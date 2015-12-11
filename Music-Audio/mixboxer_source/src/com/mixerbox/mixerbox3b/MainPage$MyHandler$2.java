// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b;

import android.view.animation.Animation;
import android.widget.RelativeLayout;

// Referenced classes of package com.mixerbox.mixerbox3b:
//            MainPage

class val.theActivity
    implements android.view.animation.stener
{

    final m this$0;
    final MainPage val$theActivity;

    public void onAnimationEnd(Animation animation)
    {
        val$theActivity.rlPanelBottom.setVisibility(8);
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    tener()
    {
        this$0 = final_tener;
        val$theActivity = MainPage.this;
        super();
    }
}
