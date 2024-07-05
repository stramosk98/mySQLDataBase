package Models;

import java.util.List;

import com.google.gson.JsonObject;

public class ModelTable implements IModel {

	@Override
	public List<JsonObject> read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(String databaseName, String tableName) {
	    return "DROP TABLE " + databaseName + "." + tableName + ";";
	}

	@Override
	public void update(String databaseName, String tableName, String columnName) {
		// TODO Auto-generated method stub
	}

}
