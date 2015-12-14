// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.lookspanel;

import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.lookspanel:
//            LooksGridItem

class a
    implements android.view.ener
{

    final LooksGridItem a;

    public void onClick(View view)
    {
        if (!LooksGridItem.c(a).isEnabled())
        {
            return;
        } else
        {
            LooksGridItem.c(a).setEnabled(false);
            LooksGridItem.d(a).onClick(a);
            return;
        }
    }

    (LooksGridItem looksgriditem)
    {
        a = looksgriditem;
        super();
    }
}
