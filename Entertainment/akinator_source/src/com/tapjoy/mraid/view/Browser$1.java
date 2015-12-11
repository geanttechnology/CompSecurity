// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.mraid.view;

import android.view.View;
import android.webkit.WebView;

// Referenced classes of package com.tapjoy.mraid.view:
//            Browser

final class a
    implements android.view.ckListener
{

    final Browser a;

    public final void onClick(View view)
    {
        view = (WebView)a.findViewById(101);
        if (view.canGoBack())
        {
            view.goBack();
            return;
        } else
        {
            a.finish();
            return;
        }
    }

    r(Browser browser)
    {
        a = browser;
        super();
    }
}
