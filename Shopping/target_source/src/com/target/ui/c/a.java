// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.c;

import android.app.Activity;
import android.content.res.Resources;
import android.support.v4.app.h;
import com.target.ui.f.c;
import com.target.ui.fragment.common.BaseNavigationFragment;

public abstract class a
{

    private static final String INVALID_PROVIDER_FORMAT = "Fragment does not provide correct %s. Please check the BaseNavigationFragmentDelegate subclass you are using for details.";
    private BaseNavigationFragment mFragment;

    public a(BaseNavigationFragment basenavigationfragment)
    {
        mFragment = basenavigationfragment;
    }

    private void a(String s)
    {
        if (b() == null)
        {
            throw new IllegalStateException(String.format("Cannot call method %s after calling onDestroy()", new Object[] {
                s
            }));
        } else
        {
            return;
        }
    }

    protected Activity a()
    {
        a("getActivity");
        return b().getActivity();
    }

    protected void a(Object obj, Object obj1, String s)
    {
        if (obj != obj1)
        {
            throw new IllegalStateException(String.format("Fragment does not provide correct %s. Please check the BaseNavigationFragmentDelegate subclass you are using for details.", new Object[] {
                s
            }));
        } else
        {
            return;
        }
    }

    protected BaseNavigationFragment b()
    {
        return mFragment;
    }

    protected h c()
    {
        a("getFragmentManager");
        return b().getFragmentManager();
    }

    protected c d()
    {
        a("getNavigationFragmentManager");
        return b().m();
    }

    protected Resources e()
    {
        a("getResources");
        return b().getResources();
    }

    public void f()
    {
    }

    public void g()
    {
    }

    public void h()
    {
    }

    public void i()
    {
        mFragment = null;
    }

    protected boolean j()
    {
        a("onSavedInstanceStateCalled");
        return b().Z();
    }
}
