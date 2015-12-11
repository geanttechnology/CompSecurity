// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.timessquare;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;

// Referenced classes of package com.squareup.timessquare:
//            CalendarPickerView, MonthView, MonthDescriptor

private class <init> extends BaseAdapter
{

    private final LayoutInflater inflater;
    final CalendarPickerView this$0;

    public int getCount()
    {
        return months.size();
    }

    public Object getItem(int i)
    {
        return months.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        view = (MonthView)view;
        if (view == null)
        {
            view = MonthView.create(viewgroup, inflater, CalendarPickerView.access$600(CalendarPickerView.this), listener, today, CalendarPickerView.access$1500(CalendarPickerView.this), CalendarPickerView.access$1600(CalendarPickerView.this), CalendarPickerView.access$1700(CalendarPickerView.this), CalendarPickerView.access$1800(CalendarPickerView.this), CalendarPickerView.access$1900(CalendarPickerView.this), CalendarPickerView.access$2000(CalendarPickerView.this), CalendarPickerView.access$2100(CalendarPickerView.this), CalendarPickerView.access$500(CalendarPickerView.this));
        } else
        {
            view.setDecorators(CalendarPickerView.access$2100(CalendarPickerView.this));
        }
        view.init((MonthDescriptor)months.get(i), (List)CalendarPickerView.access$2200(CalendarPickerView.this).get(i), CalendarPickerView.access$700(CalendarPickerView.this), CalendarPickerView.access$2300(CalendarPickerView.this), CalendarPickerView.access$2400(CalendarPickerView.this));
        return view;
    }

    public boolean isEnabled(int i)
    {
        return false;
    }

    private ()
    {
        this$0 = CalendarPickerView.this;
        super();
        inflater = LayoutInflater.from(getContext());
    }

    inflater(inflater inflater1)
    {
        this();
    }
}
