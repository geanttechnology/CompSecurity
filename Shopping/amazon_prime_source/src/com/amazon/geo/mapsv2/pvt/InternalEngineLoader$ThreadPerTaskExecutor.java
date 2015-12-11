// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.pvt;

import java.util.concurrent.Executor;

// Referenced classes of package com.amazon.geo.mapsv2.pvt:
//            InternalEngineLoader

private static class <init>
    implements Executor
{

    public void execute(Runnable runnable)
    {
        (new Thread(runnable)).start();
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
