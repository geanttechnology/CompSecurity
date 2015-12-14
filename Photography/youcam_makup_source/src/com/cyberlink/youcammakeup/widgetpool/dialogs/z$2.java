// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.dialogs:
//            z

class a
    implements android.view..OnClickListener
{

    final z a;

    public void onClick(View view)
    {
        if (z.c(a) != null)
        {
            a.a(null);
            z.c(a).onClick(view);
        }
    }

    (z z1)
    {
        a = z1;
        super();
    }
}
