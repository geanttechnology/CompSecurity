// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.codehaus.jackson.map.jsontype.impl;

import java.io.IOException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.jsontype.TypeIdResolver;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.util.JsonParserSequence;
import org.codehaus.jackson.util.TokenBuffer;

// Referenced classes of package org.codehaus.jackson.map.jsontype.impl:
//            AsArrayTypeDeserializer

public class AsPropertyTypeDeserializer extends AsArrayTypeDeserializer
{

    protected final String _typePropertyName;

    public AsPropertyTypeDeserializer(JavaType javatype, TypeIdResolver typeidresolver, BeanProperty beanproperty, Class class1, String s)
    {
        super(javatype, typeidresolver, beanproperty, class1);
        _typePropertyName = s;
    }

    protected Object _deserializeTypedUsingDefaultImpl(JsonParser jsonparser, DeserializationContext deserializationcontext, TokenBuffer tokenbuffer)
        throws IOException, JsonProcessingException
    {
        if (_defaultImpl != null)
        {
            JsonDeserializer jsondeserializer = _findDefaultImplDeserializer(deserializationcontext);
            JsonParser jsonparser1 = jsonparser;
            if (tokenbuffer != null)
            {
                tokenbuffer.writeEndObject();
                jsonparser1 = tokenbuffer.asParser(jsonparser);
                jsonparser1.nextToken();
            }
            return jsondeserializer.deserialize(jsonparser1, deserializationcontext);
        } else
        {
            throw deserializationcontext.wrongTokenException(jsonparser, JsonToken.FIELD_NAME, (new StringBuilder()).append("missing property '").append(_typePropertyName).append("' that is to contain type id  (for class ").append(baseTypeName()).append(")").toString());
        }
    }

    public Object deserializeTypedFromAny(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        if (jsonparser.getCurrentToken() == JsonToken.START_ARRAY)
        {
            return super.deserializeTypedFromArray(jsonparser, deserializationcontext);
        } else
        {
            return deserializeTypedFromObject(jsonparser, deserializationcontext);
        }
    }

    public Object deserializeTypedFromObject(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        Object obj1 = jsonparser.getCurrentToken();
        Object obj;
        if (obj1 == JsonToken.START_OBJECT)
        {
            obj = jsonparser.nextToken();
        } else
        {
            obj = obj1;
            if (obj1 != JsonToken.FIELD_NAME)
            {
                throw deserializationcontext.wrongTokenException(jsonparser, JsonToken.START_OBJECT, (new StringBuilder()).append("need JSON Object to contain As.PROPERTY type information (for class ").append(baseTypeName()).append(")").toString());
            }
        }
        obj1 = null;
        for (Object obj2 = obj; obj2 == JsonToken.FIELD_NAME;)
        {
            obj2 = jsonparser.getCurrentName();
            jsonparser.nextToken();
            if (_typePropertyName.equals(obj2))
            {
                obj2 = _findDeserializer(deserializationcontext, jsonparser.getText());
                obj = jsonparser;
                if (obj1 != null)
                {
                    obj = JsonParserSequence.createFlattened(((TokenBuffer) (obj1)).asParser(jsonparser), jsonparser);
                }
                ((JsonParser) (obj)).nextToken();
                return ((JsonDeserializer) (obj2)).deserialize(((JsonParser) (obj)), deserializationcontext);
            }
            obj = obj1;
            if (obj1 == null)
            {
                obj = new TokenBuffer(null);
            }
            ((TokenBuffer) (obj)).writeFieldName(((String) (obj2)));
            ((TokenBuffer) (obj)).copyCurrentStructure(jsonparser);
            obj2 = jsonparser.nextToken();
            obj1 = obj;
        }

        return _deserializeTypedUsingDefaultImpl(jsonparser, deserializationcontext, ((TokenBuffer) (obj1)));
    }

    public String getPropertyName()
    {
        return _typePropertyName;
    }

    public org.codehaus.jackson.annotate.JsonTypeInfo.As getTypeInclusion()
    {
        return org.codehaus.jackson.annotate.JsonTypeInfo.As.PROPERTY;
    }
}
