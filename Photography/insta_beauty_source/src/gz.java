// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.ad.StaticFlurryEvent;

class gz
    implements Runnable
{

    final gy a;

    gz(gy gy1)
    {
        a = gy1;
        super();
    }

    public void run()
    {
        if (a.a.a != null)
        {
            a.a.a.adIconLoaded(a.a.b);
            StaticFlurryEvent.logADEventWithKV(StaticFlurryEvent.FBNativeIconAD, StaticFlurryEvent.adLoaded);
        }
    }
}
