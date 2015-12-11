// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b;

import android.view.animation.Animation;
import android.widget.ImageView;

class val.zoom2
    implements android.view.animation.tionListener
{

    final val.b1 this$1;
    final ImageView val$b1;
    final ImageView val$b2;
    final Animation val$zoom2;

    public void onAnimationEnd(Animation animation)
    {
        val$b2.startAnimation(val$zoom2);
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
        val$b1.setVisibility(0);
    }

    ionListener()
    {
        this$1 = final_ionlistener;
        val$b1 = imageview;
        val$b2 = imageview1;
        val$zoom2 = Animation.this;
        super();
    }
}
