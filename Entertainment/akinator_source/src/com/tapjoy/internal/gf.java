// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Html;
import com.tapjoy.TapjoyReceiver;

// Referenced classes of package com.tapjoy.internal:
//            s, ga, ae, a, 
//            gd, gg, cw, u, 
//            gn, q

public final class gf extends s
{

    private static gf c;

    private gf(Context context)
    {
        super(context, new u() {

            public final String a(Context context1)
            {
                return gn.a(context1).b.getString("gcm.senderIds", "");
            }

            public final void a(Context context1, int i)
            {
                q.a(gn.a(context1).b, "gcm.appVersion", i);
            }

            public final void a(Context context1, long l)
            {
                context1 = gn.a(context1).b.edit();
                context1.putLong("gcm.onServerExpirationTime", l);
                context1.commit();
            }

            public final void a(Context context1, String s1)
            {
                q.a(gn.a(context1).b, "gcm.senderIds", s1);
            }

            public final void a(Context context1, boolean flag)
            {
                q.a(gn.a(context1).b, "gcm.stale", flag);
            }

            public final String b(Context context1)
            {
                return gn.a(context1).b.getString("gcm.regId", "");
            }

            public final void b(Context context1, int i)
            {
                q.a(gn.a(context1).b, "gcm.backoff", i);
            }

            public final void b(Context context1, String s1)
            {
                q.a(gn.a(context1).b, "gcm.regId", s1);
            }

            public final void b(Context context1, boolean flag)
            {
                q.a(gn.a(context1).b, "gcm.onServer", flag);
            }

            public final boolean c(Context context1)
            {
                return gn.a(context1).b.getBoolean("gcm.stale", true);
            }

            public final int d(Context context1)
            {
                return gn.a(context1).b.getInt("gcm.appVersion", 0x80000000);
            }

            public final boolean e(Context context1)
            {
                return gn.a(context1).b.getBoolean("gcm.onServer", false);
            }

            public final long f(Context context1)
            {
                return gn.a(context1).b.getLong("gcm.onServerExpirationTime", 0L);
            }

            public final int g(Context context1)
            {
                return gn.a(context1).b.getInt("gcm.backoff", 0);
            }

        });
    }

    private static int a(Bundle bundle, String s1, Context context)
    {
        int i;
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        bundle = ((Bundle) (bundle.get(s1)));
        if (!(bundle instanceof Integer))
        {
            break MISSING_BLOCK_LABEL_48;
        }
        i = ((Integer)bundle).intValue();
        boolean flag = "drawable".equals(context.getResources().getResourceTypeName(i));
        if (flag)
        {
            return i;
        }
        break MISSING_BLOCK_LABEL_48;
        context;
        if (bundle != null && ga.a)
        {
            ae.a(4, "Tapjoy", "meta-data of {} invalid", new Object[] {
                s1
            });
        }
        return 0;
    }

    private static Notification a(Context context, String s1, String s2, String s3, boolean flag, boolean flag1, String s4)
    {
        Object obj = new Intent(context.getApplicationContext(), com/tapjoy/TapjoyReceiver);
        ((Intent) (obj)).setAction("com.tapjoy.PUSH_CLICK");
        ((Intent) (obj)).putExtra("com.tapjoy.PUSH_ID", s1);
        if (s4 != null)
        {
            ((Intent) (obj)).putExtra("com.tapjoy.PUSH_PAYLOAD", s4);
        }
        int i = 0x8000000;
        if (android.os.Build.VERSION.SDK_INT == 19)
        {
            i = 0x10000000;
        }
        s4 = PendingIntent.getBroadcast(context.getApplicationContext(), 0, ((Intent) (obj)), i);
        if (s4 == null)
        {
            return null;
        }
        s1 = context.getPackageManager();
        obj = context.getPackageName();
        int j;
        try
        {
            obj = s1.getApplicationInfo(((String) (obj)), 128);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return null;
        }
        j = a(((ApplicationInfo) (obj)).metaData, "com.tapjoy.notification.icon", context);
        i = j;
        if (j == 0)
        {
            if (((ApplicationInfo) (obj)).icon != 0)
            {
                i = ((ApplicationInfo) (obj)).icon;
            } else
            {
                i = 0x1080093;
            }
        }
        if (s2.length() != 0) goto _L2; else goto _L1
_L1:
        s1 = s1.getApplicationLabel(((ApplicationInfo) (obj)));
_L4:
        s2 = s3;
        if (flag)
        {
            s2 = Html.fromHtml(s3);
        }
        context = new a.d(context);
        ((a.d) (context)).r.icon = i;
        ((a.d) (context)).r.tickerText = s1;
        context.b = s1;
        context.c = s2;
        context.d = s4;
        s3 = ((a.d) (context)).r;
        s3.flags = ((Notification) (s3)).flags | 0x10;
        s3 = new a.c();
        s3.e = s1;
        s3.a = s2;
        context = context.a(s3);
        if (flag1)
        {
            ((a.d) (context)).r.defaults = 1;
        }
        return com.tapjoy.internal.a.a().a(context);
_L2:
        s1 = s2;
        if (flag)
        {
            s1 = Html.fromHtml(s2);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static gf a(Context context)
    {
        com/tapjoy/internal/gf;
        JVM INSTR monitorenter ;
        if (c == null)
        {
            c = new gf(context);
        }
        context = c;
        com/tapjoy/internal/gf;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    private static boolean a(Object obj)
    {
        return Boolean.TRUE.equals(obj) || "true".equals(obj);
    }

    protected final void a(int i)
    {
    }

    protected final void a(Context context, String s1)
    {
        gd.a(context).c(s1);
    }

    protected final void a(String s1)
    {
        a();
    }

    protected final boolean a(Context context, Intent intent)
    {
        String s1;
        intent.getExtras();
        s1 = intent.getStringExtra("fiverocks");
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_270;
        }
        if (!gg.a(context).f()) goto _L2; else goto _L1
_L1:
        gd.a(context).d(s1);
_L4:
        return true;
_L2:
        String s2;
        String s3;
        s3 = intent.getStringExtra("title");
        s2 = intent.getStringExtra("message");
        if (s2 == null) goto _L4; else goto _L3
_L3:
        Object obj2 = intent.getExtras();
        intent = ((Intent) (((Bundle) (obj2)).get("rich")));
        Object obj = ((Bundle) (obj2)).get("sound");
        Object obj1 = ((Bundle) (obj2)).get("important");
        String s4 = ((Bundle) (obj2)).getString("payload");
        Object obj3 = ((Bundle) (obj2)).get("always");
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        if ("true".equals(obj3) || Boolean.TRUE.equals(obj3))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj2 = ((Bundle) (obj2)).get("repeatable");
        if ("true".equals(obj2) || Boolean.TRUE.equals(obj2))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (!flag && gd.a(context).f()) goto _L4; else goto _L5
_L5:
        s3 = cw.a(s3);
        flag2 = a(intent);
        flag3 = a(obj);
        a(obj1);
        intent = a(context, s1, s3, s2, flag2, flag3, s4);
        if (!gd.a(context).a(context, s1, flag1)) goto _L4; else goto _L6
_L6:
        ((NotificationManager)context.getSystemService("notification")).notify(0, intent);
        return true;
        return false;
    }

    protected final boolean b(String s1)
    {
        return true;
    }

    protected final boolean c(String s1)
    {
        return false;
    }

    final void d(String s1)
    {
        if (s1 != null && s1.length() > 0)
        {
            super.a(new String[] {
                s1
            });
        }
    }
}
