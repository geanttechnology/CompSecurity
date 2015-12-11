// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.goods.shoppingcart.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

// Referenced classes of package com.groupon.goods.shoppingcart.view:
//            ShoppingCartFlyout

private class initialVisibility extends AnimatorListenerAdapter
{

    private final int initialVisibility;
    final ShoppingCartFlyout this$0;

    public void onAnimationEnd(Animator animator)
    {
        stopPositionAnimation();
        animator = ShoppingCartFlyout.this;
        byte byte0;
        if (initialVisibility == 0)
        {
            byte0 = 4;
        } else
        {
            byte0 = 0;
        }
        animator.setVisibility(byte0);
    }

    public (int i)
    {
        this$0 = ShoppingCartFlyout.this;
        super();
        initialVisibility = i;
    }
}
