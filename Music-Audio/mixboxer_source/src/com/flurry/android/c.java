// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;
import android.os.Handler;
import java.util.List;

// Referenced classes of package com.flurry.android:
//            fp, FlurryAgent, af, cy, 
//            IFlurryAds

final class c extends fp
{

    final Context j;
    final FlurryAgent l;
    private boolean m;

    c(FlurryAgent flurryagent, boolean flag, Context context)
    {
        l = flurryagent;
        m = flag;
        j = context;
        super();
    }

    public final void c()
    {
        am am = FlurryAgent.b(l);
        FlurryAgent.c(l).add(am);
        FlurryAgent.d(l);
        if (!m)
        {
            FlurryAgent.e(l).postDelayed(new af(this), FlurryAgent.A());
        }
        if (FlurryAgent.r())
        {
            cy.c("FlurryAgent", "Attempting to persist AdLogs");
            l.be.savePersistentAdLogData();
            cy.c("FlurryAgent", "Attempting to persist FreqCap");
            l.be.savePersistentFreqCapData();
        }
    }
}
