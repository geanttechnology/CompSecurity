// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.IOException;

public final class eum extends IOException
{

    private static final long serialVersionUID = 0xe9924688c2f20054L;

    private eum(String s)
    {
        super(s);
    }

    static eum a()
    {
        return new eum("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    static eum b()
    {
        return new eum("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static eum c()
    {
        return new eum("CodedInputStream encountered a malformed varint.");
    }

    static eum d()
    {
        return new eum("Protocol message contained an invalid tag (zero).");
    }

    static eum e()
    {
        return new eum("Protocol message end-group tag did not match expected tag.");
    }

    static eum f()
    {
        return new eum("Protocol message tag had invalid wire type.");
    }

    static eum g()
    {
        return new eum("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }
}
