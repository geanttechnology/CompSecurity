// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.media.MediaPlayer;
import android.os.Handler;
import com.google.android.apps.youtube.kids.activities.SplashScreenActivity;

public final class zd
    implements android.media.MediaPlayer.OnCompletionListener
{

    final SplashScreenActivity a;

    public zd(SplashScreenActivity splashscreenactivity)
    {
        a = splashscreenactivity;
        super();
    }

    public final void onCompletion(MediaPlayer mediaplayer)
    {
        SplashScreenActivity.e(a).postDelayed(new ze(this), 300L);
    }
}
