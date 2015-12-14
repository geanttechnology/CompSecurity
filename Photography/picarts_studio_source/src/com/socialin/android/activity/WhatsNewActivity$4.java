// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.activity;

import android.support.v4.view.ViewPager;

// Referenced classes of package com.socialin.android.activity:
//            WhatsNewActivity

final class a
    implements android.support.v4.view.ngeListener
{

    private WhatsNewActivity a;

    public final void onPageScrollStateChanged(int i)
    {
    }

    public final void onPageScrolled(int i, float f, int j)
    {
    }

    public final void onPageSelected(int i)
    {
        com.socialin.android.apiv3.model.atsNewItem atsnewitem = ((atsNewAdapter)WhatsNewActivity.access$200(a).getAdapter()).getItem(i);
        WhatsNewActivity.access$700(a, atsnewitem);
    }

    atsNewAdapter(WhatsNewActivity whatsnewactivity)
    {
        a = whatsnewactivity;
        super();
    }
}
