// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.product;

import com.google.a.a.e;
import com.target.ui.adapter.product.a.a;
import com.target.ui.common.ProductErrorHeaderOptions;
import com.target.ui.common.ProductHeaderOptions;
import com.target.ui.view.product.PlpFooterView;
import java.lang.ref.WeakReference;

public abstract class g extends a
{

    private ProductHeaderOptions mDisplayOptions;
    private ProductErrorHeaderOptions mErrorHeaderOptions;
    private WeakReference mFooterViewReference;
    private boolean mShowFooter;
    private boolean mShowHeader;

    public g()
    {
        mShowHeader = false;
        mShowFooter = false;
    }

    private void a(boolean flag, boolean flag1)
    {
        if (mShowHeader == flag && !flag1)
        {
            return;
        } else
        {
            mShowHeader = flag;
            d();
            return;
        }
    }

    public final void a(ProductErrorHeaderOptions producterrorheaderoptions)
    {
        mErrorHeaderOptions = producterrorheaderoptions;
        mDisplayOptions = null;
        if (producterrorheaderoptions == null)
        {
            b(false);
            return;
        } else
        {
            a(true, true);
            return;
        }
    }

    public final void a(ProductHeaderOptions productheaderoptions)
    {
        mDisplayOptions = productheaderoptions;
        mErrorHeaderOptions = null;
        if (productheaderoptions == null)
        {
            b(false);
            return;
        } else
        {
            a(true, true);
            return;
        }
    }

    protected final void a(PlpFooterView plpfooterview)
    {
        mFooterViewReference = new WeakReference(plpfooterview);
    }

    public final void b(boolean flag)
    {
        a(flag, false);
    }

    public final void c(boolean flag)
    {
        if (mShowFooter == flag)
        {
            return;
        } else
        {
            mShowFooter = flag;
            d();
            return;
        }
    }

    public final void d(boolean flag)
    {
        if (!mShowFooter || mFooterViewReference == null || mFooterViewReference.get() == null)
        {
            return;
        } else
        {
            ((PlpFooterView)mFooterViewReference.get()).a(flag);
            return;
        }
    }

    protected final boolean e()
    {
        return mShowHeader;
    }

    protected final boolean f()
    {
        return mShowFooter;
    }

    protected final e k()
    {
        return com.google.a.a.e.c(mErrorHeaderOptions);
    }

    protected final e l()
    {
        return com.google.a.a.e.c(mDisplayOptions);
    }

    public boolean m()
    {
        return mShowHeader && mErrorHeaderOptions != null;
    }

    public boolean n()
    {
        return mShowHeader && mDisplayOptions != null;
    }
}
