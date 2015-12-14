// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.lucasr.smoothie;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;

// Referenced classes of package org.lucasr.smoothie:
//            ItemLoader, ItemManaged

public final class ItemManager
{
    public static final class Builder
    {

        private static final int DEFAULT_PRELOAD_ITEMS_COUNT = 4;
        private static final boolean DEFAULT_PRELOAD_ITEMS_ENABLED = false;
        private static final int DEFAULT_THREAD_POOL_SIZE = 2;
        private final ItemLoader mItemLoader;
        private int mPreloadItemsCount;
        private boolean mPreloadItemsEnabled;
        private int mThreadPoolSize;

        public ItemManager build()
        {
            return new ItemManager(mItemLoader, mPreloadItemsEnabled, mPreloadItemsCount, mThreadPoolSize);
        }

        public Builder setPreloadItemsCount(int i)
        {
            mPreloadItemsCount = i;
            return this;
        }

        public Builder setPreloadItemsEnabled(boolean flag)
        {
            mPreloadItemsEnabled = flag;
            return this;
        }

        public Builder setThreadPoolSize(int i)
        {
            mThreadPoolSize = i;
            return this;
        }

        public Builder(ItemLoader itemloader)
        {
            mItemLoader = itemloader;
            mPreloadItemsEnabled = false;
            mPreloadItemsCount = 4;
            mThreadPoolSize = 2;
        }
    }

    private class FingerTracker
        implements android.view.View.OnTouchListener
    {

        final ItemManager this$0;

        public boolean onTouch(View view, MotionEvent motionevent)
        {
            boolean flag2 = true;
            boolean flag1 = false;
            int i = motionevent.getAction();
            Object obj = ItemManager.this;
            boolean flag = flag2;
            if (i != 1)
            {
                if (i == 3)
                {
                    flag = flag2;
                } else
                {
                    flag = false;
                }
            }
            obj.mFingerUp = flag;
            if (mFingerUp && mScrollState != 2)
            {
                postUpdateItems();
            }
            obj = mManaged.getOnTouchListener();
            flag = flag1;
            if (obj != null)
            {
                flag = ((android.view.View.OnTouchListener) (obj)).onTouch(view, motionevent);
            }
            return flag;
        }

        private FingerTracker()
        {
            this$0 = ItemManager.this;
            super();
        }

    }

    private static class ItemsListHandler extends Handler
    {

        public void handleMessage(Message message)
        {
            switch (message.what)
            {
            default:
                return;

            case 1: // '\001'
                ((ItemManager)message.obj).updateItems();
                break;
            }
        }

        private ItemsListHandler()
        {
        }

    }

    private class ScrollManager
        implements android.widget.AbsListView.OnScrollListener
    {

        final ItemManager this$0;

        public void onScroll(AbsListView abslistview, int i, int j, int k)
        {
            android.widget.AbsListView.OnScrollListener onscrolllistener = mManaged.getOnScrollListener();
            if (onscrolllistener != null)
            {
                onscrolllistener.onScroll(abslistview, i, j, k);
            }
        }

        public void onScrollStateChanged(AbsListView abslistview, int i)
        {
            int j;
            boolean flag = false;
            Object obj;
            if (mScrollState == 2 && i != 2)
            {
                j = 1;
            } else
            {
                j = 0;
            }
            if (j == 0) goto _L2; else goto _L1
_L1:
            obj = mHandler.obtainMessage(1, ItemManager.this);
            mHandler.removeMessages(1);
            if (mFingerUp)
            {
                j = ((flag) ? 1 : 0);
            } else
            {
                j = 550;
            }
            mHandler.sendMessageDelayed(((Message) (obj)), j);
            mPendingItemsUpdate = true;
_L4:
            mScrollState = i;
            obj = mManaged.getOnScrollListener();
            if (obj != null)
            {
                ((android.widget.AbsListView.OnScrollListener) (obj)).onScrollStateChanged(abslistview, i);
            }
            return;
_L2:
            if (i == 2)
            {
                mPendingItemsUpdate = false;
                mHandler.removeMessages(1);
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        private ScrollManager()
        {
            this$0 = ItemManager.this;
            super();
        }

    }

    private class SelectionTracker
        implements android.widget.AdapterView.OnItemSelectedListener
    {

        final ItemManager this$0;

        public void onItemSelected(AdapterView adapterview, View view, int i, long l)
        {
            if (mScrollState != 0)
            {
                mScrollState = 0;
                postUpdateItems();
            }
            android.widget.AdapterView.OnItemSelectedListener onitemselectedlistener = mManaged.getOnItemSelectedListener();
            if (onitemselectedlistener != null)
            {
                onitemselectedlistener.onItemSelected(adapterview, view, i, l);
            }
        }

        public void onNothingSelected(AdapterView adapterview)
        {
            android.widget.AdapterView.OnItemSelectedListener onitemselectedlistener = mManaged.getOnItemSelectedListener();
            if (onitemselectedlistener != null)
            {
                onitemselectedlistener.onNothingSelected(adapterview);
            }
        }

        private SelectionTracker()
        {
            this$0 = ItemManager.this;
            super();
        }

    }


    private static final int DELAY_SHOW_ITEMS = 550;
    private static final int MESSAGE_UPDATE_ITEMS = 1;
    private boolean mFingerUp;
    private final Handler mHandler;
    private final ItemLoader mItemLoader;
    private long mLastPreloadTimestamp;
    private ItemManaged mManaged;
    private boolean mPendingItemsUpdate;
    private final int mPreloadItemsCount;
    private final boolean mPreloadItemsEnabled;
    private int mScrollState;

    private ItemManager(ItemLoader itemloader, boolean flag, int i, int j)
    {
        mManaged = null;
        mHandler = new ItemsListHandler();
        mItemLoader = itemloader;
        mItemLoader.init(mHandler, j);
        mPreloadItemsEnabled = flag;
        mPreloadItemsCount = i;
        mLastPreloadTimestamp = SystemClock.uptimeMillis();
        mScrollState = 0;
    }


    private void updateItems()
    {
        if (mManaged != null)
        {
            AbsListView abslistview = mManaged.getAbsListView();
            ListAdapter listadapter = mManaged.getAdapter();
            mPendingItemsUpdate = false;
            if (listadapter != null)
            {
                long l1 = SystemClock.uptimeMillis();
                int k = abslistview.getChildCount();
                for (int i = 0; i < k;)
                {
                    View view = abslistview.getChildAt(i);
                    mItemLoader.performDisplayItem(abslistview, listadapter, view, l1);
                    i++;
                    l1++;
                }

                long l2 = l1;
                if (mPreloadItemsEnabled)
                {
                    int l = abslistview.getLastVisiblePosition() + 1;
                    l2 = l1;
                    if (l > 0)
                    {
                        int i1 = listadapter.getCount();
                        int j = l;
                        do
                        {
                            l2 = l1;
                            if (j >= mPreloadItemsCount + l)
                            {
                                break;
                            }
                            l2 = l1;
                            if (j >= i1)
                            {
                                break;
                            }
                            mItemLoader.performPreloadItem(abslistview, listadapter, j, l1);
                            j++;
                            l1++;
                        } while (true);
                    }
                }
                mItemLoader.cancelObsoleteRequests(mLastPreloadTimestamp);
                mLastPreloadTimestamp = l2;
                abslistview.invalidate();
                return;
            }
        }
    }

    void cancelAllRequests()
    {
        if (mManaged == null)
        {
            throw new IllegalStateException("Cannot cancel requests with no managed view");
        } else
        {
            mItemLoader.cancelRequestsForContainer(mManaged.getAbsListView());
            return;
        }
    }

    void loadItem(View view, View view1, int i)
    {
        mManaged.getAbsListView();
        ListAdapter listadapter = mManaged.getAdapter();
        boolean flag;
        if (mScrollState != 2 && !mPendingItemsUpdate)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mItemLoader.performLoadItem(view, view1, listadapter, i, flag);
    }

    void postUpdateItems()
    {
        Message message = mHandler.obtainMessage(1, this);
        mHandler.removeMessages(1);
        mPendingItemsUpdate = true;
        mHandler.sendMessage(message);
    }

    void setItemManaged(ItemManaged itemmanaged)
    {
        mManaged = itemmanaged;
        if (mManaged != null)
        {
            itemmanaged = mManaged.getAbsListView();
            itemmanaged.setOnScrollListener(new ScrollManager());
            itemmanaged.setOnTouchListener(new FingerTracker());
            itemmanaged.setOnItemSelectedListener(new SelectionTracker());
        }
    }



/*
    static int access$402(ItemManager itemmanager, int i)
    {
        itemmanager.mScrollState = i;
        return i;
    }

*/




/*
    static boolean access$602(ItemManager itemmanager, boolean flag)
    {
        itemmanager.mFingerUp = flag;
        return flag;
    }

*/


/*
    static boolean access$702(ItemManager itemmanager, boolean flag)
    {
        itemmanager.mPendingItemsUpdate = flag;
        return flag;
    }

*/


}
