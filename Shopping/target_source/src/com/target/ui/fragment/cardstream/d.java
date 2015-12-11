// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cardstream;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import com.target.ui.fragment.cardstream.a.a;
import com.target.ui.fragment.cardstream.b.c;
import com.target.ui.fragment.cardstream.b.e;
import com.target.ui.fragment.cardstream.c.b;
import com.target.ui.fragment.cardstream.c.g;
import com.target.ui.fragment.cardstream.c.h;
import com.target.ui.service.k;
import com.target.ui.service.m;
import com.target.ui.service.provider.DefaultStringResourceProvider;
import com.target.ui.service.provider.f;

// Referenced classes of package com.target.ui.fragment.cardstream:
//            f, h, c, g, 
//            e

public class d
{

    private final Context ctx;
    private final com.target.ui.fragment.cardstream.c mCardDataSource;
    private final c mCardManagerFactory;
    private final c.b mCardsLoadedlistener;
    private final com.target.ui.fragment.cardstream.b.c.a mDependencies;

    public d(Context context, c.b b1)
    {
        ctx = context;
        mCardsLoadedlistener = a(b1);
        b1 = new h();
        mDependencies = a(context, b1);
        mCardManagerFactory = new c(mDependencies);
        mCardDataSource = a(b1);
    }

    private static com.google.a.a.g a(com.target.ui.fragment.cardstream.b.d d1)
    {
        return new com.google.a.a.g(d1) {

            final com.target.ui.fragment.cardstream.b.d val$provider;

            public boolean a(com.target.ui.fragment.cardstream.e e1)
            {
                return provider.a(e1).a();
            }

            public volatile boolean a(Object obj)
            {
                return a((com.target.ui.fragment.cardstream.e)obj);
            }

            
            {
                provider = d1;
                super();
            }
        };
    }

    private static a a(Context context, com.google.c.a a1)
    {
        return new a(new com.target.a.a.a(context), a1, (int)context.getResources().getDimension(0x7f0a00d0), (int)context.getResources().getDimension(0x7f0a00cf), android.graphics.Bitmap.CompressFormat.PNG, 100);
    }

    private static com.target.ui.fragment.cardstream.b.c.a a(Context context, b b1)
    {
        context = context.getApplicationContext();
        return new com.target.ui.fragment.cardstream.b.c.a(b1, new DefaultStringResourceProvider(context), c(), k.a(), m.a(), com.target.ui.service.a.a(), new e(new com.target.a.a.a(context)), new f(), new com.target.mothership.model.coupons.c(), a(context, com.google.c.a.e));
    }

    static com.target.ui.fragment.cardstream.b.c.a a(d d1)
    {
        return d1.mDependencies;
    }

    private c.b a(final c.b decoratedListener)
    {
        return new c.b() {

            final Handler mHandler = new Handler(Looper.getMainLooper());
            final d this$0;
            final c.b val$decoratedListener;

            private void a(Runnable runnable)
            {
                if (Looper.getMainLooper().getThread() == Thread.currentThread())
                {
                    runnable.run();
                    return;
                } else
                {
                    mHandler.post(runnable);
                    return;
                }
            }

            public void a(com.google.a.a.e e1)
            {
                a(e1. new Runnable() {

                    final _cls1 this$1;
                    final com.google.a.a.e val$data;

                    public void run()
                    {
                        decoratedListener.a(data);
                    }

            
            {
                this$1 = final__pcls1;
                data = com.google.a.a.e.this;
                super();
            }
                });
            }

            public void c()
            {
                a(new Runnable() {

                    final _cls1 this$1;

                    public void run()
                    {
                        decoratedListener.c();
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                });
            }

            
            {
                this$0 = d.this;
                decoratedListener = b1;
                super();
            }
        };
    }

    private com.target.ui.fragment.cardstream.c a(h h1)
    {
        Object obj = new com.target.ui.fragment.cardstream.f((new com.target.ui.fragment.cardstream.h()).a(), mCardManagerFactory.a(), a(((com.target.ui.fragment.cardstream.b.d) (mCardManagerFactory))));
        com.target.b.a a1 = new com.target.b.a() {

            final d this$0;

            public com.google.a.a.e a()
            {
                return com.target.ui.fragment.cardstream.d.a(d.this).relevantStoreService.c();
            }

            public Object b()
            {
                return a();
            }

            
            {
                this$0 = d.this;
                super();
            }
        };
        obj = new com.target.ui.fragment.cardstream.c(mDependencies.throttlingTaskRunnerFactory, mCardsLoadedlistener, mCardManagerFactory.b(), (new com.target.ui.fragment.cardstream.g(a1)).b(), ((com.google.a.a.b) (obj)));
        h1.a(((b) (obj)));
        return ((com.target.ui.fragment.cardstream.c) (obj));
    }

    private static com.target.ui.fragment.cardstream.c.j.c c()
    {
        return new com.target.ui.fragment.cardstream.c.j.c((new com.target.ui.fragment.cardstream.c.d()).a(), g.a());
    }

    public com.target.ui.fragment.cardstream.b.c.a a()
    {
        return mDependencies;
    }

    public com.target.ui.fragment.cardstream.c b()
    {
        return mCardDataSource;
    }
}
