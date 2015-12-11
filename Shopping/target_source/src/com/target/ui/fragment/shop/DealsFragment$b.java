// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.shop;

import com.target.mothership.model.list.interfaces.ListSummary;
import com.target.ui.c.b.e;
import com.target.ui.util.ad;
import com.target.ui.view.common.h;

// Referenced classes of package com.target.ui.fragment.shop:
//            DealsFragment

private class <init> extends e
{

    final DealsFragment this$0;

    public void a(String s)
    {
        DealsFragment.a(DealsFragment.this).c(s);
    }

    public void a(String s, ListSummary listsummary)
    {
        ad.a(getActivity(), s, DealsFragment.a(DealsFragment.this), listsummary, m());
    }

    private ListSummary()
    {
        this$0 = DealsFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
