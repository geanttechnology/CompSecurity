// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v7.internal.widget.ScrollingTabContainerView;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class di extends BaseAdapter
{

    final ScrollingTabContainerView a;

    private di(ScrollingTabContainerView scrollingtabcontainerview)
    {
        a = scrollingtabcontainerview;
        super();
    }

    public di(ScrollingTabContainerView scrollingtabcontainerview, dh dh)
    {
        this(scrollingtabcontainerview);
    }

    public int getCount()
    {
        return ScrollingTabContainerView.access$200(a).getChildCount();
    }

    public Object getItem(int i)
    {
        return ((dk)ScrollingTabContainerView.access$200(a).getChildAt(i)).b();
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (view == null)
        {
            return ScrollingTabContainerView.access$300(a, (b)getItem(i), true);
        } else
        {
            ((dk)view).a((b)getItem(i));
            return view;
        }
    }
}
