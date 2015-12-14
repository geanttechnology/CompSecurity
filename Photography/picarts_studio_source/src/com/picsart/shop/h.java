// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.shop;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.firegnom.rat.ActivityDestroyListener;
import com.picsart.studio.utils.ItemControl;
import com.picsart.studio.view.SlidingTabLayout;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.adapter.a;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.controllers.GetShopBannersController;
import com.socialin.android.apiv3.model.AppProps;
import com.socialin.android.apiv3.model.ShopBannersResponse;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.picsart.profile.view.PagerRecyclerView;
import com.socialin.android.util.Utils;
import com.socialin.android.util.s;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

// Referenced classes of package com.picsart.shop:
//            i, ShopItemActivity, ShopActivity, q, 
//            o, j, s, f

public final class h extends Fragment
    implements a
{

    int a;
    private ViewPager b;
    private q c;
    private android.support.v7.widget.RecyclerView.OnScrollListener d;
    private ViewGroup e;
    private SlidingTabLayout f;
    private int g;
    private int h;
    private View i;
    private int j;
    private Fragment k;
    private int l;
    private ArrayList m;
    private boolean n;
    private com.picsart.shop.s o;
    private PagerRecyclerView p;
    private j q;

    public h()
    {
        b = null;
        c = null;
        d = null;
        e = null;
        f = null;
        g = 0;
        h = 0;
        i = null;
        j = 0;
        k = null;
        a = 0;
        l = 0;
        m = new ArrayList();
        o = null;
        p = null;
        q = null;
    }

    static int a(h h1, int i1)
    {
        h1.h = i1;
        return i1;
    }

    static Fragment a(h h1)
    {
        return h1.k;
    }

    static Fragment a(h h1, Fragment fragment)
    {
        h1.k = fragment;
        return fragment;
    }

    private void a()
    {
        GetShopBannersController getshopbannerscontroller = new GetShopBannersController();
        getshopbannerscontroller.setRequestCompleteListener(new d() {

            private h a;

            public final volatile void onCancelRequest(Object obj, Request request)
            {
            }

            public final void onFailure(Exception exception, Request request)
            {
            }

            public final transient void onProgressUpdate(Integer ainteger[])
            {
            }

            public final void onSuccess(Object obj, Request request)
            {
                for (obj = ((ShopBannersResponse)obj).response.iterator(); ((Iterator) (obj)).hasNext(); h.n(a).add(((com.socialin.android.apiv3.model.ShopBannersResponse.ShopBanner) (request)).data))
                {
                    request = (com.socialin.android.apiv3.model.ShopBannersResponse.ShopBanner)((Iterator) (obj)).next();
                }

                if (h.n(a).size() > 0)
                {
                    com.picsart.shop.h.a(a, h.n(a));
                }
            }

            
            {
                a = h.this;
                super();
            }
        });
        getshopbannerscontroller.doRequest();
    }

    static void a(h h1, ArrayList arraylist)
    {
        h1.a(arraylist);
    }

    private void a(ArrayList arraylist)
    {
        FragmentActivity fragmentactivity = getActivity();
        if (fragmentactivity != null && !fragmentactivity.isFinishing())
        {
            Object obj = (android.widget.RelativeLayout.LayoutParams)p.getLayoutParams();
            int j1 = fragmentactivity.getResources().getDisplayMetrics().widthPixels;
            int k1 = Math.min(j1, fragmentactivity.getResources().getDisplayMetrics().heightPixels);
            int l1 = (j1 - k1) / 2;
            obj.height = (int)((double)k1 * 0.46999999999999997D);
            obj.width = j1;
            p.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            e.getLayoutParams().width = j1;
            e.getLayoutParams().height = ((android.widget.RelativeLayout.LayoutParams) (obj)).height;
            obj = p;
            int i1;
            if (l1 == 0)
            {
                i1 = 0;
            } else
            {
                i1 = 2;
            }
            ((PagerRecyclerView) (obj)).addItemDecoration(new i(i1));
            p.setProportion(l1);
            p.setScreenWidth(j1);
            obj = new com.socialin.android.picsart.profile.adapter.h(fragmentactivity, k1, arraylist.size(), p, this, null);
            ((BaseActivity)fragmentactivity).addOnDestroyListener(((ActivityDestroyListener) (obj)));
            ((com.socialin.android.picsart.profile.adapter.h) (obj)).setHasStableIds(true);
            obj.b = 0.46999999999999997D;
            ((com.socialin.android.picsart.profile.adapter.h) (obj)).addAll(arraylist);
            p.setAdapter(((android.support.v7.widget.RecyclerView.Adapter) (obj)));
            p.post(new Runnable(l1) {

                private int a;
                private h b;

                public final void run()
                {
                    h.o(b).scrollToPositionWithOffset(0x3fffffff, a);
                }

            
            {
                b = h.this;
                a = i1;
                super();
            }
            });
            if (getActivity() instanceof BaseActivity)
            {
                ((BaseActivity)getActivity()).addOnDestroyListener(((ActivityDestroyListener) (obj)));
                return;
            }
        }
    }

    static int b(h h1, int i1)
    {
        i1 = h1.h - i1;
        h1.h = i1;
        return i1;
    }

    static q b(h h1)
    {
        return h1.c;
    }

    static int c(h h1)
    {
        return h1.j;
    }

    static int c(h h1, int i1)
    {
        h1.j = i1;
        return i1;
    }

    static int d(h h1)
    {
        return h1.h;
    }

    static boolean e(h h1)
    {
        return h1.n;
    }

    static int f(h h1)
    {
        return h1.l;
    }

    static int g(h h1)
    {
        return h1.a;
    }

    static View h(h h1)
    {
        return h1.i;
    }

    static ViewGroup i(h h1)
    {
        return h1.e;
    }

    static ViewPager j(h h1)
    {
        return h1.b;
    }

    static int k(h h1)
    {
        return h1.g;
    }

    static boolean l(h h1)
    {
        h1.n = true;
        return true;
    }

    static void m(h h1)
    {
        h1.a();
    }

    static ArrayList n(h h1)
    {
        return h1.m;
    }

    static j o(h h1)
    {
        return h1.q;
    }

    public final transient void a(int i1, ItemControl itemcontrol, Object aobj[])
    {
        if (!isAdded())
        {
            return;
        }
        final class _cls8
        {

            static final int a[];

            static 
            {
                a = new int[ItemControl.values().length];
                try
                {
                    a[ItemControl.BANNER.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
            }
        }

        switch (com.picsart.shop._cls8.a[itemcontrol.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            itemcontrol = (String)aobj[0];
            break;
        }
        aobj = itemcontrol.substring(itemcontrol.lastIndexOf("=") + 1);
        Intent intent = new Intent(getActivity(), com/picsart/shop/ShopItemActivity);
        intent.putExtra("selectedShopItemId", ((String) (aobj)));
        startActivity(intent);
        AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.BannerClickEvent("shop", itemcontrol, getResources().getConfiguration().locale.getCountry()));
    }

    public final void a(boolean flag)
    {
        int i1 = 0;
        if (flag)
        {
            j = 0;
            h = 0;
            e.post(new Runnable() {

                private h a;

                public final void run()
                {
                    h.i(a).setTranslationY(0.0F);
                }

            
            {
                a = h.this;
                super();
            }
            });
            i.post(new Runnable() {

                private h a;

                public final void run()
                {
                    h.h(a).setTranslationY(0.0F);
                }

            
            {
                a = h.this;
                super();
            }
            });
            FragmentActivity fragmentactivity = getActivity();
            if (fragmentactivity != null && !fragmentactivity.isFinishing() && (fragmentactivity instanceof ShopActivity))
            {
                ((ShopActivity)fragmentactivity).a(0);
            }
        }
        for (int j1 = c.getCount(); i1 < j1; i1++)
        {
            Fragment fragment = c.a(i1);
            if (fragment != null && (fragment instanceof o))
            {
                ((o)fragment).a();
            }
        }

    }

    public final void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        bundle = getActivity();
        g = (int)Utils.a(48F, bundle);
        int i1 = Utils.a(getActivity());
        l = (int)(0.46999999999999997D * (double)Math.min(Utils.b(bundle), Utils.a(bundle)));
        Object obj = e.getLayoutParams();
        obj.width = i1;
        obj.height = l;
        e.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        q = new j(bundle);
        q.setSmoothScrollbarEnabled(false);
        p.setLayoutManager(q);
        d = new android.support.v7.widget.RecyclerView.OnScrollListener(bundle) {

            private Activity a;
            private h b;

            public final void onScrolled(RecyclerView recyclerview, int j1, int k1)
            {
                boolean flag1 = false;
                super.onScrolled(recyclerview, j1, k1);
                h.b(b, k1);
                com.picsart.shop.h.a(b, Math.min(0, com.picsart.shop.h.d(b)));
                recyclerview = b;
                k1 = com.picsart.shop.h.d(b);
                j1 = ((flag1) ? 1 : 0);
                if (h.e(b))
                {
                    j1 = -h.f(b);
                }
                h.c(recyclerview, Math.max(k1, j1 + h.g(b)));
                h.h(b).setTranslationY(h.c(b));
                h.i(b).setTranslationY((h.c(b) * -2) / 3);
                if (com.picsart.shop.h.a(b) == null)
                {
                    com.picsart.shop.h.a(b, h.b(b).b(h.j(b).getCurrentItem()));
                }
                if (!(com.picsart.shop.h.a(b) instanceof o)) goto _L2; else goto _L1
_L1:
                ((o)com.picsart.shop.h.a(b)).c = com.picsart.shop.h.d(b);
_L4:
                if (a != null && !a.isFinishing() && (a instanceof ShopActivity))
                {
                    ((ShopActivity)a).a((h.c(b) * 255) / (-h.f(b) + h.g(b)));
                }
                return;
_L2:
                if (com.picsart.shop.h.a(b) instanceof f)
                {
                    ((f)com.picsart.shop.h.a(b)).d = com.picsart.shop.h.d(b);
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                b = h.this;
                a = activity;
                super();
            }
        };
        o = new com.picsart.shop.s(this);
        n = s.a(getActivity());
        if (!n)
        {
            e.setVisibility(8);
        }
        obj = getChildFragmentManager();
        android.support.v7.widget.RecyclerView.OnScrollListener onscrolllistener = d;
        com.picsart.shop.s s1 = o;
        if (n)
        {
            i1 = l;
        } else
        {
            i1 = 0;
        }
        c = new q(bundle, ((android.support.v4.app.FragmentManager) (obj)), onscrolllistener, s1, i1 + g);
        bundle = SocialinV3.getInstance().getAppProps();
        if (bundle != null)
        {
            bundle = bundle.getShopTabs();
        } else
        {
            bundle = null;
        }
        boolean flag;
        long l1;
        if (bundle != null && bundle.size() > 0)
        {
            for (bundle = bundle.iterator(); bundle.hasNext();)
            {
                com.socialin.android.apiv3.model.AppProps.ShopTab shoptab = (com.socialin.android.apiv3.model.AppProps.ShopTab)bundle.next();
                if (shoptab.tags != null && shoptab.tags.length > 0)
                {
                    Bundle bundle1 = new Bundle();
                    bundle1.putStringArray("tagsList", shoptab.tags);
                    c.a(shoptab.title, com/picsart/shop/f, bundle1, 0x7f100099);
                } else
                {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("price", shoptab.price);
                    bundle2.putString("tag", shoptab.tag);
                    c.a(shoptab.title, com/picsart/shop/o, bundle2, 0x7f100099);
                }
            }

            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            bundle = new Bundle();
            bundle.putString("fName", "paid.fragment");
            bundle.putString("price", "paid");
            c.a(getString(0x7f08029c), com/picsart/shop/o, bundle, 0x7f10008c);
            bundle = new Bundle();
            bundle.putString("fName", "free.fragment");
            bundle.putString("price", "free");
            c.a(getString(0x7f080299), com/picsart/shop/o, bundle, 0x7f100079);
        }
        new Bundle();
        bundle = new Bundle();
        bundle.putString("fName", "installed.fragment");
        bundle.putString("price", "installed");
        c.a(getString(0x7f08029a), com/picsart/shop/o, bundle, 0x7f100080);
        c.notifyDataSetChanged();
        b.setAdapter(c);
        b.setOffscreenPageLimit(3);
        ((SlidingTabLayout)getView().findViewById(0x7f10060b)).setViewPager(b);
        c.getCount();
        l1 = SocialinV3.getInstance().getUser().id;
        h = 0;
        j = 0;
        if (m != null && m.size() > 0)
        {
            a(m);
        } else
        {
            a();
        }
        if (getActivity().getIntent().hasExtra("type"))
        {
            b.setCurrentItem(getActivity().getIntent().getIntExtra("type", 0));
        }
        new ActivityDestroyListener() {

            public final void onActivityDestroyed()
            {
            }

        };
    }

    public final void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        if (intent != null)
        {
            FragmentActivity fragmentactivity = getActivity();
            if (fragmentactivity != null && !fragmentactivity.isFinishing() && i1 == 100 && intent.getBooleanExtra("needUpdate", true))
            {
                a(false);
            }
        }
    }

    public final void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        a(m);
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030119, viewgroup, false);
        b = (ViewPager)layoutinflater.findViewById(0x7f100608);
        e = (ViewGroup)layoutinflater.findViewById(0x7f10060a);
        f = (SlidingTabLayout)layoutinflater.findViewById(0x7f10060b);
        i = layoutinflater.findViewById(0x7f100609);
        p = (PagerRecyclerView)layoutinflater.findViewById(0x7f100278);
        f.setOnPageChangeListener(new android.support.v4.view.ViewPager.OnPageChangeListener() {

            private h a;

            public final void onPageScrollStateChanged(int i1)
            {
            }

            public final void onPageScrolled(int i1, float f1, int j1)
            {
            }

            public final void onPageSelected(int i1)
            {
                if (com.picsart.shop.h.a(a) == null) goto _L2; else goto _L1
_L1:
                if (!(com.picsart.shop.h.a(a) instanceof o)) goto _L4; else goto _L3
_L3:
                o o1 = (o)com.picsart.shop.h.a(a);
                if (o1.a != null)
                {
                    o1.a.setOnScrollListener(null);
                    o1.a.stopScroll();
                }
_L2:
                com.picsart.shop.h.a(a, h.b(a).b(i1));
                com.picsart.shop.h.a(a, h.c(a));
                if (!(com.picsart.shop.h.a(a) instanceof o)) goto _L6; else goto _L5
_L5:
                ((o)com.picsart.shop.h.a(a)).a(h.c(a));
                o o2 = (o)com.picsart.shop.h.a(a);
                if (o2.a != null)
                {
                    o2.a.setOnScrollListener(o2.b);
                    o2.a.stopScroll();
                }
_L8:
                return;
_L4:
                if (com.picsart.shop.h.a(a) instanceof f)
                {
                    f f1 = (f)com.picsart.shop.h.a(a);
                    if (f1.a != null)
                    {
                        f1.a.setOnScrollListener(null);
                        f1.a.stopScroll();
                    }
                }
                continue; /* Loop/switch isn't completed */
_L6:
                if (!(com.picsart.shop.h.a(a) instanceof f)) goto _L8; else goto _L7
_L7:
                f f2;
                f2 = (f)com.picsart.shop.h.a(a);
                i1 = h.c(a);
                int j1 = i1 - f2.d;
                f2.d = i1;
                if (j1 != 0 && f2.a != null && f2.a.getLayoutManager() != null)
                {
                    f2.a.post(new f._cls1(f2, i1, j1));
                }
                f2 = (f)com.picsart.shop.h.a(a);
                if (f2.a == null) goto _L8; else goto _L9
_L9:
                f2.a.setOnScrollListener(f2.c);
                f2.a.stopScroll();
                return;
                if (true) goto _L2; else goto _L10
_L10:
            }

            
            {
                a = h.this;
                super();
            }
        });
        return layoutinflater;
    }

    public final void onDetach()
    {
        super.onDetach();
    }

    public final void onPause()
    {
        super.onPause();
    }

    public final void onResume()
    {
        super.onResume();
    }
}
