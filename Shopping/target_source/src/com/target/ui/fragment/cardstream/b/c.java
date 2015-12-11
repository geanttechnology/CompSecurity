// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cardstream.b;

import android.support.v4.f.a;
import android.support.v4.f.h;
import com.google.a.b.k;
import com.target.ui.fragment.cardstream.c.i;
import com.target.ui.fragment.cardstream.e;
import com.target.ui.helper.j.b;
import com.target.ui.service.m;
import com.target.ui.service.provider.f;
import com.target.ui.service.provider.s;
import java.util.Collections;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.target.ui.fragment.cardstream.b:
//            d, f, m, j, 
//            i, k, l, h, 
//            g, b, e

public class c
    implements d
{
    public static class a
    {

        public final com.target.ui.service.a accountService;
        public final com.target.ui.fragment.cardstream.c.b cardStreamInvalidator;
        public final com.target.ui.fragment.cardstream.a.a code128BarcodeFactory;
        public final com.target.mothership.model.coupons.c couponsManager;
        public final com.target.b.a guestProvider;
        public final com.target.ui.service.k relevantStoreService;
        public final com.target.ui.fragment.cardstream.b.e simpleStorage;
        public final m singleListService;
        public final s stringResourceProvider;
        public final com.target.ui.fragment.cardstream.c.j.c throttlingTaskRunnerFactory;

        public a(com.target.ui.fragment.cardstream.c.b b1, s s, com.target.ui.fragment.cardstream.c.j.c c1, com.target.ui.service.k k1, m m1, com.target.ui.service.a a1, com.target.ui.fragment.cardstream.b.e e1, 
                com.target.b.a a2, com.target.mothership.model.coupons.c c2, com.target.ui.fragment.cardstream.a.a a3)
        {
            cardStreamInvalidator = b1;
            stringResourceProvider = s;
            throttlingTaskRunnerFactory = c1;
            relevantStoreService = k1;
            singleListService = m1;
            accountService = a1;
            simpleStorage = e1;
            guestProvider = a2;
            couponsManager = c2;
            code128BarcodeFactory = a3;
        }
    }


    private final List mAllDataSources;
    private final Map mCardManagers;
    private final a mDependencies;

    public c(a a1)
    {
        mDependencies = a1;
        a1 = c();
        mCardManagers = (Map)((h) (a1)).a;
        mAllDataSources = (List)((h) (a1)).b;
        d();
    }

    private com.target.b.a a(final com.target.ui.service.k service)
    {
        return new com.target.b.a() {

            final c this$0;
            final com.target.ui.service.k val$service;

            public com.google.a.a.e a()
            {
                return service.c();
            }

            public Object b()
            {
                return a();
            }

            
            {
                this$0 = c.this;
                service = k1;
                super();
            }
        };
    }

    private com.target.ui.fragment.cardstream.c.a.a a(final com.target.ui.fragment.cardstream.c.b cardStreamInvalidator)
    {
        return new com.target.ui.fragment.cardstream.c.a.a() {

            final c this$0;
            final com.target.ui.fragment.cardstream.c.b val$cardStreamInvalidator;

            public void a(com.google.a.a.e e1)
            {
                cardStreamInvalidator.h();
            }

            
            {
                this$0 = c.this;
                cardStreamInvalidator = b1;
                super();
            }
        };
    }

    private i a(com.target.ui.fragment.cardstream.c.c c1)
    {
        b b1 = new b();
        return new i(mDependencies.throttlingTaskRunnerFactory, c1, mDependencies.singleListService, mDependencies.accountService, b1, a(mDependencies.relevantStoreService));
    }

    private Object a(Object obj, List list)
    {
        list.add(obj);
        return obj;
    }

    private com.target.ui.fragment.cardstream.c.c b(com.target.ui.fragment.cardstream.c.b b1)
    {
        com.target.ui.fragment.cardstream.c.c c1 = new com.target.ui.fragment.cardstream.c.c();
        c1.a(a(b1));
        return c1;
    }

    private h c()
    {
        android.support.v4.f.a a1 = new android.support.v4.f.a();
        java.util.ArrayList arraylist = k.a();
        a1.put(e.DEV_TEST_CARD, new com.target.ui.fragment.cardstream.b.f(false));
        Object obj = (m.a)a(e(), arraylist);
        a1.put(e.WELCOME, new com.target.ui.fragment.cardstream.b.m(mDependencies.stringResourceProvider, ((m.a) (obj))));
        Object obj1 = b(mDependencies.cardStreamInvalidator);
        obj = (i)a(a(((com.target.ui.fragment.cardstream.c.c) (obj1))), arraylist);
        j j1 = new j(mDependencies.simpleStorage, ((i) (obj)));
        ((com.target.ui.fragment.cardstream.c.c) (obj1)).a(j1);
        a1.put(e.SHOPPING_LIST_ENGAGEMENT, j1);
        obj1 = new com.target.ui.fragment.cardstream.b.i(((i) (obj)));
        a1.put(e.SHOPPING_LIST, obj1);
        obj1 = a(mDependencies.relevantStoreService);
        obj = new com.target.ui.fragment.cardstream.b.k(((com.target.b.a) (obj1)), ((i) (obj)));
        a1.put(e.SHOW_STORE_MAP_VIEW, obj);
        obj = (l.a)a(f(), arraylist);
        obj = new l(mDependencies.stringResourceProvider, ((l.a) (obj)), ((com.target.b.a) (obj1)));
        a1.put(e.WEEKLY_AD, obj);
        obj = new com.target.ui.fragment.cardstream.b.h(new f(), ((com.target.b.a) (obj1)));
        a1.put(e.REQUEST_A_TEAM_MEMBER, obj);
        obj = new g((com.target.ui.fragment.cardstream.c.f)a(g(), arraylist));
        a1.put(e.MOBILE_COUPONS, obj);
        return h.a(Collections.unmodifiableMap(a1), arraylist);
    }

    private void d()
    {
        e ae[] = com.target.ui.fragment.cardstream.e.values();
        int j1 = ae.length;
        for (int i1 = 0; i1 < j1; i1++)
        {
            e e1 = ae[i1];
            if (a(e1) == null)
            {
                throw new IllegalStateException((new StringBuilder()).append("Card ").append(e1).append(" does not have an assigned manager!").toString());
            }
        }

    }

    private m.a e()
    {
        return new m.a(mDependencies.throttlingTaskRunnerFactory, a(mDependencies.cardStreamInvalidator), mDependencies.relevantStoreService);
    }

    private l.a f()
    {
        return new l.a(mDependencies.throttlingTaskRunnerFactory, a(mDependencies.cardStreamInvalidator), mDependencies.relevantStoreService, new com.target.ui.helper.q.a());
    }

    private com.target.ui.fragment.cardstream.c.f g()
    {
        return new com.target.ui.fragment.cardstream.c.f(mDependencies.throttlingTaskRunnerFactory, a(mDependencies.cardStreamInvalidator), mDependencies.couponsManager, mDependencies.code128BarcodeFactory);
    }

    public com.google.a.a.b a()
    {
        return new com.google.a.a.b() {

            final c this$0;

            public com.google.a.a.e a(e e1)
            {
                return c.this.a(e1).b();
            }

            public volatile Object a(Object obj)
            {
                return a((e)obj);
            }

            
            {
                this$0 = c.this;
                super();
            }
        };
    }

    public com.target.ui.fragment.cardstream.b.b a(e e1)
    {
        return (com.target.ui.fragment.cardstream.b.b)mCardManagers.get(e1);
    }

    public List b()
    {
        return com.google.a.b.h.a(mAllDataSources);
    }
}
