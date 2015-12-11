// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.annotation.NoClass;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.fasterxml.jackson.databind.deser:
//            ResolvableDeserializer, DeserializerFactory

public final class DeserializerCache
    implements Serializable
{

    protected final ConcurrentHashMap _cachedDeserializers = new ConcurrentHashMap(64, 0.75F, 2);
    protected final HashMap _incompleteDeserializers = new HashMap(8);

    public DeserializerCache()
    {
    }

    private Class _verifyAsClass(Object obj, String s, Class class1)
    {
        if (obj != null) goto _L2; else goto _L1
_L1:
        obj = null;
_L4:
        return ((Class) (obj));
_L2:
        if (!(obj instanceof Class))
        {
            throw new IllegalStateException((new StringBuilder()).append("AnnotationIntrospector.").append(s).append("() returned value of type ").append(obj.getClass().getName()).append(": expected type JsonSerializer or Class<JsonSerializer> instead").toString());
        }
        s = (Class)obj;
        if (s == class1)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = s;
        if (s != com/fasterxml/jackson/databind/annotation/NoClass) goto _L4; else goto _L3
_L3:
        return null;
    }

    private JavaType modifyTypeByAnnotation(DeserializationContext deserializationcontext, Annotated annotated, JavaType javatype)
        throws JsonMappingException
    {
        Object obj;
        Object obj1;
        Object obj2;
        obj2 = deserializationcontext.getAnnotationIntrospector();
        obj1 = ((AnnotationIntrospector) (obj2)).findDeserializationType(annotated, javatype);
        obj = javatype;
        if (obj1 != null)
        {
            try
            {
                obj = javatype.narrowBy(((Class) (obj1)));
            }
            // Misplaced declaration of an exception variable
            catch (DeserializationContext deserializationcontext)
            {
                throw new JsonMappingException((new StringBuilder()).append("Failed to narrow type ").append(javatype).append(" with concrete-type annotation (value ").append(((Class) (obj1)).getName()).append("), method '").append(annotated.getName()).append("': ").append(deserializationcontext.getMessage()).toString(), null, deserializationcontext);
            }
        }
        obj1 = obj;
        if (!((JavaType) (obj)).isContainerType()) goto _L2; else goto _L1
_L1:
        obj1 = ((AnnotationIntrospector) (obj2)).findDeserializationKeyType(annotated, ((JavaType) (obj)).getKeyType());
        javatype = ((JavaType) (obj));
        if (obj1 != null)
        {
            if (!(obj instanceof MapLikeType))
            {
                throw new JsonMappingException((new StringBuilder()).append("Illegal key-type annotation: type ").append(obj).append(" is not a Map(-like) type").toString());
            }
            try
            {
                javatype = ((MapLikeType)obj).narrowKey(((Class) (obj1)));
            }
            // Misplaced declaration of an exception variable
            catch (DeserializationContext deserializationcontext)
            {
                throw new JsonMappingException((new StringBuilder()).append("Failed to narrow key type ").append(obj).append(" with key-type annotation (").append(((Class) (obj1)).getName()).append("): ").append(deserializationcontext.getMessage()).toString(), null, deserializationcontext);
            }
        }
        obj1 = javatype.getKeyType();
        obj = javatype;
        if (obj1 != null)
        {
            obj = javatype;
            if (((JavaType) (obj1)).getValueHandler() == null)
            {
                obj1 = ((AnnotationIntrospector) (obj2)).findKeyDeserializer(annotated);
                obj = javatype;
                if (obj1 != null)
                {
                    obj1 = deserializationcontext.keyDeserializerInstance(annotated, obj1);
                    obj = javatype;
                    if (obj1 != null)
                    {
                        obj = ((MapLikeType)javatype).withKeyValueHandler(obj1);
                        ((JavaType) (obj)).getKeyType();
                    }
                }
            }
        }
        obj1 = ((AnnotationIntrospector) (obj2)).findDeserializationContentType(annotated, ((JavaType) (obj)).getContentType());
        javatype = ((JavaType) (obj));
        if (obj1 != null)
        {
            try
            {
                javatype = ((JavaType) (obj)).narrowContentsBy(((Class) (obj1)));
            }
            // Misplaced declaration of an exception variable
            catch (DeserializationContext deserializationcontext)
            {
                throw new JsonMappingException((new StringBuilder()).append("Failed to narrow content type ").append(obj).append(" with content-type annotation (").append(((Class) (obj1)).getName()).append("): ").append(deserializationcontext.getMessage()).toString(), null, deserializationcontext);
            }
        }
        obj1 = javatype;
        if (javatype.getContentType().getValueHandler() != null) goto _L2; else goto _L3
_L3:
        obj2 = ((AnnotationIntrospector) (obj2)).findContentDeserializer(annotated);
        obj1 = javatype;
        if (obj2 == null) goto _L2; else goto _L4
_L4:
        obj = null;
        if (!(obj2 instanceof JsonDeserializer)) goto _L6; else goto _L5
_L5:
        deserializationcontext = (JsonDeserializer)obj2;
_L8:
        obj1 = javatype;
        if (obj != null)
        {
            obj1 = javatype.withContentValueHandler(obj);
        }
_L2:
        return ((JavaType) (obj1));
_L6:
        Class class1 = _verifyAsClass(obj2, "findContentDeserializer", com/fasterxml/jackson/databind/JsonDeserializer$None);
        if (class1 != null)
        {
            obj = deserializationcontext.deserializerInstance(annotated, class1);
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    protected JsonDeserializer _createAndCache2(DeserializationContext deserializationcontext, DeserializerFactory deserializerfactory, JavaType javatype)
        throws JsonMappingException
    {
        try
        {
            deserializerfactory = _createDeserializer(deserializationcontext, deserializerfactory, javatype);
        }
        // Misplaced declaration of an exception variable
        catch (DeserializationContext deserializationcontext)
        {
            throw new JsonMappingException(deserializationcontext.getMessage(), null, deserializationcontext);
        }
        if (deserializerfactory == null)
        {
            deserializationcontext = null;
        } else
        {
            boolean flag = deserializerfactory instanceof ResolvableDeserializer;
            boolean flag1 = deserializerfactory.isCachable();
            if (flag)
            {
                _incompleteDeserializers.put(javatype, deserializerfactory);
                ((ResolvableDeserializer)deserializerfactory).resolve(deserializationcontext);
                _incompleteDeserializers.remove(javatype);
            }
            deserializationcontext = deserializerfactory;
            if (flag1)
            {
                _cachedDeserializers.put(javatype, deserializerfactory);
                return deserializerfactory;
            }
        }
        return deserializationcontext;
    }

    protected JsonDeserializer _createAndCacheValueDeserializer(DeserializationContext deserializationcontext, DeserializerFactory deserializerfactory, JavaType javatype)
        throws JsonMappingException
    {
        HashMap hashmap = _incompleteDeserializers;
        hashmap;
        JVM INSTR monitorenter ;
        JsonDeserializer jsondeserializer = _findCachedDeserializer(javatype);
        if (jsondeserializer == null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        hashmap;
        JVM INSTR monitorexit ;
        return jsondeserializer;
        int i = _incompleteDeserializers.size();
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        jsondeserializer = (JsonDeserializer)_incompleteDeserializers.get(javatype);
        if (jsondeserializer == null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        hashmap;
        JVM INSTR monitorexit ;
        return jsondeserializer;
        deserializationcontext = _createAndCache2(deserializationcontext, deserializerfactory, javatype);
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        if (_incompleteDeserializers.size() > 0)
        {
            _incompleteDeserializers.clear();
        }
        hashmap;
        JVM INSTR monitorexit ;
        return deserializationcontext;
        deserializationcontext;
        hashmap;
        JVM INSTR monitorexit ;
        throw deserializationcontext;
        deserializationcontext;
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_129;
        }
        if (_incompleteDeserializers.size() > 0)
        {
            _incompleteDeserializers.clear();
        }
        throw deserializationcontext;
    }

    protected JsonDeserializer _createDeserializer(DeserializationContext deserializationcontext, DeserializerFactory deserializerfactory, JavaType javatype)
        throws JsonMappingException
    {
        Object obj;
        DeserializationConfig deserializationconfig;
label0:
        {
            deserializationconfig = deserializationcontext.getConfig();
            if (!javatype.isAbstract() && !javatype.isMapLikeType())
            {
                obj = javatype;
                if (!javatype.isCollectionLikeType())
                {
                    break label0;
                }
            }
            obj = deserializerfactory.mapAbstractType(deserializationconfig, javatype);
        }
        javatype = deserializationconfig.introspect(((JavaType) (obj)));
        Object obj1 = findDeserializerFromAnnotation(deserializationcontext, javatype.getClassInfo());
        if (obj1 != null)
        {
            return ((JsonDeserializer) (obj1));
        }
        JavaType javatype1 = modifyTypeByAnnotation(deserializationcontext, javatype.getClassInfo(), ((JavaType) (obj)));
        obj1 = obj;
        if (javatype1 != obj)
        {
            obj1 = javatype1;
            javatype = deserializationconfig.introspect(javatype1);
        }
        obj = javatype.findPOJOBuilder();
        if (obj != null)
        {
            return deserializerfactory.createBuilderBasedDeserializer(deserializationcontext, ((JavaType) (obj1)), javatype, ((Class) (obj)));
        }
        if (((JavaType) (obj1)).isEnumType())
        {
            return deserializerfactory.createEnumDeserializer(deserializationcontext, ((JavaType) (obj1)), javatype);
        }
        if (((JavaType) (obj1)).isContainerType())
        {
            if (((JavaType) (obj1)).isArrayType())
            {
                return deserializerfactory.createArrayDeserializer(deserializationcontext, (ArrayType)obj1, javatype);
            }
            if (((JavaType) (obj1)).isMapLikeType())
            {
                MapLikeType mapliketype = (MapLikeType)obj1;
                if (mapliketype.isTrueMapType())
                {
                    return deserializerfactory.createMapDeserializer(deserializationcontext, (MapType)mapliketype, javatype);
                } else
                {
                    return deserializerfactory.createMapLikeDeserializer(deserializationcontext, mapliketype, javatype);
                }
            }
            if (((JavaType) (obj1)).isCollectionLikeType())
            {
                com.fasterxml.jackson.annotation.JsonFormat.Value value = javatype.findExpectedFormat(null);
                if (value == null || value.getShape() != com.fasterxml.jackson.annotation.JsonFormat.Shape.OBJECT)
                {
                    CollectionLikeType collectionliketype = (CollectionLikeType)obj1;
                    if (collectionliketype.isTrueCollectionType())
                    {
                        return deserializerfactory.createCollectionDeserializer(deserializationcontext, (CollectionType)collectionliketype, javatype);
                    } else
                    {
                        return deserializerfactory.createCollectionLikeDeserializer(deserializationcontext, collectionliketype, javatype);
                    }
                }
            }
        }
        if (com/fasterxml/jackson/databind/JsonNode.isAssignableFrom(((JavaType) (obj1)).getRawClass()))
        {
            return deserializerfactory.createTreeDeserializer(deserializationconfig, ((JavaType) (obj1)), javatype);
        } else
        {
            return deserializerfactory.createBeanDeserializer(deserializationcontext, ((JavaType) (obj1)), javatype);
        }
    }

    protected JsonDeserializer _findCachedDeserializer(JavaType javatype)
    {
        if (javatype == null)
        {
            throw new IllegalArgumentException("Null JavaType passed");
        } else
        {
            return (JsonDeserializer)_cachedDeserializers.get(javatype);
        }
    }

    protected KeyDeserializer _handleUnknownKeyDeserializer(JavaType javatype)
        throws JsonMappingException
    {
        throw new JsonMappingException((new StringBuilder()).append("Can not find a (Map) Key deserializer for type ").append(javatype).toString());
    }

    protected JsonDeserializer _handleUnknownValueDeserializer(JavaType javatype)
        throws JsonMappingException
    {
        if (!ClassUtil.isConcrete(javatype.getRawClass()))
        {
            throw new JsonMappingException((new StringBuilder()).append("Can not find a Value deserializer for abstract type ").append(javatype).toString());
        } else
        {
            throw new JsonMappingException((new StringBuilder()).append("Can not find a Value deserializer for type ").append(javatype).toString());
        }
    }

    protected JsonDeserializer findDeserializerFromAnnotation(DeserializationContext deserializationcontext, Annotated annotated)
        throws JsonMappingException
    {
        Object obj = deserializationcontext.getAnnotationIntrospector().findDeserializer(annotated);
        if (obj == null)
        {
            return null;
        } else
        {
            return deserializationcontext.deserializerInstance(annotated, obj);
        }
    }

    public KeyDeserializer findKeyDeserializer(DeserializationContext deserializationcontext, DeserializerFactory deserializerfactory, JavaType javatype)
        throws JsonMappingException
    {
        KeyDeserializer keydeserializer = deserializerfactory.createKeyDeserializer(deserializationcontext, javatype);
        if (keydeserializer == null)
        {
            deserializerfactory = _handleUnknownKeyDeserializer(javatype);
        } else
        {
            deserializerfactory = keydeserializer;
            if (keydeserializer instanceof ResolvableDeserializer)
            {
                ((ResolvableDeserializer)keydeserializer).resolve(deserializationcontext);
                return keydeserializer;
            }
        }
        return deserializerfactory;
    }

    public JsonDeserializer findValueDeserializer(DeserializationContext deserializationcontext, DeserializerFactory deserializerfactory, JavaType javatype)
        throws JsonMappingException
    {
        JsonDeserializer jsondeserializer = _findCachedDeserializer(javatype);
        if (jsondeserializer != null)
        {
            return jsondeserializer;
        }
        deserializerfactory = _createAndCacheValueDeserializer(deserializationcontext, deserializerfactory, javatype);
        deserializationcontext = deserializerfactory;
        if (deserializerfactory == null)
        {
            deserializationcontext = _handleUnknownValueDeserializer(javatype);
        }
        return deserializationcontext;
    }
}
