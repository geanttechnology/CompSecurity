// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import android.content.Intent;
import android.net.Uri;
import com.applovin.sdk.AppLovinEventService;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdk;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

// Referenced classes of package com.applovin.impl.sdk:
//            AppLovinSdkImpl, bw, r, bs, 
//            u, t, s, v, 
//            ci, cr, cq, dh, 
//            cj

public class EventServiceImpl
    implements AppLovinEventService
{

    private final AppLovinSdkImpl a;
    private final List b;

    public EventServiceImpl(AppLovinSdk applovinsdk)
    {
        a = (AppLovinSdkImpl)applovinsdk;
        b = Arrays.asList(((String)((AppLovinSdkImpl)applovinsdk).a(bw.bi)).split(","));
    }

    static Uri a(EventServiceImpl eventserviceimpl, bs bs1, s s1)
    {
        return eventserviceimpl.a(bs1, s1);
    }

    private Uri a(bs bs1, s s1)
    {
        Object obj = a.getDataCollector();
        u u1 = ((r) (obj)).a();
        t t1 = ((r) (obj)).b();
        boolean flag = b.contains(bs1.a());
        android.net.Uri.Builder builder = Uri.parse((String)a.a(bw.bh)).buildUpon();
        if (flag)
        {
            obj = bs1.a();
        } else
        {
            obj = "postinstall";
        }
        obj = builder.appendQueryParameter("event", ((String) (obj))).appendQueryParameter("ts", Long.toString(bs1.c())).appendQueryParameter("platform", "Android").appendQueryParameter("model", u1.a).appendQueryParameter("package_name", t1.c).appendQueryParameter("sdk_key", a.getSdkKey()).appendQueryParameter("idfa", s1.b).appendQueryParameter("dnt", Boolean.toString(s1.a)).appendQueryParameter("ia", Long.toString(t1.d)).appendQueryParameter("api_did", (String)a.a(bw.c)).appendQueryParameter("brand", u1.c).appendQueryParameter("model", u1.a).appendQueryParameter("revision", u1.d).appendQueryParameter("sdk_version", "6.1.4").appendQueryParameter("os", u1.b);
        s1 = ((s) (obj));
        if (!flag)
        {
            s1 = ((android.net.Uri.Builder) (obj)).appendQueryParameter("sub_event", bs1.a());
        }
        return s1.build();
    }

    static AppLovinSdkImpl a(EventServiceImpl eventserviceimpl)
    {
        return eventserviceimpl.a;
    }

    private Map a(Map map)
    {
        HashMap hashmap = new HashMap();
        if (map != null)
        {
            for (map = map.entrySet().iterator(); map.hasNext();)
            {
                Object obj1 = (java.util.Map.Entry)map.next();
                Object obj = ((java.util.Map.Entry) (obj1)).getKey();
                obj1 = ((java.util.Map.Entry) (obj1)).getValue();
                if ((obj instanceof String) && (obj1 instanceof String))
                {
                    hashmap.put((String)obj, (String)obj1);
                } else
                {
                    a.getLogger().w("EventServiceImpl", (new StringBuilder()).append("Unexpected class type in trackEvent(); all keys and values passed as parameters must be String. Encountered ").append(obj.getClass().getCanonicalName()).append("/").append(obj1.getClass().getCanonicalName()).append("; will use toString() value instead, which may be unexpected...").toString());
                    hashmap.put(obj.toString(), obj1.toString());
                }
            }

        }
        return hashmap;
    }

    private void a(bs bs1)
    {
        if (!((Boolean)a.a(bw.bj)).booleanValue())
        {
            return;
        } else
        {
            a.getLogger().d("EventServiceImpl", (new StringBuilder()).append("Tracking event: ").append(bs1).toString());
            a(((cj) (new v(this, bs1))));
            return;
        }
    }

    private void a(cj cj)
    {
        cj = new ci(a, cj);
        a.a().a(cj, cr.b);
    }

    public void trackCheckout(String s1, Map map)
    {
        if (map != null)
        {
            map = new HashMap(map);
        } else
        {
            map = new HashMap(1);
        }
        map.put("transaction_id", s1);
        trackEvent("checkout", map);
    }

    public void trackEvent(String s1)
    {
        trackEvent(s1, ((Map) (new HashMap())));
    }

    public void trackEvent(String s1, Map map)
    {
        a(new bs(s1, a(map), System.currentTimeMillis(), dh.b(UUID.randomUUID().toString())));
    }

    public void trackInAppPurchase(Intent intent, Map map)
    {
        if (map != null)
        {
            map = new HashMap(map);
        } else
        {
            map = new HashMap();
        }
        try
        {
            map.put("receipt_data", intent.getStringExtra("INAPP_PURCHASE_DATA"));
            map.put("receipt_data_signature", intent.getStringExtra("INAPP_DATA_SIGNATURE"));
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            a.getLogger().userError("EventServiceImpl", "Unable to track in app purchase; invalid purchanse intent", intent);
        }
        trackEvent("iap", map);
    }
}
