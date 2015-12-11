// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.youraccount;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Checkable;
import android.widget.CheckedTextView;
import android.widget.ListView;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.TaskCallbackFactory;
import com.amazon.mShop.TitleProvider;
import com.amazon.mShop.control.account.OneClickController;
import com.amazon.mShop.ui.resources.PaymentFormat;
import com.amazon.rio.j2me.client.services.mShop.OneClickAddress;
import com.amazon.rio.j2me.client.services.mShop.PaymentMethod;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PaymentMethodView extends ListView
    implements TitleProvider
{

    public PaymentMethodView(final AmazonActivity final_context, final OneClickAddress selectedOneClickAddress, final List paymentMethods, View view, final OneClickController controller)
    {
        super(final_context);
        setHeaderDividersEnabled(false);
        addHeaderView(LayoutInflater.from(getContext()).inflate(com.amazon.mShop.android.lib.R.layout.oneclick_settings_payment_method_header, null), null, false);
        view = controller.getSelectedPaymentMethod();
        ArrayList arraylist = new ArrayList();
        CheckedTextView checkedtextview;
        for (Iterator iterator = paymentMethods.iterator(); iterator.hasNext(); arraylist.add(checkedtextview))
        {
            PaymentMethod paymentmethod = (PaymentMethod)iterator.next();
            checkedtextview = (CheckedTextView)LayoutInflater.from(getContext()).inflate(com.amazon.mShop.android.lib.R.layout.picker_item, null);
            String s = PaymentFormat.formatPaymentMethod(paymentmethod);
            checkedtextview.setChecked(paymentmethod.equals(view));
            checkedtextview.setText(s);
        }

        view = (View[])arraylist.toArray(new View[0]);
        setAdapter(new ArrayAdapter(com.amazon.mShop.android.lib.R.layout.oneclick_settings_shipping_payment_method, view, view) {

            final PaymentMethodView this$0;
            final View val$viewsArray[];

            public View getView(int i, View view1, ViewGroup viewgroup)
            {
                return viewsArray[i];
            }

            
            {
                this$0 = PaymentMethodView.this;
                viewsArray = aview1;
                super(final_context, i, aview);
            }
        });
        setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final PaymentMethodView this$0;
            final AmazonActivity val$amazonActivity;
            final OneClickController val$controller;
            final List val$paymentMethods;
            final OneClickAddress val$selectedOneClickAddress;

            public void onItemClick(AdapterView adapterview, View view1, int i, long l)
            {
                int j = i - getHeaderViewsCount();
                if (j >= 0 && j <= paymentMethods.size())
                {
                    i = 0;
                    while (i < adapterview.getChildCount()) 
                    {
                        View view2 = adapterview.getChildAt(i);
                        if (view2 instanceof Checkable)
                        {
                            Checkable checkable = (Checkable)view2;
                            boolean flag;
                            if (view2 == view1)
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
                    if (!controller.hasServiceCallRunning())
                    {
                        adapterview = (PaymentMethod)paymentMethods.get(j);
                        view1 = new TaskCallbackFactory(amazonActivity);
                        controller.setSelectedOneClickAddress(selectedOneClickAddress);
                        controller.setSelectedPaymentMethod(adapterview);
                        controller.doSetOneClickConfig(view1.getPopViewTaskCallback(controller, amazonActivity, com.amazon.mShop.android.lib.R.string.one_click_settings_saving_shipping_payment_method));
                        amazonActivity.popView();
                        return;
                    }
                }
            }

            
            {
                this$0 = PaymentMethodView.this;
                paymentMethods = list;
                controller = oneclickcontroller;
                amazonActivity = amazonactivity;
                selectedOneClickAddress = oneclickaddress;
                super();
            }
        });
    }

    public volatile CharSequence getTitle()
    {
        return getTitle();
    }

    public String getTitle()
    {
        return getContext().getString(com.amazon.mShop.android.lib.R.string.one_click_settings_payment_method_title);
    }
}
