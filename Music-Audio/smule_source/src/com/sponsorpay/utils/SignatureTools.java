// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

// Referenced classes of package com.sponsorpay.utils:
//            SponsorPayLogger

public class SignatureTools
{

    public static final String NO_SHA1_RESULT = "nosha1";
    private static final String SHA1_ALGORITHM = "SHA1";

    public SignatureTools()
    {
    }

    public static String byteArray2Hex(byte abyte0[])
    {
        Formatter formatter = new Formatter();
        int j = abyte0.length;
        int i = 0;
        do
        {
            if (i >= j)
            {
                abyte0 = formatter.toString();
                formatter.close();
                return abyte0;
            }
            formatter.format("%02x", new Object[] {
                Byte.valueOf(abyte0[i])
            });
            i++;
        } while (true);
    }

    public static String generateSHA1ForString(String s)
    {
        try
        {
            s = byteArray2Hex(MessageDigest.getInstance("SHA1").digest(s.getBytes()));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            SponsorPayLogger.e("UrlBuilder", "SHA1 algorithm not available.", s);
            return "nosha1";
        }
        return s;
    }

    public static String generateSignatureForParameters(Map map, String s)
    {
        Object obj = new TreeSet();
        ((TreeSet) (obj)).addAll(map.keySet());
        Iterator iterator = ((TreeSet) (obj)).iterator();
        obj = "";
        do
        {
            if (!iterator.hasNext())
            {
                return generateSignatureForString(((String) (obj)), s);
            }
            String s1 = (String)iterator.next();
            String s2 = (String)map.get(s1);
            obj = (new StringBuilder(String.valueOf(obj))).append(String.format("%s=%s&", new Object[] {
                s1, s2
            })).toString();
        } while (true);
    }

    public static String generateSignatureForString(String s, String s1)
    {
        return generateSHA1ForString((new StringBuilder(String.valueOf(s))).append(s1).toString());
    }
}
