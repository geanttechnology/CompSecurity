// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.fotobeauty.WantuActivity;

public class act
    implements Runnable
{

    final WantuActivity a;

    public act(WantuActivity wantuactivity)
    {
        a = wantuactivity;
        super();
    }

    public void run()
    {
        a.f();
        WantuActivity.d(a);
    }
}
