// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.io.parsing;

import java.util.Map;

// Referenced classes of package com.flurry.org.apache.avro.io.parsing:
//            Symbol

public static class <init> extends Symbol
{

    public final Symbol end;

    private static Symbol[] makeProduction(Symbol asymbol[])
    {
        Symbol asymbol1[] = new Symbol[asymbol.length + 1];
        System.arraycopy(asymbol, 0, asymbol1, 1, asymbol.length);
        return asymbol1;
    }

    public <init> flatten(Map map, Map map1)
    {
        <init> <init>1 = new <init>(end, new Symbol[flattenedSize(production, 1)]);
        flatten(production, 1, <init>1.production, 1, map, map1);
        return <init>1;
    }

    public volatile Symbol flatten(Map map, Map map1)
    {
        return flatten(map, map1);
    }

    private transient (Symbol symbol, Symbol asymbol[])
    {
        super(ATER, makeProduction(asymbol));
        end = symbol;
        production[0] = this;
    }

    production(Symbol symbol, Symbol asymbol[], production production)
    {
        this(symbol, asymbol);
    }
}
