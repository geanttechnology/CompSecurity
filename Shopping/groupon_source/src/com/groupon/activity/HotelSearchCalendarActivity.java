// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import com.groupon.models.GetawaysCalendarData;
import com.groupon.models.hotel.HotelSearchCalendarData;
import com.groupon.tracking.mobile.EncodedNSTField;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.GetawaysCalendarCellDecorator;
import com.groupon.util.HotelSearchCalendarDecorator;
import com.squareup.timessquare.CalendarCellDecorator;
import com.squareup.timessquare.CalendarPickerView;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            CalendarActivity

public class HotelSearchCalendarActivity extends CalendarActivity
{

    public static final int RESULT_DATES_CHANGED = 1;
    protected Button confirmSelectedButton;
    protected ViewGroup confirmSelectedDateBar;
    private EncodedNSTField logMetaData;
    protected TextView topBarTextView;

    public HotelSearchCalendarActivity()
    {
        logMetaData = new EncodedNSTField() {

            final HotelSearchCalendarActivity this$0;

            public String toEncodedString()
            {
                return "getaways";
            }

            
            {
                this$0 = HotelSearchCalendarActivity.this;
                super();
            }
        };
    }

    private static Intent createResultData(Date date, Date date1)
    {
        Intent intent = new Intent();
        intent.putExtra("check_in_date", date);
        intent.putExtra("check_out_date", date1);
        return intent;
    }

    private void hideConfirmDateBar()
    {
        if (confirmSelectedDateBar.getVisibility() == 0)
        {
            confirmSelectedDateBar.startAnimation(AnimationUtils.loadAnimation(this, 0x7f040010));
        }
        confirmSelectedDateBar.setVisibility(8);
    }

    private void initCalendarData()
    {
        calendarData = new HotelSearchCalendarData();
    }

    private void initCalendarView()
    {
        logCalendarViewImpression();
        calendarView = (CalendarPickerView)findViewById(0x7f10010a);
        calendarDecorator = new HotelSearchCalendarDecorator((HotelSearchCalendarData)calendarData);
        calendarView.setDecorators(Arrays.asList(new CalendarCellDecorator[] {
            calendarDecorator
        }));
        calendarView.init(calendarData.calendarStartDate.getTime(), calendarData.calendarEndDate.getTime()).inMode(com.squareup.timessquare.CalendarPickerView.SelectionMode.RANGE);
        calendarView.setCellClickInterceptor(new com.squareup.timessquare.CalendarPickerView.CellClickInterceptor() {

            final HotelSearchCalendarActivity this$0;

            public boolean onCellClicked(Date date)
            {
                com.groupon.models.GetawaysCalendarData.CalendarError calendarerror;
                if (selectedCheckInDate == null || selectedCheckOutDate != null)
                {
                    calendarerror = calendarData.isValidCheckInDate(date);
                } else
                {
                    calendarerror = calendarData.isValidCheckOutDate(selectedCheckInDate, date);
                }
                if (calendarerror == com.groupon.models.GetawaysCalendarData.CalendarError.MAXIMUM_NIGHTS)
                {
                    date = ((HotelSearchCalendarData)calendarData).getActualMaximumCheckOutDate(selectedCheckInDate, date);
                    if (date != null)
                    {
                        calendarView.selectDate(date);
                        setCheckOutDate(date);
                    }
                }
                if (calendarerror != com.groupon.models.GetawaysCalendarData.CalendarError.NO_ERROR)
                {
                    showErrorMessage(calendarerror);
                    return true;
                } else
                {
                    return false;
                }
            }

            
            {
                this$0 = HotelSearchCalendarActivity.this;
                super();
            }
        });
        calendarView.setOnDateSelectedListener(new com.squareup.timessquare.CalendarPickerView.OnDateSelectedListener() {

            final HotelSearchCalendarActivity this$0;

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
            }

            
            {
                this$0 = HotelSearchCalendarActivity.this;
                super();
            }
        });
        setPreSelectedDates();
        restoreSelectedDates();
    }

    private void logCalendarViewImpression()
    {
        logger.logClick("", "select_dates_box_click", "market_rate", logMetaData);
        logger.logPageView("", "getaways_hotel_search_cal_page", Logger.NULL_NST_FIELD);
    }

    private void logConfirmButtonClick()
    {
        logger.logClick("", "date_done_click", "market_rate", logMetaData);
    }

    public static Intent newIntent(Context context, Date date, Date date1)
    {
        context = new Intent(context, com/groupon/activity/HotelSearchCalendarActivity);
        context.putExtra("check_in_date", date);
        context.putExtra("check_out_date", date1);
        return context;
    }

    public static Pair parseResultData(Intent intent)
    {
        Date date;
        if (intent.hasExtra("check_in_date"))
        {
            date = (Date)intent.getSerializableExtra("check_in_date");
        } else
        {
            date = null;
        }
        if (intent.hasExtra("check_out_date"))
        {
            intent = (Date)intent.getSerializableExtra("check_out_date");
        } else
        {
            intent = null;
        }
        return new Pair(date, intent);
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

    private void showConfirmDateBar()
    {
        if (confirmSelectedDateBar.getVisibility() == 8)
        {
            confirmSelectedDateBar.startAnimation(AnimationUtils.loadAnimation(this, 0x7f040012));
        }
        confirmSelectedDateBar.setVisibility(0);
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
        hideConfirmDateBar();
        resetCalendarView();
        setResult(1, createResultData(null, null));
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03013b);
        confirmSelectedButton.setOnClickListener(new android.view.View.OnClickListener() {

            final HotelSearchCalendarActivity this$0;

            public void onClick(View view)
            {
                if (selectedCheckInDate != null)
                {
                    if (selectedCheckOutDate == null)
                    {
                        view = Calendar.getInstance();
                        view.setTime(selectedCheckInDate);
                        view.add(5, 1);
                        selectedCheckOutDate = view.getTime();
                    }
                    logConfirmButtonClick();
                    setResult(1, HotelSearchCalendarActivity.createResultData(selectedCheckInDate, selectedCheckOutDate));
                }
                finish();
            }

            
            {
                this$0 = HotelSearchCalendarActivity.this;
                super();
            }
        });
        initCalendarData();
        initCalendarView();
    }

    protected void setCheckInDate(Date date)
    {
        super.setCheckInDate(date);
        date = Calendar.getInstance();
        date.setTime(selectedCheckInDate);
        date.add(5, 1);
        setMinimumStayDates(Collections.singletonList(date.getTime()));
        calendarDecorator.setSelectedDate(selectedCheckInDate, null);
        showTopBarInfo(selectedCheckInDate, date.getTime());
        showConfirmDateBar();
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
        showTopBarInfo(selectedCheckInDate, selectedCheckOutDate);
        showConfirmDateBar();
    }



}
