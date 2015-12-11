// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g;

import android.content.DialogInterface;

// Referenced classes of package com.offerup.android.g:
//            aa

final class ab
    implements android.content.DialogInterface.OnClickListener
{

    private aa a;

    ab(aa aa1)
    {
        a = aa1;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        if (i == 0)
        {
            aa.a(a);
        } else
        if (i == 1)
        {
            aa.b(a);
            return;
        }
    }
}
