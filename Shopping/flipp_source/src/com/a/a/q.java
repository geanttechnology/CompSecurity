// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a;

import com.a.a.a.b;
import java.io.UnsupportedEncodingException;

public final class q
{

    public final String a;

    private q(String s)
    {
        a = s;
    }

    public static q a(String s, String s1)
    {
        try
        {
            s = b.b((new StringBuilder()).append(s).append(":").append(s1).toString().getBytes("ISO-8859-1"));
            s = new q((new StringBuilder("Basic ")).append(s).toString());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new AssertionError();
        }
        return s;
    }

    public final boolean equals(Object obj)
    {
        return (obj instanceof q) && ((q)obj).a.equals(a);
    }

    public final int hashCode()
    {
        return a.hashCode();
    }

    public final String toString()
    {
        return a;
    }
}
