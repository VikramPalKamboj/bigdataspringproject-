package example.springdata.rest.stores;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QStore_Address is a Querydsl query type for Address
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QStore_Address extends BeanPath<Store.Address> {

    private static final long serialVersionUID = -1819181486L;

    public static final QStore_Address address = new QStore_Address("address");

    public final StringPath city = createString("city");

    public final SimplePath<org.springframework.data.geo.Point> location = createSimple("location", org.springframework.data.geo.Point.class);

    public final StringPath street = createString("street");

    public final StringPath zip = createString("zip");

    public QStore_Address(String variable) {
        super(Store.Address.class, forVariable(variable));
    }

    public QStore_Address(Path<? extends Store.Address> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStore_Address(PathMetadata metadata) {
        super(Store.Address.class, metadata);
    }

}

