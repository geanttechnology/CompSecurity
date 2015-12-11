// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.content.DialogInterface;

// Referenced classes of package com.wishabi.flipp.app:
//            o, n

final class q
    implements android.content.DialogInterface.OnClickListener
{

    final int a;
    final o b;

    q(o o1, int i)
    {
        b = o1;
        a = i;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        n.a(b.a, a);
    }
}
