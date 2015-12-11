// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.eas;

import android.view.View;
import android.view.ViewGroup;
import com.comcast.playerplatform.primetime.android.player.IPlayerPlatform;

// Referenced classes of package com.comcast.playerplatform.primetime.android.eas:
//            AlertAnimationManager, EmergencyAlertScroller

class this._cls0
    implements Runnable
{

    final AlertAnimationManager this$0;

    public void run()
    {
        if (AlertAnimationManager.access$1000(AlertAnimationManager.this).getParent() != null)
        {
            ((ViewGroup)AlertAnimationManager.access$1000(AlertAnimationManager.this).getParent()).removeView(AlertAnimationManager.access$1000(AlertAnimationManager.this));
            AlertAnimationManager.access$1000(AlertAnimationManager.this).removeView(AlertAnimationManager.access$1100(AlertAnimationManager.this));
        }
        ((ViewGroup)AlertAnimationManager.access$500(AlertAnimationManager.this).getView().getParent()).addView(AlertAnimationManager.access$1000(AlertAnimationManager.this));
    }

    ()
    {
        this$0 = AlertAnimationManager.this;
        super();
    }
}
