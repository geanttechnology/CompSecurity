// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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

// Referenced classes of package com.a.a.a:
//            o, l

public class k
{

    private static String d = "UTF-8";
    protected ConcurrentHashMap a;
    protected ConcurrentHashMap b;
    protected ConcurrentHashMap c;

    public k()
    {
        d();
    }

    public k(String s, String s1)
    {
        d();
        a(s, s1);
    }

    public k(Map map)
    {
        d();
        map = map.entrySet().iterator();
        do
        {
            if (!map.hasNext())
            {
                return;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
            a((String)entry.getKey(), (String)entry.getValue());
        } while (true);
    }

    public transient k(Object aobj[])
    {
        d();
        int j = aobj.length;
        if (j % 2 != 0)
        {
            throw new IllegalArgumentException("Supplied arguments must be even");
        }
        int i = 0;
        do
        {
            if (i >= j)
            {
                return;
            }
            a(String.valueOf(aobj[i]), String.valueOf(aobj[i + 1]));
            i += 2;
        } while (true);
    }

    private void d()
    {
        a = new ConcurrentHashMap();
        b = new ConcurrentHashMap();
        c = new ConcurrentHashMap();
    }

    public HttpEntity a()
    {
        if (b.isEmpty()) goto _L2; else goto _L1
_L1:
        Object obj;
        Iterator iterator;
        obj = new o();
        iterator = a.entrySet().iterator();
_L10:
        if (iterator.hasNext()) goto _L4; else goto _L3
_L3:
        int i;
        int j;
        j = b.entrySet().size();
        iterator = b.entrySet().iterator();
        i = 0;
_L7:
        if (iterator.hasNext()) goto _L6; else goto _L5
_L5:
        iterator = c.entrySet().iterator();
_L8:
        if (!iterator.hasNext())
        {
            return ((HttpEntity) (obj));
        }
        break MISSING_BLOCK_LABEL_260;
_L4:
        java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
        ((o) (obj)).a((String)entry.getKey(), (String)entry.getValue());
        continue; /* Loop/switch isn't completed */
_L6:
        java.util.Map.Entry entry1 = (java.util.Map.Entry)iterator.next();
        l l1 = (l)entry1.getValue();
        if (l1.a != null)
        {
            boolean flag;
            if (i == j - 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (l1.c != null)
            {
                ((o) (obj)).a((String)entry1.getKey(), l1.a(), l1.a, l1.c, flag);
            } else
            {
                ((o) (obj)).a((String)entry1.getKey(), l1.a(), l1.a, flag);
            }
        }
        i++;
          goto _L7
        java.util.Map.Entry entry2 = (java.util.Map.Entry)iterator.next();
        Iterator iterator1 = ((ArrayList)entry2.getValue()).iterator();
        while (iterator1.hasNext()) 
        {
            String s = (String)iterator1.next();
            ((o) (obj)).a((String)entry2.getKey(), s);
        }
          goto _L8
_L2:
        obj = new UrlEncodedFormEntity(b(), d);
        return ((HttpEntity) (obj));
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        unsupportedencodingexception.printStackTrace();
        return null;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public void a(String s)
    {
        a.remove(s);
        b.remove(s);
        c.remove(s);
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
            b.put(s, new l(inputstream, s1, s2));
        }
    }

    public void a(String s, String s1)
    {
        if (s != null && s1 != null)
        {
            a.put(s, s1);
        }
    }

    public void a(String s, ArrayList arraylist)
    {
        if (s != null && arraylist != null)
        {
            c.put(s, arraylist);
        }
    }

    protected List b()
    {
        LinkedList linkedlist;
        Iterator iterator;
        linkedlist = new LinkedList();
        iterator = a.entrySet().iterator();
_L3:
        if (iterator.hasNext()) goto _L2; else goto _L1
_L1:
        iterator = c.entrySet().iterator();
_L4:
        if (!iterator.hasNext())
        {
            return linkedlist;
        }
        break MISSING_BLOCK_LABEL_99;
_L2:
        java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
        linkedlist.add(new BasicNameValuePair((String)entry.getKey(), (String)entry.getValue()));
          goto _L3
        java.util.Map.Entry entry1 = (java.util.Map.Entry)iterator.next();
        Iterator iterator1 = ((ArrayList)entry1.getValue()).iterator();
        while (iterator1.hasNext()) 
        {
            String s = (String)iterator1.next();
            linkedlist.add(new BasicNameValuePair((String)entry1.getKey(), s));
        }
          goto _L4
    }

    public String c()
    {
        return URLEncodedUtils.format(b(), d);
    }

    public String toString()
    {
        StringBuilder stringbuilder;
        Iterator iterator;
        stringbuilder = new StringBuilder();
        iterator = a.entrySet().iterator();
_L5:
        if (iterator.hasNext()) goto _L2; else goto _L1
_L1:
        iterator = b.entrySet().iterator();
_L6:
        if (iterator.hasNext()) goto _L4; else goto _L3
_L3:
        iterator = c.entrySet().iterator();
_L7:
        if (!iterator.hasNext())
        {
            return stringbuilder.toString();
        }
        break MISSING_BLOCK_LABEL_196;
_L2:
        java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
        if (stringbuilder.length() > 0)
        {
            stringbuilder.append("&");
        }
        stringbuilder.append((String)entry.getKey());
        stringbuilder.append("=");
        stringbuilder.append((String)entry.getValue());
          goto _L5
_L4:
        java.util.Map.Entry entry1 = (java.util.Map.Entry)iterator.next();
        if (stringbuilder.length() > 0)
        {
            stringbuilder.append("&");
        }
        stringbuilder.append((String)entry1.getKey());
        stringbuilder.append("=");
        stringbuilder.append("FILE");
          goto _L6
        java.util.Map.Entry entry2 = (java.util.Map.Entry)iterator.next();
        if (stringbuilder.length() > 0)
        {
            stringbuilder.append("&");
        }
        ArrayList arraylist = (ArrayList)entry2.getValue();
        Iterator iterator1 = arraylist.iterator();
        while (iterator1.hasNext()) 
        {
            String s = (String)iterator1.next();
            if (arraylist.indexOf(s) != 0)
            {
                stringbuilder.append("&");
            }
            stringbuilder.append((String)entry2.getKey());
            stringbuilder.append("=");
            stringbuilder.append(s);
        }
          goto _L7
    }

}
