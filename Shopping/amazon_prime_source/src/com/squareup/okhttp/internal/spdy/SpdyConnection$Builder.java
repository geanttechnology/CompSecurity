// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.okio.BufferedSink;
import com.squareup.okhttp.internal.okio.BufferedSource;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            SpdyConnection, IncomingStreamHandler, PushObserver

public static class sink
{

    private boolean client;
    private IncomingStreamHandler handler;
    private String hostName;
    private Protocol protocol;
    private PushObserver pushObserver;
    private BufferedSink sink;
    private BufferedSource source;

    public SpdyConnection build()
    {
        return new SpdyConnection(this, null);
    }

    public sink protocol(Protocol protocol1)
    {
        protocol = protocol1;
        return this;
    }








    public (String s, boolean flag, BufferedSource bufferedsource, BufferedSink bufferedsink)
    {
        handler = IncomingStreamHandler.REFUSE_INCOMING_STREAMS;
        protocol = Protocol.SPDY_3;
        pushObserver = PushObserver.CANCEL;
        hostName = s;
        client = flag;
        source = bufferedsource;
        sink = bufferedsink;
    }
}
