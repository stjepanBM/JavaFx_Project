package javafxapplication5.Model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Driver.class)
public abstract class Driver_ {

	public static volatile SingularAttribute<Driver, String> ime;
	public static volatile SingularAttribute<Driver, String> prezime;
	public static volatile SingularAttribute<Driver, Integer> licenceNumber;
	public static volatile SingularAttribute<Driver, String> telephone;
	public static volatile SingularAttribute<Driver, Integer> id;
	public static volatile CollectionAttribute<Driver, TravelInfo> putniNalozi;

}

