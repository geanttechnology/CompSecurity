// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms.resolver;


class HomeBrewBase64
{

    public static int NO_WRAP = 0;
    private static final String base64code = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
    private static final int splitLinesAt = 76;

    HomeBrewBase64()
    {
    }

    static String encodeToString(byte abyte0[], int i)
    {
        int k = (3 - abyte0.length % 3) % 3;
        byte abyte1[] = zeroPad(abyte0.length + k, abyte0);
        abyte0 = "";
        for (int j = 0; j < abyte1.length; j += 3)
        {
            int l = ((abyte1[j] & 0xff) << 16) + ((abyte1[j + 1] & 0xff) << 8) + (abyte1[j + 2] & 0xff);
            abyte0 = (new StringBuilder()).append(abyte0).append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt(l >> 18 & 0x3f)).append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt(l >> 12 & 0x3f)).append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt(l >> 6 & 0x3f)).append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt(l & 0x3f)).toString();
        }

        return splitLines((new StringBuilder()).append(abyte0.substring(0, abyte0.length() - k)).append("==".substring(0, k)).toString(), i);
    }

    static String splitLines(String s, int i)
    {
        String s1 = "";
        for (int j = 0; j < s.length(); j += 76)
        {
            String s2 = (new StringBuilder()).append(s1).append(s.substring(j, Math.min(s.length(), j + 76))).toString();
            s1 = s2;
            if (i != NO_WRAP)
            {
                s1 = (new StringBuilder()).append(s2).append("\r\n").toString();
            }
        }

        return s1;
    }

    static byte[] zeroPad(int i, byte abyte0[])
    {
        byte abyte1[] = new byte[i];
        System.arraycopy(abyte0, 0, abyte1, 0, abyte0.length);
        return abyte1;
    }

    static 
    {
        NO_WRAP = 1;
    }
}
