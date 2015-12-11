// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import android.content.DialogInterface;

// Referenced classes of package com.tapjoy:
//            TJAdUnitActivity

final class a
    implements android.content.lickListener
{

    final TJAdUnitActivity a;

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        a.handleClose();
        dialoginterface.cancel();
    }

    e(TJAdUnitActivity tjadunitactivity)
    {
        a = tjadunitactivity;
        super();
    }
}
