// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.view.ViewGroup;
import android.view.animation.Animation;
import co.vine.android.animation.SimpleAnimationListener;

// Referenced classes of package co.vine.android.widget:
//            TooltipOverlayView

class tener extends SimpleAnimationListener
{

    final TooltipOverlayView this$0;

    public void onAnimationEnd(Animation animation)
    {
        setVisibility(8);
        animation = (ViewGroup)getParent();
        if (animation != null)
        {
            animation.removeView(TooltipOverlayView.this);
        }
    }

    tener()
    {
        this$0 = TooltipOverlayView.this;
        super();
    }
}
