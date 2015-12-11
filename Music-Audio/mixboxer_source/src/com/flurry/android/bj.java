// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.DialogInterface;
import android.webkit.WebView;

// Referenced classes of package com.flurry.android:
//            ft

final class bj
    implements android.content.DialogInterface.OnDismissListener
{

    private ft dp;

    bj(ft ft1)
    {
        dp = ft1;
        super();
    }

    public final void onDismiss(DialogInterface dialoginterface)
    {
        if (ft.b(dp) != null)
        {
            ft.b(dp).loadUrl("javascript:if(window.mraid){window.mraid.close();};");
        }
    }
}
