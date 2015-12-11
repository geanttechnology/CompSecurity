// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.service.player;

import com.shazam.android.analytics.event.EventAnalytics;
import com.shazam.model.analytics.BeaconEventKey;
import com.shazam.model.analytics.event.DefinedEventParameterKey;
import com.shazam.n.l;

// Referenced classes of package com.shazam.android.service.player:
//            k

public final class c
    implements k
{

    private final EventAnalytics a;
    private final l b;
    private boolean c;
    private String d;

    public c(EventAnalytics eventanalytics, l l1)
    {
        a = eventanalytics;
        b = l1;
    }

    public final void a()
    {
        b(0L);
    }

    public final void a(long l1)
    {
        b.a(l1);
    }

    public final void a(String s)
    {
        d = s;
        a(0L);
    }

    public final void a(boolean flag)
    {
        c = flag;
    }

    public final void b(long l1)
    {
        b.b(l1);
        l1 = b.a();
        EventAnalytics eventanalytics = a;
        com.shazam.android.analytics.event.Event.Builder builder = com.shazam.android.analytics.event.Event.Builder.anEvent().withEventType(BeaconEventKey.USER_EVENT);
        com.shazam.android.analytics.event.EventParameters.Builder builder1 = com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.TYPE, "playersessionend");
        DefinedEventParameterKey definedeventparameterkey = DefinedEventParameterKey.BACKGROUND;
        String s;
        if (c)
        {
            s = "1";
        } else
        {
            s = "0";
        }
        eventanalytics.logEvent(builder.withParameters(builder1.putNotEmptyOrNullParameter(definedeventparameterkey, s).putNotEmptyOrNullParameter(DefinedEventParameterKey.PLAYBACK_DURATION, String.valueOf(l1)).putNotEmptyOrNullParameter(DefinedEventParameterKey.PLAYLIST_TITLE, d).build()).build());
    }
}
