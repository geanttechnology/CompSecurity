// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.codehaus.jackson.map.module;

import java.util.HashMap;
import org.codehaus.jackson.map.BeanDescription;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.TypeSerializer;
import org.codehaus.jackson.map.type.ClassKey;
import org.codehaus.jackson.map.type.CollectionLikeType;
import org.codehaus.jackson.map.type.CollectionType;
import org.codehaus.jackson.map.type.MapLikeType;
import org.codehaus.jackson.map.type.MapType;
import org.codehaus.jackson.type.JavaType;

public class SimpleSerializers extends org.codehaus.jackson.map.Serializers.Base
{

    protected HashMap _classMappings;
    protected HashMap _interfaceMappings;

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

    public JsonSerializer findCollectionLikeSerializer(SerializationConfig serializationconfig, CollectionLikeType collectionliketype, BeanDescription beandescription, BeanProperty beanproperty, TypeSerializer typeserializer, JsonSerializer jsonserializer)
    {
        return findSerializer(serializationconfig, collectionliketype, beandescription, beanproperty);
    }

    public JsonSerializer findCollectionSerializer(SerializationConfig serializationconfig, CollectionType collectiontype, BeanDescription beandescription, BeanProperty beanproperty, TypeSerializer typeserializer, JsonSerializer jsonserializer)
    {
        return findSerializer(serializationconfig, collectiontype, beandescription, beanproperty);
    }

    public JsonSerializer findMapLikeSerializer(SerializationConfig serializationconfig, MapLikeType mapliketype, BeanDescription beandescription, BeanProperty beanproperty, JsonSerializer jsonserializer, TypeSerializer typeserializer, JsonSerializer jsonserializer1)
    {
        return findSerializer(serializationconfig, mapliketype, beandescription, beanproperty);
    }

    public JsonSerializer findMapSerializer(SerializationConfig serializationconfig, MapType maptype, BeanDescription beandescription, BeanProperty beanproperty, JsonSerializer jsonserializer, TypeSerializer typeserializer, JsonSerializer jsonserializer1)
    {
        return findSerializer(serializationconfig, maptype, beandescription, beanproperty);
    }

    public JsonSerializer findSerializer(SerializationConfig serializationconfig, JavaType javatype, BeanDescription beandescription, BeanProperty beanproperty)
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
                    beanproperty = (JsonSerializer)_classMappings.get(beandescription);
                    if (beanproperty != null)
                    {
                        return beanproperty;
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
