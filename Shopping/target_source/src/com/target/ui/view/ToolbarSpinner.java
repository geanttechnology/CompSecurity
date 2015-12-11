// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.j;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import com.target.ui.adapter.h.c;
import java.util.ArrayList;
import java.util.List;

public class ToolbarSpinner extends j
{
    public static interface a
    {

        public abstract void a(int i);
    }


    private c mAdapter;
    private List mItems;
    private a mListener;

    public ToolbarSpinner(Context context)
    {
        super(context);
        mItems = new ArrayList();
        a();
    }

    public ToolbarSpinner(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mItems = new ArrayList();
        a();
    }

    public ToolbarSpinner(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mItems = new ArrayList();
        a();
    }

    static a a(ToolbarSpinner toolbarspinner)
    {
        return toolbarspinner.mListener;
    }

    private void a()
    {
        mAdapter = new c(getContext(), mItems);
        setAdapter(mAdapter);
        TypedValue typedvalue = new TypedValue();
        if (com.target.ui.util.j.a() && !com.target.ui.util.j.b() && getContext().getTheme().resolveAttribute(0x10102eb, typedvalue, true))
        {
            setDropDownVerticalOffset(-TypedValue.complexToDimensionPixelSize(typedvalue.data, getResources().getDisplayMetrics()));
        }
        setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {

            final ToolbarSpinner this$0;

            public void onItemSelected(AdapterView adapterview, View view, int i, long l)
            {
                if (ToolbarSpinner.a(ToolbarSpinner.this) != null)
                {
                    ToolbarSpinner.a(ToolbarSpinner.this).a(i);
                }
            }

            public void onNothingSelected(AdapterView adapterview)
            {
            }

            
            {
                this$0 = ToolbarSpinner.this;
                super();
            }
        });
    }

    public void setItems(List list)
    {
        mItems.clear();
        mItems.addAll(list);
        mAdapter.notifyDataSetChanged();
    }

    public void setListener(a a1)
    {
        mListener = a1;
    }

    public void setSelectedItem(int i)
    {
        setSelection(i);
    }
}
