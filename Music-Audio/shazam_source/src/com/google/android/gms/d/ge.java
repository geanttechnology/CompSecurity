// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.client.b;

public final class ge
{

    public long a;
    public long b;
    public int c;
    public final Object d = new Object();
    final String e;
    public int f;
    public int g;

    public ge(String s)
    {
        a = -1L;
        b = -1L;
        c = -1;
        f = 0;
        g = 0;
        e = s;
    }

    private static boolean a(Context context)
    {
        ComponentName componentname;
        int i;
        i = context.getResources().getIdentifier("Theme.Translucent", "style", "android");
        if (i == 0)
        {
            com.google.android.gms.ads.internal.util.client.b.a(4);
            return false;
        }
        componentname = new ComponentName(context.getPackageName(), "com.google.android.gms.ads.AdActivity");
        if (i == context.getPackageManager().getActivityInfo(componentname, 0).theme)
        {
            return true;
        }
        try
        {
            com.google.android.gms.ads.internal.util.client.b.a(4);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
            com.google.android.gms.ads.internal.util.client.b.a(4);
            return false;
        }
        return false;
    }

    public final Bundle a(Context context, String s)
    {
        Bundle bundle;
        synchronized (d)
        {
            bundle = new Bundle();
            bundle.putString("session_id", e);
            bundle.putLong("basets", b);
            bundle.putLong("currts", a);
            bundle.putString("seq_num", s);
            bundle.putInt("preqs", c);
            bundle.putInt("pclick", f);
            bundle.putInt("pimp", g);
            bundle.putBoolean("support_transparent_background", a(context));
        }
        return bundle;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }
}
