// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.weekly_ad;

import com.target.mothership.model.h;
import com.target.mothership.model.store.interfaces.RelevantStoreSummary;
import com.target.mothership.services.x;
import com.target.ui.util.q;

// Referenced classes of package com.target.ui.fragment.weekly_ad:
//            WeeklyAdFragment

class this._cls0 extends h
{

    final WeeklyAdFragment this$0;

    public String a()
    {
        return WeeklyAdFragment.TAG;
    }

    public void a(RelevantStoreSummary relevantstoresummary)
    {
        if (WeeklyAdFragment.b(WeeklyAdFragment.this) == null)
        {
            return;
        } else
        {
            WeeklyAdFragment.a(WeeklyAdFragment.this, relevantstoresummary);
            WeeklyAdFragment.e(WeeklyAdFragment.this);
            return;
        }
    }

    public void a(x x1)
    {
        if (WeeklyAdFragment.b(WeeklyAdFragment.this) == null)
        {
            return;
        } else
        {
            q.a(WeeklyAdFragment.TAG, "Error when retrieving the store summary");
            return;
        }
    }

    public volatile void a(Object obj)
    {
        a((RelevantStoreSummary)obj);
    }

    public void b(Object obj)
    {
        a((x)obj);
    }

    tStoreSummary()
    {
        this$0 = WeeklyAdFragment.this;
        super();
    }
}
