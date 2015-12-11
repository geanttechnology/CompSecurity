// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.damnhandy.uri.template;

import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.util.BitSet;

public final class UriUtil
{

    private static final BitSet FRAGMENT_ALLOWED_CHARS;
    private static final BitSet GENERAL_ALLOWED_CHARS;
    private static final BitSet RESERVED_ALLOWED_CHARS;

    private static void add(BitSet bitset, String s)
    {
        s = s.toCharArray();
        int j = s.length;
        for (int i = 0; i < j; i++)
        {
            char c = s[i];
            if (c >= '\177')
            {
                throw new IllegalArgumentException("Bitset only works correct with one byte");
            }
            bitset.set(c);
        }

    }

    public static String encode(String s)
    {
        return encode(s, GENERAL_ALLOWED_CHARS);
    }

    private static String encode(String s, BitSet bitset)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream(s.length());
        Charset charset = Charset.forName("UTF-8");
        s = s.getBytes(charset);
        int i = 0;
        while (i < s.length) 
        {
            char c1 = s[i];
            if (bitset.get(c1 & 0xff))
            {
                bytearrayoutputstream.write(c1);
            } else
            {
                bytearrayoutputstream.write(37);
                char c = Character.toUpperCase(Character.forDigit(c1 >> 4 & 0xf, 16));
                c1 = Character.toUpperCase(Character.forDigit(c1 & 0xf, 16));
                bytearrayoutputstream.write(c);
                bytearrayoutputstream.write(c1);
            }
            i++;
        }
        return new String(bytearrayoutputstream.toByteArray(), charset);
    }

    public static String encodeFragment(String s)
    {
        return encode(s, FRAGMENT_ALLOWED_CHARS);
    }

    public static String encodeReserved(String s)
    {
        return encode(s, RESERVED_ALLOWED_CHARS);
    }

    static 
    {
        GENERAL_ALLOWED_CHARS = new BitSet();
        FRAGMENT_ALLOWED_CHARS = new BitSet();
        RESERVED_ALLOWED_CHARS = new BitSet();
        String s = (new StringBuilder()).append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz").append("0123456789").append("-._~").toString();
        String s1 = (new StringBuilder()).append("!$&'()*+,;=").append(":/?#[]@").toString();
        String s2 = (new StringBuilder()).append(s).append("!$&'()*+,;=").append(":@/?").toString();
        add(GENERAL_ALLOWED_CHARS, s);
        add(FRAGMENT_ALLOWED_CHARS, s2);
        add(RESERVED_ALLOWED_CHARS, s);
        add(RESERVED_ALLOWED_CHARS, s1);
    }
}
