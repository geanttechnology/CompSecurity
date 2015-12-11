// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Base64;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public final class cne
{

    private final SortedMap a = new TreeMap();

    public cne()
    {
    }

    public final cne a(String s, int i)
    {
        a.put(s, String.format("%d", new Object[] {
            Integer.valueOf(i)
        }));
        return this;
    }

    public final cne a(String s, String s1)
    {
        a.put(s, s1);
        return this;
    }

    public final cne a(String s, boolean flag)
    {
        a.put(s, String.format("%b", new Object[] {
            Boolean.valueOf(flag)
        }));
        return this;
    }

    public final cne a(String s, byte abyte0[])
    {
        b.a(abyte0);
        a.put(s, Base64.encodeToString(abyte0, 0));
        return this;
    }

    public final String a()
    {
        Object obj = a.entrySet();
        StringBuilder stringbuilder = new StringBuilder();
        for (obj = ((Set) (obj)).iterator(); ((Iterator) (obj)).hasNext(); stringbuilder.append("/"))
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator) (obj)).next();
            stringbuilder.append((String)entry.getKey());
            stringbuilder.append(":");
            stringbuilder.append((String)entry.getValue());
        }

        return stringbuilder.toString();
    }
}
