// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.view.viewpagerindicator;

import android.database.DataSetObserver;

// Referenced classes of package com.picsart.studio.view.viewpagerindicator:
//            VerticalViewPager

final class h extends DataSetObserver
{

    private VerticalViewPager a;

    private h(VerticalViewPager verticalviewpager)
    {
        a = verticalviewpager;
        super();
    }

    h(VerticalViewPager verticalviewpager, byte byte0)
    {
        this(verticalviewpager);
    }

    public final void onChanged()
    {
        a.b();
    }

    public final void onInvalidated()
    {
        a.b();
    }
}
