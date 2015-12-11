// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.map.deser;

import com.flurry.org.codehaus.jackson.map.JsonDeserializer;
import com.flurry.org.codehaus.jackson.map.TypeDeserializer;
import com.flurry.org.codehaus.jackson.type.JavaType;
import java.lang.reflect.Constructor;

// Referenced classes of package com.flurry.org.codehaus.jackson.map.deser:
//            ValueInstantiator

public class CollectionDeserializer extends com.flurry.org.codehaus.jackson.map.deser.std.CollectionDeserializer
{

    protected CollectionDeserializer(CollectionDeserializer collectiondeserializer)
    {
        super(collectiondeserializer);
    }

    public CollectionDeserializer(JavaType javatype, JsonDeserializer jsondeserializer, TypeDeserializer typedeserializer, ValueInstantiator valueinstantiator)
    {
        super(javatype, jsondeserializer, typedeserializer, valueinstantiator);
    }

    public CollectionDeserializer(JavaType javatype, JsonDeserializer jsondeserializer, TypeDeserializer typedeserializer, Constructor constructor)
    {
        super(javatype, jsondeserializer, typedeserializer, constructor);
    }
}
