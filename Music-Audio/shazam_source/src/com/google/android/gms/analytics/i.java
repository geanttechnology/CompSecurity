// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.google.android.gms.analytics.internal.a;
import com.google.android.gms.analytics.internal.ag;
import com.google.android.gms.analytics.internal.r;
import com.google.android.gms.analytics.internal.w;
import com.google.android.gms.analytics.internal.z;
import com.google.android.gms.d.hr;
import com.google.android.gms.d.ix;
import com.google.android.gms.d.iz;

public class i extends iz
{

    public final r f;
    public boolean g;

    public i(r r1)
    {
        super(r1.b(), r1.c);
        f = r1;
    }

    protected final void a(ix ix1)
    {
        ix1 = (hr)ix1.b(com/google/android/gms/d/hr);
        if (TextUtils.isEmpty(((hr) (ix1)).b))
        {
            ix1.b = f.g().b();
        }
        if (g && TextUtils.isEmpty(((hr) (ix1)).d))
        {
            a a1 = f.f();
            ix1.d = a1.c();
            ix1.e = a1.b();
        }
    }

    public final ix c()
    {
        ix ix1 = d().a();
        ix1.a(f.h().b());
        ix1.a(f.h.b());
        f();
        return ix1;
    }
}
