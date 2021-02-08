package javafxapplication5.Model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Item.class)
public abstract class Item_ {

	public static volatile SingularAttribute<Item, Double> price;
	public static volatile SingularAttribute<Item, String> name;
	public static volatile SingularAttribute<Item, Bill> bill;
	public static volatile SingularAttribute<Item, Integer> id;

}

