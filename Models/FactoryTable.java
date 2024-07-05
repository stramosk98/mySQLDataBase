package Models;

public class FactoryTable extends FactoryModel {

	@Override
	public IModel execute() {
		return new ModelTable();
	}

}
