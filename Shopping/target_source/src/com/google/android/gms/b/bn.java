// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.b;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.a.c;
import com.google.android.gms.ads.internal.util.client.b;

// Referenced classes of package com.google.android.gms.b:
//            bm, bl

public final class bn extends c
{

    private static final bn a = new bn();

    private bn()
    {
        super("com.google.android.gms.ads.InAppPurchaseManagerCreatorImpl");
    }

    public static bl a(Activity activity)
    {
        try
        {
            if (b(activity))
            {
                com.google.android.gms.ads.internal.util.client.b.a("Using AdOverlay from the client jar.");
                return new com.google.android.gms.ads.internal.purchase.c(activity);
            }
            activity = a.c(activity);
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
    /* block-local class not found */
    class a {}

            com.google.android.gms.ads.internal.util.client.b.e(activity.getMessage());
            return null;
        }
        return activity;
    }

    private static boolean b(Activity activity)
        throws a
    {
        activity = activity.getIntent();
        if (!activity.hasExtra("com.google.android.gms.ads.internal.purchase.useClientJar"))
        {
            throw new a("InAppPurchaseManager requires the useClientJar flag in intent extras.");
        } else
        {
            return activity.getBooleanExtra("com.google.android.gms.ads.internal.purchase.useClientJar", false);
        }
    }

    private bl c(Activity activity)
    {
        try
        {
            com.google.android.gms.a.a a1 = com.google.android.gms.a.b.a(activity);
            activity = bl.a.a(((bm)a(activity)).a(a1));
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            com.google.android.gms.ads.internal.util.client.b.c("Could not create remote InAppPurchaseManager.", activity);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            com.google.android.gms.ads.internal.util.client.b.c("Could not create remote InAppPurchaseManager.", activity);
            return null;
        }
        return activity;
    }

    protected bm a(IBinder ibinder)
    {
        return bm.a.a(ibinder);
    }

    protected Object b(IBinder ibinder)
    {
        return a(ibinder);
    }

}
