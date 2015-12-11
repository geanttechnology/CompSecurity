// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.l;

public final class hv extends l
{

    public hv(Context context, Looper looper, h h, com.google.android.gms.common.api.c.b b1, com.google.android.gms.common.api.c.c c)
    {
        super(context, looper, 19, h, b1, c);
    }

    protected final IInterface a(IBinder ibinder)
    {
        return hs.a.a(ibinder);
    }

    protected final String a()
    {
        return "com.google.android.gms.icing.LIGHTWEIGHT_INDEX_SERVICE";
    }

    protected final String b()
    {
        return "com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch";
    }
}
