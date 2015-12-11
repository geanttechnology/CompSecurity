// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.map.deser;

import com.flurry.org.codehaus.jackson.map.JsonDeserializer;
import com.flurry.org.codehaus.jackson.map.KeyDeserializer;
import com.flurry.org.codehaus.jackson.map.TypeDeserializer;
import com.flurry.org.codehaus.jackson.type.JavaType;
import java.lang.reflect.Constructor;

// Referenced classes of package com.flurry.org.codehaus.jackson.map.deser:
//            ValueInstantiator

public class MapDeserializer extends com.flurry.org.codehaus.jackson.map.deser.std.MapDeserializer
{

    protected MapDeserializer(MapDeserializer mapdeserializer)
    {
        super(mapdeserializer);
    }

    public MapDeserializer(JavaType javatype, ValueInstantiator valueinstantiator, KeyDeserializer keydeserializer, JsonDeserializer jsondeserializer, TypeDeserializer typedeserializer)
    {
        super(javatype, valueinstantiator, keydeserializer, jsondeserializer, typedeserializer);
    }

    public MapDeserializer(JavaType javatype, Constructor constructor, KeyDeserializer keydeserializer, JsonDeserializer jsondeserializer, TypeDeserializer typedeserializer)
    {
        super(javatype, constructor, keydeserializer, jsondeserializer, typedeserializer);
    }
}
