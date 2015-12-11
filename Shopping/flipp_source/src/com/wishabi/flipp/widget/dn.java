// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

// Referenced classes of package com.wishabi.flipp.widget:
//            ds, ShoppingListPopup, dq

final class dn extends AnimatorListenerAdapter
{

    final ShoppingListPopup a;

    dn(ShoppingListPopup shoppinglistpopup)
    {
        a = shoppinglistpopup;
        super();
    }

    public final void onAnimationCancel(Animator animator)
    {
        ShoppingListPopup.a(a, ds.c);
    }

    public final void onAnimationEnd(Animator animator)
    {
        ShoppingListPopup.d(a).setAlpha(0.0F);
        ShoppingListPopup.e(a).setAlpha(1.0F);
        if (ShoppingListPopup.a(a) == ds.e)
        {
            ShoppingListPopup.a(a, new dq(a, ShoppingListPopup.f(a)));
        }
    }

    public final void onAnimationStart(Animator animator)
    {
        ShoppingListPopup.c(a).setVisibility(8);
        ShoppingListPopup.a(a, ds.e);
    }
}
