// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.loader;

import android.content.Context;
import android.content.Loader;
import android.os.Bundle;
import android.os.SystemClock;
import com.groupon.db.dao.DaoHotel;
import com.groupon.db.dao.DaoMarketRateResult;
import com.groupon.db.events.HotelUpdateEvent;
import com.groupon.db.models.Hotel;
import com.groupon.manager.HotelSyncManager;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.CollectionUtils;
import commonlib.loader.EntityLoader;
import commonlib.loader.event.UpdateEvent;
import java.sql.SQLException;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

public abstract class HotelLoaderCallbacks
    implements android.app.LoaderManager.LoaderCallbacks
{
    private static class HotelLoader extends EntityLoader
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

        public HotelLoader(Class class1, Class class2, Context context1, String s, boolean flag, String s1)
        {
            super(class1, class2, context1);
            RoboGuice.getInjector(context1).injectMembers(this);
            hotelId = s;
            channelId = s1;
            isSearchFlow = flag;
        }
    }


    private String channelId;
    private Context context;
    private String hotelId;
    private HotelSyncManager hotelSyncManager;
    private boolean isSearchFlow;

    public HotelLoaderCallbacks(Context context1, String s, boolean flag, String s1)
    {
        RoboGuice.getInjector(context1).injectMembers(this);
        context = context1;
        hotelId = s;
        channelId = s1;
        isSearchFlow = flag;
        hotelSyncManager.setHotelId(s);
    }

    public Loader onCreateLoader(int i, Bundle bundle)
    {
        return new HotelLoader(com/groupon/db/models/Hotel, com/groupon/db/events/HotelUpdateEvent, context, hotelId, isSearchFlow, channelId);
    }

    public abstract void onHotelLoaded(Hotel hotel);

    public void onLoadFinished(Loader loader, Hotel hotel)
    {
        if (hotelSyncManager.isValid(hotel))
        {
            onHotelLoaded(hotel);
        }
    }

    public volatile void onLoadFinished(Loader loader, Object obj)
    {
        onLoadFinished(loader, (Hotel)obj);
    }

    public void onLoaderReset(Loader loader)
    {
    }
}
