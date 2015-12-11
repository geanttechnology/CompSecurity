// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.shop;

import com.google.a.a.e;
import com.target.mothership.util.p;
import com.target.ui.model.weekly_ad.WeeklyAdHomepageData;
import java.util.Date;

// Referenced classes of package com.target.ui.view.shop:
//            WeeklyAdView

private class this._cls0
    implements w.a
{

    private Date mEndDate;
    private String mImageUrl;
    private Date mStartDate;
    private WeeklyAdHomepageData mWeeklyAdHomePageData;
    final WeeklyAdView this$0;

    public e a()
    {
        return e.c(mEndDate);
    }

    public e a(int i)
    {
        if (mImageUrl == null)
        {
            return e.e();
        } else
        {
            return e.c(p.a(mImageUrl, i));
        }
    }

    public void a(WeeklyAdHomepageData weeklyadhomepagedata)
    {
        mWeeklyAdHomePageData = weeklyadhomepagedata;
    }

    public void a(String s)
    {
        mImageUrl = s;
    }

    public void a(Date date)
    {
        mEndDate = date;
    }

    public e b()
    {
        return e.c(mStartDate);
    }

    public void b(Date date)
    {
        mStartDate = date;
    }

    public e c()
    {
        return e.c(mImageUrl);
    }

    public e d()
    {
        return e.c(mWeeklyAdHomePageData);
    }

    public omepageData()
    {
        this$0 = WeeklyAdView.this;
        super();
    }
}
