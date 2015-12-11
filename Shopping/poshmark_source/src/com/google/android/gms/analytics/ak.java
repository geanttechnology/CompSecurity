// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

class ak
{

    private static final char uR[] = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        'A', 'B', 'C', 'D', 'E', 'F'
    };

    public static Map I(String s1)
    {
        HashMap hashmap = new HashMap();
        s1 = s1.split("&");
        int j = s1.length;
        int i = 0;
        while (i < j) 
        {
            String as[] = s1[i].split("=");
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

    public static String J(String s1)
    {
        if (TextUtils.isEmpty(s1))
        {
            return null;
        }
        Object obj = s1;
        if (s1.contains("?"))
        {
            String as[] = s1.split("[\\?]");
            obj = s1;
            if (as.length > 1)
            {
                obj = as[1];
            }
        }
        StringBuilder stringbuilder;
        if (((String) (obj)).contains("%3D"))
        {
            try
            {
                s1 = URLDecoder.decode(((String) (obj)), "UTF-8");
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                return null;
            }
        } else
        {
            s1 = ((String) (obj));
            if (!((String) (obj)).contains("="))
            {
                return null;
            }
        }
        s1 = I(s1);
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
        stringbuilder = new StringBuilder();
        for (int i = 0; i < obj.length; i++)
        {
            if (!TextUtils.isEmpty((CharSequence)s1.get(obj[i])))
            {
                if (stringbuilder.length() > 0)
                {
                    stringbuilder.append("&");
                }
                stringbuilder.append(obj[i]).append("=").append((String)s1.get(obj[i]));
            }
        }

        return stringbuilder.toString();
    }

    public static double a(String s1, double d1)
    {
        if (s1 == null)
        {
            return d1;
        }
        double d2;
        try
        {
            d2 = Double.parseDouble(s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            return d1;
        }
        return d2;
    }

    static String a(Locale locale)
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

    public static void a(Map map, String s1, String s2)
    {
        if (!map.containsKey(s1))
        {
            map.put(s1, s2);
        }
    }

    public static boolean d(String s1, boolean flag)
    {
        boolean flag1 = flag;
        if (s1 == null) goto _L2; else goto _L1
_L1:
        if (!s1.equalsIgnoreCase("true") && !s1.equalsIgnoreCase("yes") && !s1.equalsIgnoreCase("1")) goto _L4; else goto _L3
_L3:
        flag1 = true;
_L2:
        return flag1;
_L4:
        if (s1.equalsIgnoreCase("false") || s1.equalsIgnoreCase("no"))
        {
            break; /* Loop/switch isn't completed */
        }
        flag1 = flag;
        if (!s1.equalsIgnoreCase("0")) goto _L2; else goto _L5
_L5:
        return false;
    }

    static String s(boolean flag)
    {
        if (flag)
        {
            return "1";
        } else
        {
            return "0";
        }
    }

}
