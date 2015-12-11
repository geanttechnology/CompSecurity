// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.app.Activity;
import android.opengl.GLSurfaceView;

// Referenced classes of package com.tapjoy.internal:
//            cf, d, bg

public final class fx
{

    public static final bg a = new bg() {

        public final boolean a(Runnable runnable)
        {
            GLSurfaceView glsurfaceview = (GLSurfaceView)fx.c().a();
            if (glsurfaceview != null)
            {
                glsurfaceview.queueEvent(runnable);
                return true;
            } else
            {
                return false;
            }
        }

    };
    private static Activity b;
    private static final cf c = new cf();
    private static final cf d = new cf();

    public static Activity a()
    {
        Activity activity1 = b;
        Activity activity = activity1;
        if (activity1 == null)
        {
            activity = com.tapjoy.internal.d.a();
        }
        return activity;
    }

    static void a(GLSurfaceView glsurfaceview)
    {
        c.a(glsurfaceview);
        glsurfaceview.queueEvent(new Runnable() {

            public final void run()
            {
                Thread thread = Thread.currentThread();
                fx.d().a(thread);
            }

        });
    }

    public static Thread b()
    {
        return (Thread)d.a();
    }

    static cf c()
    {
        return c;
    }

    static cf d()
    {
        return d;
    }

}
