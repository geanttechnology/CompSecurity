// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.mftd;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.ebay.common.model.mftd.MessageList;
import com.ebay.common.model.mftd.MessageListResult;
import com.ebay.common.net.api.mftd.EbayMftdApi;
import com.ebay.mobile.activities.mftdActivity;
import com.ebay.mobile.notifications.NotificationPreferenceManager;
import com.ebay.mobile.util.EbayApiUtil;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.shell.app.BaseIntentService;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.ebay.mobile.mftd:
//            MftdAlarmReceiver

public class MftdService extends BaseIntentService
{
    private class MftdCache
    {

        private static final String DB_NAME = "motd_cache.db";
        private static final int DB_VERSION = 1;
        private static final String MOTD_CONTENT_TYPE = "contentType";
        private static final String MOTD_MAX_NUMBER_OF_VIEWS = "maxNumOfViews";
        private static final String MOTD_MESSAGE = "message";
        private static final String MOTD_MESSAGE_ID = "id";
        private static final String MOTD_MESSAGE_TYPE = "messageType";
        private static final String MOTD_NUMBER_OF_VIEWS = "numberOfViews";
        private static final String MOTD_TABLE_NAME = "motd";
        private static final String MOTD_VALIDFROM_TIMESTAMP = "validFrom";
        private static final String MOTD_VALIDTO_TIMESTAMP = "validTo";
        private static final String SQL_CREATE_MOTD_TABLE = "CREATE TABLE motd (id INTEGER PRIMARY KEY, message TEXT, messageType TEXT, contentType TEXT, maxNumOfViews INTEGER, validFrom INTEGER, validTo INTEGER, numberOfViews INTEGER);";
        private static final String SQL_INSERT_MOTD_RECORD = "INSERT INTO motd(id,message,messageType,contentType,maxNumOfViews,validFrom,validTo,numberOfViews) VALUES(?,?,?,?,?,?,?,?)";
        private static final String SQL_PURGE_EXPIRED_MOTDS = "DELETE FROM motd WHERE validTo<?";
        private static final String SQL_UPDATE_MOTD_NUMBER_OF_VIEWS = "UPDATE motd SET numberOfViews=? WHERE id=?";
        private final String MOTD_SEARCH_COLUMNS[];
        private SQLiteDatabase db;
        private SQLiteOpenHelper helper;
        final MftdService this$0;

        private void close()
        {
            if (db == null)
            {
                return;
            }
            try
            {
                db.close();
                return;
            }
            catch (SQLException sqlexception)
            {
                Log.e("MftdService", sqlexception.toString());
            }
        }

        private int getNumberOfViews(int i)
        {
            long l1;
            long l2;
            if (db == null)
            {
                return 0;
            }
            l2 = 0L;
            l1 = l2;
            Cursor cursor = db.query("motd", MOTD_SEARCH_COLUMNS, (new StringBuilder()).append("id=").append(i).toString(), null, null, null, null);
            long l;
            l = l2;
            l1 = l2;
            if (!cursor.moveToFirst())
            {
                break MISSING_BLOCK_LABEL_81;
            }
            l1 = l2;
            l = cursor.getLong(2);
            l1 = l;
            try
            {
                cursor.close();
            }
            catch (SQLException sqlexception)
            {
                Log.e("MftdService", sqlexception.toString());
                l = l1;
            }
            return (int)l;
        }

        private void insertMftdRecord(int i, String s, String s1, String s2, int j, long l, 
                long l1, int k)
        {
            this;
            JVM INSTR monitorenter ;
            SQLiteDatabase sqlitedatabase = db;
            if (sqlitedatabase != null) goto _L2; else goto _L1
_L1:
            this;
            JVM INSTR monitorexit ;
            return;
_L2:
            SQLiteStatement sqlitestatement = db.compileStatement("INSERT INTO motd(id,message,messageType,contentType,maxNumOfViews,validFrom,validTo,numberOfViews) VALUES(?,?,?,?,?,?,?,?)");
            sqlitestatement.bindLong(1, i);
            sqlitestatement.bindString(2, s);
            sqlitestatement.bindString(3, s1);
            sqlitestatement.bindString(4, s2);
            sqlitestatement.bindLong(5, j);
            sqlitestatement.bindLong(6, l);
            sqlitestatement.bindLong(7, l1);
            sqlitestatement.bindLong(8, k);
            sqlitestatement.execute();
              goto _L1
            s;
            Log.e("MftdService", s.toString());
              goto _L1
            s;
            throw s;
            s;
            Log.e("MftdService", s.toString());
              goto _L1
        }

        private void purgeMftdExpired(long l)
        {
            this;
            JVM INSTR monitorenter ;
            SQLiteDatabase sqlitedatabase = db;
            if (sqlitedatabase != null) goto _L2; else goto _L1
_L1:
            this;
            JVM INSTR monitorexit ;
            return;
_L2:
            SQLiteStatement sqlitestatement = db.compileStatement("DELETE FROM motd WHERE validTo<?");
            sqlitestatement.bindLong(1, l);
            sqlitestatement.execute();
              goto _L1
            Object obj;
            obj;
            Log.e("MftdService", ((SQLException) (obj)).toString());
              goto _L1
            obj;
            throw obj;
            obj;
            Log.e("MftdService", ((IllegalArgumentException) (obj)).toString());
              goto _L1
        }

        private void updateMftdNumOfViews(int i, int j)
        {
            this;
            JVM INSTR monitorenter ;
            SQLiteDatabase sqlitedatabase = db;
            if (sqlitedatabase != null) goto _L2; else goto _L1
_L1:
            this;
            JVM INSTR monitorexit ;
            return;
_L2:
            SQLiteStatement sqlitestatement = db.compileStatement("UPDATE motd SET numberOfViews=? WHERE id=?");
            sqlitestatement.bindLong(1, j);
            sqlitestatement.bindLong(2, i);
            sqlitestatement.execute();
              goto _L1
            Object obj;
            obj;
            Log.e("MftdService", ((SQLException) (obj)).toString());
              goto _L1
            obj;
            throw obj;
            obj;
            Log.e("MftdService", ((IllegalArgumentException) (obj)).toString());
              goto _L1
        }






        private MftdCache(boolean flag)
        {
            this$0 = MftdService.this;
            super();
            db = null;
            MOTD_SEARCH_COLUMNS = (new String[] {
                "id", "maxNumOfViews", "numberOfViews"
            });
            helper = ctx. new _cls1("motd_cache.db", null, 1, MftdService.this);
            if (!flag)
            {
                break MISSING_BLOCK_LABEL_76;
            }
            mftdservice = helper.getReadableDatabase();
_L1:
            db = MftdService.this;
            return;
            try
            {
                mftdservice = helper.getWritableDatabase();
            }
            // Misplaced declaration of an exception variable
            catch (MftdService mftdservice)
            {
                Log.e("MftdService", toString());
                return;
            }
              goto _L1
        }

    }


    public static final String GET_MFTD = "com.ebay.mobile.service.GET_MFTD";
    public static final long MILLISECONDS_TILL_START = 1L;
    public static final String START_MFTD = "com.ebay.mobile.service.START_MFTD";
    private static final String TAG = "MftdService";
    public static final long WAKE_UP_INTERVAL = 0x5265c00L;
    private Context ctx;

    public MftdService()
    {
        super("MftdService");
    }

    private void getMftd()
    {
        Object obj1;
        long l;
        ctx = this;
        l = System.currentTimeMillis();
        obj1 = new NotificationPreferenceManager(this);
        if (l >= 0x5265c00L + ((NotificationPreferenceManager) (obj1)).getMftdPollTime()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        MftdCache mftdcache;
        MessageList messagelist;
        int i;
        Object obj = NautilusKernel.getAppVersionWithoutBuildNumber(this);
        ((NotificationPreferenceManager) (obj1)).setMftdPollTime(l);
        obj1 = EbayApiUtil.getMftdApi(getEbayContext());
        Intent intent;
        int j;
        int k;
        long l1;
        long l2;
        try
        {
            obj = ((EbayMftdApi) (obj1)).getMOTDResponse(null, ((String) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.e("MftdService", "Request error", ((Throwable) (obj)));
            return;
        }
        catch (Exception exception)
        {
            Log.e("MftdService", "Error getting mftd or notifying user", exception);
            return;
        }
        if (obj == null) goto _L1; else goto _L3
_L3:
        obj1 = ((MessageListResult) (obj)).list;
        if (obj1 == null) goto _L1; else goto _L4
_L4:
        mftdcache = new MftdCache(true);
        i = 0;
_L11:
        if (i >= ((List) (obj1)).size())
        {
            break MISSING_BLOCK_LABEL_588;
        }
        messagelist = (MessageList)((List) (obj1)).get(i);
        l1 = messagelist.validFromTime.getTime();
        l2 = messagelist.validToTime.getTime();
        if (l1 > l || l2 < l)
        {
            break MISSING_BLOCK_LABEL_599;
        }
        if (messagelist.maxNumberOfViews <= 0)
        {
            break MISSING_BLOCK_LABEL_543;
        }
        j = mftdcache.getNumberOfViews(messagelist.messageId);
        if (j != 0)
        {
            break MISSING_BLOCK_LABEL_208;
        }
        mftdcache.insertMftdRecord(messagelist.messageId, messagelist.message, messagelist.messageType, messagelist.contentType, messagelist.maxNumberOfViews, l1, l2, 1);
        if (j >= messagelist.maxNumberOfViews) goto _L6; else goto _L5
_L5:
        mftdcache.updateMftdNumOfViews(messagelist.messageId, j + 1);
        if (messagelist.message != null);
        k = messagelist.message.indexOf("html");
        j = k;
        if (k >= 0)
        {
            break MISSING_BLOCK_LABEL_272;
        }
        j = messagelist.message.indexOf("HTML");
        if (j <= 0)
        {
            break MISSING_BLOCK_LABEL_291;
        }
        messagelist.message.substring(0, j - 1);
        if (messagelist.messageType != null && messagelist.messageType.length() >= 1 && !messagelist.messageType.equalsIgnoreCase("Info")) goto _L8; else goto _L7
_L7:
        obj = ctx.getString(0x7f070613);
_L9:
        intent = new Intent(getBaseContext(), com/ebay/mobile/activities/mftdActivity);
        intent.addFlags(0x10000000);
        intent.putExtra("android.intent.extra.TITLE", ((String) (obj)));
        intent.putExtra("android.intent.extra.TEXT", messagelist.message);
        intent.putExtra("format", messagelist.contentType);
        startActivity(intent);
        break MISSING_BLOCK_LABEL_599;
_L8:
        if (messagelist.messageType.equalsIgnoreCase("Alert"))
        {
            obj = ctx.getString(0x7f070611);
            continue; /* Loop/switch isn't completed */
        }
        if (messagelist.messageType.equalsIgnoreCase("Announcement"))
        {
            obj = ctx.getString(0x7f070612);
            continue; /* Loop/switch isn't completed */
        }
        obj = ctx.getString(0x7f070613);
        if (true) goto _L9; else goto _L6
_L6:
        Log.w("MftdService", (new StringBuilder()).append("MOTD limit reached: id = ").append(messagelist.messageId).append(", numShown = ").append(j).append(", maxNumberOfViews = ").append(messagelist.maxNumberOfViews).toString());
        break MISSING_BLOCK_LABEL_599;
        Log.e("MftdService", (new StringBuilder()).append("MOTD bad view number: id = ").append(messagelist.messageId).append(", maxNumberOfViews = ").append(messagelist.maxNumberOfViews).toString());
        break MISSING_BLOCK_LABEL_599;
        mftdcache.purgeMftdExpired(l);
        mftdcache.close();
        return;
        i++;
        if (true) goto _L11; else goto _L10
_L10:
    }

    private static void scheduleMftdAlarm(Context context)
    {
        AlarmManager alarmmanager = (AlarmManager)context.getSystemService("alarm");
        Intent intent = new Intent(context, com/ebay/mobile/mftd/MftdAlarmReceiver);
        intent.setAction("com.ebay.mobile.service.GET_MFTD");
        context = PendingIntent.getBroadcast(context, 0, intent, 0x8000000);
        alarmmanager.set(3, SystemClock.elapsedRealtime() + 0x5265c00L, context);
    }

    protected void onHandleIntent(Intent intent)
    {
        String s = intent.getAction();
        intent = s;
        if (TextUtils.isEmpty(s))
        {
            intent = "com.ebay.mobile.service.GET_MFTD";
        }
        if (intent.equalsIgnoreCase("com.ebay.mobile.service.GET_MFTD"))
        {
            getMftd();
            scheduleMftdAlarm(this);
            return;
        }
        try
        {
            if (intent.equalsIgnoreCase("com.ebay.mobile.service.START_MFTD"))
            {
                scheduleMftdAlarm(this);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            Log.e("MftdService", "Exception getting or scheduling Message of the Day", intent);
        }
        return;
    }


    // Unreferenced inner class com/ebay/mobile/mftd/MftdService$MftdCache$1

/* anonymous class */
    class MftdCache._cls1 extends SQLiteOpenHelper
    {

        final MftdCache this$1;
        final MftdService val$this$0;

        public void onCreate(SQLiteDatabase sqlitedatabase)
        {
            this;
            JVM INSTR monitorenter ;
            sqlitedatabase.execSQL("CREATE TABLE motd (id INTEGER PRIMARY KEY, message TEXT, messageType TEXT, contentType TEXT, maxNumOfViews INTEGER, validFrom INTEGER, validTo INTEGER, numberOfViews INTEGER);");
_L2:
            this;
            JVM INSTR monitorexit ;
            return;
            sqlitedatabase;
            Log.e("MftdService", sqlitedatabase.toString());
            if (true) goto _L2; else goto _L1
_L1:
            sqlitedatabase;
            throw sqlitedatabase;
        }

        public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
        {
            this;
            JVM INSTR monitorenter ;
            sqlitedatabase.execSQL("DROP TABLE IF EXISTS motd");
            onCreate(sqlitedatabase);
_L2:
            this;
            JVM INSTR monitorexit ;
            return;
            sqlitedatabase;
            Log.e("MftdService", sqlitedatabase.toString());
            if (true) goto _L2; else goto _L1
_L1:
            sqlitedatabase;
            throw sqlitedatabase;
        }

            
            {
                this$1 = final_mftdcache;
                this$0 = mftdservice;
                super(Context.this, s, cursorfactory, i);
            }
    }

}
