// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;

// Referenced classes of package android.support.v4.app:
//            d, f, c, b, 
//            cy

public final class a extends android.support.v4.b.a
{

    private static d a(cy cy)
    {
        d d1 = null;
        if (cy != null)
        {
            d1 = new d(cy);
        }
        return d1;
    }

    public static void a(Activity activity)
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            activity.finishAffinity();
            return;
        } else
        {
            activity.finish();
            return;
        }
    }

    public static void a(Activity activity, cy cy)
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            d.a(activity, a(cy));
        }
    }

    public static void a(Activity activity, String as[], int i)
    {
        if (android.os.Build.VERSION.SDK_INT >= 23)
        {
            if (activity instanceof f)
            {
                ((f)activity).validateRequestPermissionsRequestCode(i);
            }
            activity.requestPermissions(as, i);
        } else
        if (activity instanceof c)
        {
            (new Handler(Looper.getMainLooper())).post(new b(as, activity, i));
            return;
        }
    }

    public static void b(Activity activity, cy cy)
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            d.b(activity, a(cy));
        }
    }
}
