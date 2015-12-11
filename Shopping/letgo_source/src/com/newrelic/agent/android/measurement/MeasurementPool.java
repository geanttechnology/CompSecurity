// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.measurement;

import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.measurement.consumer.MeasurementConsumer;
import com.newrelic.agent.android.measurement.producer.BaseMeasurementProducer;
import com.newrelic.agent.android.measurement.producer.MeasurementProducer;
import com.newrelic.agent.android.util.ExceptionHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

// Referenced classes of package com.newrelic.agent.android.measurement:
//            MeasurementType, Measurement

public class MeasurementPool extends BaseMeasurementProducer
    implements MeasurementConsumer
{

    private static final AgentLog log = AgentLogManager.getAgentLog();
    private final Collection consumers = new CopyOnWriteArrayList();
    private final Collection producers = new CopyOnWriteArrayList();

    public MeasurementPool()
    {
        super(MeasurementType.Any);
        addMeasurementProducer(this);
    }

    public void addMeasurementConsumer(MeasurementConsumer measurementconsumer)
    {
label0:
        {
            if (measurementconsumer == null)
            {
                break MISSING_BLOCK_LABEL_78;
            }
            synchronized (consumers)
            {
                if (!consumers.contains(measurementconsumer))
                {
                    break label0;
                }
                log.debug((new StringBuilder()).append("Attempted to add the same MeasurementConsumer ").append(measurementconsumer).append(" multiple times.").toString());
            }
            return;
        }
        consumers.add(measurementconsumer);
        collection;
        JVM INSTR monitorexit ;
        return;
        measurementconsumer;
        collection;
        JVM INSTR monitorexit ;
        throw measurementconsumer;
        log.debug("Attempted to add null MeasurementConsumer.");
        return;
    }

    public void addMeasurementProducer(MeasurementProducer measurementproducer)
    {
label0:
        {
            if (measurementproducer == null)
            {
                break MISSING_BLOCK_LABEL_78;
            }
            synchronized (producers)
            {
                if (!producers.contains(measurementproducer))
                {
                    break label0;
                }
                log.debug((new StringBuilder()).append("Attempted to add the same MeasurementProducer ").append(measurementproducer).append("  multiple times.").toString());
            }
            return;
        }
        producers.add(measurementproducer);
        collection;
        JVM INSTR monitorexit ;
        return;
        measurementproducer;
        collection;
        JVM INSTR monitorexit ;
        throw measurementproducer;
        log.debug("Attempted to add null MeasurementProducer.");
        return;
    }

    public void broadcastMeasurements()
    {
        ArrayList arraylist = new ArrayList();
        Collection collection = producers;
        collection;
        JVM INSTR monitorenter ;
        Iterator iterator = producers.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Collection collection1 = ((MeasurementProducer)iterator.next()).drainMeasurements();
            if (collection1.size() > 0)
            {
                arraylist.addAll(collection1);
                while (arraylist.remove(null)) ;
            }
        } while (true);
        collection;
        JVM INSTR monitorexit ;
        if (arraylist.size() <= 0) goto _L2; else goto _L1
_L1:
        collection = consumers;
        collection;
        JVM INSTR monitorenter ;
        Iterator iterator1 = consumers.iterator();
_L8:
        MeasurementConsumer measurementconsumer;
        Iterator iterator2;
        if (!iterator1.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        measurementconsumer = (MeasurementConsumer)iterator1.next();
        iterator2 = (new ArrayList(arraylist)).iterator();
_L5:
        Measurement measurement;
        if (!iterator2.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        measurement = (Measurement)iterator2.next();
        if (measurementconsumer.getMeasurementType() == measurement.getType()) goto _L4; else goto _L3
_L3:
        MeasurementType measurementtype;
        MeasurementType measurementtype1;
        measurementtype = measurementconsumer.getMeasurementType();
        measurementtype1 = MeasurementType.Any;
        if (measurementtype != measurementtype1) goto _L5; else goto _L4
_L4:
        measurementconsumer.consumeMeasurement(measurement);
          goto _L5
        Exception exception1;
        exception1;
        ExceptionHelper.exceptionToErrorCode(exception1);
        log.error((new StringBuilder()).append("broadcastMeasurements exception[").append(exception1.getClass().getName()).append("]").toString());
        if (true) goto _L5; else goto _L6
_L6:
        if (true) goto _L8; else goto _L7
        Exception exception;
        exception;
        collection;
        JVM INSTR monitorexit ;
        throw exception;
        exception;
        collection;
        JVM INSTR monitorexit ;
        throw exception;
_L7:
        collection;
        JVM INSTR monitorexit ;
_L2:
    }

    public void consumeMeasurement(Measurement measurement)
    {
        produceMeasurement(measurement);
    }

    public void consumeMeasurements(Collection collection)
    {
        produceMeasurements(collection);
    }

    public Collection getMeasurementConsumers()
    {
        return consumers;
    }

    public Collection getMeasurementProducers()
    {
        return producers;
    }

    public MeasurementType getMeasurementType()
    {
        return MeasurementType.Any;
    }

    public void removeMeasurementConsumer(MeasurementConsumer measurementconsumer)
    {
label0:
        {
            synchronized (consumers)
            {
                if (consumers.contains(measurementconsumer))
                {
                    break label0;
                }
                log.debug((new StringBuilder()).append("Attempted to remove MeasurementConsumer ").append(measurementconsumer).append(" which is not registered.").toString());
            }
            return;
        }
        consumers.remove(measurementconsumer);
        collection;
        JVM INSTR monitorexit ;
        return;
        measurementconsumer;
        collection;
        JVM INSTR monitorexit ;
        throw measurementconsumer;
    }

    public void removeMeasurementProducer(MeasurementProducer measurementproducer)
    {
label0:
        {
            synchronized (producers)
            {
                if (producers.contains(measurementproducer))
                {
                    break label0;
                }
                log.debug((new StringBuilder()).append("Attempted to remove MeasurementProducer ").append(measurementproducer).append(" which is not registered.").toString());
            }
            return;
        }
        producers.remove(measurementproducer);
        collection;
        JVM INSTR monitorexit ;
        return;
        measurementproducer;
        collection;
        JVM INSTR monitorexit ;
        throw measurementproducer;
    }

}
