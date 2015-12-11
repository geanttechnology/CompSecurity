// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.media.MediaPlayer;
import android.widget.VideoView;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            v, u

class a
    implements android.media.aPlayer.OnCompletionListener
{

    final v a;

    public void onCompletion(MediaPlayer mediaplayer)
    {
label0:
        {
            if (!a.B)
            {
                v.c(a, v.g(a));
                if (!v.a(a).P())
                {
                    break label0;
                }
                v.e(a).pause();
                a.o = true;
                mediaplayer = a;
                mediaplayer.b = ((v) (mediaplayer)).b + 1;
                v.l(a);
            }
            return;
        }
        v.m(a);
        a.i = true;
        v.e(a).stopPlayback();
        a.k();
    }

    stener(v v1)
    {
        a = v1;
        super();
    }
}
