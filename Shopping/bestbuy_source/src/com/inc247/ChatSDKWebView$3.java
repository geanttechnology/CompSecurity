// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inc247;

import com.inc247.bridge.ChatSDKNativeToJSBridge;

// Referenced classes of package com.inc247:
//            ChatSDKWebView, ChatSDKUtil

class this._cls0
    implements Runnable
{

    final ChatSDKWebView this$0;

    public void run()
    {
        try
        {
            ChatSDKWebView.access$2().setVisibility(8);
            ChatSDKWebView.access$2().destroy();
            ChatSDKWebView.access$3(null);
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            ChatSDKNativeToJSBridge.executeJS(ChatSDKUtil.createExecJSString((new StringBuilder("{'Error':'")).append(exception).append("'}").toString()));
            return;
        }
    }

    iveToJSBridge()
    {
        this$0 = ChatSDKWebView.this;
        super();
    }
}
