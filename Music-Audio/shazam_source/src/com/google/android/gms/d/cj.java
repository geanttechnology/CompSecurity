// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import com.google.android.gms.ads.internal.util.client.b;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.d:
//            ce, gx, he

public final class cj
    implements ce
{

    public final HashMap a = new HashMap();

    public cj()
    {
    }

    public final void a(he he, Map map)
    {
        String s;
        he = (String)map.get("request_id");
        s = (String)map.get("fetched_ad");
        b.a(3);
        map = (gx)a.get(he);
        if (map == null)
        {
            b.a("Could not find the ad request for the corresponding ad response.");
            return;
        }
        map.b(new JSONObject(s));
        a.remove(he);
        return;
        JSONException jsonexception;
        jsonexception;
        b.a("Failed constructing JSON object from value passed from javascript", jsonexception);
        map.b(null);
        a.remove(he);
        return;
        map;
        a.remove(he);
        throw map;
    }

    public final void a(String s)
    {
        gx gx1 = (gx)a.get(s);
        if (gx1 == null)
        {
            b.a("Could not find the ad request for the corresponding ad response.");
            return;
        }
        if (!gx1.isDone())
        {
            gx1.cancel(true);
        }
        a.remove(s);
    }
}
