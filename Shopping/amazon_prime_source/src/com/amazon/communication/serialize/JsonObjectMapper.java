// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication.serialize;

import amazon.communication.serialize.TypeReference;
import com.amazon.dp.logger.DPLogger;
import com.amazon.org.codehaus.jackson.JsonGenerationException;
import com.amazon.org.codehaus.jackson.JsonParseException;
import com.amazon.org.codehaus.jackson.JsonParser;
import com.amazon.org.codehaus.jackson.JsonProcessingException;
import com.amazon.org.codehaus.jackson.Version;
import com.amazon.org.codehaus.jackson.map.DeserializationConfig;
import com.amazon.org.codehaus.jackson.map.DeserializationContext;
import com.amazon.org.codehaus.jackson.map.DeserializationProblemHandler;
import com.amazon.org.codehaus.jackson.map.JsonDeserializer;
import com.amazon.org.codehaus.jackson.map.JsonMappingException;
import com.amazon.org.codehaus.jackson.map.ObjectMapper;
import com.amazon.org.codehaus.jackson.map.module.SimpleModule;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.amazon.communication.serialize:
//            ByteBufferJsonSerializer, ByteBufferJsonDeserializer

public class JsonObjectMapper
{

    private static final List IGNORABLE_FIELDS = new ArrayList(Arrays.asList(new String[] {
        "__type"
    }));
    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();
    private static final DPLogger log = new DPLogger("TComm.JsonObjectMapper");
    private static volatile boolean sRegisteredModule = false;

    public JsonObjectMapper()
    {
        synchronized (JSON_MAPPER)
        {
            if (!sRegisteredModule)
            {
                SimpleModule simplemodule = new SimpleModule("CoralExtension", new Version(1, 0, 0, null));
                simplemodule.addSerializer(java/nio/ByteBuffer, new ByteBufferJsonSerializer());
                simplemodule.addDeserializer(java/nio/ByteBuffer, new ByteBufferJsonDeserializer());
                JSON_MAPPER.registerModule(simplemodule);
                JSON_MAPPER.getDeserializationConfig().addHandler(new DeserializationProblemHandler() {

                    final JsonObjectMapper this$0;

                    public boolean handleUnknownProperty(DeserializationContext deserializationcontext, JsonDeserializer jsondeserializer, Object obj, String s)
                        throws IOException, JsonProcessingException
                    {
                        if (!JsonObjectMapper.IGNORABLE_FIELDS.contains(s))
                        {
                            JsonObjectMapper.log.debug("JsonObjectMapper", "Unknown field in Json input", new Object[] {
                                "propertyName", s
                            });
                        }
                        deserializationcontext.getParser().skipChildren();
                        return true;
                    }

            
            {
                this$0 = JsonObjectMapper.this;
                super();
            }
                });
                sRegisteredModule = true;
            }
        }
        return;
        exception;
        objectmapper;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public JsonObjectMapper(List list)
    {
        this();
        if (list == null)
        {
            throw new IllegalArgumentException("null ignorableFields passed.");
        } else
        {
            IGNORABLE_FIELDS.addAll(list);
            return;
        }
    }

    public Object deserialize(InputStream inputstream, final TypeReference valueTypeRef)
        throws IOException
    {
        try
        {
            inputstream = ((InputStream) (JSON_MAPPER.readValue(inputstream, new com.amazon.org.codehaus.jackson.type.TypeReference() {

                final JsonObjectMapper this$0;
                final TypeReference val$valueTypeRef;

                public Type getType()
                {
                    return valueTypeRef.getType();
                }

            
            {
                this$0 = JsonObjectMapper.this;
                valueTypeRef = typereference;
                super();
            }
            })));
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new IllegalArgumentException(inputstream);
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new IllegalArgumentException(inputstream);
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw inputstream;
        }
        return inputstream;
    }

    public Object deserialize(InputStream inputstream, Class class1)
        throws IOException
    {
        try
        {
            inputstream = ((InputStream) (JSON_MAPPER.readValue(inputstream, class1)));
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new IllegalArgumentException(inputstream);
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new IllegalArgumentException(inputstream);
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw inputstream;
        }
        return inputstream;
    }

    public ByteBuffer serialize(Object obj)
    {
        try
        {
            obj = ByteBuffer.wrap(JSON_MAPPER.writeValueAsBytes(obj));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new IllegalArgumentException(((Throwable) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new IllegalArgumentException(((Throwable) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new IllegalArgumentException(((Throwable) (obj)));
        }
        return ((ByteBuffer) (obj));
    }



}
