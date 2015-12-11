// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.content.DialogInterface;

// Referenced classes of package com.wishabi.flipp.app:
//            cg

final class ch
    implements android.content.DialogInterface.OnClickListener
{

    final cg a;

    ch(cg cg)
    {
        a = cg;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }
}
