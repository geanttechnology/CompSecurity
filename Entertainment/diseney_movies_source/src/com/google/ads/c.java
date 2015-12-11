// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads;

import com.google.ads.internal.h;
import com.google.ads.util.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.ads:
//            a, AdSize

public class c
{

    private static final Map a = Collections.unmodifiableMap(new HashMap() {

            
            {
                put("banner", AdSize.BANNER);
                put("mrec", AdSize.IAB_MRECT);
                put("fullbanner", AdSize.IAB_BANNER);
                put("leaderboard", AdSize.IAB_LEADERBOARD);
                put("skyscraper", AdSize.IAB_WIDE_SKYSCRAPER);
            }
    });
    private final String b;
    private final String c;
    private final List d;
    private final Integer e;
    private final Integer f;
    private final List g;
    private final List h;
    private final List i;

    private c(String s, String s1, List list, Integer integer, Integer integer1, List list1, List list2, 
            List list3)
    {
        com.google.ads.util.a.a(s);
        b = s;
        c = s1;
        d = list;
        e = integer;
        f = integer1;
        g = list1;
        h = list2;
        i = list3;
    }

    private static com.google.ads.a a(JSONObject jsonobject)
        throws JSONException
    {
        String s = jsonobject.getString("id");
        String s1 = jsonobject.optString("allocation_id", null);
        JSONArray jsonarray = jsonobject.getJSONArray("adapters");
        ArrayList arraylist = new ArrayList(jsonarray.length());
        for (int k = 0; k < jsonarray.length(); k++)
        {
            arraylist.add(jsonarray.getString(k));
        }

        List list = a(jsonobject, "imp_urls");
        JSONObject jsonobject1 = jsonobject.optJSONObject("data");
        jsonobject = new HashMap(0);
        if (jsonobject1 != null)
        {
            HashMap hashmap = new HashMap(jsonobject1.length());
            Iterator iterator = jsonobject1.keys();
            do
            {
                jsonobject = hashmap;
                if (!iterator.hasNext())
                {
                    break;
                }
                jsonobject = (String)iterator.next();
                hashmap.put(jsonobject, jsonobject1.getString(jsonobject));
            } while (true);
        }
        return new com.google.ads.a(s1, s, arraylist, list, jsonobject);
    }

    public static c a(String s)
        throws JSONException
    {
        Integer integer = null;
        s = new JSONObject(s);
        String s2 = s.getString("qdata");
        String s1;
        Object obj;
        ArrayList arraylist;
        if (s.has("ad_type"))
        {
            s1 = s.getString("ad_type");
        } else
        {
            s1 = null;
        }
        obj = s.getJSONArray("ad_networks");
        arraylist = new ArrayList(((JSONArray) (obj)).length());
        for (int k = 0; k < ((JSONArray) (obj)).length(); k++)
        {
            arraylist.add(a(((JSONArray) (obj)).getJSONObject(k)));
        }

        Object obj1 = s.optJSONObject("settings");
        List list;
        if (obj1 != null)
        {
            if (((JSONObject) (obj1)).has("refresh"))
            {
                s = Integer.valueOf(((JSONObject) (obj1)).getInt("refresh"));
            } else
            {
                s = null;
            }
            if (((JSONObject) (obj1)).has("ad_network_timeout_millis"))
            {
                integer = Integer.valueOf(((JSONObject) (obj1)).getInt("ad_network_timeout_millis"));
            }
            obj = a(((JSONObject) (obj1)), "imp_urls");
            list = a(((JSONObject) (obj1)), "click_urls");
            obj1 = a(((JSONObject) (obj1)), "nofill_urls");
        } else
        {
            obj1 = null;
            obj = null;
            list = null;
            integer = null;
            s = null;
        }
        return new c(s2, s1, arraylist, s, integer, ((List) (obj)), list, ((List) (obj1)));
    }

    private static List a(JSONObject jsonobject, String s)
        throws JSONException
    {
        jsonobject = jsonobject.optJSONArray(s);
        if (jsonobject != null)
        {
            s = new ArrayList(jsonobject.length());
            for (int k = 0; k < jsonobject.length(); k++)
            {
                s.add(jsonobject.getString(k));
            }

            return s;
        } else
        {
            return null;
        }
    }

    public boolean a()
    {
        return f != null;
    }

    public int b()
    {
        return f.intValue();
    }

    public String c()
    {
        return b;
    }

    public boolean d()
    {
        return e != null;
    }

    public int e()
    {
        return e.intValue();
    }

    public List f()
    {
        return d;
    }

    public List g()
    {
        return g;
    }

    public List h()
    {
        return h;
    }

    public List i()
    {
        return i;
    }

    public h j()
    {
        if (c == null)
        {
            return null;
        }
        if ("interstitial".equals(c))
        {
            return h.a;
        }
        AdSize adsize = (AdSize)a.get(c);
        if (adsize != null)
        {
            return com.google.ads.internal.h.a(adsize);
        } else
        {
            return null;
        }
    }

}
