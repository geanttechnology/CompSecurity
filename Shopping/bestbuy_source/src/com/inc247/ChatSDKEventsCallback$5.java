// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inc247;

import org.json.JSONObject;

// Referenced classes of package com.inc247:
//            ChatSDKEventsCallback, ChatSDKEventsListener

class val.data
    implements Runnable
{

    final ChatSDKEventsCallback this$0;
    private final JSONObject val$data;

    public void run()
    {
        ChatSDKEventsCallback.access$1(ChatSDKEventsCallback.access$0()).onChatMinimized(val$data);
    }

    ()
    {
        this$0 = final_chatsdkeventscallback;
        val$data = JSONObject.this;
        super();
    }
}
