// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a.b;

import com.facebook.ads.a.f.e;
import com.facebook.ads.a.f.f;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.facebook.ads.a.b:
//            f

public final class q
    implements com.facebook.ads.a.b.f
{

    public final String a;
    final String b;
    public final String c;
    final Map d;
    public final String e;
    public final int f;
    public final int g;
    private final e h;
    private final String i;
    private final Collection j;

    public q(String s, String s1, String s2, e e1, String s3, Collection collection, Map map, 
            String s4, int k, int l)
    {
        a = s;
        b = s1;
        c = s2;
        h = e1;
        i = s3;
        j = collection;
        d = map;
        e = s4;
        f = k;
        g = l;
    }

    public static q a(JSONObject jsonobject)
    {
        if (jsonobject == null)
        {
            return null;
        }
        String s = jsonobject.optString("markup");
        String s1 = jsonobject.optString("activation_command");
        String s2 = jsonobject.optString("native_impression_report_url");
        String s3 = jsonobject.optString("request_id");
        e e1 = com.facebook.ads.a.f.e.a(jsonobject.optString("invalidation_behavior"));
        String s4 = jsonobject.optString("invalidation_report_url");
        Object obj;
        HashMap hashmap;
        try
        {
            obj = new JSONArray(jsonobject.optString("detection_strings"));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((JSONException) (obj)).printStackTrace();
            obj = null;
        }
        obj = com.facebook.ads.a.f.f.a(((JSONArray) (obj)));
        jsonobject = jsonobject.optJSONObject("metadata");
        hashmap = new HashMap();
        if (jsonobject != null)
        {
            String s5;
            for (Iterator iterator = jsonobject.keys(); iterator.hasNext(); hashmap.put(s5, jsonobject.optString(s5)))
            {
                s5 = (String)iterator.next();
            }

        }
        int k = 0;
        int l = 1000;
        if (hashmap.containsKey("viewability_check_initial_delay"))
        {
            k = Integer.parseInt((String)hashmap.get("viewability_check_initial_delay"));
        }
        if (hashmap.containsKey("viewability_check_interval"))
        {
            l = Integer.parseInt((String)hashmap.get("viewability_check_interval"));
        }
        return new q(s, s1, s2, e1, s4, ((Collection) (obj)), hashmap, s3, k, l);
    }

    public final e a()
    {
        return h;
    }

    public final String b()
    {
        return i;
    }

    public final Collection c()
    {
        return j;
    }
}
