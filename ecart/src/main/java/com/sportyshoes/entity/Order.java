package com.sportyshoes.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;





@ToString
@NoArgsConstructor

@AllArgsConstructor
@Setter
@Getter
@Entity

@Table(name = "myorder")
public class Order {
	
	
			@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		private String orderdescription;
		
		@OneToOne(cascade =CascadeType.MERGE)
		@JoinColumn(name="customer_id",referencedColumnName = "id")
		private Customer customer;
		
		
		@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, targetEntity = Shoppingcart.class)
		
		@JoinColumn(name="order_id",referencedColumnName ="id" )
		
		private List<Shoppingcart> cartItems;
		
		private LocalDate dateoforder;
		

}
