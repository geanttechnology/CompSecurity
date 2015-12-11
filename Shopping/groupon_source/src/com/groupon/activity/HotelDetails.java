// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.groupon.Channel;
import com.groupon.abtest.TravelReviewsAbTestHelper;
import com.groupon.activity.transition.HotelDetailsTransitionController;
import com.groupon.db.models.Hotel;
import com.groupon.db.models.Location;
import com.groupon.db.models.MarketRateResult;
import com.groupon.fragment.HotelDiscountServiceFragment;
import com.groupon.loader.HotelLoaderCallbacks;
import com.groupon.manager.GrouponSyncManager;
import com.groupon.manager.HotelSyncManager;
import com.groupon.models.GenericAmount;
import com.groupon.models.RoomCustomField;
import com.groupon.models.RoomDetails;
import com.groupon.models.RoomPrice;
import com.groupon.models.deal.SharedDealInfo;
import com.groupon.models.hotel.HotelRoom;
import com.groupon.models.hotel.RaoResponseWrapper;
import com.groupon.models.nst.RaOCheckButtonExtraInfo;
import com.groupon.models.nst.RaOContactHotelImpressionExtraInfo;
import com.groupon.models.nst.RaODealExtraInfo;
import com.groupon.models.nst.TravelReviewsSummaryImpressionExtraInfo;
import com.groupon.service.core.AbTestService;
import com.groupon.service.marketrate.HotelsService;
import com.groupon.tracking.mobile.EncodedNSTField;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.CurrencyFormatter;
import com.groupon.util.DeviceInfoUtil;
import com.groupon.util.Function0;
import com.groupon.util.Function1;
import com.groupon.util.Function2;
import com.groupon.util.HumanReadableCountdownFormat;
import com.groupon.util.ImageUrl;
import com.groupon.util.LoggingUtils;
import com.groupon.util.LoginUtil;
import com.groupon.util.MarketRateUtil;
import com.groupon.util.PausableThreadPoolExecutor;
import com.groupon.util.TransparentToolBarHelper;
import com.groupon.view.DealDetailsTemporaryImage;
import com.groupon.view.DealImageView;
import com.groupon.view.GuestsPickerDialog;
import com.groupon.view.MapSliceRedesign;
import com.groupon.view.SpinnerButton;
import com.groupon.view.TripAdvisorReviewSection;
import com.squareup.picasso.Callback;
import commonlib.manager.SyncManager;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.restlet.engine.util.InternetUsDateFormat;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            AbstractDetailsBase, BookingMetaData, IntentFactory

public class HotelDetails extends AbstractDetailsBase
    implements com.groupon.view.GrouponDrawerDialog.OnDrawerDialogDismiss
{
    private static class PeriodicTasks
        implements Runnable
    {

        protected AtomicBoolean canceled;
        protected WeakReference contextRef;

        public void cancel()
        {
            canceled.set(true);
        }

        public void run()
        {
            HotelDetails hoteldetails = (HotelDetails)contextRef.get();
            if (hoteldetails != null && !canceled.get()) goto _L2; else goto _L1
_L1:
            return;
_L2:
            hoteldetails.updateRaOExpireTimeLeft();
            if (!canceled.get())
            {
                long l = (SystemClock.uptimeMillis() + 1000L) / 1000L;
                hoteldetails.handler.postAtTime(this, l * 1000L);
                return;
            }
              goto _L1
            Object obj;
            obj;
            ((Exception) (obj)).printStackTrace();
            if (canceled.get()) goto _L1; else goto _L3
_L3:
            long l1 = (SystemClock.uptimeMillis() + 1000L) / 1000L;
            hoteldetails.handler.postAtTime(this, l1 * 1000L);
            return;
            obj;
            if (!canceled.get())
            {
                long l2 = (SystemClock.uptimeMillis() + 1000L) / 1000L;
                hoteldetails.handler.postAtTime(this, l2 * 1000L);
            }
            throw obj;
        }

        protected PeriodicTasks(HotelDetails hoteldetails)
        {
            canceled = new AtomicBoolean(false);
            contextRef = new WeakReference(hoteldetails);
        }
    }

    private static class RequestAnOfferCallback
        implements com.groupon.fragment.HotelDiscountServiceFragment.HotelDiscountServiceCallback
    {

        private WeakReference hotelDetailsWeakReference;

        public void onRequestRaOResult(RaoResponseWrapper raoresponsewrapper, Exception exception)
        {
label0:
            {
                if (hotelDetailsWeakReference.get() != null)
                {
                    if (exception != null)
                    {
                        break label0;
                    }
                    ((HotelDetails)hotelDetailsWeakReference.get()).onGetRaORequestResult(true, raoresponsewrapper.waitTimeSecond, raoresponsewrapper.attemptsLeft);
                }
                return;
            }
            ((HotelDetails)hotelDetailsWeakReference.get()).onGetRaORequestResult(false, 0, 0);
        }

        public RequestAnOfferCallback(HotelDetails hoteldetails)
        {
            hotelDetailsWeakReference = new WeakReference(hoteldetails);
        }
    }


    private static final String ACTION_HOTEL_DETAILS_ONCREATE = "hotel_details_onCreate";
    private static final String ACTION_HOTEL_DETAILS_UPDATE_VIEW = "on_hotel_details_update_view";
    private static final String ACTION_HOTEL_DETAILS_UPDATE_VIEW_AFTER_REQUEST = "on_hotel_details_update_view_after_request";
    private static final String ACTION_ON_HOTEL_IMAGES_LOADED = "on_hotel_images_loaded";
    private static final String ACTION_ON_HOTEL_INVENTORY_LOADED = "on_hotel_inventory_loaded";
    public static final String CATEGORY_HOTEL_PERFORMANCE = "hotel_performance";
    private static final String CHECKING_FOR_RAO = "checking_rao";
    private static final int DEFAULT_ADULT_NUMBER = 2;
    private static final int DEFAULT_CHILDREN_NUMBER = 0;
    private static final String EXPIRED_RAO = "expired_rao";
    private static final String GUESTS_PICKER_DIALOG = "guests_picker_dialog";
    public static final String HAS_RAO = "hasRaO";
    private static final String HOTEL_DETAILS_SPECIFIER = "hotel_details";
    private static final String HOTEL_ID = "Hotel_ID";
    private static final int HOTEL_LANDSCAPE_IMAGE_HEIGHT = 192;
    public static final String INVENTORY_TYPE_RAO = "requestAnOffer";
    private static final String RAO_CHECK_BUTTON_CLICK = "rao_check_button_click";
    private static final String RAO_CHECK_BUTTON_IMPRESSION = "rao_check_button_impression";
    private static final String RAO_CONTACT_HOTEL_IMPRESSION = "rao_contact_hotel_impression";
    private static final String RAO_SKIP_OFFER_CLICK = "rao_skip_offer_click";
    private static final String SHOULD_EXPAND = "should_expand";
    public static final String UUID = "uuid";
    View aboutContainer;
    TextView aboutTitle;
    WebView aboutWebView;
    int adults;
    private int adultsNumberBackup;
    View amenitiesContainer;
    TextView amenitiesView;
    private List availableRooms;
    View bookingDateContainer;
    TextView bookingDateText;
    View bottomBar;
    TextView bucksDisclaimer;
    String channelId;
    private Date checkInDate;
    String checkInDateString;
    private Date checkOutDate;
    String checkOutDateString;
    private AtomicBoolean checkingForRaO;
    int children;
    private List childrenAges;
    private int childrenNumberBackup;
    private boolean contentLoaded;
    View contentView;
    private CurrencyFormatter currencyFormatter;
    View dealImageContainer;
    DealImageView dealImageView;
    View detailsMainContainer;
    View detailsTopContainer;
    TextView disabledGuestsSelectorText;
    View disabledSelectGuests;
    private HotelDiscountServiceFragment discountServiceFragment;
    View finePrintContainer;
    View gBucksContainer;
    TextView gBucksValue;
    TextView guestsSelectorText;
    private Handler handler;
    boolean hasRaO;
    private Hotel hotel;
    String hotelId;
    TextView hotelLocation;
    private HotelSyncManager hotelSyncManager;
    TextView hotelTitle;
    String hotelUuid;
    private HotelsService hotelsService;
    private List imageUrls;
    private InternetUsDateFormat internetUsDateFormat;
    private boolean inventoryLoaded;
    private boolean isLastMinute;
    private boolean isRaODeal;
    private boolean isRaOExpired;
    boolean isSearchFlow;
    TextView lastMinuteDiscountLabel;
    View lastMinuteInfo;
    private LoginUtil loginUtil;
    MapSliceRedesign mapSlice;
    private MarketRateResult marketRateResult;
    private long onCreateStartTime;
    private boolean pageLoadTimeHasBeenLogged;
    TextView price;
    View priceContainer;
    String productType;
    View progress;
    SpinnerButton raoCheckButton;
    private CountDownTimer raoContactingHotelCountDownTimer;
    TextView raoDiscountLabel;
    TextView raoExpireTime;
    private AtomicReference raoExpireTimePeriodicTask;
    private Date raoOfferEndAt;
    View raoOfferInfo;
    TextView raoPrice;
    View raoPriceContainer;
    TextView raoStrikePrice;
    View raoUnlockingTimerContainer;
    ProgressBar raoUnlockingTimerProgressBar;
    TextView raoUnlockingTimerText;
    LinearLayout roomContainer;
    TextView roomDescription;
    TextView roomRateDisclaimer;
    TextView roomTitle;
    View scrollableContent;
    View selectGuests;
    SharedDealInfo sharedDealInfo;
    private boolean shouldShowRaO;
    private boolean shouldShowTripAdvisorReviews;
    TextView strikePrice;
    SpinnerButton submitButton;
    TextView submitButtonMask;
    DealDetailsTemporaryImage temporaryDealImageView;
    private DateFormat timeLeftDateFormat;
    Toolbar toolbar;
    private HotelDetailsTransitionController transitionController;
    private TransparentToolBarHelper transparentToolBarHelper;
    private TravelReviewsAbTestHelper travelReviewsAbTestHelper;
    TripAdvisorReviewSection tripAdvisorSection;

    public HotelDetails()
    {
        raoExpireTimePeriodicTask = new AtomicReference();
        adultsNumberBackup = -1;
        childrenNumberBackup = -1;
        checkingForRaO = new AtomicBoolean();
    }

    private float calculateLandscapeImageHeight()
    {
        float f = 192F;
        if (getResources().getConfiguration().orientation == 1)
        {
            float f1 = DeviceInfoUtil.getScreenHeightDpi(this) / 3F;
            f = f1;
            if (f1 > 450F)
            {
                f = 450F;
            }
        }
        return f;
    }

    private void getHotelInventory(final Function0 onSuccess)
    {
        availableRooms = null;
        startLoadingSubmitButton();
        final long hotelInventoryServiceStartTime = SystemClock.elapsedRealtime();
        hotelsService.getHotelInventory(hotelId, getInventoryParams(), null, new Function2() {

            final HotelDetails this$0;
            final long val$hotelInventoryServiceStartTime;
            final Function0 val$onSuccess;

            public volatile void execute(Object obj, Object obj1)
                throws Exception
            {
                execute((List)obj, (String)obj1);
            }

            public void execute(List list, String s)
            {
                inventoryLoaded = true;
                stopLoadingSubmitButton();
                productType = s;
                HotelDetails hoteldetails = HotelDetails.this;
                boolean flag;
                boolean flag1;
                if (s != null && "requestAnOffer".equalsIgnoreCase(s))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                hoteldetails.isRaODeal = flag1;
                if (list != null && list.size() > 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (!flag)
                {
                    updateSubmitButtonNoAvailableRoom();
                    return;
                }
                if (isRaODeal)
                {
                    setRaODealExpirationTime(((RoomCustomField)((HotelRoom)list.get(0)).customFields.get(0)).roomTokenExpirationDate);
                }
                availableRooms = new ArrayList();
                availableRooms.addAll(list);
                long l;
                if (availableRooms.size() == 1)
                {
                    updateSubmitButtonBookRoom();
                } else
                {
                    updateSubmitButtonSelectRoom();
                }
                if (onSuccess != null)
                {
                    onSuccess.execute();
                }
                logPageLoadComplete(onCreateStartTime);
                l = SystemClock.elapsedRealtime();
                logger.logGeneralEvent("hotel_performance", "on_hotel_inventory_loaded", hotelId, (int)(l - hotelInventoryServiceStartTime), Logger.NULL_NST_FIELD);
            }

            
            {
                this$0 = HotelDetails.this;
                onSuccess = function0;
                hotelInventoryServiceStartTime = l;
                super();
            }
        }, new Function1() {

            final HotelDetails this$0;

            public void execute(Exception exception)
            {
                stopLoadingSubmitButton();
                updateSubmitButtonNoAvailableRoom();
                logPageLoadComplete(onCreateStartTime);
            }

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((Exception)obj);
            }

            
            {
                this$0 = HotelDetails.this;
                super();
            }
        });
    }

    private List getInventoryParams()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(Arrays.asList(new CharSequence[] {
            "check_in", internetUsDateFormat.format("yyyy-MM-dd", checkInDate)
        }));
        arraylist.addAll(Arrays.asList(new CharSequence[] {
            "check_out", internetUsDateFormat.format("yyyy-MM-dd", checkOutDate)
        }));
        arraylist.addAll(Arrays.asList(new Serializable[] {
            "adults", Integer.valueOf(adults)
        }));
        if (childrenAges != null && childrenAges.size() > 0)
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "children", getChildrenAgesAsString()
            }));
        }
        return arraylist;
    }

    private void handleDealImageCarouselRequestCode(int i, Intent intent)
    {
        if (-1 == i && intent != null)
        {
            i = intent.getIntExtra("image_carousel_current_position", 0);
            dealImageView.setCurrentItem(i);
        }
    }

    private void handleDefaultSceneTransition()
    {
        if (sharedDealInfo != null)
        {
            temporaryDealImageView.setImageHeight(calculateLandscapeImageHeight());
            temporaryDealImageView.loadImageFromUrl(sharedDealInfo.largeImageUrl, null);
        } else
        {
            temporaryDealImageView.setVisibility(8);
        }
        init(false);
    }

    private void handleLollipopSceneTransition()
    {
        HashMap hashmap = new HashMap(5);
        hashmap.put(Integer.valueOf(0x7f100180), toolbar);
        hashmap.put(Integer.valueOf(0x7f100132), contentView);
        hashmap.put(Integer.valueOf(0x7f1000da), scrollableContent);
        hashmap.put(Integer.valueOf(0x7f100222), dealImageContainer);
        hashmap.put(Integer.valueOf(0x7f100385), temporaryDealImageView);
        transitionController.initializeController(sharedDealInfo, calculateLandscapeImageHeight(), hashmap);
        transitionController.handleEnterTransition(new Function0() {

            final HotelDetails this$0;

            public void execute()
                throws RuntimeException
            {
                init(true);
            }

            
            {
                this$0 = HotelDetails.this;
                super();
            }
        });
    }

    private void hidePriceInfo()
    {
        strikePrice.setVisibility(8);
        lastMinuteDiscountLabel.setVisibility(8);
        priceContainer.setVisibility(8);
    }

    private void hideRaOBottomBar()
    {
        raoCheckButton.setVisibility(8);
        raoUnlockingTimerContainer.setVisibility(8);
        raoPriceContainer.setVisibility(8);
    }

    private void hideRaODealView()
    {
        raoOfferInfo.setVisibility(8);
        raoCheckButton.setVisibility(8);
        raoUnlockingTimerContainer.setVisibility(8);
        raoPriceContainer.setVisibility(8);
    }

    private void init(boolean flag)
    {
        initLoaderManager();
        if (flag)
        {
            PausableThreadPoolExecutor pausablethreadpoolexecutor = getSyncManager().getExecutor();
            if (!pausablethreadpoolexecutor.isShutdown() && !pausablethreadpoolexecutor.isTerminated() && !pausablethreadpoolexecutor.isTerminating())
            {
                startAutomaticSyncs();
            }
        }
        initViews();
        loadInventory();
        loadImageUrls();
        getIntent().removeExtra("shared_deal_info");
    }

    private void initDiscountService()
    {
        Object obj = getFragmentManager();
        discountServiceFragment = (HotelDiscountServiceFragment)((FragmentManager) (obj)).findFragmentByTag(HotelDiscountServiceFragment.TAG);
        if (discountServiceFragment == null)
        {
            discountServiceFragment = new HotelDiscountServiceFragment();
            ((FragmentManager) (obj)).beginTransaction().add(discountServiceFragment, HotelDiscountServiceFragment.TAG).commit();
        }
        obj = new RequestAnOfferCallback(this);
        discountServiceFragment.setCallback(((com.groupon.fragment.HotelDiscountServiceFragment.HotelDiscountServiceCallback) (obj)));
    }

    private void initViews()
    {
        long l = SystemClock.elapsedRealtime();
        selectGuests.setOnClickListener(new android.view.View.OnClickListener() {

            final HotelDetails this$0;

            public void onClick(View view)
            {
                showGuestsPickerDialog();
                logger.logClick("", "guest_selection_click", "market_rate", hotelId);
            }

            
            {
                this$0 = HotelDetails.this;
                super();
            }
        });
        submitButton.setOnClickListener(new android.view.View.OnClickListener() {

            final HotelDetails this$0;

            public void onClick(View view)
            {
                logger.logClick("", "select_room_click", "market_rate", hotelId);
                if (hasRaO && raoUnlockingTimerContainer.getVisibility() == 0)
                {
                    skipRaORequest();
                    logger.logClick("", "rao_skip_offer_click", "hotel_details", new EncodedNSTField() {

                        final _cls6 this$1;

                        public String toEncodedString()
                        {
                            return "Skip_RaO_offer";
                        }

            
            {
                this$1 = _cls6.this;
                super();
            }
                    });
                }
                if (availableRooms == null || availableRooms.size() == 0)
                {
                    getHotelInventory(new Function0() {

                        final _cls6 this$1;

                        public void execute()
                        {
                            selectRoom();
                        }

            
            {
                this$1 = _cls6.this;
                super();
            }
                    });
                    return;
                } else
                {
                    selectRoom();
                    return;
                }
            }

            
            {
                this$0 = HotelDetails.this;
                super();
            }
        });
        raoCheckButton.setOnClickListener(new android.view.View.OnClickListener() {

            final HotelDetails this$0;

            public void onClick(View view)
            {
                onClickCheckRaOButton();
            }

            
            {
                this$0 = HotelDetails.this;
                super();
            }
        });
        transitionController.slideInBottomBar(bottomBar, 0);
        dealImageView.setDealImageHeight(calculateLandscapeImageHeight());
        long l1 = SystemClock.elapsedRealtime();
        logger.logGeneralEvent("hotel_performance", "on_hotel_details_update_view", hotelId, (int)(l1 - l), Logger.NULL_NST_FIELD);
    }

    private boolean isBothContentAndInventoryLoaded()
    {
        return contentLoaded && inventoryLoaded;
    }

    private boolean isCustomEnterTransition()
    {
        return android.os.Build.VERSION.SDK_INT >= 21 && sharedDealInfo != null && sharedDealInfo.dealImageHeight > 0;
    }

    private boolean isTimeInPast(Date date)
    {
        return date != null && (new Date()).after(date);
    }

    private void loadImageUrls()
    {
        final long startTime = SystemClock.elapsedRealtime();
        hotelsService.getHotelImageUrls(hotelId, null, new Function1() {

            final HotelDetails this$0;
            final long val$startTime;

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((List)obj);
            }

            public void execute(List list)
            {
                if (imageUrls == null)
                {
                    imageUrls = new ArrayList();
                }
                imageUrls.clear();
                imageUrls.addAll(list);
                setupImagePager();
                long l = SystemClock.elapsedRealtime();
                logger.logGeneralEvent("hotel_performance", "on_hotel_images_loaded", hotelId, (int)(l - startTime), Logger.NULL_NST_FIELD);
            }

            
            {
                this$0 = HotelDetails.this;
                startTime = l;
                super();
            }
        }, null);
    }

    private void loadInventory()
    {
        getHotelInventory(new Function0() {

            final HotelDetails this$0;

            public void execute()
            {
                updateViewsByInventory();
            }

            
            {
                this$0 = HotelDetails.this;
                super();
            }
        });
    }

    private void logPageLoadComplete(long l)
    {
        if (isBothContentAndInventoryLoaded() && !pageLoadTimeHasBeenLogged)
        {
            logger.logPageLoad("", com/groupon/activity/HotelDetails.getSimpleName(), 0, l, (int)(SystemClock.elapsedRealtime() - l), Logger.NULL_NST_FIELD);
            pageLoadTimeHasBeenLogged = true;
        }
    }

    private void logRaOCheckButtonImpression()
    {
        Object obj = Logger.NULL_NST_FIELD;
        if (marketRateResult != null)
        {
            obj = new RaOCheckButtonExtraInfo(marketRateResult.derivedAvgMinPriceNet, marketRateResult.derivedAvgMinPriceCurrencyCode);
        }
        logger.logImpression("", "rao_check_button_impression", hotel.uuid, "hotel_details", ((EncodedNSTField) (obj)));
    }

    private void logRaODealImpression()
    {
        if (availableRooms != null && availableRooms.size() > 0)
        {
            RoomPrice roomprice = (RoomPrice)((HotelRoom)availableRooms.get(0)).prices.get(0);
            logger.logDealView("", channel.toString(), hotel.remoteId, hotel.uuid, new RaODealExtraInfo(true, roomprice.net, roomprice.currencyCode, raoOfferEndAt.toString(), false));
        }
    }

    private void onClickCheckRaOButton()
    {
        raoCheckButton.setEnabled(false);
        raoCheckButton.startSpinning();
        startRaORequest();
        logger.logClick("", "rao_check_button_click", "hotel_details", new EncodedNSTField() {

            final HotelDetails this$0;

            public String toEncodedString()
            {
                return "Click_Check_RaO_Button";
            }

            
            {
                this$0 = HotelDetails.this;
                super();
            }
        });
    }

    private void onGetRaORequestResult(boolean flag, int i, int j)
    {
label0:
        {
            raoCheckButton.stopSpinning();
            raoCheckButton.setEnabled(true);
            if (flag)
            {
                if (j < 0)
                {
                    break label0;
                }
                if (i > 0)
                {
                    checkingForRaO.set(true);
                    showUnlockingRaODiscount();
                    startRaOCountDownTimer(i);
                } else
                {
                    checkingForRaO.set(false);
                    hideRaOBottomBar();
                    loadInventory();
                }
                logger.logImpression("", "rao_contact_hotel_impression", hotel.uuid, "hotel_details", new RaOContactHotelImpressionExtraInfo(i, j));
            }
            return;
        }
        isRaOExpired = true;
        checkingForRaO.set(false);
        showNoRaOChanceToast();
        hideRaODealView();
    }

    private void revertGuestNumber()
    {
        if (adultsNumberBackup != -1)
        {
            adults = adultsNumberBackup;
        }
        if (childrenNumberBackup != -1)
        {
            children = childrenNumberBackup;
        }
    }

    private void selectRoom()
    {
        List list = hotelsService.mapHotelInventory(availableRooms);
        if (list != null && !list.isEmpty())
        {
            String s = (new StringBuilder()).append(hotel.derivedHotelAddressCity).append(", ").append(hotel.derivedHotelAddressState).append(", ").append(hotel.derivedHotelAddressCountry).toString();
            Object obj;
            BookingMetaData bookingmetadata;
            Calendar calendar;
            Calendar calendar1;
            if (imageUrls != null && !imageUrls.isEmpty())
            {
                obj = (ImageUrl)imageUrls.get(0);
            } else
            {
                if (marketRateResult != null)
                {
                    obj = marketRateResult.derivedImageUrl;
                } else
                {
                    obj = "";
                }
                obj = new ImageUrl(((String) (obj)));
            }
            bookingmetadata = new BookingMetaData();
            calendar = Calendar.getInstance();
            calendar.setTime(checkInDate);
            calendar1 = Calendar.getInstance();
            calendar1.setTime(checkOutDate);
            bookingmetadata.setStartDate(calendar);
            bookingmetadata.setEndDate(calendar1);
            if (list.size() == 1)
            {
                loginUtil.startMarketRateReservationFlow(((RoomCustomField)((HotelRoom)list.get(0)).customFields.get(0)).roomToken, hotel.name, s, ((ImageUrl) (obj)).getUrl(), hotel.getBucksDisclaimer(), channel, hotelId, bookingmetadata, productType);
                return;
            } else
            {
                startActivity(intentFactory.newSelectRoomIntent(availableRooms, hotel.name, s, ((ImageUrl) (obj)).getUrl(), hotel.getBucksDisclaimer(), channel, hotelId, bookingmetadata, productType));
                return;
            }
        } else
        {
            updateSubmitButtonNoAvailableRoom();
            return;
        }
    }

    private void setBucksInfo()
    {
        if (hotel == null || hotel.bucksPercentage == 0.0D || isLastMinute || marketRateResult == null)
        {
            gBucksContainer.setVisibility(8);
            return;
        } else
        {
            double d = hotel.bucksPercentage;
            int i = MarketRateUtil.getNumberOfNights(checkInDate, checkOutDate);
            i = (int)Math.round((double)(marketRateResult.derivedAvgMinPriceNet * i) * (d / 100D));
            GenericAmount genericamount = new GenericAmount();
            genericamount.setAmount(i);
            genericamount.setCurrencyCode(marketRateResult.derivedAvgMinPriceCurrencyCode);
            gBucksValue.setText(currencyFormatter.format(genericamount, true, com.groupon.util.CurrencyFormatter.DecimalStripBehavior.Always));
            gBucksContainer.setVisibility(0);
            return;
        }
    }

    private void setDates(String s, String s1)
    {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd");
        try
        {
            checkInDate = simpledateformat.parse(s);
            checkOutDate = simpledateformat.parse(s1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
    }

    private void setDefaultGuestNumber()
    {
        adultsNumberBackup = adults;
        childrenNumberBackup = children;
        adults = 2;
        children = 0;
    }

    private void setFinePrint()
    {
        boolean flag = false;
        String s = hotel.roomRateDisclaimer;
        String s1 = hotel.getBucksDisclaimer();
        boolean flag1 = Strings.notEmpty(s);
        int i;
        if (Strings.notEmpty(s1) && !isRaODeal)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (flag1 || i != 0)
        {
            finePrintContainer.setVisibility(0);
            TextView textview = roomRateDisclaimer;
            int j;
            if (flag1)
            {
                j = 0;
            } else
            {
                j = 8;
            }
            textview.setVisibility(j);
            textview = bucksDisclaimer;
            if (i != 0)
            {
                i = ((flag) ? 1 : 0);
            } else
            {
                i = 8;
            }
            textview.setVisibility(i);
            roomRateDisclaimer.setText(s);
            bucksDisclaimer.setText(s1);
            return;
        } else
        {
            finePrintContainer.setVisibility(8);
            return;
        }
    }

    private void setHotel(Hotel hotel1)
    {
        hotel = hotel1;
        marketRateResult = hotel1.marketRateResult;
    }

    private void setHotelAmenities()
    {
        boolean flag = false;
        String as[] = hotel.hotelAmenities;
        View view;
        int i;
        int j;
        if (as != null && as.length > 0)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        view = amenitiesContainer;
        if (i != 0)
        {
            j = 0;
        } else
        {
            j = 8;
        }
        view.setVisibility(j);
        if (i != 0)
        {
            StringBuilder stringbuilder = new StringBuilder();
            j = as.length;
            for (i = ((flag) ? 1 : 0); i < j; i++)
            {
                String s = as[i];
                stringbuilder.append("&#8226; ").append(s).append("<br/>");
            }

            amenitiesView.setText(Html.fromHtml(stringbuilder.toString()));
        }
    }

    private void setHotelDescription()
    {
        String s = hotel.description;
        boolean flag = Strings.notEmpty(s);
        View view = aboutContainer;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
        if (flag)
        {
            aboutTitle.setText(String.format(getString(0x7f080041), new Object[] {
                hotel.name
            }));
            aboutWebView.loadDataWithBaseURL(null, (new StringBuilder()).append("<style type=text/css> img{max-width: 100%; height: auto; display: block; margin: auto;} table{width: 100%; height: auto;} div{max-width: 100%; height: auto;} object{max-width: 100%; height: auto;} body{margin:10px 0px 0px 0px; color:#75787b;} a:link {color:#369ec1;} ul{padding-left:25px} blockquote{margin:0px;}</style>").append(s).toString(), "text/html", "UTF-8", null);
        }
    }

    private void setInitialDealData()
    {
        if (sharedDealInfo != null)
        {
            hotelTitle.setText(sharedDealInfo.announcementTitle);
            updatePriceInfo(sharedDealInfo.derivedPriceAmount, sharedDealInfo.derivedPriceCurrencyCode, sharedDealInfo.derivedValueAmount, sharedDealInfo.derivedValueCurrencyCode, sharedDealInfo.derivedDiscountPercent);
        }
    }

    private void setLocationInfo()
    {
        StringBuilder stringbuilder = new StringBuilder();
        String s = hotel.derivedHotelAddressCity;
        String s1 = hotel.derivedHotelAddressState;
        String s2 = hotel.derivedHotelAddressCountry;
        boolean flag = false;
        if (!Strings.isEmpty(s))
        {
            stringbuilder.append(s);
            flag = true;
        }
        boolean flag1 = flag;
        if (!Strings.isEmpty(s1))
        {
            if (flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append(s1);
            flag1 = true;
        }
        if (!Strings.isEmpty(s2))
        {
            if (flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append(s2);
        }
        hotelLocation.setText(stringbuilder);
    }

    private void setRaODealExpirationTime(String s)
    {
        if (s != null)
        {
            try
            {
                raoOfferEndAt = internetUsDateFormat.parse(s);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
            raoOfferEndAt = null;
            return;
        } else
        {
            raoOfferEndAt = null;
            return;
        }
    }

    private void setupImagePager()
    {
        dealImageView.setVisibility(0);
        dealImageView.setImageUrls(imageUrls).setDealId(hotelId).setChannel(channel).setupImagePager(new Callback() {

            final HotelDetails this$0;

            public void onError(ImageView imageview)
            {
            }

            public void onSuccess(ImageView imageview)
            {
                temporaryDealImageView.animate().alpha(0.0F).setDuration(200L).setStartDelay(400L);
            }

            
            {
                this$0 = HotelDetails.this;
                super();
            }
        });
    }

    private void showBottomBarRaOPrice()
    {
        raoCheckButton.setVisibility(8);
        raoUnlockingTimerContainer.setVisibility(8);
        raoPriceContainer.setVisibility(0);
    }

    private void showGuestsPickerDialog()
    {
        FragmentTransaction fragmenttransaction = getFragmentManager().beginTransaction();
        Object obj = getFragmentManager().findFragmentByTag("guests_picker_dialog");
        if (obj != null)
        {
            fragmenttransaction.remove(((android.app.Fragment) (obj)));
        }
        fragmenttransaction.addToBackStack(null);
        obj = GuestsPickerDialog.newInstance(adults, children, childrenAges, hotelId);
        ((GuestsPickerDialog) (obj)).show(fragmenttransaction, "guests_picker_dialog");
        ((GuestsPickerDialog) (obj)).setOnDismissListener(this);
    }

    private void showLastMinuteView()
    {
        updateGuestsSelectorButton();
        disabledSelectGuests.setVisibility(0);
        selectGuests.setVisibility(8);
        lastMinuteInfo.setVisibility(0);
        raoOfferInfo.setVisibility(8);
        strikePrice.setVisibility(0);
        bookingDateContainer.setVisibility(0);
        bookingDateText.setText(MarketRateUtil.getReservationDatesString(this, checkInDate, checkOutDate));
    }

    private void showMarketRateView()
    {
        updateGuestsSelectorButton();
        disabledSelectGuests.setVisibility(8);
        selectGuests.setVisibility(0);
        lastMinuteInfo.setVisibility(8);
        raoOfferInfo.setVisibility(8);
        strikePrice.setVisibility(8);
        bookingDateContainer.setVisibility(8);
    }

    private void showNoRaOChanceToast()
    {
        Toast.makeText(getApplicationContext(), getString(0x7f0802fc), 1).show();
    }

    private void showPotentialRaODiscount()
    {
        raoCheckButton.setVisibility(0);
        raoUnlockingTimerContainer.setVisibility(8);
        raoPriceContainer.setVisibility(8);
        logRaOCheckButtonImpression();
    }

    private void showRaOCountDownProgress(int i)
    {
        raoUnlockingTimerProgressBar.setProgress(i);
        raoUnlockingTimerText.setText(Integer.toString(i));
    }

    private void showRaOView()
    {
        setDefaultGuestNumber();
        updateGuestsSelectorButton();
        disabledSelectGuests.setVisibility(0);
        selectGuests.setVisibility(8);
        lastMinuteInfo.setVisibility(8);
        raoOfferInfo.setVisibility(0);
        gBucksContainer.setVisibility(8);
        bucksDisclaimer.setVisibility(8);
        bookingDateContainer.setVisibility(0);
        bookingDateText.setText(MarketRateUtil.getReservationDatesString(this, checkInDate, checkOutDate));
        logRaODealImpression();
    }

    private void showUnlockingRaODiscount()
    {
        raoCheckButton.setVisibility(8);
        raoPriceContainer.setVisibility(8);
        raoUnlockingTimerContainer.setVisibility(0);
    }

    private void skipRaORequest()
    {
        checkingForRaO.set(false);
        if (raoContactingHotelCountDownTimer != null)
        {
            raoContactingHotelCountDownTimer.cancel();
        }
        hideRaODealView();
        discountServiceFragment.skipRaOOffer(hotel.uuid);
    }

    private void startLoadingSubmitButton()
    {
        submitButton.setEnabled(false);
        submitButton.setText("");
        submitButtonMask.setVisibility(0);
        submitButton.startSpinning();
    }

    private void startRaOCountDownTimer(int i)
    {
        raoUnlockingTimerProgressBar.setMax(i);
        raoContactingHotelCountDownTimer = new CountDownTimer(i * 1000, 1000L) {

            final HotelDetails this$0;

            public void onFinish()
            {
                checkingForRaO.set(false);
                showRaOCountDownProgress(0);
                hideRaOBottomBar();
                loadInventory();
            }

            public void onTick(long l)
            {
                int j = (int)l / 1000;
                showRaOCountDownProgress(j);
            }

            
            {
                this$0 = HotelDetails.this;
                super(l, l1);
            }
        };
        raoContactingHotelCountDownTimer.start();
    }

    private void startRaOExpireTimeCounting()
    {
        if (raoOfferEndAt == null)
        {
            return;
        }
        PeriodicTasks periodictasks = new PeriodicTasks(this);
        PeriodicTasks periodictasks1 = (PeriodicTasks)raoExpireTimePeriodicTask.getAndSet(periodictasks);
        if (periodictasks1 != null)
        {
            periodictasks1.cancel();
            handler.removeCallbacks(periodictasks1);
        }
        periodictasks.run();
        updateRaOExpireTimeLeft();
    }

    private void startRaORequest()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(Arrays.asList(new String[] {
            "Hotel_ID", hotelId
        }));
        discountServiceFragment.requestRaOOffer(hotelUuid, arraylist);
    }

    private void stopLoadingSubmitButton()
    {
        submitButton.stopSpinning();
    }

    private void updateGuestsSelectorButton()
    {
        String s = getResources().getQuantityString(0x7f0c0000, adults, new Object[] {
            Integer.valueOf(adults)
        });
        String s1 = getResources().getQuantityString(0x7f0c0003, children, new Object[] {
            Integer.valueOf(children)
        });
        guestsSelectorText.setText((new StringBuilder()).append(s).append(", ").append(s1));
        disabledGuestsSelectorText.setText((new StringBuilder()).append(s).append(", ").append(s1));
    }

    private void updateMapSection()
    {
        mapSlice.setVisibility(0);
        final Double lat = hotel.derivedHotelAddressLat;
        final Double lng = hotel.derivedHotelAddressLng;
        if (lat != null && lng != null)
        {
            mapSlice.setLocationCoordinates(lat.doubleValue(), lng.doubleValue());
            mapSlice.setOnImageClickListener(new android.view.View.OnClickListener() {

                final HotelDetails this$0;
                final Double val$lat;
                final Double val$lng;

                public void onClick(View view)
                {
                    double d1 = 0.0D;
                    view = new Location();
                    double d;
                    if (lat == null)
                    {
                        d = 0.0D;
                    } else
                    {
                        d = lat.doubleValue();
                    }
                    view.lat = d;
                    if (lng == null)
                    {
                        d = d1;
                    } else
                    {
                        d = lng.doubleValue();
                    }
                    view.lng = d;
                    startActivity(intentFactory.newShowOnMapIntent(view, hotel.name, 0));
                }

            
            {
                this$0 = HotelDetails.this;
                lat = double1;
                lng = double2;
                super();
            }
            });
        }
        mapSlice.setLocationAddress(hotel.derivedHotelAddressStreetAddress1, hotel.derivedHotelAddressStreetAddress2, hotel.derivedHotelAddressPostalCode, hotel.derivedHotelAddressCity, hotel.derivedHotelAddressState, hotel.derivedHotelAddressCountry);
        mapSlice.setVendorInfo(hotel.phoneNumber, "");
        mapSlice.show();
    }

    private void updateMarketRatePriceInfo()
    {
        if (marketRateResult != null)
        {
            updatePriceInfo(marketRateResult.derivedAvgMinPriceNet, marketRateResult.derivedAvgMinPriceCurrencyCode, marketRateResult.derivedDisplayValueAmount, marketRateResult.derivedDisplayValueCurrencyCode, marketRateResult.discountPercentage);
            return;
        } else
        {
            hidePriceInfo();
            return;
        }
    }

    private void updatePriceInfo(int i, String s, int j, String s1, double d)
    {
        GenericAmount genericamount = new GenericAmount();
        genericamount.setAmount(i);
        genericamount.setCurrencyCode(s);
        s = new GenericAmount();
        s.setAmount(j);
        s.setCurrencyCode(s1);
        price.setText(currencyFormatter.format(genericamount, true, com.groupon.util.CurrencyFormatter.DecimalStripBehavior.OnlyIfZero));
        strikePrice.setText(currencyFormatter.format(s, true, com.groupon.util.CurrencyFormatter.DecimalStripBehavior.Always));
        strikePrice.setPaintFlags(strikePrice.getPaintFlags() | 0x10);
        s1 = strikePrice;
        if (s.getAmount() == 0)
        {
            i = 8;
        } else
        {
            i = 0;
        }
        s1.setVisibility(i);
        priceContainer.setVisibility(0);
        if (isLastMinute)
        {
            s = lastMinuteDiscountLabel;
            if (d == 0.0D)
            {
                i = 8;
            } else
            {
                i = 0;
            }
            s.setVisibility(i);
            lastMinuteDiscountLabel.setText(getString(0x7f080135, new Object[] {
                Integer.valueOf((int)d)
            }));
        } else
        if (isRaODeal)
        {
            raoStrikePrice.setText(currencyFormatter.format(s, true, com.groupon.util.CurrencyFormatter.DecimalStripBehavior.OnlyIfZero));
            raoStrikePrice.setPaintFlags(raoStrikePrice.getPaintFlags() | 0x10);
            s = raoStrikePrice;
            if (j == 0)
            {
                i = 8;
            } else
            {
                i = 0;
            }
            s.setVisibility(i);
            raoPrice.setText(currencyFormatter.format(genericamount, true, com.groupon.util.CurrencyFormatter.DecimalStripBehavior.OnlyIfZero));
            s = raoDiscountLabel;
            if (d == 0.0D)
            {
                i = 8;
            } else
            {
                i = 0;
            }
            s.setVisibility(i);
            raoDiscountLabel.setText(getString(0x7f080135, new Object[] {
                Integer.valueOf((int)d)
            }));
            return;
        }
    }

    private void updateRaOExpireTimeLeft()
    {
        if (isTimeInPast(raoOfferEndAt))
        {
            PeriodicTasks periodictasks = (PeriodicTasks)raoExpireTimePeriodicTask.get();
            if (periodictasks != null)
            {
                periodictasks.cancel();
                handler.removeCallbacks(periodictasks);
            }
            raoExpireTime.setText(getString(0x7f0802f8));
            if (!isRaOExpired)
            {
                isRaOExpired = true;
                hideRaODealView();
                revertGuestNumber();
                loadInventory();
            }
            return;
        } else
        {
            Object obj = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
            ((HumanReadableCountdownFormat)timeLeftDateFormat).setRelativeTo(((Calendar) (obj)).getTime());
            obj = timeLeftDateFormat.format(raoOfferEndAt);
            raoExpireTime.setText(getString(0x7f0801ae, new Object[] {
                obj
            }));
            return;
        }
    }

    private void updateRaOPriceInfo()
    {
        RoomPrice roomprice;
label0:
        {
            if (availableRooms != null && availableRooms.size() > 0)
            {
                showBottomBarRaOPrice();
                roomprice = (RoomPrice)((HotelRoom)availableRooms.get(0)).prices.get(0);
                if (marketRateResult == null)
                {
                    break label0;
                }
                double d = Math.ceil(((double)(marketRateResult.derivedAvgMinPriceNet - roomprice.net) * 100D) / (double)marketRateResult.derivedAvgMinPriceNet);
                updatePriceInfo(roomprice.net, roomprice.currencyCode, marketRateResult.derivedAvgMinPriceNet, marketRateResult.derivedAvgMinPriceCurrencyCode, d);
            }
            return;
        }
        updatePriceInfo(roomprice.net, roomprice.currencyCode, 0, "", 0.0D);
    }

    private void updateSubmitButton(boolean flag, boolean flag1)
    {
        Object obj = submitButton;
        int i;
        if (flag)
        {
            if (flag1)
            {
                i = 0x7f080432;
            } else
            {
                i = 0x7f080518;
            }
        } else
        {
            i = 0x7f0804fc;
        }
        ((SpinnerButton) (obj)).setText(i);
        obj = submitButtonMask;
        if (flag)
        {
            i = 8;
        } else
        {
            i = 0;
        }
        ((TextView) (obj)).setVisibility(i);
        submitButton.setEnabled(flag);
    }

    private void updateSubmitButtonBookRoom()
    {
        updateSubmitButton(true, true);
    }

    private void updateSubmitButtonNoAvailableRoom()
    {
        updateSubmitButton(false, false);
    }

    private void updateSubmitButtonSelectRoom()
    {
        updateSubmitButton(true, false);
    }

    private void updateTripAdvisorSection()
    {
        com.groupon.db.models.HotelReviews hotelreviews = hotel.getHotelReviews(getString(0x7f080464));
        if (hotelreviews != null)
        {
            Object obj = tripAdvisorSection;
            String s1 = hotel.uuid;
            String s;
            if (isLastMinute)
            {
                s = "lastMinute";
            } else
            {
                s = "marketRate";
            }
            ((TripAdvisorReviewSection) (obj)).updateViews(hotelreviews, s1, s);
            obj = logger;
            s1 = hotel.uuid;
            if (isLastMinute)
            {
                s = "lastMinute";
            } else
            {
                s = "marketRate";
            }
            ((Logger) (obj)).logImpression("", "travel_reviews_summary", s1, s, new TravelReviewsSummaryImpressionExtraInfo(hotelreviews));
        }
    }

    private void updateViewWithSingleRoom()
    {
        if (availableRooms != null && availableRooms.size() == 1)
        {
            Object obj = (HotelRoom)hotelsService.mapHotelInventory(availableRooms).get(0);
            roomContainer.setVisibility(0);
            roomTitle.setText(((HotelRoom) (obj)).title);
            obj = ((HotelRoom) (obj)).details;
            if (((List) (obj)).size() > 0 && ((List) (obj)).get(0) != null && ((RoomDetails)((List) (obj)).get(0)).description != null)
            {
                obj = ((RoomDetails)((List) (obj)).get(0)).description;
            } else
            {
                obj = "";
            }
            roomDescription.setText(Html.fromHtml(((String) (obj))));
            return;
        } else
        {
            roomContainer.setVisibility(8);
            return;
        }
    }

    private void updateViewsByContent()
    {
        if (hotel == null)
        {
            return;
        }
        long l = SystemClock.elapsedRealtime();
        hotelTitle.setText(hotel.name);
        setLocationInfo();
        long l1;
        if (isRaODeal)
        {
            updateRaOPriceInfo();
        } else
        {
            setBucksInfo();
            updateMarketRatePriceInfo();
        }
        setHotelDescription();
        setHotelAmenities();
        updateMapSection();
        setFinePrint();
        progress.setVisibility(8);
        contentView.setVisibility(0);
        if (shouldShowTripAdvisorReviews)
        {
            updateTripAdvisorSection();
        }
        l1 = SystemClock.elapsedRealtime();
        logger.logGeneralEvent("hotel_performance", "on_hotel_details_update_view_after_request", hotelId, (int)(l1 - l), Logger.NULL_NST_FIELD);
    }

    private void updateViewsByInventory()
    {
        updateViewWithSingleRoom();
        if (isRaODeal)
        {
            showRaOView();
            updateRaOPriceInfo();
            startRaOExpireTimeCounting();
        } else
        {
            if (isLastMinute)
            {
                showLastMinuteView();
            } else
            {
                showMarketRateView();
            }
            if (shouldShowRaO)
            {
                if (checkingForRaO.get())
                {
                    onClickCheckRaOButton();
                    return;
                }
                if (isRaOExpired)
                {
                    hideRaODealView();
                    if (isBothContentAndInventoryLoaded())
                    {
                        setBucksInfo();
                        updateMarketRatePriceInfo();
                        setFinePrint();
                        return;
                    }
                } else
                {
                    showPotentialRaODiscount();
                    return;
                }
            }
        }
    }

    public void finishAfterTransition()
    {
        setResult(-1);
        if (transitionController.isInitialized())
        {
            HashMap hashmap = new HashMap();
            hashmap.put(Integer.valueOf(0x7f100384), detailsTopContainer);
            hashmap.put(Integer.valueOf(0x7f100394), detailsMainContainer);
            hashmap.put(Integer.valueOf(0x7f1000a0), bottomBar);
            transitionController.setReturning(true);
            transitionController.addAllAnimatedViews(hashmap);
            transitionController.handleReturnTransition();
            super.finishAfterTransition();
            return;
        } else
        {
            finish();
            return;
        }
    }

    protected String getChildrenAgesAsString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        int j = childrenAges.size();
        for (int i = 0; i < j; i++)
        {
            stringbuilder.append(childrenAges.get(i));
            if (i < j - 1)
            {
                stringbuilder.append(",");
            }
        }

        return stringbuilder.toString();
    }

    public android.app.LoaderManager.LoaderCallbacks getLoaderCallBack()
    {
        return new HotelLoaderCallbacks(this, hotelId, isSearchFlow, channelId) {

            final HotelDetails this$0;

            public void onHotelLoaded(Hotel hotel1)
            {
                contentLoaded = true;
                setHotel(hotel1);
                updateViewsByContent();
                logPageLoadComplete(onCreateStartTime);
                logger.logDealView("", channel.toString(), hotel1.remoteId, hotel1.uuid, loggingUtils.getMarketRateExtraInfoString(productType, hasRaO));
                dealImageView.doStartImageRotation();
            }

            
            {
                this$0 = HotelDetails.this;
                super(context, s, flag, s1);
            }
        };
    }

    public GrouponSyncManager getSyncManager()
    {
        return hotelSyncManager;
    }

    public volatile SyncManager getSyncManager()
    {
        return getSyncManager();
    }

    protected void initActionBar(Bundle bundle)
    {
        super.initActionBar(bundle);
        transparentToolBarHelper.initToolBar(this);
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        switch (i)
        {
        default:
            return;

        case 10149: 
            handleDealImageCarouselRequestCode(j, intent);
            break;
        }
    }

    public void onCreate(Bundle bundle)
    {
        boolean flag1 = false;
        onCreateStartTime = SystemClock.elapsedRealtime();
        long l = SystemClock.elapsedRealtime();
        super.onCreate(bundle);
        setContentView(0x7f030134);
        if (bundle != null)
        {
            adults = bundle.getInt("adults", 2);
            children = bundle.getInt("children", 0);
            childrenAges = bundle.getIntegerArrayList("children_ages");
            isRaOExpired = bundle.getBoolean("expired_rao");
            checkingForRaO.set(bundle.getBoolean("checking_rao"));
        }
        dealImageView.setDealImageHeight(calculateLandscapeImageHeight());
        isLastMinute = Strings.equalsIgnoreCase(productType, "lastMinute");
        setDates(checkInDateString, checkOutDateString);
        shouldShowTripAdvisorReviews = travelReviewsAbTestHelper.isTravelTripAdvisorReviewsEnabled();
        hotelSyncManager.setRequestTripAdvisorReviews(shouldShowTripAdvisorReviews);
        boolean flag = flag1;
        if (abTestService.isVariantEnabledAndUSCA("getawaysRequestAnOffer1508USCA", "on"))
        {
            flag = flag1;
            if (hasRaO)
            {
                flag = true;
            }
        }
        shouldShowRaO = flag;
        if (shouldShowRaO)
        {
            initDiscountService();
        }
        setInitialDealData();
        long l1;
        if (isCustomEnterTransition() && bundle == null)
        {
            handleLollipopSceneTransition();
        } else
        {
            handleDefaultSceneTransition();
        }
        l1 = SystemClock.elapsedRealtime();
        logger.logGeneralEvent("hotel_performance", "hotel_details_onCreate", hotelId, (int)(l1 - l), Logger.NULL_NST_FIELD);
    }

    protected void onDestroy()
    {
        if (raoContactingHotelCountDownTimer != null)
        {
            raoContactingHotelCountDownTimer.cancel();
        }
        handler.removeCallbacks((Runnable)raoExpireTimePeriodicTask.get());
        if (discountServiceFragment != null)
        {
            discountServiceFragment.setCallback(null);
        }
        super.onDestroy();
    }

    public void onDrawerDialogDismiss(Bundle bundle)
    {
        if (bundle != null)
        {
            int i = bundle.getInt("adults", 0);
            int j = bundle.getInt("children", 0);
            bundle = bundle.getIntegerArrayList("children_ages");
            if (childrenAges != null && !childrenAges.equals(bundle) || adults != i || children != j)
            {
                adults = i;
                children = j;
                childrenAges = bundle;
                updateGuestsSelectorButton();
                getHotelInventory(null);
            }
        }
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
        if (bundle.getBoolean("should_expand", false))
        {
            tripAdvisorSection.expandAfterLayout();
        }
    }

    protected void onResume()
    {
        super.onResume();
        android.app.Fragment fragment = getFragmentManager().findFragmentByTag("guests_picker_dialog");
        if (fragment != null)
        {
            ((GuestsPickerDialog)fragment).setOnDismissListener(this);
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putInt("adults", adults);
        bundle.putInt("children", children);
        bundle.putIntegerArrayList("children_ages", (ArrayList)childrenAges);
        bundle.putBoolean("should_expand", tripAdvisorSection.isExpanded());
        bundle.putBoolean("checking_rao", checkingForRaO.get());
        bundle.putBoolean("expired_rao", isRaOExpired);
    }

    protected void onStop()
    {
        dealImageView.doStopImageRotation();
        super.onStop();
    }

    protected boolean shouldStartAutomaticSyncsOnResume()
    {
        return android.os.Build.VERSION.SDK_INT < 21 || !transitionController.shouldStartSceneTransition();
    }




/*
    static boolean access$102(HotelDetails hoteldetails, boolean flag)
    {
        hoteldetails.contentLoaded = flag;
        return flag;
    }

*/



/*
    static List access$1102(HotelDetails hoteldetails, List list)
    {
        hoteldetails.availableRooms = list;
        return list;
    }

*/






/*
    static boolean access$1602(HotelDetails hoteldetails, boolean flag)
    {
        hoteldetails.inventoryLoaded = flag;
        return flag;
    }

*/




/*
    static boolean access$1802(HotelDetails hoteldetails, boolean flag)
    {
        hoteldetails.isRaODeal = flag;
        return flag;
    }

*/



















/*
    static List access$702(HotelDetails hoteldetails, List list)
    {
        hoteldetails.imageUrls = list;
        return list;
    }

*/


}
