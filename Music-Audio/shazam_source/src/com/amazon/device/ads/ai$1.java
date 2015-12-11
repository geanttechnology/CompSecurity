// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;

// Referenced classes of package com.amazon.device.ads:
//            ai, eb

final class a
    implements Runnable
{

    final Context a;
    final ai b;

    public final void run()
    {
        b.a(eb.a().a(a).getSettings().getUserAgentString());
    }

    (ai ai1, Context context)
    {
        b = ai1;
        a = context;
        super();
    }
}
