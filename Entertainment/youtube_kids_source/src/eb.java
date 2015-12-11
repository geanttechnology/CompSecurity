// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Paint;
import android.view.View;
import java.util.WeakHashMap;

class eb
    implements ej
{

    WeakHashMap a;

    eb()
    {
        a = null;
    }

    public int a(int i, int j, int k)
    {
        return View.resolveSize(i, j);
    }

    long a()
    {
        return 10L;
    }

    public void a(View view)
    {
    }

    public void a(View view, float f1)
    {
    }

    public void a(View view, int i, Paint paint)
    {
    }

    public void a(View view, Runnable runnable)
    {
        view.postDelayed(runnable, a());
    }

    public void a(View view, Runnable runnable, long l)
    {
        view.postDelayed(runnable, a() + l);
    }

    public int b(View view)
    {
        return 0;
    }

    public int c(View view)
    {
        return 0;
    }

    public float d(View view)
    {
        return 0.0F;
    }

    public int e(View view)
    {
        return 0;
    }

    public ep f(View view)
    {
        return new ep(view);
    }

    public int g(View view)
    {
        return 0;
    }
}
