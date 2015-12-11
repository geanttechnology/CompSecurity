// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.io.parsing;

import com.flurry.org.apache.avro.Schema;

// Referenced classes of package com.flurry.org.apache.avro.io.parsing:
//            ValidatingGrammarGenerator

static class actual
{

    public final Schema actual;

    public boolean equals(Object obj)
    {
        while (!(obj instanceof actual) || actual != ((actual)obj).actual) 
        {
            return false;
        }
        return true;
    }

    public int hashCode()
    {
        return actual.hashCode();
    }

    public (Schema schema)
    {
        actual = schema;
    }
}
