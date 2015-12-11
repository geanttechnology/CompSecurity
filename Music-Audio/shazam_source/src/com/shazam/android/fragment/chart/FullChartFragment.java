// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.fragment.chart;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.c;
import android.support.v4.app.i;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.shazam.android.activities.streaming.StreamingProviderUpsellDialogActivity;
import com.shazam.android.advert.h.a;
import com.shazam.android.advert.n;
import com.shazam.android.analytics.event.EventAnalyticsFromView;
import com.shazam.android.analytics.event.factory.StoreEventFactory;
import com.shazam.android.analytics.event.factory.StreamingEventFactory;
import com.shazam.android.analytics.session.SessionCancellationPolicy;
import com.shazam.android.analytics.session.SessionConfigurable;
import com.shazam.android.analytics.session.page.ChartConfigurablePage;
import com.shazam.android.analytics.session.page.Page;
import com.shazam.android.fragment.f;
import com.shazam.android.k.b.d;
import com.shazam.android.k.f.ag;
import com.shazam.android.k.f.h;
import com.shazam.android.widget.advert.BannerAdLayout;
import com.shazam.android.widget.player.PlayAllButton;
import com.shazam.c.j;
import com.shazam.i.b.o.c.e;
import com.shazam.i.c.b;
import com.shazam.model.advert.AdvertInfo;
import com.shazam.model.advert.AdvertSiteIdKey;
import com.shazam.model.advert.HardCodedAdvertSiteIdKeys;
import com.shazam.model.analytics.event.DefinedEventParameterKey;
import com.shazam.model.chart.FullChartItem;
import com.shazam.model.store.Store;
import com.shazam.o.k;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FullChartFragment extends f
    implements a, n, SessionCancellationPolicy, SessionConfigurable, com.shazam.p.d.a
{

    private final com.shazam.android.widget.c.f a = com.shazam.i.b.ay.a.a.b();
    private com.shazam.l.d.a aj;
    private com.shazam.android.a.b.a ak;
    private boolean al;
    private PlayAllButton am;
    private View an;
    private final ag h = com.shazam.i.b.o.c.e.b();
    private final EventAnalyticsFromView i = com.shazam.i.b.g.b.a.b();

    public FullChartFragment()
    {
    }

    public static Fragment a(String s, Uri uri, String s1, String s2, String s3, AdvertInfo advertinfo)
    {
        FullChartFragment fullchartfragment = new FullChartFragment();
        fullchartfragment.setArguments(new Bundle());
        fullchartfragment.getArguments().putString("param_chart_title", s);
        s = uri.toString();
        fullchartfragment.getArguments().putString("param_data_url", s);
        fullchartfragment.getArguments().putString("param_page_name", s1);
        fullchartfragment.getArguments().putString("param_screen_origin", s2);
        fullchartfragment.getArguments().putString("param_even_id", s3);
        fullchartfragment.getArguments().putSerializable("param_advert_info", advertinfo);
        return fullchartfragment;
    }

    static View a(FullChartFragment fullchartfragment, View view)
    {
        fullchartfragment.an = view;
        return view;
    }

    static com.shazam.l.d.a a(FullChartFragment fullchartfragment)
    {
        return fullchartfragment.aj;
    }

    private com.shazam.android.k.f.i k()
    {
        com.shazam.android.k.f.i.a a1 = new com.shazam.android.k.f.i.a();
        a1.a = com.shazam.model.analytics.AnalyticsInfo.Builder.a().a(DefinedEventParameterKey.SCREEN_ORIGIN, n()).a(DefinedEventParameterKey.EVENT_ID, q()).b();
        return a1.a();
    }

    private String l()
    {
        return getArguments().getString("param_chart_title");
    }

    private String m()
    {
        return getArguments().getString("param_data_url");
    }

    private String n()
    {
        return getArguments().getString("param_screen_origin");
    }

    private String q()
    {
        return getArguments().getString("param_even_id");
    }

    private Uri r()
    {
        Uri uri = Uri.parse(m());
        return h.a(uri, com.shazam.o.k.a("playlist_title", l()));
    }

    public final Map a()
    {
        return ((AdvertInfo)getArguments().getSerializable("param_advert_info")).targetingParameters;
    }

    public final void a(Uri uri)
    {
        Object obj = null;
        if (an != null)
        {
            obj = an.findViewById(0x7f110204);
            obj = c.a(getActivity(), ((View) (obj)), "coverArt").a();
        }
        a.a(getActivity(), uri, k(), ((Bundle) (obj)));
    }

    public final void a(String s)
    {
        getActivity().setTitle(s);
    }

    public final void a(List list)
    {
        if (ak == null)
        {
            ak = new com.shazam.android.a.b.a(getActivity());
            a(((android.widget.ListAdapter) (ak)));
    /* block-local class not found */
    class a {}

            o().setOnItemClickListener(new a((byte)0));
        }
        ak.a(list);
        list = list.iterator();
        int i1 = 0;
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            Store store = ((FullChartItem)list.next()).store;
            if (store != null && store.key.equals("google"))
            {
                i1++;
            }
        } while (true);
        if (getView() != null)
        {
            i.logEvent(getView(), StoreEventFactory.aggregateImpressionEventForStoreWithKey("google", i1));
        }
    }

    public final void a(Set set)
    {
        i.logEvent(am, StreamingEventFactory.createStreamingLoginUpsellImpression());
        a.a(getActivity(), StreamingProviderUpsellDialogActivity.a(set, r()), k());
    }

    public final void a(boolean flag)
    {
        am.setEnabled(flag);
        am.setVisibility(0);
    /* block-local class not found */
    class b {}

        am.setOnClickListener(new b((byte)0));
    }

    public void configureWith(Page page)
    {
        page = (ChartConfigurablePage)page;
        page.setPageName(getArguments().getString("param_page_name"));
        page.setScreenOrigin(n());
        page.setEventId(q());
        page.setChartTitle(l());
    }

    protected final void d()
    {
        aj.a();
        al = false;
    }

    protected final String e()
    {
        return "chartnetworkerror";
    }

    public final AdvertSiteIdKey f()
    {
        return AdvertSiteIdKey.a(HardCodedAdvertSiteIdKeys.CHARTS_TRACK_LIST);
    }

    public final void h()
    {
        al = true;
        g();
    }

    public boolean isSessionCanceled(Object obj)
    {
        return al;
    }

    public final void j()
    {
        a(r());
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        aj = new com.shazam.l.d.a(this, l(), new d(getLoaderManager(), 10003, getActivity(), com.shazam.android.k.c.a(new com.shazam.android.k.e.a.a(com.shazam.i.c.b.a(), m()), com.shazam.c.j.a(new com.shazam.c.c.b(com.shazam.i.k.c.a.a(new com.shazam.c.o.b()), com.shazam.i.d.d.x()))), com.shazam.android.k.b.i.b), new h(), new com.shazam.android.ao.b(com.shazam.i.b.aj.b.a()), com.shazam.i.b.ad.b.a.a());
        aj.a();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return BannerAdLayout.a(layoutinflater.inflate(0x7f030042, viewgroup, false));
    }

    public void onStop()
    {
        super.onStop();
        aj.b.b();
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        am = (PlayAllButton)view.findViewById(0x7f110147);
        view = am;
        bundle = com.shazam.model.analytics.player.PlayAllButtonAnalyticsInfo.Builder.a();
        bundle.playQueue = l();
        view.a = bundle.b();
    }
}
