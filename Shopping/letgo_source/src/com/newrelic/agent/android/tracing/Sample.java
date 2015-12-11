// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.tracing;

import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonPrimitive;

// Referenced classes of package com.newrelic.agent.android.tracing:
//            SampleValue

public class Sample extends HarvestableArray
{
    public static final class SampleType extends Enum
    {

        private static final SampleType $VALUES[];
        public static final SampleType CPU;
        public static final SampleType MEMORY;

        public static SampleType valueOf(String s)
        {
            return (SampleType)Enum.valueOf(com/newrelic/agent/android/tracing/Sample$SampleType, s);
        }

        public static SampleType[] values()
        {
            return (SampleType[])$VALUES.clone();
        }

        static 
        {
            MEMORY = new SampleType("MEMORY", 0);
            CPU = new SampleType("CPU", 1);
            $VALUES = (new SampleType[] {
                MEMORY, CPU
            });
        }

        private SampleType(String s, int i)
        {
            super(s, i);
        }
    }


    private SampleValue sampleValue;
    private long timestamp;
    private SampleType type;

    public Sample(long l)
    {
        setTimestamp(l);
    }

    public Sample(long l, SampleValue samplevalue)
    {
        setTimestamp(l);
        setSampleValue(samplevalue);
    }

    public Sample(SampleType sampletype)
    {
        setSampleType(sampletype);
        setTimestamp(System.currentTimeMillis());
    }

    public JsonArray asJsonArray()
    {
        JsonArray jsonarray = new JsonArray();
        jsonarray.add(new JsonPrimitive(Long.valueOf(timestamp)));
        jsonarray.add(new JsonPrimitive(sampleValue.getValue()));
        return jsonarray;
    }

    public SampleType getSampleType()
    {
        return type;
    }

    public SampleValue getSampleValue()
    {
        return sampleValue;
    }

    public long getTimestamp()
    {
        return timestamp;
    }

    public Number getValue()
    {
        return sampleValue.getValue();
    }

    public void setSampleType(SampleType sampletype)
    {
        type = sampletype;
    }

    public void setSampleValue(double d)
    {
        sampleValue = new SampleValue(d);
    }

    public void setSampleValue(long l)
    {
        sampleValue = new SampleValue(l);
    }

    public void setSampleValue(SampleValue samplevalue)
    {
        sampleValue = samplevalue;
    }

    public void setTimestamp(long l)
    {
        timestamp = l;
    }
}
