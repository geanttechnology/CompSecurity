// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android;

import com.newrelic.agent.android.activity.MeasuredActivity;
import com.newrelic.agent.android.activity.NamedActivity;
import com.newrelic.agent.android.measurement.MeasurementException;
import com.newrelic.agent.android.measurement.MeasurementPool;
import com.newrelic.agent.android.measurement.consumer.MeasurementConsumer;
import com.newrelic.agent.android.measurement.producer.MeasurementProducer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MeasurementEngine
{

    private final Map activities = new ConcurrentHashMap();
    private final MeasurementPool rootMeasurementPool = new MeasurementPool();

    public MeasurementEngine()
    {
    }

    public void addMeasurementConsumer(MeasurementConsumer measurementconsumer)
    {
        rootMeasurementPool.addMeasurementConsumer(measurementconsumer);
    }

    public void addMeasurementProducer(MeasurementProducer measurementproducer)
    {
        rootMeasurementPool.addMeasurementProducer(measurementproducer);
    }

    public void broadcastMeasurements()
    {
        rootMeasurementPool.broadcastMeasurements();
    }

    public void clear()
    {
        activities.clear();
    }

    public MeasuredActivity endActivity(String s)
    {
        MeasuredActivity measuredactivity = (MeasuredActivity)activities.get(s);
        if (measuredactivity == null)
        {
            throw new MeasurementException((new StringBuilder()).append("Activity '").append(s).append("' has not been started.").toString());
        } else
        {
            endActivity(measuredactivity);
            return measuredactivity;
        }
    }

    public void endActivity(MeasuredActivity measuredactivity)
    {
        rootMeasurementPool.removeMeasurementConsumer(measuredactivity.getMeasurementPool());
        activities.remove(measuredactivity.getName());
        measuredactivity.finish();
    }

    public void removeMeasurementConsumer(MeasurementConsumer measurementconsumer)
    {
        rootMeasurementPool.removeMeasurementConsumer(measurementconsumer);
    }

    public void removeMeasurementProducer(MeasurementProducer measurementproducer)
    {
        rootMeasurementPool.removeMeasurementProducer(measurementproducer);
    }

    public void renameActivity(String s, String s1)
    {
        s = (MeasuredActivity)activities.remove(s);
        if (s != null && (s instanceof NamedActivity))
        {
            activities.put(s1, s);
            ((NamedActivity)s).rename(s1);
        }
    }

    public MeasuredActivity startActivity(String s)
    {
        if (activities.containsKey(s))
        {
            throw new MeasurementException((new StringBuilder()).append("An activity with the name '").append(s).append("' has already started.").toString());
        } else
        {
            NamedActivity namedactivity = new NamedActivity(s);
            activities.put(s, namedactivity);
            s = new MeasurementPool();
            namedactivity.setMeasurementPool(s);
            rootMeasurementPool.addMeasurementConsumer(s);
            return namedactivity;
        }
    }
}
