// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.l;

// Referenced classes of package com.google.android.gms.location.internal:
//            n, g

public class b extends l
{

    protected final n a = new n() {

        final b a;

        public void a()
        {
            b.a(a);
        }

        public g b()
            throws DeadObjectException
        {
            return (g)a.zzoA();
        }

        public IInterface c()
            throws DeadObjectException
        {
            return b();
        }

            
            {
                a = b.this;
                super();
            }
    };
    private final String b;

    public b(Context context, Looper looper, com.google.android.gms.common.api.c.b b1, com.google.android.gms.common.api.c.c c, String s, h h)
    {
        super(context, looper, 23, h, b1, c);
        b = s;
    }

    static void a(b b1)
    {
        b1.zzoz();
    }

    protected g a(IBinder ibinder)
    {
        return g.a.a(ibinder);
    }

    protected IInterface zzV(IBinder ibinder)
    {
        return a(ibinder);
    }

    protected String zzfA()
    {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    protected String zzfB()
    {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    protected Bundle zzli()
    {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", b);
        return bundle;
    }
}
