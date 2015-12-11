// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.groupon.Channel;
import com.groupon.abtest.NewCartAbTestHelper;
import com.groupon.db.models.Deal;
import com.groupon.db.models.Merchant;
import com.groupon.db.models.Option;
import com.groupon.db.models.SchedulerOption;
import com.groupon.models.DateTimeFinderReservationDetails;
import com.groupon.models.LocationsContainer;
import com.groupon.models.country.Country;
import com.groupon.models.dealbreakdown.DealBreakdownAddress;
import com.groupon.models.division.Division;
import com.groupon.models.gdt.GdtFeatures;
import com.groupon.models.gdt.GdtMerchantData;
import com.groupon.models.gdt.GdtMerchantDataContainer;
import com.groupon.models.gift.GiftingRecord;
import com.groupon.models.mobilescheduler.DealOption;
import com.groupon.models.mobilescheduler.LocalBookingInfo;
import com.groupon.models.mobilescheduler.MobileSchedulerData;
import com.groupon.models.mobilescheduler.Reservation;
import com.groupon.service.LocationService;
import com.groupon.service.ShippingService;
import com.groupon.service.ShoppingCartService;
import com.groupon.service.core.AbTestService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.service.countryanddivision.CurrentDivisionManager;
import com.groupon.service.gdt.GdtService;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.BuyUtils;
import com.groupon.util.Dates;
import com.groupon.util.DealUtils;
import com.groupon.util.DialogManager;
import com.groupon.util.Function0;
import com.groupon.util.Function1;
import com.groupon.util.GeoPoint;
import com.groupon.util.GrouponDialogFragment;
import com.groupon.util.GrouponDialogListener;
import com.groupon.util.GrouponRatingPrompter;
import com.groupon.util.ShareHelper;
import com.groupon.view.PopupWindowAboveView;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.restlet.engine.util.InternetUsDateFormat;
import roboguice.inject.Lazy;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            AbstractThanks, IntentFactory

public class Thanks extends AbstractThanks
    implements GrouponDialogListener
{

    private static final String PREPURCHASE_RESERVATION_CLICK_TYPE = "view_reservation_click";
    private static final String RATING_ADD_WIDGET_DIALOG = "rating_add_widget_dialog";
    private static final String RESERVATION_DATE_FORMAT = "E MMM d";
    private static final String RESERVATION_DETAILS_DATE_TIME_FORMAT = "%1$s, %2$s";
    private static final String RESERVATION_DETAILS_PARTY_SIZE_DATE_TIME_FORMAT = "%1$s, %2$s, %3$s";
    private static final String RESERVATION_TIME_FORMAT = "h:mm a";
    private static boolean showRate = true;
    TextView bookNowOrShareView;
    LinearLayout buttonsContainer;
    private BuyUtils buyUtil;
    private NewCartAbTestHelper cartAbTestHelper;
    private CurrentCountryManager currentCountryManager;
    private DateTimeFinderReservationDetails dateTimeFinderReservationDetails;
    Bundle dateTimeFinderReservationDetailsBundle;
    TextView dateTimeFinderReservationDetailsTextView;
    TextView dealRequiresBooking;
    private DialogManager dialogManager;
    private GdtService gdtService;
    private GiftingRecord giftingRecord;
    Bundle giftingRecordBundle;
    boolean hideMyGroupons;
    private IntentFactory intentFactory;
    private InternetUsDateFormat internetUsDateFormat;
    private boolean isBookingEngineCoachMark1506USCA;
    private boolean isBookingUpdatePreBook1506USCA;
    private boolean isBookingUpdates1408USCA;
    boolean isDealPrePurchaseBooked;
    private boolean isGDT1503USCA;
    private GeoPoint location;
    private LocationService locationService;
    private Logger logger;
    TextView merchantNameTextView;
    TextView myGrouponView;
    int numberOfItemsInCart;
    private Option option;
    String optionId;
    TextView orderFood;
    private PopupWindowAboveView popupWindow;
    private SharedPreferences prefs;
    TextView requestAppointmentLater;
    TextView requestAppointmentMessage;
    TextView requestAppointmentView;
    TextView shippingAddress;
    FrameLayout shippingAddressContainer;
    TextView shippingAddressHeader;
    private String shippingAddressString;
    ProgressBar shippingProgress;
    private ShippingService shippingService;
    private ShoppingCartService shoppingCartService;
    private boolean shouldShowGdtOrderNow;
    private boolean shouldShowRequestAppointment;
    private boolean shouldShowRequestAppointmentPopup;
    boolean showShippingAddress;
    TextView thankYouGdtHead;
    TextView thankYouGdtSubhead;
    TextView thankYouSubhead;
    ProgressBar thanksButtonsProgress;
    TextView thanksView;
    TextView unlockedDealsTitleNew;

    public Thanks()
    {
        location = null;
    }

    private void checkGdtLocations()
    {
        thanksButtonsProgress.setVisibility(0);
        gdtService.getMerchantGdtLocations(deal.merchant.uuid, new Function1() {

            final Thanks this$0;

            public void execute(GdtMerchantDataContainer gdtmerchantdatacontainer)
            {
                if (gdtmerchantdatacontainer != null && gdtmerchantdatacontainer.data != null && gdtmerchantdatacontainer.data.gdtFeatures != null)
                {
                    gdtmerchantdatacontainer = gdtmerchantdatacontainer.data.gdtFeatures;
                    if (((GdtFeatures) (gdtmerchantdatacontainer)).offersTakeout || ((GdtFeatures) (gdtmerchantdatacontainer)).offersDelivery)
                    {
                        shouldShowGdtOrderNow = true;
                    }
                }
            }

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((GdtMerchantDataContainer)obj);
            }

            
            {
                this$0 = Thanks.this;
                super();
            }
        }, null, new Function0() {

            final Thanks this$0;

            public void execute()
            {
                thanksButtonsProgress.setVisibility(8);
                setupUI();
            }

            
            {
                this$0 = Thanks.this;
                super();
            }
        });
    }

    private int computeAppointmentButtonResourceId(boolean flag)
    {
        byte byte0;
        boolean flag1;
        boolean flag2;
        byte0 = -1;
        flag1 = DealUtils.isFoodAndDrinkDeal(deal);
        flag2 = DealUtils.isHealthBeautyWellnessDeal(deal);
        if (!flag) goto _L2; else goto _L1
_L1:
        if (!flag2) goto _L4; else goto _L3
_L3:
        int i = 0x7f080403;
_L6:
        return i;
_L4:
        i = byte0;
        if (flag1)
        {
            return 0x7f08040c;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (!isCurrentOptionG3DealOption())
        {
            break; /* Loop/switch isn't completed */
        }
        if (flag2)
        {
            return 0x7f080072;
        }
        i = byte0;
        if (flag1)
        {
            return 0x7f080077;
        }
        if (true) goto _L6; else goto _L5
_L5:
        i = byte0;
        if (isCurrentOptionArseDealOption())
        {
            if (flag2)
            {
                return 0x7f080327;
            }
            i = byte0;
            if (flag1)
            {
                return 0x7f08032d;
            }
        }
        if (true) goto _L6; else goto _L7
_L7:
    }

    private MobileSchedulerData createMobileSchedulerData(String s)
    {
        MobileSchedulerData mobileschedulerdata = new MobileSchedulerData();
        mobileschedulerdata.dealOption.id = option.uuid;
        mobileschedulerdata.orderId = orderId;
        mobileschedulerdata.merchant.id = deal.merchant.remoteId;
        mobileschedulerdata.deal.id = dealId;
        mobileschedulerdata.localBookingInfo.reservation.status = s;
        mobileschedulerdata.bookable = option.bookable;
        mobileschedulerdata.channel = channel.name();
        return mobileschedulerdata;
    }

    private String generateThankYouSubheadString()
    {
        if (deal.isTravelBookableDeal)
        {
            return getString(0x7f0803e8);
        }
        if (giftingRecord != null)
        {
            if (giftingRecord.deliveryMethod.equals("print"))
            {
                return getString(0x7f0803d5);
            }
            if (currentCountryManager.getCurrentCountry().isSellerOfRecordCountry())
            {
                return getString(0x7f0803b8);
            } else
            {
                return getString(0x7f0803d2);
            }
        }
        if (deal.isApplyButton)
        {
            return getString(0x7f0803d3);
        }
        String s;
        if (currentCountryManager.getCurrentCountry().isSellerOfRecordCountry())
        {
            s = getString(0x7f080284);
        } else
        {
            s = getString(0x7f08027e);
        }
        if (currentCountryManager.getCurrentCountry().isSellerOfRecordCountry())
        {
            if (isDealPrePurchaseBooked)
            {
                return getString(0x7f0803cb, new Object[] {
                    s
                });
            } else
            {
                return getString(0x7f0803b7);
            }
        }
        if (deal.derivedIsGLiveDeal)
        {
            return getString(0x7f0801e9);
        }
        if (isDealPrePurchaseBooked)
        {
            return getString(0x7f0803cb, new Object[] {
                s
            });
        } else
        {
            return getString(0x7f0803d1);
        }
    }

    private String getDealTitle()
    {
        if (currentCountryManager.getCurrentCountry().isJapan() && option != null)
        {
            if (Strings.notEmpty(option.getTitle()))
            {
                return option.getTitle();
            } else
            {
                return deal.getTitle();
            }
        } else
        {
            return deal.getTitle();
        }
    }

    private void getShippingAddress()
    {
        startShippingProcess();
        if (!isUSACompatible)
        {
            shippingService.getLocations(new Function1() {

                final Thanks this$0;

                public void execute(LocationsContainer locationscontainer)
                {
                    locationscontainer = locationscontainer.getLocations();
                    String s1 = prefs.getString("preferredShippingLocationId", "");
                    Iterator iterator = locationscontainer.iterator();
                    do
                    {
                        if (!iterator.hasNext())
                        {
                            break;
                        }
                        locationscontainer = (DealBreakdownAddress)iterator.next();
                        if (Strings.equals(((DealBreakdownAddress) (locationscontainer)).id, s1))
                        {
                            String s = shippingService.getAsJoin(locationscontainer);
                            Thanks thanks = Thanks.this;
                            locationscontainer = s;
                            if (s.startsWith(", "))
                            {
                                locationscontainer = s.replaceFirst(", ", "");
                            }
                            thanks.shippingAddressString = locationscontainer;
                            shippingAddress.setText(shippingAddressString);
                            stopShippingProcess();
                        }
                    } while (true);
                }

                public volatile void execute(Object obj)
                    throws Exception
                {
                    execute((LocationsContainer)obj);
                }

            
            {
                this$0 = Thanks.this;
                super();
            }
            }, null, null);
            return;
        } else
        {
            shippingAddressString = shippingService.getAsJoin(true);
            shippingAddress.setText(shippingAddressString);
            stopShippingProcess();
            return;
        }
    }

    private void handleClick(int i)
    {
        i;
        JVM INSTR lookupswitch 14: default 124
    //                   2131230834: 515
    //                   2131230836: 125
    //                   2131230837: 208
    //                   2131230839: 515
    //                   2131231197: 333
    //                   2131231358: 125
    //                   2131231364: 125
    //                   2131231365: 208
    //                   2131231526: 208
    //                   2131231527: 515
    //                   2131231533: 515
    //                   2131231694: 321
    //                   2131231747: 550
    //                   2131231756: 550;
           goto _L1 _L2 _L3 _L4 _L2 _L5 _L3 _L3 _L4 _L4 _L2 _L2 _L6 _L7 _L7
_L1:
        return;
_L3:
        Intent intent;
        if (i == 0x7f080074)
        {
            logger.logClick("", "book_later_click", dealId, orderId);
        } else
        {
            logger.logClick("", "my_groupons_click", dealId, orderId);
        }
        intent = intentFactory.newMyGrouponIntent(channel);
        intent.putExtra("from_thank_you", true);
        startActivity(intent);
        finish();
        return;
_L4:
        if (i == 0x7f080285)
        {
            logger.logClick("", "view_reservation_click", channel.toString(), dealId);
        } else
        {
            Logger logger1 = logger;
            String s;
            if (!option.bookable && isBookingUpdates1408USCA)
            {
                s = "request_appointment_click";
            } else
            {
                s = "book_now_click";
            }
            logger1.logClick("", s, dealId, orderId);
        }
        startActivity(intentFactory.newMobileSchedulerIntent(createMobileSchedulerData("booked"), channel, false, true, false, null));
        finish();
        return;
_L6:
        if (!hidePurchasedDealInfo)
        {
            openShareHelper();
            return;
        }
          goto _L1
_L5:
        MobileSchedulerData mobileschedulerdata = createMobileSchedulerData("booked");
        mobileschedulerdata.orderId = orderId;
        mobileschedulerdata.merchant.id = deal.merchant.uuid;
        mobileschedulerdata.dealOption.id = option.remoteId;
        Object obj = locationService.getLocation();
        if (obj != null)
        {
            mobileschedulerdata.location.lat = ((Location) (obj)).getLatitude();
            mobileschedulerdata.location.lng = ((Location) (obj)).getLongitude();
        }
        mobileschedulerdata.location.division = ((CurrentDivisionManager)currentDivisionManager.get()).getCurrentDivision().name;
        obj = new HashMap(1);
        ((HashMap) (obj)).put("dealId", dealId);
        logger.logClick("", "order_food_gdt", channel.toString(), buyUtil.nstClickMetadata(logger, ((HashMap) (obj))));
        startActivity(intentFactory.newMobileSchedulerIntent(mobileschedulerdata, channel, true, true, false, null));
        finish();
        return;
_L2:
        startActivity(intentFactory.newMobileSchedulerIntentWithPredefinedReservation(createMobileSchedulerData("unbooked"), dateTimeFinderReservationDetails, channel, false, true, false, null));
        finish();
        return;
_L7:
        startActivity(intentFactory.newMobileSchedulerIntent(createMobileSchedulerData("booked"), channel, false, true, false, null));
        finish();
        return;
    }

    private boolean isBookingEngineOption(SchedulerOption scheduleroption)
    {
        return Strings.notEmpty(scheduleroption.bookingType) && Strings.equalsIgnoreCase(scheduleroption.bookingType, "booking_engine");
    }

    private boolean isCurrentOptionArseDealOption()
    {
        return !option.bookable && option.schedulerOptions != null && isBookingEngineOption(option.schedulerOptions);
    }

    private boolean isCurrentOptionDto()
    {
        return option != null && (option.specificAttributeDelivery || option.specificAttributeTakeout);
    }

    private boolean isCurrentOptionG3DealOption()
    {
        return option.bookable && option.schedulerOptions != null && isBookingEngineOption(option.schedulerOptions);
    }

    private void openShareHelper()
    {
        (new ShareHelper(this, getDealTitle(), deal.dealUrl)).shareDeal();
    }

    private void setAppointmentViews(int i)
    {
        setupItem(i, requestAppointmentView);
        requestAppointmentView.setVisibility(0);
        String s;
        if (currentCountryManager.getCurrentCountry().isSellerOfRecordCountry())
        {
            s = getString(0x7f080284);
        } else
        {
            s = getString(0x7f08027e);
        }
        setUpTextLink(getString(0x7f0803cb, new Object[] {
            s
        }), s, thankYouSubhead);
    }

    private void setUpShippingAddress()
    {
        shippingAddressHeader.setVisibility(0);
        shippingAddress.setVisibility(0);
        getShippingAddress();
        TextView textview = shippingAddressHeader;
        String s1 = getResources().getString(0x7f0803d0);
        String s;
        if (hidePurchasedDealInfo)
        {
            s = getResources().getString(0x7f080206).toLowerCase();
        } else
        {
            s = getDealTitle();
        }
        textview.setText(String.format(s1, new Object[] {
            s
        }));
    }

    private void setUpTextLink(String s, String s1, TextView textview)
    {
        int i = s.length();
        s = new SpannableString(s);
        s.setSpan(new ClickableSpan() {

            final Thanks this$0;

            public void onClick(View view)
            {
                logger.logClick("", "my_groupons_click", dealId, orderId);
                startActivity(intentFactory.newMyGrouponIntent(channel));
                finish();
            }

            public void updateDrawState(TextPaint textpaint)
            {
                textpaint.setUnderlineText(false);
                textpaint.setColor(getResources().getColor(0x7f0e0197));
            }

            
            {
                this$0 = Thanks.this;
                super();
            }
        }, i - (s1.length() + 1), i - 1, 33);
        textview.setText(s);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        textview.setVisibility(0);
        if (isBookingEngineCoachMark1506USCA && isBookingUpdates1408USCA && shouldShowRequestAppointment)
        {
            requestAppointmentView.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

                final Thanks this$0;

                public void onGlobalLayout()
                {
                    if (shouldShowRequestAppointmentPopup && (popupWindow == null || !popupWindow.isShowing()))
                    {
                        popupWindow = new PopupWindowAboveView(Thanks.this, new Runnable() {

                            final _cls5 this$1;

                            public void run()
                            {
                                shouldShowRequestAppointmentPopup = false;
                            }

            
            {
                this$1 = _cls5.this;
                super();
            }
                        }, requestAppointmentView.getWidth(), -2);
                        View view = getLayoutInflater().inflate(0x7f030214, null);
                        popupWindow.showAboveView(requestAppointmentView, view, (int)getResources().getDimension(0x7f0b020d));
                    }
                    requestAppointmentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }

            
            {
                this$0 = Thanks.this;
                super();
            }
            });
        }
    }

    private void setUserRated()
    {
        android.content.SharedPreferences.Editor editor = getSharedPreferences("GRP.ratingsDictionary", 0).edit();
        editor.putBoolean("GRP.alreadyRated", true);
        editor.apply();
    }

    private void setupHeader()
    {
        int i;
        if (!hidePurchasedDealInfo)
        {
            TextView textview;
            if (deal.shippingAddressRequired)
            {
                setUpShippingAddress();
            } else
            {
                shippingAddress.setVisibility(8);
                shippingAddressHeader.setVisibility(8);
                shippingAddressContainer.setVisibility(8);
            }
            thankYouSubhead.setText(generateThankYouSubheadString());
        } else
        {
            if (numberOfItemsInCart > 1)
            {
                thankYouSubhead.setText(0x7f0803d4);
            }
            if (showShippingAddress && shippingService.isStored())
            {
                setUpShippingAddress();
            } else
            {
                shippingAddress.setVisibility(8);
                shippingAddressHeader.setVisibility(8);
                shippingAddressContainer.setVisibility(8);
            }
            unlockedDealsTitleNew.setVisibility(0);
        }
        textview = thanksView;
        if (numberOfItemsInCart > 1)
        {
            i = 0x7f0803d7;
        } else
        if (currentCountryManager.getCurrentCountry().isSellerOfRecordCountry())
        {
            i = 0x7f0803b9;
        } else
        {
            i = 0x7f0803d9;
        }
        textview.setText(i);
    }

    private void setupItem(final int stringId, TextView textview)
    {
        textview.setText(stringId);
        textview.setOnClickListener(new android.view.View.OnClickListener() {

            final Thanks this$0;
            final int val$stringId;

            public void onClick(View view)
            {
                handleClick(stringId);
            }

            
            {
                this$0 = Thanks.this;
                stringId = i;
                super();
            }
        });
    }

    private void setupItems()
    {
        Object obj;
        int i;
label0:
        {
            boolean flag = false;
            if (!isUSACompatible)
            {
                i = ((flag) ? 1 : 0);
                if (!isBookingUpdatePreBook1506USCA)
                {
                    break label0;
                }
            }
            if (option != null)
            {
                obj = option.schedulerOptions;
            } else
            {
                obj = null;
            }
            i = ((flag) ? 1 : 0);
            if (obj != null)
            {
                if (option.bookable)
                {
                    if (!isDealPrePurchaseBooked && isBookingEngineOption(((SchedulerOption) (obj))))
                    {
                        i = 1;
                    } else
                    {
                        i = 0;
                    }
                } else
                {
                    shouldShowRequestAppointment = isBookingEngineOption(((SchedulerOption) (obj)));
                    invalidateOptionsMenu();
                    i = ((flag) ? 1 : 0);
                }
            }
        }
        if (dateTimeFinderReservationDetails == null) goto _L2; else goto _L1
_L1:
        thankYouSubhead.setVisibility(0);
        if (isDealPrePurchaseBooked)
        {
            setAppointmentViews(computeAppointmentButtonResourceId(true));
            String s1;
            if (dateTimeFinderReservationDetails.reservationDate != null)
            {
                if (Dates.isToday(dateTimeFinderReservationDetails.reservationDate.getTime()))
                {
                    obj = getString(0x7f0803e0);
                } else
                {
                    obj = internetUsDateFormat.format("E MMM d", dateTimeFinderReservationDetails.reservationDate, dateTimeFinderReservationDetails.timeZone).toString();
                }
                s1 = internetUsDateFormat.format("h:mm a", dateTimeFinderReservationDetails.reservationDate, dateTimeFinderReservationDetails.timeZone).toString();
            } else
            {
                obj = getString(0x7f080065);
                s1 = getString(0x7f0802b4);
            }
            i = dateTimeFinderReservationDetails.partySize;
            if (i > 0)
            {
                obj = String.format("%1$s, %2$s, %3$s", new Object[] {
                    getResources().getQuantityString(0x7f0c0015, i, new Object[] {
                        Integer.valueOf(i)
                    }), obj, s1
                });
            } else
            {
                obj = String.format("%1$s, %2$s", new Object[] {
                    obj, s1
                });
            }
            dateTimeFinderReservationDetailsTextView.setText(((CharSequence) (obj)));
            dateTimeFinderReservationDetailsTextView.setVisibility(0);
            merchantNameTextView.setText(deal.merchant.name);
            merchantNameTextView.setVisibility(0);
            dealRequiresBooking.setText(0x7f0803cf);
        } else
        {
            setAppointmentViews(computeAppointmentButtonResourceId(false));
            dateTimeFinderReservationDetailsTextView.setVisibility(8);
            merchantNameTextView.setVisibility(0);
        }
        dealRequiresBooking.setVisibility(0);
_L4:
        if (hideMyGroupons)
        {
            myGrouponView.setVisibility(8);
        }
        return;
_L2:
        if (shouldShowGdtOrderNow)
        {
            buttonsContainer.setOrientation(1);
            setupItem(0x7f0801dd, orderFood);
            android.widget.LinearLayout.LayoutParams layoutparams;
            if (currentCountryManager.getCurrentCountry().isSellerOfRecordCountry())
            {
                i = 0x7f080284;
            } else
            {
                i = 0x7f08027e;
            }
            setupItem(i, myGrouponView);
            layoutparams = new android.widget.LinearLayout.LayoutParams(-1, -2);
            myGrouponView.setLayoutParams(layoutparams);
            layoutparams.setMargins(0, 0, 0, getResources().getDimensionPixelSize(0x7f0b011f));
            orderFood.setLayoutParams(layoutparams);
            orderFood.setVisibility(0);
            thankYouSubhead.setVisibility(8);
            thankYouGdtHead.setVisibility(0);
            thankYouGdtSubhead.setVisibility(0);
            myGrouponView.setVisibility(0);
        } else
        if (isBookingUpdates1408USCA && shouldShowRequestAppointment)
        {
            setupItem(0x7f080326, requestAppointmentView);
            requestAppointmentView.setVisibility(0);
            thankYouSubhead.setVisibility(8);
            requestAppointmentMessage.setVisibility(0);
            String s = getString(0x7f08027e);
            setUpTextLink(getString(0x7f080329, new Object[] {
                s
            }), s, requestAppointmentLater);
        } else
        {
            setupItem(0x7f080075, bookNowOrShareView);
            TextView textview = bookNowOrShareView;
            int j;
            if (i != 0)
            {
                j = 0;
            } else
            {
                j = 8;
            }
            textview.setVisibility(j);
            textview = dealRequiresBooking;
            if (i != 0)
            {
                j = 0;
            } else
            {
                j = 8;
            }
            textview.setVisibility(j);
            if (i != 0)
            {
                i = 0x7f080074;
            } else
            if (currentCountryManager.getCurrentCountry().isSellerOfRecordCountry())
            {
                i = 0x7f080284;
            } else
            {
                i = 0x7f08027e;
            }
            setupItem(i, myGrouponView);
            thankYouSubhead.setVisibility(0);
            textview = myGrouponView;
            if (isDealPrePurchaseBooked)
            {
                i = 8;
            } else
            {
                i = 0;
            }
            textview.setVisibility(i);
            if (isDealPrePurchaseBooked)
            {
                setAppointmentViews(0x7f080285);
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void setupUI()
    {
        setupHeader();
        setupItems();
        if (!isMegamindOnThankYouScreenEnabled)
        {
            loadDealBankDeals();
        }
    }

    private void startShippingProcess()
    {
        shippingAddress.setVisibility(8);
        shippingProgress.setVisibility(0);
    }

    private void stopShippingProcess()
    {
        shippingAddress.setVisibility(0);
        shippingProgress.setVisibility(8);
    }

    protected void afterDealListLoaded(List list)
    {
        TextView textview = unlockedDealsTitleNew;
        int i;
        if (list != null && list.size() > 0)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        textview.setVisibility(i);
    }

    protected void afterDealLoaded(Deal deal)
    {
        setDealOption();
        if (isGDT1503USCA && giftingRecord == null && isCurrentOptionDto())
        {
            checkGdtLocations();
            return;
        } else
        {
            setupUI();
            return;
        }
    }

    protected Channel getNavigateToChannelName()
    {
        if (channel != null)
        {
            return channel;
        }
        if (deal != null && !deal.getChannelList().isEmpty())
        {
            return (Channel)deal.getChannelList().iterator().next();
        } else
        {
            return Channel.UNKNOWN;
        }
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if ((10119 == i || 10120 == i) && -1 == j)
        {
            getShippingAddress();
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030211);
        initListHeaderView(0x7f030212);
        if (giftingRecordBundle != null)
        {
            giftingRecord = (GiftingRecord)giftingRecordBundle.getParcelable("giftingRecord");
        }
        if (dateTimeFinderReservationDetailsBundle != null)
        {
            dateTimeFinderReservationDetails = (DateTimeFinderReservationDetails)dateTimeFinderReservationDetailsBundle.getParcelable("reservation_details");
        }
        isBookingUpdates1408USCA = abTestService.isVariantEnabledAndUSCA("bookingUpdates1408USCA", "on");
        isBookingUpdatePreBook1506USCA = abTestService.isVariantEnabledAndUSCA("bookingUpdatesPreBook1506USCA", "on");
        isGDT1503USCA = abTestService.isVariantEnabledAndUSCA("GDT1503USCA", "on");
        isBookingEngineCoachMark1506USCA = abTestService.isVariantEnabledAndUSCA("bookingEngineCoachMark1506USCA", "on");
        if (hidePurchasedDealInfo && cartAbTestHelper.isShoppingCartEnabled())
        {
            shoppingCartService.refreshCachedCart();
        }
        if (dealId != null)
        {
            loadDeal(dealId);
        } else
        {
            hidePurchasedDealInfo = true;
            initMegamindWidgets();
            setupUI();
        }
        shouldShowRequestAppointmentPopup = isBookingEngineCoachMark1506USCA;
        if (bundle != null)
        {
            int i = bundle.getInt("lat", 0x7fffffff);
            int j = bundle.getInt("lng", 0x7fffffff);
            if (i != 0x7fffffff && j != 0x7fffffff)
            {
                setLocation(new GeoPoint(i, j));
            }
            shouldShowRequestAppointmentPopup = bundle.getBoolean("show_request_appointment_popup", false);
        }
        if (location == null)
        {
            bundle = locationService.getLocation();
            if (bundle != null)
            {
                bundle = new GeoPoint((int)(bundle.getLatitude() * 1000000D), (int)(bundle.getLongitude() * 1000000D));
            } else
            {
                bundle = null;
            }
            setLocation(bundle);
        }
        bundle = new GrouponRatingPrompter(this);
        if (showRate && bundle.shouldPrompt())
        {
            bundle.maybeShowPrompt();
            showRate = false;
        } else
        if (showRate && !prefs.getBoolean("hasSeenWidgetDialog", false))
        {
            prefs.edit().putBoolean("hasSeenWidgetDialog", true).apply();
            if (!prefs.getBoolean("widgetHasBeenInstalled", false) && (GrouponDialogFragment)getFragmentManager().findFragmentByTag("rating_add_widget_dialog") == null)
            {
                bundle = dialogManager.getDialogFragment(Integer.valueOf(0x7f080147), Integer.valueOf(0x7f080051), Integer.valueOf(0x7f0804fe), null, true);
                GrouponDialogFragment.show(getFragmentManager(), bundle, "rating_add_widget_dialog");
            }
            showRate = false;
            return;
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        if (isBookingUpdates1408USCA && shouldShowRequestAppointment || dateTimeFinderReservationDetails != null)
        {
            menu.add(0, 0x7f10001d, 0, 0x7f080370).setIcon(0x7f0201f5).setShowAsAction(2);
        }
        return super.onCreateOptionsMenu(menu);
    }

    public void onDialogCancel(String s, DialogInterface dialoginterface)
    {
        if (Strings.equals(s, "rating_dialog"))
        {
            setUserRated();
        }
    }

    public void onDialogItemClick(String s, DialogInterface dialoginterface, int i)
    {
    }

    public void onDialogMultiChoiceItemClick(String s, DialogInterface dialoginterface, int i, boolean flag)
    {
    }

    public void onDialogNegativeButtonClick(String s, DialogInterface dialoginterface)
    {
    }

    public void onDialogPositiveButtonClick(String s, DialogInterface dialoginterface)
    {
        if (Strings.equals(s, "rating_dialog"))
        {
            setUserRated();
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("market://details?id=").append(getPackageName()).toString())));
        }
    }

    public void onDialogShown(String s, DialogInterface dialoginterface)
    {
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        menuitem.getItemId();
        JVM INSTR tableswitch 2131755037 2131755037: default 24
    //                   2131755037 30;
           goto _L1 _L2
_L1:
        return super.onOptionsItemSelected(menuitem);
_L2:
        openShareHelper();
        if (true) goto _L1; else goto _L3
_L3:
    }

    protected void onPause()
    {
        super.onPause();
        if (popupWindow != null && popupWindow.isShowing())
        {
            popupWindow.dismiss();
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (location != null)
        {
            bundle.putInt("lat", location.getLatitudeE6());
            bundle.putInt("lng", location.getLongitudeE6());
        }
        bundle.putBoolean("show_request_appointment_popup", shouldShowRequestAppointmentPopup);
    }

    protected void setDealOption()
    {
label0:
        {
            Object obj = deal.getOptions();
            option = (Option)((ArrayList) (obj)).get(0);
            if (!Strings.notEmpty(optionId))
            {
                break label0;
            }
            obj = ((ArrayList) (obj)).iterator();
            Option option1;
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break label0;
                }
                option1 = (Option)((Iterator) (obj)).next();
            } while (!Strings.equals(option1.remoteId, optionId));
            option = option1;
        }
    }

    protected void setLocation(GeoPoint geopoint)
    {
        this;
        JVM INSTR monitorenter ;
        location = geopoint;
        this;
        JVM INSTR monitorexit ;
        return;
        geopoint;
        throw geopoint;
    }



/*
    static boolean access$002(Thanks thanks, boolean flag)
    {
        thanks.shouldShowGdtOrderNow = flag;
        return flag;
    }

*/







/*
    static String access$402(Thanks thanks, String s)
    {
        thanks.shippingAddressString = s;
        return s;
    }

*/






/*
    static boolean access$802(Thanks thanks, boolean flag)
    {
        thanks.shouldShowRequestAppointmentPopup = flag;
        return flag;
    }

*/



/*
    static PopupWindowAboveView access$902(Thanks thanks, PopupWindowAboveView popupwindowaboveview)
    {
        thanks.popupWindow = popupwindowaboveview;
        return popupwindowaboveview;
    }

*/
}
