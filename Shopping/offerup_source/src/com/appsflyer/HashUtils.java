// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appsflyer;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.Map;

public class HashUtils
{

    public HashUtils()
    {
    }

    private static String byteToHex(byte abyte0[])
    {
        Formatter formatter = new Formatter();
        int j = abyte0.length;
        for (int i = 0; i < j; i++)
        {
            formatter.format("%02x", new Object[] {
                Byte.valueOf(abyte0[i])
            });
        }

        abyte0 = formatter.toString();
        formatter.close();
        return abyte0;
    }

    public static String toSHA1(String s)
    {
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance("SHA-1");
            messagedigest.reset();
            messagedigest.update(s.getBytes("UTF-8"));
            s = byteToHex(messagedigest.digest());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        return s;
    }

    public String getHashCode(Map map)
    {
        String s = (String)map.get("appsflyerKey");
        String s1 = (String)map.get("af_timestamp");
        map = (String)map.get("uid");
        return toSHA1((new StringBuilder()).append(s.substring(0, 7)).append(map.substring(0, 7)).append(s1.substring(s1.length() - 7)).toString());
    }

    public native String getNativeCode(String s, String s1, String s2);

}
