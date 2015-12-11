// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.groupon.Channel;
import com.groupon.abtest.BitmapAbTestHelper;
import com.groupon.fragment.HotelReservationServiceFragment;
import com.groupon.models.Bucks;
import com.groupon.models.GenericAmount;
import com.groupon.models.RoomPrice;
import com.groupon.models.billingrecord.BillingRecord;
import com.groupon.models.country.Country;
import com.groupon.models.hotel.HotelCancellationPolicy;
import com.groupon.models.hotel.HotelPricing;
import com.groupon.models.hotel.HotelReservation;
import com.groupon.models.nst.LiveChatExtraInfo;
import com.groupon.models.payment.AbstractPaymentMethod;
import com.groupon.models.payment.PaymentMethodFactory;
import com.groupon.models.user.User;
import com.groupon.models.user.UserContainer;
import com.groupon.service.AttributionService;
import com.groupon.service.LoginService;
import com.groupon.service.core.AbTestService;
import com.groupon.service.core.UserManager;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.tracking.mobile.events.Impression;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.ArraySharedPreferences;
import com.groupon.util.CurrencyFormatter;
import com.groupon.util.DeviceInfoUtil;
import com.groupon.util.DialogManager;
import com.groupon.util.Function0;
import com.groupon.util.Function1;
import com.groupon.util.GrouponDialogFragment;
import com.groupon.util.GrouponDialogListener;
import com.groupon.util.ImageUrl;
import com.groupon.util.LoggingUtils;
import com.groupon.util.MarketRateUtil;
import com.groupon.util.TimeZoneUSFriendlyDateFormat;
import com.groupon.util.TravelerNameHelper;
import com.groupon.util.ViewUtils;
import com.groupon.util.VolatileTravelerNameProvider;
import com.groupon.util.livechat.LiveChatUtil;
import com.groupon.view.CreditCardIconHelper;
import com.groupon.view.LiveChatView;
import com.groupon.view.ObservableScrollView;
import com.groupon.view.SpinnerButton;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.restlet.engine.util.InternetDateFormat;
import roboguice.inject.ContextScopedProvider;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            GrouponFragmentActivity, IntentFactory, BookingMetaData

public class MarketRatePurchase extends GrouponFragmentActivity
    implements com.groupon.fragment.HotelReservationServiceFragment.Callback, GrouponDialogListener
{

    private static ContextScopedProvider localizedSharedPreferencesProvider;
    private AbTestService abTestService;
    private AttributionService attributionService;
    private BitmapAbTestHelper bitmapAbTestHelper;
    BookingMetaData bookingMetaData;
    View bottomBar;
    TextView bottomBarText;
    private boolean canShowLiveChat;
    View cancellationPolicyContainer;
    WebView cancellationPolicyView;
    Channel channel;
    private CurrencyFormatter currencyFormatter;
    private CurrentCountryManager currentCountryManager;
    private AbstractPaymentMethod currentPaymentMethod;
    private DeviceInfoUtil deviceInfoUtil;
    private DialogManager dialogManager;
    private boolean enable565Bitmap1506;
    private AbstractPaymentMethod firstStoredCreditCard;
    private TimeZoneUSFriendlyDateFormat friendlyDateFormatter;
    String gBucksDisclaimer;
    TextView gBucksValue;
    View grouponBucksView;
    TextView guestName;
    RelativeLayout guestNameContainer;
    String hotelId;
    String hotelImageUrl;
    ImageView hotelImageView;
    String hotelLocation;
    String hotelName;
    private HotelReservation hotelReservation;
    private HotelReservationServiceFragment hotelReservationServiceFragment;
    private LayoutInflater inflater;
    private IntentFactory intentFactory;
    private InternetDateFormat internetDateFormat;
    private boolean isLastMinute;
    private AtomicBoolean isOrdersCallInProgress;
    private boolean isRaODeal;
    private AtomicBoolean isRefreshingPaymentInformation;
    private LiveChatUtil liveChatUtil;
    LiveChatView liveChatView;
    TextView locationView;
    private LoggingUtils loggingUtils;
    private ArraySharedPreferences loginPrefs;
    private LoginService loginService;
    private String nstCurrency;
    private int nstPriceInCents;
    LinearLayout paymentDetailsContainer;
    private PaymentMethodFactory paymentMethodFactory;
    String productType;
    LinearLayout reervationContainer;
    TextView roomCancellationPolicyView;
    LinearLayout roomDetailsContainer;
    String roomToken;
    View scrollableContent;
    ObservableScrollView scroller;
    SpinnerButton submit;
    View titleGradientContainer;
    TextView titleView;
    private TravelerNameHelper travelerNameHelper;
    private UserManager userManager;
    TextView viewTerms;
    private VolatileTravelerNameProvider volatileTravelerNameProvider;

    public MarketRatePurchase()
    {
        isRefreshingPaymentInformation = new AtomicBoolean(false);
        isOrdersCallInProgress = new AtomicBoolean(false);
    }

    private View addBasicListItem(ViewGroup viewgroup, int i, String s, String s1, int j, int k, boolean flag, 
            boolean flag1, android.view.View.OnClickListener onclicklistener)
    {
        if (i > 0)
        {
            View view = inflater.inflate(i, viewgroup, false);
            TextView textview = (TextView)view.findViewById(0x7f1002d3);
            if (textview != null && s != null)
            {
                textview.setText(s);
                textview.setTextColor(getResources().getColor(j));
                s = textview.getTypeface();
                if (flag)
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                textview.setTypeface(s, i);
            }
            s = (TextView)view.findViewById(0x7f100249);
            if (s != null)
            {
                if (Strings.notEmpty(s1))
                {
                    s.setText(s1);
                    s.setTextColor(getResources().getColor(k));
                    s1 = s.getTypeface();
                    if (flag1)
                    {
                        i = 1;
                    } else
                    {
                        i = 0;
                    }
                    s.setTypeface(s1, i);
                } else
                {
                    s.setVisibility(8);
                }
            }
            if (onclicklistener != null)
            {
                view.setOnClickListener(onclicklistener);
            }
            if (onclicklistener != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            view.setClickable(flag);
            if (onclicklistener != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            view.setFocusable(flag);
            view.setFocusableInTouchMode(false);
            viewgroup.addView(view);
            return view;
        } else
        {
            return null;
        }
    }

    private void buildImageHeader()
    {
        MarketRateUtil.setHeaderImage(this, deviceInfoUtil, hotelImageUrl, hotelImageView, enable565Bitmap1506);
        titleView.setText(hotelReservation.hotelName);
        locationView.setText(hotelLocation);
    }

    private void buildPaymentDetails()
    {
        Object obj;
label0:
        {
            if (currentPaymentMethod == null)
            {
                Ln.d("BREAKDOWN: need to update", new Object[0]);
                updatePaymentInformation();
            }
            paymentDetailsContainer.removeAllViews();
            obj = hotelReservation.pricing.total;
            String s = getString(0x7f08044c);
            String s1 = getFormattedPrice(((RoomPrice) (obj)).net, ((RoomPrice) (obj)).currencyCode);
            addBasicListItem(paymentDetailsContainer, 0x7f030139, s, s1, 0x7f0e0031, 0x7f0e00d5, false, false, null);
            s = getString(0x7f08052c);
            s1 = getFormattedPrice(((RoomPrice) (obj)).tax, ((RoomPrice) (obj)).currencyCode);
            addBasicListItem(paymentDetailsContainer, 0x7f030139, s, s1, 0x7f0e0031, 0x7f0e00d5, false, false, null);
            s = getString(0x7f0803e4);
            s1 = getFormattedPrice(((RoomPrice) (obj)).net + ((RoomPrice) (obj)).tax, ((RoomPrice) (obj)).currencyCode);
            nstPriceInCents = ((RoomPrice) (obj)).net + ((RoomPrice) (obj)).tax;
            addBasicListItem(paymentDetailsContainer, 0x7f030139, s, s1, 0x7f0e0031, 0x7f0e0031, true, true, null);
            s = getString(0x7f0802d3);
            if (currentPaymentMethod != null)
            {
                obj = currentPaymentMethod.getCardNumber();
            } else
            {
                obj = "";
            }
            obj = addBasicListItem(paymentDetailsContainer, 0x7f030137, s, ((String) (obj)), 0x7f0e0031, 0x7f0e00d5, false, false, new android.view.View.OnClickListener() {

                final MarketRatePurchase this$0;

                public void onClick(View view)
                {
                    changePaymentMethod();
                }

            
            {
                this$0 = MarketRatePurchase.this;
                super();
            }
            }).findViewById(0x7f1003b4);
            if (obj != null)
            {
                int i;
                if (currentPaymentMethod != null)
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                if (i != 0)
                {
                    if (!currentPaymentMethod.isCreditCard())
                    {
                        break label0;
                    }
                    CreditCardIconHelper.createCreditCardIcon(currentPaymentMethod.getBillingRecord(), (TextView)obj, com.groupon.view.CreditCardIconHelper.IconType.REDESIGNED);
                    if (currentCountryManager.getCurrentCountry().isJapan())
                    {
                        ((TextView)obj).setTextColor(getResources().getColor(0x7f0e01a9));
                        if (currentPaymentMethod.isVolatile())
                        {
                            i = 0x7f020242;
                        } else
                        {
                            i = 0x7f020241;
                        }
                        ((View) (obj)).setBackgroundResource(i);
                    }
                }
            }
            return;
        }
        CreditCardIconHelper.createCreditCardIcon(currentPaymentMethod.getId(), ((View) (obj)), com.groupon.view.CreditCardIconHelper.IconType.REDESIGNED);
    }

    private void buildRoomDetails()
    {
        roomDetailsContainer.removeAllViews();
        reervationContainer.removeAllViews();
        ArrayList arraylist = new ArrayList();
        String s = null;
        Object obj1 = hotelReservation.pricing.nights.iterator();
        do
        {
            if (!((Iterator) (obj1)).hasNext())
            {
                break;
            }
            Object obj = (RoomPrice)((Iterator) (obj1)).next();
            arraylist.add(Integer.valueOf(((RoomPrice) (obj)).net));
            if (Strings.isEmpty(s))
            {
                obj = ((RoomPrice) (obj)).currencyCode;
                s = ((String) (obj));
                if (Strings.isEmpty(nstCurrency))
                {
                    nstCurrency = ((String) (obj));
                    s = ((String) (obj));
                }
            }
        } while (true);
        String s1 = hotelReservation.hotelTimeZoneIdentifier;
        if (Strings.notEmpty(s1))
        {
            friendlyDateFormatter.setTimeZoneByIdentifier(s1);
        }
        s1 = getString(0x7f0800af);
        obj1 = MarketRateUtil.getFormattedDate(hotelReservation.checkInUtc, internetDateFormat, friendlyDateFormatter, this);
        if (Strings.notEmpty(obj1))
        {
            addBasicListItem(reervationContainer, 0x7f030139, s1, ((String) (obj1)), 0x7f0e0031, 0x7f0e00d5, false, false, null);
        }
        s1 = getString(0x7f0800b2);
        obj1 = MarketRateUtil.getFormattedDate(hotelReservation.checkOutUtc, internetDateFormat, friendlyDateFormatter, this);
        if (Strings.notEmpty(obj1))
        {
            addBasicListItem(reervationContainer, 0x7f030139, s1, ((String) (obj1)), 0x7f0e0031, 0x7f0e00d5, false, false, null);
        }
        s1 = getResources().getQuantityString(0x7f0c0013, 2);
        addBasicListItem(reervationContainer, 0x7f030139, s1, Integer.toString(hotelReservation.numberOfNights), 0x7f0e0031, 0x7f0e00d5, false, false, null);
        s1 = hotelReservation.roomName;
        s = getFormattedPrice(Integer.valueOf(MarketRateUtil.getAverageRoomRate(arraylist)).intValue(), s);
        addBasicListItem(roomDetailsContainer, 0x7f030138, s1, s, 0x7f0e0031, 0x7f0e00c2, false, true, null);
        s = getResources().getQuantityString(0x7f0c0025, 2);
        s1 = MarketRateUtil.getPersonsFilterString(getApplicationContext(), hotelReservation.numberOfAdults, hotelReservation.childAges.size());
        addBasicListItem(roomDetailsContainer, 0x7f030139, s, s1, 0x7f0e0031, 0x7f0e00d5, false, false, null);
    }

    private void changePaymentMethod()
    {
        startActivityForResult(intentFactory.newMyCreditCardIntent(true), 10112);
    }

    private void confirmPurchase()
    {
        setIsOrdersCallInProgress(true);
        hotelReservationServiceFragment.updateReservation(loginService.getConsumerId(), travelerNameHelper.getFirstname(), travelerNameHelper.getLastname(), currentPaymentMethod.getId());
    }

    private AbstractPaymentMethod getFirstStoredCreditCard(List list)
    {
        for (list = list.iterator(); list.hasNext();)
        {
            AbstractPaymentMethod abstractpaymentmethod = (AbstractPaymentMethod)list.next();
            if (abstractpaymentmethod.isCreditCard() && !abstractpaymentmethod.is3DSecurePayment())
            {
                return abstractpaymentmethod;
            }
        }

        return null;
    }

    private String getFormattedPrice(int i, String s)
    {
        GenericAmount genericamount = new GenericAmount();
        genericamount.setAmount(i);
        genericamount.setCurrencyCode(s);
        return currencyFormatter.format(genericamount, true, com.groupon.util.CurrencyFormatter.DecimalStripBehavior.Never);
    }

    private List getListOfPaymentMethods(List list)
    {
        boolean flag = false;
        ArrayList arraylist;
        int i;
        if (list != null)
        {
            i = list.size();
        } else
        {
            i = 0;
        }
        arraylist = new ArrayList();
        if (currentCountryManager.getCurrentCountry().isUSACompatible())
        {
            Ln.d("BREAKDOWN: USA", new Object[0]);
            if (i > 0)
            {
                list = list.iterator();
                do
                {
                    if (!list.hasNext())
                    {
                        break;
                    }
                    Object obj = (BillingRecord)list.next();
                    obj = paymentMethodFactory.createPaymentMethod(((BillingRecord) (obj)));
                    if (obj != null && !((AbstractPaymentMethod) (obj)).isNonRecurring())
                    {
                        arraylist.add(obj);
                    }
                } while (true);
            }
        }
        list = IntentFactory.Payments.values();
        int k = list.length;
        for (int j = ((flag) ? 1 : 0); j < k; j++)
        {
            Object obj1 = list[j];
            if (!Strings.equals(((IntentFactory.Payments) (obj1)).getPaymentType(), "ECommerce"))
            {
                continue;
            }
            obj1 = paymentMethodFactory.createPaymentMethod(((IntentFactory.Payments) (obj1)).getPaymentId());
            if (obj1 != null)
            {
                arraylist.add(obj1);
            }
        }

        return arraylist;
    }

    private AbstractPaymentMethod getPaymentMethodById(List list, String s)
    {
        for (list = list.iterator(); list.hasNext();)
        {
            AbstractPaymentMethod abstractpaymentmethod = (AbstractPaymentMethod)list.next();
            if (Strings.equalsIgnoreCase(s, abstractpaymentmethod.getId()))
            {
                return abstractpaymentmethod;
            }
        }

        return null;
    }

    public static Intent instantiate(Context context, String s, String s1, String s2, String s3, String s4, String s5, Channel channel1, 
            String s6, BookingMetaData bookingmetadata)
    {
        return (new Intent(context, com/groupon/activity/MarketRatePurchase)).putExtra("id", s1).putExtra("hotel_name", s2).putExtra("hotel_location", s3).putExtra("hotel_image_url", s4).putExtra("g_bucks_disclaimer", s5).putExtra("channel", channel1).putExtra("productType", s6).putExtra("room_token", s).putExtra("getaways_booking", bookingmetadata);
    }

    private void setCancellationPolicy()
    {
        Object obj = hotelReservation.cancellationPolicies;
        String s;
        if (obj != null && ((List) (obj)).size() > 0)
        {
            obj = ((HotelCancellationPolicy)((List) (obj)).get(0)).descriptionHtml;
        } else
        {
            obj = "";
        }
        s = hotelReservation.crsPolicyHtml;
        if (Strings.isEmpty(obj) && Strings.isEmpty(s))
        {
            cancellationPolicyContainer.setVisibility(8);
        } else
        {
            if (Strings.notEmpty(obj))
            {
                roomCancellationPolicyView.setText(Html.fromHtml(((String) (obj))));
                roomCancellationPolicyView.setVisibility(0);
            }
            if (Strings.notEmpty(s))
            {
                cancellationPolicyView.loadDataWithBaseURL(null, (new StringBuilder()).append("<style type=text/css> img{max-width: 100%; height: auto; display: block; margin: auto;} table{width: 100%; height: auto;} div{max-width: 100%; height: auto;} object{max-width: 100%; height: auto;} body{margin:10px 0px 0px 0px; color:#75787b;} a:link {color:#369ec1; text-decoration: none;} hr{border-bottom:solid 1px #ddd; border-top:none; border-left:none; border-right:none;} ul{padding-left:25px} blockquote{margin:0px;}</style>").append(s).toString(), "text/html", "UTF-8", null);
                cancellationPolicyView.setVisibility(0);
                return;
            }
        }
    }

    private void setGBucks()
    {
        final int gBucksAmountValue = hotelReservation.bucks.amount;
        if (!isLastMinute && !isRaODeal && gBucksAmountValue > 0)
        {
            final GenericAmount gBucksAmount = new GenericAmount();
            gBucksAmount.setAmount(gBucksAmountValue);
            gBucksAmount.setCurrencyCode(hotelReservation.bucks.currencyCode);
            gBucksValue.setText(currencyFormatter.format(gBucksAmount, true, com.groupon.util.CurrencyFormatter.DecimalStripBehavior.Never));
            grouponBucksView.setOnClickListener(new android.view.View.OnClickListener() {

                final MarketRatePurchase this$0;
                final GenericAmount val$gBucksAmount;
                final int val$gBucksAmountValue;

                public void onClick(View view)
                {
                    startActivity(intentFactory.newMarketRateGBucksIntent(gBucksAmount, gBucksDisclaimer));
                    logger.logClick("", "groupon_bucks_back_click", "market_rate", (new StringBuilder()).append(hotelId).append(",").append(gBucksAmountValue).toString());
                }

            
            {
                this$0 = MarketRatePurchase.this;
                gBucksAmount = genericamount;
                gBucksAmountValue = i;
                super();
            }
            });
            return;
        } else
        {
            grouponBucksView.setVisibility(8);
            return;
        }
    }

    private void setHotelReservation(HotelReservation hotelreservation)
    {
        hotelReservation = hotelreservation;
        buildImageHeader();
        buildRoomDetails();
        buildPaymentDetails();
        setCancellationPolicy();
        setGBucks();
    }

    private boolean setIsOrdersCallInProgress(boolean flag)
    {
        flag = isOrdersCallInProgress.getAndSet(flag);
        updateOrdersInProgressFeedback();
        return flag;
    }

    private boolean setIsRefreshingPaymentInformation(boolean flag)
    {
        return isRefreshingPaymentInformation.getAndSet(flag);
    }

    private void setupViews()
    {
        scroller.setOnLayoutUpdatedListener(new com.groupon.view.ObservableScrollView.OnLayoutUpdatedListener() {

            final MarketRatePurchase this$0;

            public void onLayoutUpdated(boolean flag, int i, int j, int k, int l)
            {
                scroller.smoothScrollTo(0, titleGradientContainer.getTop());
            }

            
            {
                this$0 = MarketRatePurchase.this;
                super();
            }
        });
        bottomBarText.setText(0x7f08034b);
        bottomBarText.setVisibility(0);
        submit.setText(0x7f0800c1);
        submit.setOnClickListener(new android.view.View.OnClickListener() {

            final MarketRatePurchase this$0;

            public void onClick(View view)
            {
                logger.logClick("", "confirm_purchase_click", "market_rate", hotelId);
                if (currentPaymentMethod == null)
                {
                    changePaymentMethod();
                    return;
                } else
                {
                    logger.logDealPurchaseInitiation("", channel.name(), hotelId, 1, nstPriceInCents, "", nstCurrency, attributionService.getAttributionCid(), attributionService.getAttributionId(), attributionService.getAttributionType(), attributionService.getDeepLinkTimeOverlap(Long.valueOf(System.currentTimeMillis())).longValue(), attributionService.getAttributionDownloadId(), attributionService.getAttributionDownloadCid(), "", "", "", loggingUtils.getMarketRateExtraInfoString(productType, isRaODeal));
                    confirmPurchase();
                    return;
                }
            }

            
            {
                this$0 = MarketRatePurchase.this;
                super();
            }
        });
        bottomBar.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

            final MarketRatePurchase this$0;

            public void onGlobalLayout()
            {
                int i = bottomBar.getHeight();
                scrollableContent.setPadding(0, 0, 0, i);
            }

            
            {
                this$0 = MarketRatePurchase.this;
                super();
            }
        });
        viewTerms.setText(Html.fromHtml(getString(0x7f08040f)));
        viewTerms.setMovementMethod(LinkMovementMethod.getInstance());
        guestNameContainer.setOnClickListener(new android.view.View.OnClickListener() {

            final MarketRatePurchase this$0;

            public void onClick(View view)
            {
                travelerNameHelper.startEditing();
            }

            
            {
                this$0 = MarketRatePurchase.this;
                super();
            }
        });
    }

    private void updateOrdersInProgressFeedback()
    {
        boolean flag;
        if (!isOrdersCallInProgress.get())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ViewUtils.setEnabledOnAllChildren(paymentDetailsContainer, flag);
        grouponBucksView.setEnabled(flag);
    }

    private void updatePaymentInformation()
    {
        setCurrentPaymentMethod(getDefaultPaymentMethod(null));
        Ln.d("CURRENT_PAYMENT: currentPaymentMethod = %s", new Object[] {
            currentPaymentMethod
        });
        if (setIsRefreshingPaymentInformation(true))
        {
            Ln.d("BREAKDOWN: already refreshing payment information", new Object[0]);
            return;
        } else
        {
            updateSubmitButton(true, false);
            userManager.getUserData(false, false, new Function1() {

                final MarketRatePurchase this$0;

                public void execute(UserContainer usercontainer)
                {
                    if (usercontainer != null)
                    {
                        usercontainer = usercontainer.user;
                        setCurrentPaymentMethod(getDefaultPaymentMethod(((User) (usercontainer)).billingRecords));
                        buildPaymentDetails();
                    }
                }

                public volatile void execute(Object obj)
                    throws Exception
                {
                    execute((UserContainer)obj);
                }

            
            {
                this$0 = MarketRatePurchase.this;
                super();
            }
            }, null, new Function0() {

                final MarketRatePurchase this$0;

                public void execute()
                {
                    setIsRefreshingPaymentInformation(false);
                    Ln.d("BREAKDOWN: getCreditCards finally -- refresh list", new Object[0]);
                    updateSubmitButton(false, true);
                }

            
            {
                this$0 = MarketRatePurchase.this;
                super();
            }
            }, null);
            return;
        }
    }

    private void updateSubmitButton(boolean flag, boolean flag1)
    {
        SpinnerButton spinnerbutton = submit;
        int i;
        if (currentPaymentMethod == null)
        {
            i = 0x7f08004e;
        } else
        {
            i = 0x7f0800c1;
        }
        spinnerbutton.setText(i);
        if (flag)
        {
            submit.startSpinning();
        } else
        {
            submit.stopSpinning();
        }
        submit.setEnabled(flag1);
    }

    protected AbstractPaymentMethod getDefaultPaymentMethod(List list)
    {
        Object obj = null;
        String s = loginPrefs.getString("currentBillingRecordId", null);
        boolean flag = Strings.notEmpty(s);
        Ln.d("BREAKDOWN: locSharedPref = %s", new Object[] {
            localizedSharedPreferencesProvider
        });
        Ln.d("BREAKDOWN: getDefaultPaymentMethod pp=%s, pref=%s", new Object[] {
            Boolean.valueOf(flag), s
        });
        List list1 = getListOfPaymentMethods(list);
        list = obj;
        if (list1 != null)
        {
            if (list1.size() == 0)
            {
                list = obj;
            } else
            {
                AbstractPaymentMethod abstractpaymentmethod = getPaymentMethodById(list1, s);
                firstStoredCreditCard = getFirstStoredCreditCard(list1);
                list = abstractpaymentmethod;
                if (abstractpaymentmethod == null)
                {
                    return firstStoredCreditCard;
                }
            }
        }
        return list;
    }

    protected void initActionBar(Bundle bundle)
    {
        super.initActionBar(bundle);
        setDisplayToolbarTitle(false);
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        i;
        JVM INSTR tableswitch 10112 10112: default 28
    //                   10112 37;
           goto _L1 _L2
_L1:
        travelerNameHelper.onActivityResult(i);
        return;
_L2:
        if (j == -1)
        {
            Ln.d("BREAKDOWN: came back from MyCreditCards, refresh", new Object[0]);
            setCurrentPaymentMethod(null);
            if (hotelReservation != null)
            {
                buildPaymentDetails();
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03015e);
        enable565Bitmap1506 = bitmapAbTestHelper.isEnable565Bitmap1506();
        FragmentManager fragmentmanager = getSupportFragmentManager();
        hotelReservationServiceFragment = (HotelReservationServiceFragment)fragmentmanager.findFragmentByTag(HotelReservationServiceFragment.TAG);
        if (hotelReservationServiceFragment == null)
        {
            hotelReservationServiceFragment = new HotelReservationServiceFragment();
            hotelReservationServiceFragment.setRoomToken(roomToken);
            fragmentmanager.beginTransaction().add(hotelReservationServiceFragment, HotelReservationServiceFragment.TAG).commit();
        }
        travelerNameHelper = new TravelerNameHelper(this, volatileTravelerNameProvider, loginService, guestName, intentFactory);
        travelerNameHelper.onCreate(bundle);
        travelerNameHelper.onDealReady(hotelName, new ImageUrl(hotelImageUrl), bookingMetaData);
        isLastMinute = Strings.equalsIgnoreCase(productType, "lastMinute");
        isRaODeal = Strings.equalsIgnoreCase(productType, "requestAnOffer");
        friendlyDateFormatter.setOutputType(com.groupon.util.TimeZoneUSFriendlyDateFormat.OutputType.shortDate);
        setupViews();
        if (hotelReservationServiceFragment.hasReservation())
        {
            setHotelReservation(hotelReservationServiceFragment.getReservation());
        }
        boolean flag;
        if (currentCountryManager.getCurrentCountry().isUSOnly() && abTestService.isVariantEnabled("livechatCheckout1508US", "on"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        canShowLiveChat = flag;
        if (canShowLiveChat)
        {
            liveChatUtil.channel = channel;
            liveChatUtil.dealId = hotelId;
            liveChatUtil.pageId = getClass().getSimpleName();
        }
        scroller.addOnScrollChangedListener(new com.groupon.view.ObservableScrollView.OnScrollChangedListener() {

            final MarketRatePurchase this$0;

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
                    if (liveChatView.getVisibility() == 0)
                    {
                        logger.log(new Impression("", "show_live_chat", channel.toString(), "bottom", new LiveChatExtraInfo(getClass().getSimpleName(), hotelId)));
                        return;
                    }
                }
            }

            
            {
                this$0 = MarketRatePurchase.this;
                super();
            }
        });
        logger.logDealConfirmationView("", channel.name(), hotelId, "", "", "", loggingUtils.getMarketRateExtraInfoString(productType));
    }

    public void onDialogCancel(String s, DialogInterface dialoginterface)
    {
        finish();
    }

    public void onDialogItemClick(String s, DialogInterface dialoginterface, int i)
    {
    }

    public void onDialogMultiChoiceItemClick(String s, DialogInterface dialoginterface, int i, boolean flag)
    {
    }

    public void onDialogNegativeButtonClick(String s, DialogInterface dialoginterface)
    {
        finish();
    }

    public void onDialogPositiveButtonClick(String s, DialogInterface dialoginterface)
    {
        finish();
    }

    public void onDialogShown(String s, DialogInterface dialoginterface)
    {
    }

    public void onNewReservationFinished(HotelReservation hotelreservation, Exception exception)
    {
        if (hotelreservation == null)
        {
            hotelreservation = dialogManager.getDialogFragment(null, Integer.valueOf(0x7f080165), Integer.valueOf(0x7f080139));
            GrouponDialogFragment.show(getFragmentManager(), hotelreservation, "generic_error_dialog");
            return;
        } else
        {
            setHotelReservation(hotelreservation);
            return;
        }
    }

    protected void onResume()
    {
        super.onResume();
        if (canShowLiveChat)
        {
            liveChatView.updateLiveChatSection(false);
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        travelerNameHelper.onSaveInstanceState(bundle);
    }

    public void onUpdateReservationFinished(HotelReservation hotelreservation, Exception exception)
    {
        setIsOrdersCallInProgress(false);
        startActivity(intentFactory.newMarketRateThanksIntent(hotelName, true, channel));
        logger.logDealPurchaseConfirmation("", channel.toString(), hotelId, 0, "", "", attributionService.getAttributionCid(), attributionService.getAttributionId(), attributionService.getAttributionType(), attributionService.getDeepLinkTimeOverlap(Long.valueOf(System.currentTimeMillis())).longValue(), attributionService.getAttributionDownloadId(), attributionService.getAttributionDownloadCid(), hotelreservation.uuid, "", "", "", loggingUtils.getMarketRateExtraInfoString(productType, hotelReservation.numberOfNights, nstPriceInCents, nstCurrency));
        finish();
    }

    protected void setCurrentPaymentMethod(AbstractPaymentMethod abstractpaymentmethod)
    {
        currentPaymentMethod = abstractpaymentmethod;
        if (currentPaymentMethod != null)
        {
            currentPaymentMethod.saveToPrefs();
        }
    }













}
