// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.persistence.c;

import com.shazam.k.b;

public final class a
    implements b
{

    private final com.shazam.android.persistence.n.b b;

    public a(com.shazam.android.persistence.n.b b1)
    {
        b = b1;
    }

    public final String a()
    {
        return b.h("pk_amp_k");
    }

    public final void a(String s)
    {
        b.b("pk_amp_k", s);
    }
}
