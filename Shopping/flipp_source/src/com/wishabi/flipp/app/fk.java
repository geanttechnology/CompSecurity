// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.content.DialogInterface;

// Referenced classes of package com.wishabi.flipp.app:
//            fg

final class fk
    implements android.content.DialogInterface.OnShowListener
{

    final fg a;

    fk(fg fg1)
    {
        a = fg1;
        super();
    }

    public final void onShow(DialogInterface dialoginterface)
    {
        fg.e(a);
    }
}
