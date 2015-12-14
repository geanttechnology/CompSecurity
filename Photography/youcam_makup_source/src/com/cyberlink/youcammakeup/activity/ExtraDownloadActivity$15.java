// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            ExtraDownloadActivity

class b
    implements Runnable
{

    final DownloadGridItem a;
    final int b;
    final ExtraDownloadActivity c;

    public void run()
    {
        a.setProgress(b);
    }

    (ExtraDownloadActivity extradownloadactivity, DownloadGridItem downloadgriditem, int i)
    {
        c = extradownloadactivity;
        a = downloadgriditem;
        b = i;
        super();
    }
}
