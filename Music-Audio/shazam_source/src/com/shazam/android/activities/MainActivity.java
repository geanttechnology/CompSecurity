// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.h;
import android.support.v4.app.k;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import com.shazam.android.activities.a.c;
import com.shazam.android.analytics.AgofReportingDisabler;
import com.shazam.android.analytics.TaggedBeaconData;
import com.shazam.android.analytics.TaggingOrigin;
import com.shazam.android.analytics.TaggingOutcome;
import com.shazam.android.analytics.event.BeaconErrorCode;
import com.shazam.android.analytics.event.EventAnalytics;
import com.shazam.android.analytics.event.StartupEvent;
import com.shazam.android.analytics.event.StartupEventAnalytics;
import com.shazam.android.analytics.event.factory.AccountLoginEventFactory;
import com.shazam.android.analytics.event.factory.SearchEventFactory;
import com.shazam.android.analytics.event.factory.WidgetEventFactory;
import com.shazam.android.base.activities.BaseAppCompatActivity;
import com.shazam.android.d;
import com.shazam.android.e;
import com.shazam.android.fragment.TaggingDialogFragment;
import com.shazam.android.fragment.g;
import com.shazam.android.j.t.a;
import com.shazam.android.k.b.i;
import com.shazam.android.k.e.ab;
import com.shazam.android.k.f.p;
import com.shazam.android.k.f.r;
import com.shazam.android.k.f.t;
import com.shazam.android.receiver.AutoTagMatchedReceiver;
import com.shazam.android.util.s;
import com.shazam.android.widget.BadgingTabView;
import com.shazam.android.widget.page.NotifyingViewPager;
import com.shazam.android.widget.slidingtabs.SlidingTabLayout;
import com.shazam.i.b.ah.c.b;
import com.shazam.i.b.ah.f;
import com.shazam.model.Provider;
import com.shazam.model.account.ConfirmingEmailStatus;
import com.shazam.model.account.UserStateDecider;
import com.shazam.model.analytics.ScreenOrigin;
import com.shazam.model.analytics.event.DefinedEventParameterKey;
import com.shazam.model.availability.GooglePlayAvailability;
import com.shazam.model.configuration.SearchConfiguration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.shazam.android.activities:
//            SettingsActivity

public class MainActivity extends BaseAppCompatActivity
    implements com.shazam.android.activities.a.c, AgofReportingDisabler
{
    private final class a extends BroadcastReceiver
    {

        final MainActivity a;

        public final void onReceive(Context context, Intent intent)
        {
            com.shazam.android.activities.MainActivity.b(a);
            int i1 = com.shazam.android.activities.MainActivity.a(a, com.shazam.android.k.f.b.a.h);
            if (i1 != -1)
            {
                context = com.shazam.android.activities.MainActivity.c(a).c(i1);
                if (context instanceof com.shazam.android.fragment.myshazam.a)
                {
                    context = (com.shazam.android.fragment.myshazam.a)context;
                    if (((com.shazam.android.fragment.myshazam.a) (context)).a.getAdapter().c() == 1)
                    {
                        context.a();
                    }
                }
            }
        }

        private a()
        {
            a = MainActivity.this;
            super();
        }

        a(byte byte0)
        {
            this();
        }
    }

    private final class b
        implements android.content.DialogInterface.OnClickListener, com.shazam.p.a.a
    {

        final MainActivity a;

        private void a(int i1)
        {
            s s1 = com.shazam.android.activities.MainActivity.e(a);
            com.shazam.android.util.q.a a1 = new com.shazam.android.util.q.a();
            a1.a = i1;
            a1.h = 0x7f0300b6;
            s1.a(a1.a());
        }

        private void a(BeaconErrorCode beaconerrorcode)
        {
            com.shazam.android.activities.MainActivity.d(a).logEvent(AccountLoginEventFactory.error(com.shazam.android.analytics.event.factory.AccountLoginEventFactory.AccountLoginProviderName.EMAIL, beaconerrorcode, null));
        }

        private void f()
        {
            (new android.app.AlertDialog.Builder(a)).setTitle(0x7f090110).setMessage(0x7f09008a).setCancelable(false).setPositiveButton(0x7f0900fd, this).setNegativeButton(0x7f090123, this).show();
        }

        public final void a()
        {
            com.shazam.android.activities.MainActivity.d(a).logEvent(AccountLoginEventFactory.success(com.shazam.android.analytics.event.factory.AccountLoginEventFactory.AccountLoginProviderName.EMAIL));
            s s1 = com.shazam.android.activities.MainActivity.e(a);
            com.shazam.android.util.q.a a1 = new com.shazam.android.util.q.a();
            a1.a = 0x7f09009f;
            a1.h = 0x7f0300b8;
            s1.a(a1.a());
        }

        public final void b()
        {
            a(BeaconErrorCode.EMAIL_CONFIRM_UNAUTHORIZED);
            a(0x7f09008a);
            com.shazam.android.activities.b.b.b(a);
            a.finish();
        }

        public final void c()
        {
            a(BeaconErrorCode.EMAIL_CONFIRM_FAILED);
            f();
        }

        public final void d()
        {
            a(BeaconErrorCode.EMAIL_CONFIRM_CONFIGURATION_FAILED);
            f();
        }

        public final void e()
        {
            a(BeaconErrorCode.EMAIL_ALREADY_CONFIRMED);
            a(0x7f090064);
        }

        public final void onClick(DialogInterface dialoginterface, int i1)
        {
            if (i1 == -1)
            {
                com.shazam.android.activities.MainActivity.d(a).logEvent(AccountLoginEventFactory.retry());
                com.shazam.android.activities.MainActivity.a(a, a.getIntent().getData());
            }
        }

        private b()
        {
            a = MainActivity.this;
            super();
        }

        b(byte byte0)
        {
            this();
        }
    }

    public static interface c
    {

        public abstract void a();
    }


    private com.shazam.l.a.a A;
    private final com.shazam.android.persistence.e.d a = com.shazam.i.b.ah.c.b.a();
    private final com.shazam.android.service.gcm.c b = new com.shazam.android.service.gcm.c((new e()).b(), com.shazam.i.b.n.b.v().a(), com.shazam.i.b.ah.d.a.a(), com.shazam.i.b.x.a.a.a(), com.shazam.i.c.a.a.a());
    private final com.shazam.android.fragment.a c = new g();
    private final EventAnalytics d = com.shazam.i.b.g.b.a.a();
    private final StartupEvent e = com.shazam.i.b.g.b.c.a();
    private final c f = new com.shazam.android.util.h.a(new c[] {
        new com.shazam.android.ad.b(com.shazam.i.b.ay.b.a.a())
    });
    private final com.shazam.android.fragment.b.b g = com.shazam.i.b.w.a.a.a();
    private final com.shazam.android.ay.a.p h = com.shazam.i.b.ar.a.e.a();
    private final com.shazam.b.a.a i = com.shazam.i.d.d.k();
    private final com.shazam.n.f j = com.shazam.i.p.a.a();
    private final com.shazam.android.e.h k;
    private final com.shazam.android.persistence.n.b l = com.shazam.i.b.ah.f.a();
    private final com.shazam.android.ad.a m = new com.shazam.android.ad.a();
    private final StartupEventAnalytics n = com.shazam.i.b.g.b.b.a();
    private final s o = com.shazam.i.b.au.d.c();
    private final com.shazam.android.receiver.d p = com.shazam.i.b.am.b.a();
    private final com.shazam.android.v.d q = new com.shazam.android.v.d(com.shazam.i.c.a.a(), com.shazam.i.b.ad.a.a.a(), com.shazam.i.k.a.b.a(), com.shazam.i.b.ap.a.c(), com.shazam.i.b.ah.c.d.a(), com.shazam.i.b.ah.b.a.a(), com.shazam.i.b.an.a.a(), com.shazam.i.k.a.a.a(), new com.shazam.android.v.f(com.shazam.i.c.a.a()));
    private final com.shazam.android.k.f.b.a.r r = new com.shazam.android.as.a(com.shazam.i.b.c.a().getResources());
    private final com.shazam.android.widget.c.f s = com.shazam.i.b.ay.a.a.b();
    private final t t = new p();
    private NotifyingViewPager u;
    private BroadcastReceiver v;
    private com.shazam.android.receiver.f w;
    private com.shazam.android.a.a x;
    private Provider y;
    private SlidingTabLayout z;

    public MainActivity()
    {
        com.shazam.model.availability.AppInstallationVerifier appinstallationverifier = com.shazam.i.b.aq.a.a();
        EventAnalytics eventanalytics = com.shazam.i.b.g.b.a.a();
        Map map = com.shazam.i.e.a.a(0);
        map.put("com.beatsmusic.android.client", "b");
        map.put("com.liquable.nemo", "c");
        map.put("com.sec.chaton", "co");
        map.put("com.supercell.clashofclans", "coc");
        map.put("deezer.android.app", "d");
        map.put("com.etsy.android", "e");
        map.put("com.espn.score_center", "espn");
        map.put("com.facebook.katana", "f");
        map.put("com.facebook.orca", "fm");
        map.put("com.google.android.talk", "gh");
        map.put("com.groupme.android", "gm");
        map.put("com.clearchannel.iheartradio.controller", "h");
        map.put("com.bsb.hike", "hi");
        map.put("com.heytell", "ht");
        map.put("kik.android", "ki");
        map.put("com.kakao.talk", "kt");
        map.put("jp.naver.line.android", "li");
        map.put("com.musixmatch.android.lyrify", "m");
        map.put("com.maaii.maaii", "ma");
        map.put("com.littleinc.MessageMe", "mm");
        map.put("com.nimbuzz", "n");
        map.put("com.pandora.android", "p");
        map.put("com.pinterest", "pi");
        map.put("com.rdio.android.ui", "r");
        map.put("com.rounds.android", "ro");
        map.put("com.spotify.music", "s");
        map.put("com.saavn.android", "sa");
        map.put("com.soundcloud.android", "sc");
        map.put("com.skype.raider", "sk");
        map.put("com.melodis.midomiMusicIdentifier.freemium", "sh");
        map.put("com.snapchat.android", "sn");
        map.put("tunein.player", "t");
        map.put("com.sgiggle.production", "ta");
        map.put("com.talkatone.android", "tt");
        map.put("com.vevo", "v");
        map.put("com.viber.voip", "vi");
        map.put("com.rebelvox.voxer", "vo");
        map.put("com.whatsapp", "w");
        map.put("com.tencent.mm", "wc");
        map.put("com.google.android.youtube", "y");
        map.put("com.zulily.android", "z");
        k = new com.shazam.android.e.d(new com.shazam.android.e.c(appinstallationverifier, eventanalytics, map), com.shazam.i.o.a.a());
    }

    static int a(MainActivity mainactivity, com.shazam.android.k.f.b.a a1)
    {
        return mainactivity.a(a1);
    }

    private int a(com.shazam.android.k.f.b.a a1)
    {
        return x.a(a1);
    }

    static com.shazam.n.f a(MainActivity mainactivity)
    {
        return mainactivity.j;
    }

    private void a()
    {
        Object obj;
label0:
        {
            int i1 = a(com.shazam.android.k.f.b.a.h);
            if (i1 != -1)
            {
                obj = z.a.getChildAt(i1);
                if (obj instanceof BadgingTabView)
                {
                    obj = (BadgingTabView)obj;
                    if (g.a() <= 0)
                    {
                        break label0;
                    }
                    ((BadgingTabView) (obj)).setBottomDrawable(((BadgingTabView) (obj)).getResources().getDrawable(0x7f0201d7));
                }
            }
            return;
        }
        ((BadgingTabView) (obj)).setBottomDrawable(((BadgingTabView) (obj)).getResources().getDrawable(0x7f0201d8));
    }

    private void a(Intent intent)
    {
        Uri uri;
        String s1;
        boolean flag1;
        flag1 = false;
        uri = intent.getData();
        s1 = intent.getAction();
        a(uri);
        if (intent.getBooleanExtra("SEND_WIDGET_PRESSED_BEACON", false))
        {
            d.logEvent(WidgetEventFactory.createWidgetEvent(com.shazam.android.analytics.event.factory.WidgetEventFactory.WidgetEventAction.PRESSED));
        }
        if (!"android.intent.action.VIEW".equals(s1) || uri == null) goto _L2; else goto _L1
_L1:
        boolean flag = flag1;
        if (intent == null) goto _L4; else goto _L3
_L3:
        if (intent.getData() != null) goto _L6; else goto _L5
_L5:
        flag = flag1;
_L4:
        if (!flag) goto _L2; else goto _L7
_L7:
        return;
_L6:
        Object obj = com.shazam.android.k.f.r.a(intent.getData());
        int i1;
        if (obj != null)
        {
            i1 = a(((r) (obj)).b);
        } else
        {
            i1 = -1;
        }
        flag = flag1;
        if (i1 != -1)
        {
            u.setCurrentItem(i1);
            flag = true;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (com.shazam.android.util.f.a.a(intent) || !"com.shazam.android.intent.actions.START_TAGGING".equals(intent.getAction())) goto _L7; else goto _L8
_L8:
        p.a();
        obj = TaggingDialogFragment.d();
        u.setCurrentItem(a(com.shazam.android.k.f.b.a.n));
        h.a((TaggedBeaconData)i.a(intent));
        ((h) (obj)).a(getSupportFragmentManager(), TaggingDialogFragment.aj);
        return;
        if (true) goto _L4; else goto _L9
_L9:
    }

    private void a(Uri uri)
    {
        if (r.a(uri))
        {
            com.shazam.android.v.d d1 = q;
            android.support.v4.app.o o1 = getSupportLoaderManager();
            b b1 = new b((byte)0);
            uri = uri.getQueryParameter("vkey");
            A = new com.shazam.l.a.a(d1.b, d1.c, (new com.shazam.android.v.e(this, o1, d1.i, d1.e)).a(uri), d1.f, d1.d, new com.shazam.android.k.b.a(o1, 10022, this, new ab(d1.a), i.b), d1.h, new com.shazam.android.k.b.a(o1, 10014, this, new com.shazam.android.k.e.c(d1.g), i.b), b1);
            uri = A;
            if (((com.shazam.l.a.a) (uri)).b.g())
            {
                ((com.shazam.l.a.a) (uri)).i.e();
            } else
            {
                ((com.shazam.l.a.a) (uri)).g.a();
                if (((com.shazam.l.a.a) (uri)).b.c())
                {
                    ((com.shazam.l.a.a) (uri)).c.a(new com.shazam.l.a.a.b(uri, (byte)0));
                    ((com.shazam.l.a.a) (uri)).c.a();
                    return;
                }
                if (((com.shazam.l.a.a) (uri)).b.h())
                {
                    uri.a();
                    return;
                }
            }
        }
    }

    static void a(MainActivity mainactivity, Uri uri)
    {
        mainactivity.a(uri);
    }

    private void a(boolean flag)
    {
        if (!flag)
        {
            n.sendStartupEvent();
        }
        x = new com.shazam.android.a.a(getResources(), getSupportFragmentManager());
        y = new com.shazam.android.aq.r(u, x);
        if (u == null)
        {
            return;
        } else
        {
            u.a(x, flag);
            int i1 = u.getCurrentItem();
            u.setCurrentItem(i1);
            return;
        }
    }

    static void b(MainActivity mainactivity)
    {
        mainactivity.a();
    }

    static com.shazam.android.a.a c(MainActivity mainactivity)
    {
        return mainactivity.x;
    }

    static EventAnalytics d(MainActivity mainactivity)
    {
        return mainactivity.d;
    }

    static s e(MainActivity mainactivity)
    {
        return mainactivity.o;
    }

    public final void a(com.shazam.android.k.f.b.a a1, com.shazam.android.widget.slidingtabs.a a2)
    {
        int i1 = a(a1);
        com.shazam.android.ad.a a3 = m;
        List list = (List)a3.a.get(Integer.valueOf(i1));
        a1 = list;
        if (list == null)
        {
            a1 = new ArrayList();
            a3.a.put(Integer.valueOf(i1), a1);
        }
        a1.add(a2);
        z.setOnPageReselectedListener(m);
    }

    public final void b(com.shazam.android.k.f.b.a a1, com.shazam.android.widget.slidingtabs.a a2)
    {
        int i1 = a(a1);
        a1 = (List)m.a.get(Integer.valueOf(i1));
        if (a1 != null)
        {
            a1.remove(a2);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionevent)
    {
        f.a();
        return super.dispatchTouchEvent(motionevent);
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        Fragment fragment = (Fragment)y.a();
        if (!c.a(i1, j1, intent, fragment))
        {
            super.onActivityResult(i1, j1, intent);
        }
    }

    public void onBackPressed()
    {
label0:
        {
            if (!h.a(TaggingOutcome.CANCELED))
            {
                Fragment fragment = (Fragment)y.a();
                if (fragment == null || fragment.getChildFragmentManager().e() <= 0)
                {
                    break label0;
                }
                fragment.getChildFragmentManager().c();
            }
            return;
        }
        super.onBackPressed();
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        a(true);
        invalidateOptionsMenu();
    }

    public void onCreate(Bundle bundle)
    {
        Object obj;
        if (com.shazam.android.util.f.a.b(getIntent()))
        {
            overridePendingTransition(0, 0);
        }
        super.onCreate(bundle);
        setContentView(0x7f030023);
        setupToolbar(getToolbar());
        setDisplayHomeAsUp(false);
        setDisplayShowTitle(false);
        e.markDisplayedActivitiesCreationStarted();
        u = (NotifyingViewPager)findViewById(0x7f1100d7);
        z = (SlidingTabLayout)findViewById(0x7f1100d6);
        int i1 = getResources().getDimensionPixelSize(0x7f0a00e4);
        z.setSelectedIndicatorThickness(i1);
        z.setSelectedIndicatorColors(new int[] {
            getResources().getColor(0x7f0f009e)
        });
        z.setBottomBorderThickness(0);
        z.setDividerColors(new int[] {
            getResources().getColor(0x7f0f007b)
        });
        z.a(0x7f030091, 0x7f11020a);
        a(false);
        u.setOnPageSelectionListener(new com.shazam.android.ad.b.a());
        z.setViewPager(u);
        v = new a((byte)0);
        w = new com.shazam.android.receiver.f(this, com.shazam.i.b.ay.b.a.a());
        Intent intent = getIntent();
        boolean flag = intent.getBooleanExtra("fromAppLaunchToTriggerAutotaggingIfConfigured", false);
        intent.removeExtra("fromAppLaunchToTriggerAutotaggingIfConfigured");
        if (flag && bundle == null)
        {
            boolean flag1;
            boolean flag2;
            boolean flag3;
            if (intent != null)
            {
                obj = intent.getAction();
            } else
            {
                obj = null;
            }
            if (obj != null && ((String) (obj)).equals("android.intent.action.INSERT"))
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            flag3 = com.shazam.android.util.f.a.a(intent);
            if (flag1 && !flag3)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            (new StringBuilder("should autostart tagging: ")).append(flag2).append(", action is insert: ").append(flag1).append(", is recent apps: ").append(flag3);
            if (!flag2 && l.b(getString(0x7f09023e)))
            {
                com.shazam.android.activities.b.a.a(this, TaggingOrigin.TAG_ON_START);
            }
        }
        obj = b;
        if (!((com.shazam.android.service.gcm.c) (obj)).d.a()) goto _L2; else goto _L1
_L1:
        if (((com.shazam.android.service.gcm.c) (obj)).c.b() != 0x7d064)
        {
            ((com.shazam.android.service.gcm.c) (obj)).c.d();
        }
        if (!com.shazam.b.e.a.a(((com.shazam.android.service.gcm.c) (obj)).c.a()) || !com.shazam.b.e.a.c(((com.shazam.android.service.gcm.c) (obj)).b)) goto _L4; else goto _L3
_L3:
        (new com.shazam.android.service.gcm.c.a(((com.shazam.android.service.gcm.c) (obj)), true)).execute(new Void[0]);
_L2:
        if (bundle == null)
        {
            a(getIntent());
        }
        if (!a.a())
        {
            (new Thread(new Runnable() {

                final MainActivity a;

                public final void run()
                {
                    com.shazam.android.activities.MainActivity.a(a).c();
                }

            
            {
                a = MainActivity.this;
                super();
            }
            }, "NTP Time Sync")).start();
        }
        k.a();
        return;
_L4:
        if (!((com.shazam.android.service.gcm.c) (obj)).c.c())
        {
            (new com.shazam.android.service.gcm.c.a(((com.shazam.android.service.gcm.c) (obj)), false)).execute(new Void[0]);
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(0x7f130000, menu);
        return true;
    }

    public void onDestroy()
    {
        super.onDestroy();
        de.b.a.a.a.b.a();
    }

    public void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        a(intent);
        setIntent(intent);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 2131821192: 
            startActivity(new Intent(this, com/shazam/android/activities/SettingsActivity));
            return true;

        case 2131821193: 
            d.logEvent(SearchEventFactory.searchIconClickedEvent());
            break;
        }
        menuitem = s;
        Uri uri = t.g();
        com.shazam.android.k.f.i.a a1 = new com.shazam.android.k.f.i.a();
        a1.a = com.shazam.model.analytics.AnalyticsInfo.Builder.a().a(DefinedEventParameterKey.SCREEN_ORIGIN, ScreenOrigin.HOME.value).b();
        menuitem.a(this, uri, a1.a());
        return true;
    }

    public void onPause()
    {
        super.onPause();
        getIntent().putExtra("param_minimumConfig", false);
    }

    public void onResume()
    {
        super.onResume();
        (new com.shazam.android.c.b("onResume", this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
    }

    public void onStart()
    {
        super.onStart();
        setDisplayShowTitle(false);
        registerReceiver(v, AutoTagMatchedReceiver.a(1));
        Object obj = w;
        IntentFilter intentfilter = new IntentFilter("com.shazam.android.intent.actions.UNSUBMITTED_TAG_MATCHED");
        intentfilter.setPriority(1000);
        registerReceiver(((BroadcastReceiver) (obj)), intentfilter);
        obj = u;
        ((NotifyingViewPager) (obj)).a.a(((NotifyingViewPager) (obj)).getCurrentItem(), ((NotifyingViewPager) (obj)).getAdapter());
        a();
        boolean flag = com.shazam.i.b.n.b.U().a();
        boolean flag1 = com.shazam.i.b.ah.f.a().a("pk_version_upgraded_from_previous_version", false);
        if (flag && flag1 && !com.shazam.i.b.ah.f.a().b("pk_search_education_dialog_shown_before"))
        {
            com.shazam.i.b.ah.f.a().b("pk_search_education_dialog_shown_before", true);
            String s1 = com/shazam/android/fragment/f/a.getCanonicalName();
            ((com.shazam.android.fragment.f.a)com.shazam.android.fragment.f.a.instantiate(this, s1)).a(getSupportFragmentManager(), s1);
        }
    }

    protected void onStop()
    {
        super.onStop();
        unregisterReceiver(w);
        unregisterReceiver(v);
        u.d();
        if (A != null)
        {
            com.shazam.l.a.a a1 = A;
            a1.c.b();
            a1.c.c();
            a1.h.b();
            a1.f.b();
        }
    }
}
