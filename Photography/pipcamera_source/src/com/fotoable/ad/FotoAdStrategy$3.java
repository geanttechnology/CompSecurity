// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.ad;


// Referenced classes of package com.fotoable.ad:
//            FotoAdStrategy

final class val.listener
    implements Runnable
{

    final toAdStrategyListener val$listener;

    public void run()
    {
        val$listener.onAdInReterund(FotoAdStrategy.access$300());
    }

    toAdStrategyListener()
    {
        val$listener = toadstrategylistener;
        super();
    }
}
