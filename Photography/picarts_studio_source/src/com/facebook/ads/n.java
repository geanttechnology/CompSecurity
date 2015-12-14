// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads;

import android.media.MediaPlayer;

// Referenced classes of package com.facebook.ads:
//            VideoAdActivity

class n
    implements android.media.MediaPlayer.OnPreparedListener
{

    final VideoAdActivity a;

    n(VideoAdActivity videoadactivity)
    {
        a = videoadactivity;
        super();
    }

    public void onPrepared(MediaPlayer mediaplayer)
    {
        VideoAdActivity.access$602(a, mediaplayer);
        if (VideoAdActivity.access$700(a))
        {
            VideoAdActivity.access$600(a).setVolume(0.0F, 0.0F);
        } else
        {
            VideoAdActivity.access$600(a).setVolume(1.0F, 1.0F);
        }
        VideoAdActivity.access$100(a);
        if (VideoAdActivity.access$800(a) == VideoAdActivity.a.d || VideoAdActivity.access$800(a) == VideoAdActivity.a.e)
        {
            VideoAdActivity.access$600(a).seekTo(VideoAdActivity.access$900(a));
        } else
        {
            if (VideoAdActivity.access$800(a) == VideoAdActivity.a.c)
            {
                VideoAdActivity.access$600(a).seekTo(VideoAdActivity.access$900(a));
                VideoAdActivity.access$1000(a);
                return;
            }
            if (VideoAdActivity.access$800(a) == VideoAdActivity.a.a)
            {
                VideoAdActivity.access$1100(a, VideoAdActivity.a.b);
                VideoAdActivity.access$1000(a);
                return;
            }
        }
    }
}
