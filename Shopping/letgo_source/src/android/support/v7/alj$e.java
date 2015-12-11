// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.concurrent.ThreadFactory;

// Referenced classes of package android.support.v7:
//            alj

static class adFactory
    implements ThreadFactory
{

    public Thread newThread(Runnable runnable)
    {
        return new <init>(runnable);
    }

    adFactory()
    {
    }
}
