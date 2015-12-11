// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inc247;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.webkit.JsResult;

// Referenced classes of package com.inc247:
//            ChatSDKWebChromeClient

class val.result
    implements android.content.ener
{

    final ChatSDKWebChromeClient this$0;
    private final JsResult val$result;

    public boolean onKey(DialogInterface dialoginterface, int i, KeyEvent keyevent)
    {
        if (i == 4)
        {
            val$result.confirm();
            return false;
        } else
        {
            return true;
        }
    }

    yListener()
    {
        this$0 = final_chatsdkwebchromeclient;
        val$result = JsResult.this;
        super();
    }
}
