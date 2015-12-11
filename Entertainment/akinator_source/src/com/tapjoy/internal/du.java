// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.io.IOException;

// Referenced classes of package com.tapjoy.internal:
//            dx

public final class du extends IOException
{

    private dx a;

    public du(String s)
    {
        super(s);
        a = null;
    }

    static du a()
    {
        return new du("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    static du b()
    {
        return new du("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static du c()
    {
        return new du("CodedInputStream encountered a malformed varint.");
    }

    static du d()
    {
        return new du("Protocol message contained an invalid tag (zero).");
    }

    static du e()
    {
        return new du("Protocol message end-group tag did not match expected tag.");
    }

    static du f()
    {
        return new du("Protocol message tag had invalid wire type.");
    }

    static du g()
    {
        return new du("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    static du h()
    {
        return new du("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    public final du a(dx dx)
    {
        a = dx;
        return this;
    }
}
