// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cardstream.c;

import com.google.a.a.e;
import com.google.a.a.g;
import com.pointinside.products.BaseProduct;
import com.target.a.a.b;
import com.target.b.a;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.list.interfaces.ListDetail;
import com.target.mothership.model.list.interfaces.ListItem;
import com.target.mothership.model.list.interfaces.ListSummary;
import com.target.mothership.model.store.interfaces.RelevantStoreSummary;
import com.target.mothership.model.store.interfaces.Store;
import com.target.ui.fragment.cardstream.SingleShoppingListData;
import com.target.ui.model.LookupResultParcelable;
import com.target.ui.model.list.ListDetailItem;
import com.target.ui.service.m;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.target.ui.fragment.cardstream.c:
//            a

public class i extends com.target.ui.fragment.cardstream.c.a
{

    private static final String TAG = "SingleShoppingListDataSource";
    private static final g sNoDeletingItems = new g() {

        public boolean a(ListItem listitem)
        {
            return listitem != null && !listitem.isDeleting();
        }

        public volatile boolean a(Object obj)
        {
            return a((ListItem)obj);
        }

    };
    public static final g sOnlyShowIncompleteItems = new g() {

        public boolean a(ListDetailItem listdetailitem)
        {
            return !listdetailitem.d();
        }

        public volatile boolean a(Object obj)
        {
            return a((ListDetailItem)obj);
        }

    };
    private static final com.google.a.a.b sToListDetailItem = new com.google.a.a.b() {

        public ListDetailItem a(ListItem listitem)
        {
            return new ListDetailItem(listitem);
        }

        public volatile Object a(Object obj)
        {
            return a((ListItem)obj);
        }

    };
    private final com.target.ui.service.a mAccountService;
    private final com.target.ui.helper.j.b mDataHelper;
    private final com.target.ui.service.a.b mSessionListener = new com.target.ui.service.a.b() {

        final i this$0;

        public void a(Guest guest)
        {
            h();
        }

        public void b()
        {
            h();
        }

            
            {
                this$0 = i.this;
                super();
            }
    };
    private final m mSingleListService;
    private final a mStoreProvider;

    public i(j.c c1, a.a a1, m m1, com.target.ui.service.a a2, com.target.ui.helper.j.b b1, a a3)
    {
        super(c1, a1, "ShoppingListSource");
        mSingleListService = m1;
        mAccountService = a2;
        mDataHelper = b1;
        mStoreProvider = a3;
    }

    static com.google.a.a.b a()
    {
        return sToListDetailItem;
    }

    private void a(final ListSummary listSummary, final List items, final a.a onLoadedCallback)
    {
        e e1 = (e)mStoreProvider.b();
        String s;
        if (!e1.b() || ((RelevantStoreSummary)e1.c()).getStoreId() == null)
        {
            s = "No store available, cannot attach aisle locations";
        } else
        if (items.isEmpty())
        {
            s = "No items to attach aisle locations to.";
        } else
        {
            s = null;
        }
        if (s != null)
        {
            listSummary = new SingleShoppingListData(listSummary, items);
            com.target.a.a.b.d("SingleShoppingListDataSource", s);
            onLoadedCallback.a(e.b(listSummary));
            return;
        } else
        {
            mDataHelper.a(items, (Store)e1.c(), new com.target.ui.helper.j.b.m() {

                final i this$0;
                final List val$items;
                final ListSummary val$listSummary;
                final a.a val$onLoadedCallback;

                public void a(Exception exception)
                {
                    com.target.a.a.b.d("SingleShoppingListDataSource", (new StringBuilder()).append("PILookupError: ").append(exception.getMessage()).toString());
                }

                public void a(Map map)
                {
                    Iterator iterator = items.iterator();
                    do
                    {
                        if (!iterator.hasNext())
                        {
                            break;
                        }
                        ListDetailItem listdetailitem = (ListDetailItem)iterator.next();
                        LookupResultParcelable lookupresultparcelable = (LookupResultParcelable)map.get(listdetailitem.b().toLowerCase());
                        if (lookupresultparcelable != null && lookupresultparcelable.product.locations != null && !lookupresultparcelable.product.locations.isEmpty())
                        {
                            listdetailitem.a(com.target.ui.util.f.a.b(lookupresultparcelable.product.locations));
                        }
                    } while (true);
                    map = new SingleShoppingListData(listSummary, items);
                    onLoadedCallback.a(e.b(map));
                }

            
            {
                this$0 = i.this;
                items = list;
                listSummary = listsummary;
                onLoadedCallback = a1;
                super();
            }
            });
            return;
        }
    }

    static void a(i j, ListSummary listsummary, List list, a.a a1)
    {
        j.a(listsummary, list, a1);
    }

    static g m()
    {
        return sNoDeletingItems;
    }

    protected void a(final a.a onLoadedCallback)
    {
        mSingleListService.a(new com.target.ui.service.m.a() {

            final i this$0;
            final a.a val$onLoadedCallback;

            public void a(ListDetail listdetail)
            {
                com.google.a.b.h h = com.google.a.b.e.a(listdetail.getListItems()).a(com.target.ui.fragment.cardstream.c.i.m()).a(com.target.ui.fragment.cardstream.c.i.a()).a();
                com.target.ui.fragment.cardstream.c.i.a(i.this, listdetail, h, onLoadedCallback);
            }

            public void a(com.target.mothership.model.list.interfaces.a.a a1)
            {
                onLoadedCallback.a(e.e());
            }

            
            {
                this$0 = i.this;
                onLoadedCallback = a1;
                super();
            }
        });
    }

    protected boolean a(SingleShoppingListData singleshoppinglistdata)
    {
        return singleshoppinglistdata != null;
    }

    protected volatile boolean a(Object obj)
    {
        return a((SingleShoppingListData)obj);
    }

    public long b()
    {
        return TimeUnit.SECONDS.toMillis(5L);
    }

    protected void c()
    {
        mAccountService.a(mSessionListener);
    }

    protected void d()
    {
        mAccountService.b(mSessionListener);
    }

}
