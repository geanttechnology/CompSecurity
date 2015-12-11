// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.support.v4.e.a;
import android.view.ViewGroup;
import java.util.List;

// Referenced classes of package android.support.v7.widget:
//            RecyclerView

public abstract class mHasStableIds
{

    private boolean mHasStableIds;
    private final ataObservable mObservable = new ataObservable();

    public final void bindViewHolder(er er, int i)
    {
        er.mPosition = i;
        if (hasStableIds())
        {
            er.mItemId = getItemId(i);
        }
        er.setFlags(1, 519);
        a.c("RV OnBindView");
        onBindViewHolder(er, i, er.getUnmodifiedPayloads());
        er.clearPayload();
        a.l();
    }

    public final er createViewHolder(ViewGroup viewgroup, int i)
    {
        a.c("RV CreateView");
        viewgroup = onCreateViewHolder(viewgroup, i);
        viewgroup.mItemViewType = i;
        a.l();
        return viewgroup;
    }

    public abstract int getItemCount();

    public long getItemId(int i)
    {
        return -1L;
    }

    public int getItemViewType(int i)
    {
        return 0;
    }

    public final boolean hasStableIds()
    {
        return mHasStableIds;
    }

    public final void notifyDataSetChanged()
    {
        mObservable.notifyChanged();
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerview)
    {
    }

    public abstract void onBindViewHolder(er er, int i);

    public void onBindViewHolder(er er, int i, List list)
    {
        onBindViewHolder(er, i);
    }

    public abstract er onCreateViewHolder(ViewGroup viewgroup, int i);

    public void onDetachedFromRecyclerView(RecyclerView recyclerview)
    {
    }

    public boolean onFailedToRecycleView(er er)
    {
        return false;
    }

    public void onViewAttachedToWindow(er er)
    {
    }

    public void onViewDetachedFromWindow(er er)
    {
    }

    public void onViewRecycled(er er)
    {
    }

    public void registerAdapterDataObserver(ataObserver ataobserver)
    {
        mObservable.registerObserver(ataobserver);
    }

    public void unregisterAdapterDataObserver(ataObserver ataobserver)
    {
        mObservable.unregisterObserver(ataobserver);
    }

    public ataObserver()
    {
        mHasStableIds = false;
    }
}
