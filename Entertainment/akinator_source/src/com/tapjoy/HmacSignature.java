// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import android.net.Uri;
import android.util.Log;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HmacSignature
{

    private String a;
    private String b;

    public HmacSignature(String s, String s1)
    {
        a = s;
        b = s1;
    }

    private static String a(Map map)
    {
        Object obj = new TreeSet(map.keySet());
        StringBuilder stringbuilder = new StringBuilder();
        String s;
        String s1;
        for (obj = ((TreeSet) (obj)).iterator(); ((Iterator) (obj)).hasNext(); stringbuilder.append((new StringBuilder()).append(s).append("=").append(s1).append("&").toString()))
        {
            s = (String)((Iterator) (obj)).next();
            s1 = (String)map.get(s);
        }

        stringbuilder.deleteCharAt(stringbuilder.lastIndexOf("&"));
        Log.v("HmacSignature", (new StringBuilder("Unhashed String: ")).append(stringbuilder.toString()).toString());
        return stringbuilder.toString();
    }

    public boolean matches(String s, Map map, String s1)
    {
        return sign(s, map).equals(s1);
    }

    public String sign(String s, Map map)
    {
        boolean flag = false;
        Object obj;
        Mac mac;
        Uri uri;
        obj = new SecretKeySpec(b.getBytes(), a);
        mac = Mac.getInstance(a);
        mac.init(((java.security.Key) (obj)));
        uri = Uri.parse(s);
        obj = (new StringBuilder()).append(uri.getScheme()).append("://").append(uri.getHost()).toString();
        int i;
        int j;
        if (uri.getScheme().equals("http") && uri.getPort() == 80 || uri.getScheme().equals("https") && uri.getPort() == 443)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        s = ((String) (obj));
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_171;
        }
        s = ((String) (obj));
        if (-1 != uri.getPort())
        {
            s = (new StringBuilder()).append(((String) (obj))).append(":").append(uri.getPort()).toString();
        }
        s = s.toLowerCase();
        s = (new StringBuilder()).append(s).append(uri.getPath()).toString();
        map = a(map);
        s = (new StringBuilder("POST&")).append(Uri.encode(s)).append("&").append(Uri.encode(map)).toString();
        Log.v("HmacSignature", (new StringBuilder("Base Url: ")).append(s).toString());
        s = mac.doFinal(s.getBytes());
        map = new StringBuilder();
        j = s.length;
        i = ((flag) ? 1 : 0);
        while (i < j) 
        {
            try
            {
                obj = Integer.toHexString(s[i] & 0xff);
                if (((String) (obj)).length() == 1)
                {
                    map.append('0');
                }
                map.append(((String) (obj)));
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return null;
            }
            i++;
        }
        s = map.toString();
        return s;
    }
}
