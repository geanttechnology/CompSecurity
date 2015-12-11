// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

// Referenced classes of package com.groupon.fragment:
//            ForgotPasswordFragment

class val.view extends Animation
{

    final ForgotPasswordFragment this$0;
    final int val$newTargetWidth;
    final View val$view;

    protected void applyTransformation(float f, Transformation transformation)
    {
        int i;
        int j;
        if (f == 1.0F)
        {
            i = val$newTargetWidth;
        } else
        {
            i = (int)((float)val$newTargetWidth * f) + ForgotPasswordFragment.access$300(ForgotPasswordFragment.this);
        }
        j = i;
        if (i > val$newTargetWidth)
        {
            j = val$newTargetWidth;
        }
        val$view.getLayoutParams().dth = j;
        val$view.requestLayout();
    }

    public boolean willChangeBounds()
    {
        return true;
    }

    ()
    {
        this$0 = final_forgotpasswordfragment;
        val$newTargetWidth = i;
        val$view = View.this;
        super();
    }
}
