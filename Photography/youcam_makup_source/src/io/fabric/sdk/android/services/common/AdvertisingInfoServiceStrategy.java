// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.fabric.sdk.android.services.common;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Looper;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;

// Referenced classes of package io.fabric.sdk.android.services.common:
//            AdvertisingInfoStrategy, AdvertisingInfo

class AdvertisingInfoServiceStrategy
    implements AdvertisingInfoStrategy
{

    public static final String GOOGLE_PLAY_SERVICES_INTENT = "com.google.android.gms.ads.identifier.service.START";
    public static final String GOOGLE_PLAY_SERVICES_INTENT_PACKAGE_NAME = "com.google.android.gms";
    private static final String GOOGLE_PLAY_SERVICE_PACKAGE_NAME = "com.android.vending";
    private final Context context;

    public AdvertisingInfoServiceStrategy(Context context1)
    {
        context = context1.getApplicationContext();
    }

    public AdvertisingInfo getAdvertisingInfo()
    {
        Object obj;
        if (Looper.myLooper() == Looper.getMainLooper())
        {
            Fabric.getLogger().d("Fabric", "AdvertisingInfoServiceStrategy cannot be called on the main thread");
            return null;
        }
        Object obj1;
        boolean flag;
        try
        {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Fabric.getLogger().d("Fabric", "Unable to find Google Play Services package name");
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Fabric.getLogger().d("Fabric", "Unable to determine if Google Play Services is available", ((Throwable) (obj)));
            return null;
        }
        obj = new AdvertisingConnection(null);
        obj1 = new Intent("com.google.android.gms.ads.identifier.service.START");
        ((Intent) (obj1)).setPackage("com.google.android.gms");
        Exception exception;
        try
        {
            flag = context.bindService(((Intent) (obj1)), ((android.content.ServiceConnection) (obj)), 1);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Fabric.getLogger().d("Fabric", "Could not bind to Google Play Service to capture AdvertisingId", ((Throwable) (obj)));
            return null;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_198;
        }
        obj1 = new AdvertisingInterface(((AdvertisingConnection) (obj)).getBinder());
        obj1 = new AdvertisingInfo(((AdvertisingInterface) (obj1)).getId(), ((AdvertisingInterface) (obj1)).isLimitAdTrackingEnabled());
        context.unbindService(((android.content.ServiceConnection) (obj)));
        return ((AdvertisingInfo) (obj1));
        exception;
        Fabric.getLogger().w("Fabric", "Exception in binding to Google Play Service to capture AdvertisingId", exception);
        context.unbindService(((android.content.ServiceConnection) (obj)));
        return null;
        Exception exception1;
        exception1;
        context.unbindService(((android.content.ServiceConnection) (obj)));
        throw exception1;
        Fabric.getLogger().d("Fabric", "Could not bind to Google Play Service to capture AdvertisingId");
        return null;
    }

    /* member class not found */
    class AdvertisingConnection {}


    /* member class not found */
    class AdvertisingInterface {}

}
