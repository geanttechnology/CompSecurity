// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.generic;

import com.flurry.org.apache.avro.Schema;

// Referenced classes of package com.flurry.org.apache.avro.generic:
//            GenericEnumSymbol, GenericData

public static class symbol
    implements GenericEnumSymbol
{

    private Schema schema;
    private String symbol;

    public boolean equals(Object obj)
    {
        while (obj == this || (obj instanceof GenericEnumSymbol) && symbol.equals(obj.toString())) 
        {
            return true;
        }
        return false;
    }

    public Schema getSchema()
    {
        return schema;
    }

    public int hashCode()
    {
        return symbol.hashCode();
    }

    public String toString()
    {
        return symbol;
    }

    public (Schema schema1, String s)
    {
        schema = schema1;
        symbol = s;
    }
}
