// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.map.ser.impl;

import com.flurry.org.codehaus.jackson.JsonGenerator;
import com.flurry.org.codehaus.jackson.map.JsonMappingException;
import com.flurry.org.codehaus.jackson.map.JsonSerializer;
import com.flurry.org.codehaus.jackson.map.SerializerProvider;
import com.flurry.org.codehaus.jackson.map.ser.BeanPropertyWriter;

// Referenced classes of package com.flurry.org.codehaus.jackson.map.ser.impl:
//            PropertySerializerMap

public class UnwrappingBeanPropertyWriter extends BeanPropertyWriter
{

    public UnwrappingBeanPropertyWriter(BeanPropertyWriter beanpropertywriter)
    {
        super(beanpropertywriter);
    }

    public UnwrappingBeanPropertyWriter(BeanPropertyWriter beanpropertywriter, JsonSerializer jsonserializer)
    {
        super(beanpropertywriter, jsonserializer);
    }

    protected JsonSerializer _findAndAddDynamic(PropertySerializerMap propertyserializermap, Class class1, SerializerProvider serializerprovider)
        throws JsonMappingException
    {
        if (_nonTrivialBaseType != null)
        {
            propertyserializermap = serializerprovider.findValueSerializer(serializerprovider.constructSpecializedType(_nonTrivialBaseType, class1), this);
        } else
        {
            propertyserializermap = serializerprovider.findValueSerializer(class1, this);
        }
        serializerprovider = propertyserializermap;
        if (!propertyserializermap.isUnwrappingSerializer())
        {
            serializerprovider = propertyserializermap.unwrappingSerializer();
        }
        _dynamicSerializers = _dynamicSerializers.newWith(class1, serializerprovider);
        return serializerprovider;
    }

    public void serializeAsField(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws Exception
    {
        Object obj1 = get(obj);
        if (obj1 != null)
        {
            if (obj1 == obj)
            {
                _reportSelfReference(obj);
            }
            if (_suppressableValue == null || !_suppressableValue.equals(obj1))
            {
                JsonSerializer jsonserializer = _serializer;
                obj = jsonserializer;
                if (jsonserializer == null)
                {
                    Class class1 = obj1.getClass();
                    PropertySerializerMap propertyserializermap = _dynamicSerializers;
                    JsonSerializer jsonserializer1 = propertyserializermap.serializerFor(class1);
                    obj = jsonserializer1;
                    if (jsonserializer1 == null)
                    {
                        obj = _findAndAddDynamic(propertyserializermap, class1, serializerprovider);
                    }
                }
                if (!((JsonSerializer) (obj)).isUnwrappingSerializer())
                {
                    jsongenerator.writeFieldName(_name);
                }
                if (_typeSerializer == null)
                {
                    ((JsonSerializer) (obj)).serialize(obj1, jsongenerator, serializerprovider);
                    return;
                } else
                {
                    ((JsonSerializer) (obj)).serializeWithType(obj1, jsongenerator, serializerprovider, _typeSerializer);
                    return;
                }
            }
        }
    }

    public BeanPropertyWriter withSerializer(JsonSerializer jsonserializer)
    {
        if (getClass() != com/flurry/org/codehaus/jackson/map/ser/impl/UnwrappingBeanPropertyWriter)
        {
            throw new IllegalStateException("UnwrappingBeanPropertyWriter sub-class does not override 'withSerializer()'; needs to!");
        }
        JsonSerializer jsonserializer1 = jsonserializer;
        if (!jsonserializer.isUnwrappingSerializer())
        {
            jsonserializer1 = jsonserializer.unwrappingSerializer();
        }
        return new UnwrappingBeanPropertyWriter(this, jsonserializer1);
    }
}
