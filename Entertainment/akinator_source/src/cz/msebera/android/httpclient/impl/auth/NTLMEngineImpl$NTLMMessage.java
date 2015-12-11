// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.auth;

import cz.msebera.android.httpclient.extras.Base64;
import cz.msebera.android.httpclient.util.EncodingUtils;

// Referenced classes of package cz.msebera.android.httpclient.impl.auth:
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
        if (abyte0 != null)
        {
            int j = abyte0.length;
            int i = 0;
            while (i < j) 
            {
                byte byte0 = abyte0[i];
                messageContents[currentOutputPosition] = byte0;
                currentOutputPosition = currentOutputPosition + 1;
                i++;
            }
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

    protected int getPreambleLength()
    {
        return NTLMEngineImpl.access$1000().length + 4;
    }

    String getResponse()
    {
        byte abyte0[];
        if (messageContents.length > currentOutputPosition)
        {
            abyte0 = new byte[currentOutputPosition];
            System.arraycopy(messageContents, 0, abyte0, 0, currentOutputPosition);
        } else
        {
            abyte0 = messageContents;
        }
        return EncodingUtils.getAsciiString(Base64.encode(abyte0, 2));
    }

    protected void prepareResponse(int i, int j)
    {
        messageContents = new byte[i];
        currentOutputPosition = 0;
        addBytes(NTLMEngineImpl.access$1000());
        addULong(j);
    }

    protected byte readByte(int i)
        throws NTLMEngineException
    {
        if (messageContents.length < i + 1)
        {
            throw new NTLMEngineException("NTLM: Message too short");
        } else
        {
            return messageContents[i];
        }
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
        return NTLMEngineImpl.access$1300(messageContents, i);
    }

    protected int readULong(int i)
        throws NTLMEngineException
    {
        return NTLMEngineImpl.access$1200(messageContents, i);
    }

    protected int readUShort(int i)
        throws NTLMEngineException
    {
        return NTLMEngineImpl.access$1100(messageContents, i);
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
        messageContents = Base64.decode(EncodingUtils.getBytes(s, "ASCII"), 2);
        if (messageContents.length < NTLMEngineImpl.access$1000().length)
        {
            throw new NTLMEngineException("NTLM message decoding error - packet too short");
        }
        for (int j = 0; j < NTLMEngineImpl.access$1000().length; j++)
        {
            if (messageContents[j] != NTLMEngineImpl.access$1000()[j])
            {
                throw new NTLMEngineException("NTLM message expected - instead got unrecognized bytes");
            }
        }

        int k = readULong(NTLMEngineImpl.access$1000().length);
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
