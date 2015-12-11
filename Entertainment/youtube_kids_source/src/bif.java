// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.LinkedHashMap;

final class bif extends LinkedHashMap
{

    private bie a;

    bif(bie bie1, int i, float f, boolean flag)
    {
        a = bie1;
        super(i, 0.75F, true);
    }

    protected final boolean removeEldestEntry(java.util.Map.Entry entry)
    {
        if (a.b.size() > a.a)
        {
            a.b(entry.getKey());
        }
        return false;
    }
}
