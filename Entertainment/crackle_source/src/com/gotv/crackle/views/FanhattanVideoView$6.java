// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.views;

import android.media.MediaPlayer;
import android.util.Log;

// Referenced classes of package com.gotv.crackle.views:
//            FanhattanVideoView

class this._cls0
    implements android.media.pleteListener
{

    final FanhattanVideoView this$0;

    public void onSeekComplete(MediaPlayer mediaplayer)
    {
        Log.i(FanhattanVideoView.access$000(FanhattanVideoView.this), "OnSeekComplete.");
        if (FanhattanVideoView.access$2100(FanhattanVideoView.this) != null)
        {
            FanhattanVideoView.access$2100(FanhattanVideoView.this).onSeekComplete(mediaplayer);
        }
    }

    ener()
    {
        this$0 = FanhattanVideoView.this;
        super();
    }
}
