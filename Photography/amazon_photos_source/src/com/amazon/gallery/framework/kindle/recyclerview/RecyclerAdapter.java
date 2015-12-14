// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.recyclerview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.amazon.gallery.framework.gallery.widget.ViewFactory;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.amazon.gallery.framework.kindle.recyclerview:
//            TrackSelectionAdapter

public class RecyclerAdapter extends TrackSelectionAdapter
{

    protected final ViewFactory defaultFactory;
    protected BaseAdapter mDelegateAdapter;
    private android.view.View.OnClickListener onClickListener;
    private android.view.View.OnLongClickListener onLongClickListener;
    private android.view.View.OnTouchListener onTouchListener;
    private final Map viewTypeToFactory = new HashMap();

    public RecyclerAdapter(BaseAdapter baseadapter, ViewFactory viewfactory)
    {
        mDelegateAdapter = baseadapter;
        defaultFactory = viewfactory;
    }

    public BaseAdapter getDelegateAdapter()
    {
        return mDelegateAdapter;
    }

    public int getItemCount()
    {
        return mDelegateAdapter.getCount();
    }

    public long getItemId(int i)
    {
        return mDelegateAdapter.getItemId(i);
    }

    public int getItemViewType(int i)
    {
        return mDelegateAdapter.getItemViewType(i);
    }

    public void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewholder, int i)
    {
        super.onBindViewHolder(viewholder, i);
        mDelegateAdapter.getView(i, viewholder.itemView, null);
    }

    public android.support.v7.widget.RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i)
    {
        android.support.v7.widget.RecyclerView.ViewHolder viewholder;
        if (viewTypeToFactory.containsKey(Integer.valueOf(i)))
        {
            viewgroup = ((ViewFactory)viewTypeToFactory.get(Integer.valueOf(i))).createView(null);
        } else
        {
            viewgroup = defaultFactory.createView(null);
        }
        viewholder = (android.support.v7.widget.RecyclerView.ViewHolder)viewgroup.getTag();
        viewgroup.setTag(viewholder);
        if (onTouchListener != null)
        {
            viewgroup.setOnTouchListener(onTouchListener);
        }
        viewgroup.setOnClickListener(onClickListener);
        viewgroup.setOnLongClickListener(onLongClickListener);
        return viewholder;
    }

    public void onViewRecycled(android.support.v7.widget.RecyclerView.ViewHolder viewholder)
    {
        super.onViewRecycled(viewholder);
        if (viewTypeToFactory.containsKey(Integer.valueOf(viewholder.getItemViewType())))
        {
            ((ViewFactory)viewTypeToFactory.get(Integer.valueOf(viewholder.getItemViewType()))).onViewDestroy(viewholder.itemView);
            return;
        } else
        {
            defaultFactory.onViewDestroy(viewholder.itemView);
            return;
        }
    }

    public void setOnClickListener(android.view.View.OnClickListener onclicklistener)
    {
        onClickListener = onclicklistener;
    }

    public void setOnLongClickListener(android.view.View.OnLongClickListener onlongclicklistener)
    {
        onLongClickListener = onlongclicklistener;
    }

    public void setOnTouchListener(android.view.View.OnTouchListener ontouchlistener)
    {
        onTouchListener = ontouchlistener;
    }

    public void setViewFactory(int i, ViewFactory viewfactory)
    {
        viewTypeToFactory.put(Integer.valueOf(i), viewfactory);
    }
}
