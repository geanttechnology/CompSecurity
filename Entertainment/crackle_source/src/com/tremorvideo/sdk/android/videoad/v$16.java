// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.media.MediaPlayer;
import android.widget.VideoView;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            v, u

class a
    implements android.media.Player.OnPreparedListener
{

    final int a;
    final v b;

    public void onPrepared(MediaPlayer mediaplayer)
    {
        b.C = true;
        if (a > 0)
        {
            v.e(b).seekTo(a);
        }
        if (!v.a(b).p || !b.h)
        {
            v.f(b);
        }
        int i = v.e(b).getDuration();
        if (i > 0)
        {
            v.b(b, i);
        } else
        {
            v.b(b, v.a(b).D);
        }
        if (v.a(b).g(v.g(b)))
        {
            v.a(b, v.a(b));
        }
        if (a == 0)
        {
            v.i(b).(v.h(b));
        }
        v.i(b).ostDelayed(v.j(b), 10L);
        v.e(b).setOnPreparedListener(null);
        v.a(b, -1L);
        v.b(b, a);
    }

    ner(v v1, int i)
    {
        b = v1;
        a = i;
        super();
    }
}
