// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.io.parsing;

import java.util.Map;

// Referenced classes of package com.flurry.org.apache.avro.io.parsing:
//            Symbol

public static class <init> extends <init>
{

    public final Symbol reader;
    public final Symbol writer;

    public <init> flatten(Map map, Map map1)
    {
        return new <init>(writer.flatten(map, map1), reader.flatten(map, map1));
    }

    public volatile Symbol flatten(Map map, Map map1)
    {
        return flatten(map, map1);
    }

    private (Symbol symbol, Symbol symbol1)
    {
        super(null);
        writer = symbol;
        reader = symbol1;
    }

    reader(Symbol symbol, Symbol symbol1, reader reader1)
    {
        this(symbol, symbol1);
    }
}
