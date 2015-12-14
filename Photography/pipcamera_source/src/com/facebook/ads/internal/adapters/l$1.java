// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.adapters;

import android.util.Log;
import com.facebook.ads.internal.view.d;

// Referenced classes of package com.facebook.ads.internal.adapters:
//            l, k

class a
    implements Runnable
{

    final l a;

    public void run()
    {
        if (l.a(a).b())
        {
            Log.w(l.e(), "Webview already destroyed, cannot activate");
            return;
        } else
        {
            l.a(a).loadUrl((new StringBuilder()).append("javascript:").append(l.b(a).e()).toString());
            return;
        }
    }

    (l l1)
    {
        a = l1;
        super();
    }
}
