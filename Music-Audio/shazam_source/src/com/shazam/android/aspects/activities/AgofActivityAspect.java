// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.aspects.activities;

import com.shazam.android.analytics.AgofReportingDisabler;
import com.shazam.android.analytics.session.AgofSession;
import com.shazam.android.aspects.b.a.b;
import com.shazam.i.b.g.c.a;

public class AgofActivityAspect extends b
{

    private final AgofSession agofSession = a.a();

    public AgofActivityAspect()
    {
    }

    public void onStart(com.shazam.android.aspects.c.a.a a1)
    {
        agofSession.onActivityStart();
        if ((a1 instanceof com.shazam.android.aq.a) && !(a1 instanceof AgofReportingDisabler))
        {
            agofSession.viewAppeared(((com.shazam.android.aq.a)a1).getAgofViewKey());
        }
    }

    public void onStop(com.shazam.android.aspects.c.a.a a1)
    {
        agofSession.onActivityStop();
    }
}
