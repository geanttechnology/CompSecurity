// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.account;

import com.google.a.a.e;
import com.target.mothership.model.store.interfaces.Store;
import com.target.ui.e.i;
import com.target.ui.l.a;
import com.target.ui.service.k;

class c
    implements com.target.ui.view.account.SettingsView.a
{

    private a mUserPreferenceService;
    private i mVlcManagerWrapper;

    public c(a a1, i j)
    {
        mUserPreferenceService = a1;
        mVlcManagerWrapper = j;
    }

    public void a(boolean flag)
    {
        mUserPreferenceService.a(flag);
    }

    public void b(boolean flag)
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
}
