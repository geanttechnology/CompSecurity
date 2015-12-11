// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.view.animation.Animation;
import android.widget.TextView;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ViewItemPlaceBidActivity

class val.fadeInAnimation
    implements android.view.animation.
{

    final ViewItemPlaceBidActivity this$0;
    final Animation val$fadeInAnimation;
    final String val$value;
    final TextView val$view;

    public void onAnimationEnd(Animation animation)
    {
        if (!isFinishing())
        {
            val$view.setText(val$value);
            if (val$fadeInAnimation != null)
            {
                val$fadeInAnimation.start();
            }
        }
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    _cls9()
    {
        this$0 = final_viewitemplacebidactivity;
        val$view = textview;
        val$value = s;
        val$fadeInAnimation = Animation.this;
        super();
    }
}
