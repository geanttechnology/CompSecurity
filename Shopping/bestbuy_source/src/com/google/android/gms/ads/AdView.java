// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import ol;
import om;
import oo;
import pg;
import pi;
import ub;

public final class AdView extends ViewGroup
{

    private final ub a;

    public AdView(Context context)
    {
        super(context);
        a = new ub(this);
    }

    public AdView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = new ub(this, attributeset, false);
    }

    public AdView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a = new ub(this, attributeset, false);
    }

    public void a()
    {
        a.a();
    }

    public void a(om om1)
    {
        a.a(om1.a());
    }

    public oo b()
    {
        return a.b();
    }

    public void c()
    {
        a.c();
    }

    public void d()
    {
        a.d();
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        View view = getChildAt(0);
        if (view != null && view.getVisibility() != 8)
        {
            int i1 = view.getMeasuredWidth();
            int j1 = view.getMeasuredHeight();
            i = (k - i - i1) / 2;
            j = (l - j - j1) / 2;
            view.layout(i, j, i1 + i, j1 + j);
        }
    }

    protected void onMeasure(int i, int j)
    {
        int k = 0;
        View view = getChildAt(0);
        oo oo1 = b();
        int l;
        if (view != null && view.getVisibility() != 8)
        {
            measureChild(view, i, j);
            l = view.getMeasuredWidth();
            k = view.getMeasuredHeight();
        } else
        if (oo1 != null)
        {
            Context context = getContext();
            l = oo1.b(context);
            k = oo1.a(context);
        } else
        {
            l = 0;
        }
        l = Math.max(l, getSuggestedMinimumWidth());
        k = Math.max(k, getSuggestedMinimumHeight());
        setMeasuredDimension(View.resolveSize(l, i), View.resolveSize(k, j));
    }

    public void setAdListener(ol ol)
    {
        a.a(ol);
    }

    public void setAdSize(oo oo1)
    {
        a.a(new oo[] {
            oo1
        });
    }

    public void setAdUnitId(String s)
    {
        a.a(s);
    }

    public void setInAppPurchaseListener(pg pg)
    {
        a.a(pg);
    }

    public void setPlayStorePurchaseParams(pi pi, String s)
    {
        a.a(pi, s);
    }
}
