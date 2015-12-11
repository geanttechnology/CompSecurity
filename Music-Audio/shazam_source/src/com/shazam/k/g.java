// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.k;

import com.shazam.android.k.f.t;
import com.shazam.android.k.f.v;
import com.shazam.model.like.Like;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.shazam.k:
//            i

public final class g
    implements i
{

    private final Map a = new HashMap();
    private final v b;
    private final t c;

    public g(v v1, t t1)
    {
        b = v1;
        c = t1;
    }

    public final Like a(String s)
    {
        return (Like)a.get(s);
    }

    public final void a()
    {
        a.clear();
    }

    public final void a(Like like)
    {
        a.put(like.key, like);
        b.a(c.k(like.key));
    }

    public final boolean b()
    {
        return a.isEmpty();
    }
}
