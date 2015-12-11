// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.android.widget;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import co.vine.android.util.CrashUtil;
import java.util.ArrayList;

// Referenced classes of package com.twitter.android.widget:
//            RefreshableListView

private class registerDataSetObserver extends HeaderViewListAdapter
{

    private final unregisterDataSetObserver mDataSetObserver;
    private boolean mRegistered;
    final RefreshableListView this$0;

    public int getCount()
    {
        return mItemCount;
    }

    public Object getItem(int i)
    {
        if (isMode(34))
        {
            if (i == 0)
            {
                return null;
            } else
            {
                return super.getItem(i - 1);
            }
        } else
        {
            return super.getItem(i);
        }
    }

    public long getItemId(int i)
    {
        if (isMode(34))
        {
            if (i == 0)
            {
                return 0L;
            } else
            {
                return super.getItemId(i - 1);
            }
        } else
        {
            return super.getItemId(i);
        }
    }

    public int getItemViewType(int i)
    {
        if (isMode(34))
        {
            if (i == 0)
            {
                return -1;
            } else
            {
                return super.getItemViewType(i - 1);
            }
        } else
        {
            return super.getItemViewType(i);
        }
    }

    int getSuperCount()
    {
        return super.getCount();
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (isMode(34))
        {
            if (i == 0)
            {
                return mRefreshView;
            } else
            {
                return super.getView(i - 1, view, viewgroup);
            }
        }
        try
        {
            view = super.getView(i, view, viewgroup);
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            CrashUtil.logException(view);
            return mRefreshView;
        }
        return view;
    }

    public boolean isEnabled(int i)
    {
        if (isMode(34))
        {
            return i > 0 && superEnabled(i - 1);
        }
        boolean flag;
        try
        {
            flag = superEnabled(i);
        }
        catch (IndexOutOfBoundsException indexoutofboundsexception)
        {
            int j = RefreshableListView.access$000(RefreshableListView.this).size();
            if (i < j)
            {
                return ((android.widget.ListAdapter.this._cls0)RefreshableListView.access$000(RefreshableListView.this).get(i))._fld0;
            }
            int l = i - j;
            i = 0;
            if (RefreshableListView.access$100(RefreshableListView.this) != null)
            {
                int k = RefreshableListView.access$100(RefreshableListView.this).getCount();
                i = k;
                if (l < k)
                {
                    return RefreshableListView.access$100(RefreshableListView.this).isEnabled(l);
                }
            }
            boolean flag1;
            try
            {
                flag1 = ((android.widget.ListAdapter.isEnabled)RefreshableListView.access$200(RefreshableListView.this).get(l - i))._fld0;
            }
            catch (Exception exception)
            {
                CrashUtil.logException(exception);
                return false;
            }
            return flag1;
        }
        return flag;
    }

    public final void registerDataSetObserver()
    {
        if (!mRegistered)
        {
            super.registerDataSetObserver(mDataSetObserver);
            mRegistered = true;
        }
    }

    public void registerDataSetObserver(DataSetObserver datasetobserver)
    {
        mDataSetObserver.registerDataSetObserver(datasetobserver);
    }

    public boolean superEnabled(int i)
    {
        boolean flag;
        try
        {
            flag = super.isEnabled(i);
        }
        catch (IndexOutOfBoundsException indexoutofboundsexception)
        {
            int j = RefreshableListView.access$000(RefreshableListView.this).size();
            if (i < j)
            {
                return ((android.widget.ListAdapter.this._cls0)RefreshableListView.access$000(RefreshableListView.this).get(i))._fld0;
            }
            int l = i - j;
            i = 0;
            if (RefreshableListView.access$100(RefreshableListView.this) != null)
            {
                int k = RefreshableListView.access$100(RefreshableListView.this).getCount();
                i = k;
                if (l < k)
                {
                    return RefreshableListView.access$100(RefreshableListView.this).isEnabled(l);
                }
            }
            boolean flag1;
            try
            {
                flag1 = ((android.widget.ListAdapter.isEnabled)RefreshableListView.access$200(RefreshableListView.this).get(l - i))._fld0;
            }
            catch (Exception exception)
            {
                CrashUtil.logException(exception);
                return false;
            }
            return flag1;
        }
        return flag;
    }

    public final void unregisterDataSetObserver()
    {
        if (mRegistered)
        {
            super.unregisterDataSetObserver(mDataSetObserver);
            mRegistered = false;
        }
    }

    public void unregisterDataSetObserver(DataSetObserver datasetobserver)
    {
        mDataSetObserver.unregisterDataSetObserver(datasetobserver);
    }

    public (ArrayList arraylist, ArrayList arraylist1, ListAdapter listadapter,  )
    {
        this$0 = RefreshableListView.this;
        super(arraylist, arraylist1, listadapter);
        mDataSetObserver = ;
        registerDataSetObserver();
    }
}
