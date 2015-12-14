// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import android.content.DialogInterface;
import com.cyberlink.youcammakeup.activity.EditViewActivity;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            e

class a
    implements android.content.ogInterface.OnDismissListener
{

    final e a;

    public void onDismiss(DialogInterface dialoginterface)
    {
        if (a.k != null)
        {
            a.k.Y();
        }
        a.c();
    }

    (e e1)
    {
        a = e1;
        super();
    }
}
