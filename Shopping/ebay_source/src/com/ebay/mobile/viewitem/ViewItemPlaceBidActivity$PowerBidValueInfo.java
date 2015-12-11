// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.view.View;
import android.widget.TextView;
import com.ebay.nautilus.domain.data.ItemCurrency;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ViewItemPlaceBidActivity

private class amount
{

    public final ItemCurrency amount;
    public final String amountStr;
    public final View layout;
    public final TextView textview;
    final ViewItemPlaceBidActivity this$0;

    public I(TextView textview1, View view, String s, ItemCurrency itemcurrency)
    {
        this$0 = ViewItemPlaceBidActivity.this;
        super();
        textview = textview1;
        layout = view;
        amountStr = s;
        amount = itemcurrency;
    }
}
