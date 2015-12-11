// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.support.v7.kx;
import android.support.v7.vn;
import android.support.v7.vo;
import android.support.v7.wf;
import com.google.android.gms.common.internal.x;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            ag, w, a, z, 
//            m, g, ad, x, 
//            h, n, v, i, 
//            u, ah, j, r

public class s
{

    private final Context a;
    private final Context b;

    public s(Context context)
    {
        x.a(context);
        context = context.getApplicationContext();
        x.a(context, "Application context can't be null");
        a = context;
        b = context;
    }

    public Context a()
    {
        return a;
    }

    protected wf a(Context context)
    {
        return wf.a(context);
    }

    protected ag a(r r)
    {
        return new ag(r);
    }

    public Context b()
    {
        return b;
    }

    protected w b(r r)
    {
        return new w(r);
    }

    protected a c(r r)
    {
        return new a(r);
    }

    protected z d(r r)
    {
        return new z(r);
    }

    protected m e(r r)
    {
        return new m(r);
    }

    protected g f(r r)
    {
        return new g(r);
    }

    protected ad g(r r)
    {
        return new ad(r);
    }

    protected vn h(r r)
    {
        return vo.d();
    }

    protected kx i(r r)
    {
        return new kx(r);
    }

    com.google.android.gms.analytics.internal.x j(r r)
    {
        return new com.google.android.gms.analytics.internal.x(r, this);
    }

    h k(r r)
    {
        return new h(r);
    }

    protected n l(r r)
    {
        return new n(r, this);
    }

    public v m(r r)
    {
        return new v(r);
    }

    public i n(r r)
    {
        return new i(r);
    }

    public u o(r r)
    {
        return new u(r);
    }

    public ah p(r r)
    {
        return new ah(r);
    }

    public j q(r r)
    {
        return new j(r);
    }
}
