// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.widget.ProgressBar;
import com.cyberlink.youcammakeup.database.more.makeup.MakeupItemMetadata;
import com.cyberlink.youcammakeup.e;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            WeekStarActivity

class a
    implements e
{

    final WeekStarActivity a;

    public volatile void a(Object obj)
    {
        a((List)obj);
    }

    public void a(List list)
    {
        if (list.size() == 0)
        {
            WeekStarActivity.a(a, true, false, true, false, a.getString(0x7f0703fd), null, a.getString(0x7f07051d));
        } else
        {
            WeekStarActivity.a(a).setMax(100);
            list = list.iterator();
            while (list.hasNext()) 
            {
                MakeupItemMetadata makeupitemmetadata = (MakeupItemMetadata)list.next();
                WeekStarActivity.a(a, makeupitemmetadata);
            }
        }
    }

    public void b(Object obj)
    {
    }

    public void c(Object obj)
    {
    }

    temMetadata(WeekStarActivity weekstaractivity)
    {
        a = weekstaractivity;
        super();
    }
}
