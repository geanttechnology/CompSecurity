// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.util;

import java.util.concurrent.ThreadFactory;

final class g
    implements ThreadFactory
{

    final String a;

    g(String s)
    {
        a = s;
        super();
    }

    public final Thread newThread(Runnable runnable)
    {
        return new Thread(runnable, a);
    }
}
