// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.LoaderManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.text.Html;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.TextAppearanceSpan;
import android.text.util.Linkify;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.MaskedWallet;
import com.groupon.Channel;
import com.groupon.abtest.GiftingAbTestHelper;
import com.groupon.db.models.CustomField;
import com.groupon.db.models.Deal;
import com.groupon.db.models.DealSummary;
import com.groupon.db.models.Division;
import com.groupon.db.models.GiftWrappingCharge;
import com.groupon.db.models.Image;
import com.groupon.db.models.Option;
import com.groupon.db.models.Price;
import com.groupon.db.models.StockValue;
import com.groupon.events.CustomPageViewEvent;
import com.groupon.loader.DealLoaderCallbacks;
import com.groupon.manager.DealSyncManager;
import com.groupon.models.BookingDetails;
import com.groupon.models.DateTimeFinderReservationDetails;
import com.groupon.models.GenericAmount;
import com.groupon.models.IncentiveTicket;
import com.groupon.models.LocationsContainer;
import com.groupon.models.SchedulerReservationDetails;
import com.groupon.models.billingrecord.BillingRecord;
import com.groupon.models.billingrecord.BillingRecordContainer;
import com.groupon.models.country.Country;
import com.groupon.models.country.CreditCard;
import com.groupon.models.country.PaymentMethod;
import com.groupon.models.dealbreakdown.DealBreakdown;
import com.groupon.models.dealbreakdown.DealBreakdownAddress;
import com.groupon.models.dealbreakdown.DealBreakdownAddresses;
import com.groupon.models.dealbreakdown.DealBreakdownAdjustment;
import com.groupon.models.dealbreakdown.DealBreakdownContainer;
import com.groupon.models.dealbreakdown.DealBreakdownItem;
import com.groupon.models.dealbreakdown.DealBreakdownPaymentMethodInstallmentItem;
import com.groupon.models.dealbreakdown.DealBreakdownPaymentMethodItem;
import com.groupon.models.dealbreakdown.DealBreakdownTenderItem;
import com.groupon.models.dealbreakdown.PurchaseBreakdown;
import com.groupon.models.emailsubscription.EmailSubscriptionsContainer;
import com.groupon.models.error.BreakdownException;
import com.groupon.models.error.GrouponException;
import com.groupon.models.error.OrderException;
import com.groupon.models.error.ShippingException;
import com.groupon.models.error.TravelInventoryNotFoundException;
import com.groupon.models.gift.GiftCode;
import com.groupon.models.gift.GiftingRecord;
import com.groupon.models.nst.ClickExtraInfo;
import com.groupon.models.nst.ClickMetadata;
import com.groupon.models.nst.LiveChatExtraInfo;
import com.groupon.models.nst.PageViewExtraInfo;
import com.groupon.models.nst.UpBackClickExtraInfo;
import com.groupon.models.order.Order;
import com.groupon.models.payment.AbstractPaymentMethod;
import com.groupon.models.payment.ECommercePaymentMethod;
import com.groupon.models.payment.GoogleWalletPaymentMethod;
import com.groupon.models.payment.PaymentMethodFactory;
import com.groupon.models.shippingFields.RegionMX;
import com.groupon.models.shippingFields.ShippingSelectValue;
import com.groupon.models.shippingFields.SpecialShippingFieldsCLCO;
import com.groupon.models.support.SupportInfo;
import com.groupon.models.user.User;
import com.groupon.models.user.UserContainer;
import com.groupon.network.HttpResponseException;
import com.groupon.provider.KochavaProvider;
import com.groupon.provider.LocalizedSharedPreferencesProvider;
import com.groupon.service.AddressService;
import com.groupon.service.AttributionService;
import com.groupon.service.BillingService;
import com.groupon.service.DealBreakdownService;
import com.groupon.service.EmailSubscriptionsService;
import com.groupon.service.GoogleWalletService;
import com.groupon.service.LoginService;
import com.groupon.service.ShippingService;
import com.groupon.service.core.AbTestService;
import com.groupon.service.core.SupportInfoService;
import com.groupon.service.core.UserManager;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.tracking.mobile.events.Impression;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.ActionBarUtil;
import com.groupon.util.ArraySharedPreferences;
import com.groupon.util.BillingRecordExpiryChecker;
import com.groupon.util.BillingRecordUtil;
import com.groupon.util.BuyUtils;
import com.groupon.util.CheckedFunction1;
import com.groupon.util.CurrencyFormatter;
import com.groupon.util.DealUtils;
import com.groupon.util.DeviceInfoUtil;
import com.groupon.util.DialogManager;
import com.groupon.util.ExpirationFormat;
import com.groupon.util.Function0;
import com.groupon.util.Function1;
import com.groupon.util.GrouponDialogFragment;
import com.groupon.util.GrouponDialogListener;
import com.groupon.util.ImageUrl;
import com.groupon.util.IovationBlackboxUtil;
import com.groupon.util.LoggingUtils;
import com.groupon.util.MultiOptionUtil;
import com.groupon.util.ReturningFunction1;
import com.groupon.util.TravelerNameHelper;
import com.groupon.util.UserMigrationManager;
import com.groupon.util.ViewUtils;
import com.groupon.util.VolatileBillingInfoProvider;
import com.groupon.util.VolatileTravelerNameProvider;
import com.groupon.util.livechat.LiveChatUtil;
import com.groupon.view.BuyWithGoogleButton;
import com.groupon.view.CreditCardIconHelper;
import com.groupon.view.DealCardCompact;
import com.groupon.view.LiveChatView;
import com.groupon.view.ObservableScrollView;
import com.groupon.view.SpinnerButton;
import com.groupon.view.Transformation.AspectScaleTransformation;
import com.groupon.view.UrlImageView;
import com.kochava.android.tracker.Feature;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicBoolean;
import org.restlet.engine.util.InternetUsDateFormat;
import roboguice.inject.ContextScopedProvider;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            GrouponFragmentActivity, IntentFactory, BookingMetaData, ConfirmCreditCard

public class Purchase extends GrouponFragmentActivity
    implements CustomPageViewEvent, GrouponDialogListener, commonlib.manager.SyncManager.SyncUiCallbacks
{
    private class GiftingOnClickListener
        implements android.view.View.OnClickListener
    {

        final Purchase this$0;

        public void onClick(View view)
        {
            onSendAsGiftClicked();
        }

        private GiftingOnClickListener()
        {
            this$0 = Purchase.this;
            super();
        }

    }

    private class GiftingRemoveViewOnClickListener
        implements android.view.View.OnClickListener
    {

        private TextView labelView;
        private TextView removeView;
        final Purchase this$0;
        private TextView valueView;

        public void onClick(View view)
        {
            view = new ClickExtraInfo();
            view.pageId = getPageViewId();
            logger.logClick("", "remove_gift_click", channel.toString(), null, view);
            labelView.setText(getString(0x7f080080));
            valueView.setVisibility(8);
            removeView.setVisibility(8);
            giftingRecord = null;
        }

        public GiftingRemoveViewOnClickListener(TextView textview, TextView textview1, TextView textview2)
        {
            this$0 = Purchase.this;
            super();
            labelView = textview;
            valueView = textview1;
            removeView = textview2;
        }
    }


    private static final String ADDRESS_VALIDATION_DIALOG = "address_validation_dialog";
    private static final String BREAKDOWNS_DISMISS_ONLY_ERROR_DIALOG = "breakdowns_dismiss_only_error_dialog";
    private static final String BREAKDOWNS_ERROR_DIALOG = "breakdowns_error_dialog";
    protected static final String BREAKDOWNS_PAYMENTS_ACTION_CHOOSE_PAYMENT = "breakdowns_payments_action_choose_payment";
    protected static final String BREAKDOWNS_PAYMENTS_ACTION_FINISH = "breakdowns_payments_action_finish";
    private static final int COUNT_MULTIPLE_ITEMS = 2;
    private static final String CUSTOM_FIELD_DIALOG = "custom_field_dialog";
    protected static final String CUSTOM_FIELD_KEY = "custom_field_key";
    protected static final int DEAL_LOADER_ID = 0;
    private static final String EDIT_GIFT_CLICK = "edit_gift_click";
    private static final String GIFT_THEME = "gift_theme";
    private static final String INSTALLMENTS_DIALOG = "installments_dialog";
    private static final String INVALID_BREAKDOWNS_PAYMENT_METHODS_DIALOG_CHOOSE_PAYMENT = "invalid_breakdowns_payment_methods_dialog_choose_payment";
    private static final String INVALID_BREAKDOWNS_PAYMENT_METHODS_DIALOG_FINISH = "invalid_breakdowns_payment_methods_dialog_finish";
    private static final String IS_STORABLE_FOR_FUTURE_USE = "billing_record[isStorableForFutureUse]";
    public static final String KOCHAVA_PURCHASE_EVENT_TITLE = "purchase";
    private static final String MINIMUM_AMOUNT_NOT_REACHED_DIALOG = "minimum_amount_not_reached_dialog";
    private static final String PREPURCHASE_BACK_ACTION = "action_back";
    private static final String PREPURCHASE_BACK_CLICK_TYPE = "back_reservation";
    private static final String PREPURCHASE_RESERVATION_NO = "no";
    private static final String PREPURCHASE_RESERVATION_YES = "yes";
    private static final String PRE_PURCHASE_RESERVATION_EXPIRED_DIALOG = "pre_purchase_reservation_expired_dialog";
    private static final String PROMO_CODE_BREAKDOWNS_FAILED_DIALOG = "promo_code_breakdowns_failed_dialog";
    private static final String PURCHASE_PAGE_ID = com/groupon/activity/Purchase.getSimpleName();
    private static final String QUANTITY_DIALOG = "quantity_dialog";
    private static final String REMOVE_GIFT_CLICK = "remove_gift_click";
    private static final String REMOVE_INCENTIVE_TICKETS_DIALOG = "remove_incentive_tickets_dialog";
    protected static final String RESERVATION_DATE_TIME_FORMAT = "MMM d, yyyy h:mma";
    private static final String SHIPPING_ADDRESS_ERROR_DIALOG = "shipping_address_error_dialog";
    private static final String TRAVEL_INVENTORY_NOT_FOUND_DIALOG = "travel_inventory_not_found_dialog";
    private static final String TRAVEL_INVENTORY_NOT_FOUND_EXCEPTION = "travelInventoryNotFound";
    protected static final String VALIDATED_ADDRESS = "validated_address";
    String ADDRESS_ERROR_MESSAGE_FORMAT;
    String ADD_PAYMENT_METHOD;
    String ADD_SHIPPING_ADDRESS;
    String AMOUNT_DUE;
    String APPLY_INCENTIVE_TICKET;
    String CVV_STRING;
    String DELIVERY_ADDRESS;
    String ENTER_SHIPPING_ADDRESS;
    String ENTER_YOUR_ADDRESS;
    String ERROR_MISSING_SHIPPING_ADDRESS;
    String GIFT_FOR;
    String GROUPON_BUCKS;
    String PAYMENT_METHOD;
    String QUANTITY;
    String REENTER_CVV;
    String SELECT_PREFERENCES;
    String SEND_AS_GIFT;
    String SEND_AS_GIFT_QUESTION;
    String SHIPPING_ADDRESS;
    String SUBTOTAL;
    String YOUR_ADDRESS;
    TextView addPaymentHintView;
    private AddressService addressService;
    protected int amountChargedToCreditCardInCents;
    protected AttributionService attributionService;
    private BillingRecordExpiryChecker billingRecordExpiryChecker;
    private BillingRecordUtil billingRecordUtil;
    private BillingService billingService;
    private BookingDetails bookingDetails;
    BookingMetaData bookingModel;
    View bottomBar;
    View bottomBarTaxAndShippingLabel;
    TextView bottomBarText;
    View bottomBarTotalContainer;
    TextView bottomBarTotalLabel;
    TextView bottomBarTotalValue;
    private BuyUtils buyUtils;
    protected BuyWithGoogleButton buyWithGoogleButton;
    private boolean canShowLiveChat;
    protected boolean canUseGiftPoints;
    protected boolean canUseIncentiveTicket;
    protected Channel channel;
    TextView checkInDateView;
    TextView checkOutDateView;
    private boolean checkoutParity1506INTL;
    private GenericAmount creditsAvailable;
    protected String currency;
    protected CurrencyFormatter currencyFormatter;
    private DealBreakdownPaymentMethodInstallmentItem currentAvailableInstallmentOptionsForCardType[];
    private DealBreakdown currentBreakdown;
    protected AbstractPaymentMethod currentPaymentMethod;
    protected DealBreakdownPaymentMethodInstallmentItem currentlySelectedInstallmentOption;
    protected int currentlySelectedQuantity;
    protected HashMap customFieldMap;
    private Map customFieldViewsMap;
    private DateTimeFinderReservationDetails dateTimeFinderReservationDetails;
    Bundle dateTimeFinderReservationDetailsBundle;
    protected Deal deal;
    protected DealBreakdownService dealBreakdownService;
    DealCardCompact dealCardCompact;
    protected LinearLayout dealDetailsContainer;
    protected String dealId;
    UrlImageView dealImageView;
    protected String dealOptionId;
    protected LinearLayout dealPaymentContainer;
    protected HashMap dealPaymentMethodsNameTypePairs;
    private DealSyncManager dealSyncManager;
    protected String defaultOptionIdSelected;
    protected DealBreakdownAddress defaultShippingAddress;
    private DeviceInfoUtil deviceInfoUtil;
    protected DialogManager dialogManager;
    private String displayedShippingAddress;
    private String displayedUserAddress;
    private EmailSubscriptionsService emailSubscriptionsService;
    private ExpirationFormat expirationFormat;
    protected boolean fromGiftCodesScreen;
    TextView fullName;
    protected GiftCode giftCode;
    private GiftingAbTestHelper giftingAbTestHelper;
    protected GiftingRecord giftingRecord;
    protected GoogleWalletService googleWalletService;
    protected boolean hasAddresses;
    private boolean haveCheckedBillingRecords;
    private TextView hotlineView;
    private List incentiveTickets;
    protected LayoutInflater inflater;
    protected IntentFactory intentFactory;
    private InternetUsDateFormat internetUsDateFormat;
    private IovationBlackboxUtil iovationBlackboxUtil;
    private boolean isBookingUpdatePreBook1506USCA;
    protected boolean isCityDealCountry;
    private boolean isGDT1503USCA;
    protected boolean isGiftWrappable;
    boolean isLotteryDeal;
    private boolean isMultiOptions1508INTL;
    private boolean isMultiOptionsIntlDeal;
    protected boolean isNewCheckout1408;
    protected boolean isNewsletterOptInEnabled;
    protected AtomicBoolean isOrdersCallInProgress;
    private AtomicBoolean isRefreshing;
    protected AtomicBoolean isRefreshingBreakdowns;
    protected AtomicBoolean isRefreshingGoogleWallet;
    private AtomicBoolean isUsersCallInProgress;
    private boolean isValidAddressTheSameAsOriginal;
    private DateFormat iso8601DateFormat;
    private KochavaProvider kochavaProvider;
    protected String lang;
    private LiveChatUtil liveChatUtil;
    LiveChatView liveChatView;
    private DateFormat localLongDateFormat;
    protected ContextScopedProvider localizedSharedPreferencesProvider;
    protected Logger logger;
    private LoggingUtils loggingUtils;
    protected ArraySharedPreferences loginPrefs;
    protected LoginService loginService;
    private UserMigrationManager migrationManager;
    private MultiOptionUtil multiOptionUtil;
    protected String multiUsePromoCode;
    protected CheckBox newsletterOptin;
    TextView nightsLabelView;
    TextView nightsView;
    private Function0 onDealLoadedSuccess;
    protected Option option;
    protected String orderId;
    private DealBreakdownAddress otherShippingAddress;
    protected LinearLayout paymentDetailContainer;
    protected PaymentMethodFactory paymentMethodFactory;
    protected ProgressBar paymentSpinner;
    private SharedPreferences prefs;
    protected int priceAmountInCents;
    protected SpinnerButton purchaseButton;
    protected boolean purchased;
    boolean redirectToEnterCode;
    protected LinearLayout reservationContainer;
    protected TextView reservationDetailTitle;
    protected SchedulerReservationDetails reservationDetails;
    Bundle reservationDetailsBundle;
    protected LinearLayout reservationDetailsContainer;
    protected View scrollableContent;
    ObservableScrollView scroller;
    protected String selectedIncentiveTicket;
    protected DealBreakdownAddress shippingAddress;
    private boolean shippingInfoIsInvalid;
    protected ShippingService shippingService;
    boolean shouldLaunchPurchasePage;
    protected boolean shouldShowMultiUsePromoCodeSuccessMessage;
    ViewGroup stockControlContainer;
    View stockControlHeaderContainer;
    protected StockValue stockValue;
    protected Bundle storageConsentRequirements;
    private SupportInfoService supportInfoService;
    TextView titleView;
    private TravelerNameHelper travelerNameHelper;
    protected DealBreakdownAddress userAddress;
    protected LinearLayout userInputActionContainer;
    protected UserManager userManager;
    private String validationCardNumber;
    TextView viewTerms;
    protected VolatileBillingInfoProvider volatileBillingInfoProvider;
    private VolatileTravelerNameProvider volatileTravelerNameProvider;
    protected boolean wasPaymentMethodPreviouslyDisplayed;
    private DateFormat weekDateFormat;

    public Purchase()
    {
        purchased = false;
        isRefreshingBreakdowns = new AtomicBoolean(false);
        isOrdersCallInProgress = new AtomicBoolean(false);
        isUsersCallInProgress = new AtomicBoolean(false);
        isRefreshing = new AtomicBoolean(false);
        isRefreshingGoogleWallet = new AtomicBoolean(false);
        isValidAddressTheSameAsOriginal = true;
        shouldShowMultiUsePromoCodeSuccessMessage = false;
        storageConsentRequirements = new Bundle();
    }

    private void addCustomFieldItemsOldDesign(ViewGroup viewgroup)
    {
        if (customFieldMap == null) goto _L2; else goto _L1
_L1:
        Iterator iterator = customFieldMap.entrySet().iterator();
_L6:
        if (!iterator.hasNext()) goto _L2; else goto _L3
_L3:
        java.util.Map.Entry entry;
        final String key;
        entry = (java.util.Map.Entry)iterator.next();
        key = (String)entry.getKey();
        if (!Strings.equalsIgnoreCase(key, CVV_STRING)) goto _L4; else goto _L2
_L2:
        return;
_L4:
        addSeparator(viewgroup, true);
        getBasicListItem(viewgroup, 0x7f0301a0, key, (String)entry.getValue(), 0, new android.view.View.OnClickListener() {

            final Purchase this$0;
            final String val$key;

            public void onClick(View view)
            {
                view = getCustomFieldPossibleValues(key);
                if (view != null && view.length > 0)
                {
                    onCustomFieldClick(key, view, null);
                    return;
                } else
                {
                    onCustomFieldClick(key);
                    return;
                }
            }

            
            {
                this$0 = Purchase.this;
                key = s;
                super();
            }
        });
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void addDetailsSeparator()
    {
        if (dealDetailsContainer.getChildCount() > 0)
        {
            inflater.inflate(0x7f0301ae, dealDetailsContainer);
        }
    }

    private void addEnterCodeItem()
    {
        if (shouldShowEnterCode())
        {
            addPurchaseActionItem(userInputActionContainer, 0x7f030199, getString(0x7f08014d), null, 0x7f02022d, true, new android.view.View.OnClickListener() {

                final Purchase this$0;

                public void onClick(View view)
                {
                    logEnterCodeClickEvent();
                    startGiftCodesIntent();
                }

            
            {
                this$0 = Purchase.this;
                super();
            }
            });
            addUserInputActionSeparator();
        }
    }

    private void addGoogleWalletCreditCardItem()
    {
        Object obj = googleWalletService.getMaskedWallet();
        if (googleWalletService.isGoogleWalletPaymentMethod(currentPaymentMethod) && obj != null)
        {
            addPaymentSeparator();
            obj = addPurchaseActionItem(dealPaymentContainer, 0x7f0301a7, ((MaskedWallet) (obj)).getPaymentDescriptions()[0], ((MaskedWallet) (obj)).getEmail(), 0x7f020212, false, new android.view.View.OnClickListener() {

                final Purchase this$0;

                public void onClick(View view)
                {
                    setIsRefreshingGoogleWallet(true);
                    googleWalletService.triggerChangeMaskedWalletRequest(Purchase.this);
                    loggingUtils.logGoogleWalletCardClick(channel, com/groupon/activity/Purchase.getSimpleName());
                }

            
            {
                this$0 = Purchase.this;
                super();
            }
            });
            if (!isNewCheckout1408)
            {
                ((android.widget.LinearLayout.LayoutParams)((View) (obj)).getLayoutParams()).setMargins(0, 0, 0, 0);
            }
        }
    }

    private void addGoogleWalletPaymentMethod(String s, List list)
    {
        if (googleWalletService.isGoogleWalletEnabled() && googleWalletService.isGoogleWalletBillingRecord(s))
        {
            s = paymentMethodFactory.createGoogleWalletPaymentMethod(deal, option, currentlySelectedQuantity, isUsingCredits());
            if (s != null)
            {
                list.add(s);
            }
        }
    }

    private void addJapanIncentiveTicketItem()
    {
        if (shouldShowJapanIncentiveTickets())
        {
            Ln.d("BREAKDOWN: incentiveTickets", new Object[0]);
            String s = null;
            Object obj1 = incentiveTickets.iterator();
            Object obj;
            do
            {
                obj = s;
                if (!((Iterator) (obj1)).hasNext())
                {
                    break;
                }
                obj = (IncentiveTicket)((Iterator) (obj1)).next();
            } while (!Strings.equals(((IncentiveTicket) (obj)).type, selectedIncentiveTicket));
            addPaymentSeparatorMarginTop();
            obj1 = dealPaymentContainer;
            if (obj != null)
            {
                if (canUseIncentiveTicket)
                {
                    s = ((IncentiveTicket) (obj)).name;
                } else
                {
                    s = String.format(getString(0x7f080234), new Object[] {
                        ((IncentiveTicket) (obj)).minimum_points.getFormattedAmount()
                    });
                }
            } else
            {
                s = APPLY_INCENTIVE_TICKET;
            }
            if (obj != null)
            {
                obj = (new StringBuilder()).append("-").append(currencyFormatter.format(((IncentiveTicket) (obj)).points, true, com.groupon.util.CurrencyFormatter.DecimalStripBehavior.OnlyIfZero)).toString();
            } else
            {
                obj = null;
            }
            addPurchaseActionItem(((ViewGroup) (obj1)), 0x7f03019b, s, ((CharSequence) (obj)), 0, true, new android.view.View.OnClickListener() {

                final Purchase this$0;

                public void onClick(View view)
                {
                    logger.logClick("", "incentive_ticket_select_option_click", "incentive_ticket", dealId);
                    view = Purchase.this;
                    IntentFactory intentfactory = intentFactory;
                    String s1 = selectedIncentiveTicket;
                    boolean flag;
                    if (giftCode != null)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    view.startActivityForResult(intentfactory.newIncentiveTicketsIntent(true, s1, flag, dealId), 10126);
                }

            
            {
                this$0 = Purchase.this;
                super();
            }
            });
        }
    }

    private void addJapanUserAddressItem()
    {
        byte byte0 = 0;
        if (currentCountryManager.getCurrentCountry().isJapan())
        {
            LinearLayout linearlayout = userInputActionContainer;
            String s = YOUR_ADDRESS;
            Object obj;
            if (Strings.notEmpty(displayedUserAddress))
            {
                obj = displayedUserAddress;
            } else
            {
                obj = ENTER_YOUR_ADDRESS;
            }
            obj = addPurchaseActionItem(linearlayout, 0x7f03019d, s, ((CharSequence) (obj)), 0, true, new android.view.View.OnClickListener() {

                final Purchase this$0;

                public void onClick(View view)
                {
                    startActivityForResult(getShippingAddressIntent(null, userAddress, true), 10120);
                }

            
            {
                this$0 = Purchase.this;
                super();
            }
            });
            addUserInputActionSeparator();
            ((ImageView)((View) (obj)).findViewById(0x7f100492)).setImageResource(0x7f020220);
            obj = (TextView)((View) (obj)).findViewById(0x7f10051b);
            if (obj != null)
            {
                if (isValidAddressTheSameAsOriginal)
                {
                    byte0 = 8;
                }
                ((TextView) (obj)).setVisibility(byte0);
            }
        }
    }

    private void addPaymentMethodItem(String s, String s1)
    {
        s1 = addPurchaseActionItem(userInputActionContainer, 0x7f0301ab, s, s1, 0x7f020209, true, new android.view.View.OnClickListener() {

            final Purchase this$0;

            public void onClick(View view)
            {
                onChangePaymentMethod();
                currentlySelectedInstallmentOption = null;
            }

            
            {
                this$0 = Purchase.this;
                super();
            }
        });
        addUserInputActionSeparator();
        s = (TextView)s1.findViewById(0x7f100249);
        s1 = (ImageView)s1.findViewById(0x7f10049d);
        int i;
        int j;
        boolean flag;
        if (currentPaymentMethod != null)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i != 0 && amountChargedToCreditCardInCents > 0)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        flag = currentCountryManager.getCurrentCountry().isJapan();
        if (i != 0)
        {
            if (currentPaymentMethod.isCreditCard() && !googleWalletService.isGoogleWalletPaymentMethod(currentPaymentMethod))
            {
                CreditCardIconHelper.createCreditCardIcon(currentPaymentMethod.getBillingRecord(), s, com.groupon.view.CreditCardIconHelper.IconType.REDESIGNED);
                if (flag)
                {
                    if (currentPaymentMethod.isVolatile())
                    {
                        j = 0x7f0200bb;
                    } else
                    {
                        j = 0x7f0200d4;
                    }
                    s1.setImageResource(j);
                }
            } else
            {
                CreditCardIconHelper.createCreditCardIcon(currentPaymentMethod.getId(), s, com.groupon.view.CreditCardIconHelper.IconType.REDESIGNED);
            }
        }
        if (i != 0 && !flag)
        {
            j = 0;
        } else
        {
            j = 8;
        }
        s.setVisibility(j);
        if (i != 0 && flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        s1.setVisibility(i);
    }

    private void addPaymentSeparator()
    {
        inflater.inflate(0x7f0301ae, dealPaymentContainer);
    }

    private void addPaymentSeparatorMarginTop()
    {
        inflater.inflate(0x7f0301ad, dealPaymentContainer);
    }

    private View addPurchaseActionItem(ViewGroup viewgroup, int i, CharSequence charsequence, CharSequence charsequence1, int j, int k, boolean flag, 
            android.view.View.OnClickListener onclicklistener)
    {
        View view = null;
        if (i > 0)
        {
            view = inflater.inflate(i, viewgroup, false);
            TextView textview = (TextView)view.findViewById(0x7f1002d3);
            TextView textview1 = (TextView)view.findViewById(0x7f100249);
            EditText edittext = (EditText)view.findViewById(0x7f1002f5);
            ImageView imageview = (ImageView)view.findViewById(0x7f10049b);
            View view1 = view.findViewById(0x7f1001fc);
            TextView textview2 = (TextView)view.findViewById(0x7f10049c);
            TextView textview3 = (TextView)view.findViewById(0x7f10049a);
            if (textview != null)
            {
                if (Strings.notEmpty(charsequence))
                {
                    textview.setText(charsequence);
                    if (k > 0 && imageview == null)
                    {
                        boolean flag1 = deviceInfoUtil.isRTLLanguage();
                        int l;
                        if (flag1)
                        {
                            i = 0;
                        } else
                        {
                            i = k;
                        }
                        if (flag1)
                        {
                            l = k;
                        } else
                        {
                            l = 0;
                        }
                        textview.setCompoundDrawablesWithIntrinsicBounds(i, 0, l, 0);
                    }
                }
                if (Strings.notEmpty(charsequence))
                {
                    i = 0;
                } else
                {
                    i = 8;
                }
                textview.setVisibility(i);
            }
            if (textview1 != null)
            {
                if (Strings.notEmpty(charsequence1))
                {
                    textview1.setText(charsequence1);
                }
                if (Strings.notEmpty(charsequence1))
                {
                    i = 0;
                } else
                {
                    i = 8;
                }
                textview1.setVisibility(i);
                if (j != 0)
                {
                    textview1.setTextColor(j);
                }
            }
            if (edittext != null && imageview == null)
            {
                if (Strings.notEmpty(charsequence))
                {
                    edittext.setHint(charsequence);
                }
                if (Strings.notEmpty(charsequence1))
                {
                    edittext.setText(charsequence1);
                }
                if (k > 0)
                {
                    flag1 = deviceInfoUtil.isRTLLanguage();
                    if (flag1)
                    {
                        i = 0;
                    } else
                    {
                        i = k;
                    }
                    if (flag1)
                    {
                        j = k;
                    } else
                    {
                        j = 0;
                    }
                    edittext.setCompoundDrawablesWithIntrinsicBounds(i, 0, j, 0);
                }
            }
            if (imageview != null)
            {
                imageview.setImageResource(k);
            }
            if (view1 != null)
            {
                if (flag)
                {
                    i = 0;
                } else
                {
                    i = 8;
                }
                view1.setVisibility(i);
            }
            if (onclicklistener != null)
            {
                view.setOnClickListener(onclicklistener);
            }
            if (textview2 != null)
            {
                if (currentPaymentMethod != null && currentPaymentMethod.isCreditCard() && billingRecordExpiryChecker.isBillingRecordExpired(currentPaymentMethod.getBillingRecord()))
                {
                    i = 0;
                } else
                {
                    i = 8;
                }
                textview2.setVisibility(i);
            }
            if (textview3 != null && giftingRecord != null)
            {
                textview3.setVisibility(0);
                textview3.setOnClickListener(new GiftingRemoveViewOnClickListener(textview, textview1, textview3));
            }
            viewgroup.addView(view);
        }
        return view;
    }

    private View addPurchaseActionItem(ViewGroup viewgroup, int i, CharSequence charsequence, CharSequence charsequence1, int j, boolean flag, android.view.View.OnClickListener onclicklistener)
    {
        return addPurchaseActionItem(viewgroup, i, charsequence, charsequence1, 0, j, flag, onclicklistener);
    }

    private void addReservationDetails()
    {
        reservationContainer.setVisibility(0);
        if (dateTimeFinderReservationDetails != null)
        {
            reservationDetailTitle.setText(getReservationDetailsHeaderText());
        }
        String s = formatReservationDate(reservationDetails.startDateTime);
        addPurchaseActionItem(reservationDetailsContainer, 0x7f03019c, s, null, 0x7f020091, false, null);
    }

    private void addSendAsGiftItem()
    {
        if (!shouldShowSendAsGift()) goto _L2; else goto _L1
_L1:
        String s;
        String s2;
        GiftingOnClickListener giftingonclicklistener;
        giftingonclicklistener = new GiftingOnClickListener();
        if (!giftingAbTestHelper.shouldAddGiftingButtonOnDealDetail() || !DealUtils.isGiftableDeal(deal, false, false))
        {
            break MISSING_BLOCK_LABEL_239;
        }
        s2 = "";
        if (giftingRecord == null || Strings.isEmpty(giftingRecord.recipientName))
        {
            s = getString(0x7f080080);
        } else
        {
label0:
            {
                if (!giftingRecord.deliveryMethod.equals("print"))
                {
                    break label0;
                }
                s = String.format(getString(0x7f0801f3), new Object[] {
                    giftingRecord.recipientName
                });
            }
        }
_L3:
        addPurchaseActionItem(userInputActionContainer, 0x7f0301a6, s, s2, 0, true, giftingonclicklistener);
_L4:
        addUserInputActionSeparator();
_L2:
        return;
        s = String.format(getString(0x7f08036d), new Object[] {
            giftingRecord.recipientEmail
        });
        String s4;
        s4 = giftingRecord.emailDeliveryTime;
        if (!Strings.isEmpty(s4))
        {
            break MISSING_BLOCK_LABEL_192;
        }
        s4 = getString(0x7f0803e0);
        s2 = s4;
          goto _L3
        s4 = String.format(getString(0x7f08036c), new Object[] {
            weekDateFormat.format(iso8601DateFormat.parse(s4))
        });
        s2 = s4;
          goto _L3
        ParseException parseexception;
        parseexception;
        Ln.e(parseexception);
          goto _L3
        String s1;
        String s3;
        LinearLayout linearlayout;
        if (giftingRecord != null && Strings.notEmpty(giftingRecord.recipientName))
        {
            s1 = giftingRecord.recipientName;
        } else
        if (isNewCheckout1408)
        {
            s1 = "No";
        } else
        {
            s1 = "";
        }
        isGiftWrappable = DealUtils.isGiftWrappable(option);
        linearlayout = userInputActionContainer;
        if (Strings.equals(s1, "No"))
        {
            s3 = SEND_AS_GIFT_QUESTION;
        } else
        {
            s3 = GIFT_FOR;
        }
        addPurchaseActionItem(linearlayout, 0x7f030199, s3, s1, 0x7f020211, true, giftingonclicklistener);
          goto _L4
    }

    private void addSeparator(ViewGroup viewgroup, boolean flag)
    {
        if (!flag || viewgroup.getChildCount() > 0)
        {
            inflater.inflate(0x7f0301ae, viewgroup);
        }
    }

    private void addShippingAddressItem()
    {
        Object obj;
        Object obj1;
        boolean flag2;
label0:
        {
            flag2 = false;
            boolean flag1 = false;
            if (isShippingAddressRequired())
            {
                boolean flag3 = shippingService.isStored();
                obj = googleWalletService.getMaskedWalletShippingAddress();
                int i;
                boolean flag;
                if (obj != null)
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                if (shouldShowAddShippingAddressPrompt())
                {
                    obj1 = ADD_SHIPPING_ADDRESS;
                } else
                if (currentCountryManager.getCurrentCountry().isUSACompatible())
                {
                    obj1 = SHIPPING_ADDRESS;
                } else
                {
                    obj1 = DELIVERY_ADDRESS;
                }
                if (!flag3)
                {
                    if (googleWalletService.isGoogleWalletPaymentMethod(currentPaymentMethod))
                    {
                        obj = shippingService.getAsJoin(((com.google.android.gms.wallet.Address) (obj)));
                    } else
                    {
                        obj = null;
                    }
                } else
                if (currentCountryManager.getCurrentCountry().isUSACompatible())
                {
                    obj = shippingService.getAsJoin();
                } else
                {
                    obj = displayedShippingAddress;
                }
                obj1 = addPurchaseActionItem(userInputActionContainer, 0x7f03019d, ((CharSequence) (obj1)), ((CharSequence) (obj)), 0, true, new android.view.View.OnClickListener() {

                    final Purchase this$0;

                    public void onClick(View view)
                    {
                        isValidAddressTheSameAsOriginal = true;
                        onShippingAddressClick();
                    }

            
            {
                this$0 = Purchase.this;
                super();
            }
                });
                addUserInputActionSeparator();
                if (!currentCountryManager.getCurrentCountry().isChile() && !currentCountryManager.getCurrentCountry().isColombia() || !Strings.equals(ENTER_SHIPPING_ADDRESS, displayedShippingAddress))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                obj1 = (TextView)((View) (obj1)).findViewById(0x7f100493);
                if (obj1 != null)
                {
                    if (!flag3 && i == 0 || !flag)
                    {
                        break label0;
                    }
                    i = ((flag1) ? 1 : 0);
                    if (isValidAddressTheSameAsOriginal)
                    {
                        i = 8;
                    }
                    ((TextView) (obj1)).setVisibility(i);
                    if (shippingInfoIsInvalid)
                    {
                        i = 0x7f0802df;
                    } else
                    {
                        i = 0x7f0802e0;
                    }
                    ((TextView) (obj1)).setText(i);
                    if (shippingInfoIsInvalid)
                    {
                        ((TextView) (obj1)).setTextColor(getResources().getColor(0x7f0e015b));
                    }
                }
            }
            return;
        }
        int j;
        if (Strings.notEmpty(obj))
        {
            j = ((flag2) ? 1 : 0);
        } else
        {
            j = 8;
        }
        ((TextView) (obj1)).setVisibility(j);
        ((TextView) (obj1)).setText(ERROR_MISSING_SHIPPING_ADDRESS);
    }

    private void adjustScrollToTopOfTitle()
    {
        if (titleView != null)
        {
            scroller.smoothScrollTo(0, titleView.getTop());
        }
    }

    private void alertMinimumAmountNotReached(String s)
    {
        showDialog(dialogManager.getDialogFragment(String.format(getString(0x7f08019d), new Object[] {
            s
        })), "minimum_amount_not_reached_dialog");
    }

    private void applyCredits(int i, int j, List list, DealBreakdownTenderItem dealbreakdowntenderitem, String s)
    {
        DealBreakdownTenderItem dealbreakdowntenderitem1;
        int k;
        if (j > i)
        {
            k = i;
        } else
        {
            k = j;
        }
        Ln.d("BREAKDOWN: getCreditsForUser, totalAmount = %d, creditAmount = %d, actualCreditUsedAmount = %d", new Object[] {
            Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k)
        });
        dealbreakdowntenderitem1 = new DealBreakdownTenderItem();
        dealbreakdowntenderitem1.type = "credit";
        dealbreakdowntenderitem1.amount = new GenericAmount(-k, s, null);
        list.add(dealbreakdowntenderitem1);
        dealbreakdowntenderitem.amount.setAmount(j - k);
        recreateOrderBreakdowns();
    }

    private void buildHotlineNumber()
    {
        String s = supportInfoService.getSupportInfo().contents.getawayBookingsCustomerSupport.afterHoursPhoneNumber;
        if (Strings.notEmpty(s))
        {
            SpannableString spannablestring = new SpannableString(String.format(getString(0x7f0802f5), new Object[] {
                s
            }));
            spannablestring.setSpan(new TextAppearanceSpan(this, 0x7f0a017e), spannablestring.length() - s.length(), spannablestring.length(), 33);
            Linkify.addLinks(spannablestring, 4);
            hotlineView.setVisibility(0);
            hotlineView.setText(spannablestring);
            hotlineView.setMovementMethod(LinkMovementMethod.getInstance());
            return;
        } else
        {
            hotlineView.setVisibility(8);
            return;
        }
    }

    private Intent createThanksIntent()
    {
        Object obj;
        Bundle bundle;
        Intent intent;
        boolean flag;
        if (getIntent().getExtras() == null)
        {
            obj = null;
        } else
        {
            obj = (Channel)getIntent().getExtras().getParcelable("channel");
        }
        bundle = new Bundle(1);
        bundle.putParcelable("giftingRecord", giftingRecord);
        intent = intentFactory.newThanksIntent(deal.remoteId, option.remoteId, ((Channel) (obj))).putExtra("orderID", orderId);
        if (obj == null)
        {
            obj = channel;
        }
        obj = intent.putExtra("channel", ((android.os.Parcelable) (obj))).putExtra("gifting_record_bundle", bundle).putExtra("isDeepLinked", getIntent().getBooleanExtra("isDeepLinked", false));
        if (reservationDetails != null && Strings.notEmpty(reservationDetails.id))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj = ((Intent) (obj)).putExtra("is_deal_pre_purchase_booked", flag);
        if (dateTimeFinderReservationDetails != null)
        {
            if (reservationDetails != null)
            {
                dateTimeFinderReservationDetails.reservationDate = reservationDetails.startDateTime;
                dateTimeFinderReservationDetails.timeZone = TimeZone.getTimeZone(reservationDetails.timezone);
                dateTimeFinderReservationDetails.partySize = reservationDetails.partySize;
            }
            dateTimeFinderReservationDetailsBundle.putParcelable("reservation_details", dateTimeFinderReservationDetails);
            ((Intent) (obj)).putExtra("reservation_details_bundle", dateTimeFinderReservationDetailsBundle);
        }
        return ((Intent) (obj));
    }

    private String createTotalPriceBookingComment()
    {
        int j = 0x7f0803e6;
        Object obj = deal.division;
        String s;
        int i;
        if (obj != null)
        {
            s = ((Division) (obj)).timezoneIdentifier;
        } else
        {
            s = "";
        }
        if (obj != null)
        {
            i = ((Division) (obj)).timezoneOffsetInSeconds;
        } else
        {
            i = 0;
        }
        obj = Integer.valueOf(i);
        expirationFormat.shouldDisplayTime(false);
        if (dateTimeFinderReservationDetails != null)
        {
            if (DealUtils.isFoodAndDrinkDeal(deal))
            {
                i = j;
            } else
            if (DealUtils.isHealthBeautyWellnessDeal(deal))
            {
                i = 0x7f0803e5;
            } else
            {
                i = -1;
            }
            return expirationFormat.format(option.getExpiresAt(), s, ((Integer) (obj)), getString(i));
        } else
        {
            return expirationFormat.format(option.getExpiresAt(), s, ((Integer) (obj)), getString(0x7f0803e6));
        }
    }

    private void displayPrePurchaseReservationExpiredDialog()
    {
        showDialog(dialogManager.getDialogFragment(null, Integer.valueOf(0x7f0802e2), Integer.valueOf(0x104000a), false), "pre_purchase_reservation_expired_dialog");
    }

    private void displayPromoCodeError(Exception exception)
    {
        showDialog(dialogManager.getDialogFragmentGrouponException((GrouponException)exception), "promo_code_breakdowns_failed_dialog");
    }

    private void displayRetryCancelDialog()
    {
        showDialog(dialogManager.getDialogFragment(null, Integer.valueOf(0x7f0803f4), Integer.valueOf(0x7f080336), Integer.valueOf(0x7f080084), false), "breakdowns_error_dialog");
    }

    private void displayShippingAddressError()
    {
        DialogManager dialogmanager = dialogManager;
        String s1 = ADDRESS_ERROR_MESSAGE_FORMAT;
        String s;
        if (currentCountryManager.getCurrentCountry().isUSACompatible())
        {
            s = addressService.getFormattedAddressFromPrefsForUS();
        } else
        {
            s = shippingService.getShippingAddressStringEu();
        }
        showDialog(dialogmanager.getDialogFragment(Integer.valueOf(0x7f08005a), String.format(s1, new Object[] {
            s
        }), Integer.valueOf(0x7f080139), false), "shipping_address_error_dialog");
    }

    private void displayTravelInventoryNoLongerAvailableDialog(String s)
    {
        showDialog(dialogManager.getDialogFragment(null, s, Integer.valueOf(0x104000a), false), "travel_inventory_not_available_dialog");
    }

    private void displayTravelInventoryNotFoundError()
    {
        showDialog(dialogManager.getDialogFragment(null, Integer.valueOf(0x7f0803e9), Integer.valueOf(0x104000a), false), "travel_inventory_not_found_dialog");
    }

    private void enterShippingAddress()
    {
        if (!currentCountryManager.getCurrentCountry().isUSACompatible())
        {
            startActivityForResult(getShippingAddressIntent(defaultShippingAddress, otherShippingAddress, false), 10120);
            return;
        }
        DealBreakdownAddress dealbreakdownaddress1 = defaultShippingAddress;
        DealBreakdownAddress dealbreakdownaddress;
        if (shippingService.isStored())
        {
            dealbreakdownaddress = shippingService.getAddressFromPrefs();
        } else
        {
            dealbreakdownaddress = null;
        }
        startActivityForResult(getShippingAddressIntent(dealbreakdownaddress1, dealbreakdownaddress, false), 10119);
    }

    private String formatReservationDate(Date date)
    {
        int i = reservationDetails.partySize;
        String s = Strings.toString(internetUsDateFormat.format("MMM d, yyyy h:mma", date, TimeZone.getTimeZone(reservationDetails.timezone)));
        date = s;
        if (i > 0)
        {
            date = getString(0x7f080510, new Object[] {
                getResources().getQuantityString(0x7f0c0015, i, new Object[] {
                    Integer.valueOf(i)
                }), s
            });
        }
        return date;
    }

    private void getAddressInfoLatam(DealBreakdownAddress dealbreakdownaddress)
    {
        if (currentCountryManager.getCurrentCountry().isChile() || currentCountryManager.getCurrentCountry().isColombia())
        {
            getDisplayedAddressAndRefreshCLCO(dealbreakdownaddress);
            return;
        } else
        {
            getDisplayedAddressAndRefreshLatAm(dealbreakdownaddress);
            return;
        }
    }

    private List getAvailableCCPaymentMethodsArrayForDeal()
    {
        Object obj;
        if (dealPaymentMethodsNameTypePairs == null || dealPaymentMethodsNameTypePairs.size() == 0)
        {
            obj = null;
        } else
        {
            ArrayList arraylist = new ArrayList();
            obj = dealPaymentMethodsNameTypePairs.keySet().iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                String s = (String)((Iterator) (obj)).next();
                if (Strings.equalsIgnoreCase(dealPaymentMethodsNameTypePairs.get(s), "payment_method_type_credit_card"))
                {
                    arraylist.add(s);
                }
            } while (true);
            obj = arraylist;
            if (arraylist.size() <= 0)
            {
                return null;
            }
        }
        return ((List) (obj));
    }

    private View getBasicListItem(ViewGroup viewgroup, int i, String s, String s1, int j, android.view.View.OnClickListener onclicklistener)
    {
        return getBasicListItem(viewgroup, i, s, s1, j, onclicklistener, false);
    }

    private View getBasicListItem(ViewGroup viewgroup, int i, String s, String s1, int j, android.view.View.OnClickListener onclicklistener, boolean flag)
    {
        if (i <= 0) goto _L2; else goto _L1
_L1:
        View view;
        view = inflater.inflate(i, viewgroup, false);
        TextView textview = (TextView)view.findViewById(0x7f1002d3);
        if (textview != null)
        {
            if (Strings.notEmpty(s))
            {
                textview.setText(s);
                if (flag)
                {
                    i = getResources().getColor(0x7f0e015b);
                } else
                {
                    i = textview.getCurrentTextColor();
                }
                textview.setTextColor(i);
            }
            if (Strings.notEmpty(s))
            {
                i = 0;
            } else
            {
                i = 8;
            }
            textview.setVisibility(i);
        }
        s = (TextView)view.findViewById(0x7f100249);
        if (s != null)
        {
            if (Strings.notEmpty(s1))
            {
                s.setText(s1);
            }
            if (Strings.notEmpty(s1) || j != 0)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            s.setVisibility(i);
            if (j != 0)
            {
                if (deviceInfoUtil.isRTLLanguage())
                {
                    s.setCompoundDrawablesWithIntrinsicBounds(j, 0, 0, 0);
                } else
                {
                    s.setCompoundDrawablesWithIntrinsicBounds(0, 0, j, 0);
                }
            }
        }
        if (onclicklistener == null) goto _L4; else goto _L3
_L3:
        view.setClickable(true);
        view.setFocusable(true);
        view.setFocusableInTouchMode(false);
        view.setOnClickListener(onclicklistener);
_L5:
        viewgroup.addView(view);
        return view;
_L4:
        view.setClickable(false);
        view.setFocusable(false);
        view.setFocusableInTouchMode(false);
        s = (ImageView)view.findViewById(0x7f100182);
        if (s != null)
        {
            s.setVisibility(4);
        }
        if (true) goto _L5; else goto _L2
_L2:
        return null;
    }

    private String[] getCustomFieldPossibleValues(String s)
    {
label0:
        {
            Object obj = option.customFields;
            if (obj == null || ((Collection) (obj)).size() <= 0)
            {
                break label0;
            }
            obj = ((Collection) (obj)).iterator();
            CustomField customfield;
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break label0;
                }
                customfield = (CustomField)((Iterator) (obj)).next();
            } while (!Strings.equals(customfield.label, s));
            return customfield.getPossibleValuesArray();
        }
        return null;
    }

    private HashMap getCustomFieldRequiredMap()
    {
        Object obj = option.customFields;
        if (obj != null && ((Collection) (obj)).size() > 0)
        {
            HashMap hashmap = new HashMap();
            Iterator iterator = ((Collection) (obj)).iterator();
            do
            {
                obj = hashmap;
                if (!iterator.hasNext())
                {
                    break;
                }
                obj = (CustomField)iterator.next();
                hashmap.put(((CustomField) (obj)).label, Boolean.valueOf(((CustomField) (obj)).required));
            } while (true);
        } else
        {
            obj = null;
        }
        return ((HashMap) (obj));
    }

    private ImageUrl getDealImageUrl()
    {
        if (buyUtils.showOptionsWithImages(deal, this) && !option.images.isEmpty())
        {
            String s = ((Image)option.images.iterator().next()).url;
            boolean flag;
            if (!currentCountryManager.getCurrentCountry().isJapan())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            return new ImageUrl(s, flag);
        }
        if (Strings.notEmpty(deal.derivedImageUrl))
        {
            return new ImageUrl(deal.derivedImageUrl, true);
        } else
        {
            return new ImageUrl(deal.largeImageUrl, false);
        }
    }

    private AbstractPaymentMethod getDefaultPaymentMethod(List list, String s)
    {
        list = billingService.getListOfPaymentMethods(list, deal, option, currentlySelectedQuantity, volatileBillingInfoProvider, isUsingCredits());
        if (shouldDisplayGoogleWallet())
        {
            addGoogleWalletPaymentMethod(s, list);
        }
        return billingService.getDefaultPaymentMethod(list, s);
    }

    private Intent getDeliveryAddressesIntent()
    {
        return intentFactory.newDeliveryAddressesIntent(dealId, dealOptionId, channel).putExtra("firstShippingAddress", defaultShippingAddress).putExtra("isShippingAddress", hasAddresses);
    }

    private void getDisplayedAddressAndRefresh(DealBreakdownAddress dealbreakdownaddress)
    {
        String s = shippingService.getAsJoin(dealbreakdownaddress);
        dealbreakdownaddress = s;
        if (s.startsWith(", "))
        {
            dealbreakdownaddress = s.replaceFirst(", ", "");
        }
        displayedShippingAddress = dealbreakdownaddress;
        handleOrderDetailsSection();
    }

    private void getDisplayedAddressAndRefreshCLCO(final DealBreakdownAddress address)
    {
        displayedShippingAddress = "";
        shippingService.getShippingFieldsCLCO(dealId, new Function1() {

            final Purchase this$0;
            final DealBreakdownAddress val$address;

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((List)obj);
            }

            public void execute(List list)
                throws RuntimeException
            {
                Object obj = shippingService.getSpecialShippingFieldsCLCO(list);
                list = ((SpecialShippingFieldsCLCO) (obj)).getAvailableRegionsForCurrentDeal();
                obj = ((SpecialShippingFieldsCLCO) (obj)).getAvailableLocationsForCurrentDeal();
                String s1 = address.shipping_state;
                if (list.contains(s1))
                {
                    list = (List)((HashMap) (obj)).get(s1);
                    if (list != null && list.size() > 0)
                    {
                        boolean flag1 = false;
                        list = list.iterator();
                        boolean flag;
                        do
                        {
                            flag = flag1;
                            if (!list.hasNext())
                            {
                                break;
                            }
                            if (!Strings.equals(((ShippingSelectValue)list.next()).value, address.shipping_district))
                            {
                                continue;
                            }
                            flag = true;
                            break;
                        } while (true);
                        if (flag)
                        {
                            String s = address.locationString;
                            Purchase purchase = Purchase.this;
                            list = s;
                            if (s.startsWith(", "))
                            {
                                list = s.replaceFirst(", ", "");
                            }
                            purchase.displayedShippingAddress = list;
                            handleOrderDetailsSection();
                            return;
                        } else
                        {
                            handleBadAddress();
                            return;
                        }
                    } else
                    {
                        handleBadAddress();
                        return;
                    }
                } else
                {
                    handleBadAddress();
                    return;
                }
            }

            
            {
                this$0 = Purchase.this;
                address = dealbreakdownaddress;
                super();
            }
        }, null, null);
    }

    private void getDisplayedAddressAndRefreshJapan(DealBreakdownAddress dealbreakdownaddress, int i)
    {
        if (dealbreakdownaddress.isMaster())
        {
            userAddress = dealbreakdownaddress;
            displayedUserAddress = shippingService.getAsJoin(dealbreakdownaddress);
            handleOrderDetailsSection();
        }
        if (Strings.equals(dealbreakdownaddress.id, prefs.getString("preferredShippingLocationId", "")) || i == 1 && dealbreakdownaddress.isMaster())
        {
            shippingAddress = dealbreakdownaddress;
            if (!prefs.contains("preferredShippingLocationId"))
            {
                shippingService.store(dealbreakdownaddress.id);
            }
            displayedShippingAddress = shippingService.getAsJoin(dealbreakdownaddress);
            handleOrderDetailsSection();
        }
    }

    private void getDisplayedAddressAndRefreshLatAm(final DealBreakdownAddress address)
    {
        shippingService.getLocationsByPostalCodeMX(this, address.shipping_postal_code, new Function1() {

            final Purchase this$0;
            final DealBreakdownAddress val$address;

            public void execute(RegionMX regionmx)
            {
                String s = shippingService.getAsJoin(address, regionmx.stateName, regionmx.name);
                Purchase purchase = Purchase.this;
                regionmx = s;
                if (s.startsWith(", "))
                {
                    regionmx = s.replaceFirst(", ", "");
                }
                purchase.displayedShippingAddress = regionmx;
                handleOrderDetailsSection();
            }

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((RegionMX)obj);
            }

            
            {
                this$0 = Purchase.this;
                address = dealbreakdownaddress;
                super();
            }
        }, null, null);
    }

    private String[] getInstallmentOptionsAsStringArray(DealBreakdownTenderItem dealbreakdowntenderitem)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(getString(0x7f08023b, new Object[] {
            Integer.valueOf(1), currencyFormatter.format(dealbreakdowntenderitem.amount, true, com.groupon.util.CurrencyFormatter.DecimalStripBehavior.Never)
        }));
        dealbreakdowntenderitem = currentAvailableInstallmentOptionsForCardType;
        int j = dealbreakdowntenderitem.length;
        for (int i = 0; i < j; i++)
        {
            Object obj = dealbreakdowntenderitem[i];
            arraylist.add(getString(0x7f08023b, new Object[] {
                Integer.valueOf(((DealBreakdownPaymentMethodInstallmentItem) (obj)).numberOfPayments), currencyFormatter.format(((DealBreakdownPaymentMethodInstallmentItem) (obj)).amount, true, com.groupon.util.CurrencyFormatter.DecimalStripBehavior.Never)
            }));
        }

        return (String[])arraylist.toArray(new String[0]);
    }

    private DealBreakdownPaymentMethodInstallmentItem[] getInstallmentOptionsForCardType()
    {
        Object obj = currentPaymentMethod.getBillingRecord().paymentType;
        Object obj1 = currentPaymentMethod.getBillingRecord().cardType;
        Object obj2;
        Iterator iterator;
        if (!Strings.notEmpty(obj))
        {
            if (Strings.notEmpty(obj1))
            {
                obj = obj1;
            } else
            {
                obj = null;
            }
        }
        obj1 = currentBreakdown.paymentMethods;
        obj2 = null;
        iterator = ((List) (obj1)).iterator();
        do
        {
            obj1 = obj2;
            if (!iterator.hasNext())
            {
                break;
            }
            obj1 = (DealBreakdownPaymentMethodItem)iterator.next();
            if (((DealBreakdownPaymentMethodItem) (obj1)).installments == null || !Strings.equalsIgnoreCase(((DealBreakdownPaymentMethodItem) (obj1)).name, obj))
            {
                continue;
            }
            obj1 = (DealBreakdownPaymentMethodInstallmentItem[])((DealBreakdownPaymentMethodItem) (obj1)).installments.toArray(new DealBreakdownPaymentMethodInstallmentItem[0]);
            break;
        } while (true);
        if (obj1 != null)
        {
            obj = new ArrayList();
            int j = obj1.length;
            for (int i = 0; i < j; i++)
            {
                Object obj3 = obj1[i];
                GenericAmount genericamount = ((DealBreakdownPaymentMethodInstallmentItem) (obj3)).amount;
                GenericAmount genericamount1 = ((DealBreakdownPaymentMethodInstallmentItem) (obj3)).totalAmount;
                if (genericamount != null && genericamount1 != null && Strings.notEmpty(genericamount.getFormattedAmount()) && Strings.notEmpty(genericamount1.getFormattedAmount()))
                {
                    ((List) (obj)).add(obj3);
                }
            }

            if (((List) (obj)).size() > 0)
            {
                return (DealBreakdownPaymentMethodInstallmentItem[])((List) (obj)).toArray(new DealBreakdownPaymentMethodInstallmentItem[0]);
            } else
            {
                return null;
            }
        } else
        {
            return null;
        }
    }

    private boolean getIsGoodsDeal()
    {
        for (Iterator iterator = deal.getChannelList().iterator(); iterator.hasNext();)
        {
            Channel channel1 = (Channel)iterator.next();
            if (Channel.GOODS == channel1)
            {
                return true;
            }
        }

        return false;
    }

    private Intent getPaymentMethodIntent()
    {
        if (currentCountryManager.getCurrentCountry().acceptsOtherPayments())
        {
            return intentFactory.newMyCreditCardIntent(dealId, dealOptionId, channel, 0, null, null, null, dealPaymentMethodsNameTypePairs, storageConsentRequirements);
        } else
        {
            return intentFactory.newEditCreditCardIntent(getAvailableCCPaymentMethodsArrayForDeal(), channel, storageConsentRequirements);
        }
    }

    private String getReservationDetailsHeaderText()
    {
        if (DealUtils.isFoodAndDrinkDeal(deal))
        {
            return getString(0x7f08032e);
        }
        if (DealUtils.isHealthBeautyWellnessDeal(deal))
        {
            return getString(0x7f080068);
        } else
        {
            return "";
        }
    }

    private Intent getShippingAddressIntent()
    {
        return intentFactory.newShippingAddressIntent(defaultShippingAddress, hasAddresses, dealId, dealOptionId, channel);
    }

    private Intent getShippingAddressIntent(DealBreakdownAddress dealbreakdownaddress, DealBreakdownAddress dealbreakdownaddress1, boolean flag)
    {
        return intentFactory.newShippingAddressIntent(dealbreakdownaddress, dealbreakdownaddress1, flag, dealId, option.remoteId, channel, 0, null, null, null);
    }

    private void handleAddressesIntl(List list, String s)
    {
label0:
        {
            if (currentCountryManager.getCurrentCountry().isJapan())
            {
                for (s = list.iterator(); s.hasNext(); getDisplayedAddressAndRefreshJapan((DealBreakdownAddress)s.next(), list.size())) { }
                break label0;
            }
            list = list.iterator();
            DealBreakdownAddress dealbreakdownaddress;
            do
            {
                if (!list.hasNext())
                {
                    break label0;
                }
                dealbreakdownaddress = (DealBreakdownAddress)list.next();
            } while (!Strings.equals(dealbreakdownaddress.id, s));
            getDisplayedAddressAndRefresh(dealbreakdownaddress);
        }
    }

    private void handleAddressesLatam(List list, String s)
    {
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            DealBreakdownAddress dealbreakdownaddress = (DealBreakdownAddress)list.next();
            if (!Strings.equals(dealbreakdownaddress.id, s))
            {
                continue;
            }
            getAddressInfoLatam(dealbreakdownaddress);
            break;
        } while (true);
    }

    private void handleAdjustments(List list, List list1)
    {
        int i;
        boolean flag;
        boolean flag1;
        if (list != null && list.size() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (list1 != null && list1.size() > 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag1)
        {
            i = list1.size();
        } else
        {
            i = -1;
        }
        Ln.d("BREAKDOWN: handleAdjustments, adj = %s, credits = %s (size %d)", new Object[] {
            Boolean.valueOf(flag), Boolean.valueOf(flag1), Integer.valueOf(i)
        });
        if (isBookableDeal())
        {
            i = 0x7f0300f8;
        } else
        if (isNewCheckout1408)
        {
            i = 0x7f0301af;
        } else
        {
            i = 0x7f03019e;
        }
        if (flag || flag1)
        {
            if (flag)
            {
                for (Iterator iterator = list.iterator(); iterator.hasNext();)
                {
                    DealBreakdownAdjustment dealbreakdownadjustment = (DealBreakdownAdjustment)iterator.next();
                    if (isNewCheckout1408)
                    {
                        GenericAmount genericamount1 = dealbreakdownadjustment.amount;
                        int j;
                        if (genericamount1.getAmount() == 0 && Strings.equalsIgnoreCase(dealbreakdownadjustment.type, "shipping"))
                        {
                            list = getString(0x7f0801d4);
                        } else
                        {
                            list = currencyFormatter.format(genericamount1, true, com.groupon.util.CurrencyFormatter.DecimalStripBehavior.Never);
                        }
                        if (genericamount1.getAmount() == 0 && Strings.equalsIgnoreCase(dealbreakdownadjustment.type, "shipping"))
                        {
                            j = getResources().getColor(0x7f0e00c1);
                        } else
                        {
                            j = 0;
                        }
                        addPurchaseActionItem(dealPaymentContainer, i, dealbreakdownadjustment.name, list, j, 0, false, null);
                    } else
                    {
                        getBasicListItem(dealPaymentContainer, i, dealbreakdownadjustment.name, currencyFormatter.format(dealbreakdownadjustment.amount, true, com.groupon.util.CurrencyFormatter.DecimalStripBehavior.Never), 0, null);
                    }
                }

            }
            if (flag1 && isUsingCredits() && selectedIncentiveTicket == null)
            {
                Ln.d("BREAKDOWN: has credits", new Object[0]);
                list1 = list1.iterator();
                do
                {
                    if (!list1.hasNext())
                    {
                        break;
                    }
                    GenericAmount genericamount = ((DealBreakdownTenderItem)list1.next()).amount;
                    Ln.d("BREAKDOWN: credit: %d", new Object[] {
                        Integer.valueOf(genericamount.getAmount())
                    });
                    if (Math.abs(genericamount.getAmount()) > 0)
                    {
                        CurrencyFormatter currencyformatter = currencyFormatter;
                        if (currentCountryManager.getCurrentCountry().isJapan())
                        {
                            list = com.groupon.util.CurrencyFormatter.DecimalStripBehavior.Always;
                        } else
                        {
                            list = com.groupon.util.CurrencyFormatter.DecimalStripBehavior.Never;
                        }
                        list = currencyformatter.format(genericamount, true, list);
                        Ln.d("BREAKDOWN: handleAdjustments, credit = %s", new Object[] {
                            list
                        });
                        if (isNewCheckout1408)
                        {
                            addPurchaseActionItem(dealPaymentContainer, i, GROUPON_BUCKS, list, 0, false, null);
                        } else
                        {
                            getBasicListItem(dealPaymentContainer, i, GROUPON_BUCKS, list, 0, null);
                        }
                    }
                } while (true);
            }
        }
    }

    private void handleBadAddress()
    {
        displayedShippingAddress = ENTER_SHIPPING_ADDRESS;
        handleOrderDetailsSection();
    }

    private void handleBillingRecords(List list)
    {
        Object obj = loginPrefs.getString("currentBillingRecordId", null);
        setCurrentPaymentMethod(billingService.getDefaultPaymentMethod(null, ((String) (obj))));
        obj = getDefaultPaymentMethod(list, ((String) (obj)));
        if (obj instanceof GoogleWalletPaymentMethod)
        {
            googleWalletService.checkForPreAuthorization(this);
        }
        setCurrentPaymentMethod(((AbstractPaymentMethod) (obj)));
        if (list.size() > 0 && currentCountryManager.getCurrentCountry().isUSACompatible())
        {
            defaultShippingAddress = billingService.getShippingAddress(list);
        }
        haveCheckedBillingRecords = true;
    }

    private void handleBottomBarTotal(GenericAmount genericamount, boolean flag)
    {
        if (isNewCheckout1408)
        {
            String s = getString(0x7f0803e4);
            Object obj1 = currencyFormatter;
            Object obj;
            String s1;
            int i;
            if (currentCountryManager.getCurrentCountry().isJapan())
            {
                obj = com.groupon.util.CurrencyFormatter.DecimalStripBehavior.Always;
            } else
            {
                obj = com.groupon.util.CurrencyFormatter.DecimalStripBehavior.Never;
            }
            s1 = ((CurrencyFormatter) (obj1)).format(genericamount, true, ((com.groupon.util.CurrencyFormatter.DecimalStripBehavior) (obj)));
            obj1 = s;
            obj = s1;
            if (currentPaymentMethod != null)
            {
                obj1 = s;
                obj = s1;
                if (currentPaymentMethod.isCreditCard())
                {
                    obj1 = s;
                    obj = s1;
                    if (currentAvailableInstallmentOptionsForCardType != null)
                    {
                        obj1 = s;
                        obj = s1;
                        if (currentAvailableInstallmentOptionsForCardType.length > 0)
                        {
                            obj1 = getString(0x7f08023c);
                            if (currentlySelectedInstallmentOption != null)
                            {
                                obj = currencyFormatter.format(currentlySelectedInstallmentOption.totalAmount, true, com.groupon.util.CurrencyFormatter.DecimalStripBehavior.Never);
                            } else
                            {
                                obj = currencyFormatter.format(genericamount, true, com.groupon.util.CurrencyFormatter.DecimalStripBehavior.Never);
                            }
                        }
                    }
                }
            }
            bottomBarTotalContainer.setVisibility(0);
            bottomBarTotalLabel.setText(((CharSequence) (obj1)));
            bottomBarTotalValue.setText(((CharSequence) (obj)));
            genericamount = bottomBarTaxAndShippingLabel;
            if (flag)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            genericamount.setVisibility(i);
        }
    }

    private void handleCashTender(final DealBreakdownTenderItem tender)
    {
        int i;
        boolean flag;
        if (currentPaymentMethod != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        amountChargedToCreditCardInCents = 0;
        Ln.d("BREAKDOWN: cash handleCashTender, tender = %s", new Object[] {
            tender
        });
        if (tender != null)
        {
            GenericAmount genericamount = tender.amount;
            amountChargedToCreditCardInCents = genericamount.getAmount();
            Ln.d("BREAKDOWN: cash handleCashTender, amountInCents = %d, hasBillingRecord = %s, usingCredits = %s", new Object[] {
                Integer.valueOf(amountChargedToCreditCardInCents), Boolean.valueOf(flag), Boolean.valueOf(isUsingCredits())
            });
            Object obj = PAYMENT_METHOD;
            Object obj1;
            CurrencyFormatter currencyformatter;
            if (amountChargedToCreditCardInCents == 0)
            {
                obj = AMOUNT_DUE;
            } else
            if (flag && currentPaymentMethod.isCreditCard())
            {
                obj = BillingService.getCardTypeName(this, currentPaymentMethod);
            } else
            if (flag)
            {
                obj = ((ECommercePaymentMethod)currentPaymentMethod).getDisplayName();
            }
            obj1 = obj;
            if (Strings.isEmpty(obj))
            {
                obj1 = AMOUNT_DUE;
            }
            Ln.d("BREAKDOWN: cash handleCashTender label = %s", new Object[] {
                obj1
            });
            currencyformatter = currencyFormatter;
            if (currentCountryManager.getCurrentCountry().isJapan())
            {
                obj = com.groupon.util.CurrencyFormatter.DecimalStripBehavior.Always;
            } else
            {
                obj = com.groupon.util.CurrencyFormatter.DecimalStripBehavior.Never;
            }
            obj = currencyformatter.format(genericamount, true, ((com.groupon.util.CurrencyFormatter.DecimalStripBehavior) (obj)));
            if (shouldShowInstallments())
            {
                i = 0x7f0301b1;
            } else
            if (isNewCheckout1408)
            {
                if (showTotalPriceBookingComment())
                {
                    i = 0x7f0301b0;
                } else
                {
                    i = 0x7f0301b2;
                }
            } else
            if (showTotalPriceBookingComment())
            {
                i = 0x7f0301b4;
            } else
            {
                i = 0x7f0301b3;
            }
            if (isNewCheckout1408)
            {
                obj = addPurchaseActionItem(dealPaymentContainer, i, getString(0x7f0803e4), ((CharSequence) (obj)), 0, false, null);
            } else
            {
                obj = getBasicListItem(dealPaymentContainer, i, getString(0x7f0803e4), ((String) (obj)), 0, null);
            }
            if (i == 0x7f0301b0 || i == 0x7f0301b4)
            {
                setTotalPriceComment(((View) (obj)));
            }
            if (isNewCheckout1408 && !shouldShowJapanIncentiveTickets())
            {
                addPaymentSeparatorMarginTop();
            } else
            {
                addPaymentSeparator();
            }
            if (!isNewCheckout1408 && !currentCountryManager.getCurrentCountry().isRussia())
            {
                addPaymentSeparator();
                LinearLayout linearlayout = dealPaymentContainer;
                if ((amountChargedToCreditCardInCents > 0 || isUsingCredits()) && !deal.isApplyButton)
                {
                    obj = new android.view.View.OnClickListener() {

                        final Purchase this$0;

                        public void onClick(View view)
                        {
                            onChangePaymentMethod();
                            currentlySelectedInstallmentOption = null;
                        }

            
            {
                this$0 = Purchase.this;
                super();
            }
                    };
                } else
                {
                    obj = null;
                }
                obj = getBasicListItem(linearlayout, 0x7f0301aa, null, ((String) (obj1)), 0, ((android.view.View.OnClickListener) (obj)));
                Ln.d("BREAKDOWN: cash handleCashTender, view = %s", new Object[] {
                    obj
                });
                obj1 = ((View) (obj)).findViewById(0x7f100182);
                if (deal.isApplyButton)
                {
                    i = 8;
                } else
                {
                    i = 0;
                }
                ((View) (obj1)).setVisibility(i);
                obj1 = (TextView)((View) (obj)).findViewById(0x7f10049c);
                if (currentPaymentMethod != null && currentPaymentMethod.isCreditCard() && billingRecordExpiryChecker.isBillingRecordExpired(currentPaymentMethod.getBillingRecord()))
                {
                    i = 0;
                } else
                {
                    i = 8;
                }
                ((TextView) (obj1)).setVisibility(i);
                obj1 = ((View) (obj)).findViewById(0x7f1003b4);
                if (obj1 != null)
                {
                    if (flag && amountChargedToCreditCardInCents > 0)
                    {
                        i = 1;
                    } else
                    {
                        i = 0;
                    }
                    if (i != 0)
                    {
                        if (currentPaymentMethod.isCreditCard() && !googleWalletService.isGoogleWalletPaymentMethod(currentPaymentMethod))
                        {
                            CreditCardIconHelper.createCreditCardIcon(currentPaymentMethod.getBillingRecord(), (TextView)obj1, com.groupon.view.CreditCardIconHelper.IconType.REDESIGNED);
                            if (currentCountryManager.getCurrentCountry().isJapan())
                            {
                                ((TextView)obj1).setTextColor(getResources().getColor(0x7f0e01a9));
                                int j;
                                if (currentPaymentMethod.isVolatile())
                                {
                                    j = 0x7f020242;
                                } else
                                {
                                    j = 0x7f020241;
                                }
                                ((View) (obj1)).setBackgroundResource(j);
                            }
                        } else
                        {
                            CreditCardIconHelper.createCreditCardIcon(currentPaymentMethod.getId(), ((View) (obj1)), com.groupon.view.CreditCardIconHelper.IconType.REDESIGNED);
                        }
                    }
                    if (i != 0)
                    {
                        i = 0;
                    } else
                    {
                        i = 8;
                    }
                    ((View) (obj1)).setVisibility(i);
                }
                obj = (TextView)((View) (obj)).findViewById(0x7f1002d3);
                if (obj != null && currentPaymentMethod != null && currentPaymentMethod.isEcommercePayment())
                {
                    if (amountChargedToCreditCardInCents == 0)
                    {
                        i = 0;
                    } else
                    {
                        i = 8;
                    }
                    ((TextView) (obj)).setVisibility(i);
                }
            }
            if (currentPaymentMethod != null && currentPaymentMethod.isCreditCard() && currentPaymentMethod.isOneClickRecurring())
            {
                if (isNewCheckout1408)
                {
                    if (!isReenterCvvAdded())
                    {
                        customFieldMap.put(CVV_STRING, null);
                    }
                } else
                {
                    addPaymentSeparator();
                    getBasicListItem(dealPaymentContainer, 0x7f0301a0, REENTER_CVV, Strings.toString(customFieldMap.get(CVV_STRING)), 0, new android.view.View.OnClickListener() {

                        final Purchase this$0;

                        public void onClick(View view)
                        {
                            onCustomFieldClick(CVV_STRING);
                        }

            
            {
                this$0 = Purchase.this;
                super();
            }
                    });
                }
            } else
            if (isNewCheckout1408 && isReenterCvvAdded())
            {
                customFieldMap.remove(CVV_STRING);
                customFieldViewsMap.remove(CVV_STRING);
            }
            if (shouldShowInstallments())
            {
                if (currentlySelectedInstallmentOption != null)
                {
                    obj = getString(0x7f08023b, new Object[] {
                        Integer.valueOf(currentlySelectedInstallmentOption.numberOfPayments), currencyFormatter.format(currentlySelectedInstallmentOption.amount, true, com.groupon.util.CurrencyFormatter.DecimalStripBehavior.Never)
                    });
                } else
                {
                    obj = getString(0x7f08023b, new Object[] {
                        Integer.valueOf(1), currencyFormatter.format(tender.amount, true, com.groupon.util.CurrencyFormatter.DecimalStripBehavior.Never)
                    });
                }
                addPaymentSeparator();
                if (isNewCheckout1408)
                {
                    addPurchaseActionItem(dealPaymentContainer, 0x7f03019a, getString(0x7f08023a), ((CharSequence) (obj)), 0, true, new android.view.View.OnClickListener() {

                        final Purchase this$0;
                        final DealBreakdownTenderItem val$tender;

                        public void onClick(View view)
                        {
                            showInstallmentOptionsDialog(tender);
                        }

            
            {
                this$0 = Purchase.this;
                tender = dealbreakdowntenderitem;
                super();
            }
                    });
                } else
                {
                    getBasicListItem(dealPaymentContainer, 0x7f0301a0, getString(0x7f08023a), ((String) (obj)), 0, new android.view.View.OnClickListener() {

                        final Purchase this$0;
                        final DealBreakdownTenderItem val$tender;

                        public void onClick(View view)
                        {
                            showInstallmentOptionsDialog(tender);
                        }

            
            {
                this$0 = Purchase.this;
                tender = dealbreakdowntenderitem;
                super();
            }
                    });
                }
                addPaymentSeparator();
                if (currentlySelectedInstallmentOption != null)
                {
                    tender = currencyFormatter.format(currentlySelectedInstallmentOption.totalAmount, true, com.groupon.util.CurrencyFormatter.DecimalStripBehavior.Never);
                } else
                {
                    tender = currencyFormatter.format(tender.amount, true, com.groupon.util.CurrencyFormatter.DecimalStripBehavior.Never);
                }
                if (isNewCheckout1408)
                {
                    addPurchaseActionItem(dealPaymentContainer, 0x7f0301b2, getString(0x7f08023c), tender, 0, false, null);
                } else
                {
                    getBasicListItem(dealPaymentContainer, 0x7f0301b3, getString(0x7f08023c), tender, 0, null);
                }
            }
        }
        if (currentPaymentMethod != null && currentPaymentMethod.isCreditCard() && amountChargedToCreditCardInCents > 0)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (!flag && i != 0)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        tender = addPaymentHintView;
        if (i != 0)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        tender.setVisibility(i);
        updatePurchaseButtonState();
    }

    private void handleCheckPreauthorizationRequestCode(int i, Intent intent)
    {
        boolean flag;
label0:
        {
            flag = intent.getBooleanExtra("com.google.android.gm.wallet.EXTRA_IS_USER_PREAUTHORIZED", false);
            if (i == -1)
            {
                if (googleWalletService.getMaskedWallet() != null)
                {
                    break label0;
                }
                if (!flag)
                {
                    loggingUtils.logGoogleWalletDialogImpression(channel, com/groupon/activity/Purchase.getSimpleName());
                }
            }
            return;
        }
        loggingUtils.loggGoogleWalletFutureUseImpression(channel, flag);
    }

    private void handleConfirmCreditCardRequestCode(int i, Intent intent)
    {
        if (intent == null)
        {
            validationCardNumber = null;
            hideProcessingFeedback();
            return;
        }
        if (i == 0)
        {
            validationCardNumber = intent.getStringExtra("validationCardNumber");
            purchaseButton.performClick();
            return;
        } else
        {
            validationCardNumber = null;
            hideProcessingFeedback();
            return;
        }
    }

    private void handleCredits(GenericAmount genericamount, List list)
    {
        if (isUsingCredits())
        {
            creditsAvailable = genericamount;
            incentiveTickets = list;
        }
    }

    private void handleDeepLinkError()
    {
        if (!shouldLaunchPurchasePage)
        {
            startActivity(intentFactory.newCarouselIntent());
        }
        finish();
    }

    private void handleDefaultOrderDetailsSection()
    {
        final int minCount = option.getMinimumPurchaseQuantity();
        Object obj;
        LinearLayout linearlayout;
        String s;
        final int maxCount;
        int k;
        if (stockValue != null)
        {
            maxCount = stockValue.maxStock - stockValue.soldQuantity;
        } else
        {
            maxCount = option.maximumPurchaseQuantity;
        }
        dealDetailsContainer.removeAllViews();
        if (reservationDetailsContainer != null && reservationDetails != null && reservationDetails.partySize > 0 && reservationDetails.startDateTime != null)
        {
            if (dateTimeFinderReservationDetails != null)
            {
                reservationDetailTitle.setText(getReservationDetailsHeaderText());
            }
            reservationDetailsContainer.removeAllViews();
            reservationContainer.setVisibility(0);
            getBasicListItem(reservationDetailsContainer, 0x7f0301b1, formatReservationDate(reservationDetails.startDateTime), null, 0, null);
        }
        if (currentlySelectedQuantity < minCount)
        {
            currentlySelectedQuantity = minCount;
        } else
        if (currentlySelectedQuantity > maxCount)
        {
            currentlySelectedQuantity = maxCount;
        }
        if (currentBreakdown != null)
        {
            int j = currentBreakdown.getBreakdownItem().quantity;
            Ln.d("BREAKDOWN: quantity, set current quantity based on breakdown: %d", new Object[] {
                Integer.valueOf(j)
            });
            currentlySelectedQuantity = j;
        }
        addDetailsSeparator();
        linearlayout = dealDetailsContainer;
        s = QUANTITY;
        k = currentlySelectedQuantity;
        if (maxCount < 2)
        {
            obj = null;
        } else
        {
            obj = new android.view.View.OnClickListener() {

                final Purchase this$0;
                final int val$maxCount;
                final int val$minCount;

                public void onClick(View view)
                {
                    onChangeQuantity(minCount, maxCount);
                }

            
            {
                this$0 = Purchase.this;
                minCount = i;
                maxCount = j;
                super();
            }
            };
        }
        getBasicListItem(linearlayout, 0x7f0301a0, s, String.valueOf(k), 0, ((android.view.View.OnClickListener) (obj)));
        if (shouldShowSendAsGift())
        {
            addDetailsSeparator();
            LinearLayout linearlayout1;
            String s1;
            boolean flag;
            if (giftingRecord != null)
            {
                obj = giftingRecord.recipientName;
            } else
            {
                obj = "";
            }
            if (option.giftWrappingCharge != null && option.giftWrappingCharge.amount != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            isGiftWrappable = flag;
            getBasicListItem(dealDetailsContainer, 0x7f03019f, SEND_AS_GIFT, ((String) (obj)), 0x7f020077, new GiftingOnClickListener());
        }
        if (currentCountryManager.getCurrentCountry().isJapan())
        {
            addDetailsSeparator();
            linearlayout1 = dealDetailsContainer;
            s1 = YOUR_ADDRESS;
            if (Strings.notEmpty(displayedUserAddress))
            {
                obj = displayedUserAddress;
            } else
            {
                obj = ENTER_YOUR_ADDRESS;
            }
            obj = (TextView)getBasicListItem(linearlayout1, 0x7f0301f3, s1, ((String) (obj)), 0, new android.view.View.OnClickListener() {

                final Purchase this$0;

                public void onClick(View view)
                {
                    startActivityForResult(getShippingAddressIntent(null, userAddress, true), 10120);
                }

            
            {
                this$0 = Purchase.this;
                super();
            }
            }).findViewById(0x7f10051b);
            if (obj != null)
            {
                if (isValidAddressTheSameAsOriginal)
                {
                    maxCount = 8;
                } else
                {
                    maxCount = 0;
                }
                ((TextView) (obj)).setVisibility(maxCount);
            }
        }
        if (isShippingAddressRequired())
        {
            addDetailsSeparator();
            flag = shippingService.isStored();
            obj = googleWalletService.getMaskedWalletShippingAddress();
            Object obj1;
            if (obj != null)
            {
                minCount = 1;
            } else
            {
                minCount = 0;
            }
            if (!flag)
            {
                if (googleWalletService.isGoogleWalletPaymentMethod(currentPaymentMethod))
                {
                    obj = shippingService.getAsJoin(((com.google.android.gms.wallet.Address) (obj)));
                } else
                {
                    obj = null;
                }
            } else
            if (currentCountryManager.getCurrentCountry().isUSACompatible())
            {
                obj = shippingService.getAsJoin(false);
            } else
            {
                obj = displayedShippingAddress;
            }
            if (Strings.notEmpty(obj))
            {
                maxCount = 0x7f0301f3;
            } else
            {
                maxCount = 0x7f0301a9;
            }
            if (!shouldShowAddShippingAddressPrompt())
            {
                if (currentCountryManager.getCurrentCountry().isUSACompatible())
                {
                    obj1 = SHIPPING_ADDRESS;
                } else
                {
                    obj1 = DELIVERY_ADDRESS;
                }
            } else
            {
                obj1 = ADD_SHIPPING_ADDRESS;
            }
            obj1 = getBasicListItem(dealDetailsContainer, maxCount, ((String) (obj1)), Strings.toString(obj), 0, new android.view.View.OnClickListener() {

                final Purchase this$0;

                public void onClick(View view)
                {
                    isValidAddressTheSameAsOriginal = true;
                    onShippingAddressClick();
                }

            
            {
                this$0 = Purchase.this;
                super();
            }
            });
            if (currentCountryManager.getCurrentCountry().isChile() || currentCountryManager.getCurrentCountry().isColombia())
            {
                if (Strings.equals(ENTER_SHIPPING_ADDRESS, displayedShippingAddress))
                {
                    maxCount = 0;
                } else
                {
                    maxCount = 1;
                }
            } else
            {
                maxCount = 1;
            }
            obj1 = (TextView)((View) (obj1)).findViewById(0x7f10051b);
            if (obj1 != null)
            {
                if ((flag || minCount != 0) && maxCount != 0)
                {
                    if (isValidAddressTheSameAsOriginal)
                    {
                        maxCount = 8;
                    } else
                    {
                        maxCount = 0;
                    }
                    ((TextView) (obj1)).setVisibility(maxCount);
                    if (shippingInfoIsInvalid)
                    {
                        maxCount = 0x7f0802df;
                    } else
                    {
                        maxCount = 0x7f0802e0;
                    }
                    ((TextView) (obj1)).setText(maxCount);
                    if (shippingInfoIsInvalid)
                    {
                        maxCount = getResources().getColor(0x7f0e015b);
                    } else
                    {
                        maxCount = getResources().getColor(0x7f0e01bb);
                    }
                    ((TextView) (obj1)).setTextColor(maxCount);
                } else
                {
                    int i;
                    if (Strings.notEmpty(obj))
                    {
                        i = 0;
                    } else
                    {
                        i = 8;
                    }
                    ((TextView) (obj1)).setVisibility(i);
                    ((TextView) (obj1)).setText(ERROR_MISSING_SHIPPING_ADDRESS);
                    ((TextView) (obj1)).setTextColor(getResources().getColor(0x7f0e01bb));
                }
            }
        }
        addCustomFieldItemsOldDesign(dealDetailsContainer);
        updateStockControl();
    }

    private void handleException(Exception exception)
    {
        Ln.w(exception);
        showDialog(dialogManager.getDialogFragment(Integer.valueOf(0x7f080165)), "http_error_dialog");
    }

    private void handleGetawaysOrderDetailsSection()
    {
        if (userInputActionContainer == null)
        {
            return;
        } else
        {
            userInputActionContainer.removeAllViews();
            addSeparator(userInputActionContainer, false);
            addCustomFieldItemsOldDesign(userInputActionContainer);
            return;
        }
    }

    private void handleGiftingRequestCode(int i, Intent intent)
    {
        switch (i)
        {
        default:
            giftingRecord = null;
            // fall through

        case 0: // '\0'
            return;

        case -1: 
            giftingRecord = (GiftingRecord)intent.getParcelableExtra("giftingRecord");
            break;
        }
    }

    private void handleGoogleWalletErrors(Intent intent)
    {
        int i;
label0:
        {
            if (intent != null)
            {
                i = intent.getIntExtra("com.google.android.gms.wallet.EXTRA_ERROR_CODE", -1);
                if (i != -1)
                {
                    switch (i)
                    {
                    default:
                        Ln.d((new StringBuilder()).append("Google Wallet Error: Error code - ").append(i).toString(), new Object[0]);
                        googleWalletService.postponeShowGoogleWalletGenericErrorDialog();
                        break;

                    case 406: 
                        break label0;
                    }
                }
            }
            return;
        }
        Ln.d((new StringBuilder()).append("Google Wallet Error: ERROR_CODE_SPENDING_LIMIT_EXCEEDED - ").append(i).toString(), new Object[0]);
        googleWalletService.postponeShowGoogleWalletMaxAmountErrorDialog();
    }

    private void handleLoadFullWalletRequestCode(int i, Intent intent)
    {
        switch (i)
        {
        default:
            handleGoogleWalletErrors(intent);
            hideProcessingFeedback();
            setIsOrdersCallInProgress(false);
            return;

        case -1: 
            break;
        }
        if (intent.hasExtra("com.google.android.gms.wallet.EXTRA_FULL_WALLET"))
        {
            intent = (FullWallet)intent.getParcelableExtra("com.google.android.gms.wallet.EXTRA_FULL_WALLET");
            googleWalletService.onFullWalletResponse(intent);
            (new ClickMetadata()).dealId = dealId;
            loggingUtils.logClick("", "save_cc_info", getClass().getName(), dealId, "");
            userManager.saveBillingRecord(null, googleWalletService.getWalletBillingRecordParams(), new Function1() {

                final Purchase this$0;

                public void execute(BillingRecordContainer billingrecordcontainer)
                {
                    if (billingrecordcontainer != null)
                    {
                        currentPaymentMethod.setBillingRecord(billingrecordcontainer.billingRecord);
                        onPurchaseButtonClick();
                    }
                }

                public volatile void execute(Object obj)
                    throws Exception
                {
                    execute((BillingRecordContainer)obj);
                }

            
            {
                this$0 = Purchase.this;
                super();
            }
            }, new ReturningFunction1() {

                final Purchase this$0;

                public Boolean execute(Exception exception)
                {
                    if ((exception instanceof HttpResponseException) && ((HttpResponseException)exception).getStatusCode() == 401)
                    {
                        return Boolean.valueOf(true);
                    } else
                    {
                        hideProcessingFeedback();
                        setIsOrdersCallInProgress(false);
                        googleWalletService.setFullWallet(null);
                        return Boolean.valueOf(true);
                    }
                }

                public volatile Object execute(Object obj)
                    throws Exception
                {
                    return execute((Exception)obj);
                }

            
            {
                this$0 = Purchase.this;
                super();
            }
            }, null, null);
            return;
        }
        if (intent.hasExtra("com.google.android.gms.wallet.EXTRA_MASKED_WALLET"))
        {
            intent = (MaskedWallet)intent.getParcelableExtra("com.google.android.gms.wallet.EXTRA_MASKED_WALLET");
            googleWalletService.onMaskedWalletResponse(intent, -1);
            triggerFullWalletRequest();
            return;
        } else
        {
            hideProcessingFeedback();
            setIsOrdersCallInProgress(false);
            return;
        }
    }

    private void handleMaskedWalletRequest(int i, Intent intent, boolean flag)
    {
        setIsRefreshing(false);
        buyWithGoogleButton.stopProgress();
        i;
        JVM INSTR tableswitch -1 -1: default 32
    //                   -1 105;
           goto _L1 _L2
_L1:
        handleGoogleWalletErrors(intent);
        setIsRefreshingGoogleWallet(false);
        if (!flag)
        {
            googleWalletService.onMaskedWalletResponse(null, 0);
            purchaseButton.setVisibility(8);
            toggleBuyWithGoogleButton(true);
            if (i == 0)
            {
                loggingUtils.logGoogleWalletDialogCancelClick(channel, PURCHASE_PAGE_ID);
            }
        }
_L4:
        if (!flag)
        {
            refreshDealBreakdowns();
        }
        googleWalletService.checkForPreAuthorization(this);
        return;
_L2:
        intent = (MaskedWallet)intent.getParcelableExtra("com.google.android.gms.wallet.EXTRA_MASKED_WALLET");
        googleWalletService.onMaskedWalletResponse(intent, -1);
        if (intent != null && Strings.notEmpty(intent.getGoogleTransactionId()))
        {
            setIsRefreshingGoogleWallet(false);
            purchaseButton.setVisibility(0);
            toggleBuyWithGoogleButton(false);
            if (flag)
            {
                setIsRefreshing(true);
                refreshDealBreakdowns();
            }
        }
        loggingUtils.logGoogleWalletDialogContinueClick(channel, PURCHASE_PAGE_ID);
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void handleOrderDetailsSection()
    {
        if (isBookableDeal())
        {
            handleGetawaysOrderDetailsSection();
            return;
        }
        if (isNewCheckout1408)
        {
            handleUserInputSection();
            return;
        } else
        {
            handleDefaultOrderDetailsSection();
            return;
        }
    }

    private void handlePaymentMethodsForDeal()
    {
        if (currentBreakdown != null && currentBreakdown.paymentMethods != null) goto _L2; else goto _L1
_L1:
        dealPaymentMethodsNameTypePairs = null;
        storageConsentRequirements.clear();
_L4:
        return;
_L2:
        List list;
        boolean flag;
        list = currentBreakdown.paymentMethods;
        Object obj = currentBreakdown.getTenderItemsOfType("cash");
        if (obj != null && ((List) (obj)).size() > 0)
        {
            obj = (DealBreakdownTenderItem)((List) (obj)).get(0);
        } else
        {
            obj = null;
        }
        if (obj != null)
        {
            obj = ((DealBreakdownTenderItem) (obj)).amount;
        } else
        {
            obj = null;
        }
        if (obj != null && ((GenericAmount) (obj)).getAmount() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (list.size() != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        if (flag)
        {
            displayInvalidBreakdownsPaymentMethodsDialog("breakdowns_payments_action_finish");
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        setAvailablePaymentMethodsForDeal(list);
        if (dealPaymentMethodsNameTypePairs != null && dealPaymentMethodsNameTypePairs.size() != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        if (flag)
        {
            displayInvalidBreakdownsPaymentMethodsDialog("breakdowns_payments_action_finish");
            return;
        }
        if (true) goto _L4; else goto _L5
_L5:
        if (currentPaymentMethod == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (!dealPaymentMethodsNameTypePairs.containsKey(currentPaymentMethod.getName()))
        {
            setCurrentPaymentMethod(null);
            if (wasPaymentMethodPreviouslyDisplayed && flag)
            {
                displayInvalidBreakdownsPaymentMethodsDialog("breakdowns_payments_action_choose_payment");
                wasPaymentMethodPreviouslyDisplayed = false;
                return;
            }
        } else
        {
            wasPaymentMethodPreviouslyDisplayed = true;
            return;
        }
        if (true) goto _L4; else goto _L6
_L6:
        String s = loginPrefs.getString("currentBillingRecordId", null);
        if (Strings.notEmpty(s))
        {
            AbstractPaymentMethod abstractpaymentmethod = getDefaultPaymentMethod(null, s);
            if (abstractpaymentmethod != null)
            {
                if (!isPaymentMethodSupportedForDeal(abstractpaymentmethod))
                {
                    abstractpaymentmethod = null;
                }
                setCurrentPaymentMethod(abstractpaymentmethod);
                wasPaymentMethodPreviouslyDisplayed = true;
                return;
            } else
            {
                setDefaultPaymentMethod(s);
                return;
            }
        }
        if (true) goto _L4; else goto _L7
_L7:
    }

    private void handleShippingAddresses(List list)
    {
        boolean flag;
        if (list != null && !list.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        hasAddresses = flag;
        if (hasAddresses && !shippingService.isStored())
        {
            shippingService.storeMultipleShipping((DealBreakdownAddress)list.get(0));
            return;
        } else
        {
            handleOrderDetailsSection();
            return;
        }
    }

    private void handleUserInputSection()
    {
        boolean flag1 = true;
        if (userInputActionContainer != null)
        {
            saveCustomFieldsValues();
            userInputActionContainer.removeAllViews();
            addQuantityItem();
            if (!currentCountryManager.getCurrentCountry().isRussia())
            {
                Object obj;
                if (shouldShowAddPaymentMethodPrompt())
                {
                    obj = ADD_PAYMENT_METHOD;
                } else
                {
                    obj = PAYMENT_METHOD;
                }
                addPaymentMethodItem(((String) (obj)), null);
            }
            addJapanUserAddressItem();
            addShippingAddressItem();
            addEnterCodeItem();
            addSendAsGiftItem();
            addCustomFieldItems();
            addStockControlItem();
            if (reservationDetailsContainer != null && reservationDetails != null && reservationDetails.startDateTime != null)
            {
                reservationDetailsContainer.removeAllViews();
                addReservationDetails();
            }
            if (userInputActionContainer != null)
            {
                boolean flag;
                if (isRefreshingBreakdowns.get() || isUsersCallInProgress.get())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                obj = userInputActionContainer;
                if (flag)
                {
                    flag1 = false;
                }
                ViewUtils.setEnabledOnAllChildren(((ViewGroup) (obj)), flag1);
                return;
            }
        }
    }

    private void initializeDefaultPurchaseViews()
    {
        dealDetailsContainer = (LinearLayout)findViewById(0x7f100488);
    }

    private void initializeGetawaysPurchaseViews()
    {
        hotlineView = (TextView)findViewById(0x7f1002d0);
        fullName = (TextView)findViewById(0x7f100496);
        checkInDateView = (TextView)findViewById(0x7f100494);
        checkOutDateView = (TextView)findViewById(0x7f100495);
        nightsView = (TextView)findViewById(0x7f100498);
        nightsLabelView = (TextView)findViewById(0x7f100497);
        findViewById(0x7f1002c9).setOnClickListener(new android.view.View.OnClickListener() {

            final Purchase this$0;

            public void onClick(View view)
            {
                travelerNameHelper.startEditing();
            }

            
            {
                this$0 = Purchase.this;
                super();
            }
        });
        buildHotlineNumber();
        setBookingValues();
    }

    private boolean isBookableDeal()
    {
        return bookingModel != null;
    }

    private boolean isDealLoaderInitialized()
    {
        boolean flag = false;
        if (getLoaderManager().getLoader(0) != null)
        {
            flag = true;
        }
        return flag;
    }

    private boolean isPaymentMethodSupportedForDeal(AbstractPaymentMethod abstractpaymentmethod)
    {
        return abstractpaymentmethod != null && dealPaymentMethodsNameTypePairs.containsKey(abstractpaymentmethod.getName());
    }

    private boolean isPaymentMethodValid(AbstractPaymentMethod abstractpaymentmethod)
    {
        return abstractpaymentmethod != null && (!abstractpaymentmethod.isCreditCard() || !billingRecordExpiryChecker.isBillingRecordExpired(abstractpaymentmethod.getBillingRecord()));
    }

    private boolean isReenterCvvAdded()
    {
        for (int i = 0; i < userInputActionContainer.getChildCount(); i++)
        {
            EditText edittext = (EditText)userInputActionContainer.getChildAt(i).findViewById(0x7f1002f5);
            if (edittext != null && Strings.equalsIgnoreCase(edittext.getHint(), REENTER_CVV))
            {
                return true;
            }
        }

        return false;
    }

    private boolean isRefreshingBreakdowns()
    {
        return isRefreshingBreakdowns.get();
    }

    private boolean isRefreshingGoogleWallet()
    {
        return isRefreshingGoogleWallet.get();
    }

    private boolean isUsingCredits()
    {
        return currentCountryManager.getCurrentCountry().isUSACompatible() || currentCountryManager.getCurrentCountry().isLATAMCompatible() || ((LocalizedSharedPreferencesProvider)localizedSharedPreferencesProvider.get(this)).get().getBoolean("eagerlyApplyRewardPoints", true) && !currentCountryManager.getCurrentCountry().isRussia();
    }

    private void logEnterCodeClickEvent()
    {
        ClickMetadata clickmetadata = new ClickMetadata();
        clickmetadata.dealId = deal.remoteId;
        logger.logClick("", "enter_promo_code", "confirm_purhcase", clickmetadata, null);
    }

    private void manuallyCreateOrderBreakdown()
    {
        String s;
        ArrayList arraylist1;
        DealBreakdownTenderItem dealbreakdowntenderitem;
        Object obj2;
        int l;
        currentBreakdown = new DealBreakdown();
        Ln.d("BREAKDOWN: manuallyCreateOrderBreakdown", new Object[0]);
        ArrayList arraylist = new ArrayList();
        currentBreakdown.items = arraylist;
        DealBreakdownItem dealbreakdownitem = new DealBreakdownItem();
        arraylist.add(dealbreakdownitem);
        dealbreakdownitem.quantity = currentlySelectedQuantity;
        l = currentlySelectedQuantity * priceAmountInCents;
        s = currency;
        obj2 = new GenericAmount(l, s, null);
        dealbreakdownitem.total = ((GenericAmount) (obj2));
        arraylist1 = new ArrayList();
        currentBreakdown.tenders = arraylist1;
        dealbreakdowntenderitem = new DealBreakdownTenderItem();
        dealbreakdowntenderitem.type = "cash";
        dealbreakdowntenderitem.amount = new GenericAmount(l, s, null);
        arraylist1.add(dealbreakdowntenderitem);
        Ln.d("BREAKDOWN: subtotal = %d", new Object[] {
            Integer.valueOf(((GenericAmount) (obj2)).getAmount())
        });
        if (!isUsingCredits()) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        j = 0;
        i = j;
        if (!currentCountryManager.getCurrentCountry().isJapan()) goto _L4; else goto _L3
_L3:
        canUseGiftPoints = false;
        canUseIncentiveTicket = false;
        i = j;
        if (incentiveTickets == null) goto _L4; else goto _L5
_L5:
        IncentiveTicket incentiveticket;
        Object obj1 = null;
        Iterator iterator = incentiveTickets.iterator();
        do
        {
            incentiveticket = obj1;
            if (!iterator.hasNext())
            {
                break;
            }
            incentiveticket = (IncentiveTicket)iterator.next();
        } while (!Strings.equals(incentiveticket.type, selectedIncentiveTicket));
        if (incentiveticket == null) goto _L7; else goto _L6
_L6:
        j = incentiveticket.points.getAmount();
        GenericAmount genericamount1 = incentiveticket.minimum_points;
        i = genericamount1.getAmount();
        boolean flag;
        if (((GenericAmount) (obj2)).getAmount() >= i)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        canUseIncentiveTicket = flag;
        i = j;
        if (!canUseIncentiveTicket)
        {
            obj2 = logger;
            Object obj;
            if (dealId != null)
            {
                obj = new PageViewExtraInfo(dealId);
            } else
            {
                obj = Logger.NULL_NST_FIELD;
            }
            ((Logger) (obj2)).logPageView("", "minimum_incentive_purchase_error", ((com.groupon.tracking.mobile.EncodedNSTField) (obj)));
            alertMinimumAmountNotReached(genericamount1.getFormattedAmount());
            i = j;
        }
_L4:
        if (creditsAvailable != null || canUseGiftPoints || canUseIncentiveTicket)
        {
            if (creditsAvailable != null)
            {
                i = creditsAvailable.getAmount();
            }
            applyCredits(i, l, arraylist1, dealbreakdowntenderitem, s);
        }
_L2:
        recreateOrderBreakdowns();
        return;
_L7:
        i = j;
        if (giftCode != null)
        {
            int k = giftCode.point.getAmount();
            GenericAmount genericamount = giftCode.minimum_point;
            i = genericamount.getAmount();
            boolean flag1;
            if (((GenericAmount) (obj2)).getAmount() >= i)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            canUseGiftPoints = flag1;
            i = k;
            if (!canUseGiftPoints)
            {
                alertMinimumAmountNotReached(genericamount.getFormattedAmount());
                i = k;
            }
        }
        if (true) goto _L4; else goto _L8
_L8:
    }

    private void onAddressValidationPositiveClick()
    {
        isValidAddressTheSameAsOriginal = true;
        Object obj = getFragmentManager().findFragmentByTag("address_validation_dialog");
        if (obj != null)
        {
            obj = (DealBreakdownAddress)((Fragment) (obj)).getArguments().getSerializable("validated_address");
        } else
        {
            obj = null;
        }
        if (currentCountryManager.getCurrentCountry().isUSACompatible())
        {
            shippingService.store(((DealBreakdownAddress) (obj)));
            handleOrderDetailsSection();
            return;
        } else
        {
            updateShippingAddressEu(shippingService.getSelectedShippingLocationId(), ((DealBreakdownAddress) (obj)));
            return;
        }
    }

    private void onBreakdownsDismissOnlyErrorNegativeClick()
    {
        finish();
    }

    private void onBreakdownsErrorPositiveClick()
    {
        Ln.d("ADDRESS: calling refresh 3", new Object[0]);
        refreshDealBreakdowns();
    }

    private void onChangePaymentMethod()
    {
        startActivityForResult(getNewMyCreditCardIntent(), 10112);
    }

    private void onChangeQuantity(int i, int j)
    {
        String as[];
        if (j >= i)
        {
            j = (j - i) + 1;
        } else
        {
            j = 1;
        }
        as = new String[j];
        for (j = 0; j < as.length; j++)
        {
            as[j] = String.valueOf(i + j);
        }

        GrouponDialogFragment groupondialogfragment = new GrouponDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("dialog_title_res_id", 0x7f0802f4);
        bundle.putStringArray("dialog_items", as);
        bundle.putInt("min_count", i);
        groupondialogfragment.setArguments(bundle);
        showDialog(groupondialogfragment, "quantity_dialog");
    }

    private void onCustomFieldClick(String s)
    {
        View view = getLayoutInflater().inflate(0x7f0300b6, null);
        Object obj = (EditText)view.findViewById(0x7f100206);
        ((EditText) (obj)).setHint(s);
        ((EditText) (obj)).setSingleLine();
        ((EditText) (obj)).setText(Strings.toString(customFieldMap.get(s)));
        if (Strings.equals(s, CVV_STRING))
        {
            ((EditText) (obj)).setInputType(2);
        }
        obj = new GrouponDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("dialog_title_res_id", 0x7f080150);
        bundle.putInt("dialog_positive_button_text_res_id", 0x104000a);
        bundle.putInt("dialog_negative_button_text_res_id", 0x1040000);
        bundle.putString("custom_field_key", s);
        ((GrouponDialogFragment) (obj)).setArguments(bundle);
        ((GrouponDialogFragment) (obj)).setCustomView(view);
        showDialog(((GrouponDialogFragment) (obj)), "custom_field_dialog");
    }

    private void onCustomFieldClick(String s, String as[], String s1)
    {
        GrouponDialogFragment groupondialogfragment = new GrouponDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("dialog_title_res_id", 0x7f080361);
        bundle.putStringArray("dialog_single_choice_items", as);
        if (Strings.notEmpty(s1))
        {
            bundle.putInt("dialog_single_choice_checked_item", Arrays.asList(as).indexOf(s1));
        }
        bundle.putString("custom_field_key", s);
        groupondialogfragment.setArguments(bundle);
        showDialog(groupondialogfragment, "custom_field_dialog");
    }

    private void onCustomFieldDialogItemClick(DialogInterface dialoginterface, int i)
    {
        String s = null;
        String as[] = null;
        GrouponDialogFragment groupondialogfragment = (GrouponDialogFragment)getFragmentManager().findFragmentByTag("custom_field_dialog");
        if (groupondialogfragment != null)
        {
            s = groupondialogfragment.getArguments().getString("custom_field_key");
            as = groupondialogfragment.getArguments().getStringArray("dialog_single_choice_items");
        }
        if (s != null && as != null)
        {
            String s1 = Strings.toString(as[i]);
            customFieldMap.put(s, s1);
        }
        handleOrderDetailsSection();
        dialoginterface.dismiss();
    }

    private void onCustomFieldPositiveClick()
    {
label0:
        {
            String s = null;
            EditText edittext = null;
            GrouponDialogFragment groupondialogfragment = (GrouponDialogFragment)getFragmentManager().findFragmentByTag("custom_field_dialog");
            if (groupondialogfragment != null)
            {
                s = groupondialogfragment.getArguments().getString("custom_field_key");
                edittext = (EditText)groupondialogfragment.getCustomView().findViewById(0x7f100206);
            }
            if (Strings.notEmpty(s) && edittext != null)
            {
                customFieldMap.put(s, edittext.getText().toString());
                if (!s.equals(CVV_STRING))
                {
                    break label0;
                }
                handlePaymentSection();
            }
            return;
        }
        handleOrderDetailsSection();
    }

    private void onHttpErrorPositiveClick()
    {
        finish();
    }

    private void onInstallmentsDialogItemClick(int i)
    {
        Object obj = null;
        DealBreakdownPaymentMethodInstallmentItem dealbreakdownpaymentmethodinstallmentitem = obj;
        if (i > 0)
        {
            dealbreakdownpaymentmethodinstallmentitem = obj;
            if (currentAvailableInstallmentOptionsForCardType != null)
            {
                dealbreakdownpaymentmethodinstallmentitem = currentAvailableInstallmentOptionsForCardType[i - 1];
            }
        }
        currentlySelectedInstallmentOption = dealbreakdownpaymentmethodinstallmentitem;
        handlePaymentSection();
    }

    private void onInvalidBreakdownsPaymentMethodsDismissClickChoosePayment()
    {
        startActivity(getPaymentMethodIntent());
    }

    private void onInvalidBreakdownsPaymentMethodsDismissClickFinish()
    {
        finish();
    }

    private void onPrePurchaseReservationExpiredPossitiveButtonClick()
    {
        finish();
    }

    private void onPurchaseButtonClick()
    {
        while (redirectToAddPaymentMethod() || redirectToAddShippingAddress() || !valid()) 
        {
            return;
        }
        if (googleWalletService.isGoogleWalletPaymentMethod(currentPaymentMethod) && googleWalletService.shouldTriggerFullWalletRequest())
        {
            triggerFullWalletRequest();
            return;
        }
        abTestService.isVariantEnabled("AAforPurchaseButtonClick1510", "On");
        Ln.d("SPINNING: showProcessingFeedback call 1", new Object[0]);
        showProcessingFeedback(false);
        setIsOrdersCallInProgress(true);
        ArrayList arraylist = new ArrayList();
        if (amountChargedToCreditCardInCents <= 0)
        {
            Object obj;
            Object obj1;
            if (currentPaymentMethod != null)
            {
                obj = currentPaymentMethod;
            } else
            {
                obj = paymentMethodFactory.createPaymentMethod(deal, option, currentlySelectedQuantity, isUsingCredits());
            }
            ((AbstractPaymentMethod) (obj)).addDefaultPurchaseParams(arraylist, currentlySelectedQuantity);
        } else
        {
            currentPaymentMethod.addPurchaseParams(arraylist, currentlySelectedQuantity);
        }
        if (customFieldMap != null)
        {
            if (isNewCheckout1408)
            {
                saveCustomFieldsValues();
            }
            obj = customFieldMap.entrySet().iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                obj1 = (java.util.Map.Entry)((Iterator) (obj)).next();
                if (!Strings.equalsIgnoreCase(((java.util.Map.Entry) (obj1)).getKey(), CVV_STRING))
                {
                    obj1 = (String)((java.util.Map.Entry) (obj1)).getValue();
                    if (Strings.notEmpty(obj1))
                    {
                        arraylist.addAll(Arrays.asList(new String[] {
                            "custom_field_value", obj1
                        }));
                    }
                }
            } while (true);
        }
        addGiftingParameters(arraylist);
        addMultiUsePromoCodeParameterIfNecessary(arraylist);
        if (!googleWalletService.isGoogleWalletPaymentMethod(currentPaymentMethod))
        {
            logDealPurchaseInitiation();
        }
        if (isBookableDeal())
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "getaways_booking_segment", bookingDetails.getawaysBookingSegment, "traveler_first_name", travelerNameHelper.getFirstname(), "traveler_last_name", travelerNameHelper.getLastname()
            }));
        }
        iovationBlackboxUtil.addIovationParameterIfNeeded(arraylist);
        if (currentCountryManager.getCurrentCountry().isUSACompatible())
        {
            arraylist.addAll(Arrays.asList(new Serializable[] {
                "validate_shipping_address", Boolean.valueOf(true)
            }));
            if (validationCardNumber != null)
            {
                arraylist.addAll(Arrays.asList(new String[] {
                    "validation_card_number", validationCardNumber
                }));
            }
        }
        if (reservationDetails != null)
        {
            if (reservationDetails.expires_at <= 0L || reservationDetails.expires_at > System.currentTimeMillis() / 1000L)
            {
                if (Strings.notEmpty(reservationDetails.id))
                {
                    arraylist.addAll(Arrays.asList(new String[] {
                        "booking_reservation_id", reservationDetails.id
                    }));
                }
                saveOrderResult(arraylist);
                return;
            } else
            {
                displayPrePurchaseReservationExpiredDialog();
                return;
            }
        } else
        {
            saveOrderResult(arraylist);
            return;
        }
    }

    private void onQuantityDialogItemClick(int i)
    {
        int j = 0;
        Fragment fragment = getFragmentManager().findFragmentByTag("quantity_dialog");
        if (fragment != null)
        {
            j = fragment.getArguments().getInt("min_count");
        }
        Ln.d("BREAKDOWN: user changed quantity to %d", new Object[] {
            Integer.valueOf(j + i)
        });
        currentlySelectedQuantity = j + i;
        currentlySelectedInstallmentOption = null;
        currentAvailableInstallmentOptionsForCardType = null;
        setIsRefreshing(true);
        refreshDealBreakdowns();
    }

    private void onRemoveIncentiveTicketsPositiveClick()
    {
        selectedIncentiveTicket = null;
        startActivityForResult(getNewGiftCodesIntent(), 10105);
    }

    private void onSendAsGiftClicked()
    {
        Object obj = "edit_gift_click";
        if (giftingRecord == null)
        {
            Object obj1 = "send_as_gift_click";
            giftingRecord = new GiftingRecord();
            giftingRecord.fromName = loginService.getFullName();
            giftingRecord.isGoods = getIsGoodsDeal();
            giftingRecord.isGiftWrappable = isGiftWrappable;
            if (isGiftWrappable)
            {
                GiftingRecord giftingrecord = giftingRecord;
                if (option.giftWrappingCharge != null)
                {
                    obj = option.giftWrappingCharge.formattedAmount;
                } else
                {
                    obj = "";
                }
                giftingrecord.giftWrapChargeAmount = ((String) (obj));
            }
            if (!Strings.isEmpty(deal.dealUrl))
            {
                giftingRecord.dealUrl = deal.dealUrl;
            }
            giftingRecord.deliveryMethod = "email";
            obj = obj1;
        }
        obj1 = new ClickExtraInfo();
        obj1.pageId = getPageViewId();
        logger.logClick("", ((String) (obj)), channel.toString(), null, ((com.groupon.tracking.mobile.EncodedNSTField) (obj1)));
        obj1 = logger;
        if (dealId != null)
        {
            obj = new PageViewExtraInfo(dealId);
        } else
        {
            obj = Logger.NULL_NST_FIELD;
        }
        ((Logger) (obj1)).logPageView("", "send_as_gift_page", ((com.groupon.tracking.mobile.EncodedNSTField) (obj)));
        startActivityForResult(intentFactory.newGiftingIntent(this, giftingRecord, dealId, null, DealUtils.isGiftableDeal(deal, false, false)), 10107);
    }

    private void onShippingAddrErrorPositiveClick()
    {
        shippingInfoIsInvalid = true;
        isValidAddressTheSameAsOriginal = false;
        updatePurchaseButtonState();
        handleOrderDetailsSection();
    }

    private void onShippingAddressClick()
    {
label0:
        {
label1:
            {
                if (!isRefreshing.get())
                {
                    if (!currentCountryManager.getCurrentCountry().supportsMultipleDeliveryAddresses() && !currentCountryManager.getCurrentCountry().isUSACompatible())
                    {
                        break label0;
                    }
                    if (!hasAddresses)
                    {
                        break label1;
                    }
                    startActivityForResult(getDeliveryAddressesIntent(), 10122);
                }
                return;
            }
            startActivityForResult(getShippingAddressIntent(), 10119);
            return;
        }
        enterShippingAddress();
    }

    private void onTaxAmountChangedPositiveClick()
    {
        Ln.d("ADDRESS: calling refresh 1", new Object[0]);
        refreshDealBreakdowns();
    }

    private void onTravelInventNotAvailablePositiveClick()
    {
        startActivity(intentFactory.newCalendarBookingIntentWithClearTop(deal.remoteId, dealOptionId, channel));
    }

    private void onTravelInventNotFoundPositiveClick()
    {
        startActivity(intentFactory.newCalendarBookingIntentWithClearTop(deal.remoteId, dealOptionId, channel));
    }

    private void refreshShippingAddressIntl()
    {
        final String savedShippingId = prefs.getString("preferredShippingLocationId", "");
        shippingService.getLocations(new Function1() , null, new Function0() {

            final Purchase this$0;

            public void execute()
            {
                refreshDealBreakdowns();
            }

            
            {
                this$0 = Purchase.this;
                super();
            }
        });
    }

    private void refreshUserData()
    {
        final boolean withShippingAddressesUS;
        final boolean withCredits;
        if (isShippingAddressRequired() && currentCountryManager.getCurrentCountry().isUSACompatible())
        {
            withShippingAddressesUS = true;
        } else
        {
            withShippingAddressesUS = false;
        }
        if (!currentCountryManager.getCurrentCountry().supportsDealBreakdowns())
        {
            withCredits = true;
        } else
        {
            withCredits = false;
        }
        haveCheckedBillingRecords = false;
        setIsRefreshingUserData(true);
        userManager.getUserData(withShippingAddressesUS, withCredits, new Function1() {

            final Purchase this$0;
            final boolean val$withCredits;
            final boolean val$withShippingAddressesUS;

            public void execute(UserContainer usercontainer)
            {
                if (usercontainer != null)
                {
                    usercontainer = usercontainer.user;
                    if (withShippingAddressesUS)
                    {
                        handleShippingAddresses(((User) (usercontainer)).shippingAddresses);
                    }
                    if (withCredits)
                    {
                        handleCredits(((User) (usercontainer)).creditsAvailable, ((User) (usercontainer)).incentiveTickets);
                    }
                    handleBillingRecords(((User) (usercontainer)).billingRecords);
                    if (!isRefreshingGoogleWallet())
                    {
                        triggerNextInitializationRequest();
                    }
                }
            }

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((UserContainer)obj);
            }

            
            {
                this$0 = Purchase.this;
                withShippingAddressesUS = flag;
                withCredits = flag1;
                super();
            }
        }, new ReturningFunction1() {

            final Purchase this$0;

            public Boolean execute(Exception exception)
            {
                setIsRefreshing(false);
                haveCheckedBillingRecords = true;
                return null;
            }

            public volatile Object execute(Object obj)
                throws Exception
            {
                return execute((Exception)obj);
            }

            
            {
                this$0 = Purchase.this;
                super();
            }
        }, new Function0() {

            final Purchase this$0;

            public void execute()
            {
                setIsRefreshingUserData(false);
                recreateOrderBreakdowns();
                if (bottomBar != null)
                {
                    bottomBar.setVisibility(0);
                }
            }

            
            {
                this$0 = Purchase.this;
                super();
            }
        }, new Function0() {

            final Purchase this$0;

            public void execute()
            {
                finish();
            }

            
            {
                this$0 = Purchase.this;
                super();
            }
        });
    }

    private void saveCustomFieldsValues()
    {
        if (isNewCheckout1408 && customFieldViewsMap != null)
        {
            Iterator iterator = customFieldViewsMap.keySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                String s = (String)iterator.next();
                Object obj = (View)customFieldViewsMap.get(s);
                String as[] = getCustomFieldPossibleValues(s);
                boolean flag;
                if (as != null && as.length > 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (!flag)
                {
                    obj = (EditText)((View) (obj)).findViewById(0x7f1002f5);
                    if (obj != null)
                    {
                        obj = ((EditText) (obj)).getText().toString();
                    } else
                    {
                        obj = null;
                    }
                    if (Strings.notEmpty(obj))
                    {
                        customFieldMap.put(s, obj);
                    }
                }
            } while (true);
        }
    }

    private void setAvailablePaymentMethodsForDeal(List list)
    {
        List list1 = currentCountryManager.getCurrentCountry().paymentMethods;
        HashMap hashmap = new HashMap();
        storageConsentRequirements.clear();
        for (Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            DealBreakdownPaymentMethodItem dealbreakdownpaymentmethoditem = (DealBreakdownPaymentMethodItem)iterator.next();
            String s = dealbreakdownpaymentmethoditem.name;
            Iterator iterator1 = list1.iterator();
            while (iterator1.hasNext()) 
            {
                list = (PaymentMethod)iterator1.next();
                if (Strings.equalsIgnoreCase(s, ((PaymentMethod) (list)).name))
                {
                    if (list instanceof CreditCard)
                    {
                        list = "payment_method_type_credit_card";
                    } else
                    {
                        list = "payment_method_type_other";
                    }
                    hashmap.put(s, list);
                    storageConsentRequirements.putString(s, dealbreakdownpaymentmethoditem.consentRequiredForStoring);
                }
            }
        }

        if (hashmap.size() > 0)
        {
            list = hashmap;
        } else
        {
            list = null;
        }
        dealPaymentMethodsNameTypePairs = list;
    }

    private void setBookingValues()
    {
        checkInDateView.setText(localLongDateFormat.format(bookingModel.getStartDate().getTime()));
        checkOutDateView.setText(localLongDateFormat.format(bookingModel.getEndDate().getTime()));
        Object obj = getApplicationContext().getResources();
        Long long1 = Long.valueOf((bookingModel.getEndDate().getTimeInMillis() - bookingModel.getStartDate().getTimeInMillis()) / 0x5265c00L);
        nightsView.setText(Strings.toString(long1));
        obj = ((Resources) (obj)).getQuantityString(0x7f0c0013, long1.intValue());
        nightsLabelView.setText(((CharSequence) (obj)));
    }

    private void setBuyWithGoogleButtonClickListener()
    {
        if (buyWithGoogleButton != null)
        {
            buyWithGoogleButton.setOnClickListener(new android.view.View.OnClickListener() {

                final Purchase this$0;

                public void onClick(View view)
                {
                    buyWithGoogleButton.startProgress();
                    boolean flag;
                    if (!shippingService.isStored() && isShippingAddressRequired())
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    googleWalletService.triggerLoadMaskedWalletRequest(Purchase.this, option, currentlySelectedQuantity, flag);
                    loggingUtils.logBuyWithGoogleButtonClick(channel, com/groupon/activity/Purchase.getSimpleName(), dealId);
                }

            
            {
                this$0 = Purchase.this;
                super();
            }
            });
        }
    }

    private void setCurrentPaymentMethod(AbstractPaymentMethod abstractpaymentmethod)
    {
        boolean flag;
        flag = true;
        currentPaymentMethod = abstractpaymentmethod;
        if (currentPaymentMethod != null)
        {
            currentPaymentMethod.saveToPrefs();
        }
        if (!googleWalletService.isGoogleWalletPaymentMethod(currentPaymentMethod)) goto _L2; else goto _L1
_L1:
        if (!getIntent().getBooleanExtra("isDeepLinked", false)) goto _L4; else goto _L3
_L3:
        googleWalletService.clearGoogleWalletData();
        purchaseButton.setVisibility(8);
        toggleBuyWithGoogleButton(true);
_L6:
        updatePurchaseButtonState();
        return;
_L4:
        if (googleWalletService.shouldTriggerLoadMaskedWalletRequest() && !isRefreshingGoogleWallet())
        {
            if (googleWalletService.hasMaximumPurchaseLimitBeenReached(amountChargedToCreditCardInCents))
            {
                buyWithGoogleButton.setVisibility(0);
                purchaseButton.setVisibility(8);
                googleWalletService.showGoogleWalletMaxAmountErrorDialog(this);
            } else
            {
                setIsRefreshingGoogleWallet(true);
                setIsRefreshing(true);
                if (shippingService.isStored() || !isShippingAddressRequired())
                {
                    flag = false;
                }
                googleWalletService.triggerLoadMaskedWalletRequest(this, option, currentlySelectedQuantity, flag);
            }
        }
        continue; /* Loop/switch isn't completed */
_L2:
        purchaseButton.setVisibility(0);
        toggleBuyWithGoogleButton(false);
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void setDealCardCompact()
    {
        if (isNewCheckout1408 && dealCardCompact != null)
        {
            if (deal != null)
            {
                dealCardCompact.setInfo(new DealSummary(deal, channel), DealUtils.getOption(deal, dealOptionId));
            }
            DealCardCompact dealcardcompact = dealCardCompact;
            int i;
            if (deal != null)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            dealcardcompact.setVisibility(i);
        }
    }

    private void setDefaultPaymentMethod(final String preferredBillingRecordId)
    {
        setIsRefreshing(true);
        setIsRefreshingUserData(true);
        userManager.getUserData(false, false, new Function1() {

            final Purchase this$0;
            final String val$preferredBillingRecordId;

            public void execute(UserContainer usercontainer)
            {
                if (usercontainer != null)
                {
                    usercontainer = usercontainer.user;
                    usercontainer = getDefaultPaymentMethod(((User) (usercontainer)).billingRecords, preferredBillingRecordId);
                    Purchase purchase = Purchase.this;
                    boolean flag;
                    if (!isPaymentMethodSupportedForDeal(usercontainer))
                    {
                        usercontainer = null;
                    }
                    purchase.setCurrentPaymentMethod(usercontainer);
                    usercontainer = Purchase.this;
                    if (currentPaymentMethod != null)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    usercontainer.wasPaymentMethodPreviouslyDisplayed = flag;
                    handlePaymentSection();
                }
            }

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((UserContainer)obj);
            }

            
            {
                this$0 = Purchase.this;
                preferredBillingRecordId = s;
                super();
            }
        }, new ReturningFunction1() {

            final Purchase this$0;

            public Boolean execute(Exception exception)
            {
                return Boolean.valueOf(false);
            }

            public volatile Object execute(Object obj)
                throws Exception
            {
                return execute((Exception)obj);
            }

            
            {
                this$0 = Purchase.this;
                super();
            }
        }, new Function0() {

            final Purchase this$0;

            public void execute()
            {
                setIsRefreshingUserData(false);
                setIsRefreshing(false);
            }

            
            {
                this$0 = Purchase.this;
                super();
            }
        }, null);
    }

    private boolean setIsRefreshingGoogleWallet(boolean flag)
    {
        return isRefreshingGoogleWallet.getAndSet(flag);
    }

    private boolean setIsRefreshingUserData(boolean flag)
    {
        return isUsersCallInProgress.getAndSet(flag);
    }

    private void setProcessingFeedback(boolean flag)
    {
        boolean flag2 = true;
        boolean flag1;
        if (dealDetailsContainer != null)
        {
            LinearLayout linearlayout = dealDetailsContainer;
            if (!flag)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            ViewUtils.setEnabledOnAllChildren(linearlayout, flag1);
        }
        if (dealPaymentContainer != null)
        {
            linearlayout = dealPaymentContainer;
            if (!flag)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            ViewUtils.setEnabledOnAllChildren(linearlayout, flag1);
        }
        if (userInputActionContainer != null)
        {
            linearlayout = userInputActionContainer;
            if (!flag)
            {
                flag = flag2;
            } else
            {
                flag = false;
            }
            ViewUtils.setEnabledOnAllChildren(linearlayout, flag);
        }
    }

    private void setTotalPriceComment(View view)
    {
        ((TextView)view.findViewById(0x7f10049f)).setText(createTotalPriceBookingComment());
    }

    private boolean shouldShowAddPaymentMethodPrompt()
    {
        return !currentCountryManager.getCurrentCountry().isRussia() && haveCheckedBillingRecords && !isPaymentMethodValid(currentPaymentMethod) && amountChargedToCreditCardInCents > 0;
    }

    private boolean shouldShowAddShippingAddressPrompt()
    {
        boolean flag1 = shippingService.isStored();
        String s;
        boolean flag;
        if (googleWalletService.getMaskedWalletShippingAddress() != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (currentCountryManager.getCurrentCountry().isUSACompatible())
        {
            s = shippingService.getAsJoin(false);
        } else
        {
            s = displayedShippingAddress;
        }
        return hasDealData() && isShippingAddressRequired() && isNewCheckout1408 && !flag1 && Strings.isEmpty(s) && !flag;
    }

    private boolean shouldShowEnterCode()
    {
        return !isLotteryDeal && !currentCountryManager.getCurrentCountry().isRussia();
    }

    private boolean shouldShowInstallments()
    {
        return currentPaymentMethod != null && currentPaymentMethod.isCreditCard() && currentAvailableInstallmentOptionsForCardType != null && currentAvailableInstallmentOptionsForCardType.length > 0;
    }

    private boolean shouldShowJapanIncentiveTickets()
    {
        return currentCountryManager.getCurrentCountry().isJapan() && incentiveTickets != null && !deal.isApplyButton;
    }

    private boolean shouldShowTaxAndShippingLabel(List list)
    {
        return list != null && list.size() > 0 && isShippingAddressRequired();
    }

    private void showIncentiveTicketsDialog()
    {
        if (currentCountryManager.getCurrentCountry().isJapan() && selectedIncentiveTicket != null)
        {
            showDialog(dialogManager.getDialogFragment(getString(0x7f080317), getString(0x7f080318), getString(0x7f080426), getString(0x7f0802a6), false), "remove_incentive_tickets_dialog");
            return;
        } else
        {
            startActivityForResult(getNewGiftCodesIntent(), 10105);
            return;
        }
    }

    private void showInstallmentOptionsDialog(DealBreakdownTenderItem dealbreakdowntenderitem)
    {
        GrouponDialogFragment groupondialogfragment = new GrouponDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("dialog_title_res_id", 0x7f08023a);
        bundle.putStringArray("dialog_items", getInstallmentOptionsAsStringArray(dealbreakdowntenderitem));
        groupondialogfragment.setArguments(bundle);
        showDialog(groupondialogfragment, "installments_dialog");
    }

    private void showNewsletterOptIn()
    {
        if (currentCountryManager.getCurrentCountry().isIsrael())
        {
            newsletterOptin.setChecked(true);
            newsletterOptin.setText(0x7f0803c3);
            newsletterOptin.setVisibility(0);
            return;
        } else
        {
            emailSubscriptionsService.getEmailSubscriptions(0, new Function1() {

                final Purchase this$0;

                public void execute(EmailSubscriptionsContainer emailsubscriptionscontainer)
                {
                    boolean flag = false;
                    int i;
                    if (emailsubscriptionscontainer.emailSubscriptions != null && emailsubscriptionscontainer.emailSubscriptions.size() > 0)
                    {
                        i = 1;
                    } else
                    {
                        i = 0;
                    }
                    emailsubscriptionscontainer = newsletterOptin;
                    if (i == 0)
                    {
                        i = ((flag) ? 1 : 0);
                    } else
                    {
                        i = 8;
                    }
                    emailsubscriptionscontainer.setVisibility(i);
                }

                public volatile void execute(Object obj)
                    throws Exception
                {
                    execute((EmailSubscriptionsContainer)obj);
                }

            
            {
                this$0 = Purchase.this;
                super();
            }
            }, new ReturningFunction1() {

                final Purchase this$0;

                public Boolean execute(Exception exception)
                {
                    Ln.d("SUBSCRIPTIONS: exception when getting Email Subscriptions", new Object[0]);
                    newsletterOptin.setVisibility(0);
                    return Boolean.valueOf(false);
                }

                public volatile Object execute(Object obj)
                    throws Exception
                {
                    return execute((Exception)obj);
                }

            
            {
                this$0 = Purchase.this;
                super();
            }
            }, null);
            return;
        }
    }

    private boolean showTotalPriceBookingComment()
    {
        Deal deal1 = deal;
        boolean flag;
        if (dateTimeFinderReservationDetails == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return DealUtils.isBookingEngineDeal(deal1, flag) && reservationDetails == null && option.getExpiresAt() != null;
    }

    private void startGiftCodesIntent()
    {
        if (currentCountryManager.getCurrentCountry().isJapan() && selectedIncentiveTicket != null)
        {
            showIncentiveTicketsDialog();
            return;
        } else
        {
            startActivityForResult(getNewGiftCodesIntent(), 10105);
            return;
        }
    }

    private void syncDeal(Function0 function0)
    {
        if (isDealLoaderInitialized())
        {
            if (function0 != null)
            {
                onDealLoadedSuccess = function0;
            }
            dealSyncManager.requestSync(this, null);
        }
    }

    private void toggleBuyWithGoogleButton(boolean flag)
    {
        BuyWithGoogleButton buywithgooglebutton = buyWithGoogleButton;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        buywithgooglebutton.setVisibility(i);
        if (flag)
        {
            loggingUtils.logBuyWithGoogleButtonImpression(channel, com/groupon/activity/Purchase.getSimpleName());
        }
    }

    private void triggerFullWalletRequest()
    {
        if (googleWalletService.hasMaximumPurchaseLimitBeenReached(amountChargedToCreditCardInCents))
        {
            googleWalletService.showGoogleWalletMaxAmountErrorDialog(this);
            return;
        } else
        {
            showProcessingFeedback(false);
            setIsOrdersCallInProgress(true);
            googleWalletService.triggerLoadFullWalletRequest(this, currentBreakdown);
            logDealPurchaseInitiation();
            return;
        }
    }

    private void triggerNextInitializationRequest()
    {
        Country country = currentCountryManager.getCurrentCountry();
        boolean flag;
        if (isShippingAddressRequired() && !country.isUSACompatible() || country.isJapan())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            refreshShippingAddressIntl();
            return;
        } else
        {
            refreshDealBreakdowns();
            return;
        }
    }

    private void updateOrdersInProgressFeedback()
    {
        setProcessingFeedback(isOrdersCallInProgress.get());
    }

    private void updatePurchaseButtonState()
    {
        if (!purchaseButton.isSpinning())
        {
            boolean flag1 = shouldShowAddPaymentMethodPrompt();
            boolean flag2 = shouldShowAddShippingAddressPrompt();
            SpinnerButton spinnerbutton = purchaseButton;
            int i;
            boolean flag;
            if (currentCountryManager.getCurrentCountry().isRussia() || flag1 || flag2 || !shippingInfoIsInvalid && (amountChargedToCreditCardInCents <= 0 || isPaymentMethodValid(currentPaymentMethod)) && isCurrentBreakdownValid())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            spinnerbutton.setEnabled(flag);
            spinnerbutton = purchaseButton;
            if (flag1)
            {
                i = 0x7f08004e;
            } else
            if (flag2)
            {
                i = 0x7f080050;
            } else
            if (deal != null && deal.isApplyButton)
            {
                i = 0x7f0800bf;
            } else
            {
                i = 0x7f0800c1;
            }
            spinnerbutton.setText(i);
        }
    }

    private void updateRefreshFeedback()
    {
        byte byte0 = 8;
        if (isRefreshing.get())
        {
            if (dealDetailsContainer != null)
            {
                ViewUtils.setEnabledOnAllChildren(dealDetailsContainer, false);
            }
            if (userInputActionContainer != null)
            {
                ViewUtils.setEnabledOnAllChildren(userInputActionContainer, false);
            }
            dealPaymentContainer.setVisibility(8);
            paymentSpinner.setVisibility(0);
            showProcessingFeedback(false);
            return;
        }
        if (dealDetailsContainer != null)
        {
            ViewUtils.setEnabledOnAllChildren(dealDetailsContainer, true);
        }
        if (userInputActionContainer != null)
        {
            ViewUtils.setEnabledOnAllChildren(userInputActionContainer, true);
        }
        dealPaymentContainer.setVisibility(0);
        ProgressBar progressbar = paymentSpinner;
        if (!isBookableDeal())
        {
            byte0 = 4;
        }
        progressbar.setVisibility(byte0);
        hideProcessingFeedback();
    }

    private void updateShippingAddressEu(String s, DealBreakdownAddress dealbreakdownaddress)
    {
        purchaseButton.startSpinning();
        shippingService.updateShippingAddressEu(this, s, null, new CheckedFunction1() {

            final Purchase this$0;

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((Void)obj);
            }

            public void execute(Void void1)
                throws Exception
            {
                refresh();
                handleOrderDetailsSection();
            }

            
            {
                this$0 = Purchase.this;
                super();
            }
        }, new Function1() {

            final Purchase this$0;

            public void execute(Exception exception)
            {
                if (exception instanceof HttpResponseException)
                {
                    Toast.makeText(getApplicationContext(), getString(0x7f0801a3), 1).show();
                }
            }

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((Exception)obj);
            }

            
            {
                this$0 = Purchase.this;
                super();
            }
        }, new Function0() {

            final Purchase this$0;

            public void execute()
            {
                purchaseButton.stopSpinning();
            }

            
            {
                this$0 = Purchase.this;
                super();
            }
        }, shippingService.getMainHttpParams(dealbreakdownaddress).toArray());
    }

    private void updateStockControl()
    {
        if (option.stockManagement && stockControlHeaderContainer != null && stockControlContainer != null)
        {
            String s;
            String s1;
            int i;
            if (stockValue != null)
            {
                s = stockValue.name;
            } else
            {
                s = null;
            }
            stockControlHeaderContainer.setVisibility(0);
            stockControlContainer.removeAllViews();
            if (Strings.isEmpty(s))
            {
                i = 0x7f0301a8;
            } else
            {
                i = 0x7f0301a0;
            }
            if (Strings.notEmpty(s))
            {
                s1 = SELECT_PREFERENCES;
            } else
            {
                s1 = null;
            }
            if (!Strings.notEmpty(s))
            {
                s = SELECT_PREFERENCES;
            }
            getBasicListItem(stockControlContainer, i, s1, s, 0, new android.view.View.OnClickListener() {

                final Purchase this$0;

                public void onClick(View view)
                {
                    startActivityForResult(intentFactory.newStockCategoriesIntent(dealId, dealOptionId).putExtra("stockValue", stockValue), 10121);
                }

            
            {
                this$0 = Purchase.this;
                super();
            }
            });
        }
    }

    protected void addCustomFieldItems()
    {
        if (customFieldMap != null)
        {
            customFieldViewsMap = new HashMap();
            Iterator iterator = customFieldMap.entrySet().iterator();
            while (iterator.hasNext()) 
            {
                final String selectedValue = (java.util.Map.Entry)iterator.next();
                final String key = (String)selectedValue.getKey();
                final String possibleValues[] = getCustomFieldPossibleValues(key);
                Object obj;
                android.view.View.OnClickListener onclicklistener;
                LinearLayout linearlayout;
                int i;
                boolean flag;
                if (Strings.equalsIgnoreCase(key, CVV_STRING))
                {
                    obj = REENTER_CVV;
                } else
                {
                    obj = key;
                }
                selectedValue = (String)selectedValue.getValue();
                if (possibleValues != null && possibleValues.length > 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                linearlayout = userInputActionContainer;
                if (flag)
                {
                    i = 0x7f030199;
                } else
                {
                    i = 0x7f0301a1;
                }
                if (flag)
                {
                    onclicklistener = new android.view.View.OnClickListener() {

                        final Purchase this$0;
                        final String val$key;
                        final String val$possibleValues[];
                        final String val$selectedValue;

                        public void onClick(View view)
                        {
                            onCustomFieldClick(key, possibleValues, selectedValue);
                        }

            
            {
                this$0 = Purchase.this;
                key = s;
                possibleValues = as;
                selectedValue = s1;
                super();
            }
                    };
                } else
                {
                    onclicklistener = null;
                }
                obj = addPurchaseActionItem(linearlayout, i, ((CharSequence) (obj)), selectedValue, 0x7f02020a, flag, onclicklistener);
                customFieldViewsMap.put(key, obj);
                addUserInputActionSeparator();
            }
        }
    }

    protected void addGiftingParameters(List list)
    {
        if (giftingRecord != null && Strings.notEmpty(giftingRecord.fromName) && Strings.notEmpty(giftingRecord.recipientName) && Strings.notEmpty(giftingRecord.message))
        {
            list.addAll(Arrays.asList(new String[] {
                "gift_from_name", giftingRecord.fromName, "gift_to_name", giftingRecord.recipientName, "gift_message", giftingRecord.message
            }));
            if (Strings.notEmpty(giftingRecord.themeId))
            {
                list.addAll(Arrays.asList(new String[] {
                    "gift_theme", giftingRecord.themeId
                }));
            }
            if (giftingRecord.isGiftWrappable)
            {
                list.addAll(Arrays.asList(new Serializable[] {
                    "gift_wrap", Boolean.valueOf(giftingRecord.isGiftWrapped)
                }));
            } else
            {
                String s = giftingRecord.deliveryMethod;
                list.addAll(Arrays.asList(new Serializable[] {
                    "gift_delivery_method", s, "is_gift", Boolean.valueOf(true)
                }));
                if (s.equals("email"))
                {
                    list.addAll(Arrays.asList(new String[] {
                        "gift_recipient_email_address", giftingRecord.recipientEmail
                    }));
                    if (Strings.notEmpty(giftingRecord.emailDeliveryTime))
                    {
                        list.addAll(Arrays.asList(new String[] {
                            "gift_email_delivery_time", giftingRecord.emailDeliveryTime
                        }));
                        return;
                    }
                }
            }
        }
    }

    protected void addMultiUsePromoCodeParameterIfNecessary(List list)
    {
        String s;
        if (currentBreakdown != null)
        {
            s = currentBreakdown.multiUsePromoCode;
        } else
        {
            s = "";
        }
        if (Strings.notEmpty(s))
        {
            list.addAll(Arrays.asList(new String[] {
                "promo_code", s
            }));
        }
    }

    protected void addQuantityItem()
    {
        if (currentBreakdown != null)
        {
            int i = currentBreakdown.getBreakdownItem().quantity;
            Ln.d("BREAKDOWN: quantity, set current quantity based on breakdown: %d", new Object[] {
                Integer.valueOf(i)
            });
            currentlySelectedQuantity = i;
        }
        final int minCount = option.getMinimumPurchaseQuantity();
        final int maxCount;
        if (stockValue != null)
        {
            maxCount = stockValue.maxStock - stockValue.soldQuantity;
        } else
        {
            maxCount = option.maximumPurchaseQuantity;
        }
        addPurchaseActionItem(userInputActionContainer, 0x7f0301ac, QUANTITY, String.valueOf(currentlySelectedQuantity), 0x7f020227, false, new android.view.View.OnClickListener() {

            final Purchase this$0;
            final int val$maxCount;
            final int val$minCount;

            public void onClick(View view)
            {
                onChangeQuantity(minCount, maxCount);
            }

            
            {
                this$0 = Purchase.this;
                minCount = i;
                maxCount = j;
                super();
            }
        });
        addUserInputActionSeparator();
    }

    protected void addStockControlItem()
    {
        if (option.stockManagement)
        {
            String s;
            if (stockValue != null)
            {
                s = stockValue.name;
            } else
            {
                s = null;
            }
            if (!Strings.notEmpty(s))
            {
                s = null;
            }
            addPurchaseActionItem(userInputActionContainer, 0x7f0301b5, SELECT_PREFERENCES, s, 0x7f02020a, true, new android.view.View.OnClickListener() {

                final Purchase this$0;

                public void onClick(View view)
                {
                    startActivityForResult(intentFactory.newStockCategoriesIntent(dealId, dealOptionId).putExtra("stockValue", stockValue), 10121);
                }

            
            {
                this$0 = Purchase.this;
                super();
            }
            });
        }
    }

    protected void addUserInputActionSeparator()
    {
        if (userInputActionContainer.getChildCount() > 0)
        {
            inflater.inflate(0x7f0301ae, userInputActionContainer);
        }
    }

    protected boolean areCustomFieldsValid()
    {
label0:
        {
            if (customFieldMap == null)
            {
                break label0;
            }
            if (isNewCheckout1408)
            {
                saveCustomFieldsValues();
            }
            HashMap hashmap = getCustomFieldRequiredMap();
            Iterator iterator = customFieldMap.entrySet().iterator();
            java.util.Map.Entry entry;
            String s;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                entry = (java.util.Map.Entry)iterator.next();
                s = (String)entry.getKey();
            } while (s.equals(CVV_STRING) || !Strings.isEmpty(entry.getValue()) || !((Boolean)hashmap.get(s)).booleanValue());
            showCustomFieldError(s);
            return false;
        }
        return true;
    }

    protected void displayBreakdownError(Exception exception)
    {
        if (exception instanceof GrouponException)
        {
            if ((GrouponException)exception instanceof ShippingException)
            {
                displayShippingAddressError();
                return;
            }
            if (exception instanceof TravelInventoryNotFoundException)
            {
                displayTravelInventoryNotFoundError();
                return;
            }
            if (exception instanceof BreakdownException)
            {
                if (((BreakdownException)exception).mapErrorFieldToErrorList.get("travelInventoryNotFound") != null)
                {
                    displayTravelInventoryNotFoundError();
                    return;
                } else
                {
                    displayGenericBreakdownsError(exception);
                    return;
                }
            }
            if (fromGiftCodesScreen && Strings.notEmpty(multiUsePromoCode))
            {
                multiUsePromoCode = "";
                displayPromoCodeError(exception);
                return;
            } else
            {
                displayGenericBreakdownsError(exception);
                return;
            }
        } else
        {
            displayRetryCancelDialog();
            return;
        }
    }

    protected void displayGenericBreakdownsError(Exception exception)
    {
        showDialog(dialogManager.getDialogFragmentGrouponException((GrouponException)exception), "breakdowns_dismiss_only_error_dialog");
    }

    protected void displayInvalidBreakdownsPaymentMethodsDialog(String s)
    {
        Object obj;
        byte byte0;
        byte0 = 0;
        obj = dialogManager.getDialogFragment(null, Integer.valueOf(0x7f0803f4), Integer.valueOf(0x7f080139), false);
        s.hashCode();
        JVM INSTR lookupswitch 2: default 56
    //                   -1105631006: 156
    //                   2003628439: 168;
           goto _L1 _L2 _L3
_L1:
        byte0 = -1;
_L7:
        byte0;
        JVM INSTR tableswitch 0 1: default 80
    //                   0 182
    //                   1 192;
           goto _L4 _L5 _L6
_L4:
        obj = new StringBuilder();
        if (Strings.notEmpty(dealOptionId))
        {
            s = dealOptionId;
        } else
        {
            s = dealId;
        }
        s = ((StringBuilder) (obj)).append(s).append(", ").append(loginService.getUserId()).toString();
        logger.log(new Impression("", "invalid_breakdowns_payment_method", s, "", Logger.NULL_NST_FIELD));
        return;
_L2:
        if (!s.equals("breakdowns_payments_action_choose_payment")) goto _L1; else goto _L7
_L3:
        if (!s.equals("breakdowns_payments_action_finish")) goto _L1; else goto _L8
_L8:
        byte0 = 1;
          goto _L7
_L5:
        showDialog(((GrouponDialogFragment) (obj)), "invalid_breakdowns_payment_methods_dialog_choose_payment");
          goto _L4
_L6:
        showDialog(((GrouponDialogFragment) (obj)), "invalid_breakdowns_payment_methods_dialog_finish");
          goto _L4
    }

    protected void displayOrderErrorDialog(Exception exception)
    {
        if (exception instanceof GrouponException)
        {
            exception = (GrouponException)exception;
            Object obj = ((GrouponException) (exception)).mapErrorFieldToErrorList;
            if (obj != null && !((Map) (obj)).entrySet().isEmpty())
            {
                exception = new StringBuilder();
                for (obj = ((Map) (obj)).entrySet().iterator(); ((Iterator) (obj)).hasNext();)
                {
                    Iterator iterator = ((Collection)((java.util.Map.Entry)((Iterator) (obj)).next()).getValue()).iterator();
                    while (iterator.hasNext()) 
                    {
                        String s = (String)iterator.next();
                        exception.append('\n');
                        exception.append(s);
                    }
                }

                exception = exception.toString();
            } else
            {
                exception = exception.getMessage();
            }
            if (Strings.notEmpty(exception))
            {
                exception = dialogManager.getDialogFragment(exception);
                GrouponDialogFragment.show(getFragmentManager(), exception, "generic_error_dialog");
                return;
            }
        }
        displayOrdersErrorDialog();
    }

    protected void displayOrdersErrorDialog()
    {
        GrouponDialogFragment.show(getFragmentManager(), dialogManager.getDialogFragment(Integer.valueOf(0x7f080165)), "generic_error_dialog");
    }

    protected void doAddUserPaymentStorageConsentIfNeeded(List list)
    {
        if (currentPaymentMethod != null && !currentPaymentMethod.isCreditCard() || !loginPrefs.contains("userCreditCardStorageConsent"))
        {
            return;
        } else
        {
            list.addAll(Arrays.asList(new Serializable[] {
                "billing_record[isStorableForFutureUse]", Boolean.valueOf(loginPrefs.getBoolean("userCreditCardStorageConsent", false))
            }));
            return;
        }
    }

    public void draw()
    {
        updateOptionAndPrice();
        Integer integer = Integer.valueOf(option.getMinimumPurchaseQuantity());
        if (currentlySelectedQuantity < integer.intValue())
        {
            currentlySelectedQuantity = integer.intValue();
        }
        if (customFieldMap == null)
        {
            customFieldMap = getCustomFieldMap(false);
        }
        handleTitle();
        if (!isNewCheckout1408 || checkoutParity1506INTL)
        {
            ImageUrl imageurl = getDealImageUrl();
            dealImageView.setImageUrl(imageurl, new AspectScaleTransformation(deviceInfoUtil.getDisplayMetrics().widthPixels));
        }
        initializeCountryBasedActions();
        lang = deviceInfoUtil.getLanguageFromLocale();
        logDealConfirmationView();
    }

    public void enableSyncProgressIndicator(boolean flag)
    {
    }

    protected GenericAmount getBreakdownSubtotal()
    {
        DealBreakdownItem dealbreakdownitem;
        if (currentBreakdown != null)
        {
            dealbreakdownitem = currentBreakdown.getBreakdownItem();
        } else
        {
            dealbreakdownitem = null;
        }
        if (dealbreakdownitem != null)
        {
            Ln.d("BREAKDOWN: have currentBreakdownItem", new Object[0]);
            return dealbreakdownitem.total;
        } else
        {
            Ln.d("BREAKDOWN: NO currentBreakdownItem", new Object[0]);
            return new GenericAmount(currentlySelectedQuantity * priceAmountInCents, currency, null);
        }
    }

    protected PurchaseBreakdown getCurrentBreakdown()
    {
        return currentBreakdown;
    }

    protected HashMap getCustomFieldMap(boolean flag)
    {
        Object obj = option.customFields;
        if (obj != null && ((Collection) (obj)).size() > 0)
        {
            LinkedHashMap linkedhashmap = new LinkedHashMap();
            Iterator iterator = ((Collection) (obj)).iterator();
            do
            {
                obj = linkedhashmap;
                if (!iterator.hasNext())
                {
                    break;
                }
                obj = (CustomField)iterator.next();
                String s = ((CustomField) (obj)).label;
                if (Strings.notEmpty(s))
                {
                    if (flag)
                    {
                        obj = Long.toString(((CustomField) (obj)).primaryKey.longValue());
                    } else
                    {
                        obj = "";
                    }
                    linkedhashmap.put(s, obj);
                }
            } while (true);
        } else
        {
            obj = new HashMap();
        }
        return ((HashMap) (obj));
    }

    protected Intent getDeepLinkUpIntent()
    {
        if (deal != null)
        {
            return NavUtils.getParentActivityIntent(this).putExtra("dealId", deal.remoteId).putExtra("channel", channel).putExtra("isDeepLinked", true);
        } else
        {
            return null;
        }
    }

    protected int getLayout()
    {
        if (isBookableDeal())
        {
            return 0x7f0300f7;
        }
        if (checkoutParity1506INTL)
        {
            return 0x7f030197;
        }
        return !isNewCheckout1408 ? 0x7f030195 : 0x7f030196;
    }

    protected Intent getNewGiftCodesIntent()
    {
        return intentFactory.newGiftCodesIntent(dealId, dealOptionId, channel);
    }

    protected Intent getNewMyCreditCardIntent()
    {
        return intentFactory.newMyCreditCardIntent(dealId, dealOptionId, channel, isGdtOption(option), false, isUSDCurrency(option), 0, null, null, null, dealPaymentMethodsNameTypePairs, storageConsentRequirements);
    }

    protected void handleAddressAdjustments(DealBreakdownAddresses dealbreakdownaddresses)
    {
        boolean flag = false;
        Ln.d("ADDRESS: handleAddressAdjustments", new Object[0]);
        shippingInfoIsInvalid = false;
        if (dealbreakdownaddresses != null)
        {
            Object obj = dealbreakdownaddresses.original;
            DealBreakdownAddress dealbreakdownaddress = dealbreakdownaddresses.validated;
            if (obj != null && dealbreakdownaddress != null)
            {
                if (currentCountryManager.getCurrentCountry().isUSACompatible())
                {
                    if (shippingService.areAddressesCloseEnough(((DealBreakdownAddress) (obj)), dealbreakdownaddress))
                    {
                        dealbreakdownaddresses = shippingService;
                        if (googleWalletService.getMaskedWalletShippingAddress() != null)
                        {
                            flag = true;
                        }
                        dealbreakdownaddresses.store(dealbreakdownaddress, flag);
                        isValidAddressTheSameAsOriginal = true;
                        return;
                    }
                } else
                if (!dealbreakdownaddresses.differ)
                {
                    isValidAddressTheSameAsOriginal = true;
                    return;
                }
                obj = new GrouponDialogFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("dialog_title_res_id", 0x7f080058);
                if (currentCountryManager.getCurrentCountry().isUSACompatible())
                {
                    dealbreakdownaddresses = addressService.getFormattedAddressFrom(dealbreakdownaddress);
                } else
                {
                    dealbreakdownaddresses = shippingService.getAsJoin(dealbreakdownaddress, true, false, true);
                }
                bundle.putString("dialog_message", dealbreakdownaddresses);
                bundle.putInt("dialog_positive_button_text_res_id", 0x7f080426);
                bundle.putInt("dialog_negative_button_text_res_id", 0x7f0802a6);
                bundle.putSerializable("validated_address", dealbreakdownaddress);
                ((GrouponDialogFragment) (obj)).setArguments(bundle);
                ((GrouponDialogFragment) (obj)).setCancelable(false);
                showDialog(((GrouponDialogFragment) (obj)), "address_validation_dialog");
                return;
            }
        }
    }

    protected Boolean handleOrderResultSaveException(Exception exception)
    {
        Boolean boolean1 = Boolean.valueOf(false);
        int i;
        if (exception instanceof HttpResponseException)
        {
            i = ((HttpResponseException)exception).getStatusCode();
        } else
        {
            i = 900;
        }
        logDealPurchaseConfirmation(exception);
        setIsOrdersCallInProgress(false);
        if ((exception instanceof OrderException) && i == 400)
        {
            OrderException orderexception = (OrderException)exception;
            if (Strings.notEmpty(orderexception.taxAmountChanged))
            {
                showDialog(dialogManager.getDialogFragment(null, Integer.valueOf(0x7f0803c9), Integer.valueOf(0x104000a), Integer.valueOf(0x7f080139), true), "tax_amount_changed_dialog");
                exception = boolean1;
            } else
            if (Strings.notEmpty(orderexception.travelSegmentIdExpired))
            {
                displayTravelInventoryNoLongerAvailableDialog(orderexception.travelSegmentIdExpired);
                exception = boolean1;
            } else
            if (Strings.notEmpty(orderexception.inventoryUnavailable))
            {
                displayTravelInventoryNoLongerAvailableDialog(orderexception.inventoryUnavailable);
                exception = boolean1;
            } else
            if (Strings.notEmpty(orderexception.amount))
            {
                showDialog(dialogManager.getDialogFragment(exception.getMessage(), Integer.valueOf(0x7f080158), Integer.valueOf(0x7f080139), false), null);
                exception = boolean1;
            } else
            {
                if (Strings.equals("unknown shipping address, billing record validation required", exception.getMessage()))
                {
                    showConfirmCreditCardDialog(false);
                    return Boolean.valueOf(false);
                }
                if (Strings.equals("unknown shipping address, billing record validation failed", exception.getMessage()))
                {
                    showConfirmCreditCardDialog(true);
                    return Boolean.valueOf(false);
                }
                displayOrderErrorDialog(exception);
                exception = Boolean.valueOf(false);
            }
        } else
        {
            exception = Boolean.valueOf(true);
        }
        validationCardNumber = null;
        googleWalletService.clearGoogleWalletData();
        hideProcessingFeedback();
        return exception;
    }

    protected void handlePaymentSection()
    {
        PurchaseBreakdown purchasebreakdown = getCurrentBreakdown();
        dealPaymentContainer.removeAllViews();
        Object obj;
        List list;
        List list1;
        List list2;
        GenericAmount genericamount;
        int i;
        if (purchasebreakdown != null)
        {
            list1 = purchasebreakdown.getTenderItemsOfType("credit");
        } else
        {
            list1 = null;
        }
        if (purchasebreakdown != null)
        {
            list = purchasebreakdown.getTenderItemsOfType("cash");
        } else
        {
            list = null;
        }
        if (purchasebreakdown != null)
        {
            list2 = purchasebreakdown.getAdjustments();
        } else
        {
            list2 = null;
        }
        if (purchasebreakdown != null && purchasebreakdown.getPaymentMethods() != null && currentPaymentMethod != null && currentPaymentMethod.isCreditCard())
        {
            obj = getInstallmentOptionsForCardType();
        } else
        {
            obj = null;
        }
        currentAvailableInstallmentOptionsForCardType = ((DealBreakdownPaymentMethodInstallmentItem []) (obj));
        if (purchasebreakdown != null && isBookableDeal())
        {
            bookingDetails = purchasebreakdown.getTravelBookingDetails();
        }
        if (isNewCheckout1408 && googleWalletService.isGoogleWalletPaymentMethod(currentPaymentMethod))
        {
            addGoogleWalletCreditCardItem();
        }
        Ln.d("BREAKDOWN: shouldShowSubtotal", new Object[0]);
        if (isBookableDeal())
        {
            i = 0x7f0300f8;
        } else
        if (isNewCheckout1408)
        {
            i = 0x7f0301af;
        } else
        {
            i = 0x7f03019e;
        }
        genericamount = getBreakdownSubtotal();
        if (currentCountryManager.getCurrentCountry().isJapan())
        {
            obj = com.groupon.util.CurrencyFormatter.DecimalStripBehavior.Always;
        } else
        {
            obj = com.groupon.util.CurrencyFormatter.DecimalStripBehavior.Never;
        }
        if (isNewCheckout1408)
        {
            addPurchaseActionItem(dealPaymentContainer, i, SUBTOTAL, currencyFormatter.format(genericamount, true, ((com.groupon.util.CurrencyFormatter.DecimalStripBehavior) (obj))), 0, false, null);
        } else
        {
            getBasicListItem(dealPaymentContainer, i, SUBTOTAL, currencyFormatter.format(genericamount, true, ((com.groupon.util.CurrencyFormatter.DecimalStripBehavior) (obj))), 0, null);
        }
        if (currentCountryManager.getCurrentCountry().isJapan() && incentiveTickets != null && !deal.isApplyButton)
        {
            Ln.d("BREAKDOWN: incentiveTickets", new Object[0]);
            obj = null;
            Iterator iterator = incentiveTickets.iterator();
            Object obj1;
            do
            {
                obj1 = obj;
                if (!iterator.hasNext())
                {
                    break;
                }
                obj1 = (IncentiveTicket)iterator.next();
            } while (!Strings.equals(((IncentiveTicket) (obj1)).type, selectedIncentiveTicket));
            if (isNewCheckout1408)
            {
                addJapanIncentiveTicketItem();
            } else
            {
                addPaymentSeparator();
                String s;
                LinearLayout linearlayout;
                android.view.View.OnClickListener onclicklistener;
                int j;
                boolean flag;
                if (obj1 != null)
                {
                    j = 0x7f0301a0;
                } else
                {
                    j = 0x7f0301a8;
                }
                linearlayout = dealPaymentContainer;
                if (obj1 != null)
                {
                    if (canUseIncentiveTicket)
                    {
                        obj = ((IncentiveTicket) (obj1)).name;
                    } else
                    {
                        obj = String.format(getString(0x7f080234), new Object[] {
                            ((IncentiveTicket) (obj1)).minimum_points.getFormattedAmount()
                        });
                    }
                } else
                {
                    obj = null;
                }
                if (obj1 != null)
                {
                    s = (new StringBuilder()).append("-").append(currencyFormatter.format(((IncentiveTicket) (obj1)).points, true, com.groupon.util.CurrencyFormatter.DecimalStripBehavior.Always)).toString();
                } else
                {
                    s = APPLY_INCENTIVE_TICKET;
                }
                onclicklistener = new android.view.View.OnClickListener() {

                    final Purchase this$0;

                    public void onClick(View view)
                    {
                        logger.logClick("", "incentive_ticket_select_option_click", "incentive_ticket", dealId);
                        view = Purchase.this;
                        IntentFactory intentfactory = intentFactory;
                        String s1 = selectedIncentiveTicket;
                        boolean flag1;
                        if (giftCode != null)
                        {
                            flag1 = true;
                        } else
                        {
                            flag1 = false;
                        }
                        view.startActivityForResult(intentfactory.newIncentiveTicketsIntent(true, s1, flag1, dealId), 10126);
                    }

            
            {
                this$0 = Purchase.this;
                super();
            }
                };
                if (obj1 != null && !canUseIncentiveTicket)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                getBasicListItem(linearlayout, j, ((String) (obj)), s, 0, onclicklistener, flag);
            }
        }
        handleAdjustments(list2, list1);
        if (list != null && list.size() > 0)
        {
            Ln.d("BREAKDOWN: cash # = %d", new Object[] {
                Integer.valueOf(list.size())
            });
            obj = (DealBreakdownTenderItem)list.get(0);
            Ln.d("BREAKDOWN: cash 0: %d", new Object[] {
                Integer.valueOf(((DealBreakdownTenderItem) (obj)).amount.getAmount())
            });
        } else
        {
            Ln.d("BREAKDOWN: no cash items, make one now", new Object[0]);
            obj = new DealBreakdownTenderItem();
            obj.amount = genericamount;
        }
        Ln.d("BREAKDOWN: cash calling handleCashTender", new Object[0]);
        handleCashTender(((DealBreakdownTenderItem) (obj)));
        handleBottomBarTotal(((DealBreakdownTenderItem) (obj)).amount, shouldShowTaxAndShippingLabel(list));
        if (shouldShowEnterCode())
        {
            if (!isNewCheckout1408)
            {
                addPaymentSeparator();
            }
            if (!isNewCheckout1408)
            {
                getBasicListItem(dealPaymentContainer, 0x7f0301a8, null, getString(0x7f08014d), 0, new android.view.View.OnClickListener() {

                    final Purchase this$0;

                    public void onClick(View view)
                    {
                        logEnterCodeClickEvent();
                        startGiftCodesIntent();
                    }

            
            {
                this$0 = Purchase.this;
                super();
            }
                });
            }
        }
        if (!isNewCheckout1408)
        {
            addGoogleWalletCreditCardItem();
        }
    }

    public void handleSyncError(Runnable runnable, Exception exception)
    {
        if (Boolean.valueOf(getIntent().getBooleanExtra("isDeepLinked", false)).booleanValue())
        {
            handleDeepLinkError();
            return;
        } else
        {
            handleException(exception);
            return;
        }
    }

    protected void handleTitle()
    {
        boolean flag = false;
        Object obj;
        String s;
        int i;
        if (currentBreakdown != null)
        {
            obj = currentBreakdown.getBreakdownItem();
        } else
        {
            obj = null;
        }
        if (isMultiOptionsIntlDeal || deal.getOptions().size() > 1)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i == 0 && obj != null && Strings.notEmpty(((DealBreakdownItem) (obj)).name))
        {
            s = ((DealBreakdownItem) (obj)).name;
        } else
        {
            s = option.getTitle();
        }
        if (titleView != null)
        {
            Ln.d("BREAKDOWN: handleTitle", new Object[0]);
            Ln.d("BREAKDOWN: title from deal: %s", new Object[] {
                s
            });
            titleView.setText(s);
        }
        if (isNewCheckout1408 && dealCardCompact != null && obj != null)
        {
            if (deal != null)
            {
                dealCardCompact.setTitle(s);
                dealCardCompact.setPrice(((DealBreakdownItem) (obj)).unitPrice.getFormattedAmount());
            }
            obj = dealCardCompact;
            if (deal != null)
            {
                i = ((flag) ? 1 : 0);
            } else
            {
                i = 8;
            }
            ((DealCardCompact) (obj)).setVisibility(i);
        }
    }

    protected boolean hasDealData()
    {
        return deal != null;
    }

    protected void hideProcessingFeedback()
    {
        Ln.d("SPINNING: hideProcessingFeedback", new Object[0]);
        purchaseButton.stopSpinning();
        updatePurchaseButtonState();
    }

    protected void initActionBar(Bundle bundle)
    {
        super.initActionBar(bundle);
        int i;
        if (isNewCheckout1408)
        {
            i = 0x7f080337;
        } else
        {
            i = 0x7f0800c1;
        }
        setToolbarTitle(getString(i));
    }

    protected void initDealLoader(boolean flag)
    {
        if (!Strings.isEmpty(dealId))
        {
            dealSyncManager.setForceDownload(flag);
            getLoaderManager().initLoader(0, null, new DealLoaderCallbacks(this, dealId) {

                final Purchase this$0;

                public void onDealLoaded(Deal deal1)
                {
                    onRequestDealSuccess(deal1, isDeepLinked);
                    if (onDealLoadedSuccess != null)
                    {
                        onDealLoadedSuccess.execute();
                        onDealLoadedSuccess = null;
                    }
                }

            
            {
                this$0 = Purchase.this;
                super(context, s);
            }
            });
            if (flag)
            {
                syncDeal(null);
                return;
            }
        }
    }

    protected void initializeCountryBasedActions()
    {
        purchaseButton.setOnClickListener(new android.view.View.OnClickListener() {

            final Purchase this$0;

            public void onClick(View view)
            {
                if (!isOrdersCallInProgress.get())
                {
                    onPurchaseButtonClick();
                }
            }

            
            {
                this$0 = Purchase.this;
                super();
            }
        });
        setBuyWithGoogleButtonClickListener();
    }

    protected boolean isCurrentBreakdownValid()
    {
        return currentBreakdown != null;
    }

    protected boolean isGdtOption(Option option1)
    {
        return option1.specificAttributeDelivery || option1.specificAttributeTakeout;
    }

    protected boolean isShippingAddressRequired()
    {
        return deal.shippingAddressRequired;
    }

    protected boolean isUSDCurrency(Option option1)
    {
        return currencyFormatter.isUSDCurrency(option1.getPrice());
    }

    protected void logDealConfirmationView()
    {
        logger.logDealConfirmationView("", channel.toString(), deal.remoteId, "", deal.uuid, "", loggingUtils.getDealConfirmationViewExtraInfo(deal.isTravelBookableDeal, channel.toString(), dealOptionId, defaultOptionIdSelected));
    }

    protected void logDealPurchaseConfirmation(Exception exception)
    {
        String s;
        String s1;
        Logger logger1;
        String s2;
        String s3;
        String s4;
        String s5;
        String s6;
        String s7;
        String s8;
        String s9;
        int i;
        long l;
        if (exception == null)
        {
            i = 0;
        } else
        if (exception instanceof HttpResponseException)
        {
            i = ((HttpResponseException)exception).getStatusCode();
        } else
        {
            i = 900;
        }
        if (exception == null)
        {
            s = "";
        } else
        {
            s = exception.getMessage();
        }
        if (isBookingUpdatePreBook1506USCA && DealUtils.isBookingEngineDeal(deal, true))
        {
            if (reservationDetails != null)
            {
                exception = "yes";
            } else
            {
                exception = "no";
            }
        } else
        {
            exception = "";
        }
        logger1 = logger;
        s2 = channel.toString();
        s3 = deal.remoteId;
        s4 = option.remoteId;
        s5 = attributionService.getAttributionCid();
        s6 = attributionService.getAttributionId();
        s7 = attributionService.getAttributionType();
        l = attributionService.getDeepLinkTimeOverlap(Long.valueOf(System.currentTimeMillis())).longValue();
        s8 = attributionService.getAttributionDownloadId();
        s9 = attributionService.getAttributionDownloadCid();
        if (orderId == null)
        {
            s1 = "";
        } else
        {
            s1 = orderId;
        }
        logger1.logDealPurchaseConfirmation("", s2, s3, i, s, s4, s5, s6, s7, l, s8, s9, s1, "", deal.uuid, "", loggingUtils.getLogExtraInfo(deal.isTravelBookableDeal, channel.toString(), currentlySelectedQuantity, priceAmountInCents, currency, exception, null));
    }

    protected void logDealPurchaseInitiation()
    {
        String s;
        String s1;
        if (isGDT1503USCA)
        {
            if (isGdtOption(option))
            {
                s = "on";
            } else
            {
                s = "off";
            }
        } else
        {
            s = "";
        }
        if (isBookingUpdatePreBook1506USCA && DealUtils.isBookingEngineDeal(deal, true))
        {
            if (reservationDetails != null)
            {
                s1 = "yes";
            } else
            {
                s1 = "no";
            }
        } else
        {
            s1 = "";
        }
        logger.logDealPurchaseInitiation("", channel.toString(), deal.remoteId, currentlySelectedQuantity, priceAmountInCents, option.remoteId, currency, attributionService.getAttributionCid(), attributionService.getAttributionId(), attributionService.getAttributionType(), attributionService.getDeepLinkTimeOverlap(Long.valueOf(System.currentTimeMillis())).longValue(), attributionService.getAttributionDownloadId(), attributionService.getAttributionDownloadCid(), "", deal.uuid, "", loggingUtils.getPurchaseInitiationExtraInfo(deal.isTravelBookableDeal, channel.toString(), s, s1));
    }

    public void logPageViewEvent()
    {
        Logger logger1 = logger;
        String s = getPageViewId();
        Object obj;
        if (dealId != null)
        {
            obj = new PageViewExtraInfo(dealId);
        } else
        {
            obj = Logger.NULL_NST_FIELD;
        }
        logger1.logPageView("", s, ((com.groupon.tracking.mobile.EncodedNSTField) (obj)));
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        i;
        JVM INSTR lookupswitch 9: default 92
    //                   1: 225
    //                   1001: 266
    //                   1002: 276
    //                   1003: 286
    //                   1004: 295
    //                   10105: 117
    //                   10107: 108
    //                   10112: 117
    //                   10126: 231;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L7 _L9
_L1:
        if (isBookableDeal())
        {
            travelerNameHelper.onActivityResult(i);
        }
        return;
_L8:
        handleGiftingRequestCode(j, intent);
        continue; /* Loop/switch isn't completed */
_L7:
        if (intent != null)
        {
            fromGiftCodesScreen = true;
            String s = intent.getStringExtra("multi_use_promo_code");
            if (Strings.notEmpty(s))
            {
                multiUsePromoCode = s;
                shouldShowMultiUsePromoCodeSuccessMessage = true;
            } else
            if (currentCountryManager.getCurrentCountry().isJapan())
            {
                giftCode = (GiftCode)intent.getSerializableExtra("gift_code");
            }
        }
        Ln.d("BREAKDOWN: came back from MyCreditCards, refresh", new Object[0]);
        if (hasDealData())
        {
            setCurrentPaymentMethod(null);
        } else
        {
            requestSync(new Function0() {

                final Purchase this$0;

                public void execute()
                {
                    setCurrentPaymentMethod(null);
                }

            
            {
                this$0 = Purchase.this;
                super();
            }
            });
        }
        continue; /* Loop/switch isn't completed */
_L2:
        handleConfirmCreditCardRequestCode(j, intent);
_L9:
        if (j == -1)
        {
            if (intent.getBooleanExtra("removeGiftCodes", false))
            {
                giftCode = null;
            }
            selectedIncentiveTicket = intent.getStringExtra("incentive_ticket_type");
        }
        continue; /* Loop/switch isn't completed */
_L3:
        handleMaskedWalletRequest(j, intent, false);
        continue; /* Loop/switch isn't completed */
_L4:
        handleMaskedWalletRequest(j, intent, true);
        continue; /* Loop/switch isn't completed */
_L5:
        handleLoadFullWalletRequestCode(j, intent);
        continue; /* Loop/switch isn't completed */
_L6:
        handleCheckPreauthorizationRequestCode(j, intent);
        if (true) goto _L1; else goto _L10
_L10:
    }

    public void onBackPressed()
    {
        if (isBookingUpdatePreBook1506USCA && DealUtils.isBookingEngineDeal(deal, true))
        {
            loggingUtils.logPrePurchaseBookingClick("action_back", "back_reservation", dealId, channel, PURCHASE_PAGE_ID);
        } else
        {
            logger.logClick("", "back_arrow_click", channel.toString(), Logger.NULL_NST_FIELD, new UpBackClickExtraInfo(getPageViewId(), "system_back"));
        }
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Intent intent;
        boolean flag;
        boolean flag1;
        if (abTestService.isVariantEnabled("checkoutParity1506INTL", "on") && !currentCountryManager.getCurrentCountry().isUSACompatible())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        checkoutParity1506INTL = flag;
        if (currentCountryManager.getCurrentCountry().isUSACompatible() || checkoutParity1506INTL)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isNewCheckout1408 = flag;
        isMultiOptions1508INTL = abTestService.isVariantEnabled("multioptions1508INTL", "on");
        isGDT1503USCA = abTestService.isVariantEnabledAndUSCA("GDT1503USCA", "on");
        isBookingUpdatePreBook1506USCA = abTestService.isVariantEnabledAndUSCA("bookingUpdatesPreBook1506USCA", "on");
        if (reservationDetailsBundle != null)
        {
            reservationDetails = (SchedulerReservationDetails)reservationDetailsBundle.getParcelable("reservation_extra");
        }
        if (dateTimeFinderReservationDetailsBundle != null)
        {
            dateTimeFinderReservationDetails = (DateTimeFinderReservationDetails)dateTimeFinderReservationDetailsBundle.getParcelable("reservation_details");
        }
        if (currentCountryManager.getCurrentCountry().isUSOnly() && abTestService.isVariantEnabled("livechatCheckout1508US", "on"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        canShowLiveChat = flag;
        if (redirectToEnterCode)
        {
            startGiftCodesIntent();
        }
        if (isNewCheckout1408 && !isBookableDeal())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isNewCheckout1408 = flag;
        if (channel == null)
        {
            channel = Channel.DETAIL;
        }
        isCityDealCountry = currentCountryManager.getCurrentCountry().isCityDealCountry();
        if (currentCountryManager.getCurrentCountry().isNewsletterOptInEnabledCountry() && abTestService.isVariantEnabled("nLOptIn1403INTL", "on"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isNewsletterOptInEnabled = flag;
        overrideAbValues();
        setContentView(getLayout());
        if (isBookableDeal())
        {
            initializeGetawaysPurchaseViews();
            travelerNameHelper = new TravelerNameHelper(this, volatileTravelerNameProvider, loginService, fullName, intentFactory);
            travelerNameHelper.onCreate(bundle);
        } else
        {
            initializeDefaultPurchaseViews();
        }
        if (googleWalletService.isGoogleWalletEnabled())
        {
            googleWalletService.initialiseGoogleWallet(this, dealOptionId);
        }
        if (bundle != null && bundle.containsKey("purchased"))
        {
            purchased = bundle.getBoolean("purchased");
        }
        if (isCityDealCountry && isNewsletterOptInEnabled)
        {
            showNewsletterOptIn();
        }
        if (!isNewCheckout1408 || checkoutParity1506INTL)
        {
            scroller.setOnLayoutUpdatedListener(new com.groupon.view.ObservableScrollView.OnLayoutUpdatedListener() {

                final Purchase this$0;

                public void onLayoutUpdated(boolean flag2, int i, int j, int k, int l)
                {
                    adjustScrollToTopOfTitle();
                }

            
            {
                this$0 = Purchase.this;
                super();
            }
            });
        }
        scroller.addOnScrollChangedListener(new com.groupon.view.ObservableScrollView.OnScrollChangedListener() {

            final Purchase this$0;

            public void onScrollChanged(ObservableScrollView observablescrollview, int i, int j, int k, int l)
            {
                View view = observablescrollview.getChildAt(observablescrollview.getChildCount() - 1);
                i = view.getBottom();
                k = observablescrollview.getHeight();
                int i1 = observablescrollview.getScrollY();
                int j1 = view.getTop();
                if (l > j && observablescrollview.isScrolledToBottom())
                {
                    observablescrollview.setScrolledToBottom(false);
                } else
                if (i - (k + i1 + j1) == 0 && j != l && !observablescrollview.isScrolledToBottom())
                {
                    observablescrollview.setScrolledToBottom(true);
                    if (liveChatView != null && liveChatView.getVisibility() == 0)
                    {
                        logger.log(new Impression("", "show_live_chat", channel.toString(), "bottom", new LiveChatExtraInfo(com/groupon/activity/Purchase.getSimpleName(), dealId)));
                        return;
                    }
                }
            }

            
            {
                this$0 = Purchase.this;
                super();
            }
        });
        intent = getIntent();
        flag = intent.getBooleanExtra("isDeepLinked", false);
        flag1 = intent.getBooleanExtra("is_wearable_preview_purchase", false);
        if (flag || flag1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        initDealLoader(flag);
        viewTerms.setText(Html.fromHtml(getString(0x7f08040f)));
        viewTerms.setMovementMethod(LinkMovementMethod.getInstance());
        bottomBarText.setVisibility(0);
        if (!isNewCheckout1408)
        {
            bottomBar.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

                final Purchase this$0;

                public void onGlobalLayout()
                {
                    int i = bottomBar.getHeight();
                    scrollableContent.setPadding(0, 0, 0, i);
                }

            
            {
                this$0 = Purchase.this;
                super();
            }
            });
        }
        migrationManager.restoreState(bundle);
        migrationManager.build(this);
    }

    public void onDialogCancel(String s, DialogInterface dialoginterface)
    {
    }

    public void onDialogItemClick(String s, DialogInterface dialoginterface, int i)
    {
        if (Strings.equals(s, "installments_dialog"))
        {
            onInstallmentsDialogItemClick(i);
        } else
        {
            if (Strings.equals(s, "quantity_dialog"))
            {
                onQuantityDialogItemClick(i);
                return;
            }
            if (Strings.equals(s, "custom_field_dialog"))
            {
                onCustomFieldDialogItemClick(dialoginterface, i);
                return;
            }
        }
    }

    public void onDialogMultiChoiceItemClick(String s, DialogInterface dialoginterface, int i, boolean flag)
    {
    }

    public void onDialogNegativeButtonClick(String s, DialogInterface dialoginterface)
    {
        isValidAddressTheSameAsOriginal = false;
        handleOrderDetailsSection();
        if (Strings.equals(s, "breakdowns_error_dialog"))
        {
            finish();
        }
    }

    public void onDialogPositiveButtonClick(String s, DialogInterface dialoginterface)
    {
        if (Strings.equals(s, "http_error_dialog"))
        {
            onHttpErrorPositiveClick();
        } else
        {
            if (Strings.equals(s, "tax_amount_changed_dialog"))
            {
                onTaxAmountChangedPositiveClick();
                return;
            }
            if (Strings.equals(s, "remove_incentive_tickets_dialog"))
            {
                onRemoveIncentiveTicketsPositiveClick();
                return;
            }
            if (Strings.equals(s, "address_validation_dialog"))
            {
                onAddressValidationPositiveClick();
                return;
            }
            if (Strings.equals(s, "custom_field_dialog"))
            {
                onCustomFieldPositiveClick();
                return;
            }
            if (Strings.equals(s, "shipping_address_error_dialog"))
            {
                onShippingAddrErrorPositiveClick();
                return;
            }
            if (Strings.equals(s, "breakdowns_error_dialog"))
            {
                onBreakdownsErrorPositiveClick();
                return;
            }
            if (Strings.equals(s, "breakdowns_dismiss_only_error_dialog"))
            {
                onBreakdownsDismissOnlyErrorNegativeClick();
                return;
            }
            if (Strings.equals(s, "travel_inventory_not_found_dialog"))
            {
                onTravelInventNotFoundPositiveClick();
                return;
            }
            if (Strings.equals(s, "travel_inventory_not_available_dialog"))
            {
                onTravelInventNotAvailablePositiveClick();
                return;
            }
            if (Strings.equals(s, "promo_code_breakdowns_failed_dialog"))
            {
                onBreakdownsErrorPositiveClick();
                return;
            }
            if (Strings.equals(s, "invalid_breakdowns_payment_methods_dialog_finish"))
            {
                onInvalidBreakdownsPaymentMethodsDismissClickFinish();
                return;
            }
            if (Strings.equals(s, "invalid_breakdowns_payment_methods_dialog_choose_payment"))
            {
                onInvalidBreakdownsPaymentMethodsDismissClickChoosePayment();
                return;
            }
            if (Strings.equals(s, "pre_purchase_reservation_expired_dialog"))
            {
                onPrePurchaseReservationExpiredPossitiveButtonClick();
                return;
            }
        }
    }

    public void onDialogShown(String s, DialogInterface dialoginterface)
    {
    }

    protected boolean onNavigationUpPressed()
    {
label0:
        {
            if (deal != null)
            {
                if ((!isBookingUpdatePreBook1506USCA || !DealUtils.isBookingEngineDeal(deal, true)) && dateTimeFinderReservationDetails == null)
                {
                    break label0;
                }
                loggingUtils.logPrePurchaseBookingClick("action_back", "back_reservation", dealId, channel, PURCHASE_PAGE_ID);
                finish();
            }
            return false;
        }
        logger.logClick("", "back_arrow_click", channel.toString(), Logger.NULL_NST_FIELD, new UpBackClickExtraInfo(getPageViewId(), "app_back_arrow"));
        if (buyUtils.showOptionsWithImages(deal, this)) goto _L2; else goto _L1
_L1:
        Object obj;
        obj = multiOptionUtil;
        Deal deal1 = deal;
        Channel channel1 = channel;
        boolean flag;
        if (dateTimeFinderReservationDetails != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!((MultiOptionUtil) (obj)).canDisplayExposedMultiOptions(deal1, channel1, flag) || dealOptionId == null) goto _L3; else goto _L2
_L2:
        if (isBookableDeal())
        {
            obj = intentFactory.newDealIntentWithOption(deal, channel, dealOptionId, 0).putExtra("isDeepLinked", getIntent().getBooleanExtra("isDeepLinked", false));
        } else
        {
            obj = intentFactory.newDealIntentWithExplicitOption(deal.remoteId, channel, dealOptionId).putExtra("isDeepLinked", getIntent().getBooleanExtra("isDeepLinked", false));
        }
_L5:
        return ActionBarUtil.navigateUpTo(this, channel, ((Intent) (obj)), null);
_L3:
        obj = intentFactory.newDealIntent(deal, channel).putExtra("isDeepLinked", getIntent().getBooleanExtra("isDeepLinked", false));
        if (true) goto _L5; else goto _L4
_L4:
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        Ln.d("onNewIntent(%s)", new Object[] {
            intent
        });
        if (intent.getBooleanExtra("refresh", false))
        {
            refresh();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        boolean flag1 = true;
        menuitem.getItemId();
        JVM INSTR lookupswitch 2: default 36
    //                   16908332: 54
    //                   2131755025: 44;
           goto _L1 _L2 _L3
_L1:
        boolean flag = super.onOptionsItemSelected(menuitem);
_L5:
        return flag;
_L3:
        logEnterCodeClickEvent();
        startGiftCodesIntent();
        return true;
_L2:
        flag = flag1;
        if (!onNavigationUpPressed())
        {
            flag = flag1;
            if (!super.onOptionsItemSelected(menuitem))
            {
                return false;
            }
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    protected void onPostResume()
    {
        super.onPostResume();
        if (googleWalletService.isGoogleWalletPaymentMethod(currentPaymentMethod))
        {
            if (googleWalletService.shouldShowGenericErrorDialog())
            {
                googleWalletService.showGoogleWalletGenericErrorDialog(this);
            }
            if (googleWalletService.shouldShowMaxAmountErrorDialog())
            {
                googleWalletService.showGoogleWalletMaxAmountErrorDialog(this);
            }
        }
    }

    protected void onRequestDealSuccess(Deal deal1, boolean flag)
    {
        if (deal1 != null || !flag) goto _L2; else goto _L1
_L1:
        handleDeepLinkError();
_L4:
        return;
_L2:
        Option option1;
        String s;
        boolean flag1;
        deal = deal1;
        if (isNewCheckout1408)
        {
            setDealCardCompact();
        }
        if (isMultiOptions1508INTL)
        {
            isMultiOptionsIntlDeal = buyUtils.showOptionsWithImages(deal1, this);
        }
        if (canShowLiveChat)
        {
            liveChatUtil.channel = channel;
            liveChatUtil.dealId = dealId;
            liveChatUtil.dealUrl = deal1.dealUrl;
            liveChatUtil.pageId = com/groupon/activity/Purchase.getSimpleName();
        }
        Object obj;
        boolean flag2;
        boolean flag3;
        if (Strings.isEmpty(dealOptionId) && deal1.getOptions().size() == 1)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        flag3 = false;
        obj = deal1.getOptions().iterator();
_L6:
        flag1 = flag3;
        if (((Iterator) (obj)).hasNext())
        {
            option1 = (Option)((Iterator) (obj)).next();
            s = option1.remoteId;
            if (!flag2)
            {
                continue; /* Loop/switch isn't completed */
            }
            dealOptionId = s;
            option = option1;
            flag1 = true;
        }
_L7:
        if (flag1)
        {
            draw();
            hideProcessingFeedback();
            if (isShippingAddressRequired() && currentCountryManager.getCurrentCountry().supportsDealBreakdowns())
            {
                shippingInfoIsInvalid = true;
            }
            refresh();
        } else
        {
            Ln.e("Purchase2: unable to find option ID %s for deal %s, go to deal details instead", new Object[] {
                dealOptionId, dealId
            });
            if (!shouldLaunchPurchasePage)
            {
                startActivity(intentFactory.newDealIntent(deal1, channel));
            }
            finish();
        }
        if (!isBookableDeal()) goto _L4; else goto _L3
_L3:
        obj = travelerNameHelper;
        if (Strings.isEmpty(option))
        {
            deal1 = deal1.getTitle();
        } else
        {
            deal1 = option.getTitle();
        }
        ((TravelerNameHelper) (obj)).onDealReady(deal1, getDealImageUrl(), bookingModel);
        return;
        if (dealOptionId == null || !dealOptionId.equals(s)) goto _L6; else goto _L5
_L5:
        option = option1;
        flag1 = true;
          goto _L7
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
        if (bundle != null)
        {
            if (bundle.containsKey("gift_to_name"))
            {
                if (giftingRecord == null)
                {
                    giftingRecord = new GiftingRecord();
                    giftingRecord.fromName = loginService.getFullName();
                }
                giftingRecord.recipientName = bundle.getString("gift_to_name");
                giftingRecord.recipientEmail = bundle.getString("gift_recipient_email_address");
                giftingRecord.message = bundle.getString("gift_message");
            }
            if (bundle.containsKey(QUANTITY))
            {
                currentlySelectedQuantity = bundle.getInt(QUANTITY);
            }
            if (bundle.containsKey("stockValue"))
            {
                stockValue = (StockValue)bundle.getSerializable("stockValue");
            }
            if (bundle.containsKey("customFields"))
            {
                customFieldMap = (HashMap)bundle.getSerializable("customFields");
            }
            if (bundle.containsKey("multi_use_promo_code"))
            {
                multiUsePromoCode = bundle.getString("multi_use_promo_code");
            }
            shippingInfoIsInvalid = bundle.getBoolean("shippingInfoInvalid", true);
            shouldShowMultiUsePromoCodeSuccessMessage = bundle.getBoolean("should_show_multi_use_promo_code_success_message", false);
            wasPaymentMethodPreviouslyDisplayed = bundle.getBoolean("payment_method_previously_displayed", false);
        }
    }

    protected void onResume()
    {
        super.onResume();
        if (hasDealData() && validationCardNumber == null)
        {
            if (googleWalletService.isGoogleWalletPaymentMethod(currentPaymentMethod))
            {
                if (!isOrdersCallInProgress.get())
                {
                    if (!isRefreshingBreakdowns())
                    {
                        setIsRefreshing(true);
                    }
                    refreshDealBreakdowns();
                }
            } else
            {
                hideProcessingFeedback();
                refresh();
            }
        }
        if (canShowLiveChat && liveChatView != null)
        {
            liveChatView.updateLiveChatSection(false);
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (bundle != null)
        {
            if (giftingRecord != null)
            {
                bundle.putString("gift_to_name", giftingRecord.recipientName);
                bundle.putString("gift_recipient_email_address", giftingRecord.recipientEmail);
                bundle.putString("gift_message", giftingRecord.message);
            }
            if (currentlySelectedQuantity > 1)
            {
                bundle.putInt(QUANTITY, currentlySelectedQuantity);
            }
            if (stockValue != null)
            {
                bundle.putSerializable("stockValue", stockValue);
            }
            if (customFieldMap != null)
            {
                bundle.putSerializable("customFields", customFieldMap);
            }
            if (Strings.notEmpty(multiUsePromoCode))
            {
                bundle.putString("multi_use_promo_code", multiUsePromoCode);
            }
            bundle.putBoolean("shippingInfoInvalid", shippingInfoIsInvalid);
            bundle.putBoolean("should_show_multi_use_promo_code_success_message", shouldShowMultiUsePromoCodeSuccessMessage);
            bundle.putBoolean("payment_method_previously_displayed", wasPaymentMethodPreviouslyDisplayed);
            if (isBookableDeal())
            {
                travelerNameHelper.onSaveInstanceState(bundle);
            }
        }
        migrationManager.saveState(bundle);
    }

    protected void overrideAbValues()
    {
    }

    protected void recreateOrderBreakdowns()
    {
        Ln.d("BREAKDOWN: recreateOrderBreakdowns", new Object[0]);
        handleTitle();
        handleOrderDetailsSection();
        handlePaymentSection();
    }

    protected boolean redirectToAddPaymentMethod()
    {
        if (shouldShowAddPaymentMethodPrompt() || currentPaymentMethod != null && billingRecordExpiryChecker.isBillingRecordExpired(currentPaymentMethod.getBillingRecord()))
        {
            logger.logClick("", "add_payment_method_click", getClass().getName(), dealId);
            Intent intent;
            if (currentCountryManager.getCurrentCountry().acceptsOtherPayments() || googleWalletService.isGoogleWalletEnabled() && shouldDisplayGoogleWallet())
            {
                intent = getNewMyCreditCardIntent();
            } else
            {
                intent = intentFactory.newEditCreditCardIntent(getAvailableCCPaymentMethodsArrayForDeal(), channel, storageConsentRequirements);
            }
            startActivity(intent);
            return true;
        } else
        {
            return false;
        }
    }

    protected boolean redirectToAddShippingAddress()
    {
        if (shouldShowAddShippingAddressPrompt())
        {
            if (currentCountryManager.getCurrentCountry().isJapan())
            {
                startActivityForResult(getShippingAddressIntent(null, userAddress, true), 10120);
                return true;
            } else
            {
                onShippingAddressClick();
                return true;
            }
        } else
        {
            return false;
        }
    }

    protected void refresh()
    {
        if (!setIsRefreshing(true))
        {
            currentBreakdown = null;
            haveCheckedBillingRecords = false;
            updateOptionAndPrice();
            handleOrderDetailsSection();
            refreshUserData();
        }
    }

    protected void refreshDealBreakdowns()
    {
        String s1 = deal.remoteId;
        String s2 = option.remoteId;
        handlePaymentSection();
        if (currentCountryManager.getCurrentCountry().supportsDealBreakdowns())
        {
            if (setIsRefreshingBreakdowns(true))
            {
                return;
            }
            boolean flag = isShippingAddressRequired();
            ArrayList arraylist = new ArrayList();
            Object obj = arraylist;
            if (isBookableDeal())
            {
                obj = arraylist;
                if (bookingModel != null)
                {
                    obj = internetUsDateFormat.getFormatter("yyyy-MM-dd");
                    obj = new ArrayList(Arrays.asList(new String[] {
                        "check_in", ((SimpleDateFormat) (obj)).format(bookingModel.getStartDate().getTime()), "check_out", ((SimpleDateFormat) (obj)).format(bookingModel.getEndDate().getTime())
                    }));
                }
            }
            if (giftingRecord != null && giftingRecord.isGiftWrappable)
            {
                ((ArrayList) (obj)).addAll(Arrays.asList(new Serializable[] {
                    "gift_wrap", Boolean.valueOf(giftingRecord.isGiftWrapped)
                }));
            }
            if (!currentCountryManager.getCurrentCountry().isUSACompatible())
            {
                String s;
                if (isUsingCredits())
                {
                    s = "true";
                } else
                {
                    s = "false";
                }
                ((ArrayList) (obj)).addAll(Arrays.asList(new String[] {
                    "use_credits", s
                }));
            }
            if (Strings.notEmpty(multiUsePromoCode))
            {
                ((ArrayList) (obj)).addAll(Arrays.asList(new String[] {
                    "promo_code", multiUsePromoCode
                }));
            }
            dealBreakdownService.getDealBreakdown(s1, s2, currentlySelectedQuantity, flag, ((List) (obj)), new Function1() {

                final Purchase this$0;

                public void execute(DealBreakdownContainer dealbreakdowncontainer)
                {
                    currentBreakdown = dealbreakdowncontainer.breakdowns;
                    String s3;
                    if (currentBreakdown != null)
                    {
                        s3 = currentBreakdown.multiUsePromoCode;
                    } else
                    {
                        s3 = "";
                    }
                    if (Strings.notEmpty(s3) && shouldShowMultiUsePromoCodeSuccessMessage)
                    {
                        Toast.makeText(getApplicationContext(), getString(0x7f08004d), 1).show();
                        shouldShowMultiUsePromoCodeSuccessMessage = false;
                    }
                    handlePaymentMethodsForDeal();
                    handleAddressAdjustments(dealbreakdowncontainer.addresses);
                    invalidateOptionsMenu();
                    recreateOrderBreakdowns();
                }

                public volatile void execute(Object obj1)
                    throws Exception
                {
                    execute((DealBreakdownContainer)obj1);
                }

            
            {
                this$0 = Purchase.this;
                super();
            }
            }, new ReturningFunction1() {

                final Purchase this$0;

                public Boolean execute(Exception exception)
                {
                    currentBreakdown = null;
                    setIsRefreshingBreakdowns(false);
                    displayBreakdownError(exception);
                    return Boolean.valueOf(false);
                }

                public volatile Object execute(Object obj1)
                    throws Exception
                {
                    return execute((Exception)obj1);
                }

            
            {
                this$0 = Purchase.this;
                super();
            }
            }, new Function0() {

                final Purchase this$0;

                public void execute()
                {
                    setIsRefreshingBreakdowns(false);
                    if (!isUsersCallInProgress.get() && !isRefreshingGoogleWallet())
                    {
                        setIsRefreshing(false);
                    }
                    fromGiftCodesScreen = false;
                }

            
            {
                this$0 = Purchase.this;
                super();
            }
            });
            return;
        }
        setIsRefreshing(false);
        shippingInfoIsInvalid = false;
        if (currentCountryManager.getCurrentCountry().isJapan())
        {
            isValidAddressTheSameAsOriginal = true;
        }
        manuallyCreateOrderBreakdown();
    }

    protected void requestSync(Function0 function0)
    {
        syncDeal(function0);
    }

    protected void saveOrderResult(List list)
    {
        userManager.saveOrderResult(list, new Function1() {

            final Purchase this$0;

            public void execute(Order order)
                throws RuntimeException
            {
                order = order.id;
                updateOrderId(order);
                logDealPurchaseConfirmation(null);
                kochavaProvider.get().event("purchase", order);
                setIsOrdersCallInProgress(false);
                purchased = true;
                showThanksScreen();
                googleWalletService.clearGoogleWalletData();
            }

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((Order)obj);
            }

            
            {
                this$0 = Purchase.this;
                super();
            }
        }, new ReturningFunction1() {

            final Purchase this$0;

            public Boolean execute(Exception exception)
                throws RuntimeException
            {
                return handleOrderResultSaveException(exception);
            }

            public volatile Object execute(Object obj)
                throws Exception
            {
                return execute((Exception)obj);
            }

            
            {
                this$0 = Purchase.this;
                super();
            }
        });
    }

    protected boolean setIsOrdersCallInProgress(boolean flag)
    {
        flag = isOrdersCallInProgress.getAndSet(flag);
        updateOrdersInProgressFeedback();
        return flag;
    }

    protected boolean setIsRefreshing(boolean flag)
    {
        flag = isRefreshing.getAndSet(flag);
        updateRefreshFeedback();
        return flag;
    }

    protected boolean setIsRefreshingBreakdowns(boolean flag)
    {
        return isRefreshingBreakdowns.getAndSet(flag);
    }

    protected boolean shouldDisplayGoogleWallet()
    {
        return googleWalletService.shouldDisplayGoogleWallet(isGdtOption(option), false, false, isUSDCurrency(option));
    }

    protected boolean shouldShowSendAsGift()
    {
        boolean flag1 = currentCountryManager.getCurrentCountry().isUSACompatible();
        boolean flag;
        if (deal.isTravelBookableDeal || isBookableDeal() || option != null && option.bookable || DealUtils.isBookingEngineDeal(deal, false))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag1 && !flag || !flag1 && deal.isGiftable && currentCountryManager.getCurrentCountry().isBuyAsGiftCountry();
    }

    protected void showConfirmCreditCardDialog(boolean flag)
    {
        Intent intent = new Intent(this, com/groupon/activity/ConfirmCreditCard);
        if (flag)
        {
            intent.putExtra("cc_validation_state", "failed");
        }
        String s = billingRecordUtil.getCreditCardLastDigits(currentPaymentMethod.getBillingRecord());
        if (s == null || Strings.isEmpty(s))
        {
            return;
        } else
        {
            showProcessingFeedback(false);
            intent.putExtra("dealId", dealId);
            intent.putExtra("cc_four_digits", s);
            intent.putExtra("isShippingAddressRequired", isShippingAddressRequired());
            intent.putExtra("cc_type", currentPaymentMethod.getCardType());
            startActivityForResult(intent, 1);
            return;
        }
    }

    protected void showCustomFieldError(String s)
    {
        Toast.makeText(getApplicationContext(), String.format(getString(0x7f08015b), new Object[] {
            s
        }), 1).show();
    }

    protected void showDialog(GrouponDialogFragment groupondialogfragment, String s)
    {
        FragmentManager fragmentmanager = getFragmentManager();
        Fragment fragment = fragmentmanager.findFragmentByTag(s);
        if (fragment == null)
        {
            GrouponDialogFragment.show(fragmentmanager, groupondialogfragment, s);
        } else
        if (fragment.getActivity() != this)
        {
            GrouponDialogFragment.show(fragmentmanager, groupondialogfragment, s);
            return;
        }
    }

    protected void showMaxQuantityReachedDialog(OrderException orderexception)
    {
        GrouponDialogFragment.show(getFragmentManager(), dialogManager.getDialogFragment(orderexception.getMessage()), null);
    }

    protected void showProcessingFeedback(boolean flag)
    {
        Ln.d("SPINNING: showProcessingFeedback %s", new Object[] {
            Boolean.valueOf(flag)
        });
        if (flag)
        {
            purchaseButton.setText(0x7f0802f0);
        }
        purchaseButton.startSpinning();
    }

    protected void showThanksScreen()
    {
        startActivity(createThanksIntent());
        finish();
    }

    protected void updateOptionAndPrice()
    {
        if (deal == null)
        {
            return;
        }
        option = null;
        Iterator iterator = deal.getOptions().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Option option1 = (Option)iterator.next();
            if (Strings.equals(option1.remoteId, dealOptionId))
            {
                option = option1;
            }
        } while (true);
        if (option == null)
        {
            finish();
            return;
        } else
        {
            priceAmountInCents = option.getPrice().amount;
            currency = option.getPrice().currencyCode;
            return;
        }
    }

    protected void updateOrderId(String s)
    {
        orderId = s;
    }

    public boolean valid()
    {
        if (amountChargedToCreditCardInCents > 0)
        {
            BillingRecord billingrecord = currentPaymentMethod.getBillingRecord();
            if (!googleWalletService.isGoogleWalletPaymentMethod(currentPaymentMethod) && billingrecord == null)
            {
                Toast.makeText(getApplicationContext(), 0x7f08018e, 1).show();
                return false;
            }
        }
        boolean flag;
        if (currentCountryManager.getCurrentCountry().isChile() || currentCountryManager.getCurrentCountry().isColombia())
        {
            if (Strings.equals(ENTER_SHIPPING_ADDRESS, displayedShippingAddress))
            {
                flag = false;
            } else
            {
                flag = true;
            }
        } else
        {
            flag = true;
        }
        if (isShippingAddressRequired() && !shippingService.isStored() && flag)
        {
            Toast.makeText(getApplicationContext(), 0x7f080192, 1).show();
            return false;
        } else
        {
            return areCustomFieldsValid();
        }
    }






/*
    static Function0 access$102(Purchase purchase, Function0 function0)
    {
        purchase.onDealLoadedSuccess = function0;
        return function0;
    }

*/



/*
    static boolean access$1202(Purchase purchase, boolean flag)
    {
        purchase.haveCheckedBillingRecords = flag;
        return flag;
    }

*/



/*
    static DealBreakdownAddress access$1402(Purchase purchase, DealBreakdownAddress dealbreakdownaddress)
    {
        purchase.otherShippingAddress = dealbreakdownaddress;
        return dealbreakdownaddress;
    }

*/





/*
    static String access$1802(Purchase purchase, String s)
    {
        purchase.displayedShippingAddress = s;
        return s;
    }

*/






/*
    static DealBreakdown access$2102(Purchase purchase, DealBreakdown dealbreakdown)
    {
        purchase.currentBreakdown = dealbreakdown;
        return dealbreakdown;
    }

*/









/*
    static boolean access$2902(Purchase purchase, boolean flag)
    {
        purchase.isValidAddressTheSameAsOriginal = flag;
        return flag;
    }

*/
















}
