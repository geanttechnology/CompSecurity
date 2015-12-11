// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.store.location.b;

import android.view.Menu;
import android.view.MenuInflater;
import com.google.a.a.e;
import com.target.mothership.model.store.interfaces.Store;
import com.target.ui.e.i;
import com.target.ui.service.k;

public class a
    implements com.target.ui.g.a
{

    private com.target.ui.fragment.store.location.a.a mPresentation;
    private com.target.ui.l.a mUserPreferenceService;
    private i mVlcManagerWrapper;

    public a(com.target.ui.l.a a1, i j)
    {
        mUserPreferenceService = a1;
        mVlcManagerWrapper = j;
    }

    public void a(Menu menu, MenuInflater menuinflater)
    {
    }

    public void a(com.target.ui.fragment.store.location.a.a a1)
    {
        mPresentation = a1;
        mPresentation.a(mUserPreferenceService.c());
    }

    public volatile void a(Object obj)
    {
        a((com.target.ui.fragment.store.location.a.a)obj);
    }

    public void a(boolean flag)
    {
        mUserPreferenceService.a(Boolean.valueOf(flag));
        if (flag)
        {
            e e1 = k.a().c();
            if (e1.b())
            {
                mVlcManagerWrapper.a((Store)e1.c());
            }
            return;
        } else
        {
            mVlcManagerWrapper.a();
            return;
        }
    }

    public void c()
    {
        mPresentation.dismiss();
    }

    public void v_()
    {
    }

    public void z_()
    {
    }
}
