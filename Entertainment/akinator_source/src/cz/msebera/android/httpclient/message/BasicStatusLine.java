// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.message;

import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.io.Serializable;

// Referenced classes of package cz.msebera.android.httpclient.message:
//            BasicLineFormatter

public class BasicStatusLine
    implements StatusLine, Cloneable, Serializable
{

    private static final long serialVersionUID = 0xde17a42b501ecf7bL;
    private final ProtocolVersion protoVersion;
    private final String reasonPhrase;
    private final int statusCode;

    public BasicStatusLine(ProtocolVersion protocolversion, int i, String s)
    {
        protoVersion = (ProtocolVersion)Args.notNull(protocolversion, "Version");
        statusCode = Args.notNegative(i, "Status code");
        reasonPhrase = s;
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
        return BasicLineFormatter.INSTANCE.formatStatusLine(null, this).toString();
    }
}
