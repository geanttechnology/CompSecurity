// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.ads.controller;

import android.content.Context;
import android.os.Handler;
import io.presage.Presage;
import io.presage.actions.NewAction;
import io.presage.actions.d;
import io.presage.actions.g;
import io.presage.actions.j;
import io.presage.ads.NewAd;
import io.presage.ads.NewAdController;
import io.presage.ads.NewAdViewerDescriptor;
import io.presage.do.e;
import io.presage.model.Advertiser;
import io.presage.utils.do.a;
import io.presage.utils.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import shared_presage.com.google.gson.Gson;

// Referenced classes of package io.presage.ads.controller:
//            a

public abstract class DefaultAdController extends NewAdController
    implements io.presage.ads.NewAd.a, io.presage.ads.NewAd.b, io.presage.ads.NewAd.c, io.presage.ads.NewAd.d
{

    private boolean f;
    private String g;
    private Handler h;

    public DefaultAdController(Context context, NewAd newad, NewAdViewerDescriptor newadviewerdescriptor, int i)
    {
        super(context, newad, newadviewerdescriptor, i);
        g = "cancel";
        h = new Handler(new io.presage.ads.controller.a(this));
    }

    private void cancelHomeDefaultBehaviour()
    {
        if (h.hasMessages(0))
        {
            h.removeMessages(0);
        }
    }

    private void sendError(String s, String s1)
    {
        Object obj = new e();
        ((e) (obj)).a("type", "error");
        ((e) (obj)).a("error_type", s);
        ((e) (obj)).a("error_message", s1);
        d.a();
        obj = d.a("send_event", "send_ad_event", ((e) (obj)));
        ((g) (obj)).a(b.getAdvertiser().getId(), b.getCampaignId(), b.getId());
        ((g) (obj)).a(s, s1);
        ((g) (obj)).j();
        g = null;
    }

    private void sendEvent(String s)
    {
        Object obj = new e();
        ((e) (obj)).a("type", s);
        d.a();
        obj = d.a("send_event", "send_ad_event", ((e) (obj)));
        if (s.equals("completed") || s.equals("cancel"))
        {
            s = b.getVideoCompletionRate();
            if (s != null)
            {
                ((g) (obj)).a(s);
            }
        }
        ((g) (obj)).a(b.getAdvertiser().getId(), b.getCampaignId(), b.getId());
        ((g) (obj)).j();
    }

    public abstract String getAdHistorySource();

    public void hideAd()
    {
        super.hideAd();
        b.setOnFormatEventListener(null);
        b.setOnPageFinishedListener(null);
        b.setOnSDKActionListener(null);
        b.setOnVideoErrorListener(null);
        cancelHomeDefaultBehaviour();
        if (g != null)
        {
            sendEvent(g);
        }
    }

    public void onFormatEvent(String s)
    {
        if (!s.equals("shown") || !hasFlag(1)) goto _L2; else goto _L1
_L1:
        sendEvent("shown");
_L4:
        return;
_L2:
        if (s.equals("completed"))
        {
            sendEvent("completed");
            return;
        }
        if (!s.equals("close_system_dialog") || !hasFlag(16))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!h.hasMessages(0))
        {
            h.sendEmptyMessageDelayed(0, 300L);
            return;
        }
        continue; /* Loop/switch isn't completed */
        if (f) goto _L4; else goto _L3
_L3:
        if (s.equals("finish"))
        {
            g = "finish";
            hideAd();
            f = true;
            return;
        }
        if (s.equals("cancel"))
        {
            g = "cancel";
            hideAd();
            f = true;
            return;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public void onPageFinished(String s, boolean flag)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("campaign_id", b.getCampaignId());
        hashmap.put("advert_id", b.getId());
        hashmap.put("advertiser_id", b.getAdvertiser().getId());
        hashmap.put("url", s);
        hashmap.put("source", getAdHistorySource());
        if (flag)
        {
            hashmap.put("landing", "true");
        }
        Presage.getInstance().getWS().a("ad_history", hashmap);
    }

    public void onSDKAction(String s, String s1)
    {
        j.a();
        io.presage.actions.j.a a1 = j.a(s);
        if (a1 != null)
        {
            a1.a(a, s1).execute();
        } else
        {
            d.a();
            s = d.a("action", s, new e((ArrayList)(new Gson()).fromJson(s1, java/util/ArrayList)));
            if (Presage.getInstance().getPackageHelper().a(s.p()))
            {
                s.a(b.getAdvertiser().getId(), b.getCampaignId(), b.getId());
                s.k();
                return;
            }
        }
    }

    public void onVideoError(String s)
    {
        sendError("video", s);
        hideAd();
    }

    public void showAd()
    {
        b.setOnFormatEventListener(this);
        b.setOnPageFinishedListener(this);
        b.setOnSDKActionListener(this);
        b.setOnVideoErrorListener(this);
        super.showAd();
    }

}
