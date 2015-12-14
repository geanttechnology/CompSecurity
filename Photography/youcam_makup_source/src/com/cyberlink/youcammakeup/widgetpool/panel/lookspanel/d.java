// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.lookspanel;

import android.util.Log;
import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.lookspanel:
//            a, LooksGridItem, b

class d extends a
{

    final LooksGridItem b;

    private d(LooksGridItem looksgriditem)
    {
        b = looksgriditem;
        super(looksgriditem, null);
    }

    d(LooksGridItem looksgriditem, LooksGridItem._cls1 _pcls1)
    {
        this(looksgriditem);
    }

    public a a()
    {
        Log.d("LooksGridItem", "from StateDownloading to StateCanDownload");
        b.setProgress(0);
        LooksGridItem.a(b).setVisibility(0);
        LooksGridItem.b(b).setVisibility(8);
        return new b(b);
    }
}
