// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.content.DialogInterface;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.dialogs:
//            h, i

class a
    implements android.content.ogInterface.OnDismissListener
{

    final h a;

    public void onDismiss(DialogInterface dialoginterface)
    {
        if (!a.a)
        {
            a.a = true;
            if (h.a(a) != null)
            {
                h.a(a).a(a.b);
            }
        }
    }

    (h h1)
    {
        a = h1;
        super();
    }
}
