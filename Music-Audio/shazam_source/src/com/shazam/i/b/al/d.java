// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.i.b.al;

import com.shazam.android.aq.c;
import com.shazam.android.aq.j;
import com.shazam.android.aq.m;
import com.shazam.android.aq.n;
import com.shazam.android.aq.s;
import com.shazam.i.b.ah.f;
import com.shazam.i.b.au.e;
import com.shazam.i.b.m.a;
import com.shazam.i.b.n.b;
import com.shazam.model.Provider;
import com.shazam.model.store.AvailableProviders;

public final class d
{

    public static s a;

    public static AvailableProviders a()
    {
        com.shazam.server.response.config.AmpConfig ampconfig = com.shazam.i.b.m.a.a().a();
        return (AvailableProviders)com.shazam.i.d.d.g().a(ampconfig);
    }

    public static n b()
    {
        return new m(f.a(), e.a());
    }

    public static Provider c()
    {
        return new j(com.shazam.i.b.n.b.M());
    }

    // Unreferenced inner class com/shazam/i/b/al/d$1

/* anonymous class */
    public static final class _cls1
        implements Provider
    {

        public final Object a()
        {
            return null;
        }

    }

}
