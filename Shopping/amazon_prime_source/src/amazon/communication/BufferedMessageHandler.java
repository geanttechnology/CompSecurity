// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.communication;

import amazon.communication.identity.EndpointIdentity;
import com.amazon.communication.BufferedMessageManagerBase;

// Referenced classes of package amazon.communication:
//            MessageHandler, Message

public class BufferedMessageHandler
    implements MessageHandler
{

    private final BufferedMessageManagerBase mBufferedMessageManagerBase;
    private final MessageHandler mDecoratedMessageHandler;

    public BufferedMessageHandler(MessageHandler messagehandler)
    {
        this(messagehandler, 0x1b7740L);
    }

    public BufferedMessageHandler(MessageHandler messagehandler, long l)
    {
        mBufferedMessageManagerBase = new BufferedMessageManagerBase(l) {

            final BufferedMessageHandler this$0;

            protected void handleCompletedMessage(EndpointIdentity endpointidentity, com.amazon.communication.BufferedMessageManagerBase.MessageEntry messageentry)
            {
                onMessage(endpointidentity, messageentry.getMessage());
            }

            
            {
                this$0 = BufferedMessageHandler.this;
                super(l);
            }
        };
        mDecoratedMessageHandler = messagehandler;
    }

    public void onMessage(EndpointIdentity endpointidentity, Message message)
    {
        mDecoratedMessageHandler.onMessage(endpointidentity, message);
    }
}
