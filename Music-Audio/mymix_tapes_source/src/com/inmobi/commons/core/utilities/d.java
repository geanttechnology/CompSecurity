// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.core.utilities;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.inmobi.commons.a.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class d
{

    public static String a(String s)
    {
        try
        {
            s = URLEncoder.encode(s, "UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return "";
        }
        return s;
    }

    public static String a(Map map, String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        String s1;
        for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); stringbuilder.append(String.format(Locale.US, "%s=%s", new Object[] {
    a(s1), a(map.get(s1).toString())
})))
        {
            s1 = (String)iterator.next();
            if (stringbuilder.length() > 0)
            {
                stringbuilder.append(s);
            }
        }

        return stringbuilder.toString();
    }

    public static void a(Map map)
    {
        if (map != null)
        {
            Iterator iterator = map.entrySet().iterator();
            HashMap hashmap = new HashMap();
            while (iterator.hasNext()) 
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                if (entry.getValue() == null || ((String)entry.getValue()).trim().length() == 0 || entry.getKey() == null || ((String)entry.getKey()).trim().length() == 0)
                {
                    iterator.remove();
                } else
                if (!((String)entry.getKey()).equals(((String)entry.getKey()).trim()))
                {
                    iterator.remove();
                    hashmap.put(((String)entry.getKey()).trim(), ((String)entry.getValue()).trim());
                } else
                {
                    hashmap.put(entry.getKey(), ((String)entry.getValue()).trim());
                }
            }
            map.putAll(hashmap);
        }
    }

    public static boolean a()
    {
        NetworkInfo networkinfo = ((ConnectivityManager)com.inmobi.commons.a.a.b().getSystemService("connectivity")).getActiveNetworkInfo();
        return networkinfo != null && networkinfo.isConnected();
    }
}
