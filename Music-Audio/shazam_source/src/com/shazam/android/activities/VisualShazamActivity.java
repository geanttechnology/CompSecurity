// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities;

import android.os.Bundle;
import android.support.v4.app.h;
import com.shazam.android.analytics.event.EventAnalytics;
import com.shazam.android.aspects.c.a.a;
import com.shazam.android.fragment.TransitionParams;
import com.shazam.android.util.s;
import com.shazam.android.visual.VisualShazamDialogFragment;
import com.shazam.android.visual.q;
import com.shazam.android.visual.u;
import com.shazam.android.visual.w;
import com.shazam.i.b.au.d;
import com.shazam.i.b.aw.b;
import com.shazam.model.analytics.BeaconEventKey;
import com.shazam.model.analytics.event.DefinedEventParameterKey;

public class VisualShazamActivity extends a
    implements q, u
{

    private final w b = com.shazam.i.b.aw.b.a();
    private final EventAnalytics c = com.shazam.i.b.g.b.a.a();
    private final s d = com.shazam.i.b.au.d.b();

    public VisualShazamActivity()
    {
    }

    public final void a()
    {
        finish();
    }

    public final void a(w w1)
    {
        VisualShazamDialogFragment.a(TransitionParams.a(findViewById(0x1020002))).a(getSupportFragmentManager(), VisualShazamDialogFragment.aj);
    }

    public final void b(w w1)
    {
        c.logEvent(com.shazam.android.analytics.event.Event.Builder.anEvent().withEventType(BeaconEventKey.ERROR).withParameters(com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.TYPE, "visualshazam").putNotEmptyOrNullParameter(DefinedEventParameterKey.REASON, "initializationfailed").build()).build());
    }

    public final void c(w w1)
    {
        w1 = d;
        com.shazam.android.util.q.a a1 = new com.shazam.android.util.q.a();
        a1.a = 0x7f090165;
        w1.a(a1.a());
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        b.a(this);
    }

    protected void onPause()
    {
        super.onPause();
        b.i();
        b.b();
    }

    protected void onResume()
    {
        super.onResume();
        b.l_();
    }

    protected void onStop()
    {
        super.onStop();
        b.b();
    }
}
