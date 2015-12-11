// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.groupon.models.GetawaysCalendarData;
import com.groupon.util.CalendarUtil;
import com.groupon.util.GetawaysCalendarCellDecorator;
import com.squareup.timessquare.CalendarPickerView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

// Referenced classes of package com.groupon.activity:
//            GrouponFragmentActivity

public abstract class CalendarActivity extends GrouponFragmentActivity
{

    protected static final String BUNDLE_KEY_CHECKIN_DATE = "bookingStartDate";
    protected static final String BUNDLE_KEY_CHECKOUT_DATE = "bookingEndDate";
    protected static final long ONE_DAY_IN_MILLISECONDS = 0x5265c00L;
    protected GetawaysCalendarData calendarData;
    protected GetawaysCalendarCellDecorator calendarDecorator;
    protected CalendarPickerView calendarView;
    protected Date checkInDate;
    protected Date checkOutDate;
    protected Locale locale;
    protected Date selectedCheckInDate;
    protected Date selectedCheckOutDate;
    protected Toast toastView;

    public CalendarActivity()
    {
        locale = Locale.getDefault();
    }

    protected void clearSelection()
    {
        selectedCheckInDate = null;
        selectedCheckOutDate = null;
    }

    protected String getDateString(Date date, Date date1)
    {
        if (date == null || date1 == null)
        {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date1);
        SimpleDateFormat simpledateformat = new SimpleDateFormat("MMM d");
        long l = CalendarUtil.nightsBetweenDates(date, date1);
        date = (new StringBuilder()).append(" ").append(getResources().getQuantityString(0x7f0c0013, (int)l)).append(": ").toString();
        if (calendar.get(2) == calendar1.get(2))
        {
            date = (new StringBuilder(String.valueOf(l))).append(date).append(simpledateformat.format(calendar.getTime())).append(" - ").append(calendar1.get(5));
        } else
        {
            date = (new StringBuilder(String.valueOf(l))).append(date).append(simpledateformat.format(calendar.getTime())).append(" - ").append(simpledateformat.format(calendar1.getTime()));
        }
        return date.toString();
    }

    protected void initActionBar(Bundle bundle)
    {
        super.initActionBar(bundle);
        setToolbarTitle(getString(0x7f080359));
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle != null)
        {
            long l = bundle.getLong("bookingStartDate");
            long l1 = bundle.getLong("bookingEndDate");
            if (l != 0L)
            {
                selectedCheckInDate = new Date(l);
                if (l1 != 0L)
                {
                    selectedCheckOutDate = new Date(l1);
                }
            }
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        menu.add(0, 0x7f10000a, 0, 0x7f0800ba).setShowAsAction(2);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        menuitem.getItemId();
        JVM INSTR tableswitch 2131755018 2131755018: default 24
    //                   2131755018 30;
           goto _L1 _L2
_L1:
        return super.onOptionsItemSelected(menuitem);
_L2:
        clearSelection();
        if (true) goto _L1; else goto _L3
_L3:
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (selectedCheckInDate != null)
        {
            bundle.putLong("bookingStartDate", selectedCheckInDate.getTime());
            if (selectedCheckOutDate != null)
            {
                bundle.putLong("bookingEndDate", selectedCheckOutDate.getTime());
            }
        }
    }

    protected void resetCalendarView()
    {
        if (calendarDecorator == null)
        {
            return;
        } else
        {
            calendarDecorator.reset();
            calendarView.init(calendarData.calendarStartDate.getTime(), calendarData.calendarEndDate.getTime()).inMode(com.squareup.timessquare.CalendarPickerView.SelectionMode.RANGE);
            return;
        }
    }

    protected void restoreSelectedDates()
    {
        if (selectedCheckInDate != null)
        {
            calendarView.selectDate(selectedCheckInDate);
            setCheckInDate((Date)selectedCheckInDate.clone());
            if (selectedCheckOutDate != null)
            {
                calendarView.selectDate(selectedCheckOutDate);
                setCheckOutDate((Date)selectedCheckOutDate.clone());
            }
            return;
        } else
        {
            selectedCheckOutDate = null;
            return;
        }
    }

    protected void setCheckInDate(Date date)
    {
        selectedCheckInDate = CalendarUtil.getDateWithoutHour(date);
    }

    protected void setCheckOutDate(Date date)
    {
        selectedCheckOutDate = CalendarUtil.getDateWithoutHour(date);
    }

    protected void setPreSelectedDates()
    {
        if (selectedCheckInDate == null && checkInDate != null && checkOutDate != null && checkInDate.before(checkOutDate) && calendarData.isValidCheckInDate(CalendarUtil.getDateWithoutHour(checkInDate)) == com.groupon.models.GetawaysCalendarData.CalendarError.NO_ERROR && calendarData.isValidCheckOutDate(CalendarUtil.getDateWithoutHour(checkInDate), CalendarUtil.getDateWithoutHour(checkOutDate)) == com.groupon.models.GetawaysCalendarData.CalendarError.NO_ERROR)
        {
            selectedCheckInDate = checkInDate;
            selectedCheckOutDate = checkOutDate;
        }
    }

    protected void showErrorMessage(com.groupon.models.GetawaysCalendarData.CalendarError calendarerror)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$groupon$models$GetawaysCalendarData$CalendarError[];

            static 
            {
                $SwitchMap$com$groupon$models$GetawaysCalendarData$CalendarError = new int[com.groupon.models.GetawaysCalendarData.CalendarError.values().length];
                try
                {
                    $SwitchMap$com$groupon$models$GetawaysCalendarData$CalendarError[com.groupon.models.GetawaysCalendarData.CalendarError.INVALID_DATE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$groupon$models$GetawaysCalendarData$CalendarError[com.groupon.models.GetawaysCalendarData.CalendarError.MINIMUM_NIGHTS.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$groupon$models$GetawaysCalendarData$CalendarError[com.groupon.models.GetawaysCalendarData.CalendarError.MAXIMUM_NIGHTS.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$groupon$models$GetawaysCalendarData$CalendarError[com.groupon.models.GetawaysCalendarData.CalendarError.OUT_RANGE.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$groupon$models$GetawaysCalendarData$CalendarError[com.groupon.models.GetawaysCalendarData.CalendarError.CONTAIN_BLACKOUT_DAYS.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.groupon.models.GetawaysCalendarData.CalendarError[calendarerror.ordinal()];
        JVM INSTR tableswitch 1 5: default 44
    //                   1 58
    //                   2 69
    //                   3 97
    //                   4 125
    //                   5 125;
           goto _L1 _L2 _L3 _L4 _L5 _L5
_L1:
        calendarerror = getString(0x7f080532);
_L7:
        toastMessage(calendarerror);
        return;
_L2:
        calendarerror = getString(0x7f0802b7);
        continue; /* Loop/switch isn't completed */
_L3:
        calendarerror = getString(0x7f0804ef, new Object[] {
            Integer.valueOf(calendarData.minimumNights)
        });
        continue; /* Loop/switch isn't completed */
_L4:
        calendarerror = getString(0x7f0804ee, new Object[] {
            Integer.valueOf(calendarData.maximumNights)
        });
        continue; /* Loop/switch isn't completed */
_L5:
        calendarerror = getString(0x7f0804d0);
        if (true) goto _L7; else goto _L6
_L6:
    }

    protected void toastMessage(String s)
    {
        if (toastView != null)
        {
            toastView.cancel();
        }
        toastView = Toast.makeText(getApplicationContext(), s, 0);
        toastView.show();
    }
}
