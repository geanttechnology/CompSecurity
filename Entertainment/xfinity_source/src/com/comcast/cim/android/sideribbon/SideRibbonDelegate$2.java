// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.sideribbon;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.comcast.cim.android.accessibility.AccessibilityUtil;

// Referenced classes of package com.comcast.cim.android.sideribbon:
//            SideRibbonDelegate

class val.shadowWidth
    implements android.view.animation.stener
{

    final SideRibbonDelegate this$0;
    final AccessibilityUtil val$accessibilityUtil;
    final int val$shadowWidth;

    public void onAnimationEnd(Animation animation)
    {
        animation = (android.view.tParams)SideRibbonDelegate.access$600(SideRibbonDelegate.this).getLayoutParams();
        animation.setMargins(SideRibbonDelegate.access$700(SideRibbonDelegate.this), 0, -SideRibbonDelegate.access$700(SideRibbonDelegate.this), 0);
        SideRibbonDelegate.access$600(SideRibbonDelegate.this).setLayoutParams(animation);
        animation = (android.view.tParams)SideRibbonDelegate.access$800(SideRibbonDelegate.this).getLayoutParams();
        animation.setMargins(SideRibbonDelegate.access$700(SideRibbonDelegate.this) - val$shadowWidth, 0, -SideRibbonDelegate.access$700(SideRibbonDelegate.this) - val$shadowWidth, 0);
        SideRibbonDelegate.access$800(SideRibbonDelegate.this).setLayoutParams(animation);
        SideRibbonDelegate.access$400(SideRibbonDelegate.this).getLayoutParams().width = SideRibbonDelegate.access$700(SideRibbonDelegate.this);
        SideRibbonDelegate.access$400(SideRibbonDelegate.this).requestLayout();
        SideRibbonDelegate.access$400(SideRibbonDelegate.this).requestFocus();
        SideRibbonDelegate.access$500(SideRibbonDelegate.this, ate.OPEN);
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
        SideRibbonDelegate.access$400(SideRibbonDelegate.this).setVisibility(0);
        SideRibbonDelegate.access$500(SideRibbonDelegate.this, ate.IN_PROGRESS);
        if (val$accessibilityUtil.isAccessibilityEnabled())
        {
            val$accessibilityUtil.toggleScreenFocus(focusToggleState, SideRibbonDelegate.access$600(SideRibbonDelegate.this), SideRibbonDelegate.access$600(SideRibbonDelegate.this), true, true);
        }
    }

    ate()
    {
        this$0 = final_sideribbondelegate;
        val$accessibilityUtil = accessibilityutil;
        val$shadowWidth = I.this;
        super();
    }
}
