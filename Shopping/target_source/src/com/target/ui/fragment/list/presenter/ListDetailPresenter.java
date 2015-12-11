// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.list.presenter;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import com.google.a.a.e;
import com.google.a.b.k;
import com.pointinside.products.AutocompleteSuggestion;
import com.pointinside.products.BaseProduct;
import com.target.mothership.common.product.Tcin;
import com.target.mothership.model.list.interfaces.ListDetail;
import com.target.mothership.model.list.interfaces.ListItem;
import com.target.mothership.model.list.interfaces.ListSummary;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.model.promotion.interfaces.PromotionDetail;
import com.target.mothership.model.promotion.interfaces.PromotionStatus;
import com.target.mothership.model.store.interfaces.Store;
import com.target.mothership.services.x;
import com.target.mothership.util.o;
import com.target.ui.g.a;
import com.target.ui.helper.promotions.PromotionDetailRequestParams;
import com.target.ui.helper.promotions.PromotionStatusRequestParams;
import com.target.ui.model.LookupResultParcelable;
import com.target.ui.model.list.ListCollectionItem;
import com.target.ui.model.list.ListDetailCompletedItem;
import com.target.ui.model.list.ListDetailItem;
import com.target.ui.service.g;
import com.target.ui.service.m;
import com.target.ui.service.provider.b;
import com.target.ui.service.provider.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ListDetailPresenter
    implements com.target.ui.g.a, com.target.ui.helper.j.b.a, com.target.ui.helper.j.b.d, com.target.ui.helper.j.b.f, com.target.ui.helper.j.b.g, com.target.ui.helper.j.b.i, com.target.ui.helper.promotions.a.a, com.target.ui.service.m.a
{
    public static class SavedState
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public SavedState a(Parcel parcel)
            {
                return new SavedState(parcel);
            }

            public SavedState[] a(int i1)
            {
                return new SavedState[i1];
            }

            public Object createFromParcel(Parcel parcel)
            {
                return a(parcel);
            }

            public Object[] newArray(int i1)
            {
                return a(i1);
            }

        };
        protected boolean pendingComplete;
        protected List pendingItems;

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i1)
        {
            byte byte0;
            if (pendingComplete)
            {
                byte0 = 1;
            } else
            {
                byte0 = 0;
            }
            parcel.writeByte(byte0);
            parcel.writeList(pendingItems);
        }


        public SavedState()
        {
        }

        protected SavedState(Parcel parcel)
        {
            boolean flag;
            if (parcel.readByte() != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            pendingComplete = flag;
            pendingItems = new ArrayList();
            parcel.readList(pendingItems, com/target/mothership/model/product/interfaces/ProductDetails.getClassLoader());
        }
    }

    public static class a
    {

        private com.target.ui.service.provider.b connectivityProvider;
        private Context context;
        private l deviceOsProvider;
        private ListCollectionItem listCollectionItem;
        private com.target.ui.helper.j.b listDetailDataHelper;
        private g listService;
        private com.target.ui.helper.promotions.a promotionDataHelper;
        private Parcelable savedState;
        private m singleListService;
        private Store store;

        static com.target.ui.helper.j.b a(a a1)
        {
            return a1.listDetailDataHelper;
        }

        static ListCollectionItem b(a a1)
        {
            return a1.listCollectionItem;
        }

        private boolean b()
        {
            return listDetailDataHelper != null && singleListService != null && listService != null && promotionDataHelper != null && connectivityProvider != null && deviceOsProvider != null && context != null;
        }

        static m c(a a1)
        {
            return a1.singleListService;
        }

        static g d(a a1)
        {
            return a1.listService;
        }

        static com.target.ui.helper.promotions.a e(a a1)
        {
            return a1.promotionDataHelper;
        }

        static Store f(a a1)
        {
            return a1.store;
        }

        static com.target.ui.service.provider.b g(a a1)
        {
            return a1.connectivityProvider;
        }

        static l h(a a1)
        {
            return a1.deviceOsProvider;
        }

        static Context i(a a1)
        {
            return a1.context;
        }

        static Parcelable j(a a1)
        {
            return a1.savedState;
        }

        public a a(Context context1)
        {
            context = context1;
            return this;
        }

        public a a(Parcelable parcelable)
        {
            savedState = parcelable;
            return this;
        }

        public a a(Store store1)
        {
            store = store1;
            return this;
        }

        public a a(com.target.ui.helper.j.b b1)
        {
            listDetailDataHelper = b1;
            return this;
        }

        public a a(com.target.ui.helper.promotions.a a1)
        {
            promotionDataHelper = a1;
            return this;
        }

        public a a(ListCollectionItem listcollectionitem)
        {
            listCollectionItem = listcollectionitem;
            return this;
        }

        public a a(g g1)
        {
            listService = g1;
            return this;
        }

        public a a(m m1)
        {
            singleListService = m1;
            return this;
        }

        public a a(com.target.ui.service.provider.b b1)
        {
            connectivityProvider = b1;
            return this;
        }

        public a a(l l1)
        {
            deviceOsProvider = l1;
            return this;
        }

        public ListDetailPresenter a()
        {
            if (!b())
            {
                throw new IllegalArgumentException("Required fields were not set.");
            } else
            {
                return new ListDetailPresenter(this);
            }
        }

        public a()
        {
        }
    }

    private class b
        implements com.target.ui.helper.promotions.a.c
    {

        private boolean mNotifyAll;
        private List mRequestItems;
        final ListDetailPresenter this$0;

        public void a(PromotionStatus promotionstatus, PromotionStatusRequestParams promotionstatusrequestparams)
        {
            ListDetailPresenter.this.a(promotionstatus, mRequestItems, mNotifyAll);
        }

        public void a(x x1, PromotionStatusRequestParams promotionstatusrequestparams)
        {
            ListDetailPresenter.this.a(x1);
        }

        public b(List list, boolean flag)
        {
            this$0 = ListDetailPresenter.this;
            super();
            mRequestItems = list;
            mNotifyAll = flag;
        }
    }


    private static final int AVG_LIST_ITEM_TITLE_LENGTH = 16;
    private final String TAG;
    private List mCache;
    private List mCompletedItems;
    private com.target.ui.service.provider.b mConnectivityProvider;
    private Context mContext;
    private com.target.ui.helper.j.b mDataHelper;
    private l mDeviceOsProvider;
    private boolean mDisableMovement;
    private ListCollectionItem mListCollectionItem;
    private g mListService;
    private com.target.mothership.model.list.k mListSyncService;
    private boolean mPendingComplete;
    private List mPendingItems;
    private com.target.ui.fragment.list.a.a mPresentation;
    private com.target.ui.helper.promotions.a mPromotionDataHelper;
    private boolean mPromotionsVisible;
    private m mSingleListService;
    private Store mStore;

    private ListDetailPresenter(a a1)
    {
        TAG = com/target/ui/fragment/list/presenter/ListDetailPresenter.getSimpleName();
        mDataHelper = com.target.ui.fragment.list.presenter.a.a(a1);
        mListCollectionItem = com.target.ui.fragment.list.presenter.a.b(a1);
        mSingleListService = a.c(a1);
        mListService = a.d(a1);
        mPromotionDataHelper = com.target.ui.fragment.list.presenter.a.e(a1);
        mStore = a.f(a1);
        mConnectivityProvider = com.target.ui.fragment.list.presenter.a.g(a1);
        mDeviceOsProvider = a.h(a1);
        mContext = a.i(a1);
        mCache = new ArrayList();
        mCompletedItems = new ArrayList();
        a(a.j(a1));
    }


    private ListItem a(int i1, List list)
    {
        for (list = list.iterator(); list.hasNext();)
        {
            ListItem listitem = (ListItem)list.next();
            if (i1 == listitem.getKey())
            {
                return listitem;
            }
        }

        return null;
    }

    static ListItem a(ListDetailPresenter listdetailpresenter, int i1, List list)
    {
        return listdetailpresenter.a(i1, list);
    }

    static com.target.ui.fragment.list.a.a a(ListDetailPresenter listdetailpresenter)
    {
        return listdetailpresenter.mPresentation;
    }

    private void a(Parcelable parcelable)
    {
        SavedState savedstate = (SavedState)parcelable;
        if (parcelable == null)
        {
            mPendingItems = new ArrayList();
            mPendingComplete = false;
            return;
        } else
        {
            mPendingItems = savedstate.pendingItems;
            mPendingComplete = savedstate.pendingComplete;
            return;
        }
    }

    private void a(ListItem listitem)
    {
        listitem = new ListDetailCompletedItem(listitem);
        mCompletedItems.add(0, listitem);
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.b(listitem);
            o();
            return;
        }
    }

    static void a(ListDetailPresenter listdetailpresenter, ListItem listitem)
    {
        listdetailpresenter.a(listitem);
    }

    static void a(ListDetailPresenter listdetailpresenter, boolean flag, List list)
    {
        listdetailpresenter.a(flag, list);
    }

    private void a(final List items, final boolean notifyAll)
    {
        if (mStore == null || items.isEmpty())
        {
            return;
        }
        if (!mConnectivityProvider.a())
        {
            mPresentation.b(0x7f090384);
            return;
        } else
        {
            mDataHelper.a(items, mStore, new com.target.ui.helper.j.b.m() {

                final ListDetailPresenter this$0;
                final List val$items;
                final boolean val$notifyAll;

                public void a(Exception exception)
                {
                    exception = (new StringBuilder()).append("PILookupError: ").append(exception.getMessage()).toString();
                    com.target.a.a.b.d(com.target.ui.fragment.list.presenter.ListDetailPresenter.e(ListDetailPresenter.this), exception);
                }

                public void a(Map map)
                {
                    if (com.target.ui.fragment.list.presenter.ListDetailPresenter.a(ListDetailPresenter.this) == null)
                    {
                        return;
                    }
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
                    com.target.ui.fragment.list.presenter.ListDetailPresenter.a(ListDetailPresenter.this, notifyAll, items);
                }

            
            {
                this$0 = ListDetailPresenter.this;
                items = list;
                notifyAll = flag;
                super();
            }
            });
            return;
        }
    }

    private void a(boolean flag, List list)
    {
        if (flag)
        {
            mPresentation.j();
        } else
        {
            list = list.iterator();
            while (list.hasNext()) 
            {
                ListDetailItem listdetailitem = (ListDetailItem)list.next();
                mPresentation.f(listdetailitem);
            }
        }
    }

    static List b(ListDetailPresenter listdetailpresenter)
    {
        return listdetailpresenter.mCache;
    }

    private void b(List list, boolean flag)
    {
        if (mStore == null || list.isEmpty())
        {
            return;
        }
        Object obj = new ArrayList();
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            ListDetailItem listdetailitem = (ListDetailItem)iterator.next();
            if (listdetailitem.g().b())
            {
                ((List) (obj)).add(listdetailitem.g().c());
            } else
            {
                arraylist.add(listdetailitem.b());
            }
        }

        obj = new PromotionStatusRequestParams(mStore.getStoreId(), ((List) (obj)), arraylist);
        mPromotionDataHelper.a(((PromotionStatusRequestParams) (obj)), new b(list, flag));
    }

    static void c(ListDetailPresenter listdetailpresenter)
    {
        listdetailpresenter.o();
    }

    private void c(List list)
    {
        for (Iterator iterator = list.iterator(); iterator.hasNext(); ((ListDetailItem)iterator.next()).c(false)) { }
        if (mPresentation != null)
        {
            a(true, list);
        }
    }

    static List d(ListDetailPresenter listdetailpresenter)
    {
        return listdetailpresenter.mCompletedItems;
    }

    static String e(ListDetailPresenter listdetailpresenter)
    {
        return listdetailpresenter.TAG;
    }

    private void e(ListDetailItem listdetailitem)
    {
        a(com.google.a.b.k.a(new ListDetailItem[] {
            listdetailitem
        }), false);
    }

    private void f(ListDetailItem listdetailitem)
    {
        b(com.google.a.b.k.a(new ListDetailItem[] {
            listdetailitem
        }), false);
    }

    private void o()
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.q();
            return;
        }
    }

    private void p()
    {
        if (mSingleListService.b().b())
        {
            mListCollectionItem = (ListCollectionItem)mSingleListService.b().c();
            mDataHelper.a(mListCollectionItem.d());
            mPresentation.b(mListCollectionItem);
            q();
            return;
        } else
        {
            mPresentation.d(true);
            mSingleListService.a(this);
            return;
        }
    }

    private void q()
    {
        mListService.a(mListCollectionItem);
        mPresentation.f();
        mPresentation.d(mListCollectionItem.b());
        mPresentation.c(mListCollectionItem.b());
        if (!mPendingComplete && mCache != null && mCompletedItems != null && (!mCache.isEmpty() || !mCompletedItems.isEmpty()))
        {
            mPresentation.a(mCache, mCompletedItems);
            o();
        } else
        {
            mPendingComplete = false;
            mDataHelper.a(this);
        }
        s();
    }

    private String r()
    {
        StringBuilder stringbuilder = new StringBuilder((mCache.size() + 1) * 16);
        ListDetailItem listdetailitem;
        for (Iterator iterator = mCache.iterator(); iterator.hasNext(); stringbuilder.append(listdetailitem.b()).append('\n'))
        {
            listdetailitem = (ListDetailItem)iterator.next();
            stringbuilder.append("-").append(" ");
            int i1 = listdetailitem.h();
            if (i1 > 1)
            {
                stringbuilder.append('(').append(i1).append(')').append(" ");
            }
        }

        return stringbuilder.toString();
    }

    private void s()
    {
        if (mPendingItems.isEmpty() || mPresentation == null)
        {
            return;
        }
        ProductDetails productdetails;
        for (Iterator iterator = mPendingItems.iterator(); iterator.hasNext(); mDataHelper.a(productdetails, this))
        {
            productdetails = (ProductDetails)iterator.next();
        }

        mPendingItems.clear();
    }

    public void a(Menu menu)
    {
label0:
        {
            boolean flag1 = false;
            com.target.ui.fragment.list.a.a a1 = mPresentation;
            boolean flag;
            if (mCache != null && !mCache.isEmpty())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            a1.a(menu, flag);
            a1 = mPresentation;
            if (mCache == null || mCache.isEmpty())
            {
                flag = flag1;
                if (mCompletedItems == null)
                {
                    break label0;
                }
                flag = flag1;
                if (mCompletedItems.isEmpty())
                {
                    break label0;
                }
            }
            flag = true;
        }
        a1.b(menu, flag);
    }

    public void a(Menu menu, MenuInflater menuinflater)
    {
        if (mListCollectionItem != null)
        {
            mPresentation.c(mListCollectionItem.b());
        }
        mPresentation.c(true);
    }

    public void a(e e1)
    {
        if (!e1.b())
        {
            c(mCache);
            return;
        } else
        {
            mStore = (Store)e1.c();
            a(mCache, true);
            b(mCache, true);
            return;
        }
    }

    public void a(ListDetail listdetail)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.d(false);
            mListCollectionItem = new ListCollectionItem(listdetail, mContext);
            mDataHelper.a(mListCollectionItem.d());
            mPresentation.b(mListCollectionItem);
            q();
            return;
        }
    }

    public void a(ListItem listitem, int i1, ListSummary listsummary)
    {
        ListDetailItem listdetailitem = new ListDetailItem(listitem);
        mCache.add(listdetailitem);
        if (mPresentation != null)
        {
            mPresentation.a(listitem, listsummary);
            mPresentation.d(listdetailitem, i1);
            o();
            f(listdetailitem);
            e(listdetailitem);
            if (mPromotionsVisible)
            {
                mPresentation.p();
                return;
            }
        }
    }

    public void a(ListItem listitem, ListSummary listsummary)
    {
        a(listitem, -1, listsummary);
    }

    public void a(ListSummary listsummary)
    {
        mCache.clear();
        mCompletedItems.clear();
        if (mPresentation == null)
        {
            return;
        } else
        {
            o();
            mPresentation.g();
            mPresentation.e(mListCollectionItem.b());
            return;
        }
    }

    public void a(com.target.mothership.model.list.interfaces.a.a a1)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            com.target.a.a.b.a(TAG, (new StringBuilder()).append("Error getting default list: ").append(a1.g()).toString());
            mPresentation.d(false);
            mPresentation.e();
            return;
        }
    }

    public void a(ProductDetails productdetails)
    {
        mPendingItems.add(productdetails);
    }

    public void a(PromotionDetail promotiondetail, int i1)
    {
        promotiondetail = promotiondetail.a();
        mDataHelper.a(promotiondetail, i1, this);
    }

    public void a(PromotionStatus promotionstatus, List list, boolean flag)
    {
        if (mPresentation == null)
        {
            return;
        }
        for (Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            ListDetailItem listdetailitem = (ListDetailItem)iterator.next();
            if (listdetailitem.g().b())
            {
                listdetailitem.c(promotionstatus.a((Tcin)listdetailitem.g().c()));
            } else
            {
                listdetailitem.c(promotionstatus.a(listdetailitem.b()));
            }
        }

        a(flag, list);
    }

    public void a(x x1)
    {
        com.target.a.a.b.d(TAG, (new StringBuilder()).append("Error retrieving promotions from PointInside").append(x1.getMessage()).toString());
    }

    public void a(x x1, PromotionDetailRequestParams promotiondetailrequestparams)
    {
        com.target.a.a.b.d(TAG, (new StringBuilder()).append("Error retrieving promotions from PointInside").append(x1.getMessage()).toString());
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.e(false);
            return;
        }
    }

    public void a(com.target.ui.fragment.list.a.a a1)
    {
        mPresentation = a1;
        if (mListCollectionItem == null)
        {
            p();
            return;
        } else
        {
            q();
            return;
        }
    }

    public void a(com.target.ui.helper.j.b.n n1, String s1)
    {
        if (mPresentation == null)
        {
            return;
        }
        static class _cls7
        {

            static final int $SwitchMap$com$target$ui$helper$list$ListDetailDataHelper$ServiceError[];

            static 
            {
                $SwitchMap$com$target$ui$helper$list$ListDetailDataHelper$ServiceError = new int[com.target.ui.helper.j.b.n.values().length];
                try
                {
                    $SwitchMap$com$target$ui$helper$list$ListDetailDataHelper$ServiceError[com.target.ui.helper.j.b.n.GET_ITEMS_ERROR.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$target$ui$helper$list$ListDetailDataHelper$ServiceError[com.target.ui.helper.j.b.n.ADD_ITEM_ERROR.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$target$ui$helper$list$ListDetailDataHelper$ServiceError[com.target.ui.helper.j.b.n.EDIT_ITEM_ERROR.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$ui$helper$list$ListDetailDataHelper$ServiceError[com.target.ui.helper.j.b.n.SET_QUANTITY_ERROR.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$ui$helper$list$ListDetailDataHelper$ServiceError[com.target.ui.helper.j.b.n.CLEAR_LIST_ERROR.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls7..SwitchMap.com.target.ui.helper.list.ListDetailDataHelper.ServiceError[n1.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            mPresentation.b(0x7f090516);
            return;

        case 2: // '\002'
            mPresentation.b(0x7f090511);
            return;

        case 3: // '\003'
            mPresentation.b(0x7f090514);
            return;

        case 4: // '\004'
            mPresentation.b(0x7f09051d);
            return;

        case 5: // '\005'
            mPresentation.b(0x7f090512);
            break;
        }
    }

    public void a(final ListDetailCompletedItem item)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mDataHelper.a(item, new com.target.ui.helper.j.b.c() {

                final ListDetailPresenter this$0;
                final ListDetailCompletedItem val$item;

                public void a(com.target.ui.helper.j.b.n n1, String s1)
                {
                    if (com.target.ui.fragment.list.presenter.ListDetailPresenter.a(ListDetailPresenter.this) == null)
                    {
                        return;
                    } else
                    {
                        com.target.ui.fragment.list.presenter.ListDetailPresenter.a(ListDetailPresenter.this).b(0x7f09051b);
                        return;
                    }
                }

                public void a(List list, ListSummary listsummary)
                {
                    if (com.target.ui.fragment.list.presenter.ListDetailPresenter.a(ListDetailPresenter.this) == null)
                    {
                        return;
                    }
                    ListDetailPresenter.d(ListDetailPresenter.this).remove(item);
                    list = com.target.ui.fragment.list.presenter.ListDetailPresenter.a(ListDetailPresenter.this, item.e().getKey(), list);
                    if (list == null)
                    {
                        com.target.ui.fragment.list.presenter.ListDetailPresenter.a(ListDetailPresenter.this).b(0x7f09051b);
                        return;
                    } else
                    {
                        ListDetailPresenter.this.a(list, listsummary);
                        return;
                    }
                }

            
            {
                this$0 = ListDetailPresenter.this;
                item = listdetailcompleteditem;
                super();
            }
            });
            return;
        }
    }

    public void a(final ListDetailItem item)
    {
        if (mPresentation == null)
        {
            item.d(false);
            return;
        } else
        {
            mDataHelper.a(item, new com.target.ui.helper.j.b.j() {

                final ListDetailPresenter this$0;
                final ListDetailItem val$item;

                public void a(com.target.ui.helper.j.b.n n1, String s1)
                {
                    if (com.target.ui.fragment.list.presenter.ListDetailPresenter.a(ListDetailPresenter.this) == null)
                    {
                        return;
                    } else
                    {
                        com.target.ui.fragment.list.presenter.ListDetailPresenter.a(ListDetailPresenter.this).b(0x7f090519);
                        return;
                    }
                }

                public void a(List list, ListSummary listsummary)
                {
                    if (com.target.ui.fragment.list.presenter.ListDetailPresenter.a(ListDetailPresenter.this) == null)
                    {
                        return;
                    }
                    list = com.target.ui.fragment.list.presenter.ListDetailPresenter.a(ListDetailPresenter.this, item.e().getKey(), list);
                    if (list != null)
                    {
                        com.target.ui.fragment.list.presenter.ListDetailPresenter.b(ListDetailPresenter.this).remove(item);
                        com.target.ui.fragment.list.presenter.ListDetailPresenter.a(ListDetailPresenter.this, list);
                        return;
                    } else
                    {
                        com.target.ui.fragment.list.presenter.ListDetailPresenter.a(ListDetailPresenter.this).b(0x7f090519);
                        return;
                    }
                }

            
            {
                this$0 = ListDetailPresenter.this;
                item = listdetailitem;
                super();
            }
            });
            return;
        }
    }

    public void a(final ListDetailItem detailItem, final int position)
    {
        if (mPresentation == null)
        {
            detailItem.d(false);
            return;
        } else
        {
            mDataHelper.a(detailItem.e(), new com.target.ui.helper.j.b.h() {

                final ListDetailPresenter this$0;
                final ListDetailItem val$detailItem;
                final int val$position;

                public void a(ListItem listitem, ListSummary listsummary)
                {
                    if (com.target.ui.fragment.list.presenter.ListDetailPresenter.a(ListDetailPresenter.this) == null)
                    {
                        return;
                    } else
                    {
                        com.target.ui.fragment.list.presenter.ListDetailPresenter.a(ListDetailPresenter.this).e(detailItem, position);
                        com.target.ui.fragment.list.presenter.ListDetailPresenter.a(ListDetailPresenter.this).e(detailItem);
                        com.target.ui.fragment.list.presenter.ListDetailPresenter.a(ListDetailPresenter.this).a(listitem, com.target.ui.fragment.list.presenter.ListDetailPresenter.b(ListDetailPresenter.this).size());
                        com.target.ui.fragment.list.presenter.ListDetailPresenter.b(ListDetailPresenter.this).remove(detailItem);
                        ListDetailPresenter.c(ListDetailPresenter.this);
                        return;
                    }
                }

                public void a(com.target.ui.helper.j.b.n n1, String s1)
                {
                    if (com.target.ui.fragment.list.presenter.ListDetailPresenter.a(ListDetailPresenter.this) == null)
                    {
                        return;
                    } else
                    {
                        com.target.ui.fragment.list.presenter.ListDetailPresenter.a(ListDetailPresenter.this).f(detailItem, position);
                        com.target.ui.fragment.list.presenter.ListDetailPresenter.a(ListDetailPresenter.this).b(0x7f090513);
                        return;
                    }
                }

            
            {
                this$0 = ListDetailPresenter.this;
                detailItem = listdetailitem;
                position = i1;
                super();
            }
            });
            return;
        }
    }

    public void a(ListDetailItem listdetailitem, View view)
    {
        if (listdetailitem.f() == null || mStore == null)
        {
            mPresentation.b(0x7f090516);
            return;
        }
        if (mDeviceOsProvider.a())
        {
            mPresentation.a(mStore, mListCollectionItem.d(), mCache, listdetailitem, view);
            return;
        } else
        {
            mPresentation.a(mStore, mListCollectionItem.d(), mCache, listdetailitem);
            return;
        }
    }

    public volatile void a(Object obj)
    {
        a((com.target.ui.fragment.list.a.a)obj);
    }

    public void a(String s1)
    {
        if (com.target.mothership.util.o.c(s1))
        {
            mPresentation.b(Collections.emptyList());
            return;
        } else
        {
            mDataHelper.a(s1, mStore, this);
            return;
        }
    }

    public void a(List list)
    {
        if (mPresentation == null)
        {
            return;
        }
        mCache = new ArrayList();
        mCompletedItems = new ArrayList();
        for (list = list.iterator(); list.hasNext();)
        {
            ListItem listitem = (ListItem)list.next();
            if (listitem.isCompleted())
            {
                mCompletedItems.add(new ListDetailCompletedItem(listitem));
            } else
            {
                mCache.add(new ListDetailItem(listitem));
            }
        }

        mPresentation.a(mCache, mCompletedItems);
        o();
        a(mCache, true);
        b(mCache, true);
    }

    public void a(List list, PromotionDetailRequestParams promotiondetailrequestparams)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.a(list);
            mPresentation.e(false);
            return;
        }
    }

    public void a(boolean flag)
    {
        mPromotionsVisible = flag;
    }

    public void b(ListSummary listsummary)
    {
        mCompletedItems.clear();
        if (mPresentation != null)
        {
            mPresentation.h();
            o();
        }
    }

    public void b(ListDetailItem listdetailitem)
    {
        ListItem listitem = listdetailitem.e();
        String s1 = listdetailitem.b();
        mDataHelper.a(listitem, s1, this);
        e(listdetailitem);
        listdetailitem.c(false);
        f(listdetailitem);
    }

    public void b(final ListDetailItem detailItem, final int position)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mDataHelper.a(detailItem, position, new com.target.ui.helper.j.b.k() {

                final ListDetailPresenter this$0;
                final ListDetailItem val$detailItem;
                final int val$position;

                public void a(ListItem listitem)
                {
                    if (com.target.ui.fragment.list.presenter.ListDetailPresenter.a(ListDetailPresenter.this) == null)
                    {
                        return;
                    } else
                    {
                        ListDetailItem listdetailitem = new ListDetailItem(listitem);
                        int i1 = Math.min(position, com.target.ui.fragment.list.presenter.ListDetailPresenter.b(ListDetailPresenter.this).size());
                        com.target.ui.fragment.list.presenter.ListDetailPresenter.b(ListDetailPresenter.this).add(i1, listdetailitem);
                        com.target.ui.fragment.list.presenter.ListDetailPresenter.a(ListDetailPresenter.this).f(listdetailitem, i1);
                        com.target.ui.fragment.list.presenter.ListDetailPresenter.a(ListDetailPresenter.this).a(listitem);
                        ListDetailPresenter.c(ListDetailPresenter.this);
                        listdetailitem.c(detailItem.j());
                        listdetailitem.a(detailItem.f());
                        return;
                    }
                }

                public void a(com.target.ui.helper.j.b.n n1, String s1)
                {
                    if (com.target.ui.fragment.list.presenter.ListDetailPresenter.a(ListDetailPresenter.this) == null)
                    {
                        return;
                    } else
                    {
                        com.target.ui.fragment.list.presenter.ListDetailPresenter.a(ListDetailPresenter.this).b(0x7f09051b);
                        return;
                    }
                }

            
            {
                this$0 = ListDetailPresenter.this;
                position = i1;
                detailItem = listdetailitem;
                super();
            }
            });
            return;
        }
    }

    public void b(String s1)
    {
        if (!com.target.mothership.util.o.e(s1))
        {
            mDataHelper.a(s1, this);
        }
    }

    public void b(List list)
    {
        if (mPresentation == null)
        {
            return;
        }
        ArrayList arraylist = new ArrayList();
        for (list = list.iterator(); list.hasNext(); arraylist.add(((AutocompleteSuggestion)list.next()).getTerm())) { }
        mPresentation.b(arraylist);
    }

    public void b(boolean flag)
    {
        mDisableMovement = flag;
    }

    public void c()
    {
        p();
    }

    public void c(ListDetailItem listdetailitem)
    {
        ListItem listitem = listdetailitem.e();
        mDataHelper.a(listitem, listdetailitem.h(), this);
    }

    public void c(final ListDetailItem item, final int newPosition)
    {
        mDataHelper.a(item, newPosition, new com.target.ui.helper.j.b.l() {

            final ListDetailPresenter this$0;
            final ListDetailItem val$item;
            final int val$newPosition;

            public void a(com.target.ui.helper.j.b.n n1, String s1)
            {
                com.target.ui.fragment.list.presenter.ListDetailPresenter.a(ListDetailPresenter.this).b(0x7f09051a);
            }

            public void a(List list, ListSummary listsummary)
            {
                if (com.target.ui.fragment.list.presenter.ListDetailPresenter.a(ListDetailPresenter.this) == null)
                {
                    return;
                } else
                {
                    com.target.ui.fragment.list.presenter.ListDetailPresenter.b(ListDetailPresenter.this).remove(item);
                    com.target.ui.fragment.list.presenter.ListDetailPresenter.b(ListDetailPresenter.this).add(newPosition, item);
                    return;
                }
            }

            
            {
                this$0 = ListDetailPresenter.this;
                item = listdetailitem;
                newPosition = i1;
                super();
            }
        });
    }

    public void c(String s1)
    {
    }

    public void d(ListDetailItem listdetailitem)
    {
        if (listdetailitem.g().b())
        {
            mPresentation.a((Tcin)listdetailitem.g().c(), mStore);
        }
    }

    public void d(ListDetailItem listdetailitem, int i1)
    {
        if (mStore == null)
        {
            return;
        }
        mPresentation.g(listdetailitem);
        mPresentation.e(true);
        mPresentation.k();
        mPresentation.c(i1);
        Object obj = mStore.getStoreId();
        if (listdetailitem.g().b())
        {
            obj = new PromotionDetailRequestParams(((com.target.mothership.common.store.StoreIdentifier) (obj)), (Tcin)listdetailitem.g().c());
        } else
        {
            obj = new PromotionDetailRequestParams(((com.target.mothership.common.store.StoreIdentifier) (obj)), listdetailitem.b());
        }
        mPromotionDataHelper.a(((PromotionDetailRequestParams) (obj)), this);
        mPresentation.l();
        mPresentation.n();
        mPresentation.f(listdetailitem.b());
    }

    public boolean d()
    {
        return mPromotionsVisible;
    }

    public void e()
    {
        if (mPromotionsVisible)
        {
            mPresentation.o();
        }
    }

    public void f()
    {
        while (mPresentation == null || !mPromotionsVisible) 
        {
            return;
        }
        mPresentation.o();
    }

    public boolean g()
    {
        if (mPromotionsVisible)
        {
            mPresentation.o();
            return true;
        } else
        {
            return false;
        }
    }

    public void h()
    {
        if (mPresentation == null)
        {
            mPendingComplete = true;
            return;
        } else
        {
            mDataHelper.a(this);
            return;
        }
    }

    public void i()
    {
        boolean flag1 = true;
        if (mDisableMovement)
        {
            return;
        }
        boolean flag;
        if (!mCache.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (mCompletedItems.isEmpty())
        {
            flag1 = false;
        }
        mPresentation.a(flag, flag1);
    }

    public void j()
    {
        if (mDisableMovement)
        {
            return;
        } else
        {
            String s1 = r();
            mPresentation.a(0x7f0904fa, mListCollectionItem.b(), s1);
            return;
        }
    }

    public void k()
    {
        mDataHelper.a(this);
        if (mPromotionsVisible)
        {
            mPresentation.o();
        }
    }

    public void l()
    {
        mPresentation.i();
    }

    public Parcelable m()
    {
        SavedState savedstate = new SavedState();
        savedstate.pendingItems = mPendingItems;
        savedstate.pendingComplete = mPendingComplete;
        return savedstate;
    }

    public void n()
    {
        mDataHelper.a(this);
    }

    public void v_()
    {
        mSingleListService = null;
        mListService = null;
        mPromotionDataHelper = null;
        mListCollectionItem = null;
        mStore = null;
        mDeviceOsProvider = null;
        mCache = null;
        mCompletedItems = null;
        mDataHelper = null;
    }

    public void z_()
    {
        if (!mCache.isEmpty())
        {
            mPresentation.r();
        }
        mDataHelper.a();
        mPresentation = null;
    }
}
