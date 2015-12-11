// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl;


// Referenced classes of package com.comcast.cim.httpcomponentsandroid.impl:
//            SocketHttpServerConnection

public class DefaultHttpServerConnection extends SocketHttpServerConnection
{

    public DefaultHttpServerConnection()
    {
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("[");
        if (isOpen())
        {
            stringbuffer.append(getRemotePort());
        } else
        {
            stringbuffer.append("closed");
        }
        stringbuffer.append("]");
        return stringbuffer.toString();
    }
}
