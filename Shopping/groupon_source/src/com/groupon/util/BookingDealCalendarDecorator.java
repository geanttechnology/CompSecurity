// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import com.groupon.models.BookingDealCalendarData;
import com.groupon.models.GetawaysCalendarData;
import com.groupon.models.travelinventory.BookableDate;
import com.squareup.timessquare.CalendarCellView;
import java.util.Date;
import java.util.HashMap;

// Referenced classes of package com.groupon.util:
//            GetawaysCalendarCellDecorator, CurrencyFormatter

public class BookingDealCalendarDecorator extends GetawaysCalendarCellDecorator
{

    private static final float PRICE_TEXT_RELATIVE_SIZE = 0.6F;
    private CurrencyFormatter currencyFormatter;
    private Date potentialCheckoutDate;

    public BookingDealCalendarDecorator(BookingDealCalendarData bookingdealcalendardata)
    {
        super(bookingdealcalendardata);
    }

    public void decorate(CalendarCellView calendarcellview, Date date)
    {
        if (calendarcellview.isCurrentMonth())
        {
            Object obj = new StringBuilder("\n");
            String s;
            if (calendarData != null && calendarData.bookableDateMap.containsKey(Long.valueOf(date.getTime())) && (potentialCheckoutDate == null || potentialCheckoutDate.compareTo(date) != 0))
            {
                com.groupon.models.GenericAmount genericamount = ((BookableDate)calendarData.bookableDateMap.get(Long.valueOf(date.getTime()))).price;
                ((StringBuilder) (obj)).append(currencyFormatter.format(genericamount, currencyFormatter.isUSDCurrency(genericamount), CurrencyFormatter.DecimalStripBehavior.Always));
            } else
            {
                ((StringBuilder) (obj)).append(" ");
            }
            s = Integer.toString(date.getDate());
            obj = new SpannableString((new StringBuilder()).append(s).append(obj).toString());
            ((SpannableString) (obj)).setSpan(new RelativeSizeSpan(0.6F), s.length(), ((SpannableString) (obj)).length(), 17);
            calendarcellview.setText(((CharSequence) (obj)));
        } else
        {
            calendarcellview.setText("");
        }
        super.decorate(calendarcellview, date);
    }

    public void reset()
    {
        super.reset();
        potentialCheckoutDate = null;
    }

    public void setCurrencyFormatter(CurrencyFormatter currencyformatter)
    {
        currencyFormatter = currencyformatter;
    }

    public void setPotentialCheckoutDate(Date date)
    {
        potentialCheckoutDate = date;
    }
}
