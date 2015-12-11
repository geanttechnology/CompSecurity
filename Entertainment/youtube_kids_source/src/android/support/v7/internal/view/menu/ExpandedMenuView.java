// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import bn;
import gu;
import gv;
import ib;

public final class ExpandedMenuView extends ListView
    implements android.widget.AdapterView.OnItemClickListener, bn, gu
{

    private static final int a[] = {
        0x10100d4, 0x1010129
    };

    public ExpandedMenuView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0x1010074);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset);
        setOnItemClickListener(this);
        context = ib.a(context, attributeset, a, i, 0);
        if (context.c(0))
        {
            setBackgroundDrawable(context.a(0));
        }
        if (context.c(1))
        {
            setDivider(context.a(1));
        }
        ((ib) (context)).a.recycle();
    }

    public final boolean a(gv gv1)
    {
        throw new NullPointerException();
    }

    protected final void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    public final void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (gv)getAdapter().getItem(i);
        throw new NullPointerException();
    }

}
