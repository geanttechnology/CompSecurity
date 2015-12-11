// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid;

import com.comcast.cim.httpcomponentsandroid.util.CharArrayBuffer;
import java.io.Serializable;

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

    public int compareToVersion(ProtocolVersion protocolversion)
    {
        if (protocolversion == null)
        {
            throw new IllegalArgumentException("Protocol version must not be null.");
        }
        if (!protocol.equals(protocolversion.protocol))
        {
            throw new IllegalArgumentException("Versions for different protocols cannot be compared. " + this + " " + protocolversion);
        }
        int j = getMajor() - protocolversion.getMajor();
        int i = j;
        if (j == 0)
        {
            i = getMinor() - protocolversion.getMinor();
        }
        return i;
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

    public ProtocolVersion forVersion(int i, int j)
    {
        if (i == major && j == minor)
        {
            return this;
        } else
        {
            return new ProtocolVersion(protocol, i, j);
        }
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

    public boolean isComparable(ProtocolVersion protocolversion)
    {
        return protocolversion != null && protocol.equals(protocolversion.protocol);
    }

    public final boolean lessEquals(ProtocolVersion protocolversion)
    {
        return isComparable(protocolversion) && compareToVersion(protocolversion) <= 0;
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
