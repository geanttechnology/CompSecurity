// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.beautyui.newui.MNewSofterFragment;

public class vg
    implements Runnable
{

    final MNewSofterFragment a;

    public vg(MNewSofterFragment mnewsofterfragment)
    {
        a = mnewsofterfragment;
        super();
    }

    public void run()
    {
        if (MNewSofterFragment.c(a) != null)
        {
            MNewSofterFragment.c(a).a(MNewSofterFragment.j(a));
        }
    }
}
