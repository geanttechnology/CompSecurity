// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.http;

import java.io.Serializable;
import org.apache.http.util.CharArrayBuffer;

public class ProtocolVersion
    implements Serializable, Cloneable
{

    protected final int major;
    protected final int minor;
    protected final String protocol;

    public ProtocolVersion(String s, int i, int j)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Protocol name must not be null.");
        }
        if (i < 0)
        {
            throw new IllegalArgumentException("Protocol major version number must not be negative.");
        }
        if (j < 0)
        {
            throw new IllegalArgumentException("Protocol minor version number may not be negative");
        } else
        {
            protocol = s;
            major = i;
            minor = j;
            return;
        }
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        return super.clone();
    }

    public final boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof ProtocolVersion))
            {
                return false;
            }
            obj = (ProtocolVersion)obj;
            if (!protocol.equals(((ProtocolVersion) (obj)).protocol) || major != ((ProtocolVersion) (obj)).major || minor != ((ProtocolVersion) (obj)).minor)
            {
                return false;
            }
        }
        return true;
    }

    public final int getMajor()
    {
        return major;
    }

    public final int getMinor()
    {
        return minor;
    }

    public final String getProtocol()
    {
        return protocol;
    }

    public final int hashCode()
    {
        return protocol.hashCode() ^ major * 0x186a0 ^ minor;
    }

    public String toString()
    {
        CharArrayBuffer chararraybuffer = new CharArrayBuffer(16);
        chararraybuffer.append(protocol);
        chararraybuffer.append('/');
        chararraybuffer.append(Integer.toString(major));
        chararraybuffer.append('.');
        chararraybuffer.append(Integer.toString(minor));
        return chararraybuffer.toString();
    }
}
