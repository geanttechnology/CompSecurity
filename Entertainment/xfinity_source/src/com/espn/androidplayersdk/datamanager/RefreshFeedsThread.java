// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.espn.androidplayersdk.datamanager;

import android.content.ContentValues;
import android.database.Cursor;
import com.espn.androidplayersdk.objects.EPChannels;
import com.espn.androidplayersdk.utilities.EPEventType;
import com.espn.androidplayersdk.utilities.EPFeaturedEventType;
import com.espn.androidplayersdk.utilities.Utils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;

// Referenced classes of package com.espn.androidplayersdk.datamanager:
//            FeedsManagerAPI, DataManager, FeedsDB, EPFeaturedCategory, 
//            EPSport

class RefreshFeedsThread extends Thread
{

    protected static final String EVENT_WHERE = "eventWhere";
    protected static final String EVENT_WHERE_ARG = "eventWhereArg";
    String abbre;
    EPSport epSport;
    FeedsManagerAPI feeds;
    int key;
    String limit;
    EPEventType mEPEventType;
    EPFeaturedEventType mEPFeaturedEventType;
    EPCatalogManager.Lock mLock;
    Object mObject;
    String networkCode;
    String networkId;
    String sport;
    String sportsid;
    String start;
    int subKey;
    String subKeyMeta;
    String type;

    RefreshFeedsThread(EPCatalogManager.Lock lock, int i)
    {
        key = 0;
        subKey = 0;
        epSport = null;
        networkCode = null;
        networkId = null;
        sportsid = null;
        sport = null;
        type = null;
        limit = null;
        start = null;
        abbre = null;
        subKeyMeta = null;
        mLock = null;
        feeds = new FeedsManagerAPI();
        key = i;
        mLock = lock;
    }

    RefreshFeedsThread(EPCatalogManager.Lock lock, int i, int j, EPSport epsport)
    {
        key = 0;
        subKey = 0;
        epSport = null;
        networkCode = null;
        networkId = null;
        sportsid = null;
        sport = null;
        type = null;
        limit = null;
        start = null;
        abbre = null;
        subKeyMeta = null;
        mLock = null;
        feeds = new FeedsManagerAPI();
        key = i;
        subKey = j;
        mLock = lock;
        epSport = epsport;
    }

    RefreshFeedsThread(EPCatalogManager.Lock lock, int i, int j, String s, EPSport epsport)
    {
        key = 0;
        subKey = 0;
        epSport = null;
        networkCode = null;
        networkId = null;
        sportsid = null;
        sport = null;
        type = null;
        limit = null;
        start = null;
        abbre = null;
        subKeyMeta = null;
        mLock = null;
        feeds = new FeedsManagerAPI();
        key = i;
        subKey = j;
        mLock = lock;
        epSport = epsport;
        subKeyMeta = s;
    }

    RefreshFeedsThread(EPCatalogManager.Lock lock, int i, EPChannels epchannels, String s, String s1, String s2)
    {
        key = 0;
        subKey = 0;
        epSport = null;
        networkCode = null;
        networkId = null;
        sportsid = null;
        sport = null;
        type = null;
        limit = null;
        start = null;
        abbre = null;
        subKeyMeta = null;
        mLock = null;
        feeds = new FeedsManagerAPI();
        mLock = lock;
        key = i;
        networkCode = epchannels.getNetworkCode();
        networkId = epchannels.getNetworkId();
        type = s;
        limit = s1;
        start = s2;
    }

    RefreshFeedsThread(EPCatalogManager.Lock lock, int i, Object obj, EPFeaturedEventType epfeaturedeventtype, EPEventType epeventtype, String s)
    {
        key = 0;
        subKey = 0;
        epSport = null;
        networkCode = null;
        networkId = null;
        sportsid = null;
        sport = null;
        type = null;
        limit = null;
        start = null;
        abbre = null;
        subKeyMeta = null;
        mLock = null;
        feeds = new FeedsManagerAPI();
        key = i;
        mLock = lock;
        mObject = obj;
        mEPFeaturedEventType = epfeaturedeventtype;
        mEPEventType = epeventtype;
        limit = s;
    }

    RefreshFeedsThread(EPCatalogManager.Lock lock, int i, String s, String s1, String s2, String s3, String s4, 
            String s5)
    {
        key = 0;
        subKey = 0;
        epSport = null;
        networkCode = null;
        networkId = null;
        sportsid = null;
        sport = null;
        type = null;
        limit = null;
        start = null;
        abbre = null;
        subKeyMeta = null;
        mLock = null;
        feeds = new FeedsManagerAPI();
        mLock = lock;
        key = i;
        sport = s;
        sportsid = s1;
        type = s2;
        limit = s3;
        start = s4;
        abbre = s5;
    }

    private void loadEventsForChannel(String s, String s1, String s2, String s3)
    {
        Object obj;
        Object obj1;
        obj1 = null;
        obj = null;
        if (s2 == null) goto _L2; else goto _L1
_L1:
        String s5 = s2;
_L6:
        String s4;
        String s6;
        s6 = s3;
        if (s3 == null)
        {
            s6 = "10";
        }
        s4 = obj;
        s2 = obj1;
        s1 = DataManager.feedsDbConn.getEventsForChannel(s1, s5);
        s4 = s1;
        s2 = s1;
        int i = s1.getCount();
        s4 = s1;
        s2 = s1;
        s3 = new String[2];
        s4 = s1;
        s2 = s1;
        setDateRange(10, s3);
        s4 = s1;
        s2 = s1;
        feeds.getEventsByChannelFeed(s, s5, s6, Integer.toString(i), s3[0], s3[1], null);
        if (s1 != null)
        {
            s1.close();
        }
_L4:
        return;
_L2:
        s4 = obj;
        s2 = obj1;
        try
        {
            s5 = EPEventType.LIVE.getEventStr();
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s2 = s4;
        }
        finally
        {
            if (s2 != null)
            {
                s2.close();
            }
            throw s;
        }
        Utils.sdkLog("Error: ", 5, s);
        if (s4 == null) goto _L4; else goto _L3
_L3:
        s4.close();
        return;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void loadEventsForChannelByLeague(String s, String s1, String s2, String s3)
    {
        Object obj;
        Object obj1;
        obj1 = null;
        obj = null;
        if (s2 == null) goto _L2; else goto _L1
_L1:
        String s5 = s2;
_L6:
        String s4;
        String s6;
        s6 = s3;
        if (s3 == null)
        {
            s6 = "10";
        }
        s4 = obj;
        s2 = obj1;
        s1 = DataManager.feedsDbConn.getEventsForChannelByLeague(s1, s5);
        s4 = s1;
        s2 = s1;
        int i = s1.getCount();
        s4 = s1;
        s2 = s1;
        s3 = new String[2];
        s4 = s1;
        s2 = s1;
        setDateRange(10, s3);
        s4 = s1;
        s2 = s1;
        feeds.getEventsByChannelSortedByLeagueFeed(s, s5, s6, Integer.toString(i), s3[0], s3[1], null);
        if (s1 != null)
        {
            s1.close();
        }
_L4:
        return;
_L2:
        s4 = obj;
        s2 = obj1;
        try
        {
            s5 = EPEventType.LIVE.getEventStr();
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s2 = s4;
        }
        finally
        {
            if (s2 != null)
            {
                s2.close();
            }
            throw s;
        }
        Utils.sdkLog("Error: ", 5, s);
        if (s4 == null) goto _L4; else goto _L3
_L3:
        s4.close();
        return;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void loadEventsForSport(String s, String s1, String s2)
    {
        Cursor cursor;
        Cursor cursor1;
        cursor1 = null;
        cursor = null;
        Cursor cursor2 = DataManager.feedsDbConn.getEventsForSport(s, s1);
        cursor = cursor2;
        cursor1 = cursor2;
        int i = cursor2.getCount();
        cursor = cursor2;
        cursor1 = cursor2;
        String as[] = new String[2];
        cursor = cursor2;
        cursor1 = cursor2;
        setDateRange(10, as);
        cursor = cursor2;
        cursor1 = cursor2;
        feeds.getEventsBySportFeed(s, s1, s2, Integer.toString(i), as[0], as[1], null);
        if (cursor2 != null)
        {
            cursor2.close();
        }
_L2:
        return;
        s;
        cursor1 = cursor;
        Utils.sdkLog("Error: ", 5, s);
        if (cursor == null) goto _L2; else goto _L1
_L1:
        cursor.close();
        return;
        s;
        if (cursor1 != null)
        {
            cursor1.close();
        }
        throw s;
    }

    private void loadEventsForSportByLeague(String s, String s1, String s2, String s3)
    {
        Cursor cursor;
        Cursor cursor1;
        cursor1 = null;
        cursor = null;
        Cursor cursor2 = DataManager.feedsDbConn.getEventsForSportByLeague(s, s1);
        cursor = cursor2;
        cursor1 = cursor2;
        int i = cursor2.getCount();
        cursor = cursor2;
        cursor1 = cursor2;
        String as[] = new String[2];
        cursor = cursor2;
        cursor1 = cursor2;
        setDateRange(10, as);
        cursor = cursor2;
        cursor1 = cursor2;
        feeds.getEventsBySportSortedByLeagueFeed(s, s1, s2, s3, Integer.toString(i), as[0], as[1], null);
        if (cursor2 != null)
        {
            cursor2.close();
        }
_L2:
        return;
        s;
        cursor1 = cursor;
        Utils.sdkLog("Error: ", 5, s);
        if (cursor == null) goto _L2; else goto _L1
_L1:
        cursor.close();
        return;
        s;
        if (cursor1 != null)
        {
            cursor1.close();
        }
        throw s;
    }

    private void refreshChannelEventsByLeague(String s, String s1, String s2, String s3)
    {
        Object obj;
        Cursor cursor;
        Object obj1;
        String as1[];
        String s5;
        ContentValues contentvalues;
        HashMap hashmap;
        EPCatalogManager.Lock lock;
        String as2[];
        cursor = null;
        Object obj2 = null;
        Object obj3 = null;
        obj1 = null;
        contentvalues = new ContentValues();
        hashmap = new HashMap();
        String s4 = "metaEventRelationId = ? and networkId = ?";
        String as[];
        if (s2 != null)
        {
            s4 = (new StringBuilder(String.valueOf("metaEventRelationId = ? and networkId = ?"))).append(" and eventType = ?").toString();
            as = new String[3];
            as[2] = s2;
        } else
        {
            as = new String[2];
        }
        as[0] = "8";
        as[1] = s;
        s5 = "eventRelationId = ? and networkId = ?";
        if (s2 != null)
        {
            s5 = (new StringBuilder(String.valueOf("eventRelationId = ? and networkId = ?"))).append(" and eventsType = ?").toString();
            as1 = new String[3];
            as1[2] = s2;
            contentvalues.put("eventsType", s2);
        } else
        {
            as1 = new String[2];
        }
        as1[0] = "8";
        as1[1] = s;
        contentvalues.put("networkId", s);
        as2 = new String[2];
        setDateRange(10, as2);
        obj = obj2;
        s = obj3;
        lock = mLock;
        obj = obj2;
        s = obj3;
        lock;
        JVM INSTR monitorenter ;
        obj = obj1;
        s = cursor;
        cursor = DataManager.feedsDbConn.getMeta("metaEvents", s5, as1);
        obj = cursor;
        s = cursor;
        if (cursor.getCount() <= 0) goto _L2; else goto _L1
_L1:
        obj = cursor;
        s = cursor;
        if (!cursor.moveToFirst()) goto _L2; else goto _L3
_L3:
        obj1 = cursor;
        obj = cursor;
        s = cursor;
        if (!Utils.isExpired(cursor.getString(cursor.getColumnIndex("ttl"))))
        {
            break MISSING_BLOCK_LABEL_366;
        }
        obj = cursor;
        s = cursor;
        hashmap.put("eventWhere", s4);
        obj = cursor;
        s = cursor;
        hashmap.put("eventWhereArg", as);
        obj = cursor;
        s = cursor;
        DataManager.feedsDbConn.tempUpdateExpTimeForEvents("metaEvents", s5, as1, contentvalues);
        obj = cursor;
        s = cursor;
        feeds.getEventsByChannelSortedByLeagueFeed(s1, s2, s3, start, as2[0], as2[1], hashmap);
        obj1 = cursor;
_L7:
        s = ((String) (obj1));
        lock;
        JVM INSTR monitorexit ;
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
_L5:
        return;
_L2:
        obj = cursor;
        s = cursor;
        DataManager.feedsDbConn.tempUpdateExpTimeForEvents("metaEvents", s5, as1, contentvalues);
        obj = cursor;
        s = cursor;
        feeds.getEventsByChannelSortedByLeagueFeed(s1, s2, s3, start, as2[0], as2[1], hashmap);
        obj1 = cursor;
        continue; /* Loop/switch isn't completed */
        s1;
        s = ((String) (obj));
        Utils.sdkLog("Error: ", 5, s1);
        obj1 = obj;
        continue; /* Loop/switch isn't completed */
        s1;
        lock;
        JVM INSTR monitorexit ;
        obj = s;
        try
        {
            throw s1;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            s = ((String) (obj));
        }
        finally
        {
            if (s == null) goto _L0; else goto _L0
        }
        Utils.sdkLog("Error: ", 5, s1);
        if (obj == null) goto _L5; else goto _L4
_L4:
        ((Cursor) (obj)).close();
        return;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private void refreshChannelsFeed()
    {
        Cursor cursor;
        Cursor cursor1;
        Cursor cursor2;
        Cursor cursor3;
        Object obj1;
        Object obj2;
        cursor2 = null;
        obj1 = null;
        obj2 = null;
        cursor3 = null;
        cursor1 = obj1;
        cursor = obj2;
        EPCatalogManager.Lock lock = mLock;
        cursor1 = obj1;
        cursor = obj2;
        lock;
        JVM INSTR monitorenter ;
        cursor1 = cursor3;
        cursor = cursor2;
        cursor2 = DataManager.feedsDbConn.getMeta("metaChannel", null, null);
        cursor1 = cursor2;
        cursor = cursor2;
        if (cursor2.getCount() <= 0) goto _L2; else goto _L1
_L1:
        cursor1 = cursor2;
        cursor = cursor2;
        if (!cursor2.moveToFirst()) goto _L2; else goto _L3
_L3:
        cursor3 = cursor2;
        cursor1 = cursor2;
        cursor = cursor2;
        if (!Utils.isExpired(cursor2.getString(cursor2.getColumnIndex("TTL"))))
        {
            break MISSING_BLOCK_LABEL_138;
        }
        cursor1 = cursor2;
        cursor = cursor2;
        DataManager.feedsDbConn.tempUpdateExpTimeForMisc("metaChannel", null, null, new String[] {
            "TTL"
        });
        cursor1 = cursor2;
        cursor = cursor2;
        feeds.getChannelFeed();
        cursor3 = cursor2;
_L7:
        cursor = cursor3;
        lock;
        JVM INSTR monitorexit ;
        if (cursor3 != null)
        {
            cursor3.close();
        }
_L5:
        return;
_L2:
        cursor1 = cursor2;
        cursor = cursor2;
        DataManager.feedsDbConn.tempUpdateExpTimeForMisc("metaChannel", null, null, new String[] {
            "TTL"
        });
        cursor1 = cursor2;
        cursor = cursor2;
        feeds.getChannelFeed();
        cursor3 = cursor2;
        continue; /* Loop/switch isn't completed */
        Object obj;
        obj;
        cursor = cursor1;
        Utils.sdkLog("Error: ", 5, ((Exception) (obj)));
        cursor3 = cursor1;
        continue; /* Loop/switch isn't completed */
        obj;
        lock;
        JVM INSTR monitorexit ;
        cursor1 = cursor;
        throw obj;
        obj;
        cursor = cursor1;
        Utils.sdkLog("Error: ", 5, ((Exception) (obj)));
        if (cursor1 == null) goto _L5; else goto _L4
_L4:
        cursor1.close();
        return;
        Exception exception;
        exception;
        if (cursor != null)
        {
            cursor.close();
        }
        throw exception;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private void refreshConfigFeed()
    {
        Cursor cursor;
        Cursor cursor1;
        cursor1 = null;
        cursor = null;
        Cursor cursor2 = DataManager.feedsDbConn.getConfig();
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
        if (!Utils.isExpired(cursor2.getString(cursor2.getColumnIndex("TTL"))))
        {
            break MISSING_BLOCK_LABEL_87;
        }
        cursor = cursor2;
        cursor1 = cursor2;
        DataManager.feedsDbConn.delAllRows("config", null, null);
        cursor = cursor2;
        cursor1 = cursor2;
        feeds.getConfigFeed();
_L7:
        if (cursor2 != null)
        {
            cursor2.close();
        }
_L5:
        return;
_L2:
        cursor = cursor2;
        cursor1 = cursor2;
        feeds.getConfigFeed();
        continue; /* Loop/switch isn't completed */
        Exception exception1;
        exception1;
        cursor1 = cursor;
        Utils.sdkLog("Error: ", 5, exception1);
        if (cursor == null) goto _L5; else goto _L4
_L4:
        cursor.close();
        return;
        Exception exception;
        exception;
        if (cursor1 != null)
        {
            cursor1.close();
        }
        throw exception;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private void refreshEventsByChannelsFeed(String s, String s1, String s2, String s3, String s4)
    {
        Object obj;
        Object obj1;
        String s5;
        Object obj2;
        Object obj3;
        Object obj4;
        String as[];
        ContentValues contentvalues;
        HashMap hashmap;
        obj1 = null;
        obj3 = null;
        obj4 = null;
        obj2 = null;
        as = new String[3];
        contentvalues = new ContentValues();
        hashmap = new HashMap();
        s5 = s3;
        if (s3 == null)
        {
            s5 = "10";
        }
        as[0] = "3";
        as[1] = s1;
        as[2] = s2;
        s3 = obj3;
        obj = obj4;
        contentvalues.put("eventsType", s2);
        s3 = obj3;
        obj = obj4;
        contentvalues.put("networkId", s1);
        s3 = obj3;
        obj = obj4;
        String as1[] = new String[2];
        s3 = obj3;
        obj = obj4;
        setDateRange(10, as1);
        s3 = obj3;
        obj = obj4;
        EPCatalogManager.Lock lock = mLock;
        s3 = obj3;
        obj = obj4;
        lock;
        JVM INSTR monitorenter ;
        s3 = obj2;
        s1 = ((String) (obj1));
        obj = DataManager.feedsDbConn.getMeta("metaEvents", "eventRelationId = ? and networkId = ? and eventsType = ?", as);
        s3 = ((String) (obj));
        s1 = ((String) (obj));
        if (((Cursor) (obj)).getCount() <= 0) goto _L2; else goto _L1
_L1:
        s3 = ((String) (obj));
        s1 = ((String) (obj));
        if (!((Cursor) (obj)).moveToFirst()) goto _L2; else goto _L3
_L3:
        obj1 = obj;
        s3 = ((String) (obj));
        s1 = ((String) (obj));
        if (!Utils.isExpired(((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndex("ttl"))))
        {
            break MISSING_BLOCK_LABEL_333;
        }
        s3 = ((String) (obj));
        s1 = ((String) (obj));
        hashmap.put("eventWhere", "metaEventRelationId = ? and networkId = ? and eventType = ?");
        s3 = ((String) (obj));
        s1 = ((String) (obj));
        hashmap.put("eventWhereArg", as);
        s3 = ((String) (obj));
        s1 = ((String) (obj));
        DataManager.feedsDbConn.tempUpdateExpTimeForEvents("metaEvents", "eventRelationId = ? and networkId = ? and eventsType = ?", as, contentvalues);
        s3 = ((String) (obj));
        s1 = ((String) (obj));
        feeds.getEventsByChannelFeed(s, s2, s5, s4, as1[0], as1[1], hashmap);
        obj1 = obj;
_L7:
        s1 = ((String) (obj1));
        lock;
        JVM INSTR monitorexit ;
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
_L5:
        return;
_L2:
        s3 = ((String) (obj));
        s1 = ((String) (obj));
        DataManager.feedsDbConn.tempUpdateExpTimeForEvents("metaEvents", "eventRelationId = ? and networkId = ? and eventsType = ?", as, contentvalues);
        s3 = ((String) (obj));
        s1 = ((String) (obj));
        feeds.getEventsByChannelFeed(s, s2, s5, s4, as1[0], as1[1], hashmap);
        obj1 = obj;
        continue; /* Loop/switch isn't completed */
        s;
        s1 = s3;
        Utils.sdkLog("Error: ", 5, s);
        obj1 = s3;
        continue; /* Loop/switch isn't completed */
        s;
        lock;
        JVM INSTR monitorexit ;
        s3 = s1;
        obj = s1;
        try
        {
            throw s;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            obj = s3;
        }
        finally
        {
            if (obj == null) goto _L0; else goto _L0
        }
        Utils.sdkLog("Error: ", 5, s);
        if (s3 == null) goto _L5; else goto _L4
_L4:
        s3.close();
        return;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private void refreshEventsBySportFeed(String s, String s1, String s2, String s3, String s4)
    {
        Object obj;
        Cursor cursor;
        Object obj1;
        String as1[];
        String s6;
        ContentValues contentvalues;
        HashMap hashmap;
        EPCatalogManager.Lock lock;
        String as2[];
        cursor = null;
        Object obj2 = null;
        Object obj3 = null;
        obj1 = null;
        contentvalues = new ContentValues();
        hashmap = new HashMap();
        String s5 = "metaEventRelationId = ? and sportId = ?";
        String as[];
        if (s2 != null)
        {
            s5 = (new StringBuilder(String.valueOf("metaEventRelationId = ? and sportId = ?"))).append(" and eventType = ?").toString();
            as = new String[3];
            as[2] = s2;
        } else
        {
            as = new String[2];
        }
        as[0] = "4";
        as[1] = s1;
        s6 = "eventRelationId = ? and sportId = ?";
        if (s2 != null)
        {
            s6 = (new StringBuilder(String.valueOf("eventRelationId = ? and sportId = ?"))).append(" and eventsType = ?").toString();
            as1 = new String[3];
            as1[2] = s2;
            contentvalues.put("eventsType", s2);
        } else
        {
            as1 = new String[2];
        }
        as1[0] = "4";
        as1[1] = s1;
        contentvalues.put("sportId", s1);
        as2 = new String[2];
        setDateRange(10, as2);
        obj = obj2;
        s = obj3;
        lock = mLock;
        obj = obj2;
        s = obj3;
        lock;
        JVM INSTR monitorenter ;
        obj = obj1;
        s = cursor;
        cursor = DataManager.feedsDbConn.getMeta("metaEvents", s6, as1);
        obj = cursor;
        s = cursor;
        if (cursor.getCount() <= 0) goto _L2; else goto _L1
_L1:
        obj = cursor;
        s = cursor;
        if (!cursor.moveToFirst()) goto _L2; else goto _L3
_L3:
        obj1 = cursor;
        obj = cursor;
        s = cursor;
        if (!Utils.isExpired(cursor.getString(cursor.getColumnIndex("ttl"))))
        {
            break MISSING_BLOCK_LABEL_371;
        }
        obj = cursor;
        s = cursor;
        hashmap.put("eventWhere", s5);
        obj = cursor;
        s = cursor;
        hashmap.put("eventWhereArg", as);
        obj = cursor;
        s = cursor;
        DataManager.feedsDbConn.tempUpdateExpTimeForEvents("metaEvents", s6, as1, contentvalues);
        obj = cursor;
        s = cursor;
        feeds.getEventsBySportFeed(s1, s2, s3, s4, as2[0], as2[1], hashmap);
        obj1 = cursor;
_L7:
        s = ((String) (obj1));
        lock;
        JVM INSTR monitorexit ;
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
_L5:
        return;
_L2:
        obj = cursor;
        s = cursor;
        DataManager.feedsDbConn.tempUpdateExpTimeForEvents("metaEvents", s6, as1, contentvalues);
        obj = cursor;
        s = cursor;
        feeds.getEventsBySportFeed(s1, s2, s3, s4, as2[0], as2[1], hashmap);
        obj1 = cursor;
        continue; /* Loop/switch isn't completed */
        s1;
        s = ((String) (obj));
        Utils.sdkLog("Error: ", 5, s1);
        obj1 = obj;
        continue; /* Loop/switch isn't completed */
        s1;
        lock;
        JVM INSTR monitorexit ;
        obj = s;
        try
        {
            throw s1;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            s = ((String) (obj));
        }
        finally
        {
            if (s == null) goto _L0; else goto _L0
        }
        Utils.sdkLog("Error: ", 5, s1);
        if (obj == null) goto _L5; else goto _L4
_L4:
        ((Cursor) (obj)).close();
        return;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private void refreshFeaturedCategory()
    {
        Cursor cursor;
        Cursor cursor1;
        Cursor cursor2;
        Cursor cursor3;
        Object obj1;
        Object obj2;
        HashMap hashmap;
        String as[];
        cursor2 = null;
        obj1 = null;
        obj2 = null;
        cursor3 = null;
        hashmap = new HashMap();
        as = new String[1];
        as[0] = Integer.toString(key);
        cursor1 = obj1;
        cursor = obj2;
        EPCatalogManager.Lock lock = mLock;
        cursor1 = obj1;
        cursor = obj2;
        lock;
        JVM INSTR monitorenter ;
        cursor1 = cursor3;
        cursor = cursor2;
        cursor2 = DataManager.feedsDbConn.getMeta("metaEvents", "eventRelationId = ?", as);
        cursor1 = cursor2;
        cursor = cursor2;
        if (cursor2.getCount() <= 0) goto _L2; else goto _L1
_L1:
        cursor1 = cursor2;
        cursor = cursor2;
        if (!cursor2.moveToFirst()) goto _L2; else goto _L3
_L3:
        cursor3 = cursor2;
        cursor1 = cursor2;
        cursor = cursor2;
        if (!Utils.isExpired(cursor2.getString(cursor2.getColumnIndex("ttl"))))
        {
            break MISSING_BLOCK_LABEL_193;
        }
        cursor1 = cursor2;
        cursor = cursor2;
        hashmap.put("eventWhere", "metaEventRelationId = ?");
        cursor1 = cursor2;
        cursor = cursor2;
        hashmap.put("eventWhereArg", as);
        cursor1 = cursor2;
        cursor = cursor2;
        DataManager.feedsDbConn.tempUpdateExpTimeForEvents("metaEvents", "eventRelationId = ?", as, null);
        cursor1 = cursor2;
        cursor = cursor2;
        feeds.getFeturedCategories(hashmap);
        cursor3 = cursor2;
_L7:
        cursor = cursor3;
        lock;
        JVM INSTR monitorexit ;
        if (cursor3 != null)
        {
            cursor3.close();
        }
_L5:
        return;
_L2:
        cursor1 = cursor2;
        cursor = cursor2;
        DataManager.feedsDbConn.tempUpdateExpTimeForEvents("metaEvents", "eventRelationId = ?", as, null);
        cursor1 = cursor2;
        cursor = cursor2;
        feeds.getFeturedCategories(hashmap);
        cursor3 = cursor2;
        continue; /* Loop/switch isn't completed */
        Object obj;
        obj;
        cursor = cursor1;
        Utils.sdkLog("Error: ", 5, ((Exception) (obj)));
        cursor3 = cursor1;
        continue; /* Loop/switch isn't completed */
        obj;
        lock;
        JVM INSTR monitorexit ;
        cursor1 = cursor;
        throw obj;
        obj;
        cursor = cursor1;
        Utils.sdkLog("Error: ", 5, ((Exception) (obj)));
        if (cursor1 == null) goto _L5; else goto _L4
_L4:
        cursor1.close();
        return;
        Exception exception;
        exception;
        if (cursor != null)
        {
            cursor.close();
        }
        throw exception;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private void refreshFeaturedCategoryEvents()
    {
        Object obj;
        Object obj1;
        Cursor cursor;
        Object obj3;
        String s;
        ContentValues contentvalues;
        HashMap hashmap;
        String as[];
        String as1[];
        EPCatalogManager.Lock lock;
        cursor = null;
        Object obj4 = null;
        Object obj5 = null;
        obj3 = null;
        contentvalues = new ContentValues();
        hashmap = new HashMap();
        as = new String[3];
        as1 = new String[3];
        obj = (EPFeaturedCategory)mObject;
        hashmap.put("sportId", ((EPFeaturedCategory) (obj)).getCategoryId());
        as1[0] = Integer.toString(key);
        as1[2] = ((EPFeaturedCategory) (obj)).getCategoryId();
        contentvalues.put("sportId", ((EPFeaturedCategory) (obj)).getCategoryId());
        if (mEPFeaturedEventType == EPFeaturedEventType.VOD)
        {
            as1[1] = "VOD";
            s = (new StringBuilder(String.valueOf(((EPFeaturedCategory) (obj)).getVodUrl()))).append("?").toString();
            hashmap.put("featuredCatEventType", EPFeaturedEventType.VOD);
            limit = null;
            contentvalues.put("eventsType", "VOD");
        } else
        {
            as1[1] = mEPEventType.getEventStr();
            s = (new StringBuilder(String.valueOf(((EPFeaturedCategory) (obj)).getListingsUrl()))).append("&").toString();
            type = mEPEventType.getEventStr();
            hashmap.put("featuredCatEventType", EPFeaturedEventType.LINEAR);
            setDateRange(10, as);
            contentvalues.put("eventsType", mEPEventType.getEventStr());
        }
        obj1 = obj4;
        obj = obj5;
        lock = mLock;
        obj1 = obj4;
        obj = obj5;
        lock;
        JVM INSTR monitorenter ;
        obj1 = obj3;
        obj = cursor;
        cursor = DataManager.feedsDbConn.getMeta("metaEvents", "eventRelationId = ? and eventsType = ? and sportId = ?", as1);
        obj1 = cursor;
        obj = cursor;
        if (cursor.getCount() <= 0) goto _L2; else goto _L1
_L1:
        obj1 = cursor;
        obj = cursor;
        if (!cursor.moveToFirst()) goto _L2; else goto _L3
_L3:
        obj3 = cursor;
        obj1 = cursor;
        obj = cursor;
        if (!Utils.isExpired(cursor.getString(cursor.getColumnIndex("ttl"))))
        {
            break MISSING_BLOCK_LABEL_341;
        }
        obj1 = cursor;
        obj = cursor;
        hashmap.put("eventWhere", "metaEventRelationId = ? and eventType = ? and sportId = ?");
        obj1 = cursor;
        obj = cursor;
        hashmap.put("eventWhereArg", as1);
        obj1 = cursor;
        obj = cursor;
        DataManager.feedsDbConn.tempUpdateExpTimeForEvents("metaEvents", "eventRelationId = ? and eventsType = ? and sportId = ?", as1, contentvalues);
        obj1 = cursor;
        obj = cursor;
        feeds.getEventsForFeaturedCategory(s, hashmap, type, as[0], as[1], start, limit);
        obj3 = cursor;
_L7:
        obj = obj3;
        lock;
        JVM INSTR monitorexit ;
        if (obj3 != null)
        {
            ((Cursor) (obj3)).close();
        }
_L5:
        return;
_L2:
        obj1 = cursor;
        obj = cursor;
        DataManager.feedsDbConn.tempUpdateExpTimeForEvents("metaEvents", "eventRelationId = ? and eventsType = ? and sportId = ?", as1, contentvalues);
        obj1 = cursor;
        obj = cursor;
        feeds.getEventsForFeaturedCategory(s, hashmap, type, as[0], as[1], start, limit);
        obj3 = cursor;
        continue; /* Loop/switch isn't completed */
        Object obj2;
        obj2;
        obj = obj1;
        Utils.sdkLog("Error: ", 5, ((Exception) (obj2)));
        obj3 = obj1;
        continue; /* Loop/switch isn't completed */
        obj2;
        lock;
        JVM INSTR monitorexit ;
        obj1 = obj;
        throw obj2;
        obj2;
        obj = obj1;
        Utils.sdkLog("Error: ", 5, ((Exception) (obj2)));
        if (obj1 == null) goto _L5; else goto _L4
_L4:
        ((Cursor) (obj1)).close();
        return;
        Exception exception;
        exception;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw exception;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private void refreshSportEventsByLeague(String s, String s1, String s2, String s3)
    {
        Cursor cursor;
        Cursor cursor1;
        Cursor cursor2;
        Cursor cursor3;
        String as1[];
        String s5;
        ContentValues contentvalues;
        HashMap hashmap;
        EPCatalogManager.Lock lock;
        String as2[];
        cursor2 = null;
        Object obj = null;
        Object obj1 = null;
        cursor3 = null;
        contentvalues = new ContentValues();
        hashmap = new HashMap();
        String s4 = "metaEventRelationId = ? and sportId = ?";
        String as[];
        if (s1 != null)
        {
            s4 = (new StringBuilder(String.valueOf("metaEventRelationId = ? and sportId = ?"))).append(" and eventType = ?").toString();
            as = new String[3];
            as[2] = s1;
        } else
        {
            as = new String[2];
        }
        as[0] = "7";
        as[1] = s;
        s5 = "eventRelationId = ? and sportId = ?";
        if (s1 != null)
        {
            s5 = (new StringBuilder(String.valueOf("eventRelationId = ? and sportId = ?"))).append(" and eventsType = ?").toString();
            as1 = new String[3];
            as1[2] = s1;
            contentvalues.put("eventsType", s1);
        } else
        {
            as1 = new String[2];
        }
        as1[0] = "7";
        as1[1] = s;
        contentvalues.put("sportId", s);
        as2 = new String[2];
        setDateRange(10, as2);
        cursor1 = obj;
        cursor = obj1;
        lock = mLock;
        cursor1 = obj;
        cursor = obj1;
        lock;
        JVM INSTR monitorenter ;
        cursor1 = cursor3;
        cursor = cursor2;
        cursor2 = DataManager.feedsDbConn.getMeta("metaEvents", s5, as1);
        cursor1 = cursor2;
        cursor = cursor2;
        if (cursor2.getCount() <= 0) goto _L2; else goto _L1
_L1:
        cursor1 = cursor2;
        cursor = cursor2;
        if (!cursor2.moveToFirst()) goto _L2; else goto _L3
_L3:
        cursor3 = cursor2;
        cursor1 = cursor2;
        cursor = cursor2;
        if (!Utils.isExpired(cursor2.getString(cursor2.getColumnIndex("ttl"))))
        {
            break MISSING_BLOCK_LABEL_384;
        }
        cursor1 = cursor2;
        cursor = cursor2;
        hashmap.put("eventWhere", s4);
        cursor1 = cursor2;
        cursor = cursor2;
        hashmap.put("eventWhereArg", as);
        cursor1 = cursor2;
        cursor = cursor2;
        DataManager.feedsDbConn.tempUpdateExpTimeForEvents("metaEvents", s5, as1, contentvalues);
        cursor1 = cursor2;
        cursor = cursor2;
        feeds.getEventsBySportSortedByLeagueFeed(s, s1, s3, s2, start, as2[0], as2[1], hashmap);
        cursor3 = cursor2;
_L7:
        cursor = cursor3;
        lock;
        JVM INSTR monitorexit ;
        if (cursor3 != null)
        {
            cursor3.close();
        }
_L5:
        return;
_L2:
        cursor1 = cursor2;
        cursor = cursor2;
        DataManager.feedsDbConn.tempUpdateExpTimeForEvents("metaEvents", s5, as1, contentvalues);
        cursor1 = cursor2;
        cursor = cursor2;
        feeds.getEventsBySportSortedByLeagueFeed(s, s1, s3, s2, start, as2[0], as2[1], hashmap);
        cursor3 = cursor2;
        continue; /* Loop/switch isn't completed */
        s;
        cursor = cursor1;
        Utils.sdkLog("Error: ", 5, s);
        cursor3 = cursor1;
        continue; /* Loop/switch isn't completed */
        s;
        lock;
        JVM INSTR monitorexit ;
        cursor1 = cursor;
        try
        {
            throw s;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            cursor = cursor1;
        }
        finally
        {
            if (cursor == null) goto _L0; else goto _L0
        }
        Utils.sdkLog("Error: ", 5, s);
        if (cursor1 == null) goto _L5; else goto _L4
_L4:
        cursor1.close();
        return;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private void refreshSportsFeed(int i)
    {
        Cursor cursor;
        Cursor cursor1;
        Cursor cursor2;
        Cursor cursor3;
        Object obj1;
        Object obj2;
        String s;
        String as[];
        cursor2 = null;
        obj1 = null;
        obj2 = null;
        cursor3 = null;
        s = Integer.toString(i);
        as = new String[1];
        as[0] = s;
        cursor1 = obj1;
        cursor = obj2;
        EPCatalogManager.Lock lock = mLock;
        cursor1 = obj1;
        cursor = obj2;
        lock;
        JVM INSTR monitorenter ;
        cursor1 = cursor3;
        cursor = cursor2;
        cursor2 = DataManager.feedsDbConn.getMeta("metaSport", "sportrelationId= ?", as);
        cursor1 = cursor2;
        cursor = cursor2;
        if (cursor2.getCount() <= 0) goto _L2; else goto _L1
_L1:
        cursor1 = cursor2;
        cursor = cursor2;
        if (!cursor2.moveToFirst()) goto _L2; else goto _L3
_L3:
        cursor3 = cursor2;
        cursor1 = cursor2;
        cursor = cursor2;
        if (!Utils.isExpired(cursor2.getString(cursor2.getColumnIndex("TTL"))))
        {
            break MISSING_BLOCK_LABEL_191;
        }
        cursor1 = cursor2;
        cursor = cursor2;
        DataManager.feedsDbConn.tempUpdateExpTimeForMisc("metaSport", "sportrelationId= ?", as, new String[] {
            "TTL", "sportrelationId"
        });
        cursor1 = cursor2;
        cursor = cursor2;
        feeds.getSportsFeed(s);
        cursor3 = cursor2;
_L7:
        cursor = cursor3;
        lock;
        JVM INSTR monitorexit ;
        if (cursor3 != null)
        {
            cursor3.close();
        }
_L5:
        return;
_L2:
        cursor1 = cursor2;
        cursor = cursor2;
        DataManager.feedsDbConn.tempUpdateExpTimeForMisc("metaSport", "sportrelationId= ?", as, new String[] {
            "TTL", "sportrelationId"
        });
        cursor1 = cursor2;
        cursor = cursor2;
        feeds.getSportsFeed(s);
        cursor3 = cursor2;
        continue; /* Loop/switch isn't completed */
        Object obj;
        obj;
        cursor = cursor1;
        Utils.sdkLog("Error: ", 5, ((Exception) (obj)));
        cursor3 = cursor1;
        continue; /* Loop/switch isn't completed */
        obj;
        lock;
        JVM INSTR monitorexit ;
        cursor1 = cursor;
        throw obj;
        obj;
        cursor = cursor1;
        Utils.sdkLog("Error: ", 5, ((Exception) (obj)));
        if (cursor1 == null) goto _L5; else goto _L4
_L4:
        cursor1.close();
        return;
        Exception exception;
        exception;
        if (cursor != null)
        {
            cursor.close();
        }
        throw exception;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private void refreshTopSportEvents()
    {
        Object obj;
        Object obj1;
        String s;
        Cursor cursor;
        Object obj3;
        ContentValues contentvalues;
        HashMap hashmap;
        String as[];
        String as1[];
        EPCatalogManager.Lock lock;
        boolean flag;
        cursor = null;
        Object obj4 = null;
        Object obj5 = null;
        obj3 = null;
        contentvalues = new ContentValues();
        flag = false;
        hashmap = new HashMap();
        as = new String[3];
        as1 = new String[3];
        obj = (EPSport)mObject;
        as1[0] = Integer.toString(key);
        hashmap.put("sportId", ((EPSport) (obj)).getId());
        as1[2] = ((EPSport) (obj)).getId();
        contentvalues.put("sportId", ((EPSport) (obj)).getId());
        if (mEPFeaturedEventType == EPFeaturedEventType.VOD)
        {
            flag = true;
            as1[1] = "VOD";
            s = ((EPSport) (obj)).getVodLink();
            hashmap.put("featuredTopSportEventType", EPFeaturedEventType.VOD);
            limit = null;
            contentvalues.put("eventsType", "VOD");
        } else
        if (mEPEventType == null)
        {
            as1[1] = "top";
            s = ((EPSport) (obj)).getTopListingLink();
            type = null;
            hashmap.put("featuredTopSportEventType", EPFeaturedEventType.LINEAR);
            hashmap.put("eventType", "top");
            contentvalues.put("eventsType", "top");
        } else
        {
            as1[1] = mEPEventType.getEventStr();
            s = ((EPSport) (obj)).getListingLink();
            type = mEPEventType.getEventStr();
            hashmap.put("featuredTopSportEventType", EPFeaturedEventType.LINEAR);
            setDateRange(10, as);
            contentvalues.put("eventsType", mEPEventType.getEventStr());
        }
        obj1 = obj4;
        obj = obj5;
        lock = mLock;
        obj1 = obj4;
        obj = obj5;
        lock;
        JVM INSTR monitorenter ;
        obj1 = obj3;
        obj = cursor;
        cursor = DataManager.feedsDbConn.getMeta("metaEvents", "eventRelationId = ? and eventsType = ? and sportId = ?", as1);
        obj1 = cursor;
        obj = cursor;
        if (cursor.getCount() <= 0) goto _L2; else goto _L1
_L1:
        obj1 = cursor;
        obj = cursor;
        if (!cursor.moveToFirst()) goto _L2; else goto _L3
_L3:
        obj3 = cursor;
        obj1 = cursor;
        obj = cursor;
        if (!Utils.isExpired(cursor.getString(cursor.getColumnIndex("ttl"))))
        {
            break MISSING_BLOCK_LABEL_351;
        }
        obj1 = cursor;
        obj = cursor;
        hashmap.put("eventWhere", "metaEventRelationId = ? and eventType = ? and sportId = ?");
        obj1 = cursor;
        obj = cursor;
        hashmap.put("eventWhereArg", as1);
        obj1 = cursor;
        obj = cursor;
        DataManager.feedsDbConn.tempUpdateExpTimeForEvents("metaEvents", "eventRelationId = ? and eventsType = ? and sportId = ?", as1, contentvalues);
        obj1 = cursor;
        obj = cursor;
        feeds.getEventsForTopSport(s, hashmap, type, as[0], as[1], start, limit, flag);
        obj3 = cursor;
_L7:
        obj = obj3;
        lock;
        JVM INSTR monitorexit ;
        if (obj3 != null)
        {
            ((Cursor) (obj3)).close();
        }
_L5:
        return;
_L2:
        obj1 = cursor;
        obj = cursor;
        DataManager.feedsDbConn.tempUpdateExpTimeForEvents("metaEvents", "eventRelationId = ? and eventsType = ? and sportId = ?", as1, contentvalues);
        obj1 = cursor;
        obj = cursor;
        feeds.getEventsForTopSport(s, hashmap, type, as[0], as[1], start, limit, flag);
        obj3 = cursor;
        continue; /* Loop/switch isn't completed */
        Object obj2;
        obj2;
        obj = obj1;
        Utils.sdkLog("Error: ", 5, ((Exception) (obj2)));
        obj3 = obj1;
        continue; /* Loop/switch isn't completed */
        obj2;
        lock;
        JVM INSTR monitorexit ;
        obj1 = obj;
        throw obj2;
        obj2;
        obj = obj1;
        Utils.sdkLog("Error: ", 5, ((Exception) (obj2)));
        if (obj1 == null) goto _L5; else goto _L4
_L4:
        ((Cursor) (obj1)).close();
        return;
        Exception exception;
        exception;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw exception;
        if (true) goto _L7; else goto _L6
_L6:
    }

    void getFeaturedEvents(int i, HashMap hashmap)
    {
        i;
        JVM INSTR tableswitch 11 18: default 48
    //                   11 49
    //                   12 58
    //                   13 92
    //                   14 101
    //                   15 110
    //                   16 72
    //                   17 119
    //                   18 58;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L3
_L1:
        return;
_L2:
        feeds.getFeturedEventsFeed(hashmap);
        return;
_L3:
        feeds.getFeturedEventsForE3Feed(i, subKeyMeta, hashmap);
        return;
_L7:
        if (epSport != null)
        {
            feeds.getFeturedEventsForCatagoryFeed(epSport, hashmap);
            return;
        }
          goto _L1
_L4:
        feeds.getMustSeeFeturedEvents(hashmap);
        return;
_L5:
        feeds.getBestOfFeturedEvents(hashmap);
        return;
_L6:
        feeds.getTopVODFeturedEvents(hashmap);
        return;
_L8:
        feeds.getTrendingFeturedEvents(hashmap);
        return;
    }

    protected void refreshLiveEvents()
    {
        Cursor cursor;
        Cursor cursor1;
        Cursor cursor2;
        Cursor cursor3;
        Object obj1;
        Object obj2;
        HashMap hashmap;
        String as[];
        cursor2 = null;
        obj1 = null;
        obj2 = null;
        cursor3 = null;
        hashmap = new HashMap();
        as = new String[1];
        as[0] = "1";
        cursor1 = obj1;
        cursor = obj2;
        EPCatalogManager.Lock lock = mLock;
        cursor1 = obj1;
        cursor = obj2;
        lock;
        JVM INSTR monitorenter ;
        cursor1 = cursor3;
        cursor = cursor2;
        cursor2 = DataManager.feedsDbConn.getMeta("metaEvents", "eventRelationId = ?", as);
        cursor1 = cursor2;
        cursor = cursor2;
        if (cursor2.getCount() <= 0) goto _L2; else goto _L1
_L1:
        cursor1 = cursor2;
        cursor = cursor2;
        if (!cursor2.moveToFirst()) goto _L2; else goto _L3
_L3:
        cursor3 = cursor2;
        cursor1 = cursor2;
        cursor = cursor2;
        if (!Utils.isExpired(cursor2.getString(cursor2.getColumnIndex("ttl"))))
        {
            break MISSING_BLOCK_LABEL_189;
        }
        cursor1 = cursor2;
        cursor = cursor2;
        hashmap.put("eventWhere", "metaEventRelationId = ?");
        cursor1 = cursor2;
        cursor = cursor2;
        hashmap.put("eventWhereArg", as);
        cursor1 = cursor2;
        cursor = cursor2;
        DataManager.feedsDbConn.tempUpdateExpTimeForEvents("metaEvents", "eventRelationId = ?", as, null);
        cursor1 = cursor2;
        cursor = cursor2;
        feeds.getLiveEventsFeed(hashmap);
        cursor3 = cursor2;
_L7:
        cursor = cursor3;
        lock;
        JVM INSTR monitorexit ;
        if (cursor3 != null)
        {
            cursor3.close();
        }
_L5:
        return;
_L2:
        cursor1 = cursor2;
        cursor = cursor2;
        DataManager.feedsDbConn.tempUpdateExpTimeForEvents("metaEvents", "eventRelationId = ?", as, null);
        cursor1 = cursor2;
        cursor = cursor2;
        feeds.getLiveEventsFeed(hashmap);
        cursor3 = cursor2;
        continue; /* Loop/switch isn't completed */
        Object obj;
        obj;
        cursor = cursor1;
        Utils.sdkLog("Error: ", 5, ((Exception) (obj)));
        cursor3 = cursor1;
        continue; /* Loop/switch isn't completed */
        obj;
        lock;
        JVM INSTR monitorexit ;
        cursor1 = cursor;
        throw obj;
        obj;
        cursor = cursor1;
        Utils.sdkLog("Error: ", 5, ((Exception) (obj)));
        if (cursor1 == null) goto _L5; else goto _L4
_L4:
        cursor1.close();
        return;
        Exception exception;
        exception;
        if (cursor != null)
        {
            cursor.close();
        }
        throw exception;
        if (true) goto _L7; else goto _L6
_L6:
    }

    protected void refreshfeaturedEvents(int i)
    {
        Cursor cursor;
        Cursor cursor1;
        Cursor cursor2;
        Cursor cursor3;
        ContentValues contentvalues;
        String as[];
        String s1;
        HashMap hashmap;
        EPCatalogManager.Lock lock;
        cursor2 = null;
        Object obj1 = null;
        Object obj2 = null;
        cursor3 = null;
        contentvalues = null;
        hashmap = new HashMap();
        String s = "metaEventRelationId = ?";
        s1 = "eventRelationId = ?";
        if (epSport != null)
        {
            s = (new StringBuilder(String.valueOf("metaEventRelationId = ?"))).append(" and sportId = ?").toString();
            s1 = (new StringBuilder(String.valueOf("eventRelationId = ?"))).append(" and sportId = ?").toString();
            as = new String[2];
            as[1] = epSport.getId();
            contentvalues = new ContentValues();
            contentvalues.put("sportId", epSport.getId());
        } else
        {
            as = new String[1];
        }
        as[0] = Integer.toString(i);
        cursor1 = obj1;
        cursor = obj2;
        lock = mLock;
        cursor1 = obj1;
        cursor = obj2;
        lock;
        JVM INSTR monitorenter ;
        cursor1 = cursor3;
        cursor = cursor2;
        cursor2 = DataManager.feedsDbConn.getMeta("metaEvents", s1, as);
        cursor1 = cursor2;
        cursor = cursor2;
        if (cursor2.getCount() <= 0) goto _L2; else goto _L1
_L1:
        cursor1 = cursor2;
        cursor = cursor2;
        if (!cursor2.moveToFirst()) goto _L2; else goto _L3
_L3:
        cursor3 = cursor2;
        cursor1 = cursor2;
        cursor = cursor2;
        if (!Utils.isExpired(cursor2.getString(cursor2.getColumnIndex("ttl"))))
        {
            break MISSING_BLOCK_LABEL_312;
        }
        cursor1 = cursor2;
        cursor = cursor2;
        hashmap.put("eventWhere", s);
        cursor1 = cursor2;
        cursor = cursor2;
        hashmap.put("eventWhereArg", as);
        cursor1 = cursor2;
        cursor = cursor2;
        DataManager.feedsDbConn.tempUpdateExpTimeForEvents("metaEvents", s1, as, contentvalues);
        cursor1 = cursor2;
        cursor = cursor2;
        getFeaturedEvents(i, hashmap);
        cursor3 = cursor2;
_L7:
        cursor = cursor3;
        lock;
        JVM INSTR monitorexit ;
        if (cursor3 != null)
        {
            cursor3.close();
        }
_L5:
        return;
_L2:
        cursor1 = cursor2;
        cursor = cursor2;
        DataManager.feedsDbConn.tempUpdateExpTimeForEvents("metaEvents", s1, as, contentvalues);
        cursor1 = cursor2;
        cursor = cursor2;
        getFeaturedEvents(i, hashmap);
        cursor3 = cursor2;
        continue; /* Loop/switch isn't completed */
        Object obj;
        obj;
        cursor = cursor1;
        Utils.sdkLog("Error: ", 5, ((Exception) (obj)));
        cursor3 = cursor1;
        continue; /* Loop/switch isn't completed */
        obj;
        lock;
        JVM INSTR monitorexit ;
        cursor1 = cursor;
        throw obj;
        obj;
        cursor = cursor1;
        Utils.sdkLog("Error: ", 5, ((Exception) (obj)));
        if (cursor1 == null) goto _L5; else goto _L4
_L4:
        cursor1.close();
        return;
        Exception exception;
        exception;
        if (cursor != null)
        {
            cursor.close();
        }
        throw exception;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void run()
    {
        super.run();
        switch (key)
        {
        case 8: // '\b'
        case 11: // '\013'
        case 12: // '\f'
        case 13: // '\r'
        case 14: // '\016'
        case 15: // '\017'
        case 16: // '\020'
        case 17: // '\021'
        case 18: // '\022'
        case 19: // '\023'
        case 23: // '\027'
        case 24: // '\030'
        case 25: // '\031'
        case 26: // '\032'
        case 27: // '\033'
        case 28: // '\034'
        case 29: // '\035'
        default:
            return;

        case 1: // '\001'
            refreshChannelsFeed();
            return;

        case 2: // '\002'
            refreshConfigFeed();
            return;

        case 3: // '\003'
            refreshEventsByChannelsFeed(networkCode, networkId, type, limit, start);
            return;

        case 4: // '\004'
            loadEventsForChannel(networkCode, networkId, type, limit);
            return;

        case 5: // '\005'
            refreshSportsFeed(subKey);
            return;

        case 6: // '\006'
            refreshEventsBySportFeed(sport, sportsid, type, limit, start);
            return;

        case 7: // '\007'
            loadEventsForSport(sportsid, type, limit);
            return;

        case 10: // '\n'
            refreshfeaturedEvents(subKey);
            return;

        case 9: // '\t'
            refreshLiveEvents();
            return;

        case 0: // '\0'
            refreshSportEventsByLeague(sportsid, type, limit, abbre);
            return;

        case 20: // '\024'
            refreshChannelEventsByLeague(networkId, networkCode, type, limit);
            return;

        case 21: // '\025'
            loadEventsForChannelByLeague(networkCode, networkId, type, limit);
            return;

        case 22: // '\026'
            loadEventsForSportByLeague(sportsid, type, abbre, limit);
            return;

        case 30: // '\036'
            refreshFeaturedCategory();
            return;

        case 31: // '\037'
            refreshFeaturedCategoryEvents();
            return;

        case 32: // ' '
            refreshTopSportEvents();
            break;
        }
    }

    transient void setDateRange(int i, String as[])
    {
        Date date1;
        SimpleDateFormat simpledateformat;
        GregorianCalendar gregoriancalendar;
        gregoriancalendar = new GregorianCalendar(TimeZone.getDefault(), Locale.US);
        simpledateformat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        date1 = new Date();
        if (!type.equals(EPEventType.UPCOMING.getEventStr())) goto _L2; else goto _L1
_L1:
        Date date;
        gregoriancalendar.add(5, 365);
        date = gregoriancalendar.getTime();
_L3:
        as[0] = simpledateformat.format(date1).replace("-", "");
        as[1] = simpledateformat.format(date).replace("-", "");
        return;
_L2:
        if (!type.equals(EPEventType.REPLAY.getEventStr()))
        {
            break MISSING_BLOCK_LABEL_147;
        }
        gregoriancalendar.add(5, -365);
        date = date1;
        try
        {
            date1 = gregoriancalendar.getTime();
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            Utils.sdkLog("Error: ", 5, as);
            return;
        }
          goto _L3
        date = gregoriancalendar.getTime();
          goto _L3
    }
}
