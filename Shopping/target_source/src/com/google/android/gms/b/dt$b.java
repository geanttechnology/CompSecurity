// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.b;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.g;
import com.google.android.gms.search.GoogleNowAuthState;
import com.google.android.gms.search.a;

// Referenced classes of package com.google.android.gms.b:
//            dt, ds, dr

static class c extends com.google.android.gms.common.api.
{

    private final d b;
    private final String c;
    private final boolean d = Log.isLoggable("SearchAuth", 3);

    static boolean a(api. )
    {
        return .d;
    }

    protected void a(ds ds1)
        throws RemoteException
    {
        if (d)
        {
            Log.d("SearchAuth", "GetGoogleNowAuthImpl started");
        }
        String s = b.a().getPackageName();
        d d1 = new dt.a() {

            final dt.b a;

            public void a(Status status, GoogleNowAuthState googlenowauthstate)
            {
                if (com.google.android.gms.b.dt.b.a(a))
                {
                    Log.d("SearchAuth", "GetGoogleNowAuthImpl success");
                }
                a.a(new dt.c(status, googlenowauthstate));
            }

            
            {
                a = dt.b.this;
                super();
            }
        };
        ((dr)ds1.m()).a(d1, s, c);
    }

    protected g b(Status status)
    {
        return d(status);
    }

    protected void b(com.google.android.gms.common.api.s s)
        throws RemoteException
    {
        a((ds)s);
    }

    protected com.google.android.gms.search.tatus d(Status status)
    {
        if (d)
        {
            Log.d("SearchAuth", (new StringBuilder()).append("GetGoogleNowAuthImpl received failure: ").append(status.c()).toString());
        }
        return new <init>(status, null);
    }

    protected api.d(d d1, String s)
    {
        super(a.a, d1);
        b = d1;
        c = s;
    }
}
