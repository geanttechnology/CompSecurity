// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.codehaus.jackson.map;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ser.FilterProvider;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.type.JavaType;

// Referenced classes of package org.codehaus.jackson.map:
//            SerializationConfig, JsonSerializer, JsonMappingException, BeanProperty, 
//            SerializerFactory

public abstract class SerializerProvider
{

    protected static final JavaType TYPE_OBJECT = TypeFactory.defaultInstance().uncheckedSimpleType(java/lang/Object);
    protected final SerializationConfig _config;
    protected final Class _serializationView;

    protected SerializerProvider(SerializationConfig serializationconfig)
    {
        _config = serializationconfig;
        if (serializationconfig == null)
        {
            serializationconfig = null;
        } else
        {
            serializationconfig = _config.getSerializationView();
        }
        _serializationView = serializationconfig;
    }

    public JavaType constructSpecializedType(JavaType javatype, Class class1)
    {
        return _config.constructSpecializedType(javatype, class1);
    }

    public JavaType constructType(Type type)
    {
        return _config.getTypeFactory().constructType(type);
    }

    public abstract void defaultSerializeDateKey(long l, JsonGenerator jsongenerator)
        throws IOException, JsonProcessingException;

    public abstract void defaultSerializeDateKey(Date date, JsonGenerator jsongenerator)
        throws IOException, JsonProcessingException;

    public abstract void defaultSerializeDateValue(long l, JsonGenerator jsongenerator)
        throws IOException, JsonProcessingException;

    public abstract void defaultSerializeDateValue(Date date, JsonGenerator jsongenerator)
        throws IOException, JsonProcessingException;

    public final void defaultSerializeNull(JsonGenerator jsongenerator)
        throws IOException, JsonProcessingException
    {
        getNullValueSerializer().serialize(null, jsongenerator, this);
    }

    public final void defaultSerializeValue(Object obj, JsonGenerator jsongenerator)
        throws IOException, JsonProcessingException
    {
        if (obj == null)
        {
            getNullValueSerializer().serialize(null, jsongenerator, this);
            return;
        } else
        {
            findTypedValueSerializer(obj.getClass(), true, null).serialize(obj, jsongenerator, this);
            return;
        }
    }

    public abstract JsonSerializer findKeySerializer(JavaType javatype, BeanProperty beanproperty)
        throws JsonMappingException;

    public abstract JsonSerializer findTypedValueSerializer(Class class1, boolean flag, BeanProperty beanproperty)
        throws JsonMappingException;

    public abstract JsonSerializer findTypedValueSerializer(JavaType javatype, boolean flag, BeanProperty beanproperty)
        throws JsonMappingException;

    public abstract JsonSerializer findValueSerializer(Class class1, BeanProperty beanproperty)
        throws JsonMappingException;

    public abstract JsonSerializer findValueSerializer(JavaType javatype, BeanProperty beanproperty)
        throws JsonMappingException;

    public final FilterProvider getFilterProvider()
    {
        return _config.getFilterProvider();
    }

    public abstract JsonSerializer getNullKeySerializer();

    public abstract JsonSerializer getNullValueSerializer();

    public final Class getSerializationView()
    {
        return _serializationView;
    }

    public final boolean isEnabled(SerializationConfig.Feature feature)
    {
        return _config.isEnabled(feature);
    }

    public abstract void serializeValue(SerializationConfig serializationconfig, JsonGenerator jsongenerator, Object obj, SerializerFactory serializerfactory)
        throws IOException, JsonGenerationException;

}
