// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a.a;

import com.a.a.a.u;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.CacheResponse;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class i extends CacheResponse
{

    i()
    {
    }

    public final InputStream getBody()
    {
        return new ByteArrayInputStream(u.a);
    }

    public final Map getHeaders()
    {
        HashMap hashmap = new HashMap();
        hashmap.put(null, Collections.singletonList("HTTP/1.1 504 Gateway Timeout"));
        return hashmap;
    }
}
