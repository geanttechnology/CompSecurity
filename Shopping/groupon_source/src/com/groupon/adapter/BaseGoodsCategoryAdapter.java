// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import com.groupon.adapter.listener.OnCategoryImpressionEventListener;
import java.util.List;

public abstract class BaseGoodsCategoryAdapter extends android.support.v7.widget.RecyclerView.Adapter
{

    protected LayoutInflater inflater;
    protected List items;
    protected OnCategoryImpressionEventListener onImpressionEventListener;

    public BaseGoodsCategoryAdapter(Context context, List list)
    {
        items = list;
        inflater = LayoutInflater.from(context);
    }

    public List getItems()
    {
        return items;
    }

    public void setOnImpressionEventListener(OnCategoryImpressionEventListener oncategoryimpressioneventlistener)
    {
        onImpressionEventListener = oncategoryimpressioneventlistener;
    }
}
