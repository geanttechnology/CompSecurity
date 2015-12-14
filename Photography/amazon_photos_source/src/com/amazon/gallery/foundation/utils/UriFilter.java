// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils;

import org.apache.commons.lang3.StringUtils;

public class UriFilter
{

    public static String filter(String s)
    {
        String s1 = s;
        if (s != null)
        {
            s1 = s;
            if (s.startsWith("/photos/api/media/create/CUSTOMER_ID/"))
            {
                s1 = (new StringBuilder()).append("/photos/api/media/create/CUSTOMER_ID/").append(StringUtils.repeat('*', s.length() - "/photos/api/media/create/CUSTOMER_ID/".length())).toString();
            }
        }
        return s1;
    }
}
