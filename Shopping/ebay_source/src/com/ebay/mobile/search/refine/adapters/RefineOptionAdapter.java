// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search.refine.adapters;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class RefineOptionAdapter extends ArrayAdapter
{
    class ViewCache
    {

        public int itemIdx;
        public View leftArrow;
        public TextView summaryView;
        final RefineOptionAdapter this$0;
        public TextView titleView;

        ViewCache()
        {
            this$0 = RefineOptionAdapter.this;
            super();
        }
    }


    protected final LayoutInflater inflater;

    public RefineOptionAdapter(Context context, List list)
    {
        super(context, 0, list);
        inflater = LayoutInflater.from(new ContextThemeWrapper(context, 0x7f0a002b));
    }

    public RefineOptionAdapter(Context context, Object aobj[])
    {
        super(context, 0, aobj);
        inflater = LayoutInflater.from(new ContextThemeWrapper(context, 0x7f0a002b));
    }

    protected String getItemTitle(Object obj)
    {
        return obj.toString();
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        Object obj = getItem(i);
        if (view == null)
        {
            view = inflater.inflate(getViewResId(), viewgroup, false);
            viewgroup = new ViewCache();
            viewgroup.titleView = (TextView)view.findViewById(0x7f1005cb);
            viewgroup.summaryView = (TextView)view.findViewById(0x7f1005cc);
            viewgroup.leftArrow = view.findViewById(0x7f1005ca);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ViewCache)view.getTag();
        }
        viewgroup.itemIdx = i;
        ((ViewCache) (viewgroup)).titleView.setText(getItemTitle(obj));
        return view;
    }

    protected int getViewResId()
    {
        return 0x7f0301dc;
    }
}
