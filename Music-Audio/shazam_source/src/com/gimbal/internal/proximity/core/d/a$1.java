// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity.core.d;

import java.util.concurrent.ThreadFactory;

// Referenced classes of package com.gimbal.internal.proximity.core.d:
//            a

static final class a
    implements ThreadFactory
{

    private int a;
    private String b;

    public final Thread newThread(Runnable runnable)
    {
        StringBuilder stringbuilder = (new StringBuilder()).append(b).append("-");
        int i = a + 1;
        a = i;
        return new Thread(runnable, stringbuilder.append(i).toString());
    }

    (String s)
    {
        b = s;
        super();
        a = 0;
    }
}
