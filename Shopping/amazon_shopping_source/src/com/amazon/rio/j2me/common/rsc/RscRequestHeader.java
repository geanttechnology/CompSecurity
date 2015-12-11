// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.common.rsc;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Date;

public class RscRequestHeader
{

    private final String applicationID;
    private final byte cookieJar[];
    private final String requestMethod;
    private final long requestTimeUtcMillis;
    private final byte secureCookieJar[];
    private final byte securityType;
    private final String serviceName;

    public static byte[] readByteArray(DataInputStream datainputstream)
        throws IOException
    {
        short word0 = datainputstream.readShort();
        byte abyte0[] = null;
        if (word0 != -1)
        {
            abyte0 = new byte[word0];
            datainputstream.readFully(abyte0);
        }
        return abyte0;
    }

    public static void writeByteArray(DataOutputStream dataoutputstream, byte abyte0[])
        throws IOException
    {
        if (abyte0 == null)
        {
            dataoutputstream.writeShort(-1);
            return;
        } else
        {
            dataoutputstream.writeShort(abyte0.length);
            dataoutputstream.write(abyte0);
            return;
        }
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append('[');
        stringbuffer.append("rscVersion=").append(0);
        stringbuffer.append(", securityType=").append(securityType);
        stringbuffer.append(", serviceName=").append(serviceName);
        stringbuffer.append(", requestMethod=").append(requestMethod);
        stringbuffer.append(", applicationID=").append(applicationID);
        stringbuffer.append(", requestTimeUtcMillis=").append(new Date(requestTimeUtcMillis));
        if (cookieJar == null)
        {
            stringbuffer.append(", cookieJar=null");
        } else
        {
            stringbuffer.append(", cookieJar.length=").append(cookieJar.length);
        }
        if (secureCookieJar == null)
        {
            stringbuffer.append(", secureCookieJar=null");
        } else
        {
            stringbuffer.append(", secureCookieJar.length=").append(secureCookieJar.length);
        }
        stringbuffer.append(']');
        return stringbuffer.toString();
    }
}
