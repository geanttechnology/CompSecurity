// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.i.k.a;

import com.shazam.i.b.ad.a.a;
import com.shazam.i.b.ah.c.d;
import com.shazam.model.account.RepositoryBackedUserStateDecider;
import com.shazam.model.account.UserStateDecider;

public final class b
{

    private static final RepositoryBackedUserStateDecider a = new RepositoryBackedUserStateDecider(com.shazam.i.b.ad.a.a.a(), d.a());

    public static UserStateDecider a()
    {
        return a;
    }

}
