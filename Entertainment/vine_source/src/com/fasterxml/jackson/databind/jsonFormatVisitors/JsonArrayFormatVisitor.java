// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.jsonFormatVisitors;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializerProvider;

// Referenced classes of package com.fasterxml.jackson.databind.jsonFormatVisitors:
//            JsonFormatVisitorWithSerializerProvider, JsonFormatTypes, JsonFormatVisitable

public interface JsonArrayFormatVisitor
    extends JsonFormatVisitorWithSerializerProvider
{
    public static class Base
        implements JsonArrayFormatVisitor
    {

        protected SerializerProvider _provider;

        public SerializerProvider getProvider()
        {
            return _provider;
        }

        public void itemsFormat(JsonFormatTypes jsonformattypes)
            throws JsonMappingException
        {
        }

        public void itemsFormat(JsonFormatVisitable jsonformatvisitable, JavaType javatype)
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


    public abstract void itemsFormat(JsonFormatTypes jsonformattypes)
        throws JsonMappingException;

    public abstract void itemsFormat(JsonFormatVisitable jsonformatvisitable, JavaType javatype)
        throws JsonMappingException;
}
