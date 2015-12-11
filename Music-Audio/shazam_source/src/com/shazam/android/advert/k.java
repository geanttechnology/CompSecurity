// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.advert;

import com.shazam.android.analytics.event.EventAnalytics;
import com.shazam.model.analytics.BeaconEventKey;
import com.shazam.model.analytics.event.DefinedEventParameterKey;
import com.shazam.n.l;

// Referenced classes of package com.shazam.android.advert:
//            l, b, a, ShazamAdView

public final class k
    implements com.shazam.android.advert.l
{

    private final EventAnalytics a;
    private final l c;

    public k(EventAnalytics eventanalytics, l l1)
    {
        a = eventanalytics;
        c = l1;
    }

    private static com.shazam.android.analytics.event.EventParameters.Builder a(b b1, String s)
    {
        return com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.SITE_ID, s).putNotEmptyOrNullParameter(DefinedEventParameterKey.PROVIDER, b1.a());
    }

    private void a(BeaconEventKey beaconeventkey, com.shazam.android.analytics.event.EventParameters.Builder builder)
    {
        a.logEvent(com.shazam.android.analytics.event.Event.Builder.anEvent().withEventType(beaconeventkey).withParameters(builder.build()).build());
    }

    public final void a()
    {
        c.a(0L);
    }

    public final void a(ShazamAdView shazamadview, b b1, a a1, String s)
    {
        c.b(0L);
        shazamadview = a(b1, s).putNotEmptyOrNullParameter(DefinedEventParameterKey.LOADED, "0").putNotEmptyOrNullParameter(DefinedEventParameterKey.REASON, "0").putNotEmptyOrNullParameter(DefinedEventParameterKey.DURATION, String.valueOf(c.a()));
        if (a1 != null)
        {
            shazamadview.putNotEmptyOrNullParameter(DefinedEventParameterKey.ERROR_CODE, String.valueOf(a1.a));
        }
        a(BeaconEventKey.ADVERT, ((com.shazam.android.analytics.event.EventParameters.Builder) (shazamadview)));
    }

    public final void a(ShazamAdView shazamadview, b b1, String s)
    {
        c.b(0L);
        shazamadview = a(b1, s).putNotEmptyOrNullParameter(DefinedEventParameterKey.LOADED, "1").putNotEmptyOrNullParameter(DefinedEventParameterKey.DURATION, String.valueOf(c.a()));
        a(BeaconEventKey.ADVERT, ((com.shazam.android.analytics.event.EventParameters.Builder) (shazamadview)));
    }

    public final void b()
    {
    }

    public final void b(ShazamAdView shazamadview, b b1, String s)
    {
        shazamadview = a(b1, s).putNotEmptyOrNullParameter(DefinedEventParameterKey.TYPE, "advertclicked");
        a(BeaconEventKey.USER_EVENT, shazamadview);
    }

    public final void c()
    {
    }
}
