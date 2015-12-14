// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.moreview;

import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.pages.moreview:
//            DownloadGridItem, n

class a
    implements android.view.r
{

    final DownloadGridItem a;

    public void onClick(View view)
    {
        a.setUseTemplateTarget(.UseTemplateTarget.b);
        if (DownloadGridItem.c(a) != null)
        {
            DownloadGridItem.c(a).a(a);
        }
        a.setLookTemplateMenuVisibility(4);
    }

    .UseTemplateTarget(DownloadGridItem downloadgriditem)
    {
        a = downloadgriditem;
        super();
    }
}
