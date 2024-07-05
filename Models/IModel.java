package Models;

import java.util.List;

import com.google.gson.JsonObject;

public interface IModel {
    List<JsonObject> read();
	String delete(String databaseName, String tableName);
	void update(String databaseName, String tableName, String columnName);
}