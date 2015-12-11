// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import com.tapjoy.mraid.view.BasicWebView;

// Referenced classes of package com.tapjoy:
//            TJAdUnit, TapjoyLog

final class >
    implements Runnable
{

    final String a;
    final ridge.AdUnitAsyncTaskListner b;
    final TJAdUnit c;

    public final void run()
    {
        try
        {
            TapjoyLog.i("TJAdUnit", (new StringBuilder("setBackgroundContent: ")).append(a).toString());
            TJAdUnit.d(c).loadDataWithBaseURL(null, a, "text/html", "utf-8", null);
            b.onComplete(true);
            return;
        }
        catch (Exception exception)
        {
            TapjoyLog.i("TJAdUnit", (new StringBuilder("Error setting background content. backgroundWebView: ")).append(TJAdUnit.d(c)).append(", content: ").append(a).toString());
        }
        b.onComplete(false);
    }

    istner(TJAdUnit tjadunit, String s, ridge.AdUnitAsyncTaskListner adunitasynctasklistner)
    {
        c = tjadunit;
        a = s;
        b = adunitasynctasklistner;
        super();
    }
}
