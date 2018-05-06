package Model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-06T14:02:10")
@StaticMetamodel(Transaction.class)
public class Transaction_ { 

    public static volatile SingularAttribute<Transaction, Long> date;
    public static volatile SingularAttribute<Transaction, Double> amount;
    public static volatile SingularAttribute<Transaction, String> name;
    public static volatile SingularAttribute<Transaction, String> particular;
    public static volatile SingularAttribute<Transaction, Integer> ID;

}