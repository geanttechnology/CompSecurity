// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.goods.shoppingcart;

import android.content.DialogInterface;
import com.groupon.util.DefaultGrouponDialogListenerImpl;

// Referenced classes of package com.groupon.goods.shoppingcart:
//            CartSummaryActivity

private class position extends DefaultGrouponDialogListenerImpl
{

    private final String optionUuid;
    private final int position;
    final CartSummaryActivity this$0;

    public void onDialogNegativeButtonClick(String s, DialogInterface dialoginterface)
    {
        CartSummaryActivity.access$000(CartSummaryActivity.this, false, optionUuid, position);
    }

    public void onDialogPositiveButtonClick(String s, DialogInterface dialoginterface)
    {
        CartSummaryActivity.access$000(CartSummaryActivity.this, true, optionUuid, position);
    }

    public (String s, int i)
    {
        this$0 = CartSummaryActivity.this;
        super();
        optionUuid = s;
        position = i;
    }
}
