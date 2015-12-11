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

public final class b extends l
{

    private final com.google.android.gms.common.api.a.d a;

    public b(Context context, Looper looper, int i, com.google.android.gms.common.api.c.b b1, com.google.android.gms.common.api.c.c c, h h, com.google.android.gms.common.api.a.d d)
    {
        super(context, looper, i, h, b1, c);
        a = d;
    }

    protected final IInterface a(IBinder ibinder)
    {
        return a.c();
    }

    protected final String a()
    {
        return a.a();
    }

    protected final String b()
    {
        return a.b();
    }
}
