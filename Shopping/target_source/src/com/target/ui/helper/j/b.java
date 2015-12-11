// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.helper.j;

import com.google.a.a.e;
import com.pointinside.products.BaseProduct;
import com.target.mothership.common.product.Tcin;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.list.g;
import com.target.mothership.model.list.interfaces.ListDetail;
import com.target.mothership.model.list.interfaces.ListItem;
import com.target.mothership.model.list.interfaces.ListSummary;
import com.target.mothership.model.list.interfaces.a.a;
import com.target.mothership.model.list.j;
import com.target.mothership.model.product.handler.TGTProduct;
import com.target.mothership.model.product.interfaces.Product;
import com.target.mothership.model.store.interfaces.Store;
import com.target.mothership.util.o;
import com.target.ui.model.LookupResultParcelable;
import com.target.ui.model.list.ListDetailCompletedItem;
import com.target.ui.model.list.ListDetailItem;
import com.target.ui.util.aa;
import com.target.ui.util.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class com.target.ui.helper.j.b
{
    public static interface a
    {

        public abstract void b(List list);

        public abstract void c(String s);
    }

    private static class b extends com.target.mothership.model.d
    {

        private final k mListener;
        private final String mRequestTag;

        public String a()
        {
            return mRequestTag;
        }

        public void a(com.target.mothership.model.list.interfaces.a.a a1)
        {
            if (com.target.ui.helper.j.b.a(a1))
            {
                mListener.a(n.MAX_LIST_ITEM_COUNT_ERROR, a1.g());
                return;
            } else
            {
                mListener.a(n.RESTORE_ITEM_ERROR, a1.g());
                return;
            }
        }

        public volatile void a(Object obj)
        {
            a((List)obj);
        }

        public void a(List list)
        {
            if (list != null && list.size() > 0)
            {
                list = (ListItem)list.get(0);
            } else
            {
                list = null;
            }
            if (list != null)
            {
                mListener.a(list);
                return;
            } else
            {
                mListener.a(n.RESTORE_ITEM_ERROR, "Unknown Error");
                return;
            }
        }

        public void b(Object obj)
        {
            a((com.target.mothership.model.list.interfaces.a.a)obj);
        }

        public b(k k1, String s)
        {
            mListener = k1;
            mRequestTag = s;
        }
    }

    public static interface c
        extends e
    {

        public abstract void a(List list, ListSummary listsummary);
    }

    public static interface d
        extends e
    {

        public abstract void a(ListItem listitem, int i1, ListSummary listsummary);

        public abstract void a(ListItem listitem, ListSummary listsummary);
    }

    public static interface e
    {

        public abstract void a(n n1, String s);
    }

    public static interface f
        extends e
    {

        public abstract void b(ListSummary listsummary);
    }

    public static interface g
        extends e
    {

        public abstract void a(ListSummary listsummary);
    }

    public static interface h
        extends e
    {

        public abstract void a(ListItem listitem, ListSummary listsummary);
    }

    public static interface i
        extends e
    {

        public abstract void a(List list);
    }

    public static interface j
        extends e
    {

        public abstract void a(List list, ListSummary listsummary);
    }

    public static interface k
        extends e
    {

        public abstract void a(ListItem listitem);
    }

    public static interface l
        extends e
    {

        public abstract void a(List list, ListSummary listsummary);
    }

    public static interface m
    {

        public abstract void a(Exception exception);

        public abstract void a(Map map);
    }

    public static final class n extends Enum
    {

        private static final n $VALUES[];
        public static final n ADD_ITEM_ERROR;
        public static final n ADD_RECENT_ERROR;
        public static final n CLEAR_COMPLETED_ERROR;
        public static final n CLEAR_LIST_ERROR;
        public static final n DELETE_ITEM_ERROR;
        public static final n EDIT_ITEM_ERROR;
        public static final n GET_ITEMS_ERROR;
        public static final n MARK_COMPLETE_ERROR;
        public static final n MAX_LIST_ITEM_COUNT_ERROR;
        public static final n REORDER_ERROR;
        public static final n RESTORE_COMPLETED_ITEM_ERROR;
        public static final n RESTORE_ITEM_ERROR;
        public static final n SET_FULFILLED_ERROR;
        public static final n SET_QUANTITY_ERROR;

        public static n valueOf(String s)
        {
            return (n)Enum.valueOf(com/target/ui/helper/j/b$n, s);
        }

        public static n[] values()
        {
            return (n[])$VALUES.clone();
        }

        static 
        {
            ADD_ITEM_ERROR = new n("ADD_ITEM_ERROR", 0);
            ADD_RECENT_ERROR = new n("ADD_RECENT_ERROR", 1);
            DELETE_ITEM_ERROR = new n("DELETE_ITEM_ERROR", 2);
            GET_ITEMS_ERROR = new n("GET_ITEMS_ERROR", 3);
            SET_FULFILLED_ERROR = new n("SET_FULFILLED_ERROR", 4);
            CLEAR_LIST_ERROR = new n("CLEAR_LIST_ERROR", 5);
            SET_QUANTITY_ERROR = new n("SET_QUANTITY_ERROR", 6);
            EDIT_ITEM_ERROR = new n("EDIT_ITEM_ERROR", 7);
            REORDER_ERROR = new n("REORDER_ERROR", 8);
            MAX_LIST_ITEM_COUNT_ERROR = new n("MAX_LIST_ITEM_COUNT_ERROR", 9);
            RESTORE_ITEM_ERROR = new n("RESTORE_ITEM_ERROR", 10);
            MARK_COMPLETE_ERROR = new n("MARK_COMPLETE_ERROR", 11);
            RESTORE_COMPLETED_ITEM_ERROR = new n("RESTORE_COMPLETED_ITEM_ERROR", 12);
            CLEAR_COMPLETED_ERROR = new n("CLEAR_COMPLETED_ERROR", 13);
            $VALUES = (new n[] {
                ADD_ITEM_ERROR, ADD_RECENT_ERROR, DELETE_ITEM_ERROR, GET_ITEMS_ERROR, SET_FULFILLED_ERROR, CLEAR_LIST_ERROR, SET_QUANTITY_ERROR, EDIT_ITEM_ERROR, REORDER_ERROR, MAX_LIST_ITEM_COUNT_ERROR, 
                RESTORE_ITEM_ERROR, MARK_COMPLETE_ERROR, RESTORE_COMPLETED_ITEM_ERROR, CLEAR_COMPLETED_ERROR
            });
        }

        private n(String s, int i1)
        {
            super(s, i1);
        }
    }


    private com.target.mothership.model.list.g mListManager;
    private com.target.mothership.model.list.j mListMostRecentManager;
    private ListSummary mListSummary;
    private final String mRequestTag;

    public com.target.ui.helper.j.b()
    {
        this(null);
    }

    public com.target.ui.helper.j.b(ListSummary listsummary)
    {
        mRequestTag = String.valueOf(hashCode());
        if (listsummary != null)
        {
            a(listsummary);
        }
    }

    static ListSummary a(com.target.ui.helper.j.b b1)
    {
        return b1.mListSummary;
    }

    static boolean a(com.target.mothership.model.list.interfaces.a.a a1)
    {
        return b(a1);
    }

    static String b(com.target.ui.helper.j.b b1)
    {
        return b1.mRequestTag;
    }

    private static boolean b(com.target.mothership.model.list.interfaces.a.a a1)
    {
        for (a1 = a1.f().iterator(); a1.hasNext();)
        {
            if ((com.target.mothership.model.list.interfaces.a.a.a)a1.next() == com.target.mothership.model.list.interfaces.a.a.a.ERROR_LIST_MAX_ITEM_COUNT_EXCEEDED)
            {
                return true;
            }
        }

        return false;
    }

    public void a()
    {
        if (mListManager != null)
        {
            mListManager.a(mRequestTag);
        }
    }

    public void a(ListItem listitem, int i1, final e listener)
    {
        mListManager.a(listitem, i1, new com.target.mothership.model.d() {

            final com.target.ui.helper.j.b this$0;
            final e val$listener;

            public String a()
            {
                return com.target.ui.helper.j.b.b(com.target.ui.helper.j.b.this);
            }

            public void a(ListItem listitem1)
            {
            }

            public void a(com.target.mothership.model.list.interfaces.a.a a1)
            {
                listener.a(n.SET_QUANTITY_ERROR, a1.g());
            }

            public volatile void a(Object obj)
            {
                a((ListItem)obj);
            }

            public void b(Object obj)
            {
                a((com.target.mothership.model.list.interfaces.a.a)obj);
            }

            
            {
                this$0 = com.target.ui.helper.j.b.this;
                listener = e1;
                super();
            }
        });
    }

    public void a(final ListItem listItem, final h listener)
    {
        mListManager.a(listItem, new com.target.mothership.model.d() {

            final com.target.ui.helper.j.b this$0;
            final ListItem val$listItem;
            final h val$listener;

            public String a()
            {
                return com.target.ui.helper.j.b.b(com.target.ui.helper.j.b.this);
            }

            public void a(ListItem listitem)
            {
                listener.a(listItem, com.target.ui.helper.j.b.a(com.target.ui.helper.j.b.this));
            }

            public void a(com.target.mothership.model.list.interfaces.a.a a1)
            {
                listener.a(n.DELETE_ITEM_ERROR, a1.g());
            }

            public volatile void a(Object obj)
            {
                a((ListItem)obj);
            }

            public void b(Object obj)
            {
                a((com.target.mothership.model.list.interfaces.a.a)obj);
            }

            
            {
                this$0 = com.target.ui.helper.j.b.this;
                listener = h1;
                listItem = listitem;
                super();
            }
        });
    }

    public void a(ListItem listitem, String s, final e listener)
    {
        mListManager.a(listitem, s, new com.target.mothership.model.d() {

            final com.target.ui.helper.j.b this$0;
            final e val$listener;

            public String a()
            {
                return com.target.ui.helper.j.b.b(com.target.ui.helper.j.b.this);
            }

            public void a(ListItem listitem1)
            {
            }

            public void a(com.target.mothership.model.list.interfaces.a.a a1)
            {
                listener.a(n.EDIT_ITEM_ERROR, a1.g());
            }

            public volatile void a(Object obj)
            {
                a((ListItem)obj);
            }

            public void b(Object obj)
            {
                a((com.target.mothership.model.list.interfaces.a.a)obj);
            }

            
            {
                this$0 = com.target.ui.helper.j.b.this;
                listener = e1;
                super();
            }
        });
    }

    public void a(ListSummary listsummary)
    {
        mListSummary = listsummary;
        mListManager = new com.target.mothership.model.list.g(listsummary, (Guest)com.target.ui.service.a.a().c().d());
        mListMostRecentManager = new com.target.mothership.model.list.j();
    }

    public void a(Product product, final d listener)
    {
        if (product.k_() == null)
        {
            mListManager.a(product.g(), Integer.valueOf(1), new com.target.mothership.model.d() {

                final com.target.ui.helper.j.b this$0;
                final d val$listener;

                public String a()
                {
                    return com.target.ui.helper.j.b.b(com.target.ui.helper.j.b.this);
                }

                public void a(com.target.mothership.model.list.interfaces.a.a a1)
                {
                    listener.a(n.ADD_ITEM_ERROR, a1.g());
                }

                public volatile void a(Object obj)
                {
                    a((List)obj);
                }

                public void a(List list)
                {
                    if (list != null && list.size() > 0)
                    {
                        list = (ListItem)list.get(0);
                    } else
                    {
                        list = null;
                    }
                    if (list != null)
                    {
                        listener.a(list, com.target.ui.helper.j.b.a(com.target.ui.helper.j.b.this));
                        return;
                    } else
                    {
                        listener.a(n.ADD_ITEM_ERROR, "");
                        return;
                    }
                }

                public void b(Object obj)
                {
                    a((com.target.mothership.model.list.interfaces.a.a)obj);
                }

            
            {
                this$0 = com.target.ui.helper.j.b.this;
                listener = d1;
                super();
            }
            });
            return;
        } else
        {
            mListManager.a(product, Integer.valueOf(1), new com.target.mothership.model.d() {

                final com.target.ui.helper.j.b this$0;
                final d val$listener;

                public String a()
                {
                    return com.target.ui.helper.j.b.b(com.target.ui.helper.j.b.this);
                }

                public void a(com.target.mothership.model.list.interfaces.a.a a1)
                {
                    listener.a(n.ADD_ITEM_ERROR, a1.g());
                }

                public volatile void a(Object obj)
                {
                    a((List)obj);
                }

                public void a(List list)
                {
                    if (list != null && list.size() > 0)
                    {
                        list = (ListItem)list.get(0);
                    } else
                    {
                        list = null;
                    }
                    if (list != null)
                    {
                        listener.a(list, com.target.ui.helper.j.b.a(com.target.ui.helper.j.b.this));
                        return;
                    } else
                    {
                        listener.a(n.ADD_ITEM_ERROR, "");
                        return;
                    }
                }

                public void b(Object obj)
                {
                    a((com.target.mothership.model.list.interfaces.a.a)obj);
                }

            
            {
                this$0 = com.target.ui.helper.j.b.this;
                listener = d1;
                super();
            }
            });
            return;
        }
    }

    public void a(final f listener)
    {
        mListManager.d(new com.target.mothership.model.d() {

            final com.target.ui.helper.j.b this$0;
            final f val$listener;

            public void a(com.target.mothership.model.list.interfaces.a.a a1)
            {
                listener.a(n.CLEAR_COMPLETED_ERROR, a1.g());
            }

            public volatile void a(Object obj)
            {
                a((Void)obj);
            }

            public void a(Void void1)
            {
                listener.b(com.target.ui.helper.j.b.a(com.target.ui.helper.j.b.this));
            }

            public void b(Object obj)
            {
                a((com.target.mothership.model.list.interfaces.a.a)obj);
            }

            
            {
                this$0 = com.target.ui.helper.j.b.this;
                listener = f1;
                super();
            }
        });
    }

    public void a(final g listener)
    {
        mListManager.c(new com.target.mothership.model.d() {

            final com.target.ui.helper.j.b this$0;
            final g val$listener;

            public String a()
            {
                return com.target.ui.helper.j.b.b(com.target.ui.helper.j.b.this);
            }

            public void a(com.target.mothership.model.list.interfaces.a.a a1)
            {
                listener.a(n.CLEAR_LIST_ERROR, a1.g());
            }

            public volatile void a(Object obj)
            {
                a((Void)obj);
            }

            public void a(Void void1)
            {
                listener.a(com.target.ui.helper.j.b.a(com.target.ui.helper.j.b.this));
            }

            public void b(Object obj)
            {
                a((com.target.mothership.model.list.interfaces.a.a)obj);
            }

            
            {
                this$0 = com.target.ui.helper.j.b.this;
                listener = g1;
                super();
            }
        });
    }

    public void a(final i listener)
    {
        mListManager.a(new com.target.mothership.model.d() {

            final com.target.ui.helper.j.b this$0;
            final i val$listener;

            public String a()
            {
                return com.target.ui.helper.j.b.b(com.target.ui.helper.j.b.this);
            }

            public void a(ListDetail listdetail)
            {
                listener.a(listdetail.getListItems());
            }

            public void a(com.target.mothership.model.list.interfaces.a.a a1)
            {
                listener.a(n.GET_ITEMS_ERROR, a1.g());
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
                this$0 = com.target.ui.helper.j.b.this;
                listener = i1;
                super();
            }
        });
    }

    public void a(ListDetailCompletedItem listdetailcompleteditem, final c listener)
    {
        mListManager.c(listdetailcompleteditem.e(), new com.target.mothership.model.d() {

            final com.target.ui.helper.j.b this$0;
            final c val$listener;

            public String a()
            {
                return com.target.ui.helper.j.b.b(com.target.ui.helper.j.b.this);
            }

            public void a(com.target.mothership.model.list.interfaces.a.a a1)
            {
                listener.a(n.RESTORE_COMPLETED_ITEM_ERROR, a1.g());
            }

            public volatile void a(Object obj)
            {
                a((List)obj);
            }

            public void a(List list)
            {
                listener.a(list, com.target.ui.helper.j.b.a(com.target.ui.helper.j.b.this));
            }

            public void b(Object obj)
            {
                a((com.target.mothership.model.list.interfaces.a.a)obj);
            }

            
            {
                this$0 = com.target.ui.helper.j.b.this;
                listener = c1;
                super();
            }
        });
    }

    public void a(ListDetailItem listdetailitem, int i1, k k1)
    {
        if (listdetailitem.g().b())
        {
            TGTProduct tgtproduct = new TGTProduct();
            tgtproduct.a((Tcin)listdetailitem.g().c());
            tgtproduct.l(listdetailitem.b());
            mListManager.a(tgtproduct, Integer.valueOf(listdetailitem.h()), i1, new b(k1, mRequestTag));
            return;
        } else
        {
            mListManager.a(listdetailitem.b(), Integer.valueOf(listdetailitem.h()), i1, new b(k1, mRequestTag));
            return;
        }
    }

    public void a(ListDetailItem listdetailitem, int i1, final l listener)
    {
        mListManager.b(listdetailitem.e(), i1, new com.target.mothership.model.d() {

            final com.target.ui.helper.j.b this$0;
            final l val$listener;

            public String a()
            {
                return com.target.ui.helper.j.b.b(com.target.ui.helper.j.b.this);
            }

            public void a(com.target.mothership.model.list.interfaces.a.a a1)
            {
                listener.a(n.REORDER_ERROR, a1.g());
            }

            public volatile void a(Object obj)
            {
                a((List)obj);
            }

            public void a(List list)
            {
                listener.a(list, com.target.ui.helper.j.b.a(com.target.ui.helper.j.b.this));
            }

            public void b(Object obj)
            {
                a((com.target.mothership.model.list.interfaces.a.a)obj);
            }

            
            {
                this$0 = com.target.ui.helper.j.b.this;
                listener = l1;
                super();
            }
        });
    }

    public void a(ListDetailItem listdetailitem, final j listener)
    {
        mListManager.b(listdetailitem.e(), new com.target.mothership.model.d() {

            final com.target.ui.helper.j.b this$0;
            final j val$listener;

            public String a()
            {
                return com.target.ui.helper.j.b.b(com.target.ui.helper.j.b.this);
            }

            public void a(com.target.mothership.model.list.interfaces.a.a a1)
            {
                listener.a(n.MARK_COMPLETE_ERROR, a1.g());
            }

            public volatile void a(Object obj)
            {
                a((List)obj);
            }

            public void a(List list)
            {
                listener.a(list, com.target.ui.helper.j.b.a(com.target.ui.helper.j.b.this));
            }

            public void b(Object obj)
            {
                a((com.target.mothership.model.list.interfaces.a.a)obj);
            }

            
            {
                this$0 = com.target.ui.helper.j.b.this;
                listener = j1;
                super();
            }
        });
    }

    public void a(String s, final int position, final d listener)
    {
        mListManager.a(s, Integer.valueOf(1), position, new com.target.mothership.model.d() {

            final com.target.ui.helper.j.b this$0;
            final d val$listener;
            final int val$position;

            public String a()
            {
                return com.target.ui.helper.j.b.b(com.target.ui.helper.j.b.this);
            }

            public void a(com.target.mothership.model.list.interfaces.a.a a1)
            {
                if (com.target.ui.helper.j.b.a(a1))
                {
                    listener.a(n.MAX_LIST_ITEM_COUNT_ERROR, a1.g());
                    return;
                } else
                {
                    listener.a(n.ADD_ITEM_ERROR, a1.g());
                    return;
                }
            }

            public volatile void a(Object obj)
            {
                a((List)obj);
            }

            public void a(List list)
            {
                if (list != null && list.size() > 0)
                {
                    list = (ListItem)list.get(0);
                } else
                {
                    list = null;
                }
                if (position == -1)
                {
                    listener.a(list, com.target.ui.helper.j.b.a(com.target.ui.helper.j.b.this));
                    return;
                } else
                {
                    listener.a(list, position, com.target.ui.helper.j.b.a(com.target.ui.helper.j.b.this));
                    return;
                }
            }

            public void b(Object obj)
            {
                a((com.target.mothership.model.list.interfaces.a.a)obj);
            }

            
            {
                this$0 = com.target.ui.helper.j.b.this;
                position = i1;
                listener = d1;
                super();
            }
        });
    }

    public void a(String s, Store store, final a listener)
    {
        aa.a(s, store, new com.target.ui.util.aa.c() {

            final com.target.ui.helper.j.b this$0;
            final a val$listener;

            public void a(String s1)
            {
                listener.c(s1);
            }

            public void a(List list)
            {
                listener.b(list);
            }

            
            {
                this$0 = com.target.ui.helper.j.b.this;
                listener = a1;
                super();
            }
        });
    }

    public void a(String s, d d1)
    {
        a(s, -1, d1);
    }

    public void a(List list, Store store, final m listener)
    {
        TreeSet treeset = new TreeSet() {

            final com.target.ui.helper.j.b this$0;

            public boolean a(String s)
            {
                return !o.c(s) && super.add(s);
            }

            public boolean add(Object obj)
            {
                return a((String)obj);
            }

            
            {
                this$0 = com.target.ui.helper.j.b.this;
                super();
            }
        };
        for (list = list.iterator(); list.hasNext(); treeset.add(((ListDetailItem)list.next()).b())) { }
        list = new ArrayList(treeset.size());
        list.addAll(treeset);
        w.a(list, store, new com.target.ui.util.w.b() {

            final com.target.ui.helper.j.b this$0;
            final m val$listener;

            public void a(Exception exception)
            {
                listener.a(exception);
            }

            public void a(List list1)
            {
                android.support.v4.f.a a1 = new android.support.v4.f.a();
                list1 = list1.iterator();
                do
                {
                    if (!list1.hasNext())
                    {
                        break;
                    }
                    LookupResultParcelable lookupresultparcelable = (LookupResultParcelable)list1.next();
                    if (lookupresultparcelable.product != null)
                    {
                        a1.put(lookupresultparcelable.product.title.toLowerCase(), lookupresultparcelable);
                    }
                } while (true);
                listener.a(a1);
            }

            
            {
                this$0 = com.target.ui.helper.j.b.this;
                listener = m1;
                super();
            }
        }).a();
    }
}
