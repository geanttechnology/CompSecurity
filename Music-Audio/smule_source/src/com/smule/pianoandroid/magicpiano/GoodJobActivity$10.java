// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.view.View;
import com.smule.android.c.a;
import com.smule.android.c.i;
import com.smule.android.c.n;
import com.smule.android.c.o;
import com.smule.android.network.managers.q;
import com.smule.android.network.models.PerformanceV2;
import com.smule.magicpiano.PianoCoreBridge;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            GoodJobActivity, s, q

class a
    implements android.view.r
{

    final GoodJobActivity a;

    public void onClick(View view)
    {
        (new s(a, null)).execute(new com.smule.pianoandroid.magicpiano.q[] {
            new com.smule.pianoandroid.magicpiano.q() {

                final GoodJobActivity._cls10 a;

                public void a(q q1)
                {
                    com.smule.android.c.a.a(q1.mPerformance.performanceKey, o.f, n.a, i.a, PianoCoreBridge.getEnsembleAnalyticsType());
                    com.smule.pianoandroid.f.a.a(a.a).c(a.a, q1.mPerformance.performanceKey, GoodJobActivity.l(a.a), q1.mPerformance.webUrl, 4);
                }

            
            {
                a = GoodJobActivity._cls10.this;
                super();
            }
            }, null, null
        });
    }

    _cls1.a(GoodJobActivity goodjobactivity)
    {
        a = goodjobactivity;
        super();
    }
}
