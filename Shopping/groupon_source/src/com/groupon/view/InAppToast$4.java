// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.view.animation.Animation;
import com.groupon.util.Function0;

// Referenced classes of package com.groupon.view:
//            InAppToast

class val.endCallback
    implements android.view.animation.mationListener
{

    final InAppToast this$0;
    final Function0 val$endCallback;

    public void onAnimationEnd(Animation animation)
    {
        if (val$endCallback != null)
        {
            val$endCallback.execute();
        }
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    on()
    {
        this$0 = final_inapptoast;
        val$endCallback = Function0.this;
        super();
    }
}
