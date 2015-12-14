// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.ad.FotoAdStrategy;
import com.fotoable.fotobeauty.WantuActivity;

public class acx
    implements Runnable
{

    final WantuActivity a;

    public acx(WantuActivity wantuactivity)
    {
        a = wantuactivity;
        super();
    }

    public void run()
    {
        FotoAdStrategy.loadStrategyOnceOnStartRemoved(a.getApplicationContext());
    }
}
