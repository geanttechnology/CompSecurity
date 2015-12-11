// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.weekly_ad;

import android.view.View;
import com.target.ui.view.weekly_ad.WeeklyAdHeaderView;
import com.target.ui.view.weekly_ad.WeeklyAdListLayout;

// Referenced classes of package com.target.ui.fragment.weekly_ad:
//            WeeklyAdFragment

class this._cls0
    implements android.view.Listener
{

    final WeeklyAdFragment this$0;

    public void onLayoutChange(View view, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1)
    {
        WeeklyAdFragment.a(WeeklyAdFragment.this, WeeklyAdFragment.b(WeeklyAdFragment.this).weeklyAdListLayout.getHeight());
        if (WeeklyAdFragment.g(WeeklyAdFragment.this) == 0)
        {
            return;
        } else
        {
            WeeklyAdFragment.b(WeeklyAdFragment.this).weeklyAdHeaderView.b(WeeklyAdFragment.g(WeeklyAdFragment.this));
            WeeklyAdFragment.b(WeeklyAdFragment.this).weeklyAdListLayout.removeOnLayoutChangeListener(this);
            return;
        }
    }

    ews()
    {
        this$0 = WeeklyAdFragment.this;
        super();
    }
}
