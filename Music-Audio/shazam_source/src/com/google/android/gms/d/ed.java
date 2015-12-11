// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.overlay.d;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.b.f;

// Referenced classes of package com.google.android.gms.d:
//            ef, ee

public final class ed extends f
{
    private static final class a extends Exception
    {

        public a(String s)
        {
            super(s);
        }
    }


    private static final ed a = new ed();

    private ed()
    {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    public static ee a(Activity activity)
    {
        Intent intent;
        try
        {
            intent = activity.getIntent();
            if (!intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar"))
            {
                throw new a("Ad overlay requires the useClientJar flag in intent extras.");
            }
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            activity.getMessage();
            com.google.android.gms.ads.internal.util.client.b.a(5);
            return null;
        }
        if (intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false))
        {
            com.google.android.gms.ads.internal.util.client.b.a(3);
            return new d(activity);
        }
        activity = a.b(activity);
        return activity;
    }

    private ee b(Activity activity)
    {
        try
        {
            com.google.android.gms.b.c c = com.google.android.gms.b.d.a(activity);
            activity = ee.a.a(((ef)a(activity)).a(c));
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
        return ef.a.a(ibinder);
    }

}
