// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication.rmr;

import amazon.communication.CommunicationBaseException;
import amazon.communication.Message;
import amazon.communication.MessageFactory;
import amazon.communication.identity.EndpointIdentity;
import com.amazon.communication.ProtocolException;
import com.amazon.dp.logger.DPLogger;
import com.dp.framework.ByteBufferOutputStream;
import com.dp.framework.CodecException;
import com.dp.framework.StreamCodec;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Set;

public abstract class RmrProtocolHandler
{

    public static final String LAST_RESPONSE_MSG_TYPE = "LST";
    public static final String NEW_STYLE_LAST_RESPONSE_MSG_TYPE = "NLS";
    public static final String NEW_STYLE_REQUEST_MSG_TYPE = "NRQ";
    public static final String NEW_STYLE_RESPONSE_RESPONSE_MSG_TYPE = "NRP";
    public static final String REQUEST_MSG_TYPE = "RQS";
    public static final String RESPONSE_RESPONSE_MSG_TYPE = "RPY";
    public static final int SIZE_OF_MESSAGE_TYPE = 3;
    public static final int START_OF_SEQUENCE_NUMBER = 0;
    private static final DPLogger log = new DPLogger("TComm.RmrProtocolHandler");
    private static final Set rmrMessageTypes = new HashSet();
    private final int mDelimiterSize;
    private final StreamCodec mStreamCodec;

    public RmrProtocolHandler(StreamCodec streamcodec)
    {
        mStreamCodec = streamcodec;
        mDelimiterSize = streamcodec.getSizeOfDelimiter();
        rmrMessageTypes.add("RQS");
        rmrMessageTypes.add("LST");
        rmrMessageTypes.add("RPY");
        rmrMessageTypes.add("NRQ");
        rmrMessageTypes.add("NLS");
        rmrMessageTypes.add("NRP");
    }

    private int extractSequenceNumber(InputStream inputstream, String s)
        throws CodecException
    {
        int i = 0;
        if (isNewStyleMessageType(s))
        {
            i = mStreamCodec.decodeInt(inputstream);
        }
        return i;
    }

    private boolean isNewStyleMessageType(String s)
    {
        return s.equals("NRQ") || s.equals("NRP") || s.equals("NLS");
    }

    public void decodeMessage(EndpointIdentity endpointidentity, Message message)
        throws CommunicationBaseException
    {
        String s;
        try
        {
            InputStream inputstream = message.getPayload();
            s = mStreamCodec.decodeAsciiString(inputstream, 3);
            if (rmrMessageTypes.contains(s))
            {
                int i = mStreamCodec.decodeInt(inputstream);
                int j = extractSequenceNumber(inputstream, s);
                log.debug("decodeMessage", "decoded message", new Object[] {
                    "messageType", s, "requestId", Integer.valueOf(i), "sequenceNumber", Integer.valueOf(j)
                });
                handleRmrMessage(endpointidentity, s, i, message.extractPayload(), j);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (EndpointIdentity endpointidentity)
        {
            throw new ProtocolException(endpointidentity);
        }
        throw new ProtocolException((new StringBuilder()).append("Unknown RMR message type: ").append(s).toString());
    }

    public Message encodeLast(int i, int j)
    {
        return encodeMessage(MessageFactory.createMessage(ByteBuffer.wrap(new byte[] {
            0
        })), "NLS", i, j);
    }

    public Message encodeMessage(Message message, String s, int i, int j)
    {
        log.debug("encodeMessage", "beginning execution", new Object[] {
            "messageType", s, "requestId", Integer.valueOf(i), "sequenceNumber", Integer.valueOf(j)
        });
        if (!rmrMessageTypes.contains(s))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Unexpected message type: ").append(s).toString());
        }
        boolean flag = isNewStyleMessageType(s);
        int l = mStreamCodec.getSizeOfEncodedMaxInteger();
        int i1 = mDelimiterSize;
        ByteBuffer bytebuffer;
        ByteBufferOutputStream bytebufferoutputstream;
        int k;
        if (flag)
        {
            k = mDelimiterSize + l;
        } else
        {
            k = 0;
        }
        bytebuffer = ByteBuffer.allocate(k + (i1 + 3 + l) + mDelimiterSize);
        bytebufferoutputstream = new ByteBufferOutputStream(bytebuffer);
        mStreamCodec.encodeAsciiString(s, bytebufferoutputstream);
        mStreamCodec.encodeInt(i, bytebufferoutputstream);
        if (flag)
        {
            try
            {
                mStreamCodec.encodeInt(j, bytebufferoutputstream);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                log.error("encodeMessage", "CodecException shouldn't be thrown as we are controling header size and encoding", new Object[] {
                    s
                });
            }
        }
        bytebuffer.rewind();
        message.prependPayload(bytebuffer);
        return message;
    }

    public Message encodeOldStyleLast(int i)
    {
        return encodeMessage(MessageFactory.createMessage(ByteBuffer.wrap(new byte[] {
            0
        })), "LST", i, 0);
    }

    public Message encodeOldStyleRequest(Message message, int i)
    {
        return encodeMessage(message, "RQS", i, 0);
    }

    public Message encodeOldStyleResponse(Message message, int i)
    {
        return encodeMessage(message, "RPY", i, 0);
    }

    public Message encodeRequest(Message message, int i, int j)
    {
        return encodeMessage(message, "NRQ", i, j);
    }

    public Message encodeResponse(Message message, int i, int j)
    {
        return encodeMessage(message, "NRP", i, j);
    }

    public String getProtocolName()
    {
        return (new StringBuilder()).append("R:").append(mStreamCodec.getName()).toString();
    }

    protected abstract void handleRmrMessage(EndpointIdentity endpointidentity, String s, int i, Message message, int j)
        throws CommunicationBaseException;

}
