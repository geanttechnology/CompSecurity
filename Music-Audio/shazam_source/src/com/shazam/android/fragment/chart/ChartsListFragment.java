// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.fragment.chart;

import android.animation.AnimatorInflater;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ListView;
import com.shazam.android.advert.AdBinderStrategyType;
import com.shazam.android.advert.e;
import com.shazam.android.advert.h.a;
import com.shazam.android.analytics.session.SessionConfigurable;
import com.shazam.android.analytics.session.SessionStrategyType;
import com.shazam.android.analytics.session.fragments.strategy.ConfigurableSessionStrategyType;
import com.shazam.android.analytics.session.page.ChartListPage;
import com.shazam.android.analytics.session.page.Page;
import com.shazam.android.fragment.b;
import com.shazam.android.fragment.d;
import com.shazam.android.p.c;
import com.shazam.android.p.m;
import com.shazam.android.widget.advert.BannerAdLayout;
import com.shazam.c.j;
import com.shazam.model.advert.AdvertSiteIdKey;
import com.shazam.model.advert.HardCodedAdvertSiteIdKeys;
import com.shazam.model.availability.ExploreAvailability;
import com.shazam.model.availability.GooglePlayAndConfigBasedExploreAvailability;
import com.shazam.model.configuration.ChartsConfiguration;
import java.util.List;

// Referenced classes of package com.shazam.android.fragment.chart:
//            a

public class ChartsListFragment extends d
    implements e, a, SessionConfigurable, ConfigurableSessionStrategyType, com.shazam.android.aq.a, com.shazam.p.a
{

    private final m a = new c();
    private ListView b;
    private int c;
    private com.shazam.android.fragment.chart.a d;
    private com.shazam.l.a e;
    private b f;

    public ChartsListFragment()
    {
        f = b.a;
    }

    public static Fragment a(String s, String s1, SessionStrategyType sessionstrategytype, AdBinderStrategyType adbinderstrategytype)
    {
        ChartsListFragment chartslistfragment = new ChartsListFragment();
        chartslistfragment.setArguments(new Bundle());
        chartslistfragment.getArguments().putString("param_even_id", s1);
        chartslistfragment.getArguments().putString("param_screen_origin", s);
        chartslistfragment.getArguments().putSerializable("paramSessionStrategyType", sessionstrategytype);
        chartslistfragment.getArguments().putSerializable("param_ad_binder_strategy_type", adbinderstrategytype);
        return chartslistfragment;
    }

    static ListView a(ChartsListFragment chartslistfragment)
    {
        return chartslistfragment.b;
    }

    public static Fragment d()
    {
        return a(null, null, SessionStrategyType.SELECTED_UNSELECTED_FOCUSED_UNFOCUSED, AdBinderStrategyType.SELECTION);
    }

    public final AdBinderStrategyType a()
    {
        return (AdBinderStrategyType)getArguments().getSerializable("param_ad_binder_strategy_type");
    }

    public final void a(b b1)
    {
        f = b1;
    }

    public final void a(List list)
    {
        if (com.shazam.o.b.a(d.b()))
        {
            d.a(list);
        }
        b.setSelection(c);
    }

    public SessionStrategyType configurableSessionStrategyType()
    {
        java.io.Serializable serializable = getArguments().getSerializable("paramSessionStrategyType");
        if (serializable == null)
        {
            return SessionStrategyType.START_STOP_FOCUSED_UNFOCUSED;
        } else
        {
            return (SessionStrategyType)serializable;
        }
    }

    public void configureWith(Page page)
    {
        page = (ChartListPage)page;
        page.setScreenOrigin(getArguments().getString("param_screen_origin"));
        page.setEventId(getArguments().getString("param_even_id"));
    }

    public final void e()
    {
        View view = LayoutInflater.from(com.shazam.i.b.c.a()).inflate(0x7f03008b, b, false);
    /* block-local class not found */
    class a {}

        view.setOnClickListener(new a(getActivity()));
        if (a.d())
        {
            view.setClipToOutline(true);
            view.setStateListAnimator(AnimatorInflater.loadStateListAnimator(getActivity(), 0x7f040016));
            view.getViewTreeObserver().addOnPreDrawListener(new _cls1(view));
        }
        b.addHeaderView(view);
    }

    public final AdvertSiteIdKey f()
    {
        return AdvertSiteIdKey.a(HardCodedAdvertSiteIdKeys.CHARTS_FEED);
    }

    public String getAgofViewKey()
    {
        return "ShazamAndroidCharts";
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        e = new com.shazam.l.a(this, new GooglePlayAndConfigBasedExploreAvailability(com.shazam.i.b.x.a.a.a(), com.shazam.i.b.n.b.b()), com.shazam.i.b.n.b.F(), j.a(new com.shazam.c.c.a()));
        com.shazam.l.a a1 = e;
        if (a1.b.a())
        {
            a1.a.e();
        }
        b.setAdapter(d);
        if (bundle != null)
        {
            c = bundle.getInt("listPosition");
        }
        f.a(this);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        d = new com.shazam.android.fragment.chart.a(getActivity());
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return BannerAdLayout.a(layoutinflater.inflate(0x7f030043, viewgroup, false));
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        c = b.getFirstVisiblePosition();
        bundle.putInt("listPosition", c);
    }

    public void onStart()
    {
        super.onStart();
        com.shazam.l.a a1 = e;
        a1.a.a((List)a1.d.a(a1.c.b()));
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        b = (ListView)view.findViewById(0x7f11014b);
        boolean flag;
        if (getResources().getConfiguration().orientation == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b.setHeaderDividersEnabled(flag);
    }

    /* member class not found */
    class _cls1 {}

}
