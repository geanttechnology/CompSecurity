// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK.libcore;

import java.io.InputStream;
import java.net.CacheResponse;
import java.util.Map;

// Referenced classes of package com.twinprime.TwinPrimeSDK.libcore:
//            HttpResponseCache, RawHeaders

public static class is extends CacheResponse
{

    private final entry entry;
    private final InputStream is;

    public InputStream getBody()
    {
        return is;
    }

    public Map getHeaders()
    {
        return entry.entry.toMultimap(true);
    }

    public ( ,  1)
    {
        entry = ;
        is = 1.is(1);
    }
}
