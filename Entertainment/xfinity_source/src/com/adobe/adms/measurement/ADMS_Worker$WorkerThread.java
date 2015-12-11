// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.adms.measurement;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

// Referenced classes of package com.adobe.adms.measurement:
//            ADMS_Worker, ADMS_Measurement, ADMS_RequestProperties, ADMS_RequestHandler

private static class worker extends Thread
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
        Cursor cursor1 = ADMS_Worker.access$000().query("HITS", new String[] {
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
        if (!worker.trackOffline && Long.parseLong(s6) < System.currentTimeMillis() / 1000L - (long)ADMS_Worker.access$100().intValue())
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

    public _cls9(ADMS_Worker adms_worker)
    {
        delay = 0L;
        worker = null;
        cancelled = false;
        worker = adms_worker;
    }
}
