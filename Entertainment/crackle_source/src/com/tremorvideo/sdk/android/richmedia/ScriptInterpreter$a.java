// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia;

import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;

// Referenced classes of package com.tremorvideo.sdk.android.richmedia:
//            ScriptInterpreter

private class <init> extends WebChromeClient
{

    final ScriptInterpreter a;

    public void onConsoleMessage(String s, int i, String s1)
    {
    }

    public boolean onConsoleMessage(ConsoleMessage consolemessage)
    {
        return false;
    }

    private (ScriptInterpreter scriptinterpreter)
    {
        a = scriptinterpreter;
        super();
    }

    a(ScriptInterpreter scriptinterpreter, a a1)
    {
        this(scriptinterpreter);
    }
}
