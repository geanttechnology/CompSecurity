// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.a.d;

import android.content.res.Resources;
import com.shazam.android.advert.g.c;
import com.shazam.android.j.s.a;
import com.shazam.model.advert.Ad;
import com.shazam.model.advert.AdType;
import com.shazam.model.availability.GooglePlayAvailability;
import com.shazam.model.news.FeedCard;
import com.shazam.server.response.config.AmpConfig;
import com.shazam.server.response.config.AmpSettings;
import com.shazam.server.response.config.QuizFallbackAmpSetting;
import java.util.List;

// Referenced classes of package com.shazam.android.a.d:
//            c

private final class c
    implements c
{

    final com.shazam.android.a.d.c a;
    private final FeedCard c;

    private void a(Ad ad, int i)
    {
        int j = com.shazam.android.a.d.c.a(a, c.id);
        if (com.shazam.android.a.d.c.e(j))
        {
            com.shazam.android.a.d.c c1 = a;
            com.shazam.model.news.edCard.Builder builder = com.shazam.model.news.edCard.Builder.a();
            builder.sponsorshipText = a.c.getString(i);
            builder.ad = ad;
            builder.id = c.id;
            ad = builder.b();
            c1.e.set(j, ad);
            a.h(j);
        }
    }

    public final void a(Ad ad)
    {
        a(ad, 0x7f090129);
    }

    public final void b(Ad ad)
    {
        if (a.g.a.a().getSettings().getQuizFallback().isEnabled())
        {
            ad = com.shazam.model.advert.uilder.a();
            ad.adType = AdType.FALLBACK_QUIZ;
            a(ad.b(), 0x7f090115);
        } else
        {
            if (a.d.a())
            {
                a(ad, 0x7f090112);
                return;
            }
            int i = com.shazam.android.a.d.c.a(a, c.id);
            if (com.shazam.android.a.d.c.e(i))
            {
                ad = a;
                ((com.shazam.android.a.d.c) (ad)).e.remove(i);
                ad.g(i);
                return;
            }
        }
    }

    public ard(com.shazam.android.a.d.c c1, FeedCard feedcard)
    {
        a = c1;
        super();
        c = feedcard;
    }
}
