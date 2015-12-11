// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.util;

import com.gotv.crackle.ApplicationConstants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class CrackleHMAC
{

    public CrackleHMAC()
    {
    }

    private static String byteToString(byte abyte0[])
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (int i = 0; i < abyte0.length; i++)
        {
            stringbuilder.append(Integer.toString((abyte0[i] & 0xff) + 256, 16).substring(1));
        }

        return stringbuilder.toString().toUpperCase();
    }

    private static String calcHmac(String s)
        throws Exception
    {
        SecretKeySpec secretkeyspec = new SecretKeySpec(ApplicationConstants.getVendorKey().getBytes(), "HmacMD5");
        Mac mac = Mac.getInstance("HmacMD5");
        mac.init(secretkeyspec);
        return byteToString(mac.doFinal(s.getBytes()));
    }

    private static String createTimeStampString(Date date)
    {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyyMMddHHmm");
        simpledateformat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpledateformat.format(date);
    }

    public static String encodeURL(String s)
    {
        String s1 = createTimeStampString(new Date());
        s = (new StringBuilder()).append(s).append("|").append(s1).toString();
        try
        {
            s = (new StringBuilder()).append(calcHmac(s)).append("|").append(s1).append("|").append(ApplicationConstants.getVendorID()).toString();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        return s;
    }
}
