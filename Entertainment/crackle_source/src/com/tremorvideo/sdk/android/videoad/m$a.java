// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.app.Activity;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            m, aq

class a extends TimerTask
{

    final m a;

    public void run()
    {
        a.d.purge();
        a.d.cancel();
        a.d = null;
        a.a.runOnUiThread(new Runnable() {

            final m.a a;

            public void run()
            {
                if (a.a.b != null)
                {
                    a.a.b.a(a.a.c);
                }
            }

            
            {
                a = m.a.this;
                super();
            }
        });
    }

    _cls1.a(m m1)
    {
        a = m1;
        super();
    }
}
