// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.views;

import android.media.MediaPlayer;
import android.util.Log;
import android.widget.MediaController;

// Referenced classes of package com.gotv.crackle.views:
//            FanhattanVideoView

class this._cls0
    implements android.media.ionListener
{

    final FanhattanVideoView this$0;

    public void onCompletion(MediaPlayer mediaplayer)
    {
        Log.i(FanhattanVideoView.access$000(FanhattanVideoView.this), "OnCompletion.");
        FanhattanVideoView.access$602(FanhattanVideoView.this, 5);
        FanhattanVideoView.access$1602(FanhattanVideoView.this, 5);
        if (FanhattanVideoView.access$900(FanhattanVideoView.this) != null)
        {
            FanhattanVideoView.access$900(FanhattanVideoView.this).hide();
        }
        mediaplayer = FanhattanVideoView.access$1700(FanhattanVideoView.this);
        if (mediaplayer != null)
        {
            mediaplayer.onCompletion(FanhattanVideoView.access$1100(FanhattanVideoView.this));
        }
    }

    er()
    {
        this$0 = FanhattanVideoView.this;
        super();
    }
}
