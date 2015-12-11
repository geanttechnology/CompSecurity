// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a.f;

import android.os.AsyncTask;
import android.util.Log;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

// Referenced classes of package com.facebook.ads.a.f:
//            s, g, a

public class o extends AsyncTask
{

    private static final String a = com/facebook/ads/a/f/o.getSimpleName();
    private static final Set b;
    private Map c;
    private Map d;

    public o()
    {
        this(null, null);
    }

    public o(Map map)
    {
        this(map, null);
    }

    public o(Map map, Map map1)
    {
        c = map;
        d = map1;
    }

    private static String a(String s1, String s2, String s3)
    {
        if (s.a(s1) || s.a(s2) || s.a(s3))
        {
            return s1;
        }
        String s4;
        if (s1.contains("?"))
        {
            s4 = "&";
        } else
        {
            s4 = "?";
        }
        return (new StringBuilder()).append(s1).append(s4).append(s2).append("=").append(URLEncoder.encode(s3)).toString();
    }

    private boolean a(String s1)
    {
        Object obj = g.b();
        HttpPost httppost;
        ArrayList arraylist;
        int i;
        if (d == null || d.size() == 0)
        {
            return ((HttpClient) (obj)).execute(new HttpGet(s1)).getStatusLine().getStatusCode() == 200;
        }
        try
        {
            httppost = new HttpPost(s1);
            arraylist = new ArrayList(1);
            java.util.Map.Entry entry;
            for (Iterator iterator = d.entrySet().iterator(); iterator.hasNext(); arraylist.add(new BasicNameValuePair((String)entry.getKey(), (String)entry.getValue())))
            {
                entry = (java.util.Map.Entry)iterator.next();
            }

        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.e(a, (new StringBuilder("Error opening url: ")).append(s1).toString(), ((Throwable) (obj)));
            return false;
        }
        httppost.setEntity(new UrlEncodedFormEntity(arraylist));
        i = ((HttpClient) (obj)).execute(httppost).getStatusLine().getStatusCode();
        return i == 200;
    }

    private static String b(String s1)
    {
        String s2;
        try
        {
            s2 = a(s1, "analog", g.a(com.facebook.ads.a.f.a.a()));
        }
        catch (Exception exception)
        {
            return s1;
        }
        return s2;
    }

    protected Object doInBackground(Object aobj[])
    {
        aobj = ((String[])aobj)[0];
        if (!s.a(((String) (aobj))) && !b.contains(((Object) (aobj))))
        {
            aobj = b(((String) (aobj)));
            Object obj = ((Object) (aobj));
            if (c != null)
            {
                obj = ((Object) (aobj));
                if (!c.isEmpty())
                {
                    for (obj = c.entrySet().iterator(); ((Iterator) (obj)).hasNext();)
                    {
                        java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator) (obj)).next();
                        aobj = a(((String) (aobj)), (String)entry.getKey(), (String)entry.getValue());
                    }

                    obj = ((Object) (aobj));
                }
            }
            int i = 1;
            while (i <= 2 && !a(((String) (obj)))) 
            {
                i++;
            }
        }
        return null;
    }

    static 
    {
        HashSet hashset = new HashSet();
        b = hashset;
        hashset.add("#");
        b.add("null");
    }
}
