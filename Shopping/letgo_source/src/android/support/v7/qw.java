// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.util.client.zzb;

// Referenced classes of package android.support.v7:
//            ln, ll, qy, qx

public final class qw extends ln
{
    private static final class a extends Exception
    {

        public a(String s)
        {
            super(s);
        }
    }


    private static final qw a = new qw();

    private qw()
    {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    public static qx a(Activity activity)
    {
        try
        {
            if (b(activity))
            {
                zzb.zzaC("Using AdOverlay from the client jar.");
                return new zzd(activity);
            }
            activity = a.c(activity);
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            zzb.zzaE(activity.getMessage());
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

    private qx c(Activity activity)
    {
        try
        {
            lk lk = ll.a(activity);
            activity = qx.a.zzK(((qy)zzar(activity)).a(lk));
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            zzb.zzd("Could not create remote AdOverlay.", activity);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            zzb.zzd("Could not create remote AdOverlay.", activity);
            return null;
        }
        return activity;
    }

    protected qy a(IBinder ibinder)
    {
        return qy.a.a(ibinder);
    }

    protected Object zzd(IBinder ibinder)
    {
        return a(ibinder);
    }

}
