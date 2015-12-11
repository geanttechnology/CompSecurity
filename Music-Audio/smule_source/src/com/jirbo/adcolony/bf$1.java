// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.media.MediaPlayer;
import android.view.SurfaceHolder;

// Referenced classes of package com.jirbo.adcolony:
//            bf

class a
    implements android.media.Player.OnVideoSizeChangedListener
{

    final bf a;

    public void onVideoSizeChanged(MediaPlayer mediaplayer, int i, int j)
    {
        a.i = mediaplayer.getVideoWidth();
        a.j = mediaplayer.getVideoHeight();
        if (a.i != 0 && a.j != 0)
        {
            a.getHolder().setFixedSize(a.i, a.j);
        }
    }

    r(bf bf1)
    {
        a = bf1;
        super();
    }
}
