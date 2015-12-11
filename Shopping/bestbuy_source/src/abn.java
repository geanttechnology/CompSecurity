// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public abstract class abn
{

    private final Runnable a = new Runnable() {

        final abn a;

        public final void run()
        {
            abn.a(a, Thread.currentThread());
            a.a();
        }

            
            {
                a = abn.this;
                super();
            }
    };
    private volatile Thread b;

    public abn()
    {
    }

    static Thread a(abn abn1, Thread thread)
    {
        abn1.b = thread;
        return thread;
    }

    public abstract void a();

    public abstract void b();

    public final void e()
    {
        abp.a(a);
    }

    public final void f()
    {
        b();
        if (b != null)
        {
            b.interrupt();
        }
    }
}
