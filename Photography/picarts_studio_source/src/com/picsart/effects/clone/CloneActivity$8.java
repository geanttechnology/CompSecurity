// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.clone;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;

// Referenced classes of package com.picsart.effects.clone:
//            CloneActivity

final class c
    implements Runnable
{

    private Bitmap a;
    private boolean b;
    private Bitmap c;
    private CloneActivity d;

    public final void run()
    {
        d.e();
        if (CloneActivity.f(d) != null)
        {
            Looper looper = CloneActivity.f(d).getLooper();
            if (looper != null)
            {
                looper.quit();
            }
        }
        if (d.isFinishing()) goto _L2; else goto _L1
_L1:
        if ((a == null || a.isRecycled()) && b || c == null || c.isRecycled()) goto _L4; else goto _L3
_L3:
        CloneActivity.a(d, a);
        CloneActivity.b(d, c);
        CloneActivity.g(d);
_L6:
        return;
_L4:
        d.finish();
        return;
_L2:
        if (a != null && !a.isRecycled())
        {
            a.recycle();
        }
        if (c != null && !c.isRecycled())
        {
            c.recycle();
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    (CloneActivity cloneactivity, Bitmap bitmap, boolean flag, Bitmap bitmap1)
    {
        d = cloneactivity;
        a = bitmap;
        b = flag;
        c = bitmap1;
        super();
    }
}
