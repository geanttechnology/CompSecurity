// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.ebay.common.Preferences;
import com.ebay.common.content.EbaySimpleNetLoader;
import com.ebay.common.model.cart.Cart;
import com.ebay.common.model.cart.PaymentInstruction;
import com.ebay.common.net.api.trading.AddMemberMessageAAQNetLoader;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.ComposeNewMessageActivity;
import com.ebay.mobile.activities.ModalActivity;
import com.ebay.mobile.activities.MyEbayLandingActivity;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.merch.MerchandiseFragment;
import com.ebay.mobile.shoppingcart.ShoppingCartActivity;
import com.ebay.mobile.ui_stuff.UserNotifications;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.EbayResponseError;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import com.ebay.nautilus.shell.content.FwLoader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class PurchaseCompleteAlternativeActivity extends ModalActivity
    implements android.view.View.OnClickListener
{

    public static final String EXTRA_BANK_TRANSFER_DETAILS = "bank_transfer_details";
    public static final String EXTRA_CHECKOUT_CART = "checkout_cart";
    public static final String EXTRA_PAYMENT_METHOD = "payment_method";
    public static final String EXTRA_PURCHASED_ITEM_IDS = "purchased_item_ids";
    public static final String EXTRA_SHOPPING_CART_CHECKOUT = "shopping_cart_checkout";
    private static final int LOADER_ID_CONTACT_SELLER = 1;
    private static final Map paymentAttributeNameMap;
    private String amountString;
    private Long ebayItemId;
    private String ebayItemTitle;
    private String ebaySellerId;
    private boolean eftButtonSelected;
    private PaymentInstruction paymentInstruction;
    private String paymentMethod;

    public PurchaseCompleteAlternativeActivity()
    {
        paymentMethod = null;
        eftButtonSelected = false;
    }

    private void handleError(EbaySimpleNetLoader ebaysimplenetloader, String s)
    {
        ebaysimplenetloader = ebaysimplenetloader.getServiceErrorsAndWarnings();
        android.support.v7.app.AlertDialog.Builder builder;
        if (ebaysimplenetloader != null)
        {
            ebaysimplenetloader = ((EbayResponseError)ebaysimplenetloader.get(0)).longMessage;
        } else
        {
            ebaysimplenetloader = "";
        }
        builder = new android.support.v7.app.AlertDialog.Builder(this);
        builder.setIcon(0x1080027).setTitle(s).setMessage(ebaysimplenetloader).setPositiveButton(0x7f070738, new android.content.DialogInterface.OnClickListener() {

            final PurchaseCompleteAlternativeActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$0 = PurchaseCompleteAlternativeActivity.this;
                super();
            }
        }).create();
        builder.show();
    }

    private void loadAmountIntoView(Cart cart, boolean flag)
    {
        Object obj;
label0:
        {
label1:
            {
                obj = (ViewGroup)findViewById(0x7f1009b7);
                Object obj1 = getLayoutInflater();
                amountString = EbayCurrencyUtil.formatDisplay(cart.total, 0);
                if (cart.total == null)
                {
                    break label0;
                }
                cart = (ViewGroup)((LayoutInflater) (obj1)).inflate(0x7f0302d4, ((ViewGroup) (obj)), false);
                obj1 = (TextView)cart.findViewById(0x7f1009be);
                TextView textview = (TextView)cart.findViewById(0x7f1009bf);
                ((TextView) (obj1)).setText(getString(0x7f070c87));
                textview.setText(amountString);
                ((ViewGroup) (obj)).addView(cart);
                if (!flag)
                {
                    cart = (TextView)findViewById(0x7f1009b1);
                    if (!paymentMethod.equals("MoneyXferAcceptedInCheckout"))
                    {
                        break label1;
                    }
                    cart.setText(getString(0x7f0707d0, new Object[] {
                        amountString
                    }));
                }
                return;
            }
            obj = Calendar.getInstance();
            DateFormat dateformat = SimpleDateFormat.getDateInstance(3, Locale.getDefault());
            ((Calendar) (obj)).add(5, 14);
            cart.setText(getString(0x7f0707d2, new Object[] {
                amountString, dateformat.format(((Calendar) (obj)).getTime())
            }));
            return;
        }
        ((ViewGroup) (obj)).setVisibility(8);
    }

    private void loadItemInfoIntoView(Cart cart)
    {
        ViewGroup viewgroup = (ViewGroup)findViewById(0x7f1009ba);
        Object obj1 = getLayoutInflater();
        if (cart.numberOfItems() != 1)
        {
            findViewById(0x7f1009b8).setVisibility(8);
            findViewById(0x7f1009b9).setVisibility(8);
        } else
        {
            Object obj = (com.ebay.common.model.cart.Cart.LineItem)cart.lineItems.get(0);
            ebayItemId = ((com.ebay.common.model.cart.Cart.LineItem) (obj)).ebayItemId;
            ebayItemTitle = ((com.ebay.common.model.cart.Cart.LineItem) (obj)).getTitle(DeviceConfiguration.getAsync().get(DcsBoolean.itemTitleTranslationEnabled));
            obj = null;
            Object obj2 = cart.sellers.keySet().iterator();
            if (((Iterator) (obj2)).hasNext())
            {
                obj = (String)((Iterator) (obj2)).next();
                obj = (com.ebay.common.model.cart.Cart.Seller)cart.sellers.get(obj);
                ebaySellerId = ((com.ebay.common.model.cart.Cart.Seller) (obj)).userIdentifier;
            }
            cart = (ViewGroup)((LayoutInflater) (obj1)).inflate(0x7f0302d3, viewgroup, false);
            obj2 = (TextView)cart.findViewById(0x7f1009be);
            TextView textview1 = (TextView)cart.findViewById(0x7f1009bf);
            ((TextView) (obj2)).setText(getString(0x7f070c88));
            textview1.setText(String.valueOf(ebayItemId));
            viewgroup.addView(cart);
            cart = (ViewGroup)((LayoutInflater) (obj1)).inflate(0x7f0302d3, viewgroup, false);
            obj2 = (TextView)cart.findViewById(0x7f1009be);
            textview1 = (TextView)cart.findViewById(0x7f1009bf);
            ((TextView) (obj2)).setText(getString(0x7f0700fa));
            textview1.setText(ebayItemTitle);
            viewgroup.addView(cart);
            if (obj != null && ((com.ebay.common.model.cart.Cart.Seller) (obj)).userIdentifier != null)
            {
                cart = (ViewGroup)((LayoutInflater) (obj1)).inflate(0x7f0302d3, viewgroup, false);
                TextView textview = (TextView)cart.findViewById(0x7f1009be);
                obj1 = (TextView)cart.findViewById(0x7f1009bf);
                textview.setText(getString(0x7f070592));
                ((TextView) (obj1)).setText(ebaySellerId);
                viewgroup.addView(cart);
                return;
            }
        }
    }

    private void loadPaymentInstructionIntoView(PaymentInstruction paymentinstruction, ViewGroup viewgroup)
    {
        LayoutInflater layoutinflater = getLayoutInflater();
        paymentinstruction = paymentinstruction.getAttributeMap();
        if (paymentinstruction != null)
        {
            Iterator iterator = paymentAttributeNameMap.keySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                String s = (String)iterator.next();
                if (paymentinstruction.containsKey(s))
                {
                    String s1 = (String)paymentinstruction.get(s);
                    if (!TextUtils.isEmpty(s1) && paymentAttributeNameMap.containsKey(s))
                    {
                        ViewGroup viewgroup2 = (ViewGroup)layoutinflater.inflate(0x7f0302d3, viewgroup, false);
                        TextView textview1 = (TextView)viewgroup2.findViewById(0x7f1009be);
                        TextView textview2 = (TextView)viewgroup2.findViewById(0x7f1009bf);
                        textview1.setText(getString(((Integer)paymentAttributeNameMap.get(s)).intValue()));
                        textview2.setText(s1);
                        viewgroup.addView(viewgroup2);
                    }
                }
            } while (true);
            if (paymentinstruction.containsKey("BankTransferMsgFromSeller"))
            {
                paymentinstruction = (String)paymentinstruction.get("BankTransferMsgFromSeller");
                if (!TextUtils.isEmpty(paymentinstruction))
                {
                    viewgroup = (TextView)findViewById(0x7f1009bb);
                    TextView textview = (TextView)findViewById(0x7f1009bd);
                    ViewGroup viewgroup1 = (ViewGroup)findViewById(0x7f1009bc);
                    textview.setText(paymentinstruction);
                    viewgroup.setVisibility(0);
                    viewgroup1.setVisibility(0);
                    return;
                }
            }
        }
    }

    private void returnToMyEbay()
    {
        Intent intent = MyEbayLandingActivity.getBuyingActivityIntent(this, com.ebay.mobile.activities.MyEbayLandingActivity.BuyingTarget.WON);
        intent.setFlags(0x4000000);
        startActivity(intent);
        finish();
    }

    private void sendConfirmationEmail()
    {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("message/rfc822");
        intent.putExtra("android.intent.extra.EMAIL", new String[] {
            ""
        });
        intent.putExtra("android.intent.extra.SUBJECT", String.format(getString(0x7f070100), new Object[] {
            ebayItemId
        }));
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
        if (paymentInstruction != null && paymentInstruction.hasSellerBankAccountDetails())
        {
            Map map = paymentInstruction.getAttributeMap();
            if (map != null)
            {
                Iterator iterator = map.keySet().iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    String s = (String)iterator.next();
                    if (paymentInstruction != null && map.containsKey(s))
                    {
                        String s1 = (String)map.get(s);
                        if (!TextUtils.isEmpty(s1) && paymentAttributeNameMap.containsKey(s))
                        {
                            spannablestringbuilder.append(getString(((Integer)paymentAttributeNameMap.get(s)).intValue())).append(":").append(" ");
                            spannablestringbuilder.append(s1).append("\n");
                        }
                    }
                } while (true);
            }
        } else
        {
            spannablestringbuilder.append(getString(0x7f0700f9));
            spannablestringbuilder.append("\n");
            spannablestringbuilder.append("\n");
        }
        spannablestringbuilder.append(getString(0x7f070c87)).append(":").append(" ");
        spannablestringbuilder.append(amountString).append("\n");
        spannablestringbuilder.append("\n");
        spannablestringbuilder.append(getString(0x7f070c88)).append(":").append(" ");
        spannablestringbuilder.append(String.valueOf(ebayItemId)).append("\n");
        spannablestringbuilder.append(getString(0x7f0700fa)).append(":").append(" ");
        spannablestringbuilder.append(ebayItemTitle).append("\n");
        spannablestringbuilder.append(getString(0x7f070592)).append(":").append(" ");
        spannablestringbuilder.append(ebaySellerId).append("\n");
        spannablestringbuilder.append("\n");
        intent.putExtra("android.intent.extra.TEXT", spannablestringbuilder);
        startActivity(Intent.createChooser(intent, getString(0x7f0700fb)));
    }

    private void sendSellerMessage()
    {
        Authentication authentication = MyApp.getPrefs().getAuthentication();
        String s;
        if (paymentMethod.equals("MoneyXferAcceptedInCheckout"))
        {
            String s1 = ebaySellerId;
            String s3 = ebayItemTitle;
            if (authentication != null)
            {
                s = authentication.user;
            } else
            {
                s = "";
            }
            s = getString(0x7f0700ff, new Object[] {
                s1, s3, s
            });
        } else
        {
            String s2 = ebaySellerId;
            Long long1 = ebayItemId;
            if (authentication != null)
            {
                s = authentication.user;
            } else
            {
                s = "";
            }
            s = getString(0x7f0700fd, new Object[] {
                s2, long1, s
            });
        }
        ComposeNewMessageActivity.StartActivity(this, new com.ebay.mobile.activities.ComposeNewMessageActivity.MemberMessageRequestParams(ebayItemId, authentication.user, ebaySellerId, s, false));
    }

    public String getTrackingEventName()
    {
        return "PaymentSent";
    }

    public void onBackPressed()
    {
        returnToMyEbay();
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131757491: 
            eftButtonSelected = true;
            sendConfirmationEmail();
            return;

        case 2131757490: 
            sendSellerMessage();
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0302d2);
        Object obj = (Button)findViewById(0x7f1009b2);
        Button button = (Button)findViewById(0x7f1009b3);
        TextView textview = (TextView)findViewById(0x7f1009b0);
        ViewGroup viewgroup = (ViewGroup)findViewById(0x7f1009b5);
        View view = findViewById(0x7f1009b4);
        Intent intent = getIntent();
        bundle = (Cart)intent.getSerializableExtra("checkout_cart");
        paymentMethod = intent.getStringExtra("payment_method");
        long al[] = intent.getLongArrayExtra("purchased_item_ids");
        paymentInstruction = (PaymentInstruction)intent.getSerializableExtra("bank_transfer_details");
        boolean flag;
        if (paymentMethod.equals("CashOnPickup") || paymentInstruction == null || !paymentInstruction.hasSellerBankAccountDetails())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            viewgroup.setVisibility(8);
            button.setVisibility(8);
            ((Button) (obj)).setVisibility(0);
            ((Button) (obj)).setOnClickListener(this);
            view.setVisibility(0);
            obj = (TextView)findViewById(0x7f1009b1);
            if (paymentMethod.equals("MoneyXferAcceptedInCheckout"))
            {
                ((TextView) (obj)).setText(0x7f0700f9);
            } else
            {
                ((TextView) (obj)).setText(0x7f0707ce);
            }
        } else
        {
            viewgroup.setVisibility(0);
            ((Button) (obj)).setVisibility(8);
            loadPaymentInstructionIntoView(paymentInstruction, (ViewGroup)findViewById(0x7f1009b6));
            if (paymentMethod.equals("PayUponInvoice"))
            {
                button.setVisibility(8);
                textview.setVisibility(0);
                view.setVisibility(8);
            } else
            {
                button.setVisibility(0);
                button.setOnClickListener(this);
                textview.setVisibility(8);
                view.setVisibility(0);
            }
        }
        loadAmountIntoView(bundle, flag);
        loadItemInfoIntoView(bundle);
        if (DeviceConfiguration.getAsync().get(DcsBoolean.checkoutMerchandiseItems))
        {
            MerchandiseFragment.attach(this, "MERCH_XO_COMPLETE", 0x7f10088c, 0x1873dL, al, false);
        }
        initDataManagers();
        hideBackButton();
        showCloseButton();
        setCancelable(false);
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.ServiceApi serviceapi;
        if (DeviceConfiguration.getAsync().get(com.ebay.nautilus.domain.dcs.DcsDomain.Payments.B.shopCaseCart))
        {
            serviceapi = com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.ServiceApi.SHOPCASE;
        } else
        {
            serviceapi = com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.ServiceApi.ECAS;
        }
        ((ShoppingCartDataManagerBase)datamanagercontainer.initialize(new com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.KeyParams(serviceapi), new com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.SimpleObserver() {

            final PurchaseCompleteAlternativeActivity this$0;

            public void onShoppingCartChanged(ShoppingCartDataManagerBase shoppingcartdatamanagerbase, com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.Action action, Content content)
            {
                ShoppingCartActivity.updateActionBarCount(PurchaseCompleteAlternativeActivity.this);
            }

            
            {
                this$0 = PurchaseCompleteAlternativeActivity.this;
                super();
            }
        })).getCartAsync(true);
    }

    protected void onPause()
    {
        super.onPause();
        TrackingData trackingdata = new TrackingData("CheckoutPaymentSuccess", TrackingType.EVENT);
        if (findViewById(0x7f1009b3).getVisibility() == 0)
        {
            Object obj;
            Iterator iterator;
            String s;
            if (eftButtonSelected)
            {
                obj = "1";
            } else
            {
                obj = "0";
            }
            trackingdata.addKeyValuePair("eftemail", ((String) (obj)));
        }
        obj = (Map)getIntent().getSerializableExtra("tracking_key_values");
        if (obj != null && ((Map) (obj)).size() > 0)
        {
            for (iterator = ((Map) (obj)).keySet().iterator(); iterator.hasNext(); trackingdata.addKeyValuePair(s, (String)((Map) (obj)).get(s)))
            {
                s = (String)iterator.next();
            }

        }
        trackingdata.send(this);
    }

    protected void onResume()
    {
        super.onResume();
        (new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION)).send(this);
    }

    protected void onTaskComplete(int i, FwLoader fwloader)
    {
label0:
        {
            if (i == 1)
            {
                fwloader = (AddMemberMessageAAQNetLoader)fwloader;
                if (fwloader.isError() || fwloader.getResponse() == null)
                {
                    break label0;
                }
                UserNotifications.showToast(this, getString(0x7f070617), false, true);
            }
            return;
        }
        if (Util.checkForIAFTokenError(fwloader))
        {
            handleIafTokenExpiration();
            return;
        } else
        {
            handleError(fwloader, getString(0x7f0708c7));
            return;
        }
    }

    static 
    {
        LinkedHashMap linkedhashmap = new LinkedHashMap();
        linkedhashmap.put("BankTransferUniqueIdentifier", Integer.valueOf(0x7f070cbc));
        linkedhashmap.put("BankAccountHolderName", Integer.valueOf(0x7f070cb6));
        linkedhashmap.put("BankAccountNumber", Integer.valueOf(0x7f070cb7));
        linkedhashmap.put("BankCode", Integer.valueOf(0x7f070cb8));
        linkedhashmap.put("BankBIC", Integer.valueOf(0x7f070cb8));
        linkedhashmap.put("BankName", Integer.valueOf(0x7f070cb9));
        linkedhashmap.put("BankSwiftCode", Integer.valueOf(0x7f070cba));
        linkedhashmap.put("BankIBAN", Integer.valueOf(0x7f070cbb));
        linkedhashmap.put("ReferenceNumber", Integer.valueOf(0x7f070cbc));
        linkedhashmap.put("AccountHolderName", Integer.valueOf(0x7f070cb6));
        linkedhashmap.put("AccountNumber", Integer.valueOf(0x7f070cb7));
        linkedhashmap.put("BankIdentifierCode", Integer.valueOf(0x7f070cb8));
        linkedhashmap.put("InternationalBankAccountNumber", Integer.valueOf(0x7f070cbb));
        paymentAttributeNameMap = Collections.unmodifiableMap(linkedhashmap);
    }
}
