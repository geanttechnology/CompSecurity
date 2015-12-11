// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.media.MediaPlayer;
import android.view.SurfaceHolder;

// Referenced classes of package com.flurry.sdk:
//            dw

class it>
    implements android.media.Player.OnVideoSizeChangedListener
{

    final dw a;

    public void onVideoSizeChanged(MediaPlayer mediaplayer, int i, int j)
    {
        dw.a(a, mediaplayer.getVideoWidth());
        dw.b(a, mediaplayer.getVideoHeight());
        if (dw.f(a) != 0 && dw.g(a) != 0 && a.getHolder() != null)
        {
            a.getHolder().setFixedSize(dw.f(a), dw.g(a));
        }
    }

    layer(dw dw1)
    {
        a = dw1;
        super();
    }
}
