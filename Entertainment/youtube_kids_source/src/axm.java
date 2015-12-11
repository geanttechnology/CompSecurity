// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Bundle;
import android.os.IBinder;

public final class axm extends axy
{

    private axi a;

    public axm(axi axi1)
    {
        a = axi1;
    }

    public final void a(int i, IBinder ibinder, Bundle bundle)
    {
        a.f("onPostInitComplete can be called only once per call to getServiceFromBroker", a);
        a.a(i, ibinder, bundle);
        a = null;
    }
}
