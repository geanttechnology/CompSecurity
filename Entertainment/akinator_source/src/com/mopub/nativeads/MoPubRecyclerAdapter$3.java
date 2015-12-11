// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;


// Referenced classes of package com.mopub.nativeads:
//            MoPubRecyclerAdapter, MoPubStreamAdPlacer

class terDataObserver extends android.support.v7.widget.aObserver
{

    final MoPubRecyclerAdapter this$0;

    public void onChanged()
    {
        MoPubRecyclerAdapter.access$200(MoPubRecyclerAdapter.this).setItemCount(MoPubRecyclerAdapter.access$100(MoPubRecyclerAdapter.this).tItemCount());
        notifyDataSetChanged();
    }

    public void onItemRangeChanged(int i, int j)
    {
        j = MoPubRecyclerAdapter.access$200(MoPubRecyclerAdapter.this).getAdjustedPosition((i + j) - 1);
        i = MoPubRecyclerAdapter.access$200(MoPubRecyclerAdapter.this).getAdjustedPosition(i);
        notifyItemRangeChanged(i, (j - i) + 1);
    }

    public void onItemRangeInserted(int i, int j)
    {
        int i1 = MoPubRecyclerAdapter.access$200(MoPubRecyclerAdapter.this).getAdjustedPosition(i);
        int k = MoPubRecyclerAdapter.access$100(MoPubRecyclerAdapter.this).tItemCount();
        MoPubRecyclerAdapter.access$200(MoPubRecyclerAdapter.this).setItemCount(k);
        if (i + j >= k)
        {
            k = 1;
        } else
        {
            k = 0;
        }
        if (ntentChangeStrategy.KEEP_ADS_FIXED == MoPubRecyclerAdapter.access$300(MoPubRecyclerAdapter.this) || ntentChangeStrategy.INSERT_AT_END == MoPubRecyclerAdapter.access$300(MoPubRecyclerAdapter.this) && k)
        {
            notifyDataSetChanged();
            return;
        }
        for (int l = 0; l < j; l++)
        {
            MoPubRecyclerAdapter.access$200(MoPubRecyclerAdapter.this).insertItem(i);
        }

        notifyItemRangeInserted(i1, j);
    }

    public void onItemRangeMoved(int i, int j, int k)
    {
        notifyDataSetChanged();
    }

    public void onItemRangeRemoved(int i, int j)
    {
        int l = MoPubRecyclerAdapter.access$200(MoPubRecyclerAdapter.this).getAdjustedPosition(i);
        int i1 = MoPubRecyclerAdapter.access$100(MoPubRecyclerAdapter.this).tItemCount();
        MoPubRecyclerAdapter.access$200(MoPubRecyclerAdapter.this).setItemCount(i1);
        boolean flag;
        if (i + j >= i1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (ntentChangeStrategy.KEEP_ADS_FIXED == MoPubRecyclerAdapter.access$300(MoPubRecyclerAdapter.this) || ntentChangeStrategy.INSERT_AT_END == MoPubRecyclerAdapter.access$300(MoPubRecyclerAdapter.this) && flag)
        {
            notifyDataSetChanged();
            return;
        }
        int j1 = MoPubRecyclerAdapter.access$200(MoPubRecyclerAdapter.this).getAdjustedCount(i1 + j);
        for (int k = 0; k < j; k++)
        {
            MoPubRecyclerAdapter.access$200(MoPubRecyclerAdapter.this).removeItem(i);
        }

        i = j1 - MoPubRecyclerAdapter.access$200(MoPubRecyclerAdapter.this).getAdjustedCount(i1);
        notifyItemRangeRemoved(l - (i - j), i);
    }

    ntentChangeStrategy()
    {
        this$0 = MoPubRecyclerAdapter.this;
        super();
    }
}
