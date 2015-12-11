// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.view.View;
import android.webkit.WebView;

// Referenced classes of package com.flurry.sdk:
//            eh

class it>
    implements android.view.OnClickListener
{

    final eh a;

    public void onClick(View view)
    {
        if (eh.b(a) != null && eh.b(a).canGoForward())
        {
            eh.b(a).goForward();
        }
    }

    ew(eh eh1)
    {
        a = eh1;
        super();
    }
}
