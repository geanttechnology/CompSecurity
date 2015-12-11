// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.map.ser.std;

import com.flurry.org.codehaus.jackson.JsonGenerationException;
import com.flurry.org.codehaus.jackson.JsonGenerator;
import com.flurry.org.codehaus.jackson.JsonNode;
import com.flurry.org.codehaus.jackson.map.JsonMappingException;
import com.flurry.org.codehaus.jackson.map.JsonSerializer;
import com.flurry.org.codehaus.jackson.map.SerializerProvider;
import com.flurry.org.codehaus.jackson.map.annotate.JacksonStdImpl;
import com.flurry.org.codehaus.jackson.node.JsonNodeFactory;
import com.flurry.org.codehaus.jackson.node.ObjectNode;
import com.flurry.org.codehaus.jackson.schema.SchemaAware;
import com.flurry.org.codehaus.jackson.type.JavaType;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;

public abstract class SerializerBase extends JsonSerializer
    implements SchemaAware
{

    protected final Class _handledType;

    protected SerializerBase(JavaType javatype)
    {
        _handledType = javatype.getRawClass();
    }

    protected SerializerBase(Class class1)
    {
        _handledType = class1;
    }

    protected SerializerBase(Class class1, boolean flag)
    {
        _handledType = class1;
    }

    protected ObjectNode createObjectNode()
    {
        return JsonNodeFactory.instance.objectNode();
    }

    protected ObjectNode createSchemaNode(String s)
    {
        ObjectNode objectnode = createObjectNode();
        objectnode.put("type", s);
        return objectnode;
    }

    protected ObjectNode createSchemaNode(String s, boolean flag)
    {
        s = createSchemaNode(s);
        if (!flag)
        {
            if (!flag)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            s.put("required", flag);
        }
        return s;
    }

    public JsonNode getSchema(SerializerProvider serializerprovider, Type type)
        throws JsonMappingException
    {
        return createSchemaNode("string");
    }

    public final Class handledType()
    {
        return _handledType;
    }

    protected boolean isDefaultSerializer(JsonSerializer jsonserializer)
    {
        return jsonserializer != null && jsonserializer.getClass().getAnnotation(com/flurry/org/codehaus/jackson/map/annotate/JacksonStdImpl) != null;
    }

    public abstract void serialize(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException, JsonGenerationException;

    public void wrapAndThrow(SerializerProvider serializerprovider, Throwable throwable, Object obj, int i)
        throws IOException
    {
        for (; (throwable instanceof InvocationTargetException) && throwable.getCause() != null; throwable = throwable.getCause()) { }
        if (throwable instanceof Error)
        {
            throw (Error)throwable;
        }
        boolean flag;
        if (serializerprovider == null || serializerprovider.isEnabled(com.flurry.org.codehaus.jackson.map.SerializationConfig.Feature.WRAP_EXCEPTIONS))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (throwable instanceof IOException)
        {
            if (!flag || !(throwable instanceof JsonMappingException))
            {
                throw (IOException)throwable;
            }
        } else
        if (!flag && (throwable instanceof RuntimeException))
        {
            throw (RuntimeException)throwable;
        }
        throw JsonMappingException.wrapWithPath(throwable, obj, i);
    }

    public void wrapAndThrow(SerializerProvider serializerprovider, Throwable throwable, Object obj, String s)
        throws IOException
    {
        for (; (throwable instanceof InvocationTargetException) && throwable.getCause() != null; throwable = throwable.getCause()) { }
        if (throwable instanceof Error)
        {
            throw (Error)throwable;
        }
        boolean flag;
        if (serializerprovider == null || serializerprovider.isEnabled(com.flurry.org.codehaus.jackson.map.SerializationConfig.Feature.WRAP_EXCEPTIONS))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (throwable instanceof IOException)
        {
            if (!flag || !(throwable instanceof JsonMappingException))
            {
                throw (IOException)throwable;
            }
        } else
        if (!flag && (throwable instanceof RuntimeException))
        {
            throw (RuntimeException)throwable;
        }
        throw JsonMappingException.wrapWithPath(throwable, obj, s);
    }

    public void wrapAndThrow(Throwable throwable, Object obj, int i)
        throws IOException
    {
        wrapAndThrow(null, throwable, obj, i);
    }

    public void wrapAndThrow(Throwable throwable, Object obj, String s)
        throws IOException
    {
        wrapAndThrow(null, throwable, obj, s);
    }
}
