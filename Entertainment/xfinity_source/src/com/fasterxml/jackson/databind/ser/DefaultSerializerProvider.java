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
import com.fasterxml.jackson.databind.introspect.ObjectIdInfo;
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
import java.util.IdentityHashMap;

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
    protected transient IdentityHashMap _seenObjectIds;

    protected DefaultSerializerProvider()
    {
    }

    protected DefaultSerializerProvider(SerializerProvider serializerprovider, SerializationConfig serializationconfig, SerializerFactory serializerfactory)
    {
        super(serializerprovider, serializationconfig, serializerfactory);
    }

    public void acceptJsonFormatVisitor(JavaType javatype, JsonFormatVisitorWrapper jsonformatvisitorwrapper)
        throws JsonMappingException
    {
        if (javatype == null)
        {
            throw new IllegalArgumentException("A class must be provided");
        } else
        {
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
        ObjectIdGenerator objectidgenerator1;
        if (_seenObjectIds == null)
        {
            _seenObjectIds = new IdentityHashMap();
        } else
        {
            obj1 = (WritableObjectId)_seenObjectIds.get(obj);
            if (obj1 != null)
            {
                return ((WritableObjectId) (obj1));
            }
        }
        objectidgenerator1 = null;
        if (_objectIdGenerators != null) goto _L2; else goto _L1
_L1:
        _objectIdGenerators = new ArrayList(8);
        obj1 = objectidgenerator1;
_L4:
        objectidgenerator1 = ((ObjectIdGenerator) (obj1));
        if (obj1 == null)
        {
            objectidgenerator1 = objectidgenerator.newForSerialization(this);
            _objectIdGenerators.add(objectidgenerator1);
        }
        objectidgenerator = new WritableObjectId(objectidgenerator1);
        _seenObjectIds.put(obj, objectidgenerator);
        return objectidgenerator;
_L2:
        int i;
        int j;
        i = 0;
        j = _objectIdGenerators.size();
_L6:
        obj1 = objectidgenerator1;
        if (i >= j) goto _L4; else goto _L3
_L3:
        obj1 = (ObjectIdGenerator)_objectIdGenerators.get(i);
        if (!((ObjectIdGenerator) (obj1)).canUseFor(objectidgenerator)) goto _L5; else goto _L4
_L5:
        i++;
          goto _L6
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
        return _findExplicitUntypedSerializer(class1) != null;
    }

    public ObjectIdGenerator objectIdGeneratorInstance(Annotated annotated, ObjectIdInfo objectidinfo)
        throws JsonMappingException
    {
        Class class1 = objectidinfo.getGeneratorType();
        HandlerInstantiator handlerinstantiator = _config.getHandlerInstantiator();
        if (handlerinstantiator != null)
        {
            annotated = handlerinstantiator.objectIdGeneratorInstance(_config, annotated, class1);
        } else
        {
            annotated = (ObjectIdGenerator)ClassUtil.createInstance(class1, _config.canOverrideAccessModifiers());
        }
        return annotated.forScope(objectidinfo.getScope());
    }

    public void serializeValue(JsonGenerator jsongenerator, Object obj)
        throws IOException, JsonGenerationException
    {
        if (obj != null) goto _L2; else goto _L1
_L1:
        Object obj1;
        boolean flag;
        obj1 = getDefaultNullValueSerializer();
        flag = false;
_L4:
        JsonSerializer jsonserializer;
        boolean flag1;
        try
        {
            ((JsonSerializer) (obj1)).serialize(obj, jsongenerator, this);
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
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        jsongenerator.writeEndObject();
        return;
_L2:
        jsonserializer = findTypedValueSerializer(obj.getClass(), true, null);
        obj1 = _config.getRootName();
        if (obj1 == null)
        {
            flag1 = _config.isEnabled(SerializationFeature.WRAP_ROOT_VALUE);
            obj1 = jsonserializer;
            flag = flag1;
            if (flag1)
            {
                jsongenerator.writeStartObject();
                jsongenerator.writeFieldName(_rootNames.findRootName(obj.getClass(), _config));
                obj1 = jsonserializer;
                flag = flag1;
            }
        } else
        if (((String) (obj1)).length() == 0)
        {
            flag = false;
            obj1 = jsonserializer;
        } else
        {
            flag = true;
            jsongenerator.writeStartObject();
            jsongenerator.writeFieldName(((String) (obj1)));
            obj1 = jsonserializer;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void serializeValue(JsonGenerator jsongenerator, Object obj, JavaType javatype)
        throws IOException, JsonGenerationException
    {
        if (obj != null) goto _L2; else goto _L1
_L1:
        JsonSerializer jsonserializer;
        boolean flag;
        jsonserializer = getDefaultNullValueSerializer();
        flag = false;
_L4:
        JsonSerializer jsonserializer1;
        boolean flag1;
        try
        {
            jsonserializer.serialize(obj, jsongenerator, this);
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
            jsongenerator = ((JsonGenerator) (obj));
            if (obj == null)
            {
                jsongenerator = (new StringBuilder()).append("[no message for ").append(javatype.getClass().getName()).append("]").toString();
            }
            throw new JsonMappingException(jsongenerator, javatype);
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        jsongenerator.writeEndObject();
        return;
_L2:
        if (!javatype.getRawClass().isAssignableFrom(obj.getClass()))
        {
            _reportIncompatibleRootType(obj, javatype);
        }
        jsonserializer1 = findTypedValueSerializer(javatype, true, null);
        flag1 = _config.isEnabled(SerializationFeature.WRAP_ROOT_VALUE);
        jsonserializer = jsonserializer1;
        flag = flag1;
        if (flag1)
        {
            jsongenerator.writeStartObject();
            jsongenerator.writeFieldName(_rootNames.findRootName(javatype, _config));
            jsonserializer = jsonserializer1;
            flag = flag1;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void serializeValue(JsonGenerator jsongenerator, Object obj, JavaType javatype, JsonSerializer jsonserializer)
        throws IOException, JsonGenerationException
    {
        if (obj != null) goto _L2; else goto _L1
_L1:
        boolean flag;
        jsonserializer = getDefaultNullValueSerializer();
        flag = false;
_L4:
        JsonSerializer jsonserializer1;
        boolean flag1;
        try
        {
            jsonserializer.serialize(obj, jsongenerator, this);
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
            jsongenerator = ((JsonGenerator) (obj));
            if (obj == null)
            {
                jsongenerator = (new StringBuilder()).append("[no message for ").append(javatype.getClass().getName()).append("]").toString();
            }
            throw new JsonMappingException(jsongenerator, javatype);
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        jsongenerator.writeEndObject();
        return;
_L2:
        if (javatype != null && !javatype.getRawClass().isAssignableFrom(obj.getClass()))
        {
            _reportIncompatibleRootType(obj, javatype);
        }
        jsonserializer1 = jsonserializer;
        if (jsonserializer == null)
        {
            jsonserializer1 = findTypedValueSerializer(javatype, true, null);
        }
        flag1 = _config.isEnabled(SerializationFeature.WRAP_ROOT_VALUE);
        flag = flag1;
        jsonserializer = jsonserializer1;
        if (flag1)
        {
            jsongenerator.writeStartObject();
            jsongenerator.writeFieldName(_rootNames.findRootName(javatype, _config));
            flag = flag1;
            jsonserializer = jsonserializer1;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public JsonSerializer serializerInstance(Annotated annotated, Object obj)
        throws JsonMappingException
    {
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
            if (handlerinstantiator != null)
            {
                annotated = handlerinstantiator.serializerInstance(_config, annotated, ((Class) (obj)));
            } else
            {
                annotated = (JsonSerializer)ClassUtil.createInstance(((Class) (obj)), _config.canOverrideAccessModifiers());
            }
        }
        return _handleResolvable(annotated);
        if (true) goto _L1; else goto _L3
_L3:
    }
}
