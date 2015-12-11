// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.groupon.view.widgetcards.EndlessListWidgetHeaderCard;

public class DealListHeaderAdapter extends BaseAdapter
{

    private Context context;
    protected boolean enabled;
    private String subtitle;
    private String title;

    public DealListHeaderAdapter(Context context1, String s, String s1)
    {
        context = context1;
        title = s;
        subtitle = s1;
    }

    protected Context getContext()
    {
        return context;
    }

    public int getCount()
    {
        return !enabled ? 0 : 1;
    }

    public Object getItem(int i)
    {
        return null;
    }

    public long getItemId(int i)
    {
        return 0L;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (!reuseView(view))
        {
            view = new EndlessListWidgetHeaderCard(getContext());
        }
        view = (EndlessListWidgetHeaderCard)(EndlessListWidgetHeaderCard)view;
        view.setInfo(title, subtitle);
        return view;
    }

    public boolean reuseView(View view)
    {
        return view != null && (view instanceof EndlessListWidgetHeaderCard);
    }

    public void setHeaderEnabled(boolean flag)
    {
        if (flag == enabled)
        {
            return;
        } else
        {
            enabled = flag;
            notifyDataSetChanged();
            return;
        }
    }
}
