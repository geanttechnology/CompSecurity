// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.wallet.Address;
import com.google.android.gms.wallet.Cart;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.LineItem;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.Payments;
import com.google.android.gms.wallet.ProxyCard;
import com.google.android.gms.wallet.Wallet;
import com.groupon.activity.GrouponFragmentActivity;
import com.groupon.db.models.Option;
import com.groupon.db.models.Price;
import com.groupon.models.GenericAmount;
import com.groupon.models.country.Country;
import com.groupon.models.dealbreakdown.DealBreakdown;
import com.groupon.models.dealbreakdown.DealBreakdownAdjustment;
import com.groupon.models.dealbreakdown.DealBreakdownGenericAmount;
import com.groupon.models.dealbreakdown.DealBreakdownItem;
import com.groupon.models.dealbreakdown.DealBreakdownTenderItem;
import com.groupon.models.dealbreakdown.DealMultiItemBreakdown;
import com.groupon.models.payment.AbstractPaymentMethod;
import com.groupon.models.payment.GoogleWalletPaymentMethod;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.service.listener.GoogleWalletEventsListener;
import com.groupon.util.GrouponDialogFragment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.service:
//            ShippingService

public class GoogleWalletService
    implements GoogleWalletEventsListener
{

    private static final String GOOGLE_WALLET_AMOUNT_EXCEEDED = "google_wallet_amount_exceeded";
    public static final int GOOGLE_WALLET_MAXIMUM_PURCHASE_AMOUNT = 0x2bf20;
    public static final int REQUEST_CODE_CHANGE_MASKED_WALLET = 1002;
    public static final int REQUEST_CODE_CHECK_PREAUTHORIZATION = 1004;
    public static final int REQUEST_CODE_LOAD_FULL_WALLET = 1003;
    public static final int REQUEST_CODE_LOAD_MASKED_WALLET = 1001;
    private CurrentCountryManager currentCountryManager;
    protected String currentDealOptionId;
    protected FullWallet fullWallet;
    protected GoogleApiClient googleApiClient;
    protected MaskedWallet maskedWallet;
    private SharedPreferences prefs;
    private ShippingService shippingService;
    protected boolean shouldShowGenericErrorDialog;
    protected boolean shouldShowMaxAmountErrorDialog;
    protected boolean wasMaskedWalletCanceled;

    public GoogleWalletService()
    {
    }

    private List buildLineItems(DealBreakdown dealbreakdown)
    {
        ArrayList arraylist = new ArrayList();
        if (dealbreakdown != null)
        {
            DealBreakdownItem dealbreakdownitem = dealbreakdown.getBreakdownItem();
            arraylist.add(LineItem.newBuilder().setCurrencyCode(dealbreakdownitem.unitPrice.getCurrencyCode()).setDescription(dealbreakdownitem.name).setQuantity(Strings.toString(Integer.valueOf(dealbreakdownitem.quantity))).setUnitPrice(Strings.toString(Double.valueOf((double)dealbreakdownitem.unitPrice.getAmount() / 100D))).setTotalPrice(Strings.toString(Double.valueOf((double)dealbreakdownitem.total.getAmount() / 100D))).build());
            handleAdjustments(dealbreakdown.adjustments, arraylist);
            handleCredits(dealbreakdown.getTenderItemsOfType("credit"), arraylist);
        }
        return arraylist;
    }

    private List buildLineItems(DealMultiItemBreakdown dealmultiitembreakdown)
    {
        ArrayList arraylist = new ArrayList();
        if (dealmultiitembreakdown != null)
        {
            Iterator iterator = dealmultiitembreakdown.items.iterator();
            while (iterator.hasNext()) 
            {
                DealBreakdownItem dealbreakdownitem = (DealBreakdownItem)iterator.next();
                Object obj = dealbreakdownitem.unitPrice;
                Object obj1 = dealbreakdownitem.total;
                double d1 = (double)((GenericAmount) (obj)).getAmount() / 100D;
                double d;
                com.google.android.gms.wallet.LineItem.Builder builder;
                if (obj1 != null)
                {
                    d = (double)dealbreakdownitem.total.getAmount() / 100D;
                } else
                {
                    d = d1;
                }
                obj1 = dealbreakdownitem.name;
                builder = LineItem.newBuilder().setCurrencyCode(((GenericAmount) (obj)).getCurrencyCode());
                obj = obj1;
                if (Strings.isEmpty(obj1))
                {
                    obj = dealbreakdownitem.optionId;
                }
                arraylist.add(builder.setDescription(((String) (obj))).setQuantity(Strings.toString(Integer.valueOf(dealbreakdownitem.quantity))).setUnitPrice(Strings.toString(Double.valueOf(d1))).setTotalPrice(Strings.toString(Double.valueOf(d))).build());
            }
            handleAdjustments(dealmultiitembreakdown.adjustments, arraylist);
            handleCredits(dealmultiitembreakdown.getTenderItemsOfType("credit"), arraylist);
        }
        return arraylist;
    }

    private void handleAdjustments(List list, List list1)
    {
        double d;
        DealBreakdownAdjustment dealbreakdownadjustment;
        GenericAmount genericamount;
        for (list = list.iterator(); list.hasNext(); list1.add(LineItem.newBuilder().setCurrencyCode(genericamount.getCurrencyCode()).setDescription(dealbreakdownadjustment.name).setQuantity(Strings.toString(Integer.valueOf(1))).setUnitPrice(Strings.toString(Double.valueOf(d))).setTotalPrice(Strings.toString(Double.valueOf(d))).build()))
        {
            dealbreakdownadjustment = (DealBreakdownAdjustment)list.next();
            genericamount = dealbreakdownadjustment.amount;
            d = (double)genericamount.getAmount() / 100D;
        }

    }

    private void handleCredits(List list, List list1)
    {
        double d;
        DealBreakdownTenderItem dealbreakdowntenderitem;
        GenericAmount genericamount;
        for (list = list.iterator(); list.hasNext(); list1.add(LineItem.newBuilder().setCurrencyCode(genericamount.getCurrencyCode()).setDescription(dealbreakdowntenderitem.type).setQuantity(Strings.toString(Integer.valueOf(1))).setUnitPrice(Strings.toString(Double.valueOf(d))).setTotalPrice(Strings.toString(Double.valueOf(d))).build()))
        {
            dealbreakdowntenderitem = (DealBreakdownTenderItem)list.next();
            genericamount = dealbreakdowntenderitem.amount;
            d = (double)genericamount.getAmount() / 100D;
        }

    }

    private void initGoogleApiClient(Context context)
    {
        int i = 0;
        com.google.android.gms.wallet.Wallet.WalletOptions.Builder builder;
        if (!prefs.getBoolean("googleWalletSandboxEnabled", false))
        {
            i = 1;
        }
        builder = new com.google.android.gms.wallet.Wallet.WalletOptions.Builder();
        builder.setEnvironment(i);
        builder.setTheme(1);
        context = new com.google.android.gms.common.api.GoogleApiClient.Builder(context);
        context.setAccountName(null);
        context.addApi(Wallet.API, builder.build());
        if (googleApiClient != null && googleApiClient.isConnected())
        {
            googleApiClient.disconnect();
        }
        googleApiClient = context.build();
    }

    private void onPreFullWalletRequest(Context context)
    {
        if (maskedWallet == null)
        {
            throw new RuntimeException("MaskedWallet response is null. The Google Transaction ID is required for the FullWallet request");
        }
        if (googleApiClient == null)
        {
            initGoogleApiClient(context);
        }
        googleApiClient.connect();
    }

    private boolean showGoogleWalletErrorDialog(Context context, int i)
    {
        FragmentManager fragmentmanager;
        fragmentmanager = ((GrouponFragmentActivity)context).getFragmentManager();
        if ((GrouponDialogFragment)fragmentmanager.findFragmentByTag("google_wallet_amount_exceeded") != null)
        {
            break MISSING_BLOCK_LABEL_117;
        }
        if (((Activity)context).isFinishing())
        {
            return false;
        }
        GrouponDialogFragment groupondialogfragment = new GrouponDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("dialog_title", null);
        bundle.putString("dialog_message", context.getString(i));
        bundle.putString("dialog_positive_button_text", context.getString(0x7f080139));
        bundle.putString("dialog_negative_button_text", null);
        groupondialogfragment.setArguments(bundle);
        groupondialogfragment.setCancelable(false);
        GrouponDialogFragment.show(fragmentmanager, groupondialogfragment, "google_wallet_amount_exceeded");
        return true;
        context;
_L2:
        return false;
        context;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void checkForPreAuthorization(Context context)
    {
        initGoogleApiClient(context);
        googleApiClient.connect();
        Wallet.Payments.checkForPreAuthorization(googleApiClient, 1004);
    }

    public void clearGoogleWalletData()
    {
        maskedWallet = null;
        fullWallet = null;
        wasMaskedWalletCanceled = false;
    }

    public FullWalletRequest createFullWalletRequest(DealBreakdown dealbreakdown, String s)
    {
        String s1 = null;
        List list = buildLineItems(dealbreakdown);
        double d;
        if (dealbreakdown != null)
        {
            dealbreakdown = dealbreakdown.getTenderItemsOfType("cash");
        } else
        {
            dealbreakdown = null;
        }
        if (dealbreakdown != null)
        {
            dealbreakdown = (DealBreakdownTenderItem)dealbreakdown.get(0);
        } else
        {
            dealbreakdown = null;
        }
        if (dealbreakdown != null)
        {
            s1 = ((DealBreakdownTenderItem) (dealbreakdown)).amount.getCurrencyCode();
        }
        if (dealbreakdown != null)
        {
            d = (double)((DealBreakdownTenderItem) (dealbreakdown)).amount.getAmount() / 100D;
        } else
        {
            d = 0.0D;
        }
        dealbreakdown = Strings.toString(Double.valueOf(d));
        return FullWalletRequest.newBuilder().setGoogleTransactionId(s).setCart(Cart.newBuilder().setCurrencyCode(s1).setTotalPrice(dealbreakdown).setLineItems(list).build()).build();
    }

    public FullWalletRequest createFullWalletRequest(DealMultiItemBreakdown dealmultiitembreakdown, String s)
    {
        List list = buildLineItems(dealmultiitembreakdown);
        Object obj = dealmultiitembreakdown.getTenderItemsOfType("cash");
        dealmultiitembreakdown = dealmultiitembreakdown.subtotal.amount;
        if (obj != null && ((List) (obj)).size() > 0)
        {
            dealmultiitembreakdown = ((DealBreakdownTenderItem)((List) (obj)).get(0)).amount;
        }
        obj = Strings.toString(Double.valueOf((double)dealmultiitembreakdown.getAmount() / 100D));
        dealmultiitembreakdown = dealmultiitembreakdown.getCurrencyCode();
        return FullWalletRequest.newBuilder().setGoogleTransactionId(s).setCart(Cart.newBuilder().setCurrencyCode(dealmultiitembreakdown).setTotalPrice(((String) (obj))).setLineItems(list).build()).build();
    }

    public MaskedWalletRequest createMaskedWalletRequest(Context context, Option option, int i, boolean flag)
    {
        double d = (double)option.getPrice().amount / 100D;
        String s = option.getPrice().currencyCode;
        String s1 = Strings.toString(Double.valueOf(d));
        String s2 = Strings.toString(Double.valueOf((double)i * d));
        String s3 = Strings.toString(Integer.valueOf(i));
        ArrayList arraylist = new ArrayList();
        arraylist.add(LineItem.newBuilder().setCurrencyCode(s).setDescription(option.getTitle()).setRole(0).setQuantity(s3).setUnitPrice(s1).setTotalPrice(s2).build());
        return MaskedWalletRequest.newBuilder().setMerchantName(context.getString(0x7f080473)).setPhoneNumberRequired(false).setShippingAddressRequired(flag).setCurrencyCode(s).setShouldRetrieveWalletObjects(true).setCart(Cart.newBuilder().setCurrencyCode(s).setTotalPrice(s1).setLineItems(arraylist).build()).setEstimatedTotalPrice(s2).build();
    }

    public FullWallet getFullWallet()
    {
        return fullWallet;
    }

    public MaskedWallet getMaskedWallet()
    {
        return maskedWallet;
    }

    public Address getMaskedWalletBillingAddress()
    {
        if (maskedWallet != null)
        {
            return maskedWallet.getBillingAddress();
        } else
        {
            return null;
        }
    }

    public Address getMaskedWalletShippingAddress()
    {
        if (maskedWallet != null)
        {
            return maskedWallet.getShippingAddress();
        } else
        {
            return null;
        }
    }

    public List getWalletBillingRecordParams()
    {
        Object obj = getFullWallet();
        if (obj == null)
        {
            throw new RuntimeException("To get the billing_record request params, first trigger the Full Wallet request");
        }
        obj = ((FullWallet) (obj)).getProxyCard();
        obj = new ArrayList(Arrays.asList(new Object[] {
            "card_number", ((ProxyCard) (obj)).getPan(), "month", Integer.valueOf(((ProxyCard) (obj)).getExpirationMonth()), "year", Integer.valueOf(((ProxyCard) (obj)).getExpirationYear()), "cvv", ((ProxyCard) (obj)).getCvn(), "type", "googlewallet"
        }));
        Address address = getMaskedWalletBillingAddress();
        if (address != null)
        {
            ((List) (obj)).addAll(Arrays.asList(new String[] {
                "full_name", address.getName(), "address1", address.getAddress1(), "city", address.getCity(), "state", address.getState(), "zip", address.getPostalCode(), 
                "country", address.getCountryCode()
            }));
        }
        return ((List) (obj));
    }

    public boolean hasMaximumPurchaseLimitBeenReached(int i)
    {
        return i > 0x2bf20;
    }

    public void initialiseGoogleWallet(Context context, String s)
    {
        boolean flag;
        if (Strings.isEmpty(currentDealOptionId) || !Strings.equals(currentDealOptionId, s))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        currentDealOptionId = s;
        if (flag)
        {
            clearGoogleWalletData();
        }
        initGoogleApiClient(context);
    }

    public boolean isGoogleWalletBillingRecord(String s)
    {
        return Strings.equalsIgnoreCase(s, "google-wallet");
    }

    public boolean isGoogleWalletEnabled()
    {
        return currentCountryManager.getCurrentCountry().isUnitedStates();
    }

    public boolean isGoogleWalletPaymentMethod(AbstractPaymentMethod abstractpaymentmethod)
    {
        return isGoogleWalletEnabled() && (abstractpaymentmethod instanceof GoogleWalletPaymentMethod);
    }

    public void onFullWalletResponse(FullWallet fullwallet)
    {
        googleApiClient.disconnect();
        setFullWallet(fullwallet);
    }

    public void onMaskedWalletResponse(MaskedWallet maskedwallet, int i)
    {
        googleApiClient.disconnect();
        setMaskedWallet(maskedwallet);
        boolean flag;
        if (i == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        wasMaskedWalletCanceled = flag;
    }

    public void postponeShowGoogleWalletGenericErrorDialog()
    {
        shouldShowGenericErrorDialog = true;
    }

    public void postponeShowGoogleWalletMaxAmountErrorDialog()
    {
        shouldShowMaxAmountErrorDialog = true;
    }

    public void setFullWallet(FullWallet fullwallet)
    {
        fullWallet = fullwallet;
    }

    public void setMaskedWallet(MaskedWallet maskedwallet)
    {
        maskedWallet = maskedwallet;
        shippingService.store(getMaskedWalletShippingAddress());
    }

    public boolean shouldDisplayGoogleWallet(boolean flag, boolean flag1, boolean flag2, boolean flag3)
    {
        return !flag && !flag1 && !flag2 && flag3;
    }

    public boolean shouldShowGenericErrorDialog()
    {
        return shouldShowGenericErrorDialog;
    }

    public boolean shouldShowMaxAmountErrorDialog()
    {
        return shouldShowMaxAmountErrorDialog;
    }

    public boolean shouldTriggerFullWalletRequest()
    {
        return maskedWallet != null && fullWallet == null;
    }

    public boolean shouldTriggerLoadMaskedWalletRequest()
    {
        return maskedWallet == null;
    }

    public void showGoogleWalletGenericErrorDialog(Context context)
    {
        if (showGoogleWalletErrorDialog(context, 0x7f080216))
        {
            shouldShowGenericErrorDialog = false;
        }
    }

    public void showGoogleWalletMaxAmountErrorDialog(Context context)
    {
        if (showGoogleWalletErrorDialog(context, 0x7f080217))
        {
            shouldShowMaxAmountErrorDialog = false;
        }
    }

    public void triggerChangeMaskedWalletRequest(Context context)
    {
        MaskedWallet maskedwallet = getMaskedWallet();
        if (maskedwallet != null)
        {
            initGoogleApiClient(context);
            googleApiClient.connect();
            Wallet.Payments.changeMaskedWallet(googleApiClient, maskedwallet.getGoogleTransactionId(), maskedwallet.getMerchantTransactionId(), 1002);
        }
    }

    public void triggerLoadFullWalletRequest(Context context, DealBreakdown dealbreakdown)
    {
        onPreFullWalletRequest(context);
        Wallet.Payments.loadFullWallet(googleApiClient, createFullWalletRequest(dealbreakdown, maskedWallet.getGoogleTransactionId()), 1003);
    }

    public void triggerLoadMaskedWalletRequest(Context context, Option option, int i, boolean flag)
    {
        initGoogleApiClient(context);
        googleApiClient.connect();
        Wallet.Payments.loadMaskedWallet(googleApiClient, createMaskedWalletRequest(context, option, i, flag), 1001);
    }
}
