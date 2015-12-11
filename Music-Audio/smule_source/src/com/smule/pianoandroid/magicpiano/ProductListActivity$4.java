// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.view.ViewGroup;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.smule.android.c.aa;
import com.smule.pianoandroid.ads.b;
import com.smule.pianoandroid.utils.a;
import com.smule.pianoandroid.utils.n;
import java.text.MessageFormat;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ProductListActivity

class a
    implements Runnable
{

    final ViewGroup a;
    final ProductListActivity b;

    public void run()
    {
        if (n.a("banner_source"))
        {
            b.spaceDidReceiveAd("PIANDROID_Songbook_Banner");
            return;
        }
        if (n.b("banner_source"))
        {
            com.smule.pianoandroid.magicpiano.ProductListActivity.a(b, new PublisherAdView(b));
            ProductListActivity.f(b).setAdUnitId(MessageFormat.format("/{0}/{1}", new Object[] {
                b.getString(0x7f0c00ce), b.getString(0x7f0c00cc)
            }));
            ProductListActivity.f(b).setAdSizes(new AdSize[] {
                new AdSize(320, 40)
            });
            a.addView(ProductListActivity.f(b));
            aa.a(com.smule.pianoandroid.magicpiano.ProductListActivity.a, "Loading DFP banner ");
            ProductListActivity.f(b).setAdListener(new b(ProductListActivity.f(b)));
            ProductListActivity.f(b).setAppEventListener(new com.smule.pianoandroid.utils.b(b, null));
            ProductListActivity.f(b).loadAd((new com.google.android.gms.ads.doubleclick.lder()).addNetworkExtras(new AdMobExtras(com.smule.pianoandroid.utils.a.a(null))).build());
            return;
        } else
        {
            a.setVisibility(8);
            return;
        }
    }

    t.Builder(ProductListActivity productlistactivity, ViewGroup viewgroup)
    {
        b = productlistactivity;
        a = viewgroup;
        super();
    }
}
