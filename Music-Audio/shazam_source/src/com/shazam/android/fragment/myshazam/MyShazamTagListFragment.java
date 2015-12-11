// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.fragment.myshazam;

import android.content.BroadcastReceiver;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import com.shazam.android.activities.streaming.StreamingProviderUpsellDialogActivity;
import com.shazam.android.analytics.AnalyticsInfoProvider;
import com.shazam.android.analytics.event.EventAnalyticsFromView;
import com.shazam.android.analytics.event.factory.StoreEventFactory;
import com.shazam.android.analytics.event.factory.StreamingEventFactory;
import com.shazam.android.analytics.session.SessionConfigurable;
import com.shazam.android.analytics.session.page.ConfigurablePage;
import com.shazam.android.analytics.session.page.Page;
import com.shazam.android.fragment.f;
import com.shazam.android.fragment.news.m;
import com.shazam.android.k.f.ac;
import com.shazam.android.k.f.ad;
import com.shazam.android.k.f.b.a;
import com.shazam.android.k.f.p;
import com.shazam.android.k.k;
import com.shazam.android.l.y;
import com.shazam.android.receiver.AutoTagMatchedReceiver;
import com.shazam.android.v.e.h;
import com.shazam.android.widget.tagging.i;
import com.shazam.c.j;
import com.shazam.g.e;
import com.shazam.i.b.c;
import com.shazam.i.b.o.b.b;
import com.shazam.model.analytics.AnalyticsInfo;
import com.shazam.model.analytics.ScreenOrigin;
import com.shazam.model.analytics.event.DefinedEventParameterKey;
import com.shazam.model.configuration.ProModeConfiguration;
import com.shazam.model.myshazam.MyShazamTag;
import com.shazam.model.store.Store;
import com.shazam.p.d;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.shazam.android.fragment.myshazam:
//            e, f, j, h

public class MyShazamTagListFragment extends f
    implements AnalyticsInfoProvider, SessionConfigurable, i, d
{

    final com.shazam.android.widget.c.f a = com.shazam.i.b.ay.a.a.b();
    private final com.shazam.android.fragment.b.b aj = com.shazam.i.b.w.a.a.a();
    private final BroadcastReceiver ak = new a((byte)0);
    private final com.shazam.android.k.f.j al = new com.shazam.android.k.f.j();
    private final EventAnalyticsFromView am = com.shazam.i.b.g.b.a.b();
    private final android.widget.AbsListView.OnScrollListener an = new d((byte)0);
    private final com.shazam.android.k.e.i ao = com.shazam.i.b.o.b.b.b();
    private final ac ap = new ad("playlist_my_tags");
    private final ProModeConfiguration aq = com.shazam.i.b.n.b.D();
    private final m ar = new com.shazam.android.fragment.myshazam.e(com.shazam.i.b.n.b.D());
    private com.shazam.l.k.b as;
    private com.shazam.android.a.i.a at;
    private com.shazam.android.widget.tagging.a au;
    private View av;
    private View aw;
    private boolean ax;
    private final Map h;
    private final com.shazam.android.fragment.b.c i = new com.shazam.android.fragment.b.a(com.shazam.i.b.w.a.a.a(), com.shazam.i.b.c.a());

    public MyShazamTagListFragment()
    {
        h = com.shazam.b.b.d.a(a.g, com.shazam.i.b.o.b.b.a(), a.i, com.shazam.i.b.o.b.b.a(new com.shazam.android.k.e.b(new p(), com.shazam.i.b.ah.e.a.a()), com.shazam.c.j.a(com.shazam.i.d.d.b())));
    /* block-local class not found */
    class a {}

    /* block-local class not found */
    class d {}

        au = com.shazam.android.widget.tagging.a.a;
    }

    public static Fragment a(Uri uri, String s1, String s2, boolean flag)
    {
        MyShazamTagListFragment myshazamtaglistfragment = new MyShazamTagListFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("argument_resource_uri", uri);
        bundle.putString("argument_error_page_name", s1);
        bundle.putString("argument_page_name", s2);
        bundle.putBoolean("argument_clear_auto_tags_tab_on_selected", flag);
        myshazamtaglistfragment.setArguments(bundle);
        return myshazamtaglistfragment;
    }

    static boolean a(MyShazamTagListFragment myshazamtaglistfragment)
    {
        return myshazamtaglistfragment.q();
    }

    static com.shazam.android.a.i.a b(MyShazamTagListFragment myshazamtaglistfragment)
    {
        return myshazamtaglistfragment.at;
    }

    static com.shazam.l.k.b c(MyShazamTagListFragment myshazamtaglistfragment)
    {
        return myshazamtaglistfragment.as;
    }

    static boolean d(MyShazamTagListFragment myshazamtaglistfragment)
    {
        return myshazamtaglistfragment.v();
    }

    static com.shazam.android.fragment.b.b e(MyShazamTagListFragment myshazamtaglistfragment)
    {
        return myshazamtaglistfragment.aj;
    }

    static com.shazam.android.fragment.b.c f(MyShazamTagListFragment myshazamtaglistfragment)
    {
        return myshazamtaglistfragment.i;
    }

    static View g(MyShazamTagListFragment myshazamtaglistfragment)
    {
        return myshazamtaglistfragment.av;
    }

    private boolean q()
    {
        return a.g.equals(com.shazam.android.k.f.b.a.a(s()));
    }

    private Uri r()
    {
        return ap.a(s());
    }

    private Uri s()
    {
        return (Uri)getArguments().getParcelable("argument_resource_uri");
    }

    private String t()
    {
        if (aq.a() && !v())
        {
            return "artistmytags";
        } else
        {
            return getArguments().getString("argument_page_name");
        }
    }

    private ScreenOrigin u()
    {
        android.support.v4.app.i i1 = getActivity();
        if (i1 != null)
        {
            return ScreenOrigin.a(com.shazam.android.k.f.j.a(i1.getIntent()).a().a(DefinedEventParameterKey.SCREEN_ORIGIN));
        } else
        {
            return ScreenOrigin.NONE;
        }
    }

    private boolean v()
    {
        return getArguments().getBoolean("argument_clear_auto_tags_tab_on_selected");
    }

    private void w()
    {
        if (v() && !ax)
        {
            getActivity().registerReceiver(ak, AutoTagMatchedReceiver.a(10));
            ax = true;
        }
    }

    public final void a()
    {
        g();
    }

    public final void a(com.shazam.android.widget.tagging.a a1)
    {
        au = a1;
    }

    public final void a(List list)
    {
        at = new com.shazam.android.a.i.a(getActivity(), new com.shazam.android.fragment.myshazam.f(new p(), new y(com.shazam.i.d.d.a()), getLoaderManager()), com.shazam.i.b.z.a.a(), new com.shazam.android.v.f.a(com.shazam.i.b.n.b.D()));
    /* block-local class not found */
    class b {}

        o().setOnItemClickListener(new b((byte)0));
        a(((ListAdapter) (at)));
        at.a(list);
        list = list.iterator();
        int i1 = 0;
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            Store store = ((MyShazamTag)list.next()).store;
            if (store != null && store.key.equals("google"))
            {
                i1++;
            }
        } while (true);
        if (getView() != null)
        {
            am.logEvent(getView(), StoreEventFactory.aggregateImpressionEventForStoreWithKey("google", i1));
        }
    }

    public final void a(Set set)
    {
        am.logEvent(aw, StreamingEventFactory.createStreamingLoginUpsellImpression());
        a.a(getActivity(), StreamingProviderUpsellDialogActivity.a(set, r()), f());
    }

    public void configureWith(Page page)
    {
        page = (ConfigurablePage)page;
        page.setPageName(t());
        page.setScreenOrigin(u().value);
    }

    protected final void d()
    {
        as.a();
    }

    protected final String e()
    {
        return getArguments().getString("argument_error_page_name");
    }

    public final com.shazam.android.k.f.i f()
    {
        com.shazam.android.k.f.i.a a1 = new com.shazam.android.k.f.i.a();
        a1.a = com.shazam.model.analytics.AnalyticsInfo.Builder.a().a(DefinedEventParameterKey.SCREEN_ORIGIN, u().value).b();
        return a1.a();
    }

    public AnalyticsInfo getAnalyticsInfo()
    {
        return com.shazam.model.analytics.AnalyticsInfo.Builder.a().a(DefinedEventParameterKey.SCREEN_NAME, t()).a(DefinedEventParameterKey.SCREEN_ORIGIN, u().value).b();
    }

    public final void h()
    {
        av.setVisibility(0);
        aw.setEnabled(false);
    }

    public final void j()
    {
        aw.setEnabled(true);
    }

    public final void k()
    {
        at.notifyDataSetChanged();
    }

    public final void l()
    {
        a.a(getActivity(), r());
    }

    public final void m()
    {
        av.setVisibility(8);
    }

    public final void n()
    {
        com.shazam.android.activities.b.b.b(getActivity());
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        a(false, true);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getLoaderManager();
        android.support.v4.app.i i1 = getActivity();
        as = new com.shazam.l.k.b(this, q(), new com.shazam.android.k.b.p(i1, bundle, 10002, (k)h.get(com.shazam.android.k.f.b.a.a(s())), com.shazam.android.k.b.i.b), new h(bundle, i1, ao), new com.shazam.android.v.e.f(bundle, i1, com.shazam.i.c.b.a(), com.shazam.i.b.n.b.E(), com.shazam.i.d.d.B(), new com.shazam.k.k(com.shazam.i.l.d.a())), com.shazam.i.d.d.I(), com.shazam.i.b.ad.b.a.a());
        ar.a();
        as.a();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f03004e, viewgroup, false);
    }

    public void onDestroy()
    {
        as.c.b();
        super.onDestroy();
    }

    public void onSelected()
    {
        super.onSelected();
        if (getParentFragment() instanceof com.shazam.android.fragment.myshazam.j)
        {
            com.shazam.android.fragment.myshazam.j j1 = (com.shazam.android.fragment.myshazam.j)getParentFragment();
            boolean flag;
            if (super.b == null || super.b.getCount() == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                j1.d();
            } else
            {
                j1.a(o());
            }
        }
        w();
        if (v())
        {
            i.a();
        }
        au.a();
        if (as != null)
        {
            as.b();
        }
    }

    public void onStart()
    {
        super.onStart();
        if (getParentFragment() instanceof com.shazam.android.fragment.myshazam.j)
        {
            ((com.shazam.android.fragment.myshazam.j)getParentFragment()).a(new View[] {
                o(), super.d, super.e
            });
        }
        w();
        ((com.shazam.android.fragment.myshazam.h)getParentFragment()).e();
        if (ar.b())
        {
            ar.a();
            as.a();
        }
    }

    public void onUnselected()
    {
        super.onUnselected();
        if (ax)
        {
            getActivity().unregisterReceiver(ak);
            ax = false;
        }
        if (p())
        {
            au.b(o(), new android.widget.AbsListView.OnScrollListener[0]);
        }
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        aw = view.findViewById(0x7f110147);
        av = view.findViewById(0x7f110170);
    /* block-local class not found */
    class c {}

        aw.setOnClickListener(new c((byte)0));
        o().setOnScrollListener(an);
        int i1 = (int)(getResources().getDimension(0x7f0a009f) + getResources().getDimension(0x7f0a003c) + getResources().getDimension(0x7f0a003d));
        o().setPadding(o().getPaddingLeft(), o().getPaddingTop(), o().getPaddingRight(), i1);
    }
}
