// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.fragment.myshazam;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.k;
import android.support.v4.app.m;
import android.support.v4.view.t;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.shazam.android.a.c;
import com.shazam.android.analytics.AnalyticsInfoProvider;
import com.shazam.android.fragment.d;
import com.shazam.android.widget.advert.BannerAdLayout;
import com.shazam.android.widget.feed.FeedRecyclerView;
import com.shazam.android.widget.myshazam.ListAwareLinearLayout;
import com.shazam.android.widget.page.NotifyingViewPager;
import com.shazam.android.widget.slidingtabs.SlidingTabLayout;
import com.shazam.i.b.ah.f;
import com.shazam.i.b.n.b;
import com.shazam.model.account.UserState;
import com.shazam.model.advert.AdvertSiteIdKey;
import com.shazam.model.advert.HardCodedAdvertSiteIdKeys;
import com.shazam.model.analytics.AnalyticsInfo;
import com.shazam.model.configuration.SignUpConfiguration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.shazam.android.fragment.myshazam:
//            h, j, b

public class a extends d
    implements com.shazam.android.advert.h.a, AnalyticsInfoProvider, com.shazam.android.aq.a, h, j
{

    public NotifyingViewPager a;
    private c aj;
    private boolean ak;
    private com.shazam.android.fragment.b al;
    private final String b = "MY_SHAZAM_HEADER";
    private final com.shazam.k.t c = com.shazam.i.b.ad.a.a.a();
    private final com.shazam.android.persistence.n.b d = com.shazam.i.b.ah.f.a();
    private final SignUpConfiguration e = com.shazam.i.b.n.b.P();
    private final a f = new a((byte)0);
    private View g;
    private ListAwareLinearLayout h;
    private SlidingTabLayout i;

    public a()
    {
    /* block-local class not found */
    class a {}

        al = com.shazam.android.fragment.b.a;
    }

    static c a(a a1)
    {
        return a1.aj;
    }

    private com.shazam.android.fragment.myshazam.b g()
    {
        return (com.shazam.android.fragment.myshazam.b)getChildFragmentManager().a("MY_SHAZAM_HEADER");
    }

    private Fragment h()
    {
        return aj.c(a.getCurrentItem());
    }

    public final void a()
    {
        aj = new c(com.shazam.i.b.w.d.a.a(), getResources(), getChildFragmentManager(), true);
        a.setAdapter(aj);
        i.setOnPageChangeListener(f);
        i.setViewPager(a);
        int l = a.getAdapter().c();
        SlidingTabLayout slidingtablayout = i;
        if (l < 2)
        {
            l = 8;
        } else
        {
            l = 0;
        }
        slidingtablayout.setVisibility(l);
    }

    public final void a(ViewGroup viewgroup)
    {
        if (h == null) goto _L2; else goto _L1
_L1:
        ListAwareLinearLayout listawarelinearlayout;
        int l;
        listawarelinearlayout = h;
        l = 0;
        if (!(viewgroup instanceof AbsListView)) goto _L4; else goto _L3
_L3:
        l = ((AbsListView)viewgroup).getFirstVisiblePosition();
_L6:
        listawarelinearlayout.a(l, viewgroup, true);
_L2:
        return;
_L4:
        if (viewgroup instanceof FeedRecyclerView)
        {
            l = ((FeedRecyclerView)viewgroup).getFirstVisiblePosition();
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final void a(com.shazam.android.fragment.b b1)
    {
        al = b1;
    }

    public final transient void a(View aview[])
    {
        if (h != null)
        {
            ListAwareLinearLayout listawarelinearlayout = h;
            listawarelinearlayout.b.clear();
            Collections.addAll(listawarelinearlayout.b, aview);
            aview = listawarelinearlayout.b.iterator();
            while (aview.hasNext()) 
            {
                View view = (View)aview.next();
                if (view instanceof AbsListView)
                {
                    AbsListView abslistview = (AbsListView)view;
                    abslistview.setOnScrollListener(listawarelinearlayout.c);
                    abslistview.setClipToPadding(false);
                    abslistview.setScrollBarStyle(0x2000000);
                    if (!listawarelinearlayout.a.contains(abslistview))
                    {
                        listawarelinearlayout.a.add(abslistview);
                    }
                } else
                if (view instanceof FeedRecyclerView)
                {
                    FeedRecyclerView feedrecyclerview = (FeedRecyclerView)view;
                    feedrecyclerview.setOnScrollListener(new com.shazam.android.ad.d.b(new android.support.v7.widget.RecyclerView.l[] {
                        listawarelinearlayout.d, feedrecyclerview.getOnScrollListener()
                    }));
                    feedrecyclerview.setClipToPadding(false);
                    feedrecyclerview.setScrollBarStyle(0x2000000);
                    if (!listawarelinearlayout.a.contains(feedrecyclerview))
                    {
                        listawarelinearlayout.a.add(feedrecyclerview);
                    }
                }
                listawarelinearlayout.a(view);
            }
        }
    }

    public final void d()
    {
        if (h != null)
        {
            Object obj = h;
            AnimatorSet animatorset = new AnimatorSet();
            ArrayList arraylist = new ArrayList();
            animatorset.setDuration(200L).setInterpolator(new android.support.v4.view.b.b());
            arraylist.add(ObjectAnimator.ofFloat(obj, "translationY", new float[] {
                0.0F
            }));
            for (obj = ((ListAwareLinearLayout) (obj)).a.iterator(); ((Iterator) (obj)).hasNext(); arraylist.add(ObjectAnimator.ofFloat((ViewGroup)((Iterator) (obj)).next(), "translationY", new float[] {
    0.0F
}))) { }
            animatorset.playTogether(arraylist);
            animatorset.start();
        }
    }

    public final void e()
    {
        al.a(this);
    }

    public final AdvertSiteIdKey f()
    {
        return AdvertSiteIdKey.a(HardCodedAdvertSiteIdKeys.MY_TAGS);
    }

    public String getAgofViewKey()
    {
        return "ShazamAndroid";
    }

    public AnalyticsInfo getAnalyticsInfo()
    {
        if (h() instanceof AnalyticsInfoProvider)
        {
            return ((AnalyticsInfoProvider)h()).getAnalyticsInfo();
        } else
        {
            return com.shazam.model.analytics.AnalyticsInfo.Builder.a().b();
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        boolean flag;
        if (g != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag && g() == null)
        {
            getChildFragmentManager().a().a(0x7f110174, new com.shazam.android.fragment.myshazam.b(), "MY_SHAZAM_HEADER").a();
        }
        a();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return BannerAdLayout.a(layoutinflater.inflate(0x7f0300c0, viewgroup, false));
    }

    public void onSelected()
    {
        super.onSelected();
        ak = true;
        Object obj = g();
        if (obj != null)
        {
            ((com.shazam.android.fragment.myshazam.b) (obj)).onSelected();
        }
        obj = h();
        if (obj instanceof com.shazam.android.ad.b.b)
        {
            ((com.shazam.android.ad.b.b)obj).onSelected();
        }
        boolean flag;
        if (c.a() == UserState.ANONYMOUS && !d.b("pk_myshazam_signup_promo_displayed") && e.b())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            h.postDelayed(new _cls1(), 500L);
            d.b("pk_myshazam_signup_promo_displayed", true);
        }
    }

    public void onStop()
    {
        super.onStop();
        a.d();
    }

    public void onUnselected()
    {
        super.onUnselected();
        ak = false;
        Fragment fragment = h();
        if (fragment instanceof com.shazam.android.ad.b.b)
        {
            ((com.shazam.android.ad.b.b)fragment).onUnselected();
        }
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        g = view.findViewById(0x7f110174);
        i = (SlidingTabLayout)view.findViewById(0x7f110175);
        a = (NotifyingViewPager)view.findViewById(0x7f110172);
        h = (ListAwareLinearLayout)view.findViewById(0x7f110173);
        view = getResources();
        int l = view.getDimensionPixelSize(0x7f0a00e7);
        i.setSelectedIndicatorThickness(l);
        i.setSelectedIndicatorColors(new int[] {
            view.getColor(0x7f0f007b)
        });
        i.setBottomBorderThickness(0);
        i.setDividerColors(new int[] {
            0
        });
        i.a(0x7f0300a1, 0x7f11024a);
    }

    public void onWindowFocusChanged(boolean flag)
    {
        super.onWindowFocusChanged(flag);
        if (ak)
        {
            Fragment fragment = h();
            if (fragment instanceof com.shazam.android.fragment.c)
            {
                ((com.shazam.android.fragment.c)fragment).onWindowFocusChanged(flag);
            }
        }
    }

    /* member class not found */
    class _cls1 {}

}
