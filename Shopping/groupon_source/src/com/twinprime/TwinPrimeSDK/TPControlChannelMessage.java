// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;

import java.nio.ByteBuffer;

class TPControlChannelMessage
    implements Comparable
{
    class TPControlChannelMessageException extends Exception
    {

        final TPControlChannelMessage this$0;

        TPControlChannelMessageException(String s)
        {
            this$0 = TPControlChannelMessage.this;
            super(s);
        }
    }


    ByteBuffer buffer;
    int type;

    TPControlChannelMessage(int i)
        throws TPControlChannelMessageException
    {
        if (i != 2 && i != 3 && i != 4)
        {
            throw new TPControlChannelMessageException("Messages of type different than TYPE_ERROR, TYPE_OKHTTP_CACHE or TYPE_STOP need a ByteBuffer");
        } else
        {
            type = i;
            return;
        }
    }

    TPControlChannelMessage(int i, ByteBuffer bytebuffer)
        throws TPControlChannelMessageException
    {
        if (bytebuffer == null || bytebuffer.capacity() == 0)
        {
            throw new TPControlChannelMessageException("ByteBuffer is needed for constructing this message");
        } else
        {
            type = i;
            buffer = bytebuffer;
            return;
        }
    }

    public int compareTo(Object obj)
        throws ClassCastException
    {
        obj = (TPControlChannelMessage)obj;
        if (type != 4)
        {
            if (((TPControlChannelMessage) (obj)).type == 4)
            {
                return -1;
            }
            if (type != 2 || ((TPControlChannelMessage) (obj)).type == 2)
            {
                return type == 2 || ((TPControlChannelMessage) (obj)).type != 2 ? 0 : -1;
            }
        }
        return 1;
    }
}
