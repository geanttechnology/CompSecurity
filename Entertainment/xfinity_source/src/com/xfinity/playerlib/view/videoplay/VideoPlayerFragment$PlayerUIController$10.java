// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.videoplay;

import android.content.DialogInterface;
import com.comcast.playerplatform.primetime.android.enums.PlayerStatus;
import com.xfinity.playerlib.model.videoplay.adobeplayer.VideoStateController;

// Referenced classes of package com.xfinity.playerlib.view.videoplay:
//            VideoPlayerFragment, PlayerPlatformMediaPlayer

class this._cls1
    implements android.content.layerUIController._cls10
{

    final rtMainControlTimeout this$1;

    public void onCancel(DialogInterface dialoginterface)
    {
        if (VideoPlayerFragment.access$500(_fld0).getMediaPlayer().getPlayerStatus() == PlayerStatus.PLAYING)
        {
            rtMainControlTimeout();
        }
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
