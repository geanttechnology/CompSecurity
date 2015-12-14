// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import com.flurry.sdk.js;
import com.flurry.sdk.ka;
import com.flurry.sdk.kb;
import com.flurry.sdk.lg;

// Referenced classes of package com.flurry.android:
//            FlurryAgent, FlurryAgentListener

final class _cls1.a
    implements kb
{

    public volatile void a(ka ka)
    {
        a((lg)ka);
    }

    public void a(lg lg1)
    {
        js.a().a(new Runnable(lg1) {

            final lg a;
            final FlurryAgent._cls1 b;

            public void run()
            {
                FlurryAgent._cls2.a[a.c.ordinal()];
                JVM INSTR tableswitch 1 1: default 32
            //                           1 33;
                   goto _L1 _L2
_L1:
                return;
_L2:
                if (FlurryAgent.a() != null)
                {
                    FlurryAgent.a().onSessionStarted();
                    return;
                }
                if (true) goto _L1; else goto _L3
_L3:
            }

            
            {
                b = FlurryAgent._cls1.this;
                a = lg1;
                super();
            }
        });
    }

    _cls1.a()
    {
    }
}
