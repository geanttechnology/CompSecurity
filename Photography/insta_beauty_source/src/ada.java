// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.fotobeauty.WantuActivity;
import com.fotoable.fullscreenad.FullScreenAdView;

public class ada
    implements aom
{

    final WantuActivity a;

    public ada(WantuActivity wantuactivity)
    {
        a = wantuactivity;
        super();
    }

    public void a()
    {
        if (WantuActivity.b(a) != null)
        {
            WantuActivity.b(a).destroyView();
            WantuActivity.a(a, null);
        }
        WantuActivity.c(a);
    }

    public void a(String s)
    {
        WantuActivity.a(a, s);
    }
}
