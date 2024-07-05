package Models;

public class ForeignKey {
	
	public ForeignKey(Table table, Column column) {
		this.table = table;
		this.column = column;
	}
	
	private Table table;

	private Column column;

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	public Column getColumn() {
		return column;
	}

	public void setColumn(Column column) {
		this.column = column;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ForeignKey [table=");
		builder.append(table);
		builder.append(", column=");
		builder.append(column);
		builder.append("]");
		return builder.toString();
	}

}
