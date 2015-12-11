// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.ViewGroup;
import com.ebay.common.Preferences;
import com.ebay.common.content.EbaySimpleNetLoader;
import com.ebay.common.model.ItemTransaction;
import com.ebay.common.model.cart.Cart;
import com.ebay.common.model.cart.CartPaymentMethods;
import com.ebay.common.model.cart.Incentive;
import com.ebay.common.model.cart.IncentiveType;
import com.ebay.common.model.cart.ItemIncentives;
import com.ebay.common.model.cart.JsonModel;
import com.ebay.common.model.cart.PayPalCheckoutDetails;
import com.ebay.common.model.cart.PaymentInstruction;
import com.ebay.common.model.cart.PaymentSession;
import com.ebay.common.model.cart.ResultStatusJsonModel;
import com.ebay.common.model.cart.UserIncentives;
import com.ebay.common.model.inventory.InventoryInfo;
import com.ebay.common.net.api.cart.AddItemsNetLoader;
import com.ebay.common.net.api.cart.BuyNetLoader;
import com.ebay.common.net.api.cart.CreateCartNetLoader;
import com.ebay.common.net.api.cart.EbayCartApi;
import com.ebay.common.net.api.cart.GetCartNetLoader;
import com.ebay.common.net.api.cart.GetItemIncentivesNetLoader;
import com.ebay.common.net.api.cart.GetUserIncentivesNetLoader;
import com.ebay.common.net.api.cart.InitPaymentNetLoader;
import com.ebay.common.net.api.cart.InitPaymentResultNetLoader;
import com.ebay.common.net.api.cart.PayPalCheckoutNetLoader;
import com.ebay.common.net.api.cart.RequestTokenForServiceNetLoader;
import com.ebay.common.net.api.cart.SetPaymentMethodNetLoader;
import com.ebay.common.net.api.cart.SetShippingAddressNetLoader;
import com.ebay.common.net.api.cart.UpdateCartNetLoader;
import com.ebay.common.net.api.cart.UpdateCartResponse;
import com.ebay.common.net.api.cart.UpdateDeliveryReservationNetLoader;
import com.ebay.common.net.api.cart.UpdateLogisticsPlanNetLoader;
import com.ebay.common.net.api.cart.UpdateLogisticsPlanParams;
import com.ebay.common.net.api.cart.UpdatePickupMethodNetLoader;
import com.ebay.common.net.api.fis.AddCreditCardNetLoader;
import com.ebay.common.net.api.fis.AddDirectDebitNetLoader;
import com.ebay.common.net.api.fis.FundingInstrumentServiceNetLoader;
import com.ebay.common.net.api.fis.GetFundingInstrumentNetLoader;
import com.ebay.common.net.api.fis.UpdateCreditCardNetLoader;
import com.ebay.common.net.api.fis.UpdateDirectDebitNetLoader;
import com.ebay.common.util.EbayErrorUtil;
import com.ebay.mobile.CheckoutItem;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.ModalActivity;
import com.ebay.mobile.activities.ShowWebViewFragment;
import com.ebay.mobile.checkout.delivery.DeliverySchedulingParams;
import com.ebay.mobile.checkout.prox.CreditCardActivity;
import com.ebay.mobile.checkout.prox.DirectDebitActivity;
import com.ebay.mobile.checkout.prox.PayPalIdentityActivity;
import com.ebay.mobile.checkout.prox.PayUponInvoiceActivity;
import com.ebay.mobile.checkout.prox.SepaConfirmationActivity;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.mobile.service.PreferenceSyncService;
import com.ebay.mobile.settings.CountryPreferencesFragment;
import com.ebay.mobile.util.EbayApiUtil;
import com.ebay.mobile.util.LocationUtil;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbayCurrency;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.AddressDataManager;
import com.ebay.nautilus.domain.content.dm.DysonDataManager;
import com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase;
import com.ebay.nautilus.domain.content.dm.UserContextDataManager;
import com.ebay.nautilus.domain.data.Address;
import com.ebay.nautilus.domain.data.CreditCard;
import com.ebay.nautilus.domain.data.DirectDebit;
import com.ebay.nautilus.domain.data.EnergyEfficiencyRating;
import com.ebay.nautilus.domain.dcs.DcsNautilusBoolean;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.api.addressbook.AddressResponseData;
import com.ebay.nautilus.domain.net.fis.FundingInstrumentServiceResponse;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import com.ebay.nautilus.shell.app.FwLoaderManager;
import com.ebay.nautilus.shell.content.FwLoader;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public abstract class BaseCheckoutActivity extends ModalActivity
    implements com.ebay.nautilus.domain.content.dm.AddressDataManager.Observer, com.ebay.nautilus.domain.content.dm.DysonDataManager.Observer
{
    public static final class Operation extends Enum
    {

        private static final Operation $VALUES[];
        public static final Operation ADDRESS_DATA_MANAGER;
        public static final Operation ADD_CREDIT_CARD;
        public static final Operation ADD_DIRECT_DEBIT;
        public static final Operation ADD_DONATION;
        public static final Operation APPLY_INCENTIVES;
        public static final Operation BUY;
        public static final Operation CREATE_CART;
        public static final Operation CREATE_CHECKOUT_SESSION;
        public static final Operation DYSON_PAIRED;
        public static final Operation GET_ADDRESSES;
        public static final Operation GET_CART;
        public static final Operation GET_FUNDING_INSTRUMENT;
        public static final Operation GET_INCENTIVES_COUPONS;
        public static final Operation GET_INCENTIVES_REWARDS;
        public static final Operation GET_USER_INCENTIVES_COUPONS;
        public static final Operation GET_USER_INCENTIVES_VOUCHERS;
        public static final Operation INIT_PAYMENT_FOR_PREPARE;
        public static final Operation INIT_PAYMENT_FOR_REFRESH;
        public static final Operation INIT_PAYMENT_RESULT;
        public static final Operation PAYPAL_CHECKOUT;
        public static final Operation PAYPAL_CHECKOUT_FOR_REFRESH;
        public static final Operation POST_PAYMENT_WATCH_LIST_UPDATE;
        public static final Operation REDEEM_INCENTIVE;
        public static final Operation REFRESH_ADDRESSES;
        public static final Operation REFRESH_CART;
        public static final Operation REMOVE_DONATION;
        public static final Operation REQUEST_TOKEN_FOR_SERVICE;
        public static final Operation SET_DEFAULT_SHIPPING_ADDRESS;
        public static final Operation SET_PAYMENT_INSTRUMENT;
        public static final Operation SET_SHIPPING_ADDRESS;
        public static final Operation UPDATE_CREDIT_CARD;
        public static final Operation UPDATE_DELIVERY_RESERVATION;
        public static final Operation UPDATE_DIRECT_DEBIT;
        public static final Operation UPDATE_ITEM_QUANTITY;
        public static final Operation UPDATE_PICKUP_METHOD;
        public static final Operation UPDATE_SELLER_NOTE;
        public static final Operation UPDATE_SHIPPING_METHOD;

        public static Operation valueOf(String s)
        {
            return (Operation)Enum.valueOf(com/ebay/mobile/checkout/BaseCheckoutActivity$Operation, s);
        }

        public static Operation[] values()
        {
            return (Operation[])$VALUES.clone();
        }

        static 
        {
            GET_ADDRESSES = new Operation("GET_ADDRESSES", 0);
            CREATE_CHECKOUT_SESSION = new Operation("CREATE_CHECKOUT_SESSION", 1);
            GET_CART = new Operation("GET_CART", 2);
            SET_DEFAULT_SHIPPING_ADDRESS = new Operation("SET_DEFAULT_SHIPPING_ADDRESS", 3);
            CREATE_CART = new Operation("CREATE_CART", 4);
            REFRESH_CART = new Operation("REFRESH_CART", 5);
            GET_USER_INCENTIVES_COUPONS = new Operation("GET_USER_INCENTIVES_COUPONS", 6);
            GET_USER_INCENTIVES_VOUCHERS = new Operation("GET_USER_INCENTIVES_VOUCHERS", 7);
            GET_INCENTIVES_COUPONS = new Operation("GET_INCENTIVES_COUPONS", 8);
            GET_INCENTIVES_REWARDS = new Operation("GET_INCENTIVES_REWARDS", 9);
            SET_SHIPPING_ADDRESS = new Operation("SET_SHIPPING_ADDRESS", 10);
            REFRESH_ADDRESSES = new Operation("REFRESH_ADDRESSES", 11);
            APPLY_INCENTIVES = new Operation("APPLY_INCENTIVES", 12);
            REDEEM_INCENTIVE = new Operation("REDEEM_INCENTIVE", 13);
            UPDATE_SHIPPING_METHOD = new Operation("UPDATE_SHIPPING_METHOD", 14);
            UPDATE_ITEM_QUANTITY = new Operation("UPDATE_ITEM_QUANTITY", 15);
            UPDATE_SELLER_NOTE = new Operation("UPDATE_SELLER_NOTE", 16);
            UPDATE_PICKUP_METHOD = new Operation("UPDATE_PICKUP_METHOD", 17);
            UPDATE_DELIVERY_RESERVATION = new Operation("UPDATE_DELIVERY_RESERVATION", 18);
            ADD_DONATION = new Operation("ADD_DONATION", 19);
            REMOVE_DONATION = new Operation("REMOVE_DONATION", 20);
            REQUEST_TOKEN_FOR_SERVICE = new Operation("REQUEST_TOKEN_FOR_SERVICE", 21);
            INIT_PAYMENT_FOR_PREPARE = new Operation("INIT_PAYMENT_FOR_PREPARE", 22);
            INIT_PAYMENT_FOR_REFRESH = new Operation("INIT_PAYMENT_FOR_REFRESH", 23);
            PAYPAL_CHECKOUT_FOR_REFRESH = new Operation("PAYPAL_CHECKOUT_FOR_REFRESH", 24);
            PAYPAL_CHECKOUT = new Operation("PAYPAL_CHECKOUT", 25);
            INIT_PAYMENT_RESULT = new Operation("INIT_PAYMENT_RESULT", 26);
            BUY = new Operation("BUY", 27);
            POST_PAYMENT_WATCH_LIST_UPDATE = new Operation("POST_PAYMENT_WATCH_LIST_UPDATE", 28);
            ADDRESS_DATA_MANAGER = new Operation("ADDRESS_DATA_MANAGER", 29);
            SET_PAYMENT_INSTRUMENT = new Operation("SET_PAYMENT_INSTRUMENT", 30);
            ADD_CREDIT_CARD = new Operation("ADD_CREDIT_CARD", 31);
            GET_FUNDING_INSTRUMENT = new Operation("GET_FUNDING_INSTRUMENT", 32);
            UPDATE_CREDIT_CARD = new Operation("UPDATE_CREDIT_CARD", 33);
            ADD_DIRECT_DEBIT = new Operation("ADD_DIRECT_DEBIT", 34);
            UPDATE_DIRECT_DEBIT = new Operation("UPDATE_DIRECT_DEBIT", 35);
            DYSON_PAIRED = new Operation("DYSON_PAIRED", 36);
            $VALUES = (new Operation[] {
                GET_ADDRESSES, CREATE_CHECKOUT_SESSION, GET_CART, SET_DEFAULT_SHIPPING_ADDRESS, CREATE_CART, REFRESH_CART, GET_USER_INCENTIVES_COUPONS, GET_USER_INCENTIVES_VOUCHERS, GET_INCENTIVES_COUPONS, GET_INCENTIVES_REWARDS, 
                SET_SHIPPING_ADDRESS, REFRESH_ADDRESSES, APPLY_INCENTIVES, REDEEM_INCENTIVE, UPDATE_SHIPPING_METHOD, UPDATE_ITEM_QUANTITY, UPDATE_SELLER_NOTE, UPDATE_PICKUP_METHOD, UPDATE_DELIVERY_RESERVATION, ADD_DONATION, 
                REMOVE_DONATION, REQUEST_TOKEN_FOR_SERVICE, INIT_PAYMENT_FOR_PREPARE, INIT_PAYMENT_FOR_REFRESH, PAYPAL_CHECKOUT_FOR_REFRESH, PAYPAL_CHECKOUT, INIT_PAYMENT_RESULT, BUY, POST_PAYMENT_WATCH_LIST_UPDATE, ADDRESS_DATA_MANAGER, 
                SET_PAYMENT_INSTRUMENT, ADD_CREDIT_CARD, GET_FUNDING_INSTRUMENT, UPDATE_CREDIT_CARD, ADD_DIRECT_DEBIT, UPDATE_DIRECT_DEBIT, DYSON_PAIRED
            });
        }

        private Operation(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String CHECKOUT_STATE_CART = "xo_state_cart";
    private static final String CHECKOUT_STATE_CART_ID = "xo_state_cart_id";
    private static final String CHECKOUT_STATE_CART_ITEMS_INVENTORY_INFO = "xo_state_inventory_info_for_items";
    private static final String CHECKOUT_STATE_COUNTRY_CHANGED = "xo_state_country_changed";
    private static final String CHECKOUT_STATE_CREDIT_CARD = "xo_state_fis_credit_card";
    private static final String CHECKOUT_STATE_DIRECT_DEBIT = "xo_state_fis_direct_debit";
    private static final String CHECKOUT_STATE_DYSON_RISK_PAYLOAD = "xo_dyson_risk_payload";
    private static final String CHECKOUT_STATE_FAVORITE_CHARITIES = "xo_state_favorite_charities";
    private static final String CHECKOUT_STATE_ITEM = "xo_state_item";
    private static final String CHECKOUT_STATE_ITEM_INCENTIVES_COUPONS = "xo_state_item_incentives_coupons";
    private static final String CHECKOUT_STATE_ITEM_INCENTIVES_REWARDS = "xo_state_item_incentives_rewards";
    private static final String CHECKOUT_STATE_LINE_ITEMS_WITH_SHIPPING_CHANGES = "xo_state_line_items_with_shipping_changes";
    private static final String CHECKOUT_STATE_OPERATION_PENDING_ON_DATA_MANAGER = "xo_operation_pending_data_manager";
    private static final String CHECKOUT_STATE_PAYMENT_ATTRIBUTES = "xo_state_payment_attributes";
    private static final String CHECKOUT_STATE_PAYMENT_METHOD_COUNT = "payment_method_count";
    private static final String CHECKOUT_STATE_PAYMENT_SESSION = "xo_state_payment_session";
    private static final String CHECKOUT_STATE_PAYPAL_CHECKOUT_DETAILS = "xo_state_paypal_checkout_details";
    private static final String CHECKOUT_STATE_PAYPAL_COMPLETED = "paypal_completed";
    private static final String CHECKOUT_STATE_REFINED_POSTAL_CODE = "xo_state_refined_postal_code";
    private static final String CHECKOUT_STATE_SELECTED_PAYMENT_METHOD = "selected_payment_method";
    private static final String CHECKOUT_STATE_SERVICE_PROVIDER_TOKEN = "xo_state_service_provider_token";
    private static final String CHECKOUT_STATE_SHIPPING_ADDRESSES = "xo_state_shipping_addresses";
    private static final String CHECKOUT_STATE_SHOP_CART_ID = "xo_state_shop_cart_id";
    private static final String CHECKOUT_STATE_SHOP_CART_ITEMS = "xo_state_shop_cart_items";
    private static final String CHECKOUT_STATE_TEMP_FUNDING_INSTRUMENT = "xo_state_temp_funding_instrument";
    private static final String CHECKOUT_STATE_TRANSACTION = "xo_state_transaction";
    private static final String CHECKOUT_STATE_UNSHIPPABLE_ADDRESSES = "xo_state_unshippable_addresses";
    private static final String CHECKOUT_STATE_UPDATED_CART_LINE_ITEM_ID = "xo_state_updated_cart_line_item_id";
    private static final String CHECKOUT_STATE_UPDATE_ADDRESS_REQUEST_ID = "update_address_request_id";
    private static final String CHECKOUT_STATE_UPDATE_ADDRESS_RESPONSE_ID = "update_address_response_id";
    private static final String CHECKOUT_STATE_USER_INCENTIVES = "xo_state_user_incentives";
    private static final String CHECKOUT_STATE_USE_GUEST_XO = "use_guest_xo";
    private static final String CHECKOUT_STATE_VARIATION_ID = "xo_state_variation_id";
    protected static final int REQUEST_PROX_PAYPAL_IDENTITY = 0x7759b2;
    protected static final int REQUEST_PROX_PAY_UPON_INVOICE = 0x7759b7;
    protected static final int REQUEST_PROX_RISK_CHALLENGE = 0x7759b6;
    protected static final int REQUEST_PROX_SEPA_MANDATE = 0x7759b5;
    protected static final int REQUEST_PROX_TEMP_CREDIT_CARD = 0x7759b3;
    protected static final int REQUEST_PROX_TEMP_DIRECT_DEBIT = 0x7759b4;
    public static final String SHIPPING_ADDRESSES_EXTERNAL_INTENT = "xo_state_shipping_addresses";
    protected AddressDataManager addressDataManager;
    protected Cart cart;
    protected String cartId;
    protected EbayCartApi checkoutCartApi;
    protected boolean countryChanged;
    public CreditCard creditCard;
    private boolean currencyConversionRequest;
    public DirectDebit directDebit;
    protected DysonDataManager dysonDataManager;
    protected List favoriteCharities;
    private Map inventoryInfoMap;
    protected CheckoutItem item;
    protected ItemIncentives itemIncentivesCoupons;
    protected ItemIncentives itemIncentivesRewards;
    protected Map lineItemIdToIsTransacted;
    protected Set lineItemsWithShippingChanges;
    private Operation operationPendingOnDataManager;
    protected PayPalCheckoutDetails payPalCheckoutDetails;
    protected PaymentInstruction paymentInstruction;
    protected boolean paymentMethodCompleted;
    protected int paymentMethodCount;
    protected PaymentSession paymentSession;
    private ProgressDialog progressDialog;
    protected String refinedPostalCode;
    protected String selectedPaymentMethod;
    protected String serviceProviderToken;
    private List shippingAddresses;
    protected long shopCartId;
    protected Map shopCartItems;
    protected com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.Observer shoppingCartDataHandler;
    protected ShoppingCartDataManagerBase shoppingCartDataManager;
    private String siteCurrencyCode;
    public String temporaryFundingInstrumentId;
    protected ItemTransaction transaction;
    private Map unshippableAddresses;
    protected String updateAddressRequestId;
    protected String updateAddressResponseId;
    protected String updatedCartLineItemId;
    protected boolean useGuestXo;
    private UserContextDataManager userContextDataManager;
    protected UserIncentives userIncentives;
    protected String variationId;

    public BaseCheckoutActivity()
    {
        shopCartId = -1L;
        lineItemIdToIsTransacted = new HashMap();
        progressDialog = null;
    }

    private void apiSetPaymentInstrumentInternal(String s, String s1, String s2, Boolean boolean1)
    {
        s = new SetPaymentMethodNetLoader(getEbayContext(), checkoutCartApi, cart.cartId, s, s1, s2, shouldRememberPaymentInstrument(), boolean1, null, null);
        getFwLoaderManager().start(Operation.SET_PAYMENT_INSTRUMENT.ordinal(), s, false);
    }

    public static Address getDefaultAddress(List list)
    {
label0:
        {
            if (list == null)
            {
                break label0;
            }
            list = list.iterator();
            Address address;
            do
            {
                if (!list.hasNext())
                {
                    break label0;
                }
                address = (Address)list.next();
            } while (!address.isDefault());
            return address;
        }
        return null;
    }

    public static boolean handleDefaultAddressChange(Activity activity, UserContextDataManager usercontextdatamanager, List list, boolean flag, String s)
    {
        boolean flag2;
        boolean flag3;
        flag2 = false;
        flag3 = false;
        if (list == null || list.size() == 0)
        {
            return false;
        }
        list = getDefaultAddress(list);
        if (list == null) goto _L2; else goto _L1
_L1:
        Preferences preferences;
        EbayCountry ebaycountry;
        EbayCountry ebaycountry1;
        boolean flag1;
        preferences = MyApp.getPrefs();
        ebaycountry = preferences.getCurrentCountry();
        ebaycountry1 = EbayCountry.getInstance(((Address) (list)).addressFields.country);
        flag1 = flag3;
        if (!preferences.getCountryAutoDetected()) goto _L4; else goto _L3
_L3:
        if (ebaycountry1 == null || ebaycountry == null) goto _L6; else goto _L5
_L5:
        if (!ebaycountry.equals(ebaycountry1))
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (!flag2) goto _L8; else goto _L7
_L7:
        if (usercontextdatamanager != null)
        {
            usercontextdatamanager.setCurrentCountry(ebaycountry1);
        }
        CountryPreferencesFragment.trackCountryChange(activity, ebaycountry1, true, s);
        flag1 = flag2;
_L4:
        flag2 = flag1;
        if (ebaycountry1 != null)
        {
            usercontextdatamanager = new Intent(activity, com/ebay/mobile/service/PreferenceSyncService);
            usercontextdatamanager.putExtra("countryCode", ((Address) (list)).addressFields.country);
            usercontextdatamanager.putExtra("postalCode", ((Address) (list)).addressFields.postalCode);
            usercontextdatamanager.putExtra("stateOrProvince", ((Address) (list)).addressFields.stateOrProvince);
            usercontextdatamanager.setAction("com.ebay.mobile.service.PreferenceSyncService.updatePrefsPrimaryAddress");
            activity.startService(usercontextdatamanager);
            flag2 = flag1;
        }
_L2:
        return flag2;
_L8:
        flag1 = flag2;
        if (flag)
        {
            flag1 = flag2;
            if (usercontextdatamanager != null)
            {
                usercontextdatamanager.setCurrentCountry(ebaycountry1);
                flag1 = flag2;
            }
        }
        continue; /* Loop/switch isn't completed */
_L6:
        flag1 = flag3;
        if (flag)
        {
            flag1 = flag3;
            if (ebaycountry1 != null)
            {
                flag1 = flag3;
                if (usercontextdatamanager != null)
                {
                    usercontextdatamanager.setCurrentCountry(ebaycountry1);
                    flag1 = flag3;
                }
            }
        }
        if (true) goto _L4; else goto _L9
_L9:
    }

    public static String incentiveTypeToString(Context context, IncentiveType incentivetype)
    {
        int i;
        if (incentivetype.isVoucher())
        {
            i = 0x7f070c1c;
        } else
        if (incentivetype.isCoupon())
        {
            i = 0x7f070c17;
        } else
        if (incentivetype.isReward())
        {
            i = 0x7f070c65;
        } else
        if (incentivetype.isGiftCard() || incentivetype.isGiftCertificate())
        {
            i = 0x7f070c24;
        } else
        {
            i = 0x7f070c33;
        }
        return context.getString(i);
    }

    private void loadCheckoutState(Intent intent)
    {
        if (intent.hasExtra("xo_state_item"))
        {
            item = (CheckoutItem)intent.getParcelableExtra("xo_state_item");
        }
        if (intent.hasExtra("xo_state_transaction"))
        {
            transaction = (ItemTransaction)intent.getParcelableExtra("xo_state_transaction");
        }
        if (intent.hasExtra("xo_state_variation_id"))
        {
            variationId = intent.getStringExtra("xo_state_variation_id");
        }
        if (intent.hasExtra("xo_state_shop_cart_id"))
        {
            shopCartId = intent.getLongExtra("xo_state_shop_cart_id", -1L);
        }
        if (intent.hasExtra("xo_state_shop_cart_items"))
        {
            shopCartItems = (Map)intent.getSerializableExtra("xo_state_shop_cart_items");
        }
        if (intent.hasExtra("xo_state_cart_id"))
        {
            cartId = intent.getStringExtra("xo_state_cart_id");
        }
        if (intent.hasExtra("xo_state_cart"))
        {
            cart = (Cart)intent.getSerializableExtra("xo_state_cart");
        }
        if (intent.hasExtra("xo_state_payment_attributes"))
        {
            paymentInstruction = (PaymentInstruction)intent.getSerializableExtra("xo_state_payment_attributes");
        }
        if (intent.hasExtra("xo_state_item_incentives_coupons"))
        {
            itemIncentivesCoupons = (ItemIncentives)intent.getSerializableExtra("xo_state_item_incentives_coupons");
        }
        if (intent.hasExtra("xo_state_item_incentives_rewards"))
        {
            itemIncentivesRewards = (ItemIncentives)intent.getSerializableExtra("xo_state_item_incentives_rewards");
        }
        if (intent.hasExtra("xo_state_user_incentives"))
        {
            userIncentives = (UserIncentives)intent.getSerializableExtra("xo_state_user_incentives");
        }
        if (intent.hasExtra("xo_state_service_provider_token"))
        {
            serviceProviderToken = intent.getStringExtra("xo_state_service_provider_token");
        }
        if (intent.hasExtra("xo_state_paypal_checkout_details"))
        {
            payPalCheckoutDetails = (PayPalCheckoutDetails)intent.getSerializableExtra("xo_state_paypal_checkout_details");
        }
        if (intent.hasExtra("xo_state_payment_session"))
        {
            paymentSession = (PaymentSession)intent.getSerializableExtra("xo_state_payment_session");
        }
        if (intent.hasExtra("paypal_completed"))
        {
            paymentMethodCompleted = intent.getBooleanExtra("paypal_completed", false);
        }
        if (intent.hasExtra("use_guest_xo"))
        {
            useGuestXo = intent.getBooleanExtra("use_guest_xo", false);
        }
        if (intent.hasExtra("xo_state_shipping_addresses"))
        {
            setShippingAddresses((List)intent.getSerializableExtra("xo_state_shipping_addresses"));
        }
        if (intent.hasExtra("selected_payment_method"))
        {
            selectedPaymentMethod = intent.getStringExtra("selected_payment_method");
        }
        if (intent.hasExtra("payment_method_count"))
        {
            paymentMethodCount = intent.getIntExtra("payment_method_count", 0);
        }
        if (intent.hasExtra("update_address_request_id"))
        {
            updateAddressRequestId = intent.getStringExtra("update_address_request_id");
        }
        if (intent.hasExtra("update_address_response_id"))
        {
            updateAddressResponseId = intent.getStringExtra("update_address_response_id");
        }
        if (intent.hasExtra("xo_state_inventory_info_for_items"))
        {
            inventoryInfoMap = (Map)intent.getSerializableExtra("xo_state_inventory_info_for_items");
        }
        if (intent.hasExtra("xo_state_updated_cart_line_item_id"))
        {
            updatedCartLineItemId = intent.getStringExtra("xo_state_updated_cart_line_item_id");
        }
        if (intent.hasExtra("xo_state_refined_postal_code"))
        {
            refinedPostalCode = intent.getStringExtra("xo_state_refined_postal_code");
        }
        if (intent.hasExtra("xo_state_favorite_charities"))
        {
            favoriteCharities = intent.getParcelableArrayListExtra("xo_state_favorite_charities");
        }
        if (intent.hasExtra("xo_state_line_items_with_shipping_changes"))
        {
            lineItemsWithShippingChanges = (Set)intent.getSerializableExtra("xo_state_line_items_with_shipping_changes");
        }
        if (intent.hasExtra("xo_state_country_changed"))
        {
            countryChanged = intent.getBooleanExtra("xo_state_country_changed", false);
        }
        if (intent.hasExtra("xo_operation_pending_data_manager"))
        {
            operationPendingOnDataManager = Operation.values()[intent.getIntExtra("xo_operation_pending_data_manager", 0)];
        }
        if (intent.hasExtra("xo_state_unshippable_addresses"))
        {
            unshippableAddresses = (Map)intent.getSerializableExtra("xo_state_unshippable_addresses");
        }
        if (intent.hasExtra("xo_state_temp_funding_instrument"))
        {
            temporaryFundingInstrumentId = intent.getStringExtra("xo_state_temp_funding_instrument");
        }
        if (intent.hasExtra("xo_state_fis_credit_card"))
        {
            creditCard = (CreditCard)intent.getParcelableExtra("xo_state_fis_credit_card");
        }
        if (intent.hasExtra("xo_state_fis_direct_debit"))
        {
            directDebit = (DirectDebit)intent.getParcelableExtra("xo_state_fis_direct_debit");
        }
        if (!intent.hasExtra("xo_dyson_risk_payload")) goto _L2; else goto _L1
_L1:
        intent = intent.getStringExtra("xo_dyson_risk_payload");
        EbayCartApi ebaycartapi;
        try
        {
            ebaycartapi = checkoutCartApi;
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            checkoutCartApi.riskPayload = null;
            return;
        }
        if (intent == null)
        {
            break MISSING_BLOCK_LABEL_708;
        }
        intent = new JSONObject(intent);
_L3:
        ebaycartapi.riskPayload = intent;
_L2:
        return;
        intent = null;
          goto _L3
    }

    private void loadCheckoutState(Bundle bundle)
    {
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_444;
        }
        setShippingAddresses((List)bundle.getSerializable("xo_state_shipping_addresses"));
        item = (CheckoutItem)bundle.getParcelable("xo_state_item");
        transaction = (ItemTransaction)bundle.getParcelable("xo_state_transaction");
        variationId = bundle.getString("xo_state_variation_id");
        shopCartId = bundle.getLong("xo_state_shop_cart_id");
        shopCartItems = (Map)bundle.getSerializable("xo_state_shop_cart_items");
        cartId = bundle.getString("xo_state_cart_id");
        cart = (Cart)bundle.getSerializable("xo_state_cart");
        paymentInstruction = (PaymentInstruction)bundle.getSerializable("xo_state_payment_attributes");
        itemIncentivesCoupons = (ItemIncentives)bundle.getSerializable("xo_state_item_incentives_coupons");
        itemIncentivesRewards = (ItemIncentives)bundle.getSerializable("xo_state_item_incentives_rewards");
        userIncentives = (UserIncentives)bundle.getSerializable("xo_state_user_incentives");
        serviceProviderToken = bundle.getString("xo_state_service_provider_token");
        payPalCheckoutDetails = (PayPalCheckoutDetails)bundle.getSerializable("xo_state_paypal_checkout_details");
        paymentSession = (PaymentSession)bundle.getSerializable("xo_state_payment_session");
        paymentMethodCompleted = bundle.getBoolean("paypal_completed");
        useGuestXo = bundle.getBoolean("use_guest_xo");
        shippingAddresses = (List)bundle.getSerializable("xo_state_shipping_addresses");
        selectedPaymentMethod = bundle.getString("selected_payment_method");
        paymentMethodCount = bundle.getInt("payment_method_count");
        updateAddressRequestId = bundle.getString("update_address_request_id");
        updateAddressResponseId = bundle.getString("update_address_response_id");
        inventoryInfoMap = (Map)bundle.getSerializable("xo_state_inventory_info_for_items");
        updatedCartLineItemId = bundle.getString("xo_state_updated_cart_line_item_id");
        refinedPostalCode = bundle.getString("xo_state_refined_postal_code");
        favoriteCharities = bundle.getParcelableArrayList("xo_state_favorite_charities");
        lineItemsWithShippingChanges = (Set)bundle.getSerializable("xo_state_line_items_with_shipping_changes");
        countryChanged = bundle.getBoolean("xo_state_country_changed");
        if (bundle.containsKey("xo_operation_pending_data_manager"))
        {
            operationPendingOnDataManager = Operation.values()[bundle.getInt("xo_operation_pending_data_manager")];
        }
        unshippableAddresses = (Map)bundle.getSerializable("xo_state_unshippable_addresses");
        temporaryFundingInstrumentId = bundle.getString("xo_state_temp_funding_instrument");
        creditCard = (CreditCard)bundle.getParcelable("xo_state_fis_credit_card");
        directDebit = (DirectDebit)bundle.getParcelable("xo_state_fis_direct_debit");
        EbayCartApi ebaycartapi;
        try
        {
            bundle = bundle.getString("xo_dyson_risk_payload");
            ebaycartapi = checkoutCartApi;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            checkoutCartApi.riskPayload = null;
            return;
        }
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_429;
        }
        bundle = new JSONObject(bundle);
_L1:
        ebaycartapi.riskPayload = bundle;
        return;
        bundle = null;
          goto _L1
        loadCheckoutState(getIntent());
        return;
    }

    private Cart retainAndResolveLineItemCartState(Cart cart1)
    {
        if (cart != null && cart.lineItems != null && !cart.areAllBopisItemsInStock())
        {
            Iterator iterator = cart1.lineItems.iterator();
            while (iterator.hasNext()) 
            {
                com.ebay.common.model.cart.Cart.LineItem lineitem = (com.ebay.common.model.cart.Cart.LineItem)iterator.next();
                com.ebay.common.model.cart.Cart.LineItem lineitem1 = cart.getLineItemByCartLineItemId(lineitem.cartLineItemId);
                if (lineitem1 != null && (updatedCartLineItemId == null || !updatedCartLineItemId.equals(lineitem.cartLineItemId)))
                {
                    lineitem.lineItemErrorCode = lineitem1.lineItemErrorCode;
                }
            }
        }
        return cart1;
    }

    private void saveCheckoutState(Intent intent)
    {
        intent.putExtra("xo_state_item", item);
        intent.putExtra("xo_state_transaction", transaction);
        intent.putExtra("xo_state_variation_id", variationId);
        intent.putExtra("xo_state_shop_cart_id", shopCartId);
        intent.putExtra("xo_state_shop_cart_items", (Serializable)shopCartItems);
        intent.putExtra("xo_state_cart_id", cartId);
        intent.putExtra("xo_state_cart", cart);
        intent.putExtra("xo_state_payment_attributes", paymentInstruction);
        intent.putExtra("xo_state_item_incentives_coupons", itemIncentivesCoupons);
        intent.putExtra("xo_state_item_incentives_rewards", itemIncentivesRewards);
        intent.putExtra("xo_state_user_incentives", userIncentives);
        intent.putExtra("xo_state_service_provider_token", serviceProviderToken);
        intent.putExtra("xo_state_paypal_checkout_details", payPalCheckoutDetails);
        intent.putExtra("xo_state_payment_session", paymentSession);
        intent.putExtra("paypal_completed", paymentMethodCompleted);
        intent.putExtra("use_guest_xo", useGuestXo);
        intent.putExtra("xo_state_shipping_addresses", (Serializable)getShippingAddresses());
        intent.putExtra("selected_payment_method", selectedPaymentMethod);
        intent.putExtra("payment_method_count", paymentMethodCount);
        intent.putExtra("update_address_request_id", updateAddressRequestId);
        intent.putExtra("update_address_response_id", updateAddressResponseId);
        intent.putExtra("xo_state_inventory_info_for_items", (Serializable)inventoryInfoMap);
        intent.putExtra("xo_state_updated_cart_line_item_id", updatedCartLineItemId);
        intent.putExtra("xo_state_refined_postal_code", refinedPostalCode);
        intent.putParcelableArrayListExtra("xo_state_favorite_charities", (ArrayList)favoriteCharities);
        intent.putExtra("xo_state_line_items_with_shipping_changes", (Serializable)lineItemsWithShippingChanges);
        intent.putExtra("xo_state_country_changed", countryChanged);
        if (operationPendingOnDataManager != null)
        {
            intent.putExtra("xo_operation_pending_data_manager", operationPendingOnDataManager.ordinal());
        }
        intent.putExtra("xo_state_unshippable_addresses", (Serializable)unshippableAddresses);
        intent.putExtra("xo_state_temp_funding_instrument", temporaryFundingInstrumentId);
        intent.putExtra("xo_state_fis_credit_card", creditCard);
        intent.putExtra("xo_state_fis_direct_debit", directDebit);
        String s;
        if (checkoutCartApi.riskPayload != null)
        {
            s = checkoutCartApi.riskPayload.toString();
        } else
        {
            s = "";
        }
        intent.putExtra("xo_dyson_risk_payload", s);
    }

    public void addUnshippable(String s, String s1)
    {
        if (!unshippableAddresses.containsKey(s))
        {
            unshippableAddresses.put(s, new ArrayList());
        }
        ((List)unshippableAddresses.get(s)).add(s1);
    }

    protected void apiAddCreditCard(CreditCard creditcard)
    {
        creditcard = new AddCreditCardNetLoader(getEbayContext(), checkoutCartApi.iafToken, creditcard);
        getFwLoaderManager().start(Operation.ADD_CREDIT_CARD.ordinal(), creditcard, false);
    }

    public void apiAddDirectDebit(DirectDebit directdebit)
    {
        directdebit = new AddDirectDebitNetLoader(getEbayContext(), checkoutCartApi.iafToken, directdebit);
        getFwLoaderManager().start(Operation.ADD_DIRECT_DEBIT.ordinal(), directdebit, false);
    }

    protected void apiAddDonation(String s, int i, String s1)
    {
        updatedCartLineItemId = null;
        s = new AddItemsNetLoader(getEbayContext(), checkoutCartApi, cart.cartId, s, i, s1, 1);
        getFwLoaderManager().start(Operation.ADD_DONATION.ordinal(), s, false);
    }

    protected void apiAgreeToPaymentAgreement()
    {
        com.ebay.common.model.cart.CartPaymentMethods.PaymentMethod paymentmethod = cart.cartPaymentMethods.getSelectedPaymentMethod();
        if (paymentmethod != null)
        {
            com.ebay.common.model.cart.CartPaymentMethods.PaymentMethod.PaymentInstrument paymentinstrument = paymentmethod.getPaymentInstrument();
            if (paymentinstrument != null)
            {
                apiSetPaymentInstrumentInternal(paymentmethod.getName(), paymentinstrument.getPaymentInstrumentRefId(), null, Boolean.valueOf(true));
            }
        }
    }

    protected void apiApplyIncentives(List list, List list1)
    {
        updatedCartLineItemId = null;
        list = new UpdateCartNetLoader(getEbayContext(), checkoutCartApi, cart.cartId, list, list1);
        getFwLoaderManager().start(Operation.APPLY_INCENTIVES.ordinal(), list, true);
    }

    protected void apiBuyCart(String s)
    {
        lineItemIdToIsTransacted.clear();
        if (cart != null)
        {
            com.ebay.common.model.cart.Cart.LineItem lineitem;
            for (Iterator iterator = cart.lineItems.iterator(); iterator.hasNext(); lineItemIdToIsTransacted.put(lineitem.cartLineItemId, Boolean.valueOf(lineitem.isTransacted())))
            {
                lineitem = (com.ebay.common.model.cart.Cart.LineItem)iterator.next();
            }

        }
        s = new BuyNetLoader(getEbayContext(), checkoutCartApi, s);
        getFwLoaderManager().start(Operation.BUY.ordinal(), s, false);
    }

    protected void apiCreateCart()
    {
        CreateCartNetLoader createcartnetloader = new CreateCartNetLoader(getEbayContext(), checkoutCartApi, getDefaultShippingAddress(), transaction.quantityPurchased, String.valueOf(item.id), transaction.transactionId, variationId, isProxEnabled());
        getFwLoaderManager().start(Operation.CREATE_CART.ordinal(), createcartnetloader, true);
    }

    protected void apiCreateCheckoutSession()
    {
        ArrayList arraylist = new ArrayList(shopCartItems.size());
        for (Iterator iterator = shopCartItems.values().iterator(); iterator.hasNext(); arraylist.add(Long.valueOf(((CheckoutItem)iterator.next()).shopCartLineItemId))) { }
        if (shoppingCartDataManager != null)
        {
            shoppingCartDataManager.createCheckoutSession(Long.valueOf(shopCartId), arraylist, shoppingCartDataHandler, checkoutCartApi.riskCorrelationId);
        }
    }

    protected void apiGetAddresses()
    {
        if (getDefaultShippingAddress() != null)
        {
            onSuccess(Operation.GET_ADDRESSES);
            return;
        } else
        {
            operationPendingOnDataManager = Operation.GET_ADDRESSES;
            addressDataManager.forceReloadData();
            enableProgressDialog(true, true);
            updateProgressDialog(0x7f070c6d);
            return;
        }
    }

    protected void apiGetCart(String s)
    {
        com.ebay.nautilus.kernel.content.EbayContext ebaycontext = getEbayContext();
        EbayCartApi ebaycartapi = checkoutCartApi;
        String s1;
        if (currencyConversionRequest)
        {
            s1 = siteCurrencyCode;
        } else
        {
            s1 = "";
        }
        s = new GetCartNetLoader(ebaycontext, ebaycartapi, s, s1);
        getFwLoaderManager().start(Operation.GET_CART.ordinal(), s, true);
    }

    public void apiGetFundingInstrument(String s)
    {
        s = new GetFundingInstrumentNetLoader(getEbayContext(), checkoutCartApi.iafToken, s);
        getFwLoaderManager().start(Operation.GET_FUNDING_INSTRUMENT.ordinal(), s, false);
    }

    protected void apiGetItemIncentives(boolean flag)
    {
        Object obj = MyApp.getPrefs().getCurrentSite();
        obj = new GetItemIncentivesNetLoader(getEbayContext(), checkoutCartApi, ((EbaySite) (obj)).getCurrency().getCurrencyCode(), String.valueOf(item.id), transaction.transactionId, variationId, transaction.quantityPurchased, flag, false);
        int i;
        if (flag)
        {
            i = Operation.GET_INCENTIVES_REWARDS.ordinal();
        } else
        {
            i = Operation.GET_INCENTIVES_COUPONS.ordinal();
        }
        getFwLoaderManager().start(i, ((FwLoader) (obj)), true);
    }

    protected void apiGetUserIncentives(boolean flag)
    {
        Object obj1 = getEbayContext();
        EbayCartApi ebaycartapi = checkoutCartApi;
        Object obj;
        int i;
        if (flag)
        {
            obj = com.ebay.common.net.api.cart.GetUserIncentives.UserIncentiveType.VOUCHER;
        } else
        {
            obj = com.ebay.common.net.api.cart.GetUserIncentives.UserIncentiveType.COUPON;
        }
        obj = new GetUserIncentivesNetLoader(((com.ebay.nautilus.kernel.content.EbayContext) (obj1)), ebaycartapi, ((com.ebay.common.net.api.cart.GetUserIncentives.UserIncentiveType) (obj)));
        obj1 = getFwLoaderManager();
        if (flag)
        {
            i = Operation.GET_USER_INCENTIVES_VOUCHERS.ordinal();
        } else
        {
            i = Operation.GET_USER_INCENTIVES_COUPONS.ordinal();
        }
        ((FwLoaderManager) (obj1)).start(i, ((FwLoader) (obj)), true);
    }

    protected void apiInitDyson()
    {
        enableProgressDialog(true, true);
        updateProgressDialog(0x7f070c6d);
        dysonDataManager.load(LocationUtil.getLastKnownLocation(this));
    }

    protected void apiInitPaymentForPrepare()
    {
        InitPaymentNetLoader initpaymentnetloader = new InitPaymentNetLoader(getEbayContext(), checkoutCartApi, cart.cartId, getDefaultShippingAddress(), useGuestXo, selectedPaymentMethod);
        getFwLoaderManager().start(Operation.INIT_PAYMENT_FOR_PREPARE.ordinal(), initpaymentnetloader, false);
    }

    protected void apiInitPaymentForPrepareWithPayPal()
    {
        InitPaymentNetLoader initpaymentnetloader = new InitPaymentNetLoader(getEbayContext(), checkoutCartApi, cart.cartId, getDefaultShippingAddress(), useGuestXo, "PayPal");
        getFwLoaderManager().start(Operation.INIT_PAYMENT_FOR_PREPARE.ordinal(), initpaymentnetloader, false);
    }

    protected void apiInitPaymentForRefresh()
    {
        while (cart != null && cart.isProx() || paymentSession == null || !paymentMethodCompleted) 
        {
            return;
        }
        InitPaymentNetLoader initpaymentnetloader = new InitPaymentNetLoader(getEbayContext(), checkoutCartApi, cart.cartId, getDefaultShippingAddress(), useGuestXo, selectedPaymentMethod);
        getFwLoaderManager().start(Operation.INIT_PAYMENT_FOR_REFRESH.ordinal(), initpaymentnetloader, false);
    }

    protected void apiInitPaymentResult(String s)
    {
        if (cart.isProx())
        {
            apiBuyCart(cart.cartId);
            return;
        } else
        {
            s = new InitPaymentResultNetLoader(getEbayContext(), checkoutCartApi, s);
            getFwLoaderManager().start(Operation.INIT_PAYMENT_RESULT.ordinal(), s, false);
            return;
        }
    }

    protected void apiMakeCart()
    {
        if (shopCartId > 0L)
        {
            apiCreateCheckoutSession();
            return;
        } else
        {
            apiCreateCart();
            return;
        }
    }

    protected void apiPayPalCheckout(String s, String s1, boolean flag)
    {
        String s2 = null;
        String s3;
        String s4;
        Object obj;
        int i;
        try
        {
            s = new URL(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s = s2;
        }
        obj = MyApp.getPrefs();
        s2 = ((Preferences) (obj)).getPayPalCheckoutAuthToken();
        s3 = ((Preferences) (obj)).getPayPalCheckoutVisitorId();
        s4 = ((Preferences) (obj)).getPayPalCheckoutSessionId();
        obj = ((Preferences) (obj)).getPayPalCheckoutFundingSourceId();
        if (flag)
        {
            i = Operation.PAYPAL_CHECKOUT_FOR_REFRESH.ordinal();
        } else
        {
            i = Operation.PAYPAL_CHECKOUT.ordinal();
        }
        s = new PayPalCheckoutNetLoader(getEbayContext(), checkoutCartApi, s, s1, serviceProviderToken, s2, s3, s4, ((String) (obj)), checkoutCartApi.riskPayload);
        getFwLoaderManager().start(i, s, false);
    }

    protected void apiRedeemIncentive(String s)
    {
        updatedCartLineItemId = null;
        ArrayList arraylist = new ArrayList(1);
        arraylist.add(s);
        s = new UpdateCartNetLoader(getEbayContext(), checkoutCartApi, cart.cartId, arraylist, null);
        getFwLoaderManager().start(Operation.REDEEM_INCENTIVE.ordinal(), s, false);
    }

    protected void apiRefreshAddresses()
    {
        operationPendingOnDataManager = Operation.REFRESH_ADDRESSES;
        addressDataManager.forceReloadData();
        enableProgressDialog(false, false);
    }

    protected void apiRefreshCart(String s)
    {
        com.ebay.nautilus.kernel.content.EbayContext ebaycontext = getEbayContext();
        EbayCartApi ebaycartapi = checkoutCartApi;
        String s1;
        if (currencyConversionRequest)
        {
            s1 = siteCurrencyCode;
        } else
        {
            s1 = "";
        }
        s = new GetCartNetLoader(ebaycontext, ebaycartapi, s, s1);
        getFwLoaderManager().start(Operation.REFRESH_CART.ordinal(), s, true);
    }

    protected void apiRemoveDonation(String s)
    {
        updatedCartLineItemId = null;
        s = new UpdateCartNetLoader(getEbayContext(), checkoutCartApi, cart.cartId, s);
        getFwLoaderManager().start(Operation.REMOVE_DONATION.ordinal(), s, false);
    }

    protected void apiRequestTokenForService(String s)
    {
        s = new RequestTokenForServiceNetLoader(getEbayContext(), checkoutCartApi, MyApp.getPrefs().getCurrentSite(), s);
        getFwLoaderManager().start(Operation.REQUEST_TOKEN_FOR_SERVICE.ordinal(), s, false);
    }

    protected void apiResetPaymentInstrument()
    {
        Object obj = cart.cartPaymentMethods.getSelectedPaymentMethod();
        if (obj != null)
        {
            obj = ((com.ebay.common.model.cart.CartPaymentMethods.PaymentMethod) (obj)).getPaymentInstrument();
            if (obj != null)
            {
                String s = ((com.ebay.common.model.cart.CartPaymentMethods.PaymentMethod.PaymentInstrument) (obj)).getSelectedFundingStrategy().getSelectedStrategyChoice().getStrategyChoiceId();
                if (s != null)
                {
                    apiSetPaymentInstrument(selectedPaymentMethod, ((com.ebay.common.model.cart.CartPaymentMethods.PaymentMethod.PaymentInstrument) (obj)).getPaymentInstrumentRefId(), s);
                }
            }
        }
    }

    protected void apiSetPayUponInvoice(String s, Calendar calendar, String s1)
    {
        s = new SetPaymentMethodNetLoader(getEbayContext(), checkoutCartApi, cart.cartId, s, null, null, shouldRememberPaymentInstrument(), null, calendar.getTime(), s1);
        getFwLoaderManager().start(Operation.SET_PAYMENT_INSTRUMENT.ordinal(), s, false);
    }

    protected void apiSetPaymentInstrument(String s, String s1, String s2)
    {
        apiSetPaymentInstrumentInternal(s, s1, s2, null);
    }

    protected void apiSetShippingAddress(Operation operation, Address address)
    {
        updatedCartLineItemId = null;
        address = new SetShippingAddressNetLoader(getEbayContext(), checkoutCartApi, address, cart.cartId);
        getFwLoaderManager().start(operation.ordinal(), address, false);
    }

    protected void apiToggleRememberPaymentInstrument(boolean flag)
    {
        Object obj2 = cart.cartPaymentMethods.getSelectedPaymentMethod();
        com.ebay.common.model.cart.CartPaymentMethods.PaymentMethod.PaymentInstrument paymentinstrument = ((com.ebay.common.model.cart.CartPaymentMethods.PaymentMethod) (obj2)).getPaymentInstrument();
        if (paymentinstrument != null && flag != shouldRememberPaymentInstrument())
        {
            Object obj1 = null;
            Object obj = obj1;
            if ("DirectDebit".equals(selectedPaymentMethod))
            {
                obj2 = ((com.ebay.common.model.cart.CartPaymentMethods.PaymentMethod) (obj2)).getPaymentAgreement();
                obj = obj1;
                if (obj2 != null)
                {
                    if (((com.ebay.common.model.cart.CartPaymentMethods.PaymentMethod.PaymentInstrument.PaymentAgreement) (obj2)).isAccepted())
                    {
                        obj = Boolean.valueOf(true);
                    } else
                    {
                        obj = Boolean.valueOf(false);
                    }
                }
            }
            obj = new SetPaymentMethodNetLoader(getEbayContext(), checkoutCartApi, cart.cartId, selectedPaymentMethod, paymentinstrument.getPaymentInstrumentRefId(), paymentinstrument.getFundingStrategyChoiceId(), flag, ((Boolean) (obj)), null, null);
            getFwLoaderManager().start(Operation.SET_PAYMENT_INSTRUMENT.ordinal(), ((FwLoader) (obj)), false);
        }
    }

    protected void apiUpdateCreditCard(String s, CreditCard creditcard)
    {
        s = new UpdateCreditCardNetLoader(getEbayContext(), checkoutCartApi.iafToken, s, creditcard);
        getFwLoaderManager().start(Operation.UPDATE_CREDIT_CARD.ordinal(), s, false);
    }

    protected void apiUpdateDeliveryReservation(String s, DeliverySchedulingParams deliveryschedulingparams)
    {
        updatedCartLineItemId = s;
        String s1 = deliveryschedulingparams.selectedLogisticsPlanOptionToken;
        ArrayList arraylist = new ArrayList();
        Object obj = cart.getSellerUserIdFromLineItem(s);
        for (obj = ((com.ebay.common.model.cart.Cart.Seller)cart.sellers.get(obj)).cartLineItemIds.iterator(); ((Iterator) (obj)).hasNext();)
        {
            Object obj1 = (String)((Iterator) (obj)).next();
            obj1 = cart.getLineItemByCartLineItemId(((String) (obj1)));
            if (((com.ebay.common.model.cart.Cart.LineItem) (obj1)).isEbayNowAvailable())
            {
                obj1 = ((com.ebay.common.model.cart.Cart.LineItem) (obj1)).getLogisticsPlanOfType(com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type.EBAY_NOW).planSteps.iterator();
                while (((Iterator) (obj1)).hasNext()) 
                {
                    Iterator iterator = ((com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.PlanStep)((Iterator) (obj1)).next()).planOptionsList.iterator();
                    while (iterator.hasNext()) 
                    {
                        com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.PlanStep.PlanOption planoption = (com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.PlanStep.PlanOption)iterator.next();
                        if (planoption.token.equals(s1))
                        {
                            arraylist.add(planoption.logisticsOptionIdentifier);
                        }
                    }
                }
            }
        }

        s = new UpdateDeliveryReservationNetLoader(getEbayContext(), checkoutCartApi, cart.cartId, s, arraylist, deliveryschedulingparams.selectedReservationToken, null);
        getFwLoaderManager().start(Operation.UPDATE_DELIVERY_RESERVATION.ordinal(), s, false);
    }

    public void apiUpdateDirectDebit(String s, DirectDebit directdebit)
    {
        s = new UpdateDirectDebitNetLoader(getEbayContext(), checkoutCartApi.iafToken, s, directdebit);
        getFwLoaderManager().start(Operation.UPDATE_DIRECT_DEBIT.ordinal(), s, false);
    }

    protected void apiUpdateItemNote(String s, String s1)
    {
        updatedCartLineItemId = null;
        s = new UpdateCartNetLoader(getEbayContext(), checkoutCartApi, cart.cartId, null, s, s1);
        getFwLoaderManager().start(Operation.UPDATE_SELLER_NOTE.ordinal(), s, false);
    }

    protected void apiUpdateItemQuantity(String s, int i)
    {
        updatedCartLineItemId = null;
        s = new UpdateCartNetLoader(getEbayContext(), checkoutCartApi, cart.cartId, s, i);
        getFwLoaderManager().start(Operation.UPDATE_ITEM_QUANTITY.ordinal(), s, false);
    }

    protected void apiUpdatePickupMethod(String s, String s1, String s2, com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type type)
    {
        updatedCartLineItemId = s;
        ArrayList arraylist = new ArrayList();
        if (com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type.PUDO.equals(type))
        {
            s1 = cart.getSellerUserIdFromLineItem(s);
            for (s1 = ((com.ebay.common.model.cart.Cart.Seller)cart.sellers.get(s1)).cartLineItemIds.iterator(); s1.hasNext();)
            {
                Object obj = (String)s1.next();
                obj = cart.getLineItemByCartLineItemId(((String) (obj)));
                if (((com.ebay.common.model.cart.Cart.LineItem) (obj)).isPickupAndDropoffAvailable())
                {
                    obj = ((com.ebay.common.model.cart.Cart.LineItem) (obj)).getLogisticsPlanOfType(com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type.PUDO).planSteps.iterator();
                    while (((Iterator) (obj)).hasNext()) 
                    {
                        Iterator iterator = ((com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.PlanStep)((Iterator) (obj)).next()).planOptionsList.iterator();
                        while (iterator.hasNext()) 
                        {
                            com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.PlanStep.PlanOption planoption = (com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.PlanStep.PlanOption)iterator.next();
                            if (planoption.token.equals(com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type.PUDO.altName))
                            {
                                arraylist.add(planoption.logisticsOptionIdentifier);
                            }
                        }
                    }
                }
            }

        } else
        {
            arraylist.add(s1);
        }
        s = new UpdatePickupMethodNetLoader(getEbayContext(), checkoutCartApi, cart.cartId, s, arraylist, s2, type);
        getFwLoaderManager().start(Operation.UPDATE_PICKUP_METHOD.ordinal(), s, false);
    }

    protected void apiUpdateShippingMethod(String s, String s1, String s2)
    {
        updatedCartLineItemId = s;
        s = new UpdateLogisticsPlanNetLoader(getEbayContext(), checkoutCartApi, cart.cartId, new UpdateLogisticsPlanParams(s1, s2));
        getFwLoaderManager().start(Operation.UPDATE_SHIPPING_METHOD.ordinal(), s, false);
    }

    protected void apiUpdateShippingMethod(List list)
    {
        list = new UpdateLogisticsPlanNetLoader(getEbayContext(), checkoutCartApi, cart.cartId, list);
        getFwLoaderManager().start(Operation.UPDATE_SHIPPING_METHOD.ordinal(), list, false);
    }

    protected boolean checkForIafTokenFailure(List list)
    {
        if (EbayErrorUtil.userNotLoggedIn(list) && MyApp.getPrefs().isSignedIn())
        {
            MyApp.signOutForIafTokenFailure(this);
            finish();
            return true;
        } else
        {
            return false;
        }
    }

    protected void enableProgressDialog(boolean flag, boolean flag1)
    {
        ViewGroup viewgroup;
        ViewGroup viewgroup1;
        byte byte0;
        if (flag)
        {
            progressDialog.show();
        } else
        {
            progressDialog.hide();
        }
        viewgroup1 = (ViewGroup)findViewById(0x7f1003a9);
        viewgroup = viewgroup1;
        if (viewgroup1 == null)
        {
            viewgroup = (ViewGroup)findViewById(0x1020002);
        }
        if (flag1)
        {
            byte0 = 8;
        } else
        {
            byte0 = 0;
        }
        viewgroup.setVisibility(byte0);
    }

    protected CharSequence formatFundingSourceDetailText(String s, String s1, boolean flag)
    {
        boolean flag1 = false;
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
        if (!TextUtils.isEmpty(s))
        {
            spannablestringbuilder.append(s);
        }
        int i;
        int j;
        if (flag)
        {
            i = spannablestringbuilder.length();
        } else
        {
            i = 0;
        }
        j = i;
        if (!TextUtils.isEmpty(s1))
        {
            spannablestringbuilder.append(", ");
            j = ((flag1) ? 1 : 0);
            if (flag)
            {
                j = ", ".length();
            }
            j = i + j;
            spannablestringbuilder.append(s1);
        }
        spannablestringbuilder.setSpan(new ForegroundColorSpan(getResources().getColor(0x7f0d0110)), j, spannablestringbuilder.length(), 33);
        return spannablestringbuilder;
    }

    public int getAvailableIncentiveCount()
    {
        HashSet hashset = new HashSet();
        if (userIncentives != null && userIncentives.incentives != null)
        {
            for (Iterator iterator = userIncentives.incentives.iterator(); iterator.hasNext(); hashset.add(((Incentive)iterator.next()).redemptionCode)) { }
        }
        if (itemIncentivesCoupons != null && itemIncentivesCoupons.incentives != null)
        {
            for (Iterator iterator1 = itemIncentivesCoupons.incentives.iterator(); iterator1.hasNext(); hashset.add(((Incentive)iterator1.next()).redemptionCode)) { }
        }
        if (payPalCheckoutDetails != null && payPalCheckoutDetails.incentives.length > 0)
        {
            com.ebay.common.model.cart.PayPalCheckoutDetails.Incentive aincentive[] = payPalCheckoutDetails.incentives;
            int j = aincentive.length;
            for (int i = 0; i < j; i++)
            {
                hashset.add(aincentive[i].code);
            }

        }
        return hashset.size();
    }

    public Address getDefaultShippingAddress()
    {
        return getDefaultAddress(shippingAddresses);
    }

    protected String getDisplayStringForPayPalFundingSource(com.ebay.common.model.cart.CartPaymentMethods.PaymentMethod.PaymentInstrument.FundingStrategy.StrategyChoice.FundingSource fundingsource)
    {
        String s = fundingsource.getType();
        if (s.equals("BALANCE"))
        {
            return getString(0x7f0707df);
        }
        if (s.equals("PAYMENT_CARD"))
        {
            s = fundingsource.getSubtype();
            if ("AMEX".equals(s))
            {
                return getString(0x7f0707d7, new Object[] {
                    fundingsource.getMaskedId()
                });
            }
            if ("VISA".equals(s))
            {
                return getString(0x7f0707e0, new Object[] {
                    fundingsource.getMaskedId()
                });
            }
            if ("MASTERCARD".equals(s))
            {
                return getString(0x7f0707dd, new Object[] {
                    fundingsource.getMaskedId()
                });
            }
            if ("DINERS".equals(s))
            {
                return getString(0x7f0707db, new Object[] {
                    fundingsource.getMaskedId()
                });
            }
            if ("DISCOVER".equals(s))
            {
                return getString(0x7f0707dc, new Object[] {
                    fundingsource.getMaskedId()
                });
            } else
            {
                return getString(0x7f0707d8, new Object[] {
                    fundingsource.getMaskedId()
                });
            }
        }
        if (s.equals("BANK_ACCOUNT"))
        {
            if ("MANUAL_BANK_TRANSFER".equals(fundingsource.getMode()))
            {
                return getString(0x7f0707de, new Object[] {
                    fundingsource.getMaskedId()
                });
            } else
            {
                return getString(0x7f0700c6, new Object[] {
                    fundingsource.getMaskedId()
                });
            }
        }
        if (s.equals("INCENTIVE"))
        {
            return getString(0x7f0707d9, new Object[] {
                fundingsource.getMaskedId()
            });
        }
        if (s.equals("CREDIT"))
        {
            return getString(0x7f0707da);
        } else
        {
            return null;
        }
    }

    protected CharSequence getDisplayStringForPaymentInstrument(com.ebay.common.model.cart.CartPaymentMethods.PaymentMethod.PaymentInstrument paymentinstrument)
    {
        if (paymentinstrument != null)
        {
            static class _cls2
            {

                static final int $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[];
                static final int $SwitchMap$com$ebay$nautilus$domain$data$CreditCard$Type[];

                static 
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$CreditCard$Type = new int[com.ebay.nautilus.domain.data.CreditCard.Type.values().length];
                    try
                    {
                        $SwitchMap$com$ebay$nautilus$domain$data$CreditCard$Type[com.ebay.nautilus.domain.data.CreditCard.Type.VISA.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror35) { }
                    try
                    {
                        $SwitchMap$com$ebay$nautilus$domain$data$CreditCard$Type[com.ebay.nautilus.domain.data.CreditCard.Type.DISCOVER.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror34) { }
                    try
                    {
                        $SwitchMap$com$ebay$nautilus$domain$data$CreditCard$Type[com.ebay.nautilus.domain.data.CreditCard.Type.AMERICANEXPRESS.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror33) { }
                    try
                    {
                        $SwitchMap$com$ebay$nautilus$domain$data$CreditCard$Type[com.ebay.nautilus.domain.data.CreditCard.Type.MASTERCARD.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror32) { }
                    $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation = new int[Operation.values().length];
                    try
                    {
                        $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[Operation.CREATE_CHECKOUT_SESSION.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror31) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[Operation.CREATE_CART.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror30) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[Operation.APPLY_INCENTIVES.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror29) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[Operation.REDEEM_INCENTIVE.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror28) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[Operation.INIT_PAYMENT_FOR_PREPARE.ordinal()] = 5;
                    }
                    catch (NoSuchFieldError nosuchfielderror27) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[Operation.REQUEST_TOKEN_FOR_SERVICE.ordinal()] = 6;
                    }
                    catch (NoSuchFieldError nosuchfielderror26) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[Operation.INIT_PAYMENT_FOR_REFRESH.ordinal()] = 7;
                    }
                    catch (NoSuchFieldError nosuchfielderror25) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[Operation.PAYPAL_CHECKOUT_FOR_REFRESH.ordinal()] = 8;
                    }
                    catch (NoSuchFieldError nosuchfielderror24) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[Operation.UPDATE_SHIPPING_METHOD.ordinal()] = 9;
                    }
                    catch (NoSuchFieldError nosuchfielderror23) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[Operation.UPDATE_ITEM_QUANTITY.ordinal()] = 10;
                    }
                    catch (NoSuchFieldError nosuchfielderror22) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[Operation.UPDATE_SELLER_NOTE.ordinal()] = 11;
                    }
                    catch (NoSuchFieldError nosuchfielderror21) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[Operation.UPDATE_PICKUP_METHOD.ordinal()] = 12;
                    }
                    catch (NoSuchFieldError nosuchfielderror20) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[Operation.UPDATE_DELIVERY_RESERVATION.ordinal()] = 13;
                    }
                    catch (NoSuchFieldError nosuchfielderror19) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[Operation.REMOVE_DONATION.ordinal()] = 14;
                    }
                    catch (NoSuchFieldError nosuchfielderror18) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[Operation.ADD_DONATION.ordinal()] = 15;
                    }
                    catch (NoSuchFieldError nosuchfielderror17) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[Operation.SET_PAYMENT_INSTRUMENT.ordinal()] = 16;
                    }
                    catch (NoSuchFieldError nosuchfielderror16) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[Operation.ADD_CREDIT_CARD.ordinal()] = 17;
                    }
                    catch (NoSuchFieldError nosuchfielderror15) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[Operation.ADD_DIRECT_DEBIT.ordinal()] = 18;
                    }
                    catch (NoSuchFieldError nosuchfielderror14) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[Operation.UPDATE_CREDIT_CARD.ordinal()] = 19;
                    }
                    catch (NoSuchFieldError nosuchfielderror13) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[Operation.UPDATE_DIRECT_DEBIT.ordinal()] = 20;
                    }
                    catch (NoSuchFieldError nosuchfielderror12) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[Operation.GET_FUNDING_INSTRUMENT.ordinal()] = 21;
                    }
                    catch (NoSuchFieldError nosuchfielderror11) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[Operation.PAYPAL_CHECKOUT.ordinal()] = 22;
                    }
                    catch (NoSuchFieldError nosuchfielderror10) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[Operation.SET_DEFAULT_SHIPPING_ADDRESS.ordinal()] = 23;
                    }
                    catch (NoSuchFieldError nosuchfielderror9) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[Operation.SET_SHIPPING_ADDRESS.ordinal()] = 24;
                    }
                    catch (NoSuchFieldError nosuchfielderror8) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[Operation.INIT_PAYMENT_RESULT.ordinal()] = 25;
                    }
                    catch (NoSuchFieldError nosuchfielderror7) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[Operation.BUY.ordinal()] = 26;
                    }
                    catch (NoSuchFieldError nosuchfielderror6) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[Operation.REFRESH_CART.ordinal()] = 27;
                    }
                    catch (NoSuchFieldError nosuchfielderror5) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[Operation.GET_CART.ordinal()] = 28;
                    }
                    catch (NoSuchFieldError nosuchfielderror4) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[Operation.GET_USER_INCENTIVES_VOUCHERS.ordinal()] = 29;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[Operation.GET_USER_INCENTIVES_COUPONS.ordinal()] = 30;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[Operation.GET_INCENTIVES_COUPONS.ordinal()] = 31;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[Operation.GET_INCENTIVES_REWARDS.ordinal()] = 32;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            if ("CREDIT_CARD".equals(paymentinstrument.getType()))
            {
                switch (_cls2..SwitchMap.com.ebay.nautilus.domain.data.CreditCard.Type[paymentinstrument.getCreditCardType().ordinal()])
                {
                default:
                    return getString(0x7f0707d8, new Object[] {
                        paymentinstrument.getCreditCardLastFourDigits()
                    });

                case 1: // '\001'
                    return getString(0x7f0707e0, new Object[] {
                        paymentinstrument.getCreditCardLastFourDigits()
                    });

                case 2: // '\002'
                    return getString(0x7f0707dc, new Object[] {
                        paymentinstrument.getCreditCardLastFourDigits()
                    });

                case 3: // '\003'
                    return getString(0x7f0707d7, new Object[] {
                        paymentinstrument.getCreditCardLastFourDigits()
                    });

                case 4: // '\004'
                    return getString(0x7f0707dd, new Object[] {
                        paymentinstrument.getCreditCardLastFourDigits()
                    });
                }
            }
            if ("BANK_ACCOUNT".equals(paymentinstrument.getType()))
            {
                return getString(0x7f0700c6, new Object[] {
                    paymentinstrument.getBankLastFourDigits()
                });
            }
        }
        return null;
    }

    public EnergyEfficiencyRating getEekForItem(com.ebay.common.model.cart.Cart.LineItem lineitem)
    {
        if (MyApp.getDeviceConfiguration().getConfig().get(DcsNautilusBoolean.payments_showEekRatings))
        {
            return lineitem.getEek();
        } else
        {
            return null;
        }
    }

    public InventoryInfo getInventoryInfo(String s)
    {
        return (InventoryInfo)inventoryInfoMap.get(s);
    }

    protected List getShippingAddresses()
    {
        return shippingAddresses;
    }

    protected void handleCheckoutSessionComplete(ShoppingCartDataManagerBase shoppingcartdatamanagerbase, Content content)
    {
        shoppingcartdatamanagerbase = (com.ebay.nautilus.domain.data.ShoppingCart.CheckoutSession)content.getData();
        if (content.getStatus() == ResultStatus.SUCCESS && shoppingcartdatamanagerbase != null)
        {
            cartId = ((com.ebay.nautilus.domain.data.ShoppingCart.CheckoutSession) (shoppingcartdatamanagerbase)).token;
            onSuccess(Operation.CREATE_CHECKOUT_SESSION);
            return;
        } else
        {
            onPartialFailure(Operation.CREATE_CHECKOUT_SESSION, new ResultStatusJsonModel(getEbayContext(), content.getStatus()));
            return;
        }
    }

    protected void initializeCheckout()
    {
        shippingAddresses = new ArrayList();
        cartId = null;
        cart = null;
        paymentInstruction = null;
        itemIncentivesCoupons = null;
        itemIncentivesRewards = null;
        paymentSession = null;
        serviceProviderToken = null;
        userIncentives = null;
        payPalCheckoutDetails = null;
        paymentMethodCompleted = false;
        useGuestXo = false;
        selectedPaymentMethod = null;
        paymentMethodCount = 0;
        lineItemsWithShippingChanges = new HashSet();
        unshippableAddresses = new HashMap();
        inventoryInfoMap = new HashMap();
        temporaryFundingInstrumentId = null;
        siteCurrencyCode = MyApp.getPrefs().getCurrentCountry().getCurrency().getCurrencyCode();
        currencyConversionRequest = MyApp.getDeviceConfiguration().getConfig().get(DcsBoolean.checkoutConvertCartToSiteCurrency);
    }

    public boolean isCopAvailable()
    {
        if (MyApp.getDeviceConfiguration().isAlternativePaymentMethodsAvailable() && cart != null)
        {
            return cart.isCopAvailable();
        } else
        {
            return false;
        }
    }

    public boolean isCreditCardAvailable()
    {
        if (cart != null)
        {
            return cart.isCreditCardAvailable();
        } else
        {
            return false;
        }
    }

    public boolean isDirectDebitAvailable()
    {
        return cart != null && cart.isDirectDebitAvailable();
    }

    public boolean isEftAvailable()
    {
        if (MyApp.getDeviceConfiguration().isAlternativePaymentMethodsAvailable() && cart != null)
        {
            return cart.isEftAvailable();
        } else
        {
            return false;
        }
    }

    public boolean isPayPalAvailable()
    {
        return cart != null && cart.isPayPalAvailable();
    }

    public boolean isPayPalGuestXoAvailable()
    {
        if (!cart.isProx() && isPayPalAvailable())
        {
            DeviceConfiguration deviceconfiguration = DeviceConfiguration.getAsync();
            if ((!MyApp.getPrefs().hasPayPalAccount() || deviceconfiguration.get(DcsBoolean.MecAlwaysOfferGuestXo) && deviceconfiguration.get(DcsBoolean.MEC2)) && (deviceconfiguration.get(DcsBoolean.MecBankTransfer) || deviceconfiguration.get(DcsBoolean.MecGuestXo)))
            {
                return true;
            }
        }
        return false;
    }

    public boolean isPayPalSelected()
    {
        return isPayPalAvailable() && "PayPal".equals(selectedPaymentMethod);
    }

    protected boolean isProxEnabled()
    {
        DeviceConfiguration deviceconfiguration = DeviceConfiguration.getAsync();
        return deviceconfiguration.get(DcsNautilusBoolean.PROX) && deviceconfiguration.get(DcsBoolean.SSO);
    }

    public boolean isPuiAvailable()
    {
        return cart != null && cart.isProx() && DeviceConfiguration.getAsync().get(DcsBoolean.payments_payUponInvoiceEnabled) && cart.isPuiAvailable();
    }

    protected boolean isShoppingCartCheckout()
    {
        return shopCartId > 0L;
    }

    public boolean isTopRatedSellerAvailable()
    {
        DcsHelper dcshelper = MyApp.getDeviceConfiguration();
        return dcshelper.getConfig().get(DcsBoolean.TopRatedSeller3) && !TextUtils.isEmpty(dcshelper.topRatedSeller3Url()) && cart.hasEbayBuyerGuarantee();
    }

    public boolean isUnshippable(String s, String s1)
    {
        if (unshippableAddresses != null && unshippableAddresses.containsKey(s))
        {
            return ((List)unshippableAddresses.get(s)).contains(s1);
        } else
        {
            return false;
        }
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        if (j != 0 && intent != null)
        {
            loadCheckoutState(intent);
        }
    }

    public void onAddressDeleted(AddressDataManager addressdatamanager, Content content)
    {
    }

    public void onAddressPrimary(AddressDataManager addressdatamanager, Content content)
    {
    }

    public void onAddressUpdated(AddressDataManager addressdatamanager, Content content)
    {
        addressdatamanager = (AddressResponseData)content.getData();
        if (addressdatamanager != null)
        {
            updateAddressResponseId = ((AddressResponseData) (addressdatamanager)).addressId;
        }
    }

    public void onAddressesChanged(AddressDataManager addressdatamanager, Content content, boolean flag)
    {
        if (addressDataManager == null)
        {
            addressDataManager = addressdatamanager;
        }
        addressdatamanager = content.getStatus();
        if (!addressdatamanager.hasError())
        {
            break MISSING_BLOCK_LABEL_90;
        }
        if (!checkForIafTokenFailure(addressdatamanager.getMessages())) goto _L2; else goto _L1
_L1:
        return;
_L2:
        addressdatamanager = null;
_L4:
        if (flag)
        {
            countryChanged = handleDefaultAddressChange(this, userContextDataManager, addressdatamanager, false, "Address List");
        }
        setShippingAddresses(addressdatamanager);
        if (operationPendingOnDataManager == null) goto _L1; else goto _L3
_L3:
        if (addressdatamanager == null)
        {
            onPartialFailure(operationPendingOnDataManager, null);
        } else
        {
            onSuccess(operationPendingOnDataManager);
        }
        operationPendingOnDataManager = null;
        return;
        addressdatamanager = (List)content.getData();
          goto _L4
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        com.ebay.nautilus.domain.app.Authentication authentication = MyApp.getPrefs().getAuthentication();
        if (authentication == null)
        {
            finish();
            return;
        } else
        {
            checkoutCartApi = EbayApiUtil.getCartApi(this, authentication);
            progressDialog = ProgressDialog.show(this, "", "", true);
            enableProgressDialog(false, false);
            loadCheckoutState(bundle);
            return;
        }
    }

    protected void onDestroy()
    {
        if (progressDialog != null)
        {
            progressDialog.dismiss();
        }
        super.onDestroy();
    }

    public abstract void onError(Operation operation, boolean flag, IOException ioexception);

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        userContextDataManager = (UserContextDataManager)datamanagercontainer.initialize(UserContextDataManager.KEY, null);
        addressDataManager = (AddressDataManager)datamanagercontainer.initialize(new com.ebay.nautilus.domain.content.dm.AddressDataManager.KeyParams("Shipping"), this);
        shoppingCartDataHandler = new com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.SimpleObserver() {

            final BaseCheckoutActivity this$0;

            public void onCheckoutSessionComplete(ShoppingCartDataManagerBase shoppingcartdatamanagerbase, Content content)
            {
                handleCheckoutSessionComplete(shoppingcartdatamanagerbase, content);
            }

            
            {
                this$0 = BaseCheckoutActivity.this;
                super();
            }
        };
        com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.ServiceApi serviceapi;
        if (DeviceConfiguration.getAsync().get(com.ebay.nautilus.domain.dcs.DcsDomain.Payments.B.shopCaseCart))
        {
            serviceapi = com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.ServiceApi.SHOPCASE;
        } else
        {
            serviceapi = com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.ServiceApi.ECAS;
        }
        shoppingCartDataManager = (ShoppingCartDataManagerBase)datamanagercontainer.initialize(new com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.KeyParams(serviceapi), shoppingCartDataHandler);
        if (DeviceConfiguration.getAsync().get(DcsNautilusBoolean.PayPalDyson))
        {
            dysonDataManager = (DysonDataManager)datamanagercontainer.initialize(DysonDataManager.KEY, this);
        }
    }

    public void onPaired(DysonDataManager dysondatamanager, String s, JSONObject jsonobject)
    {
        checkoutCartApi.riskCorrelationId = s;
        checkoutCartApi.riskPayload = jsonobject;
        if (jsonobject != null)
        {
            try
            {
                if (jsonobject.has("device_model"))
                {
                    jsonobject.put("device_model", URLEncoder.encode(jsonobject.getString("device_model"), "UTF-8"));
                }
                if (jsonobject.has("device_name"))
                {
                    jsonobject.put("device_name", URLEncoder.encode(jsonobject.getString("device_name"), "UTF-8"));
                }
                if (jsonobject.has("ssid"))
                {
                    jsonobject.put("ssid", URLEncoder.encode(jsonobject.getString("ssid"), "UTF-8"));
                }
            }
            // Misplaced declaration of an exception variable
            catch (DysonDataManager dysondatamanager) { }
        }
        onSuccess(Operation.DYSON_PAIRED);
    }

    public abstract void onPartialFailure(Operation operation, JsonModel jsonmodel);

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        return false;
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("xo_state_item", item);
        bundle.putParcelable("xo_state_transaction", transaction);
        bundle.putString("xo_state_variation_id", variationId);
        bundle.putLong("xo_state_shop_cart_id", shopCartId);
        bundle.putSerializable("xo_state_shop_cart_items", (Serializable)shopCartItems);
        bundle.putString("xo_state_cart_id", cartId);
        bundle.putSerializable("xo_state_cart", cart);
        bundle.putSerializable("xo_state_payment_attributes", paymentInstruction);
        bundle.putSerializable("xo_state_item_incentives_coupons", itemIncentivesCoupons);
        bundle.putSerializable("xo_state_item_incentives_rewards", itemIncentivesRewards);
        bundle.putSerializable("xo_state_user_incentives", userIncentives);
        bundle.putString("xo_state_service_provider_token", serviceProviderToken);
        bundle.putSerializable("xo_state_paypal_checkout_details", payPalCheckoutDetails);
        bundle.putSerializable("xo_state_payment_session", paymentSession);
        bundle.putBoolean("paypal_completed", paymentMethodCompleted);
        bundle.putBoolean("use_guest_xo", useGuestXo);
        bundle.putSerializable("xo_state_shipping_addresses", (Serializable)getShippingAddresses());
        bundle.putString("selected_payment_method", selectedPaymentMethod);
        bundle.putInt("payment_method_count", paymentMethodCount);
        bundle.putString("update_address_request_id", updateAddressRequestId);
        bundle.putString("update_address_response_id", updateAddressResponseId);
        bundle.putSerializable("xo_state_inventory_info_for_items", (Serializable)inventoryInfoMap);
        bundle.putString("xo_state_updated_cart_line_item_id", updatedCartLineItemId);
        bundle.putString("xo_state_refined_postal_code", refinedPostalCode);
        bundle.putParcelableArrayList("xo_state_favorite_charities", (ArrayList)favoriteCharities);
        bundle.putSerializable("xo_state_line_items_with_shipping_changes", (Serializable)lineItemsWithShippingChanges);
        bundle.putBoolean("xo_state_country_changed", countryChanged);
        if (operationPendingOnDataManager != null)
        {
            bundle.putInt("xo_operation_pending_data_manager", operationPendingOnDataManager.ordinal());
        }
        bundle.putSerializable("xo_state_unshippable_addresses", (Serializable)unshippableAddresses);
        bundle.putString("xo_state_temp_funding_instrument", temporaryFundingInstrumentId);
        bundle.putParcelable("xo_state_fis_credit_card", creditCard);
        bundle.putParcelable("xo_state_fis_direct_debit", directDebit);
        String s;
        if (checkoutCartApi.riskPayload != null)
        {
            s = checkoutCartApi.riskPayload.toString();
        } else
        {
            s = "";
        }
        bundle.putString("xo_dyson_risk_payload", s);
    }

    public abstract void onSuccess(Operation operation);

    protected void onTaskComplete(int i, FwLoader fwloader)
    {
        Operation operation;
        if (isFinishing())
        {
            return;
        }
        operation = Operation.values()[i];
        EbaySimpleNetLoader ebaysimplenetloader = (EbaySimpleNetLoader)fwloader;
        if (ebaysimplenetloader.isError())
        {
            onError(operation, ebaysimplenetloader.isConnectionError(), ebaysimplenetloader.getException());
            return;
        }
        _cls2..SwitchMap.com.ebay.mobile.checkout.BaseCheckoutActivity.Operation[operation.ordinal()];
        JVM INSTR tableswitch 2 32: default 188
    //                   2 189
    //                   3 484
    //                   4 484
    //                   5 755
    //                   6 731
    //                   7 755
    //                   8 800
    //                   9 533
    //                   10 435
    //                   11 435
    //                   12 619
    //                   13 675
    //                   14 435
    //                   15 570
    //                   16 1052
    //                   17 1229
    //                   18 1229
    //                   19 1229
    //                   20 1229
    //                   21 1229
    //                   22 800
    //                   23 1180
    //                   24 1180
    //                   25 1007
    //                   26 1097
    //                   27 223
    //                   28 223
    //                   29 279
    //                   30 279
    //                   31 345
    //                   32 390;
           goto _L1 _L2 _L3 _L3 _L4 _L5 _L4 _L6 _L7 _L8 _L8 _L9 _L10 _L8 _L11 _L12 _L13 _L13 _L13 _L13 _L13 _L6 _L14 _L14 _L15 _L16 _L17 _L17 _L18 _L18 _L19 _L20
_L1:
        return;
_L2:
        fwloader = (com.ebay.common.net.api.cart.CreateCart.CreateCartResponse)((CreateCartNetLoader)fwloader).getResponse();
        cart = fwloader.getResponseCart();
        if (((com.ebay.common.net.api.cart.CreateCart.CreateCartResponse) (fwloader)).ackCode == 1)
        {
            onSuccess(operation);
            return;
        } else
        {
            onPartialFailure(operation, cart);
            return;
        }
_L17:
        fwloader = (com.ebay.common.net.api.cart.GetCart.GetCartResponse)((GetCartNetLoader)fwloader).getResponse();
        cart = fwloader.getResponseCart();
        if (((com.ebay.common.net.api.cart.GetCart.GetCartResponse) (fwloader)).ackCode == 1)
        {
            onSuccess(operation);
            return;
        } else
        {
            onPartialFailure(operation, cart);
            return;
        }
_L18:
        fwloader = (com.ebay.common.net.api.cart.GetUserIncentives.GetUserIncentivesResponse)((GetUserIncentivesNetLoader)fwloader).getResponse();
        if (userIncentives == null)
        {
            userIncentives = fwloader.getUserIncentives();
        } else
        {
            userIncentives.merge(fwloader.getUserIncentives());
        }
        if (((com.ebay.common.net.api.cart.GetUserIncentives.GetUserIncentivesResponse) (fwloader)).ackCode == 1)
        {
            onSuccess(operation);
            return;
        } else
        {
            onPartialFailure(operation, userIncentives);
            return;
        }
_L19:
        fwloader = (com.ebay.common.net.api.cart.GetItemIncentives.GetItemIncentivesResponse)((GetItemIncentivesNetLoader)fwloader).getResponse();
        itemIncentivesCoupons = fwloader.getItemIncentives();
        if (((com.ebay.common.net.api.cart.GetItemIncentives.GetItemIncentivesResponse) (fwloader)).ackCode == 1)
        {
            onSuccess(operation);
            return;
        } else
        {
            onPartialFailure(operation, itemIncentivesCoupons);
            return;
        }
_L20:
        fwloader = (com.ebay.common.net.api.cart.GetItemIncentives.GetItemIncentivesResponse)((GetItemIncentivesNetLoader)fwloader).getResponse();
        itemIncentivesRewards = fwloader.getItemIncentives();
        if (((com.ebay.common.net.api.cart.GetItemIncentives.GetItemIncentivesResponse) (fwloader)).ackCode == 1)
        {
            onSuccess(operation);
            return;
        } else
        {
            onPartialFailure(operation, itemIncentivesCoupons);
            return;
        }
_L8:
        fwloader = (UpdateCartResponse)((UpdateCartNetLoader)fwloader).getResponse();
        if (((UpdateCartResponse) (fwloader)).ackCode == 1)
        {
            cart = retainAndResolveLineItemCartState(fwloader.getResponseCart());
            onSuccess(operation);
            return;
        } else
        {
            onPartialFailure(operation, fwloader.getResponseCart());
            return;
        }
_L3:
        fwloader = (UpdateCartResponse)((UpdateCartNetLoader)fwloader).getResponse();
        cart = retainAndResolveLineItemCartState(fwloader.getResponseCart());
        if (((UpdateCartResponse) (fwloader)).ackCode == 1)
        {
            onSuccess(operation);
            return;
        } else
        {
            onPartialFailure(operation, fwloader.getResponseCart());
            return;
        }
_L7:
        fwloader = (UpdateCartResponse)((UpdateLogisticsPlanNetLoader)fwloader).getResponse();
        if (fwloader.getResponseCart() != null)
        {
            cart = retainAndResolveLineItemCartState(fwloader.getResponseCart());
        }
        onSuccess(operation);
        return;
_L11:
        fwloader = (com.ebay.common.net.api.cart.AddItems.AddItemsResponse)((AddItemsNetLoader)fwloader).getResponse();
        if (((com.ebay.common.net.api.cart.AddItems.AddItemsResponse) (fwloader)).ackCode == 1)
        {
            cart = retainAndResolveLineItemCartState(fwloader.getResponseCart());
            onSuccess(operation);
            return;
        } else
        {
            onPartialFailure(operation, fwloader.getResponseCart());
            return;
        }
_L9:
        fwloader = (UpdateCartResponse)((UpdatePickupMethodNetLoader)fwloader).getResponse();
        if (fwloader.getResponseCart() != null)
        {
            cart = retainAndResolveLineItemCartState(fwloader.getResponseCart());
        }
        if (((UpdateCartResponse) (fwloader)).ackCode == 1)
        {
            onSuccess(operation);
            return;
        } else
        {
            onPartialFailure(operation, fwloader.getResponseCart());
            return;
        }
_L10:
        fwloader = (UpdateCartResponse)((UpdateDeliveryReservationNetLoader)fwloader).getResponse();
        if (fwloader.getResponseCart() != null)
        {
            cart = retainAndResolveLineItemCartState(fwloader.getResponseCart());
        }
        if (((UpdateCartResponse) (fwloader)).ackCode == 1)
        {
            onSuccess(operation);
            return;
        } else
        {
            onPartialFailure(operation, fwloader.getResponseCart());
            return;
        }
_L5:
        serviceProviderToken = ((com.ebay.common.net.api.cart.RequestTokenForService.RequestTokenForServiceResponse)((RequestTokenForServiceNetLoader)fwloader).getResponse()).getToken();
        onSuccess(operation);
        return;
_L4:
        fwloader = (com.ebay.common.net.api.cart.InitPayment.InitPaymentResponse)((InitPaymentNetLoader)fwloader).getResponse();
        paymentSession = fwloader.getResponsePaymentSession();
        if (((com.ebay.common.net.api.cart.InitPayment.InitPaymentResponse) (fwloader)).ackCode == 1)
        {
            onSuccess(operation);
            return;
        } else
        {
            onPartialFailure(operation, paymentSession);
            return;
        }
_L6:
        com.ebay.common.net.api.cart.PayPalCheckout.PayPalCheckoutResponse paypalcheckoutresponse;
        PayPalCheckoutDetails paypalcheckoutdetails;
        paypalcheckoutresponse = (com.ebay.common.net.api.cart.PayPalCheckout.PayPalCheckoutResponse)((PayPalCheckoutNetLoader)fwloader).getResponse();
        paypalcheckoutdetails = paypalcheckoutresponse.getResponseDetails();
        if (paypalcheckoutdetails == null) goto _L22; else goto _L21
_L21:
        fwloader = MyApp.getPrefs();
        com.ebay.common.model.cart.PayPalCheckoutDetails.FundingSource afundingsource[];
        com.ebay.common.model.cart.PayPalCheckoutDetails.FundingSource fundingsource;
        int j;
        if (paypalcheckoutdetails.isSignedIn())
        {
            fwloader.setPayPalCheckoutAuthToken(paypalcheckoutdetails.account.authToken);
        } else
        {
            fwloader.clearPayPalCheckoutSettings();
        }
        fwloader.setPayPalCheckoutVisitorId(paypalcheckoutdetails.visitorId);
        fwloader.setPayPalCheckoutSessionId(paypalcheckoutdetails.sessionId);
        if (paypalcheckoutdetails.fundingSources == null) goto _L22; else goto _L23
_L23:
        afundingsource = paypalcheckoutdetails.fundingSources;
        j = afundingsource.length;
        i = 0;
_L27:
        if (i >= j) goto _L22; else goto _L24
_L24:
        fundingsource = afundingsource[i];
        if (TextUtils.isEmpty(fundingsource.id)) goto _L26; else goto _L25
_L25:
        fwloader.setPayPalCheckoutFundingSourceId(fundingsource.id);
_L22:
        afundingsource = null;
        fwloader = afundingsource;
        if (payPalCheckoutDetails != null)
        {
            fwloader = afundingsource;
            if (payPalCheckoutDetails.incentives != null)
            {
                fwloader = payPalCheckoutDetails.incentives;
            }
        }
        payPalCheckoutDetails = paypalcheckoutdetails;
        if (fwloader != null)
        {
            payPalCheckoutDetails.incentives = fwloader;
        }
        if (paypalcheckoutresponse.ackCode == 1)
        {
            onSuccess(operation);
            return;
        } else
        {
            onPartialFailure(operation, payPalCheckoutDetails);
            return;
        }
_L26:
        i++;
          goto _L27
_L15:
        fwloader = (com.ebay.common.net.api.cart.InitPaymentResult.InitPaymentResultResponse)((InitPaymentResultNetLoader)fwloader).getResponse();
        cart = fwloader.getResponseCart();
        if (((com.ebay.common.net.api.cart.InitPaymentResult.InitPaymentResultResponse) (fwloader)).ackCode == 1)
        {
            onSuccess(operation);
            return;
        } else
        {
            onPartialFailure(operation, cart);
            return;
        }
_L12:
        fwloader = (UpdateCartResponse)((SetPaymentMethodNetLoader)fwloader).getResponse();
        cart = fwloader.getResponseCart();
        if (((UpdateCartResponse) (fwloader)).ackCode == 1)
        {
            onSuccess(operation);
            return;
        } else
        {
            onPartialFailure(operation, cart);
            return;
        }
_L16:
        fwloader = (com.ebay.common.net.api.cart.Buy.BuyResponse)((BuyNetLoader)fwloader).getResponse();
        cart = fwloader.getResponseCart();
        if (cart.isProx())
        {
            paymentInstruction = cart.cartPaymentMethods.getSelectedPaymentMethod().getPaymentInstruction();
        } else
        {
            paymentInstruction = fwloader.getPaymentInstruction();
        }
        if (((com.ebay.common.net.api.cart.Buy.BuyResponse) (fwloader)).ackCode == 1)
        {
            onSuccess(operation);
            return;
        } else
        {
            onPartialFailure(operation, cart);
            return;
        }
_L14:
        fwloader = (com.ebay.common.net.api.cart.SetShippingAddress.SetShippingAddressResponse)((SetShippingAddressNetLoader)fwloader).getResponse();
        cart = retainAndResolveLineItemCartState(fwloader.getResponseCart());
        if (((com.ebay.common.net.api.cart.SetShippingAddress.SetShippingAddressResponse) (fwloader)).ackCode == 1)
        {
            onSuccess(operation);
            return;
        } else
        {
            onPartialFailure(operation, cart);
            return;
        }
_L13:
        fwloader = (FundingInstrumentServiceResponse)((FundingInstrumentServiceNetLoader)fwloader).getResponse();
        ResultStatus resultstatus = fwloader.getResultStatus();
        if (!resultstatus.hasError() && !resultstatus.hasWarning())
        {
            fwloader = fwloader.getResponseData();
            temporaryFundingInstrumentId = ((com.ebay.nautilus.domain.net.fis.FundingInstrumentServiceResponse.FundingResponseData) (fwloader)).instrumentId;
            creditCard = ((com.ebay.nautilus.domain.net.fis.FundingInstrumentServiceResponse.FundingResponseData) (fwloader)).creditCard;
            directDebit = ((com.ebay.nautilus.domain.net.fis.FundingInstrumentServiceResponse.FundingResponseData) (fwloader)).bankAccount;
            onSuccess(operation);
            return;
        } else
        {
            onPartialFailure(operation, new ResultStatusJsonModel(getEbayContext(), resultstatus));
            return;
        }
    }

    protected void onTaskStarted(int i, FwLoader fwloader)
    {
        if (isFinishing())
        {
            return;
        }
        fwloader = Operation.values()[i];
        switch (_cls2..SwitchMap.com.ebay.mobile.checkout.BaseCheckoutActivity.Operation[fwloader.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
        case 2: // '\002'
            updateProgressDialog(0x7f0700f5);
            return;

        case 3: // '\003'
        case 4: // '\004'
            enableProgressDialog(true, false);
            updateProgressDialog(0x7f0700dd);
            return;

        case 5: // '\005'
            enableProgressDialog(true, true);
            if (selectedPaymentMethod != null && selectedPaymentMethod.equals("PayPal"))
            {
                updateProgressDialog(0x7f0700f7);
                return;
            } else
            {
                updateProgressDialog(0x7f0700f6);
                return;
            }

        case 6: // '\006'
            enableProgressDialog(true, true);
            updateProgressDialog(0x7f070c16);
            return;

        case 7: // '\007'
        case 8: // '\b'
        case 9: // '\t'
        case 10: // '\n'
        case 11: // '\013'
        case 12: // '\f'
        case 13: // '\r'
        case 14: // '\016'
        case 15: // '\017'
        case 16: // '\020'
            enableProgressDialog(true, false);
            updateProgressDialog(0x7f070c7e);
            return;

        case 17: // '\021'
        case 18: // '\022'
            enableProgressDialog(true, false);
            updateProgressDialog(0x7f070bd7);
            return;

        case 19: // '\023'
        case 20: // '\024'
            enableProgressDialog(true, false);
            updateProgressDialog(0x7f070c7f);
            return;

        case 21: // '\025'
            enableProgressDialog(true, true);
            updateProgressDialog(0x7f070c40);
            return;

        case 22: // '\026'
            enableProgressDialog(true, false);
            updateProgressDialog(0x7f070c80);
            return;

        case 23: // '\027'
            enableProgressDialog(true, true);
            updateProgressDialog(0x7f0700f5);
            return;

        case 24: // '\030'
            enableProgressDialog(true, false);
            updateProgressDialog(0x7f0700f5);
            return;

        case 25: // '\031'
        case 26: // '\032'
            enableProgressDialog(true, false);
            break;
        }
        if (selectedPaymentMethod != null && selectedPaymentMethod.equals("PayPal"))
        {
            updateProgressDialog(0x7f0700f1);
            return;
        } else
        {
            updateProgressDialog(0x7f0700f2);
            return;
        }
    }

    public final void setCheckoutResult(int i, Intent intent)
    {
        Intent intent1 = intent;
        if (intent == null)
        {
            intent1 = new Intent();
        }
        saveCheckoutState(intent1);
        setResult(i, intent1);
    }

    public void setInventoryInfo(String s, InventoryInfo inventoryinfo)
    {
        if (s != null && inventoryinfo != null)
        {
            inventoryInfoMap.put(s, inventoryinfo);
        }
    }

    protected void setShippingAddresses(List list)
    {
        if (list == null)
        {
            list = new ArrayList();
        }
        shippingAddresses = list;
    }

    protected boolean shouldRememberPaymentInstrument()
    {
        if (cart != null && cart.isProx() && cart.cartPaymentMethods != null)
        {
            if (cart.cartPaymentMethods.getSelectedPaymentMethod() != null)
            {
                com.ebay.common.model.cart.CartPaymentMethods.PaymentMethod.PaymentInstrument paymentinstrument = cart.cartPaymentMethods.getSelectedPaymentMethod().getPaymentInstrument();
                if (paymentinstrument != null)
                {
                    return paymentinstrument.shouldRememeber();
                }
            }
            if ("PayPal".equals(selectedPaymentMethod) && cart.shouldRememberPayPalSwitch)
            {
                return true;
            }
            if ("CreditCard".equals(selectedPaymentMethod) && cart.shouldRememberCreditCardSwitch)
            {
                return true;
            }
            if ("DirectDebit".equals(selectedPaymentMethod) && cart.shouldRememberDirectDebitSwitch)
            {
                return true;
            }
        }
        return false;
    }

    protected boolean showProxRememberMeSwitchForPayPal()
    {
        DeviceConfiguration deviceconfiguration = DeviceConfiguration.getAsync();
        return deviceconfiguration.get(DcsNautilusBoolean.PROX) && !deviceconfiguration.get(DcsBoolean.payments_hideRememberMeControls);
    }

    public void startActivityForResult(Intent intent, int i)
    {
        if (i >= 0)
        {
            saveCheckoutState(intent);
        }
        super.startActivityForResult(intent, i);
    }

    protected void startProxFlowForPaymentType(String s, String s1)
    {
        int i = 1;
        Object obj = cart.cartPaymentMethods.getPaymentMethodsOfName(s);
        if (obj != null && ((List) (obj)).size() > 0)
        {
            obj = (com.ebay.common.model.cart.CartPaymentMethods.PaymentMethod)((List) (obj)).get(0);
            if ("PayPal".equals(s))
            {
                obj = ((com.ebay.common.model.cart.CartPaymentMethods.PaymentMethod) (obj)).getActionUrlForAction(s1);
                s = new Intent(this, com/ebay/mobile/checkout/prox/PayPalIdentityActivity);
                s.putExtra("android.intent.extra.TITLE", getString(0x7f070c52));
                s.putExtra("url", ((String) (obj)));
                s.putExtra("use_sso", true);
                s.putExtra("back", true);
                obj = ShowWebViewFragment.EXTRA_NUM_HISTORY_TO_SKIP;
                if ("SelectPaymentInstrument".equals(s1))
                {
                    i = 0;
                }
                s.putExtra(((String) (obj)), i);
                s.putExtra("add_device_id", false);
                s.putExtra("attachOnInflate", false);
                startActivityForResult(s, 0x7759b2);
            } else
            {
                if ("CreditCard".equals(s))
                {
                    s = new Intent(this, com/ebay/mobile/checkout/prox/CreditCardActivity);
                    if (s1 != null)
                    {
                        s.putExtra("fundingInstrumentId", s1);
                    }
                    s.putExtra("use_cancel_done_buttons", true);
                    startActivityForResult(s, 0x7759b3);
                    return;
                }
                if ("DirectDebit".equals(s))
                {
                    if ("PaymentAgreementMandate".equals(s1))
                    {
                        s = cart.cartPaymentMethods.getSelectedPaymentMethod().getPaymentAgreement();
                        s1 = new Intent(this, com/ebay/mobile/checkout/prox/SepaConfirmationActivity);
                        s1.putExtra("sepaText", s.getSepaText());
                        s1.putExtra("sepaButtonText", s.getSepaButtonText());
                        s1.putExtra("sepaButtonLink", s.getSepaMandateUrl());
                        startActivityForResult(s1, 0x7759b5);
                        return;
                    }
                    s = new Intent(this, com/ebay/mobile/checkout/prox/DirectDebitActivity);
                    if (s1 != null)
                    {
                        s.putExtra("fundingInstrumentId", s1);
                    }
                    s.putExtra("use_cancel_done_buttons", true);
                    startActivityForResult(s, 0x7759b4);
                    return;
                }
                if ("PayUponInvoice".equals(s))
                {
                    s = new Intent(this, com/ebay/mobile/checkout/prox/PayUponInvoiceActivity);
                    s.putExtra("use_cancel_done_buttons", true);
                    startActivityForResult(s, 0x7759b7);
                    return;
                }
                if ("CashOnPickup".equals(s) || "MoneyXferAcceptedInCheckout".equals(s))
                {
                    apiSetPaymentInstrument(s, null, null);
                    return;
                }
            }
        }
    }

    protected void updateProgressDialog(int i)
    {
        if (!isFinishing() && progressDialog != null && progressDialog.isShowing())
        {
            progressDialog.setMessage(getString(i));
        }
    }
}
