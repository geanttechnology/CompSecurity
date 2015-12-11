// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import android.content.Context;
import com.groupon.db.dao.DaoUniversal;
import com.groupon.db.events.UniversalUpdateEvent;
import com.groupon.manager.sync_process.AbstractPaginatedSyncManagerProcess;
import com.groupon.manager.sync_process.AbstractSyncManagerProcess;
import com.groupon.manager.sync_process.SyncManagerTaskRunner;
import com.groupon.util.ExecutorManager;
import com.groupon.util.IOUtils;
import com.groupon.util.PausableThreadPoolExecutor;
import com.squareup.otto.Bus;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package com.groupon.manager:
//            GrouponPaginatedSyncManager, UniversalInfo

public class UniversalSyncManager extends GrouponPaginatedSyncManager
{

    protected static final int FIXED_THREAD_POOL_SIZE = 5;
    protected static final ExecutorService THREAD_POOL_EXECUTOR = Executors.newFixedThreadPool(5);
    protected AbstractPaginatedSyncManagerProcess abstractPaginatedSyncManagerProcess;
    protected List abstractSyncManagerProcessList;
    protected DaoUniversal daoUniversal;
    protected Bus globalBus;
    protected UniversalUpdateEvent universalUpdateEvent;

    public UniversalSyncManager(Context context)
    {
        super(context);
        abstractSyncManagerProcessList = new ArrayList();
    }

    public UniversalSyncManager(Context context, PausableThreadPoolExecutor pausablethreadpoolexecutor)
    {
        super(context, pausablethreadpoolexecutor);
        abstractSyncManagerProcessList = new ArrayList();
    }

    public UniversalSyncManager(Context context, PausableThreadPoolExecutor pausablethreadpoolexecutor, ExecutorManager executormanager)
    {
        super(context, pausablethreadpoolexecutor, executormanager);
        abstractSyncManagerProcessList = new ArrayList();
    }

    private void closeInputStream(InputStream inputstream, List list)
    {
        if (inputstream != null && abstractPaginatedSyncManagerProcess != null)
        {
            IOUtils.close(inputstream);
        }
        for (inputstream = list.iterator(); inputstream.hasNext(); ((SyncManagerTaskRunner)inputstream.next()).closeInputStream()) { }
    }

    private void fireUpdateEvent()
    {
        if (universalUpdateEvent != null)
        {
            globalBus.post(universalUpdateEvent);
        }
    }

    public void configurePaginatedSyncManager(AbstractPaginatedSyncManagerProcess abstractpaginatedsyncmanagerprocess, List list, UniversalUpdateEvent universalupdateevent)
    {
        abstractPaginatedSyncManagerProcess = abstractpaginatedsyncmanagerprocess;
        abstractpaginatedsyncmanagerprocess = list;
        if (list == null)
        {
            abstractpaginatedsyncmanagerprocess = new ArrayList();
        }
        abstractSyncManagerProcessList = abstractpaginatedsyncmanagerprocess;
        universalUpdateEvent = universalupdateevent;
    }

    protected void doSync(final UniversalInfo info, final int offset, final int limit)
        throws Exception
    {
        Object obj;
        final Object inputStreamClone;
        Object obj1;
        Object obj6;
        final ArrayList runners;
        runners = new ArrayList();
        inputStreamClone = null;
        obj6 = null;
        obj1 = null;
        obj = obj1;
        Object obj3 = new CountDownLatch(0);
        if (offset != 0) goto _L2; else goto _L1
_L1:
        obj = obj1;
        Object obj2 = new CountDownLatch(abstractSyncManagerProcessList.size());
        obj = obj1;
        final Object objectClone = abstractSyncManagerProcessList.iterator();
_L3:
        obj = obj1;
        obj3 = obj2;
        if (!((Iterator) (objectClone)).hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = obj1;
        obj3 = new SyncManagerTaskRunner(((CountDownLatch) (obj2)), (AbstractSyncManagerProcess)((Iterator) (objectClone)).next(), info);
        obj = obj1;
        THREAD_POOL_EXECUTOR.execute(((Runnable) (obj3)));
        obj = obj1;
        runners.add(obj3);
        if (true) goto _L3; else goto _L2
        info;
        closeInputStream(((InputStream) (obj)), runners);
        fireUpdateEvent();
        throw info;
_L2:
        Object obj4;
        Object obj5;
        obj4 = null;
        obj5 = null;
        obj = obj1;
        AbstractPaginatedSyncManagerProcess abstractpaginatedsyncmanagerprocess = abstractPaginatedSyncManagerProcess;
        objectClone = obj4;
        obj2 = obj5;
        if (abstractpaginatedsyncmanagerprocess == null)
        {
            break MISSING_BLOCK_LABEL_238;
        }
        obj = obj1;
        obj1 = obj6;
        inputStreamClone = abstractPaginatedSyncManagerProcess.triggerSync(info, offset, limit);
        obj = inputStreamClone;
        obj1 = inputStreamClone;
        objectClone = abstractPaginatedSyncManagerProcess.triggerJsonParsing(((InputStream) (inputStreamClone)), info, offset, limit);
        obj2 = obj5;
_L8:
        obj = inputStreamClone;
        ((CountDownLatch) (obj3)).await();
        obj1 = obj2;
        if (obj2 != null) goto _L5; else goto _L4
_L4:
        obj = inputStreamClone;
        obj3 = runners.iterator();
_L6:
        obj = inputStreamClone;
        obj1 = obj2;
        if (!((Iterator) (obj3)).hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = inputStreamClone;
        obj1 = ((SyncManagerTaskRunner)((Iterator) (obj3)).next()).getException();
        if (obj1 == null) goto _L6; else goto _L5
_L5:
        if (obj1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = inputStreamClone;
        daoUniversal.callBatchTasks(new Callable() {

            final UniversalSyncManager this$0;
            final UniversalInfo val$info;
            final int val$limit;
            final int val$offset;

            public Object call()
                throws Exception
            {
                if (abstractPaginatedSyncManagerProcess != null)
                {
                    abstractPaginatedSyncManagerProcess.doDatabaseWorkOnNetworkError(info, offset, limit);
                }
                for (Iterator iterator = abstractSyncManagerProcessList.iterator(); iterator.hasNext(); ((AbstractSyncManagerProcess)iterator.next()).doDatabaseWorkOnNetworkError(info)) { }
                return null;
            }

            
            {
                this$0 = UniversalSyncManager.this;
                info = universalinfo;
                offset = i;
                limit = j;
                super();
            }
        });
        obj = inputStreamClone;
        throw obj1;
        Exception exception;
        exception;
        obj = obj1;
        objectClone = obj4;
        obj2 = obj5;
        inputStreamClone = obj1;
        if (abstractPaginatedSyncManagerProcess.isThrowingErrorOnException())
        {
            obj2 = exception;
            objectClone = obj4;
            inputStreamClone = obj1;
        }
        if (true) goto _L8; else goto _L7
_L7:
        obj = inputStreamClone;
        daoUniversal.callBatchTasks(new Callable() {

            final UniversalSyncManager this$0;
            final UniversalInfo val$info;
            final InputStream val$inputStreamClone;
            final int val$limit;
            final Object val$objectClone;
            final int val$offset;
            final List val$runners;

            public Object call()
                throws Exception
            {
                for (Iterator iterator = runners.iterator(); iterator.hasNext(); ((SyncManagerTaskRunner)iterator.next()).runBatchTask()) { }
                if (abstractPaginatedSyncManagerProcess != null)
                {
                    abstractPaginatedSyncManagerProcess.triggerDatabaseTask(inputStreamClone, objectClone, info, offset, limit);
                }
                return null;
            }

            
            {
                this$0 = UniversalSyncManager.this;
                runners = list;
                inputStreamClone = inputstream;
                objectClone = obj;
                info = universalinfo;
                offset = i;
                limit = j;
                super();
            }
        });
        closeInputStream(((InputStream) (inputStreamClone)), runners);
        fireUpdateEvent();
        return;
    }

    protected volatile void doSync(Object obj, int i, int j)
        throws Exception
    {
        doSync((UniversalInfo)obj, i, j);
    }

    protected int getNextOffset()
        throws Exception
    {
        if (abstractPaginatedSyncManagerProcess != null)
        {
            return abstractPaginatedSyncManagerProcess.getNextOffset();
        } else
        {
            return 0;
        }
    }

    protected long lastUpdated()
        throws Exception
    {
        Long long1;
        long l1;
        l1 = 0L;
        long1 = Long.valueOf(0x7fffffffffffffffL);
        if (abstractPaginatedSyncManagerProcess == null) goto _L2; else goto _L1
_L1:
        Long long2;
        long2 = Long.valueOf(abstractPaginatedSyncManagerProcess.lastUpdated());
        long1 = long2;
        if (long2.longValue() != 0L) goto _L2; else goto _L3
_L3:
        long l = long2.longValue();
_L5:
        return l;
_L2:
        Iterator iterator = abstractSyncManagerProcessList.iterator();
label0:
        do
        {
label1:
            {
                if (!iterator.hasNext())
                {
                    break label1;
                }
                long l2 = ((AbstractSyncManagerProcess)iterator.next()).lastUpdated();
                l = l1;
                if (l2 == 0L)
                {
                    break label0;
                }
                if (long1.longValue() > l2)
                {
                    long1 = Long.valueOf(l2);
                }
            }
        } while (true);
        if (true) goto _L5; else goto _L4
_L4:
        return long1.longValue();
    }

}
