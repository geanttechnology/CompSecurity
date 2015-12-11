// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.module;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.ClassKey;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.MapType;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class SimpleSerializers extends com.fasterxml.jackson.databind.ser.Serializers.Base
    implements Serializable
{

    private static final long serialVersionUID = 0x76667f4cd0de53cbL;
    protected HashMap _classMappings;
    protected HashMap _interfaceMappings;

    public SimpleSerializers()
    {
        _classMappings = null;
        _interfaceMappings = null;
    }

    public SimpleSerializers(List list)
    {
        _classMappings = null;
        _interfaceMappings = null;
        addSerializers(list);
    }

    private void _addSerializer(Class class1, JsonSerializer jsonserializer)
    {
        ClassKey classkey = new ClassKey(class1);
        if (class1.isInterface())
        {
            if (_interfaceMappings == null)
            {
                _interfaceMappings = new HashMap();
            }
            _interfaceMappings.put(classkey, jsonserializer);
            return;
        }
        if (_classMappings == null)
        {
            _classMappings = new HashMap();
        }
        _classMappings.put(classkey, jsonserializer);
    }

    protected JsonSerializer _findInterfaceMapping(Class class1, ClassKey classkey)
    {
        Class aclass[];
        int i;
        int j;
        aclass = class1.getInterfaces();
        j = aclass.length;
        i = 0;
_L5:
        Object obj;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = aclass[i];
        classkey.reset(((Class) (obj)));
        class1 = (JsonSerializer)_interfaceMappings.get(classkey);
        if (class1 == null) goto _L2; else goto _L1
_L1:
        return class1;
_L2:
        obj = _findInterfaceMapping(((Class) (obj)), classkey);
        class1 = ((Class) (obj));
        if (obj != null) goto _L1; else goto _L3
_L3:
        i++;
        if (true) goto _L5; else goto _L4
_L4:
        return null;
    }

    public void addSerializer(JsonSerializer jsonserializer)
    {
        Class class1 = jsonserializer.handledType();
        if (class1 == null || class1 == java/lang/Object)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("JsonSerializer of type ").append(jsonserializer.getClass().getName()).append(" does not define valid handledType() -- must either register with method that takes type argument ").append(" or make serializer extend 'com.fasterxml.jackson.databind.ser.std.StdSerializer'").toString());
        } else
        {
            _addSerializer(class1, jsonserializer);
            return;
        }
    }

    public void addSerializer(Class class1, JsonSerializer jsonserializer)
    {
        _addSerializer(class1, jsonserializer);
    }

    public void addSerializers(List list)
    {
        for (list = list.iterator(); list.hasNext(); addSerializer((JsonSerializer)list.next())) { }
    }

    public JsonSerializer findArraySerializer(SerializationConfig serializationconfig, ArrayType arraytype, BeanDescription beandescription, TypeSerializer typeserializer, JsonSerializer jsonserializer)
    {
        return findSerializer(serializationconfig, arraytype, beandescription);
    }

    public JsonSerializer findCollectionLikeSerializer(SerializationConfig serializationconfig, CollectionLikeType collectionliketype, BeanDescription beandescription, TypeSerializer typeserializer, JsonSerializer jsonserializer)
    {
        return findSerializer(serializationconfig, collectionliketype, beandescription);
    }

    public JsonSerializer findCollectionSerializer(SerializationConfig serializationconfig, CollectionType collectiontype, BeanDescription beandescription, TypeSerializer typeserializer, JsonSerializer jsonserializer)
    {
        return findSerializer(serializationconfig, collectiontype, beandescription);
    }

    public JsonSerializer findMapLikeSerializer(SerializationConfig serializationconfig, MapLikeType mapliketype, BeanDescription beandescription, JsonSerializer jsonserializer, TypeSerializer typeserializer, JsonSerializer jsonserializer1)
    {
        return findSerializer(serializationconfig, mapliketype, beandescription);
    }

    public JsonSerializer findMapSerializer(SerializationConfig serializationconfig, MapType maptype, BeanDescription beandescription, JsonSerializer jsonserializer, TypeSerializer typeserializer, JsonSerializer jsonserializer1)
    {
        return findSerializer(serializationconfig, maptype, beandescription);
    }

    public JsonSerializer findSerializer(SerializationConfig serializationconfig, JavaType javatype, BeanDescription beandescription)
    {
label0:
        {
            serializationconfig = javatype.getRawClass();
            beandescription = new ClassKey(serializationconfig);
            if (serializationconfig.isInterface())
            {
                if (_interfaceMappings != null)
                {
                    javatype = (JsonSerializer)_interfaceMappings.get(beandescription);
                    if (javatype != null)
                    {
                        return javatype;
                    }
                }
            } else
            if (_classMappings != null)
            {
                javatype = (JsonSerializer)_classMappings.get(beandescription);
                if (javatype != null)
                {
                    return javatype;
                }
                for (javatype = serializationconfig; javatype != null; javatype = javatype.getSuperclass())
                {
                    beandescription.reset(javatype);
                    JsonSerializer jsonserializer = (JsonSerializer)_classMappings.get(beandescription);
                    if (jsonserializer != null)
                    {
                        return jsonserializer;
                    }
                }

            }
            if (_interfaceMappings == null)
            {
                break label0;
            }
            javatype = _findInterfaceMapping(serializationconfig, beandescription);
            if (javatype != null)
            {
                return javatype;
            }
            if (serializationconfig.isInterface())
            {
                break label0;
            }
            do
            {
                serializationconfig = serializationconfig.getSuperclass();
                if (serializationconfig == null)
                {
                    break label0;
                }
                javatype = _findInterfaceMapping(serializationconfig, beandescription);
            } while (javatype == null);
            return javatype;
        }
        return null;
    }
}
