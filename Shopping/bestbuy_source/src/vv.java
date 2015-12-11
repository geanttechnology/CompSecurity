// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class vv
{

    public final List a;
    public final long b;
    public final List c;
    public final List d;
    public final List e;
    public final String f;
    public final long g;
    public int h;
    public int i;

    public vv(String s)
    {
        s = new JSONObject(s);
        if (acb.a(2))
        {
            acb.d((new StringBuilder()).append("Mediation Response JSON: ").append(s.toString(2)).toString());
        }
        JSONArray jsonarray = s.getJSONArray("ad_networks");
        ArrayList arraylist = new ArrayList(jsonarray.length());
        int k = -1;
        for (int j = 0; j < jsonarray.length();)
        {
            vu vu1 = new vu(jsonarray.getJSONObject(j));
            arraylist.add(vu1);
            int l = k;
            if (k < 0)
            {
                l = k;
                if (a(vu1))
                {
                    l = j;
                }
            }
            j++;
            k = l;
        }

        h = k;
        i = jsonarray.length();
        a = Collections.unmodifiableList(arraylist);
        f = s.getString("qdata");
        s = s.optJSONObject("settings");
        if (s != null)
        {
            b = s.optLong("ad_network_timeout_millis", -1L);
            c = wb.a(s, "click_urls");
            d = wb.a(s, "imp_urls");
            e = wb.a(s, "nofill_urls");
            long l1 = s.optLong("refresh", -1L);
            if (l1 > 0L)
            {
                l1 *= 1000L;
            } else
            {
                l1 = -1L;
            }
            g = l1;
            return;
        } else
        {
            b = -1L;
            c = null;
            d = null;
            e = null;
            g = -1L;
            return;
        }
    }

    private boolean a(vu vu1)
    {
        for (vu1 = vu1.c.iterator(); vu1.hasNext();)
        {
            if (((String)vu1.next()).equals("com.google.ads.mediation.admob.AdMobAdapter"))
            {
                return true;
            }
        }

        return false;
    }
}
