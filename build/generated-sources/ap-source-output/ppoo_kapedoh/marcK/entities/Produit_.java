package ppoo_kapedoh.marcK.entities;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ppoo_kapedoh.marcK.entities.Souscription;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-04-28T18:52:59", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Produit.class)
public class Produit_ { 

    public static volatile ListAttribute<Produit, Souscription> souscriptionList;
    public static volatile SingularAttribute<Produit, Integer> idProduit;
    public static volatile SingularAttribute<Produit, String> libelle;
    public static volatile SingularAttribute<Produit, String> actif;

}