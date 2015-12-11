// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.poshmark.analytics.Analytics;
import com.poshmark.data_model.models.PMDiscount;
import com.poshmark.data_model.models.PMOrder;
import com.poshmark.data_model.models.inner_models.CreditCard;
import com.poshmark.data_model.models.inner_models.LineItem;
import com.poshmark.http.api.PMApi;
import com.poshmark.ui.customviews.PMTextView;
import com.poshmark.utils.AddressUtils;
import com.poshmark.utils.CheckoutFlowHandler;
import com.poshmark.utils.CreditCardUtils;
import com.poshmark.utils.CurrencyUtils;
import com.poshmark.utils.ViewUtils;
import com.poshmark.utils.view_holders.CheckoutConfirmationFormViewHolder;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.poshmark.ui.fragments:
//            CheckoutConfirmationFragment

public class BundleCheckoutConformationFragment extends CheckoutConfirmationFragment
{

    public BundleCheckoutConformationFragment()
    {
    }

    public boolean handleBack()
    {
        Object obj = flowHandler.getPoshmarkOrder();
        PMApi.releaseBundle(((PMOrder) (obj)).getOrderId(), null);
        obj = ((PMOrder) (obj)).getOrderId();
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "removed_lineitem_from_order", ((String) (obj)));
        return false;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public void setViewNameForAnalytics()
    {
        viewNameForAnalytics = "multi_item_checkout_screen";
    }

    public void setupActionBar()
    {
        super.setupActionBar();
        setTitle(getString(0x7f060078));
    }

    protected void setupView(View view)
    {
        super.setupView(view);
        viewHolder.singleItemSummaryAndPricingContainer.setVisibility(8);
        viewHolder.lineItemsLayout = (LinearLayout)view.findViewById(0x7f0c00a5);
        viewHolder.lineItemsLayout.setVisibility(0);
        viewHolder.bundleOrderPricingSummaryLayout = (LinearLayout)view.findViewById(0x7f0c00a6);
        viewHolder.bundleOrderPricingSummaryLayout.setVisibility(0);
    }

    protected void updateView()
    {
        if (current_state != CheckoutConfirmationFragment.FLOW_STATE.GATHER_DETAILS) goto _L2; else goto _L1
_L1:
        PMOrder pmorder;
        return;
_L2:
        if ((pmorder = flowHandler.getPoshmarkOrder()).getLineItems().size() <= 0 || pmorder.getShippingAmount().size() <= 0) goto _L1; else goto _L3
_L3:
        Object obj;
        Object obj1 = CurrencyUtils.getCurrencySymbol();
        obj = getActivity().getLayoutInflater();
        viewHolder.lineItemsLayout.removeAllViews();
        viewHolder.bundleOrderPricingSummaryLayout.removeAllViews();
        Object obj2 = pmorder.getLineItems().listIterator();
        while (((Iterator) (obj2)).hasNext()) 
        {
            Object obj3 = (LineItem)((Iterator) (obj2)).next();
            LinearLayout linearlayout = (LinearLayout)((LayoutInflater) (obj)).inflate(0x7f03005a, null);
            Object obj4 = (ImageView)linearlayout.findViewById(0x7f0c0162);
            ImageLoader.getInstance().displayImage(((LineItem) (obj3)).getPictureURL(), ((ImageView) (obj4)));
            ((PMTextView)linearlayout.findViewById(0x7f0c0035)).setText(((LineItem) (obj3)).getTitle());
            ((PMTextView)linearlayout.findViewById(0x7f0c0163)).setText((new StringBuilder()).append(((String) (obj1))).append(CurrencyUtils.getPriceAsWholeNumber(((LineItem) (obj3)).getPrice())).toString());
            ((PMTextView)linearlayout.findViewById(0x7f0c0164)).setText((new StringBuilder()).append(getString(0x7f060281)).append(((LineItem) (obj3)).getSize()).toString());
            obj3 = linearlayout.findViewById(0x7f0c012a);
            obj4 = linearlayout.findViewById(0x7f0c0165);
            if (((Iterator) (obj2)).hasNext())
            {
                ((View) (obj3)).setVisibility(8);
                ((View) (obj4)).setVisibility(0);
            } else
            {
                ((View) (obj3)).setVisibility(0);
                ((View) (obj4)).setVisibility(8);
            }
            viewHolder.lineItemsLayout.addView(linearlayout);
        }
        if (pmorder.getTotalOriginalPrice().doubleValue() > 0.0D)
        {
            obj1 = (LinearLayout)((LayoutInflater) (obj)).inflate(0x7f0300a5, null);
            ((PMTextView)((LinearLayout) (obj1)).findViewById(0x7f0c0270)).setText(getString(0x7f060067));
            ((PMTextView)((LinearLayout) (obj1)).findViewById(0x7f0c0163)).setText(pmorder.getTotalOriginalPriceString());
            viewHolder.bundleOrderPricingSummaryLayout.addView(((View) (obj1)));
        }
        obj1 = pmorder.getDiscounts().iterator();
        do
        {
            if (!((Iterator) (obj1)).hasNext())
            {
                break;
            }
            obj2 = (PMDiscount)((Iterator) (obj1)).next();
            if (((PMDiscount) (obj2)).getTargetType().equalsIgnoreCase("iprc"))
            {
                LinearLayout linearlayout1 = (LinearLayout)((LayoutInflater) (obj)).inflate(0x7f0300a5, null);
                ((PMTextView)linearlayout1.findViewById(0x7f0c0270)).setText(((PMDiscount) (obj2)).getTitle());
                ((PMTextView)linearlayout1.findViewById(0x7f0c0163)).setText((new StringBuilder()).append("-").append(((PMDiscount) (obj2)).getDiscountPriceString()).toString());
                viewHolder.bundleOrderPricingSummaryLayout.addView(linearlayout1);
            }
        } while (true);
        obj1 = (LinearLayout)((LayoutInflater) (obj)).inflate(0x7f0300a5, null);
        ((PMTextView)((LinearLayout) (obj1)).findViewById(0x7f0c0270)).setText(getString(0x7f060260));
        ((PMTextView)((LinearLayout) (obj1)).findViewById(0x7f0c0163)).setText(pmorder.getTotalShippingString());
        obj2 = pmorder.getShippingDiscountTitle();
        if (obj2 != null && ((String) (obj2)).length() > 0)
        {
            PMTextView pmtextview1 = (PMTextView)((LinearLayout) (obj1)).findViewById(0x7f0c0135);
            pmtextview1.setVisibility(0);
            pmtextview1.setText(((CharSequence) (obj2)));
        }
        ((LinearLayout) (obj1)).findViewById(0x7f0c0165).setVisibility(0);
        viewHolder.bundleOrderPricingSummaryLayout.addView(((View) (obj1)));
        if (pmorder.getTotalTax().compareTo(BigDecimal.ZERO) > 0)
        {
            obj1 = (LinearLayout)((LayoutInflater) (obj)).inflate(0x7f0300a5, null);
            ((PMTextView)((LinearLayout) (obj1)).findViewById(0x7f0c0270)).setText(getString(0x7f060297));
            ((PMTextView)((LinearLayout) (obj1)).findViewById(0x7f0c0163)).setText(pmorder.getTotalTaxString());
            viewHolder.bundleOrderPricingSummaryLayout.addView(((View) (obj1)));
        }
        obj1 = (LinearLayout)((LayoutInflater) (obj)).inflate(0x7f0300a5, null);
        ((PMTextView)((LinearLayout) (obj1)).findViewById(0x7f0c0270)).setText(getString(0x7f06029d));
        ((PMTextView)((LinearLayout) (obj1)).findViewById(0x7f0c0163)).setText(pmorder.getTotalString());
        viewHolder.bundleOrderPricingSummaryLayout.addView(((View) (obj1)));
        if (pmorder.getCreditsToApply().compareTo(BigDecimal.ZERO) > 0)
        {
            obj1 = (LinearLayout)((LayoutInflater) (obj)).inflate(0x7f0300a5, null);
            ((PMTextView)((LinearLayout) (obj1)).findViewById(0x7f0c0270)).setText(getString(0x7f06020c));
            ((PMTextView)((LinearLayout) (obj1)).findViewById(0x7f0c0163)).setText((new StringBuilder()).append("-").append(pmorder.getCreditsToApplyString()).toString());
            viewHolder.bundleOrderPricingSummaryLayout.addView(((View) (obj1)));
        }
        if (pmorder.getRedeemableToApply().compareTo(BigDecimal.ZERO) > 0)
        {
            obj1 = (LinearLayout)((LayoutInflater) (obj)).inflate(0x7f0300a5, null);
            ((PMTextView)((LinearLayout) (obj1)).findViewById(0x7f0c0270)).setText(getString(0x7f060222));
            ((PMTextView)((LinearLayout) (obj1)).findViewById(0x7f0c0163)).setText((new StringBuilder()).append("-").append(pmorder.getRedeemableToApplyString()).toString());
            viewHolder.bundleOrderPricingSummaryLayout.addView(((View) (obj1)));
        }
        int i = (int)ViewUtils.dipToPixels(getActivity(), 10F);
        obj = (LinearLayout)((LayoutInflater) (obj)).inflate(0x7f0300a5, null);
        ((LinearLayout) (obj)).setPadding(0, i / 2, 0, 0);
        obj1 = (LinearLayout)((LinearLayout) (obj)).findViewById(0x7f0c026f);
        ((LinearLayout) (obj1)).setPadding(i, i, i, i);
        ((LinearLayout) (obj1)).setBackgroundColor(getResources().getColor(0x7f090009));
        obj1 = (PMTextView)((LinearLayout) (obj)).findViewById(0x7f0c0270);
        ((PMTextView) (obj1)).setTypeface(null, 1);
        ((PMTextView) (obj1)).setText(getString(0x7f0601be));
        obj1 = (PMTextView)((LinearLayout) (obj)).findViewById(0x7f0c0163);
        ((PMTextView) (obj1)).setTextSize(2, 18F);
        ((PMTextView) (obj1)).setText(pmorder.getNetBalanceString());
        if (pmorder.getTotalDiscountTitle() != null && pmorder.getTotalDiscountTitle().length() > 0)
        {
            PMTextView pmtextview = (PMTextView)((LinearLayout) (obj)).findViewById(0x7f0c0135);
            pmtextview.setVisibility(0);
            pmtextview.setText(pmorder.getTotalDiscountTitle());
        }
        viewHolder.bundleOrderPricingSummaryLayout.addView(((View) (obj)));
        ((LinearLayout) (obj)).findViewById(0x7f0c012a).setVisibility(0);
        obj = flowHandler.getCreditCard();
        if (obj == null || ((CreditCard) (obj)).getNumber() == null) goto _L5; else goto _L4
_L4:
        obj = CreditCardUtils.getStringFromCreditCard(getActivity(), ((CreditCard) (obj)));
        viewHolder.changeCreditCardInfoButton.setText(((CharSequence) (obj)));
_L7:
        viewHolder.changeShippingInfoButton.setText(AddressUtils.addressStringWithoutPhone(pmorder.getShippingAddress()));
        return;
_L5:
        if (pmorder.getLastPaymentInfo() != null)
        {
            String s = CreditCardUtils.getStringFromPaymentInfo(getActivity(), pmorder.getLastPaymentInfo());
            viewHolder.changeCreditCardInfoButton.setText(s);
        }
        if (true) goto _L7; else goto _L6
_L6:
    }
}
