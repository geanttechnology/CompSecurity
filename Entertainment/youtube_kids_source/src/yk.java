// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.media.MediaPlayer;
import com.google.android.apps.youtube.kids.activities.ScalingVideoView;

public final class yk
    implements android.media.MediaPlayer.OnVideoSizeChangedListener
{

    private ScalingVideoView a;

    public yk(ScalingVideoView scalingvideoview)
    {
        a = scalingvideoview;
        super();
    }

    public final void onVideoSizeChanged(MediaPlayer mediaplayer, int i, int j)
    {
        ScalingVideoView.a(a, j);
        ScalingVideoView.b(a, i);
        ScalingVideoView.a(a);
    }
}
