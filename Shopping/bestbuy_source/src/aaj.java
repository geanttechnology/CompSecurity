// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;

public class aaj extends acy
{

    final int a;

    public aaj(Context context, qo qo, qp qp, int i)
    {
        super(context, context.getMainLooper(), qo, qp, new String[0]);
        a = i;
    }

    protected aan a(IBinder ibinder)
    {
        return aao.a(ibinder);
    }

    protected void a(adp adp1, adb adb)
    {
        Bundle bundle = new Bundle();
        adp1.g(adb, a, h().getPackageName(), bundle);
    }

    protected IInterface b(IBinder ibinder)
    {
        return a(ibinder);
    }

    protected String d()
    {
        return "com.google.android.gms.ads.service.START";
    }

    protected String e()
    {
        return "com.google.android.gms.ads.internal.request.IAdRequestService";
    }

    public aan f()
    {
        return (aan)super.j();
    }
}
