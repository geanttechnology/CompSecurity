// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public final class yz extends sd
{

    private static final yz a = new yz();

    private yz()
    {
        super("com.google.android.gms.ads.InAppPurchaseManagerCreatorImpl");
    }

    public static ym a(Activity activity)
    {
        try
        {
            if (b(activity))
            {
                acb.a("Using AdOverlay from the client jar.");
                return new xx(activity);
            }
            activity = a.c(activity);
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            acb.e(activity.getMessage());
            return null;
        }
        return activity;
    }

    private static boolean b(Activity activity)
    {
        activity = activity.getIntent();
        if (!activity.hasExtra("com.google.android.gms.ads.internal.purchase.useClientJar"))
        {
            throw new za("InAppPurchaseManager requires the useClientJar flag in intent extras.");
        } else
        {
            return activity.getBooleanExtra("com.google.android.gms.ads.internal.purchase.useClientJar", false);
        }
    }

    private ym c(Activity activity)
    {
        try
        {
            ry ry = sb.a(activity);
            activity = yn.a(((yp)a(activity)).a(ry));
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            acb.d("Could not create remote InAppPurchaseManager.", activity);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            acb.d("Could not create remote InAppPurchaseManager.", activity);
            return null;
        }
        return activity;
    }

    protected Object a(IBinder ibinder)
    {
        return b(ibinder);
    }

    protected yp b(IBinder ibinder)
    {
        return yq.a(ibinder);
    }

}
