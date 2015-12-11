// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.common.util:
//            EbayAsyncTask

public abstract class EbayObservableAsyncTask extends EbayAsyncTask
{
    public static abstract class BaseAsyncTaskObserver
        implements EbayAsyncTask.TaskHandler
    {

        private EbayObservableAsyncTask asyncTask;

        public final void clear()
        {
            if (asyncTask != null)
            {
                asyncTask.removeObserver(this);
                asyncTask = null;
            }
        }

        public final EbayObservableAsyncTask getTask()
        {
            return asyncTask;
        }

        public final void setTask(EbayObservableAsyncTask ebayobservableasynctask)
        {
            asyncTask = ebayobservableasynctask;
            ebayobservableasynctask.addObserver(this);
        }

        public BaseAsyncTaskObserver()
        {
            asyncTask = null;
        }
    }

    private static final class Observers extends HashSet
        implements EbayAsyncTask.TaskHandler
    {

        private static final long serialVersionUID = 1L;

        public void onError(int i, List list)
        {
            this;
            JVM INSTR monitorenter ;
            for (Iterator iterator = (new ArrayList(this)).iterator(); iterator.hasNext(); ((EbayAsyncTask.TaskHandler)iterator.next()).onError(i, list)) { }
            break MISSING_BLOCK_LABEL_47;
            list;
            this;
            JVM INSTR monitorexit ;
            throw list;
            clear();
            this;
            JVM INSTR monitorexit ;
        }

        public void onTaskComplete(Object obj)
        {
            this;
            JVM INSTR monitorenter ;
            for (Iterator iterator = (new ArrayList(this)).iterator(); iterator.hasNext(); ((EbayAsyncTask.TaskHandler)iterator.next()).onTaskComplete(obj)) { }
            break MISSING_BLOCK_LABEL_46;
            obj;
            this;
            JVM INSTR monitorexit ;
            throw obj;
            clear();
            this;
            JVM INSTR monitorexit ;
        }

        private Observers()
        {
        }

    }


    private final Observers observers = new Observers();

    protected EbayObservableAsyncTask()
    {
        setHandler(observers);
    }

    public final boolean addObserver(EbayAsyncTask.TaskHandler taskhandler)
    {
        boolean flag;
        synchronized (observers)
        {
            flag = observers.add(taskhandler);
        }
        return flag;
        taskhandler;
        observers1;
        JVM INSTR monitorexit ;
        throw taskhandler;
    }

    public final boolean removeObserver(EbayAsyncTask.TaskHandler taskhandler)
    {
        boolean flag;
        synchronized (observers)
        {
            flag = observers.remove(taskhandler);
        }
        return flag;
        taskhandler;
        observers1;
        JVM INSTR monitorexit ;
        throw taskhandler;
    }
}
