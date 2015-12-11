// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.getaways.carousel;

import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public final class EndlessRecyclerViewAdapter extends android.support.v7.widget.RecyclerView.Adapter
{
    private class ForwardingDataSetObserver extends android.support.v7.widget.RecyclerView.AdapterDataObserver
    {

        final EndlessRecyclerViewAdapter this$0;

        public void onChanged()
        {
            notifyDataSetChanged();
        }

        public void onItemRangeChanged(int i, int j)
        {
            notifyItemRangeChanged(i, j);
        }

        public void onItemRangeInserted(int i, int j)
        {
            notifyItemRangeInserted(i, j);
        }

        public void onItemRangeMoved(int i, int j, int k)
        {
            notifyItemMoved(i, j);
        }

        public void onItemRangeRemoved(int i, int j)
        {
            notifyItemRangeRemoved(i, j);
        }

        private ForwardingDataSetObserver()
        {
            this$0 = EndlessRecyclerViewAdapter.this;
            super();
        }

    }

    public static class ProgressViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder
    {

        public ProgressViewHolder(View view)
        {
            super(view);
        }
    }


    private final android.support.v7.widget.RecyclerView.Adapter adapter;
    private boolean isProgressVisible;
    private ProgressViewHolder progressViewHolder;
    private final int progressViewId;

    public EndlessRecyclerViewAdapter(android.support.v7.widget.RecyclerView.Adapter adapter1, int i)
    {
        isProgressVisible = false;
        adapter = adapter1;
        progressViewId = i;
        super.setHasStableIds(adapter1.hasStableIds());
        adapter1.registerAdapterDataObserver(new ForwardingDataSetObserver());
    }

    public android.support.v7.widget.RecyclerView.Adapter getAdapter()
    {
        return adapter;
    }

    public int getItemCount()
    {
        int j = adapter.getItemCount();
        int i;
        if (isProgressVisible)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        return i + j;
    }

    public long getItemId(int i)
    {
        if (isProgressView(i))
        {
            return super.getItemId(i);
        } else
        {
            return adapter.getItemId(i);
        }
    }

    public int getItemViewType(int i)
    {
        if (isProgressVisible && i == getItemCount() - 1)
        {
            return progressViewId;
        } else
        {
            return adapter.getItemViewType(i);
        }
    }

    public boolean isProgressView(int i)
    {
        return getItemViewType(i) == progressViewId;
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerview)
    {
        adapter.onAttachedToRecyclerView(recyclerview);
    }

    public void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewholder, int i)
    {
        if (!isProgressView(i))
        {
            adapter.onBindViewHolder(viewholder, i);
        }
    }

    public android.support.v7.widget.RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i)
    {
        if (i == progressViewId)
        {
            progressViewHolder = new ProgressViewHolder(LayoutInflater.from(viewgroup.getContext()).inflate(progressViewId, viewgroup, false));
            return progressViewHolder;
        } else
        {
            return adapter.onCreateViewHolder(viewgroup, i);
        }
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerview)
    {
        adapter.onDetachedFromRecyclerView(recyclerview);
    }

    public void onViewAttachedToWindow(android.support.v7.widget.RecyclerView.ViewHolder viewholder)
    {
        if (viewholder == progressViewHolder)
        {
            return;
        } else
        {
            adapter.onViewAttachedToWindow(viewholder);
            return;
        }
    }

    public void onViewDetachedFromWindow(android.support.v7.widget.RecyclerView.ViewHolder viewholder)
    {
        if (viewholder == progressViewHolder)
        {
            return;
        } else
        {
            adapter.onViewDetachedFromWindow(viewholder);
            return;
        }
    }

    public void onViewRecycled(android.support.v7.widget.RecyclerView.ViewHolder viewholder)
    {
        if (viewholder == progressViewHolder)
        {
            return;
        } else
        {
            adapter.onViewRecycled(viewholder);
            return;
        }
    }

    public void setProgressViewVisible(final boolean visible)
    {
        (new Handler()).post(new Runnable() {

            final EndlessRecyclerViewAdapter this$0;
            final boolean val$visible;

            public void run()
            {
                if (isProgressVisible == visible)
                {
                    return;
                }
                isProgressVisible = visible;
                if (visible)
                {
                    notifyItemInserted(adapter.getItemCount() + 1);
                    return;
                } else
                {
                    notifyItemRemoved(adapter.getItemCount() + 1);
                    return;
                }
            }

            
            {
                this$0 = EndlessRecyclerViewAdapter.this;
                visible = flag;
                super();
            }
        });
    }



/*
    static boolean access$102(EndlessRecyclerViewAdapter endlessrecyclerviewadapter, boolean flag)
    {
        endlessrecyclerviewadapter.isProgressVisible = flag;
        return flag;
    }

*/

}
