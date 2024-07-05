package Models;

import java.util.List;

import com.google.gson.JsonObject;

public class ModelColumn implements IModel {

	@Override
	public List<JsonObject> read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(String databaseName, String tableName) {
		return tableName;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(String databaseName, String tableName, String columnName) {
		// TODO Auto-generated method stub
		
	}

}
