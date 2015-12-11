// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.view.animation.Animation;
import android.widget.ImageView;

// Referenced classes of package com.groupon.view:
//            HotelsLoadingScreen

class val.forever
    implements android.view.animation.tener
{

    final HotelsLoadingScreen this$0;
    final boolean val$forever;
    final int val$imageIndex;
    final ImageView val$imageView;
    final int val$images[];

    public void onAnimationEnd(Animation animation)
    {
        if (val$images.length - 1 > val$imageIndex)
        {
            HotelsLoadingScreen.access$200(HotelsLoadingScreen.this, val$imageView, val$images, val$imageIndex + 1, val$forever);
        } else
        if (val$forever)
        {
            HotelsLoadingScreen.access$200(HotelsLoadingScreen.this, val$imageView, val$images, 0, val$forever);
            return;
        }
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    ionListener()
    {
        this$0 = final_hotelsloadingscreen;
        val$images = ai;
        val$imageIndex = i;
        val$imageView = imageview;
        val$forever = Z.this;
        super();
    }
}
