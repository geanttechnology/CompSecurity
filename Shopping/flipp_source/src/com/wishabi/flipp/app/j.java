// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.content.DialogInterface;

// Referenced classes of package com.wishabi.flipp.app:
//            i, k

final class j
    implements android.content.DialogInterface.OnClickListener
{

    final i a;

    j(i l)
    {
        a = l;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int l)
    {
        if (i.a(a) == null)
        {
            return;
        }
        switch (l)
        {
        default:
            return;

        case -1: 
            i.a(a).a(i.b(a));
            break;
        }
    }
}
