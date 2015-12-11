// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.list;

import com.target.mothership.cache.e;
import com.target.mothership.cache.list.b;
import com.target.mothership.model.a;
import com.target.mothership.model.d;
import java.sql.SQLException;
import java.util.concurrent.Callable;

// Referenced classes of package com.target.mothership.model.list:
//            i, l, CacheListMostRecent

public class j extends a
{

    public static final int NO_LIMIT = -1;
    private i mMostRecentAccessor;

    public j()
    {
        mMostRecentAccessor = new i();
    }

    static i a(j j1)
    {
        return j1.mMostRecentAccessor;
    }

    public void a(final int limit, final d handler)
    {
        if (handler == null)
        {
            handler = null;
        } else
        {
            handler = new b(com.target.mothership.model.list.l.a(handler));
        }
        e.getInstance().add(new Callable() {

            final j this$0;
            final b val$handler;
            final int val$limit;

            public Void a()
                throws Exception
            {
                java.util.List list = com.target.mothership.model.list.j.a(j.this).a(limit, new com.target.mothership.model.list.interfaces.ListMostRecent.a[] {
                    com.target.mothership.model.list.interfaces.ListMostRecent.a.SEARCH
                });
                if (handler != null)
                {
                    handler.onResponse(list);
                }
_L2:
                return null;
                SQLException sqlexception;
                sqlexception;
                if (handler != null)
                {
                    com.target.mothership.model.list.interfaces.a.a a1 = new com.target.mothership.model.list.interfaces.a.a(sqlexception);
                    handler.onError(a1);
                }
                if (true) goto _L2; else goto _L1
_L1:
            }

            public Object call()
                throws Exception
            {
                return a();
            }

            
            {
                this$0 = j.this;
                limit = k;
                handler = b1;
                super();
            }
        });
    }

    public void a(final d handler)
    {
        if (handler == null)
        {
            handler = null;
        } else
        {
            handler = new b(com.target.mothership.model.list.l.a(handler));
        }
        e.getInstance().add(new Callable() {

            final j this$0;
            final b val$handler;

            public Void a()
                throws Exception
            {
                java.util.List list = com.target.mothership.model.list.j.a(j.this).a(new com.target.mothership.model.list.interfaces.ListMostRecent.a[] {
                    com.target.mothership.model.list.interfaces.ListMostRecent.a.SEARCH
                });
                if (handler != null)
                {
                    handler.onResponse(list);
                }
_L2:
                return null;
                SQLException sqlexception;
                sqlexception;
                if (handler != null)
                {
                    com.target.mothership.model.list.interfaces.a.a a1 = new com.target.mothership.model.list.interfaces.a.a(sqlexception);
                    handler.onError(a1);
                }
                if (true) goto _L2; else goto _L1
_L1:
            }

            public Object call()
                throws Exception
            {
                return a();
            }

            
            {
                this$0 = j.this;
                handler = b1;
                super();
            }
        });
    }

    public void a(final String search, final d handler)
    {
        if (handler == null)
        {
            handler = null;
        } else
        {
            handler = new b(com.target.mothership.model.list.l.a(handler));
        }
        e.getInstance().add(new Callable() {

            final j this$0;
            final b val$handler;
            final String val$search;

            public Void a()
                throws Exception
            {
                try
                {
                    CacheListMostRecent cachelistmostrecent = new CacheListMostRecent(search, com.target.mothership.model.list.interfaces.ListMostRecent.a.SEARCH);
                    com.target.mothership.model.list.j.a(j.this).b(cachelistmostrecent);
                    if (handler != null)
                    {
                        handler.onResponse(null);
                    }
                }
                catch (SQLException sqlexception)
                {
                    com.target.mothership.model.list.interfaces.a.a a1 = new com.target.mothership.model.list.interfaces.a.a(sqlexception);
                    if (handler != null)
                    {
                        handler.onError(a1);
                        return null;
                    }
                }
                return null;
            }

            public Object call()
                throws Exception
            {
                return a();
            }

            
            {
                this$0 = j.this;
                search = s;
                handler = b1;
                super();
            }
        });
    }
}
