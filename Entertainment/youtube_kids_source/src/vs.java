// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;

final class vs
    implements android.media.MediaPlayer.OnCompletionListener
{

    final AudioManager a;
    private vq b;

    vs(vq vq1, AudioManager audiomanager)
    {
        b = vq1;
        a = audiomanager;
        super();
    }

    public final void onCompletion(MediaPlayer mediaplayer)
    {
        vq.e(b).postDelayed(new vt(this), 1500L);
    }
}
