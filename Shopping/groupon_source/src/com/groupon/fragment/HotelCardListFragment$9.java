// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.view.View;
import android.view.ViewTreeObserver;

// Referenced classes of package com.groupon.fragment:
//            HotelCardListFragment

class this._cls0
    implements android.view.lLayoutListener
{

    final HotelCardListFragment this$0;

    public void onGlobalLayout()
    {
        HotelCardListFragment.access$1700(HotelCardListFragment.this);
        getView().getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }

    istener()
    {
        this$0 = HotelCardListFragment.this;
        super();
    }
}
