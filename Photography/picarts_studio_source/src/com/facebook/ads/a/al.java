// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a;

import android.content.Intent;
import android.os.Bundle;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.facebook.ads.a:
//            e, h, i

public class al
    implements e
{

    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final h f;
    private final Collection g;
    private final Map h;

    private al(String s, String s1, String s2, String s3, String s4, h h1, Collection collection, 
            Map map)
    {
        a = s;
        b = s1;
        c = s2;
        d = s3;
        e = s4;
        f = h1;
        g = collection;
        h = map;
    }

    public static al a(Bundle bundle)
    {
        return new al(bundle.getString("markup"), null, bundle.getString("activation_command"), null, bundle.getString("native_impression_report_url"), h.a, null, null);
    }

    public static al a(JSONObject jsonobject)
    {
        if (jsonobject == null)
        {
            return null;
        }
        String s = jsonobject.optString("markup");
        String s1 = jsonobject.optString("secondary_markup");
        String s2 = jsonobject.optString("activation_command");
        String s3 = jsonobject.optString("secondary_activation_command");
        String s4 = jsonobject.optString("native_impression_report_url");
        h h1 = com.facebook.ads.a.h.a(jsonobject.optString("invalidation_behavior"));
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
        obj = com.facebook.ads.a.i.a(((JSONArray) (obj)));
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
        return new al(s, s1, s2, s3, s4, h1, ((Collection) (obj)), hashmap);
    }

    public static al b(Intent intent)
    {
        return new al(intent.getStringExtra("markup"), null, intent.getStringExtra("activation_command"), null, intent.getStringExtra("native_impression_report_url"), h.a, null, null);
    }

    public h a()
    {
        return f;
    }

    public void a(Intent intent)
    {
        intent.putExtra("markup", a);
        intent.putExtra("activation_command", c);
        intent.putExtra("native_impression_report_url", e);
    }

    public Collection b()
    {
        return g;
    }

    public String c()
    {
        return a;
    }

    public String d()
    {
        return c;
    }

    public String e()
    {
        return e;
    }

    public String f()
    {
        return "facebookAd.sendImpression();";
    }

    public boolean g()
    {
        return h.containsKey("preload") && Boolean.valueOf((String)h.get("preload")).booleanValue();
    }

    public Map h()
    {
        return h;
    }

    public Bundle i()
    {
        Bundle bundle = new Bundle();
        bundle.putString("markup", a);
        bundle.putString("native_impression_report_url", e);
        return bundle;
    }

    public Map j()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("markup", b);
        hashmap.put("activation_command", d);
        hashmap.put("native_impression_report_url", e);
        return hashmap;
    }
}
