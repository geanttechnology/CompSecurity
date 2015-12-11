// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.aq;

import android.support.v4.view.ViewPager;
import com.shazam.android.a.a;
import com.shazam.android.base.fragments.BaseFragment;
import com.shazam.model.Provider;

public final class r
    implements Provider
{

    private final ViewPager a;
    private final a b;

    public r(ViewPager viewpager, a a1)
    {
        a = viewpager;
        b = a1;
    }

    public final Object a()
    {
        int i = a.getCurrentItem();
        return (BaseFragment)b.c(i);
    }
}
