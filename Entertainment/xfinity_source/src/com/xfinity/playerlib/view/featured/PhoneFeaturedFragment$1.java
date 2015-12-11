// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.featured;

import android.view.View;
import android.widget.TabHost;
import com.comcast.cim.android.accessibility.AlternateInterfaceListener;

// Referenced classes of package com.xfinity.playerlib.view.featured:
//            PhoneFeaturedFragment

class this._cls0
    implements android.support.v4.view.stener
{

    final PhoneFeaturedFragment this$0;

    public void onPageScrollStateChanged(int i)
    {
    }

    public void onPageScrolled(int i, float f, int j)
    {
    }

    public void onPageSelected(int i)
    {
        PhoneFeaturedFragment.access$000(PhoneFeaturedFragment.this).setCurrentTab(i);
        if (PhoneFeaturedFragment.access$100(PhoneFeaturedFragment.this).isAccessibilityEnabled())
        {
            PhoneFeaturedFragment.access$000(PhoneFeaturedFragment.this).getRootView().findViewById(com.xfinity.playerlib.redFragment).requestFocus();
        }
    }

    ener()
    {
        this$0 = PhoneFeaturedFragment.this;
        super();
    }
}
