// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.loader;

import android.content.Context;
import android.os.SystemClock;
import com.groupon.db.dao.DaoHotel;
import com.groupon.db.dao.DaoMarketRateResult;
import com.groupon.db.events.HotelUpdateEvent;
import com.groupon.db.models.Hotel;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.CollectionUtils;
import commonlib.loader.EntityLoader;
import commonlib.loader.event.UpdateEvent;
import java.sql.SQLException;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

// Referenced classes of package com.groupon.loader:
//            HotelLoaderCallbacks

private static class isSearchFlow extends EntityLoader
{

    private static final String ACTION_LOAD_HOTEL_FROM_DB = "load_hotel_from_db";
    private String channelId;
    private DaoHotel hotelDao;
    private String hotelId;
    private boolean isSearchFlow;
    private Logger logger;
    private DaoMarketRateResult marketrateResultDao;

    public Hotel loadInBackground()
    {
        Hotel hotel;
        String s;
        DaoMarketRateResult daomarketrateresult;
        String s1;
        long l;
        long l1;
        try
        {
            l = SystemClock.elapsedRealtime();
            hotel = (Hotel)CollectionUtils.getFirstItem(hotelDao.queryForEq("remoteId", hotelId), null);
        }
        catch (SQLException sqlexception)
        {
            throw new RuntimeException(sqlexception);
        }
        if (hotel == null)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        daomarketrateresult = marketrateResultDao;
        s1 = hotelId;
        if (!isSearchFlow)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        s = channelId;
_L1:
        hotel.marketRateResult = daomarketrateresult.getByIdAndChannelId(s1, s);
        l1 = SystemClock.elapsedRealtime();
        logger.logGeneralEvent("hotel_performance", "load_hotel_from_db", hotel.uuid, (int)(l1 - l), Logger.NULL_NST_FIELD);
        return hotel;
        s = "HOTELS";
          goto _L1
        return hotel;
    }

    public volatile Object loadInBackground()
    {
        return loadInBackground();
    }

    protected boolean shouldReload(HotelUpdateEvent hotelupdateevent)
    {
        return hotelupdateevent.getHotelId().equalsIgnoreCase(hotelId);
    }

    protected volatile boolean shouldReload(UpdateEvent updateevent)
    {
        return shouldReload((HotelUpdateEvent)updateevent);
    }

    public _cls9(Class class1, Class class2, Context context, String s, boolean flag, String s1)
    {
        super(class1, class2, context);
        RoboGuice.getInjector(context).injectMembers(this);
        hotelId = s;
        channelId = s1;
        isSearchFlow = flag;
    }
}
