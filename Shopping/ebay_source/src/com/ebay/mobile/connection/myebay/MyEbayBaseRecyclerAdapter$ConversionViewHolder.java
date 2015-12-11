// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.connection.myebay;

import android.view.View;

// Referenced classes of package com.ebay.mobile.connection.myebay:
//            MyEbayBaseRecyclerAdapter

public class currencyText extends com.ebay.mobile.widget.er
{

    private final View currencyText;
    final MyEbayBaseRecyclerAdapter this$0;

    protected void onBindView(int i, int j)
    {
        if (hasCurrencyConversion && j + 1 == getListCount())
        {
            currencyText.setVisibility(0);
            return;
        } else
        {
            currencyText.setVisibility(8);
            return;
        }
    }

    public (View view)
    {
        this$0 = MyEbayBaseRecyclerAdapter.this;
        super(view);
        currencyText = view.findViewById(0x7f1003b8);
    }
}
