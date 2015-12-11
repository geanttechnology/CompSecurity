// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ad.a;

import android.content.Context;
import android.preference.Preference;
import com.shazam.android.analytics.TaggingOutcome;
import com.shazam.android.analytics.event.EventAnalytics;
import com.shazam.android.ay.a.p;
import com.shazam.android.persistence.n.b;
import com.shazam.i.b.ah.f;
import com.shazam.i.b.ar.a.e;
import com.shazam.model.analytics.BeaconEventKey;
import com.shazam.model.analytics.event.DefinedEventParameterKey;

public final class a
    implements android.preference.Preference.OnPreferenceChangeListener
{

    private final p a;
    private final b b;
    private final EventAnalytics c;

    public a()
    {
        this(((p) (e.a())), f.a(), com.shazam.i.b.g.b.a.a());
    }

    public a(p p1, b b1, EventAnalytics eventanalytics)
    {
        a = p1;
        b = b1;
        c = eventanalytics;
    }

    public final boolean onPreferenceChange(Preference preference, Object obj)
    {
        obj = (Boolean)obj;
        if (!((Boolean) (obj)).booleanValue())
        {
            a.b(TaggingOutcome.CANCELED);
        }
        String s = preference.getContext().getString(0x7f09022b);
        boolean flag = b.a(s);
        b.b(s, "true");
        preference = preference.getKey();
        preference = com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.TYPE, "continuoustaggingswitchchanged").putNotEmptyOrNullParameter(DefinedEventParameterKey.CHANGED_TO, ((Boolean) (obj)).toString()).putNotEmptyOrNullParameter(DefinedEventParameterKey.CHANGED_FROM, Boolean.toString(b.a(preference, true)));
        obj = DefinedEventParameterKey.FIRST_OCCURRENCE;
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        preference = preference.putNotEmptyOrNullParameter(((com.shazam.model.analytics.event.EventParameterKey) (obj)), Boolean.toString(flag)).build();
        preference = com.shazam.android.analytics.event.Event.Builder.anEvent().withEventType(BeaconEventKey.USER_EVENT).withParameters(preference).build();
        c.logEvent(preference);
        return true;
    }
}
