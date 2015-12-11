// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.media.MediaPlayer;
import com.google.android.apps.youtube.kids.activities.ScalingVideoView;

public final class yl
    implements android.media.MediaPlayer.OnPreparedListener
{

    private ScalingVideoView a;

    public yl(ScalingVideoView scalingvideoview)
    {
        a = scalingvideoview;
        super();
    }

    public final void onPrepared(MediaPlayer mediaplayer)
    {
        if (ScalingVideoView.b(a) != null)
        {
            ScalingVideoView.b(a).onPrepared(mediaplayer);
        }
        if (ScalingVideoView.c(a) == 4)
        {
            a.a();
        }
    }
}
