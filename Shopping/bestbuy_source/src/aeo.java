// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;

public class aeo extends acy
{

    protected final afj a = new afj() {

        final aeo a;

        public void a()
        {
            aeo.a(a);
        }

        public aex b()
        {
            return (aex)a.j();
        }

        public IInterface c()
        {
            return b();
        }

            
            {
                a = aeo.this;
                super();
            }
    };
    private final String e;

    public aeo(Context context, Looper looper, qo qo, qp qp, String s)
    {
        super(context, looper, qo, qp, new String[0]);
        e = s;
    }

    static void a(aeo aeo1)
    {
        aeo1.i();
    }

    protected aex a(IBinder ibinder)
    {
        return aey.a(ibinder);
    }

    protected void a(adp adp1, adb adb)
    {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", e);
        adp1.e(adb, 0x648278, h().getPackageName(), bundle);
    }

    protected IInterface b(IBinder ibinder)
    {
        return a(ibinder);
    }

    protected String d()
    {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    protected String e()
    {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }
}
