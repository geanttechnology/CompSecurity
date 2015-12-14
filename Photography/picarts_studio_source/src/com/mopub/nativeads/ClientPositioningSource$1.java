// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;


// Referenced classes of package com.mopub.nativeads:
//            ClientPositioningSource

class ingListener
    implements Runnable
{

    final ClientPositioningSource this$0;
    final ingListener val$listener;

    public void run()
    {
        val$listener.onLoad(ClientPositioningSource.access$000(ClientPositioningSource.this));
    }

    ingListener()
    {
        this$0 = final_clientpositioningsource;
        val$listener = ingListener.this;
        super();
    }
}
