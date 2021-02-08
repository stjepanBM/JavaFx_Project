package javafxapplication5.Model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Car.class)
public abstract class Car_ {

	public static volatile SingularAttribute<Car, String> carType;
	public static volatile SingularAttribute<Car, Integer> yearOfMaking;
	public static volatile SingularAttribute<Car, Boolean> carReserved;
	public static volatile SingularAttribute<Car, Integer> id;
	public static volatile SingularAttribute<Car, String> brand;
	public static volatile SingularAttribute<Car, Integer> mileage;

}

