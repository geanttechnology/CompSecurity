// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import okio.ByteString;

public final class Header
{

    public static final ByteString RESPONSE_STATUS = ByteString.a(":status");
    public static final ByteString TARGET_AUTHORITY = ByteString.a(":authority");
    public static final ByteString TARGET_HOST = ByteString.a(":host");
    public static final ByteString TARGET_METHOD = ByteString.a(":method");
    public static final ByteString TARGET_PATH = ByteString.a(":path");
    public static final ByteString TARGET_SCHEME = ByteString.a(":scheme");
    public static final ByteString VERSION = ByteString.a(":version");
    final int hpackSize;
    public final ByteString name;
    public final ByteString value;

    public Header(String s, String s1)
    {
        this(ByteString.a(s), ByteString.a(s1));
    }

    public Header(ByteString bytestring, String s)
    {
        this(bytestring, ByteString.a(s));
    }

    public Header(ByteString bytestring, ByteString bytestring1)
    {
        name = bytestring;
        value = bytestring1;
        hpackSize = bytestring.e() + 32 + bytestring1.e();
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof Header)
        {
            obj = (Header)obj;
            flag = flag1;
            if (name.equals(((Header) (obj)).name))
            {
                flag = flag1;
                if (value.equals(((Header) (obj)).value))
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public int hashCode()
    {
        return (name.hashCode() + 527) * 31 + value.hashCode();
    }

    public String toString()
    {
        return String.format("%s: %s", new Object[] {
            name.a(), value.a()
        });
    }

}
