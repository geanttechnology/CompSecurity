// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.beautyui.newui.MNewSofterFragment;

class vi
    implements Runnable
{

    final vh a;

    vi(vh vh1)
    {
        a = vh1;
        super();
    }

    public void run()
    {
        if (MNewSofterFragment.c(a.a) != null)
        {
            MNewSofterFragment.k(a.a);
            MNewSofterFragment.c(a.a).a(MNewSofterFragment.d(a.a), MNewSofterFragment.j(a.a));
        }
    }
}
