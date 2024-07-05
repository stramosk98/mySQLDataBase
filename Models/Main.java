package Models;

import Connection.Connect;

public class Main {
    public static void main(String[] args) throws Exception {
    	
    	Connect connection = new Connect("localhost", 3306, "root", "", "mvcsimplesjdbc");
    	
    	Column pedidoId = new Column();
    	pedidoId.setName("id");
    	pedidoId.setType(ColumnType.INT);
    	pedidoId.setNotNull(true);
    	pedidoId.setAutoIncrement(true);
    	pedidoId.setPk(true);

    	Column pedidoNome = new Column();
    	pedidoNome.setName("nome");
    	pedidoNome.setType(ColumnType.VARCHAR, 250);

    	Column pedidoAtivo = new Column();
    	pedidoAtivo.setName("ativo");
    	pedidoAtivo.setType(ColumnType.BOOLEAN);
    	
    	Column pedidoQuantidade = new Column();
    	pedidoQuantidade.setName("valor");
    	pedidoQuantidade.setType(ColumnType.INT);
    	
    	Column produtoId = new Column();
    	produtoId.setName("id");
    	produtoId.setType(ColumnType.INT);
    	produtoId.setNotNull(true);
    	produtoId.setAutoIncrement(true);
    	produtoId.setPk(true);
    	
    	Column produtoNome = new Column();
    	produtoNome.setName("nome");
    	produtoNome.setType(ColumnType.VARCHAR, 250);
    	
    	Column produtoAtivo = new Column();
    	produtoAtivo.setName("ativo");
    	produtoAtivo.setType(ColumnType.BOOLEAN);
    	
    	Table pedido = new Table("pedido");
    	pedido.getColumnList().add(pedidoId);
    	pedido.getColumnList().add(pedidoNome);
    	pedido.getColumnList().add(pedidoAtivo);
    	pedido.getColumnList().add(pedidoQuantidade);

    	Table produto = new Table("produto");
    	produto.getColumnList().add(produtoId);
    	produto.getColumnList().add(produtoNome);
    	produto.getColumnList().add(produtoAtivo);
    	
    	Column idPedido = new Column();
    	idPedido.setName("idPedido");
    	idPedido.setType(ColumnType.INT);
    	idPedido.setFk(new ForeignKey(produto, produtoId));
    	
    	Column idProduto = new Column();
    	idProduto.setName("idProduto");
    	idProduto.setType(ColumnType.INT);
    	idProduto.setFk(new ForeignKey(pedido, pedidoId));
    	
    	Table pedidoProduto = new Table("pedido_produto");
    	pedidoProduto.getColumnList().add(idPedido);
    	pedidoProduto.getColumnList().add(idProduto);
    	
    	Database db = new Database("marketplace");
    	db.setConnection(connection);
    	
    	db.getTableList().add(pedido);
    	db.getTableList().add(produto);
    	db.getTableList().add(pedidoProduto);
    	
    	System.out.println(db.script());
    	
    	db.export("script.sql");
    	
    	db.execute("script.sql");
    	
//    	FactoryModel columnFactory = new FactoryColumn();
//    	IModel crudColumn = columnFactory.execute();
//    	crudColumn.update("marketplace", "pedido", "ativo");
//    	
//    	FactoryModel columnTable = new FactoryTable();
//    	IModel crudTable = columnTable.execute();
//    	crudTable.delete("marketplace", "pedido");
    	
    }
}
