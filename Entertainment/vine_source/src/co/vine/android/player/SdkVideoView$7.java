// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.player;

import android.media.MediaPlayer;

// Referenced classes of package co.vine.android.player:
//            SdkVideoView

class this._cls0
    implements android.media.rrorListener
{

    final SdkVideoView this$0;

    public boolean onError(MediaPlayer mediaplayer, int i, int j)
    {
        SdkVideoView.access$2100(SdkVideoView.this, i, j);
        return true;
    }

    ner()
    {
        this$0 = SdkVideoView.this;
        super();
    }
}
