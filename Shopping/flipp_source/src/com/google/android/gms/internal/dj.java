// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.c;
import com.google.android.gms.common.d;

// Referenced classes of package com.google.android.gms.internal:
//            fw, dp, gr, do, 
//            ga

public final class dj extends fw
{

    private final int f;

    public dj(Context context, c c1, d d, int i)
    {
        super(context, c1, d, new String[0]);
        f = i;
    }

    protected final IInterface a(IBinder ibinder)
    {
        return dp.a(ibinder);
    }

    protected final String a()
    {
        return "com.google.android.gms.ads.service.START";
    }

    protected final void a(gr gr1, ga ga)
    {
        Bundle bundle = new Bundle();
        gr1.g(ga, f, super.a.getPackageName(), bundle);
    }

    protected final String b()
    {
        return "com.google.android.gms.ads.internal.request.IAdRequestService";
    }

    public final do c()
    {
        return (do)super.i();
    }
}
