// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

class Utils
{

    private static final char HEXBYTES[] = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        'A', 'B', 'C', 'D', 'E', 'F'
    };

    Utils()
    {
    }

    public static String filterCampaign(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return null;
        }
        Object obj1 = s;
        Object obj = obj1;
        if (s.contains("?"))
        {
            s = s.split("[\\?]");
            obj = obj1;
            if (s.length > 1)
            {
                obj = s[1];
            }
        }
        if (((String) (obj)).contains("%3D"))
        {
            try
            {
                s = URLDecoder.decode(((String) (obj)), "UTF-8");
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return null;
            }
        } else
        {
            s = ((String) (obj));
            if (!((String) (obj)).contains("="))
            {
                return null;
            }
        }
        s = parseURLParameters(s);
        obj = new String[9];
        obj[0] = "dclid";
        obj[1] = "utm_source";
        obj[2] = "gclid";
        obj[3] = "utm_campaign";
        obj[4] = "utm_medium";
        obj[5] = "utm_term";
        obj[6] = "utm_content";
        obj[7] = "utm_id";
        obj[8] = "gmob_t";
        obj1 = new StringBuilder();
        for (int i = 0; i < obj.length; i++)
        {
            if (!TextUtils.isEmpty((CharSequence)s.get(obj[i])))
            {
                if (((StringBuilder) (obj1)).length() > 0)
                {
                    ((StringBuilder) (obj1)).append("&");
                }
                ((StringBuilder) (obj1)).append(obj[i]).append("=").append((String)s.get(obj[i]));
            }
        }

        return ((StringBuilder) (obj1)).toString();
    }

    static int fromHexDigit(char c)
    {
        int i = c - 48;
        c = i;
        if (i > 9)
        {
            c = i - 7;
        }
        return c;
    }

    static String getLanguage(Locale locale)
    {
        while (locale == null || TextUtils.isEmpty(locale.getLanguage())) 
        {
            return null;
        }
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(locale.getLanguage().toLowerCase());
        if (!TextUtils.isEmpty(locale.getCountry()))
        {
            stringbuilder.append("-").append(locale.getCountry().toLowerCase());
        }
        return stringbuilder.toString();
    }

    static byte[] hexDecode(String s)
    {
        byte abyte0[] = new byte[s.length() / 2];
        for (int i = 0; i < abyte0.length; i++)
        {
            abyte0[i] = (byte)(fromHexDigit(s.charAt(i * 2)) << 4 | fromHexDigit(s.charAt(i * 2 + 1)));
        }

        return abyte0;
    }

    static String hexEncode(byte abyte0[])
    {
        char ac[] = new char[abyte0.length * 2];
        for (int i = 0; i < abyte0.length; i++)
        {
            int j = abyte0[i] & 0xff;
            ac[i * 2] = HEXBYTES[j >> 4];
            ac[i * 2 + 1] = HEXBYTES[j & 0xf];
        }

        return new String(ac);
    }

    public static Map parseURLParameters(String s)
    {
        HashMap hashmap = new HashMap();
        s = s.split("&");
        int j = s.length;
        int i = 0;
        while (i < j) 
        {
            String as[] = s[i].split("=");
            if (as.length > 1)
            {
                hashmap.put(as[0], as[1]);
            } else
            if (as.length == 1 && as[0].length() != 0)
            {
                hashmap.put(as[0], null);
            }
            i++;
        }
        return hashmap;
    }

    public static void putIfAbsent(Map map, String s, String s1)
    {
        if (!map.containsKey(s))
        {
            map.put(s, s1);
        }
    }

    public static boolean safeParseBoolean(String s, boolean flag)
    {
        boolean flag1 = flag;
        if (s == null) goto _L2; else goto _L1
_L1:
        if (!s.equalsIgnoreCase("true") && !s.equalsIgnoreCase("yes") && !s.equalsIgnoreCase("1")) goto _L4; else goto _L3
_L3:
        flag1 = true;
_L2:
        return flag1;
_L4:
        if (s.equalsIgnoreCase("false") || s.equalsIgnoreCase("no"))
        {
            break; /* Loop/switch isn't completed */
        }
        flag1 = flag;
        if (!s.equalsIgnoreCase("0")) goto _L2; else goto _L5
_L5:
        return false;
    }

    public static double safeParseDouble(String s)
    {
        return safeParseDouble(s, 0.0D);
    }

    public static double safeParseDouble(String s, double d)
    {
        if (s == null)
        {
            return d;
        }
        double d1;
        try
        {
            d1 = Double.parseDouble(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return d;
        }
        return d1;
    }

    public static long safeParseLong(String s)
    {
        if (s == null)
        {
            return 0L;
        }
        long l;
        try
        {
            l = Long.parseLong(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return 0L;
        }
        return l;
    }

}
