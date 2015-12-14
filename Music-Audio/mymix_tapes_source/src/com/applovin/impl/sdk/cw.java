// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.applovin.impl.sdk:
//            bv, ax, ba, AppLovinSdkImpl, 
//            NativeAdImpl

class cw extends bv
{

    private final AppLovinNativeAdLoadListener a;
    private final JSONObject b;

    cw(JSONObject jsonobject, AppLovinSdkImpl applovinsdkimpl, AppLovinNativeAdLoadListener applovinnativeadloadlistener)
    {
        super("TaskRenderWidget", applovinsdkimpl);
        a = applovinnativeadloadlistener;
        b = jsonobject;
    }

    private String a(Map map, String s)
    {
        map = (String)map.get("simp_url");
        if (!AppLovinSdkUtils.isValidString(map))
        {
            throw new IllegalArgumentException("No impression URL available");
        } else
        {
            return map.replace("{CLCODE}", s);
        }
    }

    private String a(Map map, String s, String s1)
    {
        String s2 = (String)map.get("click_url");
        if (!AppLovinSdkUtils.isValidString(s2))
        {
            throw new IllegalArgumentException("No impression URL available");
        }
        map = s1;
        if (s1 == null)
        {
            map = "";
        }
        return s2.replace("{CLCODE}", s).replace("{EVENT_ID}", map);
    }

    private void a(JSONObject jsonobject)
    {
        Object obj = ax.a(jsonobject.getJSONArray("native_ads"));
        jsonobject = ax.a(jsonobject.getJSONObject("native_settings"));
        ArrayList arraylist = new ArrayList(((List) (obj)).size());
        Object obj1;
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); f.getLogger().d("TaskRenderWidget", (new StringBuilder()).append("Prepared slot: ").append(((NativeAdImpl) (obj1)).getAdId()).toString()))
        {
            obj1 = (Map)((Iterator) (obj)).next();
            String s = (String)((Map) (obj1)).get("clcode");
            obj1 = (new ba()).e((String)((Map) (obj1)).get("title")).f((String)((Map) (obj1)).get("description")).g((String)((Map) (obj1)).get("caption")).p((String)((Map) (obj1)).get("cta")).a((String)((Map) (obj1)).get("icon_url")).b((String)((Map) (obj1)).get("image_url")).d((String)((Map) (obj1)).get("video_url")).c((String)((Map) (obj1)).get("star_rating_url")).h((String)((Map) (obj1)).get("icon_url")).i((String)((Map) (obj1)).get("image_url")).j((String)((Map) (obj1)).get("video_url")).a(Float.parseFloat((String)((Map) (obj1)).get("star_rating"))).o(s).k(a(((Map) (jsonobject)), s)).l(a(((Map) (jsonobject)), s, (String)((Map) (obj1)).get("event_id"))).m(b(jsonobject, s)).n(c(jsonobject, s)).a(Long.parseLong((String)((Map) (obj1)).get("ad_id"))).a(f).a();
            arraylist.add(obj1);
        }

        if (a != null)
        {
            a.onNativeAdsLoaded((List)arraylist);
        }
    }

    private String b(Map map, String s)
    {
        map = (String)map.get("video_start_url");
        if (map != null)
        {
            return map.replace("{CLCODE}", s);
        } else
        {
            return null;
        }
    }

    private String c(Map map, String s)
    {
        map = (String)map.get("video_end_url");
        if (map != null)
        {
            return map.replace("{CLCODE}", s);
        } else
        {
            return null;
        }
    }

    void a(int i)
    {
        try
        {
            if (a != null)
            {
                a.onNativeAdsFailedToLoad(i);
            }
            return;
        }
        catch (Exception exception)
        {
            f.getLogger().e("TaskRenderWidget", "Unable to notify listener about failure.", exception);
        }
    }

    public void run()
    {
        if (b == null || b.length() == 0)
        {
            a(-700);
            return;
        }
        try
        {
            a(b);
            return;
        }
        catch (Exception exception)
        {
            f.getLogger().e("TaskRenderWidget", "Unable to render widget.", exception);
        }
        a(-200);
        return;
    }
}
