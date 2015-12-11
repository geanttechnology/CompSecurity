// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.commonscodecandroid.binary;

import java.io.UnsupportedEncodingException;

public class StringUtils
{

    public StringUtils()
    {
    }

    private static IllegalStateException newIllegalStateException(String s, UnsupportedEncodingException unsupportedencodingexception)
    {
        return new IllegalStateException(s + ": " + unsupportedencodingexception);
    }

    public static String newString(byte abyte0[], String s)
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
            throw newIllegalStateException(s, abyte0);
        }
        return abyte0;
    }

    public static String newStringUsAscii(byte abyte0[])
    {
        return newString(abyte0, "US-ASCII");
    }

    public static String newStringUtf8(byte abyte0[])
    {
        return newString(abyte0, "UTF-8");
    }
}
