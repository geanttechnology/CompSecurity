// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.views;

import android.media.MediaPlayer;
import android.util.Log;

// Referenced classes of package com.gotv.crackle.views:
//            FanhattanVideoView

class this._cls0
    implements android.media.tener
{

    final FanhattanVideoView this$0;

    public boolean onInfo(MediaPlayer mediaplayer, int i, int j)
    {
        Log.i(FanhattanVideoView.access$000(FanhattanVideoView.this), (new StringBuilder()).append("OnInfo called with what/extra : ").append(i).append("/").append(j).toString());
        if (i == 1002)
        {
            FanhattanVideoView.access$1900(FanhattanVideoView.this, j);
            return true;
        }
        if (FanhattanVideoView.access$2000(FanhattanVideoView.this) != null)
        {
            return FanhattanVideoView.access$2000(FanhattanVideoView.this).onInfo(mediaplayer, i, j);
        } else
        {
            return false;
        }
    }

    ()
    {
        this$0 = FanhattanVideoView.this;
        super();
    }
}
