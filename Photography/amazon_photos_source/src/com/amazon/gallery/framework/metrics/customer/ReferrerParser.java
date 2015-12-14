// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.metrics.customer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;

public class ReferrerParser
{

    private static final Map KEYS;

    private static String parseRefKey(String s, String s1)
    {
        String as[] = StringUtils.substringsBetween(s, s1, "&");
        if (as != null && as.length > 0)
        {
            s = as[0];
        } else
        {
            s1 = StringUtils.substringAfter(s, s1);
            s = s1;
            if ("".equals(s1))
            {
                return null;
            }
        }
        return s;
    }

    public static String parseRefString(String s)
    {
        String s1 = null;
        Iterator iterator = KEYS.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s2 = (String)iterator.next();
            String s3 = parseRefKey(s, s2);
            if (s3 != null)
            {
                if (s1 != null)
                {
                    s1 = (new StringBuilder()).append(s1).append("&").toString();
                } else
                {
                    s1 = "";
                }
                s1 = (new StringBuilder()).append(s1).append((String)KEYS.get(s2)).append(s3).toString();
            }
        } while (true);
        return s1;
    }

    static 
    {
        KEYS = new HashMap();
        KEYS.put("creative=", "creative=");
        KEYS.put("ref=", "ref=");
        KEYS.put("ref_=", "ref=");
    }
}
