// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.lookspanel;

import android.util.Log;
import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.lookspanel:
//            a, LooksGridItem

class c extends a
{

    final LooksGridItem b;

    c(LooksGridItem looksgriditem)
    {
        b = looksgriditem;
        super(looksgriditem, null);
        LooksGridItem.a(looksgriditem).setVisibility(4);
        LooksGridItem.b(looksgriditem).setVisibility(8);
    }

    public a a()
    {
        Log.d("LooksGridItem", "from StateDownloadCompleted to StateDownloadCompleted");
        return this;
    }
}
