// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.player;

import android.media.MediaPlayer;

// Referenced classes of package co.vine.android.player:
//            OldSdkVideoView

class this._cls0
    implements android.media.eringUpdateListener
{

    final OldSdkVideoView this$0;

    public void onBufferingUpdate(MediaPlayer mediaplayer, int i)
    {
        OldSdkVideoView.access$1902(OldSdkVideoView.this, i);
    }

    teListener()
    {
        this$0 = OldSdkVideoView.this;
        super();
    }
}
