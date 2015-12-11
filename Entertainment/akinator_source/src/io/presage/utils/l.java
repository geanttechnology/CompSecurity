// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.utils;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import io.presage.activities.PresageActivity;

// Referenced classes of package io.presage.utils:
//            e, m

public final class l
{

    public static void a(Context context, String s)
    {
        e.b(new String[] {
            "Uninstalling", s, "shortcut."
        });
        Intent intent = new Intent(context, io/presage/activities/PresageActivity);
        intent.setAction("android.intent.action.MAIN");
        Intent intent1 = new Intent();
        intent1.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent1.putExtra("android.intent.extra.shortcut.NAME", s);
        intent1.setAction("com.android.launcher.action.UNINSTALL_SHORTCUT");
        context.sendBroadcast(intent1);
    }

    public static void a(Context context, String s, String s1, Bundle bundle)
    {
        e.b(new String[] {
            "Installing", s, "shortcut."
        });
        Intent intent = new Intent(context, io/presage/activities/PresageActivity);
        intent.addFlags(0x10000000);
        intent.addFlags(32768);
        intent.setAction("android.intent.action.MAIN");
        if (bundle != null)
        {
            intent.putExtras(bundle);
        }
        bundle = new Intent();
        bundle.putExtra("android.intent.extra.shortcut.INTENT", intent);
        bundle.putExtra("android.intent.extra.shortcut.NAME", s);
        bundle.putExtra("android.intent.extra.shortcut.ICON", b(context, s1));
        bundle.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
        context.sendBroadcast(bundle);
    }

    private static Bitmap b(Context context, String s)
    {
        int i;
        WindowManager windowmanager = (WindowManager)context.getSystemService("window");
        try
        {
            DisplayMetrics displaymetrics = new DisplayMetrics();
            windowmanager.getDefaultDisplay().getMetrics(displaymetrics);
            i = displaymetrics.densityDpi;
        }
        catch (Exception exception)
        {
            i = context.getResources().getDisplayMetrics().densityDpi;
        }
        i;
        JVM INSTR lookupswitch 5: default 88
    //                   120: 118
    //                   160: 125
    //                   240: 132
    //                   320: 139
    //                   480: 146;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        i = 192;
_L8:
        return m.a(s, i, i);
_L2:
        i = 36;
        continue; /* Loop/switch isn't completed */
_L3:
        i = 48;
        continue; /* Loop/switch isn't completed */
_L4:
        i = 72;
        continue; /* Loop/switch isn't completed */
_L5:
        i = 96;
        continue; /* Loop/switch isn't completed */
_L6:
        i = 144;
        if (true) goto _L8; else goto _L7
_L7:
    }
}
