// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro;

import com.flurry.org.codehaus.jackson.JsonGenerator;
import java.io.IOException;

// Referenced classes of package com.flurry.org.apache.avro:
//            Schema

private static class elementType extends Schema
{

    private final Schema elementType;

    int computeHash()
    {
        return super.computeHash() + elementType.computeHash();
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof elementType))
            {
                return false;
            }
            obj = (elementType)obj;
            if (!equalCachedHash(((Schema) (obj))) || !elementType.equals(((elementType) (obj)).elementType) || !props.((() (obj)).props))
            {
                return false;
            }
        }
        return true;
    }

    public Schema getElementType()
    {
        return elementType;
    }

    void toJson(elementType elementtype, JsonGenerator jsongenerator)
        throws IOException
    {
        jsongenerator.writeStartObject();
        jsongenerator.writeStringField("type", "array");
        jsongenerator.writeFieldName("items");
        elementType.toJson(elementtype, jsongenerator);
        props.props(jsongenerator);
        jsongenerator.writeEndObject();
    }

    public (Schema schema)
    {
        super();
        elementType = schema;
    }
}
