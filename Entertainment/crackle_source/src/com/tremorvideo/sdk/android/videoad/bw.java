// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.webkit.URLUtil;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            ad, ay, aw, aa

public class bw
{

    public String a;
    public int b;
    public boolean c;
    public int d;
    public int e;

    public bw(String s)
    {
        b = -1;
        c = false;
        d = 0;
        e = 0;
        a = s;
        b = -1;
        c = false;
        d = 0;
        e = 0;
    }

    public static int a(JSONArray jsonarray)
    {
        int j = 0;
        jsonarray = jsonarray.toString();
        if (jsonarray.contains("UT"))
        {
            j = 1;
        }
        int i = j;
        if (jsonarray.contains("Umd"))
        {
            i = j | 2;
        }
        j = i;
        if (jsonarray.contains("RwT"))
        {
            j = i | 4;
        }
        i = j;
        if (jsonarray.contains("RmT"))
        {
            i = j | 8;
        }
        j = i;
        if (jsonarray.contains("RvN"))
        {
            j = i | 0x10;
        }
        i = j;
        if (jsonarray.contains("AmN"))
        {
            i = j | 0x20;
        }
        j = i;
        if (jsonarray.contains("EiN"))
        {
            j = i | 0x40;
        }
        i = j;
        if (jsonarray.contains("SfF"))
        {
            i = j | 0x80;
        }
        j = i;
        if (jsonarray.contains("Ee"))
        {
            j = i | 0x100;
        }
        return j;
    }

    public static bw a(JSONObject jsonobject)
    {
        Object obj = null;
        bw bw1 = obj;
        if (jsonobject.has("url"))
        {
            String s;
            try
            {
                s = jsonobject.getString("url");
            }
            catch (Exception exception)
            {
                ad.d((new StringBuilder()).append("Error loading Tracking data: ").append(jsonobject.toString()).toString());
                return null;
            }
            bw1 = obj;
            if (URLUtil.isValidUrl(s))
            {
                bw bw2 = new bw(s);
                if (jsonobject.has("load-count"))
                {
                    try
                    {
                        bw2.b = jsonobject.getInt("load-count");
                    }
                    catch (Exception exception1)
                    {
                        ad.d((new StringBuilder()).append("Error loading load-count for: ").append(jsonobject.toString()).toString());
                    }
                }
                if (jsonobject.has("internal"))
                {
                    try
                    {
                        bw2.c = jsonobject.getBoolean("internal");
                    }
                    catch (Exception exception2)
                    {
                        ad.d((new StringBuilder()).append("Error loading internal for: ").append(jsonobject.toString()).toString());
                    }
                }
                bw1 = bw2;
                if (jsonobject.has("log-vars"))
                {
                    try
                    {
                        bw2.d = a(jsonobject.getJSONArray("log-vars"));
                    }
                    catch (Exception exception3)
                    {
                        ad.d((new StringBuilder()).append("Error loading log-vars for: ").append(jsonobject.toString()).toString());
                        return bw2;
                    }
                    bw1 = bw2;
                }
            }
        }
        return bw1;
    }

    private List b(ay.a a1)
    {
        ArrayList arraylist = new ArrayList();
        if (a(1))
        {
            Date date = new Date();
            arraylist.add(new BasicNameValuePair("UT", (new SimpleDateFormat("yyMMddHH")).format(date)));
        }
        if (a(2))
        {
            if (a1.g != null)
            {
                arraylist.add(new BasicNameValuePair("Umd", (new StringBuilder()).append("").append(a1.g.a).append(",").append(a1.g.b).append(",").append(a1.g.c).append(",").append(a1.g.d).toString()));
            } else
            {
                arraylist.add(new BasicNameValuePair("Umd", (new StringBuilder()).append("0,0,").append(ad.l()).append(",").append(ad.m()).toString()));
            }
        }
        if (a(4))
        {
            arraylist.add(new BasicNameValuePair("RwT", (new StringBuilder()).append("").append((a1.d + a1.e) - a1.a.b).toString()));
        }
        if (a(8))
        {
            arraylist.add(new BasicNameValuePair("RmT", (new StringBuilder()).append("").append(a1.e).toString()));
        }
        if (a(16))
        {
            arraylist.add(new BasicNameValuePair("RvN", (new StringBuilder()).append("").append(a1.f).toString()));
        }
        if (a(32))
        {
            arraylist.add(new BasicNameValuePair("AmN", (new StringBuilder()).append("").append(a1.f).toString()));
        }
        if (a(64))
        {
            arraylist.add(new BasicNameValuePair("EiN", (new StringBuilder()).append("").append(a1.f).toString()));
        }
        if (a(128))
        {
            if (e == 0)
            {
                arraylist.add(new BasicNameValuePair("SfF", "true"));
            } else
            {
                arraylist.add(new BasicNameValuePair("SfF", "false"));
            }
        }
        if (a(256))
        {
            arraylist.add(new BasicNameValuePair("Ee", "1"));
        }
        return arraylist;
    }

    public void a(ay.a a1)
    {
        ad.d((new StringBuilder()).append("Tracking URL: ").append(a).toString());
        if (b > 0 && e >= b)
        {
            ad.d((new StringBuilder()).append("Load count for pixel reached: ").append(e).append("/").append(b).toString());
            return;
        }
        if (!c) goto _L2; else goto _L1
_L1:
        Object obj;
        List list = b(a1);
        if (list != null && list.size() > 0)
        {
            ad.d("LogVars: ");
            NameValuePair namevaluepair;
            for (Iterator iterator = list.iterator(); iterator.hasNext(); ad.d((new StringBuilder()).append(namevaluepair.getName()).append("=").append(namevaluepair.getValue()).toString()))
            {
                namevaluepair = (NameValuePair)iterator.next();
            }

        }
        obj = list;
        if (a1.h == null)
        {
            break MISSING_BLOCK_LABEL_379;
        }
        obj = list;
        if (a1.h.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_379;
        }
        obj = list;
        if (list == null)
        {
            obj = new ArrayList();
        }
        Iterator iterator1 = a1.h.iterator();
        String s = "";
_L4:
        NameValuePair namevaluepair1;
        if (!iterator1.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        namevaluepair1 = (NameValuePair)iterator1.next();
        String s1 = s;
        if (s.length() > 0)
        {
            s1 = (new StringBuilder()).append(s).append("&").toString();
        }
        s = (new StringBuilder()).append(s1).append(namevaluepair1.getName()).append("=").append(namevaluepair1.getValue()).toString();
        if (true) goto _L4; else goto _L3
_L3:
        int i;
        byte byte0;
        try
        {
            s = URLEncoder.encode(s, "utf-8");
            ad.d((new StringBuilder()).append("Additional Data: ").append(s).toString());
            ((List) (obj)).add(new BasicNameValuePair("ssEd", s));
        }
        catch (Exception exception)
        {
            ad.a(exception);
        }
_L6:
        byte0 = -1;
        i = byte0;
        if (a1 != null)
        {
            i = byte0;
            if (a1.c != null)
            {
                i = a1.c.k();
            }
        }
        aa.a(a, ((List) (obj)), c, i);
        e = e + 1;
        return;
_L2:
        obj = null;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public boolean a(int i)
    {
        return (d & i) > 0;
    }
}
