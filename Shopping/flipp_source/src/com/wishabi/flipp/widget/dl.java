// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

// Referenced classes of package com.wishabi.flipp.widget:
//            ds, ShoppingListPopup

final class dl extends AnimatorListenerAdapter
{

    final ShoppingListPopup a;

    dl(ShoppingListPopup shoppinglistpopup)
    {
        a = shoppinglistpopup;
        super();
    }

    public final void onAnimationEnd(Animator animator)
    {
        ShoppingListPopup.a(a, ds.c);
    }

    public final void onAnimationStart(Animator animator)
    {
        ShoppingListPopup.a(a, ds.b);
    }
}
