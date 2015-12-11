// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package commonlib.adapter;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.commonsware.cwac.adapter.AdapterWrapper;

// Referenced classes of package commonlib.adapter:
//            PendingAdapterInterface

public abstract class EndlessAdapter extends AdapterWrapper
    implements PendingAdapterInterface
{

    private static final int START_LOADING_WHEN_WITHIN_N_OF_END = 3;
    protected boolean forceStopAppending;
    private boolean isLoading;
    private View pendingView;
    protected int totalSize;

    public EndlessAdapter(ListAdapter listadapter)
    {
        super(listadapter);
        totalSize = 0;
        isLoading = false;
        forceStopAppending = false;
        listadapter.registerDataSetObserver(new DataSetObserver() {

            final EndlessAdapter this$0;

            public void onChanged()
            {
                pendingView = null;
                isLoading = false;
            }

            public void onInvalidated()
            {
                onChanged();
            }

            
            {
                this$0 = EndlessAdapter.this;
                super();
            }
        });
    }

    protected abstract View createPendingView(ViewGroup viewgroup);

    public void enableAppending(boolean flag)
    {
        if (forceStopAppending == flag)
        {
            if (!flag)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            forceStopAppending = flag;
            notifyDataSetChanged();
        }
    }

    public int getCount()
    {
        int j = super.getCount();
        int i;
        if (hasMorePages())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        return i + j;
    }

    public int getItemViewType(int i)
    {
        if (i >= getWrappedAdapter().getCount())
        {
            return getWrappedAdapter().getViewTypeCount();
        } else
        {
            return getWrappedAdapter().getItemViewType(i);
        }
    }

    protected View getPendingView(ViewGroup viewgroup)
    {
        if (pendingView == null)
        {
            pendingView = createPendingView(viewgroup);
        }
        return pendingView;
    }

    public int getTotalSize()
    {
        return totalSize;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (i >= getWrappedAdapter().getCount())
        {
            return getPendingView(viewgroup);
        }
        if (!isLoading && hasMorePages() && i + 3 >= getWrappedAdapter().getCount())
        {
            isLoading = true;
            requestNextPage();
        }
        return super.getView(i, view, viewgroup);
    }

    public int getViewTypeCount()
    {
        return getWrappedAdapter().getViewTypeCount() + 1;
    }

    public boolean hasMorePages()
    {
        int i = super.getCount();
        return i > 0 && i < getTotalSize() && !forceStopAppending;
    }

    protected abstract void requestNextPage();

    public void setTotalSize(int i)
    {
        totalSize = i;
    }


/*
    static View access$002(EndlessAdapter endlessadapter, View view)
    {
        endlessadapter.pendingView = view;
        return view;
    }

*/


/*
    static boolean access$102(EndlessAdapter endlessadapter, boolean flag)
    {
        endlessadapter.isLoading = flag;
        return flag;
    }

*/
}
