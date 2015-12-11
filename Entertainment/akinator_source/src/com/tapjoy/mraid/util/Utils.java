// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.mraid.util;

import android.os.Bundle;

public class Utils
{

    public Utils()
    {
    }

    public static String byteToHex(byte byte0)
    {
        char ac[] = new char[16];
        char[] _tmp = ac;
        ac[0] = '0';
        ac[1] = '1';
        ac[2] = '2';
        ac[3] = '3';
        ac[4] = '4';
        ac[5] = '5';
        ac[6] = '6';
        ac[7] = '7';
        ac[8] = '8';
        ac[9] = '9';
        ac[10] = 'a';
        ac[11] = 'b';
        ac[12] = 'c';
        ac[13] = 'd';
        ac[14] = 'e';
        ac[15] = 'f';
        return new String(new char[] {
            ac[byte0 >> 4 & 0xf], ac[byte0 & 0xf]
        });
    }

    public static String convert(String s)
    {
        StringBuffer stringbuffer;
        int i;
        try
        {
            s = s.getBytes();
            stringbuffer = new StringBuffer();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        i = 0;
        if (i >= s.length)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        if ((s[i] & 0x80) <= 0)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        stringbuffer.append((new StringBuilder("%")).append(byteToHex(s[i])).toString());
        break MISSING_BLOCK_LABEL_91;
        stringbuffer.append((char)s[i]);
        break MISSING_BLOCK_LABEL_91;
        s = new String(stringbuffer.toString().getBytes(), "ISO-8859-1");
        return s;
        for (i++; false; i++)
        {
        }

        break MISSING_BLOCK_LABEL_15;
    }

    public static String getData(String s, Bundle bundle)
    {
        return bundle.getString(s);
    }
}
