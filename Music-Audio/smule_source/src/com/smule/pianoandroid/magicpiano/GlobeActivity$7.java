// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.view.View;
import com.smule.android.network.core.r;
import com.smule.android.network.managers.ap;
import com.smule.android.network.managers.i;
import com.smule.android.network.models.PerformanceV2;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            GlobeActivity

class a
    implements android.view.ener
{

    final GlobeActivity a;

    public void onClick(View view)
    {
        view = GlobeActivity.b(a);
        if (view != null)
        {
            if (i.a().c(((PerformanceV2) (view)).songUid) || ap.a().b())
            {
                GlobeActivity.c(a);
                return;
            }
            if (r.a(a))
            {
                a.f();
                return;
            }
        }
    }

    (GlobeActivity globeactivity)
    {
        a = globeactivity;
        super();
    }
}
