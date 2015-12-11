// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.product.a;

import android.view.View;
import android.view.ViewGroup;

public abstract class a extends com.target.ui.adapter.b.a
{

    public static final int DVM_ITEM = 201;
    public static final int PRODUCT_ITEM = 200;

    public a()
    {
    }

    protected View a(ViewGroup viewgroup)
    {
        return null;
    }

    protected final View c(ViewGroup viewgroup, int k)
    {
        switch (k)
        {
        default:
            return null;

        case 201: 
            return f(viewgroup);

        case 200: 
            return e(viewgroup);
        }
    }

    protected void c(android.support.v7.widget.RecyclerView.t t, int k)
    {
    }

    protected abstract View e(ViewGroup viewgroup);

    protected long f(int k)
    {
        return 0L;
    }

    protected View f(ViewGroup viewgroup)
    {
        return null;
    }

    protected final void f(android.support.v7.widget.RecyclerView.t t, int k)
    {
        switch (g(k))
        {
        default:
            return;

        case 201: 
            i(t, k);
            return;

        case 200: 
            h(t, k);
            return;
        }
    }

    protected final int g()
    {
        return i();
    }

    protected final int g(int k)
    {
        return !i(k) || !j() ? 200 : 201;
    }

    protected abstract void h(android.support.v7.widget.RecyclerView.t t, int k);

    protected abstract int i();

    protected void i(android.support.v7.widget.RecyclerView.t t, int k)
    {
    }

    protected boolean i(int k)
    {
        return false;
    }

    protected boolean j()
    {
        return false;
    }
}
