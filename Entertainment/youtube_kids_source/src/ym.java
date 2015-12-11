// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.media.MediaPlayer;
import com.google.android.apps.youtube.kids.activities.ScalingVideoView;

public final class ym
    implements android.media.MediaPlayer.OnCompletionListener
{

    private ScalingVideoView a;

    public ym(ScalingVideoView scalingvideoview)
    {
        a = scalingvideoview;
        super();
    }

    public final void onCompletion(MediaPlayer mediaplayer)
    {
        ScalingVideoView.a(a, 7);
        if (ScalingVideoView.d(a) != null)
        {
            ScalingVideoView.d(a).onCompletion(mediaplayer);
        }
    }
}
