// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.concurrent.Executor;

// Referenced classes of package android.support.v7:
//            anh, anj, and

private static class b
    implements Executor
{

    private final Executor a;
    private final anh b;

    static anh a(utor utor)
    {
        return utor.b;
    }

    public void execute(Runnable runnable)
    {
        a.execute(new anj(runnable, null) {

            final anh.a a;

            public and a()
            {
                return anh.a.a(a);
            }

            
            {
                a = anh.a.this;
                super(runnable, obj);
            }
        });
    }

    public utor(Executor executor, anh anh1)
    {
        a = executor;
        b = anh1;
    }
}
