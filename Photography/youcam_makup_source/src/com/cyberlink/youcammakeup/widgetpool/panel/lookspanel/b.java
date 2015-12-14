// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.lookspanel;

import android.util.Log;
import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.lookspanel:
//            a, LooksGridItem, d

class b extends a
{

    final LooksGridItem b;

    b(LooksGridItem looksgriditem)
    {
        b = looksgriditem;
        super(looksgriditem, null);
        LooksGridItem.a(looksgriditem).setBackgroundResource(0x7f020730);
        LooksGridItem.a(looksgriditem).setVisibility(0);
        LooksGridItem.b(looksgriditem).setVisibility(8);
    }

    public a a()
    {
        Log.d("LooksGridItem", "from StateCanDownload to StateDownloading");
        b.setProgress(0);
        LooksGridItem.a(b).setVisibility(4);
        LooksGridItem.b(b).setVisibility(0);
        return new d(b, null);
    }
}
