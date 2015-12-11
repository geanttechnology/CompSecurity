// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cardstream.c;

import com.google.a.a.e;
import com.target.a.a.b;

// Referenced classes of package com.target.ui.fragment.cardstream.c:
//            b

public abstract class com.target.ui.fragment.cardstream.c.a
    implements com.target.ui.fragment.cardstream.c.b
{
    public static interface a
    {

        public abstract void a(e e1);
    }


    public static final long DEFAULT_LOADING_THROTTLE_DELAY_MILLIS = 20000L;
    private static final String LOG_TAG = "DataSource";
    private boolean isStarted;
    private volatile Object loadedDataCache;
    private final a mCachingDataSourceLoadedListener = m();
    private final a mInjectedDataSourceLoadedListener;
    private final String mName;
    protected final j.b mThrottlingTaskRunner;

    public com.target.ui.fragment.cardstream.c.a(j.c c1, a a1, String s)
    {
        isStarted = false;
        mInjectedDataSourceLoadedListener = a1;
        mThrottlingTaskRunner = a(c1, b(), s);
        mName = s;
    }

    private j.b a(j.c c1, long l1, String s)
    {
        return c1.a(new Runnable() {

            final com.target.ui.fragment.cardstream.c.a this$0;

            public void run()
            {
                com.target.a.a.b.d("DataSource", (new StringBuilder()).append(com.target.ui.fragment.cardstream.c.a.a(com.target.ui.fragment.cardstream.c.a.this)).append(": doLoadData()").toString());
                com.target.ui.fragment.cardstream.c.a.this.a(com.target.ui.fragment.cardstream.c.a.d(com.target.ui.fragment.cardstream.c.a.this));
                com.target.a.a.b.d("DataSource", (new StringBuilder()).append(com.target.ui.fragment.cardstream.c.a.a(com.target.ui.fragment.cardstream.c.a.this)).append(": end doLoadData()").toString());
            }

            
            {
                this$0 = com.target.ui.fragment.cardstream.c.a.this;
                super();
            }
        }, l1, s);
    }

    static Object a(com.target.ui.fragment.cardstream.c.a a1, Object obj)
    {
        a1.loadedDataCache = obj;
        return obj;
    }

    static String a(com.target.ui.fragment.cardstream.c.a a1)
    {
        return a1.mName;
    }

    private void a()
    {
        loadedDataCache = null;
        l();
    }

    static Object b(com.target.ui.fragment.cardstream.c.a a1)
    {
        return a1.loadedDataCache;
    }

    static a c(com.target.ui.fragment.cardstream.c.a a1)
    {
        return a1.mInjectedDataSourceLoadedListener;
    }

    static a d(com.target.ui.fragment.cardstream.c.a a1)
    {
        return a1.mCachingDataSourceLoadedListener;
    }

    private a m()
    {
        return new a() {

            final com.target.ui.fragment.cardstream.c.a this$0;

            public void a(e e1)
            {
                com.target.ui.fragment.cardstream.c.a.a(com.target.ui.fragment.cardstream.c.a.this, e1.d());
                com.target.a.a.b.d("DataSource", (new StringBuilder()).append(com.target.ui.fragment.cardstream.c.a.a(com.target.ui.fragment.cardstream.c.a.this)).append(" loaded data: ").append(com.target.ui.fragment.cardstream.c.a.b(com.target.ui.fragment.cardstream.c.a.this)).toString());
                com.target.ui.fragment.cardstream.c.a.c(com.target.ui.fragment.cardstream.c.a.this).a(e1);
            }

            
            {
                this$0 = com.target.ui.fragment.cardstream.c.a.this;
                super();
            }
        };
    }

    protected abstract void a(a a1);

    protected abstract boolean a(Object obj);

    public long b()
    {
        return 20000L;
    }

    protected void c()
    {
    }

    protected void d()
    {
    }

    protected void e()
    {
    }

    public e f()
    {
        return com.google.a.a.e.c(loadedDataCache);
    }

    public boolean g()
    {
        if (loadedDataCache == null)
        {
            return false;
        } else
        {
            return a(loadedDataCache);
        }
    }

    public void h()
    {
        a();
    }

    public final void i()
    {
        this;
        JVM INSTR monitorenter ;
        if (!isStarted) goto _L2; else goto _L1
_L1:
        com.target.a.a.b.b("DataSource", "This DataSource has already been started.");
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        c();
        l();
        isStarted = true;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public final void j()
    {
        this;
        JVM INSTR monitorenter ;
        if (isStarted) goto _L2; else goto _L1
_L1:
        com.target.a.a.b.b("DataSource", "This DataSource has already been stopped.");
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        isStarted = false;
        d();
        mThrottlingTaskRunner.b();
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void k()
    {
        mThrottlingTaskRunner.a(0L);
        l();
    }

    protected final void l()
    {
        com.target.a.a.b.d("DataSource", (new StringBuilder()).append(mName).append(": loadData()").toString());
        e();
        mThrottlingTaskRunner.a();
    }

    public String toString()
    {
        return (new StringBuilder()).append("DataSource{mName='").append(mName).append('\'').append('}').toString();
    }
}
