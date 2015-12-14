// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.interactors;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.thread.NamedThreadFactory;
import com.amazon.gallery.framework.data.dao.ThisDayDBInfoProvider;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.dao.sqlite.SQLiteDaoUtil;
import com.amazon.gallery.framework.model.ThisDayYearInfo;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.SyncState;
import com.amazon.gallery.thor.settings.HidePreferenceManager;
import com.amazon.gallery.thor.thisday.ThisDayViewCollection;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThisDayInteractor
{
    private class MediaItemsObserver extends ContentObserver
    {

        final ThisDayInteractor this$0;

        public void onChange(boolean flag)
        {
            onChange(flag, null);
        }

        public void onChange(boolean flag, Uri uri)
        {
            if (observers.isEmpty())
            {
                dayContentChanged = true;
                weekContentChanged = true;
                shuffleContentChanged = true;
                return;
            } else
            {
                startAsyncDbTask(TaskType.RELOAD_THIS_DAY);
                startAsyncDbTask(TaskType.RELOAD_THIS_WEEK);
                startAsyncDbTask(TaskType.REFRESH_SHUFFLE);
                return;
            }
        }

        public MediaItemsObserver(Handler handler)
        {
            this$0 = ThisDayInteractor.this;
            super(handler);
        }
    }

    private static final class TaskType extends Enum
    {

        private static final TaskType $VALUES[];
        public static final TaskType REFRESH_SHUFFLE;
        public static final TaskType RELOAD_SHUFFLE;
        public static final TaskType RELOAD_THIS_DAY;
        public static final TaskType RELOAD_THIS_WEEK;

        public static TaskType valueOf(String s)
        {
            return (TaskType)Enum.valueOf(com/amazon/gallery/thor/interactors/ThisDayInteractor$TaskType, s);
        }

        public static TaskType[] values()
        {
            return (TaskType[])$VALUES.clone();
        }

        static 
        {
            RELOAD_THIS_DAY = new TaskType("RELOAD_THIS_DAY", 0);
            RELOAD_THIS_WEEK = new TaskType("RELOAD_THIS_WEEK", 1);
            RELOAD_SHUFFLE = new TaskType("RELOAD_SHUFFLE", 2);
            REFRESH_SHUFFLE = new TaskType("REFRESH_SHUFFLE", 3);
            $VALUES = (new TaskType[] {
                RELOAD_THIS_DAY, RELOAD_THIS_WEEK, RELOAD_SHUFFLE, REFRESH_SHUFFLE
            });
        }

        private TaskType(String s, int i)
        {
            super(s, i);
        }
    }

    private static class ThisDayDataLoaderTask
        implements Runnable
    {

        private int collectionType;
        private final WeakReference interactorRef;
        private final TaskType taskType;

        TaskType getTaskType()
        {
            return taskType;
        }

        public void run()
        {
            ThisDayInteractor thisdayinteractor;
label0:
            {
                thisdayinteractor = (ThisDayInteractor)interactorRef.get();
                if (thisdayinteractor != null)
                {
                    if (taskType != TaskType.REFRESH_SHUFFLE)
                    {
                        break label0;
                    }
                    thisdayinteractor.refreshShuffleData();
                }
                return;
            }
            thisdayinteractor.reloadData(collectionType);
        }

        ThisDayDataLoaderTask(ThisDayInteractor thisdayinteractor, TaskType tasktype)
        {
            interactorRef = new WeakReference(thisdayinteractor);
            taskType = tasktype;
            switch (_cls1..SwitchMap.com.amazon.gallery.thor.interactors.ThisDayInteractor.TaskType[tasktype.ordinal()])
            {
            default:
                return;

            case 1: // '\001'
                collectionType = 0;
                return;

            case 2: // '\002'
                collectionType = 1;
                return;

            case 3: // '\003'
            case 4: // '\004'
                collectionType = 2;
                break;
            }
        }
    }

    public static interface ThisDayDataObserver
    {

        public abstract void onDataRefreshed(ThisDayViewCollection thisdayviewcollection);
    }

    private static class ThisDayDbTaskExecutor
    {

        private byte activeTasksMask;
        private final ThreadPoolExecutor delegateExecutor;
        private Map pendingTasksQueueMap;

        private boolean isTaskTypeActive(TaskType tasktype)
        {
            return (activeTasksMask >> tasktype.ordinal() & 1) != 0;
        }

        private void scheduleNextTaskFromQueue(TaskType tasktype)
        {
            this;
            JVM INSTR monitorenter ;
            Runnable runnable = (Runnable)((Queue)pendingTasksQueueMap.get(tasktype)).poll();
            if (runnable == null)
            {
                break MISSING_BLOCK_LABEL_60;
            }
            delegateExecutor.execute(runnable);
_L1:
            this;
            JVM INSTR monitorexit ;
            return;
            tasktype;
            GLogger.d(ThisDayInteractor.TAG, "Task not run since ThisDayActivity has been destroyed", new Object[0]);
              goto _L1
            tasktype;
            throw tasktype;
            setTaskTypeStatus(tasktype, false);
              goto _L1
        }

        private boolean setTaskTypeActive(TaskType tasktype)
        {
            boolean flag = true;
            this;
            JVM INSTR monitorenter ;
            if (isTaskTypeActive(tasktype))
            {
                flag = false;
            }
            if (!flag)
            {
                break MISSING_BLOCK_LABEL_22;
            }
            setTaskTypeStatus(tasktype, true);
            this;
            JVM INSTR monitorexit ;
            return flag;
            tasktype;
            throw tasktype;
        }

        private void setTaskTypeStatus(TaskType tasktype, boolean flag)
        {
            if (flag)
            {
                activeTasksMask = (byte)(activeTasksMask | 1 << tasktype.ordinal());
                return;
            } else
            {
                activeTasksMask = (byte)(activeTasksMask & ~(1 << tasktype.ordinal()));
                return;
            }
        }

        public void execute(ThisDayDataLoaderTask thisdaydataloadertask)
        {
            TaskType tasktype = thisdaydataloadertask.getTaskType();
            if (setTaskTypeActive(tasktype))
            {
                try
                {
                    delegateExecutor.execute(thisdaydataloadertask);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (ThisDayDataLoaderTask thisdaydataloadertask)
                {
                    GLogger.d(ThisDayInteractor.TAG, "Task not run since ThisDayActivity has been destroyed", new Object[0]);
                }
                return;
            } else
            {
                ((Queue)pendingTasksQueueMap.get(tasktype)).add(thisdaydataloadertask);
                return;
            }
        }

        public void shutdown()
        {
            delegateExecutor.shutdownNow();
        }


        ThisDayDbTaskExecutor()
        {
            activeTasksMask = 0;
            delegateExecutor = new _cls1(3, 4, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new NamedThreadFactory(com/amazon/gallery/thor/interactors/ThisDayInteractor$ThisDayDbTaskExecutor.getSimpleName()));
            pendingTasksQueueMap = new HashMap();
            pendingTasksQueueMap.put(TaskType.RELOAD_THIS_DAY, new ArrayDeque());
            pendingTasksQueueMap.put(TaskType.RELOAD_THIS_WEEK, new ArrayDeque());
            pendingTasksQueueMap.put(TaskType.RELOAD_SHUFFLE, new ArrayDeque());
            pendingTasksQueueMap.put(TaskType.REFRESH_SHUFFLE, new ArrayDeque());
        }
    }


    private static final Uri MEDIA_ITEM_URI;
    private static final String TAG = com/amazon/gallery/thor/interactors/ThisDayInteractor.getName();
    private final ContentResolver contentResolver;
    private final ThisDayDBInfoProvider dataProvider;
    private volatile boolean dayContentChanged;
    private ThisDayDbTaskExecutor dbTaskExecutor;
    private ThisDayDataLoaderTask dbTasks[];
    private final HidePreferenceManager hidePreferenceManager;
    private final MediaItemDao mediaItemDao;
    private final MediaItemsObserver mediaItemsObserver = new MediaItemsObserver(new Handler());
    private final CopyOnWriteArraySet observers = new CopyOnWriteArraySet();
    private volatile boolean shuffleContentChanged;
    private ThisDayViewCollection shuffleData;
    private ThisDayViewCollection thisDayData;
    private ThisDayViewCollection thisWeekData;
    private volatile boolean weekContentChanged;

    public ThisDayInteractor(Context context, MediaItemDao mediaitemdao)
    {
        dayContentChanged = false;
        weekContentChanged = false;
        shuffleContentChanged = false;
        dataProvider = new ThisDayDBInfoProvider(context, mediaitemdao);
        mediaItemDao = mediaitemdao;
        contentResolver = context.getContentResolver();
        hidePreferenceManager = new HidePreferenceManager(context);
        dbTasks = new ThisDayDataLoaderTask[TaskType.values().length];
    }

    private void initTasks()
    {
        TaskType atasktype[] = TaskType.values();
        int j = atasktype.length;
        for (int i = 0; i < j; i++)
        {
            TaskType tasktype = atasktype[i];
            dbTasks[tasktype.ordinal()] = new ThisDayDataLoaderTask(this, tasktype);
        }

    }

    private void notifyObservers(ThisDayViewCollection thisdayviewcollection)
    {
        for (Iterator iterator = observers.iterator(); iterator.hasNext(); ((ThisDayDataObserver)iterator.next()).onDataRefreshed(thisdayviewcollection)) { }
    }

    private void refreshShuffleData()
    {
        if (shuffleData != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        Object obj1;
        Object obj2;
        HashMap hashmap;
        ContentProviderClient contentproviderclient;
        Object obj3;
        boolean flag;
        boolean flag1;
        int i;
        boolean flag2;
        boolean flag3;
        flag2 = false;
        flag3 = false;
        flag = false;
        hashmap = new HashMap();
        ThisDayYearInfo thisdayyearinfo;
        for (Iterator iterator = shuffleData.yearInfoList.iterator(); iterator.hasNext(); hashmap.put(Long.valueOf(((MediaItem)thisdayyearinfo.getMediaItems().get(0)).getId()), thisdayyearinfo))
        {
            thisdayyearinfo = (ThisDayYearInfo)iterator.next();
        }

        boolean flag4 = hidePreferenceManager.getHiddenPreference();
        contentproviderclient = contentResolver.acquireContentProviderClient(MEDIA_ITEM_URI);
        obj1 = null;
        obj2 = null;
        obj3 = TextUtils.join(",", hashmap.keySet());
        if (flag4)
        {
            obj = "";
        } else
        {
            obj = "AND hidden=0";
        }
        obj3 = String.format("%s IN (%s) AND %s = ? %s", new Object[] {
            "id", obj3, "sync_state", obj
        });
        i = SyncState.SYNCED.ordinal();
        flag1 = flag;
        obj = obj2;
        obj2 = contentproviderclient.query(MEDIA_ITEM_URI, null, ((String) (obj3)), new String[] {
            String.valueOf(i)
        }, null);
        i = ((flag3) ? 1 : 0);
        if (obj2 == null) goto _L4; else goto _L3
_L3:
        flag1 = flag;
        obj = obj2;
        obj1 = obj2;
        obj3 = new HashSet();
        flag1 = flag;
        obj = obj2;
        obj1 = obj2;
        if (((Cursor) (obj2)).getCount() != 0)
        {
            break MISSING_BLOCK_LABEL_322;
        }
        flag1 = flag;
        obj = obj2;
        obj1 = obj2;
        shuffleData.yearInfoList.clear();
        flag1 = flag;
        obj = obj2;
        obj1 = obj2;
        notifyObservers(shuffleData);
        flag1 = flag;
        obj = obj2;
        obj1 = obj2;
        shuffleContentChanged = false;
        if (obj2 != null)
        {
            ((Cursor) (obj2)).close();
        }
        contentproviderclient.release();
        return;
        flag1 = flag;
        obj = obj2;
        i = ((flag3) ? 1 : 0);
        obj1 = obj2;
        if (((Cursor) (obj2)).getCount() >= hashmap.keySet().size()) goto _L4; else goto _L5
_L5:
        flag1 = flag;
        obj = obj2;
        obj1 = obj2;
        ((Cursor) (obj2)).moveToFirst();
_L7:
        flag1 = flag;
        obj = obj2;
        obj1 = obj2;
        if (((Cursor) (obj2)).isAfterLast())
        {
            break; /* Loop/switch isn't completed */
        }
        flag1 = flag;
        obj = obj2;
        obj1 = obj2;
        ((Set) (obj3)).add(Long.valueOf(SQLiteDaoUtil.itemFromCursor(((Cursor) (obj2)), mediaItemDao).getId()));
        flag1 = flag;
        obj = obj2;
        obj1 = obj2;
        ((Cursor) (obj2)).moveToNext();
        if (true) goto _L7; else goto _L6
        obj2;
        obj1 = obj;
        GLogger.ex(TAG, ((RemoteException) (obj2)).getMessage(), ((Throwable) (obj2)));
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        contentproviderclient.release();
_L9:
        if (flag1)
        {
            notifyObservers(shuffleData);
            shuffleContentChanged = false;
            return;
        }
          goto _L1
_L6:
        flag1 = flag;
        obj = obj2;
        obj1 = obj2;
        Iterator iterator1 = hashmap.keySet().iterator();
        flag = flag2;
_L8:
        flag1 = flag;
        obj = obj2;
        i = ((flag) ? 1 : 0);
        obj1 = obj2;
        if (!iterator1.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        flag1 = flag;
        obj = obj2;
        obj1 = obj2;
        Object obj4 = (Long)iterator1.next();
        flag1 = flag;
        obj = obj2;
        obj1 = obj2;
        if (((Set) (obj3)).contains(obj4))
        {
            continue; /* Loop/switch isn't completed */
        }
        flag1 = flag;
        obj = obj2;
        obj1 = obj2;
        obj4 = (ThisDayYearInfo)hashmap.get(obj4);
        flag1 = flag;
        obj = obj2;
        obj1 = obj2;
        shuffleData.yearInfoList.remove(obj4);
        flag = true;
        if (true) goto _L8; else goto _L4
_L4:
        if (obj2 != null)
        {
            ((Cursor) (obj2)).close();
        }
        contentproviderclient.release();
        flag1 = i;
          goto _L9
        Exception exception;
        exception;
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        contentproviderclient.release();
        throw exception;
    }

    private void reloadData(int i)
    {
        ThisDayViewCollection thisdayviewcollection = dataProvider.getCollectionSynchronously(i);
        i;
        JVM INSTR tableswitch 0 2: default 36
    //                   0 42
    //                   1 55
    //                   2 68;
           goto _L1 _L2 _L3 _L4
_L1:
        notifyObservers(thisdayviewcollection);
        return;
_L2:
        thisDayData = thisdayviewcollection;
        dayContentChanged = false;
        continue; /* Loop/switch isn't completed */
_L3:
        thisWeekData = thisdayviewcollection;
        weekContentChanged = false;
        continue; /* Loop/switch isn't completed */
_L4:
        shuffleData = thisdayviewcollection;
        shuffleContentChanged = false;
        if (true) goto _L1; else goto _L5
_L5:
    }

    private void startAsyncDbTask(TaskType tasktype)
    {
        dbTaskExecutor.execute(dbTasks[tasktype.ordinal()]);
    }

    public void loadDataAsync(int i, boolean flag)
    {
        TaskType tasktype = TaskType.RELOAD_THIS_DAY;
        i;
        JVM INSTR tableswitch 0 2: default 32
    //                   0 38
    //                   1 80
    //                   2 122;
           goto _L1 _L2 _L3 _L4
_L1:
        startAsyncDbTask(tasktype);
        return;
_L2:
        if (!(flag | dayContentChanged) && thisDayData != null && !thisDayData.isEmpty())
        {
            notifyObservers(thisDayData);
            return;
        }
        tasktype = TaskType.RELOAD_THIS_DAY;
        continue; /* Loop/switch isn't completed */
_L3:
        if (!(flag | weekContentChanged) && thisWeekData != null && !thisWeekData.isEmpty())
        {
            notifyObservers(thisWeekData);
            return;
        }
        tasktype = TaskType.RELOAD_THIS_WEEK;
        continue; /* Loop/switch isn't completed */
_L4:
        if (!flag && shuffleData != null && !shuffleData.isEmpty())
        {
            if (shuffleContentChanged)
            {
                tasktype = TaskType.REFRESH_SHUFFLE;
            } else
            {
                notifyObservers(shuffleData);
                return;
            }
        } else
        {
            tasktype = TaskType.RELOAD_SHUFFLE;
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    public void registerDataObserver(ThisDayDataObserver thisdaydataobserver)
    {
        observers.add(thisdaydataobserver);
    }

    public void start()
    {
        initTasks();
        dbTaskExecutor = new ThisDayDbTaskExecutor();
        contentResolver.registerContentObserver(MEDIA_ITEM_URI, true, mediaItemsObserver);
    }

    public void stop()
    {
        contentResolver.unregisterContentObserver(mediaItemsObserver);
        dbTaskExecutor.shutdown();
    }

    public void unregisterDataObserver(ThisDayDataObserver thisdaydataobserver)
    {
        observers.remove(thisdaydataobserver);
    }

    static 
    {
        MEDIA_ITEM_URI = com.amazon.gallery.framework.kindle.provider.GalleryInternalContentProvider.MediaItem.CONTENT_URI;
    }



/*
    static boolean access$102(ThisDayInteractor thisdayinteractor, boolean flag)
    {
        thisdayinteractor.dayContentChanged = flag;
        return flag;
    }

*/


/*
    static boolean access$202(ThisDayInteractor thisdayinteractor, boolean flag)
    {
        thisdayinteractor.weekContentChanged = flag;
        return flag;
    }

*/


/*
    static boolean access$302(ThisDayInteractor thisdayinteractor, boolean flag)
    {
        thisdayinteractor.shuffleContentChanged = flag;
        return flag;
    }

*/





    // Unreferenced inner class com/amazon/gallery/thor/interactors/ThisDayInteractor$1

/* anonymous class */
    static class _cls1
    {

        static final int $SwitchMap$com$amazon$gallery$thor$interactors$ThisDayInteractor$TaskType[];

        static 
        {
            $SwitchMap$com$amazon$gallery$thor$interactors$ThisDayInteractor$TaskType = new int[TaskType.values().length];
            try
            {
                $SwitchMap$com$amazon$gallery$thor$interactors$ThisDayInteractor$TaskType[TaskType.RELOAD_THIS_DAY.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                $SwitchMap$com$amazon$gallery$thor$interactors$ThisDayInteractor$TaskType[TaskType.RELOAD_THIS_WEEK.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$amazon$gallery$thor$interactors$ThisDayInteractor$TaskType[TaskType.RELOAD_SHUFFLE.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$amazon$gallery$thor$interactors$ThisDayInteractor$TaskType[TaskType.REFRESH_SHUFFLE.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    // Unreferenced inner class com/amazon/gallery/thor/interactors/ThisDayInteractor$ThisDayDbTaskExecutor$1

/* anonymous class */
    class ThisDayDbTaskExecutor._cls1 extends ThreadPoolExecutor
    {

        final ThisDayDbTaskExecutor this$0;

        protected void afterExecute(Runnable runnable, Throwable throwable)
        {
            super.afterExecute(runnable, throwable);
            runnable = ((ThisDayDataLoaderTask)runnable).getTaskType();
            scheduleNextTaskFromQueue(runnable);
        }

            
            {
                this$0 = ThisDayDbTaskExecutor.this;
                super(i, j, l, timeunit, blockingqueue, threadfactory);
            }
    }

}
