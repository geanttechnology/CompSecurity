// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.sample;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.newrelic.agent.android.harvest.AgentHealth;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.tracing.ActivityTrace;
import com.newrelic.agent.android.tracing.Sample;
import com.newrelic.agent.android.tracing.TraceLifecycleAware;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.newrelic.agent.android.util.NamedThreadFactory;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class Sampler
    implements TraceLifecycleAware, Runnable
{

    private static final int KB_IN_MB = 1024;
    private static final int PID[] = {
        Process.myPid()
    };
    private static final long SAMPLE_FREQ_MS = 100L;
    private static boolean cpuSamplingDisabled = false;
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private static Sampler sampler;
    private static final ReentrantLock samplerLock = new ReentrantLock();
    private final ActivityManager activityManager;
    private RandomAccessFile appStatFile;
    private final AtomicBoolean isRunning = new AtomicBoolean(false);
    private Long lastAppCpuTime;
    private Long lastCpuTime;
    private RandomAccessFile procStatFile;
    private ScheduledFuture sampleFuture;
    private final EnumMap samples = new EnumMap(com/newrelic/agent/android/tracing/Sample$SampleType);
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor(new NamedThreadFactory("Sampler"));

    private Sampler(Context context)
    {
        activityManager = (ActivityManager)context.getSystemService("activity");
        samples.put(com.newrelic.agent.android.tracing.Sample.SampleType.MEMORY, new ArrayList());
        samples.put(com.newrelic.agent.android.tracing.Sample.SampleType.CPU, new ArrayList());
    }

    private void clear()
    {
        for (Iterator iterator = samples.values().iterator(); iterator.hasNext(); ((Collection)iterator.next()).clear()) { }
    }

    public static Map copySamples()
    {
        samplerLock.lock();
        if (sampler == null)
        {
            samplerLock.unlock();
            return new HashMap();
        }
        EnumMap enummap = new EnumMap(sampler.samples);
        com.newrelic.agent.android.tracing.Sample.SampleType sampletype;
        for (Iterator iterator = sampler.samples.keySet().iterator(); iterator.hasNext(); enummap.put(sampletype, new ArrayList((Collection)sampler.samples.get(sampletype))))
        {
            sampletype = (com.newrelic.agent.android.tracing.Sample.SampleType)iterator.next();
        }

        samplerLock.unlock();
        return Collections.unmodifiableMap(enummap);
    }

    private Collection getSampleCollection(com.newrelic.agent.android.tracing.Sample.SampleType sampletype)
    {
        return (Collection)samples.get(sampletype);
    }

    public static void init(Context context)
    {
        samplerLock.lock();
        sampler = new Sampler(context);
        samplerLock.unlock();
        TraceMachine.addTraceListener(sampler);
        log.debug("Sampler Initialized");
    }

    public static boolean isRunning()
    {
        while (sampler == null || sampler.sampleFuture.isDone()) 
        {
            return false;
        }
        return true;
    }

    private void resetCpuSampler()
    {
        lastCpuTime = null;
        lastAppCpuTime = null;
        if (appStatFile == null || procStatFile == null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        appStatFile.close();
        procStatFile.close();
        appStatFile = null;
        procStatFile = null;
        return;
        IOException ioexception;
        ioexception;
        log.debug((new StringBuilder()).append("Exception hit while resetting CPU sampler: ").append(ioexception.getMessage()).toString());
        AgentHealth.noticeException(ioexception);
        return;
    }

    private void sample()
    {
        samplerLock.lock();
        Sample sample1 = sampleMemory();
        if (sample1 == null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        getSampleCollection(com.newrelic.agent.android.tracing.Sample.SampleType.MEMORY).add(sample1);
        sample1 = sampleCpu();
        if (sample1 == null)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        getSampleCollection(com.newrelic.agent.android.tracing.Sample.SampleType.CPU).add(sample1);
        samplerLock.unlock();
        return;
        Exception exception;
        exception;
        samplerLock.unlock();
        throw exception;
    }

    public static Sample sampleMemory()
    {
        if (sampler == null)
        {
            return null;
        } else
        {
            return sampleMemory(sampler.activityManager);
        }
    }

    public static Sample sampleMemory(ActivityManager activitymanager)
    {
        int i = activitymanager.getProcessMemoryInfo(PID)[0].getTotalPss();
        if (i >= 0)
        {
            activitymanager = new Sample(com.newrelic.agent.android.tracing.Sample.SampleType.MEMORY);
            activitymanager.setSampleValue((double)i / 1024D);
            return activitymanager;
        } else
        {
            return null;
        }
    }

    private void schedule()
    {
        if (isRunning.get())
        {
            return;
        } else
        {
            clear();
            isRunning.set(true);
            sampleFuture = scheduler.scheduleAtFixedRate(this, 0L, 100L, TimeUnit.MILLISECONDS);
            return;
        }
    }

    public static void shutdown()
    {
        samplerLock.lock();
        if (sampler == null)
        {
            samplerLock.unlock();
            return;
        } else
        {
            TraceMachine.removeTraceListener(sampler);
            stop();
            sampler = null;
            samplerLock.unlock();
            return;
        }
    }

    public static void start()
    {
        samplerLock.lock();
        if (sampler == null)
        {
            samplerLock.unlock();
            return;
        } else
        {
            sampler.schedule();
            samplerLock.unlock();
            log.debug("Sampler started");
            return;
        }
    }

    public static void stop()
    {
        samplerLock.lock();
        if (sampler == null)
        {
            samplerLock.unlock();
            return;
        } else
        {
            sampler.stop(false);
            samplerLock.unlock();
            return;
        }
    }

    private void stop(boolean flag)
    {
        samplerLock.lock();
        if (!isRunning.get())
        {
            samplerLock.unlock();
            return;
        } else
        {
            isRunning.set(false);
            sampleFuture.cancel(flag);
            resetCpuSampler();
            samplerLock.unlock();
            log.debug("Sampler stopped");
            return;
        }
    }

    public static void stopNow()
    {
        samplerLock.lock();
        if (sampler == null)
        {
            samplerLock.unlock();
            return;
        } else
        {
            sampler.stop(true);
            samplerLock.unlock();
            return;
        }
    }

    public void onEnterMethod()
    {
        if (isRunning.get())
        {
            return;
        } else
        {
            start();
            return;
        }
    }

    public void onExitMethod()
    {
    }

    public void onTraceComplete(ActivityTrace activitytrace)
    {
        stop();
        activitytrace.setVitals(copySamples());
        clear();
    }

    public void onTraceStart(ActivityTrace activitytrace)
    {
        start();
    }

    public void run()
    {
        try
        {
            if (isRunning.get())
            {
                sample();
            }
            return;
        }
        catch (Exception exception)
        {
            log.error("Caught exception while running the sampler", exception);
            AgentHealth.noticeException(exception);
            return;
        }
    }

    public Sample sampleCpu()
    {
        if (cpuSamplingDisabled)
        {
            return null;
        }
        if (procStatFile != null && appStatFile != null)
        {
            break MISSING_BLOCK_LABEL_263;
        }
        procStatFile = new RandomAccessFile("/proc/stat", "r");
        appStatFile = new RandomAccessFile((new StringBuilder()).append("/proc/").append(PID[0]).append("/stat").toString(), "r");
_L1:
        long l;
        long l1;
        String s1 = procStatFile.readLine();
        String s = appStatFile.readLine();
        String as1[] = s1.split(" ");
        String as[] = s.split(" ");
        l = Long.parseLong(as1[2]) + Long.parseLong(as1[3]) + Long.parseLong(as1[4]) + Long.parseLong(as1[5]) + Long.parseLong(as1[6]) + Long.parseLong(as1[7]) + Long.parseLong(as1[8]);
        l1 = Long.parseLong(as[13]);
        l1 = Long.parseLong(as[14]) + l1;
        if (lastCpuTime != null || lastAppCpuTime != null)
        {
            break MISSING_BLOCK_LABEL_282;
        }
        lastCpuTime = Long.valueOf(l);
        lastAppCpuTime = Long.valueOf(l1);
        Exception exception;
        return null;
        try
        {
            procStatFile.seek(0L);
            appStatFile.seek(0L);
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            cpuSamplingDisabled = true;
            log.debug((new StringBuilder()).append("Exception hit while CPU sampling: ").append(exception.getMessage()).toString());
            AgentHealth.noticeException(exception);
            return null;
        }
          goto _L1
        Sample sample1;
        sample1 = new Sample(com.newrelic.agent.android.tracing.Sample.SampleType.CPU);
        sample1.setSampleValue(((double)(l1 - lastAppCpuTime.longValue()) / (double)(l - lastCpuTime.longValue())) * 100D);
        lastCpuTime = Long.valueOf(l);
        lastAppCpuTime = Long.valueOf(l1);
        return sample1;
    }

}
