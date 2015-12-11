// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.goods.shoppingcart.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

public class ShoppingCartInAppMessageView extends RelativeLayout
{

    public ShoppingCartInAppMessageView(Context context)
    {
        this(context, null, 0);
    }

    public ShoppingCartInAppMessageView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public ShoppingCartInAppMessageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        inflate(context, 0x7f03005c, this);
    }

    public void setOnClickListener(android.view.View.OnClickListener onclicklistener)
    {
        super.setOnClickListener(null);
        findViewById(0x7f100184).setOnClickListener(onclicklistener);
    }
}
