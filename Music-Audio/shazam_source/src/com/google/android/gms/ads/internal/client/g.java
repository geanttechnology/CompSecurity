// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.j;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.a;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.b.d;
import com.google.android.gms.b.f;
import com.google.android.gms.d.df;

// Referenced classes of package com.google.android.gms.ads.internal.client:
//            m, s, r

public final class g extends f
{

    private static final g a = new g();

    private g()
    {
        super("com.google.android.gms.ads.AdLoaderBuilderCreatorImpl");
    }

    public static r a(Context context, String s1, df df)
    {
        Object obj;
label0:
        {
            com.google.android.gms.ads.internal.client.m.a();
            if (com.google.android.gms.ads.internal.util.client.a.b(context))
            {
                r r = a.b(context, s1, df);
                obj = r;
                if (r != null)
                {
                    break label0;
                }
            }
            com.google.android.gms.ads.internal.util.client.b.a(3);
            obj = new j(context, s1, df, new VersionInfoParcel());
        }
        return ((r) (obj));
    }

    private r b(Context context, String s1, df df)
    {
        com.google.android.gms.b.c c = d.a(context);
        context = com.google.android.gms.ads.internal.client.r.a.a(((s)a(context)).a(c, s1, df, 0x7877d8));
        return context;
        context;
        com.google.android.gms.ads.internal.util.client.b.a(5);
_L2:
        return null;
        context;
        com.google.android.gms.ads.internal.util.client.b.a(5);
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected final Object a(IBinder ibinder)
    {
        return com.google.android.gms.ads.internal.client.s.a.a(ibinder);
    }

}
