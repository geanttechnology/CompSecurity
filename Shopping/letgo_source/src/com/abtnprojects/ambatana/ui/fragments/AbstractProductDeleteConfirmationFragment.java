// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.fragments;

import android.app.Activity;
import android.support.v4.app.f;

public class AbstractProductDeleteConfirmationFragment extends f
{
    public static interface a
    {

        public abstract void d(String s);

        public abstract void l();
    }


    protected a aj;

    public AbstractProductDeleteConfirmationFragment()
    {
    }

    public void a(Activity activity)
    {
        super.a(activity);
        if (activity instanceof a)
        {
            aj = (a)activity;
            return;
        } else
        {
            throw new IllegalArgumentException("Activity must implement OnProductDeleteConfirmationListener");
        }
    }

    public void d()
    {
        super.d();
        aj = null;
    }

    void onCancelClicked()
    {
        a();
    }

    void onDeleteClicked()
    {
        a();
        if (aj != null)
        {
            aj.l();
        }
    }
}
