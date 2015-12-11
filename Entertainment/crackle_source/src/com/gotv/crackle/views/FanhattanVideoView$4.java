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
    implements android.media.stener
{

    final FanhattanVideoView this$0;

    public boolean onError(MediaPlayer mediaplayer, int i, int j)
    {
        Log.d(FanhattanVideoView.access$000(FanhattanVideoView.this), (new StringBuilder()).append("Error: ").append(i).append(",").append(j).toString());
        FanhattanVideoView.access$602(FanhattanVideoView.this, -1);
        FanhattanVideoView.access$1602(FanhattanVideoView.this, -1);
        if (FanhattanVideoView.access$900(FanhattanVideoView.this) != null)
        {
            FanhattanVideoView.access$900(FanhattanVideoView.this).hide();
        }
        while (FanhattanVideoView.access$1800(FanhattanVideoView.this) != null && FanhattanVideoView.access$1800(FanhattanVideoView.this).onError(FanhattanVideoView.access$1100(FanhattanVideoView.this), i, j) || FanhattanVideoView.access$1700(FanhattanVideoView.this) == null) 
        {
            return true;
        }
        FanhattanVideoView.access$1700(FanhattanVideoView.this).onCompletion(FanhattanVideoView.access$1100(FanhattanVideoView.this));
        return true;
    }

    er()
    {
        this$0 = FanhattanVideoView.this;
        super();
    }
}
