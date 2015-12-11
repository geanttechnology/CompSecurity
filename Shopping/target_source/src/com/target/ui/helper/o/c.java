// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.helper.o;

import com.target.mothership.model.d;
import com.target.mothership.model.list.interfaces.ListMostRecent;
import com.target.mothership.model.list.j;
import com.target.ui.util.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class c
{
    public static interface a
    {

        public abstract void a();

        public abstract void b();
    }

    public static interface b
    {

        public abstract void a();

        public abstract void a(List list);
    }


    private static final String TAG = com/target/ui/helper/o/c.getSimpleName();
    private j mListMostRecentManager;

    public c()
    {
        mListMostRecentManager = new j();
    }

    static String a()
    {
        return TAG;
    }

    public void a(int i, final b listener)
    {
        if (listener == null)
        {
            return;
        } else
        {
            mListMostRecentManager.a(i, new d() {

                final c this$0;
                final b val$listener;

                public void a(com.target.mothership.model.list.interfaces.a.a a1)
                {
                    listener.a();
                    q.a(c.a(), "Unable to load the recent history");
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
                this$0 = c.this;
                listener = b1;
                super();
            }
            });
            return;
        }
    }

    public void a(final a listener)
    {
        if (listener == null)
        {
            return;
        } else
        {
            mListMostRecentManager.a(new d() {

                final c this$0;
                final a val$listener;

                public void a(com.target.mothership.model.list.interfaces.a.a a1)
                {
                    listener.b();
                    q.a(c.a(), "Unable to clear all search history");
                }

                public volatile void a(Object obj)
                {
                    a((List)obj);
                }

                public void a(List list)
                {
                    listener.a();
                }

                public void b(Object obj)
                {
                    a((com.target.mothership.model.list.interfaces.a.a)obj);
                }

            
            {
                this$0 = c.this;
                listener = a1;
                super();
            }
            });
            return;
        }
    }

    public void a(String s)
    {
        mListMostRecentManager.a(s, new d() {

            final c this$0;

            public void a(com.target.mothership.model.list.interfaces.a.a a1)
            {
                q.a(c.a(), "Unable to add to search history");
            }

            public volatile void a(Object obj)
            {
                a((Void)obj);
            }

            public void a(Void void1)
            {
            }

            public void b(Object obj)
            {
                a((com.target.mothership.model.list.interfaces.a.a)obj);
            }

            
            {
                this$0 = c.this;
                super();
            }
        });
    }

}
