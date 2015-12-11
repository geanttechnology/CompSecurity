// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.app.Activity;
import com.groupon.events.activity.OnDestroyEvent;
import com.groupon.events.activity.OnResumeEvent;
import com.squareup.otto.Bus;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;

// Referenced classes of package com.groupon.util:
//            PausableThreadPoolExecutor, MasterExecutorManager

public class ExecutorManager
{

    protected Activity activity;
    private Bus bus;
    private LinkedHashSet childExecutorManagers;
    private LinkedHashSet executors;
    private ExecutorManager parentExecutorManager;

    public ExecutorManager(Activity activity1)
    {
        this(activity1, null);
    }

    public ExecutorManager(Activity activity1, ExecutorManager executormanager)
    {
        executors = new LinkedHashSet();
        childExecutorManagers = new LinkedHashSet();
        activity = activity1;
        if (executormanager != null)
        {
            executormanager.addExecutorManager(this);
            parentExecutorManager = executormanager;
        }
    }

    public ExecutorManager(Activity activity1, MasterExecutorManager masterexecutormanager, Bus bus1)
    {
        this(activity1, ((ExecutorManager) (masterexecutormanager)));
        bus = bus1;
        bus1.register(this);
    }

    public void activityOnDestroy(OnDestroyEvent ondestroyevent)
    {
        if (!activity.equals(ondestroyevent.getContext())) goto _L2; else goto _L1
_L1:
        if (parentExecutorManager != null)
        {
            parentExecutorManager.removeExecutorManager(this);
        }
        this;
        JVM INSTR monitorenter ;
        PausableThreadPoolExecutor pausablethreadpoolexecutor;
        for (ondestroyevent = executors.iterator(); ondestroyevent.hasNext(); pausablethreadpoolexecutor.shutdown())
        {
            pausablethreadpoolexecutor = (PausableThreadPoolExecutor)ondestroyevent.next();
            pausablethreadpoolexecutor.purge();
        }

        break MISSING_BLOCK_LABEL_74;
        ondestroyevent;
        this;
        JVM INSTR monitorexit ;
        throw ondestroyevent;
        this;
        JVM INSTR monitorexit ;
_L2:
        bus.unregister(this);
        return;
    }

    public void activityOnResume(OnResumeEvent onresumeevent)
    {
        if (activity.equals(onresumeevent.getActivity()) && parentExecutorManager != null)
        {
            parentExecutorManager.removeExecutorManager(this);
            parentExecutorManager.addExecutorManager(this);
        }
    }

    public void addExecutor(PausableThreadPoolExecutor pausablethreadpoolexecutor)
    {
        this;
        JVM INSTR monitorenter ;
        executors.add(pausablethreadpoolexecutor);
        this;
        JVM INSTR monitorexit ;
        return;
        pausablethreadpoolexecutor;
        throw pausablethreadpoolexecutor;
    }

    public void addExecutorManager(ExecutorManager executormanager)
    {
        this;
        JVM INSTR monitorenter ;
        childExecutorManagers.add(executormanager);
        this;
        JVM INSTR monitorexit ;
        return;
        executormanager;
        throw executormanager;
    }

    protected boolean hasTaskRunning()
    {
        this;
        JVM INSTR monitorenter ;
        Iterator iterator;
        Iterator iterator1;
        iterator = (new LinkedList(childExecutorManagers)).descendingIterator();
        iterator1 = (new LinkedList(executors)).descendingIterator();
        this;
        JVM INSTR monitorexit ;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_65;
            }
        } while (!((ExecutorManager)iterator.next()).hasTaskRunning());
        return true;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        while (iterator1.hasNext()) 
        {
            if (!((PausableThreadPoolExecutor)iterator1.next()).isPaused())
            {
                return true;
            }
        }
        return false;
    }

    public void removeExecutor(PausableThreadPoolExecutor pausablethreadpoolexecutor)
    {
        this;
        JVM INSTR monitorenter ;
        executors.remove(pausablethreadpoolexecutor);
        this;
        JVM INSTR monitorexit ;
        return;
        pausablethreadpoolexecutor;
        throw pausablethreadpoolexecutor;
    }

    public void removeExecutorManager(ExecutorManager executormanager)
    {
        this;
        JVM INSTR monitorenter ;
        childExecutorManagers.remove(executormanager);
        this;
        JVM INSTR monitorexit ;
        return;
        executormanager;
        throw executormanager;
    }

    protected boolean turnOnNextExecutor()
    {
        boolean flag = false;
        this;
        JVM INSTR monitorenter ;
        Object obj;
        Iterator iterator;
        iterator = (new LinkedList(childExecutorManagers)).descendingIterator();
        obj = (new LinkedList(executors)).descendingIterator();
        this;
        JVM INSTR monitorexit ;
          goto _L1
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
_L1:
        boolean flag1;
        do
        {
            flag1 = flag;
            if (!iterator.hasNext())
            {
                break;
            }
            if (((ExecutorManager)iterator.next()).turnOnNextExecutor())
            {
                flag = true;
            }
        } while (true);
        while (((Iterator) (obj)).hasNext()) 
        {
            PausableThreadPoolExecutor pausablethreadpoolexecutor = (PausableThreadPoolExecutor)((Iterator) (obj)).next();
            if (!flag1 && !pausablethreadpoolexecutor.isEmpty())
            {
                pausablethreadpoolexecutor.resume();
                flag1 = true;
            } else
            {
                pausablethreadpoolexecutor.pause();
            }
        }
        return flag1;
    }
}
