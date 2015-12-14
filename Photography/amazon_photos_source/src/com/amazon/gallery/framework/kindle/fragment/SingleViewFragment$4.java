// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.fragment;

import android.animation.ValueAnimator;
import android.widget.TextView;

// Referenced classes of package com.amazon.gallery.framework.kindle.fragment:
//            SingleViewFragment

class val.textView
    implements android.animation.rUpdateListener
{

    final SingleViewFragment this$0;
    final TextView val$textView;

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        val$textView.setTextColor(((Integer)valueanimator.getAnimatedValue()).intValue());
    }

    ()
    {
        this$0 = final_singleviewfragment;
        val$textView = TextView.this;
        super();
    }
}
