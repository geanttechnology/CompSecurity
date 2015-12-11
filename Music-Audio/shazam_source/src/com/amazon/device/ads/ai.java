// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;

// Referenced classes of package com.amazon.device.ads:
//            ax, eb

final class ai extends ax
{

    private final ds.k a;

    public ai()
    {
        this(new ds.k());
    }

    private ai(ds.k k)
    {
        a = k;
    }

    final void a(Context context)
    {
        a.a(new Runnable(context) {

            final Context a;
            final ai b;

            public final void run()
            {
                b.a(eb.a().a(a).getSettings().getUserAgentString());
            }

            
            {
                b = ai.this;
                a = context;
                super();
            }
        }, ds.b.a, ds.c.a);
    }
}
