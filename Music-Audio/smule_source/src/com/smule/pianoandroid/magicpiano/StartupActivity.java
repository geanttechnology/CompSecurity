// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flurry.android.FlurryAdListener;
import com.flurry.android.FlurryAdType;
import com.smule.android.c.aa;
import com.smule.android.c.ab;
import com.smule.android.c.w;
import com.smule.android.f.e;
import com.smule.android.network.managers.UserManager;
import com.smule.android.network.managers.ak;
import com.smule.android.network.models.SongV2;
import com.smule.pianoandroid.d.a;
import com.smule.pianoandroid.e.i;
import com.smule.pianoandroid.magicpiano.b.p;
import com.smule.pianoandroid.magicpiano.b.q;
import com.smule.pianoandroid.utils.m;
import com.smule.pianoandroid.utils.n;
import com.smule.pianoandroid.utils.o;
import com.smule.pianoandroid.utils.r;
import com.smule.pianoandroid.utils.z;
import com.sponsorpay.SponsorPay;
import com.sponsorpay.advertiser.SponsorPayAdvertiser;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ag, MagicActivity, ProductListActivity, WhatsNewActivity, 
//            i, MagicApplication

public class StartupActivity extends ag
    implements FlurryAdListener, ab, q
{

    private static final String a = com/smule/pianoandroid/magicpiano/StartupActivity.getName();
    private boolean b;
    private com.smule.pianoandroid.magicpiano.i c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private com.smule.pianoandroid.ads.a h;
    private Runnable i;

    public StartupActivity()
    {
        b = false;
        c = null;
        d = false;
        e = false;
        f = false;
        g = false;
        i = new Runnable() {

            final StartupActivity a;

            public void run()
            {
                com.smule.pianoandroid.magicpiano.StartupActivity.a(a);
            }

            
            {
                a = StartupActivity.this;
                super();
            }
        };
    }

    static com.smule.pianoandroid.magicpiano.i a(StartupActivity startupactivity, com.smule.pianoandroid.magicpiano.i k)
    {
        startupactivity.c = k;
        return k;
    }

    public static void a(Activity activity, SongV2 songv2)
    {
        if (songv2 != null && songv2.resourceFilePaths != null && songv2.resourceFilePaths.size() > 0)
        {
            Intent intent = new Intent(activity, com/smule/pianoandroid/magicpiano/MagicActivity);
            intent.putExtra("SONG_MODE", 0);
            intent.putExtra("CREATE_ACTIVITY_ON_FINISH", true);
            intent.putExtra("SONG_MIDI_EXTRA", (String)songv2.resourceFilePaths.get("main"));
            intent.putExtra("SONG_NAME_EXTRA", songv2.title);
            intent.putExtra("SONG_GENRE_EXTRA", songv2.genre);
            intent.putExtra("SONG_UID_EXTRA", songv2.songId);
            intent.putExtra("SONG_COMPOSER_EXTRA", songv2.artist);
            intent.putExtra("SONG_OWNED", true);
            if (com.smule.pianoandroid.d.a.b(activity) >= 1)
            {
                intent.putExtra("SONG_DIFFICULTY", 3);
            } else
            {
                intent.putExtra("SONG_DIFFICULTY", 0);
            }
            com.smule.pianoandroid.utils.q.B();
            activity.startActivity(intent);
            activity.finish();
            return;
        } else
        {
            Log.e(a, "couldn't load tutorial song: twinkle_twinkle_bundled");
            return;
        }
    }

    static void a(StartupActivity startupactivity)
    {
        startupactivity.e();
    }

    static boolean a(StartupActivity startupactivity, boolean flag)
    {
        startupactivity.g = flag;
        return flag;
    }

    static boolean b(StartupActivity startupactivity)
    {
        return startupactivity.g;
    }

    static boolean b(StartupActivity startupactivity, boolean flag)
    {
        startupactivity.e = flag;
        return flag;
    }

    static boolean c(StartupActivity startupactivity)
    {
        return startupactivity.d;
    }

    static boolean c(StartupActivity startupactivity, boolean flag)
    {
        startupactivity.f = flag;
        return flag;
    }

    static String d()
    {
        return a;
    }

    static void d(StartupActivity startupactivity)
    {
        startupactivity.h();
    }

    private void e()
    {
        Intent intent = new Intent(getApplicationContext(), com/smule/pianoandroid/magicpiano/ProductListActivity);
        intent.addFlags(0x4000000);
        startActivity(intent);
        overridePendingTransition(0x7f040014, 0x7f04001b);
        finish();
    }

    static void e(StartupActivity startupactivity)
    {
        startupactivity.g();
    }

    static com.smule.pianoandroid.magicpiano.i f(StartupActivity startupactivity)
    {
        return startupactivity.c;
    }

    private void f()
    {
        Intent intent = new Intent(getApplicationContext(), com/smule/pianoandroid/magicpiano/WhatsNewActivity);
        com.smule.pianoandroid.utils.q.B();
        startActivity(intent);
    }

    private void g()
    {
        String s;
        Uri uri;
        Object obj;
        s = null;
        obj = getIntent();
        uri = ((Intent) (obj)).getData();
        obj = ((Intent) (obj)).getStringExtra("PARAMS");
        if (obj == null) goto _L2; else goto _L1
_L1:
        String s1;
        String s2;
        Object obj1;
        obj1 = (Map)com.smule.android.f.e.a().readValue(((String) (obj)), java/util/Map);
        s1 = (String)((Map) (obj1)).get("y");
        s2 = (String)((Map) (obj1)).get("z");
        obj1 = (Boolean)((Map) (obj1)).get("react_local");
        if (s1 == null || s2 == null) goto _L4; else goto _L3
_L3:
        obj1 = w.a();
        if (uri == null)
        {
            break MISSING_BLOCK_LABEL_103;
        }
        s = uri.toString();
        ((w) (obj1)).a("push_clk", "", s1, s2, null, null, null, s);
_L2:
        Exception exception;
        if (uri == null)
        {
            if (!isFinishing() && !UserManager.n().h())
            {
                if (h == null || !h.a(this, 0x7f0a00b5))
                {
                    e();
                }
                return;
            } else
            {
                e();
                return;
            }
        } else
        {
            o.a(this, uri);
            return;
        }
_L4:
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_226;
        }
        if (!((Boolean) (obj1)).booleanValue())
        {
            break MISSING_BLOCK_LABEL_226;
        }
        w.a().a("push_clk", "", "react_local");
          goto _L2
        try
        {
            aa.b(a, (new StringBuilder()).append("Missing push type or/and id or react_local type=").append(s1).append(" id=").append(s2).append(" react_local=").append(obj1).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            aa.b(a, (new StringBuilder()).append("Failed to parse push notification params ").append(((String) (obj))).toString(), exception);
        }
          goto _L2
    }

    private void h()
    {
        o.a(this, new Runnable() {

            final StartupActivity a;

            public void run()
            {
                a.runOnUiThread(new Runnable(this) {

                    final _cls3 a;

                    public void run()
                    {
                        StartupActivity.b(a.a, true);
                        com.smule.pianoandroid.magicpiano.StartupActivity.a(a.a, false);
                        aa.a(StartupActivity.d(), (new StringBuilder()).append("Login count for player ").append(UserManager.n().c()).append(" is ").append(UserManager.n().l()).toString());
                        if (UserManager.n().l() < 3)
                        {
                            a.a.c();
                            StartupActivity.c(a.a, true);
                            return;
                        } else
                        {
                            com.smule.pianoandroid.magicpiano.StartupActivity.e(a.a);
                            return;
                        }
                    }

            
            {
                a = _pcls3;
                super();
            }
                });
            }

            
            {
                a = StartupActivity.this;
                super();
            }
        }, new Runnable() {

            final StartupActivity a;

            public void run()
            {
                StartupActivity.b(a, true);
                com.smule.pianoandroid.magicpiano.StartupActivity.a(a, false);
                com.smule.pianoandroid.e.i.a().b();
                a.c();
            }

            
            {
                a = StartupActivity.this;
                super();
            }
        });
    }

    public Boolean a(Activity activity, q q1)
    {
        Object obj;
        Object obj1 = null;
        String s;
        try
        {
            s = com.smule.pianoandroid.data.db.a.a();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.e(a, "Failed to load Twinkle!", ((Throwable) (obj)));
            obj = obj1;
            continue; /* Loop/switch isn't completed */
        }
        obj = obj1;
        if (s == null) goto _L2; else goto _L1
_L1:
        obj = ((JsonNode)com.smule.android.f.e.a().readValue(s, com/fasterxml/jackson/databind/JsonNode)).get("data");
        if (obj == null) goto _L4; else goto _L3
_L3:
        obj = ((JsonNode) (obj)).get("song");
        if (obj == null) goto _L4; else goto _L5
_L5:
        obj = ak.b(((JsonNode) (obj)).toString());
_L2:
        if (obj != null)
        {
            (new p(activity, ((SongV2) (obj)), q1, c)).execute(new Void[0]);
            return Boolean.valueOf(true);
        } else
        {
            Log.e(a, "Couldn't load twinkle, still creating data-bases");
            return Boolean.valueOf(false);
        }
        obj;
        Log.e(a, (new StringBuilder()).append("Error parsing json response from bundled content: ").append(s).toString(), ((Throwable) (obj)));
        obj = obj1;
        continue; /* Loop/switch isn't completed */
_L4:
        obj = null;
        if (true) goto _L2; else goto _L6
_L6:
    }

    public void a(SongV2 songv2)
    {
        a(((Activity) (this)), songv2);
    }

    public boolean a()
    {
        return false;
    }

    public String b()
    {
        return null;
    }

    public void c()
    {
        if (c == null)
        {
            c = new com.smule.pianoandroid.magicpiano.i(this, getString(0x7f0c016b));
            c.a(false);
            if (!a(this, new q() {

        final StartupActivity a;

        public void a(SongV2 songv2)
        {
            if (StartupActivity.f(a) != null)
            {
                StartupActivity.f(a).dismiss();
            }
            com.smule.pianoandroid.magicpiano.StartupActivity.a(a, songv2);
            com.smule.pianoandroid.magicpiano.StartupActivity.a(a, null);
        }

            
            {
                a = StartupActivity.this;
                super();
            }
    }).booleanValue())
            {
                c.dismiss();
                c = null;
                return;
            }
        }
    }

    protected boolean j()
    {
        return true;
    }

    public void onAdClicked(String s)
    {
    }

    public void onAdClosed(String s)
    {
    }

    public void onAdOpened(String s)
    {
    }

    public void onApplicationExit(String s)
    {
    }

    protected void onCreate(Bundle bundle)
    {
        com.smule.android.c.a.a(r.a);
        super.onCreate(bundle);
        aa.b(a, (new StringBuilder()).append("Revision: ").append(getResources().getString(0x7f0c022d)).toString());
        aa.b(a, (new StringBuilder()).append("Build time: ").append(getResources().getString(0x7f0c0039)).toString());
        if (isTaskRoot()) goto _L2; else goto _L1
_L1:
        Intent intent;
        String s;
        intent = getIntent();
        s = intent.getAction();
        if (!intent.hasCategory("android.intent.category.LAUNCHER") || s == null || !s.equals("android.intent.action.MAIN")) goto _L2; else goto _L3
_L3:
        aa.e(a, "StartupActivity is not the root. Finishing StartupActivity instead of launching.");
        finish();
_L5:
        return;
_L2:
        n.a(MagicApplication.getContext());
        setContentView(0x7f030071);
        z.a(findViewById(0x1020002));
        m.a(this);
        long l = UserManager.n().c();
        SponsorPay.start(MagicApplication.getSponsorpayAppID(), Long.toString(l), null, this);
        SponsorPayAdvertiser.register(getApplicationContext());
        com.smule.android.a.a(MagicApplication.getContext());
        if (bundle != null)
        {
            b = bundle.getBoolean("SPLASH_SHOWN", false);
        }
        if (MagicApplication.sShowWhatsNew)
        {
            f();
            return;
        }
        if (UserManager.n().h())
        {
            g();
            return;
        }
        if (com.smule.android.network.managers.a.a().c())
        {
            h = new com.smule.pianoandroid.ads.a();
            h.b(this, 0x7f0a00b5, i, null);
            return;
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    protected void onDestroy()
    {
        if (c != null)
        {
            c.dismiss();
            c = null;
        }
        if (h != null)
        {
            h.c(this);
        }
        super.onDestroy();
    }

    protected void onPause()
    {
        if (h != null)
        {
            h.a(this);
        }
        super.onPause();
        MagicApplication.getInstance().onPause();
        d = false;
    }

    public void onRenderFailed(String s)
    {
    }

    public void onRendered(String s)
    {
    }

    protected void onResume()
    {
        if (h != null)
        {
            h.b(this);
        }
        super.onResume();
        MagicApplication.getInstance().onResume();
        d = true;
        if (UserManager.n().h() && !f && !MagicApplication.sShowWhatsNew)
        {
            e();
        }
        if (!e && g)
        {
            h();
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("SPLASH_SHOWN", b);
    }

    protected void onStart()
    {
        MagicApplication.onActivityStart(this);
        super.onStart();
        if (MagicApplication.sShowWhatsNew)
        {
            return;
        }
        if (h != null)
        {
            h.c(this, 0x7f0a00b5, i, null);
        }
        SharedPreferences sharedpreferences = getApplicationContext().getSharedPreferences("startup_prefs", 0);
        android.content.SharedPreferences.Editor editor = sharedpreferences.edit();
        if (-1 == sharedpreferences.getInt("unlock_counter", -1))
        {
            editor.putInt("unlock_counter", 0);
        }
        com.smule.android.f.p.a(editor);
        if (!com.smule.pianoandroid.magicpiano.c.a.a().c() && !e)
        {
            com.smule.android.c.a.a(r.h);
            if (!UserManager.n().h())
            {
                Timer timer = new Timer();
                TimerTask timertask = new TimerTask() {

                    final StartupActivity a;

                    public void run()
                    {
                        a.runOnUiThread(new Runnable(this) {

                            final _cls2 a;

                            public void run()
                            {
label0:
                                {
                                    if (!StartupActivity.b(a.a))
                                    {
                                        if (!StartupActivity.c(a.a))
                                        {
                                            break label0;
                                        }
                                        StartupActivity.d(a.a);
                                    }
                                    return;
                                }
                                com.smule.pianoandroid.magicpiano.StartupActivity.a(a.a, true);
                            }

            
            {
                a = _pcls2;
                super();
            }
                        });
                    }

            
            {
                a = StartupActivity.this;
                super();
            }
                };
                long l;
                if (b)
                {
                    l = 0L;
                } else
                {
                    l = 3000L;
                }
                timer.schedule(timertask, l);
                b = true;
                return;
            } else
            {
                g();
                return;
            }
        } else
        {
            g();
            return;
        }
    }

    protected void onStop()
    {
        super.onStop();
        MagicApplication.onActivityStop(this);
        if (h != null)
        {
            h.f();
        }
    }

    public void onVideoCompleted(String s)
    {
    }

    public boolean shouldDisplayAd(String s, FlurryAdType flurryadtype)
    {
        return h != null && h.b();
    }

    public void spaceDidFailToReceiveAd(String s)
    {
        aa.b(a, (new StringBuilder()).append("Flurry failed to received ad for space ").append(s).toString());
    }

    public void spaceDidReceiveAd(String s)
    {
        aa.a(a, (new StringBuilder()).append("Flurry received ad for space ").append(s).toString());
    }

}
