// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.shell.app;

import android.content.Context;
import com.ebay.nautilus.kernel.util.FwLog;
import com.ebay.nautilus.shell.content.FwLoader;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.ebay.nautilus.shell.app:
//            ActivityShimManager

public final class FwLoaderManager
{
    public static interface Callback
    {

        public abstract Context getContext();

        public abstract void onCanceled(int i, FwLoader fwloader);

        public abstract void onTaskComplete(int i, FwLoader fwloader);

        public abstract void onTaskStarted(int i, FwLoader fwloader);
    }

    private final class Task
        implements com.ebay.nautilus.shell.content.FwLoader.Callback
    {

        public final int id;
        public final boolean isCancelable;
        public final FwLoader loader;
        final FwLoaderManager this$0;

        public final boolean cancel(boolean flag)
        {
            return loader.cancel(flag);
        }

        public void onCanceled(FwLoader fwloader)
        {
            removeLoader(this);
            Callback callback = handler;
            if (callback != null)
            {
                if (FwLoaderManager.logCommonCallbacks.isLoggable)
                {
                    logMethod(FwLoaderManager.logCommonCallbacks, callback.getContext().getClass().getName(), "onCanceled", null, new Object[] {
                        Integer.valueOf(id), fwloader
                    });
                }
                callback.onCanceled(id, fwloader);
            }
        }

        public void onTaskComplete(FwLoader fwloader)
        {
            removeLoader(this);
            Callback callback = handler;
            if (callback != null)
            {
                if (FwLoaderManager.logCommonCallbacks.isLoggable)
                {
                    logMethod(FwLoaderManager.logCommonCallbacks, callback.getContext().getClass().getName(), "onTaskComplete", null, new Object[] {
                        Integer.valueOf(id), fwloader
                    });
                }
                callback.onTaskComplete(id, fwloader);
            }
        }

        public Task(int i, FwLoader fwloader, boolean flag)
        {
            this$0 = FwLoaderManager.this;
            super();
            id = i;
            loader = fwloader;
            isCancelable = flag;
        }
    }


    public static final int PRIORITY_BACKGROUND = 1;
    public static final int PRIORITY_UI = 0;
    private static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logCommonCallbacks;
    private int defaultPriority;
    volatile Callback handler;
    private final ArrayList loaders = new ArrayList();

    public FwLoaderManager(Callback callback)
    {
        defaultPriority = 1;
        handler = callback;
    }

    private transient void logMethod(com.ebay.nautilus.kernel.util.FwLog.LogInfo loginfo, String s, String s1, String s2, Object aobj[])
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(s).append('.');
        stringbuilder.append(s1).append('(');
        if (aobj != null && aobj.length != 0)
        {
            boolean flag = true;
            int j = aobj.length;
            int i = 0;
            while (i < j) 
            {
                s = ((String) (aobj[i]));
                if (flag)
                {
                    flag = false;
                } else
                {
                    stringbuilder.append(", ");
                }
                if (s != null && (s instanceof CharSequence))
                {
                    stringbuilder.append('"').append((CharSequence)s).append('"');
                } else
                {
                    stringbuilder.append(s);
                }
                i++;
            }
        }
        stringbuilder.append(')');
        if (s2 != null)
        {
            stringbuilder.append(" - ").append(s2);
        }
        FwLog.println(loginfo, stringbuilder.toString());
    }

    private Task removeLoader(int i)
    {
        int k = loaders.size();
        for (int j = 0; j < k; j++)
        {
            if (((Task)loaders.get(j)).id == i)
            {
                return (Task)loaders.remove(j);
            }
        }

        return null;
    }

    public final void cancelAll(boolean flag)
    {
        int k = loaders.size();
        k;
        JVM INSTR tableswitch 0 1: default 32
    //                   0 106
    //                   1 73;
           goto _L1 _L2 _L3
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        Task atask[] = new Task[k];
        for (int i = 0; i < k; i++)
        {
            atask[i] = (Task)loaders.get(i);
        }

        k = atask.length;
        int j = 0;
        while (j < k) 
        {
            Task task = atask[j];
            if (task.isCancelable)
            {
                task.cancel(flag);
            }
            j++;
        }
          goto _L4
_L3:
        if (((Task)loaders.get(0)).isCancelable)
        {
            ((Task)loaders.get(0)).cancel(flag);
        }
_L6:
        return;
_L4:
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final void cancelLoader(int i, boolean flag)
    {
        int k = loaders.size();
        for (int j = 0; j < k; j++)
        {
            Task task = (Task)loaders.get(j);
            if (task.id == i)
            {
                task.cancel(flag);
            }
        }

    }

    public final FwLoader getRunningLoader(int i)
    {
        int k = loaders.size();
        for (int j = 0; j < k; j++)
        {
            Task task = (Task)loaders.get(j);
            if (task.id == i)
            {
                return task.loader;
            }
        }

        return null;
    }

    public final boolean hasRunningLoaders()
    {
        return !loaders.isEmpty();
    }

    final void removeLoader(Task task)
    {
        int j = loaders.size();
        int i = 0;
        do
        {
label0:
            {
                if (i < j)
                {
                    if ((Task)loaders.get(i) != task)
                    {
                        break label0;
                    }
                    loaders.remove(i);
                }
                return;
            }
            i++;
        } while (true);
    }

    public void setDefaultPriority(int i)
    {
        defaultPriority = i;
    }

    public final void setHandler(Callback callback)
    {
        handler = callback;
        if (callback != null && !loaders.isEmpty())
        {
            Task task;
            for (Iterator iterator = (new ArrayList(loaders)).iterator(); iterator.hasNext(); callback.onTaskStarted(task.id, task.loader))
            {
                task = (Task)iterator.next();
            }

        }
    }

    public final void start(int i, FwLoader fwloader, boolean flag)
    {
        start(i, fwloader, flag, defaultPriority);
    }

    public final void start(int i, FwLoader fwloader, boolean flag, int j)
    {
        Callback callback = handler;
        if (logCommonCallbacks.isLoggable)
        {
            com.ebay.nautilus.kernel.util.FwLog.LogInfo loginfo = logCommonCallbacks;
            String s1 = getClass().getName();
            String s;
            if (callback != null)
            {
                s = callback.getContext().getClass().getName();
            } else
            {
                s = null;
            }
            logMethod(loginfo, s1, "start", s, new Object[] {
                Integer.valueOf(i), fwloader, Boolean.valueOf(flag)
            });
        }
        if (fwloader == null)
        {
            throw new NullPointerException("loader");
        }
        Object obj = fwloader.getClass();
        if ((((Class) (obj)).isAnonymousClass() || ((Class) (obj)).isMemberClass() || ((Class) (obj)).isLocalClass()) && (((Class) (obj)).getModifiers() & 8) == 0)
        {
            throw new RuntimeException((new StringBuilder()).append("The following Loader class should be static or leaks might occur: ").append(((Class) (obj)).getCanonicalName()).toString());
        }
        obj = removeLoader(i);
        if (obj != null && ((Task) (obj)).isCancelable)
        {
            ((Task) (obj)).cancel(true);
        }
        obj = new Task(i, fwloader, flag);
        loaders.add(obj);
        fwloader.execute(((com.ebay.nautilus.shell.content.FwLoader.Callback) (obj)), j);
        if (callback != null)
        {
            callback.onTaskStarted(i, fwloader);
        }
    }

    static 
    {
        logCommonCallbacks = ActivityShimManager.logCommonCallbacks;
    }


}
