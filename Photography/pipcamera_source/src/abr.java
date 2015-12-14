// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.concurrent.Executor;

class abr
    implements Executor
{

    private final Executor a;
    private final abq b;

    public abr(Executor executor, abq abq)
    {
        a = executor;
        b = abq;
    }

    static abq a(abr abr1)
    {
        return abr1.b;
    }

    public void execute(Runnable runnable)
    {
        a.execute(new abt(runnable, null) {

            final abr a;

            public abo a()
            {
                return abr.a(a);
            }

            
            {
                a = abr.this;
                super(runnable, obj);
            }
        });
    }
}
