// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem;
import com.cyberlink.youcammakeup.pages.moreview.p;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            ExtraDownloadActivity

class b
    implements Runnable
{

    final DownloadGridItem a;
    final p b;
    final ExtraDownloadActivity c;

    public void run()
    {
        a.setDownloadBtnState(com.cyberlink.youcammakeup.pages.moreview.dState.b);
        b.a(com.cyberlink.youcammakeup.pages.moreview.dState.b);
    }

    ownloadState(ExtraDownloadActivity extradownloadactivity, DownloadGridItem downloadgriditem, p p1)
    {
        c = extradownloadactivity;
        a = downloadgriditem;
        b = p1;
        super();
    }
}
