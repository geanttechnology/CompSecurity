// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.view.SurfaceHolder;

// Referenced classes of package com.flurry.sdk:
//            dw

class it>
    implements android.view.ceHolder.Callback
{

    final dw a;

    public void surfaceChanged(SurfaceHolder surfaceholder, int i, int j, int k)
    {
    }

    public void surfaceCreated(SurfaceHolder surfaceholder)
    {
        dw.a(a, true);
        dw.h(a);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder)
    {
        dw.a(a, false);
        a.c();
    }

    Holder(dw dw1)
    {
        a = dw1;
        super();
    }
}
