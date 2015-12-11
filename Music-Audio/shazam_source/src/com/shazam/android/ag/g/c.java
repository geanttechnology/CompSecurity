// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ag.g;

import android.widget.ImageView;
import com.shazam.android.analytics.event.EventAnalyticsFromView;
import com.shazam.android.analytics.event.EventAnalyticsRunnable;
import com.shazam.android.analytics.event.factory.AddOnSelectedEventFactory;
import com.shazam.android.k.i;
import com.shazam.android.widget.image.IntentUrlCachingImageView;
import com.shazam.android.widget.image.c.b;
import com.shazam.android.widget.image.d;
import com.shazam.model.store.Store;
import java.util.List;

// Referenced classes of package com.shazam.android.ag.g:
//            d, e

public final class c
    implements com.shazam.android.ag.g.d
{

    private static final com.shazam.android.widget.image.c.c d = new com.shazam.android.widget.image.c.c() {

        public final void a(ImageView imageview)
        {
            imageview.setVisibility(8);
        }

        public final void b(ImageView imageview)
        {
        }

    };
    private final EventAnalyticsFromView b;
    private final i c;

    public c(EventAnalyticsFromView eventanalyticsfromview, i i)
    {
        b = eventanalyticsfromview;
        c = i;
    }

    public final void a(Store store, IntentUrlCachingImageView intenturlcachingimageview, com.shazam.android.widget.image.c.c c1)
    {
        a(store, intenturlcachingimageview, c1, null);
    }

    public final void a(Store store, IntentUrlCachingImageView intenturlcachingimageview, com.shazam.android.widget.image.c.c c1, String s)
    {
label0:
        {
            if (store != null)
            {
                boolean flag;
                if (store.validIntent == null && store.intents.isEmpty())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (!flag)
                {
                    break label0;
                }
            }
            intenturlcachingimageview.setVisibility(8);
            return;
        }
        intenturlcachingimageview.setVisibility(0);
        com.shazam.android.widget.image.UrlCachingImageView.a a1 = intenturlcachingimageview.a(store.iconUrl);
        a1.d = com.shazam.android.widget.image.c.b.a(new com.shazam.android.widget.image.c.c[] {
            d, c1
        });
        a1.f = d.b;
        a1.e = 0x106000d;
        a1.c();
        intenturlcachingimageview.setStartActivityForResultRequestCode(123);
        intenturlcachingimageview.setIntent(e.a(store, c));
        intenturlcachingimageview.a();
        intenturlcachingimageview.a(new EventAnalyticsRunnable(intenturlcachingimageview, b, AddOnSelectedEventFactory.addOnSelectedEvent(com.shazam.android.analytics.module.AddOnAnalyticsInfo.Builder.addOnAnalyticsInfo().withScreenOrigin(store.screenOrigin).withProviderName(store.providerName).withTrackCategory(store.trackCategory).withTrackId(store.trackId).withCampaign(store.campaign).withBeaconKey(store.beaconKey).withEventId(store.eventId).withTagResultVersion(s).withCardType(store.cardType).withScreenName(store.screenName).build())));
    }

}
