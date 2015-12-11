// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.opengl.GLSurfaceView;

// Referenced classes of package com.tapjoy.internal:
//            bg, fx, cf

static final class iew
    implements bg
{

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

    iew()
    {
    }
}
