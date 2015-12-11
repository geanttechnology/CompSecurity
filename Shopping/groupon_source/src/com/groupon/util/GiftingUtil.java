// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import java.net.MalformedURLException;
import java.net.URL;
import roboguice.util.Ln;

public class GiftingUtil
{

    private GiftingUtil()
    {
    }

    public static String getDomain(String s)
    {
        Object obj;
        if (s == null)
        {
            return null;
        }
        obj = null;
        StringBuilder stringbuilder;
        s = (new URL(s)).getHost().split("\\.");
        stringbuilder = new StringBuilder();
        int i = 2;
_L2:
        if (i >= s.length)
        {
            break; /* Loop/switch isn't completed */
        }
        stringbuilder.append(".").append(s[i]);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        if (stringbuilder.length() == 0)
        {
            s = null;
        } else
        {
            try
            {
                s = stringbuilder.toString();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Ln.e(s);
                s = obj;
            }
        }
        return s;
    }
}
