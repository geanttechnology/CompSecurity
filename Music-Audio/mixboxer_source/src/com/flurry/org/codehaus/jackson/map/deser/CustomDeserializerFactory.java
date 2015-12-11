// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.map.deser;

import com.flurry.org.codehaus.jackson.map.BeanProperty;
import com.flurry.org.codehaus.jackson.map.DeserializationConfig;
import com.flurry.org.codehaus.jackson.map.DeserializerFactory;
import com.flurry.org.codehaus.jackson.map.DeserializerProvider;
import com.flurry.org.codehaus.jackson.map.JsonDeserializer;
import com.flurry.org.codehaus.jackson.map.JsonMappingException;
import com.flurry.org.codehaus.jackson.map.type.ArrayType;
import com.flurry.org.codehaus.jackson.map.type.ClassKey;
import com.flurry.org.codehaus.jackson.type.JavaType;
import java.util.HashMap;

// Referenced classes of package com.flurry.org.codehaus.jackson.map.deser:
//            BeanDeserializerFactory

public class CustomDeserializerFactory extends BeanDeserializerFactory
{

    protected HashMap _directClassMappings;
    protected HashMap _mixInAnnotations;

    public CustomDeserializerFactory()
    {
        this(null);
    }

    protected CustomDeserializerFactory(com.flurry.org.codehaus.jackson.map.DeserializerFactory.Config config)
    {
        super(config);
        _directClassMappings = null;
    }

    public void addMixInAnnotationMapping(Class class1, Class class2)
    {
        if (_mixInAnnotations == null)
        {
            _mixInAnnotations = new HashMap();
        }
        _mixInAnnotations.put(new ClassKey(class1), class2);
    }

    public void addSpecificMapping(Class class1, JsonDeserializer jsondeserializer)
    {
        class1 = new ClassKey(class1);
        if (_directClassMappings == null)
        {
            _directClassMappings = new HashMap();
        }
        _directClassMappings.put(class1, jsondeserializer);
    }

    public JsonDeserializer createArrayDeserializer(DeserializationConfig deserializationconfig, DeserializerProvider deserializerprovider, ArrayType arraytype, BeanProperty beanproperty)
        throws JsonMappingException
    {
        Object obj = new ClassKey(arraytype.getRawClass());
        if (_directClassMappings != null)
        {
            obj = (JsonDeserializer)_directClassMappings.get(obj);
            if (obj != null)
            {
                return ((JsonDeserializer) (obj));
            }
        }
        return super.createArrayDeserializer(deserializationconfig, deserializerprovider, arraytype, beanproperty);
    }

    public JsonDeserializer createBeanDeserializer(DeserializationConfig deserializationconfig, DeserializerProvider deserializerprovider, JavaType javatype, BeanProperty beanproperty)
        throws JsonMappingException
    {
        Object obj = new ClassKey(javatype.getRawClass());
        if (_directClassMappings != null)
        {
            obj = (JsonDeserializer)_directClassMappings.get(obj);
            if (obj != null)
            {
                return ((JsonDeserializer) (obj));
            }
        }
        return super.createBeanDeserializer(deserializationconfig, deserializerprovider, javatype, beanproperty);
    }

    public JsonDeserializer createEnumDeserializer(DeserializationConfig deserializationconfig, DeserializerProvider deserializerprovider, JavaType javatype, BeanProperty beanproperty)
        throws JsonMappingException
    {
        if (_directClassMappings != null)
        {
            Object obj = new ClassKey(javatype.getRawClass());
            obj = (JsonDeserializer)_directClassMappings.get(obj);
            if (obj != null)
            {
                return ((JsonDeserializer) (obj));
            }
        }
        return super.createEnumDeserializer(deserializationconfig, deserializerprovider, javatype, beanproperty);
    }

    public DeserializerFactory withConfig(com.flurry.org.codehaus.jackson.map.DeserializerFactory.Config config)
    {
        if (getClass() != com/flurry/org/codehaus/jackson/map/deser/CustomDeserializerFactory)
        {
            throw new IllegalStateException((new StringBuilder()).append("Subtype of CustomDeserializerFactory (").append(getClass().getName()).append(") has not properly overridden method 'withAdditionalDeserializers': can not instantiate subtype with ").append("additional deserializer definitions").toString());
        } else
        {
            return new CustomDeserializerFactory(config);
        }
    }
}
