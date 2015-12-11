// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.espn.androidplayersdk.datamanager;

import android.database.Cursor;
import com.espn.androidplayersdk.listenerinterface.SearchCallback;
import com.espn.androidplayersdk.objects.EPChannels;
import com.espn.androidplayersdk.utilities.EPEventType;
import com.espn.androidplayersdk.utilities.Utils;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.espn.androidplayersdk.datamanager:
//            EPEvents, RefreshFeedsThread, EPSport, DataManager, 
//            FeedsDB, EventByIdRequest, EventByGameIdRequest, EventByNetworkIdRequest, 
//            SearchAPI

public class EPCatalogManager
{
    public static interface Callback
    {

        public abstract void onEventRetrivalError(int i);

        public abstract void onEventUpdate(EPEvents epevents);
    }

    protected class Lock
    {

        final EPCatalogManager this$0;

        protected void finalize()
            throws Throwable
        {
            super.finalize();
        }

        Lock()
        {
            this$0 = EPCatalogManager.this;
            super();
        }
    }


    static final int channelEventsByLeague = 20;
    static final int channelsKey = 1;
    static final int configKey = 2;
    private static EPCatalogManager epCatalogManager = null;
    static final String espn3NetworkId = "n360";
    static final int eventByChannelKey = 3;
    static final int eventBySportsKey = 6;
    static final int liveEventsKey = 9;
    static final int loadMoreChannelEventsByLeague = 21;
    static final int loadMoreEventByChannelKey = 4;
    static final int loadMoreSportEventsByLeague = 22;
    static final int loadMoreeventBySportsKey = 7;
    static final int sportEventsByLeague = 0;
    static final int sportsKey = 5;
    private Lock mChannelListLock;
    private Lock mEventsByChannelLock;
    private Lock mEventsBySportLock;
    private Lock mLiveEventsLock;
    private Lock mSportListLock;

    public EPCatalogManager()
    {
        mLiveEventsLock = new Lock();
        mEventsByChannelLock = new Lock();
        mEventsBySportLock = new Lock();
        mChannelListLock = new Lock();
        mSportListLock = new Lock();
    }

    private ArrayList getEvents(Cursor cursor)
    {
        ArrayList arraylist = new ArrayList();
        do
        {
            try
            {
                HashMap hashmap = new HashMap();
                hashmap.put("eventName", cursor.getString(cursor.getColumnIndex("eventName")));
                hashmap.put("eventId", cursor.getString(cursor.getColumnIndex("eventId")));
                hashmap.put("simulcastAiringId", cursor.getString(cursor.getColumnIndex("simulcastAiringId")));
                hashmap.put("eventType", cursor.getString(cursor.getColumnIndex("eventType")));
                hashmap.put("showName", cursor.getString(cursor.getColumnIndex("showName")));
                hashmap.put("broadcastStartTime", cursor.getString(cursor.getColumnIndex("broadcastStartTime")));
                hashmap.put("startTime", cursor.getString(cursor.getColumnIndex("startTime")));
                hashmap.put("endTime", cursor.getString(cursor.getColumnIndex("endTime")));
                hashmap.put("imageLarge", cursor.getString(cursor.getColumnIndex("imageLarge")));
                hashmap.put("imageMed", cursor.getString(cursor.getColumnIndex("imageMed")));
                hashmap.put("imageSmall", cursor.getString(cursor.getColumnIndex("imageSmall")));
                hashmap.put("parentalRating", cursor.getString(cursor.getColumnIndex("parentalRating")));
                hashmap.put("seekInSeconds", cursor.getString(cursor.getColumnIndex("seekInSeconds")));
                hashmap.put("networkCode", cursor.getString(cursor.getColumnIndex("networkCode")));
                hashmap.put("description", cursor.getString(cursor.getColumnIndex("description")));
                hashmap.put("networkName", cursor.getString(cursor.getColumnIndex("networkName")));
                hashmap.put("league", cursor.getString(cursor.getColumnIndex("league")));
                hashmap.put("leagueName", cursor.getString(cursor.getColumnIndex("leagueName")));
                hashmap.put("SPORT", cursor.getString(cursor.getColumnIndex("SPORT")));
                hashmap.put("sportCode", cursor.getString(cursor.getColumnIndex("sportCode")));
                hashmap.put("programingCode", cursor.getString(cursor.getColumnIndex("programingCode")));
                hashmap.put("coverageType", cursor.getString(cursor.getColumnIndex("coverageType")));
                hashmap.put("networkResourceId", cursor.getString(cursor.getColumnIndex("networkResourceId")));
                arraylist.add(new EPEvents(hashmap));
            }
            catch (Exception exception)
            {
                Utils.sdkLog("CatalogManger:", 5, exception);
            }
            cursor.moveToNext();
        } while (!cursor.isAfterLast());
        return arraylist;
    }

    public static EPCatalogManager instantiate()
    {
        if (epCatalogManager == null)
        {
            epCatalogManager = new EPCatalogManager();
        }
        return epCatalogManager;
    }

    private void loadMoreEventsForChannelByLeague(EPChannels epchannels, EPEventType epeventtype, int i)
    {
        if (epchannels == null || epeventtype == null)
        {
            return;
        }
        try
        {
            epeventtype = epeventtype.getEventStr();
            (new RefreshFeedsThread(mEventsByChannelLock, 21, epchannels, epeventtype, Integer.toString(i), null)).start();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (EPChannels epchannels)
        {
            Utils.sdkLog("Error: ", 5, epchannels);
        }
    }

    private void loadMoreEventsForSportByLeague(EPSport epsport, EPEventType epeventtype, int i)
    {
        if (epsport == null || epeventtype == null)
        {
            return;
        }
        try
        {
            epeventtype = epeventtype.getEventStr();
            String s = epsport.getId();
            String s1 = epsport.getName();
            epsport = epsport.getName();
            (new RefreshFeedsThread(mEventsBySportLock, 22, s1, s, epeventtype, Integer.toString(i), null, epsport)).start();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (EPSport epsport)
        {
            Utils.sdkLog("Error: ", 5, epsport);
        }
    }

    public ArrayList getChannelsList()
    {
        Cursor cursor;
        Cursor cursor1;
        ArrayList arraylist;
        arraylist = new ArrayList();
        cursor1 = null;
        cursor = null;
        Cursor cursor2 = DataManager.feedsDbConn.getAllChannels();
        cursor = cursor2;
        cursor1 = cursor2;
        if (cursor2.getCount() <= 0) goto _L2; else goto _L1
_L1:
        cursor = cursor2;
        cursor1 = cursor2;
        if (!cursor2.moveToFirst()) goto _L2; else goto _L3
_L3:
        cursor = cursor2;
        cursor1 = cursor2;
        arraylist.add(new EPChannels(cursor2.getString(cursor2.getColumnIndex("channelName")), cursor2.getString(cursor2.getColumnIndex("type")), cursor2.getString(cursor2.getColumnIndex("id")), cursor2.getString(cursor2.getColumnIndex("code")), cursor2.getString(cursor2.getColumnIndex("ImageSmall")), cursor2.getString(cursor2.getColumnIndex("slateImageSmall")), cursor2.getString(cursor2.getColumnIndex("slateImageMedium")), cursor2.getString(cursor2.getColumnIndex("slateImageLarge")), cursor2.getString(cursor2.getColumnIndex("resourceId"))));
        cursor = cursor2;
        cursor1 = cursor2;
        cursor2.moveToNext();
        cursor = cursor2;
        cursor1 = cursor2;
        if (!cursor2.isAfterLast()) goto _L3; else goto _L2
_L2:
        cursor = cursor2;
        cursor1 = cursor2;
        (new RefreshFeedsThread(mChannelListLock, 1)).start();
        if (cursor2 != null)
        {
            cursor2.close();
        }
_L5:
        return arraylist;
        Exception exception1;
        exception1;
        cursor1 = cursor;
        Utils.sdkLog("DataManager:", 5, exception1);
        if (cursor == null) goto _L5; else goto _L4
_L4:
        cursor.close();
        return arraylist;
        Exception exception;
        exception;
        if (cursor1 != null)
        {
            cursor1.close();
        }
        throw exception;
    }

    public void getEventByID(String s, Callback callback)
    {
        Cursor cursor;
        Cursor cursor1;
        cursor = null;
        cursor1 = null;
        Cursor cursor2 = DataManager.feedsDbConn.getEventById(s);
        cursor1 = cursor2;
        cursor = cursor2;
        if (cursor2.getCount() <= 0) goto _L2; else goto _L1
_L1:
        cursor1 = cursor2;
        cursor = cursor2;
        boolean flag = cursor2.moveToFirst();
        if (!flag) goto _L2; else goto _L3
_L3:
        cursor = cursor2;
        s = new HashMap();
        cursor = cursor2;
        s.put("eventName", cursor2.getString(cursor2.getColumnIndex("eventName")));
        cursor = cursor2;
        s.put("eventId", cursor2.getString(cursor2.getColumnIndex("eventId")));
        cursor = cursor2;
        s.put("simulcastAiringId", cursor2.getString(cursor2.getColumnIndex("simulcastAiringId")));
        cursor = cursor2;
        s.put("eventType", cursor2.getString(cursor2.getColumnIndex("eventType")));
        cursor = cursor2;
        s.put("showName", cursor2.getString(cursor2.getColumnIndex("showName")));
        cursor = cursor2;
        s.put("broadcastStartTime", cursor2.getString(cursor2.getColumnIndex("broadcastStartTime")));
        cursor = cursor2;
        s.put("startTime", cursor2.getString(cursor2.getColumnIndex("startTime")));
        cursor = cursor2;
        s.put("endTime", cursor2.getString(cursor2.getColumnIndex("endTime")));
        cursor = cursor2;
        s.put("imageLarge", cursor2.getString(cursor2.getColumnIndex("imageLarge")));
        cursor = cursor2;
        s.put("imageMed", cursor2.getString(cursor2.getColumnIndex("imageMed")));
        cursor = cursor2;
        s.put("imageSmall", cursor2.getString(cursor2.getColumnIndex("imageSmall")));
        cursor = cursor2;
        s.put("parentalRating", cursor2.getString(cursor2.getColumnIndex("parentalRating")));
        cursor = cursor2;
        s.put("seekInSeconds", cursor2.getString(cursor2.getColumnIndex("seekInSeconds")));
        cursor = cursor2;
        s.put("networkCode", cursor2.getString(cursor2.getColumnIndex("networkCode")));
        cursor = cursor2;
        s.put("description", cursor2.getString(cursor2.getColumnIndex("description")));
        cursor = cursor2;
        s.put("networkName", cursor2.getString(cursor2.getColumnIndex("networkName")));
        cursor = cursor2;
        s.put("league", cursor2.getString(cursor2.getColumnIndex("league")));
        cursor = cursor2;
        s.put("leagueName", cursor2.getString(cursor2.getColumnIndex("leagueName")));
        cursor = cursor2;
        s.put("SPORT", cursor2.getString(cursor2.getColumnIndex("SPORT")));
        cursor = cursor2;
        s.put("leagueName", cursor2.getString(cursor2.getColumnIndex("leagueName")));
        cursor = cursor2;
        s.put("SPORT", cursor2.getString(cursor2.getColumnIndex("SPORT")));
        cursor = cursor2;
        s.put("coverageType", cursor2.getString(cursor2.getColumnIndex("coverageType")));
        cursor = cursor2;
        s.put("networkResourceId", cursor2.getString(cursor2.getColumnIndex("networkResourceId")));
        cursor = cursor2;
        callback.onEventUpdate(new EPEvents(s));
_L4:
        if (cursor2 != null)
        {
            cursor2.close();
        }
_L6:
        return;
        s;
        cursor1 = cursor2;
        cursor = cursor2;
        Utils.sdkLog("DataManager:", 5, s);
          goto _L4
        s;
        cursor = cursor1;
        Utils.sdkLog("DataManager: ", 5, s);
        cursor = cursor1;
        callback.onEventRetrivalError(7);
        if (cursor1 == null) goto _L6; else goto _L5
_L5:
        cursor1.close();
        return;
_L2:
        cursor1 = cursor2;
        cursor = cursor2;
        (new EventByIdRequest(s, callback)).start();
          goto _L4
        s;
        if (cursor != null)
        {
            cursor.close();
        }
        throw s;
    }

    public void getEventForGameID(String s, Callback callback)
    {
        (new EventByGameIdRequest(callback)).getEvent(s);
    }

    public ArrayList getEventsForChannel(EPChannels epchannels, EPEventType epeventtype)
    {
        return getEventsForChannel(epchannels, epeventtype, 10);
    }

    public ArrayList getEventsForChannel(EPChannels epchannels, EPEventType epeventtype, int i)
    {
        Cursor cursor;
        Cursor cursor1;
        Object obj;
        ArrayList arraylist;
        Cursor cursor2;
        Object obj1;
        arraylist = new ArrayList();
        obj1 = null;
        cursor2 = null;
        if (epchannels == null || epeventtype == null)
        {
            if (false)
            {
                throw new NullPointerException();
            } else
            {
                return arraylist;
            }
        }
        obj = arraylist;
        cursor1 = cursor2;
        cursor = obj1;
        String s = Integer.toString(i);
        obj = arraylist;
        cursor1 = cursor2;
        cursor = obj1;
        String s2 = epchannels.getNetworkId();
        obj = arraylist;
        cursor1 = cursor2;
        cursor = obj1;
        String s1 = epeventtype.getEventStr();
        obj = arraylist;
        cursor1 = cursor2;
        cursor = obj1;
        cursor2 = DataManager.feedsDbConn.getEventsForChannel(s2, s1);
        epeventtype = arraylist;
        obj = arraylist;
        cursor1 = cursor2;
        cursor = cursor2;
        if (cursor2.getCount() <= 0)
        {
            break MISSING_BLOCK_LABEL_185;
        }
        epeventtype = arraylist;
        obj = arraylist;
        cursor1 = cursor2;
        cursor = cursor2;
        if (!cursor2.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_185;
        }
        obj = arraylist;
        cursor1 = cursor2;
        cursor = cursor2;
        epeventtype = getEvents(cursor2);
        obj = epeventtype;
        cursor1 = cursor2;
        cursor = cursor2;
        (new RefreshFeedsThread(mEventsByChannelLock, 3, epchannels, s1, s, null)).start();
        epchannels = epeventtype;
        if (cursor2 != null)
        {
            cursor2.close();
            epchannels = epeventtype;
        }
_L2:
        return epchannels;
        epchannels;
        cursor = cursor1;
        Utils.sdkLog("Error: ", 5, epchannels);
        epchannels = ((EPChannels) (obj));
        if (cursor1 != null)
        {
            cursor1.close();
            epchannels = ((EPChannels) (obj));
        }
        if (true) goto _L2; else goto _L1
_L1:
        epchannels;
        if (cursor != null)
        {
            cursor.close();
        }
        throw epchannels;
    }

    public ArrayList getEventsForChannelByLeague(EPChannels epchannels, EPEventType epeventtype, int i)
    {
        ArrayList arraylist;
        ArrayList arraylist1;
        Cursor cursor;
        Cursor cursor1;
        ArrayList arraylist2;
        Cursor cursor2;
        String s;
        arraylist2 = new ArrayList();
        s = Integer.toString(i);
        arraylist = null;
        cursor2 = null;
        if (epchannels == null || epeventtype == null)
        {
            if (false)
            {
                throw new NullPointerException();
            } else
            {
                return arraylist2;
            }
        }
        arraylist1 = arraylist2;
        cursor1 = cursor2;
        cursor = arraylist;
        String s2 = epchannels.getNetworkCode();
        arraylist1 = arraylist2;
        cursor1 = cursor2;
        cursor = arraylist;
        String s1 = epeventtype.getEventStr();
        arraylist1 = arraylist2;
        cursor1 = cursor2;
        cursor = arraylist;
        cursor2 = DataManager.feedsDbConn.getEventsForChannelByLeague(s2, s1);
        arraylist = arraylist2;
        arraylist1 = arraylist2;
        cursor1 = cursor2;
        cursor = cursor2;
        if (cursor2.getCount() <= 0)
        {
            break MISSING_BLOCK_LABEL_176;
        }
        arraylist = arraylist2;
        arraylist1 = arraylist2;
        cursor1 = cursor2;
        cursor = cursor2;
        if (!cursor2.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_176;
        }
        arraylist1 = arraylist2;
        cursor1 = cursor2;
        cursor = cursor2;
        arraylist = getEvents(cursor2);
        arraylist1 = arraylist;
        cursor1 = cursor2;
        cursor = cursor2;
        (new RefreshFeedsThread(mEventsByChannelLock, 20, epchannels, epeventtype.getEventStr(), s, null)).start();
        epchannels = arraylist;
        if (cursor2 != null)
        {
            cursor2.close();
            epchannels = arraylist;
        }
_L2:
        return epchannels;
        epchannels;
        cursor = cursor1;
        Utils.sdkLog("DataManager:", 5, epchannels);
        epchannels = arraylist1;
        if (cursor1 != null)
        {
            cursor1.close();
            epchannels = arraylist1;
        }
        if (true) goto _L2; else goto _L1
_L1:
        epchannels;
        if (cursor != null)
        {
            cursor.close();
        }
        throw epchannels;
    }

    public ArrayList getEventsForSport(EPSport epsport, EPEventType epeventtype)
    {
        return getEventsForSport(epsport, epeventtype, 10);
    }

    public ArrayList getEventsForSport(EPSport epsport, EPEventType epeventtype, int i)
    {
        EPEventType epeventtype1;
        Object obj;
        Object obj1;
        ArrayList arraylist;
        Object obj2;
        Object obj3;
        String s1;
        arraylist = new ArrayList();
        s1 = Integer.toString(i);
        obj2 = null;
        obj3 = null;
        if (epsport == null || epeventtype == null)
        {
            if (false)
            {
                throw new NullPointerException();
            } else
            {
                return arraylist;
            }
        }
        obj1 = arraylist;
        epeventtype1 = obj3;
        obj = obj2;
        String s = epsport.getId();
        obj1 = arraylist;
        epeventtype1 = obj3;
        obj = obj2;
        String s2 = epsport.getName();
        obj1 = arraylist;
        epeventtype1 = obj3;
        obj = obj2;
        String s3 = epeventtype.getEventStr();
        obj1 = arraylist;
        epeventtype1 = obj3;
        obj = obj2;
        epeventtype = DataManager.feedsDbConn.getEventsForSport(s, s3);
        epsport = arraylist;
        obj1 = arraylist;
        epeventtype1 = epeventtype;
        obj = epeventtype;
        if (epeventtype.getCount() <= 0)
        {
            break MISSING_BLOCK_LABEL_181;
        }
        epsport = arraylist;
        obj1 = arraylist;
        epeventtype1 = epeventtype;
        obj = epeventtype;
        if (!epeventtype.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_181;
        }
        obj1 = arraylist;
        epeventtype1 = epeventtype;
        obj = epeventtype;
        epsport = getEvents(epeventtype);
        obj1 = epsport;
        epeventtype1 = epeventtype;
        obj = epeventtype;
        (new RefreshFeedsThread(mEventsBySportLock, 6, s2, s, s3, s1, null, null)).start();
        obj = epsport;
        if (epeventtype != null)
        {
            epeventtype.close();
            obj = epsport;
        }
_L2:
        return ((ArrayList) (obj));
        epsport;
        obj = epeventtype1;
        Utils.sdkLog("DataManager:", 5, epsport);
        obj = obj1;
        if (epeventtype1 != null)
        {
            epeventtype1.close();
            obj = obj1;
        }
        if (true) goto _L2; else goto _L1
_L1:
        epsport;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw epsport;
    }

    public ArrayList getEventsForSportByLeague(EPSport epsport, EPEventType epeventtype, int i)
    {
        EPEventType epeventtype1;
        Object obj;
        Object obj1;
        ArrayList arraylist;
        Object obj2;
        Object obj3;
        String s;
        arraylist = new ArrayList();
        s = Integer.toString(i);
        obj2 = null;
        obj3 = null;
        if (epsport == null || epeventtype == null)
        {
            if (false)
            {
                throw new NullPointerException();
            } else
            {
                return arraylist;
            }
        }
        obj = arraylist;
        epeventtype1 = obj3;
        obj1 = obj2;
        String s1 = epsport.getId();
        obj = arraylist;
        epeventtype1 = obj3;
        obj1 = obj2;
        String s2 = epsport.getAbbreviation();
        obj = arraylist;
        epeventtype1 = obj3;
        obj1 = obj2;
        String s3 = epeventtype.getEventStr();
        obj = arraylist;
        epeventtype1 = obj3;
        obj1 = obj2;
        epeventtype = DataManager.feedsDbConn.getEventsForSportByLeague(s1, s3);
        epsport = arraylist;
        obj = arraylist;
        epeventtype1 = epeventtype;
        obj1 = epeventtype;
        if (epeventtype.getCount() <= 0)
        {
            break MISSING_BLOCK_LABEL_181;
        }
        epsport = arraylist;
        obj = arraylist;
        epeventtype1 = epeventtype;
        obj1 = epeventtype;
        if (!epeventtype.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_181;
        }
        obj = arraylist;
        epeventtype1 = epeventtype;
        obj1 = epeventtype;
        epsport = getEvents(epeventtype);
        obj = epsport;
        epeventtype1 = epeventtype;
        obj1 = epeventtype;
        (new RefreshFeedsThread(mEventsBySportLock, 0, null, s1, s3, s, null, s2)).start();
        obj1 = epsport;
        if (epeventtype != null)
        {
            epeventtype.close();
            obj1 = epsport;
        }
_L2:
        return ((ArrayList) (obj1));
        epsport;
        obj1 = epeventtype1;
        Utils.sdkLog("DataManager:", 5, epsport);
        obj1 = obj;
        if (epeventtype1 != null)
        {
            epeventtype1.close();
            obj1 = obj;
        }
        if (true) goto _L2; else goto _L1
_L1:
        epsport;
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        throw epsport;
    }

    public void getFreshEventByID(String s, Callback callback)
    {
        try
        {
            (new EventByIdRequest(s, callback)).start();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Utils.sdkLog("DataManager: ", 5, s);
        }
        callback.onEventRetrivalError(7);
    }

    public void getLiveEventForNetwork(String s, Callback callback)
    {
        (new EventByNetworkIdRequest(callback)).getEvent(s);
    }

    public ArrayList getLiveEvents()
    {
        ArrayList arraylist1;
        Cursor cursor;
        Object obj1;
        ArrayList arraylist2;
        arraylist2 = new ArrayList();
        obj1 = null;
        cursor = null;
        arraylist1 = arraylist2;
        Cursor cursor1 = DataManager.feedsDbConn.getLiveEvents();
        ArrayList arraylist;
        arraylist = arraylist2;
        arraylist1 = arraylist2;
        cursor = cursor1;
        obj1 = cursor1;
        if (cursor1.getCount() <= 0)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        arraylist = arraylist2;
        arraylist1 = arraylist2;
        cursor = cursor1;
        obj1 = cursor1;
        if (!cursor1.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_88;
        }
        arraylist1 = arraylist2;
        cursor = cursor1;
        obj1 = cursor1;
        arraylist = getEvents(cursor1);
        arraylist1 = arraylist;
        cursor = cursor1;
        obj1 = cursor1;
        (new RefreshFeedsThread(mLiveEventsLock, 9)).start();
        obj1 = arraylist;
        if (cursor1 != null)
        {
            cursor1.close();
            obj1 = arraylist;
        }
_L2:
        return ((ArrayList) (obj1));
        Object obj;
        obj;
        obj1 = cursor;
        Utils.sdkLog("DataManager", 5, ((Exception) (obj)));
        obj1 = arraylist1;
        if (cursor == null) goto _L2; else goto _L1
_L1:
        cursor.close();
        return arraylist1;
        obj;
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        throw obj;
    }

    public ArrayList getSportsList()
    {
        Cursor cursor;
        Cursor cursor1;
        ArrayList arraylist;
        arraylist = new ArrayList();
        cursor1 = null;
        cursor = null;
        Cursor cursor2 = DataManager.feedsDbConn.getAllSports("101");
        cursor = cursor2;
        cursor1 = cursor2;
        if (cursor2.getCount() <= 0) goto _L2; else goto _L1
_L1:
        cursor = cursor2;
        cursor1 = cursor2;
        if (!cursor2.moveToFirst()) goto _L2; else goto _L3
_L3:
        cursor = cursor2;
        cursor1 = cursor2;
        arraylist.add(new EPSport(cursor2.getString(cursor2.getColumnIndex("sportName")), cursor2.getString(cursor2.getColumnIndex("soprtId")), cursor2.getString(cursor2.getColumnIndex("sportAbbre"))));
        cursor = cursor2;
        cursor1 = cursor2;
        cursor2.moveToNext();
        cursor = cursor2;
        cursor1 = cursor2;
        if (!cursor2.isAfterLast()) goto _L3; else goto _L2
_L2:
        cursor = cursor2;
        cursor1 = cursor2;
        (new RefreshFeedsThread(mSportListLock, 5, Integer.parseInt("101"), null)).start();
        if (cursor2 != null)
        {
            cursor2.close();
        }
_L5:
        return arraylist;
        Exception exception1;
        exception1;
        cursor1 = cursor;
        Utils.sdkLog("DataManager: ", 5, exception1);
        if (cursor == null) goto _L5; else goto _L4
_L4:
        cursor.close();
        return arraylist;
        Exception exception;
        exception;
        if (cursor1 != null)
        {
            cursor1.close();
        }
        throw exception;
    }

    public void loadMoreEventsForChannel(EPChannels epchannels, EPEventType epeventtype)
    {
        if (epchannels == null || epeventtype == null)
        {
            return;
        }
        try
        {
            epeventtype = epeventtype.getEventStr();
            (new RefreshFeedsThread(mEventsByChannelLock, 4, epchannels, epeventtype, null, null)).start();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (EPChannels epchannels)
        {
            Utils.sdkLog("Error: ", 5, epchannels);
        }
    }

    public void loadMoreEventsForChannel(EPChannels epchannels, EPEventType epeventtype, int i)
    {
        if (epchannels == null || epeventtype == null)
        {
            return;
        }
        try
        {
            epeventtype = epeventtype.getEventStr();
            (new RefreshFeedsThread(mEventsByChannelLock, 4, epchannels, epeventtype, Integer.toString(i), null)).start();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (EPChannels epchannels)
        {
            Utils.sdkLog("Error: ", 5, epchannels);
        }
    }

    public void loadMoreEventsForSport(EPSport epsport, EPEventType epeventtype)
    {
        loadMoreEventsForSport(epsport, epeventtype, 10);
    }

    public void loadMoreEventsForSport(EPSport epsport, EPEventType epeventtype, int i)
    {
        if (epsport == null || epeventtype == null)
        {
            return;
        }
        try
        {
            String s = epsport.getId();
            epsport = epsport.getName();
            epeventtype = epeventtype.getEventStr();
            String s1 = Integer.toString(i);
            (new RefreshFeedsThread(mEventsBySportLock, 7, epsport, s, epeventtype, s1, null, null)).start();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (EPSport epsport)
        {
            Utils.sdkLog("DataManager: ", 5, epsport);
        }
    }

    public void search(String s, EPEventType epeventtype, int i, int j, SearchCallback searchcallback)
    {
        if (searchcallback == null || epeventtype == null || s == null)
        {
            return;
        } else
        {
            (new SearchAPI(searchcallback)).search(s, epeventtype.getEventStr(), j, i);
            return;
        }
    }

}
