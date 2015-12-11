// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.google.android.gms.common.internal.w;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.gms.d:
//            jj, jm

public class jc
{
    public static interface a
    {

        public abstract void a(jj jj);

        public abstract void a(jj jj, Activity activity);
    }


    private static final a d[] = new a[0];
    private static jc e;
    final Application a;
    public jj b;
    jm c;
    private final List f = new ArrayList();

    private jc(Application application)
    {
        w.a(application);
        a = application;
    }

    public static jc a(Context context)
    {
        w.a(context);
        context = (Application)context.getApplicationContext();
        w.a(context);
        com/google/android/gms/d/jc;
        JVM INSTR monitorenter ;
        if (e == null)
        {
            e = new jc(context);
        }
        context = e;
        com/google/android/gms/d/jc;
        JVM INSTR monitorexit ;
        return context;
        context;
        com/google/android/gms/d/jc;
        JVM INSTR monitorexit ;
        throw context;
    }

    public final void a(a a1)
    {
        w.a(a1);
        synchronized (f)
        {
            f.remove(a1);
            f.add(a1);
        }
        return;
        a1;
        list;
        JVM INSTR monitorexit ;
        throw a1;
    }

    final a[] a()
    {
label0:
        {
            a aa[];
            synchronized (f)
            {
                if (!f.isEmpty())
                {
                    break label0;
                }
                aa = d;
            }
            return aa;
        }
        a aa1[] = (a[])f.toArray(new a[f.size()]);
        list;
        JVM INSTR monitorexit ;
        return aa1;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
    }

}
