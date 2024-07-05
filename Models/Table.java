package Models;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private String tableName;
    List<Column> columnList = new ArrayList<>();
    
    public Table () {
    	
    }
    
    public Table (String name) {
    	this.tableName = name;
    }
    
//	public Connection getConnection() {
//		return connection;
//	}
//
//	public void setConnection(Connection connection) {
//		this.connection = connection;
//	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public List<Column> getColumnList() {
		return columnList;
	}

	public void setColumnList(List<Column> columnList) {
		this.columnList = columnList;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Table [tableName=");
		builder.append(tableName);
		builder.append(", columnList=");
		builder.append(columnList);
		builder.append("]");
		return builder.toString();
	}
	
//	private void delet() {
//    	
//        String query = "DROP TABLE " + name + "." + tableName;
//
//        try (Statement stmt = connection.getConnection().createStatement()) {
//        	this.useSchema();
//            stmt.executeUpdate(query);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
	
	

//	public JsonArray getColumns() {
//		return columns;
//	}
//
//	public void setColumns(JsonArray columns) {
//		this.columns = columns;
//	}

//	public Table(String tableName, String columnsJson) {
//        this.setConnection(Connect.getConnection());
//        this.setTableName(tableName);
//        this.setColumns(new JsonParser().parse(columnsJson).getAsJsonArray());
//    }
	
//	private Boolean existsTable(String tableName) {
//		String existTable = "SHOW TABLES LIKE '" + tableName + "'";
//		try (Statement st = getConnection().createStatement();
//			ResultSet rs = st.executeQuery(existTable)) {
//			return rs.next();
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return false;
//        }
//	} 
//
//    @Override
//    public void create() throws Exception {
//    	if (this.existsTable(tableName)) {
//    		System.out.println("Table " + Database.getName() + "." + tableName + " already exists");
////    		throw new Exception("Table " + Database.getName() + "." + tableName + " already exists");
//    	} else {
//    		String pk = "", fk = "";
//	    	StringBuilder query = new StringBuilder("CREATE TABLE IF NOT EXISTS " + this.getTableName() + " (");
//	
//	        for (int i = 0; i < this.getColumns().size(); i++) {
//	            JsonObject column = this.getColumns().get(i).getAsJsonObject();
//	            
//	            query.append(column.get("name").getAsString() + " " + column.get("type").getAsString());
//	            
//	            if (column.get("auto_increment") != null) {
//	            	query.append(" NOT NULL AUTO_INCREMENT");
//	            	pk = "PRIMARY KEY(" + column.get("name").getAsString() + ")";
//	            } else if (column.get("primary_key") != null) {
//	            	pk = "PRIMARY KEY(" + column.get("name").getAsString() + ")";
//	            } 
//	            if (column.get("foreign_key") != null && column.get("foreign_key").getAsString() != "" &&
//	            		this.existsTable(column.get("foreign_key").getAsString())) {
//	            	fk = "FOREIGN KEY (" + column.get("name").getAsString() + ")"
//	            			+ " REFERENCES " + column.get("foreign_key").getAsString();
//	            }
//	            if (i < this.getColumns().size() - 1) {
//	            	query.append(", ");
//	            }
//	        }
//	
//	        if (pk != "") {
//	        	query.append(", " + pk);
//	        }
//	        if (fk != "") {
//	        	query.append(", " + fk);
//	        }
//	        query.append(")");
//	        
//	        System.out.println(query);
//	        
//	        try (PreparedStatement stmt = this.getConnection().prepareStatement(query.toString())) {
//	            stmt.executeUpdate();
//	            stmt.close();
//	            System.out.println("Success to create table");
//	        } catch (SQLException e) {
//	        	e.printStackTrace();
//	        	System.out.println("Fail to create table");
//	        }
//    	}
//    }
//
//    @Override
//    public List<JsonObject> read() {
//        List<JsonObject> results = new ArrayList<>();
//        String query = "SHOW COLUMNS FROM " + Database.getName() + "." + tableName;
//        try (Statement stmt = getConnection().createStatement();
//             ResultSet rs = stmt.executeQuery(query)) {
//            while (rs.next()) {
//                JsonObject row = new JsonObject();
//                row.addProperty("Field", rs.getString("Field"));
//                row.addProperty("Type", rs.getString("Type"));
//                row.addProperty("Null", rs.getString("Null"));
//                row.addProperty("Key", rs.getString("Key"));
//                results.add(row);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return results;
//    }
//
//    @Override
//    public void update(JsonObject column) {
//    	String query = "ALTER TABLE " + Database.getName() + "." + tableName + " " 
//    			+ column.get("operation") + " " + column.get("name")+ " " 
//    			+ column.get("type");
//    	
//        try (PreparedStatement stmt = this.getConnection().prepareStatement(query.toString())) {
//            stmt.executeUpdate();
//            stmt.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void delete() {
//        String query = "DROP TABLE " + Database.getName() + "." + tableName;
//
//        try (Statement stmt = this.getConnection().createStatement()) {
//            stmt.executeUpdate(query);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

}