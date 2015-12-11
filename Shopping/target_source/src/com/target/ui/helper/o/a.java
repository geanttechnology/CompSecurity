// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.helper.o;

import com.target.mothership.model.d;
import com.target.mothership.model.list.interfaces.ListMostRecent;
import com.target.mothership.model.list.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class com.target.ui.helper.o.a
{
    public static interface a
    {

        public abstract void a(String s);

        public abstract void b(String s);
    }

    public static interface b
    {

        public abstract void a();

        public abstract void a(List list);
    }

    public static interface c
    {

        public abstract void a(List list);

        public abstract void d();
    }


    private j mListMostRecentManager;
    private String mRequestTag;

    public com.target.ui.helper.o.a()
    {
        this(new j());
    }

    public com.target.ui.helper.o.a(j j1)
    {
        mListMostRecentManager = j1;
        mRequestTag = String.valueOf(hashCode());
    }

    static String a(com.target.ui.helper.o.a a1)
    {
        return a1.mRequestTag;
    }

    public void a()
    {
        mListMostRecentManager.a(mRequestTag);
    }

    public void a(int i, final c listener)
    {
        mListMostRecentManager.a(i, new d() {

            final com.target.ui.helper.o.a this$0;
            final c val$listener;

            public String a()
            {
                return com.target.ui.helper.o.a.a(com.target.ui.helper.o.a.this);
            }

            public void a(com.target.mothership.model.list.interfaces.a.a a1)
            {
                listener.d();
            }

            public volatile void a(Object obj)
            {
                a((List)obj);
            }

            public void a(List list)
            {
                ArrayList arraylist = new ArrayList();
                for (list = list.iterator(); list.hasNext(); arraylist.add(((ListMostRecent)list.next()).b())) { }
                listener.a(arraylist);
            }

            public void b(Object obj)
            {
                a((com.target.mothership.model.list.interfaces.a.a)obj);
            }

            
            {
                this$0 = com.target.ui.helper.o.a.this;
                listener = c1;
                super();
            }
        });
    }

    public void a(final b listener)
    {
        mListMostRecentManager.a(new d() {

            final com.target.ui.helper.o.a this$0;
            final b val$listener;

            public String a()
            {
                return com.target.ui.helper.o.a.a(com.target.ui.helper.o.a.this);
            }

            public void a(com.target.mothership.model.list.interfaces.a.a a1)
            {
                if (listener == null)
                {
                    return;
                } else
                {
                    listener.a();
                    return;
                }
            }

            public volatile void a(Object obj)
            {
                a((List)obj);
            }

            public void a(List list)
            {
                if (listener == null)
                {
                    return;
                }
                ArrayList arraylist = new ArrayList();
                for (list = list.iterator(); list.hasNext(); arraylist.add(((ListMostRecent)list.next()).b())) { }
                listener.a(arraylist);
            }

            public void b(Object obj)
            {
                a((com.target.mothership.model.list.interfaces.a.a)obj);
            }

            
            {
                this$0 = com.target.ui.helper.o.a.this;
                listener = b1;
                super();
            }
        });
    }

    public void a(c c1)
    {
        a(-1, c1);
    }

    public void a(String s)
    {
        a(s, ((a) (null)));
    }

    public void a(final String searchTerm, final a listener)
    {
        mListMostRecentManager.a(searchTerm, new d() {

            final com.target.ui.helper.o.a this$0;
            final a val$listener;
            final String val$searchTerm;

            public String a()
            {
                return com.target.ui.helper.o.a.a(com.target.ui.helper.o.a.this);
            }

            public void a(com.target.mothership.model.list.interfaces.a.a a1)
            {
                if (listener == null)
                {
                    return;
                } else
                {
                    listener.b(searchTerm);
                    return;
                }
            }

            public volatile void a(Object obj)
            {
                a((Void)obj);
            }

            public void a(Void void1)
            {
                if (listener == null)
                {
                    return;
                } else
                {
                    listener.a(searchTerm);
                    return;
                }
            }

            public void b(Object obj)
            {
                a((com.target.mothership.model.list.interfaces.a.a)obj);
            }

            
            {
                this$0 = com.target.ui.helper.o.a.this;
                listener = a2;
                searchTerm = s;
                super();
            }
        });
    }

    public void b()
    {
        a(((b) (null)));
    }
}
