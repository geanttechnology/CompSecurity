// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.controller;

import android.content.Context;
import android.view.animation.Animation;
import com.groupon.mvc.view.DealDetailsBottomBarView;

// Referenced classes of package com.groupon.mvc.controller:
//            BottomBarController

private class <init>
    implements android.view.animation.ner
{

    final BottomBarController this$0;

    public void onAnimationEnd(Animation animation)
    {
        if (animation == BottomBarController.access$2200(BottomBarController.this) && !BottomBarController.access$1800(BottomBarController.this))
        {
            animation = BottomBarController.access$800(BottomBarController.this).getString(0x7f080054);
            BottomBarController.access$2400(BottomBarController.this).startBuyButtonTextAnimation(animation, BottomBarController.access$2300(BottomBarController.this));
        }
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    private ()
    {
        this$0 = BottomBarController.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
