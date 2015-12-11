// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro;

import com.flurry.org.codehaus.jackson.JsonGenerator;
import java.io.IOException;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.flurry.org.apache.avro:
//            Protocol, Schema

private class <init> extends <init>
{

    private Schema errors;
    private Schema response;
    final Protocol this$0;

    public boolean equals(Object obj)
    {
        if (super.(obj) && (obj instanceof ))
        {
            obj = ()obj;
            if (response.equals(((response) (obj)).response) && errors.equals(((errors) (obj)).errors))
            {
                return true;
            }
        }
        return false;
    }

    public Schema getErrors()
    {
        return errors;
    }

    public Schema getResponse()
    {
        return response;
    }

    public int hashCode()
    {
        return super.de() + response.hashCode() + errors.hashCode();
    }

    public boolean isOneWay()
    {
        return false;
    }

    void toJson1(JsonGenerator jsongenerator)
        throws IOException
    {
        jsongenerator.writeFieldName("response");
        response.toJson(Protocol.access$100(Protocol.this), jsongenerator);
        Object obj = errors.getTypes();
        if (((List) (obj)).size() > 1)
        {
            obj = Schema.createUnion(((List) (obj)).subList(1, ((List) (obj)).size()));
            jsongenerator.writeFieldName("errors");
            ((Schema) (obj)).toJson(Protocol.access$100(Protocol.this), jsongenerator);
        }
    }

    private (String s, String s1, Map map, Schema schema, Schema schema1, Schema schema2)
    {
        this$0 = Protocol.this;
        super(Protocol.this, s, s1, map, schema, null);
        response = schema1;
        errors = schema2;
    }

    errors(String s, String s1, Map map, Schema schema, Schema schema1, Schema schema2, 
            errors errors1)
    {
        this(s, s1, map, schema, schema1, schema2);
    }
}
