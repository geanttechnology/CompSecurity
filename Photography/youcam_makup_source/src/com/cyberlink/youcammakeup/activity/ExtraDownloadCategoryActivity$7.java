// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a;
import com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem;
import com.cyberlink.youcammakeup.pages.moreview.af;
import com.cyberlink.youcammakeup.pages.moreview.p;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            ExtraDownloadCategoryActivity

class b
    implements Runnable
{

    final long a;
    final a b;
    final ExtraDownloadCategoryActivity c;

    public void run()
    {
        Iterator iterator = com.cyberlink.youcammakeup.activity.ExtraDownloadCategoryActivity.a(c, a).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            DownloadGridItem downloadgriditem = (DownloadGridItem)iterator.next();
            if (b != null && downloadgriditem != null)
            {
                if (((p)downloadgriditem.getTag()).c() != com.cyberlink.youcammakeup.pages.moreview. && ((p)downloadgriditem.getTag()).c() != com.cyberlink.youcammakeup.pages.moreview.)
                {
                    ((p)downloadgriditem.getTag()).a(com.cyberlink.youcammakeup.pages.moreview.);
                    downloadgriditem.setDownloadBtnState(com.cyberlink.youcammakeup.pages.moreview.);
                }
                downloadgriditem.setProgress(af.a(b));
            }
        } while (true);
    }

    tate(ExtraDownloadCategoryActivity extradownloadcategoryactivity, long l, a a1)
    {
        c = extradownloadcategoryactivity;
        a = l;
        b = a1;
        super();
    }
}
