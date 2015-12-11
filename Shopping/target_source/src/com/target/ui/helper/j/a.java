// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.helper.j;

import com.google.a.a.e;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.list.c;
import com.target.mothership.model.list.g;
import com.target.mothership.model.list.interfaces.ListDetail;
import com.target.mothership.model.list.interfaces.ListSummary;
import com.target.ui.model.list.ListCollectionItem;
import java.util.List;

public class com.target.ui.helper.j.a
{
    public static interface a
    {

        public abstract void a(com.target.mothership.model.list.interfaces.a.a a1);
    }

    public static interface b
        extends a
    {

        public abstract void a(ListSummary listsummary);
    }

    public static interface c
        extends a
    {

        public abstract void a(ListCollectionItem listcollectionitem);
    }

    public static interface d
        extends a
    {

        public abstract void a(List list);
    }

    public static interface e
        extends a
    {

        public abstract void a(List list);
    }

    public static interface f
        extends a
    {

        public abstract void c();
    }

    public static interface g
        extends a
    {

        public abstract void b(ListSummary listsummary);
    }


    private Guest mGuest;
    private com.target.mothership.model.list.c mListCollectionManager;
    private final String mRequestTag = String.valueOf(hashCode());

    public com.target.ui.helper.j.a()
    {
        mGuest = (Guest)com.target.ui.service.a.a().c().d();
        mListCollectionManager = new com.target.mothership.model.list.c(mGuest);
    }

    static String a(com.target.ui.helper.j.a a1)
    {
        return a1.mRequestTag;
    }

    public void a()
    {
        mListCollectionManager.a(mRequestTag);
    }

    public void a(ListSummary listsummary, String s, final g listener)
    {
        (new com.target.mothership.model.list.g(listsummary, mGuest)).a(s, new com.target.mothership.model.d() {

            final com.target.ui.helper.j.a this$0;
            final g val$listener;

            public String a()
            {
                return com.target.ui.helper.j.a.a(com.target.ui.helper.j.a.this);
            }

            public void a(ListDetail listdetail)
            {
                listener.b(listdetail);
            }

            public void a(com.target.mothership.model.list.interfaces.a.a a1)
            {
                listener.a(a1);
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
                this$0 = com.target.ui.helper.j.a.this;
                listener = g1;
                super();
            }
        });
    }

    public void a(final d listener)
    {
        mListCollectionManager.b(new com.target.mothership.model.d() {

            final com.target.ui.helper.j.a this$0;
            final d val$listener;

            public String a()
            {
                return com.target.ui.helper.j.a.a(com.target.ui.helper.j.a.this);
            }

            public void a(com.target.mothership.model.list.interfaces.a.a a1)
            {
                listener.a(a1);
            }

            public volatile void a(Object obj)
            {
                a((List)obj);
            }

            public void a(List list)
            {
                listener.a(list);
            }

            public void b(Object obj)
            {
                a((com.target.mothership.model.list.interfaces.a.a)obj);
            }

            
            {
                this$0 = com.target.ui.helper.j.a.this;
                listener = d1;
                super();
            }
        });
    }

    public void a(final e listener)
    {
        mListCollectionManager.a(new com.target.mothership.model.d() {

            final com.target.ui.helper.j.a this$0;
            final e val$listener;

            public String a()
            {
                return com.target.ui.helper.j.a.a(com.target.ui.helper.j.a.this);
            }

            public void a(com.target.mothership.model.list.interfaces.a.a a1)
            {
                listener.a(a1);
            }

            public volatile void a(Object obj)
            {
                a((List)obj);
            }

            public void a(List list)
            {
                listener.a(list);
            }

            public void b(Object obj)
            {
                a((com.target.mothership.model.list.interfaces.a.a)obj);
            }

            
            {
                this$0 = com.target.ui.helper.j.a.this;
                listener = e1;
                super();
            }
        });
    }

    public void a(ListCollectionItem listcollectionitem, int i, final f listener)
    {
        if (mListCollectionManager == null)
        {
            return;
        } else
        {
            mListCollectionManager.a(listcollectionitem.d(), i, new com.target.mothership.model.d() {

                final com.target.ui.helper.j.a this$0;
                final f val$listener;

                public String a()
                {
                    return com.target.ui.helper.j.a.a(com.target.ui.helper.j.a.this);
                }

                public void a(com.target.mothership.model.list.interfaces.a.a a1)
                {
                    listener.a(a1);
                }

                public volatile void a(Object obj)
                {
                    a((List)obj);
                }

                public void a(List list)
                {
                    listener.c();
                }

                public void b(Object obj)
                {
                    a((com.target.mothership.model.list.interfaces.a.a)obj);
                }

            
            {
                this$0 = com.target.ui.helper.j.a.this;
                listener = f1;
                super();
            }
            });
            return;
        }
    }

    public void a(final ListCollectionItem list, final c listener)
    {
        (new com.target.mothership.model.list.g(list.d(), mGuest)).b(new com.target.mothership.model.d() {

            final com.target.ui.helper.j.a this$0;
            final ListCollectionItem val$list;
            final c val$listener;

            public String a()
            {
                return com.target.ui.helper.j.a.a(com.target.ui.helper.j.a.this);
            }

            public void a(com.target.mothership.model.list.interfaces.a.a a1)
            {
                listener.a(a1);
            }

            public volatile void a(Object obj)
            {
                a((String)obj);
            }

            public void a(String s)
            {
                listener.a(list);
            }

            public void b(Object obj)
            {
                a((com.target.mothership.model.list.interfaces.a.a)obj);
            }

            
            {
                this$0 = com.target.ui.helper.j.a.this;
                listener = c1;
                list = listcollectionitem;
                super();
            }
        });
    }

    public void a(String s, String s1, String s2, String s3, final b listener)
    {
        mListCollectionManager.a(s, s1, s2, s3, new com.target.mothership.model.d() {

            final com.target.ui.helper.j.a this$0;
            final b val$listener;

            public String a()
            {
                return com.target.ui.helper.j.a.a(com.target.ui.helper.j.a.this);
            }

            public void a(ListDetail listdetail)
            {
                listener.a(listdetail);
            }

            public void a(com.target.mothership.model.list.interfaces.a.a a1)
            {
                listener.a(a1);
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
                this$0 = com.target.ui.helper.j.a.this;
                listener = b1;
                super();
            }
        });
    }
}
