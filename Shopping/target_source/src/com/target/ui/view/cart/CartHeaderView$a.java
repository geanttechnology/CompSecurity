// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.cart;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

// Referenced classes of package com.target.ui.view.cart:
//            CartHeaderView

private class cartFullBannerView
{

    ImageButton cartFullBannerCloseButton;
    View cartFullBannerView;
    ImageButton cartMergeBannerCloseButton;
    View cartMergeBannerView;
    View freeShippingView;
    ImageButton shippingBannerCloseButton;
    TextView shippingThresholdText;
    final CartHeaderView this$0;

    public (View view)
    {
        this$0 = CartHeaderView.this;
        super();
        freeShippingView = view.findViewById(0x7f10034c);
        shippingThresholdText = (TextView)freeShippingView.findViewById(0x7f10034f);
        shippingBannerCloseButton = (ImageButton)freeShippingView.findViewById(0x7f100351);
        cartMergeBannerView = view.findViewById(0x7f10031b);
        cartMergeBannerCloseButton = (ImageButton)cartMergeBannerView.findViewById(0x7f10031c);
        cartFullBannerView = view.findViewById(0x7f100313);
        cartFullBannerCloseButton = (ImageButton)cartFullBannerView.findViewById(0x7f100314);
    }
}
