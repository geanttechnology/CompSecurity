// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.Collections;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            xh

public static class <init>
{

    private final Map a;
    private final toString b;

    public static <init> a()
    {
        return new <init>(null);
    }

    public void a(String s, <init> <init>1)
    {
        a.put(s, <init>1);
    }

    public Map b()
    {
        return Collections.unmodifiableMap(a);
    }

    public a c()
    {
        return b;
    }

    public String toString()
    {
        return (new StringBuilder()).append("Properties: ").append(b()).append(" pushAfterEvaluate: ").append(b).toString();
    }

    private (Map map,  )
    {
        a = map;
        b = ;
    }

    b(Map map, b b1, b b2)
    {
        this(map, b1);
    }
}
