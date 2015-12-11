// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;

// Referenced classes of package com.fasterxml.jackson.databind.jsontype.impl:
//            TypeSerializerBase

public class AsArrayTypeSerializer extends TypeSerializerBase
{

    public AsArrayTypeSerializer(TypeIdResolver typeidresolver, BeanProperty beanproperty)
    {
        super(typeidresolver, beanproperty);
    }

    public volatile TypeSerializer forProperty(BeanProperty beanproperty)
    {
        return forProperty(beanproperty);
    }

    public AsArrayTypeSerializer forProperty(BeanProperty beanproperty)
    {
        if (_property == beanproperty)
        {
            return this;
        } else
        {
            return new AsArrayTypeSerializer(_idResolver, beanproperty);
        }
    }

    public com.fasterxml.jackson.annotation.JsonTypeInfo.As getTypeInclusion()
    {
        return com.fasterxml.jackson.annotation.JsonTypeInfo.As.WRAPPER_ARRAY;
    }

    public void writeCustomTypePrefixForArray(Object obj, JsonGenerator jsongenerator, String s)
        throws IOException, JsonProcessingException
    {
        if (jsongenerator.canWriteTypeId())
        {
            jsongenerator.writeTypeId(s);
        } else
        {
            jsongenerator.writeStartArray();
            jsongenerator.writeString(s);
        }
        jsongenerator.writeStartArray();
    }

    public void writeCustomTypePrefixForObject(Object obj, JsonGenerator jsongenerator, String s)
        throws IOException, JsonProcessingException
    {
        if (jsongenerator.canWriteTypeId())
        {
            jsongenerator.writeTypeId(s);
        } else
        {
            jsongenerator.writeStartArray();
            jsongenerator.writeString(s);
        }
        jsongenerator.writeStartObject();
    }

    public void writeCustomTypePrefixForScalar(Object obj, JsonGenerator jsongenerator, String s)
        throws IOException, JsonProcessingException
    {
        if (jsongenerator.canWriteTypeId())
        {
            jsongenerator.writeTypeId(s);
            return;
        } else
        {
            jsongenerator.writeStartArray();
            jsongenerator.writeString(s);
            return;
        }
    }

    public void writeCustomTypeSuffixForArray(Object obj, JsonGenerator jsongenerator, String s)
        throws IOException, JsonProcessingException
    {
        if (!jsongenerator.canWriteTypeId())
        {
            writeTypeSuffixForArray(obj, jsongenerator);
        }
    }

    public void writeCustomTypeSuffixForObject(Object obj, JsonGenerator jsongenerator, String s)
        throws IOException, JsonProcessingException
    {
        if (!jsongenerator.canWriteTypeId())
        {
            writeTypeSuffixForObject(obj, jsongenerator);
        }
    }

    public void writeCustomTypeSuffixForScalar(Object obj, JsonGenerator jsongenerator, String s)
        throws IOException, JsonProcessingException
    {
        if (!jsongenerator.canWriteTypeId())
        {
            writeTypeSuffixForScalar(obj, jsongenerator);
        }
    }

    public void writeTypePrefixForArray(Object obj, JsonGenerator jsongenerator)
        throws IOException, JsonProcessingException
    {
        obj = idFromValue(obj);
        if (jsongenerator.canWriteTypeId())
        {
            jsongenerator.writeTypeId(obj);
        } else
        {
            jsongenerator.writeStartArray();
            jsongenerator.writeString(((String) (obj)));
        }
        jsongenerator.writeStartArray();
    }

    public void writeTypePrefixForArray(Object obj, JsonGenerator jsongenerator, Class class1)
        throws IOException, JsonProcessingException
    {
        obj = idFromValueAndType(obj, class1);
        if (jsongenerator.canWriteTypeId())
        {
            jsongenerator.writeTypeId(obj);
        } else
        {
            jsongenerator.writeStartArray();
            jsongenerator.writeString(((String) (obj)));
        }
        jsongenerator.writeStartArray();
    }

    public void writeTypePrefixForObject(Object obj, JsonGenerator jsongenerator)
        throws IOException, JsonProcessingException
    {
        obj = idFromValue(obj);
        if (jsongenerator.canWriteTypeId())
        {
            jsongenerator.writeTypeId(obj);
        } else
        {
            jsongenerator.writeStartArray();
            jsongenerator.writeString(((String) (obj)));
        }
        jsongenerator.writeStartObject();
    }

    public void writeTypePrefixForObject(Object obj, JsonGenerator jsongenerator, Class class1)
        throws IOException, JsonProcessingException
    {
        obj = idFromValueAndType(obj, class1);
        if (jsongenerator.canWriteTypeId())
        {
            jsongenerator.writeTypeId(obj);
        } else
        {
            jsongenerator.writeStartArray();
            jsongenerator.writeString(((String) (obj)));
        }
        jsongenerator.writeStartObject();
    }

    public void writeTypePrefixForScalar(Object obj, JsonGenerator jsongenerator)
        throws IOException, JsonProcessingException
    {
        obj = idFromValue(obj);
        if (jsongenerator.canWriteTypeId())
        {
            jsongenerator.writeTypeId(obj);
            return;
        } else
        {
            jsongenerator.writeStartArray();
            jsongenerator.writeString(((String) (obj)));
            return;
        }
    }

    public void writeTypePrefixForScalar(Object obj, JsonGenerator jsongenerator, Class class1)
        throws IOException, JsonProcessingException
    {
        obj = idFromValueAndType(obj, class1);
        if (jsongenerator.canWriteTypeId())
        {
            jsongenerator.writeTypeId(obj);
            return;
        } else
        {
            jsongenerator.writeStartArray();
            jsongenerator.writeString(((String) (obj)));
            return;
        }
    }

    public void writeTypeSuffixForArray(Object obj, JsonGenerator jsongenerator)
        throws IOException, JsonProcessingException
    {
        jsongenerator.writeEndArray();
        if (!jsongenerator.canWriteTypeId())
        {
            jsongenerator.writeEndArray();
        }
    }

    public void writeTypeSuffixForObject(Object obj, JsonGenerator jsongenerator)
        throws IOException, JsonProcessingException
    {
        jsongenerator.writeEndObject();
        if (!jsongenerator.canWriteTypeId())
        {
            jsongenerator.writeEndArray();
        }
    }

    public void writeTypeSuffixForScalar(Object obj, JsonGenerator jsongenerator)
        throws IOException, JsonProcessingException
    {
        if (!jsongenerator.canWriteTypeId())
        {
            jsongenerator.writeEndArray();
        }
    }
}
