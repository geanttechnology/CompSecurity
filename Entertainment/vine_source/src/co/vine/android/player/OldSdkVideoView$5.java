// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.player;

import android.media.MediaPlayer;

// Referenced classes of package co.vine.android.player:
//            OldSdkVideoView

class this._cls0
    implements android.media.Listener
{

    final OldSdkVideoView this$0;

    public boolean onInfo(MediaPlayer mediaplayer, int i, int j)
    {
        if (OldSdkVideoView.access$1700(OldSdkVideoView.this) != null)
        {
            OldSdkVideoView.access$1700(OldSdkVideoView.this).onInfo(mediaplayer, i, j);
        }
        return true;
    }

    ()
    {
        this$0 = OldSdkVideoView.this;
        super();
    }
}
