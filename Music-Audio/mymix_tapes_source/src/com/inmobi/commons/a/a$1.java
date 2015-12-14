// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.a;

import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;

// Referenced classes of package com.inmobi.commons.a:
//            a

static final class a
    implements Runnable
{

    final Context a;

    public void run()
    {
        com.inmobi.commons.a.a.c((new WebView(a)).getSettings().getUserAgentString());
    }

    s(Context context)
    {
        a = context;
        super();
    }
}
