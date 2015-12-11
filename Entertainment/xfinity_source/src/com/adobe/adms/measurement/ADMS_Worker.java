// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.adms.measurement;

import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// Referenced classes of package com.adobe.adms.measurement:
//            ADMS_Measurement, ADMS_RequestProperties, ADMS_RequestHandler

final class ADMS_Worker
{
    private static class WorkerThread extends Thread
    {

        public boolean cancelled;
        private long delay;
        private ADMS_Worker worker;

        public void run()
        {
_L6:
            if (cancelled) goto _L2; else goto _L1
_L1:
            String s5;
            String s6;
            Object obj2;
            Object obj3;
            Object obj4;
            Object obj5;
            s5 = null;
            s6 = null;
            obj5 = null;
            obj3 = null;
            obj2 = null;
            obj4 = null;
            Object obj6 = ADMS_Worker.dbMutex;
            obj6;
            JVM INSTR monitorenter ;
            Cursor cursor;
            String s;
            String s1;
            Object obj1;
            obj1 = null;
            cursor = null;
            s = obj5;
            s1 = s5;
            Cursor cursor1 = ADMS_Worker._offlineDB.query("HITS", new String[] {
                "ID", "URL", "TIMESTAMP"
            }, null, null, null, null, "ID ASC", "1");
            String s2;
            String s3;
            String s4;
            s4 = obj3;
            s3 = s6;
            s2 = obj4;
            if (cursor1 == null)
            {
                break MISSING_BLOCK_LABEL_202;
            }
            s4 = obj3;
            s3 = s6;
            s2 = obj4;
            cursor = cursor1;
            s = obj5;
            s1 = s5;
            obj1 = cursor1;
            if (!cursor1.moveToFirst())
            {
                break MISSING_BLOCK_LABEL_202;
            }
            cursor = cursor1;
            s = obj5;
            s1 = s5;
            obj1 = cursor1;
            s4 = cursor1.getString(0);
            cursor = cursor1;
            s = s4;
            s1 = s5;
            obj1 = cursor1;
            s3 = cursor1.getString(1);
            cursor = cursor1;
            s = s4;
            s1 = s3;
            obj1 = cursor1;
            s2 = cursor1.getString(2);
            obj1 = s4;
            s5 = s3;
            s6 = s2;
            if (cursor1 == null)
            {
                break MISSING_BLOCK_LABEL_260;
            }
            obj1 = s4;
            s5 = s3;
            s6 = s2;
            if (cursor1.isClosed())
            {
                break MISSING_BLOCK_LABEL_260;
            }
            cursor1.close();
            s6 = s2;
            s5 = s3;
            obj1 = s4;
_L4:
            obj6;
            JVM INSTR monitorexit ;
            if (s5 != null)
            {
                break MISSING_BLOCK_LABEL_391;
            }
_L2:
            cancelled = true;
            return;
            SQLException sqlexception;
            sqlexception;
            obj1 = cursor;
            ADMS_Measurement.sharedInstance().debugLog((new StringBuilder()).append("ADMS SDK Error: Unable to read from database -- ").append(sqlexception.getMessage()).toString());
            obj1 = s;
            s5 = s1;
            s6 = obj2;
            if (cursor == null) goto _L4; else goto _L3
_L3:
            obj1 = s;
            s5 = s1;
            s6 = obj2;
            if (cursor.isClosed()) goto _L4; else goto _L5
_L5:
            cursor.close();
            obj1 = s;
            s5 = s1;
            s6 = obj2;
              goto _L4
            Object obj;
            obj;
            obj6;
            JVM INSTR monitorexit ;
            throw obj;
            obj;
            if (obj1 == null)
            {
                break MISSING_BLOCK_LABEL_389;
            }
            if (!((Cursor) (obj1)).isClosed())
            {
                ((Cursor) (obj1)).close();
            }
            throw obj;
            if (!worker.trackOffline && Long.parseLong(s6) < System.currentTimeMillis() / 1000L - (long)ADMS_Worker.TIMESTAMP_DISABLED_WAIT_THRESHOLD.intValue())
            {
                worker.deleteHit(((String) (obj1)));
            } else
            {
                ADMS_RequestProperties adms_requestproperties = new ADMS_RequestProperties(s5);
                if (ADMS_RequestHandler.sendRequest(adms_requestproperties.getUrl(), adms_requestproperties.getHeaders()))
                {
                    worker.deleteHit(((String) (obj1)));
                } else
                if (worker.trackOffline)
                {
                    ADMS_Measurement.sharedInstance().debugLog("ADMS SDK Debug: Error Sending Hit(pausing 30 seconds before retry)");
                    delay = 30000L;
                } else
                {
                    ADMS_Measurement.sharedInstance().debugLog("ADMS SDK Debug: Error Sending Hit(deleting hit)");
                    worker.deleteHit(((String) (obj1)));
                }
            }
            Thread.sleep(delay);
            delay = 0L;
              goto _L6
            adms_requestproperties;
            ADMS_Measurement.sharedInstance().debugLog("ADMS SDK Debug: Background thread interrupted");
            delay = 0L;
              goto _L6
            adms_requestproperties;
            delay = 0L;
            throw adms_requestproperties;
        }

        public WorkerThread(ADMS_Worker adms_worker)
        {
            delay = 0L;
            worker = null;
            cancelled = false;
            worker = adms_worker;
        }
    }


    private static Integer TIMESTAMP_DISABLED_WAIT_THRESHOLD = Integer.valueOf(5);
    private static SQLiteDatabase _offlineDB;
    public static final Object dbMutex = new Object();
    private SQLiteStatement _preparedInsertStatement;
    private final Object backgroundMutex = new Object();
    private WorkerThread backgroundThread;
    public String cacheFilename;
    private boolean offlineForced;
    protected int offlineLimit;
    protected boolean trackOffline;

    protected ADMS_Worker(String s)
    {
        trackOffline = false;
        offlineLimit = 1000;
        backgroundThread = null;
        offlineForced = false;
        cacheFilename = null;
        cacheFilename = s;
        createOrOpenDB();
    }

    private void killThread()
    {
        if (backgroundThread != null)
        {
            backgroundThread.cancelled = true;
            backgroundThread = null;
        }
    }

    protected void clearTrackingQueue()
    {
        synchronized (dbMutex)
        {
            _offlineDB.delete("HITS", null, null);
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void createOrOpenDB()
    {
        File file = new File(cacheFilename);
        Object obj = dbMutex;
        obj;
        JVM INSTR monitorenter ;
        _offlineDB = SQLiteDatabase.openOrCreateDatabase(file.getPath(), null);
        _offlineDB.execSQL("CREATE TABLE IF NOT EXISTS HITS (ID INTEGER PRIMARY KEY AUTOINCREMENT, URL TEXT, TIMESTAMP INTEGER)");
        _preparedInsertStatement = _offlineDB.compileStatement("INSERT INTO HITS (URL, TIMESTAMP) VALUES (?, ?)");
_L1:
        return;
        Object obj1;
        obj1;
        ADMS_Measurement.sharedInstance().debugLog((new StringBuilder()).append("Unable to create database ").append(((SQLException) (obj1)).getLocalizedMessage()).toString());
          goto _L1
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    public void deleteHit(String s)
    {
        Object obj = dbMutex;
        obj;
        JVM INSTR monitorenter ;
        _offlineDB.delete("HITS", (new StringBuilder()).append("ID=").append(s).toString(), null);
_L1:
        return;
        s;
        ADMS_Measurement.sharedInstance().debugLog((new StringBuilder()).append("Error deleting hit. ").append(s).toString());
          goto _L1
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void deleteOldestHit()
    {
        Object obj = dbMutex;
        obj;
        JVM INSTR monitorenter ;
        Cursor cursor;
        Cursor cursor1;
        cursor1 = null;
        cursor = null;
        Cursor cursor2 = _offlineDB.query("HITS", new String[] {
            "ID", "URL", "TIMESTAMP"
        }, null, null, null, null, "ID ASC", "1");
        if (cursor2 == null)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        cursor = cursor2;
        cursor1 = cursor2;
        if (!cursor2.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_80;
        }
        cursor = cursor2;
        cursor1 = cursor2;
        deleteHit(cursor2.getString(0));
        if (cursor2 == null)
        {
            break MISSING_BLOCK_LABEL_99;
        }
        if (!cursor2.isClosed())
        {
            cursor2.close();
        }
_L2:
        obj;
        JVM INSTR monitorexit ;
        return;
        SQLException sqlexception;
        sqlexception;
        cursor1 = cursor;
        ADMS_Measurement.sharedInstance().debugLog((new StringBuilder()).append("Error deleting hit. ").append(sqlexception.getMessage()).toString());
        if (cursor == null) goto _L2; else goto _L1
_L1:
        if (cursor.isClosed()) goto _L2; else goto _L3
_L3:
        cursor.close();
          goto _L2
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        exception;
        if (cursor1 == null)
        {
            break MISSING_BLOCK_LABEL_182;
        }
        if (!cursor1.isClosed())
        {
            cursor1.close();
        }
        throw exception;
    }

    protected int getTrackingQueueSize()
    {
        int i;
        synchronized (dbMutex)
        {
            i = Long.valueOf(DatabaseUtils.queryNumEntries(_offlineDB, "HITS")).intValue();
        }
        return i;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void queue(String s)
    {
        if (trackOffline || !offlineForced) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (getTrackingQueueSize() >= offlineLimit)
        {
            deleteOldestHit();
        }
        Object obj = dbMutex;
        obj;
        JVM INSTR monitorenter ;
        _preparedInsertStatement.bindString(1, s);
        _preparedInsertStatement.bindLong(2, System.currentTimeMillis() / 1000L);
        _preparedInsertStatement.execute();
_L3:
        _preparedInsertStatement.clearBindings();
        if (!offlineForced)
        {
            setOnline(true);
            return;
        }
        continue; /* Loop/switch isn't completed */
        SQLException sqlexception;
        sqlexception;
        ADMS_Measurement.sharedInstance().debugLog((new StringBuilder()).append("Unable to insert url: ").append(s).toString());
          goto _L3
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
        if (true) goto _L1; else goto _L4
_L4:
    }

    protected void setOnline(boolean flag)
    {
label0:
        {
            if (!flag)
            {
                break MISSING_BLOCK_LABEL_84;
            }
            synchronized (backgroundMutex)
            {
                if (backgroundThread == null || backgroundThread.cancelled)
                {
                    break label0;
                }
            }
            return;
        }
        if (backgroundThread == null || backgroundThread.cancelled)
        {
            killThread();
            backgroundThread = new WorkerThread(this);
            backgroundThread.start();
        }
        offlineForced = false;
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        synchronized (backgroundMutex)
        {
            if (backgroundThread != null && !backgroundThread.cancelled)
            {
                killThread();
            }
        }
        offlineForced = true;
        return;
        exception1;
        obj1;
        JVM INSTR monitorexit ;
        throw exception1;
    }

    protected void upgradeQueueToSQL(String s)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if ((s = new File(s)) == null || !s.exists()) goto _L1; else goto _L3
_L3:
        ADMS_Measurement.sharedInstance().debugLog("Upgrading offline storage to SQLite");
        BufferedReader bufferedreader;
        ArrayList arraylist;
        bufferedreader = new BufferedReader(new InputStreamReader(new FileInputStream(s), "UTF-8"));
        arraylist = new ArrayList();
_L4:
        String s1 = bufferedreader.readLine();
label0:
        {
            if (s1 == null)
            {
                break label0;
            }
            try
            {
                arraylist.add(s1);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                ADMS_Measurement.sharedInstance().debugLog((new StringBuilder()).append("ADMS SDK Error: Cannot Read Requests From Disk -- ").append(s.getMessage()).toString());
                return;
            }
        }
          goto _L4
        int i;
        try
        {
            s.delete();
        }
        catch (Exception exception) { }
        if (s.exists()) goto _L6; else goto _L5
_L5:
        i = 0;
_L7:
        if (i >= arraylist.size())
        {
            break; /* Loop/switch isn't completed */
        }
        queue((String)arraylist.get(i));
        i++;
        if (true) goto _L7; else goto _L6
_L6:
        bufferedreader.close();
        return;
    }



}
