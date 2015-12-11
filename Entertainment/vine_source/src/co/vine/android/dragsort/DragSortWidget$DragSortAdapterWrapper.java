// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.dragsort;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;

// Referenced classes of package co.vine.android.dragsort:
//            DragSortWidget

public class mContext extends BaseAdapter
    implements ListAdapter
{

    private ListAdapter mAdapter;
    private Context mContext;
    private DataSetObserver mObserver;
    final DragSortWidget this$0;

    public int getCount()
    {
        return mAdapter.getCount();
    }

    public Object getItem(int i)
    {
        return mAdapter.getItem(i);
    }

    public long getItemId(int i)
    {
        return mAdapter.getItemId(i);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        float f;
        boolean flag;
        if (view != null)
        {
            view = (mAdapter)view;
            View view1 = view.ldAt(i);
            viewgroup = mAdapter.getView(i, view1, viewgroup);
        } else
        {
            viewgroup = mAdapter.getView(i, null, viewgroup);
            view = new (DragSortWidget.this, mContext);
        }
        view.AllViews();
        view.w(viewgroup);
        if (i == DragSortWidget.access$2200(DragSortWidget.this))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view.ivated(flag);
        if (i == DragSortWidget.access$2500(DragSortWidget.this))
        {
            f = 1.0F;
        } else
        {
            f = 0.3F;
        }
        view.ha(f);
        viewgroup = view.outParams();
        if (mRemoving && i == DragSortWidget.access$2100(DragSortWidget.this))
        {
            viewgroup._fld0 = _mth700(DragSortWidget.access$2600(DragSortWidget.this));
        } else
        {
            viewgroup._fld0 = 0;
        }
        view.outParams(viewgroup);
        if (DragSortWidget.access$2800(DragSortWidget.this) != null && i == DragSortWidget.access$100(DragSortWidget.this))
        {
            view.ibility(4);
            return view;
        } else
        {
            view.ibility(0);
            return view;
        }
    }

    public boolean isEnabled(int i)
    {
        return mAdapter.isEnabled(i);
    }

    public void setAdapter(ListAdapter listadapter)
    {
        mAdapter = listadapter;
        if (listadapter != null)
        {
            listadapter.registerDataSetObserver(mObserver);
        }
    }

    public _cls1.this._cls1(Context context)
    {
        this$0 = DragSortWidget.this;
        super();
        mObserver = new DataSetObserver() {

            final DragSortWidget.DragSortAdapterWrapper this$1;

            public void onChanged()
            {
                notifyDataSetChanged();
                DragSortWidget.access$1200(this$0);
            }

            
            {
                this$1 = DragSortWidget.DragSortAdapterWrapper.this;
                super();
            }
        };
        mContext = context;
    }
}
