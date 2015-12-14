// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.ad.FotoAdStrategy;

class hy
    implements com.fotoable.ad.FotoAdStrategy.FotoAdStrategyListener
{

    final hu a;

    hy(hu hu1)
    {
        a = hu1;
        super();
    }

    public void onAdInReterund(boolean flag)
    {
        if (flag)
        {
            String s1 = FotoAdStrategy.getMadFotoAlertInfo();
            String s = s1;
            if (s1 == null)
            {
                s = "";
            }
            a.a(s);
            hu.a(a, s);
        }
    }
}
