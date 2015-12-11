// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.l;

// Referenced classes of package com.google.android.gms.location.internal:
//            m, f

public class a extends l
{

    protected final m a = new m() {

        final a a;

        public final void a()
        {
            a.a(a);
        }

        public final IInterface b()
        {
            return (f)a.m();
        }

            
            {
                a = a.this;
                super();
            }
    };
    private final String g;

    public a(Context context, Looper looper, com.google.android.gms.common.api.c.b b1, com.google.android.gms.common.api.c.c c, String s, h h)
    {
        super(context, looper, 23, h, b1, c);
        g = s;
    }

    static void a(a a1)
    {
        a1.l();
    }

    protected final IInterface a(IBinder ibinder)
    {
        return f.a.a(ibinder);
    }

    protected final String a()
    {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    protected final String b()
    {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    protected final Bundle k()
    {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", g);
        return bundle;
    }
}
