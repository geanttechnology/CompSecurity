// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.featured;

import android.support.v4.view.ViewPager;
import android.widget.TabHost;

// Referenced classes of package com.xfinity.playerlib.view.featured:
//            PhoneFeaturedFragment

class this._cls0
    implements android.widget.ner
{

    final PhoneFeaturedFragment this$0;

    public void onTabChanged(String s)
    {
        int i = PhoneFeaturedFragment.access$000(PhoneFeaturedFragment.this).getCurrentTab();
        PhoneFeaturedFragment.access$300(PhoneFeaturedFragment.this).setCurrentItem(i);
    }

    A()
    {
        this$0 = PhoneFeaturedFragment.this;
        super();
    }
}
