// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a;

import java.util.Collections;
import java.util.Map;

public class j
{

    public final byte data[];
    public final Map headers;
    public final long networkTimeMs;
    public final boolean notModified;
    public final int statusCode;

    public j(int i, byte abyte0[], Map map, boolean flag, long l)
    {
        statusCode = i;
        data = abyte0;
        headers = map;
        notModified = flag;
        networkTimeMs = l;
    }

    public j(byte abyte0[])
    {
        this(200, abyte0, Collections.emptyMap(), false, 0L);
    }

    public j(byte abyte0[], Map map)
    {
        this(200, abyte0, map, false, 0L);
    }
}
