// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage;

import android.content.Context;
import android.content.IntentFilter;
import io.presage.actions.d;
import io.presage.actions.g;
import io.presage.ads.NewAd;
import io.presage.ads.NewAdController;
import io.presage.model.Advertiser;
import io.presage.utils.IADHandler;
import io.presage.utils.do.do.a;
import io.presage.utils.do.do.b;
import java.util.Map;

// Referenced classes of package io.presage:
//            Presage, f

final class e
    implements b
{

    final Presage a;

    e(Presage presage)
    {
        a = presage;
        super();
    }

    public final void a(a a1)
    {
        Object obj = a1.a();
        if (!((String) (obj)).equals("success")) goto _L2; else goto _L1
_L1:
        a1 = a1.b();
        if (a1.containsKey("flow") && "new".equals(a1.get("flow")))
        {
            obj = (NewAd)a1.get("ad");
            Object obj1 = new io.presage.do.e();
            ((io.presage.do.e) (obj1)).a("type", "served");
            d.a();
            obj1 = d.a("send_event", "send_ad_event", ((io.presage.do.e) (obj1)));
            ((g) (obj1)).a(((NewAd) (obj)).getAdvertiser().getId(), ((NewAd) (obj)).getCampaignId(), ((NewAd) (obj)).getId());
            ((g) (obj1)).j();
            io.presage.ads.g.a();
            obj1 = io.presage.ads.g.a("format").a(1).a(16).a(a.getContext(), ((NewAd) (obj)), ((NewAd) (obj)).getFormatDescriptor());
            obj = new f(this, ((NewAd) (obj)));
            Presage.access$200(a).registerReceiver(((android.content.BroadcastReceiver) (obj)), new IntentFilter("io.presage.ad.HIDE"));
            ((NewAdController) (obj1)).showAd();
        }
        if (a1 == null || !a1.containsKey("ad")) goto _L4; else goto _L3
_L3:
        if (Presage.access$100(a) != null)
        {
            Presage.access$100(a).onAdFound();
        }
_L6:
        return;
_L4:
        if (Presage.access$100(a) == null) goto _L6; else goto _L5
_L5:
        Presage.access$100(a).onAdNotFound();
        return;
_L2:
        if (!((String) (obj)).equals("failure"))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (Presage.access$100(a) == null) goto _L6; else goto _L7
_L7:
        Presage.access$100(a).onAdNotFound();
        return;
        if (!((String) (obj)).equals("close") || Presage.access$100(a) == null) goto _L6; else goto _L8
_L8:
        Presage.access$100(a).onAdClosed();
        return;
    }
}
