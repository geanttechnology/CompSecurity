// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.youraccount;

import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckedTextView;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.TaskCallbackFactory;
import com.amazon.mShop.control.account.OneClickController;
import com.amazon.mShop.util.UIUtils;
import com.amazon.rio.j2me.client.services.mShop.OneClickAddress;
import com.amazon.rio.j2me.client.services.mShop.PaymentMethod;
import java.util.List;

// Referenced classes of package com.amazon.mShop.youraccount:
//            ShippingPaymentMethodView

class val.amazonActivity
    implements android.widget.ner
{

    final ShippingPaymentMethodView this$0;
    final AmazonActivity val$amazonActivity;
    final OneClickController val$controller;
    final List val$oneClickAddresses;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
label0:
        {
            if (!val$controller.hasServiceCallRunning())
            {
                i -= getHeaderViewsCount();
                if (i >= 0 && i <= val$oneClickAddresses.size())
                {
                    break label0;
                }
                UIUtils.alert(val$amazonActivity);
            }
            return;
        }
        adapterview = (OneClickAddress)val$oneClickAddresses.get(i);
        List list = adapterview.getPaymentMethod();
        if (list == null || list.size() < 1)
        {
            UIUtils.alert(val$amazonActivity);
            val$amazonActivity.popView();
            return;
        }
        if (list.size() == 1)
        {
            if (ShippingPaymentMethodView.access$000(ShippingPaymentMethodView.this) != null)
            {
                ShippingPaymentMethodView.access$000(ShippingPaymentMethodView.this).setChecked(false);
            }
            ((CheckedTextView)view).setChecked(true);
            view = new TaskCallbackFactory(val$amazonActivity);
            val$controller.setSelectedOneClickAddress(adapterview);
            val$controller.setSelectedPaymentMethod((PaymentMethod)list.get(0));
            val$controller.doSetOneClickConfig(view.getPopViewTaskCallback(val$controller, val$amazonActivity, com.amazon.mShop.android.lib.saving_shipping_payment_method));
            val$amazonActivity.popView();
            return;
        } else
        {
            swapPaymentMethodView(val$amazonActivity, adapterview, list, ShippingPaymentMethodView.this, val$controller);
            return;
        }
    }

    ()
    {
        this$0 = final_shippingpaymentmethodview;
        val$controller = oneclickcontroller;
        val$oneClickAddresses = list;
        val$amazonActivity = AmazonActivity.this;
        super();
    }
}
