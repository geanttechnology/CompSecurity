// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ba;

import com.shazam.android.analytics.event.EventAnalytics;
import com.shazam.model.analytics.BeaconEventKey;
import com.shazam.model.analytics.event.DefinedEventParameterKey;

// Referenced classes of package com.shazam.android.ba:
//            f

public final class e
    implements f
{

    private final EventAnalytics a;

    public e(EventAnalytics eventanalytics)
    {
        a = eventanalytics;
    }

    public final void a()
    {
        a.logEvent(com.shazam.android.analytics.event.Event.Builder.anEvent().withEventType(BeaconEventKey.USER_EVENT).withParameters(com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.TYPE, "appupdate").build()).build());
    }
}
