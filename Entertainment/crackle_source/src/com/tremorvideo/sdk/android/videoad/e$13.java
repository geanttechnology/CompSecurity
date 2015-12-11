// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.media.MediaPlayer;
import android.widget.VideoView;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            e, u

class a
    implements android.media.Player.OnPreparedListener
{

    final int a;
    final e b;

    public void onPrepared(MediaPlayer mediaplayer)
    {
        b.m = true;
        if (a > 0)
        {
            e.d(b).seekTo(a);
        }
        if (!e.a(b).p || !b.j)
        {
            e.e(b);
        }
        int i = e.d(b).getDuration();
        if (i > 0)
        {
            e.b(b, i);
        } else
        {
            e.b(b, e.a(b).D);
        }
        if (e.a(b).g(e.f(b)))
        {
            e.a(b, e.a(b));
        }
        if (a == 0)
        {
            e.h(b).(e.g(b));
        }
        e.h(b).ostDelayed(e.i(b), 10L);
        e.d(b).setOnPreparedListener(null);
        e.a(b, -1L);
        e.b(b, a);
    }

    ner(e e1, int i)
    {
        b = e1;
        a = i;
        super();
    }
}
