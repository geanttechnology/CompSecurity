// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.analytics.events.adapters;

import com.amazon.device.analytics.configuration.Configuration;
import com.amazon.device.analytics.configuration.ConfigurationRefreshListener;
import com.amazon.device.analytics.events.Event;
import com.amazon.device.analytics.log.Logger;
import com.amazon.device.analytics.log.Logging;
import com.amazon.device.analytics.util.JSONBuilder;
import com.amazon.sdk.availability.Measurement;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONObject;

// Referenced classes of package com.amazon.device.analytics.events.adapters:
//            JSONEventAdapter

public class MeasurementEventAdapter
    implements ConfigurationRefreshListener
{

    private static Logger logger = Logging.getLogger(com/amazon/device/analytics/events/adapters/MeasurementEventAdapter);
    public String clientName;
    private final JSONEventAdapter jsonAdapter = new JSONEventAdapter();
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
    private final java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock readLock;
    public String version;
    private final java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock writeLock;

    public MeasurementEventAdapter(Configuration configuration)
    {
        readLock = lock.readLock();
        writeLock = lock.writeLock();
        if (configuration != null)
        {
            clientName = configuration.optString("appStoreAvailabilityClientName", "gamelab");
            version = configuration.optString("appStoreAvailabilityClientVersion", "1.0");
            configuration.registerRefreshListener(this);
            return;
        } else
        {
            clientName = "gamelab";
            version = "1.0";
            return;
        }
    }

    public void onRefresh(Configuration configuration)
    {
        this;
        JVM INSTR monitorenter ;
        writeLock.lock();
        clientName = configuration.optString("appStoreAvailabilityClientName", clientName);
        version = configuration.optString("appStoreAvailabilityClientVersion", version);
        writeLock.unlock();
        this;
        JVM INSTR monitorexit ;
        return;
        configuration;
        writeLock.unlock();
        throw configuration;
        configuration;
        this;
        JVM INSTR monitorexit ;
        throw configuration;
    }

    public String toString()
    {
        return (new JSONBuilder(this)).toString();
    }

    public Measurement translateFromEvent(Event event)
    {
        Exception exception;
        if (event == null)
        {
            logger.w("The Event provided was null");
            return null;
        }
        exception = null;
        Measurement measurement = new Measurement();
        readLock.lock();
        measurement.setClientId(clientName);
        measurement.setClientVersion(version);
        readLock.unlock();
_L4:
        measurement.setMeasurementName(event.getEventType());
        measurement.setMeasurementValueNumber(Integer.valueOf(1));
        event = jsonAdapter.translateFromEvent(event);
        if (event == null) goto _L2; else goto _L1
_L1:
        measurement.setMetadata("event", event.toString());
          goto _L3
        exception;
        readLock.unlock();
          goto _L4
        event;
        event = measurement;
_L5:
        logger.e("Failed to translate Event to a Measurement");
        return event;
        event;
        readLock.unlock();
        throw event;
_L2:
        logger.e("Failed to translate Event to a JSONObject");
        break; /* Loop/switch isn't completed */
        event;
        event = exception;
        if (true) goto _L5; else goto _L3
_L3:
        return measurement;
    }

}
