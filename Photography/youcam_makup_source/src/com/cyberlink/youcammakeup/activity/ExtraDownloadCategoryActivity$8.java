// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem;
import com.cyberlink.youcammakeup.pages.moreview.p;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            ExtraDownloadCategoryActivity

class a
    implements Runnable
{

    final long a;
    final ExtraDownloadCategoryActivity b;

    public void run()
    {
        Iterator iterator = ExtraDownloadCategoryActivity.a(b, a).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            DownloadGridItem downloadgriditem = (DownloadGridItem)iterator.next();
            p p1 = (p)downloadgriditem.getTag();
            if (downloadgriditem != null && p1.c() == com.cyberlink.youcammakeup.pages.moreview.)
            {
                downloadgriditem.setDownloadBtnState(com.cyberlink.youcammakeup.pages.moreview.);
                p1.a(com.cyberlink.youcammakeup.pages.moreview.);
            }
        } while (true);
    }

    tate(ExtraDownloadCategoryActivity extradownloadcategoryactivity, long l)
    {
        b = extradownloadcategoryactivity;
        a = l;
        super();
    }
}
