// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.map.module;

import com.flurry.org.codehaus.jackson.map.BeanDescription;
import com.flurry.org.codehaus.jackson.map.BeanProperty;
import com.flurry.org.codehaus.jackson.map.DeserializationConfig;
import com.flurry.org.codehaus.jackson.map.DeserializerProvider;
import com.flurry.org.codehaus.jackson.map.Deserializers;
import com.flurry.org.codehaus.jackson.map.JsonDeserializer;
import com.flurry.org.codehaus.jackson.map.JsonMappingException;
import com.flurry.org.codehaus.jackson.map.KeyDeserializer;
import com.flurry.org.codehaus.jackson.map.TypeDeserializer;
import com.flurry.org.codehaus.jackson.map.type.ArrayType;
import com.flurry.org.codehaus.jackson.map.type.ClassKey;
import com.flurry.org.codehaus.jackson.map.type.CollectionLikeType;
import com.flurry.org.codehaus.jackson.map.type.CollectionType;
import com.flurry.org.codehaus.jackson.map.type.MapLikeType;
import com.flurry.org.codehaus.jackson.map.type.MapType;
import com.flurry.org.codehaus.jackson.type.JavaType;
import java.util.HashMap;

public class SimpleDeserializers
    implements Deserializers
{

    protected HashMap _classMappings;

    public SimpleDeserializers()
    {
        _classMappings = null;
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

    public JsonDeserializer findArrayDeserializer(ArrayType arraytype, DeserializationConfig deserializationconfig, DeserializerProvider deserializerprovider, BeanProperty beanproperty, TypeDeserializer typedeserializer, JsonDeserializer jsondeserializer)
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

    public JsonDeserializer findBeanDeserializer(JavaType javatype, DeserializationConfig deserializationconfig, DeserializerProvider deserializerprovider, BeanDescription beandescription, BeanProperty beanproperty)
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

    public JsonDeserializer findCollectionDeserializer(CollectionType collectiontype, DeserializationConfig deserializationconfig, DeserializerProvider deserializerprovider, BeanDescription beandescription, BeanProperty beanproperty, TypeDeserializer typedeserializer, JsonDeserializer jsondeserializer)
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

    public JsonDeserializer findCollectionLikeDeserializer(CollectionLikeType collectionliketype, DeserializationConfig deserializationconfig, DeserializerProvider deserializerprovider, BeanDescription beandescription, BeanProperty beanproperty, TypeDeserializer typedeserializer, JsonDeserializer jsondeserializer)
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

    public JsonDeserializer findEnumDeserializer(Class class1, DeserializationConfig deserializationconfig, BeanDescription beandescription, BeanProperty beanproperty)
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

    public JsonDeserializer findMapDeserializer(MapType maptype, DeserializationConfig deserializationconfig, DeserializerProvider deserializerprovider, BeanDescription beandescription, BeanProperty beanproperty, KeyDeserializer keydeserializer, TypeDeserializer typedeserializer, 
            JsonDeserializer jsondeserializer)
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

    public JsonDeserializer findMapLikeDeserializer(MapLikeType mapliketype, DeserializationConfig deserializationconfig, DeserializerProvider deserializerprovider, BeanDescription beandescription, BeanProperty beanproperty, KeyDeserializer keydeserializer, TypeDeserializer typedeserializer, 
            JsonDeserializer jsondeserializer)
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

    public JsonDeserializer findTreeNodeDeserializer(Class class1, DeserializationConfig deserializationconfig, BeanProperty beanproperty)
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
