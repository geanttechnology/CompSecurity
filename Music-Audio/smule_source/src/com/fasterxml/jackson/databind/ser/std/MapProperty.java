// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.PropertyWriter;

public class MapProperty extends PropertyWriter
{

    protected Object _key;
    protected JsonSerializer _keySerializer;
    protected TypeSerializer _typeSerializer;
    protected Object _value;
    protected JsonSerializer _valueSerializer;

    public MapProperty(TypeSerializer typeserializer)
    {
        _typeSerializer = typeserializer;
    }

    public String getName()
    {
        if (_key instanceof String)
        {
            return (String)_key;
        } else
        {
            return String.valueOf(_key);
        }
    }

    public void reset(Object obj, Object obj1, JsonSerializer jsonserializer, JsonSerializer jsonserializer1)
    {
        _key = obj;
        _value = obj1;
        _keySerializer = jsonserializer;
        _valueSerializer = jsonserializer1;
    }

    public void serializeAsField(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
    {
        _keySerializer.serialize(_key, jsongenerator, serializerprovider);
        if (_typeSerializer == null)
        {
            _valueSerializer.serialize(_value, jsongenerator, serializerprovider);
            return;
        } else
        {
            _valueSerializer.serializeWithType(_value, jsongenerator, serializerprovider, _typeSerializer);
            return;
        }
    }

    public void serializeAsOmittedField(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
    {
        if (!jsongenerator.canOmitFields())
        {
            jsongenerator.writeOmittedField(getName());
        }
    }
}
