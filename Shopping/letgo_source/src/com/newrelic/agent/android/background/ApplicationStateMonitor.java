// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.background;

import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.util.NamedThreadFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.newrelic.agent.android.background:
//            ApplicationStateEvent, ApplicationStateListener

public class ApplicationStateMonitor
    implements Runnable
{

    private static ApplicationStateMonitor instance;
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private final int activitySnoozeTimeInMilliseconds;
    protected final ArrayList applicationStateListeners;
    private AtomicLong count;
    protected final ScheduledThreadPoolExecutor executor;
    private final Lock foregroundLock;
    protected AtomicBoolean foregrounded;
    private final Lock snoozeLock;
    private AtomicLong snoozeStartTime;

    private ApplicationStateMonitor()
    {
        this(5, 5, TimeUnit.SECONDS, 5000);
    }

    ApplicationStateMonitor(int i, int j, TimeUnit timeunit, int k)
    {
        count = new AtomicLong(0L);
        snoozeStartTime = new AtomicLong(0L);
        snoozeLock = new ReentrantLock();
        applicationStateListeners = new ArrayList();
        foregrounded = new AtomicBoolean(true);
        foregroundLock = new ReentrantLock();
        executor = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("AppStateMon"));
        activitySnoozeTimeInMilliseconds = k;
        executor.scheduleAtFixedRate(this, i, j, timeunit);
        log.info("Application state monitor has started");
    }

    public static ApplicationStateMonitor getInstance()
    {
        if (instance == null)
        {
            instance = new ApplicationStateMonitor();
        }
        return instance;
    }

    private long getSnoozeTime()
    {
        long l = 0L;
        foregroundLock.lock();
        long l1;
        snoozeLock.lock();
        l1 = snoozeStartTime.get();
        if (l1 == 0L)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        l = System.currentTimeMillis();
        l -= l1;
        snoozeLock.unlock();
        foregroundLock.unlock();
        return l;
        Exception exception;
        exception;
        snoozeLock.unlock();
        throw exception;
        exception;
        foregroundLock.unlock();
        throw exception;
    }

    private void notifyApplicationInBackground()
    {
        log.verbose("Application appears to have gone to the background");
        Object obj1;
        synchronized (applicationStateListeners)
        {
            obj1 = new ArrayList(applicationStateListeners);
        }
        obj = new ApplicationStateEvent(this);
        for (obj1 = ((ArrayList) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); ((ApplicationStateListener)((Iterator) (obj1)).next()).applicationBackgrounded(((ApplicationStateEvent) (obj)))) { }
        break MISSING_BLOCK_LABEL_77;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void notifyApplicationInForeground()
    {
        Object obj1;
        synchronized (applicationStateListeners)
        {
            obj1 = new ArrayList(applicationStateListeners);
        }
        obj = new ApplicationStateEvent(this);
        for (obj1 = ((ArrayList) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); ((ApplicationStateListener)((Iterator) (obj1)).next()).applicationForegrounded(((ApplicationStateEvent) (obj)))) { }
        break MISSING_BLOCK_LABEL_67;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void activityStarted()
    {
        Runnable runnable = new Runnable() {

            final ApplicationStateMonitor this$0;

            public void run()
            {
                foregroundLock.lock();
                snoozeLock.lock();
                if (count.incrementAndGet() == 1L)
                {
                    snoozeStartTime.set(0L);
                }
                snoozeLock.unlock();
                if (!foregrounded.get())
                {
                    ApplicationStateMonitor.log.verbose("Application appears to be in the foreground");
                    notifyApplicationInForeground();
                    foregrounded.set(true);
                }
                foregroundLock.unlock();
                return;
                Exception exception;
                exception;
                snoozeLock.unlock();
                throw exception;
                exception;
                foregroundLock.unlock();
                throw exception;
            }

            
            {
                this$0 = ApplicationStateMonitor.this;
                super();
            }
        };
        executor.execute(runnable);
    }

    public void activityStopped()
    {
        Runnable runnable = new Runnable() {

            final ApplicationStateMonitor this$0;

            public void run()
            {
                foregroundLock.lock();
                snoozeLock.lock();
                if (count.decrementAndGet() == 0L)
                {
                    snoozeStartTime.set(System.currentTimeMillis());
                }
                snoozeLock.unlock();
                foregroundLock.unlock();
                return;
                Exception exception;
                exception;
                snoozeLock.unlock();
                throw exception;
                exception;
                foregroundLock.unlock();
                throw exception;
            }

            
            {
                this$0 = ApplicationStateMonitor.this;
                super();
            }
        };
        executor.execute(runnable);
    }

    public void addApplicationStateListener(ApplicationStateListener applicationstatelistener)
    {
        synchronized (applicationStateListeners)
        {
            applicationStateListeners.add(applicationstatelistener);
        }
        return;
        applicationstatelistener;
        arraylist;
        JVM INSTR monitorexit ;
        throw applicationstatelistener;
    }

    public ScheduledThreadPoolExecutor getExecutor()
    {
        return executor;
    }

    public void removeApplicationStateListener(ApplicationStateListener applicationstatelistener)
    {
        synchronized (applicationStateListeners)
        {
            applicationStateListeners.remove(applicationstatelistener);
        }
        return;
        applicationstatelistener;
        arraylist;
        JVM INSTR monitorexit ;
        throw applicationstatelistener;
    }

    public void run()
    {
        foregroundLock.lock();
        if (foregrounded.get() && getSnoozeTime() >= (long)activitySnoozeTimeInMilliseconds)
        {
            notifyApplicationInBackground();
            foregrounded.set(false);
        }
        foregroundLock.unlock();
        return;
        Exception exception;
        exception;
        foregroundLock.unlock();
        throw exception;
    }

    public void uiHidden()
    {
        Runnable runnable = new Runnable() {

            final ApplicationStateMonitor this$0;

            public void run()
            {
                foregroundLock.lock();
                if (foregrounded.get())
                {
                    ApplicationStateMonitor.log.info("UI has become hidden (app backgrounded)");
                    notifyApplicationInBackground();
                    foregrounded.set(false);
                }
                foregroundLock.unlock();
                return;
                Exception exception;
                exception;
                foregroundLock.unlock();
                throw exception;
            }

            
            {
                this$0 = ApplicationStateMonitor.this;
                super();
            }
        };
        executor.execute(runnable);
    }








}
