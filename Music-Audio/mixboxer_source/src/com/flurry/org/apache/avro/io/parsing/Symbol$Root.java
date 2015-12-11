// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.io.parsing;

import java.util.HashMap;

// Referenced classes of package com.flurry.org.apache.avro.io.parsing:
//            Symbol

protected static class <init> extends Symbol
{

    private static Symbol[] makeProduction(Symbol asymbol[])
    {
        Symbol asymbol1[] = new Symbol[flattenedSize(asymbol, 0) + 1];
        flatten(asymbol, 0, asymbol1, 1, new HashMap(), new HashMap());
        return asymbol1;
    }

    private transient (Symbol asymbol[])
    {
        super(ROOT, makeProduction(asymbol));
        production[0] = this;
    }

    production(Symbol asymbol[], production production)
    {
        this(asymbol);
    }
}
