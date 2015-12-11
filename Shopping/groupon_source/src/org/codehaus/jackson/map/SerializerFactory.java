// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.codehaus.jackson.map;

import org.codehaus.jackson.type.JavaType;

// Referenced classes of package org.codehaus.jackson.map:
//            JsonMappingException, SerializationConfig, BeanProperty, JsonSerializer, 
//            TypeSerializer, Serializers

public abstract class SerializerFactory
{
    public static abstract class Config
    {

        public abstract boolean hasKeySerializers();

        public abstract boolean hasSerializerModifiers();

        public abstract Iterable keySerializers();

        public abstract Iterable serializerModifiers();

        public abstract Iterable serializers();

        public abstract Config withAdditionalKeySerializers(Serializers serializers1);

        public abstract Config withAdditionalSerializers(Serializers serializers1);

        public Config()
        {
        }
    }


    public SerializerFactory()
    {
    }

    public abstract JsonSerializer createKeySerializer(SerializationConfig serializationconfig, JavaType javatype, BeanProperty beanproperty)
        throws JsonMappingException;

    public abstract JsonSerializer createSerializer(SerializationConfig serializationconfig, JavaType javatype, BeanProperty beanproperty)
        throws JsonMappingException;

    public abstract TypeSerializer createTypeSerializer(SerializationConfig serializationconfig, JavaType javatype, BeanProperty beanproperty)
        throws JsonMappingException;

    public abstract Config getConfig();

    public final SerializerFactory withAdditionalKeySerializers(Serializers serializers)
    {
        return withConfig(getConfig().withAdditionalKeySerializers(serializers));
    }

    public final SerializerFactory withAdditionalSerializers(Serializers serializers)
    {
        return withConfig(getConfig().withAdditionalSerializers(serializers));
    }

    public abstract SerializerFactory withConfig(Config config);
}
