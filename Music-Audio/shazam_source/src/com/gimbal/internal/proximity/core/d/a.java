// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity.core.d;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public final class a
{

    private static final ExecutorService a = Executors.newFixedThreadPool(20);

    public static ExecutorService a()
    {
        return a;
    }

    public static ExecutorService a(String s)
    {
        return Executors.newFixedThreadPool(1, new ThreadFactory(s) {

            private int a;
            private String b;

            public final Thread newThread(Runnable runnable)
            {
                StringBuilder stringbuilder = (new StringBuilder()).append(b).append("-");
                int i = a + 1;
                a = i;
                return new Thread(runnable, stringbuilder.append(i).toString());
            }

            
            {
                b = s;
                super();
                a = 0;
            }
        });
    }

}
