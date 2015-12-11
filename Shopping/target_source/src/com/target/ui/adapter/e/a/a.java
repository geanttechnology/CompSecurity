// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.e.a;

import android.view.View;
import android.view.ViewGroup;
import com.target.ui.view.product.PlpFooterView;
import java.lang.ref.WeakReference;

public abstract class a extends com.target.ui.adapter.b.a
{

    private WeakReference mFooterViewReference;
    private boolean mShowFooter;
    private boolean mShowFooterRetry;

    public a()
    {
        mShowFooter = false;
        mShowFooterRetry = false;
    }

    protected final void a(PlpFooterView plpfooterview)
    {
        mFooterViewReference = new WeakReference(plpfooterview);
    }

    protected View b(ViewGroup viewgroup)
    {
        return null;
    }

    public void b(boolean flag)
    {
        if (mShowFooter == flag && !mShowFooterRetry)
        {
            return;
        } else
        {
            mShowFooter = flag;
            mShowFooterRetry = false;
            d();
            return;
        }
    }

    public final void c(boolean flag)
    {
        if (mShowFooter != flag || !mShowFooterRetry)
        {
            mShowFooter = flag;
            mShowFooterRetry = true;
            if (mFooterViewReference != null && mFooterViewReference.get() != null)
            {
                ((PlpFooterView)mFooterViewReference.get()).a(flag);
                return;
            }
        }
    }

    protected void d(android.support.v7.widget.RecyclerView.t t, int i)
    {
    }

    protected boolean e()
    {
        return false;
    }

    protected final boolean f()
    {
        return mShowFooter;
    }
}
