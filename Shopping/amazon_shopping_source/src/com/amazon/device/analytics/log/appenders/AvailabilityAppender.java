// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.analytics.log.appenders;

import android.content.Context;
import com.amazon.device.analytics.configuration.Configuration;
import com.amazon.device.analytics.configuration.ConfigurationRefreshListener;
import com.amazon.device.analytics.events.UniqueIdService;
import com.amazon.sdk.availability.Measurement;
import com.amazon.sdk.availability.MeasurementManager;
import com.amazon.sdk.availability.MeasurementManagerFactory;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.device.analytics.log.appenders:
//            LogAppender

public class AvailabilityAppender
    implements ConfigurationRefreshListener, LogAppender
{
    static class LogMessage
    {

        private Throwable exception;
        private com.amazon.device.analytics.log.Logging.LogLevel level;
        private String message;
        private Long timestamp;

        private String getThrowableAsString(Throwable throwable)
        {
            PrintStream printstream;
            String s;
            Object obj1;
            Object obj2;
            Object obj3;
            s = "";
            obj1 = null;
            obj2 = null;
            obj3 = null;
            printstream = null;
            Object obj = new ByteArrayOutputStream();
            printstream = new PrintStream(((java.io.OutputStream) (obj)));
            throwable.printStackTrace(printstream);
            printstream.close();
            throwable = ((ByteArrayOutputStream) (obj)).toString("UTF-8");
            if (printstream != null)
            {
                printstream.close();
            }
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_172;
            }
            try
            {
                ((ByteArrayOutputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                return throwable;
            }
            obj = throwable;
_L2:
            return ((String) (obj));
            throwable;
            obj = obj2;
            throwable = printstream;
_L5:
            if (obj != null)
            {
                ((PrintStream) (obj)).close();
            }
            obj = s;
            if (throwable == null) goto _L2; else goto _L1
_L1:
            try
            {
                throwable.close();
            }
            // Misplaced declaration of an exception variable
            catch (Throwable throwable)
            {
                return "";
            }
            return "";
            obj;
            printstream = obj1;
            throwable = obj3;
_L4:
            if (printstream != null)
            {
                printstream.close();
            }
            if (throwable != null)
            {
                try
                {
                    throwable.close();
                }
                // Misplaced declaration of an exception variable
                catch (Throwable throwable) { }
            }
            throw obj;
            Exception exception1;
            exception1;
            throwable = ((Throwable) (obj));
            printstream = obj1;
            obj = exception1;
            continue; /* Loop/switch isn't completed */
            exception1;
            throwable = ((Throwable) (obj));
            obj = exception1;
            if (true) goto _L4; else goto _L3
_L3:
            throwable;
            throwable = ((Throwable) (obj));
            obj = obj2;
              goto _L5
            throwable;
            throwable = ((Throwable) (obj));
            obj = printstream;
              goto _L5
            return throwable;
        }

        public JSONObject toJSON()
        {
            JSONObject jsonobject = new JSONObject();
            if (level != null)
            {
                try
                {
                    jsonobject.put("logLevel", level.name());
                }
                catch (JSONException jsonexception3) { }
            }
            try
            {
                jsonobject.put("timestamp", timestamp);
            }
            catch (JSONException jsonexception2) { }
            if (message != null)
            {
                try
                {
                    jsonobject.put("message", message);
                }
                catch (JSONException jsonexception1) { }
            }
            if (exception != null)
            {
                try
                {
                    jsonobject.put("exception", getThrowableAsString(exception));
                }
                catch (JSONException jsonexception)
                {
                    return jsonobject;
                }
            }
            return jsonobject;
        }

        public LogMessage(com.amazon.device.analytics.log.Logging.LogLevel loglevel, String s, Throwable throwable)
        {
            message = null;
            exception = null;
            timestamp = null;
            level = null;
            level = loglevel;
            message = s;
            exception = throwable;
            timestamp = Long.valueOf(System.currentTimeMillis());
        }
    }


    private final ReentrantLock batchLock;
    public int batchSize;
    public String clientName;
    private Context context;
    private final ReentrantReadWriteLock lock;
    private final List logMessages;
    private final MeasurementManager manager;
    private final java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock readLock;
    public String version;
    private final java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock writeLock;

    public AvailabilityAppender(Context context1, Configuration configuration)
    {
        this(context1, MeasurementManagerFactory.getMeasurementManager(), configuration);
    }

    AvailabilityAppender(Context context1, MeasurementManager measurementmanager, Configuration configuration)
    {
        context = null;
        lock = new ReentrantReadWriteLock(true);
        readLock = lock.readLock();
        writeLock = lock.writeLock();
        batchLock = new ReentrantLock(true);
        batchSize = 0;
        logMessages = new CopyOnWriteArrayList();
        if (context1 != null)
        {
            context = context1.getApplicationContext();
        }
        if (configuration != null)
        {
            clientName = configuration.optString("appStoreAvailabilityClientName", "gamelab");
            version = configuration.optString("appStoreAvailabilityClientVersion", "1.0");
            batchSize = configuration.optInt("logBatchSize", Integer.valueOf(batchSize)).intValue();
            configuration.registerRefreshListener(this);
        } else
        {
            clientName = "gamelab";
            version = "1.0";
            batchSize = 0;
        }
        manager = measurementmanager;
    }

    private void enqueueLogMessage(LogMessage logmessage)
    {
        if (context != null && manager != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int j;
        j = 0;
        readLock.lock();
        if (batchSize > 0)
        {
            j = batchSize;
        }
        readLock.unlock();
        if (j <= 0) goto _L1; else goto _L3
_L3:
        batchLock.lock();
        int k;
        logMessages.add(logmessage);
        k = logMessages.size();
        if (k < j)
        {
            batchLock.unlock();
            return;
        }
        break MISSING_BLOCK_LABEL_98;
        logmessage;
        readLock.unlock();
        throw logmessage;
        logmessage = writeBatchToMeasurement();
        if (logmessage == null)
        {
            break MISSING_BLOCK_LABEL_121;
        }
        try
        {
            manager.putMeasurement(context, logmessage);
        }
        // Misplaced declaration of an exception variable
        catch (LogMessage logmessage) { }
        logMessages.clear();
        batchLock.unlock();
        return;
        logmessage;
        batchLock.unlock();
        throw logmessage;
    }

    private Measurement writeBatchToMeasurement()
    {
        Object obj;
        obj = (new Measurement()).setMeasurementName("Log").setMeasurementValueNumber(Integer.valueOf(1));
        String s = UniqueIdService.getUniqueId();
        if (s != null)
        {
            ((Measurement) (obj)).setMetadata("id", s);
        }
        readLock.lock();
        ((Measurement) (obj)).setClientId(clientName);
        ((Measurement) (obj)).setClientVersion(version);
        JSONArray jsonarray;
        readLock.unlock();
        jsonarray = new JSONArray();
        for (Iterator iterator = logMessages.iterator(); iterator.hasNext(); jsonarray.put(((LogMessage)iterator.next()).toJSON())) { }
        break MISSING_BLOCK_LABEL_125;
        obj;
        readLock.unlock();
        throw obj;
        ((Measurement) (obj)).setMetadata("messages", jsonarray.toString());
        return ((Measurement) (obj));
    }

    public void d(String s, String s1)
    {
        enqueueLogMessage(new LogMessage(com.amazon.device.analytics.log.Logging.LogLevel.DEBUG, s1, null));
    }

    public void d(String s, String s1, Throwable throwable)
    {
        enqueueLogMessage(new LogMessage(com.amazon.device.analytics.log.Logging.LogLevel.DEBUG, s1, throwable));
    }

    public void e(String s, String s1)
    {
        enqueueLogMessage(new LogMessage(com.amazon.device.analytics.log.Logging.LogLevel.ERROR, s1, null));
    }

    public void e(String s, String s1, Throwable throwable)
    {
        enqueueLogMessage(new LogMessage(com.amazon.device.analytics.log.Logging.LogLevel.ERROR, s1, throwable));
    }

    public void i(String s, String s1)
    {
        enqueueLogMessage(new LogMessage(com.amazon.device.analytics.log.Logging.LogLevel.INFO, s1, null));
    }

    public void onRefresh(Configuration configuration)
    {
        writeLock.lock();
        clientName = configuration.optString("appStoreAvailabilityClientName", clientName);
        version = configuration.optString("appStoreAvailabilityClientVersion", version);
        batchSize = configuration.optInt("logBatchSize", Integer.valueOf(batchSize)).intValue();
        writeLock.unlock();
        return;
        configuration;
        writeLock.unlock();
        throw configuration;
    }

    public void v(String s, String s1)
    {
        enqueueLogMessage(new LogMessage(com.amazon.device.analytics.log.Logging.LogLevel.VERBOSE, s1, null));
    }

    public void w(String s, String s1)
    {
        enqueueLogMessage(new LogMessage(com.amazon.device.analytics.log.Logging.LogLevel.WARN, s1, null));
    }

    public void w(String s, String s1, Throwable throwable)
    {
        enqueueLogMessage(new LogMessage(com.amazon.device.analytics.log.Logging.LogLevel.WARN, s1, throwable));
    }
}
