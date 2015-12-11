// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.service;

import android.content.Context;
import com.google.a.a.e;
import com.target.mothership.model.d;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.h;
import com.target.mothership.model.list.c;
import com.target.mothership.model.list.interfaces.ListDetail;
import com.target.mothership.services.x;
import com.target.ui.model.list.ListCollectionItem;
import com.target.ui.util.q;
import java.lang.ref.WeakReference;

// Referenced classes of package com.target.ui.service:
//            a

public class m
{
    public static interface a
    {

        public abstract void a(ListDetail listdetail);

        public abstract void a(com.target.mothership.model.list.interfaces.a.a a1);
    }


    private static String TAG = com/target/ui/service/m.getSimpleName();
    private static m sInstance;
    private WeakReference mContextReference;
    private ListCollectionItem mListCollectionItem;

    private m(Context context)
    {
        mContextReference = new WeakReference(context);
        e();
        d();
        a(((Guest) (null)));
    }

    static ListCollectionItem a(m m1, ListCollectionItem listcollectionitem)
    {
        m1.mListCollectionItem = listcollectionitem;
        return listcollectionitem;
    }

    public static m a()
    {
        if (sInstance == null)
        {
            throw new IllegalStateException("No instance of SingleListHelper found.  Have you called SingleListHelper.initialize()?");
        } else
        {
            return sInstance;
        }
    }

    static WeakReference a(m m1)
    {
        return m1.mContextReference;
    }

    public static void a(Context context)
    {
        sInstance = new m(context);
    }

    private void a(Guest guest)
    {
        (new c(guest)).c(new d() {

            final m this$0;

            public void a(ListDetail listdetail)
            {
                if (m.a(m.this) == null || m.a(m.this).get() == null)
                {
                    return;
                } else
                {
                    m.a(m.this, new ListCollectionItem(listdetail, (Context)m.a(m.this).get()));
                    return;
                }
            }

            public void a(com.target.mothership.model.list.interfaces.a.a a1)
            {
                q.a(com.target.ui.service.m.c(), (new StringBuilder()).append("Error getting default list: ").append(a1.g()).toString());
            }

            public volatile void a(Object obj)
            {
                a((ListDetail)obj);
            }

            public void b(Object obj)
            {
                a((com.target.mothership.model.list.interfaces.a.a)obj);
            }

            
            {
                this$0 = m.this;
                super();
            }
        });
    }

    static void a(m m1, Guest guest)
    {
        m1.a(guest);
    }

    static String c()
    {
        return TAG;
    }

    private void d()
    {
        h h = new h() {

            final m this$0;

            public String a()
            {
                return com.target.ui.service.m.c();
            }

            public void a(Guest guest)
            {
                m.a(m.this, guest);
            }

            public void a(x x1)
            {
                q.a(com.target.ui.service.m.c(), x1.getMessage());
            }

            public volatile void a(Object obj)
            {
                a((Guest)obj);
            }

            public void b(Object obj)
            {
                a((x)obj);
            }

            
            {
                this$0 = m.this;
                super();
            }
        };
        com.target.ui.service.a.a().a(h);
    }

    private void e()
    {
        com.target.ui.service.a.a().a(new a.b() {

            final m this$0;

            public void a(Guest guest)
            {
                m.a(m.this, (Guest)com.target.ui.service.a.a().c().d());
            }

            public void b()
            {
                m.a(m.this, null);
            }

            
            {
                this$0 = m.this;
                super();
            }
        });
    }

    public void a(final a callback)
    {
        callback = new d() {

            final m this$0;
            final a val$callback;

            public void a(ListDetail listdetail)
            {
                callback.a(listdetail);
            }

            public void a(com.target.mothership.model.list.interfaces.a.a a1)
            {
                callback.a(a1);
            }

            public volatile void a(Object obj)
            {
                a((ListDetail)obj);
            }

            public void b(Object obj)
            {
                a((com.target.mothership.model.list.interfaces.a.a)obj);
            }

            
            {
                this$0 = m.this;
                callback = a1;
                super();
            }
        };
        com.target.ui.service.a.a().a(new h() {

            final m this$0;
            final d val$receiver;

            public String a()
            {
                return com.target.ui.service.m.c();
            }

            public void a(Guest guest)
            {
                (new c(guest)).c(receiver);
            }

            public void a(x x1)
            {
                q.a(com.target.ui.service.m.c(), (new StringBuilder()).append("Error getting guest needed to retrieve default list: ").append(x1.getMessage()).append(", defaulting to new local guest").toString());
                (new c(null)).c(receiver);
            }

            public volatile void a(Object obj)
            {
                a((Guest)obj);
            }

            public void b(Object obj)
            {
                a((x)obj);
            }

            
            {
                this$0 = m.this;
                receiver = d1;
                super();
            }
        });
    }

    public e b()
    {
        return com.google.a.a.e.c(mListCollectionItem);
    }

}
