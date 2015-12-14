// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dropbox.client2;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Locale;

public final class RESTUtility
{

    public static String a(String s, String s1, String as[])
    {
        String s2 = s1;
        if (!s1.startsWith("/"))
        {
            s2 = (new StringBuilder("/")).append(s1).toString();
        }
        try
        {
            s1 = URLEncoder.encode((new StringBuilder("/1")).append(s2).toString(), "UTF-8").replace("%2F", "/");
            s1 = (new StringBuilder()).append(s1).append("?").append(a(as)).toString().replace("+", "%20").replace("*", "%2A");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return (new StringBuilder("https://")).append(s).append(":443").append(s1).toString();
    }

    private static String a(String as[])
    {
        String s;
        boolean flag;
        int i;
        if (as.length % 2 != 0)
        {
            throw new IllegalArgumentException("Params must have an even number of elements.");
        }
        s = "";
        flag = true;
        i = 0;
_L3:
        String s1 = s;
        if (i >= as.length)
        {
            break MISSING_BLOCK_LABEL_132;
        }
        boolean flag1;
        flag1 = flag;
        s1 = s;
        if (as[i + 1] == null)
        {
            break MISSING_BLOCK_LABEL_134;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        flag = false;
_L1:
        s1 = (new StringBuilder()).append(s).append(URLEncoder.encode(as[i], "UTF-8")).append("=").append(URLEncoder.encode(as[i + 1], "UTF-8")).toString();
        flag1 = flag;
        break MISSING_BLOCK_LABEL_134;
        s = (new StringBuilder()).append(s).append("&").toString();
          goto _L1
        as;
        s1 = null;
        return s1;
        i += 2;
        flag = flag1;
        s = s1;
        if (true) goto _L3; else goto _L2
_L2:
    }

    static 
    {
        new SimpleDateFormat("EEE, dd MMM yyyy kk:mm:ss ZZZZZ", Locale.US);
    }
}
