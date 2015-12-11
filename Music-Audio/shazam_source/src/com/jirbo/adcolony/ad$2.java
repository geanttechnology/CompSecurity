// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.media.MediaPlayer;
import android.view.SurfaceHolder;
import android.widget.MediaController;

// Referenced classes of package com.jirbo.adcolony:
//            ad

final class a
    implements android.media.Player.OnPreparedListener
{

    final ad a;

    public final void onPrepared(MediaPlayer mediaplayer)
    {
        int i;
        a.e = 2;
        ad ad1 = a;
        ad ad2 = a;
        a.u = true;
        ad2.t = true;
        ad1.s = true;
        if (a.o != null)
        {
            a.o.onPrepared(a.h);
        }
        if (a.m != null)
        {
            a.m.setEnabled(true);
        }
        a.i = mediaplayer.getVideoWidth();
        a.j = mediaplayer.getVideoHeight();
        i = a.r;
        if (i != 0)
        {
            a.seekTo(i);
        }
        if (a.i == 0 || a.j == 0) goto _L2; else goto _L1
_L1:
        a.getHolder().setFixedSize(a.i, a.j);
        if (a.k != a.i || a.l != a.j) goto _L4; else goto _L3
_L3:
        if (a.f != 3) goto _L6; else goto _L5
_L5:
        a.start();
        if (a.m != null)
        {
            a.m.show();
        }
_L4:
        return;
_L6:
        if (!a.isPlaying() && (i != 0 || a.getCurrentPosition() > 0) && a.m != null)
        {
            a.m.show(0);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (a.f == 3)
        {
            a.start();
            return;
        }
        if (true) goto _L4; else goto _L7
_L7:
    }

    r(ad ad1)
    {
        a = ad1;
        super();
    }
}
