// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.app.Dialog;
import android.content.DialogInterface;

// Referenced classes of package com.flurry.android:
//            co, ft

final class dt
    implements android.content.DialogInterface.OnShowListener
{

    private co fC;

    dt(co co1)
    {
        fC = co1;
        super();
    }

    public final void onShow(DialogInterface dialoginterface)
    {
        if (ft.s(fC.dp) != null)
        {
            ft.s(fC.dp).hide();
        }
    }
}
