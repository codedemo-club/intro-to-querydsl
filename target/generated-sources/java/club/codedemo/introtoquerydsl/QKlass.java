package club.codedemo.introtoquerydsl;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QKlass is a Querydsl query type for Klass
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QKlass extends EntityPathBase<Klass> {

    private static final long serialVersionUID = -1545096728L;

    public static final QKlass klass = new QKlass("klass");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QKlass(String variable) {
        super(Klass.class, forVariable(variable));
    }

    public QKlass(Path<? extends Klass> path) {
        super(path.getType(), path.getMetadata());
    }

    public QKlass(PathMetadata metadata) {
        super(Klass.class, metadata);
    }

}

