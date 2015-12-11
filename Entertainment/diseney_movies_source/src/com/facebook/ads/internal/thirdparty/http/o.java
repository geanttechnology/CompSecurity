// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.thirdparty.http;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class o
    implements Map
{

    private Map a;

    public o()
    {
        a = new HashMap();
    }

    public o a(Map map)
    {
        putAll(map);
        return this;
    }

    public String a()
    {
        StringBuilder stringbuilder = new StringBuilder();
        Iterator iterator = a.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            if (stringbuilder.length() > 0)
            {
                stringbuilder.append("&");
            }
            stringbuilder.append(s);
            s = (String)a.get(s);
            if (s != null)
            {
                stringbuilder.append("=");
                try
                {
                    stringbuilder.append(URLEncoder.encode(s, "UTF-8"));
                }
                catch (UnsupportedEncodingException unsupportedencodingexception)
                {
                    unsupportedencodingexception.printStackTrace();
                }
            }
        } while (true);
        return stringbuilder.toString();
    }

    public String a(Object obj)
    {
        return (String)a.get(obj);
    }

    public String a(String s, String s1)
    {
        return (String)a.put(s, s1);
    }

    public String b(Object obj)
    {
        return (String)a.remove(obj);
    }

    public byte[] b()
    {
        byte abyte0[];
        try
        {
            abyte0 = a().getBytes("UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            unsupportedencodingexception.printStackTrace();
            return null;
        }
        return abyte0;
    }

    public void clear()
    {
        a.clear();
    }

    public boolean containsKey(Object obj)
    {
        return a.containsKey(obj);
    }

    public boolean containsValue(Object obj)
    {
        return a.containsValue(obj);
    }

    public Set entrySet()
    {
        return a.entrySet();
    }

    public Object get(Object obj)
    {
        return a(obj);
    }

    public boolean isEmpty()
    {
        return a.isEmpty();
    }

    public Set keySet()
    {
        return a.keySet();
    }

    public Object put(Object obj, Object obj1)
    {
        return a((String)obj, (String)obj1);
    }

    public void putAll(Map map)
    {
        a.putAll(map);
    }

    public Object remove(Object obj)
    {
        return b(obj);
    }

    public int size()
    {
        return a.size();
    }

    public Collection values()
    {
        return a.values();
    }
}
