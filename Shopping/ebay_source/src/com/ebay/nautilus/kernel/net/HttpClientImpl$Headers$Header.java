// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.net;

import org.apache.http.Header;

// Referenced classes of package com.ebay.nautilus.kernel.net:
//            IHeader, HttpClientImpl

static final class h
    implements IHeader
{

    private final Header h;

    public String getName()
    {
        return h.getName();
    }

    public String getValue()
    {
        return h.getValue();
    }

    public (Header header)
    {
        h = header;
    }
}
