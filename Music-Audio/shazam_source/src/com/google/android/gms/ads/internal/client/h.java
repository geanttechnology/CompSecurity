// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.b.d;
import com.google.android.gms.b.f;
import com.google.android.gms.d.df;

// Referenced classes of package com.google.android.gms.ads.internal.client:
//            u, AdSizeParcel, t

public final class h extends f
{

    public h()
    {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    final t a(Context context, AdSizeParcel adsizeparcel, String s, df df, int i)
    {
        com.google.android.gms.b.c c = d.a(context);
        context = t.a.a(((u)a(context)).a(c, adsizeparcel, s, df, 0x7877d8, i));
        return context;
        context;
_L2:
        b.a(3);
        return null;
        context;
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected final Object a(IBinder ibinder)
    {
        return u.a.a(ibinder);
    }
}
