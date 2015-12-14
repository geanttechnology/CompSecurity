// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jivesoftware.smack;

import org.jivesoftware.smack.packet.h;

// Referenced classes of package org.jivesoftware.smack:
//            XMPPException

public class streamError extends XMPPException
{

    private static final long serialVersionUID = 0x2f31347428167f76L;
    private final h streamError;

    public h a()
    {
        return streamError;
    }

    public String getMessage()
    {
        return streamError.toString();
    }

    public String toString()
    {
        return getMessage();
    }

    public (h h1)
    {
        streamError = h1;
    }
}
