// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b;

import android.view.animation.Animation;
import android.widget.ImageView;

class val.zoom3
    implements android.view.animation.tionListener
{

    final val.b2 this$1;
    final ImageView val$b2;
    final ImageView val$b3;
    final Animation val$zoom3;

    public void onAnimationEnd(Animation animation)
    {
        val$b3.startAnimation(val$zoom3);
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
        val$b2.setVisibility(0);
    }

    ionListener()
    {
        this$1 = final_ionlistener;
        val$b2 = imageview;
        val$b3 = imageview1;
        val$zoom3 = Animation.this;
        super();
    }
}
