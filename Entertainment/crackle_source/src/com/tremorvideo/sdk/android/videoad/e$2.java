// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.media.MediaPlayer;
import android.widget.VideoView;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            e, u, ax

class a
    implements android.media.aPlayer.OnCompletionListener
{

    final e a;

    public void onCompletion(MediaPlayer mediaplayer)
    {
label0:
        {
            if (!a.k)
            {
                e.c(a, e.f(a));
                if (!e.a(a).P())
                {
                    break label0;
                }
                e.d(a).pause();
                a.s = true;
                mediaplayer = a;
                mediaplayer.b = ((e) (mediaplayer)).b + 1;
                if (!e.a(a).O)
                {
                    e.a(a).O = true;
                    mediaplayer = e.a(a).C();
                    if (mediaplayer != null)
                    {
                        e.k(a).a(mediaplayer);
                    }
                }
                e.l(a);
            }
            return;
        }
        e.m(a);
        a.l = true;
        e.a(a).O = true;
        mediaplayer = e.a(a).C();
        if (mediaplayer != null)
        {
            e.k(a).a(mediaplayer);
        }
        if (e.d(a).isPlaying())
        {
            e.d(a).stopPlayback();
        }
        e.d(a).destroyDrawingCache();
        a.d.a(a);
    }

    stener(e e1)
    {
        a = e1;
        super();
    }
}
