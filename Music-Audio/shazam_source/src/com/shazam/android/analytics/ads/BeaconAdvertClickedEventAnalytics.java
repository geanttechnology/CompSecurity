// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.ads;

import android.view.View;
import com.shazam.android.advert.m;
import com.shazam.android.analytics.event.EventAnalyticsFromView;
import com.shazam.model.advert.AdType;
import com.shazam.model.analytics.BeaconEventKey;
import com.shazam.model.analytics.event.DefinedEventParameterKey;
import java.util.EnumMap;
import java.util.Map;

// Referenced classes of package com.shazam.android.analytics.ads:
//            AdvertClickedEventAnalytics

public class BeaconAdvertClickedEventAnalytics
    implements AdvertClickedEventAnalytics
{

    private static final Map AD_TYPE_PROVIDERS;
    private final EventAnalyticsFromView eventAnalyticsFromView;

    public BeaconAdvertClickedEventAnalytics(EventAnalyticsFromView eventanalyticsfromview)
    {
        eventAnalyticsFromView = eventanalyticsfromview;
    }

    private String providerNameFrom(AdType adtype)
    {
        return (String)AD_TYPE_PROVIDERS.get(adtype);
    }

    public void sendAdClicked(View view, AdType adtype, String s)
    {
        eventAnalyticsFromView.logEvent(view, com.shazam.android.analytics.event.Event.Builder.anEvent().withEventType(BeaconEventKey.USER_EVENT).withParameters(com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.TYPE, "advertclicked").putNotEmptyOrNullParameter(DefinedEventParameterKey.SITE_ID, s).putNotEmptyOrNullParameter(DefinedEventParameterKey.PROVIDER, providerNameFrom(adtype)).build()).build());
    }

    static 
    {
        EnumMap enummap = new EnumMap(com/shazam/model/advert/AdType);
        AD_TYPE_PROVIDERS = enummap;
        enummap.put(AdType.AD_COLONY, m.c.d);
        AD_TYPE_PROVIDERS.put(AdType.FACEBOOK, m.b.d);
        AD_TYPE_PROVIDERS.put(AdType.FALLBACK_QUIZ, "quizstory");
        AD_TYPE_PROVIDERS.put(AdType.FALLBACK, "fallback");
    }
}
