// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.measurement.producer;

import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.measurement.Measurement;
import com.newrelic.agent.android.measurement.MeasurementType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

// Referenced classes of package com.newrelic.agent.android.measurement.producer:
//            MeasurementProducer

public class BaseMeasurementProducer
    implements MeasurementProducer
{

    private static final AgentLog log = AgentLogManager.getAgentLog();
    private final MeasurementType producedMeasurementType;
    private final ArrayList producedMeasurements = new ArrayList();

    public BaseMeasurementProducer(MeasurementType measurementtype)
    {
        producedMeasurementType = measurementtype;
    }

    public Collection drainMeasurements()
    {
label0:
        {
            java.util.List list;
            synchronized (producedMeasurements)
            {
                if (producedMeasurements.size() != 0)
                {
                    break label0;
                }
                list = Collections.emptyList();
            }
            return list;
        }
        ArrayList arraylist1;
        arraylist1 = new ArrayList(producedMeasurements);
        producedMeasurements.clear();
        arraylist;
        JVM INSTR monitorexit ;
        return arraylist1;
        exception;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public MeasurementType getMeasurementType()
    {
        return producedMeasurementType;
    }

    public void produceMeasurement(Measurement measurement)
    {
        ArrayList arraylist = producedMeasurements;
        arraylist;
        JVM INSTR monitorenter ;
        if (measurement == null)
        {
            break MISSING_BLOCK_LABEL_20;
        }
        producedMeasurements.add(measurement);
        arraylist;
        JVM INSTR monitorexit ;
        return;
        measurement;
        arraylist;
        JVM INSTR monitorexit ;
        throw measurement;
    }

    public void produceMeasurements(Collection collection)
    {
        ArrayList arraylist = producedMeasurements;
        arraylist;
        JVM INSTR monitorenter ;
        if (collection == null)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        producedMeasurements.addAll(collection);
        while (producedMeasurements.remove(null)) ;
        arraylist;
        JVM INSTR monitorexit ;
        return;
        collection;
        arraylist;
        JVM INSTR monitorexit ;
        throw collection;
    }

}
