// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import com.cyberlink.youcammakeup.pages.moreview.BeautyCategoryItem;
import com.cyberlink.youcammakeup.pages.moreview.a;
import com.cyberlink.youcammakeup.pages.moreview.af;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            BeautyTipCategoryActivity

class b
    implements Runnable
{

    final long a;
    final BeautyCategoryItem b;
    final BeautyTipCategoryActivity c;

    public void run()
    {
        if (c.b == null)
        {
            return;
        }
        boolean flag = af.a(com.cyberlink.youcammakeup.activity.BeautyTipCategoryActivity.a, a);
        com.cyberlink.youcammakeup.database.more.a.a a1 = (com.cyberlink.youcammakeup.database.more.a.a)c.b.a(a);
        if (a1 == null || !a1.b())
        {
            flag = false;
        }
        b.a(flag);
    }

    (BeautyTipCategoryActivity beautytipcategoryactivity, long l, BeautyCategoryItem beautycategoryitem)
    {
        c = beautytipcategoryactivity;
        a = l;
        b = beautycategoryitem;
        super();
    }
}
