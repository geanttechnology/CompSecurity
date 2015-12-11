// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.kahuna.sdk;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import java.sql.Timestamp;

// Referenced classes of package com.kahuna.sdk:
//            h, KahunaPushReceiver

public final class g
{

    private static KahunaPushReceiver a;
    private static Context b;
    private static String c;
    private static PendingIntent d;

    static transient String a(String as[])
    {
        if (as == null || as.length == 0 || as[0] == null)
        {
            Log.w("Kahuna", "App is configured for Push, but you need to call onAppCreate() in your Application to prevent strange behavior!");
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder(as[0]);
        for (int i = 1; i < as.length; i++)
        {
            stringbuilder.append(',').append(as[i]);
        }

        return stringbuilder.toString();
    }

    static void a()
    {
        com/kahuna/sdk/g;
        JVM INSTR monitorenter ;
        if (d != null)
        {
            d.cancel();
            d = null;
        }
        com/kahuna/sdk/g;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    static void a(Context context)
    {
        a(context, 2, "Unregistering app", new Object[0]);
        Intent intent = new Intent("com.google.android.c2dm.intent.UNREGISTER");
        intent.setPackage("com.google.android.gsf");
        a(context, intent);
        context.startService(intent);
    }

    private static transient void a(Context context, int i, String s, Object aobj[])
    {
        if (Log.isLoggable("GCMRegistrar", i))
        {
            s = String.format(s, aobj);
            Log.println(i, "GCMRegistrar", (new StringBuilder()).append("[").append(context.getPackageName()).append("]: ").append(s).toString());
        }
    }

    private static void a(Context context, Intent intent)
    {
        com/kahuna/sdk/g;
        JVM INSTR monitorenter ;
        if (d == null)
        {
            a(context, 2, "Creating pending intent to get package name", new Object[0]);
            d = PendingIntent.getBroadcast(context, 0, new Intent(), 0);
        }
        intent.putExtra("app", d);
        com/kahuna/sdk/g;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    private static void a(Context context, Boolean boolean1, long l)
    {
        android.content.SharedPreferences.Editor editor = g(context).edit();
        if (boolean1 != null)
        {
            editor.putBoolean("onServer", boolean1.booleanValue());
            a(context, 2, "Setting registeredOnServer flag as %b until %s", new Object[] {
                boolean1, new Timestamp(l)
            });
        } else
        {
            a(context, 2, "Setting registeredOnServer expiration to %s", new Object[] {
                new Timestamp(l)
            });
        }
        editor.putLong("onServerExpirationTime", l);
        editor.commit();
    }

    static void a(Context context, String s)
    {
        com/kahuna/sdk/g;
        JVM INSTR monitorenter ;
        a(context, 2, "Setting the name of retry receiver class to %s", new Object[] {
            s
        });
        c = s;
        com/kahuna/sdk/g;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    public static transient void a(Context context, String as[])
    {
        h.b(context);
        b(context, as);
    }

    static String b(Context context, String s)
    {
        SharedPreferences sharedpreferences = g(context);
        String s1 = sharedpreferences.getString("regId", "");
        int i = f(context);
        a(context, 2, "Saving regId on app version %d", new Object[] {
            Integer.valueOf(i)
        });
        context = sharedpreferences.edit();
        context.putString("regId", s);
        context.putInt("appVersion", i);
        context.commit();
        return s1;
    }

    static void b(Context context)
    {
        com/kahuna/sdk/g;
        JVM INSTR monitorenter ;
        if (a != null) goto _L2; else goto _L1
_L1:
        if (c != null) goto _L4; else goto _L3
_L3:
        a(context, 6, "internal error: retry receiver class not set yet", new Object[0]);
        a = new KahunaPushReceiver();
_L5:
        String s = context.getPackageName();
        IntentFilter intentfilter = new IntentFilter("com.google.android.gcm.intent.RETRY");
        intentfilter.addCategory(s);
        a(context, 2, "Registering retry receiver", new Object[0]);
        b = context;
        b.registerReceiver(a, intentfilter);
_L2:
        com/kahuna/sdk/g;
        JVM INSTR monitorexit ;
        return;
_L4:
        a = (KahunaPushReceiver)Class.forName(c).newInstance();
          goto _L5
        Exception exception;
        exception;
        a(context, 6, "Could not create instance of %s. Using %s directly.", new Object[] {
            c, com/kahuna/sdk/KahunaPushReceiver.getName()
        });
        a = new KahunaPushReceiver();
          goto _L5
        context;
        throw context;
    }

    static transient void b(Context context, String as[])
    {
        as = a(as);
        a(context, 2, "Registering app for senders %s", new Object[] {
            as
        });
        Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
        intent.setPackage("com.google.android.gsf");
        a(context, intent);
        intent.putExtra("sender", as);
        context.startService(intent);
    }

    public static String c(Context context)
    {
        Object obj = g(context);
        String s = ((SharedPreferences) (obj)).getString("regId", "");
        int i = ((SharedPreferences) (obj)).getInt("appVersion", 0x80000000);
        int j = f(context);
        obj = s;
        if (i != 0x80000000)
        {
            obj = s;
            if (i != j)
            {
                a(context, 2, "App version changed from %d to %d;resetting registration id", new Object[] {
                    Integer.valueOf(i), Integer.valueOf(j)
                });
                e(context);
                obj = "";
            }
        }
        return ((String) (obj));
    }

    public static boolean d(Context context)
    {
        return c(context).length() > 0;
    }

    static String e(Context context)
    {
        a(context, null, 0L);
        return b(context, "");
    }

    private static int f(Context context)
    {
        int i;
        try
        {
            i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new RuntimeException((new StringBuilder()).append("Coult not get package name: ").append(context).toString());
        }
        return i;
    }

    private static SharedPreferences g(Context context)
    {
        return h.d(context);
    }
}
