// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.client.metrics:
//            MetricEvent, AggregatingTimer, DataPoint, DataPointType, 
//            MetricEventType, DoubleValidator

public class BasicMetricEvent
    implements MetricEvent
{

    private boolean mAllowRunningTimers;
    protected Map mCounters;
    private MetricEventType mMetricEventType;
    private String mProgram;
    private String mSource;
    protected Map mStringClickstreamValues;
    protected Map mStringDiscreteValues;
    protected Map mTimers;

    public BasicMetricEvent(String s, String s1, MetricEventType metriceventtype, boolean flag)
    {
        mCounters = new HashMap();
        mTimers = new HashMap();
        mStringDiscreteValues = new HashMap();
        mStringClickstreamValues = new HashMap();
        validateString(s);
        validateString(s1);
        mProgram = s;
        mSource = s1;
        mMetricEventType = metriceventtype;
        mAllowRunningTimers = flag;
    }

    private AggregatingTimer getOrCreateTimer(String s)
    {
        AggregatingTimer aggregatingtimer = (AggregatingTimer)mTimers.get(s);
        s = aggregatingtimer;
        if (aggregatingtimer == null)
        {
            s = new AggregatingTimer(mAllowRunningTimers);
        }
        return s;
    }

    private String listToString(List list)
    {
        if (list.isEmpty())
        {
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(list.get(0).toString());
        for (int i = 1; i < list.size(); i++)
        {
            stringbuilder.append(",").append(list.get(i).toString());
        }

        return stringbuilder.toString();
    }

    private void validateString(String s)
    {
        if (s == null || s.length() == 0)
        {
            throw new IllegalArgumentException("Invalid string. Cannot be null or empty");
        } else
        {
            return;
        }
    }

    private boolean validateStringValue(String s)
    {
        return s != null && !s.contains(" ; ");
    }

    public void addCounter(String s, double d)
    {
        incrementCounter(s, d);
    }

    public void addString(String s, String s1)
    {
        appendString(s, s1);
    }

    public void addTimer(String s, double d)
    {
        addTimer(s, d, 1);
    }

    public void addTimer(String s, double d, int i)
    {
        validateString(s);
        AggregatingTimer aggregatingtimer = getOrCreateTimer(s);
        aggregatingtimer.addTime(d, i);
        mTimers.put(s, aggregatingtimer);
    }

    public void appendString(String s, String s1)
    {
        validateString(s);
        if (validateStringValue(s1))
        {
            List list = (List)mStringDiscreteValues.get(s);
            Object obj = list;
            if (list == null)
            {
                obj = new ArrayList();
            }
            ((List) (obj)).add(s1);
            mStringDiscreteValues.put(s, obj);
        }
    }

    public void clear()
    {
        mCounters.clear();
        mTimers.clear();
        mStringDiscreteValues.clear();
    }

    public List getAsDataPoints()
    {
        ArrayList arraylist;
        Iterator iterator3;
        arraylist = new ArrayList();
        java.util.Map.Entry entry;
        for (Iterator iterator = mCounters.entrySet().iterator(); iterator.hasNext(); arraylist.add(new DataPoint((String)entry.getKey(), Double.toString(((Double)entry.getValue()).doubleValue()), 1, DataPointType.CT)))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        iterator3 = mTimers.entrySet().iterator();
_L9:
        if (!iterator3.hasNext()) goto _L2; else goto _L1
_L1:
        Object obj = (java.util.Map.Entry)iterator3.next();
        if (((AggregatingTimer)((java.util.Map.Entry) (obj)).getValue()).getSamples() != 0) goto _L4; else goto _L3
_L3:
        if (!mAllowRunningTimers || ((AggregatingTimer)((java.util.Map.Entry) (obj)).getValue()).numRunningTimers() <= 0)
        {
            throw new IllegalStateException((new StringBuilder()).append("Discarding timer as sample count is 0. Timer name: ").append((String)((java.util.Map.Entry) (obj)).getKey()).toString());
        }
          goto _L5
_L4:
        if (!mMetricEventType.equals(MetricEventType.AGGREGATING)) goto _L7; else goto _L6
_L6:
        obj = new DataPoint((String)((java.util.Map.Entry) (obj)).getKey(), Double.toString(((AggregatingTimer)((java.util.Map.Entry) (obj)).getValue()).getElapsedTime()), ((AggregatingTimer)((java.util.Map.Entry) (obj)).getValue()).getSamples(), DataPointType.TI);
_L8:
        arraylist.add(obj);
          goto _L5
_L7:
label0:
        {
            if (!mMetricEventType.equals(MetricEventType.AVERAGING))
            {
                break label0;
            }
            double d = ((AggregatingTimer)((java.util.Map.Entry) (obj)).getValue()).getElapsedTime() / (double)((AggregatingTimer)((java.util.Map.Entry) (obj)).getValue()).getSamples();
            obj = new DataPoint((String)((java.util.Map.Entry) (obj)).getKey(), Double.toString(d), 1, DataPointType.TI);
        }
          goto _L8
        try
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Unknown Metric event type. Metric event type: ").append(mMetricEventType).toString());
        }
        catch (IllegalStateException illegalstateexception) { }
        catch (IllegalArgumentException illegalargumentexception) { }
_L5:
        if (true) goto _L9; else goto _L2
_L2:
        java.util.Map.Entry entry1;
        for (Iterator iterator1 = mStringDiscreteValues.entrySet().iterator(); iterator1.hasNext(); arraylist.add(new DataPoint((String)entry1.getKey(), listToString((List)entry1.getValue()), 1, DataPointType.DV)))
        {
            entry1 = (java.util.Map.Entry)iterator1.next();
        }

        java.util.Map.Entry entry2;
        for (Iterator iterator2 = mStringClickstreamValues.entrySet().iterator(); iterator2.hasNext(); arraylist.add(new DataPoint((String)entry2.getKey(), (String)entry2.getValue(), 1, DataPointType.CK)))
        {
            entry2 = (java.util.Map.Entry)iterator2.next();
        }

        return arraylist;
    }

    public String getProgram()
    {
        return mProgram;
    }

    public String getSource()
    {
        return mSource;
    }

    public boolean hasDataPoints()
    {
        return getAsDataPoints().size() > 0;
    }

    public void incrementCounter(String s, double d)
    {
        DoubleValidator.validateDouble(d);
        validateString(s);
        double d1 = 0.0D;
        if (mCounters.containsKey(s))
        {
            d1 = ((Double)mCounters.get(s)).doubleValue();
        }
        mCounters.put(s, Double.valueOf(d1 + d));
    }

    public void startTimer(String s)
    {
        validateString(s);
        AggregatingTimer aggregatingtimer = getOrCreateTimer(s);
        aggregatingtimer.startTimer();
        mTimers.put(s, aggregatingtimer);
    }

    public void stopTimer(String s)
    {
        validateString(s);
        s = (AggregatingTimer)mTimers.get(s);
        if (s == null)
        {
            return;
        } else
        {
            s.stopTimer();
            return;
        }
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(mProgram);
        stringbuilder.append(" ");
        stringbuilder.append(mSource);
        stringbuilder.append(" ");
        List list = getAsDataPoints();
        for (int i = 0; i < list.size(); i++)
        {
            stringbuilder.append(((DataPoint)list.get(i)).toString());
        }

        stringbuilder.append("\n");
        return stringbuilder.toString();
    }
}
