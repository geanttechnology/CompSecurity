// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

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
import org.apache.http.message.BasicNameValuePair;

// Referenced classes of package android.support.v7:
//            agz

public class agx
{
    private static class a
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
    }


    private static String d = "UTF-8";
    protected ConcurrentHashMap a;
    protected ConcurrentHashMap b;
    protected ConcurrentHashMap c;
    private HttpEntity e;

    public agx()
    {
        e = null;
        d();
    }

    private void d()
    {
        a = new ConcurrentHashMap();
        b = new ConcurrentHashMap();
        c = new ConcurrentHashMap();
        e = null;
    }

    public Map a()
    {
        return new ConcurrentHashMap(a);
    }

    public void a(String s, String s1)
    {
        if (s != null && s1 != null)
        {
            a.put(s, s1);
            e = null;
        }
    }

    public HttpEntity b()
    {
        if (e == null)
        {
            if (!b.isEmpty())
            {
                agz agz1 = new agz();
                java.util.Map.Entry entry;
                for (Iterator iterator = a.entrySet().iterator(); iterator.hasNext(); agz1.a((String)entry.getKey(), (String)entry.getValue()))
                {
                    entry = (java.util.Map.Entry)iterator.next();
                }

                for (Iterator iterator1 = c.entrySet().iterator(); iterator1.hasNext();)
                {
                    java.util.Map.Entry entry1 = (java.util.Map.Entry)iterator1.next();
                    Iterator iterator3 = ((ArrayList)entry1.getValue()).iterator();
                    while (iterator3.hasNext()) 
                    {
                        String s = (String)iterator3.next();
                        agz1.a((String)entry1.getKey(), s);
                    }
                }

                int j = b.entrySet().size();
                Iterator iterator2 = b.entrySet().iterator();
                int i = 0;
                while (iterator2.hasNext()) 
                {
                    java.util.Map.Entry entry2 = (java.util.Map.Entry)iterator2.next();
                    a a1 = (a)entry2.getValue();
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
                            agz1.a((String)entry2.getKey(), a1.a(), a1.a, a1.c, flag);
                        } else
                        {
                            agz1.a((String)entry2.getKey(), a1.a(), a1.a, flag);
                        }
                    }
                    i++;
                }
                e = agz1;
            } else
            {
                try
                {
                    e = new UrlEncodedFormEntity(c(), d);
                }
                catch (UnsupportedEncodingException unsupportedencodingexception)
                {
                    unsupportedencodingexception.printStackTrace();
                }
            }
        }
        return e;
    }

    protected List c()
    {
        LinkedList linkedlist = new LinkedList();
        java.util.Map.Entry entry;
        for (Iterator iterator = a.entrySet().iterator(); iterator.hasNext(); linkedlist.add(new BasicNameValuePair((String)entry.getKey(), (String)entry.getValue())))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        for (Iterator iterator1 = c.entrySet().iterator(); iterator1.hasNext();)
        {
            java.util.Map.Entry entry1 = (java.util.Map.Entry)iterator1.next();
            Iterator iterator2 = ((ArrayList)entry1.getValue()).iterator();
            while (iterator2.hasNext()) 
            {
                String s = (String)iterator2.next();
                linkedlist.add(new BasicNameValuePair((String)entry1.getKey(), s));
            }
        }

        return linkedlist;
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

        for (Iterator iterator2 = c.entrySet().iterator(); iterator2.hasNext();)
        {
            java.util.Map.Entry entry2 = (java.util.Map.Entry)iterator2.next();
            if (stringbuilder.length() > 0)
            {
                stringbuilder.append("&");
            }
            ArrayList arraylist = (ArrayList)entry2.getValue();
            Iterator iterator3 = arraylist.iterator();
            while (iterator3.hasNext()) 
            {
                String s = (String)iterator3.next();
                if (arraylist.indexOf(s) != 0)
                {
                    stringbuilder.append("&");
                }
                stringbuilder.append((String)entry2.getKey());
                stringbuilder.append("=");
                stringbuilder.append(s);
            }
        }

        return stringbuilder.toString();
    }

}
