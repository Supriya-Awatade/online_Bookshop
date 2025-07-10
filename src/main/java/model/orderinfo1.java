package model;

public class orderinfo1 
{
	private int order_item_id;
	private int quanitity;
	
	public int getOrder_item_id() {
		return order_item_id;
	}

	public void setOrder_item_id(int order_item_id) {
		this.order_item_id = order_item_id;
	}

	public int getQuanitity() {
		return quanitity;
	}

	public void setQuanitity(int quanitity) {
		this.quanitity = quanitity;
	}

	
	
	public orderinfo1(int order_item_id, int quanitity) {
		super();
		this.order_item_id = order_item_id;
		this.quanitity = quanitity;
	}
	
	@Override
	public String toString() {
		return "orderinfo1 [order_item_id=" + order_item_id + ", quanitity=" + quanitity + "]";
	}
}
