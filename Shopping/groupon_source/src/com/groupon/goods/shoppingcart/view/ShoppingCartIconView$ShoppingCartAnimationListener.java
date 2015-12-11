// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.goods.shoppingcart.view;

import android.view.animation.Animation;
import android.widget.TextView;

// Referenced classes of package com.groupon.goods.shoppingcart.view:
//            ShoppingCartIconView

private class <init>
    implements android.view.animation.tionListener
{

    final ShoppingCartIconView this$0;

    public void onAnimationEnd(Animation animation)
    {
        byte byte0 = 8;
        if (animation == ShoppingCartIconView.access$500(ShoppingCartIconView.this))
        {
            newBadge.setVisibility(8);
            counter.setText(String.valueOf(ShoppingCartIconView.access$600(ShoppingCartIconView.this)));
            animation = counter;
            if (ShoppingCartIconView.access$600(ShoppingCartIconView.this) > 0)
            {
                byte0 = 0;
            }
            animation.setVisibility(byte0);
            counter.startAnimation(ShoppingCartIconView.access$700(ShoppingCartIconView.this));
        }
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    private ()
    {
        this$0 = ShoppingCartIconView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
