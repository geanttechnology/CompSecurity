// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.net;

import java.io.IOException;

// Referenced classes of package com.ebay.nautilus.kernel.net:
//            Connector

public static class responseCode extends IOException
{

    private static final long serialVersionUID = 1L;
    private final int responseCode;

    public final int getResponseCode()
    {
        return responseCode;
    }

    public (int i, String s)
    {
        super(s);
        responseCode = i;
    }
}
