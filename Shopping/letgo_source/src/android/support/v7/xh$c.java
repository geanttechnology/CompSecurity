// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.Collections;
import java.util.List;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            xh

public static class <init>
{

    private final List a;
    private final Map b;
    private final String c;
    private final int d;

    public static <init> a()
    {
        return new <init>(null);
    }

    public List b()
    {
        return a;
    }

    public String c()
    {
        return c;
    }

    public Map d()
    {
        return b;
    }

    public String toString()
    {
        return (new StringBuilder()).append("Rules: ").append(b()).append("  Macros: ").append(b).toString();
    }

    private (List list, Map map, String s, int i)
    {
        a = Collections.unmodifiableList(list);
        b = Collections.unmodifiableMap(map);
        c = s;
        d = i;
    }

    d(List list, Map map, String s, int i, d d1)
    {
        this(list, map, s, i);
    }
}
