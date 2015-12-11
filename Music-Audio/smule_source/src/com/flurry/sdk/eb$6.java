// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.DialogInterface;
import android.webkit.WebView;

// Referenced classes of package com.flurry.sdk:
//            eb, gd

class it>
    implements android.content.gInterface.OnDismissListener
{

    final eb a;

    public void onDismiss(DialogInterface dialoginterface)
    {
        gd.a(3, eb.c(a), "extendedWebViewDialog.onDismiss()");
        if (eb.d(a) != null)
        {
            eb.d(a).loadUrl("javascript:if(window.mraid){window.mraid.close();};");
        }
    }

    ogInterface(eb eb1)
    {
        a = eb1;
        super();
    }
}
