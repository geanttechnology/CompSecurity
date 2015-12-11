// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.purchase.e;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.b.d;
import com.google.android.gms.b.f;

// Referenced classes of package com.google.android.gms.d:
//            eo, en

public final class es extends f
{
    private static final class a extends Exception
    {

        public a(String s)
        {
            super(s);
        }
    }


    private static final es a = new es();

    private es()
    {
        super("com.google.android.gms.ads.InAppPurchaseManagerCreatorImpl");
    }

    public static en a(Activity activity)
    {
        Intent intent;
        try
        {
            intent = activity.getIntent();
            if (!intent.hasExtra("com.google.android.gms.ads.internal.purchase.useClientJar"))
            {
                throw new a("InAppPurchaseManager requires the useClientJar flag in intent extras.");
            }
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            activity.getMessage();
            com.google.android.gms.ads.internal.util.client.b.a(5);
            return null;
        }
        if (intent.getBooleanExtra("com.google.android.gms.ads.internal.purchase.useClientJar", false))
        {
            com.google.android.gms.ads.internal.util.client.b.a(3);
            return new e(activity);
        }
        activity = a.b(activity);
        return activity;
    }

    private en b(Activity activity)
    {
        try
        {
            com.google.android.gms.b.c c = d.a(activity);
            activity = en.a.a(((eo)a(activity)).a(c));
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
            return null;
        }
        return activity;
    }

    protected final Object a(IBinder ibinder)
    {
        return eo.a.a(ibinder);
    }

}
