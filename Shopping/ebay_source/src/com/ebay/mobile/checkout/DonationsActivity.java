// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.ebay.common.Preferences;
import com.ebay.common.model.cart.Cart;
import com.ebay.common.model.cart.JsonModel;
import com.ebay.common.view.util.DialogManager;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbayCurrency;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.checkout:
//            BaseCheckoutActivity, CheckoutError

public class DonationsActivity extends BaseCheckoutActivity
    implements android.view.View.OnClickListener, android.widget.AdapterView.OnItemClickListener
{

    private static final int DONATION_AMOUNT_ID_FIVE = 2;
    private static final int DONATION_AMOUNT_ID_NONE = 5;
    private static final int DONATION_AMOUNT_ID_ONE = 0;
    private static final int DONATION_AMOUNT_ID_TEN = 3;
    private static final int DONATION_AMOUNT_ID_TWENTYFIVE = 4;
    private static final int DONATION_AMOUNT_ID_TWO = 1;
    private static final String EXTRA_DONATION_AMOUNT = "donationAmountId";
    private static final String EXTRA_SELECTED_NONPROFIT = "selectedNonprofitId";
    private ArrayList amounts;
    protected final DialogManager dialogManager = (DialogManager)getShim(com/ebay/common/view/util/DialogManager);
    private TextView donationAmount;
    private int donationAmountId;
    private String donationCurrencyCode;
    private LayoutInflater inflater;
    private String selectedNonprofitId;

    public DonationsActivity()
    {
    }

    private String getDonationCurrencyCode()
    {
        String s1 = com.ebay.common.model.cart.Cart.DonationHelper.getDonationCurrencyCode(cart);
        String s = s1;
        if (s1 == null)
        {
            s = MyApp.getPrefs().getCurrentCountry().getCurrency().getCurrencyCode();
        }
        return s;
    }

    private int getInitialDonationAmountId(Cart cart)
    {
        boolean flag = true;
        int i = ((flag) ? 1 : 0);
        if (cart.donationAmount != null)
        {
            i = ((flag) ? 1 : 0);
            if (cart.donationAmount.isGreaterThanZero())
            {
                cart = EbayCurrencyUtil.formatDisplay(cart.donationAmount, 2);
                if (cart.equals(EbayCurrencyUtil.formatDisplay(donationCurrencyCode, 1.0D, 2)))
                {
                    i = 0;
                } else
                {
                    i = ((flag) ? 1 : 0);
                    if (!cart.equals(EbayCurrencyUtil.formatDisplay(donationCurrencyCode, 2D, 2)))
                    {
                        if (cart.equals(EbayCurrencyUtil.formatDisplay(donationCurrencyCode, 5D, 2)))
                        {
                            return 2;
                        }
                        if (cart.equals(EbayCurrencyUtil.formatDisplay(donationCurrencyCode, 10D, 2)))
                        {
                            return 3;
                        }
                        return !cart.equals(EbayCurrencyUtil.formatDisplay(donationCurrencyCode, 25D, 2)) ? 5 : 4;
                    }
                }
            }
        }
        return i;
    }

    private void renderCharityRows()
    {
        ViewGroup viewgroup = (ViewGroup)findViewById(0x7f100980);
        viewgroup.removeAllViews();
        for (Iterator iterator = favoriteCharities.iterator(); iterator.hasNext(); renderFavoriteCharity(viewgroup, (com.ebay.common.model.givingworks.NonprofitData.Nonprofit)iterator.next())) { }
    }

    private void renderFavoriteCharity(ViewGroup viewgroup, com.ebay.common.model.givingworks.NonprofitData.Nonprofit nonprofit)
    {
        View view = inflater.inflate(0x7f0302c4, viewgroup, false);
        View view1 = view.findViewById(0x7f10097b);
        RadioButton radiobutton = (RadioButton)view1.findViewById(0x7f10097d);
        ((TextView)view1.findViewById(0x7f10097c)).setText(nonprofit.name);
        radiobutton.setChecked(TextUtils.equals(nonprofit.nonprofitId, selectedNonprofitId));
        view1.setTag(nonprofit);
        view1.setOnClickListener(this);
        viewgroup.addView(view);
    }

    public String getTrackingEventName()
    {
        return "MakeADonation";
    }

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR lookupswitch 4: default 48
    //                   2131757435: 49
    //                   2131757441: 68
    //                   2131757443: 231
    //                   2131757444: 84;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return;
_L2:
        selectedNonprofitId = ((com.ebay.common.model.givingworks.NonprofitData.Nonprofit)view.getTag()).nonprofitId;
        renderCharityRows();
        return;
_L3:
        registerForContextMenu(view);
        openContextMenu(view);
        unregisterForContextMenu(view);
        return;
_L5:
        String s;
        int i;
        i = getInitialDonationAmountId(cart);
        view = com.ebay.common.model.cart.Cart.DonationHelper.getDonationNonprofitId(cart);
        s = com.ebay.common.model.cart.Cart.DonationHelper.getDonationLineItemId(cart);
        if (TextUtils.isEmpty(view) && (TextUtils.isEmpty(selectedNonprofitId) || donationAmountId == 5))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (TextUtils.equals(selectedNonprofitId, view))
        {
            break; /* Loop/switch isn't completed */
        }
        if (view != null || donationAmountId == 5)
        {
            apiRemoveDonation(s);
            return;
        }
        if (!TextUtils.isEmpty(selectedNonprofitId) && donationAmountId != 5)
        {
            apiAddDonation(selectedNonprofitId, donationAmountId, donationCurrencyCode);
            return;
        }
        if (true) goto _L1; else goto _L6
_L6:
        if (!TextUtils.isEmpty(s) && donationAmountId != i)
        {
            apiRemoveDonation(s);
        }
        if (donationAmountId == i)
        {
            finish();
            return;
        }
          goto _L1
_L4:
        finish();
        return;
    }

    public boolean onContextItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x7f100981)
        {
            donationAmountId = menuitem.getOrder();
            donationAmount = (TextView)findViewById(0x7f100982);
            donationAmount.setText((CharSequence)amounts.get(donationAmountId));
            return true;
        } else
        {
            return super.onContextItemSelected(menuitem);
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0302c5);
        setTitle(0x7f070c99);
        hideCloseButton();
        showBackButton();
        inflater = (LayoutInflater)getSystemService("layout_inflater");
        findViewById(0x7f100984).setOnClickListener(this);
        findViewById(0x7f100983).setOnClickListener(this);
        donationCurrencyCode = getDonationCurrencyCode();
        if (bundle != null)
        {
            selectedNonprofitId = bundle.getString("selectedNonprofitId");
            donationAmountId = bundle.getInt("donationAmountId");
        } else
        {
            selectedNonprofitId = com.ebay.common.model.cart.Cart.DonationHelper.getDonationNonprofitId(cart);
            donationAmountId = getInitialDonationAmountId(cart);
        }
        amounts = new ArrayList();
        amounts.add(EbayCurrencyUtil.formatDisplay(donationCurrencyCode, 1.0D, 2));
        amounts.add(EbayCurrencyUtil.formatDisplay(donationCurrencyCode, 2D, 2));
        amounts.add(EbayCurrencyUtil.formatDisplay(donationCurrencyCode, 5D, 2));
        amounts.add(EbayCurrencyUtil.formatDisplay(donationCurrencyCode, 10D, 2));
        amounts.add(EbayCurrencyUtil.formatDisplay(donationCurrencyCode, 25D, 2));
        amounts.add(getString(0x7f0707c0));
        findViewById(0x7f100981).setOnClickListener(this);
        donationAmount = (TextView)findViewById(0x7f100982);
        donationAmount.setText((CharSequence)amounts.get(donationAmountId));
        renderCharityRows();
        if (MyApp.getPrefs().getCurrentSite().equals(EbaySite.UK))
        {
            ((TextView)findViewById(0x7f10097f)).setText(0x7f070c9b);
        }
    }

    public void onCreateContextMenu(ContextMenu contextmenu, View view, android.view.ContextMenu.ContextMenuInfo contextmenuinfo)
    {
        super.onCreateContextMenu(contextmenu, view, contextmenuinfo);
        if (view.getId() == 0x7f100981)
        {
            contextmenu.setHeaderTitle(getString(0x7f070c98));
            for (int i = 0; i < amounts.size(); i++)
            {
                contextmenu.add(0, 0x7f100981, i, (CharSequence)amounts.get(i));
            }

        }
    }

    public void onError(BaseCheckoutActivity.Operation operation, boolean flag, IOException ioexception)
    {
        boolean flag1 = false;
        if (isFinishing())
        {
            return;
        }
        enableProgressDialog(false, false);
        operation = dialogManager;
        String s = getString(0x7f070130);
        ioexception = CheckoutError.getConnectionError(getResources(), flag, ioexception);
        if (flag)
        {
            flag = flag1;
        } else
        {
            flag = true;
        }
        operation.showDynamicAlertDialog(s, ioexception, flag);
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
    }

    public void onPartialFailure(BaseCheckoutActivity.Operation operation, JsonModel jsonmodel)
    {
        boolean flag;
        Object obj = null;
        flag = false;
        static class _cls1
        {

            static final int $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[];

            static 
            {
                $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation = new int[BaseCheckoutActivity.Operation.values().length];
                try
                {
                    $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[BaseCheckoutActivity.Operation.REMOVE_DONATION.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[BaseCheckoutActivity.Operation.ADD_DONATION.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.ebay.mobile.checkout.BaseCheckoutActivity.Operation[operation.ordinal()])
        {
        default:
            onSuccess(operation);
            jsonmodel = obj;
            break;

        case 2: // '\002'
            break MISSING_BLOCK_LABEL_89;
        }
_L1:
        jsonmodel = CheckoutError.mapCheckoutError(operation, jsonmodel);
        boolean flag1 = false;
        if (jsonmodel != null)
        {
            flag1 = jsonmodel.shouldAbortOnError();
            dialogManager.showDynamicAlertDialog(null, jsonmodel.getErrorString(this), flag1);
        }
        if (!flag1 && !flag)
        {
            onSuccess(operation);
            return;
        } else
        {
            enableProgressDialog(false, false);
            return;
        }
        jsonmodel = jsonmodel.getValueForErrorParamater("nativeErrorCode");
        setCheckoutResult(-1, null);
        flag = true;
          goto _L1
    }

    protected void onResume()
    {
        super.onResume();
        (new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION)).send(this);
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putString("selectedNonprofitId", selectedNonprofitId);
        bundle.putInt("donationAmountId", donationAmountId);
    }

    public void onSuccess(BaseCheckoutActivity.Operation operation)
    {
        switch (_cls1..SwitchMap.com.ebay.mobile.checkout.BaseCheckoutActivity.Operation[operation.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            int i = donationAmountId;
            if (i != 5)
            {
                apiAddDonation(selectedNonprofitId, i, MyApp.getPrefs().getCurrentCountry().getCurrency().getCurrencyCode());
                return;
            }
            // fall through

        case 2: // '\002'
            setCheckoutResult(-1, null);
            finish();
            return;
        }
    }
}
