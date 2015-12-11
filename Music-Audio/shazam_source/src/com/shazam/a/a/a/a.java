// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.a.a.a;

import com.shazam.android.ay.b.d;
import com.shazam.server.response.recognition.TagResponseOverride;

// Referenced classes of package com.shazam.a.a.a:
//            g, d

public final class a extends g
    implements com.shazam.a.a.a.d
{

    public final TagResponseOverride a;
    private final d b;
    private final long d;
    private final long e;

    public a(d d1, TagResponseOverride tagresponseoverride, long l, long l1)
    {
        super(d1);
        b = d1;
        a = tagresponseoverride;
        d = l;
        e = l1;
    }

    public final long a()
    {
        return d;
    }

    public final long b()
    {
        return e;
    }
}
