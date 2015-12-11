// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g;

import android.content.DialogInterface;

// Referenced classes of package com.offerup.android.g:
//            p

final class q
    implements android.content.DialogInterface.OnClickListener
{

    private p a;

    q(p p1)
    {
        a = p1;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        if (i == 0)
        {
            p.a(a);
        } else
        if (i == 1)
        {
            p.b(a);
            return;
        }
    }
}
