// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.groupon.util.GrouponNavigationDrawerActivity;
import com.groupon.view.DealDetailsTemporaryImage;
import com.groupon.view.DealImageView;
import com.groupon.view.MapSliceRedesign;
import com.groupon.view.SpinnerButton;
import com.groupon.view.TripAdvisorReviewSection;

// Referenced classes of package com.groupon.activity:
//            HotelDetails, GrouponFragmentActivity

public class ty extends ViewBinder
{

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponFragmentActivity grouponfragmentactivity, Object obj)
    {
        bind(ewbinder, (HotelDetails)grouponfragmentactivity, obj);
    }

    public void bind(butterknife.ewBinder ewbinder, HotelDetails hoteldetails, Object obj)
    {
        super.bind(ewbinder, hoteldetails, obj);
        hoteldetails.toolbar = (Toolbar)ewbinder.ew((View)ewbinder.quiredView(obj, 0x7f100180, "field 'toolbar'"), 0x7f100180, "field 'toolbar'");
        hoteldetails.contentView = (View)ewbinder.quiredView(obj, 0x7f100132, "field 'contentView'");
        hoteldetails.progress = (View)ewbinder.quiredView(obj, 0x7f10010b, "field 'progress'");
        hoteldetails.hotelTitle = (TextView)ewbinder.ew((View)ewbinder.quiredView(obj, 0x7f100386, "field 'hotelTitle'"), 0x7f100386, "field 'hotelTitle'");
        hoteldetails.hotelLocation = (TextView)ewbinder.ew((View)ewbinder.quiredView(obj, 0x7f100387, "field 'hotelLocation'"), 0x7f100387, "field 'hotelLocation'");
        hoteldetails.priceContainer = (View)ewbinder.quiredView(obj, 0x7f1002d5, "field 'priceContainer'");
        hoteldetails.price = (TextView)ewbinder.ew((View)ewbinder.quiredView(obj, 0x7f100192, "field 'price'"), 0x7f100192, "field 'price'");
        hoteldetails.strikePrice = (TextView)ewbinder.ew((View)ewbinder.quiredView(obj, 0x7f10038a, "field 'strikePrice'"), 0x7f10038a, "field 'strikePrice'");
        hoteldetails.gBucksContainer = (View)ewbinder.quiredView(obj, 0x7f10038d, "field 'gBucksContainer'");
        hoteldetails.gBucksValue = (TextView)ewbinder.ew((View)ewbinder.quiredView(obj, 0x7f100393, "field 'gBucksValue'"), 0x7f100393, "field 'gBucksValue'");
        hoteldetails.selectGuests = (View)ewbinder.quiredView(obj, 0x7f100396, "field 'selectGuests'");
        hoteldetails.disabledSelectGuests = (View)ewbinder.quiredView(obj, 0x7f10039a, "field 'disabledSelectGuests'");
        hoteldetails.bookingDateContainer = (View)ewbinder.quiredView(obj, 0x7f10039c, "field 'bookingDateContainer'");
        hoteldetails.bookingDateText = (TextView)ewbinder.ew((View)ewbinder.quiredView(obj, 0x7f10039d, "field 'bookingDateText'"), 0x7f10039d, "field 'bookingDateText'");
        hoteldetails.disabledGuestsSelectorText = (TextView)ewbinder.ew((View)ewbinder.quiredView(obj, 0x7f10039b, "field 'disabledGuestsSelectorText'"), 0x7f10039b, "field 'disabledGuestsSelectorText'");
        hoteldetails.guestsSelectorText = (TextView)ewbinder.ew((View)ewbinder.quiredView(obj, 0x7f100399, "field 'guestsSelectorText'"), 0x7f100399, "field 'guestsSelectorText'");
        hoteldetails.submitButtonMask = (TextView)ewbinder.ew((View)ewbinder.quiredView(obj, 0x7f100398, "field 'submitButtonMask'"), 0x7f100398, "field 'submitButtonMask'");
        hoteldetails.aboutContainer = (View)ewbinder.quiredView(obj, 0x7f1003a1, "field 'aboutContainer'");
        hoteldetails.amenitiesContainer = (View)ewbinder.quiredView(obj, 0x7f1003a4, "field 'amenitiesContainer'");
        hoteldetails.aboutTitle = (TextView)ewbinder.ew((View)ewbinder.quiredView(obj, 0x7f1003a2, "field 'aboutTitle'"), 0x7f1003a2, "field 'aboutTitle'");
        hoteldetails.aboutWebView = (WebView)ewbinder.ew((View)ewbinder.quiredView(obj, 0x7f1003a3, "field 'aboutWebView'"), 0x7f1003a3, "field 'aboutWebView'");
        hoteldetails.amenitiesView = (TextView)ewbinder.ew((View)ewbinder.quiredView(obj, 0x7f1003a5, "field 'amenitiesView'"), 0x7f1003a5, "field 'amenitiesView'");
        hoteldetails.mapSlice = (MapSliceRedesign)ewbinder.ew((View)ewbinder.quiredView(obj, 0x7f10013f, "field 'mapSlice'"), 0x7f10013f, "field 'mapSlice'");
        hoteldetails.finePrintContainer = (View)ewbinder.quiredView(obj, 0x7f1003a6, "field 'finePrintContainer'");
        hoteldetails.roomRateDisclaimer = (TextView)ewbinder.ew((View)ewbinder.quiredView(obj, 0x7f1003a7, "field 'roomRateDisclaimer'"), 0x7f1003a7, "field 'roomRateDisclaimer'");
        hoteldetails.bucksDisclaimer = (TextView)ewbinder.ew((View)ewbinder.quiredView(obj, 0x7f1003a8, "field 'bucksDisclaimer'"), 0x7f1003a8, "field 'bucksDisclaimer'");
        hoteldetails.submitButton = (SpinnerButton)ewbinder.ew((View)ewbinder.quiredView(obj, 0x7f100102, "field 'submitButton'"), 0x7f100102, "field 'submitButton'");
        hoteldetails.roomContainer = (LinearLayout)ewbinder.ew((View)ewbinder.quiredView(obj, 0x7f10039e, "field 'roomContainer'"), 0x7f10039e, "field 'roomContainer'");
        hoteldetails.roomTitle = (TextView)ewbinder.ew((View)ewbinder.quiredView(obj, 0x7f10039f, "field 'roomTitle'"), 0x7f10039f, "field 'roomTitle'");
        hoteldetails.roomDescription = (TextView)ewbinder.ew((View)ewbinder.quiredView(obj, 0x7f1003a0, "field 'roomDescription'"), 0x7f1003a0, "field 'roomDescription'");
        hoteldetails.lastMinuteInfo = (View)ewbinder.quiredView(obj, 0x7f100390, "field 'lastMinuteInfo'");
        hoteldetails.lastMinuteDiscountLabel = (TextView)ewbinder.ew((View)ewbinder.quiredView(obj, 0x7f100271, "field 'lastMinuteDiscountLabel'"), 0x7f100271, "field 'lastMinuteDiscountLabel'");
        hoteldetails.dealImageView = (DealImageView)ewbinder.ew((View)ewbinder.quiredView(obj, 0x7f1001df, "field 'dealImageView'"), 0x7f1001df, "field 'dealImageView'");
        hoteldetails.scrollableContent = (View)ewbinder.quiredView(obj, 0x7f1000da, "field 'scrollableContent'");
        hoteldetails.dealImageContainer = (View)ewbinder.quiredView(obj, 0x7f100222, "field 'dealImageContainer'");
        hoteldetails.raoCheckButton = (SpinnerButton)ewbinder.ew((View)ewbinder.quiredView(obj, 0x7f1003af, "field 'raoCheckButton'"), 0x7f1003af, "field 'raoCheckButton'");
        hoteldetails.raoUnlockingTimerContainer = (View)ewbinder.quiredView(obj, 0x7f1003b0, "field 'raoUnlockingTimerContainer'");
        hoteldetails.raoUnlockingTimerProgressBar = (ProgressBar)ewbinder.ew((View)ewbinder.quiredView(obj, 0x7f1003b1, "field 'raoUnlockingTimerProgressBar'"), 0x7f1003b1, "field 'raoUnlockingTimerProgressBar'");
        hoteldetails.raoUnlockingTimerText = (TextView)ewbinder.ew((View)ewbinder.quiredView(obj, 0x7f1003b2, "field 'raoUnlockingTimerText'"), 0x7f1003b2, "field 'raoUnlockingTimerText'");
        hoteldetails.raoPriceContainer = (View)ewbinder.quiredView(obj, 0x7f1003aa, "field 'raoPriceContainer'");
        hoteldetails.raoStrikePrice = (TextView)ewbinder.ew((View)ewbinder.quiredView(obj, 0x7f1003ac, "field 'raoStrikePrice'"), 0x7f1003ac, "field 'raoStrikePrice'");
        hoteldetails.raoPrice = (TextView)ewbinder.ew((View)ewbinder.quiredView(obj, 0x7f1003ad, "field 'raoPrice'"), 0x7f1003ad, "field 'raoPrice'");
        hoteldetails.raoExpireTime = (TextView)ewbinder.ew((View)ewbinder.quiredView(obj, 0x7f1003ae, "field 'raoExpireTime'"), 0x7f1003ae, "field 'raoExpireTime'");
        hoteldetails.raoOfferInfo = (View)ewbinder.quiredView(obj, 0x7f10038c, "field 'raoOfferInfo'");
        hoteldetails.raoDiscountLabel = (TextView)ewbinder.ew((View)ewbinder.quiredView(obj, 0x7f10038f, "field 'raoDiscountLabel'"), 0x7f10038f, "field 'raoDiscountLabel'");
        hoteldetails.bottomBar = (View)ewbinder.quiredView(obj, 0x7f1000a0, "field 'bottomBar'");
        hoteldetails.detailsTopContainer = (View)ewbinder.quiredView(obj, 0x7f100384, "field 'detailsTopContainer'");
        hoteldetails.detailsMainContainer = (View)ewbinder.quiredView(obj, 0x7f100394, "field 'detailsMainContainer'");
        hoteldetails.temporaryDealImageView = (DealDetailsTemporaryImage)ewbinder.ew((View)ewbinder.quiredView(obj, 0x7f100385, "field 'temporaryDealImageView'"), 0x7f100385, "field 'temporaryDealImageView'");
        hoteldetails.tripAdvisorSection = (TripAdvisorReviewSection)ewbinder.ew((View)ewbinder.quiredView(obj, 0x7f100395, "field 'tripAdvisorSection'"), 0x7f100395, "field 'tripAdvisorSection'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponNavigationDrawerActivity grouponnavigationdraweractivity, Object obj)
    {
        bind(ewbinder, (HotelDetails)grouponnavigationdraweractivity, obj);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (HotelDetails)obj, obj1);
    }

    public volatile void unbind(GrouponFragmentActivity grouponfragmentactivity)
    {
        unbind((HotelDetails)grouponfragmentactivity);
    }

    public void unbind(HotelDetails hoteldetails)
    {
        super.unbind(hoteldetails);
        hoteldetails.toolbar = null;
        hoteldetails.contentView = null;
        hoteldetails.progress = null;
        hoteldetails.hotelTitle = null;
        hoteldetails.hotelLocation = null;
        hoteldetails.priceContainer = null;
        hoteldetails.price = null;
        hoteldetails.strikePrice = null;
        hoteldetails.gBucksContainer = null;
        hoteldetails.gBucksValue = null;
        hoteldetails.selectGuests = null;
        hoteldetails.disabledSelectGuests = null;
        hoteldetails.bookingDateContainer = null;
        hoteldetails.bookingDateText = null;
        hoteldetails.disabledGuestsSelectorText = null;
        hoteldetails.guestsSelectorText = null;
        hoteldetails.submitButtonMask = null;
        hoteldetails.aboutContainer = null;
        hoteldetails.amenitiesContainer = null;
        hoteldetails.aboutTitle = null;
        hoteldetails.aboutWebView = null;
        hoteldetails.amenitiesView = null;
        hoteldetails.mapSlice = null;
        hoteldetails.finePrintContainer = null;
        hoteldetails.roomRateDisclaimer = null;
        hoteldetails.bucksDisclaimer = null;
        hoteldetails.submitButton = null;
        hoteldetails.roomContainer = null;
        hoteldetails.roomTitle = null;
        hoteldetails.roomDescription = null;
        hoteldetails.lastMinuteInfo = null;
        hoteldetails.lastMinuteDiscountLabel = null;
        hoteldetails.dealImageView = null;
        hoteldetails.scrollableContent = null;
        hoteldetails.dealImageContainer = null;
        hoteldetails.raoCheckButton = null;
        hoteldetails.raoUnlockingTimerContainer = null;
        hoteldetails.raoUnlockingTimerProgressBar = null;
        hoteldetails.raoUnlockingTimerText = null;
        hoteldetails.raoPriceContainer = null;
        hoteldetails.raoStrikePrice = null;
        hoteldetails.raoPrice = null;
        hoteldetails.raoExpireTime = null;
        hoteldetails.raoOfferInfo = null;
        hoteldetails.raoDiscountLabel = null;
        hoteldetails.bottomBar = null;
        hoteldetails.detailsTopContainer = null;
        hoteldetails.detailsMainContainer = null;
        hoteldetails.temporaryDealImageView = null;
        hoteldetails.tripAdvisorSection = null;
    }

    public volatile void unbind(GrouponNavigationDrawerActivity grouponnavigationdraweractivity)
    {
        unbind((HotelDetails)grouponnavigationdraweractivity);
    }

    public volatile void unbind(Object obj)
    {
        unbind((HotelDetails)obj);
    }

    public ty()
    {
    }
}
