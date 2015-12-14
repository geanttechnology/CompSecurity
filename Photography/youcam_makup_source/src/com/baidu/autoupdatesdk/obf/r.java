// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk.obf;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

// Referenced classes of package com.baidu.autoupdatesdk.obf:
//            t

public class r
{

    private static String c = "UTF-8";
    protected ConcurrentHashMap a;
    protected ConcurrentHashMap b;

    public r()
    {
        d();
    }

    public r(String s, String s1)
    {
        d();
        a(s, s1);
    }

    public r(Map map)
    {
        d();
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); a((String)entry.getKey(), (String)entry.getValue()))
        {
            entry = (java.util.Map.Entry)map.next();
        }

    }

    private void d()
    {
        a = new ConcurrentHashMap();
        b = new ConcurrentHashMap();
    }

    HttpEntity a()
    {
        Object obj;
        if (!b.isEmpty())
        {
            t t1 = new t();
            java.util.Map.Entry entry;
            for (Iterator iterator = a.entrySet().iterator(); iterator.hasNext(); t1.a((String)entry.getKey(), (String)entry.getValue()))
            {
                entry = (java.util.Map.Entry)iterator.next();
            }

            int j = b.entrySet().size();
            Iterator iterator1 = b.entrySet().iterator();
            int i = 0;
            do
            {
                obj = t1;
                if (!iterator1.hasNext())
                {
                    break;
                }
                obj = (java.util.Map.Entry)iterator1.next();
                a a1 = (a)((java.util.Map.Entry) (obj)).getValue();
                if (a1.a != null)
                {
                    boolean flag;
                    if (i == j - 1)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (a1.c != null)
                    {
                        t1.a((String)((java.util.Map.Entry) (obj)).getKey(), a1.a(), a1.a, a1.c, flag);
                    } else
                    {
                        t1.a((String)((java.util.Map.Entry) (obj)).getKey(), a1.a(), a1.a, flag);
                    }
                }
                i++;
            } while (true);
        } else
        {
            try
            {
                obj = new UrlEncodedFormEntity(b(), c);
            }
            catch (UnsupportedEncodingException unsupportedencodingexception)
            {
                unsupportedencodingexception.printStackTrace();
                return null;
            }
        }
        return ((HttpEntity) (obj));
    }

    public void a(String s)
    {
        a.remove(s);
        b.remove(s);
    }

    public void a(String s, File file)
    {
        a(s, ((InputStream) (new FileInputStream(file))), file.getName());
    }

    public void a(String s, InputStream inputstream)
    {
        a(s, inputstream, null);
    }

    public void a(String s, InputStream inputstream, String s1)
    {
        a(s, inputstream, s1, null);
    }

    public void a(String s, InputStream inputstream, String s1, String s2)
    {
        if (s != null && inputstream != null)
        {
            b.put(s, new a(inputstream, s1, s2));
        }
    }

    public void a(String s, String s1)
    {
        if (s != null && s1 != null)
        {
            a.put(s, s1);
        }
    }

    protected List b()
    {
        LinkedList linkedlist = new LinkedList();
        java.util.Map.Entry entry;
        for (Iterator iterator = a.entrySet().iterator(); iterator.hasNext(); linkedlist.add(new BasicNameValuePair((String)entry.getKey(), (String)entry.getValue())))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        return linkedlist;
    }

    protected String c()
    {
        return URLEncodedUtils.format(b(), c);
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        java.util.Map.Entry entry;
        for (Iterator iterator = a.entrySet().iterator(); iterator.hasNext(); stringbuilder.append((String)entry.getValue()))
        {
            entry = (java.util.Map.Entry)iterator.next();
            if (stringbuilder.length() > 0)
            {
                stringbuilder.append("&");
            }
            stringbuilder.append((String)entry.getKey());
            stringbuilder.append("=");
        }

        for (Iterator iterator1 = b.entrySet().iterator(); iterator1.hasNext(); stringbuilder.append("FILE"))
        {
            java.util.Map.Entry entry1 = (java.util.Map.Entry)iterator1.next();
            if (stringbuilder.length() > 0)
            {
                stringbuilder.append("&");
            }
            stringbuilder.append((String)entry1.getKey());
            stringbuilder.append("=");
        }

        return stringbuilder.toString();
    }


    private class a
    {

        public InputStream a;
        public String b;
        public String c;

        public String a()
        {
            if (b != null)
            {
                return b;
            } else
            {
                return "nofilename";
            }
        }

        public a(InputStream inputstream, String s, String s1)
        {
            a = inputstream;
            b = s;
            c = s1;
        }
    }

}
