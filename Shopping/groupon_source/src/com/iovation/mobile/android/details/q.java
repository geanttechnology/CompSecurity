// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.iovation.mobile.android.details;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;

// Referenced classes of package com.iovation.mobile.android.details:
//            i, j

public class q
    implements i
{

    public q()
    {
    }

    public static boolean a(Context context)
    {
        int k = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("plugged", -1);
        return k == 1 || k == 2;
    }

    private static String b(Context context)
    {
        try
        {
            context = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return null;
        }
        return context;
    }

    public void a(Context context, j j1)
    {
        j1.a("AMID", b(context));
        if (android.os.Build.VERSION.SDK_INT >= 17 && android.os.Build.VERSION.SDK_INT <= 19)
        {
            j1.a("ANMA", android.provider.Settings.Global.getString(context.getContentResolver(), "install_non_market_apps"));
        }
        if (android.os.Build.VERSION.SDK_INT < 17 || android.os.Build.VERSION.SDK_INT > 19)
        {
            j1.a("ANMA", android.provider.Settings.Secure.getString(context.getContentResolver(), "install_non_market_apps"));
        }
        Object obj;
        int k;
        int l;
        if (Build.PRODUCT.contains("sdk"))
        {
            obj = "1";
        } else
        {
            obj = "0";
        }
        j1.a("SIM", ((String) (obj)));
        obj = ((WindowManager)context.getSystemService("window")).getDefaultDisplay();
        k = ((Display) (obj)).getWidth();
        l = ((Display) (obj)).getHeight();
        j1.a("RES", (new StringBuilder()).append(k).append("X").append(l).toString());
        if (a(context))
        {
            context = "1";
        } else
        {
            context = "0";
        }
        j1.a("PLUG", context);
    }
}
