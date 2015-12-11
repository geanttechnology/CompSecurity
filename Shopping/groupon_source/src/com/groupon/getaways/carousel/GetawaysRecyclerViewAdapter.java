// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.getaways.carousel;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;

// Referenced classes of package com.groupon.getaways.carousel:
//            DealsRecyclerViewAdapter, GetawaysWidgetRecyclerViewAdapter

public class GetawaysRecyclerViewAdapter extends android.support.v7.widget.RecyclerView.Adapter
{
    private class DealsAdapterForwardingDataSetObserver extends android.support.v7.widget.RecyclerView.AdapterDataObserver
    {

        final GetawaysRecyclerViewAdapter this$0;

        public void onChanged()
        {
            notifyDataSetChanged();
        }

        public void onItemRangeInserted(int i, int j)
        {
            notifyItemRangeInserted(dealPositionToRealPosition(i), j);
        }

        private DealsAdapterForwardingDataSetObserver()
        {
            this$0 = GetawaysRecyclerViewAdapter.this;
            super();
        }

    }

    private class WidgetAdapterForwardingDataSetObserver extends android.support.v7.widget.RecyclerView.AdapterDataObserver
    {

        final GetawaysRecyclerViewAdapter this$0;

        public void onChanged()
        {
            notifyDataSetChanged();
        }

        private WidgetAdapterForwardingDataSetObserver()
        {
            this$0 = GetawaysRecyclerViewAdapter.this;
            super();
        }

    }

    public static class WidgetViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder
    {

        RecyclerView recyclerView;

        public WidgetViewHolder(View view)
        {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


    private final DealsRecyclerViewAdapter dealsAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private final GetawaysWidgetRecyclerViewAdapter widgetViewAdapter;

    public GetawaysRecyclerViewAdapter(DealsRecyclerViewAdapter dealsrecyclerviewadapter, GetawaysWidgetRecyclerViewAdapter getawayswidgetrecyclerviewadapter)
    {
        dealsAdapter = dealsrecyclerviewadapter;
        dealsAdapter.registerAdapterDataObserver(new DealsAdapterForwardingDataSetObserver());
        widgetViewAdapter = getawayswidgetrecyclerviewadapter;
        if (getawayswidgetrecyclerviewadapter != null)
        {
            widgetViewAdapter.registerAdapterDataObserver(new WidgetAdapterForwardingDataSetObserver());
        }
    }

    private boolean isWidgetVisible()
    {
        return widgetViewAdapter != null && widgetViewAdapter.getItemCount() > 0;
    }

    public int dealPositionToRealPosition(int i)
    {
        int j;
        if (isWidgetVisible())
        {
            j = 1;
        } else
        {
            j = 0;
        }
        return j + i;
    }

    public int getItemCount()
    {
        int j = dealsAdapter.getItemCount();
        int i;
        if (isWidgetVisible())
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
        if (isWidget(i))
        {
            return 0x7f0300f9;
        } else
        {
            return dealsAdapter.getItemViewType(realPositionToDealPosition(i));
        }
    }

    public boolean isWidget(int i)
    {
        return i == 0 && isWidgetVisible();
    }

    public void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewholder, int i)
    {
        if (!isWidget(i))
        {
            dealsAdapter.onBindViewHolder((DealsRecyclerViewAdapter.DealCardViewHolder)viewholder, realPositionToDealPosition(i));
        }
    }

    public android.support.v7.widget.RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i)
    {
        if (i == 0x7f0300f9)
        {
            WidgetViewHolder widgetviewholder = new WidgetViewHolder(LayoutInflater.from(viewgroup.getContext()).inflate(0x7f0300f9, viewgroup, false));
            viewgroup = new LinearLayoutManager(viewgroup.getContext(), 0, false);
            widgetviewholder.recyclerView.setLayoutManager(viewgroup);
            widgetviewholder.recyclerView.setAdapter(widgetViewAdapter);
            widgetviewholder.recyclerView.setOnScrollListener(new android.support.v7.widget.RecyclerView.OnScrollListener() {

                final GetawaysRecyclerViewAdapter this$0;

                public void onScrollStateChanged(RecyclerView recyclerview, int j)
                {
                    if (swipeRefreshLayout != null && !swipeRefreshLayout.isRefreshing())
                    {
                        SwipeRefreshLayout swiperefreshlayout = swipeRefreshLayout;
                        boolean flag;
                        if (j == 0)
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        swiperefreshlayout.setEnabled(flag);
                    }
                    super.onScrollStateChanged(recyclerview, j);
                }

            
            {
                this$0 = GetawaysRecyclerViewAdapter.this;
                super();
            }
            });
            return widgetviewholder;
        } else
        {
            return dealsAdapter.onCreateViewHolder(viewgroup, i);
        }
    }

    public int realPositionToDealPosition(int i)
    {
        int j;
        if (isWidgetVisible())
        {
            j = 1;
        } else
        {
            j = 0;
        }
        return i - j;
    }

    public void setSwipeRefreshLayout(SwipeRefreshLayout swiperefreshlayout)
    {
        swipeRefreshLayout = swiperefreshlayout;
    }

}
