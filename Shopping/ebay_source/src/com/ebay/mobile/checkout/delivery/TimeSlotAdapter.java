// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout.delivery;

import android.content.Context;
import android.text.format.DateUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.TextView;
import com.ebay.common.model.local.EbayNowDeliveryTimeSlot;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.ebay.mobile.checkout.delivery:
//            DeliveryDate, DeliverySchedulingActivity

class TimeSlotAdapter extends ArrayAdapter
{
    private static class TimeSlotItemViewHolder
    {

        TextView fee;
        TextView timeSlotLabel;
        RadioButton timeSlotRadioButton;

        private TimeSlotItemViewHolder()
        {
        }

    }


    private final DeliverySchedulingActivity activity;
    private final DeliveryDate deliveryDate;
    private RadioButton selectedTimeSlotRadioButton;

    public TimeSlotAdapter(DeliverySchedulingActivity deliveryschedulingactivity, DeliveryDate deliverydate)
    {
        super(deliveryschedulingactivity, 0x7f0302c0, 0x7f100979, deliverydate.timeSlots);
        deliveryDate = deliverydate;
        activity = deliveryschedulingactivity;
    }

    public long getItemId(int i)
    {
        EbayNowDeliveryTimeSlot ebaynowdeliverytimeslot = (EbayNowDeliveryTimeSlot)getItem(i);
        if (ebaynowdeliverytimeslot != null)
        {
            return (long)ebaynowdeliverytimeslot.serviceType.hashCode();
        } else
        {
            return 0L;
        }
    }

    public int getItemViewType(int i)
    {
        return i >= getCount() - 1 ? 1 : 0;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        Object obj;
label0:
        {
            Context context = getContext();
            String s;
            if (view != null)
            {
                TimeSlotItemViewHolder timeslotitemviewholder = (TimeSlotItemViewHolder)view.getTag();
                viewgroup = view;
                view = timeslotitemviewholder;
            } else
            {
                int j;
                if (i < getCount() - 1)
                {
                    j = 0x7f0302c0;
                } else
                {
                    j = 0x7f0302c1;
                }
                viewgroup = View.inflate(context, j, null);
                view = new TimeSlotItemViewHolder();
                view.timeSlotLabel = (TextView)viewgroup.findViewById(0x7f100978);
                view.timeSlotRadioButton = (RadioButton)viewgroup.findViewById(0x7f100979);
                view.fee = (TextView)viewgroup.findViewById(0x7f1006a7);
                viewgroup.setTag(view);
            }
            obj = (EbayNowDeliveryTimeSlot)deliveryDate.timeSlots.get(i);
            if (((EbayNowDeliveryTimeSlot) (obj)).reservationToken.equals(activity.getSelectedReservationToken()))
            {
                selectedTimeSlotRadioButton = ((TimeSlotItemViewHolder) (view)).timeSlotRadioButton;
                ((TimeSlotItemViewHolder) (view)).timeSlotRadioButton.setChecked(true);
            } else
            {
                ((TimeSlotItemViewHolder) (view)).timeSlotRadioButton.setChecked(false);
            }
            s = DateUtils.formatDateRange(context, ((EbayNowDeliveryTimeSlot) (obj)).start.getTime(), ((EbayNowDeliveryTimeSlot) (obj)).end.getTime(), 2561);
            ((TimeSlotItemViewHolder) (view)).timeSlotLabel.setText(s);
            obj = activity.getDeliveryFee(((EbayNowDeliveryTimeSlot) (obj)).serviceType);
            if (obj != null)
            {
                if (!((CurrencyAmount) (obj)).isZero())
                {
                    break label0;
                }
                ((TimeSlotItemViewHolder) (view)).fee.setText(context.getString(0x7f070421));
            }
            return viewgroup;
        }
        ((TimeSlotItemViewHolder) (view)).fee.setText(EbayCurrencyUtil.formatDisplay(((CurrencyAmount) (obj)), 2));
        return viewgroup;
    }

    public int getViewTypeCount()
    {
        return 2;
    }

    public boolean hasStableIds()
    {
        return false;
    }

    void onClick(View view, int i)
    {
        view = (TimeSlotItemViewHolder)view.getTag();
        if (!((TimeSlotItemViewHolder) (view)).timeSlotRadioButton.isChecked())
        {
            if (selectedTimeSlotRadioButton != null)
            {
                selectedTimeSlotRadioButton.setChecked(false);
            }
            ((TimeSlotItemViewHolder) (view)).timeSlotRadioButton.setChecked(true);
            selectedTimeSlotRadioButton = ((TimeSlotItemViewHolder) (view)).timeSlotRadioButton;
            activity.onTimeSlotSelected(this, i);
        }
    }
}
