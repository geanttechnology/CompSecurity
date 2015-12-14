// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.clone;

import android.os.Handler;
import android.os.Looper;

// Referenced classes of package com.picsart.effects.clone:
//            CloneSurfaceView

final class a
    implements Runnable
{

    private CloneSurfaceView a;

    public final void run()
    {
        if (CloneSurfaceView.b(a) != null)
        {
            Looper looper = CloneSurfaceView.b(a).getLooper();
            if (looper != null)
            {
                looper.quit();
            }
        }
    }

    (CloneSurfaceView clonesurfaceview)
    {
        a = clonesurfaceview;
        super();
    }
}
