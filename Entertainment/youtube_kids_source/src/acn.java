// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import java.util.Locale;

public final class acn
    implements cnn
{

    public boolean a;
    private final Context b;
    private final TelephonyManager c;
    private final PackageManager d;
    private final SharedPreferences e;

    public acn(Context context, TelephonyManager telephonymanager, PackageManager packagemanager, SharedPreferences sharedpreferences)
    {
        b = (Context)b.a(context);
        c = (TelephonyManager)b.a(telephonymanager);
        d = (PackageManager)b.a(packagemanager);
        e = (SharedPreferences)b.a(sharedpreferences);
        a = false;
    }

    public final void a(dnl dnl1, cqw cqw)
    {
        dhf dhf1 = dnl1.a;
        cqw = dhf1;
        if (dhf1 == null)
        {
            cqw = new dhf();
        }
        cqw.i = Locale.getDefault().toString();
        cqw.j = bnh.a(c, Locale.getDefault());
        cqw.e = 18;
        cqw.f = a.a(b, d);
        cqw.h = android.os.Build.VERSION.RELEASE;
        cqw.g = "Android";
        cqw.c = Build.MANUFACTURER;
        cqw.d = Build.MODEL;
        cqw.m = 2;
        if (a)
        {
            cqw.l = 4;
        }
        if (a.e(b))
        {
            int ai[] = bye.a(e);
            cqw.b = a.a(((dhf) (cqw)).b, ai);
        }
        dnl1.a = cqw;
    }
}
