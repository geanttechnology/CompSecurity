// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.fotobeauty.WantuActivity;

public class acv
    implements Runnable
{

    final WantuActivity a;

    public acv(WantuActivity wantuactivity)
    {
        a = wantuactivity;
        super();
    }

    public void run()
    {
        WantuActivity.a(a, false);
    }
}
