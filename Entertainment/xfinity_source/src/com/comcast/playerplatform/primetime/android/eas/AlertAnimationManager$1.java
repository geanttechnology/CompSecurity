// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.eas;

import android.view.animation.Animation;

// Referenced classes of package com.comcast.playerplatform.primetime.android.eas:
//            AlertAnimationManager, Alert, AlertEventListener

class this._cls0
    implements android.view.animation.ner
{

    final AlertAnimationManager this$0;

    public void onAnimationEnd(Animation animation)
    {
        AlertAnimationManager.access$000(AlertAnimationManager.this);
        synchronized (AlertAnimationManager.access$100(AlertAnimationManager.this))
        {
            String s = AlertAnimationManager.access$200(AlertAnimationManager.this).getIdentifier();
            AlertAnimationManager.access$100(AlertAnimationManager.this).emergencyAlertCompleted(s, true);
            AlertAnimationManager.access$300(AlertAnimationManager.this);
        }
        return;
        exception;
        animation;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    ()
    {
        this$0 = AlertAnimationManager.this;
        super();
    }
}
