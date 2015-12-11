// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.shop;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.h;
import android.view.Menu;
import android.view.MenuInflater;
import com.target.a.a.a;
import com.target.mothership.common.params.ProductSummaryParam;
import com.target.mothership.common.weeklyad.PromotionRequest;
import com.target.mothership.model.store.interfaces.RelevantStoreSummary;
import com.target.ui.analytics.a.az;
import com.target.ui.fragment.common.TabbedFragment;
import com.target.ui.fragment.shop.b.e;
import com.target.ui.fragment.shop.b.f;
import com.target.ui.j.b.d;
import com.target.ui.model.shop.ShopOverrides;
import com.target.ui.service.k;
import com.target.ui.util.deep_link.PromotionParams;
import com.target.ui.util.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.ui.fragment.shop:
//            DealsFragment, CategoriesPageItemFragment

public class ShopHomeFragment extends TabbedFragment
    implements com.target.ui.fragment.product.refine.ProductSummaryRefineFragment.b
{
    private class a
        implements com.target.ui.service.k.c
    {

        private boolean mIsStarted;
        private boolean mLastWasInStoreState;
        private final k mRelevantStoreService;
        final ShopHomeFragment this$0;

        private boolean b(com.google.a.a.e e1)
        {
            return e1.b() && ((RelevantStoreSummary)e1.c()).a();
        }

        void a()
        {
            mLastWasInStoreState = b(mRelevantStoreService.c());
            mRelevantStoreService.a(this);
        }

        public void a(com.google.a.a.e e1)
        {
            boolean flag;
            if (com.target.ui.j.b.a.a().h().a() == com.target.ui.j.b.d.a.EXPERIMENT_SHOW_CARD_STREAM)
            {
                if (mLastWasInStoreState != (flag = b(e1)))
                {
                    mLastWasInStoreState = flag;
                    if (mIsStarted)
                    {
                        com.target.ui.fragment.shop.ShopHomeFragment.a(ShopHomeFragment.this);
                        return;
                    }
                }
            }
        }

        void b()
        {
            mIsStarted = true;
            a(mRelevantStoreService.c());
        }

        void c()
        {
            mIsStarted = false;
        }

        void d()
        {
            mRelevantStoreService.b(this);
        }

        a(k k1)
        {
            this$0 = ShopHomeFragment.this;
            super();
            mRelevantStoreService = k1;
        }
    }

    public static final class b extends Enum
    {

        private static final b $VALUES[];
        public static final b CATEGORIES;
        public static final b DEALS;
        public static final b FEATURED;

        public static b valueOf(String s)
        {
            return (b)Enum.valueOf(com/target/ui/fragment/shop/ShopHomeFragment$b, s);
        }

        public static b[] values()
        {
            return (b[])$VALUES.clone();
        }

        static 
        {
            CATEGORIES = new b("CATEGORIES", 0);
            DEALS = new b("DEALS", 1);
            FEATURED = new b("FEATURED", 2);
            $VALUES = (new b[] {
                CATEGORIES, DEALS, FEATURED
            });
        }

        private b(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String ARG_PERFORM_SEARCH = "performSearch";
    private static final String ARG_PROMOTION_PARAMS = "promotionParams";
    private static final String ARG_SHOP_OVERRIDES = "shopOverrides";
    private static final String ARG_WEEKLY_AD_PROMOTION_REQUEST = "weeklyAdPromotionRequest";
    private static final String LABEL_CATEGORIES = "categories";
    private static final String LABEL_DEALS = "deals";
    private static final String LABEL_FEATURED = "featured";
    private a mInStoreStateChangeHandler;
    private boolean mPerformSearch;
    private PromotionParams mPromotionParams;
    private ShopOverrides mShopOverrides;
    private PromotionRequest mWeeklyAdPromotionRequest;

    public ShopHomeFragment()
    {
        mPerformSearch = false;
    }

    public static ShopHomeFragment a()
    {
        ShopHomeFragment shophomefragment = new ShopHomeFragment();
        shophomefragment.setArguments(new Bundle());
        return shophomefragment;
    }

    public static ShopHomeFragment a(ShopOverrides shopoverrides)
    {
        ShopHomeFragment shophomefragment = a();
        shophomefragment.getArguments().putParcelable("shopOverrides", shopoverrides);
        return shophomefragment;
    }

    public static ShopHomeFragment a(ShopOverrides shopoverrides, PromotionRequest promotionrequest)
    {
        shopoverrides = a(shopoverrides);
        shopoverrides.getArguments().putParcelable("weeklyAdPromotionRequest", promotionrequest);
        return shopoverrides;
    }

    public static ShopHomeFragment a(PromotionParams promotionparams)
    {
        ShopHomeFragment shophomefragment = a();
        shophomefragment.getArguments().putParcelable("promotionParams", promotionparams);
        return shophomefragment;
    }

    static void a(ShopHomeFragment shophomefragment)
    {
        shophomefragment.k();
    }

    private void a(List list, int i)
    {
        int j = 0;
        while (j < list.size()) 
        {
            Object obj = (Fragment)list.get(j);
            if (obj instanceof az)
            {
                obj = (az)obj;
                boolean flag;
                if (j != i)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                ((az) (obj)).a(flag);
            }
            j++;
        }
    }

    private com.target.ui.fragment.common.TabbedFragment.b b()
    {
        e e1 = com.target.ui.j.a.a(new com.target.a.a.a(getActivity()));
        return new com.target.ui.fragment.common.TabbedFragment.b(e1.a(mPromotionParams, mShopOverrides), e1.a(), e1.b());
    }

    private void b(Fragment fragment)
    {
        while (fragment == null || !(fragment instanceof az)) 
        {
            return;
        }
        ((az)fragment).e();
    }

    private void k()
    {
        a(b(), 0);
    }

    protected void a(int i)
    {
        a(i(), i);
        b(j());
    }

    public void a(ProductSummaryParam productsummaryparam, ArrayList arraylist)
    {
        Object obj = getChildFragmentManager().f();
        if (obj == null)
        {
            q.a(TAG, "Attempted to call onRefined with null child list");
        } else
        {
            obj = ((List) (obj)).iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                Fragment fragment = (Fragment)((Iterator) (obj)).next();
                if (fragment instanceof DealsFragment)
                {
                    ((DealsFragment)fragment).a(productsummaryparam, arraylist);
                }
            }
        }
    }

    public void a(boolean flag)
    {
        mPerformSearch = flag;
        getArguments().putBoolean("performSearch", flag);
    }

    protected List c()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(b());
        arraylist.add(new com.target.ui.fragment.common.TabbedFragment.b(com.target.ui.j.a.a(mWeeklyAdPromotionRequest).a(), "deals"));
        arraylist.add(new com.target.ui.fragment.common.TabbedFragment.b(com.target.ui.fragment.shop.CategoriesPageItemFragment.a(), "categories"));
        return arraylist;
    }

    protected int d()
    {
        int i = 0;
        if (mShopOverrides != null) goto _L2; else goto _L1
_L1:
        i = super.d();
_L4:
        return i;
_L2:
        static class _cls1
        {

            static final int $SwitchMap$com$target$ui$fragment$shop$ShopHomeFragment$ShopTab[];

            static 
            {
                $SwitchMap$com$target$ui$fragment$shop$ShopHomeFragment$ShopTab = new int[b.values().length];
                try
                {
                    $SwitchMap$com$target$ui$fragment$shop$ShopHomeFragment$ShopTab[b.FEATURED.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$ui$fragment$shop$ShopHomeFragment$ShopTab[b.DEALS.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$ui$fragment$shop$ShopHomeFragment$ShopTab[b.CATEGORIES.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.target.ui.fragment.shop.ShopHomeFragment.ShopTab[mShopOverrides.b().ordinal()])
        {
        default:
            return 0;

        case 2: // '\002'
            return 1;

        case 3: // '\003'
            return 2;

        case 1: // '\001'
            break;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected boolean g()
    {
        return true;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mInStoreStateChangeHandler = new a(com.target.ui.service.k.a());
        mInStoreStateChangeHandler.a();
        if (getArguments() == null)
        {
            return;
        } else
        {
            mPerformSearch = getArguments().getBoolean("performSearch", false);
            mPromotionParams = (PromotionParams)getArguments().getParcelable("promotionParams");
            mShopOverrides = (ShopOverrides)getArguments().getParcelable("shopOverrides");
            mWeeklyAdPromotionRequest = (PromotionRequest)getArguments().getParcelable("weeklyAdPromotionRequest");
            return;
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        if (!isAdded())
        {
            return;
        }
        j(getResources().getString(0x7f0904fe));
        b(true);
        menuinflater.inflate(0x7f120005, menu);
        if (mPerformSearch)
        {
            a(false);
            Y();
        }
        super.onCreateOptionsMenu(menu, menuinflater);
    }

    public void onDestroy()
    {
        super.onDestroy();
        mInStoreStateChangeHandler.d();
    }

    public void onStart()
    {
        super.onStart();
        mInStoreStateChangeHandler.b();
    }

    public void onStop()
    {
        super.onStop();
        mInStoreStateChangeHandler.c();
    }
}
