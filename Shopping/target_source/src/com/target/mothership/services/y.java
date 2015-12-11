// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services;

import com.a.a.a.e;
import com.a.a.j;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Map;

// Referenced classes of package com.target.mothership.services:
//            v, z

public class y extends j
    implements v
{

    private final Map immutableHeaders;
    private final String mResponseString;

    public y(int i, byte abyte0[], Map map, boolean flag, long l)
    {
        super(i, abyte0, map, flag, l);
        mResponseString = a(abyte0, map);
        immutableHeaders = Collections.unmodifiableMap(map);
    }

    public y(byte abyte0[])
    {
        super(abyte0);
        mResponseString = a(abyte0, Collections.emptyMap());
        immutableHeaders = Collections.unmodifiableMap(Collections.emptyMap());
    }

    private String a(byte abyte0[], Map map)
    {
        return new String(abyte0, Charset.forName(e.a(map, "UTF-8")));
    }

    public String a()
    {
        return mResponseString;
    }

    public z b()
    {
        return z.a(statusCode);
    }

    public Map c()
    {
        return immutableHeaders;
    }

    public long d()
    {
        return networkTimeMs;
    }
}
