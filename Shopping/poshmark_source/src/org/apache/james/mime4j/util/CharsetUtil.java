// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.util;

import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;

public class CharsetUtil
{

    public static final int CR = 13;
    public static final String CRLF = "\r\n";
    public static final Charset DEFAULT_CHARSET;
    public static final int HT = 9;
    public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    public static final int LF = 10;
    public static final int SP = 32;
    public static final Charset US_ASCII;
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    public CharsetUtil()
    {
    }

    public static boolean isASCII(char c)
    {
        return (0xff80 & c) == 0;
    }

    public static boolean isASCII(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("String may not be null");
        }
        int j = s.length();
        for (int i = 0; i < j; i++)
        {
            if (!isASCII(s.charAt(i)))
            {
                return false;
            }
        }

        return true;
    }

    public static boolean isWhitespace(char c)
    {
        return c == ' ' || c == '\t' || c == '\r' || c == '\n';
    }

    public static boolean isWhitespace(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("String may not be null");
        }
        int j = s.length();
        for (int i = 0; i < j; i++)
        {
            if (!isWhitespace(s.charAt(i)))
            {
                return false;
            }
        }

        return true;
    }

    public static Charset lookup(String s)
    {
        if (s == null)
        {
            return null;
        }
        try
        {
            s = Charset.forName(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    static 
    {
        US_ASCII = Charset.forName("US-ASCII");
        DEFAULT_CHARSET = US_ASCII;
    }
}
