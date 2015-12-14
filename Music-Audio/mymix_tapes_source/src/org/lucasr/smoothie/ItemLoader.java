// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.lucasr.smoothie;

import android.os.Handler;
import android.os.Process;
import android.os.SystemClock;
import android.view.View;
import android.widget.Adapter;
import java.lang.ref.SoftReference;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class ItemLoader
{
    private static final class DisplayItemRunnable
        implements Runnable
    {

        private final boolean mFromMemory;
        private final ItemLoader mItemLoader;
        private final ItemRequest mRequest;

        public void run()
        {
            if (!mItemLoader.itemViewReused(mRequest))
            {
                if (mRequest.result == null)
                {
                    throw new IllegalStateException("Result should not be null when displaying an item part");
                }
                View view = (View)mRequest.itemView.get();
                if (view != null)
                {
                    Object obj = mRequest.result.get();
                    mItemLoader.displayItemPart(view, obj, mRequest.itemPart.intValue(), mFromMemory);
                    return;
                }
            }
        }

        public DisplayItemRunnable(ItemLoader itemloader, ItemRequest itemrequest, boolean flag)
        {
            mItemLoader = itemloader;
            mRequest = itemrequest;
            mFromMemory = flag;
        }
    }

    private static final class ItemRequest
    {

        public final String id;
        public SoftReference itemContainer;
        public final Object itemParams;
        public final Integer itemPart;
        public SoftReference itemView;
        public Future loadItemTask;
        public final int position;
        public SoftReference result;
        public Long timestamp;

        public ItemRequest(String s, View view, View view1, Object obj, int i, int j, long l)
        {
            id = s;
            itemContainer = new SoftReference(view);
            if (view1 != null)
            {
                s = new SoftReference(view1);
            } else
            {
                s = null;
            }
            itemView = s;
            itemParams = obj;
            position = i;
            itemPart = Integer.valueOf(j);
            result = null;
            timestamp = Long.valueOf(l);
            loadItemTask = null;
        }

        public ItemRequest(String s, View view, Object obj, int i, int j, long l)
        {
            this(s, view, null, obj, i, j, l);
        }
    }

    static final class ItemState
    {

        public Object itemParams;
        public int position;
        public boolean shouldLoadItem;

        ItemState()
        {
        }
    }

    private static final class ItemsThreadPoolExecutor extends ThreadPoolExecutor
    {

        public Future submit(Runnable runnable)
        {
            if (runnable == null)
            {
                throw new NullPointerException();
            } else
            {
                runnable = new LoadItemFutureTask((LoadItemRunnable)runnable);
                execute(runnable);
                return runnable;
            }
        }

        public ItemsThreadPoolExecutor(int i, int j, long l, TimeUnit timeunit, BlockingQueue blockingqueue)
        {
            super(i, j, l, timeunit, blockingqueue);
        }
    }

    private static final class LoadItemFutureTask extends FutureTask
        implements Comparable
    {

        private final LoadItemRunnable mRunnable;

        public volatile int compareTo(Object obj)
        {
            return compareTo((LoadItemFutureTask)obj);
        }

        public int compareTo(LoadItemFutureTask loaditemfuturetask)
        {
            ItemRequest itemrequest = mRunnable.getItemRequest();
            loaditemfuturetask = loaditemfuturetask.mRunnable.getItemRequest();
            if (itemrequest.itemView != null && ((ItemRequest) (loaditemfuturetask)).itemView == null)
            {
                return -1;
            }
            if (itemrequest.itemView == null && ((ItemRequest) (loaditemfuturetask)).itemView != null)
            {
                return 1;
            }
            if (!itemrequest.itemPart.equals(((ItemRequest) (loaditemfuturetask)).itemPart))
            {
                return itemrequest.itemPart.compareTo(((ItemRequest) (loaditemfuturetask)).itemPart);
            } else
            {
                return itemrequest.timestamp.compareTo(((ItemRequest) (loaditemfuturetask)).timestamp);
            }
        }

        public LoadItemFutureTask(LoadItemRunnable loaditemrunnable)
        {
            super(loaditemrunnable, null);
            mRunnable = loaditemrunnable;
        }
    }

    private static final class LoadItemRunnable
        implements Runnable
    {

        private final ItemLoader mItemLoader;
        private final ItemRequest mRequest;

        public ItemRequest getItemRequest()
        {
            return mRequest;
        }

        public void run()
        {
            Process.setThreadPriority(10);
            mItemLoader.mItemRequests.remove(mRequest.id);
            if (!mItemLoader.itemViewReused(mRequest))
            {
                Object obj = mItemLoader.loadItemPart(mRequest.itemParams, mRequest.itemPart.intValue());
                mRequest.result = new SoftReference(obj);
                if (mRequest.itemView != null && !mItemLoader.itemViewReused(mRequest))
                {
                    mItemLoader.mHandler.post(new DisplayItemRunnable(mItemLoader, mRequest, false));
                    return;
                }
            }
        }

        public LoadItemRunnable(ItemLoader itemloader, ItemRequest itemrequest)
        {
            mItemLoader = itemloader;
            mRequest = itemrequest;
        }
    }


    private static final boolean ENABLE_LOGGING = false;
    private static final String LOGTAG = "SmoothieItemLoader";
    private ThreadPoolExecutor mExecutorService;
    private Handler mHandler;
    private Map mItemRequests;
    private Map mItemStates;

    public ItemLoader()
    {
    }

    private void cancelItemRequest(int i, int j)
    {
        String s = generateItemRequestId(i, j);
        ItemRequest itemrequest = (ItemRequest)mItemRequests.get(s);
        if (itemrequest != null)
        {
            mItemRequests.remove(s);
            if (itemrequest.loadItemTask != null)
            {
                itemrequest.loadItemTask.cancel(true);
                return;
            }
        }
    }

    private static String generateItemRequestId(int i, int j)
    {
        return (new StringBuilder()).append(String.valueOf(i)).append(String.valueOf(j)).toString();
    }

    private ItemState getItemState(View view)
    {
        ItemState itemstate1 = (ItemState)mItemStates.get(view);
        ItemState itemstate = itemstate1;
        if (itemstate1 == null)
        {
            itemstate = new ItemState();
            itemstate.itemParams = null;
            itemstate.shouldLoadItem = false;
            itemstate.position = -1;
            mItemStates.put(view, itemstate);
        }
        return itemstate;
    }

    private boolean itemViewReused(ItemRequest itemrequest)
    {
        if (itemrequest.itemView != null)
        {
            View view = (View)itemrequest.itemView.get();
            if (view == null)
            {
                return true;
            }
            int i = getItemState(view).position;
            if (i == -1 || itemrequest.position != i)
            {
                return true;
            }
        }
        return false;
    }

    private void performDisplayItemPart(View view, View view1, ItemState itemstate, int i, long l)
    {
        int j = itemstate.position;
        Object obj = itemstate.itemParams;
        String s = generateItemRequestId(j, i);
        ItemRequest itemrequest = (ItemRequest)mItemRequests.get(s);
        if (itemrequest == null)
        {
            view = new ItemRequest(s, view, view1, obj, j, i, l);
            mItemRequests.put(s, view);
        } else
        {
            itemrequest.timestamp = Long.valueOf(l);
            itemrequest.itemView = new SoftReference(view1);
            view = itemrequest;
        }
        itemstate.shouldLoadItem = false;
        view1 = ((View) (loadItemPartFromMemory(obj, i)));
        if (view1 != null)
        {
            cancelItemRequest(j, i);
            view.result = new SoftReference(view1);
            mHandler.post(new DisplayItemRunnable(this, view, true));
            return;
        } else
        {
            view.loadItemTask = mExecutorService.submit(new LoadItemRunnable(this, view));
            return;
        }
    }

    private void performPreloadItemPart(View view, Object obj, Adapter adapter, int i, int j, long l)
    {
        if (isItemPartInMemory(obj, j))
        {
            cancelItemRequest(i, j);
            return;
        }
        adapter = generateItemRequestId(i, j);
        ItemRequest itemrequest = (ItemRequest)mItemRequests.get(adapter);
        if (itemrequest == null)
        {
            view = new ItemRequest(adapter, view, obj, i, j, l);
            mItemRequests.put(adapter, view);
            view.loadItemTask = mExecutorService.submit(new LoadItemRunnable(this, view));
            return;
        } else
        {
            itemrequest.timestamp = Long.valueOf(l);
            itemrequest.itemView = null;
            return;
        }
    }

    void cancelObsoleteRequests(long l)
    {
        Iterator iterator = mItemRequests.values().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ItemRequest itemrequest = (ItemRequest)iterator.next();
            if (itemrequest.timestamp.longValue() < l)
            {
                if (itemrequest.loadItemTask != null)
                {
                    itemrequest.loadItemTask.cancel(true);
                }
                iterator.remove();
            }
        } while (true);
        mExecutorService.purge();
    }

    void cancelRequestsForContainer(View view)
    {
        if (view == null)
        {
            throw new IllegalArgumentException("Null itemContainer in cancelRequestsForContainer");
        }
        Iterator iterator = mItemRequests.values().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ItemRequest itemrequest = (ItemRequest)iterator.next();
            if ((View)itemrequest.itemContainer.get() == view)
            {
                if (itemrequest.loadItemTask != null)
                {
                    itemrequest.loadItemTask.cancel(true);
                }
                iterator.remove();
            }
        } while (true);
    }

    public abstract void displayItemPart(View view, Object obj, int i, boolean flag);

    public abstract Object getItemParams(Adapter adapter, int i);

    public int getItemPartCount(Adapter adapter, int i)
    {
        return 1;
    }

    void init(Handler handler, int i)
    {
        mHandler = handler;
        mItemStates = Collections.synchronizedMap(new WeakHashMap());
        mItemRequests = new ConcurrentHashMap(8, 0.9F, 1);
        mExecutorService = new ItemsThreadPoolExecutor(i, i, 60L, TimeUnit.SECONDS, new PriorityBlockingQueue());
    }

    boolean isItemPartInMemory(Object obj, int i)
    {
        return loadItemPartFromMemory(obj, i) != null;
    }

    public abstract Object loadItemPart(Object obj, int i);

    public abstract Object loadItemPartFromMemory(Object obj, int i);

    void performDisplayItem(View view, Adapter adapter, View view1, long l)
    {
        ItemState itemstate;
        itemstate = getItemState(view1);
        break MISSING_BLOCK_LABEL_7;
        while (true) 
        {
            do
            {
                return;
            } while (!itemstate.shouldLoadItem || itemstate.itemParams == null);
            int i = itemstate.position;
            if (i != -1)
            {
                int j = getItemPartCount(adapter, i);
                i = 0;
                while (i < j) 
                {
                    performDisplayItemPart(view, view1, itemstate, i, l);
                    i++;
                }
            }
        }
    }

    void performLoadItem(View view, View view1, Adapter adapter, int i, boolean flag)
    {
        Object obj = getItemParams(adapter, i);
        if (obj != null)
        {
            ItemState itemstate = getItemState(view1);
            itemstate.itemParams = obj;
            itemstate.position = i;
            itemstate.shouldLoadItem = true;
            int j = getItemPartCount(adapter, i);
            i = 0;
            while (i < j) 
            {
                if (flag || isItemPartInMemory(obj, i))
                {
                    performDisplayItemPart(view, view1, itemstate, i, SystemClock.uptimeMillis());
                }
                i++;
            }
        }
    }

    void performPreloadItem(View view, Adapter adapter, int i, long l)
    {
        Object obj = getItemParams(adapter, i);
        if (obj != null)
        {
            int k = getItemPartCount(adapter, i);
            int j = 0;
            while (j < k) 
            {
                if (shouldPreloadItemPart(adapter, i, j))
                {
                    performPreloadItemPart(view, obj, adapter, i, j, SystemClock.uptimeMillis());
                }
                j++;
            }
        }
    }

    public boolean shouldPreloadItemPart(Adapter adapter, int i, int j)
    {
        return true;
    }



}
