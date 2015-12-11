// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.player;

import android.media.MediaPlayer;

// Referenced classes of package co.vine.android.player:
//            SdkVideoView

class this._cls0
    implements android.media.ufferingUpdateListener
{

    final SdkVideoView this$0;

    public void onBufferingUpdate(MediaPlayer mediaplayer, int i)
    {
        SdkVideoView.access$2202(SdkVideoView.this, i);
    }

    pdateListener()
    {
        this$0 = SdkVideoView.this;
        super();
    }
}
