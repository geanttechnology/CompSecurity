// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            ct, at, az

public final class au
{

    public final List fI;
    public final long fJ;
    public final List fK;
    public final List fL;
    public final List fM;
    public final String fN;
    public final long fO;

    public au(String s)
        throws JSONException
    {
        s = new JSONObject(s);
        if (ct.n(2))
        {
            ct.u((new StringBuilder()).append("Mediation Response JSON: ").append(s.toString(2)).toString());
        }
        JSONArray jsonarray = s.getJSONArray("ad_networks");
        ArrayList arraylist = new ArrayList(jsonarray.length());
        for (int i = 0; i < jsonarray.length(); i++)
        {
            arraylist.add(new at(jsonarray.getJSONObject(i)));
        }

        fI = Collections.unmodifiableList(arraylist);
        fN = s.getString("qdata");
        s = s.optJSONObject("settings");
        if (s != null)
        {
            fJ = s.optLong("ad_network_timeout_millis", -1L);
            fK = az.a(s, "click_urls");
            fL = az.a(s, "imp_urls");
            fM = az.a(s, "nofill_urls");
            long l = s.optLong("refresh", -1L);
            if (l > 0L)
            {
                l *= 1000L;
            } else
            {
                l = -1L;
            }
            fO = l;
            return;
        } else
        {
            fJ = -1L;
            fK = null;
            fL = null;
            fM = null;
            fO = -1L;
            return;
        }
    }
}
