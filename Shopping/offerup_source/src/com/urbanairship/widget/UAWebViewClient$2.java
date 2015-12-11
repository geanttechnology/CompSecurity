// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.widget;

import android.webkit.WebView;
import com.urbanairship.actions.ActionArguments;
import com.urbanairship.actions.ActionCompletionCallback;
import com.urbanairship.actions.ActionResult;

// Referenced classes of package com.urbanairship.widget:
//            UAWebViewClient

class val.callbackKey
    implements ActionCompletionCallback
{

    final UAWebViewClient this$0;
    final String val$callbackKey;
    final String val$name;
    final WebView val$webView;

    public void onFinish(ActionArguments actionarguments, ActionResult actionresult)
    {
        String s = null;
        .SwitchMap.com.urbanairship.actions.ActionResult.Status[actionresult.getStatus().ordinal()];
        JVM INSTR tableswitch 1 3: default 40
    //                   1 89
    //                   2 109
    //                   3 129;
           goto _L1 _L2 _L3 _L4
_L1:
        UAWebViewClient.access$100(UAWebViewClient.this, val$webView, s, actionresult.getValue(), val$callbackKey);
        this;
        JVM INSTR monitorenter ;
        if (UAWebViewClient.access$000(UAWebViewClient.this) != null)
        {
            UAWebViewClient.access$000(UAWebViewClient.this).onFinish(actionarguments, actionresult);
        }
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        s = String.format("Action %s not found", new Object[] {
            val$name
        });
        continue; /* Loop/switch isn't completed */
_L3:
        s = String.format("Action %s rejected its arguments", new Object[] {
            val$name
        });
        continue; /* Loop/switch isn't completed */
_L4:
        if (actionresult.getException() != null)
        {
            s = actionresult.getException().getMessage();
        } else
        {
            s = String.format("Action %s failed with unspecified error", new Object[] {
                val$name
            });
        }
        if (true) goto _L1; else goto _L5
_L5:
        actionarguments;
        this;
        JVM INSTR monitorexit ;
        throw actionarguments;
    }

    us()
    {
        this$0 = final_uawebviewclient;
        val$name = s;
        val$webView = webview;
        val$callbackKey = String.this;
        super();
    }
}
