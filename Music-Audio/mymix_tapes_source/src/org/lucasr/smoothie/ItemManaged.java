// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.lucasr.smoothie;

import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.WrapperListAdapter;

// Referenced classes of package org.lucasr.smoothie:
//            ItemManager, AsyncBaseAdapter

class ItemManaged
{

    private final AbsListView mAbsListView;
    private boolean mInstallingManager;
    private ItemManager mItemManager;
    private android.widget.AdapterView.OnItemSelectedListener mOnItemSelectedListener;
    private android.widget.AbsListView.OnScrollListener mOnScrollListener;
    private android.view.View.OnTouchListener mOnTouchListener;
    private ListAdapter mWrappedAdapter;

    ItemManaged(AbsListView abslistview)
    {
        mAbsListView = abslistview;
        mWrappedAdapter = null;
        mItemManager = null;
        mInstallingManager = false;
        mOnScrollListener = null;
        mOnTouchListener = null;
        mOnItemSelectedListener = null;
    }

    void cancelAllRequests()
    {
        if (mItemManager != null)
        {
            mItemManager.cancelAllRequests();
        }
    }

    AbsListView getAbsListView()
    {
        return mAbsListView;
    }

    ListAdapter getAdapter()
    {
        ListAdapter listadapter1 = (ListAdapter)mAbsListView.getAdapter();
        ListAdapter listadapter = listadapter1;
        if (listadapter1 instanceof WrapperListAdapter)
        {
            listadapter = ((WrapperListAdapter)listadapter1).getWrappedAdapter();
        }
        return listadapter;
    }

    android.widget.AdapterView.OnItemSelectedListener getOnItemSelectedListener()
    {
        return mOnItemSelectedListener;
    }

    android.widget.AbsListView.OnScrollListener getOnScrollListener()
    {
        return mOnScrollListener;
    }

    android.view.View.OnTouchListener getOnTouchListener()
    {
        return mOnTouchListener;
    }

    boolean hasItemManager()
    {
        return mItemManager != null;
    }

    void setAdapterOnView(ListAdapter listadapter)
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            mAbsListView.setAdapter(listadapter);
        } else
        {
            if (mAbsListView instanceof ListView)
            {
                ((ListView)mAbsListView).setAdapter(listadapter);
                return;
            }
            if (mAbsListView instanceof GridView)
            {
                ((GridView)mAbsListView).setAdapter(listadapter);
                return;
            }
        }
    }

    void setItemManager(ItemManager itemmanager)
    {
        if (mItemManager != null)
        {
            mItemManager.setItemManaged(null);
            mItemManager = null;
        }
        mInstallingManager = true;
        if (itemmanager != null)
        {
            itemmanager.setItemManaged(this);
            setAdapterOnView(wrapAdapter(itemmanager, mWrappedAdapter));
        } else
        {
            mAbsListView.setOnScrollListener(mOnScrollListener);
            mAbsListView.setOnTouchListener(mOnTouchListener);
            mAbsListView.setOnItemSelectedListener(mOnItemSelectedListener);
            setAdapterOnView(mWrappedAdapter);
        }
        mItemManager = itemmanager;
        mInstallingManager = false;
        triggerUpdate();
    }

    void setOnItemSelectedListener(android.widget.AdapterView.OnItemSelectedListener onitemselectedlistener)
    {
        if (mInstallingManager)
        {
            return;
        } else
        {
            mOnItemSelectedListener = onitemselectedlistener;
            return;
        }
    }

    void setOnScrollListener(android.widget.AbsListView.OnScrollListener onscrolllistener)
    {
        if (mInstallingManager)
        {
            return;
        } else
        {
            mOnScrollListener = onscrolllistener;
            return;
        }
    }

    void setOnTouchListener(android.view.View.OnTouchListener ontouchlistener)
    {
        if (mInstallingManager)
        {
            return;
        } else
        {
            mOnTouchListener = ontouchlistener;
            return;
        }
    }

    void triggerUpdate()
    {
        if (hasItemManager() && mWrappedAdapter != null)
        {
            mItemManager.postUpdateItems();
        }
    }

    ListAdapter wrapAdapter(ListAdapter listadapter)
    {
        return wrapAdapter(mItemManager, listadapter);
    }

    ListAdapter wrapAdapter(ItemManager itemmanager, ListAdapter listadapter)
    {
        mWrappedAdapter = listadapter;
        Object obj = listadapter;
        if (itemmanager != null)
        {
            obj = listadapter;
            if (listadapter != null)
            {
                obj = new AsyncBaseAdapter(itemmanager, (BaseAdapter)listadapter);
            }
        }
        return ((ListAdapter) (obj));
    }
}
