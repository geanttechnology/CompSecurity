// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.map.ser.impl;

import com.flurry.org.codehaus.jackson.map.JsonSerializer;
import com.flurry.org.codehaus.jackson.type.JavaType;
import java.util.HashMap;

// Referenced classes of package com.flurry.org.codehaus.jackson.map.ser.impl:
//            JsonSerializerMap

public final class ReadOnlyClassToSerializerMap
{

    protected final SerializerCache.TypeKey _cacheKey = new SerializerCache.TypeKey(getClass(), false);
    protected final JsonSerializerMap _map;

    private ReadOnlyClassToSerializerMap(JsonSerializerMap jsonserializermap)
    {
        _map = jsonserializermap;
    }

    public static ReadOnlyClassToSerializerMap from(HashMap hashmap)
    {
        return new ReadOnlyClassToSerializerMap(new JsonSerializerMap(hashmap));
    }

    public ReadOnlyClassToSerializerMap instance()
    {
        return new ReadOnlyClassToSerializerMap(_map);
    }

    public JsonSerializer typedValueSerializer(JavaType javatype)
    {
        _cacheKey.resetTyped(javatype);
        return _map.find(_cacheKey);
    }

    public JsonSerializer typedValueSerializer(Class class1)
    {
        _cacheKey.resetTyped(class1);
        return _map.find(_cacheKey);
    }

    public JsonSerializer untypedValueSerializer(JavaType javatype)
    {
        _cacheKey.resetUntyped(javatype);
        return _map.find(_cacheKey);
    }

    public JsonSerializer untypedValueSerializer(Class class1)
    {
        _cacheKey.resetUntyped(class1);
        return _map.find(_cacheKey);
    }
}
