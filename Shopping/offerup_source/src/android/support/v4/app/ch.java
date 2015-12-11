// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package android.support.v4.app:
//            cl, cj, ck, co, 
//            ci, bg, cm, cq

public final class ch
{

    private static final int a;
    private static final Object b = new Object();
    private static String c;
    private static Set d = new HashSet();
    private static final Object g = new Object();
    private static co h;
    private static final cj i;
    private final Context e;
    private final NotificationManager f;

    private ch(Context context)
    {
        e = context;
        f = (NotificationManager)e.getSystemService("notification");
    }

    static int a()
    {
        return a;
    }

    public static ch a(Context context)
    {
        return new ch(context);
    }

    private void a(cq cq)
    {
        synchronized (g)
        {
            if (h == null)
            {
                h = new co(e.getApplicationContext());
            }
        }
        h.a(cq);
        return;
        cq;
        obj;
        JVM INSTR monitorexit ;
        throw cq;
    }

    public static Set b(Context context)
    {
        context = android.provider.Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        if (context != null && !context.equals(c))
        {
            String as[] = context.split(":");
            HashSet hashset = new HashSet(as.length);
            int k = as.length;
            for (int j = 0; j < k; j++)
            {
                ComponentName componentname = ComponentName.unflattenFromString(as[j]);
                if (componentname != null)
                {
                    hashset.add(componentname.getPackageName());
                }
            }

            synchronized (b)
            {
                d = hashset;
                c = context;
            }
        }
        return d;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    public final void a(int j)
    {
        i.a(f, null, j);
        if (android.os.Build.VERSION.SDK_INT <= 19)
        {
            a(((cq) (new ci(e.getPackageName(), j, null))));
        }
    }

    public final void a(int j, Notification notification)
    {
        Bundle bundle = bg.a(notification);
        boolean flag;
        if (bundle != null && bundle.getBoolean("android.support.useSideChannel"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            a(((cq) (new cm(e.getPackageName(), j, null, notification))));
            i.a(f, null, j);
            return;
        } else
        {
            i.a(f, null, j, notification);
            return;
        }
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            i = new cl();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 5)
        {
            i = new ck();
        } else
        {
            i = new cj();
        }
        a = i.a();
    }
}
