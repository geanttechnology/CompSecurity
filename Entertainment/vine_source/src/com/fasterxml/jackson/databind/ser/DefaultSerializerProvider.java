// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.NoClass;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsonschema.JsonSchema;
import com.fasterxml.jackson.databind.jsonschema.SchemaAware;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ser.impl.WritableObjectId;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.RootNameLookup;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package com.fasterxml.jackson.databind.ser:
//            SerializerCache, SerializerFactory

public abstract class DefaultSerializerProvider extends SerializerProvider
    implements Serializable
{
    public static final class Impl extends DefaultSerializerProvider
    {

        private static final long serialVersionUID = 1L;

        public Impl createInstance(SerializationConfig serializationconfig, SerializerFactory serializerfactory)
        {
            return new Impl(this, serializationconfig, serializerfactory);
        }

        public volatile DefaultSerializerProvider createInstance(SerializationConfig serializationconfig, SerializerFactory serializerfactory)
        {
            return createInstance(serializationconfig, serializerfactory);
        }

        public Impl()
        {
        }

        protected Impl(SerializerProvider serializerprovider, SerializationConfig serializationconfig, SerializerFactory serializerfactory)
        {
            super(serializerprovider, serializationconfig, serializerfactory);
        }
    }


    private static final long serialVersionUID = 1L;
    protected transient ArrayList _objectIdGenerators;
    protected transient Map _seenObjectIds;

    protected DefaultSerializerProvider()
    {
    }

    protected DefaultSerializerProvider(SerializerProvider serializerprovider, SerializationConfig serializationconfig, SerializerFactory serializerfactory)
    {
        super(serializerprovider, serializationconfig, serializerfactory);
    }

    protected Map _createObjectIdMap()
    {
        if (isEnabled(SerializationFeature.USE_EQUALITY_FOR_OBJECT_ID))
        {
            return new HashMap();
        } else
        {
            return new IdentityHashMap();
        }
    }

    protected void _serializeNull(JsonGenerator jsongenerator)
        throws IOException, JsonGenerationException
    {
        JsonSerializer jsonserializer = getDefaultNullValueSerializer();
        try
        {
            jsonserializer.serialize(null, jsongenerator, this);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JsonGenerator jsongenerator)
        {
            throw jsongenerator;
        }
        catch (Exception exception)
        {
            String s = exception.getMessage();
            jsongenerator = s;
            if (s == null)
            {
                jsongenerator = (new StringBuilder()).append("[no message for ").append(exception.getClass().getName()).append("]").toString();
            }
            throw new JsonMappingException(jsongenerator, exception);
        }
    }

    public void acceptJsonFormatVisitor(JavaType javatype, JsonFormatVisitorWrapper jsonformatvisitorwrapper)
        throws JsonMappingException
    {
        if (javatype == null)
        {
            throw new IllegalArgumentException("A class must be provided");
        } else
        {
            jsonformatvisitorwrapper.setProvider(this);
            findValueSerializer(javatype, null).acceptJsonFormatVisitor(jsonformatvisitorwrapper, javatype);
            return;
        }
    }

    public int cachedSerializersCount()
    {
        return _serializerCache.size();
    }

    public abstract DefaultSerializerProvider createInstance(SerializationConfig serializationconfig, SerializerFactory serializerfactory);

    public WritableObjectId findObjectId(Object obj, ObjectIdGenerator objectidgenerator)
    {
        Object obj1;
        if (_seenObjectIds == null)
        {
            _seenObjectIds = _createObjectIdMap();
        } else
        {
            obj1 = (WritableObjectId)_seenObjectIds.get(obj);
            if (obj1 != null)
            {
                return ((WritableObjectId) (obj1));
            }
        }
        if (_objectIdGenerators != null) goto _L2; else goto _L1
_L1:
        _objectIdGenerators = new ArrayList(8);
        obj1 = null;
_L4:
        ObjectIdGenerator objectidgenerator1 = ((ObjectIdGenerator) (obj1));
        if (obj1 == null)
        {
            objectidgenerator1 = objectidgenerator.newForSerialization(this);
            _objectIdGenerators.add(objectidgenerator1);
        }
        objectidgenerator = new WritableObjectId(objectidgenerator1);
        _seenObjectIds.put(obj, objectidgenerator);
        return objectidgenerator;
_L2:
        int j = _objectIdGenerators.size();
        for (int i = 0; i < j; i++)
        {
            ObjectIdGenerator objectidgenerator2 = (ObjectIdGenerator)_objectIdGenerators.get(i);
            obj1 = objectidgenerator2;
            if (objectidgenerator2.canUseFor(objectidgenerator))
            {
                continue; /* Loop/switch isn't completed */
            }
        }

        obj1 = null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void flushCachedSerializers()
    {
        _serializerCache.flush();
    }

    public JsonSchema generateJsonSchema(Class class1)
        throws JsonMappingException
    {
        if (class1 == null)
        {
            throw new IllegalArgumentException("A class must be provided");
        }
        Object obj = findValueSerializer(class1, null);
        if (obj instanceof SchemaAware)
        {
            obj = ((SchemaAware)obj).getSchema(this, null);
        } else
        {
            obj = JsonSchema.getDefaultSchemaNode();
        }
        if (!(obj instanceof ObjectNode))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Class ").append(class1.getName()).append(" would not be serialized as a JSON object and therefore has no schema").toString());
        } else
        {
            return new JsonSchema((ObjectNode)obj);
        }
    }

    public boolean hasSerializerFor(Class class1)
    {
        return hasSerializerFor(class1, null);
    }

    public boolean hasSerializerFor(Class class1, AtomicReference atomicreference)
    {
        boolean flag = false;
        class1 = _findExplicitUntypedSerializer(class1);
        if (class1 != null)
        {
            flag = true;
        }
_L2:
        return flag;
        class1;
        if (atomicreference != null)
        {
            atomicreference.set(class1);
            return false;
        }
        if (true) goto _L2; else goto _L1
_L1:
        class1;
        if (atomicreference == null)
        {
            throw class1;
        } else
        {
            atomicreference.set(class1);
            return false;
        }
    }

    public void serializeValue(JsonGenerator jsongenerator, Object obj)
        throws IOException, JsonGenerationException
    {
        boolean flag = true;
        if (obj != null) goto _L2; else goto _L1
_L1:
        _serializeNull(jsongenerator);
_L4:
        return;
_L2:
        JsonSerializer jsonserializer = findTypedValueSerializer(obj.getClass(), true, null);
        String s = _config.getRootName();
        if (s == null)
        {
            boolean flag1 = _config.isEnabled(SerializationFeature.WRAP_ROOT_VALUE);
            flag = flag1;
            if (flag1)
            {
                jsongenerator.writeStartObject();
                jsongenerator.writeFieldName(_rootNames.findRootName(obj.getClass(), _config));
                flag = flag1;
            }
        } else
        if (s.length() == 0)
        {
            flag = false;
        } else
        {
            jsongenerator.writeStartObject();
            jsongenerator.writeFieldName(s);
        }
        try
        {
            jsonserializer.serialize(obj, jsongenerator, this);
        }
        // Misplaced declaration of an exception variable
        catch (JsonGenerator jsongenerator)
        {
            throw jsongenerator;
        }
        catch (Exception exception)
        {
            obj = exception.getMessage();
            jsongenerator = ((JsonGenerator) (obj));
            if (obj == null)
            {
                jsongenerator = (new StringBuilder()).append("[no message for ").append(exception.getClass().getName()).append("]").toString();
            }
            throw new JsonMappingException(jsongenerator, exception);
        }
        if (!flag) goto _L4; else goto _L3
_L3:
        jsongenerator.writeEndObject();
        return;
    }

    public void serializeValue(JsonGenerator jsongenerator, Object obj, JavaType javatype)
        throws IOException, JsonGenerationException
    {
        boolean flag = true;
        if (obj != null) goto _L2; else goto _L1
_L1:
        _serializeNull(jsongenerator);
_L4:
        return;
_L2:
        if (!javatype.getRawClass().isAssignableFrom(obj.getClass()))
        {
            _reportIncompatibleRootType(obj, javatype);
        }
        JsonSerializer jsonserializer = findTypedValueSerializer(javatype, true, null);
        String s = _config.getRootName();
        if (s == null)
        {
            boolean flag1 = _config.isEnabled(SerializationFeature.WRAP_ROOT_VALUE);
            flag = flag1;
            if (flag1)
            {
                jsongenerator.writeStartObject();
                jsongenerator.writeFieldName(_rootNames.findRootName(javatype, _config));
                flag = flag1;
            }
        } else
        if (s.length() == 0)
        {
            flag = false;
        } else
        {
            jsongenerator.writeStartObject();
            jsongenerator.writeFieldName(s);
        }
        jsonserializer.serialize(obj, jsongenerator, this);
        if (flag)
        {
            try
            {
                jsongenerator.writeEndObject();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (JsonGenerator jsongenerator)
            {
                throw jsongenerator;
            }
            // Misplaced declaration of an exception variable
            catch (JavaType javatype)
            {
                obj = javatype.getMessage();
            }
            jsongenerator = ((JsonGenerator) (obj));
            if (obj == null)
            {
                jsongenerator = (new StringBuilder()).append("[no message for ").append(javatype.getClass().getName()).append("]").toString();
            }
            throw new JsonMappingException(jsongenerator, javatype);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void serializeValue(JsonGenerator jsongenerator, Object obj, JavaType javatype, JsonSerializer jsonserializer)
        throws IOException, JsonGenerationException
    {
        boolean flag = true;
        if (obj != null) goto _L2; else goto _L1
_L1:
        _serializeNull(jsongenerator);
_L4:
        return;
_L2:
        if (javatype != null && !javatype.getRawClass().isAssignableFrom(obj.getClass()))
        {
            _reportIncompatibleRootType(obj, javatype);
        }
        JsonSerializer jsonserializer1 = jsonserializer;
        if (jsonserializer == null)
        {
            jsonserializer1 = findTypedValueSerializer(javatype, true, null);
        }
        jsonserializer = _config.getRootName();
        if (jsonserializer == null)
        {
            flag = _config.isEnabled(SerializationFeature.WRAP_ROOT_VALUE);
            if (flag)
            {
                jsongenerator.writeStartObject();
                if (javatype == null)
                {
                    javatype = _rootNames.findRootName(obj.getClass(), _config);
                } else
                {
                    javatype = _rootNames.findRootName(javatype, _config);
                }
                jsongenerator.writeFieldName(javatype);
            }
        } else
        if (jsonserializer.length() == 0)
        {
            flag = false;
        } else
        {
            jsongenerator.writeStartObject();
            jsongenerator.writeFieldName(jsonserializer);
        }
        jsonserializer1.serialize(obj, jsongenerator, this);
        if (flag)
        {
            try
            {
                jsongenerator.writeEndObject();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (JsonGenerator jsongenerator)
            {
                throw jsongenerator;
            }
            // Misplaced declaration of an exception variable
            catch (JavaType javatype)
            {
                obj = javatype.getMessage();
            }
            jsongenerator = ((JsonGenerator) (obj));
            if (obj == null)
            {
                jsongenerator = (new StringBuilder()).append("[no message for ").append(javatype.getClass().getName()).append("]").toString();
            }
            throw new JsonMappingException(jsongenerator, javatype);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public JsonSerializer serializerInstance(Annotated annotated, Object obj)
        throws JsonMappingException
    {
        Object obj1 = null;
        if (obj != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        if (obj instanceof JsonSerializer)
        {
            annotated = (JsonSerializer)obj;
        } else
        {
            if (!(obj instanceof Class))
            {
                throw new IllegalStateException((new StringBuilder()).append("AnnotationIntrospector returned serializer definition of type ").append(obj.getClass().getName()).append("; expected type JsonSerializer or Class<JsonSerializer> instead").toString());
            }
            obj = (Class)obj;
            if (obj == com/fasterxml/jackson/databind/JsonSerializer$None || obj == com/fasterxml/jackson/databind/annotation/NoClass)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (!com/fasterxml/jackson/databind/JsonSerializer.isAssignableFrom(((Class) (obj))))
            {
                throw new IllegalStateException((new StringBuilder()).append("AnnotationIntrospector returned Class ").append(((Class) (obj)).getName()).append("; expected Class<JsonSerializer>").toString());
            }
            HandlerInstantiator handlerinstantiator = _config.getHandlerInstantiator();
            if (handlerinstantiator == null)
            {
                annotated = obj1;
            } else
            {
                annotated = handlerinstantiator.serializerInstance(_config, annotated, ((Class) (obj)));
            }
            if (annotated == null)
            {
                annotated = (JsonSerializer)ClassUtil.createInstance(((Class) (obj)), _config.canOverrideAccessModifiers());
            }
        }
        return _handleResolvable(annotated);
        if (true) goto _L1; else goto _L3
_L3:
    }
}
