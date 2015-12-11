// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;

// Referenced classes of package com.google.android.gms.common.internal:
//            l, h

public class x extends l
{

    private final com.google.android.gms.common.api.b.e d;

    public x(Context context, Looper looper, int i, com.google.android.gms.common.api.d.b b, com.google.android.gms.common.api.d.d d1, h h, com.google.android.gms.common.api.b.e e1)
    {
        super(context, looper, i, b, d1, h);
        d = e1;
    }

    protected IInterface a(IBinder ibinder)
    {
        return d.a(ibinder);
    }

    protected String d()
    {
        return d.a();
    }

    protected String e()
    {
        return d.b();
    }
}
