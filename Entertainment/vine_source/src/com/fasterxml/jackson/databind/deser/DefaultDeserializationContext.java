// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.annotation.NoClass;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.deser.impl.ReadableObjectId;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Serializable;
import java.util.LinkedHashMap;

// Referenced classes of package com.fasterxml.jackson.databind.deser:
//            ResolvableDeserializer, DeserializerFactory, DeserializerCache

public abstract class DefaultDeserializationContext extends DeserializationContext
    implements Serializable
{
    public static final class Impl extends DefaultDeserializationContext
    {

        private static final long serialVersionUID = 1L;

        public DefaultDeserializationContext createInstance(DeserializationConfig deserializationconfig, JsonParser jsonparser, InjectableValues injectablevalues)
        {
            return new Impl(this, deserializationconfig, jsonparser, injectablevalues);
        }

        public DefaultDeserializationContext with(DeserializerFactory deserializerfactory)
        {
            return new Impl(this, deserializerfactory);
        }

        protected Impl(Impl impl, DeserializationConfig deserializationconfig, JsonParser jsonparser, InjectableValues injectablevalues)
        {
            super(impl, deserializationconfig, jsonparser, injectablevalues);
        }

        protected Impl(Impl impl, DeserializerFactory deserializerfactory)
        {
            super(impl, deserializerfactory);
        }

        public Impl(DeserializerFactory deserializerfactory)
        {
            super(deserializerfactory, null);
        }
    }


    private static final long serialVersionUID = 1L;
    protected transient LinkedHashMap _objectIds;

    protected DefaultDeserializationContext(DefaultDeserializationContext defaultdeserializationcontext, DeserializationConfig deserializationconfig, JsonParser jsonparser, InjectableValues injectablevalues)
    {
        super(defaultdeserializationcontext, deserializationconfig, jsonparser, injectablevalues);
    }

    protected DefaultDeserializationContext(DefaultDeserializationContext defaultdeserializationcontext, DeserializerFactory deserializerfactory)
    {
        super(defaultdeserializationcontext, deserializerfactory);
    }

    protected DefaultDeserializationContext(DeserializerFactory deserializerfactory, DeserializerCache deserializercache)
    {
        super(deserializerfactory, deserializercache);
    }

    public abstract DefaultDeserializationContext createInstance(DeserializationConfig deserializationconfig, JsonParser jsonparser, InjectableValues injectablevalues);

    public JsonDeserializer deserializerInstance(Annotated annotated, Object obj)
        throws JsonMappingException
    {
        Object obj1;
        Object obj2;
        obj1 = null;
        obj2 = null;
        if (obj != null) goto _L2; else goto _L1
_L1:
        obj = obj2;
_L4:
        return ((JsonDeserializer) (obj));
_L2:
        if (!(obj instanceof JsonDeserializer))
        {
            break; /* Loop/switch isn't completed */
        }
        annotated = (JsonDeserializer)obj;
_L7:
        obj = annotated;
        if (annotated instanceof ResolvableDeserializer)
        {
            ((ResolvableDeserializer)annotated).resolve(this);
            return annotated;
        }
        if (true) goto _L4; else goto _L3
_L3:
        Class class1;
        if (!(obj instanceof Class))
        {
            throw new IllegalStateException((new StringBuilder()).append("AnnotationIntrospector returned deserializer definition of type ").append(obj.getClass().getName()).append("; expected type JsonDeserializer or Class<JsonDeserializer> instead").toString());
        }
        class1 = (Class)obj;
        obj = obj2;
        if (class1 == com/fasterxml/jackson/databind/JsonDeserializer$None) goto _L4; else goto _L5
_L5:
        obj = obj2;
        if (class1 == com/fasterxml/jackson/databind/annotation/NoClass) goto _L4; else goto _L6
_L6:
        if (!com/fasterxml/jackson/databind/JsonDeserializer.isAssignableFrom(class1))
        {
            throw new IllegalStateException((new StringBuilder()).append("AnnotationIntrospector returned Class ").append(class1.getName()).append("; expected Class<JsonDeserializer>").toString());
        }
        obj = _config.getHandlerInstantiator();
        if (obj == null)
        {
            obj = obj1;
        } else
        {
            obj = ((HandlerInstantiator) (obj)).deserializerInstance(_config, annotated, class1);
        }
        annotated = ((Annotated) (obj));
        if (obj == null)
        {
            annotated = (JsonDeserializer)ClassUtil.createInstance(class1, _config.canOverrideAccessModifiers());
        }
          goto _L7
    }

    public ReadableObjectId findObjectId(Object obj, ObjectIdGenerator objectidgenerator)
    {
        objectidgenerator = objectidgenerator.key(obj);
        if (_objectIds == null)
        {
            _objectIds = new LinkedHashMap();
        } else
        {
            ReadableObjectId readableobjectid = (ReadableObjectId)_objectIds.get(objectidgenerator);
            if (readableobjectid != null)
            {
                return readableobjectid;
            }
        }
        obj = new ReadableObjectId(obj);
        _objectIds.put(objectidgenerator, obj);
        return ((ReadableObjectId) (obj));
    }

    public final KeyDeserializer keyDeserializerInstance(Annotated annotated, Object obj)
        throws JsonMappingException
    {
        Object obj1;
        Object obj2;
        obj1 = null;
        obj2 = null;
        if (obj != null) goto _L2; else goto _L1
_L1:
        obj = obj2;
_L4:
        return ((KeyDeserializer) (obj));
_L2:
        if (!(obj instanceof KeyDeserializer))
        {
            break; /* Loop/switch isn't completed */
        }
        annotated = (KeyDeserializer)obj;
_L7:
        obj = annotated;
        if (annotated instanceof ResolvableDeserializer)
        {
            ((ResolvableDeserializer)annotated).resolve(this);
            return annotated;
        }
        if (true) goto _L4; else goto _L3
_L3:
        Class class1;
        if (!(obj instanceof Class))
        {
            throw new IllegalStateException((new StringBuilder()).append("AnnotationIntrospector returned key deserializer definition of type ").append(obj.getClass().getName()).append("; expected type KeyDeserializer or Class<KeyDeserializer> instead").toString());
        }
        class1 = (Class)obj;
        obj = obj2;
        if (class1 == com/fasterxml/jackson/databind/KeyDeserializer$None) goto _L4; else goto _L5
_L5:
        obj = obj2;
        if (class1 == com/fasterxml/jackson/databind/annotation/NoClass) goto _L4; else goto _L6
_L6:
        if (!com/fasterxml/jackson/databind/KeyDeserializer.isAssignableFrom(class1))
        {
            throw new IllegalStateException((new StringBuilder()).append("AnnotationIntrospector returned Class ").append(class1.getName()).append("; expected Class<KeyDeserializer>").toString());
        }
        obj = _config.getHandlerInstantiator();
        if (obj == null)
        {
            obj = obj1;
        } else
        {
            obj = ((HandlerInstantiator) (obj)).keyDeserializerInstance(_config, annotated, class1);
        }
        annotated = ((Annotated) (obj));
        if (obj == null)
        {
            annotated = (KeyDeserializer)ClassUtil.createInstance(class1, _config.canOverrideAccessModifiers());
        }
          goto _L7
    }

    public abstract DefaultDeserializationContext with(DeserializerFactory deserializerfactory);
}
