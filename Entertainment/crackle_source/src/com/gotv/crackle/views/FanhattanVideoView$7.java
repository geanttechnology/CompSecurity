// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.views;

import android.media.MediaPlayer;
import android.util.Log;

// Referenced classes of package com.gotv.crackle.views:
//            FanhattanVideoView

class this._cls0
    implements android.media.ngUpdateListener
{

    final FanhattanVideoView this$0;

    public void onBufferingUpdate(MediaPlayer mediaplayer, int i)
    {
        Log.i(FanhattanVideoView.access$000(FanhattanVideoView.this), (new StringBuilder()).append("OnBufferingUpdate called with percent: ").append(i).toString());
        FanhattanVideoView.access$2202(FanhattanVideoView.this, i);
        if (FanhattanVideoView.access$2300(FanhattanVideoView.this) != null)
        {
            FanhattanVideoView.access$2300(FanhattanVideoView.this).onBufferingUpdate(mediaplayer, i);
        }
    }

    istener()
    {
        this$0 = FanhattanVideoView.this;
        super();
    }
}
