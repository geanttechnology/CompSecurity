// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.dynamic.c;
import com.google.android.gms.dynamic.e;

// Referenced classes of package com.google.android.gms.internal:
//            ct, bk, bt, bs

public final class br extends e
{
    private static final class a extends Exception
    {

        public a(String s)
        {
            super(s);
        }
    }


    private static final br ha = new br();

    private br()
    {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    public static bs a(Activity activity)
    {
        try
        {
            if (b(activity))
            {
                ct.r("Using AdOverlay from the client jar.");
                return new bk(activity);
            }
            activity = ha.c(activity);
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            ct.v(activity.getMessage());
            return null;
        }
        return activity;
    }

    private static boolean b(Activity activity)
        throws a
    {
        activity = activity.getIntent();
        if (!activity.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar"))
        {
            throw new a("Ad overlay requires the useClientJar flag in intent extras.");
        } else
        {
            return activity.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        }
    }

    private bs c(Activity activity)
    {
        try
        {
            com.google.android.gms.dynamic.b b1 = com.google.android.gms.dynamic.c.h(activity);
            activity = bs.a.m(((bt)t(activity)).a(b1));
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            ct.b("Could not create remote AdOverlay.", activity);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            ct.b("Could not create remote AdOverlay.", activity);
            return null;
        }
        return activity;
    }

    protected Object d(IBinder ibinder)
    {
        return l(ibinder);
    }

    protected bt l(IBinder ibinder)
    {
        return bt.a.n(ibinder);
    }

}
