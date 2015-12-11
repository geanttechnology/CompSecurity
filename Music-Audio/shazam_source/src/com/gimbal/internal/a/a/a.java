// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.a.a;

import android.app.Activity;
import android.os.Bundle;
import com.gimbal.a.b;
import com.gimbal.internal.c.c;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.gimbal.internal.a.a:
//            b

public class a
    implements android.app.Application.ActivityLifecycleCallbacks
{

    private static final b a = com.gimbal.internal.c.c.f(com/gimbal/internal/a/a/a.getName());
    private boolean b;
    private boolean c;
    private final List d;
    private Runnable e;

    public static a a()
    {
        return null;
    }

    static boolean a(a a1)
    {
        return a1.b;
    }

    static b b()
    {
        return a;
    }

    static boolean b(a a1)
    {
        return a1.c;
    }

    static boolean c(a a1)
    {
        a1.b = false;
        return false;
    }

    static List d(a a1)
    {
        return a1.d;
    }

    public void onActivityCreated(Activity activity, Bundle bundle)
    {
    }

    public void onActivityDestroyed(Activity activity)
    {
    }

    public void onActivityPaused(Activity activity)
    {
        c = true;
        if (e != null)
        {
            activity = e;
            throw new NullPointerException();
        } else
        {
            e = new Runnable() {

                private a a;

                public final void run()
                {
                    if (a.a(a) && com.gimbal.internal.a.a.a.b(a))
                    {
                        com.gimbal.internal.a.a.a.c(a);
                        com.gimbal.internal.a.a.a.b().a("went background", new Object[0]);
                        for (Iterator iterator = a.d(a).iterator(); iterator.hasNext();)
                        {
                            com.gimbal.internal.a.a.b b1 = (com.gimbal.internal.a.a.b)iterator.next();
                            try
                            {
                                b1.b();
                            }
                            catch (Exception exception)
                            {
                                com.gimbal.internal.a.a.a.b().d("Listener failed", new Object[] {
                                    exception
                                });
                            }
                        }

                    } else
                    {
                        com.gimbal.internal.a.a.a.b().a("still foreground", new Object[0]);
                    }
                }

            
            {
                a = a.this;
                super();
            }
            };
            throw new NullPointerException();
        }
    }

    public void onActivityResumed(Activity activity)
    {
        c = false;
        boolean flag;
        if (!b)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b = true;
        if (e != null)
        {
            activity = e;
            throw new NullPointerException();
        }
        if (flag)
        {
            a.a("went foreground", new Object[0]);
            for (activity = d.iterator(); activity.hasNext();)
            {
                com.gimbal.internal.a.a.b b1 = (com.gimbal.internal.a.a.b)activity.next();
                try
                {
                    b1.a();
                }
                catch (Exception exception)
                {
                    a.d("Listener failed", new Object[] {
                        exception
                    });
                }
            }

        } else
        {
            a.a("still foreground", new Object[0]);
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle)
    {
    }

    public void onActivityStarted(Activity activity)
    {
    }

    public void onActivityStopped(Activity activity)
    {
    }

}
