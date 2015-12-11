// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.a.a.a;

import com.shazam.android.ay.b.d;
import com.shazam.model.AutoTag;
import java.util.List;

// Referenced classes of package com.shazam.a.a.a:
//            g, d

public final class b extends g
    implements com.shazam.a.a.a.d
{

    public final AutoTag a;
    public final List b;
    private final long d;
    private final long e;

    public b(d d1, AutoTag autotag, List list, long l, long l1)
    {
        super(d1);
        a = autotag;
        b = list;
        e = l;
        d = l1;
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
