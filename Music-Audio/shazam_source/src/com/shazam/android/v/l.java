// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.v;

import com.shazam.c.h.a;
import com.shazam.c.h.b;
import com.shazam.c.h.c;
import com.shazam.c.h.d;
import com.shazam.model.Factory;

public final class l
    implements Factory
{

    public l()
    {
    }

    public final Object create(Object obj)
    {
        obj = (Long)obj;
        return new c(new d(), new a(new b()), ((Long) (obj)));
    }
}
