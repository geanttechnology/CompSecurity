// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.navigation.a;

import android.view.Menu;
import android.view.MenuInflater;

public class a
    implements com.target.ui.g.a, com.target.ui.helper.i.a, com.target.ui.helper.i.b
{

    private com.target.ui.helper.i.a mHelpshiftDataHelper;
    private com.target.ui.fragment.navigation.b.a mPresentation;

    public a(com.target.ui.helper.i.a a1)
    {
        mHelpshiftDataHelper = a1;
    }

    private void c(int i)
    {
        if (i > 0)
        {
            mPresentation.a(i);
            return;
        } else
        {
            mPresentation.a();
            return;
        }
    }

    private void h()
    {
        mPresentation.f();
        mPresentation.d();
    }

    public void a(int i)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            c(i);
            return;
        }
    }

    public void a(Menu menu, MenuInflater menuinflater)
    {
    }

    public void a(com.target.ui.fragment.navigation.b.a a1)
    {
        mPresentation = a1;
    }

    public volatile void a(Object obj)
    {
        a((com.target.ui.fragment.navigation.b.a)obj);
    }

    public void b(int i)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            c(i);
            return;
        }
    }

    public void c()
    {
        mHelpshiftDataHelper.a(this);
        mHelpshiftDataHelper.a(this);
    }

    public void d()
    {
    }

    public void e()
    {
        h();
    }

    public void f()
    {
        mPresentation.f();
        mPresentation.c();
    }

    public void g()
    {
        h();
    }

    public void v_()
    {
        mHelpshiftDataHelper.a(null);
    }

    public void z_()
    {
        mPresentation = null;
    }
}
