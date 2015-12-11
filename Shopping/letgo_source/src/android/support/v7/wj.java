// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.x;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package android.support.v7:
//            wq, wi, wt

public class wj
{
    public static interface a
    {

        public abstract void zza(wq wq1);

        public abstract void zza(wq wq1, Activity activity);
    }


    private static final a a[] = new a[0];
    private static wj b;
    private final Application c;
    private wq d;
    private final List e = new ArrayList();
    private wt f;

    private wj(Application application)
    {
        x.a(application);
        c = application;
    }

    public static wj a(Context context)
    {
        x.a(context);
        context = (Application)context.getApplicationContext();
        x.a(context);
        android/support/v7/wj;
        JVM INSTR monitorenter ;
        if (b == null)
        {
            b = new wj(context);
        }
        context = b;
        android/support/v7/wj;
        JVM INSTR monitorexit ;
        return context;
        context;
        android/support/v7/wj;
        JVM INSTR monitorexit ;
        throw context;
    }

    private a[] d()
    {
label0:
        {
            a aa[];
            synchronized (e)
            {
                if (!e.isEmpty())
                {
                    break label0;
                }
                aa = a;
            }
            return aa;
        }
        a aa1[] = (a[])e.toArray(new a[e.size()]);
        list;
        JVM INSTR monitorexit ;
        return aa1;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public wq a()
    {
        return d;
    }

    public void a(a a1)
    {
        x.a(a1);
        synchronized (e)
        {
            e.remove(a1);
            e.add(a1);
        }
        return;
        a1;
        list;
        JVM INSTR monitorexit ;
        throw a1;
    }

    public void a(wq wq1, Activity activity)
    {
        a aa[];
        boolean flag;
        flag = false;
        x.a(wq1);
        aa = null;
        if (!wq1.g()) goto _L2; else goto _L1
_L1:
        if (activity instanceof wi)
        {
            ((wi)activity).a(wq1);
        }
        if (d != null)
        {
            wq1.b(d.c());
            wq1.b(d.b());
        }
        aa = d();
        for (int i = 0; i < aa.length; i++)
        {
            aa[i].zza(wq1, activity);
        }

        wq1.h();
        if (!TextUtils.isEmpty(wq1.b())) goto _L2; else goto _L3
_L3:
        return;
_L2:
        if (d != null && d.c() == wq1.c())
        {
            d = wq1;
            return;
        }
        b();
        d = wq1;
        activity = aa;
        int j = ((flag) ? 1 : 0);
        if (aa == null)
        {
            activity = d();
            j = ((flag) ? 1 : 0);
        }
        while (j < activity.length) 
        {
            activity[j].zza(wq1);
            j++;
        }
        if (true) goto _L3; else goto _L4
_L4:
    }

    public void a(boolean flag)
    {
        if (android.os.Build.VERSION.SDK_INT < 14)
        {
            Log.i("com.google.android.gms.measurement.ScreenViewService", "AutoScreeViewTracking is not supported on API 14 or earlier devices");
        } else
        if (c() != flag)
        {
            if (flag)
            {
                f = new wt(this);
                c.registerActivityLifecycleCallbacks(f);
                return;
            } else
            {
                c.unregisterActivityLifecycleCallbacks(f);
                f = null;
                return;
            }
        }
    }

    public void b()
    {
        d = null;
    }

    public boolean c()
    {
        return f != null;
    }

}
