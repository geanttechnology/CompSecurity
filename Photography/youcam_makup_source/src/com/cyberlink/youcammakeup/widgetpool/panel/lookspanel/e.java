// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.lookspanel;

import android.util.Log;
import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.lookspanel:
//            a, LooksGridItem

class e extends a
{

    final LooksGridItem b;

    e(LooksGridItem looksgriditem)
    {
        b = looksgriditem;
        super(looksgriditem, null);
        LooksGridItem.a(looksgriditem).setBackgroundResource(0x7f02086f);
        LooksGridItem.a(looksgriditem).setVisibility(0);
        LooksGridItem.b(looksgriditem).setVisibility(8);
    }

    public a a()
    {
        Log.d("LooksGridItem", "from StateLocked to StateLocked");
        return this;
    }
}
