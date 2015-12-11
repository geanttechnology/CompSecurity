// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inc247.bridge;

import com.inc247.ChatSDK;

// Referenced classes of package com.inc247.bridge:
//            ChatSDKJSToNativeBridge

class this._cls0
    implements Runnable
{

    final ChatSDKJSToNativeBridge this$0;

    public void run()
    {
        ChatSDK.getSDKInstance().minimizeChat();
    }

    ()
    {
        this$0 = ChatSDKJSToNativeBridge.this;
        super();
    }
}
