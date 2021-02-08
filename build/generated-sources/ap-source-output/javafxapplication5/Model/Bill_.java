package javafxapplication5.Model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Bill.class)
public abstract class Bill_ {

	public static volatile SingularAttribute<Bill, Date> date;
	public static volatile SingularAttribute<Bill, Double> price;
	public static volatile SingularAttribute<Bill, Integer> id;
	public static volatile CollectionAttribute<Bill, TravelInfo> items;

}

