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
import com.newrelic.agent.android.metric.Metric;
import com.newrelic.agent.android.stats.TicToc;
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
    protected static final long SAMPLE_FREQ_MS_MAX = 250L;
    protected static boolean cpuSamplingDisabled = false;
    private static final AgentLog log = AgentLogManager.getAgentLog();
    protected static Sampler sampler;
    private static final ReentrantLock samplerLock = new ReentrantLock();
    private final ActivityManager activityManager;
    private RandomAccessFile appStatFile;
    protected final AtomicBoolean isRunning = new AtomicBoolean(false);
    private Long lastAppCpuTime;
    private Long lastCpuTime;
    private RandomAccessFile procStatFile;
    protected long sampleFreqMs;
    protected ScheduledFuture sampleFuture;
    private Metric samplerServiceMetric;
    private final EnumMap samples = new EnumMap(com/newrelic/agent/android/tracing/Sample$SampleType);
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor(new NamedThreadFactory("Sampler"));

    protected Sampler(Context context)
    {
        sampleFreqMs = 100L;
        activityManager = (ActivityManager)context.getSystemService("activity");
        samples.put(com.newrelic.agent.android.tracing.Sample.SampleType.MEMORY, new ArrayList());
        samples.put(com.newrelic.agent.android.tracing.Sample.SampleType.CPU, new ArrayList());
    }

    public static Map copySamples()
    {
        samplerLock.lock();
        Object obj;
        if (sampler != null)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        samplerLock.unlock();
        obj = new HashMap();
        samplerLock.unlock();
        return ((Map) (obj));
        obj = new EnumMap(sampler.samples);
        com.newrelic.agent.android.tracing.Sample.SampleType sampletype;
        for (Iterator iterator = sampler.samples.keySet().iterator(); iterator.hasNext(); ((EnumMap) (obj)).put(sampletype, new ArrayList((Collection)sampler.samples.get(sampletype))))
        {
            sampletype = (com.newrelic.agent.android.tracing.Sample.SampleType)iterator.next();
        }

        break MISSING_BLOCK_LABEL_120;
        obj;
        samplerLock.unlock();
        throw obj;
        samplerLock.unlock();
        return Collections.unmodifiableMap(((Map) (obj)));
    }

    private Collection getSampleCollection(com.newrelic.agent.android.tracing.Sample.SampleType sampletype)
    {
        return (Collection)samples.get(sampletype);
    }

    public static void init(Context context)
    {
        samplerLock.lock();
        if (sampler == null)
        {
            sampler = new Sampler(context);
            sampler.sampleFreqMs = 100L;
            sampler.samplerServiceMetric = new Metric("samplerServiceTime");
            TraceMachine.addTraceListener(sampler);
            log.debug("Sampler initialized");
        }
        samplerLock.unlock();
        return;
        context;
        log.error((new StringBuilder()).append("Sampler init failed: ").append(context.getMessage()).toString());
        shutdown();
        samplerLock.unlock();
        return;
        context;
        samplerLock.unlock();
        throw context;
    }

    protected static boolean isRunning()
    {
        while (sampler == null || sampler.sampleFuture == null || sampler.sampleFuture.isDone()) 
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

    protected static Sample sampleCpuInstance()
    {
        if (sampler == null)
        {
            return null;
        } else
        {
            return sampler.sampleCpu();
        }
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
        int i;
        activitymanager = activitymanager.getProcessMemoryInfo(PID);
        if (activitymanager.length <= 0)
        {
            break MISSING_BLOCK_LABEL_83;
        }
        i = activitymanager[0].getTotalPss();
        if (i < 0)
        {
            break MISSING_BLOCK_LABEL_83;
        }
        activitymanager = new Sample(com.newrelic.agent.android.tracing.Sample.SampleType.MEMORY);
        activitymanager.setSampleValue((double)i / 1024D);
        return activitymanager;
        activitymanager;
        log.error((new StringBuilder()).append("Sample memory failed: ").append(activitymanager.getMessage()).toString());
        AgentHealth.noticeException(activitymanager);
        return null;
    }

    public static void shutdown()
    {
        samplerLock.lock();
        if (sampler != null)
        {
            TraceMachine.removeTraceListener(sampler);
            stop();
            sampler = null;
            log.debug("Sampler shutdown");
        }
        samplerLock.unlock();
        return;
        Exception exception;
        exception;
        samplerLock.unlock();
        throw exception;
    }

    public static void start()
    {
        samplerLock.lock();
        if (sampler != null)
        {
            sampler.schedule();
            log.debug("Sampler started");
        }
        samplerLock.unlock();
        return;
        Exception exception;
        exception;
        samplerLock.unlock();
        throw exception;
    }

    public static void stop()
    {
        samplerLock.lock();
        if (sampler != null)
        {
            sampler.stop(false);
            log.debug("Sampler stopped");
        }
        samplerLock.unlock();
        return;
        Exception exception;
        exception;
        samplerLock.unlock();
        throw exception;
    }

    public static void stopNow()
    {
        samplerLock.lock();
        if (sampler != null)
        {
            sampler.stop(true);
            log.debug("Sampler hard stopped");
        }
        samplerLock.unlock();
        return;
        Exception exception;
        exception;
        samplerLock.unlock();
        throw exception;
    }

    protected void clear()
    {
        for (Iterator iterator = samples.values().iterator(); iterator.hasNext(); ((Collection)iterator.next()).clear()) { }
    }

    protected void monitorSamplerServiceTime(double d)
    {
        samplerServiceMetric.sample(d);
        if (Double.valueOf(samplerServiceMetric.getTotal() / (double)samplerServiceMetric.getCount()).doubleValue() > (double)sampleFreqMs)
        {
            log.debug("Sampler: sample service time has been exceeded. Increase by 10%");
            sampleFreqMs = Math.min((long)((float)sampleFreqMs * 1.1F), 250L);
            if (sampleFuture != null)
            {
                sampleFuture.cancel(true);
            }
            sampleFuture = scheduler.scheduleWithFixedDelay(this, 0L, sampleFreqMs, TimeUnit.MILLISECONDS);
            log.debug(String.format("Sampler scheduler restarted; sampling will now occur every %d ms.", new Object[] {
                Long.valueOf(sampleFreqMs)
            }));
            samplerServiceMetric.clear();
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

    protected void sample()
    {
        TicToc tictoc;
        tictoc = new TicToc();
        samplerLock.lock();
        Sample sample1;
        tictoc.tic();
        sample1 = sampleMemory();
        if (sample1 == null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        getSampleCollection(com.newrelic.agent.android.tracing.Sample.SampleType.MEMORY).add(sample1);
        sample1 = sampleCpu();
        if (sample1 == null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        getSampleCollection(com.newrelic.agent.android.tracing.Sample.SampleType.CPU).add(sample1);
        samplerLock.unlock();
_L2:
        monitorSamplerServiceTime(tictoc.toc());
        return;
        Exception exception1;
        exception1;
        log.error((new StringBuilder()).append("Sampling failed: ").append(exception1.getMessage()).toString());
        AgentHealth.noticeException(exception1);
        samplerLock.unlock();
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        samplerLock.unlock();
        throw exception;
    }

    public Sample sampleCpu()
    {
        if (cpuSamplingDisabled)
        {
            return null;
        }
        if (procStatFile != null && appStatFile != null)
        {
            break MISSING_BLOCK_LABEL_217;
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
        l1 = Long.parseLong(as[13]) + Long.parseLong(as[14]);
        if (lastCpuTime != null || lastAppCpuTime != null)
        {
            break MISSING_BLOCK_LABEL_278;
        }
        lastCpuTime = Long.valueOf(l);
        lastAppCpuTime = Long.valueOf(l1);
        return null;
        try
        {
            procStatFile.seek(0L);
            appStatFile.seek(0L);
        }
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

    protected void schedule()
    {
        samplerLock.lock();
        if (!isRunning.get())
        {
            clear();
            sampleFuture = scheduler.scheduleWithFixedDelay(this, 0L, sampleFreqMs, TimeUnit.MILLISECONDS);
            isRunning.set(true);
            log.debug(String.format("Sampler scheduler started; sampling will occur every %d ms.", new Object[] {
                Long.valueOf(sampleFreqMs)
            }));
        }
        samplerLock.unlock();
        return;
        Object obj;
        obj;
        log.error((new StringBuilder()).append("Sampler scheduling failed: ").append(((Exception) (obj)).getMessage()).toString());
        AgentHealth.noticeException(((Exception) (obj)));
        samplerLock.unlock();
        return;
        obj;
        samplerLock.unlock();
        throw obj;
    }

    protected void stop(boolean flag)
    {
        samplerLock.lock();
        if (isRunning.get())
        {
            isRunning.set(false);
            if (sampleFuture != null)
            {
                sampleFuture.cancel(flag);
            }
            resetCpuSampler();
            log.debug("Sampler canceled");
        }
        samplerLock.unlock();
        return;
        Object obj;
        obj;
        log.error((new StringBuilder()).append("Sampler stop failed: ").append(((Exception) (obj)).getMessage()).toString());
        AgentHealth.noticeException(((Exception) (obj)));
        samplerLock.unlock();
        return;
        obj;
        samplerLock.unlock();
        throw obj;
    }

}
