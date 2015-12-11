// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.player;

import android.media.MediaPlayer;
import android.widget.MediaController;

// Referenced classes of package co.vine.android.player:
//            OldSdkVideoView

class this._cls0
    implements android.media.letionListener
{

    final OldSdkVideoView this$0;

    public void onCompletion(MediaPlayer mediaplayer)
    {
        OldSdkVideoView.access$502(OldSdkVideoView.this, 5);
        OldSdkVideoView.access$1502(OldSdkVideoView.this, 5);
        if (OldSdkVideoView.access$1100(OldSdkVideoView.this) != null)
        {
            OldSdkVideoView.access$1100(OldSdkVideoView.this).hide();
        }
        if (OldSdkVideoView.access$1600(OldSdkVideoView.this) != null)
        {
            OldSdkVideoView.access$1600(OldSdkVideoView.this).onCompletion(OldSdkVideoView.this);
        }
    }

    .OnCompletionListener()
    {
        this$0 = OldSdkVideoView.this;
        super();
    }
}
