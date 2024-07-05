package Models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Connection.Connect;

public class Database {
	
	private String name;
	List<Table> tableList = new ArrayList<>();
	private Connect connection;
	
	public Database() {
		
	}

	public Database(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Table> getTableList() {
		return tableList;
	}

	public void setTableList(List<Table> tableList) {
		this.tableList = tableList;
	}

	public Connect getConnection() {
		return connection;
	}

	public void setConnection(Connect connection) {
		this.connection = connection;
	}
	
	public String script() {
	    StringBuilder query = new StringBuilder();
	    query.append("CREATE SCHEMA IF NOT EXISTS ").append(name).append(" DEFAULT CHARACTER SET utf8;");
	    query.append("\nUSE ").append(name).append(";\n");

	    for (int i = 0; i < tableList.size(); i++) {
	        Table table = tableList.get(i);
	        String pk = "";
	        StringBuilder fk = new StringBuilder();
	        int count = 0;
	        query.append("CREATE TABLE IF NOT EXISTS ").append(name).append(".").append(table.getTableName()).append(" (\n");

	        for (int j = 0; j < table.getColumnList().size(); j++) {
	            Column column = table.getColumnList().get(j);
	            query.append("\t").append(column.getName()).append(" ").append(column.getType());

	            if (column.getNotNull()) {
	                query.append(" NOT NULL");
	            }

	            if (column.getAutoIncrement()) {
	                query.append(" AUTO_INCREMENT");
	            }

	            if (column.getPk()) {
	                pk = "\tPRIMARY KEY (" + column.getName() + ")";
	            }

	            if (column.getFk() != null) {
	                if (count > 0) {
	                    fk.append("\n");
	                }
	                fk.append("\tFOREIGN KEY (").append(column.getName()).append(") REFERENCES ")
	                      .append(name).append(".").append(column.getFk().getTable().getTableName())
	                      .append("(").append(column.getFk().getColumn().getName()).append(")");
	                if (count < table.getColumnList().size() - 1 && column.getFk() != null) {
	                    fk.append(","); 
	                }
	                count++;
	            }

	            if (j < table.getColumnList().size() - 1 || pk != "" || fk.toString() != "") {
	                query.append(",\n");
	            } else {
	                query.append("\n");
	            }
	        }

	        query.append(pk);
	        query.append(fk);
	        query.append("\n) ENGINE = InnoDB;\n");
	    }

	    return query.toString();
	}

	 public boolean export(String nomeArquivo) {
	        try (FileWriter fileWriter = new FileWriter(nomeArquivo); PrintWriter printWriter = new PrintWriter(fileWriter)) {
	            printWriter.println(script());
	            System.out.println("Success to export file");
	            return true;
	        } catch (IOException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	
   public void execute(String path) throws IOException {
		
		if(connection != null) {
			try {
	            Statement statement = connection.getConnection().createStatement();

	            BufferedReader reader = new BufferedReader(new FileReader(path));
	            String create = reader.readLine();
	            StringBuilder sqlScript = new StringBuilder();
	            String line;
	            while ((line = reader.readLine()) != null) {
	                sqlScript.append(line);
	                sqlScript.append(System.lineSeparator());
	            }
	            reader.close();

	            statement.executeUpdate(create.substring(0, create.length() - 1));

	            String[] sqlCommands = sqlScript.toString().split(";");
	            for (String sqlCommand : sqlCommands) {
	                if (!sqlCommand.trim().isEmpty()) {
	                    statement.execute(sqlCommand.trim());
	                }
	            }
				System.out.println("Success to execute script");
			}catch (SQLException excep) {
				System.out.println(excep);
			}
		}else {
			System.out.println("Fail to connect on database");
			
		}
	}

	
}
