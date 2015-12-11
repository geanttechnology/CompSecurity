// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.fragment.musicdetails;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.shazam.android.advert.ShazamAdView;
import com.shazam.android.analytics.AnalyticsInfoProvider;
import com.shazam.android.analytics.session.SessionConfigurable;
import com.shazam.android.analytics.session.page.DetailsPage;
import com.shazam.android.analytics.session.page.Page;
import com.shazam.android.aspects.fragments.advert.FragmentAdBinderAspect;
import com.shazam.android.base.fragments.BaseFragment;
import com.shazam.android.c;
import com.shazam.android.k.f.r;
import com.shazam.android.k.f.x;
import com.shazam.android.k.f.z;
import com.shazam.android.util.o;
import com.shazam.android.view.tagging.e;
import com.shazam.android.widget.EnhancedOverScrollView;
import com.shazam.android.widget.advert.BannerAdLayout;
import com.shazam.android.widget.h;
import com.shazam.android.widget.image.d;
import com.shazam.android.widget.modules.ModulesContainerView;
import com.shazam.android.widget.musicdetails.InteractiveInfoView;
import com.shazam.android.widget.musicdetails.MusicDetailsContentAnchorView;
import com.shazam.android.widget.musicdetails.MusicDetailsCoverArtGradientView;
import com.shazam.android.widget.musicdetails.MusicDetailsCoverArtSizeCapturingView;
import com.shazam.android.widget.musicdetails.MusicDetailsCoverArtSnapshotView;
import com.shazam.android.widget.musicdetails.MusicDetailsCoverArtView;
import com.shazam.android.widget.musicdetails.MusicDetailsMetadataView;
import com.shazam.android.widget.musicdetails.g;
import com.shazam.android.widget.p.p;
import com.shazam.android.widget.share.ShareBarView;
import com.shazam.android.widget.tagging.a;
import com.shazam.android.widget.tagging.i;
import com.shazam.model.Tag;
import com.shazam.model.TrackAnalytics;
import com.shazam.model.TrackCategory;
import com.shazam.model.TrackStyle;
import com.shazam.model.advert.AdvertisingInfo;
import com.shazam.model.analytics.AnalyticsInfo;
import com.shazam.model.details.BasicInfo;
import com.shazam.model.details.InteractiveInfo;
import com.shazam.model.details.MusicTrackMetadataInfo;
import com.shazam.model.details.MusicTrackModulesInfo;
import com.shazam.model.module.ModuleRecommendationsExtraData;
import com.shazam.model.module.ModuleVideoExtraData;
import com.shazam.model.player.PlaybackProvider;
import com.shazam.model.share.ShareData;
import com.shazam.model.tooltip.Brand;
import com.shazam.p.b;
import com.xrigau.syncscrolling.view.SynchronizedRelativeLayout;
import java.util.Collection;

// Referenced classes of package com.shazam.android.fragment.musicdetails:
//            a, b, g, i, 
//            k, e, d

public class MusicDetailsFragment extends BaseFragment
    implements AnalyticsInfoProvider, SessionConfigurable, i, b
{

    public ViewGroup a;
    private MusicDetailsCoverArtSnapshotView aj;
    private MusicDetailsCoverArtGradientView ak;
    private MusicDetailsCoverArtSizeCapturingView al;
    private SynchronizedRelativeLayout am;
    private com.shazam.android.fragment.musicdetails.a an;
    private MusicDetailsMetadataView ao;
    private e ap;
    private ShazamAdView aq;
    private InteractiveInfoView ar;
    private ShareBarView as;
    private View at;
    private View au;
    private MusicDetailsContentAnchorView av;
    private a aw;
    public com.shazam.android.o.a b;
    private final c c = new c();
    private TextView e;
    private TextView f;
    private MusicDetailsCoverArtView g;
    private ModulesContainerView h;
    private EnhancedOverScrollView i;

    public MusicDetailsFragment()
    {
        an = com.shazam.android.fragment.musicdetails.a.a;
        aw = a.a;
    }

    static ViewGroup a(MusicDetailsFragment musicdetailsfragment)
    {
        return musicdetailsfragment.a;
    }

    public static MusicDetailsFragment a(Uri uri, r r1, boolean flag, String s, String s1)
    {
        MusicDetailsFragment musicdetailsfragment = new MusicDetailsFragment();
        musicdetailsfragment.setArguments(new Bundle());
        musicdetailsfragment.getArguments().putParcelable("dataUri", uri);
        if (r1 != null)
        {
            musicdetailsfragment.getArguments().putParcelable("shazamUri", r1.a);
        }
        if (flag)
        {
            musicdetailsfragment.getArguments().putBoolean("isDisplayingRecognitionMatch", true);
        }
        musicdetailsfragment.getArguments().putString("eventId", s);
        musicdetailsfragment.getArguments().putString("screenOrigin", s1);
        return musicdetailsfragment;
    }

    static View b(MusicDetailsFragment musicdetailsfragment)
    {
        return musicdetailsfragment.au;
    }

    static EnhancedOverScrollView c(MusicDetailsFragment musicdetailsfragment)
    {
        return musicdetailsfragment.i;
    }

    static e d(MusicDetailsFragment musicdetailsfragment)
    {
        return musicdetailsfragment.ap;
    }

    private String d()
    {
        return getArguments().getString("eventId");
    }

    static a e(MusicDetailsFragment musicdetailsfragment)
    {
        return musicdetailsfragment.aw;
    }

    static View f(MusicDetailsFragment musicdetailsfragment)
    {
        return musicdetailsfragment.at;
    }

    private String g()
    {
        return getArguments().getString("screenOrigin");
    }

    private Uri h()
    {
        return (Uri)getArguments().getParcelable("dataUri");
    }

    private r i()
    {
        Uri uri = (Uri)getArguments().getParcelable("shazamUri");
        r r1;
        try
        {
            r1 = r.b(uri);
        }
        catch (z z1)
        {
            (new StringBuilder("unable to convert uri to ShazamUri: ")).append(uri);
            getActivity().finish();
            return null;
        }
        return r1;
    }

    public final void a()
    {
        b.c();
    }

    public final void a(int i1)
    {
    }

    public final void a(x x)
    {
    }

    public final void a(a a1)
    {
        aw = a1;
    }

    public final void a(Tag tag)
    {
        if (b.a(tag, getArguments().getBoolean("displayFullscreen"), getActivity()))
        {
            ap.f();
        }
    }

    public final void a(TrackAnalytics trackanalytics)
    {
        b.c = trackanalytics;
    }

    public final void a(TrackCategory trackcategory)
    {
        b.a(trackcategory);
    }

    public final void a(TrackStyle trackstyle)
    {
        b.a(trackstyle);
    }

    public final void a(AdvertisingInfo advertisinginfo)
    {
        View view = getView();
        if (view != null && advertisinginfo != null)
        {
            aq = (ShazamAdView)view.findViewById(0x7f110004);
            if (aq != null)
            {
                aw.e();
                Object obj = com.shazam.model.advert.AdvertSiteIdKey.Builder.a();
                obj.siteIdKey = advertisinginfo.siteName;
                obj = ((com.shazam.model.advert.AdvertSiteIdKey.Builder) (obj)).b();
                aq.setAdvertSiteIdKeyProvider(new com.shazam.android.advert.h.b(((com.shazam.model.advert.AdvertSiteIdKey) (obj))));
                aq.setTrackAdvertInfo(advertisinginfo);
                advertisinginfo = aq;
                getActivity();
                advertisinginfo.b();
                FragmentAdBinderAspect.notifyFabOfAdVisibility(this, FragmentAdBinderAspect.isAdVisible(view));
            }
        }
    }

    public final void a(AnalyticsInfo analyticsinfo)
    {
        b.a(analyticsinfo);
    }

    public final void a(BasicInfo basicinfo)
    {
    }

    public final void a(InteractiveInfo interactiveinfo)
    {
        ar.a(interactiveinfo, null);
    }

    public final void a(MusicTrackMetadataInfo musictrackmetadatainfo)
    {
        b.a(musictrackmetadatainfo);
    }

    public final void a(MusicTrackModulesInfo musictrackmodulesinfo)
    {
        b.a(musictrackmodulesinfo);
    }

    public final void a(ModuleRecommendationsExtraData modulerecommendationsextradata)
    {
        b.a(modulerecommendationsextradata);
    }

    public final void a(ModuleVideoExtraData modulevideoextradata)
    {
        b.a(modulevideoextradata);
    }

    public final void a(PlaybackProvider playbackprovider, String s)
    {
        b.a(playbackprovider, s, getActivity());
    }

    public final void a(ShareData sharedata)
    {
        b.a(sharedata, as);
    }

    public final void a(Brand brand)
    {
        b.a(brand, ar, getActivity());
    }

    public final void a(String s)
    {
        b.a(s, getFragmentManager(), g(), h());
    }

    public final void a(Collection collection)
    {
        b.a(collection);
    }

    public final void b()
    {
    }

    public final void b(BasicInfo basicinfo)
    {
        if (!basicinfo.hideMetaData)
        {
            e.setText(basicinfo.title);
            f.setText(com.shazam.b.e.a.d(basicinfo.artist));
            ak.setEnabled(true);
            aj.setGradientEnabled(true);
        }
        g.setVisibility(0);
        g.setImageResource(0x7f0201ac);
        basicinfo = g.a(basicinfo.coverArt);
        basicinfo.g = 0x7f0201ac;
        basicinfo.f = d.b;
        basicinfo.e = 0x7f0200c3;
        basicinfo.c();
    }

    public final void b(Brand brand)
    {
        b.b(brand, getActivity());
    }

    public final void c(Brand brand)
    {
        b.a(brand, getActivity());
    }

    public void configureWith(Page page)
    {
        page = (DetailsPage)page;
        b.a(page, h(), d(), g());
    }

    public final void e()
    {
        b.e();
    }

    public final void f()
    {
        b.d();
        g.setVisibility(0);
        ak.setVisibility(0);
        i.setVisibility(0);
        i.getViewTreeObserver().addOnPreDrawListener(new _cls1());
    }

    public AnalyticsInfo getAnalyticsInfo()
    {
        return com.shazam.android.o.a.a(g(), d());
    }

    public final void j()
    {
    }

    public final void k()
    {
    }

    public final boolean l()
    {
        return b.a(getActivity());
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        bundle = i();
        b = new com.shazam.android.o.a(h, ao, bundle);
        b.b = com.shazam.i.n.b.a.a(bundle, h(), this, getFragmentManager(), getLoaderManager(), new com.shazam.g.d.a(), getArguments().getBoolean("isDisplayingRecognitionMatch"), getActivity(), com.shazam.i.a.a.a());
        setHasOptionsMenu(true);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        if (!(activity instanceof com.shazam.android.fragment.g.c))
        {
            throw new RuntimeException((new StringBuilder()).append(activity.getClass().getSimpleName()).append(" must implement ").append(com/shazam/android/fragment/g/c.getSimpleName()).toString());
        }
        if (!(activity instanceof e))
        {
            throw new RuntimeException((new StringBuilder()).append(activity.getClass().getSimpleName()).append(" must implement ").append(com/shazam/android/view/tagging/e.getSimpleName()).toString());
        }
        ap = (e)activity;
        if (activity instanceof com.shazam.android.fragment.musicdetails.a)
        {
            an = (com.shazam.android.fragment.musicdetails.a)activity;
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        com.shazam.i.b.ay.j.c.a().a();
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        super.onCreateOptionsMenu(menu, menuinflater);
        b.a(menu, menuinflater, 0x7f130009);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return BannerAdLayout.a(layoutinflater.inflate(0x7f03004c, viewgroup, false));
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        i.a = h.a;
        if (aq != null)
        {
            ShazamAdView shazamadview = aq;
            getActivity();
            shazamadview.f();
        }
        e = null;
        f = null;
        g = null;
        h = null;
        i = null;
        aj = null;
        ak = null;
        al = null;
        am = null;
        ao = null;
        aq = null;
        ar = null;
        a = null;
        au = null;
        av = null;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        super.onOptionsItemSelected(menuitem);
        return b.a(menuitem, getActivity().getSupportFragmentManager());
    }

    public void onPause()
    {
        super.onPause();
        boolean flag = b.b.I;
        getArguments().putBoolean("hasDisplayedAnyTooltip", flag);
        flag = b.b.J;
        getArguments().putBoolean("hasDisplayedPublisher", flag);
        flag = b.b.K;
        getArguments().putBoolean("hasDisplayedFacebookInviteFriendsDialog", flag);
        b.b();
        ar.a();
        if (aq != null)
        {
            ShazamAdView shazamadview = aq;
            getActivity();
            shazamadview.d();
        }
    }

    public void onResume()
    {
        super.onResume();
        b.a();
    }

    public void onStart()
    {
        super.onStart();
        b.a(getArguments().getBoolean("hasDisplayedAnyTooltip"), getArguments().getBoolean("hasDisplayedPublisher"), getArguments().getBoolean("hasDisplayedFacebookInviteFriendsDialog"));
    }

    public void onStop()
    {
        super.onStop();
        if (aq != null)
        {
            getActivity();
            ShazamAdView.e();
        }
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        a = (ViewGroup)view.findViewById(0x7f110161);
        au = view.findViewById(0x7f1100c4);
        av = (MusicDetailsContentAnchorView)view.findViewById(0x7f110168);
        e = (TextView)view.findViewById(0x7f1100e9);
        f = (TextView)view.findViewById(0x7f1100ea);
        g = (MusicDetailsCoverArtView)view.findViewById(0x7f1100e8);
        ak = (MusicDetailsCoverArtGradientView)view.findViewById(0x7f110162);
        aj = (MusicDetailsCoverArtSnapshotView)view.findViewById(0x7f11016a);
        ar = (InteractiveInfoView)view.findViewById(0x7f1100e6);
        as = (ShareBarView)view.findViewById(0x7f1100ed);
        at = view.findViewById(0x7f110169);
        h = (ModulesContainerView)view.findViewById(0x7f1100ef);
        al = (MusicDetailsCoverArtSizeCapturingView)view.findViewById(0x7f110167);
        i = (EnhancedOverScrollView)view.findViewById(0x7f1100e3);
        am = (SynchronizedRelativeLayout)view.findViewById(0x7f110164);
        ao = (MusicDetailsMetadataView)view.findViewById(0x7f1100f0);
        view = new com.shazam.android.fragment.musicdetails.b(an);
        bundle = com.shazam.android.fragment.musicdetails.g.a(h);
        com.shazam.android.fragment.musicdetails.i i1 = new com.shazam.android.fragment.musicdetails.i(new View[] {
            g, ak, al
        });
        k k1 = com.shazam.android.fragment.musicdetails.k.a(new View[] {
            g, ak
        });
        am.setPositionFixedThreshold(o.a(getActivity()));
        am.setViewPositionFixedListener(com.shazam.android.fragment.musicdetails.e.a(new com.xrigau.syncscrolling.view.SynchronizedRelativeLayout.a[] {
            view, g
        }));
        com.shazam.android.widget.musicdetails.a a1 = com.shazam.android.widget.musicdetails.a.a(a);
        i.setOverScrollListener(com.shazam.android.fragment.musicdetails.d.a(new h[] {
            view, bundle, k1, g, ak, com.shazam.android.widget.musicdetails.g.a(new View[] {
                ak, e, f
            }), a1
        }));
        i.a(bundle);
        g.setSnapshotView(aj);
        g.setBackgroundAdder(a1);
        g.setCoverArtSizeListener(com.shazam.android.widget.musicdetails.b.a(new com.shazam.android.widget.musicdetails.c[] {
            aj, al, av, ak, i1, k1
        }));
        ak.setEnabled(false);
        aj.setEnabled(false);
        g.setImageDrawable(getResources().getDrawable(0x7f0201ac));
    /* block-local class not found */
    class a {}

        as.setVisibilityChangedListener(new a((byte)0));
    }

    /* member class not found */
    class _cls1 {}

}
