// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.analytics;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.location.Location;
import android.util.Log;
import com.medialets.thrift.AdEvent;
import com.medialets.thrift.Event;
import com.medialets.thrift.Run;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.thrift.TDeserializer;
import org.apache.thrift.TException;

// Referenced classes of package com.medialets.analytics:
//            d, e, g

final class a extends SQLiteOpenHelper
    implements d
{

    private static Lock b = new ReentrantLock();
    private int a;

    public a(Context context)
    {
        super(context, "_MMTracking", null, 6);
        a = 0;
        a = (int)(System.currentTimeMillis() / 1000L);
    }

    private List a(long l)
    {
        Cursor cursor;
        Cursor cursor1;
        Object obj;
        Object obj1;
        Cursor cursor2;
        TDeserializer tdeserializer;
        ArrayList arraylist;
        obj1 = null;
        obj = null;
        tdeserializer = null;
        cursor2 = null;
        arraylist = new ArrayList();
        b.lock();
        cursor = cursor2;
        cursor1 = tdeserializer;
        Object obj2 = getWritableDatabase();
        cursor = cursor2;
        obj = obj2;
        cursor1 = tdeserializer;
        obj1 = obj2;
        cursor2 = ((SQLiteDatabase) (obj2)).rawQuery("SELECT dbID, timestamp, eventType, connStatus, latitude, longitude, altitude, countForMonth, countForDay, countForHour,  userEvent, accuracy, bearing, dur FROM v2TrackedEvents WHERE runId=? AND isAdEvent=? ORDER BY timestamp", new String[] {
            Long.toString(l), "0"
        });
        cursor = cursor2;
        obj = obj2;
        cursor1 = cursor2;
        obj1 = obj2;
        cursor2.moveToFirst();
        cursor = cursor2;
        obj = obj2;
        cursor1 = cursor2;
        obj1 = obj2;
        tdeserializer = new TDeserializer();
_L4:
        cursor = cursor2;
        obj = obj2;
        cursor1 = cursor2;
        obj1 = obj2;
        if (cursor2.isAfterLast())
        {
            break MISSING_BLOCK_LABEL_922;
        }
        cursor = cursor2;
        obj = obj2;
        cursor1 = cursor2;
        obj1 = obj2;
        Event event = new Event();
        cursor = cursor2;
        obj = obj2;
        cursor1 = cursor2;
        obj1 = obj2;
        tdeserializer.deserialize(event, cursor2.getBlob(10));
        cursor = cursor2;
        obj = obj2;
        cursor1 = cursor2;
        obj1 = obj2;
        event.setEventID(Long.toString(cursor2.getLong(0)));
        cursor = cursor2;
        obj = obj2;
        cursor1 = cursor2;
        obj1 = obj2;
        event.setKey(cursor2.getString(2));
        cursor = cursor2;
        obj = obj2;
        cursor1 = cursor2;
        obj1 = obj2;
        if (event.isSetTime())
        {
            break MISSING_BLOCK_LABEL_329;
        }
        cursor = cursor2;
        obj = obj2;
        cursor1 = cursor2;
        obj1 = obj2;
        event.setTime(e.a(new Date(cursor2.getLong(1))));
        cursor = cursor2;
        obj = obj2;
        cursor1 = cursor2;
        obj1 = obj2;
        event.setConn(cursor2.getInt(3));
        cursor = cursor2;
        obj = obj2;
        cursor1 = cursor2;
        obj1 = obj2;
        if (cursor2.isNull(4))
        {
            break MISSING_BLOCK_LABEL_411;
        }
        cursor = cursor2;
        obj = obj2;
        cursor1 = cursor2;
        obj1 = obj2;
        event.setLat(cursor2.getDouble(4));
        cursor = cursor2;
        obj = obj2;
        cursor1 = cursor2;
        obj1 = obj2;
        if (cursor2.isNull(5))
        {
            break MISSING_BLOCK_LABEL_465;
        }
        cursor = cursor2;
        obj = obj2;
        cursor1 = cursor2;
        obj1 = obj2;
        event.setLon(cursor2.getDouble(5));
        cursor = cursor2;
        obj = obj2;
        cursor1 = cursor2;
        obj1 = obj2;
        if (cursor2.isNull(6))
        {
            break MISSING_BLOCK_LABEL_521;
        }
        cursor = cursor2;
        obj = obj2;
        cursor1 = cursor2;
        obj1 = obj2;
        event.setAlt(cursor2.getDouble(6));
        cursor = cursor2;
        obj = obj2;
        cursor1 = cursor2;
        obj1 = obj2;
        if (cursor2.isNull(11))
        {
            break MISSING_BLOCK_LABEL_577;
        }
        cursor = cursor2;
        obj = obj2;
        cursor1 = cursor2;
        obj1 = obj2;
        event.setHorizontalAccuracy(cursor2.getDouble(11));
        cursor = cursor2;
        obj = obj2;
        cursor1 = cursor2;
        obj1 = obj2;
        if (cursor2.isNull(12))
        {
            break MISSING_BLOCK_LABEL_633;
        }
        cursor = cursor2;
        obj = obj2;
        cursor1 = cursor2;
        obj1 = obj2;
        event.setDirection(cursor2.getDouble(12));
        cursor = cursor2;
        obj = obj2;
        cursor1 = cursor2;
        obj1 = obj2;
        event.setCountMon(cursor2.getShort(7));
        cursor = cursor2;
        obj = obj2;
        cursor1 = cursor2;
        obj1 = obj2;
        event.setCountDay(cursor2.getShort(8));
        cursor = cursor2;
        obj = obj2;
        cursor1 = cursor2;
        obj1 = obj2;
        event.setCountHr(cursor2.getShort(9));
        cursor = cursor2;
        obj = obj2;
        cursor1 = cursor2;
        obj1 = obj2;
        arraylist.add(event);
_L2:
        cursor = cursor2;
        obj = obj2;
        cursor1 = cursor2;
        obj1 = obj2;
        TException texception;
        try
        {
            cursor2.moveToNext();
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Object obj2)
        {
            cursor1 = cursor;
            obj1 = obj;
        }
        finally
        {
            if (cursor1 != null)
            {
                cursor1.close();
            }
            if (obj1 != null)
            {
                ((SQLiteDatabase) (obj1)).close();
            }
            b.unlock();
            throw exception;
        }
        Log.e("MMT.MMDatabase", (new StringBuilder()).append("Exception gettings events for transport: ").append(((SQLException) (obj2)).toString()).toString());
        if (cursor != null)
        {
            cursor.close();
        }
        if (obj != null)
        {
            ((SQLiteDatabase) (obj)).close();
        }
        b.unlock();
        return arraylist;
        texception;
        cursor = cursor2;
        obj = obj2;
        cursor1 = cursor2;
        obj1 = obj2;
        Log.d("MMT.MMDatabase", (new StringBuilder()).append("Thrift exception caught:: ").append(texception.toString()).toString());
        if (true) goto _L2; else goto _L1
_L1:
        if (cursor2 != null)
        {
            cursor2.close();
        }
        if (obj2 != null)
        {
            ((SQLiteDatabase) (obj2)).close();
        }
        b.unlock();
        return arraylist;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private List b(long l)
    {
        Cursor cursor;
        Cursor cursor1;
        Object obj;
        Object obj1;
        Cursor cursor2;
        AdEvent adevent;
        ArrayList arraylist;
        TDeserializer tdeserializer;
        obj1 = null;
        obj = null;
        adevent = null;
        cursor2 = null;
        arraylist = new ArrayList();
        tdeserializer = new TDeserializer();
        b.lock();
        cursor = cursor2;
        cursor1 = adevent;
        Object obj2 = getWritableDatabase();
        cursor = cursor2;
        obj = obj2;
        cursor1 = adevent;
        obj1 = obj2;
        cursor2 = ((SQLiteDatabase) (obj2)).rawQuery("SELECT dbID, timestamp, eventType, connStatus, latitude, longitude, altitude, countForMonth, countForDay, countForHour, userEvent, accuracy, bearing, slotName, dur FROM v2TrackedEvents WHERE runId=? AND isAdEvent=? ORDER BY timestamp", new String[] {
            Long.toString(l), "1"
        });
        cursor = cursor2;
        obj = obj2;
        cursor1 = cursor2;
        obj1 = obj2;
        cursor2.moveToFirst();
_L4:
        cursor = cursor2;
        obj = obj2;
        cursor1 = cursor2;
        obj1 = obj2;
        if (cursor2.isAfterLast())
        {
            break MISSING_BLOCK_LABEL_892;
        }
        cursor = cursor2;
        obj = obj2;
        cursor1 = cursor2;
        obj1 = obj2;
        adevent = new AdEvent();
        cursor = cursor2;
        obj = obj2;
        cursor1 = cursor2;
        obj1 = obj2;
        tdeserializer.deserialize(adevent, cursor2.getBlob(10));
        cursor = cursor2;
        obj = obj2;
        cursor1 = cursor2;
        obj1 = obj2;
        adevent.setEventID(Long.toString(cursor2.getLong(0)));
        cursor = cursor2;
        obj = obj2;
        cursor1 = cursor2;
        obj1 = obj2;
        adevent.setKey(cursor2.getString(2));
        cursor = cursor2;
        obj = obj2;
        cursor1 = cursor2;
        obj1 = obj2;
        if (adevent.isSetTime())
        {
            break MISSING_BLOCK_LABEL_314;
        }
        cursor = cursor2;
        obj = obj2;
        cursor1 = cursor2;
        obj1 = obj2;
        adevent.setTime(e.a(new Date(cursor2.getLong(1))));
        cursor = cursor2;
        obj = obj2;
        cursor1 = cursor2;
        obj1 = obj2;
        adevent.setConn(cursor2.getInt(3));
        cursor = cursor2;
        obj = obj2;
        cursor1 = cursor2;
        obj1 = obj2;
        adevent.setFieldValue(26, cursor2.getString(13));
        cursor = cursor2;
        obj = obj2;
        cursor1 = cursor2;
        obj1 = obj2;
        if (cursor2.isNull(4))
        {
            break MISSING_BLOCK_LABEL_427;
        }
        cursor = cursor2;
        obj = obj2;
        cursor1 = cursor2;
        obj1 = obj2;
        adevent.setLat(cursor2.getDouble(4));
        cursor = cursor2;
        obj = obj2;
        cursor1 = cursor2;
        obj1 = obj2;
        if (cursor2.isNull(5))
        {
            break MISSING_BLOCK_LABEL_481;
        }
        cursor = cursor2;
        obj = obj2;
        cursor1 = cursor2;
        obj1 = obj2;
        adevent.setLon(cursor2.getDouble(5));
        cursor = cursor2;
        obj = obj2;
        cursor1 = cursor2;
        obj1 = obj2;
        if (cursor2.isNull(6))
        {
            break MISSING_BLOCK_LABEL_537;
        }
        cursor = cursor2;
        obj = obj2;
        cursor1 = cursor2;
        obj1 = obj2;
        adevent.setAlt(cursor2.getDouble(6));
        cursor = cursor2;
        obj = obj2;
        cursor1 = cursor2;
        obj1 = obj2;
        if (cursor2.isNull(14))
        {
            break MISSING_BLOCK_LABEL_603;
        }
        cursor = cursor2;
        obj = obj2;
        cursor1 = cursor2;
        obj1 = obj2;
        adevent.setUDur((new Integer(cursor2.getInt(14))).shortValue());
        cursor = cursor2;
        obj = obj2;
        cursor1 = cursor2;
        obj1 = obj2;
        adevent.setCountMon(cursor2.getShort(7));
        cursor = cursor2;
        obj = obj2;
        cursor1 = cursor2;
        obj1 = obj2;
        adevent.setCountDay(cursor2.getShort(8));
        cursor = cursor2;
        obj = obj2;
        cursor1 = cursor2;
        obj1 = obj2;
        adevent.setCountHr(cursor2.getShort(9));
        cursor = cursor2;
        obj = obj2;
        cursor1 = cursor2;
        obj1 = obj2;
        arraylist.add(adevent);
_L2:
        cursor = cursor2;
        obj = obj2;
        cursor1 = cursor2;
        obj1 = obj2;
        TException texception;
        try
        {
            cursor2.moveToNext();
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Object obj2)
        {
            cursor1 = cursor;
            obj1 = obj;
        }
        finally
        {
            if (cursor1 != null)
            {
                cursor1.close();
            }
            if (obj1 != null)
            {
                ((SQLiteDatabase) (obj1)).close();
            }
            b.unlock();
            throw exception;
        }
        Log.e("MMT.MMDatabase", (new StringBuilder()).append("Exception getting ad events for transport: ").append(((SQLException) (obj2)).toString()).toString());
        if (cursor != null)
        {
            cursor.close();
        }
        if (obj != null)
        {
            ((SQLiteDatabase) (obj)).close();
        }
        b.unlock();
        return arraylist;
        texception;
        cursor = cursor2;
        obj = obj2;
        cursor1 = cursor2;
        obj1 = obj2;
        Log.d("MMT.MMDatabase", (new StringBuilder()).append("Thrift exception caught:: ").append(texception.toString()).toString());
        if (true) goto _L2; else goto _L1
_L1:
        if (cursor2 != null)
        {
            cursor2.close();
        }
        if (obj2 != null)
        {
            ((SQLiteDatabase) (obj2)).close();
        }
        b.unlock();
        return arraylist;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private e c()
    {
        SQLiteDatabase sqlitedatabase;
        SQLiteDatabase sqlitedatabase1;
        sqlitedatabase1 = null;
        sqlitedatabase = null;
        b.lock();
        SQLiteDatabase sqlitedatabase2 = getWritableDatabase();
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        sqlitedatabase2.beginTransaction();
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        long l3 = System.currentTimeMillis();
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        Object obj = new ContentValues();
        long l;
        long l1;
        long l2;
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        flag3 = false;
        flag2 = false;
        flag1 = false;
        flag = false;
        l = 1L;
        l1 = 1L;
        l2 = 1L;
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        Cursor cursor = sqlitedatabase2.rawQuery("SELECT dbID, maxTimestamp, countForMonth, countForDay, countForHour FROM runMaxTimestamps", null);
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        ((ContentValues) (obj)).put("maxTimestamp", Long.valueOf(l3));
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        if (cursor.getCount() != 0) goto _L2; else goto _L1
_L1:
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        ((ContentValues) (obj)).put("countForMonth", Integer.valueOf(1));
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        ((ContentValues) (obj)).put("countForDay", Integer.valueOf(1));
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        ((ContentValues) (obj)).put("countForHour", Integer.valueOf(1));
        flag3 = true;
        flag2 = true;
        flag1 = true;
        flag = true;
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        sqlitedatabase2.insert("runMaxTimestamps", "maxTimestamp", ((ContentValues) (obj)));
_L8:
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        ((ContentValues) (obj)).put("countForMonth", Long.valueOf(l));
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        ((ContentValues) (obj)).put("countForDay", Long.valueOf(l1));
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        ((ContentValues) (obj)).put("countForHour", Long.valueOf(l2));
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        sqlitedatabase2.update("runMaxTimestamps", ((ContentValues) (obj)), null, null);
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        cursor.close();
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        cursor = sqlitedatabase2.rawQuery("SELECT MAX(timestamp+dur) FROM v2TrackedRuns", null);
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        cursor.moveToFirst();
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        long l4 = cursor.getLong(0);
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        cursor.close();
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        ((ContentValues) (obj)).clear();
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        ((ContentValues) (obj)).put("isComplete", Boolean.valueOf(false));
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        ((ContentValues) (obj)).put("hadAbEnd", Boolean.valueOf(false));
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        ((ContentValues) (obj)).put("wasBroadcast", Boolean.valueOf(false));
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        ((ContentValues) (obj)).put("timestamp", Long.valueOf(l3));
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        ((ContentValues) (obj)).put("isFirstEver", Boolean.valueOf(flag3));
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        ((ContentValues) (obj)).put("isFirstForMonth", Boolean.valueOf(flag2));
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        ((ContentValues) (obj)).put("isFirstForDay", Boolean.valueOf(flag1));
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        ((ContentValues) (obj)).put("isFirstForHour", Boolean.valueOf(flag));
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        ((ContentValues) (obj)).put("countForMonth", Long.valueOf(l));
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        ((ContentValues) (obj)).put("countForDay", Long.valueOf(l1));
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        ((ContentValues) (obj)).put("countForHour", Long.valueOf(l2));
        if (l4 <= 0L) goto _L4; else goto _L3
_L3:
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        ((ContentValues) (obj)).put("interval", Long.valueOf(l3 - l4));
_L6:
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        if (a == 0)
        {
            break MISSING_BLOCK_LABEL_578;
        }
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        ((ContentValues) (obj)).put("dbID", Integer.toString(a));
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        a = 0;
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        obj = new e(sqlitedatabase2.insert("v2TrackedRuns", "isComplete", ((ContentValues) (obj))));
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        sqlitedatabase2.setTransactionSuccessful();
        if (sqlitedatabase2 != null)
        {
            sqlitedatabase2.endTransaction();
            sqlitedatabase2.close();
        }
        b.unlock();
        return ((e) (obj));
_L2:
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        cursor.moveToFirst();
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        l4 = cursor.getLong(1);
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        Calendar calendar = Calendar.getInstance();
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        Calendar calendar1 = Calendar.getInstance();
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        calendar1.setTimeInMillis(l4);
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        calendar.setTimeInMillis(l3);
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        if (calendar.get(2) != calendar1.get(2))
        {
            flag2 = true;
            flag1 = true;
            flag = true;
            continue; /* Loop/switch isn't completed */
        }
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        if (calendar.get(5) == calendar1.get(5))
        {
            break MISSING_BLOCK_LABEL_776;
        }
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        l = cursor.getInt(2) + 1;
        flag1 = true;
        flag = true;
        continue; /* Loop/switch isn't completed */
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        if (calendar.get(11) == calendar1.get(11))
        {
            break MISSING_BLOCK_LABEL_837;
        }
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        l = cursor.getInt(2) + 1;
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        l1 = cursor.getInt(3) + 1;
        flag = true;
        continue; /* Loop/switch isn't completed */
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        l = cursor.getInt(2) + 1;
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        l1 = cursor.getInt(3) + 1;
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        l2 = cursor.getInt(4) + 1;
        continue; /* Loop/switch isn't completed */
_L4:
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        ((ContentValues) (obj)).put("interval", Integer.valueOf(0));
        if (true) goto _L6; else goto _L5
_L5:
        SQLException sqlexception;
        sqlexception;
        sqlitedatabase1 = sqlitedatabase;
        Log.e("MMT.MMDatabase", (new StringBuilder()).append("SQLException beginning analytics run: ").append(sqlexception.toString()).toString());
        if (sqlitedatabase != null)
        {
            sqlitedatabase.endTransaction();
            sqlitedatabase.close();
        }
        b.unlock();
        return null;
        Exception exception;
        exception;
        if (sqlitedatabase1 != null)
        {
            sqlitedatabase1.endTransaction();
            sqlitedatabase1.close();
        }
        b.unlock();
        throw exception;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public final e a()
    {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        obj2 = null;
        obj3 = null;
        obj = null;
        obj4 = null;
        b.lock();
        SQLiteDatabase sqlitedatabase = getReadableDatabase();
        Object obj1;
        obj3 = obj;
        SQLiteDatabase sqlitedatabase1 = sqlitedatabase;
        Exception exception;
        long l;
        try
        {
            obj1 = sqlitedatabase.rawQuery("SELECT MAX(timestamp+dur), dbID FROM v2TrackedRuns WHERE isComplete != '1'", null);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            exception = null;
            continue; /* Loop/switch isn't completed */
        }
        finally
        {
            sqlitedatabase = sqlitedatabase1;
            continue;
        }
        obj = obj4;
        if (!((Cursor) (obj1)).moveToNext())
        {
            break MISSING_BLOCK_LABEL_92;
        }
        l = ((Cursor) (obj1)).getLong(0);
        obj = obj4;
        try
        {
            if (System.currentTimeMillis() - l < (long)g.MIN_RUN_GAP_MSEC)
            {
                obj = new e(((Cursor) (obj1)).getLong(1));
            }
        }
        catch (SQLException sqlexception)
        {
            exception = null;
            obj2 = obj1;
            obj1 = sqlexception;
            continue; /* Loop/switch isn't completed */
        }
        finally
        {
            obj3 = obj1;
        }
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_105;
        }
        obj2 = c();
        obj = obj2;
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        if (sqlitedatabase != null)
        {
            sqlitedatabase.close();
        }
        b.unlock();
        return ((e) (obj));
        obj1;
        sqlitedatabase = null;
        obj = null;
_L2:
        obj3 = obj2;
        sqlitedatabase1 = sqlitedatabase;
        Log.e("MMT.MMDatabase", (new StringBuilder()).append("Error getting the analytics run context: ").append(((SQLException) (obj1)).toString()).toString());
        if (obj2 != null)
        {
            ((Cursor) (obj2)).close();
        }
        if (sqlitedatabase != null)
        {
            sqlitedatabase.close();
        }
        b.unlock();
        return ((e) (obj));
        exception;
        sqlitedatabase = null;
        do
        {
            if (obj3 != null)
            {
                ((Cursor) (obj3)).close();
            }
            if (sqlitedatabase != null)
            {
                sqlitedatabase.close();
            }
            b.unlock();
            throw exception;
        } while (true);
        SQLException sqlexception1;
        sqlexception1;
        obj2 = obj1;
        obj1 = sqlexception1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public final void a(e e1)
    {
        Object obj;
        Long long1;
        Long long2;
        if (e1 == null)
        {
            return;
        }
        obj = null;
        Object obj1 = null;
        long1 = new Long(e1.b);
        long2 = new Long(e1.a);
        b.lock();
        e1 = obj1;
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        e1 = sqlitedatabase;
        obj = sqlitedatabase;
        sqlitedatabase.execSQL("UPDATE v2TrackedRuns SET isComplete = 1, dur = (? - timestamp) WHERE dbID = ?", new Object[] {
            long1, long2
        });
        if (sqlitedatabase != null)
        {
            sqlitedatabase.close();
        }
        b.unlock();
        return;
        SQLException sqlexception;
        sqlexception;
        obj = e1;
        Log.e("MMT.MMDatabase", (new StringBuilder()).append("Error closing the active run: ").append(sqlexception.toString()).toString());
        if (e1 != null)
        {
            e1.close();
        }
        b.unlock();
        return;
        e1;
        if (obj != null)
        {
            ((SQLiteDatabase) (obj)).close();
        }
        b.unlock();
        throw e1;
    }

    public final void a(e e1, String s, byte abyte0[], int i, Location location, boolean flag, long l, String s1, int j)
    {
        SQLiteDatabase sqlitedatabase;
        SQLiteDatabase sqlitedatabase1;
        long l1;
        long l2;
        long l3;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        sqlitedatabase1 = null;
        sqlitedatabase = null;
        flag3 = false;
        flag2 = false;
        flag1 = false;
        l1 = 1L;
        l2 = 1L;
        l3 = 1L;
        b.lock();
        SQLiteDatabase sqlitedatabase2 = getWritableDatabase();
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        sqlitedatabase2.beginTransaction();
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        String as[] = new String[1];
        as[0] = s;
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        Cursor cursor = sqlitedatabase2.rawQuery("SELECT COUNT(*) FROM eventMaxTimestamps", null);
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        cursor.moveToFirst();
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        ContentValues contentvalues;
        boolean flag4;
        if (cursor.getLong(0) == 0L)
        {
            flag4 = true;
        } else
        {
            flag4 = false;
        }
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        cursor.close();
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        cursor = sqlitedatabase2.rawQuery("SELECT dbID, maxTimestamp, countForMonth, countForDay, countForHour FROM eventMaxTimestamps WHERE eventType=?", as);
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        contentvalues = new ContentValues();
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        contentvalues.put("maxTimestamp", Long.valueOf(l));
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        contentvalues.put("eventType", s);
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        if (cursor.getCount() != 0) goto _L2; else goto _L1
_L1:
        flag3 = true;
        flag2 = true;
        flag1 = true;
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        contentvalues.put("countForMonth", Long.valueOf(1L));
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        contentvalues.put("countForDay", Long.valueOf(1L));
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        contentvalues.put("countForHour", Long.valueOf(1L));
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        sqlitedatabase2.insert("eventMaxTimestamps", "maxTimestamps", contentvalues);
_L8:
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        cursor.close();
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        contentvalues.clear();
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        contentvalues.put("countForMonth", Long.valueOf(l1));
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        contentvalues.put("countForDay", Long.valueOf(l2));
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        contentvalues.put("countForHour", Long.valueOf(l3));
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        contentvalues.put("runId", Long.valueOf(e1.a()));
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        contentvalues.put("timestamp", Long.valueOf(l));
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        contentvalues.put("eventType", s);
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        contentvalues.put("connStatus", Integer.valueOf(i));
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        contentvalues.put("isFirstEver", Boolean.valueOf(flag4));
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        contentvalues.put("isFirstForMonth", Boolean.valueOf(flag3));
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        contentvalues.put("isFirstForDay", Boolean.valueOf(flag2));
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        contentvalues.put("isFirstForHour", Boolean.valueOf(flag1));
        Calendar calendar;
        Calendar calendar1;
        long l4;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        contentvalues.put("isAdEvent", Integer.valueOf(i));
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        contentvalues.put("userEvent", abyte0);
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        contentvalues.put("slotName", s1);
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        contentvalues.put("dur", Integer.valueOf(j));
        if (location == null)
        {
            break MISSING_BLOCK_LABEL_843;
        }
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        contentvalues.put("latitude", Double.valueOf(location.getLatitude()));
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        contentvalues.put("longitude", Double.valueOf(location.getLongitude()));
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        if (!location.hasAltitude())
        {
            break MISSING_BLOCK_LABEL_763;
        }
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        contentvalues.put("altitude", Double.valueOf(location.getAltitude()));
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        if (!location.hasAccuracy())
        {
            break MISSING_BLOCK_LABEL_803;
        }
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        contentvalues.put("accuracy", Float.valueOf(location.getAccuracy()));
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        if (!location.hasBearing())
        {
            break MISSING_BLOCK_LABEL_843;
        }
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        contentvalues.put("bearing", Float.valueOf(location.getBearing()));
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        sqlitedatabase2.insert("v2TrackedEvents", "timestamp", contentvalues);
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        sqlitedatabase2.execSQL("UPDATE v2TrackedRuns SET dur=(? - timestamp) WHERE dbID = ?", new Object[] {
            new Long(l), new Long(e1.a())
        });
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        sqlitedatabase2.setTransactionSuccessful();
        if (sqlitedatabase2 != null)
        {
            sqlitedatabase2.endTransaction();
            sqlitedatabase2.close();
        }
        b.unlock();
        return;
_L2:
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        cursor.moveToFirst();
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        l4 = cursor.getLong(1);
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        calendar = Calendar.getInstance();
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        calendar1 = Calendar.getInstance();
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        calendar.setTimeInMillis(l);
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        calendar1.setTimeInMillis(l4);
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        if (calendar.get(2) == calendar1.get(2)) goto _L4; else goto _L3
_L3:
        flag3 = true;
        flag2 = true;
        flag1 = true;
_L6:
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        contentvalues.put("countForMonth", Long.valueOf(l1));
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        contentvalues.put("countForDay", Long.valueOf(l2));
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        contentvalues.put("countForHour", Long.valueOf(l3));
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        try
        {
            sqlitedatabase2.update("eventMaxTimestamps", contentvalues, "eventType = ?", as);
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (e e1)
        {
            sqlitedatabase1 = sqlitedatabase;
        }
        finally
        {
            if (sqlitedatabase1 != null)
            {
                sqlitedatabase1.endTransaction();
                sqlitedatabase1.close();
            }
            b.unlock();
            throw e1;
        }
        Log.e("MMT.MMDatabase", (new StringBuilder()).append("Exception storing analytics event: ").append(e1.toString()).toString());
        if (sqlitedatabase != null)
        {
            sqlitedatabase.endTransaction();
            sqlitedatabase.close();
        }
        b.unlock();
        return;
_L4:
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        if (calendar.get(5) == calendar1.get(5))
        {
            break MISSING_BLOCK_LABEL_1276;
        }
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        l1 = cursor.getLong(2) + 1L;
        flag2 = true;
        flag1 = true;
        continue; /* Loop/switch isn't completed */
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        if (calendar.get(11) == calendar1.get(11))
        {
            break MISSING_BLOCK_LABEL_1347;
        }
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        l1 = 1L + cursor.getLong(2);
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        l2 = cursor.getLong(3) + 1L;
        flag1 = true;
        continue; /* Loop/switch isn't completed */
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        l1 = cursor.getLong(2) + 1L;
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        l2 = 1L + cursor.getLong(3);
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        l3 = cursor.getLong(4);
        l3++;
        if (true) goto _L6; else goto _L5
_L5:
        if (true) goto _L8; else goto _L7
_L7:
    }

    public final void a(String s)
    {
        Cursor cursor;
        SQLiteDatabase sqlitedatabase;
        Cursor cursor1;
        Cursor cursor2;
        cursor1 = null;
        cursor = null;
        sqlitedatabase = null;
        cursor2 = null;
        b.lock();
        SQLiteDatabase sqlitedatabase1 = getWritableDatabase();
        cursor1 = cursor2;
        cursor = sqlitedatabase;
        sqlitedatabase = sqlitedatabase1;
        cursor2 = sqlitedatabase1.rawQuery((new StringBuilder()).append("SELECT impressions FROM runForecasting WHERE adSlot = '").append(s).append("'").toString(), null);
        cursor1 = cursor2;
        cursor = cursor2;
        sqlitedatabase = sqlitedatabase1;
        if (!cursor2.moveToNext()) goto _L2; else goto _L1
_L1:
        cursor1 = cursor2;
        cursor = cursor2;
        sqlitedatabase = sqlitedatabase1;
        ContentValues contentvalues = new ContentValues();
        cursor1 = cursor2;
        cursor = cursor2;
        sqlitedatabase = sqlitedatabase1;
        contentvalues.put("impressions", Integer.valueOf(cursor2.getInt(0) + 1));
        cursor1 = cursor2;
        cursor = cursor2;
        sqlitedatabase = sqlitedatabase1;
        sqlitedatabase1.update("runForecasting", contentvalues, "adSlot = ?", new String[] {
            s
        });
_L4:
        if (cursor2 != null)
        {
            cursor2.close();
        }
        if (sqlitedatabase1 != null)
        {
            sqlitedatabase1.close();
        }
        b.unlock();
        return;
_L2:
        cursor1 = cursor2;
        cursor = cursor2;
        sqlitedatabase = sqlitedatabase1;
        contentvalues = new ContentValues();
        cursor1 = cursor2;
        cursor = cursor2;
        sqlitedatabase = sqlitedatabase1;
        contentvalues.put("adSlot", s);
        cursor1 = cursor2;
        cursor = cursor2;
        sqlitedatabase = sqlitedatabase1;
        sqlitedatabase1.insert("runForecasting", null, contentvalues);
        if (true) goto _L4; else goto _L3
_L3:
        s;
_L8:
        cursor = cursor1;
        sqlitedatabase = sqlitedatabase1;
        Log.e("MMT.MMDatabase", (new StringBuilder()).append("Error incrementing forecasting data: ").append(s.toString()).toString());
        if (cursor1 != null)
        {
            cursor1.close();
        }
        if (sqlitedatabase1 != null)
        {
            sqlitedatabase1.close();
        }
        b.unlock();
        return;
        s;
        sqlitedatabase = null;
_L6:
        if (cursor != null)
        {
            cursor.close();
        }
        if (sqlitedatabase != null)
        {
            sqlitedatabase.close();
        }
        b.unlock();
        throw s;
        s;
        if (true) goto _L6; else goto _L5
_L5:
        s;
        sqlitedatabase1 = null;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public final void a(List list)
    {
        SQLiteDatabase sqlitedatabase;
        sqlitedatabase = null;
        b.lock();
        SQLiteDatabase sqlitedatabase1 = getWritableDatabase();
        sqlitedatabase = sqlitedatabase1;
        sqlitedatabase1.beginTransaction();
        sqlitedatabase = sqlitedatabase1;
        list = list.iterator();
_L2:
        sqlitedatabase = sqlitedatabase1;
        if (!list.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        sqlitedatabase = sqlitedatabase1;
        Run run = (Run)list.next();
        sqlitedatabase = sqlitedatabase1;
        String as[] = new String[1];
        sqlitedatabase = sqlitedatabase1;
        as[0] = run.getId();
        sqlitedatabase = sqlitedatabase1;
        sqlitedatabase1.execSQL("DELETE FROM v2TrackedEvents WHERE runID = ?", as);
        sqlitedatabase = sqlitedatabase1;
        sqlitedatabase1.execSQL("DELETE FROM v2TrackedRuns WHERE dbID = ?", as);
        if (true) goto _L2; else goto _L1
        list;
        if (sqlitedatabase != null)
        {
            sqlitedatabase.endTransaction();
            sqlitedatabase.close();
        }
        b.unlock();
        throw list;
_L1:
        sqlitedatabase = sqlitedatabase1;
        sqlitedatabase1.setTransactionSuccessful();
        if (sqlitedatabase1 != null)
        {
            sqlitedatabase1.endTransaction();
            sqlitedatabase1.close();
        }
        b.unlock();
        return;
    }

    public final HashMap b()
    {
        Object obj1;
        obj1 = null;
        Object obj2 = null;
        HashMap hashmap = new HashMap();
        b.lock();
        Object obj;
        Exception exception1;
        try
        {
            obj = getWritableDatabase();
        }
        catch (SQLException sqlexception)
        {
            obj1 = null;
            sqlexception = ((SQLException) (obj2));
            continue; /* Loop/switch isn't completed */
        }
        finally
        {
            obj2 = null;
            obj = obj1;
            obj1 = exception;
        }
        obj2 = ((SQLiteDatabase) (obj)).query("runForecasting", null, null, null, null, null, null);
        while (((Cursor) (obj2)).moveToNext()) 
        {
            hashmap.put(((Cursor) (obj2)).getString(((Cursor) (obj2)).getColumnIndex("adSlot")), ((Cursor) (obj2)).getString(((Cursor) (obj2)).getColumnIndex("impressions")));
        }
          goto _L1
        obj1;
        obj1 = obj2;
_L5:
        Log.e("MMT.MMDatabase", "Error getting the run forecasting data.");
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        if (obj != null)
        {
            ((SQLiteDatabase) (obj)).close();
        }
        b.unlock();
        return hashmap;
_L1:
        if (obj2 != null)
        {
            ((Cursor) (obj2)).close();
        }
        if (obj != null)
        {
            ((SQLiteDatabase) (obj)).close();
        }
        b.unlock();
        return hashmap;
_L3:
        if (obj2 != null)
        {
            ((Cursor) (obj2)).close();
        }
        if (obj != null)
        {
            ((SQLiteDatabase) (obj)).close();
        }
        b.unlock();
        throw obj1;
        obj1;
        obj2 = null;
        continue; /* Loop/switch isn't completed */
        obj1;
        continue; /* Loop/switch isn't completed */
        exception1;
        obj2 = obj1;
        obj1 = exception1;
        if (true) goto _L3; else goto _L2
_L2:
        break MISSING_BLOCK_LABEL_26;
        SQLException sqlexception1;
        sqlexception1;
        sqlexception1 = null;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public final List b(String s)
    {
        Cursor cursor;
        SQLiteDatabase sqlitedatabase;
        Cursor cursor1;
        Cursor cursor2;
        ArrayList arraylist;
        cursor1 = null;
        cursor = null;
        sqlitedatabase = null;
        cursor2 = null;
        arraylist = new ArrayList();
        b.lock();
        SQLiteDatabase sqlitedatabase1 = getWritableDatabase();
        cursor1 = cursor2;
        cursor = sqlitedatabase;
        sqlitedatabase = sqlitedatabase1;
        cursor2 = sqlitedatabase1.rawQuery("SELECT dbID, hadAbEnd, timestamp, interval, dur, isFirstEver, isFirstForMonth, isFirstForDay, isFirstForHour, countForMonth, countForDay, countForHour FROM v2TrackedRuns WHERE isComplete=1 AND wasBroadcast=0 ORDER BY dbId", null);
        cursor1 = cursor2;
        cursor = cursor2;
        sqlitedatabase = sqlitedatabase1;
        cursor2.moveToFirst();
_L2:
        cursor1 = cursor2;
        cursor = cursor2;
        sqlitedatabase = sqlitedatabase1;
        if (cursor2.isAfterLast())
        {
            break; /* Loop/switch isn't completed */
        }
        cursor1 = cursor2;
        cursor = cursor2;
        sqlitedatabase = sqlitedatabase1;
        String s1 = e.a(new Date(cursor2.getLong(2)));
        cursor1 = cursor2;
        cursor = cursor2;
        sqlitedatabase = sqlitedatabase1;
        int i = cursor2.getInt(3) / 1000;
        cursor1 = cursor2;
        cursor = cursor2;
        sqlitedatabase = sqlitedatabase1;
        int j = cursor2.getInt(4) / 1000;
        cursor1 = cursor2;
        cursor = cursor2;
        sqlitedatabase = sqlitedatabase1;
        List list = a(cursor2.getLong(0));
        cursor1 = cursor2;
        cursor = cursor2;
        sqlitedatabase = sqlitedatabase1;
        List list1 = b(cursor2.getLong(0));
        cursor1 = cursor2;
        cursor = cursor2;
        sqlitedatabase = sqlitedatabase1;
        Run run = new Run();
        cursor1 = cursor2;
        cursor = cursor2;
        sqlitedatabase = sqlitedatabase1;
        run.setId(Long.toString(cursor2.getLong(0)));
        cursor1 = cursor2;
        cursor = cursor2;
        sqlitedatabase = sqlitedatabase1;
        run.setAppVersion(s);
        cursor1 = cursor2;
        cursor = cursor2;
        sqlitedatabase = sqlitedatabase1;
        run.setInterval(i);
        cursor1 = cursor2;
        cursor = cursor2;
        sqlitedatabase = sqlitedatabase1;
        run.setStart(s1);
        cursor1 = cursor2;
        cursor = cursor2;
        sqlitedatabase = sqlitedatabase1;
        run.setDur((short)Math.min(32767, j));
        cursor1 = cursor2;
        cursor = cursor2;
        sqlitedatabase = sqlitedatabase1;
        boolean flag;
        if (cursor2.getInt(1) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        cursor1 = cursor2;
        cursor = cursor2;
        sqlitedatabase = sqlitedatabase1;
        run.setAbEnd(flag);
        cursor1 = cursor2;
        cursor = cursor2;
        sqlitedatabase = sqlitedatabase1;
        if (cursor2.getInt(5) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        cursor1 = cursor2;
        cursor = cursor2;
        sqlitedatabase = sqlitedatabase1;
        run.setFirst(flag);
        cursor1 = cursor2;
        cursor = cursor2;
        sqlitedatabase = sqlitedatabase1;
        if (cursor2.getInt(6) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        cursor1 = cursor2;
        cursor = cursor2;
        sqlitedatabase = sqlitedatabase1;
        run.setFirstMon(flag);
        cursor1 = cursor2;
        cursor = cursor2;
        sqlitedatabase = sqlitedatabase1;
        if (cursor2.getInt(7) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        cursor1 = cursor2;
        cursor = cursor2;
        sqlitedatabase = sqlitedatabase1;
        run.setFirstDay(flag);
        cursor1 = cursor2;
        cursor = cursor2;
        sqlitedatabase = sqlitedatabase1;
        if (cursor2.getInt(8) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        cursor1 = cursor2;
        cursor = cursor2;
        sqlitedatabase = sqlitedatabase1;
        run.setFirstHr(flag);
        cursor1 = cursor2;
        cursor = cursor2;
        sqlitedatabase = sqlitedatabase1;
        run.setCountMon(cursor2.getShort(11));
        cursor1 = cursor2;
        cursor = cursor2;
        sqlitedatabase = sqlitedatabase1;
        run.setCountHr(cursor2.getShort(10));
        cursor1 = cursor2;
        cursor = cursor2;
        sqlitedatabase = sqlitedatabase1;
        run.setCountDay(cursor2.getShort(9));
        cursor1 = cursor2;
        cursor = cursor2;
        sqlitedatabase = sqlitedatabase1;
        run.setEvents(list);
        cursor1 = cursor2;
        cursor = cursor2;
        sqlitedatabase = sqlitedatabase1;
        run.setAdEvents(list1);
        cursor1 = cursor2;
        cursor = cursor2;
        sqlitedatabase = sqlitedatabase1;
        run.setSystemVersion(android.os.Build.VERSION.RELEASE);
        cursor1 = cursor2;
        cursor = cursor2;
        sqlitedatabase = sqlitedatabase1;
        arraylist.add(run);
        cursor1 = cursor2;
        cursor = cursor2;
        sqlitedatabase = sqlitedatabase1;
        cursor2.moveToNext();
        if (true) goto _L2; else goto _L1
        s;
_L6:
        cursor = cursor1;
        sqlitedatabase = sqlitedatabase1;
        Log.e("MMT.MMDatabase", (new StringBuilder()).append("Exception getting runs for transport: ").append(s.toString()).toString());
        if (cursor1 != null)
        {
            cursor1.close();
        }
        if (sqlitedatabase1 != null)
        {
            sqlitedatabase1.close();
        }
        b.unlock();
        return arraylist;
_L1:
        if (cursor2 != null)
        {
            cursor2.close();
        }
        if (sqlitedatabase1 != null)
        {
            sqlitedatabase1.close();
        }
        b.unlock();
        return arraylist;
        s;
        sqlitedatabase = null;
_L4:
        if (cursor != null)
        {
            cursor.close();
        }
        if (sqlitedatabase != null)
        {
            sqlitedatabase.close();
        }
        b.unlock();
        throw s;
        s;
        if (true) goto _L4; else goto _L3
_L3:
        s;
        sqlitedatabase1 = null;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final void onCreate(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.beginTransaction();
        sqlitedatabase.execSQL("CREATE TABLE IF NOT EXISTS v2TrackedRuns ( dbID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, isComplete INTEGER NOT NULL, hadAbEnd INTEGER NOT NULL, wasBroadcast INTEGER NOT NULL, timestamp LONG NOT NULL, interval INT NOT NULL, dur INT NULL, isFirstEver INT NOT NULL, isFirstForMonth INT NOT NULL, isFirstForDay INT NOT NULL, isFirstForHour INT NOT NULL, countForMonth INT NOT NULL,countForDay INT NOT NULL,countForHour INT NOT NULL); CREATE INDEX IF NOT EXISTS runIDIndx ON v2TrackedRuns(dbID); ");
        sqlitedatabase.execSQL("CREATE TABLE IF NOT EXISTS v2TrackedEvents ( dbID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, runId INTEGER NOT NULL, timestamp INT NOT NULL, eventType CHAR(50) NOT NULL, slotName TEXT, connStatus INT NOT NULL, latitude REAL, longitude REAL, altitude REAL, bearing REAL, accuracy REAL, dur INT default '0', isFirstEver INT NOT NULL, isFirstForMonth INT NOT NULL, isFirstForDay INT NOT NULL, isFirstForHour INT NOT NULL, countForMonth INT NOT NULL,countForDay INT NOT NULL,countForHour INT NOT NULL, isAdEvent INT NOT NULL,userEvent DATA NOT NULL);CREATE INDEX IF NOT EXISTS eventIDIndx ON v2TrackedEvents(dbID); ");
        sqlitedatabase.execSQL("CREATE TABLE IF NOT EXISTS eventMaxTimestamps (dbID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, eventType CHAR(50) NOT NULL, maxTimestamp INT NOT NULL, countForMonth INT NOT NULL,countForDay INT NOT NULL,countForHour INT NOT NULL);");
        sqlitedatabase.execSQL("CREATE TABLE IF NOT EXISTS runMaxTimestamps (dbID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, maxTimestamp INT NOT NULL, countForMonth INT NOT NULL,countForDay INT NOT NULL,countForHour INT NOT NULL);");
        sqlitedatabase.execSQL("CREATE TABLE IF NOT EXISTS runForecasting (adSlot TEXT NOT NULL, impressions INT NOT NULL DEFAULT '0');");
        sqlitedatabase.setTransactionSuccessful();
        sqlitedatabase.endTransaction();
        return;
        Exception exception;
        exception;
        sqlitedatabase.endTransaction();
        throw exception;
    }

    public final void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        switch (i)
        {
        default:
            return;

        case 3: // '\003'
            sqlitedatabase.execSQL("ALTER TABLE v2TrackedEvents ADD COLUMN slotName TEXT;");
            return;

        case 4: // '\004'
            sqlitedatabase.execSQL("ALTER TABLE v2TrackedEvents ADD COLUMN dur INT default 0;");
            return;

        case 5: // '\005'
            sqlitedatabase.execSQL("CREATE TABLE IF NOT EXISTS runForecasting (adSlot TEXT NOT NULL, impressions INT NOT NULL DEFAULT '0');");
            break;
        }
    }

}
