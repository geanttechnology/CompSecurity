// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a;

import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;

// Referenced classes of package com.a.a:
//            i, h

final class k extends WebChromeClient
{

    private i a;

    k(i j)
    {
        a = j;
        super();
    }

    public final boolean onConsoleMessage(ConsoleMessage consolemessage)
    {
        return h.a(a.a, consolemessage);
    }
}
