// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a.e;

import com.facebook.ads.a.c.a;
import com.facebook.ads.a.c.d;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.facebook.ads.a.e:
//            d, e, f

public final class c
{

    private static c a = new c();

    public c()
    {
    }

    public static c a()
    {
        com/facebook/ads/a/e/c;
        JVM INSTR monitorenter ;
        c c1 = a;
        com/facebook/ads/a/e/c;
        JVM INSTR monitorexit ;
        return c1;
        Exception exception;
        exception;
        throw exception;
    }

    public static com.facebook.ads.a.e.d a(String s)
    {
        String s1;
        byte byte0;
        s = new JSONObject(s);
        s1 = s.optString("type");
        byte0 = -1;
        s1.hashCode();
        JVM INSTR lookupswitch 2: default 48
    //                   96432: 88
    //                   96784904: 102;
           goto _L1 _L2 _L3
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_102;
_L4:
        switch (byte0)
        {
        default:
            s = s.optJSONObject("error");
            if (s != null)
            {
                return c(s);
            } else
            {
                return new com.facebook.ads.a.e.d(com.facebook.ads.a.e.d.a.a, null);
            }

        case 0: // '\0'
            return a(((JSONObject) (s)));

        case 1: // '\001'
            return b(s);
        }
_L2:
        if (s1.equals("ads"))
        {
            byte0 = 0;
        }
          goto _L4
        if (s1.equals("error"))
        {
            byte0 = 1;
        }
          goto _L4
    }

    private static e a(JSONObject jsonobject)
    {
        int i = 0;
        Object obj1 = jsonobject.getJSONArray("placements").getJSONObject(0);
        Object obj = d.a(((JSONObject) (obj1)).getJSONObject("definition"));
        jsonobject = new com.facebook.ads.a.c.c(((d) (obj)));
        obj = ((d) (obj)).a();
        if (((JSONObject) (obj1)).has("ads"))
        {
            for (obj1 = ((JSONObject) (obj1)).getJSONArray("ads"); i < ((JSONArray) (obj1)).length(); i++)
            {
                a a1 = new a(((com.facebook.ads.a.e.a) (obj)));
                Object obj2 = ((JSONArray) (obj1)).getJSONObject(i);
                a1.b = ((JSONObject) (obj2)).getString("adapter");
                JSONObject jsonobject1 = ((JSONObject) (obj2)).getJSONObject("data");
                obj2 = ((JSONObject) (obj2)).optJSONArray("trackers");
                if (obj2 != null)
                {
                    jsonobject1.put("trackers", obj2);
                }
                a1.c = jsonobject1;
                ((com.facebook.ads.a.c.c) (jsonobject)).a.add(a1);
            }

        }
        return new e(jsonobject);
    }

    private static f b(JSONObject jsonobject)
    {
        Object obj;
        try
        {
            obj = d.a(jsonobject.getJSONArray("placements").getJSONObject(0).getJSONObject("definition"));
            obj = new f(jsonobject.optString("message", ""), new com.facebook.ads.a.c.c(((d) (obj))));
        }
        catch (JSONException jsonexception)
        {
            return c(jsonobject);
        }
        return ((f) (obj));
    }

    private static f c(JSONObject jsonobject)
    {
        return new f(jsonobject.optString("message", ""), null);
    }

}
