// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.concurrent.Callable;

// Referenced classes of package android.support.v7:
//            to

static final class a
    implements Callable
{

    final Runnable a;

    public Void a()
    {
        a.run();
        return null;
    }

    public Object call()
        throws Exception
    {
        return a();
    }

    lable(Runnable runnable)
    {
        a = runnable;
        super();
    }
}
