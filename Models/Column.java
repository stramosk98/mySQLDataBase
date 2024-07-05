package Models;

public class Column {
    
    public Column() {
    }
    
    private ColumnType type;
    
    private String name;
    
    private int length = 0;
    
    private Boolean pk = false;

    private Boolean autoIncrement = false;
    
    private Boolean notNull = false;
    
    private ForeignKey fk;
    
	public String getType() {
		if (this.length > 0 ) {
			return type + "(" + this.length + ")";
		}
		return type.toString();
	}

	public void setType(ColumnType type) {
		this.type = type;
	}

	public void setType(ColumnType type, int length) {
		this.type = type;
		this.length = length;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Boolean getPk() {
		return pk;
	}

	public void setPk(Boolean pk) {
		this.pk = pk;
	}

	public Boolean getAutoIncrement() {
		return autoIncrement;
	}

	public void setAutoIncrement(Boolean autoIncrement) {
		this.autoIncrement = autoIncrement;
	}
	
	public Boolean getNotNull() {
		return notNull;
	}

	public void setNotNull(Boolean notNull) {
		this.notNull = notNull;
	}

	public ForeignKey getFk() {
		return fk;
	}

	public void setFk(ForeignKey fk) {
		this.fk = fk;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Column [type=");
		builder.append(type);
		builder.append(", name=");
		builder.append(name);
		builder.append(", length=");
		builder.append(length);
		builder.append(", pk=");
		builder.append(pk);
		builder.append(", autoIncrement=");
		builder.append(autoIncrement);
		builder.append(", notNull=");
		builder.append(notNull);
		builder.append(", fk=");
		builder.append(fk);
		builder.append("]");
		return builder.toString();
	}

//	BuildJson json = new BuildJson();
//	public void integer(String name, Boolean autoIncrement, Boolean primaryKey, String foreignKey) {
//    	JsonObject column = new JsonObject();
//    	column.addProperty("name", name);
//        column.addProperty("type", "INT");
//
//        if (autoIncrement) {
//        	column.addProperty("auto_increment", autoIncrement);
//            column.addProperty("primary_key", true);
//        } else if (primaryKey) {
//        	column.addProperty("primary_key", true);
//        }
//        
//        if(!primaryKey && foreignKey != "") {
//        	column.addProperty("foreign_key", foreignKey);
//        }
//        
//        json.saveJson(column);
//        
//    }
//    
//    public void string(String name, int length, Boolean primaryKey, String foreignKey) {
//    	JsonObject column = new JsonObject();
//        column.addProperty("name", name);
//        column.addProperty("type", "VARCHAR(" + length + ")");
//
//        if(primaryKey) {
//        	column.addProperty("primary_key", primaryKey);
//        }
//        
//        if(!primaryKey && foreignKey != "") {
//        	column.addProperty("foreign_key", foreignKey);
//        }
//        
//        json.saveJson(column);
//    }
//    
//    public void bool(String name) {
//    	JsonObject column = new JsonObject();
//    	column.addProperty("name", name);
//        column.addProperty("type", "BOOLEAN");
//        
//        json.saveJson(column);
//    }
//    
//    public String readJson() {
//    	return json.readJson();
//    }

    
}
