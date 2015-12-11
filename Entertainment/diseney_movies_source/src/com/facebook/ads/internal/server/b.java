// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.server;

import com.facebook.ads.internal.dto.a;
import com.facebook.ads.internal.dto.c;
import com.facebook.ads.internal.dto.d;
import com.facebook.ads.internal.util.r;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.facebook.ads.internal.server:
//            d, e, c

public class b
{

    private static b a = new b();

    public b()
    {
    }

    public static b a()
    {
        com/facebook/ads/internal/server/b;
        JVM INSTR monitorenter ;
        b b1 = a;
        com/facebook/ads/internal/server/b;
        JVM INSTR monitorexit ;
        return b1;
        Exception exception;
        exception;
        throw exception;
    }

    private com.facebook.ads.internal.server.d a(JSONObject jsonobject)
    {
        int i = 0;
        Object obj1 = jsonobject.getJSONArray("placements").getJSONObject(0);
        Object obj = d.a(((JSONObject) (obj1)).getJSONObject("definition"));
        jsonobject = new c(((d) (obj)));
        obj = ((d) (obj)).a();
        if (((JSONObject) (obj1)).has("ads"))
        {
            for (obj1 = ((JSONObject) (obj1)).getJSONArray("ads"); i < ((JSONArray) (obj1)).length(); i++)
            {
                a a1 = new a(((AdPlacementType) (obj)));
                Object obj2 = ((JSONArray) (obj1)).getJSONObject(i);
                a1.a(((JSONObject) (obj2)).getString("adapter"));
                JSONObject jsonobject1 = ((JSONObject) (obj2)).getJSONObject("data");
                obj2 = ((JSONObject) (obj2)).optJSONArray("trackers");
                if (obj2 != null)
                {
                    jsonobject1.put("trackers", obj2);
                }
                a1.a(jsonobject1);
                jsonobject.a(a1);
            }

        }
        return new com.facebook.ads.internal.server.d(jsonobject);
    }

    private e b(JSONObject jsonobject)
    {
        Object obj;
        try
        {
            obj = d.a(jsonobject.getJSONArray("placements").getJSONObject(0).getJSONObject("definition"));
            obj = new e(jsonobject.optString("message", ""), jsonobject.optInt("code", 0), new c(((d) (obj))));
        }
        catch (JSONException jsonexception)
        {
            return c(jsonobject);
        }
        return ((e) (obj));
    }

    private e c(JSONObject jsonobject)
    {
        return new e(jsonobject.optString("message", ""), jsonobject.optInt("code", 0), null);
    }

    public com.facebook.ads.internal.server.c a(String s)
    {
        String s1;
        byte byte0;
        if (r.a(s))
        {
            break MISSING_BLOCK_LABEL_137;
        }
        s = new JSONObject(s);
        s1 = s.optString("type");
        byte0 = -1;
        s1.hashCode();
        JVM INSTR lookupswitch 2: default 56
    //                   96432: 97
    //                   96784904: 111;
           goto _L1 _L2 _L3
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_111;
_L4:
        switch (byte0)
        {
        default:
            s = s.optJSONObject("error");
            if (s != null)
            {
                return c(s);
            }
            break;

        case 0: // '\0'
            return a(((JSONObject) (s)));

        case 1: // '\001'
            return b(s);
        }
        break MISSING_BLOCK_LABEL_137;
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
        return new com.facebook.ads.internal.server.c(com.facebook.ads.internal.server.c.a.a, null);
    }

}
