// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics;

import com.amazon.client.metrics.clickstream.ClickStreamData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.client.metrics:
//            MetricEvent, MetricEventType, AggregatingTimer, MetricsException, 
//            DataPoint, DataPointType, DoubleValidator

public class BasicMetricEvent
    implements MetricEvent
{

    private static final String ALLOW_RUNNING_TIMERS_KEY = "AllowRunning";
    public static final String ATTRIBUTE_DELIMITER = " ; ";
    private static final String DATAPOINTS_MAP_KEY = "Datapoints";
    private static final String DATAPOINT_DELIMITER = "\t";
    public static final String LIST_DELIMITER = ",";
    private static final String METRIC_EVENT_TYPE_KEY = "Type";
    private static final String PROGRAM_MAP_KEY = "Program";
    private static final String SOURCE_MAP_KEY = "Source";
    private boolean mAllowRunningTimers;
    private boolean mAnonymous;
    protected Map mCounters;
    private MetricEventType mMetricEventType;
    private String mNonAnonymousCustomerId;
    private String mNonAnonymousSessionId;
    private String mProgram;
    private String mSource;
    protected Map mStringClickstreamValues;
    protected Map mStringDiscreteValues;
    protected Map mTimers;

    public BasicMetricEvent(String s, String s1)
    {
        this(s, s1, MetricEventType.getDefault());
    }

    public BasicMetricEvent(String s, String s1, MetricEventType metriceventtype)
    {
        this(s, s1, metriceventtype, false);
    }

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

    private void addClickStreamData(String s, String s1)
    {
        validateString(s);
        if (validateStringValue(s1))
        {
            mStringClickstreamValues.put(s, s1);
        }
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

    public void addDataPoint(DataPoint datapoint)
        throws MetricsException
    {
        DataPointType datapointtype = datapoint.getType();
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$client$metrics$DataPointType[];

            static 
            {
                $SwitchMap$com$amazon$client$metrics$DataPointType = new int[DataPointType.values().length];
                try
                {
                    $SwitchMap$com$amazon$client$metrics$DataPointType[DataPointType.CT.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$amazon$client$metrics$DataPointType[DataPointType.TI.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$client$metrics$DataPointType[DataPointType.DV.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$client$metrics$DataPointType[DataPointType.CK.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.amazon.client.metrics.DataPointType[datapointtype.ordinal()];
        JVM INSTR tableswitch 1 4: default 157
    //                   1 95
    //                   2 111
    //                   3 131
    //                   4 144;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        IllegalArgumentException illegalargumentexception;
        throw new IllegalArgumentException("Invalid DataPointType");
_L2:
        try
        {
            addCounter(datapoint.getName(), Double.parseDouble(datapoint.getValue()));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (IllegalArgumentException illegalargumentexception)
        {
            throw new MetricsException((new StringBuilder()).append("Invalid DataPoint. DataPointType: ").append(datapointtype).append(", DataPoint value: ").append(datapoint.getValue()).toString(), illegalargumentexception);
        }
_L3:
        addTimer(datapoint.getName(), Double.parseDouble(datapoint.getValue()), datapoint.getSamples());
        return;
_L4:
        addString(datapoint.getName(), datapoint.getValue());
        return;
_L5:
        addClickStreamData(datapoint.getName(), datapoint.getValue());
        return;
    }

    public void addDataPoints(List list)
        throws MetricsException
    {
        int i = 0;
        Object obj = null;
        Iterator iterator = list.iterator();
        list = obj;
        while (iterator.hasNext()) 
        {
            DataPoint datapoint = (DataPoint)iterator.next();
            try
            {
                addDataPoint(datapoint);
            }
            // Misplaced declaration of an exception variable
            catch (List list)
            {
                i++;
            }
        }
        if (i != 0)
        {
            throw new MetricsException((new StringBuilder()).append(i).append(" MetricsExceptions were thrown").append(" while adding datapoints").toString(), list);
        } else
        {
            return;
        }
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

    protected String convertDataPointToString(DataPoint datapoint)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(datapoint.getName()).append(" ; ");
        stringbuilder.append(datapoint.getType().toString()).append(" ; ");
        stringbuilder.append(datapoint.getValue()).append(" ; ");
        stringbuilder.append(datapoint.getSamples());
        return stringbuilder.toString();
    }

    protected DataPoint convertStringToDataPoint(String s)
        throws IllegalArgumentException
    {
        String as[] = s.split(" ; ");
        if (as.length < 4)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Not enough parts to the datapoint: ").append(s).toString());
        } else
        {
            return new DataPoint(as[0], as[2], Integer.valueOf(as[3]).intValue(), DataPointType.valueOf(as[1]));
        }
    }

    public boolean getAnonymous()
    {
        return mAnonymous;
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
        Iterator iterator1 = mStringDiscreteValues.entrySet().iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry1 = (java.util.Map.Entry)iterator1.next();
            boolean flag = false;
            ClickStreamData aclickstreamdata[] = ClickStreamData.values();
            int j = aclickstreamdata.length;
            for (int i = 0; i < j; i++)
            {
                if (aclickstreamdata[i].getName().equals(entry1.getKey()))
                {
                    flag = true;
                }
            }

            if (!flag)
            {
                arraylist.add(new DataPoint((String)entry1.getKey(), listToString((List)entry1.getValue()), 1, DataPointType.DV));
            }
        } while (true);
        java.util.Map.Entry entry2;
        for (Iterator iterator2 = mStringClickstreamValues.entrySet().iterator(); iterator2.hasNext(); arraylist.add(new DataPoint((String)entry2.getKey(), (String)entry2.getValue(), 1, DataPointType.CK)))
        {
            entry2 = (java.util.Map.Entry)iterator2.next();
        }

        return arraylist;
    }

    public MetricEventType getMetricEventType()
    {
        return mMetricEventType;
    }

    public String getNonAnonymousCustomerId()
    {
        return mNonAnonymousCustomerId;
    }

    public String getNonAnonymousSessionId()
    {
        return mNonAnonymousSessionId;
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

    public void removeCounter(String s)
    {
        mCounters.remove(s);
    }

    public void removeString(String s)
    {
        mStringDiscreteValues.remove(s);
    }

    public void removeTimer(String s)
    {
        mTimers.remove(s);
    }

    public void restoreFromMap(Map map)
        throws IllegalArgumentException
    {
        if (!map.containsKey("Program") || !map.containsKey("Source") || !map.containsKey("Type") || !map.containsKey("AllowRunning") || !map.containsKey("Datapoints"))
        {
            throw new IllegalArgumentException("Map doesn't capture a MetricEvent");
        }
        mProgram = (String)map.get("Program");
        mSource = (String)map.get("Source");
        mMetricEventType = MetricEventType.valueOf((String)map.get("Type"));
        if ("1".equals(map.get("AllowRunning")))
        {
            mAllowRunningTimers = true;
        } else
        {
            mAllowRunningTimers = false;
        }
        map = (String)map.get("Datapoints");
        if (!"".equals(map))
        {
            map = map.split("\t");
            int i = 0;
            while (i < map.length) 
            {
                try
                {
                    addDataPoint(convertStringToDataPoint(map[i]));
                }
                catch (MetricsException metricsexception)
                {
                    throw new IllegalArgumentException((new StringBuilder()).append("Unable to restore, invalid datapoint string: ").append(map[i]).toString(), metricsexception);
                }
                i++;
            }
        }
    }

    public void saveToMap(Map map)
    {
        map.put("Program", mProgram);
        map.put("Source", mSource);
        map.put("Type", mMetricEventType.toString());
        Object obj;
        List list;
        if (mAllowRunningTimers)
        {
            obj = "1";
        } else
        {
            obj = "0";
        }
        map.put("AllowRunning", obj);
        obj = new StringBuilder();
        list = getAsDataPoints();
        for (int i = 0; i < list.size(); i++)
        {
            ((StringBuilder) (obj)).append(convertDataPointToString((DataPoint)list.get(i)));
            ((StringBuilder) (obj)).append("\t");
        }

        map.put("Datapoints", ((StringBuilder) (obj)).toString());
    }

    public void setAnonymous(boolean flag)
    {
        mAnonymous = flag;
    }

    public void setNonAnonymousCustomerId(String s)
    {
        mNonAnonymousCustomerId = s;
    }

    public void setNonAnonymousSessionId(String s)
    {
        mNonAnonymousSessionId = s;
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
