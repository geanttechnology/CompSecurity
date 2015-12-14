// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import android.content.DialogInterface;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            DialogUtils

final class a
    implements android.content.e.OnDismissListener
{

    final Runnable a;

    public void onDismiss(DialogInterface dialoginterface)
    {
        if (a != null)
        {
            a.run();
        }
    }

    (Runnable runnable)
    {
        a = runnable;
        super();
    }
}
