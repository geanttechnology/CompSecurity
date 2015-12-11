// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.io.parsing;

import java.util.Map;

// Referenced classes of package com.flurry.org.apache.avro.io.parsing:
//            Symbol

public static class <init> extends Symbol
{

    public final String labels[];
    public final Symbol symbols[];

    public int findLabel(String s)
    {
        if (s != null)
        {
            for (int i = 0; i < labels.length; i++)
            {
                if (s.equals(labels[i]))
                {
                    return i;
                }
            }

        }
        return -1;
    }

    public labels flatten(Map map, Map map1)
    {
        Symbol asymbol[] = new Symbol[symbols.length];
        for (int i = 0; i < asymbol.length; i++)
        {
            asymbol[i] = symbols[i].flatten(map, map1);
        }

        return new <init>(asymbol, labels);
    }

    public volatile Symbol flatten(Map map, Map map1)
    {
        return flatten(map, map1);
    }

    public String getLabel(int i)
    {
        return labels[i];
    }

    public Symbol getSymbol(int i)
    {
        return symbols[i];
    }

    public int size()
    {
        return symbols.length;
    }

    private (Symbol asymbol[], String as[])
    {
        super(TIVE);
        symbols = asymbol;
        labels = as;
    }

    labels(Symbol asymbol[], String as[], labels labels1)
    {
        this(asymbol, as);
    }
}
