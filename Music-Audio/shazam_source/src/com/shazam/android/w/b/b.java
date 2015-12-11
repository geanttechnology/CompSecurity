// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.w.b;

import com.shazam.model.social.ConnectionState;

public final class b
    implements ConnectionState
{

    private final com.shazam.android.persistence.n.b a;

    public b(com.shazam.android.persistence.n.b b1)
    {
        a = b1;
    }

    public final boolean a()
    {
        return !"disconnected".equals(a.a("pk_gp_re", "disconnected"));
    }
}
