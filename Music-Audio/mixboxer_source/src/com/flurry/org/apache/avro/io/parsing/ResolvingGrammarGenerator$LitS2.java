// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.io.parsing;

import com.flurry.org.apache.avro.Schema;

// Referenced classes of package com.flurry.org.apache.avro.io.parsing:
//            ResolvingGrammarGenerator

static class expected extends expected
{

    public Schema expected;

    public boolean equals(Object obj)
    {
        if (obj instanceof expected)
        {
            if (actual == ((actual) (obj = (actual)obj)).actual && expected == ((expected) (obj)).expected)
            {
                return true;
            }
        }
        return false;
    }

    public int hashCode()
    {
        return super.hashCode() + expected.hashCode();
    }

    public (Schema schema, Schema schema1)
    {
        super(schema);
        expected = schema1;
    }
}
