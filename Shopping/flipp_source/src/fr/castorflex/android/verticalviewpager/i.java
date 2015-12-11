// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package fr.castorflex.android.verticalviewpager;

import android.database.DataSetObserver;

// Referenced classes of package fr.castorflex.android.verticalviewpager:
//            VerticalViewPager

final class i extends DataSetObserver
{

    final VerticalViewPager a;

    private i(VerticalViewPager verticalviewpager)
    {
        a = verticalviewpager;
        super();
    }

    i(VerticalViewPager verticalviewpager, byte byte0)
    {
        this(verticalviewpager);
    }

    public final void onChanged()
    {
        a.a();
    }

    public final void onInvalidated()
    {
        a.a();
    }
}
