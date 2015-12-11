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
//            da, bo, bx, bw

public final class bv extends e
{
    private static final class a extends Exception
    {

        public a(String s)
        {
            super(s);
        }
    }


    private static final bv nL = new bv();

    private bv()
    {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    public static bw a(Activity activity)
    {
        try
        {
            if (b(activity))
            {
                da.s("Using AdOverlay from the client jar.");
                return new bo(activity);
            }
            activity = nL.c(activity);
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            da.w(activity.getMessage());
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

    private bw c(Activity activity)
    {
        try
        {
            com.google.android.gms.dynamic.b b1 = com.google.android.gms.dynamic.c.h(activity);
            activity = bw.a.m(((bx)z(activity)).a(b1));
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            da.b("Could not create remote AdOverlay.", activity);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            da.b("Could not create remote AdOverlay.", activity);
            return null;
        }
        return activity;
    }

    protected Object d(IBinder ibinder)
    {
        return l(ibinder);
    }

    protected bx l(IBinder ibinder)
    {
        return bx.a.n(ibinder);
    }

}
