// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.f.b.a.a.a.a;

import java.io.UnsupportedEncodingException;

public final class c
{

    private static IllegalStateException a(String s, UnsupportedEncodingException unsupportedencodingexception)
    {
        return new IllegalStateException((new StringBuilder()).append(s).append(": ").append(unsupportedencodingexception).toString());
    }

    public static String a(byte abyte0[], String s)
    {
        if (abyte0 == null)
        {
            return null;
        }
        try
        {
            abyte0 = new String(abyte0, s);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw a(s, ((UnsupportedEncodingException) (abyte0)));
        }
        return abyte0;
    }

    public static byte[] a(String s, String s1)
    {
        if (s == null)
        {
            return null;
        }
        try
        {
            s = s.getBytes(s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw a(s1, ((UnsupportedEncodingException) (s)));
        }
        return s;
    }
}
