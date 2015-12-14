// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.moreview;

import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.pages.moreview:
//            DownloadGridItem, p, n

class a
    implements android.view.r
{

    final DownloadGridItem a;

    private boolean a()
    {
        return DownloadGridItem.d(a) && !DownloadGridItem.e(a);
    }

    private boolean b()
    {
        return !DownloadGridItem.d(a) && DownloadGridItem.e(a);
    }

    public void onClick(View view)
    {
        view = (p)a.getTag();
        if (DownloadGridItem.f(a) != youtTypeInfo.LayoutType.a || DownloadGridItem.g(a) == null || view.c() != wnloadState.d) goto _L2; else goto _L1
_L1:
        if (DownloadGridItem.h(a) != com.cyberlink.youcammakeup.kernelctrl.er.DisplayMakeupType.c && !a()) goto _L4; else goto _L3
_L3:
        a.setUseTemplateTarget(.UseTemplateTarget.c);
_L2:
        if (DownloadGridItem.f(a) == youtTypeInfo.LayoutType.e && view.c() == wnloadState.d && (DownloadGridItem.h(a) == com.cyberlink.youcammakeup.kernelctrl.er.DisplayMakeupType.c || a()))
        {
            a.setUseTemplateTarget(.UseTemplateTarget.c);
        }
        if (DownloadGridItem.c(a) != null)
        {
            DownloadGridItem.c(a).a(a);
        }
        return;
_L4:
        if (DownloadGridItem.h(a) != com.cyberlink.youcammakeup.kernelctrl.er.DisplayMakeupType.b && !b())
        {
            break; /* Loop/switch isn't completed */
        }
        a.setUseTemplateTarget(.UseTemplateTarget.b);
        if (true) goto _L2; else goto _L5
_L5:
        int i = DownloadGridItem.g(a).getVisibility();
        view = a;
        if (i == 0)
        {
            i = 4;
        } else
        {
            i = 0;
        }
        view.setLookTemplateMenuVisibility(i);
        return;
    }

    .UseTemplateTarget(DownloadGridItem downloadgriditem)
    {
        a = downloadgriditem;
        super();
    }
}
