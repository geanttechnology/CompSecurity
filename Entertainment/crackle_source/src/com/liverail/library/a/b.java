// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.liverail.library.a;


// Referenced classes of package com.liverail.library.a:
//            c

public class b
{

    private final c a;
    private String b;

    public b(c c1)
    {
        this(c1, null);
    }

    public b(c c1, String s)
    {
        a = c1;
        b = s;
    }

    public int a()
    {
        return a.w;
    }

    public String b()
    {
        if (b != null)
        {
            return (new StringBuilder(String.valueOf(a.x))).append('\n').append(b).toString();
        } else
        {
            return a.x;
        }
    }

    public String toString()
    {
        return (new StringBuilder(String.valueOf(a.w))).append(": ").append(b()).toString();
    }
}
