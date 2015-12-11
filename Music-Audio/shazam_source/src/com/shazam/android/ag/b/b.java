// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ag.b;

import com.shazam.android.k.f.b.a;
import com.shazam.android.k.f.r;
import com.shazam.model.details.TagDeletableDecider;

public final class b
    implements TagDeletableDecider
{

    private final r a;

    public b(r r1)
    {
        a = r1;
    }

    public final boolean a()
    {
        return a.b == a.a || a.b == a.j;
    }
}
