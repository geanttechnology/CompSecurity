// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.IOException;

public class agz extends IOException
{

    public agz(String s)
    {
        super(s);
    }

    static agz a()
    {
        return new agz("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    static agz b()
    {
        return new agz("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static agz c()
    {
        return new agz("CodedInputStream encountered a malformed varint.");
    }

    static agz d()
    {
        return new agz("Protocol message contained an invalid tag (zero).");
    }

    static agz e()
    {
        return new agz("Protocol message end-group tag did not match expected tag.");
    }

    static agz f()
    {
        return new agz("Protocol message tag had invalid wire type.");
    }

    static agz g()
    {
        return new agz("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }
}
