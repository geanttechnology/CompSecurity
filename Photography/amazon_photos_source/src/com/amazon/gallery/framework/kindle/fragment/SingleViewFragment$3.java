// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.fragment;

import android.animation.ValueAnimator;
import android.view.View;

// Referenced classes of package com.amazon.gallery.framework.kindle.fragment:
//            SingleViewFragment

class val.view
    implements android.animation.rUpdateListener
{

    final SingleViewFragment this$0;
    final View val$view;

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        val$view.setBackgroundColor(((Integer)valueanimator.getAnimatedValue()).intValue());
    }

    ()
    {
        this$0 = final_singleviewfragment;
        val$view = View.this;
        super();
    }
}
