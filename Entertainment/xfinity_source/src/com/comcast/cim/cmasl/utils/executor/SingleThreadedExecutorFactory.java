// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.utils.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

// Referenced classes of package com.comcast.cim.cmasl.utils.executor:
//            ExecutorFactory

public class SingleThreadedExecutorFactory
    implements ExecutorFactory
{

    public SingleThreadedExecutorFactory()
    {
    }

    public Executor create()
    {
        return Executors.newSingleThreadExecutor();
    }
}
