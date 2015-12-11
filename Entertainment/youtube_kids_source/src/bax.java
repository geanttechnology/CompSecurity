// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;

public final class bax extends axi
{

    public bax(Context context, Looper looper, awk awk, avt avt)
    {
        super(context, looper, awk, avt, new String[0]);
    }

    public final IInterface a(IBinder ibinder)
    {
        return bbg.a(ibinder);
    }

    public final void a(Bundle bundle, Bundle bundle1)
    {
        h();
        try
        {
            ((bbf)i()).a(super.a.getPackageName(), bundle, bundle1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            Log.w("Herrevad", "NetworkQualityClient not connected soon after checkConnected.  Discarding network quality data");
        }
    }

    protected final void a(aya aya1, axm axm)
    {
        aya1.k(axm, 0x5e3530, super.a.getPackageName(), Bundle.EMPTY);
    }

    protected final String e()
    {
        return "com.google.android.gms.mdm.services.START";
    }

    protected final String f()
    {
        return "com.google.android.gms.mdm.internal.INetworkQualityService";
    }
}
