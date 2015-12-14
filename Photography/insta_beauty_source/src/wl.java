// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.beautyui.newui.MSlimBodyFragment;

class wl
    implements Runnable
{

    final wk a;

    wl(wk wk1)
    {
        a = wk1;
        super();
    }

    public void run()
    {
        if (MSlimBodyFragment.d(a.a) != null)
        {
            MSlimBodyFragment.d(a.a).a(MSlimBodyFragment.f(a.a), MSlimBodyFragment.e(a.a));
        }
    }
}
