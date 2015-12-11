// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.player;

import android.media.MediaPlayer;

// Referenced classes of package co.vine.android.player:
//            SdkVideoView

class this._cls0
    implements android.media.ideoSizeChangedListener
{

    final SdkVideoView this$0;

    public void onVideoSizeChanged(MediaPlayer mediaplayer, int i, int j)
    {
        try
        {
            SdkVideoView.this.onVideoSizeChanged(mediaplayer.getVideoWidth(), mediaplayer.getVideoHeight());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediaPlayer mediaplayer)
        {
            return;
        }
    }

    hangedListener()
    {
        this$0 = SdkVideoView.this;
        super();
    }
}
