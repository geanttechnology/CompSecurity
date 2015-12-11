// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.ebay.mobile.activities.ModalActivity;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import java.util.Iterator;
import java.util.List;

public class ChangeShippingMethodActivity extends ModalActivity
    implements android.view.View.OnClickListener
{

    public static final String EXTRA_CART_LINE_ITEM_ID = "cart_line_item_id";
    public static final String EXTRA_LOGISTICS_PLAN_OPTIONS = "logistics_plans";
    public static final String EXTRA_SELECTED_PLAN_OPTION_ID = "selected_plan_option_id";
    private String cartLineItemId;
    private List planList;
    private LinearLayout planListContainer;
    private String selectedId;

    public ChangeShippingMethodActivity()
    {
    }

    private View renderOption(com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.PlanStep.PlanOption planoption, ViewGroup viewgroup)
    {
        View view = null;
        if (planoption != null)
        {
            boolean flag = DeviceConfiguration.getAsync().get(com.ebay.mobile.dcs.Dcs.App.B.ebayPlus);
            Object obj = planoption.getDeliveryDateMin();
            java.util.Date date = planoption.getDeliveryDateMax();
            boolean flag1 = planoption.getName().equals("eBayPlus");
            TextView textview;
            RadioButton radiobutton;
            TextView textview1;
            if (flag1 && flag)
            {
                view = getLayoutInflater().inflate(0x7f0302ba, viewgroup, false);
            } else
            {
                view = getLayoutInflater().inflate(0x7f0302b9, viewgroup, false);
            }
            viewgroup = (TextView)view.findViewById(0x7f10096c);
            textview1 = (TextView)view.findViewById(0x7f10096e);
            textview = (TextView)view.findViewById(0x7f10096d);
            radiobutton = (RadioButton)view.findViewById(0x7f10096f);
            if (viewgroup != null)
            {
                viewgroup.setText(planoption.getName());
            }
            viewgroup = planoption.getLogisticsCost();
            if (viewgroup != null && viewgroup.isGreaterThanZero())
            {
                viewgroup = EbayCurrencyUtil.formatDisplay(viewgroup, 2);
            } else
            {
                viewgroup = getString(0x7f070421);
            }
            textview1.setText(viewgroup);
            if (obj != null)
            {
                if (flag1 && flag)
                {
                    viewgroup = Util.getDeliveryDateStrings(getApplicationContext(), ((java.util.Date) (obj)), date);
                    obj = planoption.getEbayPlusCutOffTime(DateFormat.is24HourFormat(this));
                    if (viewgroup.length == 1)
                    {
                        if (obj != null)
                        {
                            viewgroup = getString(0x7f070ca1, new Object[] {
                                viewgroup[0], obj
                            });
                        } else
                        {
                            viewgroup = getString(0x7f070ca2, new Object[] {
                                viewgroup[0]
                            });
                        }
                    } else
                    if (obj != null)
                    {
                        viewgroup = getString(0x7f070c9f, new Object[] {
                            viewgroup[0], viewgroup[1], obj
                        });
                    } else
                    {
                        viewgroup = getString(0x7f070ca0, new Object[] {
                            viewgroup[0], viewgroup[1]
                        });
                    }
                } else
                {
                    viewgroup = Util.getDeliveryDateString(getApplicationContext(), ((java.util.Date) (obj)), date);
                }
                textview.setText(viewgroup);
                textview.setVisibility(0);
            } else
            {
                textview.setVisibility(8);
            }
            radiobutton.setChecked(planoption.logisticsOptionIdentifier.equals(selectedId));
        }
        view.setTag(planoption);
        view.setOnClickListener(this);
        return view;
    }

    private void renderOptions(LinearLayout linearlayout, List list)
    {
        linearlayout.removeAllViews();
        for (list = list.iterator(); list.hasNext(); linearlayout.addView(renderOption((com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.PlanStep.PlanOption)list.next(), linearlayout))) { }
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131757419: 
            selectedId = ((com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.PlanStep.PlanOption)view.getTag()).logisticsOptionIdentifier;
            renderOptions(planListContainer, planList);
            return;

        case 2131757418: 
            view = new Intent();
            view.putExtra("cart_line_item_id", cartLineItemId);
            view.putExtra("selected_plan_option_id", selectedId);
            setResult(-1, view);
            finish();
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0302b8);
        bundle = getIntent();
        planList = (List)bundle.getSerializableExtra("logistics_plans");
        cartLineItemId = bundle.getStringExtra("cart_line_item_id");
        planListContainer = (LinearLayout)findViewById(0x7f100969);
        bundle = planList.iterator();
        do
        {
            if (!bundle.hasNext())
            {
                break;
            }
            com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.PlanStep.PlanOption planoption = (com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.PlanStep.PlanOption)bundle.next();
            if (planoption.selected)
            {
                selectedId = planoption.logisticsOptionIdentifier;
            }
        } while (true);
        renderOptions(planListContainer, planList);
        findViewById(0x7f10096a).setOnClickListener(this);
        showBackButton();
        hideCloseButton();
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        return false;
    }

    protected void onResume()
    {
        super.onResume();
        (new TrackingData("CheckoutShippingMethodPicker", TrackingType.PAGE_IMPRESSION)).send(this);
    }
}
