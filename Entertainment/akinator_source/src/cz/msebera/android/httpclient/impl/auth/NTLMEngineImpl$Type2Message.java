// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.auth;

import java.io.UnsupportedEncodingException;

// Referenced classes of package cz.msebera.android.httpclient.impl.auth:
//            NTLMEngineImpl, NTLMEngineException

static class targetInfo extends targetInfo
{

    protected byte challenge[];
    protected int flags;
    protected String target;
    protected byte targetInfo[];

    byte[] getChallenge()
    {
        return challenge;
    }

    int getFlags()
    {
        return flags;
    }

    String getTarget()
    {
        return target;
    }

    byte[] getTargetInfo()
    {
        return targetInfo;
    }

    I(String s)
        throws NTLMEngineException
    {
        super(s, 2);
        challenge = new byte[8];
        readBytes(challenge, 24);
        flags = readULong(20);
        if ((flags & 1) == 0)
        {
            throw new NTLMEngineException((new StringBuilder()).append("NTLM type 2 message indicates no support for Unicode. Flags are: ").append(Integer.toString(flags)).toString());
        }
        target = null;
        if (getMessageLength() >= 20)
        {
            s = readSecurityBuffer(12);
            if (s.length != 0)
            {
                try
                {
                    target = new String(s, "UnicodeLittleUnmarked");
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    throw new NTLMEngineException(s.getMessage(), s);
                }
            }
        }
        targetInfo = null;
        if (getMessageLength() >= 48)
        {
            s = readSecurityBuffer(40);
            if (s.length != 0)
            {
                targetInfo = s;
            }
        }
    }
}
