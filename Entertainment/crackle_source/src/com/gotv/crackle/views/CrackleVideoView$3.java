// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.views;

import android.media.MediaPlayer;
import android.widget.MediaController;

// Referenced classes of package com.gotv.crackle.views:
//            CrackleVideoView

class this._cls0
    implements android.media.etionListener
{

    final CrackleVideoView this$0;

    public void onCompletion(MediaPlayer mediaplayer)
    {
        CrackleVideoView.access$302(CrackleVideoView.this, 5);
        CrackleVideoView.access$1302(CrackleVideoView.this, 5);
        if (CrackleVideoView.access$900(CrackleVideoView.this) != null)
        {
            CrackleVideoView.access$900(CrackleVideoView.this).hide();
        }
        if (CrackleVideoView.access$1400(CrackleVideoView.this) != null)
        {
            CrackleVideoView.access$1400(CrackleVideoView.this).onCompletion(CrackleVideoView.access$800(CrackleVideoView.this));
        }
    }

    ener()
    {
        this$0 = CrackleVideoView.this;
        super();
    }
}
