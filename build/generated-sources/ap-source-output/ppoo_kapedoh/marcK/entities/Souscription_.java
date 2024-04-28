package ppoo_kapedoh.marcK.entities;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ppoo_kapedoh.marcK.entities.Produit;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-04-28T18:52:59", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Souscription.class)
public class Souscription_ { 

    public static volatile SingularAttribute<Souscription, Integer> idSous;
    public static volatile SingularAttribute<Souscription, Date> dateHeureSous;
    public static volatile SingularAttribute<Souscription, Produit> idProduit;
    public static volatile SingularAttribute<Souscription, String> actif;

}