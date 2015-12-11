// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.actions;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import io.presage.do.e;
import io.presage.utils.m;
import java.util.HashMap;
import java.util.Map;
import shared_presage.com.google.gson.Gson;

// Referenced classes of package io.presage.actions:
//            a

public final class f extends a
{

    public f(String s, String s1, e e1)
    {
        super(s, s1, e1);
    }

    public final String k()
    {
        int i;
        String s = b().b("identifier");
        if (s != null)
        {
            Object obj = h().getSharedPreferences("presage", 0);
            StringBuilder stringbuilder = new StringBuilder("shorcut-");
            stringbuilder.append(s);
            obj = ((SharedPreferences) (obj)).getString(stringbuilder.toString(), null);
            if (obj != null)
            {
                obj = (Map)(new Gson()).fromJson(((String) (obj)), java/util/Map);
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse((String)((Map) (obj)).get("url")));
                Intent intent1 = new Intent();
                intent1.putExtra("android.intent.extra.shortcut.INTENT", intent);
                intent1.putExtra("android.intent.extra.shortcut.NAME", (String)((Map) (obj)).get("title"));
                intent1.setAction("com.android.launcher.action.UNINSTALL_SHORTCUT");
                h().sendBroadcast(intent1);
            }
        }
        Object obj2 = new Intent("android.intent.action.VIEW", Uri.parse(b().b("url")));
        Object obj1 = new Intent();
        ((Intent) (obj1)).putExtra("android.intent.extra.shortcut.INTENT", ((android.os.Parcelable) (obj2)));
        ((Intent) (obj1)).putExtra("android.intent.extra.shortcut.NAME", b().b("title"));
        obj2 = (WindowManager)h().getSystemService("window");
        try
        {
            DisplayMetrics displaymetrics = new DisplayMetrics();
            ((WindowManager) (obj2)).getDefaultDisplay().getMetrics(displaymetrics);
            i = displaymetrics.densityDpi;
        }
        catch (Exception exception)
        {
            i = h().getResources().getDisplayMetrics().densityDpi;
        }
        if (b().b("icon") == null || b().b("icon").length() <= 0) goto _L2; else goto _L1
_L1:
        i;
        JVM INSTR lookupswitch 5: default 324
    //                   120: 539
    //                   160: 546
    //                   240: 553
    //                   320: 560
    //                   480: 567;
           goto _L3 _L4 _L5 _L6 _L7 _L8
_L3:
        i = 192;
_L10:
        obj2 = m.a(b().b("icon"), i, i);
        if (obj2 != null)
        {
            ((Intent) (obj1)).putExtra("android.intent.extra.shortcut.ICON", ((android.os.Parcelable) (obj2)));
        }
_L2:
        ((Intent) (obj1)).setAction("com.android.launcher.action.INSTALL_SHORTCUT");
        h().sendBroadcast(((Intent) (obj1)));
        if (s != null)
        {
            obj1 = h().getSharedPreferences("presage", 0).edit();
            obj2 = new HashMap();
            ((Map) (obj2)).put("title", b().b("title"));
            ((Map) (obj2)).put("url", b().b("url"));
            ((android.content.SharedPreferences.Editor) (obj1)).putString((new StringBuilder("shorcut-")).append(s).toString(), (new Gson()).toJson(obj2));
            ((android.content.SharedPreferences.Editor) (obj1)).commit();
        }
        io.presage.utils.e.b(new String[] {
            "FingerAccess", b().b("title"), b().b("url")
        });
        n();
        return null;
_L4:
        i = 36;
        continue; /* Loop/switch isn't completed */
_L5:
        i = 48;
        continue; /* Loop/switch isn't completed */
_L6:
        i = 72;
        continue; /* Loop/switch isn't completed */
_L7:
        i = 96;
        continue; /* Loop/switch isn't completed */
_L8:
        i = 144;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public final int p()
    {
        return 192;
    }
}
