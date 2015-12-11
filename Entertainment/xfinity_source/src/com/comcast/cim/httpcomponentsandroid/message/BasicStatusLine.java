// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.message;

import com.comcast.cim.httpcomponentsandroid.ProtocolVersion;
import com.comcast.cim.httpcomponentsandroid.StatusLine;
import com.comcast.cim.httpcomponentsandroid.util.CharArrayBuffer;
import java.io.Serializable;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.message:
//            BasicLineFormatter

public class BasicStatusLine
    implements StatusLine, Serializable, Cloneable
{

    private final ProtocolVersion protoVersion;
    private final String reasonPhrase;
    private final int statusCode;

    public BasicStatusLine(ProtocolVersion protocolversion, int i, String s)
    {
        if (protocolversion == null)
        {
            throw new IllegalArgumentException("Protocol version may not be null.");
        }
        if (i < 0)
        {
            throw new IllegalArgumentException("Status code may not be negative.");
        } else
        {
            protoVersion = protocolversion;
            statusCode = i;
            reasonPhrase = s;
            return;
        }
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        return super.clone();
    }

    public ProtocolVersion getProtocolVersion()
    {
        return protoVersion;
    }

    public String getReasonPhrase()
    {
        return reasonPhrase;
    }

    public int getStatusCode()
    {
        return statusCode;
    }

    public String toString()
    {
        return BasicLineFormatter.DEFAULT.formatStatusLine(null, this).toString();
    }
}
