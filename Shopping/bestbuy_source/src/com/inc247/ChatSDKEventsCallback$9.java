// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inc247;


// Referenced classes of package com.inc247:
//            ChatSDKEventsCallback, ChatSDKEventsListener

class this._cls0
    implements Runnable
{

    final ChatSDKEventsCallback this$0;

    public void run()
    {
        ChatSDKEventsCallback.access$1(ChatSDKEventsCallback.access$0()).onQueueIdParamRetrievalStarted();
    }

    ()
    {
        this$0 = ChatSDKEventsCallback.this;
        super();
    }
}
