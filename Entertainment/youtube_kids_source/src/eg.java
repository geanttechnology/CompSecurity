// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;

class eg extends ef
{

    eg()
    {
    }

    public void a(View view)
    {
        view.requestFitSystemWindows();
    }

    public final void a(View view, Runnable runnable)
    {
        view.postOnAnimation(runnable);
    }

    public final void a(View view, Runnable runnable, long l)
    {
        view.postOnAnimationDelayed(runnable, l);
    }

    public final int e(View view)
    {
        return view.getMinimumHeight();
    }
}
