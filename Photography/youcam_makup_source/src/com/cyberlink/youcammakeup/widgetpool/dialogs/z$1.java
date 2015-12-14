// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.content.DialogInterface;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.utility.o;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.dialogs:
//            z

class a
    implements android.content.ogInterface.OnDismissListener
{

    final z a;

    public void onDismiss(DialogInterface dialoginterface)
    {
        if (z.a(a) != null)
        {
            dialoginterface = Globals.d().a(z.a(a));
            if (dialoginterface != null)
            {
                o.a(dialoginterface);
            }
        }
        z.b(a);
    }

    (z z1)
    {
        a = z1;
        super();
    }
}
