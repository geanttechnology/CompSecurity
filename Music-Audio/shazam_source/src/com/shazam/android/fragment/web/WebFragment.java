// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.fragment.web;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.i;
import android.support.v4.app.k;
import android.support.v4.app.m;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.shazam.android.activities.b.b;
import com.shazam.android.ad.f;
import com.shazam.android.advert.h.a;
import com.shazam.android.analytics.event.AnalyticsInfoFromHierarchy;
import com.shazam.android.analytics.event.EventAnalytics;
import com.shazam.android.analytics.event.factory.FacebookLogInEventFactory;
import com.shazam.android.analytics.session.SessionConfigurable;
import com.shazam.android.analytics.session.page.Page;
import com.shazam.android.analytics.session.page.WebPage;
import com.shazam.android.base.fragments.BaseFragment;
import com.shazam.android.fragment.RetryFragment;
import com.shazam.android.fragment.e;
import com.shazam.android.k.e.x;
import com.shazam.android.util.r;
import com.shazam.android.util.s;
import com.shazam.android.web.bridge.d;
import com.shazam.android.web.bridge.g;
import com.shazam.android.widget.advert.BannerAdLayout;
import com.shazam.i.b.u.c;
import com.shazam.model.advert.AdvertSiteIdKey;
import com.shazam.model.analytics.AnalyticsInfo;
import com.shazam.model.analytics.ScreenOrigin;
import com.shazam.model.analytics.event.DefinedEventParameterKey;
import com.shazam.model.facebook.FacebookConnectionState;
import com.shazam.model.facebook.FacebookLoginErrorSource;
import com.shazam.server.request.account.LinkableThirdParty;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.shazam.android.fragment.web:
//            b

public class WebFragment extends BaseFragment
    implements a, SessionConfigurable, e, d, com.shazam.android.web.e, com.shazam.p.g.a
{

    private com.shazam.l.g.a aj;
    private final com.shazam.android.web.f b;
    private final com.shazam.android.activities.a.d c;
    private boolean d;
    private final FacebookConnectionState e;
    private final com.shazam.android.v.c.a f;
    private final com.shazam.a.a g;
    private final s h;
    private final EventAnalytics i;

    public WebFragment()
    {
        this(com.shazam.i.b.ax.a.a(), ((com.shazam.android.activities.a.d) (new f())));
    }

    public WebFragment(com.shazam.android.web.f f1, com.shazam.android.activities.a.d d1)
    {
        d = true;
        e = com.shazam.i.b.ap.a.c();
        f = com.shazam.i.b.u.c.a();
        g = com.shazam.i.c.a.a();
        h = com.shazam.i.b.au.d.c();
        i = com.shazam.i.b.g.b.a.a();
        b = f1;
        c = d1;
    }

    protected static Bundle a(String s1, String s2, boolean flag, boolean flag1, String s3, String s4, String s5)
    {
        Bundle bundle = new Bundle();
        bundle.putString("url", s1);
        bundle.putString("advertSiteId", s2);
        bundle.putBoolean("useTimeOut", flag);
        bundle.putBoolean("shouldDeliverEmptyTagInfo", flag1);
        bundle.putString("eventId", s3);
        bundle.putString("screenOrigin", s4);
        bundle.putString("adp", s5);
        return bundle;
    }

    public static WebFragment a(String s1, String s2, boolean flag, String s3, String s4, String s5)
    {
        WebFragment webfragment = new WebFragment();
        webfragment.setArguments(a(s1, s2, flag, true, s3, s4, s5));
        return webfragment;
    }

    private void a(Fragment fragment, String s1)
    {
        m m1 = getChildFragmentManager().a();
        m1.b(0x7f1101bf, fragment, s1);
        m1.a(null);
        m1.b();
    }

    protected static void b(ScreenOrigin screenorigin, com.shazam.android.fragment.web.b b1)
    {
        if (b1 != null)
        {
            for (b1 = b1.a(com/shazam/android/web/bridge/g).iterator(); b1.hasNext(); ((g)b1.next()).receiveScreenOrigin(screenorigin)) { }
        }
    }

    private boolean m()
    {
        return getArguments().getBoolean("useTimeOut") && d;
    }

    private String n()
    {
        return getArguments().getString("advertSiteId");
    }

    private String o()
    {
        return getArguments().getString("screenOrigin");
    }

    public final void a()
    {
        Object obj = getResources();
        obj = (new StringBuilder()).append(((Resources) (obj)).getString(0x7f09016b)).append(" ").append(((Resources) (obj)).getString(0x7f0901a9)).toString();
        h.a(r.a(((String) (obj))));
        i.logEvent(FacebookLogInEventFactory.createFacebookConnectUserEvent(com.shazam.android.analytics.event.factory.FacebookLogInEventFactory.FacebookLoginActions.CONNECT_SUCCESS, o(), n()));
    }

    public final void a(WebView webview)
    {
        getActivity().setTitle(webview.getTitle());
        if (m())
        {
            b.a();
            d = false;
            getActivity().setResult(-1);
        }
    }

    public void a(WebPage webpage)
    {
        webpage.setPageName(n());
        String s1 = o();
        if (com.shazam.b.e.a.c(s1))
        {
            webpage.setScreenOrigin(ScreenOrigin.a(s1));
        }
        webpage.setEventId(getArguments().getString("eventId"));
        webpage.setAdProviderIfNotNull(getArguments().getString("adp"));
    }

    protected void a(ScreenOrigin screenorigin, com.shazam.android.fragment.web.b b1)
    {
        b(screenorigin, b1);
    }

    public final void a(FacebookLoginErrorSource facebookloginerrorsource)
    {
        h.a(r.a(0x7f090125));
        i.logEvent(FacebookLogInEventFactory.createFacebookErrorUserEvent(com.shazam.android.analytics.event.factory.FacebookLogInEventFactory.FacebookLoginActions.CONNECT_ERROR, facebookloginerrorsource, o(), n()));
    }

    public void a(String s1, com.shazam.android.web.bridge.d.a a1)
    {
        getActivity().setTitle(s1);
    }

    public final void b()
    {
        i.logEvent(FacebookLogInEventFactory.createFacebookConnectUserEvent(com.shazam.android.analytics.event.factory.FacebookLogInEventFactory.FacebookLoginActions.CONNECT_CANCEL, o(), n()));
    }

    public final void b(FacebookLoginErrorSource facebookloginerrorsource)
    {
        h.a(r.a(0x7f090124));
        i.logEvent(FacebookLogInEventFactory.createFacebookErrorUserEvent(com.shazam.android.analytics.event.factory.FacebookLogInEventFactory.FacebookLoginActions.DISCONNECT_ERROR, facebookloginerrorsource, o(), n()));
    }

    public final void c()
    {
    }

    public void configureWith(Page page)
    {
        a((WebPage)page);
    }

    public final void d()
    {
        com.shazam.android.activities.b.b.a(getActivity(), AnalyticsInfoFromHierarchy.addAnalyticsInfoFromViewHierarchy(getView()).a(DefinedEventParameterKey.SCREEN_NAME), false);
    }

    public void e()
    {
        c.a(getActivity());
    }

    public final AdvertSiteIdKey f()
    {
        com.shazam.model.advert.AdvertSiteIdKey.Builder builder = com.shazam.model.advert.AdvertSiteIdKey.Builder.a();
        builder.siteIdKey = n();
        return builder.b();
    }

    public final void g()
    {
        if (getArguments().getBoolean("useTimeOut"))
        {
            e();
            return;
        } else
        {
            a(RetryFragment.a("webnetworkerror"), "errorTag");
            return;
        }
    }

    public final void h()
    {
        getActivity().setTitle(0x7f09009a);
        if (m())
        {
            b.a(this);
        }
    }

    public final void j()
    {
        if (!e.a())
        {
            i.logEvent(FacebookLogInEventFactory.createFacebookConnectUserEvent(com.shazam.android.analytics.event.factory.FacebookLogInEventFactory.FacebookLoginActions.CONNECT, o(), n()));
            aj.a();
        }
    }

    public final com.shazam.android.fragment.web.b k()
    {
        return (com.shazam.android.fragment.web.b)getChildFragmentManager().a("webContent");
    }

    public final void l()
    {
        i.logEvent(FacebookLogInEventFactory.createFacebookConnectUserEvent(com.shazam.android.analytics.event.factory.FacebookLogInEventFactory.FacebookLoginActions.DISCONNECT_SUCCESS, o(), n()));
    }

    public void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        if (i1 == 64206 || i1 == 5646)
        {
            getChildFragmentManager().a("FacebookLoginFragment").onActivityResult(i1, j1, intent);
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        setHasOptionsMenu(true);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getActivity();
        aj = new com.shazam.l.g.a(this, f.a(bundle), e, com.shazam.i.b.v.b.a(bundle), new com.shazam.android.k.b.a(bundle.getSupportLoaderManager(), 10031, bundle, new x(g, com.shazam.server.request.account.UnlinkThirdPartyRequest.Builder.unlinkThirdPartyRequest().withType(LinkableThirdParty.FACEBOOK.name().toLowerCase(Locale.US)).build()), com.shazam.android.k.b.i.a), com.shazam.i.k.a.b.a());
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        menuinflater.inflate(0x7f13000d, menu);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return BannerAdLayout.a(layoutinflater.inflate(0x7f030061, viewgroup, false));
    }

    public void onDestroy()
    {
        super.onDestroy();
        aj.c();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        int i1 = menuitem.getItemId();
        if (i1 == 0x102002c)
        {
            getActivity().finish();
            return true;
        }
        if (i1 == 0x7f110293)
        {
            t_();
            return true;
        } else
        {
            return false;
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("firstPageYetToLoad", d);
    }

    public void onStart()
    {
        super.onStart();
        a(ScreenOrigin.MISCELLANEOUS_WEB_VIEW, k());
    }

    public void onStop()
    {
        super.onStop();
        b.a();
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        if (bundle == null)
        {
            a(com.shazam.android.fragment.web.b.a(getArguments().getString("url"), getArguments().getBoolean("shouldDeliverEmptyTagInfo")), "webContent");
            return;
        } else
        {
            d = bundle.getBoolean("firstPageYetToLoad");
            return;
        }
    }

    public final void t_()
    {
        if (getChildFragmentManager().a("errorTag") != null)
        {
            getChildFragmentManager().d();
        }
        Fragment fragment = getChildFragmentManager().a(0x7f1101bf);
        if (fragment instanceof com.shazam.android.web.c)
        {
            ((com.shazam.android.web.c)fragment).a();
        }
    }
}
