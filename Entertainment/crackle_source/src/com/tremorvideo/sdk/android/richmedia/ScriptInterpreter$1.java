// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia;

import android.webkit.WebView;

// Referenced classes of package com.tremorvideo.sdk.android.richmedia:
//            ScriptInterpreter

class a
    implements Runnable
{

    final ScriptInterpreter a;

    public void run()
    {
        a.a.destroy();
        a.a = null;
    }

    (ScriptInterpreter scriptinterpreter)
    {
        a = scriptinterpreter;
        super();
    }
}
