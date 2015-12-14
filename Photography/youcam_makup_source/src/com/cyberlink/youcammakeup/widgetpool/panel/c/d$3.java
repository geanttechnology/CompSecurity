// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.c;

import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.c:
//            d

class a
    implements android.view..OnClickListener
{

    final d a;

    public void onClick(View view)
    {
        if (d.f(a).isSelected())
        {
            d.a(a, Boolean.valueOf(false), true);
            return;
        } else
        {
            d.a(a, Boolean.valueOf(true), true);
            return;
        }
    }

    (d d1)
    {
        a = d1;
        super();
    }
}
