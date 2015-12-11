// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.goods.shoppingcart;

import android.content.DialogInterface;

// Referenced classes of package com.groupon.goods.shoppingcart:
//            NewPurchaseCart

class val.position
    implements android.content.ClickListener
{

    final NewPurchaseCart this$0;
    final String val$optionUuid;
    final int val$position;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        NewPurchaseCart.access$600(NewPurchaseCart.this, true, val$optionUuid, val$position);
    }

    ()
    {
        this$0 = final_newpurchasecart;
        val$optionUuid = s;
        val$position = I.this;
        super();
    }
}
