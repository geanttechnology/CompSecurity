// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.ViewGroup;
import com.fotoable.beautyui.newui.MSlimBodyFragment;

public class xa
    implements xf
{

    final MSlimBodyFragment a;

    public xa(MSlimBodyFragment mslimbodyfragment)
    {
        a = mslimbodyfragment;
        super();
    }

    public void a()
    {
    }

    public void b()
    {
        ((ViewGroup)a.getView()).removeView(MSlimBodyFragment.p(a));
        MSlimBodyFragment.a(a, null);
    }
}
