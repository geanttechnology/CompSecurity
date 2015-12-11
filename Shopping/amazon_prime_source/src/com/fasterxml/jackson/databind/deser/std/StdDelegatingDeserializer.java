// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import java.io.IOException;

// Referenced classes of package com.fasterxml.jackson.databind.deser.std:
//            StdDeserializer

public class StdDelegatingDeserializer extends StdDeserializer
    implements ContextualDeserializer
{

    private static final long serialVersionUID = 1L;
    protected final Converter _converter;
    protected final JsonDeserializer _delegateDeserializer;
    protected final JavaType _delegateType;

    public StdDelegatingDeserializer(Converter converter)
    {
        super(java/lang/Object);
        _converter = converter;
        _delegateType = null;
        _delegateDeserializer = null;
    }

    protected StdDelegatingDeserializer(Converter converter, JavaType javatype, JsonDeserializer jsondeserializer)
    {
        super(javatype);
        _converter = converter;
        _delegateType = javatype;
        _delegateDeserializer = jsondeserializer;
    }

    protected Object convertValue(Object obj)
    {
        return _converter.convert(obj);
    }

    public JsonDeserializer createContextual(DeserializationContext deserializationcontext, BeanProperty beanproperty)
        throws JsonMappingException
    {
        TypeFactory typefactory = deserializationcontext.getTypeFactory();
        JavaType javatype = typefactory.constructType(_converter.getClass());
        JavaType ajavatype[] = typefactory.findTypeParameters(javatype, com/fasterxml/jackson/databind/util/Converter);
        if (ajavatype == null || ajavatype.length != 2)
        {
            throw new JsonMappingException((new StringBuilder()).append("Could not determine Converter parameterization for ").append(javatype).toString());
        } else
        {
            JavaType javatype1 = ajavatype[0];
            return withDelegate(_converter, javatype1, deserializationcontext.findContextualValueDeserializer(javatype1, beanproperty));
        }
    }

    public Object deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        jsonparser = ((JsonParser) (_delegateDeserializer.deserialize(jsonparser, deserializationcontext)));
        if (jsonparser == null)
        {
            return null;
        } else
        {
            return convertValue(jsonparser);
        }
    }

    public Object deserializeWithType(JsonParser jsonparser, DeserializationContext deserializationcontext, TypeDeserializer typedeserializer)
        throws IOException, JsonProcessingException
    {
        jsonparser = ((JsonParser) (_delegateDeserializer.deserializeWithType(jsonparser, deserializationcontext, typedeserializer)));
        if (jsonparser == null)
        {
            return null;
        } else
        {
            return convertValue(jsonparser);
        }
    }

    public JsonDeserializer getDelegatee()
    {
        return _delegateDeserializer;
    }

    protected StdDelegatingDeserializer withDelegate(Converter converter, JavaType javatype, JsonDeserializer jsondeserializer)
    {
        if (getClass() != com/fasterxml/jackson/databind/deser/std/StdDelegatingDeserializer)
        {
            throw new IllegalStateException((new StringBuilder()).append("Sub-class ").append(getClass().getName()).append(" must override 'withDelegate'").toString());
        } else
        {
            return new StdDelegatingDeserializer(converter, javatype, jsondeserializer);
        }
    }
}
