// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.altbeacon.beacon.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.logging.LogManager;

public class Stats
{

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("HH:mm:ss.SSS");
    private static final String TAG = "Stats";
    private static Stats mInstance;
    private boolean mEnableHistoricalLogging;
    private boolean mEnableLogging;
    private boolean mEnabled;
    private Sample mSample;
    private long mSampleIntervalMillis;
    private ArrayList mSamples;

    private Stats()
    {
        mSampleIntervalMillis = 0L;
        clearSamples();
    }

    private String formattedDate(Date date)
    {
        if (date == null)
        {
            return "";
        } else
        {
            return SIMPLE_DATE_FORMAT.format(date);
        }
    }

    public static Stats getInstance()
    {
        if (mInstance == null)
        {
            mInstance = new Stats();
        }
        return mInstance;
    }

    private void logSample(Sample sample, boolean flag)
    {
        if (flag)
        {
            LogManager.d("Stats", "sample start time, sample stop time, first detection time, last detection time, max millis between detections, detection count", new Object[0]);
        }
    /* block-local class not found */
    class Sample {}

        LogManager.d("Stats", "%s, %s, %s, %s, %s, %s", new Object[] {
            formattedDate(sample.sampleStartTime), formattedDate(sample.sampleStopTime), formattedDate(sample.firstDetectionTime), formattedDate(sample.lastDetectionTime), Long.valueOf(sample.maxMillisBetweenDetections), Long.valueOf(sample.detectionCount)
        });
    }

    private void logSamples()
    {
        LogManager.d("Stats", "--- Stats for %s samples", new Object[] {
            Integer.valueOf(mSamples.size())
        });
        boolean flag = true;
        for (Iterator iterator = mSamples.iterator(); iterator.hasNext();)
        {
            logSample((Sample)iterator.next(), flag);
            flag = false;
        }

    }

    private void rollSampleIfNeeded()
    {
        if (mSample == null || mSampleIntervalMillis > 0L && (new Date()).getTime() - mSample.sampleStartTime.getTime() >= mSampleIntervalMillis)
        {
            newSampleInterval();
        }
    }

    public void clearSample()
    {
        mSample = null;
    }

    public void clearSamples()
    {
        mSamples = new ArrayList();
        newSampleInterval();
    }

    public ArrayList getSamples()
    {
        rollSampleIfNeeded();
        return mSamples;
    }

    public boolean isEnabled()
    {
        return mEnabled;
    }

    public void log(Beacon beacon)
    {
        rollSampleIfNeeded();
        beacon = mSample;
        beacon.detectionCount = ((Sample) (beacon)).detectionCount + 1L;
        if (mSample.firstDetectionTime == null)
        {
            mSample.firstDetectionTime = new Date();
        }
        if (mSample.lastDetectionTime != null)
        {
            long l = (new Date()).getTime() - mSample.lastDetectionTime.getTime();
            if (l > mSample.maxMillisBetweenDetections)
            {
                mSample.maxMillisBetweenDetections = l;
            }
        }
        mSample.lastDetectionTime = new Date();
    }

    public void newSampleInterval()
    {
        Date date = new Date();
        if (mSample != null)
        {
            Date date1 = new Date(mSample.sampleStartTime.getTime() + mSampleIntervalMillis);
            mSample.sampleStopTime = date1;
            date = date1;
            if (!mEnableHistoricalLogging)
            {
                date = date1;
                if (mEnableLogging)
                {
                    logSample(mSample, true);
                    date = date1;
                }
            }
        }
        mSample = new Sample();
        mSample.sampleStartTime = date;
        mSamples.add(mSample);
        if (mEnableHistoricalLogging)
        {
            logSamples();
        }
    }

    public void setEnabled(boolean flag)
    {
        mEnabled = flag;
    }

    public void setHistoricalLoggingEnabled(boolean flag)
    {
        mEnableHistoricalLogging = flag;
    }

    public void setLoggingEnabled(boolean flag)
    {
        mEnableLogging = flag;
    }

    public void setSampleIntervalMillis(long l)
    {
        mSampleIntervalMillis = l;
    }

}
