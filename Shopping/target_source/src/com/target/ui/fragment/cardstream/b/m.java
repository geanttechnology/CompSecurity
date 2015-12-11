// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cardstream.b;

import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.model.store.interfaces.RelevantStoreSummary;
import com.target.ui.fragment.cardstream.b;
import com.target.ui.fragment.cardstream.f.e;
import com.target.ui.service.k;
import com.target.ui.service.provider.s;

// Referenced classes of package com.target.ui.fragment.cardstream.b:
//            b, a

public class m
    implements com.target.ui.fragment.cardstream.b.b
{
    static class a extends com.target.ui.fragment.cardstream.c.a
    {

        private static final String LOG_TAG = "WelcomeCardDataSource";
        private com.target.ui.service.k.c mListener;
        private final k mRelevantStoreService;

        static void a(a a1)
        {
            a1.l();
        }

        static boolean a(com.google.a.a.e e1, com.google.a.a.e e2)
        {
            boolean flag2 = true;
            e1 = (RelevantStoreSummary)e1.d();
            e2 = (RelevantStoreSummary)e2.d();
            boolean flag;
            if (e1 == null && e2 == null)
            {
                flag = false;
            } else
            {
                flag = flag2;
                if (e1 != null)
                {
                    flag = flag2;
                    if (e2 != null)
                    {
                        flag = flag2;
                        if (e1.a() == e1.a())
                        {
                            e1 = e1.getStoreId().a();
                            boolean flag1;
                            if (!e2.getStoreId().a().equals(e1))
                            {
                                flag1 = true;
                            } else
                            {
                                flag1 = false;
                            }
                            return flag1;
                        }
                    }
                }
            }
            return flag;
        }

        protected void a(com.target.ui.fragment.cardstream.c.a.a a1)
        {
            a1.a(mRelevantStoreService.c());
        }

        protected boolean a(RelevantStoreSummary relevantstoresummary)
        {
            return true;
        }

        protected volatile boolean a(Object obj)
        {
            return a((RelevantStoreSummary)obj);
        }

        public long b()
        {
            return 500L;
        }

        protected void c()
        {
            mListener = new com.target.ui.service.k.c() {

                final a this$0;

                public void a(com.google.a.a.e e1)
                {
                    if (a.a(f(), e1))
                    {
                        a.a(a.this);
                        return;
                    } else
                    {
                        com.target.a.a.b.d("WelcomeCardDataSource", "All relevant attributes for current store are identical to previous store.  Not reloading  welcome card data source");
                        return;
                    }
                }

            
            {
                this$0 = a.this;
                super();
            }
            };
            mRelevantStoreService.a(mListener);
        }

        protected void d()
        {
            if (mListener != null)
            {
                mRelevantStoreService.b(mListener);
            }
        }

        a(com.target.ui.fragment.cardstream.c.j.c c1, com.target.ui.fragment.cardstream.c.a.a a1, k k1)
        {
            super(c1, a1, "WelcomeCardDataSource");
            mRelevantStoreService = k1;
        }
    }


    private final e mChrome = d();
    private final a mDataSource;
    private final s mStringProvider;

    m(s s1, a a1)
    {
        mStringProvider = s1;
        mDataSource = a1;
    }

    private e d()
    {
        return com.target.ui.fragment.cardstream.b.a.sHideActionsList.a(com.target.ui.fragment.cardstream.b.a.a(0x7f020057, 0x7f0900ec));
    }

    private e e()
    {
        Object obj = mDataSource.f();
        if (!((com.google.a.a.e) (obj)).b())
        {
            return null;
        } else
        {
            obj = mStringProvider.a(0x7f0900e6, new Object[] {
                ((RelevantStoreSummary)((com.google.a.a.e) (obj)).c()).getName()
            });
            return com.target.ui.fragment.cardstream.f.e.a(0x7f100010).a(((CharSequence) (obj))).a();
        }
    }

    public boolean a()
    {
        com.google.a.a.e e1 = mDataSource.f();
        return e1.b() && ((RelevantStoreSummary)e1.c()).a();
    }

    public com.google.a.a.e b()
    {
        e e1 = e();
        if (e1 == null)
        {
            return com.google.a.a.e.e();
        } else
        {
            return com.google.a.a.e.b(new b(0x7f03002c, mChrome, e1, c()));
        }
    }

    public com.target.ui.fragment.cardstream.e c()
    {
        return com.target.ui.fragment.cardstream.e.WELCOME;
    }
}
