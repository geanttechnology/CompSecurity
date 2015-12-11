// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            xh

public static class <init>
{

    private final Map a;
    private a b;

    public <init> a()
    {
        return new <init>(a, b, null);
    }

    public b a(b b1)
    {
        b = b1;
        return this;
    }

    public b a(String s, b b1)
    {
        a.put(s, b1);
        return this;
    }

    private ()
    {
        a = new HashMap();
    }

    ( )
    {
        this();
    }
}
