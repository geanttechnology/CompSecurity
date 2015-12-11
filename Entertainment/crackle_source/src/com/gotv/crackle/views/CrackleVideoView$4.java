// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.views;

import android.media.MediaPlayer;

// Referenced classes of package com.gotv.crackle.views:
//            CrackleVideoView

class this._cls0
    implements android.media.ringUpdateListener
{

    final CrackleVideoView this$0;

    public void onBufferingUpdate(MediaPlayer mediaplayer, int i)
    {
        CrackleVideoView.access$1502(CrackleVideoView.this, i);
    }

    eListener()
    {
        this$0 = CrackleVideoView.this;
        super();
    }
}
