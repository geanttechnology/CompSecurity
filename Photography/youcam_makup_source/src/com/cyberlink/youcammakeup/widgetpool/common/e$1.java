// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common;

import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.common:
//            e

class a
    implements android.view..OnClickListener
{

    final e a;

    public void onClick(View view)
    {
        if (!e.d(a).isEnabled())
        {
            return;
        } else
        {
            a.c(false);
            e.e(a).onClick(a);
            return;
        }
    }

    (e e1)
    {
        a = e1;
        super();
    }
}
