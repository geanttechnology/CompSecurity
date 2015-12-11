// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.youraccount;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Checkable;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.TaskCallbackFactory;
import com.amazon.mShop.control.account.OneClickController;
import com.amazon.rio.j2me.client.services.mShop.OneClickAddress;
import com.amazon.rio.j2me.client.services.mShop.PaymentMethod;
import java.util.List;

// Referenced classes of package com.amazon.mShop.youraccount:
//            PaymentMethodView

class kAddress
    implements android.widget.ickListener
{

    final PaymentMethodView this$0;
    final AmazonActivity val$amazonActivity;
    final OneClickController val$controller;
    final List val$paymentMethods;
    final OneClickAddress val$selectedOneClickAddress;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        int j = i - getHeaderViewsCount();
        if (j >= 0 && j <= val$paymentMethods.size())
        {
            i = 0;
            while (i < adapterview.getChildCount()) 
            {
                View view1 = adapterview.getChildAt(i);
                if (view1 instanceof Checkable)
                {
                    Checkable checkable = (Checkable)view1;
                    boolean flag;
                    if (view1 == view)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    checkable.setChecked(flag);
                }
                i++;
            }
            if (!val$controller.hasServiceCallRunning())
            {
                adapterview = (PaymentMethod)val$paymentMethods.get(j);
                view = new TaskCallbackFactory(val$amazonActivity);
                val$controller.setSelectedOneClickAddress(val$selectedOneClickAddress);
                val$controller.setSelectedPaymentMethod(adapterview);
                val$controller.doSetOneClickConfig(view.getPopViewTaskCallback(val$controller, val$amazonActivity, com.amazon.mShop.android.lib.ettings_saving_shipping_payment_method));
                val$amazonActivity.popView();
                return;
            }
        }
    }

    kAddress()
    {
        this$0 = final_paymentmethodview;
        val$paymentMethods = list;
        val$controller = oneclickcontroller;
        val$amazonActivity = amazonactivity;
        val$selectedOneClickAddress = OneClickAddress.this;
        super();
    }
}
