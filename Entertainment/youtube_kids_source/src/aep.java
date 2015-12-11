// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.view.View;
import java.util.ArrayList;

public abstract class aep
{

    final ArrayList a = new ArrayList();
    private final Handler b = new Handler();
    private Runnable c;

    public aep()
    {
        c = new aeq(this);
        b.post(c);
    }

    public bn a()
    {
        Object obj;
        if (a.size() > 0)
        {
            obj = (bn)a.remove(0);
        } else
        {
            obj = String.valueOf(getClass().getName());
            (new StringBuilder(String.valueOf(obj).length() + 59)).append("Ran out of presenters.  Consider making the pool (").append(((String) (obj))).append(") larger.");
            obj = b();
        }
        if ((double)a.size() < (double)c() * 0.20000000000000001D)
        {
            b.removeCallbacks(c);
            b.postDelayed(c, 250L);
        }
        return ((bn) (obj));
    }

    public final void a(View view)
    {
        a.add(b(view));
    }

    protected abstract bn b();

    protected abstract bn b(View view);

    protected abstract int c();
}
