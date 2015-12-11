// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.foound.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Adapter;
import android.widget.ListAdapter;
import android.widget.ListView;

// Referenced classes of package com.foound.widget:
//            b, a

public class AmazingListView extends ListView
    implements b
{

    public static final String a = com/foound/widget/AmazingListView.getSimpleName();
    View b;
    boolean c;
    private View d;
    private boolean e;
    private int f;
    private int g;
    private a h;

    public AmazingListView(Context context)
    {
        super(context);
        c = false;
    }

    public AmazingListView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        c = false;
    }

    public AmazingListView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        c = false;
    }

    public void a(int i)
    {
        setSelection(h.getPositionForSection(i));
    }

    public String b(int i)
    {
        Object aobj[] = h.getSections();
        if (aobj.length >= i)
        {
            return aobj[i].toString();
        } else
        {
            return null;
        }
    }

    public void c(int i)
    {
        int j = 255;
        if (d != null)
        {
            View view;
            switch (h.a(i))
            {
            default:
                return;

            case 0: // '\0'
                e = false;
                return;

            case 1: // '\001'
                h.a(d, i, 255);
                if (d.getTop() != 0)
                {
                    d.layout(0, 0, f, g);
                }
                e = true;
                return;

            case 2: // '\002'
                view = getChildAt(0);
                break;
            }
            if (view != null)
            {
                int k = view.getBottom();
                int l = d.getHeight();
                if (k < l)
                {
                    k -= l;
                    j = ((l + k) * 255) / l;
                } else
                {
                    k = 0;
                }
                h.a(d, i, j);
                if (d.getTop() != k)
                {
                    d.layout(0, k, f, g + k);
                }
                e = true;
                return;
            }
        }
    }

    protected void dispatchDraw(Canvas canvas)
    {
        super.dispatchDraw(canvas);
        if (e)
        {
            drawChild(canvas, d, getDrawingTime());
        }
    }

    public volatile Adapter getAdapter()
    {
        return getAdapter();
    }

    public volatile ListAdapter getAdapter()
    {
        return getAdapter();
    }

    public a getAdapter()
    {
        return h;
    }

    public View getLoadingView()
    {
        return b;
    }

    public int getSectionCount()
    {
        return h.getSections().length;
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        if (d != null)
        {
            d.layout(0, 0, f, g);
            c(getFirstVisiblePosition());
        }
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        if (d != null)
        {
            measureChild(d, i, j);
            f = d.getMeasuredWidth();
            g = d.getMeasuredHeight();
        }
    }

    public volatile void setAdapter(Adapter adapter)
    {
        setAdapter((ListAdapter)adapter);
    }

    public void setAdapter(ListAdapter listadapter)
    {
        if (!(listadapter instanceof a))
        {
            throw new IllegalArgumentException((new StringBuilder()).append(com/foound/widget/AmazingListView.getSimpleName()).append(" must use adapter of type ").append(com/foound/widget/a.getSimpleName()).toString());
        }
        if (h != null)
        {
            h.a(null);
            setOnScrollListener(null);
        }
        h = (a)listadapter;
        ((a)listadapter).a(this);
        setOnScrollListener((a)listadapter);
        View view = new View(getContext());
        super.addFooterView(view);
        super.setAdapter(listadapter);
        super.removeFooterView(view);
    }

    public void setLoadingView(View view)
    {
        b = view;
    }

    public void setPinnedHeaderView(View view)
    {
        d = view;
        if (d != null)
        {
            setFadingEdgeLength(0);
        }
        requestLayout();
    }

}
