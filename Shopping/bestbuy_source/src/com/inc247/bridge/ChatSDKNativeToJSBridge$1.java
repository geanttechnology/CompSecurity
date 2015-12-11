// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inc247.bridge;

import com.inc247.ChatSDK;
import com.inc247.ChatSDKWebView;

// Referenced classes of package com.inc247.bridge:
//            ChatSDKNativeToJSBridge

class val.url
    implements Runnable
{

    private final String val$url;

    public void run()
    {
        ChatSDKWebView.getInstance(ChatSDK.getSDKInstance().activity).loadUrl(val$url);
    }

    ()
    {
        val$url = s;
        super();
    }
}
