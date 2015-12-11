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
import android.widget.CheckedTextView;
import android.widget.ListView;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.TaskCallbackFactory;
import com.amazon.mShop.TitleProvider;
import com.amazon.mShop.control.account.OneClickController;
import com.amazon.mShop.ui.resources.AddressFormat;
import com.amazon.mShop.ui.resources.PaymentFormat;
import com.amazon.mShop.util.UIUtils;
import com.amazon.rio.j2me.client.services.mShop.OneClickAddress;
import com.amazon.rio.j2me.client.services.mShop.PaymentMethod;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.mShop.youraccount:
//            PaymentMethodView

public class ShippingPaymentMethodView extends ListView
    implements TitleProvider
{

    private CheckedTextView currentCheckedTextView;

    public ShippingPaymentMethodView(final AmazonActivity final_context, OneClickAddress oneclickaddress, final List oneClickAddresses, final OneClickController controller)
    {
        super(final_context);
        currentCheckedTextView = null;
        setHeaderDividersEnabled(false);
        Object obj = LayoutInflater.from(getContext()).inflate(com.amazon.mShop.android.lib.R.layout.oneclick_settings_shipping_payment_method_header, null);
        addHeaderView(((View) (obj)), null, false);
        if (oneClickAddresses.size() < 1)
        {
            ((View) (obj)).findViewById(com.amazon.mShop.android.lib.R.id.choose_default_address_and_payment_title).setVisibility(8);
        }
        obj = new ArrayList();
        int i = 0;
        while (i < oneClickAddresses.size()) 
        {
            OneClickAddress oneclickaddress1 = (OneClickAddress)oneClickAddresses.get(i);
            if (oneclickaddress1.getAddress() != null)
            {
                List list = oneclickaddress1.getPaymentMethod();
                if (list != null && list.size() >= 1)
                {
                    CheckedTextView checkedtextview = (CheckedTextView)LayoutInflater.from(getContext()).inflate(com.amazon.mShop.android.lib.R.layout.picker_item, null);
                    if (oneclickaddress1.equals(oneclickaddress))
                    {
                        checkedtextview.setChecked(true);
                        currentCheckedTextView = checkedtextview;
                    }
                    checkedtextview.setText(getShippingPaymentMethod(oneclickaddress1));
                    ((List) (obj)).add(checkedtextview);
                }
            }
            i++;
        }
        oneclickaddress = (View[])((List) (obj)).toArray(new View[0]);
        setAdapter(new ArrayAdapter(com.amazon.mShop.android.lib.R.layout.oneclick_settings_shipping_payment_method, oneclickaddress, oneclickaddress) {

            final ShippingPaymentMethodView this$0;
            final View val$viewsArray[];

            public View getView(int j, View view, ViewGroup viewgroup)
            {
                return viewsArray[j];
            }

            
            {
                this$0 = ShippingPaymentMethodView.this;
                viewsArray = aview1;
                super(final_context, i, aview);
            }
        });
        setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final ShippingPaymentMethodView this$0;
            final AmazonActivity val$amazonActivity;
            final OneClickController val$controller;
            final List val$oneClickAddresses;

            public void onItemClick(AdapterView adapterview, View view, int j, long l)
            {
label0:
                {
                    if (!controller.hasServiceCallRunning())
                    {
                        j -= getHeaderViewsCount();
                        if (j >= 0 && j <= oneClickAddresses.size())
                        {
                            break label0;
                        }
                        UIUtils.alert(amazonActivity);
                    }
                    return;
                }
                adapterview = (OneClickAddress)oneClickAddresses.get(j);
                List list1 = adapterview.getPaymentMethod();
                if (list1 == null || list1.size() < 1)
                {
                    UIUtils.alert(amazonActivity);
                    amazonActivity.popView();
                    return;
                }
                if (list1.size() == 1)
                {
                    if (currentCheckedTextView != null)
                    {
                        currentCheckedTextView.setChecked(false);
                    }
                    ((CheckedTextView)view).setChecked(true);
                    view = new TaskCallbackFactory(amazonActivity);
                    controller.setSelectedOneClickAddress(adapterview);
                    controller.setSelectedPaymentMethod((PaymentMethod)list1.get(0));
                    controller.doSetOneClickConfig(view.getPopViewTaskCallback(controller, amazonActivity, com.amazon.mShop.android.lib.R.string.one_click_settings_saving_shipping_payment_method));
                    amazonActivity.popView();
                    return;
                } else
                {
                    swapPaymentMethodView(amazonActivity, adapterview, list1, ShippingPaymentMethodView.this, controller);
                    return;
                }
            }

            
            {
                this$0 = ShippingPaymentMethodView.this;
                controller = oneclickcontroller;
                oneClickAddresses = list;
                amazonActivity = amazonactivity;
                super();
            }
        });
    }

    private String getShippingPaymentMethod(OneClickAddress oneclickaddress)
    {
        com.amazon.rio.j2me.client.services.mShop.Address address = oneclickaddress.getAddress();
        oneclickaddress = oneclickaddress.getPaymentMethod();
        StringBuffer stringbuffer = new StringBuffer();
        AddressFormat.appendAddress(address, stringbuffer, 1);
        stringbuffer.append("\n");
        if (oneclickaddress != null && 1 == oneclickaddress.size())
        {
            PaymentFormat.appendPaymentMethod((PaymentMethod)oneclickaddress.get(0), stringbuffer);
        } else
        {
            stringbuffer.append(getContext().getString(com.amazon.mShop.android.lib.R.string.one_click_settings_select_payment_method));
        }
        return stringbuffer.toString();
    }

    public volatile CharSequence getTitle()
    {
        return getTitle();
    }

    public String getTitle()
    {
        return getContext().getString(com.amazon.mShop.android.lib.R.string.one_click_settings_shipping_payment_method_title);
    }

    protected void swapPaymentMethodView(AmazonActivity amazonactivity, OneClickAddress oneclickaddress, List list, View view, OneClickController oneclickcontroller)
    {
        amazonactivity.swapView(new PaymentMethodView(amazonactivity, oneclickaddress, list, this, oneclickcontroller));
    }

}
