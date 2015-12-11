// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.ah;
import android.view.Window;

// Referenced classes of package android.support.v7.app:
//            m, a

static class a extends m
    implements a
{

    private final Activity a;

    public void a(float f)
    {
        if (f != 1.0F) goto _L2; else goto _L1
_L1:
        a(true);
_L4:
        super.b(f);
        return;
_L2:
        if (f == 0.0F)
        {
            a(false);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    boolean a()
    {
        return ah.g(a.getWindow().getDecorView()) == 1;
    }

    public (Activity activity, Context context)
    {
        super(context);
        a = activity;
    }
}
