// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            da, ax, bd

public final class ay
{

    public final List mr;
    public final long ms;
    public final List mt;
    public final List mu;
    public final List mv;
    public final String mw;
    public final long mx;
    public int my;
    public int mz;

    public ay(String s)
        throws JSONException
    {
        s = new JSONObject(s);
        if (da.n(2))
        {
            da.v((new StringBuilder()).append("Mediation Response JSON: ").append(s.toString(2)).toString());
        }
        JSONArray jsonarray = s.getJSONArray("ad_networks");
        ArrayList arraylist = new ArrayList(jsonarray.length());
        int j = -1;
        for (int i = 0; i < jsonarray.length();)
        {
            ax ax1 = new ax(jsonarray.getJSONObject(i));
            arraylist.add(ax1);
            int k = j;
            if (j < 0)
            {
                k = j;
                if (a(ax1))
                {
                    k = i;
                }
            }
            i++;
            j = k;
        }

        my = j;
        mz = jsonarray.length();
        mr = Collections.unmodifiableList(arraylist);
        mw = s.getString("qdata");
        s = s.optJSONObject("settings");
        if (s != null)
        {
            ms = s.optLong("ad_network_timeout_millis", -1L);
            mt = bd.a(s, "click_urls");
            mu = bd.a(s, "imp_urls");
            mv = bd.a(s, "nofill_urls");
            long l = s.optLong("refresh", -1L);
            if (l > 0L)
            {
                l *= 1000L;
            } else
            {
                l = -1L;
            }
            mx = l;
            return;
        } else
        {
            ms = -1L;
            mt = null;
            mu = null;
            mv = null;
            mx = -1L;
            return;
        }
    }

    private boolean a(ax ax1)
    {
        for (ax1 = ax1.mn.iterator(); ax1.hasNext();)
        {
            if (((String)ax1.next()).equals("com.google.ads.mediation.admob.AdMobAdapter"))
            {
                return true;
            }
        }

        return false;
    }
}
