// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.analytics;

import android.content.Context;
import com.amazon.device.analytics.configuration.Configuration;
import com.amazon.device.analytics.configuration.ConfigurationChangedListener;
import com.amazon.device.analytics.configuration.InMemoryConfiguration;
import com.amazon.device.analytics.events.DefaultEventRecorderBuilder;
import com.amazon.device.analytics.events.EventRecorder;
import com.amazon.device.analytics.events.UniqueIdService;
import com.amazon.device.analytics.events.observers.MeasurementManagerObserver;
import com.amazon.device.analytics.log.Logger;
import com.amazon.device.analytics.log.Logging;
import com.amazon.device.analytics.log.appenders.AvailabilityAppender;
import com.amazon.device.analytics.log.appenders.LogAppender;
import com.amazon.device.analytics.util.JSONBuilder;
import com.amazon.sdk.availability.MeasurementManager;
import com.amazon.sdk.availability.MeasurementManagerFactory;
import java.util.Collection;
import java.util.Iterator;

public final class AnalyticsClient
    implements ConfigurationChangedListener
{

    public static final String PREFS_NAME = (new StringBuilder()).append(com/amazon/device/analytics/AnalyticsClient.getName()).append(".configuration").toString();
    private static Logger logger = Logging.getLogger(com/amazon/device/analytics/AnalyticsClient);
    private Configuration config;
    private Context context;
    private MeasurementManager measurementManager;

    public AnalyticsClient(Context context1, Configuration configuration)
    {
        if (context1 != null)
        {
            context = context1.getApplicationContext();
            Object obj = configuration;
            if (configuration == null)
            {
                obj = new InMemoryConfiguration();
            }
            config = ((Configuration) (obj));
            UniqueIdService.initialize(context);
            Logging.setConfiguration(config);
            config.registerChangedListener("useAvailabilityLogAppender", this);
            if (((Configuration) (obj)).optBoolean("useAvailabilityLogAppender", Boolean.valueOf(false)).booleanValue())
            {
                Logging.attachLogAppender(new AvailabilityAppender(context1, config));
            }
        }
    }

    public static AnalyticsClient newInstance(Context context1, Configuration configuration)
    {
        return new AnalyticsClient(context1, configuration);
    }

    public EventRecorder newEventRecorder(String s)
    {
        s = (new DefaultEventRecorderBuilder()).withApplicationKey(s);
        if (context != null)
        {
            measurementManager = MeasurementManagerFactory.getMeasurementManager();
            s.withObserver(new MeasurementManagerObserver(context, measurementManager, config));
        }
        EventRecorder eventrecorder = s.build();
        if (logger.isLoggingEnabled(com.amazon.device.analytics.log.Logging.LogLevel.VERBOSE))
        {
            logger.v("Created new EventRecorder.");
            logger.v(eventrecorder.toString());
        }
        return s.build();
    }

    public void onPropertyChanged(String s, Object obj)
    {
        if (s.equals("useAvailabilityLogAppender")) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (Boolean.parseBoolean(obj.toString()))
        {
            if (context != null)
            {
                Logging.attachLogAppender(new AvailabilityAppender(context, config));
                return;
            }
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            s = Logging.getLogAppenders().iterator();
            while (s.hasNext()) 
            {
                obj = (LogAppender)s.next();
                if (obj instanceof AvailabilityAppender)
                {
                    Logging.detachLogAppender(((LogAppender) (obj)));
                }
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public String toString()
    {
        return (new JSONBuilder(this)).toString();
    }

}
