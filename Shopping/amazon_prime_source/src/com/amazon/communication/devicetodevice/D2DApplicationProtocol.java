// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication.devicetodevice;

import amazon.communication.Message;
import amazon.communication.identity.EndpointIdentity;
import com.amazon.communication.ProtocolException;
import com.amazon.dp.logger.DPLogger;
import com.dp.framework.ByteBufferOutputStream;
import com.dp.framework.CodecException;
import com.dp.framework.StreamCodec;
import java.nio.ByteBuffer;

// Referenced classes of package com.amazon.communication.devicetodevice:
//            D2DMessage

public abstract class D2DApplicationProtocol
{

    protected static final String D2D_MESSAGE_MESSAGE_TYPE = "DDM";
    public static final String D2D_MESSAGE_WITH_CHANNEL_MESSAGE_TYPE = "DMC";
    protected static final String D2D_NOTIFICATION_MESSAGE_TYPE = "NOT";
    protected static final int SIZE_OF_MESSAGE_TYPE = 3;
    private static final DPLogger log = new DPLogger("TComm.D2DApplicationProtocol");
    protected final int mDelimiterSize;
    protected final StreamCodec mStreamCodec;

    public D2DApplicationProtocol(StreamCodec streamcodec)
    {
        mStreamCodec = streamcodec;
        mDelimiterSize = streamcodec.getSizeOfDelimiter();
    }

    private void validate(D2DMessage d2dmessage)
    {
        if (d2dmessage.destination == null)
        {
            throw new IllegalArgumentException("Destination cannot be null");
        }
        if (d2dmessage.messageType == null)
        {
            throw new IllegalArgumentException("Message type cannot be null");
        }
        if (d2dmessage.message == null)
        {
            throw new IllegalArgumentException("Message cannot be null");
        } else
        {
            return;
        }
    }

    public abstract void decode(Message message, EndpointIdentity endpointidentity)
        throws ProtocolException;

    public Message encode(D2DMessage d2dmessage)
    {
        int j = mStreamCodec.getSizeOfEncodedMaxInteger();
        int k = mDelimiterSize;
        int l = mDelimiterSize;
        int i1 = mDelimiterSize;
        int j1 = mDelimiterSize;
        int k1 = mDelimiterSize;
        int l1 = mDelimiterSize;
        int i2 = mDelimiterSize;
        int j2 = mDelimiterSize;
        int k2 = mDelimiterSize;
        int l2 = mDelimiterSize;
        validate(d2dmessage);
        String s;
        ByteBuffer bytebuffer;
        String s1;
        String s2;
        String s3;
        ByteBufferOutputStream bytebufferoutputstream;
        int i;
        if (d2dmessage.origin == null)
        {
            s = "";
        } else
        {
            s = d2dmessage.origin.toString();
        }
        s1 = d2dmessage.originApp;
        s2 = d2dmessage.destination.toString();
        s3 = d2dmessage.destinationApp;
        if (d2dmessage.messageType.equals("DMC"))
        {
            i = d2dmessage.channel;
        } else
        {
            i = -1;
        }
        bytebuffer = ByteBuffer.allocate(s.length() + (k + 3 + j + l + i1 + j + j1 + k1 + j + l1 + i2 + j + j2 + k2 + j + l2) + s1.length() + s2.length() + s3.length());
        bytebufferoutputstream = new ByteBufferOutputStream(bytebuffer);
        try
        {
            mStreamCodec.encodeAsciiString(d2dmessage.messageType, bytebufferoutputstream);
            mStreamCodec.encodeInt(s.length(), bytebufferoutputstream);
            mStreamCodec.encodeAsciiString(s, bytebufferoutputstream);
            mStreamCodec.encodeInt(s1.length(), bytebufferoutputstream);
            mStreamCodec.encodeAsciiString(s1, bytebufferoutputstream);
            mStreamCodec.encodeInt(s2.length(), bytebufferoutputstream);
            mStreamCodec.encodeAsciiString(s2, bytebufferoutputstream);
            mStreamCodec.encodeInt(s3.length(), bytebufferoutputstream);
            mStreamCodec.encodeAsciiString(s3, bytebufferoutputstream);
            mStreamCodec.encodeInt(i, bytebufferoutputstream);
        }
        catch (CodecException codecexception)
        {
            log.error("encode", "CodecException should not be thrown as we are controling header size and encoding", new Object[] {
                codecexception
            });
        }
        bytebuffer.rewind();
        d2dmessage.message.prependPayload(bytebuffer);
        return d2dmessage.message;
    }

}
