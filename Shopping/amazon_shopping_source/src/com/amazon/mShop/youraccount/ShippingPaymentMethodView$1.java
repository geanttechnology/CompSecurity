// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.youraccount;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

// Referenced classes of package com.amazon.mShop.youraccount:
//            ShippingPaymentMethodView

class val.viewsArray extends ArrayAdapter
{

    final ShippingPaymentMethodView this$0;
    final View val$viewsArray[];

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        return val$viewsArray[i];
    }

    (int i, View aview[], View aview1[])
    {
        this$0 = final_shippingpaymentmethodview;
        val$viewsArray = aview1;
        super(Context.this, i, aview);
    }
}
