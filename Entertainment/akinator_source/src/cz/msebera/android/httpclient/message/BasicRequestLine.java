// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.message;

import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.RequestLine;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.io.Serializable;

// Referenced classes of package cz.msebera.android.httpclient.message:
//            BasicLineFormatter

public class BasicRequestLine
    implements RequestLine, Cloneable, Serializable
{

    private static final long serialVersionUID = 0x2701312e8d8938a9L;
    private final String method;
    private final ProtocolVersion protoversion;
    private final String uri;

    public BasicRequestLine(String s, String s1, ProtocolVersion protocolversion)
    {
        method = (String)Args.notNull(s, "Method");
        uri = (String)Args.notNull(s1, "URI");
        protoversion = (ProtocolVersion)Args.notNull(protocolversion, "Version");
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        return super.clone();
    }

    public String getMethod()
    {
        return method;
    }

    public ProtocolVersion getProtocolVersion()
    {
        return protoversion;
    }

    public String getUri()
    {
        return uri;
    }

    public String toString()
    {
        return BasicLineFormatter.INSTANCE.formatRequestLine(null, this).toString();
    }
}
