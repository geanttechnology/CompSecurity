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
//            q, GoodJobActivity, s

class a
    implements com.smule.pianoandroid.magicpiano.q
{

    final a a;

    public void a(q q1)
    {
        com.smule.android.c.a.a(q1.mPerformance.performanceKey, o.g, n.a, i.a, PianoCoreBridge.getEnsembleAnalyticsType());
        com.smule.pianoandroid.f.a.a(a.a).b(a.a, q1.mPerformance.performanceKey, GoodJobActivity.l(a.a), q1.mPerformance.webUrl, 4);
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/smule/pianoandroid/magicpiano/GoodJobActivity$11

/* anonymous class */
    class GoodJobActivity._cls11
        implements android.view.View.OnClickListener
    {

        final GoodJobActivity a;

        public void onClick(View view)
        {
            (new s(a, null)).execute(new com.smule.pianoandroid.magicpiano.q[] {
                new GoodJobActivity._cls11._cls1(this), null, null
            });
        }

            
            {
                a = goodjobactivity;
                super();
            }
    }

}
