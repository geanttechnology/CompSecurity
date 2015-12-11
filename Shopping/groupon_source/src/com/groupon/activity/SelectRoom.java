// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.groupon.Channel;
import com.groupon.adapter.RoomsAdapter;
import com.groupon.models.RoomCustomField;
import com.groupon.models.hotel.HotelRoom;
import com.groupon.service.marketrate.HotelsService;
import com.groupon.util.CurrencyFormatter;
import com.groupon.util.LoginUtil;
import java.util.List;

// Referenced classes of package com.groupon.activity:
//            GrouponActivity, BookingMetaData

public class SelectRoom extends GrouponActivity
{

    List availableHotelRooms;
    private List availableRooms;
    BookingMetaData bookingMetaData;
    Channel channel;
    private CurrencyFormatter currencyFormatter;
    String gBucksDisclaimer;
    String hotelId;
    String hotelImageUrl;
    String hotelLocation;
    String hotelName;
    private HotelsService hotelsService;
    private LoginUtil loginUtil;
    String productType;
    private RoomsAdapter roomsAdapter;
    ListView roomsListView;

    public SelectRoom()
    {
    }

    private void setupAdapter()
    {
        roomsAdapter = new RoomsAdapter(getApplicationContext(), availableRooms, currencyFormatter);
        roomsListView.setAdapter(roomsAdapter);
    }

    private void setupListener()
    {
        roomsListView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final SelectRoom this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = roomsAdapter.getItem(i);
                loginUtil.startMarketRateReservationFlow(((RoomCustomField)((HotelRoom) (adapterview)).customFields.get(0)).roomToken, hotelName, hotelLocation, hotelImageUrl, gBucksDisclaimer, channel, hotelId, bookingMetaData, productType);
            }

            
            {
                this$0 = SelectRoom.this;
                super();
            }
        });
    }

    protected void initActionBar(Bundle bundle)
    {
        super.initActionBar(bundle);
        setDisplayToolbarTitle(false);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0301ea);
        availableRooms = hotelsService.mapHotelInventory(availableHotelRooms);
        setupAdapter();
        setupListener();
    }


}
