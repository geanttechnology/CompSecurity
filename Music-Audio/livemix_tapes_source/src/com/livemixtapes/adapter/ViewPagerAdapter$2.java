// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes.adapter;

import android.view.View;

// Referenced classes of package com.livemixtapes.adapter:
//            ViewPagerAdapter

class val.position
    implements android.view.r
{

    final ViewPagerAdapter this$0;
    private final int val$position;

    public void onClick(View view)
    {
        ViewPagerAdapter.access$0(ViewPagerAdapter.this).onShowMixtape(val$position, 1);
    }

    gerCallbacks()
    {
        this$0 = final_viewpageradapter;
        val$position = I.this;
        super();
    }
}
