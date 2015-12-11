// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.IOException;

public final class euf extends IOException
{

    private static final long serialVersionUID = 0xe9924688c2f20054L;

    private euf(String s)
    {
        super(s);
    }

    static euf a()
    {
        return new euf("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    static euf b()
    {
        return new euf("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static euf c()
    {
        return new euf("CodedInputStream encountered a malformed varint.");
    }

    static euf d()
    {
        return new euf("Protocol message contained an invalid tag (zero).");
    }

    static euf e()
    {
        return new euf("Protocol message end-group tag did not match expected tag.");
    }

    static euf f()
    {
        return new euf("Protocol message tag had invalid wire type.");
    }

    static euf g()
    {
        return new euf("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    static euf h()
    {
        return new euf("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }
}
