// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.getaways.carousel;


// Referenced classes of package com.groupon.getaways.carousel:
//            EndlessRecyclerViewAdapter

private class <init> extends android.support.v7.widget.ver
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

    private ()
    {
        this$0 = EndlessRecyclerViewAdapter.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
