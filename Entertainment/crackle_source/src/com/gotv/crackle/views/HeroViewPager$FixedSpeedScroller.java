// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.views;

import android.content.Context;
import android.widget.Scroller;

// Referenced classes of package com.gotv.crackle.views:
//            HeroViewPager

public class this._cls0 extends Scroller
{

    final HeroViewPager this$0;

    public void startScroll(int i, int j, int k, int l)
    {
        super.startScroll(i, j, k, l, 2000);
    }

    public void startScroll(int i, int j, int k, int l, int i1)
    {
        super.startScroll(i, j, k, l, 2000);
    }

    public (Context context)
    {
        this$0 = HeroViewPager.this;
        super(context);
    }
}
