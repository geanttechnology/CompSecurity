// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia.a;

import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;

// Referenced classes of package com.tremorvideo.sdk.android.richmedia.a:
//            c

private class <init> extends WebChromeClient
{

    final c a;

    public void onConsoleMessage(String s, int i, String s1)
    {
        Log.d("ClickoutWebView", (new StringBuilder()).append("MSG: ").append(s).append("; Line: ").append(i).append("; Source: ").append(s1).toString());
    }

    public boolean onConsoleMessage(ConsoleMessage consolemessage)
    {
        Log.d("ClickoutWebView", (new StringBuilder()).append("MSG: ").append(consolemessage.message()).append("; Line: ").append(consolemessage.lineNumber()).append("; Source: ").append(consolemessage.sourceId()).toString());
        return true;
    }

    private (c c1)
    {
        a = c1;
        super();
    }

    a(c c1, a a1)
    {
        this(c1);
    }
}
