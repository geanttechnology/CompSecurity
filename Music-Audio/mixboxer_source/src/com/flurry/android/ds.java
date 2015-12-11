// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.DialogInterface;
import android.webkit.WebChromeClient;

// Referenced classes of package com.flurry.android:
//            co, ft

final class ds
    implements android.content.DialogInterface.OnDismissListener
{

    private co fC;

    ds(co co1)
    {
        fC = co1;
        super();
    }

    public final void onDismiss(DialogInterface dialoginterface)
    {
        if (ft.o(fC.dp) != null && ft.p(fC.dp) != null)
        {
            ft.p(fC.dp).onHideCustomView();
        }
    }
}
