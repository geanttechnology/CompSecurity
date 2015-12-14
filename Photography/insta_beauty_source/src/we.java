// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.beautyui.newui.MOneKeyFragment;

class we
    implements Runnable
{

    final wd a;

    we(wd wd1)
    {
        a = wd1;
        super();
    }

    public void run()
    {
        if (MOneKeyFragment.f(a.b) != null)
        {
            MOneKeyFragment.f(a.b).a(a.a, MOneKeyFragment.c());
        }
    }
}
