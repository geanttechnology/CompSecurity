// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.beautyui.newui.MSlimBodyFragment;

public class wj
    implements Runnable
{

    final MSlimBodyFragment a;

    public wj(MSlimBodyFragment mslimbodyfragment)
    {
        a = mslimbodyfragment;
        super();
    }

    public void run()
    {
        if (MSlimBodyFragment.d(a) != null)
        {
            MSlimBodyFragment.d(a).a(MSlimBodyFragment.e(a));
        }
    }
}
