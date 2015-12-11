// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro;

import com.flurry.org.codehaus.jackson.JsonGenerator;
import java.io.IOException;

// Referenced classes of package com.flurry.org.apache.avro:
//            Schema

private static class valueType extends Schema
{

    private final Schema valueType;

    int computeHash()
    {
        return super.computeHash() + valueType.computeHash();
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof h))
            {
                return false;
            }
            obj = (h)obj;
            if (!equalCachedHash(((Schema) (obj))) || !valueType.equals(((valueType) (obj)).valueType) || !props.ls(((ls) (obj)).props))
            {
                return false;
            }
        }
        return true;
    }

    public Schema getValueType()
    {
        return valueType;
    }

    void toJson(r r, JsonGenerator jsongenerator)
        throws IOException
    {
        jsongenerator.writeStartObject();
        jsongenerator.writeStringField("type", "map");
        jsongenerator.writeFieldName("values");
        valueType.toJson(r, jsongenerator);
        props.e(jsongenerator);
        jsongenerator.writeEndObject();
    }

    public r(Schema schema)
    {
        super(r);
        valueType = schema;
    }
}
