// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import android.content.Context;
import com.google.android.gms.common.internal.w;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            z, ad, u, ah, 
//            j, x, r

public final class s
{

    final Context a;
    final Context b;

    public s(Context context)
    {
        w.a(context);
        context = context.getApplicationContext();
        w.a(context, "Application context can't be null");
        a = context;
        b = context;
    }

    protected static z a(r r)
    {
        return new z(r);
    }

    protected static ad b(r r)
    {
        return new ad(r);
    }

    public static u d(r r)
    {
        return new u(r);
    }

    public static ah e(r r)
    {
        return new ah(r);
    }

    public static j f(r r)
    {
        return new j(r);
    }

    final x c(r r)
    {
        return new x(r, this);
    }
}
