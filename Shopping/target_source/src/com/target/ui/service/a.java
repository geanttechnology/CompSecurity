// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.service;

import com.google.a.a.e;
import com.target.mothership.model.d;
import com.target.mothership.model.guest.b;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.guest.interfaces.a.c;
import com.target.mothership.model.h;
import com.target.mothership.services.x;
import com.target.ui.analytics.a.n;
import com.target.ui.util.q;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class com.target.ui.service.a
{
    private class a extends d
    {

        private d callback;
        final com.target.ui.service.a this$0;

        public String a()
        {
            return callback.a();
        }

        public void a(Guest guest)
        {
            com.target.ui.service.a.a(com.target.ui.service.a.this, guest);
            callback.a(guest);
            com.target.ui.service.a.b(com.target.ui.service.a.this, guest);
        }

        public void a(com.target.mothership.model.guest.interfaces.a.d d1)
        {
            callback.b(d1);
            n.a(d1.d(), d1.f()).e();
        }

        public volatile void a(Object obj)
        {
            a((Guest)obj);
        }

        public void b(Object obj)
        {
            a((com.target.mothership.model.guest.interfaces.a.d)obj);
        }

        public a(d d1)
        {
            this$0 = com.target.ui.service.a.this;
            super();
            callback = d1;
        }
    }

    public static interface b
    {

        public abstract void a(Guest guest);

        public abstract void b();
    }


    private static final String TAG = com/target/ui/service/a.getSimpleName();
    private static volatile Guest sCurrentSession;
    private static com.target.ui.service.a sInstance;
    private final h mAnonymousLoginReceiver = new h() {

        final com.target.ui.service.a this$0;

        public String a()
        {
            return String.valueOf(com.target.ui.service.a.e(com.target.ui.service.a.this).hashCode());
        }

        public void a(Guest guest)
        {
            com.target.ui.service.a.a(com.target.ui.service.a.this, guest);
            for (Iterator iterator = com.target.ui.service.a.c(com.target.ui.service.a.this).b(com.target.ui.service.a.this).iterator(); iterator.hasNext(); ((d)iterator.next()).a(guest)) { }
            com.target.ui.service.a.b(com.target.ui.service.a.this, guest);
        }

        public void a(x x1)
        {
            for (Iterator iterator = com.target.ui.service.a.c(com.target.ui.service.a.this).b(com.target.ui.service.a.this).iterator(); iterator.hasNext(); ((d)iterator.next()).b(x1)) { }
            q.a(com.target.ui.service.a.e(), (new StringBuilder()).append("error while trying to authenticate anonymously:  ").append(x1.getMessage()).toString());
            n.a(x1).e();
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
                this$0 = com.target.ui.service.a.this;
                super();
            }
    };
    private final h mCacheSessionReceiver = new h() {

        final com.target.ui.service.a this$0;

        public String a()
        {
            return com.target.ui.service.a.e();
        }

        public void a(e e1)
        {
            if (e1.b())
            {
                com.target.ui.service.a.a(com.target.ui.service.a.this, (Guest)e1.c());
                for (Iterator iterator = com.target.ui.service.a.c(com.target.ui.service.a.this).b(com.target.ui.service.a.this).iterator(); iterator.hasNext(); ((d)iterator.next()).a(e1.c())) { }
                com.target.ui.service.a.b(com.target.ui.service.a.this, (Guest)e1.c());
                return;
            } else
            {
                com.target.ui.service.a.d(com.target.ui.service.a.this);
                return;
            }
        }

        public void a(x x1)
        {
            q.a(com.target.ui.service.a.e(), (new StringBuilder()).append("error while trying to get the current guest from mothership library.  ").append(x1.getMessage()).toString());
            com.target.ui.service.a.d(com.target.ui.service.a.this);
            n.a(x1).e();
        }

        public volatile void a(Object obj)
        {
            a((e)obj);
        }

        public void b(Object obj)
        {
            a((x)obj);
        }

            
            {
                this$0 = com.target.ui.service.a.this;
                super();
            }
    };
    private final com.target.mothership.model.guest.b mGuestManager = new com.target.mothership.model.guest.b();
    private com.target.ui.util.a.a mRequestLock;
    private final CopyOnWriteArrayList mSessionListeners = new CopyOnWriteArrayList();

    private com.target.ui.service.a()
    {
        mRequestLock = new com.target.ui.util.a.a();
        f();
    }

    public static com.target.ui.service.a a()
    {
        if (sInstance == null)
        {
            sInstance = new com.target.ui.service.a();
        }
        return sInstance;
    }

    private void a(Guest guest)
    {
        sCurrentSession = guest;
    }

    private void a(x x1)
    {
        q.a(TAG, (new StringBuilder()).append("failed to refresh the current session.  ").append(x1.getMessage()).toString());
    }

    static void a(com.target.ui.service.a a1)
    {
        a1.h();
    }

    static void a(com.target.ui.service.a a1, Guest guest)
    {
        a1.a(guest);
    }

    static void a(com.target.ui.service.a a1, x x1)
    {
        a1.a(x1);
    }

    public static void b()
    {
        if (sInstance == null)
        {
            sInstance = new com.target.ui.service.a();
        }
    }

    private void b(Guest guest)
    {
        Iterator iterator = mSessionListeners.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            b b1 = (b)iterator.next();
            if (b1 != null)
            {
                b1.a(guest);
            }
        } while (true);
    }

    private void b(Guest guest, final h callback)
    {
        callback = new h() {

            final com.target.ui.service.a this$0;
            final h val$callback;

            public String a()
            {
                return callback.a();
            }

            public void a(x x1)
            {
                callback.a(x1);
                n.a(x1).e();
            }

            public volatile void a(Object obj)
            {
                a((Void)obj);
            }

            public void a(Void void1)
            {
                com.target.ui.service.a.a(com.target.ui.service.a.this, null);
                callback.a(void1);
                com.target.ui.service.a.a(com.target.ui.service.a.this);
                com.target.ui.service.a.b(com.target.ui.service.a.this);
            }

            public void b(Object obj)
            {
                a((x)obj);
            }

            
            {
                this$0 = com.target.ui.service.a.this;
                callback = h1;
                super();
            }
        };
        mGuestManager.b(guest, callback);
    }

    static void b(com.target.ui.service.a a1)
    {
        a1.f();
    }

    static void b(com.target.ui.service.a a1, Guest guest)
    {
        a1.b(guest);
    }

    static com.target.ui.util.a.a c(com.target.ui.service.a a1)
    {
        return a1.mRequestLock;
    }

    static void d(com.target.ui.service.a a1)
    {
        a1.g();
    }

    static h e(com.target.ui.service.a a1)
    {
        return a1.mAnonymousLoginReceiver;
    }

    static String e()
    {
        return TAG;
    }

    private void f()
    {
        mRequestLock.a(this);
        mGuestManager.a(mCacheSessionReceiver);
    }

    private void g()
    {
        mGuestManager.b(mAnonymousLoginReceiver);
    }

    private void h()
    {
        Iterator iterator = mSessionListeners.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            b b1 = (b)iterator.next();
            if (b1 != null)
            {
                b1.b();
            }
        } while (true);
    }

    public e a(b b1)
    {
        if (b1 == null)
        {
            throw new IllegalArgumentException("listener must not be null");
        } else
        {
            mSessionListeners.add(b1);
            return com.google.a.a.e.c(sCurrentSession);
        }
    }

    public void a(Guest guest, final h callback)
    {
        if (guest == null || callback == null)
        {
            return;
        }
        h h1 = new h() {

            final com.target.ui.service.a this$0;
            final h val$callback;

            public String a()
            {
                return callback.a();
            }

            public void a(Guest guest1)
            {
                com.target.ui.service.a.a(com.target.ui.service.a.this, guest1);
                for (Iterator iterator = com.target.ui.service.a.c(com.target.ui.service.a.this).b(com.target.ui.service.a.this).iterator(); iterator.hasNext(); ((d)iterator.next()).a(guest1)) { }
                com.target.ui.service.a.b(com.target.ui.service.a.this, guest1);
                callback.a(guest1);
            }

            public void a(x x1)
            {
                com.target.ui.service.a.a(com.target.ui.service.a.this, x1);
                for (Iterator iterator = com.target.ui.service.a.c(com.target.ui.service.a.this).b(com.target.ui.service.a.this).iterator(); iterator.hasNext(); ((d)iterator.next()).b(x1)) { }
                callback.a(x1);
                n.a(x1).e();
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
                this$0 = com.target.ui.service.a.this;
                callback = h1;
                super();
            }
        };
        if (mRequestLock.a())
        {
            mRequestLock.a(callback);
            return;
        } else
        {
            mRequestLock.a(this);
            mGuestManager.a(guest, h1);
            return;
        }
    }

    public void a(final h callback)
    {
        if (sCurrentSession != null)
        {
            callback.a(sCurrentSession);
            return;
        }
        h h1 = new h() {

            final com.target.ui.service.a this$0;
            final h val$callback;

            public String a()
            {
                return callback.a();
            }

            public void a(Guest guest)
            {
                com.target.ui.service.a.a(com.target.ui.service.a.this, guest);
                callback.a(guest);
                com.target.ui.service.a.b(com.target.ui.service.a.this, guest);
            }

            public void a(x x1)
            {
                callback.a(x1);
                n.a(x1).e();
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
                this$0 = com.target.ui.service.a.this;
                callback = h1;
                super();
            }
        };
        if (mRequestLock.a())
        {
            mRequestLock.a(callback);
            return;
        } else
        {
            mGuestManager.b(h1);
            return;
        }
    }

    public void a(String s)
    {
        if (mRequestLock.a())
        {
            mRequestLock.a(s);
        }
        mGuestManager.a(s);
    }

    public void a(String s, h h1)
    {
        mGuestManager.a(s, h1);
    }

    public void a(final String accountName, String s, final d callback)
    {
        callback = new d() {

            final com.target.ui.service.a this$0;
            final String val$accountName;
            final d val$callback;

            public String a()
            {
                return callback.a();
            }

            public void a(Guest guest)
            {
                com.target.ui.service.a.a(com.target.ui.service.a.this, guest);
                com.target.ui.d.a.c().d();
                com.target.ui.d.a.c().c(accountName);
                callback.a(guest);
                com.target.ui.service.a.b(com.target.ui.service.a.this, guest);
            }

            public void a(c c1)
            {
                callback.b(c1);
                n.a(c1.d()).e();
            }

            public volatile void a(Object obj)
            {
                a((Guest)obj);
            }

            public void b(Object obj)
            {
                a((c)obj);
            }

            
            {
                this$0 = com.target.ui.service.a.this;
                accountName = s;
                callback = d1;
                super();
            }
        };
        mGuestManager.a(accountName, s, callback);
    }

    public void a(String s, String s1, String s2, String s3, boolean flag, d d1)
    {
        d1 = new a(d1);
        mGuestManager.a(s, "", s1, s2, s3, s3, flag, d1);
    }

    public void b(h h1)
    {
        if (sCurrentSession == null)
        {
            h1.a(null);
            h();
            return;
        } else
        {
            b(sCurrentSession, h1);
            return;
        }
    }

    public void b(b b1)
    {
        mSessionListeners.remove(b1);
    }

    public e c()
    {
        if (sCurrentSession == null)
        {
            com.target.ui.analytics.b.b.b().a();
            return com.google.a.a.e.e();
        } else
        {
            return com.google.a.a.e.b(sCurrentSession);
        }
    }

    public void d()
    {
        while (sCurrentSession == null || mRequestLock.a() || !com.target.ui.util.b.a(sCurrentSession)) 
        {
            return;
        }
        a(sCurrentSession, new h() {

            final com.target.ui.service.a this$0;

            public String a()
            {
                return com.target.ui.service.a.e();
            }

            public void a(Guest guest)
            {
            }

            public void a(x x1)
            {
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
                this$0 = com.target.ui.service.a.this;
                super();
            }
        });
    }

}
