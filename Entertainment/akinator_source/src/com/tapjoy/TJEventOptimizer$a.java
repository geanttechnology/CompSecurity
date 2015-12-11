// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;

// Referenced classes of package com.tapjoy:
//            TJEventOptimizer, TapjoyLog

final class <init> extends WebChromeClient
{

    final TJEventOptimizer a;

    public final boolean onConsoleMessage(ConsoleMessage consolemessage)
    {
        TapjoyLog.d(TJEventOptimizer.b(), (new StringBuilder("JS CONSOLE: ")).append(consolemessage.message()).append(" -- From line ").append(consolemessage.lineNumber()).append(" of ").append(consolemessage.sourceId()).toString());
        return true;
    }

    private (TJEventOptimizer tjeventoptimizer)
    {
        a = tjeventoptimizer;
        super();
    }

    (TJEventOptimizer tjeventoptimizer, byte byte0)
    {
        this(tjeventoptimizer);
    }
}
