// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public final class xk extends sd
{

    private static final xk a = new xk();

    private xk()
    {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    public static xm a(Activity activity)
    {
        try
        {
            if (b(activity))
            {
                acb.a("Using AdOverlay from the client jar.");
                return new xc(activity);
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
        if (!activity.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar"))
        {
            throw new xl("Ad overlay requires the useClientJar flag in intent extras.");
        } else
        {
            return activity.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        }
    }

    private xm c(Activity activity)
    {
        try
        {
            ry ry = sb.a(activity);
            activity = xn.a(((xp)a(activity)).a(ry));
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            acb.d("Could not create remote AdOverlay.", activity);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            acb.d("Could not create remote AdOverlay.", activity);
            return null;
        }
        return activity;
    }

    protected Object a(IBinder ibinder)
    {
        return b(ibinder);
    }

    protected xp b(IBinder ibinder)
    {
        return xq.a(ibinder);
    }

}
