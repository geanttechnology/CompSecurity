// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.k;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.PathInterpolator;
import android.widget.TextView;
import at.markushi.ui.RevealColorView;
import com.shazam.android.ad.a.h;
import com.shazam.android.advert.ShazamAdView;
import com.shazam.android.af.a.a;
import com.shazam.android.analytics.AnalyticsInfoProvider;
import com.shazam.android.analytics.JustDoneRecognitionTaggedBeaconSender;
import com.shazam.android.analytics.session.SessionConfigurable;
import com.shazam.android.analytics.session.page.DetailsPage;
import com.shazam.android.analytics.session.page.Page;
import com.shazam.android.aspects.activities.MiniTaggingActivityAspect;
import com.shazam.android.aspects.activities.advert.ActivityAdBinderAspect;
import com.shazam.android.base.activities.BaseAppCompatActivity;
import com.shazam.android.fragment.RetryFragment;
import com.shazam.android.fragment.e;
import com.shazam.android.fragment.g.c;
import com.shazam.android.k.f.j;
import com.shazam.android.k.f.l;
import com.shazam.android.k.f.r;
import com.shazam.android.k.f.s;
import com.shazam.android.k.f.x;
import com.shazam.android.p.m;
import com.shazam.android.service.player.MusicPlayerService;
import com.shazam.android.util.f;
import com.shazam.android.widget.advert.AdOverlayView;
import com.shazam.android.widget.image.UrlCachingImageView;
import com.shazam.android.widget.image.d.a.g;
import com.shazam.android.widget.modules.ModulesContainerView;
import com.shazam.android.widget.musicdetails.InteractiveInfoView;
import com.shazam.android.widget.musicdetails.MusicDetailsMetadataView;
import com.shazam.android.widget.scroll.ObservableScrollView;
import com.shazam.android.widget.share.ShareBarView;
import com.shazam.android.widget.tagging.i;
import com.shazam.b.b.d;
import com.shazam.model.Tag;
import com.shazam.model.TrackAnalytics;
import com.shazam.model.TrackCategory;
import com.shazam.model.TrackStyle;
import com.shazam.model.advert.AdvertisingInfo;
import com.shazam.model.analytics.AnalyticsInfo;
import com.shazam.model.analytics.TaggedBeaconSender;
import com.shazam.model.analytics.event.DefinedEventParameterKey;
import com.shazam.model.details.AddAction;
import com.shazam.model.details.BasicInfo;
import com.shazam.model.details.InteractiveInfo;
import com.shazam.model.details.MusicTrackMetadataInfo;
import com.shazam.model.details.MusicTrackModulesInfo;
import com.shazam.model.module.ModuleRecommendationsExtraData;
import com.shazam.model.module.ModuleVideoExtraData;
import com.shazam.model.player.PlaybackProvider;
import com.shazam.model.preview.PlayerState;
import com.shazam.model.share.ShareData;
import com.shazam.model.tooltip.Brand;
import com.shazam.p.b;
import java.util.Collection;
import java.util.Map;

// Referenced classes of package com.shazam.android.activities:
//            a

public class MusicDetailsV3Activity extends BaseAppCompatActivity
    implements android.support.v7.c.c.c, h, com.shazam.android.af.a.a, AnalyticsInfoProvider, SessionConfigurable, e, com.shazam.android.fragment.g.c, com.shazam.android.widget.scroll.a, i, com.shazam.p.b
{
    private final class a
        implements com.shazam.android.widget.advert.AdOverlayView.a
    {

        final MusicDetailsV3Activity a;

        public final void a()
        {
            com.shazam.android.activities.MusicDetailsV3Activity.e(a).b();
            com.shazam.android.activities.MusicDetailsV3Activity.c(a).setShouldScroll(false);
        }

        public final void b()
        {
            com.shazam.android.activities.MusicDetailsV3Activity.e(a).a();
            com.shazam.android.activities.MusicDetailsV3Activity.c(a).setShouldScroll(true);
        }

        private a()
        {
            a = MusicDetailsV3Activity.this;
            super();
        }

        a(byte byte0)
        {
            this();
        }
    }

    private final class b
        implements android.view.ViewTreeObserver.OnPreDrawListener
    {

        final MusicDetailsV3Activity a;

        public final boolean onPreDraw()
        {
            com.shazam.android.activities.MusicDetailsV3Activity.f(a).getViewTreeObserver().removeOnPreDrawListener(this);
            if (com.shazam.android.activities.MusicDetailsV3Activity.g(a))
            {
                com.shazam.android.activities.MusicDetailsV3Activity.c(a).a(com.shazam.android.widget.scroll.b.a(com.shazam.android.activities.MusicDetailsV3Activity.f(a), a.findViewById(0x7f1100b0), a));
                com.shazam.android.activities.MusicDetailsV3Activity.c(a).a(a. new d((byte)0));
                com.shazam.android.activities.MusicDetailsV3Activity.c(a).a(new a(this, (byte)0));
            }
            com.shazam.android.activities.MusicDetailsV3Activity.d(a).setMinOffsetY(com.shazam.android.activities.MusicDetailsV3Activity.h(a).getHeight() + com.shazam.android.activities.MusicDetailsV3Activity.f(a).getHeight());
            return true;
        }

        private b()
        {
            a = MusicDetailsV3Activity.this;
            super();
        }

        b(byte byte0)
        {
            this();
        }
    }

    private final class b.a
        implements com.shazam.android.widget.scroll.ObservableScrollView.a
    {

        final b a;

        public final void a(ObservableScrollView observablescrollview, int i1, int j1)
        {
            if (j1 != 0)
            {
                com.shazam.android.activities.MusicDetailsV3Activity.d(a.a).requestLayout();
            }
        }

        private b.a(b b1)
        {
            a = b1;
            super();
        }

        b.a(b b1, byte byte0)
        {
            this(b1);
        }
    }

    private final class c
        implements com.shazam.android.ad.d.d
    {

        final MusicDetailsV3Activity a;

        public final void a(int i1)
        {
            int k1 = 0x7f1100e7;
            if (a.findViewById(0x7f1100e7) != null)
            {
                android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)com.shazam.android.activities.MusicDetailsV3Activity.m(a).getLayoutParams();
                int j1;
                if (i1 == 8)
                {
                    j1 = 0x7f1100e7;
                } else
                {
                    j1 = 0x7f1100e6;
                }
                layoutparams.addRule(8, j1);
                layoutparams = (android.widget.RelativeLayout.LayoutParams)MusicDetailsV3Activity.n(a).getLayoutParams();
                if (i1 == 8)
                {
                    i1 = k1;
                } else
                {
                    i1 = 0x7f1100e6;
                }
                layoutparams.addRule(3, i1);
            }
        }

        private c()
        {
            a = MusicDetailsV3Activity.this;
            super();
        }

        c(byte byte0)
        {
            this();
        }
    }

    private final class d
        implements com.shazam.android.widget.scroll.ObservableScrollView.a
    {

        final MusicDetailsV3Activity a;
        private final int b;
        private final int c;

        public final void a(ObservableScrollView observablescrollview, int i1, int j1)
        {
            float f1 = Math.min(1.0F, (float)Math.max(0, i1 - b) / (float)c);
            com.shazam.android.activities.MusicDetailsV3Activity.h(a).setBackgroundColor(com.shazam.android.activities.MusicDetailsV3Activity.k(a) & 0xffffff | (int)(255F * f1) << 24);
            com.shazam.android.activities.MusicDetailsV3Activity.l(a).setAlpha(f1);
        }

        private d()
        {
            a = MusicDetailsV3Activity.this;
            super();
            b = com.shazam.android.util.h.b.a(8);
            c = (com.shazam.android.activities.MusicDetailsV3Activity.i(a).getHeight() + com.shazam.android.activities.MusicDetailsV3Activity.j(a).getHeight()) - b;
        }

        d(byte byte0)
        {
            this();
        }
    }


    public static final Map a;
    public static final Map b;
    public static final Map c;
    private InteractiveInfoView A;
    private ShareBarView B;
    private View C;
    private AdOverlayView D;
    private com.shazam.android.widget.tagging.a E;
    private RevealColorView F;
    private Toolbar G;
    private boolean H;
    private com.shazam.android.k.f.i I;
    private int J;
    private int K;
    private boolean L;
    private com.f.a.a M;
    private boolean N;
    private boolean O;
    private com.shazam.android.o.a P;
    private com.shazam.l.e.b Q;
    private final com.shazam.android.aj.b e = com.shazam.i.b.af.a.a();
    private final m f = new com.shazam.android.p.c();
    private final l g = com.shazam.i.b.o.c.a.a();
    private final com.shazam.android.c h = new com.shazam.android.c();
    private final j i = new j();
    private final com.shazam.android.util.m j = com.shazam.i.b.au.c.a();
    private final boolean k;
    private final com.shazam.android.widget.c.d l = com.shazam.i.b.ay.a.a.a();
    private final com.shazam.android.b.a m = com.shazam.i.b.h.a.a();
    private final BroadcastReceiver n = new BroadcastReceiver() {

        final MusicDetailsV3Activity a;

        public final void onReceive(Context context, Intent intent)
        {
            context = (PlayerState)intent.getSerializableExtra("extraNewMusicPlayerState");
            com.shazam.android.activities.MusicDetailsV3Activity.a(a).a(context);
        }

            
            {
                a = MusicDetailsV3Activity.this;
                super();
            }
    };
    private final Runnable o = new Runnable() {

        final MusicDetailsV3Activity a;

        public final void run()
        {
            com.shazam.android.activities.MusicDetailsV3Activity.b(a);
        }

            
            {
                a = MusicDetailsV3Activity.this;
                super();
            }
    };
    private final com.shazam.android.widget.advert.AdOverlayView.a p = new a((byte)0);
    private final TaggedBeaconSender q = new JustDoneRecognitionTaggedBeaconSender(com.shazam.i.b.g.b.a());
    private final com.shazam.a.g r = com.shazam.i.c.b.a();
    private TextView s;
    private TextView t;
    private UrlCachingImageView u;
    private ModulesContainerView v;
    private ObservableScrollView w;
    private MusicDetailsMetadataView x;
    private TextView y;
    private TextView z;

    public MusicDetailsV3Activity()
    {
        k = f.d();
        E = com.shazam.android.widget.tagging.a.a;
        H = true;
    }

    static com.shazam.l.e.b a(MusicDetailsV3Activity musicdetailsv3activity)
    {
        return musicdetailsv3activity.Q;
    }

    private void a(View view, int i1, int j1)
    {
        ValueAnimator valueanimator = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[] {
            Integer.valueOf(i1), Integer.valueOf(j1)
        });
        valueanimator.setDuration(200L);
        valueanimator.setInterpolator(new android.support.v4.view.b.b());
        valueanimator.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener(view) {

            final View a;
            final MusicDetailsV3Activity b;

            public final void onAnimationUpdate(ValueAnimator valueanimator1)
            {
                a.setBackgroundColor(((Integer)valueanimator1.getAnimatedValue()).intValue());
            }

            
            {
                b = MusicDetailsV3Activity.this;
                a = view;
                super();
            }
        });
        valueanimator.start();
    }

    static void b(MusicDetailsV3Activity musicdetailsv3activity)
    {
        musicdetailsv3activity.p();
    }

    static ObservableScrollView c(MusicDetailsV3Activity musicdetailsv3activity)
    {
        return musicdetailsv3activity.w;
    }

    static AdOverlayView d(MusicDetailsV3Activity musicdetailsv3activity)
    {
        return musicdetailsv3activity.D;
    }

    static com.shazam.android.widget.tagging.a e(MusicDetailsV3Activity musicdetailsv3activity)
    {
        return musicdetailsv3activity.E;
    }

    static InteractiveInfoView f(MusicDetailsV3Activity musicdetailsv3activity)
    {
        return musicdetailsv3activity.A;
    }

    static boolean g(MusicDetailsV3Activity musicdetailsv3activity)
    {
        return musicdetailsv3activity.N;
    }

    static Toolbar h(MusicDetailsV3Activity musicdetailsv3activity)
    {
        return musicdetailsv3activity.G;
    }

    static TextView i(MusicDetailsV3Activity musicdetailsv3activity)
    {
        return musicdetailsv3activity.s;
    }

    static TextView j(MusicDetailsV3Activity musicdetailsv3activity)
    {
        return musicdetailsv3activity.t;
    }

    static int k(MusicDetailsV3Activity musicdetailsv3activity)
    {
        return musicdetailsv3activity.J;
    }

    static TextView l(MusicDetailsV3Activity musicdetailsv3activity)
    {
        return musicdetailsv3activity.y;
    }

    static RevealColorView m(MusicDetailsV3Activity musicdetailsv3activity)
    {
        return musicdetailsv3activity.F;
    }

    private r m()
    {
        return com.shazam.android.k.f.r.a(g.a(getIntent().getData()));
    }

    static ShareBarView n(MusicDetailsV3Activity musicdetailsv3activity)
    {
        return musicdetailsv3activity.B;
    }

    private String n()
    {
        return I.a().a(DefinedEventParameterKey.EVENT_ID);
    }

    private String o()
    {
        return I.a().a(DefinedEventParameterKey.SCREEN_ORIGIN);
    }

    private void p()
    {
        InteractiveInfoView interactiveinfoview = A;
        int i1;
        if (N)
        {
            i1 = K;
        } else
        {
            i1 = J;
        }
        interactiveinfoview.setBackgroundColor(i1);
        if (k)
        {
            getWindow().setStatusBarColor(K);
            return;
        } else
        {
            int j1 = K;
            M.a();
            M.a(j1);
            return;
        }
    }

    public final View a(View view)
    {
        View view1 = view.findViewById(0x7f1100f0);
        if (view1 == null)
        {
            return view;
        } else
        {
            return view1;
        }
    }

    public final void a()
    {
        P.c();
    }

    public final void a(int i1)
    {
        String s1 = j.a(i1);
        z.setText(getString(0x7f09011b, new Object[] {
            s1
        }));
        z.setAlpha(0.0F);
        z.setVisibility(0);
        z.animate().alpha(1.0F);
    }

    public final void a(android.support.v7.c.c c1)
    {
        J = com.shazam.android.util.f.a(c1, getResources().getColor(0x7f0f007b));
        c1 = new float[3];
        Color.colorToHSV(J, c1);
        c1[2] = c1[2] - 0.12F;
        K = Color.HSVToColor(c1);
        (new com.shazam.android.activities.a(u, F, o)).a(J, L);
    }

    public final volatile void a(View view, int i1)
    {
        P.a(i1);
    }

    public final void a(x x1)
    {
        x1 = new Intent("android.intent.action.VIEW", x1.a());
        MiniTaggingActivityAspect.copyStateFrom(this, x1);
        if (com.shazam.android.c.a(this))
        {
            com.shazam.android.c.a(x1);
        }
        overridePendingTransition(0x7f040010, 0x7f040014);
        l.a(this, x1, com.shazam.android.k.f.j.a(getIntent()));
        finish();
    }

    public final void a(com.shazam.android.widget.tagging.a a1)
    {
        E = a1;
    }

    public final void a(Tag tag)
    {
        P.a(tag, H, this);
    }

    public final void a(TrackAnalytics trackanalytics)
    {
        P.c = trackanalytics;
    }

    public final void a(TrackCategory trackcategory)
    {
        P.a(trackcategory);
    }

    public final void a(TrackStyle trackstyle)
    {
        P.a(trackstyle);
    }

    public final void a(AdvertisingInfo advertisinginfo)
    {
        Object obj = (ShazamAdView)findViewById(0x7f110004);
        if (advertisinginfo == null) goto _L2; else goto _L1
_L1:
        if (obj != null)
        {
            E.e();
            com.shazam.model.advert.AdvertSiteIdKey.Builder builder = com.shazam.model.advert.AdvertSiteIdKey.Builder.a();
            builder.siteIdKey = advertisinginfo.siteName;
            ((ShazamAdView) (obj)).setAdvertSiteIdKeyProvider(new com.shazam.android.advert.h.b(builder.b()));
            ((ShazamAdView) (obj)).setTrackAdvertInfo(advertisinginfo);
            ((ShazamAdView) (obj)).b();
        }
        obj = D;
        obj.d = false;
        Object obj1 = advertisinginfo.previewSiteName;
        if (com.shazam.b.e.a.c(((String) (obj1))))
        {
            com.shazam.model.advert.AdvertSiteIdKey.Builder builder1 = com.shazam.model.advert.AdvertSiteIdKey.Builder.a();
            builder1.siteIdKey = ((String) (obj1));
            obj1 = builder1.b();
            ((AdOverlayView) (obj)).a.setAdvertSiteIdKeyProvider(new com.shazam.android.advert.h.b(((com.shazam.model.advert.AdvertSiteIdKey) (obj1))));
            ((AdOverlayView) (obj)).a.setTrackAdvertInfo(advertisinginfo);
            ((AdOverlayView) (obj)).b.setAdvertSiteIdKeyProvider(new com.shazam.android.advert.h.b(((com.shazam.model.advert.AdvertSiteIdKey) (obj1))));
            ((AdOverlayView) (obj)).b.setTrackAdvertInfo(advertisinginfo);
            obj.d = true;
        }
_L4:
        ActivityAdBinderAspect.notifyFabOfAdVisibility(this, ActivityAdBinderAspect.isAdVisible(this));
        return;
_L2:
        if (obj != null)
        {
            ((ShazamAdView) (obj)).setVisibility(8);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void a(AnalyticsInfo analyticsinfo)
    {
        P.a(analyticsinfo);
    }

    public final void a(BasicInfo basicinfo)
    {
        b(basicinfo);
        C.setVisibility(0);
        Q.a();
    }

    public final void a(InteractiveInfo interactiveinfo)
    {
        A.a(interactiveinfo, null);
    }

    public final void a(MusicTrackMetadataInfo musictrackmetadatainfo)
    {
        P.a(musictrackmetadatainfo);
    }

    public final void a(MusicTrackModulesInfo musictrackmodulesinfo)
    {
        C.setVisibility(8);
        P.a(musictrackmodulesinfo);
    }

    public final void a(ModuleRecommendationsExtraData modulerecommendationsextradata)
    {
        P.a(modulerecommendationsextradata);
    }

    public final void a(ModuleVideoExtraData modulevideoextradata)
    {
        P.a(modulevideoextradata);
    }

    public final void a(PlaybackProvider playbackprovider, String s1)
    {
        P.a(playbackprovider, s1, this);
    }

    public final void a(ShareData sharedata)
    {
        P.a(sharedata, B);
    }

    public final void a(Brand brand)
    {
        P.a(brand, A, this);
    }

    public final void a(String s1)
    {
        P.a(s1, getSupportFragmentManager(), o(), getIntent().getData());
    }

    public final void a(Collection collection)
    {
        P.a(collection);
    }

    public final void b()
    {
        C.setVisibility(8);
        getSupportFragmentManager().a().b(0x7f1100ec, RetryFragment.a(null), "retryFragmentTag").b();
    }

    public final void b(BasicInfo basicinfo)
    {
        if (!basicinfo.hideMetaData)
        {
            String s1 = basicinfo.title;
            android.support.v7.a.a a2 = getSupportActionBar();
            if (a2 != null)
            {
                a2.a(s1);
            }
            s.setText(s1);
            t.setText(basicinfo.artist);
        }
        basicinfo = basicinfo.coverArt;
        com.shazam.android.widget.image.UrlCachingImageView.a a1 = u.a(basicinfo);
        if (!L)
        {
            a1.g = 0x7f0201ad;
        } else
        {
            a1.f = com.shazam.android.widget.image.d.b;
        }
        a1.e = 0x7f0200c3;
        a1.c = new g(basicinfo, this);
        a1.c();
    }

    public final void b(Brand brand)
    {
        P.b(brand, this);
    }

    public final String c()
    {
        return m().c.h;
    }

    public final void c(Brand brand)
    {
        P.a(brand, this);
    }

    public void configureWith(Page page)
    {
        page = (DetailsPage)page;
        P.a(page, getIntent().getData(), n(), o());
    }

    public final void d()
    {
        P.f();
    }

    public final void e()
    {
        P.e();
    }

    public final void f()
    {
        P.d();
        w.setVisibility(0);
        w.getViewTreeObserver().addOnPreDrawListener(new android.view.ViewTreeObserver.OnPreDrawListener() {

            final MusicDetailsV3Activity a;

            public final boolean onPreDraw()
            {
                com.shazam.android.activities.MusicDetailsV3Activity.c(a).getViewTreeObserver().removeOnPreDrawListener(this);
                if (com.shazam.android.activities.MusicDetailsV3Activity.d(a).getVisibility() != 0)
                {
                    com.shazam.android.activities.MusicDetailsV3Activity.e(a).a();
                }
                return true;
            }

            
            {
                a = MusicDetailsV3Activity.this;
                super();
            }
        });
    }

    public final void g()
    {
        a(A, K, J);
    }

    public String getAgofViewKey()
    {
        return "ShazamAndroidMatch";
    }

    public AnalyticsInfo getAnalyticsInfo()
    {
        return com.shazam.android.o.a.a(o(), n());
    }

    public final void h()
    {
        a(A, J, K);
    }

    public final void j()
    {
        AdOverlayView adoverlayview = D;
        if (adoverlayview.d && !adoverlayview.isShown())
        {
            adoverlayview.c.a();
            adoverlayview.c.b();
        }
    }

    public final void k()
    {
        D.setVisibility(8);
    }

    public final boolean l()
    {
        return P.a(this);
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        if (i1 == 10001 && (j1 == -1 || j1 == 0))
        {
            finish();
        } else
        if (i1 == 10001 && j1 == 400)
        {
            H = false;
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        int i1;
        super.onCreate(bundle);
        setContentView(0x7f030027);
        I = com.shazam.android.k.f.j.a(getIntent());
        Object obj;
        boolean flag;
        if (bundle == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        O = flag;
        if (k && O)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        L = flag;
        M = new com.f.a.a(this);
        if (getResources().getConfiguration().orientation == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        N = flag;
        s = (TextView)findViewById(0x7f1100e9);
        t = (TextView)findViewById(0x7f1100ea);
        u = (UrlCachingImageView)findViewById(0x7f1100e8);
        A = (InteractiveInfoView)findViewById(0x7f1100e6);
        B = (ShareBarView)findViewById(0x7f1100ed);
        v = (ModulesContainerView)findViewById(0x7f1100ef);
        w = (ObservableScrollView)findViewById(0x7f1100e3);
        x = (MusicDetailsMetadataView)findViewById(0x7f1100f0);
        F = (RevealColorView)findViewById(0x7f1100e5);
        G = (Toolbar)findViewById(0x7f1100b0);
        z = (TextView)findViewById(0x7f1100eb);
        C = findViewById(0x7f1100ee);
        D = (AdOverlayView)findViewById(0x7f1100f1);
        setSupportActionBar(G);
        bundle = getSupportActionBar();
        if (bundle != null)
        {
            bundle.a(true);
            bundle.b(true);
        }
        G.setBackgroundColor(getResources().getColor(0x7f0f0098));
        bundle = G;
        i1 = 0;
_L3:
        if (i1 >= bundle.getChildCount())
        {
            break MISSING_BLOCK_LABEL_782;
        }
        obj = bundle.getChildAt(i1);
        if (!(obj instanceof TextView)) goto _L2; else goto _L1
_L1:
        bundle = (TextView)obj;
_L4:
        y = bundle;
        y.setAlpha(0.0F);
        A.getViewTreeObserver().addOnPreDrawListener(new b((byte)0));
        A.setVisibilityChangedListener(new c((byte)0));
        w.a(com.shazam.android.fragment.musicdetails.h.a(v));
        u.f();
        D.setHeaderView(F);
        bundle = D;
        if (M.b)
        {
            i1 = 0;
        } else
        {
            i1 = M.a.a;
        }
        bundle.setStatusBarHeight(i1);
        D.setOnAdPreviewVisibilityListener(p);
        bundle = m();
        obj = getSupportLoaderManager();
        Q = com.shazam.i.n.b.a.a(bundle, getIntent().getData(), this, getSupportFragmentManager(), ((android.support.v4.app.o) (obj)), new com.shazam.android.k.b.f(((android.support.v4.app.o) (obj)), this, new com.shazam.android.k.e.d.c(r)), com.shazam.android.c.a(this), this, q);
        P = new com.shazam.android.o.a(v, x, bundle);
        P.b = Q;
        if (L && m.a())
        {
            obj = new AnimatorSet();
            ((AnimatorSet) (obj)).setStartDelay(1400L);
            ((AnimatorSet) (obj)).setDuration(300L);
            if (android.os.Build.VERSION.SDK_INT >= 21)
            {
                bundle = new PathInterpolator(0.2F, 0.0F, 0.2F, 1.0F);
            } else
            {
                bundle = new android.support.v4.view.b.e();
            }
            ((AnimatorSet) (obj)).setInterpolator(bundle);
            ((AnimatorSet) (obj)).playTogether(new Animator[] {
                ObjectAnimator.ofFloat(B, "alpha", new float[] {
                    1.0F
                }), ObjectAnimator.ofFloat(B, "translationY", new float[] {
                    0.0F
                }), ObjectAnimator.ofFloat(v, "alpha", new float[] {
                    1.0F
                }), ObjectAnimator.ofFloat(v, "translationY", new float[] {
                    0.0F
                }), ObjectAnimator.ofFloat(x, "alpha", new float[] {
                    1.0F
                }), ObjectAnimator.ofFloat(x, "translationY", new float[] {
                    0.0F
                })
            });
            ((AnimatorSet) (obj)).start();
            return;
        } else
        {
            B.setTranslationY(0.0F);
            B.setAlpha(1.0F);
            v.setTranslationY(0.0F);
            v.setAlpha(1.0F);
            x.setTranslationY(0.0F);
            x.setAlpha(1.0F);
            J = getResources().getColor(0x7f0f007f);
            K = getResources().getColor(0x7f0f0082);
            F.setBackgroundColor(J);
            p();
            return;
        }
_L2:
        i1++;
          goto _L3
        bundle = null;
          goto _L4
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu(menu);
        return P.a(menu, getMenuInflater(), 0x7f130001);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (P.a(menuitem, getSupportFragmentManager()))
        {
            return true;
        }
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 16908332: 
            startActivity(e.a(m(), this));
            break;
        }
        finish();
        return true;
    }

    protected void onPause()
    {
        super.onPause();
        boolean flag = P.b.I;
        getIntent().putExtra("hasDisplayedAnyTooltip", flag);
        flag = P.b.J;
        getIntent().putExtra("hasDisplayedPublisher", flag);
        flag = P.b.K;
        getIntent().putExtra("hasDisplayedFacebookInviteFriendsDialog", flag);
        P.b();
        A.a();
    }

    protected void onResume()
    {
        super.onResume();
        P.a();
        ActivityAdBinderAspect.notifyFabOfAdVisibility(this, ActivityAdBinderAspect.isAdVisible(this));
    }

    protected void onStart()
    {
        super.onStart();
        registerReceiver(n, com.shazam.android.f.a.a());
        P.a(getIntent().getBooleanExtra("hasDisplayedAnyTooltip", false), getIntent().getBooleanExtra("hasDisplayedPublisher", false), getIntent().getBooleanExtra("hasDisplayedFacebookInviteFriendsDialog", false));
        if (!O)
        {
            Q.a(MusicPlayerService.a());
        }
    }

    protected void onStop()
    {
        super.onStop();
        unregisterReceiver(n);
        if (!isChangingConfigurations())
        {
            q.sendTagInfo(null);
        }
    }

    public final void t_()
    {
        getSupportFragmentManager().a().a(getSupportFragmentManager().a("retryFragmentTag")).a();
        C.setVisibility(0);
        Q.a();
    }

    static 
    {
        a = com.shazam.b.b.d.a(AddAction.ADD_TO_RDIO_PLAYLIST, com.shazam.android.activities.streaming.b.a, AddAction.ADD_TO_SPOTIFY_PLAYLIST, com.shazam.android.activities.streaming.b.b);
        b = com.shazam.b.b.d.a(AddAction.ADD_TO_RDIO_PLAYLIST, Integer.valueOf(0x7f020127), AddAction.ADD_TO_SPOTIFY_PLAYLIST, Integer.valueOf(0x7f020129));
        c = com.shazam.b.b.d.a(PlaybackProvider.RDIO, com.shazam.android.activities.streaming.b.a, PlaybackProvider.SPOTIFY, com.shazam.android.activities.streaming.b.b);
    }
}
