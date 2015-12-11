// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import com.groupon.Channel;
import com.groupon.db.events.DealUpdateEvent;
import com.groupon.db.models.Deal;
import com.groupon.http.Http;
import com.groupon.loader.DealLoader;
import com.groupon.models.BookingDealCalendarData;
import com.groupon.models.GenericAmount;
import com.groupon.models.GetawaysCalendarData;
import com.groupon.models.nst.CalendarMetadata;
import com.groupon.models.nst.PageViewExtraInfo;
import com.groupon.models.travelinventory.BookableDate;
import com.groupon.models.travelinventory.TravelInventoryResponse;
import com.groupon.service.travelinventory.GetTravelInventoryCallBack;
import com.groupon.service.travelinventory.GetTravelInventoryRequest;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.BookingDealCalendarDecorator;
import com.groupon.util.CurrencyFormatter;
import com.groupon.util.GetawaysCalendarCellDecorator;
import com.squareup.timessquare.CalendarCellDecorator;
import com.squareup.timessquare.CalendarPickerView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.codehaus.jackson.map.ObjectMapper;
import org.restlet.engine.util.InternetUsDateFormat;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            CalendarActivity, BookingMetaData, IntentFactory

public class BookingDealCalendarActivity extends CalendarActivity
{

    protected Button availabilityButton;
    protected BookingMetaData booking;
    protected Channel channel;
    protected CurrencyFormatter currencyFormatter;
    protected Deal deal;
    protected String dealId;
    protected TextView grouponPrice;
    protected IntentFactory intentFactory;
    private InternetUsDateFormat internetUsDateFormat;
    private boolean isCalendarViewInitialized;
    protected Logger logger;
    protected ObjectMapper objectMapper;
    protected String optionId;
    protected TextView originalPrice;
    protected ViewGroup priceBuyBar;
    View progress;
    protected boolean redirectToEnterCode;
    protected TextView topBarTextView;

    public BookingDealCalendarActivity()
    {
        booking = new BookingMetaData();
    }

    private void finishWithNoInventoryForOption()
    {
        toastMessage(getString(0x7f0802ab));
        finish();
    }

    private void getInventory()
    {
        Object obj = Calendar.getInstance();
        ((Calendar) (obj)).add(2, 11);
        obj = internetUsDateFormat.format("yyyy-MM-dd", ((Calendar) (obj)).getTime()).toString();
        obj = new GetTravelInventoryRequest(getApplicationContext(), dealId, optionId, ((String) (obj)), new GetTravelInventoryCallBack() {

            final BookingDealCalendarActivity this$0;

            public void onSuccess(TravelInventoryResponse travelinventoryresponse)
                throws Exception
            {
                if (travelinventoryresponse.bookableDateList == null || travelinventoryresponse.bookableDateList.isEmpty())
                {
                    finishWithNoInventoryForOption();
                }
                initCalendarData(travelinventoryresponse.minNights, travelinventoryresponse.maxNights, travelinventoryresponse.bookableDateList);
                initCalendarView();
                showCalendar();
            }

            
            {
                this$0 = BookingDealCalendarActivity.this;
                super();
            }
        });
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd", locale));
        ((GetTravelInventoryRequest) (obj)).setObjectMapper(objectMapper).execute();
    }

    private void hidePriceBar()
    {
        grouponPrice.setText("");
        originalPrice.setText("");
        availabilityButton.setEnabled(false);
        if (priceBuyBar.getVisibility() == 0)
        {
            priceBuyBar.startAnimation(AnimationUtils.loadAnimation(this, 0x7f040010));
        }
        priceBuyBar.setVisibility(8);
    }

    private void initCalendarData(int i, int j, List list)
    {
        calendarData = new BookingDealCalendarData(i, j, list);
    }

    private void initCalendarView()
    {
        logCalendarImpression();
        calendarView = (CalendarPickerView)findViewById(0x7f10010a);
        calendarDecorator = new BookingDealCalendarDecorator((BookingDealCalendarData)calendarData);
        ((BookingDealCalendarDecorator)calendarDecorator).setCurrencyFormatter(currencyFormatter);
        calendarView.setDecorators(Arrays.asList(new CalendarCellDecorator[] {
            calendarDecorator
        }));
        calendarView.init(calendarData.calendarStartDate.getTime(), calendarData.calendarEndDate.getTime(), locale).inMode(com.squareup.timessquare.CalendarPickerView.SelectionMode.RANGE);
        calendarView.setCellClickInterceptor(new com.squareup.timessquare.CalendarPickerView.CellClickInterceptor() {

            final BookingDealCalendarActivity this$0;

            public boolean onCellClicked(Date date)
            {
                if (selectedCheckInDate == null || selectedCheckOutDate != null)
                {
                    date = calendarData.isValidCheckInDate(date);
                } else
                {
                    date = calendarData.isValidCheckOutDate(selectedCheckInDate, date);
                }
                if (date != com.groupon.models.GetawaysCalendarData.CalendarError.NO_ERROR)
                {
                    showErrorMessage(date);
                    return true;
                } else
                {
                    return false;
                }
            }

            
            {
                this$0 = BookingDealCalendarActivity.this;
                super();
            }
        });
        calendarView.setOnDateSelectedListener(new com.squareup.timessquare.CalendarPickerView.OnDateSelectedListener() {

            final BookingDealCalendarActivity this$0;

            public void onDateSelected(Date date)
            {
                if (selectedCheckInDate == null)
                {
                    setCheckInDate(date);
                } else
                if (selectedCheckOutDate == null)
                {
                    setCheckOutDate(date);
                    return;
                }
            }

            public void onDateUnselected(Date date)
            {
                if (selectedCheckOutDate != null)
                {
                    selectedCheckInDate = null;
                    selectedCheckOutDate = null;
                }
                setMinimumStayDates(null);
                ((BookingDealCalendarDecorator)calendarDecorator).setPotentialCheckoutDate(null);
            }

            
            {
                this$0 = BookingDealCalendarActivity.this;
                super();
            }
        });
        isCalendarViewInitialized = true;
        setPreSelectedDates();
        restoreSelectedDates();
    }

    private void logCalendarImpression()
    {
        logger.logCalendarView("", "initialView", dealId, Logger.NULL_NST_FIELD);
        logger.logPageView("", "getaways_booking_cal_page", new PageViewExtraInfo(dealId));
    }

    private void logClearButtonClick()
    {
        logger.logCalendarView("", "clear", dealId, Logger.NULL_NST_FIELD);
    }

    private void logContinueButtonClick()
    {
        CalendarMetadata calendarmetadata = new CalendarMetadata();
        if (checkInDate != null)
        {
            calendarmetadata.calendarBefore = "Yes";
        } else
        {
            calendarmetadata.calendarBefore = "No";
        }
        calendarmetadata.checkInDate = selectedCheckInDate.toString();
        calendarmetadata.checkOutDate = selectedCheckOutDate.toString();
        calendarmetadata.dealId = dealId;
        calendarmetadata.optionUuid = optionId;
        calendarmetadata.dealUuid = deal.uuid;
        logger.logCalendarView("", "selectDate", dealId, Logger.NULL_NST_FIELD);
        logger.logClick("", "BookingCalendar_Continue_click", channel.name(), calendarmetadata);
    }

    private void setMinimumStayDates(List list)
    {
        if (list == null)
        {
            calendarView.clearHighlightedDates();
            calendarDecorator.setMinimumDates(null);
            return;
        } else
        {
            calendarView.highlightDates(list);
            calendarDecorator.setMinimumDates(list);
            return;
        }
    }

    private void showCalendar()
    {
        calendarView.setVisibility(0);
        progress.setVisibility(8);
    }

    private void showPriceBar(Date date, Date date1)
    {
        date1 = ((BookingDealCalendarData)calendarData).calculateTotalPrice(date, date1);
        if (date1 != null)
        {
            originalPrice.setPaintFlags(originalPrice.getPaintFlags() | 0x10);
            TextView textview = originalPrice;
            int i;
            boolean flag;
            boolean flag1;
            if (((BookableDate) (date1)).marketPrice != null)
            {
                date = currencyFormatter.format(((BookableDate) (date1)).marketPrice, true, com.groupon.util.CurrencyFormatter.DecimalStripBehavior.Always);
            } else
            {
                date = "";
            }
            textview.setText(date);
            flag1 = deal.getDisplayOption("discount", true);
            flag = flag1;
            if (((BookableDate) (date1)).marketPrice != null)
            {
                flag = flag1;
                TextView textview1;
                if (((BookableDate) (date1)).price != null)
                {
                    if (flag1 && ((BookableDate) (date1)).price.getAmount() < ((BookableDate) (date1)).marketPrice.getAmount())
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                }
            }
            date = originalPrice;
            if (flag)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            date.setVisibility(i);
            textview1 = grouponPrice;
            if (((BookableDate) (date1)).price != null)
            {
                date = currencyFormatter.format(((BookableDate) (date1)).price, true, com.groupon.util.CurrencyFormatter.DecimalStripBehavior.Always);
            } else
            {
                date = "";
            }
            textview1.setText(date);
            availabilityButton.setEnabled(true);
            if (priceBuyBar.getVisibility() == 8)
            {
                priceBuyBar.startAnimation(AnimationUtils.loadAnimation(this, 0x7f040012));
            }
            priceBuyBar.setVisibility(0);
        }
    }

    private void showTopBarInfo(Date date, Date date1)
    {
        date = getDateString(date, date1);
        if (!Strings.isEmpty(date))
        {
            topBarTextView.setText(date);
        }
    }

    protected void clearSelection()
    {
        super.clearSelection();
        topBarTextView.setText(0x7f080357);
        hidePriceBar();
        resetCalendarView();
        logClearButtonClick();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030042);
        isCalendarViewInitialized = false;
        getLoaderManager().initLoader(0, null, new android.app.LoaderManager.LoaderCallbacks() {

            final BookingDealCalendarActivity this$0;

            public Loader onCreateLoader(int i, Bundle bundle1)
            {
                return new DealLoader(com/groupon/db/models/Deal, com/groupon/db/events/DealUpdateEvent, BookingDealCalendarActivity.this, dealId);
            }

            public void onLoadFinished(Loader loader, Deal deal1)
            {
                deal = deal1;
                getInventory();
            }

            public volatile void onLoadFinished(Loader loader, Object obj)
            {
                onLoadFinished(loader, (Deal)obj);
            }

            public void onLoaderReset(Loader loader)
            {
            }

            
            {
                this$0 = BookingDealCalendarActivity.this;
                super();
            }
        });
        availabilityButton.setOnClickListener(new android.view.View.OnClickListener() {

            final BookingDealCalendarActivity this$0;

            public void onClick(View view)
            {
                if (selectedCheckInDate != null)
                {
                    if (selectedCheckOutDate == null)
                    {
                        selectedCheckOutDate = new Date(selectedCheckInDate.getTime() + (long)calendarData.minimumNights * 0x5265c00L);
                    }
                    logContinueButtonClick();
                    view = Calendar.getInstance();
                    view.setTime(selectedCheckInDate);
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(selectedCheckOutDate);
                    booking.setStartDate(view);
                    booking.setEndDate(calendar);
                    startActivity(intentFactory.newConfirmGetawaysPurchaseIntent(dealId, channel, optionId, booking, redirectToEnterCode));
                }
            }

            
            {
                this$0 = BookingDealCalendarActivity.this;
                super();
            }
        });
    }

    protected void onResume()
    {
        super.onResume();
        if (isCalendarViewInitialized && selectedCheckInDate != null)
        {
            resetCalendarView();
            restoreSelectedDates();
        }
    }

    protected void setCheckInDate(Date date)
    {
        super.setCheckInDate(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int i = calendarData.minimumNights;
        date = new ArrayList();
        for (; i > 0; i--)
        {
            calendar.add(5, 1);
            date.add(calendar.getTime());
        }

        setMinimumStayDates(date);
        calendarDecorator.setSelectedDate(selectedCheckInDate, null);
        ((BookingDealCalendarDecorator)calendarDecorator).setPotentialCheckoutDate(calendar.getTime());
        showTopBarInfo(selectedCheckInDate, calendar.getTime());
        showPriceBar(selectedCheckInDate, calendar.getTime());
    }

    protected void setCheckOutDate(Date date)
    {
        super.setCheckOutDate(date);
        if (selectedCheckInDate.after(selectedCheckOutDate))
        {
            date = selectedCheckInDate;
            selectedCheckInDate = selectedCheckOutDate;
            selectedCheckOutDate = date;
            calendarView.selectDate(selectedCheckOutDate);
        }
        setMinimumStayDates(null);
        calendarDecorator.setSelectedDate(selectedCheckInDate, selectedCheckOutDate);
        ((BookingDealCalendarDecorator)calendarDecorator).setPotentialCheckoutDate(selectedCheckOutDate);
        showTopBarInfo(selectedCheckInDate, selectedCheckOutDate);
        showPriceBar(selectedCheckInDate, selectedCheckOutDate);
    }







}
