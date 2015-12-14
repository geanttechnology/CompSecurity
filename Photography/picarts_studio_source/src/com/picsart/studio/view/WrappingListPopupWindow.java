// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListPopupWindow;

// Referenced classes of package com.picsart.studio.view:
//            p

public class WrappingListPopupWindow extends ListPopupWindow
    implements android.widget.AdapterView.OnItemClickListener
{

    private Context a;
    private android.widget.AdapterView.OnItemClickListener b;

    public WrappingListPopupWindow(Context context)
    {
        this(context, null);
    }

    public WrappingListPopupWindow(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0x10102ff);
    }

    public WrappingListPopupWindow(Context context, AttributeSet attributeset, int i)
    {
        this(context, attributeset, i, 0);
    }

    public WrappingListPopupWindow(Context context, AttributeSet attributeset, int i, int j)
    {
        super(context, attributeset, i, j);
        a = context;
        super.setOnItemClickListener(this);
    }

    public static p a(Context context)
    {
        return new p(context, (byte)0);
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (b != null)
        {
            b.onItemClick(adapterview, view, i, l);
        }
        dismiss();
    }

    public void setAdapter(ListAdapter listadapter)
    {
        super.setAdapter(listadapter);
        Object obj = a;
        View view = null;
        obj = new FrameLayout(((Context) (obj)));
        int l = listadapter.getCount();
        int j = 0;
        int i = 0;
        for (; j < l; j++)
        {
            view = listadapter.getView(j, view, ((android.view.ViewGroup) (obj)));
            view.measure(0, 0);
            int k = view.getMeasuredWidth();
            if (k > i)
            {
                i = k;
            }
        }

        setContentWidth(i);
    }

    public void setOnItemClickListener(android.widget.AdapterView.OnItemClickListener onitemclicklistener)
    {
        b = onitemclicklistener;
    }
}
