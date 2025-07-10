package model;

import java.time.LocalTime;

public class order1 
{
	private int order_id;
	private LocalTime order_date;
	
	public order1(int order_id, LocalTime order_date) {
		super();
		this.order_id = order_id;
		this.order_date = order_date;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public LocalTime getOrder_date() {
		return order_date;
	}

	public void setOrder_date(LocalTime order_date) {
		this.order_date = order_date;
	}

	@Override
	public String toString() {
		return "order1 [order_id=" + order_id + ", order_date=" + order_date + "]";
	}
	
	

}
