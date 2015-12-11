// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.coach_mark.b;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import com.google.a.a.e;
import com.target.mothership.model.store.interfaces.RelevantStoreSummary;
import com.target.ui.service.provider.q;

public class a
    implements android.content.DialogInterface.OnKeyListener, com.target.ui.g.a
{

    private boolean mIsAnimatingExit;
    private float mNavigationDrawerWidth;
    private com.target.ui.fragment.coach_mark.a.a mPresentation;
    private q mRelevantStoreProvider;

    public a(q q1, float f)
    {
        mIsAnimatingExit = false;
        mRelevantStoreProvider = q1;
        mNavigationDrawerWidth = f;
    }

    private void d()
    {
        if (mIsAnimatingExit)
        {
            return;
        } else
        {
            mIsAnimatingExit = true;
            mPresentation.c();
            return;
        }
    }

    public void a(Menu menu, MenuInflater menuinflater)
    {
    }

    public void a(com.target.ui.fragment.coach_mark.a.a a1)
    {
        b(a1);
        mPresentation.a(0.0F);
        mPresentation.b(-mNavigationDrawerWidth);
        mPresentation.a((RelevantStoreSummary)mRelevantStoreProvider.a().d());
        mPresentation.b();
    }

    public volatile void a(Object obj)
    {
        a((com.target.ui.fragment.coach_mark.a.a)obj);
    }

    void b(com.target.ui.fragment.coach_mark.a.a a1)
    {
        mPresentation = a1;
    }

    public void c()
    {
        d();
    }

    public boolean onKey(DialogInterface dialoginterface, int i, KeyEvent keyevent)
    {
        if (i == 4 && keyevent.getAction() == 0)
        {
            d();
            return true;
        } else
        {
            return false;
        }
    }

    public void v_()
    {
    }

    public void z_()
    {
        mPresentation = null;
    }
}
