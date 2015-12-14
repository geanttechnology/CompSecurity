// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.moreview;

import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.pages.moreview:
//            o, DownloadItemUtility, t

class a
    implements o
{

    final DownloadItemUtility a;

    public void a(View view)
    {
        if (DownloadItemUtility.e(a) != null)
        {
            DownloadItemUtility.e(a).onClick(view);
        }
    }

    (DownloadItemUtility downloaditemutility)
    {
        a = downloaditemutility;
        super();
    }
}
