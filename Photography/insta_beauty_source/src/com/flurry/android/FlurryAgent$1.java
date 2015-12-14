// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import com.flurry.sdk.js;
import com.flurry.sdk.ka;
import com.flurry.sdk.kb;
import com.flurry.sdk.lg;

final class _cls1
    implements kb
{

    public volatile void a(ka ka)
    {
        a((lg)ka);
    }

    public void a(lg lg1)
    {
        class _cls1
            implements Runnable
        {

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

            _cls1(lg lg1)
            {
                b = FlurryAgent._cls1.this;
                a = lg1;
                super();
            }
        }

        js.a().a(new _cls1(lg1));
    }

    _cls1()
    {
    }
}
