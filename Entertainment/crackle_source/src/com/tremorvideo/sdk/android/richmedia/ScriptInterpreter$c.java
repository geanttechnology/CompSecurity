// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia;

import android.webkit.WebView;

// Referenced classes of package com.tremorvideo.sdk.android.richmedia:
//            ScriptInterpreter

public class a
    implements Runnable
{

    String a;
    final ScriptInterpreter b;

    public void run()
    {
        b.a.evaluateJavascript(a, null);
    }

    public (ScriptInterpreter scriptinterpreter, String s)
    {
        b = scriptinterpreter;
        super();
        a = s;
    }
}
