// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ad.a;

import android.view.ViewGroup;
import com.shazam.android.widget.bottombar.tagbar.TagBarViewSwitcher;
import com.shazam.android.widget.bottombar.tagbar.a;

// Referenced classes of package com.shazam.android.ad.a:
//            e, g

public final class c extends e
{

    boolean a;
    TagBarViewSwitcher b;

    public c()
    {
        super(com.shazam.i.b.c.a());
        a = false;
    }

    static android.widget.FrameLayout.LayoutParams b()
    {
        android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-1, -2);
        layoutparams.gravity = 80;
        return layoutparams;
    }

    public final void a()
    {
        ViewGroup viewgroup = (ViewGroup)getParent();
        if (viewgroup != null)
        {
            viewgroup.removeView(this);
        }
        a = false;
    }

    public final a getAutoTagMatcherListener()
    {
        return b;
    }

    public final int getCurrentHeight()
    {
        return getMeasuredHeight();
    }

    public final g getTagDetailsViewedListener()
    {
        return b;
    }
}
