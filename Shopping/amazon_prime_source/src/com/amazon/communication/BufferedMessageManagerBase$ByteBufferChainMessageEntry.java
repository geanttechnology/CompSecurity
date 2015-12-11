// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import amazon.communication.Message;
import com.amazon.communication.time.GlobalTimeSource;
import com.amazon.communication.time.TimeSource;
import com.amazon.dp.logger.DPFormattedMessage;

// Referenced classes of package com.amazon.communication:
//            BufferedMessageManagerBase, ByteBufferChainMessageImpl

public static class mLastFragmentArrivalTimeInMillis extends mLastFragmentArrivalTimeInMillis
{

    protected int mFragmentCount;
    protected long mLastFragmentArrivalTimeInMillis;

    public void appendFragment(Message message)
    {
        ((ByteBufferChainMessageImpl)mMessage).appendPayload(message);
        mFragmentCount = mFragmentCount + 1;
        mLastFragmentArrivalTimeInMillis = GlobalTimeSource.INSTANCE.currentTimeMillis();
    }

    public long getLastFragmentArrivalTimeInMillis()
    {
        return mLastFragmentArrivalTimeInMillis;
    }

    public String toString()
    {
        Message message = mMessage;
        int i = mMessageId;
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
            "message", message, "messageId", Integer.valueOf(i), "message size", Integer.valueOf(j), "channel", obj, "fragmentCount", Integer.valueOf(mFragmentCount), 
            "lastFragmentArrivalTimeMillis", Long.valueOf(mLastFragmentArrivalTimeInMillis)
        });
    }

    public (ByteBufferChainMessageImpl bytebufferchainmessageimpl, int i, int j)
    {
        super(bytebufferchainmessageimpl, i, j);
        mFragmentCount = 1;
        mLastFragmentArrivalTimeInMillis = GlobalTimeSource.INSTANCE.currentTimeMillis();
    }
}
