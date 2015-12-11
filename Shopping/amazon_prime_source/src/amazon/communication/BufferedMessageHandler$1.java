// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.communication;

import amazon.communication.identity.EndpointIdentity;
import com.amazon.communication.BufferedMessageManagerBase;

// Referenced classes of package amazon.communication:
//            BufferedMessageHandler

class rBase extends BufferedMessageManagerBase
{

    final BufferedMessageHandler this$0;

    protected void handleCompletedMessage(EndpointIdentity endpointidentity, com.amazon.communication.e.MessageEntry messageentry)
    {
        onMessage(endpointidentity, messageentry.getMessage());
    }

    rBase.MessageEntry(long l)
    {
        this$0 = BufferedMessageHandler.this;
        super(l);
    }
}
