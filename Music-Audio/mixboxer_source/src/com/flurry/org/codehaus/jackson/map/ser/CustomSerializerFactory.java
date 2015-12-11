// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.map.ser;

import com.flurry.org.codehaus.jackson.map.BeanProperty;
import com.flurry.org.codehaus.jackson.map.JsonMappingException;
import com.flurry.org.codehaus.jackson.map.JsonSerializer;
import com.flurry.org.codehaus.jackson.map.SerializationConfig;
import com.flurry.org.codehaus.jackson.map.SerializerFactory;
import com.flurry.org.codehaus.jackson.map.type.ClassKey;
import com.flurry.org.codehaus.jackson.type.JavaType;
import java.lang.reflect.Modifier;
import java.util.HashMap;

// Referenced classes of package com.flurry.org.codehaus.jackson.map.ser:
//            BeanSerializerFactory

public class CustomSerializerFactory extends BeanSerializerFactory
{

    protected HashMap _directClassMappings;
    protected JsonSerializer _enumSerializerOverride;
    protected HashMap _interfaceMappings;
    protected HashMap _transitiveClassMappings;

    public CustomSerializerFactory()
    {
        this(null);
    }

    public CustomSerializerFactory(com.flurry.org.codehaus.jackson.map.SerializerFactory.Config config)
    {
        super(config);
        _directClassMappings = null;
        _transitiveClassMappings = null;
        _interfaceMappings = null;
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

    public void addGenericMapping(Class class1, JsonSerializer jsonserializer)
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
        if (_transitiveClassMappings == null)
        {
            _transitiveClassMappings = new HashMap();
        }
        _transitiveClassMappings.put(classkey, jsonserializer);
    }

    public void addSpecificMapping(Class class1, JsonSerializer jsonserializer)
    {
        ClassKey classkey = new ClassKey(class1);
        if (class1.isInterface())
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Can not add specific mapping for an interface (").append(class1.getName()).append(")").toString());
        }
        if (Modifier.isAbstract(class1.getModifiers()))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Can not add specific mapping for an abstract class (").append(class1.getName()).append(")").toString());
        }
        if (_directClassMappings == null)
        {
            _directClassMappings = new HashMap();
        }
        _directClassMappings.put(classkey, jsonserializer);
    }

    public JsonSerializer createSerializer(SerializationConfig serializationconfig, JavaType javatype, BeanProperty beanproperty)
        throws JsonMappingException
    {
        JsonSerializer jsonserializer = findCustomSerializer(javatype.getRawClass(), serializationconfig);
        if (jsonserializer != null)
        {
            return jsonserializer;
        } else
        {
            return super.createSerializer(serializationconfig, javatype, beanproperty);
        }
    }

    protected JsonSerializer findCustomSerializer(Class class1, SerializationConfig serializationconfig)
    {
        ClassKey classkey = new ClassKey(class1);
        if (_directClassMappings != null)
        {
            serializationconfig = (JsonSerializer)_directClassMappings.get(classkey);
            if (serializationconfig != null)
            {
                return serializationconfig;
            }
        }
        if (class1.isEnum() && _enumSerializerOverride != null)
        {
            return _enumSerializerOverride;
        }
        if (_transitiveClassMappings != null)
        {
            for (serializationconfig = class1; serializationconfig != null; serializationconfig = serializationconfig.getSuperclass())
            {
                classkey.reset(serializationconfig);
                JsonSerializer jsonserializer = (JsonSerializer)_transitiveClassMappings.get(classkey);
                if (jsonserializer != null)
                {
                    return jsonserializer;
                }
            }

        }
        if (_interfaceMappings != null)
        {
            classkey.reset(class1);
            serializationconfig = (JsonSerializer)_interfaceMappings.get(classkey);
            if (serializationconfig != null)
            {
                return serializationconfig;
            }
            for (; class1 != null; class1 = class1.getSuperclass())
            {
                serializationconfig = _findInterfaceMapping(class1, classkey);
                if (serializationconfig != null)
                {
                    return serializationconfig;
                }
            }

        }
        return null;
    }

    public void setEnumSerializer(JsonSerializer jsonserializer)
    {
        _enumSerializerOverride = jsonserializer;
    }

    public SerializerFactory withConfig(com.flurry.org.codehaus.jackson.map.SerializerFactory.Config config)
    {
        if (getClass() != com/flurry/org/codehaus/jackson/map/ser/CustomSerializerFactory)
        {
            throw new IllegalStateException((new StringBuilder()).append("Subtype of CustomSerializerFactory (").append(getClass().getName()).append(") has not properly overridden method 'withAdditionalSerializers': can not instantiate subtype with ").append("additional serializer definitions").toString());
        } else
        {
            return new CustomSerializerFactory(config);
        }
    }
}
