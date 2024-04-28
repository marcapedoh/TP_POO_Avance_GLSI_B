package ppoo_kapedoh.marcK.entities;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ppoo_kapedoh.marcK.entities.Sms;
import ppoo_kapedoh.marcK.entities.Souscription;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-04-28T18:52:59", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile SingularAttribute<Client, Integer> idClient;
    public static volatile ListAttribute<Client, Sms> smsCollection;
    public static volatile SingularAttribute<Client, String> telephone;
    public static volatile ListAttribute<Client, Souscription> souscriptionCollection;
    public static volatile SingularAttribute<Client, String> nom;
    public static volatile SingularAttribute<Client, String> prenom;

}