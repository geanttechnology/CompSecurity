// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.eas;

import android.view.View;
import android.widget.FrameLayout;
import com.adobe.mediacore.MediaPlayer;
import com.comcast.playerplatform.primetime.android.enums.PlayerStatus;
import com.comcast.playerplatform.primetime.android.enums.StreamType;
import com.comcast.playerplatform.primetime.android.player.IPlayerPlatform;

// Referenced classes of package com.comcast.playerplatform.primetime.android.eas:
//            AlertAnimationManager

class this._cls0
    implements Runnable
{

    final AlertAnimationManager this$0;

    public void run()
    {
        FrameLayout framelayout = (FrameLayout)AlertAnimationManager.access$500(AlertAnimationManager.this).getView();
        framelayout.removeView(AlertAnimationManager.access$400(AlertAnimationManager.this).getView());
        framelayout.addView(AlertAnimationManager.access$600(AlertAnimationManager.this));
        AlertAnimationManager.access$600(AlertAnimationManager.this).bringToFront();
        AlertAnimationManager.access$602(AlertAnimationManager.this, null);
        AlertAnimationManager.access$400(AlertAnimationManager.this).reset();
        AlertAnimationManager.access$402(AlertAnimationManager.this, null);
        if (AlertAnimationManager.access$700(AlertAnimationManager.this) == PlayerStatus.PLAYING)
        {
            AlertAnimationManager.access$500(AlertAnimationManager.this).play();
        }
        AlertAnimationManager.access$702(AlertAnimationManager.this, null);
        if (AlertAnimationManager.access$500(AlertAnimationManager.this).getVideoType().equals(StreamType.LINEAR))
        {
            AlertAnimationManager.access$500(AlertAnimationManager.this).seekToLive();
        }
    }

    ()
    {
        this$0 = AlertAnimationManager.this;
        super();
    }
}
