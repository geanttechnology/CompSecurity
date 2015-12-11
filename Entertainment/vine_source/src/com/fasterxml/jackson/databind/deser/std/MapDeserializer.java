// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.ContextualKeyDeserializer;
import com.fasterxml.jackson.databind.deser.ResolvableDeserializer;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedCreator;
import com.fasterxml.jackson.databind.deser.impl.PropertyValueBuffer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Map;

// Referenced classes of package com.fasterxml.jackson.databind.deser.std:
//            ContainerDeserializerBase

public class MapDeserializer extends ContainerDeserializerBase
    implements ContextualDeserializer, ResolvableDeserializer
{

    private static final long serialVersionUID = 0xd11c9bd2fbfb27d0L;
    protected JsonDeserializer _delegateDeserializer;
    protected final boolean _hasDefaultCreator;
    protected HashSet _ignorableProperties;
    protected final KeyDeserializer _keyDeserializer;
    protected final JavaType _mapType;
    protected PropertyBasedCreator _propertyBasedCreator;
    protected boolean _standardStringKey;
    protected final JsonDeserializer _valueDeserializer;
    protected final ValueInstantiator _valueInstantiator;
    protected final TypeDeserializer _valueTypeDeserializer;

    public MapDeserializer(JavaType javatype, ValueInstantiator valueinstantiator, KeyDeserializer keydeserializer, JsonDeserializer jsondeserializer, TypeDeserializer typedeserializer)
    {
        super(javatype);
        _mapType = javatype;
        _keyDeserializer = keydeserializer;
        _valueDeserializer = jsondeserializer;
        _valueTypeDeserializer = typedeserializer;
        _valueInstantiator = valueinstantiator;
        _hasDefaultCreator = valueinstantiator.canCreateUsingDefault();
        _delegateDeserializer = null;
        _propertyBasedCreator = null;
        _standardStringKey = _isStdKeyDeser(javatype, keydeserializer);
    }

    protected MapDeserializer(MapDeserializer mapdeserializer)
    {
        super(mapdeserializer._mapType);
        _mapType = mapdeserializer._mapType;
        _keyDeserializer = mapdeserializer._keyDeserializer;
        _valueDeserializer = mapdeserializer._valueDeserializer;
        _valueTypeDeserializer = mapdeserializer._valueTypeDeserializer;
        _valueInstantiator = mapdeserializer._valueInstantiator;
        _propertyBasedCreator = mapdeserializer._propertyBasedCreator;
        _delegateDeserializer = mapdeserializer._delegateDeserializer;
        _hasDefaultCreator = mapdeserializer._hasDefaultCreator;
        _ignorableProperties = mapdeserializer._ignorableProperties;
        _standardStringKey = mapdeserializer._standardStringKey;
    }

    protected MapDeserializer(MapDeserializer mapdeserializer, KeyDeserializer keydeserializer, JsonDeserializer jsondeserializer, TypeDeserializer typedeserializer, HashSet hashset)
    {
        super(mapdeserializer._mapType);
        _mapType = mapdeserializer._mapType;
        _keyDeserializer = keydeserializer;
        _valueDeserializer = jsondeserializer;
        _valueTypeDeserializer = typedeserializer;
        _valueInstantiator = mapdeserializer._valueInstantiator;
        _propertyBasedCreator = mapdeserializer._propertyBasedCreator;
        _delegateDeserializer = mapdeserializer._delegateDeserializer;
        _hasDefaultCreator = mapdeserializer._hasDefaultCreator;
        _ignorableProperties = hashset;
        _standardStringKey = _isStdKeyDeser(_mapType, keydeserializer);
    }

    public Map _deserializeUsingCreator(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        PropertyBasedCreator propertybasedcreator = _propertyBasedCreator;
        PropertyValueBuffer propertyvaluebuffer = propertybasedcreator.startBuilding(jsonparser, deserializationcontext, null);
        Object obj1 = jsonparser.getCurrentToken();
        Object obj = obj1;
        if (obj1 == JsonToken.START_OBJECT)
        {
            obj = jsonparser.nextToken();
        }
        obj1 = _valueDeserializer;
        TypeDeserializer typedeserializer = _valueTypeDeserializer;
        while (obj == JsonToken.FIELD_NAME) 
        {
            Object obj2 = jsonparser.getCurrentName();
            obj = jsonparser.nextToken();
            if (_ignorableProperties != null && _ignorableProperties.contains(obj2))
            {
                jsonparser.skipChildren();
            } else
            {
                obj2 = propertybasedcreator.findCreatorProperty(((String) (obj2)));
                if (obj2 != null)
                {
                    obj = ((SettableBeanProperty) (obj2)).deserialize(jsonparser, deserializationcontext);
                    if (propertyvaluebuffer.assignParameter(((SettableBeanProperty) (obj2)).getCreatorIndex(), obj))
                    {
                        jsonparser.nextToken();
                        try
                        {
                            obj = (Map)propertybasedcreator.build(deserializationcontext, propertyvaluebuffer);
                        }
                        // Misplaced declaration of an exception variable
                        catch (JsonParser jsonparser)
                        {
                            wrapAndThrow(jsonparser, _mapType.getRawClass());
                            return null;
                        }
                        _readAndBind(jsonparser, deserializationcontext, ((Map) (obj)));
                        return ((Map) (obj));
                    }
                } else
                {
                    Object obj3 = jsonparser.getCurrentName();
                    obj3 = _keyDeserializer.deserializeKey(((String) (obj3)), deserializationcontext);
                    if (obj == JsonToken.VALUE_NULL)
                    {
                        obj = null;
                    } else
                    if (typedeserializer == null)
                    {
                        obj = ((JsonDeserializer) (obj1)).deserialize(jsonparser, deserializationcontext);
                    } else
                    {
                        obj = ((JsonDeserializer) (obj1)).deserializeWithType(jsonparser, deserializationcontext, typedeserializer);
                    }
                    propertyvaluebuffer.bufferMapProperty(obj3, obj);
                }
            }
            obj = jsonparser.nextToken();
        }
        try
        {
            jsonparser = (Map)propertybasedcreator.build(deserializationcontext, propertyvaluebuffer);
        }
        // Misplaced declaration of an exception variable
        catch (JsonParser jsonparser)
        {
            wrapAndThrow(jsonparser, _mapType.getRawClass());
            return null;
        }
        return jsonparser;
    }

    protected final boolean _isStdKeyDeser(JavaType javatype, KeyDeserializer keydeserializer)
    {
        if (keydeserializer != null)
        {
            if ((javatype = javatype.getKeyType()) != null && ((javatype = javatype.getRawClass()) != java/lang/String && javatype != java/lang/Object || !isDefaultKeyDeserializer(keydeserializer)))
            {
                return false;
            }
        }
        return true;
    }

    protected final void _readAndBind(JsonParser jsonparser, DeserializationContext deserializationcontext, Map map)
        throws IOException, JsonProcessingException
    {
        Object obj2 = jsonparser.getCurrentToken();
        Object obj = obj2;
        if (obj2 == JsonToken.START_OBJECT)
        {
            obj = jsonparser.nextToken();
        }
        obj2 = _keyDeserializer;
        JsonDeserializer jsondeserializer = _valueDeserializer;
        TypeDeserializer typedeserializer = _valueTypeDeserializer;
        while (obj == JsonToken.FIELD_NAME) 
        {
            obj = jsonparser.getCurrentName();
            Object obj3 = ((KeyDeserializer) (obj2)).deserializeKey(((String) (obj)), deserializationcontext);
            JsonToken jsontoken = jsonparser.nextToken();
            if (_ignorableProperties != null && _ignorableProperties.contains(obj))
            {
                jsonparser.skipChildren();
            } else
            {
                Object obj1;
                if (jsontoken == JsonToken.VALUE_NULL)
                {
                    obj1 = null;
                } else
                if (typedeserializer == null)
                {
                    obj1 = jsondeserializer.deserialize(jsonparser, deserializationcontext);
                } else
                {
                    obj1 = jsondeserializer.deserializeWithType(jsonparser, deserializationcontext, typedeserializer);
                }
                map.put(obj3, obj1);
            }
            obj = jsonparser.nextToken();
        }
    }

    protected final void _readAndBindStringMap(JsonParser jsonparser, DeserializationContext deserializationcontext, Map map)
        throws IOException, JsonProcessingException
    {
        Object obj1 = jsonparser.getCurrentToken();
        Object obj = obj1;
        if (obj1 == JsonToken.START_OBJECT)
        {
            obj = jsonparser.nextToken();
        }
        obj1 = _valueDeserializer;
        TypeDeserializer typedeserializer = _valueTypeDeserializer;
        while (obj == JsonToken.FIELD_NAME) 
        {
            String s = jsonparser.getCurrentName();
            obj = jsonparser.nextToken();
            if (_ignorableProperties != null && _ignorableProperties.contains(s))
            {
                jsonparser.skipChildren();
            } else
            {
                if (obj == JsonToken.VALUE_NULL)
                {
                    obj = null;
                } else
                if (typedeserializer == null)
                {
                    obj = ((JsonDeserializer) (obj1)).deserialize(jsonparser, deserializationcontext);
                } else
                {
                    obj = ((JsonDeserializer) (obj1)).deserializeWithType(jsonparser, deserializationcontext, typedeserializer);
                }
                map.put(s, obj);
            }
            obj = jsonparser.nextToken();
        }
    }

    public JsonDeserializer createContextual(DeserializationContext deserializationcontext, BeanProperty beanproperty)
        throws JsonMappingException
    {
        Object obj;
        Object obj1;
        TypeDeserializer typedeserializer;
label0:
        {
            obj1 = _keyDeserializer;
            Object obj2;
            if (obj1 == null)
            {
                obj = deserializationcontext.findKeyDeserializer(_mapType.getKeyType(), beanproperty);
            } else
            {
                obj = obj1;
                if (obj1 instanceof ContextualKeyDeserializer)
                {
                    obj = ((ContextualKeyDeserializer)obj1).createContextual(deserializationcontext, beanproperty);
                }
            }
            obj1 = findConvertingContentDeserializer(deserializationcontext, beanproperty, _valueDeserializer);
            if (obj1 == null)
            {
                obj1 = deserializationcontext.findContextualValueDeserializer(_mapType.getContentType(), beanproperty);
            } else
            {
                obj1 = deserializationcontext.handleSecondaryContextualization(((JsonDeserializer) (obj1)), beanproperty);
            }
            obj2 = _valueTypeDeserializer;
            typedeserializer = ((TypeDeserializer) (obj2));
            if (obj2 != null)
            {
                typedeserializer = ((TypeDeserializer) (obj2)).forProperty(beanproperty);
            }
            obj2 = _ignorableProperties;
            deserializationcontext = deserializationcontext.getAnnotationIntrospector();
            if (deserializationcontext != null && beanproperty != null)
            {
                String as[] = deserializationcontext.findPropertiesToIgnore(beanproperty.getMember());
                if (as != null)
                {
                    int i;
                    int j;
                    if (obj2 == null)
                    {
                        deserializationcontext = new HashSet();
                    } else
                    {
                        deserializationcontext = new HashSet(((java.util.Collection) (obj2)));
                    }
                    j = as.length;
                    i = 0;
                    do
                    {
                        beanproperty = deserializationcontext;
                        if (i >= j)
                        {
                            break;
                        }
                        deserializationcontext.add(as[i]);
                        i++;
                    } while (true);
                    break label0;
                }
            }
            beanproperty = ((BeanProperty) (obj2));
        }
        return withResolved(((KeyDeserializer) (obj)), typedeserializer, ((JsonDeserializer) (obj1)), beanproperty);
    }

    public volatile Object deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        return deserialize(jsonparser, deserializationcontext);
    }

    public volatile Object deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext, Object obj)
        throws IOException, JsonProcessingException
    {
        return deserialize(jsonparser, deserializationcontext, (Map)obj);
    }

    public Map deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        if (_propertyBasedCreator != null)
        {
            return _deserializeUsingCreator(jsonparser, deserializationcontext);
        }
        if (_delegateDeserializer != null)
        {
            return (Map)_valueInstantiator.createUsingDelegate(deserializationcontext, _delegateDeserializer.deserialize(jsonparser, deserializationcontext));
        }
        if (!_hasDefaultCreator)
        {
            throw deserializationcontext.instantiationException(getMapClass(), "No default constructor found");
        }
        Object obj = jsonparser.getCurrentToken();
        if (obj != JsonToken.START_OBJECT && obj != JsonToken.FIELD_NAME && obj != JsonToken.END_OBJECT)
        {
            if (obj == JsonToken.VALUE_STRING)
            {
                return (Map)_valueInstantiator.createFromString(deserializationcontext, jsonparser.getText());
            } else
            {
                throw deserializationcontext.mappingException(getMapClass());
            }
        }
        obj = (Map)_valueInstantiator.createUsingDefault(deserializationcontext);
        if (_standardStringKey)
        {
            _readAndBindStringMap(jsonparser, deserializationcontext, ((Map) (obj)));
            return ((Map) (obj));
        } else
        {
            _readAndBind(jsonparser, deserializationcontext, ((Map) (obj)));
            return ((Map) (obj));
        }
    }

    public Map deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext, Map map)
        throws IOException, JsonProcessingException
    {
        JsonToken jsontoken = jsonparser.getCurrentToken();
        if (jsontoken != JsonToken.START_OBJECT && jsontoken != JsonToken.FIELD_NAME)
        {
            throw deserializationcontext.mappingException(getMapClass());
        }
        if (_standardStringKey)
        {
            _readAndBindStringMap(jsonparser, deserializationcontext, map);
            return map;
        } else
        {
            _readAndBind(jsonparser, deserializationcontext, map);
            return map;
        }
    }

    public Object deserializeWithType(JsonParser jsonparser, DeserializationContext deserializationcontext, TypeDeserializer typedeserializer)
        throws IOException, JsonProcessingException
    {
        return typedeserializer.deserializeTypedFromObject(jsonparser, deserializationcontext);
    }

    public JsonDeserializer getContentDeserializer()
    {
        return _valueDeserializer;
    }

    public JavaType getContentType()
    {
        return _mapType.getContentType();
    }

    public final Class getMapClass()
    {
        return _mapType.getRawClass();
    }

    public JavaType getValueType()
    {
        return _mapType;
    }

    public void resolve(DeserializationContext deserializationcontext)
        throws JsonMappingException
    {
        if (_valueInstantiator.canCreateUsingDelegate())
        {
            JavaType javatype = _valueInstantiator.getDelegateType(deserializationcontext.getConfig());
            if (javatype == null)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Invalid delegate-creator definition for ").append(_mapType).append(": value instantiator (").append(_valueInstantiator.getClass().getName()).append(") returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'").toString());
            }
            _delegateDeserializer = findDeserializer(deserializationcontext, javatype, null);
        }
        if (_valueInstantiator.canCreateFromObjectWith())
        {
            SettableBeanProperty asettablebeanproperty[] = _valueInstantiator.getFromObjectArguments(deserializationcontext.getConfig());
            _propertyBasedCreator = PropertyBasedCreator.construct(deserializationcontext, _valueInstantiator, asettablebeanproperty);
        }
        _standardStringKey = _isStdKeyDeser(_mapType, _keyDeserializer);
    }

    public void setIgnorableProperties(String as[])
    {
        if (as == null || as.length == 0)
        {
            as = null;
        } else
        {
            as = ArrayBuilders.arrayToSet(as);
        }
        _ignorableProperties = as;
    }

    protected MapDeserializer withResolved(KeyDeserializer keydeserializer, TypeDeserializer typedeserializer, JsonDeserializer jsondeserializer, HashSet hashset)
    {
        if (_keyDeserializer == keydeserializer && _valueDeserializer == jsondeserializer && _valueTypeDeserializer == typedeserializer && _ignorableProperties == hashset)
        {
            return this;
        } else
        {
            return new MapDeserializer(this, keydeserializer, jsondeserializer, typedeserializer, hashset);
        }
    }

    protected void wrapAndThrow(Throwable throwable, Object obj)
        throws IOException
    {
        for (; (throwable instanceof InvocationTargetException) && throwable.getCause() != null; throwable = throwable.getCause()) { }
        if (throwable instanceof Error)
        {
            throw (Error)throwable;
        }
        if ((throwable instanceof IOException) && !(throwable instanceof JsonMappingException))
        {
            throw (IOException)throwable;
        } else
        {
            throw JsonMappingException.wrapWithPath(throwable, obj, null);
        }
    }
}
