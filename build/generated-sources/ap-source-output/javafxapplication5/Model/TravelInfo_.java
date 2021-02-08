package javafxapplication5.Model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TravelInfo.class)
public abstract class TravelInfo_ {

	public static volatile SingularAttribute<TravelInfo, Float> travelLength;
	public static volatile SingularAttribute<TravelInfo, City> startCity;
	public static volatile SingularAttribute<TravelInfo, City> stopCity;
	public static volatile SingularAttribute<TravelInfo, Driver> driver;
	public static volatile SingularAttribute<TravelInfo, Integer> daysExpected;
	public static volatile SingularAttribute<TravelInfo, Car> car;
	public static volatile SingularAttribute<TravelInfo, Integer> id;
	public static volatile SingularAttribute<TravelInfo, String> status;

}

