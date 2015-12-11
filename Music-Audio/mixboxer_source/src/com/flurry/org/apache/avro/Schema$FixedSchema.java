// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro;

import com.flurry.org.codehaus.jackson.JsonGenerator;
import java.io.IOException;

// Referenced classes of package com.flurry.org.apache.avro:
//            Schema

private static class size extends size
{

    private final int size;

    int computeHash()
    {
        return super.computeHash() + size;
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof size))
            {
                return false;
            }
            obj = (size)obj;
            if (!equalCachedHash(((Schema) (obj))) || !equalNames(((equalNames) (obj))) || size != ((size) (obj)).size || !props.((() (obj)).props))
            {
                return false;
            }
        }
        return true;
    }

    public int getFixedSize()
    {
        return size;
    }

    void toJson(size size1, JsonGenerator jsongenerator)
        throws IOException
    {
        if (writeNameRef(size1, jsongenerator))
        {
            return;
        }
        jsongenerator.writeStartObject();
        jsongenerator.writeStringField("type", "fixed");
        writeName(size1, jsongenerator);
        if (getDoc() != null)
        {
            jsongenerator.writeStringField("doc", getDoc());
        }
        jsongenerator.writeNumberField("size", size);
        props.props(jsongenerator);
        aliasesToJson(jsongenerator);
        jsongenerator.writeEndObject();
    }

    public ( , String s, int i)
    {
        super(<init>, , s);
        if (i < 0)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid fixed size: ").append(i).toString());
        } else
        {
            size = i;
            return;
        }
    }
}
