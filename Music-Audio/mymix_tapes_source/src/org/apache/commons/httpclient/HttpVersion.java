// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient;


// Referenced classes of package org.apache.commons.httpclient:
//            ProtocolException

public class HttpVersion
    implements Comparable
{

    public static final HttpVersion HTTP_0_9 = new HttpVersion(0, 9);
    public static final HttpVersion HTTP_1_0 = new HttpVersion(1, 0);
    public static final HttpVersion HTTP_1_1 = new HttpVersion(1, 1);
    private int major;
    private int minor;

    public HttpVersion(int i, int j)
    {
        major = 0;
        minor = 0;
        if (i < 0)
        {
            throw new IllegalArgumentException("HTTP major version number may not be negative");
        }
        major = i;
        if (j < 0)
        {
            throw new IllegalArgumentException("HTTP minor version number may not be negative");
        } else
        {
            minor = j;
            return;
        }
    }

    public static HttpVersion parse(String s)
        throws ProtocolException
    {
        if (s == null)
        {
            throw new IllegalArgumentException("String may not be null");
        }
        if (!s.startsWith("HTTP/"))
        {
            throw new ProtocolException("Invalid HTTP version string: " + s);
        }
        int j = "HTTP/".length();
        int i = s.indexOf(".", j);
        if (i == -1)
        {
            throw new ProtocolException("Invalid HTTP version number: " + s);
        }
        int k;
        try
        {
            j = Integer.parseInt(s.substring(j, i));
        }
        catch (NumberFormatException numberformatexception)
        {
            throw new ProtocolException("Invalid HTTP major version number: " + s);
        }
        k = s.length();
        try
        {
            i = Integer.parseInt(s.substring(i + 1, k));
        }
        catch (NumberFormatException numberformatexception1)
        {
            throw new ProtocolException("Invalid HTTP minor version number: " + s);
        }
        return new HttpVersion(j, i);
    }

    public int compareTo(Object obj)
    {
        return compareTo((HttpVersion)obj);
    }

    public int compareTo(HttpVersion httpversion)
    {
        if (httpversion == null)
        {
            throw new IllegalArgumentException("Version parameter may not be null");
        }
        int j = getMajor() - httpversion.getMajor();
        int i = j;
        if (j == 0)
        {
            i = getMinor() - httpversion.getMinor();
        }
        return i;
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof HttpVersion))
        {
            return false;
        } else
        {
            return equals((HttpVersion)obj);
        }
    }

    public boolean equals(HttpVersion httpversion)
    {
        return compareTo(httpversion) == 0;
    }

    public int getMajor()
    {
        return major;
    }

    public int getMinor()
    {
        return minor;
    }

    public boolean greaterEquals(HttpVersion httpversion)
    {
        return compareTo(httpversion) >= 0;
    }

    public int hashCode()
    {
        return major * 0x186a0 + minor;
    }

    public boolean lessEquals(HttpVersion httpversion)
    {
        return compareTo(httpversion) <= 0;
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("HTTP/");
        stringbuffer.append(major);
        stringbuffer.append('.');
        stringbuffer.append(minor);
        return stringbuffer.toString();
    }

}
