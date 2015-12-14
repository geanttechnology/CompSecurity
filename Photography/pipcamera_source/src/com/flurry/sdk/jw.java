// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

// Referenced classes of package com.flurry.sdk:
//            js, jv, kg

public class jw
{

    private static jw a;
    private static final String b = com/flurry/sdk/jw.getSimpleName();
    private Object c;

    private jw()
    {
        e();
    }

    public static jw a()
    {
        com/flurry/sdk/jw;
        JVM INSTR monitorenter ;
        jw jw1;
        if (a == null)
        {
            a = new jw();
        }
        jw1 = a;
        com/flurry/sdk/jw;
        JVM INSTR monitorexit ;
        return jw1;
        Exception exception;
        exception;
        throw exception;
    }

    public static void b()
    {
        com/flurry/sdk/jw;
        JVM INSTR monitorenter ;
        if (a != null)
        {
            a.f();
        }
        a = null;
        com/flurry/sdk/jw;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    static String d()
    {
        return b;
    }

    private void e()
    {
        android.content.Context context;
        if (android.os.Build.VERSION.SDK_INT >= 14 && c == null)
        {
            if ((context = js.a().c()) instanceof Application)
            {
                c = new android.app.Application.ActivityLifecycleCallbacks() {

                    final jw a;

                    protected void a(Activity activity, jv.a a1)
                    {
                        jv jv1 = new jv();
                        jv1.a = activity;
                        jv1.b = a1;
                        jv1.b();
                    }

                    public void onActivityCreated(Activity activity, Bundle bundle)
                    {
                        kg.a(3, jw.d(), (new StringBuilder()).append("onActivityCreated for activity:").append(activity).toString());
                        a(activity, jv.a.a);
                    }

                    public void onActivityDestroyed(Activity activity)
                    {
                        kg.a(3, jw.d(), (new StringBuilder()).append("onActivityDestroyed for activity:").append(activity).toString());
                        a(activity, jv.a.b);
                    }

                    public void onActivityPaused(Activity activity)
                    {
                        kg.a(3, jw.d(), (new StringBuilder()).append("onActivityPaused for activity:").append(activity).toString());
                        a(activity, jv.a.c);
                    }

                    public void onActivityResumed(Activity activity)
                    {
                        kg.a(3, jw.d(), (new StringBuilder()).append("onActivityResumed for activity:").append(activity).toString());
                        a(activity, jv.a.d);
                    }

                    public void onActivitySaveInstanceState(Activity activity, Bundle bundle)
                    {
                        kg.a(3, jw.d(), (new StringBuilder()).append("onActivitySaveInstanceState for activity:").append(activity).toString());
                        a(activity, jv.a.g);
                    }

                    public void onActivityStarted(Activity activity)
                    {
                        kg.a(3, jw.d(), (new StringBuilder()).append("onActivityStarted for activity:").append(activity).toString());
                        a(activity, jv.a.e);
                    }

                    public void onActivityStopped(Activity activity)
                    {
                        kg.a(3, jw.d(), (new StringBuilder()).append("onActivityStopped for activity:").append(activity).toString());
                        a(activity, jv.a.f);
                    }

            
            {
                a = jw.this;
                super();
            }
                };
                ((Application)context).registerActivityLifecycleCallbacks((android.app.Application.ActivityLifecycleCallbacks)c);
                return;
            }
        }
    }

    private void f()
    {
        android.content.Context context;
        if (android.os.Build.VERSION.SDK_INT >= 14 && c != null)
        {
            if ((context = js.a().c()) instanceof Application)
            {
                ((Application)context).unregisterActivityLifecycleCallbacks((android.app.Application.ActivityLifecycleCallbacks)c);
                c = null;
                return;
            }
        }
    }

    public boolean c()
    {
        return c != null;
    }

}
