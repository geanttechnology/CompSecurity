// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.codehaus.jackson.map;

import org.codehaus.jackson.map.deser.ValueInstantiators;

// Referenced classes of package org.codehaus.jackson.map:
//            Module, AbstractTypeResolver, Deserializers, KeyDeserializers, 
//            Serializers

public static interface tors
{

    public abstract void addAbstractTypeResolver(AbstractTypeResolver abstracttyperesolver);

    public abstract void addDeserializers(Deserializers deserializers);

    public abstract void addKeyDeserializers(KeyDeserializers keydeserializers);

    public abstract void addKeySerializers(Serializers serializers);

    public abstract void addSerializers(Serializers serializers);

    public abstract void addValueInstantiators(ValueInstantiators valueinstantiators);

    public abstract void setMixInAnnotations(Class class1, Class class2);
}
