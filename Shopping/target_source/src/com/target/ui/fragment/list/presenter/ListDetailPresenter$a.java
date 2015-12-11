// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.list.presenter;

import android.content.Context;
import android.os.Parcelable;
import com.target.mothership.model.store.interfaces.Store;
import com.target.ui.helper.promotions.a;
import com.target.ui.model.list.ListCollectionItem;
import com.target.ui.service.g;
import com.target.ui.service.m;
import com.target.ui.service.provider.b;
import com.target.ui.service.provider.l;

// Referenced classes of package com.target.ui.fragment.list.presenter:
//            ListDetailPresenter

public static class A
{

    private b connectivityProvider;
    private Context context;
    private l deviceOsProvider;
    private ListCollectionItem listCollectionItem;
    private com.target.ui.helper.j.b listDetailDataHelper;
    private g listService;
    private a promotionDataHelper;
    private Parcelable savedState;
    private m singleListService;
    private Store store;

    static com.target.ui.helper.j.b a(A a1)
    {
        return a1.listDetailDataHelper;
    }

    static ListCollectionItem b(listDetailDataHelper listdetaildatahelper)
    {
        return listdetaildatahelper.listCollectionItem;
    }

    private boolean b()
    {
        return listDetailDataHelper != null && singleListService != null && listService != null && promotionDataHelper != null && connectivityProvider != null && deviceOsProvider != null && context != null;
    }

    static m c(context context1)
    {
        return context1.singleListService;
    }

    static g d(singleListService singlelistservice)
    {
        return singlelistservice.listService;
    }

    static a e(listService listservice)
    {
        return listservice.promotionDataHelper;
    }

    static Store f(promotionDataHelper promotiondatahelper)
    {
        return promotiondatahelper.store;
    }

    static b g(store store1)
    {
        return store1.connectivityProvider;
    }

    static l h(connectivityProvider connectivityprovider)
    {
        return connectivityprovider.deviceOsProvider;
    }

    static Context i(deviceOsProvider deviceosprovider)
    {
        return deviceosprovider.context;
    }

    static Parcelable j(context context1)
    {
        return context1.savedState;
    }

    public savedState a(Context context1)
    {
        context = context1;
        return this;
    }

    public context a(Parcelable parcelable)
    {
        savedState = parcelable;
        return this;
    }

    public savedState a(Store store1)
    {
        store = store1;
        return this;
    }

    public store a(com.target.ui.helper.j.b b1)
    {
        listDetailDataHelper = b1;
        return this;
    }

    public listDetailDataHelper a(a a1)
    {
        promotionDataHelper = a1;
        return this;
    }

    public promotionDataHelper a(ListCollectionItem listcollectionitem)
    {
        listCollectionItem = listcollectionitem;
        return this;
    }

    public listCollectionItem a(g g1)
    {
        listService = g1;
        return this;
    }

    public listService a(m m)
    {
        singleListService = m;
        return this;
    }

    public singleListService a(b b1)
    {
        connectivityProvider = b1;
        return this;
    }

    public connectivityProvider a(l l)
    {
        deviceOsProvider = l;
        return this;
    }

    public ListDetailPresenter a()
    {
        if (!b())
        {
            throw new IllegalArgumentException("Required fields were not set.");
        } else
        {
            return new ListDetailPresenter(this, null);
        }
    }

    public A()
    {
    }
}
