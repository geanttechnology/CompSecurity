// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia.a;

import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import com.tremorvideo.sdk.android.videoad.ad;

// Referenced classes of package com.tremorvideo.sdk.android.richmedia.a:
//            h

private class <init> extends WebChromeClient
{

    final h a;

    public void onConsoleMessage(String s, int i, String s1)
    {
        ad.d((new StringBuilder()).append("GenericWebview Console: ").append(s).toString());
    }

    public boolean onConsoleMessage(ConsoleMessage consolemessage)
    {
        ad.d((new StringBuilder()).append("GenericWebview Console: ").append(consolemessage.message()).toString());
        return false;
    }

    private (h h1)
    {
        a = h1;
        super();
    }

    a(h h1, a a1)
    {
        this(h1);
    }
}
