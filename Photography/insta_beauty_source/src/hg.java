// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.ad.StaticFlurryEvent;

class hg
    implements Runnable
{

    final hf a;

    hg(hf hf1)
    {
        a = hf1;
        super();
    }

    public void run()
    {
        StaticFlurryEvent.logADEventWithKV(StaticFlurryEvent.FBNativeAD, StaticFlurryEvent.adClicked);
        StaticFlurryEvent.logADClickedEvent(a.b.a, StaticFlurryEvent.FBNativeAD_Click);
    }
}
