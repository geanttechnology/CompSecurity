// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.activity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.f;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import com.pointinside.model.VenueFactory;
import com.target.mothership.common.params.ProductSummaryParam;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.store.interfaces.Store;
import com.target.mothership.services.x;
import com.target.ui.TargetApplication;
import com.target.ui.activity.a.a;
import com.target.ui.e.b;
import com.target.ui.e.c;
import com.target.ui.e.d;
import com.target.ui.e.e;
import com.target.ui.e.h;
import com.target.ui.e.i;
import com.target.ui.e.j;
import com.target.ui.fragment.navigation.NavigationDrawerFragment;
import com.target.ui.fragment.product.plp.ProductSummaryPageFragment;
import com.target.ui.fragment.shop.ShopHomeFragment;
import com.target.ui.googlenow.GoogleNowStoreChangeListener;
import com.target.ui.service.k;
import com.target.ui.service.provider.StoreProviderFactory;
import com.target.ui.util.ae;
import com.target.ui.util.ai;
import com.target.ui.util.aj;
import com.target.ui.util.al;
import com.target.ui.util.deep_link.PromotionParams;
import com.target.ui.util.deep_link.g;
import com.target.ui.view.ToolbarSpinner;
import com.target.ui.vlc.VlcManager;
import com.target.ui.vlc.model.VlcPositionInfo;
import org.json.JSONException;

// Referenced classes of package com.target.ui.activity:
//            a

public class NavigationActivity extends f
    implements com.target.ui.activity.a.b.a, b, c, d, e, h, j, com.target.ui.vlc.c
{
    static class Views extends com.target.ui.view.a
    {

        TextView customTitle;
        NavigationDrawerFragment drawerFragment;
        DrawerLayout drawerLayout;
        View dropShadow;
        View fragmentContainer;
        View progress;
        Toolbar toolbar;
        ToolbarSpinner toolbarSpinner;

        Views(f f1)
        {
            super(f1.findViewById(0x7f1000ae));
            drawerFragment = (NavigationDrawerFragment)f1.f().a(0x7f1000b5);
        }
    }


    private static final String ACTION_SEARCH_OKGOOGLE = "com.google.android.gms.actions.SEARCH_ACTION";
    private static final int PROGRESS_CONTAINER_FADE_DURATION_MS = 150;
    public static final String TAG = com/target/ui/activity/NavigationActivity.getSimpleName();
    private com.target.ui.service.provider.a mAppConfig;
    private GoogleNowStoreChangeListener mGoogleNowStoreChangeListener;
    private com.target.ui.f.c mNavigationFragmentManager;
    private com.target.ui.l.a mUserPreferenceService;
    private Views mViews;
    private com.target.ui.vlc.b mVlcEventReporter;
    private i mVlcManagerWrapper;

    public NavigationActivity()
    {
        mVlcEventReporter = new com.target.ui.vlc.b();
    }

    static void a(NavigationActivity navigationactivity, Intent intent)
    {
        navigationactivity.c(intent);
    }

    private void a(NavigationDrawerFragment navigationdrawerfragment, DrawerLayout drawerlayout, View view)
    {
        navigationdrawerfragment.a(navigationdrawerfragment.getId(), drawerlayout);
        drawerlayout.requestTransparentRegion(view);
        navigationdrawerfragment = obtainStyledAttributes((new TypedValue()).data, new int[] {
            0x7f010159
        });
        int i1 = navigationdrawerfragment.getColor(0, -1);
        navigationdrawerfragment.recycle();
        if (i1 != -1)
        {
            drawerlayout.setStatusBarBackgroundColor(i1);
        }
    }

    private void a(com.target.ui.util.deep_link.f.a a1, com.target.ui.util.deep_link.e e1)
    {
        static class _cls3
        {

            static final int $SwitchMap$com$target$ui$util$deep_link$DeepLinkReport$CustomAction[];
            static final int $SwitchMap$com$target$ui$util$deep_link$DeepLinkReport$ReportType[];

            static 
            {
                $SwitchMap$com$target$ui$util$deep_link$DeepLinkReport$ReportType = new int[com.target.ui.util.deep_link.f.b.values().length];
                try
                {
                    $SwitchMap$com$target$ui$util$deep_link$DeepLinkReport$ReportType[com.target.ui.util.deep_link.f.b.CUSTOM_ACTION.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$target$ui$util$deep_link$DeepLinkReport$ReportType[com.target.ui.util.deep_link.f.b.FRAGMENT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$target$ui$util$deep_link$DeepLinkReport$ReportType[com.target.ui.util.deep_link.f.b.DIALOG_FRAGMENT.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$ui$util$deep_link$DeepLinkReport$ReportType[com.target.ui.util.deep_link.f.b.NONE.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                $SwitchMap$com$target$ui$util$deep_link$DeepLinkReport$CustomAction = new int[com.target.ui.util.deep_link.f.a.values().length];
                try
                {
                    $SwitchMap$com$target$ui$util$deep_link$DeepLinkReport$CustomAction[com.target.ui.util.deep_link.f.a.PROMOTION.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls3..SwitchMap.com.target.ui.util.deep_link.DeepLinkReport.CustomAction[a1.ordinal()])
        {
        default:
            com.target.a.a.b.a(TAG, "Could not handle custom action deep link");
            return;

        case 1: // '\001'
            (new a(this)).a((PromotionParams)e1.c().c());
            break;
        }
    }

    private void c(final Intent intent)
    {
        com.target.ui.util.deep_link.f f1;
        Object obj;
        obj = intent.getData();
        if (com.target.ui.util.deep_link.a.a(((Uri) (obj)), io.branch.referral.d.a(), this, new com.target.ui.util.deep_link.a.a() {

        final NavigationActivity this$0;
        final Intent val$intent;

        public void a(Uri uri)
        {
            Intent intent1 = new Intent(intent);
            intent1.setData(uri);
            com.target.ui.activity.NavigationActivity.a(NavigationActivity.this, intent1);
        }

        public void a(io.branch.referral.f f2)
        {
            com.target.a.a.b.a(NavigationActivity.TAG, (new StringBuilder()).append("Error from Branch SDK: ").append(f2.a()).toString());
        }

        public void a(JSONException jsonexception)
        {
            com.target.a.a.b.a(NavigationActivity.TAG, "Error parsing Branch payload: ", jsonexception);
        }

            
            {
                this$0 = NavigationActivity.this;
                intent = intent1;
                super();
            }
    }) || obj == null)
        {
            return;
        }
        if (com.target.ui.j.c.a(((Uri) (obj))))
        {
            com.target.ui.j.c.a(((Uri) (obj)), this);
            return;
        }
        f1 = g.a(((Uri) (obj)), (Store)ae.a(getApplicationContext()).d());
        _cls3..SwitchMap.com.target.ui.util.deep_link.DeepLinkReport.ReportType[f1.e().ordinal()];
        JVM INSTR tableswitch 1 4: default 104
    //                   1 116
    //                   2 137
    //                   3 190
    //                   4 190;
           goto _L1 _L2 _L3 _L4 _L4
_L1:
        intent.setData(null);
        setIntent(intent);
        return;
_L2:
        a((com.target.ui.util.deep_link.f.a)f1.a().c(), f1.b());
        continue; /* Loop/switch isn't completed */
_L3:
        obj = (Fragment)f1.d().c();
        com.target.ui.analytics.b.h.a(f1).a();
        if (f1.b().e().b())
        {
            m().d(((Fragment) (obj)));
        } else
        {
            m().a(((Fragment) (obj)));
        }
        continue; /* Loop/switch isn't completed */
_L4:
        ai.a(this, (new StringBuilder()).append("Couldn't load deep link : ").append(((Uri) (obj)).toString()).toString());
        if (true) goto _L1; else goto _L5
_L5:
    }

    private void d(Intent intent)
    {
        c(intent);
        e(intent);
    }

    private void d(boolean flag)
    {
        while (mViews == null || flag == al.a(mViews.progress)) 
        {
            return;
        }
        if (flag)
        {
            aj.b(mViews.progress, 150);
            return;
        } else
        {
            aj.a(mViews.progress, 150);
            return;
        }
    }

    private void e(Intent intent)
    {
        if (intent != null)
        {
            if ("android.intent.action.SEARCH".equals(intent.getAction()))
            {
                String s1 = intent.getStringExtra("query");
                com.target.ui.fragment.product.search.a.a(getApplicationContext(), s1);
            }
            if ("com.google.android.gms.actions.SEARCH_ACTION".equals(intent.getAction()))
            {
                intent = intent.getStringExtra("query");
                intent = ProductSummaryPageFragment.a(new ProductSummaryParam((Store)ae.a(getApplicationContext()).d(), null, null, intent), com.target.ui.util.g.a.a(true));
                m().a(intent);
                return;
            }
        }
    }

    private boolean t()
    {
        return al.a(mViews.progress);
    }

    private void u()
    {
        mGoogleNowStoreChangeListener = new GoogleNowStoreChangeListener(getApplicationContext());
        com.target.ui.service.k.a().a(mGoogleNowStoreChangeListener);
    }

    private void v()
    {
        com.target.mothership.model.h h1 = new com.target.mothership.model.h() {

            final NavigationActivity this$0;

            public String a()
            {
                return NavigationActivity.TAG;
            }

            public void a(Guest guest)
            {
                com.target.ui.service.b.a().b(guest);
            }

            public void a(x x1)
            {
            }

            public volatile void a(Object obj)
            {
                a((Guest)obj);
            }

            public void b(Object obj)
            {
                a((x)obj);
            }

            
            {
                this$0 = NavigationActivity.this;
                super();
            }
        };
        com.target.ui.service.a.a().a(h1);
    }

    private void w()
    {
        if (mGoogleNowStoreChangeListener != null)
        {
            com.target.ui.service.k.a().b(mGoogleNowStoreChangeListener);
        }
    }

    public void a(PromotionParams promotionparams)
    {
        m().a(ShopHomeFragment.a(promotionparams));
    }

    public void a(VlcPositionInfo vlcpositioninfo)
    {
        com.target.ui.fragment.store.location.a.a(this, f());
    }

    public void b(boolean flag)
    {
        mViews.drawerFragment.i().a(flag);
    }

    public void c(boolean flag)
    {
        if (mViews == null)
        {
            return;
        }
        int i1;
        if (flag)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        mViews.drawerLayout.setDrawerLockMode(i1);
        d(flag);
    }

    public TextView k()
    {
        return mViews.customTitle;
    }

    public View l()
    {
        return mViews.dropShadow;
    }

    public com.target.ui.f.c m()
    {
        return mNavigationFragmentManager;
    }

    public ToolbarSpinner n()
    {
        return mViews.toolbarSpinner;
    }

    public i o()
    {
        return mVlcManagerWrapper;
    }

    public void onBackPressed()
    {
        Object obj = f().a(0x7f1000af);
        if (mViews.drawerFragment.j())
        {
            mViews.drawerFragment.f();
        } else
        if (obj instanceof com.target.ui.e.a)
        {
            obj = (com.target.ui.e.a)obj;
            boolean flag;
            if (t())
            {
                boolean flag1 = ((com.target.ui.e.a) (obj)).a(this);
                flag = flag1;
                if (!flag1)
                {
                    c(false);
                    return;
                }
            } else
            {
                flag = ((com.target.ui.e.a) (obj)).R();
            }
            if (!flag)
            {
                super.onBackPressed();
                return;
            }
        } else
        {
            super.onBackPressed();
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        TargetApplication.b(this).(new com.target.a.a.a(this));
        super.onCreate(bundle);
        setContentView(0x7f030024);
        mViews = new Views(this);
        a(mViews.toolbar);
        g().b(true);
        g().a(true);
        g().a("");
        mUserPreferenceService = com.target.ui.l.a.a();
        mVlcManagerWrapper = new i(new StoreProviderFactory(this), new com.target.ui.helper.k.a(new VenueFactory(this)), new VlcManager(this), mUserPreferenceService);
        mVlcManagerWrapper.a(mVlcEventReporter);
        mAppConfig = new com.target.ui.service.provider.c();
        mNavigationFragmentManager = new com.target.ui.f.c(f(), 0x7f1000af, mViews.drawerLayout, findViewById(0x7f1000b5));
        a(mViews.drawerFragment, mViews.drawerLayout, mViews.fragmentContainer);
        v();
        u();
        if (bundle == null)
        {
            mNavigationFragmentManager.a(ShopHomeFragment.a());
        }
        d(getIntent());
    }

    protected void onDestroy()
    {
        super.onDestroy();
        mViews = null;
        w();
        mVlcEventReporter.a();
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        setIntent(intent);
        d(intent);
    }

    protected void onPause()
    {
        super.onPause();
        com.target.ui.analytics.c.a().c();
        mVlcManagerWrapper.b(mVlcEventReporter);
        mVlcManagerWrapper.b(this);
        mVlcManagerWrapper.c();
    }

    protected void onResume()
    {
        super.onResume();
        mVlcManagerWrapper.d();
        com.target.ui.service.a.a().d();
        com.target.ui.analytics.c.a().b();
        mVlcManagerWrapper.a(this);
    }

    protected void onStart()
    {
        super.onStart();
        if (mViews == null)
        {
            mViews = new Views(this);
        }
        com.target.ui.service.k.a().a(this);
    }

    protected void onStop()
    {
        super.onStop();
        com.target.ui.service.k.a().b(this);
    }

    public void p()
    {
    }

    public void q()
    {
    }

    public void r()
    {
    }

    public void s()
    {
    }

}
