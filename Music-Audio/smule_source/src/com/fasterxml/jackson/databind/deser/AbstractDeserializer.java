// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.deser.impl.ReadableObjectId;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.io.Serializable;
import java.util.Map;

// Referenced classes of package com.fasterxml.jackson.databind.deser:
//            BeanDeserializerBuilder, SettableBeanProperty

public class AbstractDeserializer extends JsonDeserializer
    implements Serializable
{

    protected final boolean _acceptBoolean;
    protected final boolean _acceptDouble;
    protected final boolean _acceptInt;
    protected final boolean _acceptString;
    protected final Map _backRefProperties;
    protected final JavaType _baseType;
    protected final ObjectIdReader _objectIdReader;

    protected AbstractDeserializer(BeanDescription beandescription)
    {
label0:
        {
            boolean flag1 = false;
            super();
            _baseType = beandescription.getType();
            _objectIdReader = null;
            _backRefProperties = null;
            beandescription = _baseType.getRawClass();
            _acceptString = beandescription.isAssignableFrom(java/lang/String);
            boolean flag;
            if (beandescription == Boolean.TYPE || beandescription.isAssignableFrom(java/lang/Boolean))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            _acceptBoolean = flag;
            if (beandescription == Integer.TYPE || beandescription.isAssignableFrom(java/lang/Integer))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            _acceptInt = flag;
            if (beandescription != Double.TYPE)
            {
                flag = flag1;
                if (!beandescription.isAssignableFrom(java/lang/Double))
                {
                    break label0;
                }
            }
            flag = true;
        }
        _acceptDouble = flag;
    }

    public AbstractDeserializer(BeanDeserializerBuilder beandeserializerbuilder, BeanDescription beandescription, Map map)
    {
label0:
        {
            boolean flag1 = false;
            super();
            _baseType = beandescription.getType();
            _objectIdReader = beandeserializerbuilder.getObjectIdReader();
            _backRefProperties = map;
            beandeserializerbuilder = _baseType.getRawClass();
            _acceptString = beandeserializerbuilder.isAssignableFrom(java/lang/String);
            boolean flag;
            if (beandeserializerbuilder == Boolean.TYPE || beandeserializerbuilder.isAssignableFrom(java/lang/Boolean))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            _acceptBoolean = flag;
            if (beandeserializerbuilder == Integer.TYPE || beandeserializerbuilder.isAssignableFrom(java/lang/Integer))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            _acceptInt = flag;
            if (beandeserializerbuilder != Double.TYPE)
            {
                flag = flag1;
                if (!beandeserializerbuilder.isAssignableFrom(java/lang/Double))
                {
                    break label0;
                }
            }
            flag = true;
        }
        _acceptDouble = flag;
    }

    public static AbstractDeserializer constructForNonPOJO(BeanDescription beandescription)
    {
        return new AbstractDeserializer(beandescription);
    }

    protected Object _deserializeFromObjectId(JsonParser jsonparser, DeserializationContext deserializationcontext)
    {
        jsonparser = ((JsonParser) (_objectIdReader.readObjectReference(jsonparser, deserializationcontext)));
        deserializationcontext = ((DeserializationContext) (deserializationcontext.findObjectId(jsonparser, _objectIdReader.generator, _objectIdReader.resolver).resolve()));
        if (deserializationcontext == null)
        {
            throw new IllegalStateException((new StringBuilder()).append("Could not resolve Object Id [").append(jsonparser).append("] -- unresolved forward-reference?").toString());
        } else
        {
            return deserializationcontext;
        }
    }

    protected Object _deserializeIfNatural(JsonParser jsonparser, DeserializationContext deserializationcontext)
    {
        deserializationcontext = jsonparser.getCurrentToken();
        if (deserializationcontext.isScalarValue())
        {
            if (deserializationcontext == JsonToken.VALUE_STRING)
            {
                if (_acceptString)
                {
                    return jsonparser.getText();
                }
            } else
            if (deserializationcontext == JsonToken.VALUE_NUMBER_INT)
            {
                if (_acceptInt)
                {
                    return Integer.valueOf(jsonparser.getIntValue());
                }
            } else
            if (deserializationcontext == JsonToken.VALUE_NUMBER_FLOAT)
            {
                if (_acceptDouble)
                {
                    return Double.valueOf(jsonparser.getDoubleValue());
                }
            } else
            if (deserializationcontext == JsonToken.VALUE_TRUE)
            {
                if (_acceptBoolean)
                {
                    return Boolean.TRUE;
                }
            } else
            if (deserializationcontext == JsonToken.VALUE_FALSE && _acceptBoolean)
            {
                return Boolean.FALSE;
            }
        }
        return null;
    }

    public Object deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
    {
        throw deserializationcontext.instantiationException(_baseType.getRawClass(), "abstract types either need to be mapped to concrete types, have custom deserializer, or be instantiated with additional type information");
    }

    public Object deserializeWithType(JsonParser jsonparser, DeserializationContext deserializationcontext, TypeDeserializer typedeserializer)
    {
        if (_objectIdReader == null) goto _L2; else goto _L1
_L1:
        Object obj = jsonparser.getCurrentToken();
        if (obj == null || !((JsonToken) (obj)).isScalarValue()) goto _L2; else goto _L3
_L3:
        obj = _deserializeFromObjectId(jsonparser, deserializationcontext);
_L5:
        return obj;
_L2:
        Object obj1 = _deserializeIfNatural(jsonparser, deserializationcontext);
        obj = obj1;
        if (obj1 == null)
        {
            return typedeserializer.deserializeTypedFromObject(jsonparser, deserializationcontext);
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    public SettableBeanProperty findBackReference(String s)
    {
        if (_backRefProperties == null)
        {
            return null;
        } else
        {
            return (SettableBeanProperty)_backRefProperties.get(s);
        }
    }

    public ObjectIdReader getObjectIdReader()
    {
        return _objectIdReader;
    }

    public Class handledType()
    {
        return _baseType.getRawClass();
    }

    public boolean isCachable()
    {
        return true;
    }
}
