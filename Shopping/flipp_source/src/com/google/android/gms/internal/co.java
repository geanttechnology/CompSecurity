// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.a.d;
import com.google.android.gms.a.e;
import com.google.android.gms.a.f;

// Referenced classes of package com.google.android.gms.internal:
//            cp, et, cd, ct, 
//            cr, cv, cq

public final class co extends e
{

    private static final co a = new co();

    private co()
    {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    public static cq a(Activity activity)
    {
        Intent intent;
        try
        {
            intent = activity.getIntent();
            if (!intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar"))
            {
                throw new cp("Ad overlay requires the useClientJar flag in intent extras.");
            }
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            com.google.android.gms.internal.et.d(activity.getMessage());
            return null;
        }
        if (intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false))
        {
            et.a("Using AdOverlay from the client jar.");
            return new cd(activity);
        }
        activity = a.b(activity);
        return activity;
    }

    private cq b(Activity activity)
    {
        try
        {
            com.google.android.gms.a.a a1 = d.a(activity);
            activity = cr.a(((ct)a(activity)).a(a1));
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            et.a("Could not create remote AdOverlay.", activity);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            et.a("Could not create remote AdOverlay.", activity);
            return null;
        }
        return activity;
    }

    protected final Object a(IBinder ibinder)
    {
        return cv.a(ibinder);
    }

}
