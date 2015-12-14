// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Looper;

class btm
    implements btq
{

    private final Context a;

    public btm(Context context)
    {
        a = context.getApplicationContext();
    }

    public bti a()
    {
        Object obj;
        if (Looper.myLooper() == Looper.getMainLooper())
        {
            bso.h().a("Fabric", "AdvertisingInfoServiceStrategy cannot be called on the main thread");
            return null;
        }
        Object obj1;
        boolean flag;
        try
        {
            a.getPackageManager().getPackageInfo("com.android.vending", 0);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            bso.h().a("Fabric", "Unable to find Google Play Services package name");
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            bso.h().a("Fabric", "Unable to determine if Google Play Services is available", ((Throwable) (obj)));
            return null;
        }
        obj = new bto(null);
        obj1 = new Intent("com.google.android.gms.ads.identifier.service.START");
        ((Intent) (obj1)).setPackage("com.google.android.gms");
        Exception exception;
        try
        {
            flag = a.bindService(((Intent) (obj1)), ((android.content.ServiceConnection) (obj)), 1);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            bso.h().a("Fabric", "Could not bind to Google Play Service to capture AdvertisingId", ((Throwable) (obj)));
            return null;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_198;
        }
        obj1 = new btp(((bto) (obj)).a());
        obj1 = new bti(((btp) (obj1)).a(), ((btp) (obj1)).b());
        a.unbindService(((android.content.ServiceConnection) (obj)));
        return ((bti) (obj1));
        exception;
        bso.h().d("Fabric", "Exception in binding to Google Play Service to capture AdvertisingId", exception);
        a.unbindService(((android.content.ServiceConnection) (obj)));
        return null;
        Exception exception1;
        exception1;
        a.unbindService(((android.content.ServiceConnection) (obj)));
        throw exception1;
        bso.h().a("Fabric", "Could not bind to Google Play Service to capture AdvertisingId");
        return null;
    }
}
