// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import com.squareup.okhttp.internal.okio.ByteString;

public final class Protocol extends Enum
{

    private static final Protocol $VALUES[];
    public static final Protocol HTTP_11;
    public static final Protocol HTTP_2;
    public static final Protocol SPDY_3;
    public final ByteString name;
    public final boolean spdyVariant;

    private Protocol(String s, int i, String s1, boolean flag)
    {
        super(s, i);
        name = ByteString.encodeUtf8(s1);
        spdyVariant = flag;
    }

    public static Protocol valueOf(String s)
    {
        return (Protocol)Enum.valueOf(com/squareup/okhttp/Protocol, s);
    }

    public static Protocol[] values()
    {
        return (Protocol[])$VALUES.clone();
    }

    static 
    {
        HTTP_2 = new Protocol("HTTP_2", 0, "HTTP-draft-09/2.0", true);
        SPDY_3 = new Protocol("SPDY_3", 1, "spdy/3.1", true);
        HTTP_11 = new Protocol("HTTP_11", 2, "http/1.1", false);
        $VALUES = (new Protocol[] {
            HTTP_2, SPDY_3, HTTP_11
        });
    }
}
