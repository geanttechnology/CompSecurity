// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.actions;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import io.presage.activities.PresageActivity;
import io.presage.ads.NewAd;
import io.presage.utils.e;
import io.presage.utils.m;
import java.util.HashSet;
import java.util.Set;
import shared_presage.com.google.gson.Gson;

// Referenced classes of package io.presage.actions:
//            NewAction

public abstract class AbstractAdShortcut extends NewAction
{

    protected NewAd a;

    public AbstractAdShortcut(Context context, NewAd newad)
    {
        super(context);
        a = newad;
    }

    protected void addId(String s)
    {
        SharedPreferences sharedpreferences = b.getSharedPreferences("presage", 0);
        Set set = sharedpreferences.getStringSet("ad_shortcut", null);
        Object obj = set;
        if (set == null)
        {
            obj = new HashSet();
        }
        ((Set) (obj)).add(s);
        s = sharedpreferences.edit();
        s.putStringSet("ad_shortcut", ((Set) (obj)));
        s.commit();
    }

    protected boolean existsId(String s)
    {
        Set set = b.getSharedPreferences("presage", 0).getStringSet("ad_shortcut", null);
        if (set == null)
        {
            return false;
        } else
        {
            return set.contains(s);
        }
    }

    protected Bitmap getIconFromUrl(String s)
    {
        int i;
        WindowManager windowmanager = (WindowManager)b.getSystemService("window");
        try
        {
            DisplayMetrics displaymetrics = new DisplayMetrics();
            windowmanager.getDefaultDisplay().getMetrics(displaymetrics);
            i = displaymetrics.densityDpi;
        }
        catch (Exception exception)
        {
            i = b.getResources().getDisplayMetrics().densityDpi;
        }
        i;
        JVM INSTR lookupswitch 5: default 88
    //                   120: 121
    //                   160: 128
    //                   240: 135
    //                   320: 142
    //                   480: 149;
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

    protected void installShortcut(String s, Bitmap bitmap, NewAd newad)
    {
        e.b(new String[] {
            "Installing", s, "shortcut."
        });
        Intent intent = new Intent(b, io/presage/activities/PresageActivity);
        intent.addFlags(0x10000000);
        intent.addFlags(32768);
        intent.setAction("android.intent.action.MAIN");
        intent.putExtra("activity_handler", "add_shortcut_action");
        intent.putExtra("ad", (new Gson()).toJson(newad));
        newad = new Intent();
        newad.putExtra("android.intent.extra.shortcut.INTENT", intent);
        newad.putExtra("android.intent.extra.shortcut.NAME", s);
        newad.putExtra("android.intent.extra.shortcut.ICON", bitmap);
        newad.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
        b.sendBroadcast(newad);
    }

    protected void removeId(String s)
    {
        SharedPreferences sharedpreferences = b.getSharedPreferences("presage", 0);
        Set set = sharedpreferences.getStringSet("ad_shortcut", null);
        if (set == null)
        {
            return;
        } else
        {
            set.remove(s);
            s = sharedpreferences.edit();
            s.putStringSet("ad_shortcut", set);
            s.commit();
            return;
        }
    }

    protected void uninstallShortcut(String s, NewAd newad)
    {
        e.b(new String[] {
            "Uninstalling", s, "shortcut."
        });
        newad = new Intent(b, io/presage/activities/PresageActivity);
        newad.setAction("android.intent.action.MAIN");
        Intent intent = new Intent();
        intent.putExtra("android.intent.extra.shortcut.INTENT", newad);
        intent.putExtra("android.intent.extra.shortcut.NAME", s);
        intent.setAction("com.android.launcher.action.UNINSTALL_SHORTCUT");
        b.sendBroadcast(intent);
    }
}
