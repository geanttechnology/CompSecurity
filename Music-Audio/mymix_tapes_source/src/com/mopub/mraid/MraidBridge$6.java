// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mraid;


// Referenced classes of package com.mopub.mraid:
//            MraidBridge, MraidCommandException, MraidJavascriptCommand

class tCommand
    implements mandHandler.MraidCommandFailureListener
{

    final MraidBridge this$0;
    final MraidJavascriptCommand val$command;

    public void onFailure(MraidCommandException mraidcommandexception)
    {
        MraidBridge.access$300(MraidBridge.this, val$command, mraidcommandexception.getMessage());
    }

    tCommand()
    {
        this$0 = final_mraidbridge;
        val$command = MraidJavascriptCommand.this;
        super();
    }
}
