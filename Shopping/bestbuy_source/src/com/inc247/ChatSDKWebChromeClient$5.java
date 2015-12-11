// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inc247;

import android.content.DialogInterface;
import android.webkit.JsResult;

// Referenced classes of package com.inc247:
//            ChatSDKWebChromeClient

class val.result
    implements android.content.istener
{

    final ChatSDKWebChromeClient this$0;
    private final JsResult val$result;

    public void onCancel(DialogInterface dialoginterface)
    {
        val$result.cancel();
    }

    ncelListener()
    {
        this$0 = final_chatsdkwebchromeclient;
        val$result = JsResult.this;
        super();
    }
}
