// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.groupon.models.GenericAmount;
import com.groupon.models.RoomDetails;
import com.groupon.models.RoomPrice;
import com.groupon.models.hotel.HotelRoom;
import com.groupon.util.CurrencyFormatter;
import com.groupon.util.MarketRateUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RoomsAdapter extends BaseAdapter
{
    private static class RoomViewHolder
    {

        public TextView description;
        public TextView price;
        public TextView title;

        private RoomViewHolder()
        {
        }

    }


    private final CurrencyFormatter currencyFormatter;
    private final List data;
    private final LayoutInflater inflater;

    public RoomsAdapter(Context context, List list, CurrencyFormatter currencyformatter)
    {
        data = list;
        currencyFormatter = currencyformatter;
        inflater = LayoutInflater.from(context);
    }

    private String generateFormattedPrice(int i, String s)
    {
        GenericAmount genericamount = new GenericAmount();
        genericamount.setAmount(i);
        genericamount.setCurrencyCode(s);
        return currencyFormatter.format(genericamount, true, com.groupon.util.CurrencyFormatter.DecimalStripBehavior.Never);
    }

    public int getCount()
    {
        if (data != null)
        {
            return data.size();
        } else
        {
            return 0;
        }
    }

    public HotelRoom getItem(int i)
    {
        if (data != null)
        {
            return (HotelRoom)data.get(i);
        } else
        {
            return null;
        }
    }

    public volatile Object getItem(int i)
    {
        return getItem(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        HotelRoom hotelroom;
        if (view == null)
        {
            view = inflater.inflate(0x7f0301de, viewgroup, false);
            viewgroup = new RoomViewHolder();
            viewgroup.title = (TextView)view.findViewById(0x7f10007a);
            viewgroup.price = (TextView)view.findViewById(0x7f100192);
            viewgroup.description = (TextView)view.findViewById(0x7f10050a);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (RoomViewHolder)view.getTag();
        }
        hotelroom = getItem(i);
        if (hotelroom != null)
        {
            ArrayList arraylist = new ArrayList();
            String s = null;
            Object obj = hotelroom.prices.iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                RoomPrice roomprice = (RoomPrice)((Iterator) (obj)).next();
                arraylist.add(Integer.valueOf(roomprice.net));
                if (s == null)
                {
                    s = roomprice.currencyCode;
                }
            } while (true);
            obj = hotelroom.details;
            if (((List) (obj)).size() > 0 && ((List) (obj)).get(0) != null && ((RoomDetails)((List) (obj)).get(0)).description != null)
            {
                obj = ((RoomDetails)((List) (obj)).get(0)).description;
            } else
            {
                obj = "";
            }
            ((RoomViewHolder) (viewgroup)).title.setText(hotelroom.title);
            ((RoomViewHolder) (viewgroup)).price.setText(generateFormattedPrice(MarketRateUtil.getAverageRoomRate(arraylist), s));
            ((RoomViewHolder) (viewgroup)).description.setText(Html.fromHtml(((String) (obj))));
        }
        return view;
    }
}
