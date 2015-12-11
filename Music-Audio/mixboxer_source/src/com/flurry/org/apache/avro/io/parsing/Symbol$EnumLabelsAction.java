// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.io.parsing;

import java.util.List;

// Referenced classes of package com.flurry.org.apache.avro.io.parsing:
//            Symbol

public static class symbols extends symbols
{

    public final List symbols;

    public int findLabel(String s)
    {
        if (s != null)
        {
            for (int i = 0; i < symbols.size(); i++)
            {
                if (s.equals(symbols.get(i)))
                {
                    return i;
                }
            }

        }
        return -1;
    }

    public String getLabel(int i)
    {
        return (String)symbols.get(i);
    }

    public (List list)
    {
        super(list.size());
        symbols = list;
    }
}
