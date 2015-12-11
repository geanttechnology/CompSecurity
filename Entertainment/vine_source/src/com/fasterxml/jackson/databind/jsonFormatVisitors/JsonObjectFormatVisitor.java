// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.jsonFormatVisitors;

import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializerProvider;

// Referenced classes of package com.fasterxml.jackson.databind.jsonFormatVisitors:
//            JsonFormatVisitorWithSerializerProvider, JsonFormatVisitable

public interface JsonObjectFormatVisitor
    extends JsonFormatVisitorWithSerializerProvider
{
    public static class Base
        implements JsonObjectFormatVisitor
    {

        protected SerializerProvider _provider;

        public SerializerProvider getProvider()
        {
            return _provider;
        }

        public void optionalProperty(BeanProperty beanproperty)
            throws JsonMappingException
        {
        }

        public void optionalProperty(String s, JsonFormatVisitable jsonformatvisitable, JavaType javatype)
            throws JsonMappingException
        {
        }

        public void property(BeanProperty beanproperty)
            throws JsonMappingException
        {
        }

        public void property(String s, JsonFormatVisitable jsonformatvisitable, JavaType javatype)
            throws JsonMappingException
        {
        }

        public void setProvider(SerializerProvider serializerprovider)
        {
            _provider = serializerprovider;
        }

        public Base()
        {
        }

        public Base(SerializerProvider serializerprovider)
        {
            _provider = serializerprovider;
        }
    }


    public abstract void optionalProperty(BeanProperty beanproperty)
        throws JsonMappingException;

    public abstract void optionalProperty(String s, JsonFormatVisitable jsonformatvisitable, JavaType javatype)
        throws JsonMappingException;

    public abstract void property(BeanProperty beanproperty)
        throws JsonMappingException;

    public abstract void property(String s, JsonFormatVisitable jsonformatvisitable, JavaType javatype)
        throws JsonMappingException;
}
