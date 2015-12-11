// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import java.io.IOException;

public final class lb extends IOException
{

    private lb(String s)
    {
        super(s);
    }

    static lb a()
    {
        return new lb("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    static lb b()
    {
        return new lb("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static lb c()
    {
        return new lb("CodedInputStream encountered a malformed varint.");
    }

    static lb d()
    {
        return new lb("Protocol message contained an invalid tag (zero).");
    }

    static lb e()
    {
        return new lb("Protocol message end-group tag did not match expected tag.");
    }

    static lb f()
    {
        return new lb("Protocol message tag had invalid wire type.");
    }

    static lb g()
    {
        return new lb("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }
}
