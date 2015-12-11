// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.controller.recycleritem;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.groupon.Channel;
import com.groupon.db.models.Deal;
import com.groupon.db.models.Option;
import com.groupon.models.DateTimeFinderReservationDetails;
import com.groupon.models.nst.DealDetailsReservationSectionClickExtraInfo;
import com.groupon.models.nst.DealDetailsReservationSectionImpressionExtraInfo;
import com.groupon.models.nst.JsonEncodedNSTField;
import com.groupon.mvc.model.DateTimeFinderReservation;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.BookingUtil;
import com.groupon.util.Dates;
import com.groupon.util.DealUtils;
import java.util.Date;
import org.restlet.engine.util.InternetUsDateFormat;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.mvc.controller.recycleritem:
//            RecyclerItemViewController

public class DateTimeFinderReservationController extends RecyclerItemViewController
{
    private class ReservationSectionClickListener
        implements android.view.View.OnClickListener
    {

        final DateTimeFinderReservationController this$0;

        public void onClick(View view)
        {
            Logger logger1 = logger;
            String s = channel.name();
            JsonEncodedNSTField jsonencodednstfield = JsonEncodedNSTField.NULL_JSON_NST_FIELD;
            String s1 = dateTimeFinderReservationDetails.searchIntentCategory.toTrackingString();
            if (dateTimeFinderReservationDetails.partialIntent)
            {
                view = "partial";
            } else
            {
                view = "full";
            }
            logger1.logClick("", "reservation_impression", s, jsonencodednstfield, new DealDetailsReservationSectionClickExtraInfo(s1, view));
            view = bookingUtil.createDateTimeFinderSchedulerIntent(dateTimeFinderReservationDetails, deal, option.remoteId, defaultOptionIdForExposedMultiOptions, channel, false, false);
            context.startActivity(view);
        }

        private ReservationSectionClickListener()
        {
            this$0 = DateTimeFinderReservationController.this;
            super();
        }

    }


    public static final String DTF_NST_FULL_INTENT = "full";
    public static final String DTF_NST_PARTIAL_INTENT = "partial";
    private static final String DTF_NST_RESERVATION_IMPRESSION = "reservation_impression";
    public static final String DTF_NST_TYPE_FD = "F&D";
    public static final String DTF_NST_TYPE_HBW = "HBW";
    protected static final String RESERVATION_DATE_FORMAT = "E MMM d";
    protected static final String RESERVATION_TIME_FORMAT = "h:mm a";
    private BookingUtil bookingUtil;
    private Channel channel;
    private DateTimeFinderReservationDetails dateTimeFinderReservationDetails;
    private Deal deal;
    private String defaultOptionIdForExposedMultiOptions;
    private InternetUsDateFormat internetUsDateFormat;
    private Logger logger;
    private Option option;

    public DateTimeFinderReservationController(Context context)
    {
        super(context);
    }

    private String generateDefaultReservationBodyText()
    {
        if (DealUtils.isFoodAndDrinkDeal(deal))
        {
            return context.getString(0x7f080260);
        }
        if (DealUtils.isHealthBeautyWellnessDeal(deal))
        {
            return context.getString(0x7f080261);
        } else
        {
            return "";
        }
    }

    private String generateReservationBodyText()
    {
        if ((dateTimeFinderReservationDetails.partySize > 0 || dateTimeFinderReservationDetails.reservationDate != null) && Strings.equalsIgnoreCase(dateTimeFinderReservationDetails.optionId, option.remoteId))
        {
            String s;
            String s1;
            String s2;
            if (dateTimeFinderReservationDetails.partySize > 0)
            {
                s1 = context.getResources().getQuantityString(0x7f0c0015, dateTimeFinderReservationDetails.partySize, new Object[] {
                    Integer.valueOf(dateTimeFinderReservationDetails.partySize)
                });
            } else
            {
                s1 = "";
            }
            if (dateTimeFinderReservationDetails.reservationDate != null)
            {
                if (Dates.isToday(dateTimeFinderReservationDetails.reservationDate.getTime()))
                {
                    s = context.getString(0x7f0803e0);
                } else
                {
                    s = internetUsDateFormat.format("E MMM d", dateTimeFinderReservationDetails.reservationDate).toString();
                }
            } else
            {
                s = context.getString(0x7f080065);
            }
            if (dateTimeFinderReservationDetails.reservationDate == null || dateTimeFinderReservationDetails.partialIntent)
            {
                s2 = context.getString(0x7f0802b4);
            } else
            {
                s2 = internetUsDateFormat.format("h:mm a", dateTimeFinderReservationDetails.reservationDate).toString();
            }
            if (Strings.notEmpty(s1))
            {
                return String.format("%s, %s, %s", new Object[] {
                    s1, s, s2
                });
            } else
            {
                return String.format("%s, %s", new Object[] {
                    s, s2
                });
            }
        } else
        {
            return generateDefaultReservationBodyText();
        }
    }

    private String generateReservationHeaderText()
    {
        if (DealUtils.isFoodAndDrinkDeal(deal))
        {
            return context.getString(0x7f080445);
        }
        if (DealUtils.isHealthBeautyWellnessDeal(deal))
        {
            return context.getString(0x7f080067);
        } else
        {
            return "";
        }
    }

    private void logViewImpression()
    {
        String s;
        String s1;
        if (DealUtils.isFoodAndDrinkDeal(deal))
        {
            s = "F&D";
        } else
        if (DealUtils.isHealthBeautyWellnessDeal(deal))
        {
            s = "HBW";
        } else
        {
            s = "";
        }
        if (dateTimeFinderReservationDetails.partialIntent)
        {
            s1 = "partial";
        } else
        {
            s1 = "full";
        }
        logger.logImpression("", "reservation_impression", channel.name(), "", new DealDetailsReservationSectionImpressionExtraInfo(s, s1, deal.remoteId, deal.uuid));
    }

    private boolean shouldEnableDateTimeFinder()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (dateTimeFinderReservationDetails != null)
        {
            flag = flag1;
            if (DealUtils.isBookingEngineDeal(deal, false))
            {
                flag = true;
            }
        }
        return flag;
    }

    public android.view.View.OnClickListener getCallback()
    {
        return new ReservationSectionClickListener();
    }

    public volatile Object getCallback()
    {
        return getCallback();
    }

    public void processData()
    {
        if (!shouldEnableDateTimeFinder())
        {
            setState(0);
            return;
        } else
        {
            model = new DateTimeFinderReservation();
            ((DateTimeFinderReservation)model).headerText = generateReservationHeaderText();
            ((DateTimeFinderReservation)model).bodyText = generateReservationBodyText();
            logViewImpression();
            setState(2);
            return;
        }
    }

    public void setChannel(Channel channel1)
    {
        setState(1);
        channel = channel1;
    }

    public void setDateTimeFinderReservationDetails(DateTimeFinderReservationDetails datetimefinderreservationdetails)
    {
        setState(1);
        dateTimeFinderReservationDetails = datetimefinderreservationdetails;
    }

    public void setDeal(Deal deal1)
    {
        setState(1);
        deal = deal1;
    }

    public void setDefaultOptionIdForExposedMultiOptions(String s)
    {
        setState(1);
        defaultOptionIdForExposedMultiOptions = s;
    }

    public void setOption(Option option1)
    {
        setState(1);
        option = option1;
    }







}
