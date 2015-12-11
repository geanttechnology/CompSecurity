// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.radiusnetworks.ibeacon.service;

import android.util.Log;
import com.radiusnetworks.ibeacon.IBeacon;
import com.radiusnetworks.ibeacon.IBeaconManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;

public class RangedIBeacon extends IBeacon
{
    private class Measurement
        implements Comparable
    {

        Integer rssi;
        final RangedIBeacon this$0;
        long timestamp;

        public int compareTo(Measurement measurement)
        {
            return rssi.compareTo(measurement.rssi);
        }

        public volatile int compareTo(Object obj)
        {
            return compareTo((Measurement)obj);
        }

        private Measurement()
        {
            this$0 = RangedIBeacon.this;
            super();
        }

    }


    public static long DEFAULT_SAMPLE_EXPIRATION_MILLISECONDS;
    private static String TAG = "RangedIBeacon";
    private static long sampleExpirationMilliseconds;
    private ArrayList measurements;
    private boolean tracked;

    public RangedIBeacon(IBeacon ibeacon)
    {
        super(ibeacon);
        tracked = true;
        measurements = new ArrayList();
        addMeasurement(Integer.valueOf(rssi));
    }

    private double calculateRunningAverage()
    {
        refreshMeasurements();
        int i1 = measurements.size();
        double d;
        int i;
        int j;
        int k;
        if (i1 > 2)
        {
            i = i1 / 10;
            j = i1 / 10;
            i++;
            j = i1 - j - 2;
        } else
        {
            j = i1 - 1;
            i = 0;
        }
        k = 0;
        for (int l = i; l <= j; l++)
        {
            k += ((Measurement)measurements.get(l)).rssi.intValue();
        }

        j = (j - i) + 1;
        i = j;
        if (j == 0)
        {
            i = 1;
        }
        d = k / i;
        if (IBeaconManager.debug)
        {
            Log.d(TAG, (new StringBuilder()).append("Running average rssi based on ").append(i1).append(" measurements: ").append(d).toString());
        }
        return d;
    }

    private void refreshMeasurements()
    {
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist;
        Date date = new Date();
        arraylist = new ArrayList();
        Iterator iterator = measurements.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Measurement measurement = (Measurement)iterator.next();
            if (date.getTime() - measurement.timestamp < sampleExpirationMilliseconds)
            {
                arraylist.add(measurement);
            }
        } while (true);
        break MISSING_BLOCK_LABEL_78;
        Exception exception;
        exception;
        throw exception;
        measurements = arraylist;
        Collections.sort(measurements);
        this;
        JVM INSTR monitorexit ;
    }

    public static void setSampleExpirationMilliseconds(long l)
    {
        sampleExpirationMilliseconds = l;
    }

    public void addMeasurement(Integer integer)
    {
        tracked = true;
        Measurement measurement = new Measurement();
        measurement.rssi = integer;
        measurement.timestamp = (new Date()).getTime();
        measurements.add(measurement);
    }

    protected void addRangeMeasurement(Integer integer)
    {
        rssi = integer.intValue();
        addMeasurement(integer);
    }

    public void commitMeasurements()
    {
        runningAverageRssi = Double.valueOf(calculateRunningAverage());
        if (IBeaconManager.debug)
        {
            Log.d(TAG, (new StringBuilder()).append("calculated new runningAverageRssi:").append(runningAverageRssi).toString());
        }
        accuracy = null;
        proximity = null;
    }

    public boolean isTracked()
    {
        return tracked;
    }

    public boolean noMeasurementsAvailable()
    {
        return measurements.size() == 0;
    }

    public void setTracked(boolean flag)
    {
        tracked = flag;
    }

    static 
    {
        DEFAULT_SAMPLE_EXPIRATION_MILLISECONDS = 20000L;
        sampleExpirationMilliseconds = DEFAULT_SAMPLE_EXPIRATION_MILLISECONDS;
    }
}
