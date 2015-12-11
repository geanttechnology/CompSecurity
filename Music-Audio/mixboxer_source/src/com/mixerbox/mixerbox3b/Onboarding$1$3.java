// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b;

import android.view.animation.Animation;
import android.widget.ImageView;

class val.zoom4
    implements android.view.animation.tionListener
{

    final val.b3 this$1;
    final ImageView val$b3;
    final ImageView val$b4;
    final Animation val$zoom4;

    public void onAnimationEnd(Animation animation)
    {
        val$b4.startAnimation(val$zoom4);
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
        val$b3.setVisibility(0);
    }

    ionListener()
    {
        this$1 = final_ionlistener;
        val$b3 = imageview;
        val$b4 = imageview1;
        val$zoom4 = Animation.this;
        super();
    }
}
