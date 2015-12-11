// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comscore.streaming;

import android.media.MediaPlayer;

// Referenced classes of package com.comscore.streaming:
//            StreamSenseMediaPlayer

class i
    implements android.media.MediaPlayer.OnInfoListener
{

    final StreamSenseMediaPlayer a;

    i(StreamSenseMediaPlayer streamsensemediaplayer)
    {
        a = streamsensemediaplayer;
        super();
    }

    public boolean onInfo(MediaPlayer mediaplayer, int j, int k)
    {
        if (j == 701 && !StreamSenseMediaPlayer.b(a) && !StreamSenseMediaPlayer.c(a))
        {
            StreamSenseMediaPlayer.d(a);
        } else
        if (j == 702 && !StreamSenseMediaPlayer.b(a) && StreamSenseMediaPlayer.c(a))
        {
            StreamSenseMediaPlayer.e(a);
        }
        if (StreamSenseMediaPlayer.f(a) != null)
        {
            return StreamSenseMediaPlayer.f(a).onInfo(mediaplayer, j, k);
        } else
        {
            return true;
        }
    }
}
