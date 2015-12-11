// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Looper;
import android.view.ViewGroup;

public abstract class ckh extends ViewGroup
{

    private final Runnable a = new cki(this);
    private final Runnable b = new ckj(this);

    public ckh(Context context)
    {
        super(context);
    }

    protected final void a(Runnable runnable, Runnable runnable1, int i)
    {
        if (runnable != null)
        {
            removeCallbacks(runnable);
        }
        if (i > 0)
        {
            postDelayed(runnable1, i);
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper())
        {
            runnable1.run();
            return;
        } else
        {
            post(runnable1);
            return;
        }
    }

    public final void b(boolean flag)
    {
        Runnable runnable;
        Runnable runnable1;
        if (flag)
        {
            runnable = b;
        } else
        {
            runnable = a;
        }
        if (flag)
        {
            runnable1 = a;
        } else
        {
            runnable1 = b;
        }
        a(runnable, runnable1, 0);
    }
}
