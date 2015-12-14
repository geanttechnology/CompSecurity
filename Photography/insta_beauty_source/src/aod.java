// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import com.fotoable.ad.FotoAdStrategy;

class aod
    implements com.fotoable.ad.FotoAdStrategy.FotoAdStrategyListener
{

    final aoc a;

    aod(aoc aoc1)
    {
        a = aoc1;
        super();
    }

    public void onAdInReterund(boolean flag)
    {
        Log.i("FullScreenAdManager", (new StringBuilder()).append("FullScreenAdManager onAdInReterund : ").append(flag).toString());
        if (flag)
        {
            a.a(FotoAdStrategy.getMadFullInfo());
        }
    }
}
