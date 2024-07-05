package Models;

public class FactoryColumn extends FactoryModel {

	@Override
	public IModel execute() {
		return new ModelColumn();
	}

}
