// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.cart;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

// Referenced classes of package com.target.ui.view.cart:
//            CartHeaderView

class  extends AnimatorListenerAdapter
{

    final CartHeaderView this$0;

    public void onAnimationEnd(Animator animator)
    {
        if (!CartHeaderView.a(CartHeaderView.this))
        {
            CartHeaderView.b(CartHeaderView.this);
        }
    }

    ()
    {
        this$0 = CartHeaderView.this;
        super();
    }
}
