// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;

public final class bbm extends ayl
{

    private static final bbm a = new bbm();

    private bbm()
    {
        super("com.google.android.gms.ads.adshield.AdShieldCreatorImpl");
    }

    public static bbn a(String s, Context context)
    {
        Object obj;
        obj = a;
        ayh ayh = ayk.a(context);
        obj = bbo.a(((bbs)((bbm) (obj)).a(context)).a(s, ayh));
        return ((bbn) (obj));
        Object obj1;
        obj1;
_L2:
        return new bbl(s, context);
        obj1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected final Object a(IBinder ibinder)
    {
        return bbt.a(ibinder);
    }

}
