// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class WeblabUtil
{

    public WeblabUtil()
    {
    }

    public static String createWeblabCookie(Map map)
    {
        if (map.isEmpty())
        {
            return null;
        }
        StringBuilder stringbuilder = new StringBuilder(256);
        stringbuilder.append('"');
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); stringbuilder.append((String)entry.getKey()).append(":").append((String)entry.getValue()))
        {
            entry = (java.util.Map.Entry)map.next();
            if (stringbuilder.length() > 1)
            {
                stringbuilder.append("&");
            }
        }

        stringbuilder.append('"');
        return stringbuilder.toString();
    }

    public static String getWeblabCookieName()
    {
        return "experiment";
    }
}
