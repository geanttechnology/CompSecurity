// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.module;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.deser.Deserializers;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.ClassKey;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.MapType;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class SimpleDeserializers
    implements Deserializers, Serializable
{

    private static final long serialVersionUID = 0xd6462683a6216850L;
    protected HashMap _classMappings;

    public SimpleDeserializers()
    {
        _classMappings = null;
    }

    public SimpleDeserializers(Map map)
    {
        _classMappings = null;
        addDeserializers(map);
    }

    public void addDeserializer(Class class1, JsonDeserializer jsondeserializer)
    {
        class1 = new ClassKey(class1);
        if (_classMappings == null)
        {
            _classMappings = new HashMap();
        }
        _classMappings.put(class1, jsondeserializer);
    }

    public void addDeserializers(Map map)
    {
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); addDeserializer((Class)entry.getKey(), (JsonDeserializer)entry.getValue()))
        {
            entry = (java.util.Map.Entry)map.next();
        }

    }

    public JsonDeserializer findArrayDeserializer(ArrayType arraytype, DeserializationConfig deserializationconfig, BeanDescription beandescription, TypeDeserializer typedeserializer, JsonDeserializer jsondeserializer)
        throws JsonMappingException
    {
        if (_classMappings == null)
        {
            return null;
        } else
        {
            return (JsonDeserializer)_classMappings.get(new ClassKey(arraytype.getRawClass()));
        }
    }

    public JsonDeserializer findBeanDeserializer(JavaType javatype, DeserializationConfig deserializationconfig, BeanDescription beandescription)
        throws JsonMappingException
    {
        if (_classMappings == null)
        {
            return null;
        } else
        {
            return (JsonDeserializer)_classMappings.get(new ClassKey(javatype.getRawClass()));
        }
    }

    public JsonDeserializer findCollectionDeserializer(CollectionType collectiontype, DeserializationConfig deserializationconfig, BeanDescription beandescription, TypeDeserializer typedeserializer, JsonDeserializer jsondeserializer)
        throws JsonMappingException
    {
        if (_classMappings == null)
        {
            return null;
        } else
        {
            return (JsonDeserializer)_classMappings.get(new ClassKey(collectiontype.getRawClass()));
        }
    }

    public JsonDeserializer findCollectionLikeDeserializer(CollectionLikeType collectionliketype, DeserializationConfig deserializationconfig, BeanDescription beandescription, TypeDeserializer typedeserializer, JsonDeserializer jsondeserializer)
        throws JsonMappingException
    {
        if (_classMappings == null)
        {
            return null;
        } else
        {
            return (JsonDeserializer)_classMappings.get(new ClassKey(collectionliketype.getRawClass()));
        }
    }

    public JsonDeserializer findEnumDeserializer(Class class1, DeserializationConfig deserializationconfig, BeanDescription beandescription)
        throws JsonMappingException
    {
        if (_classMappings == null)
        {
            return null;
        } else
        {
            return (JsonDeserializer)_classMappings.get(new ClassKey(class1));
        }
    }

    public JsonDeserializer findMapDeserializer(MapType maptype, DeserializationConfig deserializationconfig, BeanDescription beandescription, KeyDeserializer keydeserializer, TypeDeserializer typedeserializer, JsonDeserializer jsondeserializer)
        throws JsonMappingException
    {
        if (_classMappings == null)
        {
            return null;
        } else
        {
            return (JsonDeserializer)_classMappings.get(new ClassKey(maptype.getRawClass()));
        }
    }

    public JsonDeserializer findMapLikeDeserializer(MapLikeType mapliketype, DeserializationConfig deserializationconfig, BeanDescription beandescription, KeyDeserializer keydeserializer, TypeDeserializer typedeserializer, JsonDeserializer jsondeserializer)
        throws JsonMappingException
    {
        if (_classMappings == null)
        {
            return null;
        } else
        {
            return (JsonDeserializer)_classMappings.get(new ClassKey(mapliketype.getRawClass()));
        }
    }

    public JsonDeserializer findTreeNodeDeserializer(Class class1, DeserializationConfig deserializationconfig, BeanDescription beandescription)
        throws JsonMappingException
    {
        if (_classMappings == null)
        {
            return null;
        } else
        {
            return (JsonDeserializer)_classMappings.get(new ClassKey(class1));
        }
    }
}
