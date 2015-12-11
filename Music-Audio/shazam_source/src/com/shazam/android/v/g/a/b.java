// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.v.g.a;

import com.shazam.android.an.b.h;
import com.shazam.android.an.b.y;
import com.shazam.model.Factory;

public final class b
    implements Factory
{

    private final h a;

    public b(h h)
    {
        a = h;
    }

    public final Object create(Object obj)
    {
        obj = (String)obj;
        return new y(a, ((String) (obj)));
    }
}
