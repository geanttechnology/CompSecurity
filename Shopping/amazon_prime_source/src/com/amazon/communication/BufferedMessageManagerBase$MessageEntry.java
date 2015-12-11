// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import amazon.communication.Message;
import com.amazon.dp.logger.DPFormattedMessage;

// Referenced classes of package com.amazon.communication:
//            BufferedMessageManagerBase

public static class mChannel
{

    protected final int mChannel;
    protected final Message mMessage;
    protected final int mMessageId;

    public int getChannel()
    {
        return mChannel;
    }

    public Message getMessage()
    {
        return mMessage;
    }

    public int getMessageId()
    {
        return mMessageId;
    }

    public String toString()
    {
        Message message = mMessage;
        int i = getMessageId();
        int j = mMessage.getPayloadSize();
        Object obj;
        if (mChannel == -1)
        {
            obj = "NO_CHANNEL_SPECIFIED";
        } else
        {
            obj = Integer.valueOf(mChannel);
        }
        return DPFormattedMessage.toDPFormat("MessageEntry", "message details", new Object[] {
            "message", message, "messageId", Integer.valueOf(i), "message size", Integer.valueOf(j), "channel", obj
        });
    }

    public (Message message, int i, int j)
    {
        mMessage = message;
        mMessageId = i;
        mChannel = j;
    }
}
