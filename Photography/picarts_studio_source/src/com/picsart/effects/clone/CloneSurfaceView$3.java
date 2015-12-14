// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.clone;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.picsart.effects.clone:
//            CloneSurfaceView

final class a
    implements Runnable
{

    private CloneSurfaceView a;

    public final void run()
    {
        CloneSurfaceView clonesurfaceview = a;
        if (clonesurfaceview.a != null)
        {
            Message message = clonesurfaceview.a.obtainMessage();
            message.what = 2;
            clonesurfaceview.a(message, false);
        }
    }

    (CloneSurfaceView clonesurfaceview)
    {
        a = clonesurfaceview;
        super();
    }
}
