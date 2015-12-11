// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.g.a;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class g
{

    private static final ScheduledExecutorService a = Executors.newSingleThreadScheduledExecutor();

    public static ScheduledExecutorService a()
    {
        return a;
    }

}
