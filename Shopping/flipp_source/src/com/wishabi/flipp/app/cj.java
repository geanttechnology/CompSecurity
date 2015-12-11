// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.h;

// Referenced classes of package com.wishabi.flipp.app:
//            do, HelpActivity, cm, cn

final class cj extends h
{

    final HelpActivity b;

    cj(HelpActivity helpactivity, FragmentManager fragmentmanager)
    {
        b = helpactivity;
        super(fragmentmanager);
    }

    public final Fragment a(int i)
    {
        int ai[] = do.a.b();
        if (i < HelpActivity.a(b).length)
        {
            return cm.a(ai[i], HelpActivity.a(b)[i]);
        }
        HelpActivity.a(b, new cn());
        HelpActivity.c(b).a = HelpActivity.b(b);
        if (HelpActivity.d(b) != null)
        {
            HelpActivity.c(b).b = HelpActivity.d(b);
        }
        return HelpActivity.c(b);
    }

    public final int c()
    {
        return HelpActivity.a(b).length + 1;
    }
}
