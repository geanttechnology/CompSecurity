// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import com.ebay.app.AlertDialogFragment;
import com.ebay.app.DialogFragmentCallback;
import com.ebay.common.CurrencyConversionCache;
import com.ebay.common.Preferences;
import com.ebay.common.UserCache;
import com.ebay.common.UserCacheChangeWatchNetLoader;
import com.ebay.common.analytics.MimsUtil;
import com.ebay.common.model.ItemTransaction;
import com.ebay.common.model.UserDetail;
import com.ebay.common.model.cart.Cart;
import com.ebay.common.model.cart.CartPaymentMethods;
import com.ebay.common.model.cart.JsonModel;
import com.ebay.common.model.cart.PayPalCheckoutDetails;
import com.ebay.common.model.cart.PaymentSession;
import com.ebay.common.model.currency.CurrencyConversionRate;
import com.ebay.common.model.inventory.InventoryInfo;
import com.ebay.common.model.inventory.StoreAvailability;
import com.ebay.common.model.local.Availability;
import com.ebay.common.net.api.cart.EbayCartApi;
import com.ebay.common.net.api.cart.UpdateLogisticsPlanParams;
import com.ebay.common.net.api.currency.CurrencyConversionDataManager;
import com.ebay.common.net.api.givingworks.NonProfitDataManager;
import com.ebay.common.net.api.local.EbayNowInventoryLookupDataManager;
import com.ebay.common.net.api.local.EbayNowMappedException;
import com.ebay.common.net.api.local.EbayNowValidateTimeSlotDataManager;
import com.ebay.common.util.EbayErrorUtil;
import com.ebay.common.util.ImageCache;
import com.ebay.common.view.util.DialogManager;
import com.ebay.mobile.CheckoutItem;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.MyEbayLandingActivity;
import com.ebay.mobile.activities.ShowWebViewFragment;
import com.ebay.mobile.analytics.AnalyticsUtil;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.checkout.delivery.DeliverySchedulingActivity;
import com.ebay.mobile.checkout.delivery.DeliverySchedulingParams;
import com.ebay.mobile.checkout.prox.PayPalIdentityActivity;
import com.ebay.mobile.checkout.prox.PaymentMethodActivity;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.mobile.common.EbayUtil;
import com.ebay.mobile.common.LocalUtil;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.mobile.dcs.DcsInteger;
import com.ebay.mobile.experimentation.Experiments;
import com.ebay.mobile.inventory.StorePickerActivity;
import com.ebay.mobile.search.SearchUtil;
import com.ebay.mobile.sitespeed.SiteSpeedActivityUtil;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.util.EbayPhoneNumberUtil;
import com.ebay.mobile.util.LocationUtil;
import com.ebay.mobile.util.PickupUtil;
import com.ebay.mobile.util.ThemeUtil;
import com.ebay.mobile.viewitem.ItemDataManager;
import com.ebay.mobile.viewitem.ItemViewBidTracking;
import com.ebay.mobile.viewitem.PpaUpgradeConfirmDialog;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbayCurrency;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.analytics.DeviceInfoUtil;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.DysonDataManager;
import com.ebay.nautilus.domain.data.Address;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.data.EnergyEfficiencyRating;
import com.ebay.nautilus.domain.data.ShoppingCart;
import com.ebay.nautilus.domain.data.SiteSpeedData;
import com.ebay.nautilus.domain.dcs.DcsNautilusBoolean;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.api.experimentation.Experiment;
import com.ebay.nautilus.domain.net.api.experimentation.Treatment;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import com.ebay.nautilus.shell.app.FwLoaderManager;
import com.google.android.gms.maps.model.LatLng;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

// Referenced classes of package com.ebay.mobile.checkout:
//            BaseCheckoutActivity, PayPalActivity, PaymentMethodActivity, AddressEditActivity, 
//            ChangeShippingMethodActivity, AddressListActivity, IncentivesActivity, DonationsActivity, 
//            MessageToSellerActivity, ChangeCartItemQuantityActivity, CheckoutError, PurchaseCompleteAlternativeActivity, 
//            PurchaseCompleteActivity

public class CheckoutActivity extends BaseCheckoutActivity
    implements android.view.View.OnClickListener, android.widget.CompoundButton.OnCheckedChangeListener, DialogFragmentCallback, com.ebay.common.net.api.currency.CurrencyConversionDataManager.Observer, com.ebay.common.net.api.givingworks.NonProfitDataManager.Observer, com.ebay.common.net.api.local.EbayNowInventoryLookupDataManager.Observer
{

    private static final int DIALOG_ELIVS_WARNING = 0;
    private static final int DIALOG_LEAVE_CHECKOUT = 1;
    private static final String ERROR_CART_VERSION_HAS_BEEN_UPGRADED = "601";
    private static final String ERROR_NATIVE_CART_PROBLEM_STATUS_FLAGS = "158";
    private static final String ERROR_NATIVE_PROVIDE_INFO = "205";
    public static final String EXTRA_CHECKOUT_ITEM = "item";
    private static final String EXTRA_CONVERSION_RATE = "conversion_rate";
    private static final String EXTRA_IS_INITIALIZATION_SEQ_COMPLETE = "is_initialziation_sequence_completne";
    private static final String EXTRA_MIMS_SCOPE_ID = "mimsScopeId";
    private static final String EXTRA_ORIGINAL_SHIPPING_METHOD_ID = "original_shipping_method_id";
    private static final String EXTRA_PAYMENT_METHOD_VISIBLE_LAYOUT = "visible_layout_id";
    private static final String EXTRA_PAYPAL_CHECKOUT_REFRESH_URL = "paypal_checkout_refresh_url";
    private static final String EXTRA_PAYPAL_SESSION_START_TIME = "paypal_session_start_time";
    public static final String EXTRA_REFINED_POSTAL_CODE = "refined_postal_code";
    public static final String EXTRA_REMEMBER_ME = "remember_me";
    private static final String EXTRA_SELECTED_DELIVERY_SCHEDULING_PARAMS = "selected_delivery_scheduling_params";
    public static final String EXTRA_SHOPPING_CART_ID = "shopping_cart_id";
    public static final String EXTRA_SHOPPING_CART_ITEMS = "shopping_cart_items";
    public static final String EXTRA_TRACKING_KEY_VALUES = "tracking_key_values";
    public static final String EXTRA_TRANSACTION = "transaction";
    public static final String EXTRA_VARIATION_ID = "variation_id";
    public static final String EXTRA_VARIATION_OPTIONS = "variation_options";
    static final int MAX_QUANTITY = 5;
    private static final int PAYPAL_LOGIN_SESSION_TIMEOUT = 0xdbba0;
    private static final int REQUEST_APPLY_DONATIONS = 1244;
    private static final int REQUEST_APPLY_INCENTIVES = 1236;
    private static final int REQUEST_CHANGE_EBAY_NOW_SCHEDULE = 1242;
    private static final int REQUEST_CHANGE_ITEM_NOTE = 1239;
    private static final int REQUEST_CHANGE_ITEM_QUANTITY = 1238;
    private static final int REQUEST_CHANGE_PICKUP_LOCATION = 1241;
    private static final int REQUEST_CHANGE_SHIPPING_METHOD = 1240;
    private static final int REQUEST_CHOOSE_PAYMENT_METHOD = 1237;
    private static final int REQUEST_CHOOSE_PAYMENT_METHOD_PROX = 1245;
    private static final int REQUEST_EDIT_SHIPPING_ADDRESS = 1243;
    private static final int REQUEST_PAYPAL = 1234;
    private static final int REQUEST_SHIPPING_ADDRESS = 1235;
    private static final int SHIPPING_TYPE_EBAY_NOW = 3;
    private static final int SHIPPING_TYPE_IN_STORE_PICKUP = 2;
    private static final int SHIPPING_TYPE_PICKUP_AND_DROPOFF = 4;
    private static final int SHIPPING_TYPE_SHIP_TO_HOME = 1;
    private static final int paymentMethodLayoutIds[] = {
        0x7f10091b, 0x7f10091c, 0x7f10091e, 0x7f100922
    };
    private boolean aborted;
    protected Long activeMimsScope;
    private View alertView;
    private boolean atLeastOneItemHasShipping;
    private String bidSource;
    private CurrencyConversionRate conversionRate;
    private DeliverySchedulingParams deliverySchedulingParams;
    protected final DialogManager dialogManager = (DialogManager)getShim(com/ebay/common/view/util/DialogManager);
    private EbayNowInventoryLookupDataManager ebnInventoryLookupDataManager;
    private final Runnable enableClick = new Runnable() {

        final CheckoutActivity this$0;

        public void run()
        {
            shouldHandleClick = true;
        }

            
            {
                this$0 = CheckoutActivity.this;
                super();
            }
    };
    private final Handler enableClickHandler = new Handler();
    private ImageCache imageCache;
    private String inReferrer;
    private LayoutInflater inflater;
    private boolean isInitializationSequenceComplete;
    private boolean isMoreXOItemsInCart;
    private ItemDataManager itemDataManager;
    private boolean measurePageLoadOnRestart;
    private NonProfitDataManager nonprofitDataManager;
    private String originalLogisticsPlanOptionId;
    private String payPalCheckoutRefreshUrl;
    private long payPalSessionStartTime;
    private SiteSpeedData paymentSpeed;
    private Button placeOrderButton;
    private boolean preventPayment;
    private View selectedMenuItem;
    private boolean shouldHandleClick;
    protected Treatment showProxTreatment;
    private boolean showWarningView;
    private boolean useMec2;
    private ArrayList variationOptions;
    private int visibleLayoutId;
    private View warningView;

    public CheckoutActivity()
    {
        activeMimsScope = null;
        shouldHandleClick = true;
        isMoreXOItemsInCart = false;
        paymentSpeed = SiteSpeedActivityUtil.SITE_SPEED_DATA_NO_OP;
        showProxTreatment = null;
    }

    private void addCommonTrackingTags(TrackingData trackingdata)
    {
        Object obj;
        Object obj2;
        trackingdata.addExperimentServedTags(showProxTreatment);
        if (isShoppingCartCheckout())
        {
            trackingdata.addKeyValuePair("ebc", Long.toString(shopCartId));
        }
        if (cart != null)
        {
            trackingdata.addKeyValuePair("cart_id", cart.cartId);
        }
        if (isProxEnabled())
        {
            trackingdata.addKeyValuePair("prox", "1");
        } else
        {
            if (useMec2)
            {
                obj = "mec2";
            } else
            {
                obj = "mec+";
            }
            trackingdata.addKeyValuePair("mecv", ((String) (obj)));
        }
        if (isRememberMeActive())
        {
            obj = "1";
        } else
        {
            obj = "0";
        }
        trackingdata.addKeyValuePair("rmbrme", ((String) (obj)));
        if (shouldRememberPaymentInstrument())
        {
            obj = "1";
        } else
        {
            obj = "0";
        }
        trackingdata.addKeyValuePair("spm", ((String) (obj)));
        if (cart != null && cart.lineItems != null)
        {
            boolean flag4 = false;
            boolean flag = false;
            boolean flag1 = false;
            ArrayList arraylist = new ArrayList();
            Object obj1 = new LinkedList();
            obj2 = new LinkedList();
            DeviceConfiguration deviceconfiguration = DeviceConfiguration.getAsync();
            boolean flag6 = deviceconfiguration.get(DcsBoolean.smeSupport);
            Iterator iterator = cart.lineItems.iterator();
label0:
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Object obj3 = (com.ebay.common.model.cart.Cart.LineItem)iterator.next();
                boolean flag2 = flag4;
                if (deviceconfiguration.get(DcsBoolean.MecDisplayTreatmentForBopis))
                {
                    flag2 = flag4;
                    if (((com.ebay.common.model.cart.Cart.LineItem) (obj3)).isInStorePickupAvailable())
                    {
                        flag2 = flag4;
                        if (!((com.ebay.common.model.cart.Cart.LineItem) (obj3)).isInStorePickupSelected())
                        {
                            flag2 = flag4;
                            if (getInventoryInfo(((com.ebay.common.model.cart.Cart.LineItem) (obj3)).cartLineItemId) != null)
                            {
                                flag2 = true;
                            }
                        }
                    }
                }
                arraylist.add(String.valueOf(((com.ebay.common.model.cart.Cart.LineItem) (obj3)).ebayItemId));
                boolean flag3 = flag1;
                if (showEbnForLineItem(((com.ebay.common.model.cart.Cart.LineItem) (obj3))))
                {
                    flag3 = flag1;
                    if (!((com.ebay.common.model.cart.Cart.LineItem) (obj3)).isEbayNowSelected())
                    {
                        flag3 = true;
                    }
                }
                boolean flag5 = flag;
                if (((com.ebay.common.model.cart.Cart.LineItem) (obj3)).isPickupAndDropoffAvailable())
                {
                    flag5 = flag;
                    if (deviceconfiguration.get(DcsNautilusBoolean.PUDO))
                    {
                        flag5 = true;
                    }
                }
                flag4 = flag2;
                flag1 = flag3;
                flag = flag5;
                if (!flag6)
                {
                    continue;
                }
                flag4 = flag2;
                flag1 = flag3;
                flag = flag5;
                if (((com.ebay.common.model.cart.Cart.LineItem) (obj3)).promotions == null)
                {
                    continue;
                }
                Iterator iterator1 = ((com.ebay.common.model.cart.Cart.LineItem) (obj3)).promotions.iterator();
                do
                {
                    flag4 = flag2;
                    flag1 = flag3;
                    flag = flag5;
                    if (!iterator1.hasNext())
                    {
                        continue label0;
                    }
                    obj = (com.ebay.common.model.cart.Cart.Promotion)iterator1.next();
                } while (!com.ebay.nautilus.domain.net.api.ecas.models.EcasShoppingCart.PromotionType.SELLER_DISCOUNTED_PROMOTIONAL_OFFER.token.equals(((com.ebay.common.model.cart.Cart.Promotion) (obj)).type));
                obj3 = new com.ebay.mobile.analytics.Tracking.Formatters.SellerOfferItem(((com.ebay.common.model.cart.Cart.LineItem) (obj3)).ebayItemId.longValue(), ((com.ebay.common.model.cart.Cart.Promotion) (obj)).code, (String)((com.ebay.common.model.cart.Cart.Promotion) (obj)).attributeMap.get("OfferType"));
                if (((com.ebay.common.model.cart.Cart.Promotion) (obj)).isApplied)
                {
                    obj = obj2;
                } else
                {
                    obj = obj1;
                }
                ((List) (obj)).add(obj3);
                flag4 = flag2;
                flag1 = flag3;
                flag = flag5;
            } while (true);
            if (flag6)
            {
                trackingdata.addKeyValuePair("umo", com.ebay.mobile.analytics.Tracking.Formatters.SellerOfferItem.format(((List) (obj1))));
                trackingdata.addKeyValuePair("mo", com.ebay.mobile.analytics.Tracking.Formatters.SellerOfferItem.format(((List) (obj2))));
            }
            if (cart.hasEbayNowItem())
            {
                trackingdata.addKeyValuePair("chkphchg", "1");
            }
            if (doesEbnShippingAndRefinementMismatchExist())
            {
                trackingdata.addKeyValuePair("chkaddrchg", "1");
            }
            if (flag4)
            {
                trackingdata.addKeyValuePair("recoisp", "1");
            }
            if (flag)
            {
                trackingdata.addKeyValuePair("pudo", "1");
            }
            if (flag1)
            {
                trackingdata.addKeyValuePair("recoebn", "1");
            } else
            {
                trackingdata.addKeyValuePair("recoebn", "0");
            }
            trackingdata.addKeyValuePair("cart_itm", AnalyticsUtil.getCommaSeparatedStringFromCollection(arraylist));
            trackingdata.addKeyValuePair("itm", AnalyticsUtil.getCommaSeparatedStringFromCollection(arraylist));
        } else
        if (item != null)
        {
            trackingdata.addKeyValuePair("cart_itm", String.valueOf(item.id));
            trackingdata.addKeyValuePair("itm", String.valueOf(item.id));
        }
        if ("shopping_cart".equals(bidSource))
        {
            obj = "sc";
        } else
        if (item != null && item.autoPay)
        {
            obj = "ip";
        } else
        {
            obj = "rc";
        }
        trackingdata.addKeyValuePair("ckfl", ((String) (obj)));
        if (cart != null && cart.total != null)
        {
            trackingdata.addKeyValuePair("chtp", String.valueOf(cart.total.getValueAsDouble()));
            trackingdata.addKeyValuePair("chtpc", cart.total.getCurrencyCode());
        }
        if (DeviceInfoUtil.isPortrait(this))
        {
            obj = "p";
        } else
        {
            obj = "l";
        }
        trackingdata.addKeyValuePair("ort", ((String) (obj)));
        obj = null;
        if (selectedPaymentMethod == null) goto _L2; else goto _L1
_L1:
        if ("PayPal".equals(selectedPaymentMethod))
        {
            obj = "PayPal";
        } else
        if ("MoneyXferAcceptedInCheckout".equals(selectedPaymentMethod))
        {
            obj = "EFT";
        } else
        if ("CashOnPickup".equals(selectedPaymentMethod))
        {
            obj = "POP";
        } else
        if ("CreditCard".equals(selectedPaymentMethod))
        {
            obj = "CC";
        } else
        if ("DirectDebit".equals(selectedPaymentMethod))
        {
            obj = "debit";
        } else
        if ("PayUponInvoice".equals(selectedPaymentMethod))
        {
            obj = "PUI";
        }
_L12:
        obj1 = obj;
        if (!cart.isProx()) goto _L4; else goto _L3
_L3:
        obj2 = cart.cartPaymentMethods.getSelectedPaymentMethod();
        obj1 = obj;
        if (obj2 == null) goto _L4; else goto _L5
_L5:
        if (!((com.ebay.common.model.cart.CartPaymentMethods.PaymentMethod) (obj2)).isPayPal()) goto _L7; else goto _L6
_L6:
        if (!((com.ebay.common.model.cart.CartPaymentMethods.PaymentMethod) (obj2)).getFixedFundingComponents().isEmpty())
        {
            obj = "PayPal";
        } else
        {
            com.ebay.common.model.cart.CartPaymentMethods.PaymentMethod.PaymentInstrument.FundingStrategy.StrategyChoice.FundingSource fundingsource = ((com.ebay.common.model.cart.CartPaymentMethods.PaymentMethod) (obj2)).getSelectedFundingSource();
            if (fundingsource != null)
            {
                String s = fundingsource.getType();
                if (s.equals("BALANCE"))
                {
                    obj = "PayPal";
                } else
                if (s.equals("PAYMENT_CARD"))
                {
                    obj = fundingsource.getSubtype();
                    if ("AMEX".equals(obj))
                    {
                        obj = "pp-amex";
                    } else
                    if ("VISA".equals(obj))
                    {
                        obj = "pp-visa";
                    } else
                    if ("MASTERCARD".equals(obj))
                    {
                        obj = "pp-mc";
                    } else
                    if ("DINERS".equals(obj))
                    {
                        obj = "pp-diners";
                    } else
                    if ("DISCOVER".equals(obj))
                    {
                        obj = "pp-disc";
                    } else
                    {
                        obj = "pp-cc";
                    }
                } else
                if (s.equals("BANK_ACCOUNT"))
                {
                    if ("MANUAL_BANK_TRANSFER".equals(fundingsource.getMode()))
                    {
                        obj = "pp-meft";
                    } else
                    {
                        obj = "pp-debit";
                    }
                }
            } else
            {
                obj = "PayPal";
            }
        }
_L9:
        obj1 = obj;
        if (((com.ebay.common.model.cart.CartPaymentMethods.PaymentMethod) (obj2)).isDirectDebit())
        {
            obj1 = "debit";
        }
_L4:
        if (obj1 != null)
        {
            trackingdata.addKeyValuePair("paywith", ((String) (obj1)));
        }
_L2:
        return;
_L7:
        if (!((com.ebay.common.model.cart.CartPaymentMethods.PaymentMethod) (obj2)).isCreditCard()) goto _L9; else goto _L8
_L8:
        obj = ((com.ebay.common.model.cart.CartPaymentMethods.PaymentMethod) (obj2)).getPaymentInstrument();
        static class _cls6
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
                catch (NoSuchFieldError nosuchfielderror30) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$CreditCard$Type[com.ebay.nautilus.domain.data.CreditCard.Type.DISCOVER.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror29) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$CreditCard$Type[com.ebay.nautilus.domain.data.CreditCard.Type.AMERICANEXPRESS.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror28) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$CreditCard$Type[com.ebay.nautilus.domain.data.CreditCard.Type.MASTERCARD.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror27) { }
                $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation = new int[BaseCheckoutActivity.Operation.values().length];
                try
                {
                    $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[BaseCheckoutActivity.Operation.GET_USER_INCENTIVES_VOUCHERS.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror26) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[BaseCheckoutActivity.Operation.GET_USER_INCENTIVES_COUPONS.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror25) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[BaseCheckoutActivity.Operation.GET_INCENTIVES_COUPONS.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror24) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[BaseCheckoutActivity.Operation.GET_INCENTIVES_REWARDS.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror23) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[BaseCheckoutActivity.Operation.GET_ADDRESSES.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror22) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[BaseCheckoutActivity.Operation.SET_SHIPPING_ADDRESS.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror21) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[BaseCheckoutActivity.Operation.APPLY_INCENTIVES.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror20) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[BaseCheckoutActivity.Operation.REFRESH_CART.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror19) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[BaseCheckoutActivity.Operation.GET_CART.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror18) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[BaseCheckoutActivity.Operation.CREATE_CART.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror17) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[BaseCheckoutActivity.Operation.PAYPAL_CHECKOUT_FOR_REFRESH.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror16) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[BaseCheckoutActivity.Operation.PAYPAL_CHECKOUT.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror15) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[BaseCheckoutActivity.Operation.INIT_PAYMENT_FOR_PREPARE.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[BaseCheckoutActivity.Operation.INIT_PAYMENT_FOR_REFRESH.ordinal()] = 14;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[BaseCheckoutActivity.Operation.INIT_PAYMENT_RESULT.ordinal()] = 15;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[BaseCheckoutActivity.Operation.BUY.ordinal()] = 16;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[BaseCheckoutActivity.Operation.DYSON_PAIRED.ordinal()] = 17;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[BaseCheckoutActivity.Operation.CREATE_CHECKOUT_SESSION.ordinal()] = 18;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[BaseCheckoutActivity.Operation.SET_DEFAULT_SHIPPING_ADDRESS.ordinal()] = 19;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[BaseCheckoutActivity.Operation.REFRESH_ADDRESSES.ordinal()] = 20;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[BaseCheckoutActivity.Operation.UPDATE_SHIPPING_METHOD.ordinal()] = 21;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[BaseCheckoutActivity.Operation.UPDATE_PICKUP_METHOD.ordinal()] = 22;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[BaseCheckoutActivity.Operation.UPDATE_DELIVERY_RESERVATION.ordinal()] = 23;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[BaseCheckoutActivity.Operation.UPDATE_ITEM_QUANTITY.ordinal()] = 24;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[BaseCheckoutActivity.Operation.UPDATE_SELLER_NOTE.ordinal()] = 25;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[BaseCheckoutActivity.Operation.SET_PAYMENT_INSTRUMENT.ordinal()] = 26;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[BaseCheckoutActivity.Operation.REQUEST_TOKEN_FOR_SERVICE.ordinal()] = 27;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        if (obj != null)
        {
            switch (_cls6..SwitchMap.com.ebay.nautilus.domain.data.CreditCard.Type[((com.ebay.common.model.cart.CartPaymentMethods.PaymentMethod.PaymentInstrument) (obj)).getCreditCardType().ordinal()])
            {
            default:
                obj = "CC";
                break;

            case 1: // '\001'
                obj = "visa";
                break;

            case 2: // '\002'
                obj = "disc";
                break;

            case 3: // '\003'
                obj = "amex";
                break;

            case 4: // '\004'
                obj = "mc";
                break;
            }
        } else
        {
            obj = "CC";
        }
        if (true) goto _L9; else goto _L10
_L10:
        if (true) goto _L12; else goto _L11
_L11:
    }

    private void addMec2QueryArgumentsToUri(android.net.Uri.Builder builder)
    {
        builder.appendQueryParameter("op", "getjson");
        if (!DeviceConfiguration.getAsync().get(DcsBoolean.MecRememberMeCheckboxSetting))
        {
            builder.appendQueryParameter("RMDefault", "false");
        }
        if (useGuestXo)
        {
            builder.appendQueryParameter("guest_xo", "");
        }
    }

    private String addRepurchaseQueryParameterIfNecessary(String s)
    {
        if (s.contains("repurchase="))
        {
            return s;
        } else
        {
            return (new StringBuilder()).append(s).append("&repurchase=true").toString();
        }
    }

    private void addSelectedFundingSourceToGroup(ViewGroup viewgroup, com.ebay.common.model.cart.CartPaymentMethods.PaymentMethod.PaymentInstrument.FundingStrategy.StrategyChoice.FundingSource fundingsource)
    {
        CurrencyAmount currencyamount = fundingsource.getAmount();
        String s = getDisplayStringForPayPalFundingSource(fundingsource);
        if (s != null && !"INCENTIVE".equals(fundingsource.getType()))
        {
            TextView textview2 = (TextView)inflater.inflate(0x7f0302aa, viewgroup, false);
            textview2.setText(formatFundingSourceDetailText(s, EbayCurrencyUtil.formatDisplay(currencyamount, 2), true));
            viewgroup.addView(textview2);
        }
        if (fundingsource.conversionInfo != null)
        {
            TextView textview = (TextView)inflater.inflate(0x7f0302aa, viewgroup, false);
            textview.setText(formatCurrencyConversionText(fundingsource.conversionInfo.basis, fundingsource.conversionInfo.converted));
            viewgroup.addView(textview);
        }
        if (fundingsource.hasBackupSource())
        {
            TextView textview1 = (TextView)inflater.inflate(0x7f0302aa, viewgroup, false);
            textview1.setText(formatFundingSourceDetailText(getDisplayStringForPayPalFundingSource(fundingsource.getBackupSource()), getString(0x7f0707c9), false));
            viewgroup.addView(textview1);
        }
    }

    private static void appendLayout(int i, LayoutInflater layoutinflater, ViewGroup viewgroup, String s, String s1, Integer integer)
    {
        layoutinflater = (ViewGroup)layoutinflater.inflate(i, viewgroup, false);
        TextView textview = (TextView)layoutinflater.findViewById(0x7f1000ec);
        if (s != null)
        {
            textview.setText(s);
            textview.setVisibility(0);
        } else
        {
            textview.setVisibility(8);
        }
        s = (TextView)layoutinflater.findViewById(0x7f1000ed);
        if (s1 != null)
        {
            s.setText(s1);
            if (integer != null)
            {
                s.setTextColor(integer.intValue());
            }
            s.setVisibility(0);
        } else
        {
            s.setVisibility(8);
        }
        viewgroup.addView(layoutinflater);
    }

    private static void appendLayout(LayoutInflater layoutinflater, ViewGroup viewgroup, String s, String s1, Integer integer)
    {
        appendLayout(0x7f0302ab, layoutinflater, viewgroup, s, s1, integer);
    }

    private boolean blockCharityOnCrossBorderTrade()
    {
        if (cart != null && cart.total != null)
        {
            EbaySite ebaysite = MyApp.getPrefs().getCurrentSite();
            String s = ebaysite.getCurrency().getCurrencyCode();
            String s1 = cart.total.getCurrencyCode();
            if (s1.equals(s) || !EbaySite.CA.equals(ebaysite) && (!EbaySite.CAFR.equals(ebaysite) || !s1.equals("USD")))
            {
                return false;
            }
        }
        return true;
    }

    private void checkForPayPalSessionTimeout()
    {
        while (!paymentMethodCompleted || payPalSessionStartTime <= 0L || System.currentTimeMillis() - payPalSessionStartTime <= 0xdbba0L) 
        {
            return;
        }
        MyApp.getPrefs().clearPayPalCheckoutSettings();
        setDefaultPaymentMethod();
        startCheckout();
    }

    private DeliverySchedulingParams createDeliverySchedulingParams(com.ebay.common.model.cart.Cart.LineItem lineitem)
    {
        com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan logisticsplan = lineitem.getLogisticsPlanOfType(com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type.EBAY_NOW);
        Object obj = logisticsplan.getSelectedPlanOption();
        java.util.Date date = null;
        java.util.Date date1 = null;
        if (obj != null)
        {
            date = ((com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.PlanStep.PlanOption) (obj)).deliveryEstimate.deliveryDateMin;
            date1 = ((com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.PlanStep.PlanOption) (obj)).deliveryEstimate.deliveryDateMax;
        }
        obj = cart.getSellerUserIdFromLineItem(lineitem.cartLineItemId);
        return new DeliverySchedulingParams(getShippingAddressSetInCart(cart.getBuyerShippingAddress()).addressFields.phone, ((String) (obj)), ((String) (obj)), logisticsplan.getEbnStoreId(), logisticsplan.getEbnZoneId(), lineitem.getSelectedLogisticsPlan().getDeliveryInstructions(), date, date1);
    }

    private void createInventoryInfoForLineItem(com.ebay.common.model.cart.Cart.LineItem lineitem)
    {
        String s1 = lineitem.getListingSiteId();
        com.ebay.common.net.api.inventory.LookupAvailabilityRequest.PhysicalLocation physicallocation = LocationUtil.getAvailableLocation(this, refinedPostalCode, s1);
        String s = null;
        Object obj = s;
        if (physicallocation != null)
        {
            obj = s;
            if (physicallocation.getLatitude() != null)
            {
                obj = s;
                if (physicallocation.getLongitude() != null)
                {
                    obj = new LatLng(physicallocation.getLatitude().doubleValue(), physicallocation.getLongitude().doubleValue());
                }
            }
        }
        Object obj1 = DeviceConfiguration.getAsync();
        int i;
        if (physicallocation != null)
        {
            s = physicallocation.getPostalCode();
        } else
        {
            s = null;
        }
        i = ((DeviceConfiguration) (obj1)).get(DcsInteger.BopisGeocoderBiasBoxSize);
        if (obj != null)
        {
            obj1 = com.ebay.common.model.inventory.InventoryInfo.ListDerivation.LATLNG;
        } else
        {
            obj1 = com.ebay.common.model.inventory.InventoryInfo.ListDerivation.POSTAL_CODE;
        }
        obj = new InventoryInfo(s, ((LatLng) (obj)), i, null, ((com.ebay.common.model.inventory.InventoryInfo.ListDerivation) (obj1)), cart.getSellerUserIdFromLineItem(lineitem.cartLineItemId), (String)lineitem.attrs.get("SellerProductId"), null, null, s1);
        ((InventoryInfo) (obj)).setCheckoutLineItemId(lineitem.cartLineItemId);
        if (refinedPostalCode != null)
        {
            ((InventoryInfo) (obj)).setSearchRefinedPostalCode(refinedPostalCode);
        }
        setInventoryInfo(lineitem.cartLineItemId, ((InventoryInfo) (obj)));
    }

    private ViewGroup createSellerShippingLayout(ViewGroup viewgroup, com.ebay.common.model.cart.Cart.LineItem lineitem, int i)
    {
        View view = inflater.inflate(0x7f0302b4, viewgroup, false);
        ViewGroup viewgroup1 = (ViewGroup)view.findViewById(0x7f100957);
        viewgroup1.setTag(lineitem.cartLineItemId);
        viewgroup1.setTag(0x7f100015, Integer.valueOf(i));
        viewgroup.addView(view);
        return viewgroup1;
    }

    private void customizeUi()
    {
        String s;
        TextView textview;
        String s1;
        String s2;
        String s3;
        int i;
label0:
        {
            i = 0x7f0700af;
            Object obj;
            int j;
            if (MyApp.getPrefs().getCurrentSite().equals(EbaySite.DE) && !cart.hasTransactedItem())
            {
                setTitle(0x7f0700de);
                i = 0x7f0700f0;
            } else
            if (MyApp.getPrefs().getCurrentSite().isEuSite())
            {
                placeOrderButton.setText(0x7f07006d);
            } else
            {
                setTitle(0x7f0700ac);
                i = 0x7f0700af;
            }
            j = i;
            if (selectedPaymentMethod == null)
            {
                break label0;
            }
            if (!"CashOnPickup".equals(selectedPaymentMethod))
            {
                j = i;
                if (!"MoneyXferAcceptedInCheckout".equals(selectedPaymentMethod))
                {
                    break label0;
                }
            }
            j = 0x7f0700b0;
        }
        obj = MyApp.getPrefs().getCurrentCountry();
        s = getString(j);
        textview = (TextView)findViewById(0x7f100918);
        if (!"CreditCard".equals(selectedPaymentMethod) && !"DirectDebit".equals(selectedPaymentMethod) && !"PayUponInvoice".equals(selectedPaymentMethod)) goto _L2; else goto _L1
_L1:
        s1 = com.ebay.common.view.util.EbayCountryManager.Default.proxGuestXoCreditCheckUrl(((EbayCountry) (obj)));
        s2 = com.ebay.common.view.util.EbayCountryManager.Default.proxGuestXoPrivacyNoticesUrl(((EbayCountry) (obj)));
        if (s2 == null) goto _L4; else goto _L3
_L3:
        s3 = selectedPaymentMethod;
        i = -1;
        s3.hashCode();
        JVM INSTR lookupswitch 3: default 216
    //                   -1401373077: 484
    //                   1555043: 467
    //                   1428640201: 450;
           goto _L5 _L6 _L7 _L8
_L5:
        i;
        JVM INSTR tableswitch 0 2: default 244
    //                   0 501
    //                   1 565
    //                   2 565;
           goto _L9 _L10 _L11 _L11
_L9:
        textview.setVisibility(8);
_L12:
        textview = (TextView)findViewById(0x7f100930);
        if (cart != null && cart.isProx() && ("CreditCard".equals(selectedPaymentMethod) || "DirectDebit".equals(selectedPaymentMethod) || "PayPal".equals(selectedPaymentMethod)))
        {
            obj = com.ebay.common.view.util.EbayCountryManager.Default.savePaymentMethodInfoUrl(((EbayCountry) (obj)));
            if (obj != null)
            {
                if ("PayPal".equals(selectedPaymentMethod))
                {
                    i = 0x7f07009e;
                } else
                {
                    i = 0x7f07009f;
                }
                textview.setText(EbayUtil.removeUnderlinesFromHtmlLinks(getString(i, new Object[] {
                    obj
                })));
                textview.setMovementMethod(LinkMovementMethod.getInstance());
                if ("PayPal".equals(selectedPaymentMethod))
                {
                    if (showProxRememberMeSwitchForPayPal())
                    {
                        i = 0;
                    } else
                    {
                        i = 8;
                    }
                    textview.setVisibility(i);
                } else
                {
                    textview.setVisibility(0);
                }
            } else
            {
                textview.setVisibility(8);
            }
        } else
        {
            textview.setVisibility(8);
        }
        placeOrderButton.setText(s);
        return;
_L8:
        if (s3.equals("CreditCard"))
        {
            i = 0;
        }
          goto _L5
_L7:
        if (s3.equals("DirectDebit"))
        {
            i = 1;
        }
          goto _L5
_L6:
        if (s3.equals("PayUponInvoice"))
        {
            i = 2;
        }
          goto _L5
_L10:
        if (cart.hasTransactedItem())
        {
            i = 0x7f070099;
        } else
        {
            i = 0x7f07009a;
        }
        textview.setText(EbayUtil.removeUnderlinesFromHtmlLinks(getString(i, new Object[] {
            s, s2
        })));
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        textview.setVisibility(0);
          goto _L12
_L11:
        if (s1 != null)
        {
            if (cart.hasTransactedItem())
            {
                i = 0x7f07009b;
            } else
            {
                i = 0x7f07009c;
            }
            textview.setText(EbayUtil.removeUnderlinesFromHtmlLinks(getString(i, new Object[] {
                s, s2, s1
            })));
            textview.setMovementMethod(LinkMovementMethod.getInstance());
            textview.setVisibility(0);
        }
          goto _L12
_L4:
        textview.setVisibility(8);
          goto _L12
_L2:
        if ("PayPal".equals(selectedPaymentMethod) && !cart.hasTransactedItem())
        {
            textview.setText(EbayUtil.removeUnderlinesFromHtmlLinks(getString(0x7f07009d, new Object[] {
                s
            })));
            textview.setMovementMethod(LinkMovementMethod.getInstance());
            textview.setVisibility(0);
        } else
        {
            textview.setVisibility(8);
        }
          goto _L12
    }

    private boolean doesEbnShippingAndRefinementMismatchExist()
    {
        Address address = getDefaultShippingAddress();
        return DeviceConfiguration.getAsync().get(DcsBoolean.eBayNow) && !TextUtils.isEmpty(refinedPostalCode) && !TextUtils.isEmpty(address.addressFields.postalCode) && address.addressFields.postalCode.startsWith(refinedPostalCode);
    }

    private void endItem(ViewGroup viewgroup, boolean flag)
    {
        if (!flag)
        {
            viewgroup.addView(inflater.inflate(0x7f0302b0, viewgroup, false));
            return;
        } else
        {
            viewgroup.addView(inflater.inflate(0x7f0302af, viewgroup, false));
            return;
        }
    }

    private String formatConversionRateDisplay(com.ebay.common.model.cart.PayPalCheckoutDetails.CurrencyConversion currencyconversion)
    {
        if (currencyconversion != null)
        {
            return (new StringBuilder()).append(EbayCurrencyUtil.formatDisplay(currencyconversion.currencyCodeFrom, 1.0D, 2)).append(" = ").append(EbayCurrencyUtil.formatDisplay(currencyconversion.currencyCodeTo, currencyconversion.exchangeRate.doubleValue(), 2)).toString();
        } else
        {
            return "";
        }
    }

    private CharSequence formatCurrencyConversionText(CurrencyAmount currencyamount, CurrencyAmount currencyamount1)
    {
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
        if (currencyamount != null)
        {
            spannablestringbuilder.append(EbayCurrencyUtil.formatDisplay(currencyamount, 0));
        }
        if (currencyamount != null || currencyamount1 != null)
        {
            spannablestringbuilder.append("=");
        }
        if (currencyamount1 != null)
        {
            spannablestringbuilder.append(EbayCurrencyUtil.formatDisplay(currencyamount1, 2));
        }
        spannablestringbuilder.setSpan(new ForegroundColorSpan(getResources().getColor(0x7f0d0110)), 0, spannablestringbuilder.length(), 33);
        return spannablestringbuilder;
    }

    private Set getAvailabilityIdentifiers()
    {
        Object obj = getDefaultShippingAddress();
        String s;
        if (!TextUtils.isEmpty(refinedPostalCode))
        {
            if (obj != null)
            {
                s = ((Address) (obj)).addressFields.country;
            } else
            {
                s = UserCache.getUserDetails().registrationAddress.country;
            }
            obj = refinedPostalCode;
        } else
        if (obj != null)
        {
            s = ((Address) (obj)).addressFields.country;
            obj = ((Address) (obj)).addressFields.postalCode;
        } else
        {
            obj = UserCache.getUserDetails();
            s = ((UserDetail) (obj)).registrationAddress.country;
            obj = ((UserDetail) (obj)).registrationAddress.postalCode;
        }
        return cart.getAvailabilityIdentifiers(s, ((String) (obj)));
    }

    private List getBestLogisticsPlans()
    {
        ArrayList arraylist = null;
        Iterator iterator = cart.lineItems.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (com.ebay.common.model.cart.Cart.LineItem)iterator.next();
            com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan logisticsplan = ((com.ebay.common.model.cart.Cart.LineItem) (obj)).getSelectedLogisticsPlan();
            if (logisticsplan != null && !isSupportedLogisticsPlan(logisticsplan))
            {
                UpdateLogisticsPlanParams updatelogisticsplanparams = getCheapestShipToHome(((com.ebay.common.model.cart.Cart.LineItem) (obj)));
                obj = arraylist;
                if (arraylist == null)
                {
                    obj = new ArrayList();
                }
                ((ArrayList) (obj)).add(updatelogisticsplanparams);
                arraylist = ((ArrayList) (obj));
            }
        } while (true);
        return arraylist;
    }

    private UpdateLogisticsPlanParams getCheapestShipToHome(com.ebay.common.model.cart.Cart.LineItem lineitem)
    {
        com.ebay.common.model.cart.Cart.LineItem lineitem2;
        Object obj;
label0:
        {
            obj = null;
            Object obj1 = null;
            lineitem2 = null;
            com.ebay.common.model.cart.Cart.LineItem lineitem1 = null;
            com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan logisticsplan = lineitem.getLogisticsPlanOfType(com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type.SHIP_TO_HOME);
            if (logisticsplan == null)
            {
                break label0;
            }
            Iterator iterator1 = logisticsplan.planSteps.iterator();
            lineitem = obj1;
            do
            {
                lineitem2 = lineitem1;
                obj = lineitem;
                if (!iterator1.hasNext())
                {
                    break label0;
                }
                Iterator iterator = ((com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.PlanStep)iterator1.next()).planOptionsList.iterator();
                obj = lineitem;
                lineitem2 = lineitem1;
                do
                {
                    lineitem1 = lineitem2;
                    lineitem = ((com.ebay.common.model.cart.Cart.LineItem) (obj));
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    lineitem = (com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.PlanStep.PlanOption)iterator.next();
                    if (lineitem2 == null || lineitem.getLogisticsCost().compareTo(lineitem2.getLogisticsCost()) < 0)
                    {
                        obj = logisticsplan;
                        lineitem2 = lineitem;
                    }
                } while (true);
            } while (true);
        }
        if (obj != null)
        {
            return new UpdateLogisticsPlanParams(((com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan) (obj)).type.longName, ((com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.PlanStep.PlanOption) (lineitem2)).logisticsOptionIdentifier);
        } else
        {
            return null;
        }
    }

    private Address getShippingAddressSetInCart(Address address)
    {
        if (address == null || address.getAddressId() == null)
        {
            return null;
        }
        Object obj = getShippingAddresses();
        if (obj == null)
        {
            return null;
        }
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
        {
            Address address1 = (Address)((Iterator) (obj)).next();
            if (address.getAddressId().equals(address1.getAddressId()))
            {
                return address1;
            }
        }

        return null;
    }

    private void handleCartResponse()
    {
        Iterator iterator = cart.lineItems.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            com.ebay.common.model.cart.Cart.LineItem lineitem = (com.ebay.common.model.cart.Cart.LineItem)iterator.next();
            if (lineitem.isInStorePickupAvailable() || lineitem.isPickupAndDropoffAvailable())
            {
                createInventoryInfoForLineItem(lineitem);
            }
        } while (true);
        if (!setDefaultPaymentMethod())
        {
            cart = null;
            aborted = true;
            dialogManager.showDynamicAlertDialog(null, getString(0x7f070c18), aborted);
        } else
        {
            if (doesEbnShippingAndRefinementMismatchExist())
            {
                Set set = getAvailabilityIdentifiers();
                if (set != null && set.size() > 0)
                {
                    ebnInventoryLookupDataManager.getAvailability(set);
                }
            }
            customizeUi();
            (new TrackingData("ReviewOrder", TrackingType.EVENT)).send(this);
            sendCheckoutPageImpression(getIntent());
            apiGetUserIncentives(DeviceConfiguration.getAsync().get(DcsBoolean.IncentivesVouchers));
            if (isConversionRequired() && cart.total != null)
            {
                String s = MyApp.getPrefs().getCurrentCountry().getCurrency().getCurrencyCode();
                String s1 = cart.total.getCurrencyCode();
                com.ebay.nautilus.kernel.content.EbayContext ebaycontext = getEbayContext();
                if (CurrencyConversionCache.getConversionRate(ebaycontext, s1, s) == null && CurrencyConversionCache.willFetch(ebaycontext, s1, s))
                {
                    CurrencyConversionCache.loadConversionRate(ebaycontext, this, s1, s, null);
                    return;
                }
            }
        }
    }

    private void hideShippingAddressViewElements(boolean flag)
    {
        View view;
        byte byte0;
        if (flag)
        {
            byte0 = 8;
        } else
        {
            byte0 = 0;
        }
        view = findViewById(0x7f100931);
        if (view != null)
        {
            view.setVisibility(byte0);
            return;
        } else
        {
            findViewById(0x7f100932).setVisibility(byte0);
            findViewById(0x7f100934).setVisibility(byte0);
            findViewById(0x7f10093a).setVisibility(byte0);
            return;
        }
    }

    private void initializePayPalCheckout(String s)
    {
        if (!useMec2)
        {
            updateUi(true);
        } else
        if (paymentSession != null && !TextUtils.isEmpty(paymentSession.returnUrl))
        {
            String s1 = NautilusKernel.getAppVersionName(this);
            android.net.Uri.Builder builder = Uri.parse(s).buildUpon();
            builder.appendQueryParameter("flow_type", "skipall");
            if (!s.contains("&op="))
            {
                addMec2QueryArgumentsToUri(builder);
            }
            apiPayPalCheckout(builder.build().toString(), s1, false);
            return;
        }
    }

    private boolean isConversionRequired()
    {
        return MyApp.getDeviceConfiguration().getConfig().get(DcsBoolean.ShoppingCartInvertCurrencyConversionDisplay) && !isDomesticCurrency();
    }

    private boolean isDomesticCurrency()
    {
        if (cart == null || cart.total == null)
        {
            return false;
        } else
        {
            return MyApp.getPrefs().getCurrentCountry().getCurrency().getCurrencyCode().equals(cart.total.getCurrencyCode());
        }
    }

    private boolean isEbnAvailableIfRefinementPostalCodeIsShipTo()
    {
label0:
        {
            Address address = getDefaultShippingAddress();
            if (!doesEbnShippingAndRefinementMismatchExist())
            {
                break label0;
            }
            Iterator iterator = cart.lineItems.iterator();
            Object obj;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                obj = (com.ebay.common.model.cart.Cart.LineItem)iterator.next();
                obj = ebnInventoryLookupDataManager.checkAvailability(((com.ebay.common.model.cart.Cart.LineItem) (obj)).getAvailabilityIdentifier(address.addressFields.country, refinedPostalCode, cart.getSellerUserIdFromLineItem(((com.ebay.common.model.cart.Cart.LineItem) (obj)).cartLineItemId)));
            } while (obj == null || !((Availability) (obj)).isAvailable());
            return true;
        }
        return false;
    }

    private boolean isLineItemShippable(com.ebay.common.model.cart.Cart.LineItem lineitem)
    {
        if ("CashOnPickup".equals(selectedPaymentMethod) || lineitem.isLocalPickupSelected())
        {
            return true;
        } else
        {
            return lineitem.isShippable(getShippingAddressSetInCart(cart.getBuyerShippingAddress()));
        }
    }

    private boolean isPiRequired()
    {
        while (shopCartId > 0L || !com.ebay.common.view.util.EbayCountryManager.Default.supportsPaymentIntermediation(EbaySite.getInstanceFromId(item.site)) || !item.ebayPaymentProcessEnabled) 
        {
            return false;
        }
        return true;
    }

    private boolean isReadyToPayForOrder()
    {
        if (cart != null)
        {
            if (cart.isProx())
            {
                return cart.isPaymentInstrumentSelected();
            }
            if (useMec2 && selectedPaymentMethod != null && selectedPaymentMethod.equals("PayPal"))
            {
                if (payPalCheckoutDetails != null && (cart.isTotalZero() || payPalCheckoutDetails.fundingSources != null && payPalCheckoutDetails.fundingSources.length != 0))
                {
                    return true;
                }
            } else
            {
                return paymentMethodCompleted;
            }
        }
        return false;
    }

    private boolean isRememberMeActive()
    {
        if (cart != null)
        {
            if (cart.isProx())
            {
                return shouldRememberPaymentInstrument();
            }
            if (useMec2 && !TextUtils.isEmpty(MyApp.getPrefs().getPayPalCheckoutAuthToken()))
            {
                return true;
            }
        }
        return false;
    }

    private boolean isSupportedLogisticsPlan(com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan logisticsplan)
    {
        return com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type.SHIP_TO_HOME.equals(logisticsplan.type) || com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type.EBAY_NOW.equals(logisticsplan.type) || com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type.ISPU.equals(logisticsplan.type) || com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type.GLOBAL_SHIPPING.equals(logisticsplan.type) || com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type.PUDO.equals(logisticsplan.type);
    }

    private void postProcessPaidForItems()
    {
        UserCache usercache = new UserCache(this);
        Authentication authentication = MyApp.getPrefs().getAuthentication();
        if (authentication != null)
        {
            if (item != null)
            {
                com.ebay.common.model.cart.Cart.LineItem lineitem = (com.ebay.common.model.cart.Cart.LineItem)cart.lineItems.get(0);
                updatePaidStatusAndUnWatchItem(item, lineitem.postPurchaseTransactionId, variationOptions, usercache, authentication.user);
                return;
            }
            if (isShoppingCartCheckout())
            {
                Iterator iterator = cart.lineItems.iterator();
                while (iterator.hasNext()) 
                {
                    com.ebay.common.model.cart.Cart.LineItem lineitem1 = (com.ebay.common.model.cart.Cart.LineItem)iterator.next();
                    if (!lineitem1.isInvoiced())
                    {
                        Object obj = ShoppingCart.createItemKey(lineitem1.ebayItemId.longValue(), lineitem1.variationId, lineitem1.transactionId);
                        if (shopCartItems.containsKey(obj))
                        {
                            obj = (CheckoutItem)shopCartItems.get(obj);
                            if (obj != null)
                            {
                                obj.watched = true;
                                updatePaidStatusAndUnWatchItem(((CheckoutItem) (obj)), lineitem1.postPurchaseTransactionId, ((CheckoutItem) (obj)).variationOptions, usercache, authentication.user);
                            }
                        }
                    }
                }
            }
        }
    }

    private void renderCharities()
    {
        View view = findViewById(0x7f10092c);
        if (favoriteCharities == null || favoriteCharities.size() == 0 || blockCharityOnCrossBorderTrade())
        {
            view.setVisibility(8);
            view.setOnClickListener(null);
            return;
        }
        TextView textview = (TextView)findViewById(0x7f10092e);
        TextView textview1 = (TextView)findViewById(0x7f10092f);
        if (cart.hasDonation())
        {
            textview1.setText(EbayCurrencyUtil.formatDisplay(cart.donationAmount, 2));
            textview1.setVisibility(0);
            textview.setText(com.ebay.common.model.cart.Cart.DonationHelper.getDonationName(cart));
        } else
        {
            textview1.setVisibility(8);
            textview.setText(0x7f070c12);
        }
        view.setVisibility(0);
        view.setOnClickListener(this);
    }

    private void renderConvenienceCharge(ViewGroup viewgroup, CurrencyAmount currencyamount, CurrencyAmount currencyamount1)
    {
        viewgroup = viewgroup.findViewById(0x7f100945);
        ((TextView)viewgroup.findViewById(0x7f100947)).setText(EbayCurrencyUtil.formatDisplay(currencyamount, 2));
        viewgroup.setTag(currencyamount1);
    }

    private void renderDeliveryInstructions(ViewGroup viewgroup, com.ebay.common.model.cart.Cart.Seller seller, String s)
    {
        View view = viewgroup.findViewById(0x7f100950);
        ((TextView)viewgroup.findViewById(0x7f100951)).setText(0x7f070ca6);
        viewgroup = (TextView)viewgroup.findViewById(0x7f100952);
        if (!TextUtils.isEmpty(s))
        {
            viewgroup.setText(s);
        } else
        {
            viewgroup.setText(0x7f070c47);
        }
        view.setTag(0x7f100014, seller);
        view.setTag(0x7f100013, Boolean.valueOf(true));
        view.setTag(0x7f100012, s);
    }

    private boolean renderEbayNowMethod(ViewGroup viewgroup, com.ebay.common.model.cart.Cart.LineItem lineitem)
    {
        TextView textview;
        TextView textview1;
        Object obj;
        obj = (TextView)viewgroup.findViewById(0x7f100959);
        textview = (TextView)viewgroup.findViewById(0x7f10095b);
        textview1 = (TextView)viewgroup.findViewById(0x7f10095f);
        viewgroup = (RadioButton)viewgroup.findViewById(0x7f100960);
        ((TextView) (obj)).setText(0x7f070cb3);
        obj = lineitem.getSelectedLogisticsPlan();
        if (obj != null && ((com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan) (obj)).isEbayNow()) goto _L2; else goto _L1
_L1:
        textview.setText(0x7f070cb0);
        textview.setVisibility(0);
        textview1.setVisibility(0);
        renderLogisticsPlanOptionCost(textview1, lineitem.getLogisticsPlanOfType(com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type.EBAY_NOW), 0x7f0704b5);
        viewgroup.setChecked(false);
_L4:
        if (TextUtils.isEmpty(cart.getBuyerShippingAddress().addressFields.phone))
        {
            ((TextView)findViewById(0x7f100917)).setText(0x7f070cac);
            showWarningView = true;
        }
        return true;
_L2:
        viewgroup.setChecked(true);
        atLeastOneItemHasShipping = true;
        if (((com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan) (obj)).getReservationToken() != null)
        {
            viewgroup = ((com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan) (obj)).getSelectedPlanOption();
            lineitem = viewgroup.getDeliveryDateMin();
            obj = viewgroup.getDeliveryDateMax();
            if (lineitem != null && obj != null)
            {
                textview.setText(Util.getEbayNowDeliveryTimeString(getApplicationContext(), lineitem, ((java.util.Date) (obj))));
                textview.setVisibility(0);
                textview1.setVisibility(0);
                if (((com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.PlanStep.PlanOption) (viewgroup)).totalCostWithSavings != null)
                {
                    renderLogisticsPlanOptionCost(textview1, viewgroup.getLogisticsCost());
                }
            }
        } else
        {
            ((TextView)findViewById(0x7f100917)).setText(0x7f070c83);
            showWarningView = true;
            preventPayment = true;
            textview.setText(0x7f070cb0);
            textview.setTextColor(getResources().getColor(0x7f0d00fb));
            textview.setVisibility(0);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private boolean renderInStorePickupMethod(ViewGroup viewgroup, com.ebay.common.model.cart.Cart.LineItem lineitem)
    {
        TextView textview;
        TextView textview1;
        TextView textview2;
        Object obj;
        Object obj1;
        obj = (TextView)viewgroup.findViewById(0x7f100959);
        textview = (TextView)viewgroup.findViewById(0x7f10095a);
        textview1 = (TextView)viewgroup.findViewById(0x7f10095b);
        textview2 = (TextView)viewgroup.findViewById(0x7f10095f);
        obj1 = (RadioButton)viewgroup.findViewById(0x7f100960);
        ((TextView) (obj)).setText(SearchUtil.getInStorePickupResourceForCountry(MyApp.getPrefs().getCurrentCountry()));
        obj = lineitem.getSelectedLogisticsPlan();
        if (obj != null && ((com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan) (obj)).isInStorePickup()) goto _L2; else goto _L1
_L1:
        textview1.setText(0x7f070bd2);
        textview1.setVisibility(0);
        textview2.setVisibility(0);
        renderLogisticsPlanOptionCost(textview2, lineitem.getLogisticsPlanOfType(com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type.ISPU).getTotalCost());
        ((RadioButton) (obj1)).setChecked(false);
_L4:
        return true;
_L2:
        ((RadioButton) (obj1)).setChecked(true);
        obj1 = cart.getPickupAddressForStoreId(lineitem.getPickupStoreId());
        if (obj1 != null)
        {
            textview.setText(((Address) (obj1)).addressFields.name);
            textview1.setText(((Address) (obj1)).addressFields.street1);
            textview.setVisibility(0);
            textview1.setVisibility(0);
            obj1 = getInventoryInfo(lineitem.cartLineItemId);
            if (obj1 != null)
            {
                obj1 = ((InventoryInfo) (obj1)).getSelectedStore();
                if (obj1 != null && ((StoreAvailability) (obj1)).fulfillmentTime.longValue() != 0L)
                {
                    obj1 = PickupUtil.formatFulfillmentTime(this, ((StoreAvailability) (obj1)).fulfillmentTime);
                    if (!TextUtils.isEmpty(((CharSequence) (obj1))))
                    {
                        viewgroup = (TextView)viewgroup.findViewById(0x7f10095c);
                        viewgroup.setText(((CharSequence) (obj1)));
                        viewgroup.setVisibility(0);
                    }
                }
            }
        }
        if ("5016".equals(lineitem.lineItemErrorCode))
        {
            textview2.setVisibility(8);
            textview1.setText(0x7f070bce);
            textview1.setTextColor(getResources().getColor(0x7f0d009b));
        } else
        {
            textview2.setVisibility(0);
            renderLogisticsPlanOptionCost(textview2, ((com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan) (obj)).getSelectedPlanOption().getLogisticsCost());
        }
        if (((com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan) (obj)).getPickupStoreId() == null)
        {
            ((TextView)findViewById(0x7f100917)).setText(0x7f070c84);
            showWarningView = true;
            preventPayment = true;
            textview.setText(0x7f070bd2);
            textview.setTextColor(getResources().getColor(0x7f0d00fb));
            textview.setVisibility(0);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void renderIncentives(List list)
    {
        Object obj = (TextView)findViewById(0x7f100927);
        TextView textview;
        TextView textview1;
        if (MyApp.getPrefs().getCurrentSite().equals(EbaySite.US))
        {
            ((TextView) (obj)).setText(0x7f070c2f);
        } else
        {
            ((TextView) (obj)).setText(0x7f0700e4);
        }
        textview = (TextView)findViewById(0x7f100929);
        textview1 = (TextView)findViewById(0x7f10092a);
        if (list != null && list.size() > 0)
        {
            Object obj1 = null;
            obj = null;
            Iterator iterator = list.iterator();
            list = obj1;
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                com.ebay.common.model.cart.Cart.AppliedIncentive appliedincentive = (com.ebay.common.model.cart.Cart.AppliedIncentive)iterator.next();
                CurrencyAmount currencyamount = appliedincentive.redeemedAmount.add(((CurrencyAmount) (obj)));
                if (list == null)
                {
                    list = incentiveTypeToString(this, appliedincentive);
                    obj = currencyamount;
                } else
                {
                    obj = currencyamount;
                    if (TextUtils.equals(list, incentiveTypeToString(this, appliedincentive)))
                    {
                        list = getString(0x7f070c30);
                        obj = currencyamount;
                    }
                }
            } while (true);
            textview.setText(list);
            textview.setVisibility(0);
            textview1.setText(EbayCurrencyUtil.formatDisplay(((CurrencyAmount) (obj)), 2));
        } else
        {
            textview.setText(0x7f070c26);
            textview.setVisibility(8);
            if (getAvailableIncentiveCount() > 0)
            {
                int i = getAvailableIncentiveCount();
                textview1.setText(getResources().getQuantityString(0x7f08003c, i, new Object[] {
                    Integer.valueOf(i)
                }));
                textview1.setVisibility(0);
            } else
            {
                textview1.setVisibility(8);
            }
        }
        findViewById(0x7f100926).setOnClickListener(this);
    }

    private void renderItems(LayoutInflater layoutinflater)
    {
        ViewGroup viewgroup;
        Iterator iterator;
        viewgroup = (ViewGroup)findViewById(0x7f10093f);
        viewgroup.removeAllViews();
        resolveGspLineItemErrors();
        iterator = cart.sellers.keySet().iterator();
_L7:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        Object obj;
        CurrencyAmount currencyamount;
        Object obj2;
        ViewGroup viewgroup1;
        com.ebay.common.model.cart.Cart.Seller seller;
        boolean flag1;
        boolean flag4;
        obj = (String)iterator.next();
        seller = (com.ebay.common.model.cart.Cart.Seller)cart.sellers.get(obj);
        if (seller.getLineItemCount() == 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = (ViewGroup)layoutinflater.inflate(0x7f0302ad, viewgroup, false);
        viewgroup.addView(((View) (obj)));
        viewgroup1 = (ViewGroup)((ViewGroup) (obj)).findViewById(0x7f100944);
        obj = (TextView)((ViewGroup) (obj)).findViewById(0x7f100943);
        setSellerLabel(seller.userIdentifier, ((TextView) (obj)));
        flag4 = false;
        flag1 = false;
        obj2 = null;
        currencyamount = null;
        obj = null;
        DeviceConfiguration deviceconfiguration = DeviceConfiguration.getAsync();
        int i = 0;
        Iterator iterator1 = seller.cartLineItemIds.iterator();
label0:
        do
        {
            Object obj3;
            int k;
            boolean flag2;
label1:
            {
                if (!iterator1.hasNext())
                {
                    break label0;
                }
                String s = (String)iterator1.next();
                k = i + 1;
                obj3 = cart.getLineItemByCartLineItemId(s);
                if (!((com.ebay.common.model.cart.Cart.LineItem) (obj3)).isInStorePickupSelected())
                {
                    flag2 = flag4;
                    if (!((com.ebay.common.model.cart.Cart.LineItem) (obj3)).isInStorePickupAvailable())
                    {
                        break label1;
                    }
                }
                flag2 = deviceconfiguration.get(DcsBoolean.MecDisableMessageToSellerForBopis);
            }
            Object obj1 = obj2;
            boolean flag = flag1;
            if (((com.ebay.common.model.cart.Cart.LineItem) (obj3)).isEbayNowSelected())
            {
                flag = true;
                obj1 = ((com.ebay.common.model.cart.Cart.LineItem) (obj3)).getSelectedLogisticsPlan().getDeliveryInstructions();
            }
            if (((com.ebay.common.model.cart.Cart.LineItem) (obj3)).isInvoiced() && ((com.ebay.common.model.cart.Cart.LineItem) (obj3)).orderComponents.size() > 0)
            {
                int j = 0;
                do
                {
                    obj2 = obj1;
                    flag4 = flag2;
                    i = k;
                    flag1 = flag;
                    if (j >= ((com.ebay.common.model.cart.Cart.LineItem) (obj3)).orderComponents.size())
                    {
                        continue label0;
                    }
                    obj2 = (com.ebay.common.model.cart.Cart.ComponentInfo)((com.ebay.common.model.cart.Cart.LineItem) (obj3)).orderComponents.get(j);
                    ViewGroup viewgroup2 = (ViewGroup)layoutinflater.inflate(0x7f0302b1, viewgroup1, false);
                    renderSellerItem(viewgroup2, isLineItemShippable(((com.ebay.common.model.cart.Cart.LineItem) (obj3))), ((com.ebay.common.model.cart.Cart.ComponentInfo) (obj2)).itemImageUrl, ((com.ebay.common.model.cart.Cart.ComponentInfo) (obj2)).itemTitle, ((com.ebay.common.model.cart.Cart.ComponentInfo) (obj2)).price.multiplyBy(((com.ebay.common.model.cart.Cart.ComponentInfo) (obj2)).quantity));
                    viewgroup1.addView(viewgroup2);
                    renderQuantityAndShipping(viewgroup2, ((com.ebay.common.model.cart.Cart.LineItem) (obj3)));
                    if (j == ((com.ebay.common.model.cart.Cart.LineItem) (obj3)).orderComponents.size() - 1 && k == seller.cartLineItemIds.size())
                    {
                        flag4 = true;
                    } else
                    {
                        flag4 = false;
                    }
                    endItem(viewgroup1, flag4);
                    j++;
                } while (true);
            }
            obj2 = (ViewGroup)layoutinflater.inflate(0x7f0302b1, viewgroup1, false);
            ViewGroup viewgroup3 = (ViewGroup)((ViewGroup) (obj2)).findViewById(0x7f10094e);
            renderSellerItem(((ViewGroup) (obj2)), isLineItemShippable(((com.ebay.common.model.cart.Cart.LineItem) (obj3))), ((com.ebay.common.model.cart.Cart.LineItem) (obj3)).itemImageUrl, ((com.ebay.common.model.cart.Cart.LineItem) (obj3)).getTitle(deviceconfiguration.get(DcsBoolean.itemTitleTranslationEnabled)), ((com.ebay.common.model.cart.Cart.LineItem) (obj3)).price.multiplyBy(((com.ebay.common.model.cart.Cart.LineItem) (obj3)).quantity));
            renderSpecifics(viewgroup3, ((com.ebay.common.model.cart.Cart.LineItem) (obj3)));
            viewgroup1.addView(((View) (obj2)));
            renderQuantityAndShipping(((ViewGroup) (obj2)), ((com.ebay.common.model.cart.Cart.LineItem) (obj3)));
            if (k == seller.cartLineItemIds.size())
            {
                flag4 = true;
            } else
            {
                flag4 = false;
            }
            endItem(viewgroup1, flag4);
            obj2 = obj1;
            flag4 = flag2;
            i = k;
            flag1 = flag;
            if (currencyamount == null)
            {
                obj3 = ((com.ebay.common.model.cart.Cart.LineItem) (obj3)).getSelectedLogisticsPlan();
                obj2 = obj1;
                flag4 = flag2;
                i = k;
                flag1 = flag;
                if (obj3 != null)
                {
                    obj3 = ((com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan) (obj3)).getSelectedPlanOption();
                    obj2 = obj1;
                    flag4 = flag2;
                    i = k;
                    flag1 = flag;
                    if (obj3 != null)
                    {
                        obj2 = obj1;
                        flag4 = flag2;
                        i = k;
                        flag1 = flag;
                        if (((com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.PlanStep.PlanOption) (obj3)).totalCostWithSavings != null)
                        {
                            currencyamount = ((com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.PlanStep.PlanOption) (obj3)).totalCostWithSavings.getConvienceCharge();
                            obj = ((com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.PlanStep.PlanOption) (obj3)).totalCostWithSavings.getMinimumOrderAmount();
                            obj2 = obj1;
                            flag4 = flag2;
                            i = k;
                            flag1 = flag;
                        }
                    }
                }
            }
        } while (true);
        if (!flag1) goto _L4; else goto _L3
_L3:
        layoutinflater.inflate(0x7f0302b2, viewgroup1, true);
        renderDeliveryInstructions(viewgroup1, seller, ((String) (obj2)));
        View view = viewgroup1.findViewById(0x7f100950);
        view.setOnClickListener(this);
        boolean flag3;
        if (deliverySchedulingParams.selectedReservationToken != null)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        view.setClickable(flag3);
_L5:
        if (currencyamount != null && currencyamount.isGreaterThanZero())
        {
            layoutinflater.inflate(0x7f0302ae, viewgroup1, true);
            renderConvenienceCharge(viewgroup1, currencyamount, ((CurrencyAmount) (obj)));
            viewgroup1.findViewById(0x7f100945).setOnClickListener(this);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (seller.acceptsNotesToSeller() && !flag4)
        {
            layoutinflater.inflate(0x7f0302b2, viewgroup1, true);
            renderSellerMessage(viewgroup1, seller);
            viewgroup1.findViewById(0x7f100950).setOnClickListener(this);
        }
        if (true) goto _L5; else goto _L2
_L2:
        return;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private void renderLogisticsPlanOptionCost(TextView textview, com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan logisticsplan, int i)
    {
        CurrencyAmount currencyamount = null;
        Object obj = null;
        Iterator iterator = logisticsplan.getPlanOptions().iterator();
        logisticsplan = obj;
label0:
        do
        {
            CurrencyAmount currencyamount1;
            CurrencyAmount currencyamount2;
label1:
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                currencyamount1 = ((com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.PlanStep.PlanOption)iterator.next()).getLogisticsCost();
                if (currencyamount != null)
                {
                    currencyamount2 = currencyamount;
                    if (currencyamount1.compareTo(currencyamount) >= 0)
                    {
                        break label1;
                    }
                }
                currencyamount2 = currencyamount1;
            }
            if (logisticsplan != null)
            {
                currencyamount = currencyamount2;
                if (currencyamount1.compareTo(logisticsplan) <= 0)
                {
                    continue;
                }
            }
            logisticsplan = currencyamount1;
            currencyamount = currencyamount2;
        } while (true);
        if (currencyamount != null && currencyamount.equals(logisticsplan))
        {
            renderLogisticsPlanOptionCost(textview, currencyamount);
            return;
        } else
        {
            textview.setText(getString(i, new Object[] {
                EbayCurrencyUtil.formatDisplay(currencyamount, 2), EbayCurrencyUtil.formatDisplay(logisticsplan, 2)
            }));
            return;
        }
    }

    private void renderLogisticsPlanOptionCost(TextView textview, CurrencyAmount currencyamount)
    {
        if (!cart.hasFreeShipping() && currencyamount != null && currencyamount.isGreaterThanZero() && cart.logisticsSubtotal.isGreaterThanZero())
        {
            currencyamount = EbayCurrencyUtil.formatDisplay(currencyamount, 2);
        } else
        {
            currencyamount = getString(0x7f070421);
        }
        textview.setText(currencyamount);
    }

    private void renderOrderSummary()
    {
        if (cart != null)
        {
            ViewGroup viewgroup = (ViewGroup)findViewById(0x7f100919);
            viewgroup.removeAllViews();
            if (cart.priceSubtotal != null)
            {
                String s = getString(0x7f070853);
                appendLayout(inflater, viewgroup, s, EbayCurrencyUtil.formatDisplay(cart.priceSubtotal, 2), null);
            }
            Object obj = cart.shippingSubtotal;
            if (obj != null)
            {
                Object obj2;
                if (((CurrencyAmount) (obj)).isZero() || cart.hasFreeShipping())
                {
                    obj = getString(0x7f070421);
                } else
                {
                    obj = EbayCurrencyUtil.formatDisplay(((CurrencyAmount) (obj)), 2);
                }
                appendLayout(inflater, viewgroup, getString(0x7f070c6f), ((String) (obj)), null);
            }
            obj = cart.deliverySubtotal;
            if (obj != null)
            {
                if (((CurrencyAmount) (obj)).isZero() || cart.hasFreeShipping())
                {
                    obj = getString(0x7f070421);
                } else
                {
                    obj = EbayCurrencyUtil.formatDisplay(((CurrencyAmount) (obj)), 2);
                }
                appendLayout(inflater, viewgroup, getString(0x7f070c19), ((String) (obj)), null);
            }
            obj = cart.convenienceCharge;
            if (obj != null && ((CurrencyAmount) (obj)).isGreaterThanZero())
            {
                obj = EbayCurrencyUtil.formatDisplay(((CurrencyAmount) (obj)), 2);
                appendLayout(inflater, viewgroup, getString(0x7f070ca4), ((String) (obj)), null);
            }
            if (cart.importCharges != null)
            {
                obj = getString(0x7f070209);
                obj2 = EbayCurrencyUtil.formatDisplay(cart.importCharges, 2);
                appendLayout(inflater, viewgroup, ((String) (obj)), ((String) (obj2)), null);
            }
            if (cart.doesContainBopisItem() || cart.doesContainPudoItem())
            {
                appendLayout(inflater, viewgroup, getString(SearchUtil.getInStorePickupResourceForCountry(MyApp.getPrefs().getCurrentCountry())), getString(0x7f070421), null);
            }
            if (cart.handlingSubtotal != null && cart.handlingSubtotal.isGreaterThanZero())
            {
                appendLayout(inflater, viewgroup, getString(0x7f070c25), EbayCurrencyUtil.formatDisplay(cart.handlingSubtotal, 2), null);
            }
            if (cart.insuranceSubtotal != null && cart.insuranceSubtotal.isGreaterThanZero())
            {
                appendLayout(inflater, viewgroup, getString(0x7f070c3c), EbayCurrencyUtil.formatDisplay(cart.insuranceSubtotal, 2), null);
            }
            if (cart.taxSubtotal != null && cart.taxSubtotal.isGreaterThanZero())
            {
                appendLayout(inflater, viewgroup, getString(0x7f070c79), EbayCurrencyUtil.formatDisplay(cart.taxSubtotal, 2), null);
            }
            if (cart.otherFeesSubtotal != null && cart.otherFeesSubtotal.isGreaterThanZero())
            {
                appendLayout(inflater, viewgroup, getString(0x7f070c22), EbayCurrencyUtil.formatDisplay(cart.otherFeesSubtotal, 2), null);
            }
            obj2 = cart.getIncentives().iterator();
            do
            {
                if (!((Iterator) (obj2)).hasNext())
                {
                    break;
                }
                com.ebay.common.model.cart.Cart.AppliedIncentive appliedincentive = (com.ebay.common.model.cart.Cart.AppliedIncentive)((Iterator) (obj2)).next();
                if (!appliedincentive.redeemedAmount.isZero())
                {
                    if (appliedincentive.redeemedAmount.isGreaterThanZero())
                    {
                        obj = new CurrencyAmount(0.0D - appliedincentive.redeemedAmount.getValueAsDouble(), appliedincentive.redeemedAmount.getCurrencyCode());
                    } else
                    {
                        obj = appliedincentive.redeemedAmount;
                    }
                    appendLayout(inflater, viewgroup, incentiveTypeToString(this, appliedincentive), EbayCurrencyUtil.formatDisplay(((CurrencyAmount) (obj)), 2), null);
                }
            } while (true);
            if (cart.adjustmentsSubtotal != null && !cart.adjustmentsSubtotal.isZero())
            {
                boolean flag = cart.adjustmentsSubtotal.isGreaterThanZero();
                Object obj1;
                CurrencyAmount currencyamount;
                StringBuilder stringbuilder;
                int i;
                if (flag)
                {
                    i = 0x7f070c66;
                } else
                {
                    i = 0x7f070c67;
                }
                obj1 = getString(i);
                currencyamount = new CurrencyAmount(cart.adjustmentsSubtotal.getValueAsBigDecimal().abs(), cart.adjustmentsSubtotal.getCurrencyCode());
                stringbuilder = new StringBuilder();
                if (!flag)
                {
                    stringbuilder.append("- ");
                }
                stringbuilder.append(EbayCurrencyUtil.formatDisplay(currencyamount, 2));
                appendLayout(inflater, viewgroup, ((String) (obj1)), stringbuilder.toString(), null);
            }
            if (cart.promotionSavingsTotal != null && !cart.promotionSavingsTotal.isZero())
            {
                appendLayout(inflater, viewgroup, getString(0x7f07020e), (new StringBuilder()).append("- ").append(EbayCurrencyUtil.formatDisplay(cart.promotionSavingsTotal, 2)).toString(), null);
            }
            if (cart.savingsAmount != null && !cart.savingsAmount.isZero())
            {
                appendLayout(inflater, viewgroup, getString(0x7f07020f), (new StringBuilder()).append("- ").append(EbayCurrencyUtil.formatDisplay(cart.savingsAmount, 2)).toString(), null);
            }
            if (cart.hasDonation())
            {
                appendLayout(inflater, viewgroup, getString(0x7f070206), EbayCurrencyUtil.formatDisplay(cart.donationAmount, 2), null);
            }
            if (cart.total != null)
            {
                appendLayout(0x7f0302ac, inflater, viewgroup, getString(0x7f0700ec), EbayCurrencyUtil.formatDisplay(cart.total, 2), null);
                obj1 = getConvertedPrice(cart.total);
                if (isConversionRequired() && obj1 != CurrencyAmount.ZERO)
                {
                    appendLayout(inflater, viewgroup, "", (new StringBuilder()).append(getString(0x7f070bc8)).append(EbayCurrencyUtil.formatDisplay(((CurrencyAmount) (obj1)), 0)).toString(), null);
                    return;
                }
            }
        }
    }

    private void renderPaymentMethod(PayPalCheckoutDetails paypalcheckoutdetails)
    {
        if (selectedPaymentMethod == null)
        {
            visibleLayoutId = 0x7f10091b;
            findViewById(0x7f100924).setVisibility(8);
            break MISSING_BLOCK_LABEL_25;
        } else
        {
            if (selectedPaymentMethod.equals("PayPal"))
            {
                visibleLayoutId = 0x7f10091e;
                if (isReadyToPayForOrder())
                {
                    obj = (ViewGroup)findViewById(0x7f100921);
                    ((ViewGroup) (obj)).removeAllViews();
                    if (cart.isProx())
                    {
                        renderPaymentMethodDetailsProx(((ViewGroup) (obj)));
                    } else
                    {
                        renderPaymentMethodDetailsMec2(paypalcheckoutdetails, ((ViewGroup) (obj)));
                    }
                    if (useGuestXo)
                    {
                        findViewById(0x7f10091f).setVisibility(8);
                        findViewById(0x7f100920).setVisibility(0);
                    } else
                    {
                        findViewById(0x7f10091f).setVisibility(0);
                        findViewById(0x7f100920).setVisibility(8);
                    }
                } else
                {
                    visibleLayoutId = 0x7f10091c;
                    paypalcheckoutdetails = (TextView)findViewById(0x7f10091d);
                    if (isInitializationSequenceComplete)
                    {
                        paypalcheckoutdetails.setVisibility(0);
                    } else
                    {
                        paypalcheckoutdetails.setVisibility(4);
                    }
                }
            } else
            if (selectedPaymentMethod.equals("PayUponInvoice"))
            {
                findViewById(0x7f100924).setVisibility(8);
                visibleLayoutId = 0x7f100922;
                ((TextView)findViewById(0x7f100923)).setText(getString(0x7f070c53));
            } else
            if (selectedPaymentMethod.equals("MoneyXferAcceptedInCheckout"))
            {
                findViewById(0x7f100924).setVisibility(8);
                visibleLayoutId = 0x7f100922;
                ((TextView)findViewById(0x7f100923)).setText(getString(0x7f070c51));
            } else
            if (selectedPaymentMethod.equals("CashOnPickup"))
            {
                findViewById(0x7f100924).setVisibility(8);
                visibleLayoutId = 0x7f100922;
                ((TextView)findViewById(0x7f100923)).setText(getString(0x7f070c4d));
            } else
            if (selectedPaymentMethod.equals("CreditCard") || selectedPaymentMethod.equals("DirectDebit"))
            {
                visibleLayoutId = 0x7f100922;
                renderPaymentMethodDetailsProx(null);
            }
            continue;
        }
        do
        {
            paypalcheckoutdetails = paymentMethodLayoutIds;
            int k = paypalcheckoutdetails.length;
            int i = 0;
            while (i < k) 
            {
                int j = paypalcheckoutdetails[i];
                Object obj = findViewById(j);
                if (visibleLayoutId == j)
                {
                    j = 0;
                } else
                {
                    j = 8;
                }
                ((View) (obj)).setVisibility(j);
                if (selectedPaymentMethod != null && selectedPaymentMethod.equals("PayPal"))
                {
                    if (!useGuestXo)
                    {
                        ((View) (obj)).setOnClickListener(this);
                    } else
                    {
                        ((View) (obj)).setOnClickListener(null);
                        ((View) (obj)).setBackgroundDrawable(null);
                    }
                } else
                if (paymentMethodCount > 1)
                {
                    ((View) (obj)).setOnClickListener(this);
                } else
                {
                    ((View) (obj)).setOnClickListener(null);
                    ((View) (obj)).setBackgroundDrawable(null);
                }
                i++;
            }
            customizeUi();
            return;
        } while (true);
    }

    private void renderPaymentMethodDetailsMec2(PayPalCheckoutDetails paypalcheckoutdetails, ViewGroup viewgroup)
    {
        findViewById(0x7f100924).setVisibility(8);
        if (paypalcheckoutdetails != null)
        {
            if (paypalcheckoutdetails.account.userId != null)
            {
                TextView textview = (TextView)inflater.inflate(0x7f0302c6, viewgroup, false);
                textview.setText(paypalcheckoutdetails.account.userId);
                viewgroup.addView(textview);
            }
            if (paypalcheckoutdetails.fundingSources != null && paypalcheckoutdetails.fundingSources.length > 0)
            {
                com.ebay.common.model.cart.PayPalCheckoutDetails.FundingSource afundingsource[] = paypalcheckoutdetails.fundingSources;
                int j = afundingsource.length;
                for (int i = 0; i < j; i++)
                {
                    com.ebay.common.model.cart.PayPalCheckoutDetails.FundingSource fundingsource = afundingsource[i];
                    TextView textview2 = (TextView)inflater.inflate(0x7f0302aa, viewgroup, false);
                    textview2.setText(formatFundingSourceDetailText(fundingsource.name, EbayCurrencyUtil.formatDisplay(fundingsource.balance, 2), true));
                    viewgroup.addView(textview2);
                }

            } else
            if (!cart.isTotalZero())
            {
                viewgroup.addView((TextView)inflater.inflate(0x7f0302d6, viewgroup, false));
            }
            if (isConversionRequired() && paypalcheckoutdetails.currencyConversion != null && paypalcheckoutdetails.currencyConversion.exchangeRate != null)
            {
                TextView textview1 = (TextView)inflater.inflate(0x7f0302aa, viewgroup, false);
                textview1.setText(formatConversionRateDisplay(paypalcheckoutdetails.currencyConversion));
                viewgroup.addView(textview1);
            }
            return;
        }
        paypalcheckoutdetails = (TextView)inflater.inflate(0x7f0302aa, viewgroup, false);
        if (useGuestXo)
        {
            if (DeviceConfiguration.getAsync().get(DcsBoolean.MecBankTransfer))
            {
                paypalcheckoutdetails.setText(0x7f0700ef);
            } else
            {
                paypalcheckoutdetails.setText(0x7f070c4e);
            }
        } else
        {
            paypalcheckoutdetails.setText(0x7f070c4c);
        }
        viewgroup.addView(paypalcheckoutdetails);
    }

    private void renderPaymentMethodDetailsProx(ViewGroup viewgroup)
    {
        findViewById(0x7f100924).setVisibility(8);
        Object obj = (Switch)findViewById(0x7f100925);
        com.ebay.common.model.cart.CartPaymentMethods.PaymentMethod paymentmethod = cart.cartPaymentMethods.getSelectedPaymentMethod();
        Object obj1 = paymentmethod.getPaymentInstrument();
        ((Switch) (obj)).setOnCheckedChangeListener(null);
        ((Switch) (obj)).setChecked(shouldRememberPaymentInstrument());
        ((Switch) (obj)).setOnCheckedChangeListener(this);
        if ("PayPal".equals(selectedPaymentMethod))
        {
            View view = findViewById(0x7f100924);
            int i;
            if (showProxRememberMeSwitchForPayPal())
            {
                i = 0;
            } else
            {
                i = 8;
            }
            view.setVisibility(i);
            ((Switch) (obj)).setText(0x7f070818);
            obj = null;
            if (obj1 != null)
            {
                obj = ((com.ebay.common.model.cart.CartPaymentMethods.PaymentMethod.PaymentInstrument) (obj1)).getPayPalAccount();
            }
            if (!TextUtils.isEmpty(((CharSequence) (obj))))
            {
                obj1 = (TextView)inflater.inflate(0x7f0302c6, viewgroup, false);
                ((TextView) (obj1)).setText(((CharSequence) (obj)));
                viewgroup.addView(((View) (obj1)));
            }
            obj = paymentmethod.getFixedFundingComponents();
            if (!((List) (obj)).isEmpty())
            {
                obj = ((List) (obj)).iterator();
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break;
                    }
                    obj1 = (com.ebay.common.model.cart.CartPaymentMethods.PaymentMethod.PaymentInstrument.FundingStrategy.StrategyChoice)((Iterator) (obj)).next();
                    if (obj1 != null)
                    {
                        obj1 = ((com.ebay.common.model.cart.CartPaymentMethods.PaymentMethod.PaymentInstrument.FundingStrategy.StrategyChoice) (obj1)).getFundingSource();
                        if (obj1 != null)
                        {
                            addSelectedFundingSourceToGroup(viewgroup, ((com.ebay.common.model.cart.CartPaymentMethods.PaymentMethod.PaymentInstrument.FundingStrategy.StrategyChoice.FundingSource) (obj1)));
                        }
                    }
                } while (true);
            }
            if (paymentmethod.hasSelectedFundingSource())
            {
                addSelectedFundingSourceToGroup(viewgroup, paymentmethod.getSelectedFundingSource());
            }
            return;
        } else
        {
            ((Switch) (obj)).setText(0x7f070817);
            findViewById(0x7f100924).setVisibility(0);
            ((TextView)findViewById(0x7f100923)).setText(getDisplayStringForPaymentInstrument(((com.ebay.common.model.cart.CartPaymentMethods.PaymentMethod.PaymentInstrument) (obj1))));
            return;
        }
    }

    private boolean renderPickupAndDropoffMethod(ViewGroup viewgroup, com.ebay.common.model.cart.Cart.LineItem lineitem)
    {
        TextView textview;
        TextView textview1;
        TextView textview2;
        Object obj;
        Object obj1;
        obj = (TextView)viewgroup.findViewById(0x7f100959);
        textview = (TextView)viewgroup.findViewById(0x7f10095a);
        textview1 = (TextView)viewgroup.findViewById(0x7f10095b);
        textview2 = (TextView)viewgroup.findViewById(0x7f10095f);
        obj1 = (RadioButton)viewgroup.findViewById(0x7f100960);
        ((TextView) (obj)).setText(LocalUtil.getPudoResourceForCountry(MyApp.getPrefs().getCurrentCountry()));
        obj = lineitem.getSelectedLogisticsPlan();
        if (obj != null && ((com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan) (obj)).isPickupAndDropoff()) goto _L2; else goto _L1
_L1:
        textview1.setText(0x7f0708bf);
        textview1.setVisibility(0);
        textview2.setVisibility(0);
        renderLogisticsPlanOptionCost(textview2, lineitem.getLogisticsPlanOfType(com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type.PUDO).getTotalCost());
        ((RadioButton) (obj1)).setChecked(false);
_L4:
        return true;
_L2:
        ((RadioButton) (obj1)).setChecked(true);
        obj1 = cart.getPickupAddressForStoreId(lineitem.getPickupLocationId());
        if (obj1 != null)
        {
            textview.setText(((Address) (obj1)).addressFields.name);
            textview1.setText(((Address) (obj1)).addressFields.street1);
            textview.setVisibility(0);
            textview1.setVisibility(0);
            obj1 = getInventoryInfo(lineitem.cartLineItemId);
            if (obj1 != null)
            {
                obj1 = ((InventoryInfo) (obj1)).getSelectedStore();
                if (obj1 != null && ((StoreAvailability) (obj1)).fulfillmentTime.longValue() != 0L)
                {
                    obj1 = PickupUtil.formatFulfillmentTime(this, ((StoreAvailability) (obj1)).fulfillmentTime);
                    if (!TextUtils.isEmpty(((CharSequence) (obj1))))
                    {
                        viewgroup = (TextView)viewgroup.findViewById(0x7f10095c);
                        viewgroup.setText(((CharSequence) (obj1)));
                        viewgroup.setVisibility(0);
                    }
                }
            }
        }
        if ("5016".equals(lineitem.lineItemErrorCode))
        {
            textview2.setVisibility(8);
            textview1.setText(0x7f070bce);
            textview1.setTextColor(getResources().getColor(0x7f0d009b));
        } else
        {
            textview2.setVisibility(0);
            renderLogisticsPlanOptionCost(textview2, ((com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan) (obj)).getSelectedPlanOption().getLogisticsCost());
        }
        if (((com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan) (obj)).getPickupLocationId() == null)
        {
            ((TextView)findViewById(0x7f100917)).setText(0x7f070c84);
            showWarningView = true;
            preventPayment = true;
            textview.setText(0x7f0708bf);
            textview.setTextColor(getResources().getColor(0x7f0d00fb));
            textview.setVisibility(0);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void renderQuantityAndShipping(ViewGroup viewgroup, com.ebay.common.model.cart.Cart.LineItem lineitem)
    {
        ViewGroup viewgroup1 = (ViewGroup)viewgroup.findViewById(0x7f10094a);
        inflater.inflate(0x7f0302b3, viewgroup1, true);
        if (renderSellerQuantity(viewgroup, lineitem))
        {
            viewgroup.findViewById(0x7f100953).setOnClickListener(this);
        }
        DcsHelper dcshelper = MyApp.getDeviceConfiguration();
        boolean flag;
        boolean flag1;
        boolean flag2;
        if (lineitem.isInStorePickupAvailable() && dcshelper.isBopisEnabled())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (lineitem.isPickupAndDropoffAvailable() && dcshelper.isPudoEnabled())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        flag2 = showEbnForLineItem(lineitem);
        if (!flag && !flag2 || lineitem.isShipToHomeAvailable() || lineitem.isLocalPickupAvailable())
        {
            ViewGroup viewgroup2 = createSellerShippingLayout(viewgroup1, lineitem, 1);
            if (renderSellerShippingMethod(viewgroup, lineitem))
            {
                viewgroup2.setOnClickListener(this);
            }
        }
        if (flag)
        {
            viewgroup = createSellerShippingLayout(viewgroup1, lineitem, 2);
            if (renderInStorePickupMethod(viewgroup, lineitem))
            {
                viewgroup.setOnClickListener(this);
            }
        }
        if (flag1)
        {
            viewgroup = createSellerShippingLayout(viewgroup1, lineitem, 4);
            if (renderPickupAndDropoffMethod(viewgroup, lineitem))
            {
                viewgroup.setOnClickListener(this);
            }
        }
        if (flag2)
        {
            viewgroup = createSellerShippingLayout(viewgroup1, lineitem, 3);
            if (renderEbayNowMethod(viewgroup, lineitem))
            {
                viewgroup.setOnClickListener(this);
            }
        }
    }

    private void renderSellerItem(ViewGroup viewgroup, boolean flag, String s, String s1, CurrencyAmount currencyamount)
    {
        android.content.res.ColorStateList colorstatelist = ThemeUtil.resolveThemeColorStateList(getResources(), getTheme(), 0x1010036);
        if (!TextUtils.isEmpty(s))
        {
            imageCache.setImage((ImageView)viewgroup.findViewById(0x7f100949), s);
        }
        s = (TextView)viewgroup.findViewById(0x7f10094c);
        s.setText(s1);
        if (flag)
        {
            s.setTextColor(colorstatelist);
        } else
        {
            s.setTextColor(getResources().getColor(0x7f0d009b));
        }
        ((TextView)viewgroup.findViewById(0x7f10094d)).setText(EbayCurrencyUtil.formatDisplay(currencyamount, 2));
    }

    private void renderSellerMessage(ViewGroup viewgroup, com.ebay.common.model.cart.Cart.Seller seller)
    {
        View view = viewgroup.findViewById(0x7f100950);
        viewgroup = (TextView)viewgroup.findViewById(0x7f100952);
        if (!TextUtils.isEmpty(seller.note))
        {
            viewgroup.setText(seller.note);
        } else
        {
            viewgroup.setText(0x7f070c47);
        }
        view.setTag(0x7f100014, seller);
    }

    private boolean renderSellerQuantity(ViewGroup viewgroup, com.ebay.common.model.cart.Cart.LineItem lineitem)
    {
        if (lineitem != null && lineitem.isShippable(getShippingAddressSetInCart(cart.getBuyerShippingAddress())))
        {
            View view = viewgroup.findViewById(0x7f100953);
            ((TextView)viewgroup.findViewById(0x7f100955)).setText(Integer.toString(lineitem.quantity));
            TextView textview = (TextView)viewgroup.findViewById(0x7f100956);
            boolean flag;
            if (lineitem.getQuantityAvailable() > lineitem.quantity && !lineitem.isTransacted())
            {
                flag = true;
                view.setTag(lineitem.cartLineItemId);
                if (lineitem.isShipToHomeSelected())
                {
                    if (lineitem.getQuantityAvailable() > 10)
                    {
                        textview.setText(getResources().getQuantityString(0x7f08001a, 10, new Object[] {
                            Integer.valueOf(10)
                        }));
                    } else
                    {
                        textview.setText(0x7f0704b2);
                    }
                    textview.setVisibility(0);
                } else
                {
                    textview.setVisibility(8);
                }
            } else
            {
                flag = false;
                view.setClickable(false);
                textview.setVisibility(8);
            }
            viewgroup.findViewById(0x7f100953).setVisibility(0);
            return flag;
        } else
        {
            viewgroup.findViewById(0x7f100953).setVisibility(8);
            return false;
        }
    }

    private boolean renderSellerShippingMethod(ViewGroup viewgroup, com.ebay.common.model.cart.Cart.LineItem lineitem)
    {
        boolean flag1 = lineitem.isShippable(getShippingAddressSetInCart(cart.getBuyerShippingAddress()));
        Object obj1 = viewgroup.findViewById(0x7f10095d);
        ImageView imageview = (ImageView)viewgroup.findViewById(0x7f100958);
        TextView textview = (TextView)viewgroup.findViewById(0x7f100959);
        TextView textview1 = (TextView)viewgroup.findViewById(0x7f10095a);
        TextView textview3 = (TextView)viewgroup.findViewById(0x7f10095b);
        TextView textview2 = (TextView)viewgroup.findViewById(0x7f10095f);
        RadioButton radiobutton = (RadioButton)viewgroup.findViewById(0x7f100960);
        if (lineitem.gspError != null)
        {
            textview1.setText(lineitem.gspError);
            textview1.setTextColor(getResources().getColor(0x7f0d009b));
            textview1.setVisibility(0);
            textview.setVisibility(8);
            imageview.setVisibility(8);
            radiobutton.setVisibility(8);
            return false;
        }
        if (!flag1 && !lineitem.isInStorePickupSelected() && !lineitem.isLocalPickupSelected())
        {
            flag1 = false;
            viewgroup = getShippingAddressSetInCart(cart.getBuyerShippingAddress());
            if (viewgroup != null)
            {
                if (lineitem.isPOBoxAddressExcluded() && viewgroup.isPOBox())
                {
                    textview1.setText(0x7f070c73);
                } else
                if (lineitem.isPhoneNumberRequired() && TextUtils.isEmpty(((Address) (viewgroup)).addressFields.phone))
                {
                    textview1.setText(0x7f070c72);
                    flag1 = true;
                } else
                {
                    textview1.setText(0x7f070c71);
                }
            } else
            {
                textview1.setText(0x7f070c71);
            }
            textview1.setTextColor(getResources().getColor(0x7f0d009b));
            textview1.setVisibility(0);
            textview.setVisibility(8);
            imageview.setVisibility(8);
            radiobutton.setVisibility(8);
            return flag1;
        }
        boolean flag2 = false;
        boolean flag = false;
        flag1 = false;
        Object obj = lineitem.getSelectedLogisticsPlan();
        DeviceConfiguration deviceconfiguration;
        if (obj != null)
        {
            flag2 = ((com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan) (obj)).isLocalPickup();
            boolean flag3;
            if (((com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan) (obj)).isShipToHome() || ((com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan) (obj)).isGlobalShipping())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = ((com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan) (obj)).isEbayPlus();
        }
        deviceconfiguration = DeviceConfiguration.getAsync();
        flag3 = deviceconfiguration.get(com.ebay.mobile.dcs.Dcs.App.B.ebayPlus);
        if (flag1 && flag3)
        {
            atLeastOneItemHasShipping = true;
            imageview.setVisibility(0);
            radiobutton.setChecked(true);
            obj1 = ((com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan) (obj)).getSelectedPlanOption();
            viewgroup = ((com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.PlanStep.PlanOption) (obj1)).getDeliveryDateMin();
            obj1 = ((com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.PlanStep.PlanOption) (obj1)).getDeliveryDateMax();
            obj = ((com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan) (obj)).getEbayPlusCutOffTime(DateFormat.is24HourFormat(this));
            if (viewgroup != null)
            {
                viewgroup = Util.getDeliveryDateStrings(getApplicationContext(), viewgroup, ((java.util.Date) (obj1)));
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
                textview.setText(viewgroup);
                textview1.setVisibility(8);
                textview2.setVisibility(0);
                textview2.setText(0x7f070421);
            } else
            {
                textview.setVisibility(8);
            }
        } else
        if (flag2 || "CashOnPickup".equals(selectedPaymentMethod) || lineitem.isDeposit)
        {
            if (lineitem.isDeposit)
            {
                textview.setText(0x7f070c6e);
            } else
            {
                textview.setText(0x7f0700b7);
            }
            imageview.setVisibility(8);
            radiobutton.setChecked(true);
        } else
        {
            if (flag)
            {
                radiobutton.setChecked(true);
            } else
            {
                radiobutton.setChecked(false);
            }
            textview.setText(0x7f070cc4);
            imageview.setVisibility(8);
            if (!flag)
            {
                String s;
                if (lineitem.isInStorePickupOnly() && !MyApp.getDeviceConfiguration().isBopisEnabled())
                {
                    textview3.setText(0x7f070bc9);
                } else
                {
                    textview3.setText(0x7f070cc6);
                    textview2.setVisibility(0);
                    renderLogisticsPlanOptionCost(textview2, lineitem.getLogisticsPlanOfType(com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type.SHIP_TO_HOME), 0x7f0704f5);
                }
                textview3.setVisibility(0);
            } else
            if (lineitem.isShipToHomeAvailable())
            {
                atLeastOneItemHasShipping = true;
                textview3.setText(((com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan) (obj)).getName());
                textview3.setVisibility(0);
                com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.PlanStep.PlanOption planoption = ((com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan) (obj)).getSelectedPlanOption();
                if (planoption != null)
                {
                    textview2.setVisibility(0);
                    renderLogisticsPlanOptionCost(textview2, planoption.getLogisticsCost());
                }
            }
            if (deviceconfiguration.get(DcsBoolean.FastAndFree) && obj != null && ((com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan) (obj)).isFastAndFree())
            {
                s = Util.getFastAndFreeText();
                if (s != null)
                {
                    ((View) (obj1)).setVisibility(0);
                    ((TextView)((View) (obj1)).findViewById(0x7f100317)).setText(s);
                }
            }
            viewgroup = (TextView)viewgroup.findViewById(0x7f10095e);
            if (lineItemsWithShippingChanges.contains(lineitem.cartLineItemId))
            {
                ((TextView)findViewById(0x7f100917)).setText(0x7f070c82);
                showWarningView = true;
                viewgroup.setText(0x7f070c81);
                viewgroup.setTextColor(getResources().getColor(0x7f0d00fb));
                viewgroup.setVisibility(0);
            } else
            {
                viewgroup.setTextColor(getResources().getColor(0x7f0d00ef));
            }
        }
        if (lineitem.isShipToHomeAvailable() || lineitem.isLocalPickupSelected())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        return flag1;
    }

    private void renderShippingAddress(Address address)
    {
        View view = findViewById(0x7f10093d);
        if (cart.hasOnlyPickupSelectedItems())
        {
            hideShippingAddressViewElements(true);
            if (cart.hasPudoItem() && !TextUtils.isEmpty(address.addressFields.phone))
            {
                TextView textview = (TextView)findViewById(0x7f10093e);
                view.setVisibility(0);
                textview.setText(EbayPhoneNumberUtil.formatPhoneNumber(address.addressFields.phone, address.addressFields.country));
            }
            return;
        }
        view.setVisibility(8);
        hideShippingAddressViewElements(false);
        if (address != null)
        {
            Object obj = (TextView)findViewById(0x7f100935);
            ((TextView) (obj)).setText(address.addressFields.name);
            ((TextView) (obj)).setVisibility(0);
            obj = (TextView)findViewById(0x7f100936);
            ((TextView) (obj)).setText(address.addressFields.street1);
            ((TextView) (obj)).setVisibility(0);
            obj = (TextView)findViewById(0x7f100937);
            TextView textview1;
            if (!TextUtils.isEmpty(address.addressFields.street2))
            {
                ((TextView) (obj)).setVisibility(0);
                ((TextView) (obj)).setText(address.addressFields.street2);
            } else
            {
                ((TextView) (obj)).setVisibility(8);
            }
            obj = findViewById(0x7f10093a);
            textview1 = (TextView)findViewById(0x7f10093b);
            if (!TextUtils.isEmpty(address.addressFields.phone) && (cart.hasEbayNowItem() || cart.hasPudoItem()) || cart.isPhoneNumberRequired())
            {
                ((View) (obj)).setVisibility(0);
                textview1.setText(EbayPhoneNumberUtil.formatPhoneNumber(address.addressFields.phone, address.addressFields.country));
                obj = findViewById(0x7f10093c);
                if (cart.hasEbayNowItem())
                {
                    ((View) (obj)).setVisibility(0);
                } else
                {
                    ((View) (obj)).setVisibility(8);
                }
            } else
            {
                ((View) (obj)).setVisibility(8);
            }
            obj = (TextView)findViewById(0x7f100938);
            ((TextView) (obj)).setText(address.addressFields.getCityStatePostalString());
            ((TextView) (obj)).setVisibility(0);
            address = (TextView)findViewById(0x7f100939);
            if (isEbnAvailableIfRefinementPostalCodeIsShipTo() && !cart.hasEbayNowAvailable())
            {
                setHtmlTextFromResource(address, 0x7f070cb2);
                address.setVisibility(0);
                return;
            } else
            {
                address.setVisibility(8);
                return;
            }
        } else
        {
            address = (TextView)findViewById(0x7f100935);
            address.setText(0x7f070c78);
            address.setVisibility(0);
            findViewById(0x7f100936).setVisibility(8);
            findViewById(0x7f100937).setVisibility(8);
            findViewById(0x7f100938).setVisibility(8);
            return;
        }
    }

    private void renderSpecifics(ViewGroup viewgroup, com.ebay.common.model.cart.Cart.LineItem lineitem)
    {
        lineitem = getEekForItem(lineitem);
        if (lineitem == null)
        {
            return;
        } else
        {
            TextView textview = (TextView)inflater.inflate(0x7f0302c9, viewgroup, false);
            textview.setText(lineitem.getDisplayString());
            viewgroup.addView(textview);
            return;
        }
    }

    private void resolveGspLineItemErrors()
    {
        if (cart != null && cart.lineItems != null && cart.lineItems.size() != 0) goto _L2; else goto _L1
_L1:
        List list;
        return;
_L2:
        if ((list = cart.errors) == null || list.size() == 0)
        {
            continue;
        }
        HashMap hashmap = new HashMap();
        hashmap.put("SCE_ERROR_10035", Integer.valueOf(0x7f070cc0));
        hashmap.put("SCE_ERROR_10036", Integer.valueOf(0x7f070cbf));
        hashmap.put("SCE_ERROR_10037", Integer.valueOf(0x7f070cc2));
        Iterator iterator = list.iterator();
label0:
        do
        {
            String s;
            String s1;
            String s2;
            com.ebay.common.model.cart.JsonModel.OperationError operationerror;
            int i;
label1:
            do
            {
                do
                {
                    do
                    {
                        if (!iterator.hasNext())
                        {
                            continue label0;
                        }
                        operationerror = (com.ebay.common.model.cart.JsonModel.OperationError)iterator.next();
                    } while (!TextUtils.equals("201", operationerror.getErrorCode()));
                    s1 = null;
                    s = null;
                    s2 = null;
                    Iterator iterator1 = operationerror.parameters.iterator();
                    do
                    {
                        if (!iterator1.hasNext())
                        {
                            break;
                        }
                        com.ebay.common.model.cart.Cart.Property property = (com.ebay.common.model.cart.Cart.Property)iterator1.next();
                        if (property.name.equals("shippingErrorCode"))
                        {
                            s1 = property.value.trim();
                        } else
                        if (property.name.equals("AffectedLineItems"))
                        {
                            s = property.value.trim();
                        } else
                        if (property.name.equals("ORDER_TOTAL_ITEM_LIMIT"))
                        {
                            s2 = property.value.trim();
                        }
                    } while (true);
                } while (s1 == null);
                boolean flag = false;
                Iterator iterator2 = hashmap.keySet().iterator();
                do
                {
                    i = ((flag) ? 1 : 0);
                    if (!iterator2.hasNext())
                    {
                        continue label1;
                    }
                } while (!((String)iterator2.next()).equals(s1));
                i = 1;
            } while (!i || s == null || s.length() == 0);
            i = ((Integer)hashmap.get(s1)).intValue();
            String as[];
            int j;
            if (i == 0x7f070cc0)
            {
                if (s2 == null || s2.length() == 0)
                {
                    i = 0x7f070cc1;
                }
                s1 = getString(i, new Object[] {
                    s2
                });
            } else
            {
                s1 = getString(i);
            }
            as = s.replace("[", "").replace("]", "").split(",");
            j = as.length;
            i = 0;
            while (i < j) 
            {
                Object obj = as[i].replace("\"", "");
                obj = cart.getLineItemByCartLineItemId(((String) (obj)));
                if (obj != null && operationerror != null)
                {
                    obj.gspError = s1;
                }
                i++;
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
    }

    private boolean resultHasProxRiskRedirect(String s)
    {
        if (cart == null || !cart.isProx())
        {
            return false;
        }
        if ("196".equals(s) || "334".equals(s))
        {
            s = cart.cartPaymentMethods.getSelectedPaymentMethod();
            if (s == null)
            {
                return false;
            }
            if (s.isCreditCard() || s.isDirectDebit() || s.isPayPal() || s.isPui())
            {
                String s1 = cart.getValueForErrorParamater("errorAction");
                s1 = cart.getActionUrlForErrorAction(s1);
                if (s1 != null)
                {
                    Intent intent = new Intent(this, com/ebay/mobile/checkout/prox/PayPalIdentityActivity);
                    if (s.isCreditCard())
                    {
                        s = getString(0x7f070c4f);
                    } else
                    {
                        s = getString(0x7f070c50);
                    }
                    intent.putExtra("android.intent.extra.TITLE", s);
                    intent.putExtra("url", s1);
                    intent.putExtra("use_sso", true);
                    intent.putExtra("back", true);
                    intent.putExtra(ShowWebViewFragment.EXTRA_NUM_HISTORY_TO_SKIP, 0);
                    intent.putExtra("add_device_id", false);
                    intent.putExtra("attachOnInflate", false);
                    startActivityForResult(intent, 0x7759b6);
                    return true;
                }
            }
        }
        return false;
    }

    private void routeForInitPayment()
    {
        if (cart == null)
        {
            startCheckout();
            return;
        }
        isInitializationSequenceComplete = true;
        if (cart.isProx())
        {
            if (!isReadyToPayForOrder() && paymentMethodCount == 1 && !"PayPal".equals(selectedPaymentMethod))
            {
                apiSetPaymentInstrument(selectedPaymentMethod, null, null);
                return;
            } else
            {
                updateUi(true);
                return;
            }
        }
        if (isPayPalAvailable() && isRememberMeActive())
        {
            selectedPaymentMethod = "PayPal";
            apiRequestTokenForService(MyApp.getPrefs().getCurrentUser());
            return;
        }
        if (paymentMethodCount == 1)
        {
            if (!selectedPaymentMethod.equals("PayPal"))
            {
                apiInitPaymentForPrepare();
                return;
            }
            List list = getBestLogisticsPlans();
            if (list != null)
            {
                apiUpdateShippingMethod(list);
                return;
            } else
            {
                updateUi(true);
                return;
            }
        } else
        {
            updateUi(true);
            return;
        }
    }

    private void sendCanceledImpression()
    {
        TrackingData trackingdata = new TrackingData("CheckoutCanceled", TrackingType.EVENT);
        addCommonTrackingTags(trackingdata);
        trackingdata.send(this);
    }

    private void sendCheckoutPageImpression(Intent intent)
    {
        TrackingData trackingdata = new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION);
        trackingdata.addSourceIdentification(intent);
        addCommonTrackingTags(trackingdata);
        trackingdata.send(this);
    }

    private void sendErrorCodeImpression(String s)
    {
        TrackingData trackingdata = new TrackingData("PayPalError", TrackingType.EVENT);
        trackingdata.addKeyValuePair("errCode", s);
        trackingdata.send(this);
    }

    private boolean setDefaultPaymentMethod()
    {
        String s = null;
        paymentMethodCount = 0;
        if (isCopAvailable())
        {
            paymentMethodCount = paymentMethodCount + 1;
            s = "CashOnPickup";
        }
        if (isEftAvailable())
        {
            paymentMethodCount = paymentMethodCount + 1;
            s = "MoneyXferAcceptedInCheckout";
        }
        if (isCreditCardAvailable())
        {
            paymentMethodCount = paymentMethodCount + 1;
            s = "CreditCard";
        }
        if (isDirectDebitAvailable())
        {
            paymentMethodCount = paymentMethodCount + 1;
            s = "DirectDebit";
        }
        if (isPuiAvailable())
        {
            paymentMethodCount = paymentMethodCount + 1;
            s = "PayUponInvoice";
        }
        if (isPayPalAvailable())
        {
            paymentMethodCount = paymentMethodCount + 1;
            String s1 = "PayPal";
            s = s1;
            if (isPayPalGuestXoAvailable())
            {
                paymentMethodCount = paymentMethodCount + 1;
                s = s1;
            }
        }
        if (cart.isPaymentInstrumentSelected())
        {
            selectedPaymentMethod = cart.cartPaymentMethods.getSelectedPaymentMethod().getName();
        } else
        if (paymentMethodCount == 1)
        {
            selectedPaymentMethod = s;
        } else
        {
            selectedPaymentMethod = null;
        }
        return paymentMethodCount > 0;
    }

    private void setHtmlTextFromResource(TextView textview, int i)
    {
        textview.setText(Html.fromHtml(getString(i)));
    }

    private void setSellerLabel(String s, TextView textview)
    {
        if (!isShoppingCartCheckout())
        {
            textview.setText(String.format(getString(0x7f070c68), new Object[] {
                s
            }));
            textview.setVisibility(0);
            return;
        }
        for (Iterator iterator = shopCartItems.values().iterator(); iterator.hasNext();)
        {
            CheckoutItem checkoutitem = (CheckoutItem)iterator.next();
            if (checkoutitem.sellerUserId.equals(s))
            {
                textview.setText(getString(0x7f070aa7, new Object[] {
                    checkoutitem.sellerUserId, Long.valueOf(checkoutitem.sellerFeedbackScore)
                }));
                textview.setVisibility(0);
                return;
            }
        }

        textview.setVisibility(4);
    }

    private void showCancelCheckoutWarningDialog()
    {
        int i1 = 0x7f0700ad;
        int j1 = 0x7f0700ae;
        int k1 = 0x7f070738;
        int l1 = 0x7f0701cc;
        int l = j1;
        int k = l1;
        int j = k1;
        int i = i1;
        if (MyApp.getPrefs().getCurrentSite().equals(EbaySite.DE))
        {
            l = j1;
            k = l1;
            j = k1;
            i = i1;
            if (cart != null)
            {
                l = j1;
                k = l1;
                j = k1;
                i = i1;
                if (!cart.hasTransactedItem())
                {
                    i = 0x7f0700df;
                    l = 0x7f0700e0;
                    j = 0x7f070c21;
                    k = 0x7f0700f0;
                }
            }
        }
        (new com.ebay.app.AlertDialogFragment.Builder()).setTitle(i).setMessage(l).setPositiveButton(j).setNegativeButton(k).createFromActivity(1).show(getFragmentManager(), null);
    }

    private void showDynamicAlertDialog(String s, String s1, boolean flag)
    {
        if (s1 != null)
        {
            dialogManager.showDynamicAlertDialog(s, s1, flag);
            aborted = flag;
        }
    }

    private void showEbayPlusCutOffError()
    {
        dialogManager.showDynamicAlertDialog(getString(0x7f070c9e), getString(0x7f070c9d), new android.content.DialogInterface.OnClickListener() {

            final CheckoutActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                enableProgressDialog(true, false);
                apiRefreshCart(cart.cartId);
            }

            
            {
                this$0 = CheckoutActivity.this;
                super();
            }
        }, new android.content.DialogInterface.OnCancelListener() {

            final CheckoutActivity this$0;

            public void onCancel(DialogInterface dialoginterface)
            {
                enableProgressDialog(true, false);
                apiRefreshCart(cart.cartId);
            }

            
            {
                this$0 = CheckoutActivity.this;
                super();
            }
        });
    }

    private boolean showEbnForLineItem(com.ebay.common.model.cart.Cart.LineItem lineitem)
    {
        return DeviceConfiguration.getAsync().get(DcsBoolean.eBayNow) && lineitem.isEbayNowAvailable();
    }

    private void showIncentivesRequirePayPalAlert()
    {
        int i;
        if (MyApp.getPrefs().getCurrentSite().equals(EbaySite.US))
        {
            i = 0x7f070c31;
        } else
        {
            i = 0x7f0700e7;
        }
        showDynamicAlertDialog(null, getString(i), false);
    }

    private void siteSpeedFinishPayment()
    {
        paymentSpeed.primaryLoaded();
        paymentSpeed.allLoaded();
        paymentSpeed.upload(getEbayContext());
        paymentSpeed = SiteSpeedActivityUtil.SITE_SPEED_DATA_NO_OP;
    }

    private void siteSpeedStartPayment()
    {
        paymentSpeed = SiteSpeedActivityUtil.createSiteSpeedData("PaymentSent");
        paymentSpeed.viewAppeared();
    }

    private void startCheckout()
    {
        initializeCheckout();
        isInitializationSequenceComplete = false;
        payPalCheckoutRefreshUrl = null;
        payPalSessionStartTime = 0L;
        if (DeviceConfiguration.getAsync().get(DcsNautilusBoolean.PayPalDyson))
        {
            apiInitDyson();
            return;
        } else
        {
            apiGetAddresses();
            return;
        }
    }

    private void startPayPalActivity(String s)
    {
        Object obj = Uri.parse(s).buildUpon();
        if (useMec2 && (payPalCheckoutDetails == null || !TextUtils.equals(s, payPalCheckoutDetails.getChangeFundingSourceUrl())))
        {
            addMec2QueryArgumentsToUri(((android.net.Uri.Builder) (obj)));
        }
        ((android.net.Uri.Builder) (obj)).appendQueryParameter("iaf_token", serviceProviderToken);
        s = new Intent(this, com/ebay/mobile/checkout/PayPalActivity);
        s.putExtra("guestXO", useGuestXo);
        s.putExtra("url", ((android.net.Uri.Builder) (obj)).build().toString());
        s.putExtra("app_id", checkoutCartApi.payPalAppId);
        obj = MyApp.getPrefs();
        String s1 = ((Preferences) (obj)).getPayPalCheckoutAuthToken();
        if (!TextUtils.isEmpty(s1))
        {
            s.putExtra("rm_token", s1);
        }
        s1 = ((Preferences) (obj)).getPayPalCheckoutSessionId();
        if (!TextUtils.isEmpty(s1))
        {
            s.putExtra("session_id", s1);
        }
        s1 = ((Preferences) (obj)).getPayPalCheckoutVisitorId();
        if (!TextUtils.isEmpty(s1))
        {
            s.putExtra("visitor_id", s1);
        }
        obj = ((Preferences) (obj)).getPayPalCheckoutFundingSourceId();
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            s.putExtra("fs_id", ((String) (obj)));
        }
        if (checkoutCartApi.riskPayload != null)
        {
            s.putExtra("risk_payload", checkoutCartApi.riskPayload.toString());
        }
        startActivityForResult(s, 1234);
    }

    private void startPaymentMethodSelectionActivity()
    {
        if (cart.isProx())
        {
            startActivityForResult(new Intent(this, com/ebay/mobile/checkout/prox/PaymentMethodActivity), 1245);
            return;
        } else
        {
            startActivityForResult(new Intent(this, com/ebay/mobile/checkout/PaymentMethodActivity), 1237);
            return;
        }
    }

    private Map trackCheckoutTransactions()
    {
        HashMap hashmap = new HashMap();
        if (item != null)
        {
            com.ebay.common.model.cart.Cart.LineItem lineitem = (com.ebay.common.model.cart.Cart.LineItem)cart.lineItems.get(0);
            Boolean boolean1 = (Boolean)lineItemIdToIsTransacted.get(lineitem.cartLineItemId);
            if (boolean1 != null && !boolean1.booleanValue())
            {
                com.ebay.mobile.viewitem.ItemViewBidTracking.Roi roi = new com.ebay.mobile.viewitem.ItemViewBidTracking.Roi(checkoutCartApi.iafToken, cart.total.toItemCurrency());
                ItemViewBidTracking.sendBidStateForCheckout(this, item, inReferrer, bidSource, roi, lineitem.postPurchaseTransactionId, itemDataManager.isInMyEbayBidList(item.id), item.watched, lineitem.quantity, true);
                hashmap.put("itm", Long.toString(item.id));
                hashmap.put("bti", lineitem.postPurchaseTransactionId);
            }
        } else
        if (isShoppingCartCheckout())
        {
            Iterator iterator = cart.lineItems.iterator();
            while (iterator.hasNext()) 
            {
                com.ebay.common.model.cart.Cart.LineItem lineitem1 = (com.ebay.common.model.cart.Cart.LineItem)iterator.next();
                if (!lineitem1.isInvoiced())
                {
                    Object obj = ShoppingCart.createItemKey(lineitem1.ebayItemId.longValue(), lineitem1.variationId, lineitem1.transactionId);
                    if (shopCartItems.containsKey(obj))
                    {
                        obj = (CheckoutItem)shopCartItems.get(obj);
                        boolean flag2 = false;
                        boolean flag = false;
                        boolean flag1;
                        if (((CheckoutItem) (obj)).autoPay)
                        {
                            flag1 = true;
                        } else
                        {
                            flag1 = flag2;
                            if (!((CheckoutItem) (obj)).isTransacted)
                            {
                                flag = true;
                                flag1 = flag2;
                            }
                        }
                        if (flag1 || flag)
                        {
                            com.ebay.mobile.viewitem.ItemViewBidTracking.Roi roi1 = new com.ebay.mobile.viewitem.ItemViewBidTracking.Roi(checkoutCartApi.iafToken, cart.total.toItemCurrency());
                            ItemViewBidTracking.sendBidStateForCheckout(this, ((CheckoutItem) (obj)), inReferrer, bidSource, roi1, lineitem1.postPurchaseTransactionId, itemDataManager.isInMyEbayBidList(((CheckoutItem) (obj)).id), ((CheckoutItem) (obj)).watched, lineitem1.quantity, flag1);
                            hashmap.put("itm", Long.toString(lineitem1.ebayItemId.longValue()));
                            hashmap.put("bti", lineitem1.postPurchaseTransactionId);
                        }
                    }
                }
            }
        }
        return hashmap;
    }

    private void updateEbayNowDeliveryInstructions(final String sellerUserIdentifier, String s)
    {
        Authentication authentication = MyApp.getPrefs().getAuthentication();
        if (authentication != null)
        {
            enableProgressDialog(true, false);
            Address address = getShippingAddressSetInCart(cart.getBuyerShippingAddress());
            getDataManagerContainer().initialize(new com.ebay.common.net.api.local.EbayNowValidateTimeSlotDataManager.KeyParams(authentication.iafToken, deliverySchedulingParams.selectedReservationToken, address.addressFields.phone, s), new com.ebay.common.net.api.local.EbayNowValidateTimeSlotDataManager.Observer() {

                final CheckoutActivity this$0;
                final String val$sellerUserIdentifier;

                public void onValidateTimeSlotComplete(EbayNowValidateTimeSlotDataManager ebaynowvalidatetimeslotdatamanager, Content content)
                {
                    content = content.getStatus();
                    if (content.hasError())
                    {
                        enableProgressDialog(false, false);
                        dialogManager.showDynamicAlertDialog(getString(0x7f070130), MyApp.getDisplayableServiceError(getEbayContext(), content), false);
                        return;
                    }
                    content = ebaynowvalidatetimeslotdatamanager.getMappedException();
                    if (content == null) goto _L2; else goto _L1
_L1:
                    dialogManager.showDynamicAlertDialog(getString(0x7f070130), getString(0x7f070cab), false);
                    Log.e("CheckoutActivity", (new StringBuilder()).append("onValidateTimeSlotComplete: mappedException: ").append(((EbayNowMappedException) (content)).errorId).append(", ").append(((EbayNowMappedException) (content)).message).toString());
_L4:
                    enableProgressDialog(false, false);
                    return;
_L2:
                    ebaynowvalidatetimeslotdatamanager = ebaynowvalidatetimeslotdatamanager.getParams();
                    deliverySchedulingParams.deliveryInstructions = ((com.ebay.common.net.api.local.EbayNowValidateTimeSlotDataManager.KeyParams) (ebaynowvalidatetimeslotdatamanager)).deliveryNotes;
                    ebaynowvalidatetimeslotdatamanager = (com.ebay.common.model.cart.Cart.Seller)cart.sellers.get(sellerUserIdentifier);
                    if (ebaynowvalidatetimeslotdatamanager == null)
                    {
                        continue; /* Loop/switch isn't completed */
                    }
                    ebaynowvalidatetimeslotdatamanager = ((com.ebay.common.model.cart.Cart.Seller) (ebaynowvalidatetimeslotdatamanager)).cartLineItemIds.iterator();
                    do
                    {
                        if (!ebaynowvalidatetimeslotdatamanager.hasNext())
                        {
                            continue; /* Loop/switch isn't completed */
                        }
                        content = (String)ebaynowvalidatetimeslotdatamanager.next();
                    } while (!cart.getLineItemByCartLineItemId(content).isEbayNowSelected());
                    break; /* Loop/switch isn't completed */
                    if (true) goto _L4; else goto _L3
_L3:
                    apiUpdateDeliveryReservation(content, deliverySchedulingParams);
                    return;
                }

            
            {
                this$0 = CheckoutActivity.this;
                sellerUserIdentifier = s;
                super();
            }
            });
        }
    }

    private void updatePaidStatusAndUnWatchItem(CheckoutItem checkoutitem, String s, List list, UserCache usercache, String s1)
    {
        if (checkoutitem.watched)
        {
            (new UserCacheChangeWatchNetLoader(BaseCheckoutActivity.Operation.POST_PAYMENT_WATCH_LIST_UPDATE.ordinal(), s1, this, checkoutitem.id, false, list)).execute();
        }
        if (selectedPaymentMethod.equals("PayPal"))
        {
            usercache.addToPaidStatus(String.valueOf(checkoutitem.id), s, "MarkedAsPaid", null);
            return;
        } else
        {
            usercache.addToPaidStatus(String.valueOf(checkoutitem.id), s, "PaymentPending", null);
            return;
        }
    }

    private void updateUi(boolean flag)
    {
        boolean flag3;
        flag3 = true;
        break MISSING_BLOCK_LABEL_3;
        if (!aborted && cart != null)
        {
            boolean flag1;
            boolean flag2;
            if (cart.isShippable(getShippingAddressSetInCart(cart.getBuyerShippingAddress())) && cart.areAllBopisItemsInStock())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            renderOrderSummary();
            renderPaymentMethod(payPalCheckoutDetails);
            renderIncentives(cart.getIncentives());
            renderCharities();
            renderShippingAddress(cart.getBuyerShippingAddress());
            atLeastOneItemHasShipping = false;
            showWarningView = false;
            preventPayment = false;
            renderItems(inflater);
            if (!atLeastOneItemHasShipping && flag1 && "CashOnPickup".equals(selectedPaymentMethod))
            {
                findViewById(0x7f100932).setVisibility(0);
                findViewById(0x7f100934).setVisibility(8);
                findViewById(0x7f10093a).setVisibility(8);
                Object obj;
                if (item != null && !TextUtils.isEmpty(item.location))
                {
                    String s = String.format(getString(0x7f070c41), new Object[] {
                        item.location
                    });
                    TextView textview = (TextView)findViewById(0x7f100933);
                    textview.setText(s);
                    textview.setVisibility(0);
                } else
                {
                    findViewById(0x7f100933).setVisibility(8);
                }
                alertView.setVisibility(8);
            } else
            {
                findViewById(0x7f100932).setVisibility(8);
                findViewById(0x7f100934).setVisibility(0);
                findViewById(0x7f100934).setOnClickListener(this);
                View view = findViewById(0x7f10093a);
                if (view.getVisibility() == 0)
                {
                    view.setOnClickListener(this);
                }
                if (!flag1)
                {
                    alertView.setVisibility(0);
                    findViewById(0x7f10091d).setVisibility(8);
                } else
                {
                    alertView.setVisibility(8);
                    findViewById(0x7f10091d).setVisibility(0);
                }
            }
            if (showWarningView)
            {
                warningView.setVisibility(0);
            } else
            {
                warningView.setVisibility(8);
            }
            obj = findViewById(0x7f10091b);
            if (!preventPayment)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            ((View) (obj)).setClickable(flag2);
            obj = findViewById(0x7f10091c);
            if (!preventPayment)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            ((View) (obj)).setClickable(flag2);
            obj = findViewById(0x7f10091e);
            if (!preventPayment)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            ((View) (obj)).setClickable(flag2);
            obj = findViewById(0x7f100922);
            if (!preventPayment)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            ((View) (obj)).setClickable(flag2);
            obj = placeOrderButton;
            if (!preventPayment)
            {
                flag2 = flag3;
            } else
            {
                flag2 = false;
            }
            ((Button) (obj)).setClickable(flag2);
            if (isPiRequired())
            {
                findViewById(0x7f100940).setVisibility(0);
            }
            if (flag)
            {
                enableProgressDialog(false, false);
            }
            if (isReadyToPayForOrder())
            {
                SiteSpeedActivityUtil.primaryAndAllLoaded(this);
                return;
            }
        }
        return;
    }

    private boolean willPhoneNumberEditFixCart(Address address)
    {
        return address != null && cart.isPhoneNumberRequired() && TextUtils.isEmpty(address.addressFields.phone);
    }

    protected void closeMimsScope()
    {
        if (activeMimsScope == null)
        {
            return;
        } else
        {
            MimsUtil.releaseScopedProvider(activeMimsScope);
            return;
        }
    }

    public CurrencyAmount getConvertedPrice(CurrencyAmount currencyamount)
    {
        if (currencyamount != null)
        {
            CurrencyConversionRate currencyconversionrate;
            if (conversionRate != null && conversionRate.isExchangeRateAvailable)
            {
                currencyconversionrate = conversionRate;
            } else
            {
                currencyconversionrate = CurrencyConversionCache.getConversionRate(getEbayContext(), currencyamount.getCurrencyCode());
            }
            if (currencyconversionrate != null && currencyconversionrate.isExchangeRateAvailable)
            {
                String s = MyApp.getPrefs().getCurrentCountry().getCurrency().getCurrencyCode();
                return (new CurrencyAmount(currencyamount.getValueAsDouble(), s)).multiplyBy(currencyconversionrate.conversionFactor);
            }
        }
        return CurrencyAmount.ZERO;
    }

    public String getTrackingEventName()
    {
        return "CheckoutPage";
    }

    protected boolean isProxEnabled()
    {
        boolean flag = super.isProxEnabled();
        return flag && com.ebay.mobile.experimentation.Experiments.BooleanExperimentDefinition.isEnabled(showProxTreatment, flag);
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (intent != null && intent.hasExtra("com.ebay.mobile.analytics.sid"))
        {
            sendCheckoutPageImpression(intent);
        }
        i;
        JVM INSTR lookupswitch 14: default 148
    //                   1234: 514
    //                   1235: 467
    //                   1236: 698
    //                   1237: 149
    //                   1238: 1226
    //                   1239: 1270
    //                   1240: 786
    //                   1241: 866
    //                   1242: 1129
    //                   1243: 482
    //                   1244: 713
    //                   1245: 310
    //                   7821746: 316
    //                   7821750: 423;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15
_L1:
        return;
_L5:
        if (j == -1 || j == 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        switch (j)
        {
        default:
            return;

        case 3: // '\003'
            continue; /* Loop/switch isn't completed */

        case 1: // '\001'
            if (!paymentMethodCompleted || selectedPaymentMethod == null || !selectedPaymentMethod.equals("PayPal"))
            {
                apiRequestTokenForService(MyApp.getPrefs().getCurrentUser());
                return;
            }
            break;

        case 2: // '\002'
            if (!paymentMethodCompleted || selectedPaymentMethod == null || !selectedPaymentMethod.equals("MoneyXferAcceptedInCheckout"))
            {
                selectedPaymentMethod = "MoneyXferAcceptedInCheckout";
                apiInitPaymentForPrepare();
                return;
            }
            break;
        }
        continue; /* Loop/switch isn't completed */
        if (paymentMethodCompleted && selectedPaymentMethod != null && selectedPaymentMethod.equals("CashOnPickup")) goto _L1; else goto _L16
_L16:
        selectedPaymentMethod = "CashOnPickup";
        apiInitPaymentForPrepare();
        return;
        if (j != 0) goto _L1; else goto _L17
_L17:
        checkForPayPalSessionTimeout();
        return;
_L13:
        updateUi(true);
        return;
_L14:
        if (j == -1 && intent != null)
        {
            apiSetPaymentInstrument("PayPal", intent.getStringExtra("payPalLinkId"), null);
            return;
        }
        if (j == 1)
        {
            MyApp.signOutForIafTokenFailure(this);
            finish();
            return;
        }
        if (j == 2)
        {
            enableProgressDialog(false, false);
            dialogManager.showDynamicAlertDialog(getString(0x7f070130), getString(0x7f070c07), false);
            return;
        }
        if (j == 3)
        {
            enableProgressDialog(false, false);
            dialogManager.showDynamicAlertDialog(getString(0x7f070130), getString(0x7f070814), false);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L15:
        if (j == 4)
        {
            if (cart.isProx())
            {
                startPaymentMethodSelectionActivity();
            }
        } else
        if (j != -1)
        {
            cart.unselectPaymentMethod();
            handleCartResponse();
        }
        updateUi(true);
        return;
_L3:
        if (j == -1)
        {
            updateUi(true);
            apiInitPaymentForRefresh();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L11:
        if (j == -1 && intent != null)
        {
            updateUi(true);
            apiSetShippingAddress(BaseCheckoutActivity.Operation.SET_SHIPPING_ADDRESS, (Address)intent.getSerializableExtra("address_to_edit"));
            return;
        }
        if (true) goto _L1; else goto _L2
_L2:
        if (j == 3)
        {
            selectedPaymentMethod = "PayPal";
            paymentMethodCompleted = true;
            useGuestXo = false;
            payPalSessionStartTime = System.currentTimeMillis();
            if (useMec2 && intent != null)
            {
                payPalCheckoutRefreshUrl = addRepurchaseQueryParameterIfNecessary(intent.getStringExtra("url"));
                initializePayPalCheckout(payPalCheckoutRefreshUrl);
                return;
            } else
            {
                initializePayPalCheckout(paymentSession.returnUrl);
                return;
            }
        }
        if (j == 2)
        {
            MyApp.getPrefs().clearPayPalCheckoutSettings();
            setDefaultPaymentMethod();
            startCheckout();
            return;
        }
        if (j == 4 && intent != null)
        {
            selectedPaymentMethod = "PayPal";
            paymentMethodCompleted = true;
            useGuestXo = true;
            payPalSessionStartTime = System.currentTimeMillis();
            if (useMec2)
            {
                payPalCheckoutRefreshUrl = addRepurchaseQueryParameterIfNecessary(intent.getStringExtra("url"));
                initializePayPalCheckout(payPalCheckoutRefreshUrl);
                return;
            } else
            {
                initializePayPalCheckout(paymentSession.returnUrl);
                return;
            }
        } else
        {
            enableProgressDialog(false, false);
            checkForPayPalSessionTimeout();
            return;
        }
_L4:
        updateUi(true);
        if (j == -1)
        {
            apiInitPaymentForRefresh();
            return;
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L12:
        if (j == -1)
        {
            apiInitPaymentForRefresh();
        }
        if (cart.hasDonation())
        {
            intent = new TrackingData(getTrackingEventName(), TrackingType.EVENT);
            intent.addKeyValuePair("charityID", com.ebay.common.model.cart.Cart.DonationHelper.getDonationNonprofitId(cart));
            intent.addKeyValuePair("donate", com.ebay.common.model.cart.Cart.DonationHelper.getDonationAmountAsString(cart));
            intent.send(this);
        }
        updateUi(true);
        return;
_L8:
        if (j == -1 && intent != null)
        {
            String s = intent.getStringExtra("cart_line_item_id");
            intent = intent.getStringExtra("selected_plan_option_id");
            if (!TextUtils.isEmpty(s) && !TextUtils.isEmpty(intent) && !cart.getLineItemByCartLineItemId(s).getSelectedLogisticsPlan().getSelectedPlanOption().logisticsOptionIdentifier.equals(intent))
            {
                apiUpdateShippingMethod(s, com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type.SHIP_TO_HOME.longName, intent);
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
_L9:
        if (j == -1 && intent != null)
        {
            Object obj = (InventoryInfo)intent.getParcelableExtra("inventory_info");
            if (obj != null)
            {
                intent = ((InventoryInfo) (obj)).getSelectedStore();
                if (intent != null)
                {
                    intent = ((StoreAvailability) (intent)).locationId;
                    if (intent != null)
                    {
                        com.ebay.common.model.cart.Cart.LineItem lineitem = cart.getLineItemByCartLineItemId(((InventoryInfo) (obj)).getCheckoutLineItemId());
                        if (lineitem.isPickupAndDropoffAvailable())
                        {
                            Object obj1 = cart.getSellerUserIdFromLineItem(((InventoryInfo) (obj)).getCheckoutLineItemId());
                            obj1 = ((com.ebay.common.model.cart.Cart.Seller)cart.sellers.get(obj1)).cartLineItemIds.iterator();
                            do
                            {
                                if (!((Iterator) (obj1)).hasNext())
                                {
                                    break;
                                }
                                String s3 = (String)((Iterator) (obj1)).next();
                                if (cart.getLineItemByCartLineItemId(s3).isPickupAndDropoffAvailable())
                                {
                                    setInventoryInfo(s3, ((InventoryInfo) (obj)));
                                }
                            } while (true);
                        } else
                        if (lineitem.isInStorePickupAvailable())
                        {
                            setInventoryInfo(lineitem.cartLineItemId, ((InventoryInfo) (obj)));
                        }
                        com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan logisticsplan = lineitem.getSelectedLogisticsPlan();
                        if (!logisticsplan.isInStorePickup() && !logisticsplan.isPickupAndDropoff() || !intent.equals(lineitem.getPickupStoreId()))
                        {
                            obj = ((InventoryInfo) (obj)).getLogisticsPlanType();
                            if (obj == com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type.ISPU || obj == com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type.PUDO)
                            {
                                com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan logisticsplan1 = lineitem.getLogisticsPlanOfType(((com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type) (obj)));
                                apiUpdatePickupMethod(lineitem.cartLineItemId, logisticsplan1.getFirstPlanOption().logisticsOptionIdentifier, intent, ((com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type) (obj)));
                                return;
                            }
                        }
                    }
                }
            }
        }
        continue; /* Loop/switch isn't completed */
_L10:
        if (j == -1 && intent != null)
        {
            com.ebay.common.model.cart.Cart.LineItem lineitem1 = (com.ebay.common.model.cart.Cart.LineItem)intent.getSerializableExtra("line_item");
            intent = (DeliverySchedulingParams)intent.getParcelableExtra("params");
            if (intent != null && ((DeliverySchedulingParams) (intent)).selectedReservationToken != null && (!lineitem1.isEbayNowSelected() || deliverySchedulingParams.selectedReservationToken == null || !((DeliverySchedulingParams) (intent)).selectedReservationToken.equals(deliverySchedulingParams.selectedReservationToken)))
            {
                deliverySchedulingParams = intent;
                apiUpdateDeliveryReservation(lineitem1.cartLineItemId, deliverySchedulingParams);
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (j == -1 && intent != null)
        {
            i = intent.getIntExtra("quantity_selected", -1);
            intent = intent.getStringExtra("ebay_item_id");
            if (!TextUtils.isEmpty(intent) && i > 0)
            {
                apiUpdateItemQuantity(intent, i);
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
_L7:
        if (j == -1 && intent != null)
        {
            String s1 = intent.getStringExtra("message_to_seller");
            String s2 = intent.getStringExtra("seller_id");
            if (!intent.getBooleanExtra("is_ebay_now", false))
            {
                if (!TextUtils.isEmpty(s2))
                {
                    intent = s1;
                    if (TextUtils.isEmpty(s1))
                    {
                        intent = null;
                    }
                    apiUpdateItemNote(s2, intent);
                    return;
                }
            } else
            {
                updateEbayNowDeliveryInstructions(s2, s1);
                return;
            }
        }
        if (true) goto _L1; else goto _L18
_L18:
    }

    public void onBackPressed()
    {
        showCancelCheckoutWarningDialog();
    }

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        if (!shouldHandleClick)
        {
            return;
        }
        shouldHandleClick = false;
        enableClickHandler.postDelayed(enableClick, 500L);
        switch (compoundbutton.getId())
        {
        default:
            return;

        case 2131757349: 
            apiToggleRememberPaymentInstrument(flag);
            break;
        }
    }

    public void onClick(View view)
    {
        if (shouldHandleClick) goto _L2; else goto _L1
_L1:
        return;
_L2:
        shouldHandleClick = false;
        enableClickHandler.postDelayed(enableClick, 500L);
        view.getId();
        JVM INSTR lookupswitch 13: default 148
    //                   2131757339: 149
    //                   2131757340: 834
    //                   2131757342: 866
    //                   2131757346: 919
    //                   2131757350: 732
    //                   2131757356: 773
    //                   2131757364: 583
    //                   2131757370: 683
    //                   2131757377: 1121
    //                   2131757381: 802
    //                   2131757392: 980
    //                   2131757395: 964
    //                   2131757399: 154;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16
_L11:
        break; /* Loop/switch isn't completed */
_L12:
        continue; /* Loop/switch isn't completed */
_L3:
        return;
_L4:
        startPaymentMethodSelectionActivity();
        return;
_L16:
        Object obj = (String)view.getTag();
        Object obj1 = cart.getLineItemByCartLineItemId(((String) (obj)));
        int i = ((Integer)view.getTag(0x7f100015)).intValue();
        view = getShippingAddressSetInCart(cart.getBuyerShippingAddress());
        if (willPhoneNumberEditFixCart(view) || 3 == i && TextUtils.isEmpty(cart.getBuyerShippingAddress().addressFields.phone))
        {
            obj = new Intent(this, com/ebay/mobile/checkout/AddressEditActivity);
            ((Intent) (obj)).putExtra("address_to_edit", view);
            ((Intent) (obj)).putExtra("address_focus_phone", true);
            startActivityForResult(((Intent) (obj)), 1243);
            return;
        }
        if (lineItemsWithShippingChanges.contains(((com.ebay.common.model.cart.Cart.LineItem) (obj1)).cartLineItemId))
        {
            lineItemsWithShippingChanges.remove(((com.ebay.common.model.cart.Cart.LineItem) (obj1)).cartLineItemId);
            updateUi(true);
        }
        switch (i)
        {
        default:
            return;

        case 1: // '\001'
            view = ((com.ebay.common.model.cart.Cart.LineItem) (obj1)).getLogisticsPlanOfType(com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type.SHIP_TO_HOME);
            if (view != null)
            {
                view = view.getPlanOptions();
                if (view != null)
                {
                    obj1 = new Intent(this, com/ebay/mobile/checkout/ChangeShippingMethodActivity);
                    ((Intent) (obj1)).putExtra("cart_line_item_id", ((String) (obj)));
                    ((Intent) (obj1)).putExtra("logistics_plans", (Serializable)view);
                    startActivityForResult(((Intent) (obj1)), 1240);
                    return;
                }
            }
            break;

        case 2: // '\002'
        case 4: // '\004'
            Intent intent2;
            if (i == 4)
            {
                view = com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type.PUDO;
            } else
            {
                view = com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type.ISPU;
            }
            intent2 = new Intent(this, com/ebay/mobile/inventory/StorePickerActivity);
            obj = getInventoryInfo(((String) (obj)));
            ((InventoryInfo) (obj)).setCheckoutLineItemId(((com.ebay.common.model.cart.Cart.LineItem) (obj1)).cartLineItemId);
            ((InventoryInfo) (obj)).setForceInventoryLookup(true);
            ((InventoryInfo) (obj)).setLogisticsPlanType(view);
            view = ((com.ebay.common.model.cart.Cart.LineItem) (obj1)).getLogisticsPlanOfType(view);
            if (view != null && ((com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan) (view)).type.equals(com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type.PUDO))
            {
                ((InventoryInfo) (obj)).setEstimatedDeliveryDate(view.getFirstPlanOption().getEstimatedPickupTime());
            }
            intent2.putExtra("inventory_info", ((android.os.Parcelable) (obj)));
            intent2.putExtra("com.ebay.mobile.analytics.sid", new SourceIdentification(getTrackingEventName()));
            startActivityForResult(intent2, 1241);
            return;

        case 3: // '\003'
            view = new Intent(this, com/ebay/mobile/checkout/delivery/DeliverySchedulingActivity);
            view.putExtra("params", createDeliverySchedulingParams(((com.ebay.common.model.cart.Cart.LineItem) (obj1))));
            view.putExtra("cart", cart);
            view.putExtra("line_item", ((Serializable) (obj1)));
            startActivityForResult(view, 1242);
            return;
        }
        if (true) goto _L1; else goto _L17
_L10:
        view = getShippingAddressSetInCart(cart.getBuyerShippingAddress());
        if (willPhoneNumberEditFixCart(view))
        {
            Intent intent = new Intent(this, com/ebay/mobile/checkout/AddressEditActivity);
            intent.putExtra("address_to_edit", view);
            intent.putExtra("address_focus_phone", true);
            startActivityForResult(intent, 1243);
            return;
        } else
        {
            view = new Intent(this, com/ebay/mobile/checkout/AddressListActivity);
            view.setAction("android.intent.action.PICK");
            view.putExtra("refinement_postal_code", isEbnAvailableIfRefinementPostalCodeIsShipTo());
            startActivityForResult(view, 1235);
            return;
        }
_L17:
        view = new Intent(this, com/ebay/mobile/checkout/AddressEditActivity);
        view.putExtra("address_to_edit", getShippingAddressSetInCart(cart.getBuyerShippingAddress()));
        view.putExtra("address_focus_phone", true);
        startActivityForResult(view, 1243);
        return;
_L8:
        if (!isPayPalSelected() && !cart.isProx())
        {
            showIncentivesRequirePayPalAlert();
            return;
        } else
        {
            startActivityForResult(new Intent(this, com/ebay/mobile/checkout/IncentivesActivity), 1236);
            return;
        }
_L9:
        view = new Intent(this, com/ebay/mobile/checkout/DonationsActivity);
        view.setAction("android.intent.action.PICK");
        startActivityForResult(view, 1244);
        return;
_L13:
        showDynamicAlertDialog(null, getString(0x7f070caf, new Object[] {
            EbayCurrencyUtil.formatDisplay((CurrencyAmount)view.getTag(), 2)
        }), false);
        return;
_L5:
        if (cart.isProx())
        {
            startProxFlowForPaymentType("PayPal", "SelectPaymentInstrument");
            return;
        } else
        {
            apiRequestTokenForService(MyApp.getPrefs().getCurrentUser());
            return;
        }
_L6:
        if (cart.isProx())
        {
            startPaymentMethodSelectionActivity();
            return;
        }
        if (paymentMethodCompleted)
        {
            if (useMec2)
            {
                startPayPalActivity(payPalCheckoutDetails.getChangeFundingSourceUrl());
                return;
            } else
            {
                startPayPalActivity(paymentSession.returnUrl);
                return;
            }
        }
          goto _L1
_L7:
        if (cart.isProx())
        {
            startPaymentMethodSelectionActivity();
            return;
        }
        if (selectedPaymentMethod.equals("PayPal"))
        {
            startPayPalActivity(paymentSession.returnUrl);
            return;
        } else
        {
            startPaymentMethodSelectionActivity();
            return;
        }
_L15:
        registerForContextMenu(view);
        openContextMenu(view);
        unregisterForContextMenu(view);
        return;
_L14:
        Intent intent1 = new Intent(this, com/ebay/mobile/checkout/MessageToSellerActivity);
        com.ebay.common.model.cart.Cart.Seller seller = (com.ebay.common.model.cart.Cart.Seller)view.getTag(0x7f100014);
        intent1.putExtra("seller_id", seller.userIdentifier);
        intent1.putExtra("use_cancel_done_buttons", true);
        if (Boolean.TRUE.equals(view.getTag(0x7f100013)))
        {
            intent1.putExtra("is_ebay_now", true);
            intent1.putExtra("message_to_seller", (String)view.getTag(0x7f100012));
            intent1.putExtra("title", getString(0x7f070ca8));
            intent1.putExtra("edit_text_hint", getString(0x7f070ca7));
        } else
        {
            intent1.putExtra("message_to_seller", seller.note);
        }
        startActivityForResult(intent1, 1239);
        return;
        if (cart != null && (!cart.isShippable(getShippingAddressSetInCart(cart.getBuyerShippingAddress())) && !"CashOnPickup".equals(selectedPaymentMethod) || !cart.areAllBopisItemsInStock())) goto _L1; else goto _L18
_L18:
        measurePageLoadOnRestart = true;
        if (!isReadyToPayForOrder())
        {
            view = findViewById(visibleLayoutId);
            if (view != null)
            {
                shouldHandleClick = true;
                onClick(view);
                return;
            } else
            {
                showDynamicAlertDialog(null, getString(0x7f070c55), false);
                return;
            }
        }
        if (!isPayPalSelected() && cart != null && cart.incentiveSubtotal != null && cart.incentiveSubtotal.isGreaterThanZero())
        {
            showIncentivesRequirePayPalAlert();
            return;
        } else
        {
            measurePageLoadOnRestart = false;
            siteSpeedStartPayment();
            apiInitPaymentResult(cart.cartId);
            return;
        }
    }

    public boolean onContextItemSelected(MenuItem menuitem)
    {
        if (selectedMenuItem == null)
        {
            return super.onOptionsItemSelected(menuitem);
        }
        if (selectedMenuItem.getId() != 0x7f100953) goto _L2; else goto _L1
_L1:
        com.ebay.common.model.cart.Cart.LineItem lineitem;
        int i;
        lineitem = cart.getLineItemByCartLineItemId((String)selectedMenuItem.getTag());
        i = menuitem.getOrder();
        if (i <= 5) goto _L4; else goto _L3
_L3:
        menuitem = new Intent(this, com/ebay/mobile/checkout/ChangeCartItemQuantityActivity);
        menuitem.putExtra("quantity_available", lineitem.getQuantityAvailable());
        menuitem.putExtra("ebay_item_id", lineitem.cartLineItemId);
        startActivityForResult(menuitem, 1238);
_L2:
        return true;
_L4:
        if (lineitem.quantity != i)
        {
            apiUpdateItemQuantity(lineitem.cartLineItemId, i);
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (isProxEnabled())
        {
            showProxTreatment = Experiments.ShowProxExperiment.getCurrentTreatment(getEbayContext());
        }
        inflater = (LayoutInflater)getSystemService("layout_inflater");
        imageCache = new ImageCache(this);
        Intent intent = getIntent();
        if (bundle == null)
        {
            item = (CheckoutItem)intent.getParcelableExtra("item");
            transaction = (ItemTransaction)intent.getParcelableExtra("transaction");
            variationId = intent.getStringExtra("variation_id");
            shopCartId = intent.getLongExtra("shopping_cart_id", -1L);
            shopCartItems = (Map)intent.getSerializableExtra("shopping_cart_items");
            variationOptions = intent.getParcelableArrayListExtra("variation_options");
            useMec2 = intent.getBooleanExtra("remember_me", false);
            inReferrer = intent.getStringExtra("com.ebay.mobile.tracking.Referrer");
            bidSource = intent.getStringExtra("com.ebay.mobile.tracking.BidSource");
            refinedPostalCode = intent.getStringExtra("refined_postal_code");
            deliverySchedulingParams = new DeliverySchedulingParams();
            visibleLayoutId = 0;
            originalLogisticsPlanOptionId = null;
        } else
        {
            variationOptions = bundle.getParcelableArrayList("variation_options");
            useMec2 = bundle.getBoolean("remember_me");
            inReferrer = bundle.getString("com.ebay.mobile.tracking.Referrer");
            bidSource = bundle.getString("com.ebay.mobile.tracking.BidSource");
            isInitializationSequenceComplete = bundle.getBoolean("is_initialziation_sequence_completne");
            payPalCheckoutRefreshUrl = bundle.getString("paypal_checkout_refresh_url");
            payPalSessionStartTime = bundle.getLong("paypal_session_start_time");
            visibleLayoutId = bundle.getInt("visible_layout_id");
            originalLogisticsPlanOptionId = bundle.getString("original_shipping_method_id");
            refinedPostalCode = bundle.getString("refined_postal_code");
            deliverySchedulingParams = (DeliverySchedulingParams)bundle.getParcelable("selected_delivery_scheduling_params");
            if (bundle.containsKey("mimsScopeId"))
            {
                activeMimsScope = Long.valueOf(bundle.getLong("mimsScopeId"));
            }
            conversionRate = (CurrencyConversionRate)bundle.getParcelable("conversion_rate");
        }
        isMoreXOItemsInCart = intent.getBooleanExtra("checkoutable_items_in_cart", false);
        setContentView(0x7f0302a9);
        alertView = findViewById(0x7f100914);
        warningView = findViewById(0x7f100916);
        placeOrderButton = (Button)findViewById(0x7f100941);
        placeOrderButton.setOnClickListener(this);
        hideBackButton();
        setCancelable(false);
        setCloseButtonOnClickListener(new android.view.View.OnClickListener() {

            final CheckoutActivity this$0;

            public void onClick(View view)
            {
                showCancelCheckoutWarningDialog();
            }

            
            {
                this$0 = CheckoutActivity.this;
                super();
            }
        });
    }

    public void onCreateContextMenu(ContextMenu contextmenu, View view, android.view.ContextMenu.ContextMenuInfo contextmenuinfo)
    {
        super.onCreateContextMenu(contextmenu, view, contextmenuinfo);
        if (view.getId() == 0x7f100953)
        {
            contextmenu.setHeaderTitle(getString(0x7f07058e));
            selectedMenuItem = view;
            int j = cart.getLineItemByCartLineItemId((String)view.getTag()).getQuantityAvailable();
            for (int i = 1; i <= Math.min(5, j); i++)
            {
                contextmenu.add(0, 0, i, String.valueOf(i));
            }

            if (j > 5)
            {
                contextmenu.add(0, 0, 6, String.format(getString(0x7f070a96), new Object[] {
                    Integer.valueOf(5)
                }));
            }
            return;
        } else
        {
            selectedMenuItem = null;
            return;
        }
    }

    protected void onDestroy()
    {
        super.onDestroy();
        FwLoaderManager fwloadermanager = getFwLoaderManager();
        if (fwloadermanager != null)
        {
            fwloadermanager.cancelAll(true);
        }
        closeMimsScope();
    }

    public void onDialogFragmentResult(DialogFragment dialogfragment, int i, int j)
    {
        if (j != 1)
        {
            return;
        }
        switch (i)
        {
        default:
            return;

        case 0: // '\0'
            onSuccess(BaseCheckoutActivity.Operation.BUY);
            return;

        case 1: // '\001'
            sendCanceledImpression();
            break;
        }
        finish();
    }

    public void onError(BaseCheckoutActivity.Operation operation, boolean flag, IOException ioexception)
    {
        if (isFinishing())
        {
            return;
        }
        switch (_cls6..SwitchMap.com.ebay.mobile.checkout.BaseCheckoutActivity.Operation[operation.ordinal()])
        {
        default:
            boolean flag1;
            if (flag && isInitializationSequenceComplete)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            aborted = flag1;
            enableProgressDialog(false, false);
            dialogManager.showDynamicAlertDialog(getString(0x7f070130), CheckoutError.getConnectionError(getResources(), flag, ioexception), aborted);
            return;

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
            onSuccess(operation);
            return;
        }
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        DeviceConfiguration deviceconfiguration = DeviceConfiguration.getAsync();
        if (deviceconfiguration.get(DcsBoolean.ebayGivingCheckout))
        {
            nonprofitDataManager = (NonProfitDataManager)datamanagercontainer.initialize(NonProfitDataManager.KEY, this);
        }
        if (deviceconfiguration.get(DcsBoolean.eBayNow))
        {
            ebnInventoryLookupDataManager = (EbayNowInventoryLookupDataManager)datamanagercontainer.initialize(new com.ebay.common.net.api.local.EbayNowInventoryLookupDataManager.KeyParams(), this);
        }
        itemDataManager = (ItemDataManager)datamanagercontainer.initialize(new com.ebay.mobile.viewitem.ItemDataManager.KeyParams(), null);
        datamanagercontainer.initialize(CurrencyConversionDataManager.KEY, this);
    }

    public void onInventoryLookupComplete(EbayNowInventoryLookupDataManager ebaynowinventorylookupdatamanager, ResultStatus resultstatus)
    {
        if (!resultstatus.hasError())
        {
            updateUi(false);
        }
    }

    public void onNonProfitsChanged(NonProfitDataManager nonprofitdatamanager, Content content)
    {
        if (!content.getStatus().hasError())
        {
            favoriteCharities = (List)content.getData();
        } else
        {
            favoriteCharities = null;
        }
        updateUi(false);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x102002c)
        {
            showCancelCheckoutWarningDialog();
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }

    public void onPartialFailure(BaseCheckoutActivity.Operation operation, JsonModel jsonmodel)
    {
        Object obj;
        boolean flag1;
        obj = null;
        flag1 = false;
        _cls6..SwitchMap.com.ebay.mobile.checkout.BaseCheckoutActivity.Operation[operation.ordinal()];
        JVM INSTR tableswitch 5 16: default 76
    //                   5 147
    //                   6 185
    //                   7 302
    //                   8 308
    //                   9 308
    //                   10 333
    //                   11 768
    //                   12 768
    //                   13 858
    //                   14 858
    //                   15 900
    //                   16 933;
           goto _L1 _L2 _L3 _L4 _L5 _L5 _L6 _L7 _L7 _L8 _L8 _L9 _L10
_L1:
        boolean flag = flag1;
_L14:
        jsonmodel = CheckoutError.mapCheckoutError(operation, ((String) (obj)));
        if (jsonmodel != null)
        {
            aborted = jsonmodel.shouldAbortOnError();
            if (aborted)
            {
                setResult(503);
            }
            dialogManager.showDynamicAlertDialog(null, jsonmodel.getErrorString(this), aborted);
        }
        if (aborted || flag)
        {
            break; /* Loop/switch isn't completed */
        }
        onSuccess(operation);
_L12:
        return;
_L2:
        if (getDefaultShippingAddress() == null)
        {
            aborted = true;
            dialogManager.showDynamicAlertDialog(null, getString(0x7f070c18), aborted);
            return;
        } else
        {
            onSuccess(operation);
            return;
        }
_L3:
        if (jsonmodel.errors != null && !this.cart.hasEbayNowAvailable() && DeviceConfiguration.getAsync().get(DcsBoolean.eBayNow))
        {
            obj = jsonmodel.errors.iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                if (TextUtils.equals("901", ((com.ebay.common.model.cart.JsonModel.OperationError)((Iterator) (obj)).next()).errorId))
                {
                    lineItemsWithShippingChanges.add(jsonmodel.getValueForErrorParamater("cartLineItemIdentifier"));
                }
            } while (true);
        }
        String s = jsonmodel.getValueForErrorParamater("shippingErrorCode");
        obj = s;
        if (s == null)
        {
            obj = jsonmodel.getErrorId();
        }
        flag = true;
        continue; /* Loop/switch isn't completed */
_L4:
        onSuccess(operation);
        return;
_L5:
        flag = true;
        jsonmodel = jsonmodel.getErrorId();
        obj = jsonmodel;
        if ("601".equals(jsonmodel))
        {
            onSuccess(operation);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        Cart cart = (Cart)jsonmodel;
        String s6 = cart.getValueForErrorParamater("nativeErrorCode");
        String s8 = cart.getValueForErrorParamater("buyingErrorCode");
        String s9 = cart.getValueForErrorParamater("paymentErrorCode");
        String s1 = s8;
        obj = s1;
        if (s1 == null)
        {
            obj = s6;
        }
        String s4 = ((String) (obj));
        if (obj == null)
        {
            s4 = s9;
        }
        s1 = s4;
        if (s4 == null)
        {
            s1 = cart.getErrorId();
        }
        if ("205".equals(s6) && EbayErrorUtil.userAccessLevelUpgradeRequired(s8))
        {
            PpaUpgradeConfirmDialog.create(this, true).show();
            return;
        }
        if ("5016".equals(s1))
        {
            if (this.cart.numberOfItems() > 0)
            {
                obj = getString(0x7f070bd0);
                aborted = false;
            } else
            {
                obj = getString(0x7f070bcf);
                aborted = true;
            }
            dialogManager.showDynamicAlertDialog(null, ((String) (obj)), aborted);
            if (aborted)
            {
                continue; /* Loop/switch isn't completed */
            }
        } else
        {
            if ("381".equals(s1) || "334".equals(s1))
            {
                this.cart.unselectPaymentMethod();
                handleCartResponse();
                return;
            }
            if ("196".equals(s1))
            {
                handleCartResponse();
                return;
            }
            if ("339".equals(s1))
            {
                setDefaultPaymentMethod();
                boolean flag2;
                if (paymentMethodCount == 1 && selectedPaymentMethod.equals("PayPal"))
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                aborted = flag2;
                if (!aborted)
                {
                    this.cart.unselectPaymentMethod();
                    handleCartResponse();
                    return;
                }
                dialogManager.showDynamicAlertDialog(null, getString(0x7f0707d4), aborted);
            }
        }
        obj = s1;
        flag = flag1;
        if (CheckoutError.mapCheckoutError(operation, s1) == null)
        {
            obj = s1;
            flag = flag1;
            if (this.cart.numberOfItems() == 0)
            {
                aborted = true;
                jsonmodel = jsonmodel.getValueForErrorParamater("nativeErrorMsg");
                if (jsonmodel != null)
                {
                    operation = jsonmodel;
                    if (!TextUtils.isEmpty(s1))
                    {
                        operation = (new StringBuilder()).append(jsonmodel).append(" (").append(s1).append(")").toString();
                    }
                } else
                {
                    operation = getString(0x7f070c18);
                }
                dialogManager.showDynamicAlertDialog(null, operation, aborted);
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
_L7:
        jsonmodel = (PayPalCheckoutDetails)jsonmodel;
        if (!jsonmodel.isSignedIn())
        {
            setDefaultPaymentMethod();
            payPalCheckoutDetails = null;
            MyApp.getPrefs().clearPayPalCheckoutSettings();
            updateUi(true);
        }
        if (jsonmodel.isRecoverableError())
        {
            operation = jsonmodel.getRecoveryUrlString();
            if (TextUtils.isEmpty(operation))
            {
                showDynamicAlertDialog(getString(0x7f070c5e), getString(0x7f070c5b), true);
                return;
            } else
            {
                startPayPalActivity(operation);
                return;
            }
        }
        obj = jsonmodel.getErrorId();
        flag = flag1;
        continue; /* Loop/switch isn't completed */
_L8:
        jsonmodel = jsonmodel.getErrorId();
        flag1 = true;
        updateUi(true);
        obj = jsonmodel;
        flag = flag1;
        if (operation == BaseCheckoutActivity.Operation.INIT_PAYMENT_FOR_REFRESH)
        {
            obj = jsonmodel;
            flag = flag1;
            if ("158".equals(jsonmodel))
            {
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
_L9:
        String s2 = jsonmodel.getValueForErrorParamater("buyingErrorCode");
        obj = s2;
        flag = flag1;
        if (s2 == null)
        {
            obj = jsonmodel.getErrorId();
            flag = flag1;
        }
        continue; /* Loop/switch isn't completed */
_L10:
        if (this.cart != null)
        {
            if (this.cart.buyIndicatesCheckBackLater())
            {
                dialogManager.showDynamicAlertDialog(null, getString(0x7f070c59), true);
                return;
            }
            if (this.cart.buyIndicatesPartialSuccess())
            {
                onSuccess(operation);
            }
        }
        flag = true;
        String s3 = jsonmodel.getValueForErrorParamater("paymentProcessorErrorCode");
        obj = s3;
        if (s3 == null)
        {
            obj = jsonmodel.getValueForErrorParamater("buyingErrorCode");
        }
        s3 = ((String) (obj));
        if (obj == null)
        {
            s3 = jsonmodel.getValueForErrorParamater("nativeErrorCode");
        }
        obj = s3;
        if (s3 == null)
        {
            obj = jsonmodel.getErrorId();
        }
        if (((String) (obj)).equals("232"))
        {
            showEbayPlusCutOffError();
            sendErrorCodeImpression(((String) (obj)));
            return;
        }
        if (((String) (obj)).equals("10486"))
        {
            if (jsonmodel.getValueForErrorParamater("paymentErrorCode").equals("105752"))
            {
                if (useMec2 && !useGuestXo)
                {
                    startPayPalActivity(payPalCheckoutDetails.getChangeFundingSourceUrl());
                    return;
                } else
                {
                    startPayPalActivity(paymentSession.returnUrl);
                    return;
                }
            }
            break; /* Loop/switch isn't completed */
        }
        if (((String) (obj)).equals("5016"))
        {
            operation = new ArrayList();
            if (this.cart.lineItems != null)
            {
                for (obj = this.cart.lineItems.iterator(); ((Iterator) (obj)).hasNext();)
                {
                    com.ebay.common.model.cart.Cart.LineItem lineitem = (com.ebay.common.model.cart.Cart.LineItem)((Iterator) (obj)).next();
                    String s5 = jsonmodel.getValueForErrorParamaterOfItemId("buyingErrorCode", String.valueOf(lineitem.ebayItemId));
                    if ("5016".equals(s5))
                    {
                        String s7 = lineitem.getSellerProductId();
                        if (!TextUtils.isEmpty(s7))
                        {
                            operation.add(s7);
                        }
                        lineitem.lineItemErrorCode = s5;
                    } else
                    {
                        lineitem.lineItemErrorCode = null;
                    }
                }

            }
            if (operation.size() > 0)
            {
                jsonmodel = new TrackingData("CheckoutOutOfStock", TrackingType.EVENT);
                jsonmodel.addKeyValuePair("ostkitms", AnalyticsUtil.getCommaSeparatedStringFromCollection(operation));
                jsonmodel.send(this);
            }
            updateUi(true);
            return;
        }
        if (((String) (obj)).equals("2026"))
        {
            operation = jsonmodel.getValueForErrorParamater("buyingMessage");
            dialogManager.showDynamicAlertDialog(null, operation, true);
            sendErrorCodeImpression(((String) (obj)));
            return;
        }
        if (((String) (obj)).equals("6020"))
        {
            operation = jsonmodel.getValueForErrorParamater("buyingMessage");
            jsonmodel = new com.ebay.app.AlertDialogFragment.Builder();
            jsonmodel.setMessageAsWebview(true);
            jsonmodel.setMessage(operation);
            jsonmodel.setPositiveButton(getString(0x7f070738));
            jsonmodel.createFromActivity(0).show(getFragmentManager(), null);
            sendErrorCodeImpression(((String) (obj)));
            return;
        }
        if (resultHasProxRiskRedirect(((String) (obj))))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (this.cart.buyIndicatesSuccess())
        {
            jsonmodel = jsonmodel.getValueForErrorParamater("buyingMessage");
            if (!TextUtils.isEmpty(jsonmodel))
            {
                operation = new com.ebay.app.AlertDialogFragment.Builder();
                operation.setMessageAsWebview(jsonmodel.contains("</"));
                operation.setMessage(jsonmodel);
                operation.setPositiveButton(getString(0x7f070738));
                operation.createFromActivity(0).show(getFragmentManager(), null);
                sendErrorCodeImpression(((String) (obj)));
                return;
            } else
            {
                onSuccess(operation);
                return;
            }
        }
        if (this.cart != null && this.cart.isProx() && ("CreditCard".equals(selectedPaymentMethod) || "DirectDebit".equals(selectedPaymentMethod)) && this.cart.cartPaymentMethods != null)
        {
            jsonmodel = this.cart.cartPaymentMethods.getSelectedPaymentMethod();
            if (jsonmodel != null && jsonmodel.getPaymentInstrument() == null)
            {
                aborted = true;
                setResult(503);
                operation = CheckoutError.mapCheckoutError(operation, "VALIDATION_ERROR");
                dialogManager.showDynamicAlertDialog(null, operation.getErrorString(this), aborted);
                return;
            }
        }
        break; /* Loop/switch isn't completed */
        if (true) goto _L12; else goto _L11
_L11:
        sendErrorCodeImpression(((String) (obj)));
        if (true) goto _L14; else goto _L13
_L13:
        boolean flag3;
        if (operation == BaseCheckoutActivity.Operation.CREATE_CART || operation == BaseCheckoutActivity.Operation.CREATE_CHECKOUT_SESSION)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        enableProgressDialog(false, flag3);
        return;
    }

    public void onRateChanged(CurrencyConversionDataManager currencyconversiondatamanager, CurrencyConversionRate currencyconversionrate)
    {
        if (currencyconversionrate != null && currencyconversionrate.isExchangeRateAvailable)
        {
            conversionRate = currencyconversionrate;
            renderOrderSummary();
        }
    }

    public void onRateLoadComplete(CurrencyConversionDataManager currencyconversiondatamanager, ResultStatus resultstatus, CurrencyConversionRate currencyconversionrate, com.ebay.common.net.api.currency.CurrencyConversionRequest.ConversionRequestParams conversionrequestparams)
    {
        conversionRate = currencyconversionrate;
        renderOrderSummary();
    }

    protected void onRestart()
    {
        if (measurePageLoadOnRestart)
        {
            measurePageLoadOnRestart = false;
            SiteSpeedActivityUtil.initSiteSpeedData(this, getTrackingEventName());
        }
        super.onRestart();
    }

    protected void onResume()
    {
        super.onResume();
        if (cart == null || !isInitializationSequenceComplete)
        {
            startCheckout();
            return;
        } else
        {
            customizeUi();
            updateUi(true);
            return;
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putParcelableArrayList("variation_options", variationOptions);
        bundle.putBoolean("remember_me", useMec2);
        bundle.putString("com.ebay.mobile.tracking.Referrer", inReferrer);
        bundle.putString("com.ebay.mobile.tracking.BidSource", bidSource);
        bundle.putBoolean("is_initialziation_sequence_completne", isInitializationSequenceComplete);
        bundle.putString("paypal_checkout_refresh_url", payPalCheckoutRefreshUrl);
        bundle.putLong("paypal_session_start_time", payPalSessionStartTime);
        bundle.putInt("visible_layout_id", visibleLayoutId);
        bundle.putString("original_shipping_method_id", originalLogisticsPlanOptionId);
        if (activeMimsScope != null)
        {
            bundle.putLong("mimsScopeId", activeMimsScope.longValue());
        }
        bundle.putParcelable("selected_delivery_scheduling_params", deliverySchedulingParams);
        bundle.putParcelable("conversion_rate", conversionRate);
    }

    public void onSuccess(BaseCheckoutActivity.Operation operation)
    {
        if (isFinishing())
        {
            return;
        }
        switch (_cls6..SwitchMap.com.ebay.mobile.checkout.BaseCheckoutActivity.Operation[operation.ordinal()])
        {
        case 7: // '\007'
        default:
            return;

        case 1: // '\001'
            apiGetUserIncentives(false);
            return;

        case 17: // '\021'
            apiGetAddresses();
            return;

        case 5: // '\005'
            apiMakeCart();
            return;

        case 18: // '\022'
            apiGetCart(cartId);
            return;

        case 9: // '\t'
            operation = cart.getBuyerShippingAddress();
            Address address = getDefaultShippingAddress();
            if (operation != null && operation.getAddressId() != null && address != null && operation.getAddressId().equals(address.getAddressId()))
            {
                handleCartResponse();
                return;
            } else
            {
                apiSetShippingAddress(BaseCheckoutActivity.Operation.SET_DEFAULT_SHIPPING_ADDRESS, getDefaultShippingAddress());
                return;
            }

        case 10: // '\n'
        case 19: // '\023'
            handleCartResponse();
            return;

        case 2: // '\002'
            if (shopCartId < 1L)
            {
                apiGetItemIncentives(false);
                return;
            } else
            {
                routeForInitPayment();
                return;
            }

        case 3: // '\003'
            apiGetItemIncentives(true);
            return;

        case 4: // '\004'
            routeForInitPayment();
            return;

        case 6: // '\006'
            apiRefreshCart(cart.cartId);
            return;

        case 8: // '\b'
            apiRefreshAddresses();
            return;

        case 20: // '\024'
        case 21: // '\025'
            updateUi(true);
            apiInitPaymentForRefresh();
            return;

        case 22: // '\026'
        case 23: // '\027'
            updateUi(true);
            apiInitPaymentForRefresh();
            return;

        case 24: // '\030'
            updateUi(true);
            apiInitPaymentForRefresh();
            return;

        case 25: // '\031'
            updateUi(true);
            apiInitPaymentForRefresh();
            return;

        case 26: // '\032'
            selectedPaymentMethod = cart.cartPaymentMethods.getSelectedPaymentMethod().getName();
            updateUi(true);
            return;

        case 27: // '\033'
            apiInitPaymentForPrepareWithPayPal();
            return;

        case 13: // '\r'
            if (paymentSession.redirectRequired)
            {
                if (isRememberMeActive())
                {
                    updateUi(false);
                    initializePayPalCheckout(paymentSession.returnUrl);
                    return;
                }
                startPayPalActivity(paymentSession.returnUrl);
            } else
            {
                paymentMethodCompleted = true;
                if (!isShoppingCartCheckout())
                {
                    if (selectedPaymentMethod.equals("CashOnPickup"))
                    {
                        com.ebay.common.model.cart.Cart.LineItem lineitem = (com.ebay.common.model.cart.Cart.LineItem)cart.lineItems.get(0);
                        if (lineitem != null)
                        {
                            com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan logisticsplan = lineitem.getSelectedLogisticsPlan();
                            if (logisticsplan != null && logisticsplan.isShipToHome())
                            {
                                Object obj = logisticsplan.getPlanOptions();
                                if (obj != null && ((List) (obj)).size() > 0)
                                {
                                    operation = null;
                                    String s = null;
                                    Iterator iterator = ((List) (obj)).iterator();
                                    do
                                    {
                                        if (!iterator.hasNext())
                                        {
                                            break;
                                        }
                                        com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.PlanStep.PlanOption planoption = (com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.PlanStep.PlanOption)iterator.next();
                                        obj = s;
                                        if (planoption.getLogisticsCost().isZero())
                                        {
                                            obj = s;
                                            if (s == null)
                                            {
                                                obj = planoption.logisticsOptionIdentifier;
                                            }
                                        }
                                        s = ((String) (obj));
                                        if (planoption.isLocalPickup())
                                        {
                                            operation = planoption.logisticsOptionIdentifier;
                                            s = ((String) (obj));
                                        }
                                    } while (true);
                                    obj = logisticsplan.getSelectedPlanOption().logisticsOptionIdentifier;
                                    if (operation != null)
                                    {
                                        originalLogisticsPlanOptionId = ((String) (obj));
                                        apiUpdateShippingMethod(lineitem.cartLineItemId, com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type.SHIP_TO_HOME.longName, operation);
                                    } else
                                    if (s != null)
                                    {
                                        originalLogisticsPlanOptionId = ((String) (obj));
                                        apiUpdateShippingMethod(lineitem.cartLineItemId, com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type.SHIP_TO_HOME.longName, s);
                                    } else
                                    {
                                        showDynamicAlertDialog(null, getString(0x7f0700fe), false);
                                    }
                                }
                            }
                        }
                    }
                } else
                if (!TextUtils.isEmpty(originalLogisticsPlanOptionId))
                {
                    operation = (com.ebay.common.model.cart.Cart.LineItem)cart.lineItems.get(0);
                    if (operation != null)
                    {
                        apiUpdateShippingMethod(((com.ebay.common.model.cart.Cart.LineItem) (operation)).cartLineItemId, com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type.SHIP_TO_HOME.longName, originalLogisticsPlanOptionId);
                        originalLogisticsPlanOptionId = null;
                    }
                }
            }
            updateUi(true);
            return;

        case 14: // '\016'
            if (useMec2 && paymentMethodCompleted && paymentSession.redirectRequired)
            {
                String s1 = NautilusKernel.getAppVersionName(this);
                if (TextUtils.isEmpty(payPalCheckoutRefreshUrl))
                {
                    operation = Uri.parse(paymentSession.returnUrl).buildUpon();
                    operation.appendQueryParameter("flow_type", "skipall");
                    operation.appendQueryParameter("repurchase", "true");
                    addMec2QueryArgumentsToUri(operation);
                    operation = operation.build().toString();
                } else
                {
                    operation = payPalCheckoutRefreshUrl;
                }
                apiPayPalCheckout(operation, s1, true);
                return;
            } else
            {
                updateUi(true);
                return;
            }

        case 12: // '\f'
            openMimsScope(MimsUtil.PROVIDER_ID_PAYPAL);
            MimsUtil.addIdentity(MimsUtil.PROVIDER_ID_PAYPAL, payPalCheckoutDetails.account.userId);
            if (!TextUtils.isEmpty(originalLogisticsPlanOptionId))
            {
                operation = (com.ebay.common.model.cart.Cart.LineItem)cart.lineItems.get(0);
                if (operation != null)
                {
                    apiUpdateShippingMethod(((com.ebay.common.model.cart.Cart.LineItem) (operation)).cartLineItemId, com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type.SHIP_TO_HOME.longName, originalLogisticsPlanOptionId);
                    originalLogisticsPlanOptionId = null;
                }
            }
            // fall through

        case 11: // '\013'
            paymentMethodCompleted = true;
            payPalSessionStartTime = System.currentTimeMillis();
            updateUi(true);
            return;

        case 15: // '\017'
            apiBuyCart(cart.cartId);
            return;

        case 16: // '\020'
            setCheckoutResult(-1, null);
            postProcessPaidForItems();
            siteSpeedFinishPayment();
            if (dysonDataManager != null)
            {
                dysonDataManager.clear(LocationUtil.getLastKnownLocation(this));
            }
            Map map = trackCheckoutTransactions();
            if (selectedPaymentMethod.equals("CashOnPickup") || selectedPaymentMethod.equals("MoneyXferAcceptedInCheckout") || paymentInstruction != null)
            {
                Intent intent = new Intent(this, com/ebay/mobile/checkout/PurchaseCompleteAlternativeActivity);
                intent.putExtra("checkout_cart", cart);
                intent.putExtra("shopping_cart_checkout", isShoppingCartCheckout());
                intent.putExtra("payment_method", selectedPaymentMethod);
                intent.putExtra("purchased_item_ids", cart.getItemIds());
                operation = intent;
                if (paymentInstruction != null)
                {
                    intent.putExtra("bank_transfer_details", paymentInstruction);
                    operation = intent;
                }
            } else
            {
                Intent intent1;
                boolean flag;
                if (cart.hasDonation())
                {
                    operation = (new DecimalFormat("#.##")).format(cart.donationAmount.getValueAsDouble());
                } else
                {
                    operation = null;
                }
                intent1 = new Intent(this, com/ebay/mobile/checkout/PurchaseCompleteActivity);
                intent1.putExtra("not_all_items_purchased", cart.buyIndicatesPartialSuccess());
                intent1.putExtra("bopis_in_cart", cart.doesContainBopisItem());
                intent1.putExtra("ebn_in_cart", cart.doesContainEbnItem());
                if (operation != null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                intent1.putExtra("charity_in_cart", flag);
                intent1.putExtra("charity_name", com.ebay.common.model.cart.Cart.DonationHelper.getDonationName(cart));
                intent1.putExtra("charity_id", com.ebay.common.model.cart.Cart.DonationHelper.getDonationNonprofitId(cart));
                intent1.putExtra("charity_donation", operation);
                intent1.putExtra("shopping_cart_checkout", isShoppingCartCheckout());
                intent1.putExtra("MimsScope", MimsUtil.useProviderScoped(MimsUtil.PROVIDER_ID_PAYPAL));
                intent1.putExtra("purchased_item_ids", cart.getItemIds());
                intent1.putExtra("checkoutable_items_in_cart", isMoreXOItemsInCart);
                operation = intent1;
            }
            operation.putExtra("is_parent_activity_modal", false);
            operation.putExtra("tracking_key_values", (Serializable)map);
            startActivity(operation);
            MyEbayLandingActivity.setBuyingInvalid(getEbayContext());
            finish();
            return;
        }
    }

    protected void openMimsScope(String s)
    {
        if (activeMimsScope == null)
        {
            activeMimsScope = MimsUtil.useProviderScoped(s);
        }
    }




/*
    static boolean access$102(CheckoutActivity checkoutactivity, boolean flag)
    {
        checkoutactivity.shouldHandleClick = flag;
        return flag;
    }

*/

}
