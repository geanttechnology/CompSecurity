// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.auth;

import com.comcast.cim.commonscodecandroid.binary.Base64;
import com.comcast.cim.httpcomponentsandroid.util.EncodingUtils;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.impl.auth:
//            NTLMEngineImpl, NTLMEngineException

static class messageContents
{

    private int currentOutputPosition;
    private byte messageContents[];

    protected void addByte(byte byte0)
    {
        messageContents[currentOutputPosition] = byte0;
        currentOutputPosition = currentOutputPosition + 1;
    }

    protected void addBytes(byte abyte0[])
    {
        for (int i = 0; i < abyte0.length; i++)
        {
            messageContents[currentOutputPosition] = abyte0[i];
            currentOutputPosition = currentOutputPosition + 1;
        }

    }

    protected void addULong(int i)
    {
        addByte((byte)(i & 0xff));
        addByte((byte)(i >> 8 & 0xff));
        addByte((byte)(i >> 16 & 0xff));
        addByte((byte)(i >> 24 & 0xff));
    }

    protected void addUShort(int i)
    {
        addByte((byte)(i & 0xff));
        addByte((byte)(i >> 8 & 0xff));
    }

    protected int getMessageLength()
    {
        return currentOutputPosition;
    }

    String getResponse()
    {
        byte abyte0[];
        if (messageContents.length > currentOutputPosition)
        {
            abyte0 = new byte[currentOutputPosition];
            for (int i = 0; i < currentOutputPosition; i++)
            {
                abyte0[i] = messageContents[i];
            }

        } else
        {
            abyte0 = messageContents;
        }
        return EncodingUtils.getAsciiString(Base64.encodeBase64(abyte0));
    }

    protected void prepareResponse(int i, int j)
    {
        messageContents = new byte[i];
        currentOutputPosition = 0;
        addBytes(NTLMEngineImpl.access$000());
        addULong(j);
    }

    protected void readBytes(byte abyte0[], int i)
        throws NTLMEngineException
    {
        if (messageContents.length < abyte0.length + i)
        {
            throw new NTLMEngineException("NTLM: Message too short");
        } else
        {
            System.arraycopy(messageContents, i, abyte0, 0, abyte0.length);
            return;
        }
    }

    protected byte[] readSecurityBuffer(int i)
        throws NTLMEngineException
    {
        return NTLMEngineImpl.access$300(messageContents, i);
    }

    protected int readULong(int i)
        throws NTLMEngineException
    {
        return NTLMEngineImpl.access$200(messageContents, i);
    }

    ()
    {
        messageContents = null;
        currentOutputPosition = 0;
    }

    currentOutputPosition(String s, int i)
        throws NTLMEngineException
    {
        messageContents = null;
        currentOutputPosition = 0;
        messageContents = Base64.decodeBase64(EncodingUtils.getBytes(s, "ASCII"));
        if (messageContents.length < NTLMEngineImpl.access$000().length)
        {
            throw new NTLMEngineException("NTLM message decoding error - packet too short");
        }
        for (int j = 0; j < NTLMEngineImpl.access$000().length; j++)
        {
            if (messageContents[j] != NTLMEngineImpl.access$000()[j])
            {
                throw new NTLMEngineException("NTLM message expected - instead got unrecognized bytes");
            }
        }

        int k = readULong(NTLMEngineImpl.access$000().length);
        if (k != i)
        {
            throw new NTLMEngineException((new StringBuilder()).append("NTLM type ").append(Integer.toString(i)).append(" message expected - instead got type ").append(Integer.toString(k)).toString());
        } else
        {
            currentOutputPosition = messageContents.length;
            return;
        }
    }
}
