// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.overlay;

import android.os.Handler;
import android.widget.FrameLayout;
import com.google.android.gms.d.gm;

// Referenced classes of package com.google.android.gms.ads.internal.overlay:
//            k, i

final class q
    implements Runnable
{

    boolean a;
    private k b;

    q(k k1)
    {
        a = false;
        b = k1;
    }

    public final void a()
    {
        gm.a.postDelayed(this, 250L);
    }

    public final void run()
    {
        if (!a)
        {
            k k1 = b;
            long l = k1.c.getCurrentPosition();
            if (k1.e != l && l > 0L)
            {
                if (k1.g())
                {
                    k1.a.removeView(k1.d);
                }
                k1.a("timeupdate", new String[] {
                    "time", String.valueOf((float)l / 1000F)
                });
                k1.e = l;
            }
            a();
        }
    }
}
