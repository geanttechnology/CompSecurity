// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.content.DialogInterface;

// Referenced classes of package com.wishabi.flipp.app:
//            cs

final class ct
    implements android.content.DialogInterface.OnClickListener
{

    final cs a;

    ct(cs cs)
    {
        a = cs;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }
}
