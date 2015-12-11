// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.adms.measurement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;

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
_L9:
            if (cancelled) goto _L2; else goto _L1
_L1:
            if (!ADMS_Measurement.isOnline())
            {
                break MISSING_BLOCK_LABEL_162;
            }
            if (worker.getTrackingQueueSize() <= 0) goto _L4; else goto _L3
_L3:
            Object obj = worker.popRequest();
            if (obj == null) goto _L6; else goto _L5
_L5:
            ADMS_RequestProperties adms_requestproperties = new ADMS_RequestProperties(((String) (obj)));
            if (!ADMS_RequestHandler.sendRequest(adms_requestproperties.getUrl(), adms_requestproperties.getHeaders())) goto _L8; else goto _L7
_L7:
            if (worker.trackOffline)
            {
                worker.writeToDisk();
            }
_L6:
            Thread.sleep(delay);
            delay = 0L;
              goto _L9
_L2:
            return;
_L8:
            ADMS_Measurement.sharedInstance().debugLog("ADMS SDK Error: Error Sending Hit");
            if (worker.trackOffline)
            {
                delay = 30000L;
                worker.pushRequest(((String) (obj)));
            }
              goto _L6
_L4:
            try
            {
                cancelled = true;
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ADMS_Measurement.sharedInstance().debugLog((new StringBuilder()).append("ADMS SDK Error: Background Thread Interrupted -- ").append(((Exception) (obj)).getMessage()).toString());
            }
              goto _L2
            delay = 30000L;
              goto _L6
        }

        public WorkerThread(ADMS_Worker adms_worker)
        {
            delay = 0L;
            worker = null;
            cancelled = false;
            worker = adms_worker;
        }
    }


    private final Object backgroundMutex = new Object();
    private WorkerThread backgroundThread;
    protected String cacheFilename;
    private boolean offlineForced;
    protected int offlineLimit;
    private final ArrayList queuedMessages = new ArrayList();
    protected boolean trackOffline;

    protected ADMS_Worker()
    {
        backgroundThread = null;
        cacheFilename = null;
        trackOffline = false;
        offlineLimit = 100;
        offlineForced = false;
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
        synchronized (queuedMessages)
        {
            queuedMessages.clear();
            writeToDisk();
        }
        return;
        exception;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected int getTrackingQueueSize()
    {
        int i;
        synchronized (queuedMessages)
        {
            i = queuedMessages.size();
        }
        return i;
        exception;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected String popRequest()
    {
        String s = null;
        synchronized (queuedMessages)
        {
            if (queuedMessages.size() > 0)
            {
                s = (String)queuedMessages.get(0);
                queuedMessages.remove(0);
            }
        }
        return s;
        exception;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void pushRequest(String s)
    {
        synchronized (queuedMessages)
        {
            queuedMessages.add(0, s);
        }
        return;
        s;
        arraylist;
        JVM INSTR monitorexit ;
        throw s;
    }

    protected void queue(String s)
    {
        if (trackOffline || !offlineForced) goto _L2; else goto _L1
_L1:
        return;
_L2:
        ArrayList arraylist = queuedMessages;
        arraylist;
        JVM INSTR monitorenter ;
        queuedMessages.add(s);
        if (trackOffline)
        {
            for (; queuedMessages.size() > offlineLimit; queuedMessages.remove(0)) { }
        }
        break MISSING_BLOCK_LABEL_69;
        s;
        arraylist;
        JVM INSTR monitorexit ;
        throw s;
        arraylist;
        JVM INSTR monitorexit ;
        if (trackOffline)
        {
            writeToDisk();
        }
        if (!offlineForced)
        {
            setOnline(true);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    protected void readFromDisk()
    {
        Object obj;
        while (cacheFilename == null || ((obj = new File(cacheFilename)) == null || !((File) (obj)).exists())) 
        {
            return;
        }
        ArrayList arraylist;
        obj = new BufferedReader(new InputStreamReader(new FileInputStream(((File) (obj))), "UTF-8"));
        arraylist = new ArrayList();
_L1:
        String s = ((BufferedReader) (obj)).readLine();
label0:
        {
            if (s == null)
            {
                break label0;
            }
            try
            {
                arraylist.add(s);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ADMS_Measurement.sharedInstance().debugLog((new StringBuilder()).append("ADMS SDK Error: Cannot Read Requests From Disk -- ").append(((IOException) (obj)).getMessage()).toString());
                return;
            }
        }
          goto _L1
        if (arraylist.size() > 0)
        {
            synchronized (queuedMessages)
            {
                queuedMessages.clear();
                queuedMessages.addAll(arraylist);
            }
        }
        ((BufferedReader) (obj)).close();
        return;
        exception;
        arraylist1;
        JVM INSTR monitorexit ;
        throw exception;
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
        if (trackOffline)
        {
            writeToDisk();
        }
        offlineForced = true;
        return;
        exception1;
        obj1;
        JVM INSTR monitorexit ;
        throw exception1;
    }

    protected void writeToDisk()
    {
_L2:
        return;
        Object obj1;
        if (cacheFilename == null || (obj1 = new File(cacheFilename)) == null) goto _L2; else goto _L1
_L1:
        Object obj;
        Object obj3;
        obj = null;
        obj3 = null;
        obj1 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(((File) (obj1))), "UTF-8"), 2048);
        Object obj2 = queuedMessages;
        obj2;
        JVM INSTR monitorenter ;
        obj = new ArrayList(queuedMessages);
        obj2;
        JVM INSTR monitorexit ;
        for (obj = ((ArrayList) (obj)).iterator(); ((Iterator) (obj)).hasNext(); ((BufferedWriter) (obj1)).newLine())
        {
            obj2 = (String)((Iterator) (obj)).next();
            ((BufferedWriter) (obj1)).write(((String) (obj2)), 0, ((String) (obj2)).length());
        }

        continue; /* Loop/switch isn't completed */
_L4:
        obj = obj1;
        ADMS_Measurement.sharedInstance().debugLog((new StringBuilder()).append("ADMS SDK Error: Cannot Write Requests To Disk -- ").append(((IOException) (obj2)).getMessage()).toString());
        if (obj1 == null) goto _L2; else goto _L3
_L3:
        try
        {
            ((BufferedWriter) (obj1)).close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ADMS_Measurement.sharedInstance().debugLog((new StringBuilder()).append("ADMS SDK Error: Cannot close buffered writer -- ").append(((IOException) (obj)).getMessage()).toString());
        }
        return;
        obj;
_L7:
        obj2;
        JVM INSTR monitorexit ;
        try
        {
            throw obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj2) { }
        finally { }
          goto _L4
_L6:
        obj1 = obj;
        obj = obj2;
        if (obj1 != null)
        {
            try
            {
                ((BufferedWriter) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                ADMS_Measurement.sharedInstance().debugLog((new StringBuilder()).append("ADMS SDK Error: Cannot close buffered writer -- ").append(((IOException) (obj1)).getMessage()).toString());
            }
        }
        throw obj;
        if (obj1 == null) goto _L2; else goto _L5
_L5:
        try
        {
            ((BufferedWriter) (obj1)).close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ADMS_Measurement.sharedInstance().debugLog((new StringBuilder()).append("ADMS SDK Error: Cannot close buffered writer -- ").append(((IOException) (obj)).getMessage()).toString());
        }
        return;
        obj2;
          goto _L6
        obj2;
        obj1 = obj3;
          goto _L4
        obj;
          goto _L7
    }
}
