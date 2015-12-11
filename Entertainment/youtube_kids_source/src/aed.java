// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.media.MediaPlayer;

final class aed
    implements android.media.MediaPlayer.OnPreparedListener
{

    final aec this$0;

    aed(aec aec1)
    {
        this$0 = aec1;
        super();
    }

    public final void onPrepared(MediaPlayer mediaplayer)
    {
        if (aec.access$100(aec.this) == aef.PLAY_PENDING)
        {
            aec.access$102(aec.this, aef.VIDEO_VIEW_PREPARED);
            aec.access$200(aec.this);
            return;
        } else
        {
            aec.access$102(aec.this, aef.VIDEO_VIEW_PREPARED);
            return;
        }
    }
}
