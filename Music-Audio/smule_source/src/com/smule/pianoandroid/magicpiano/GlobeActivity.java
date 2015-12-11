// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.app.ActionBar;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Rect;
import android.location.Location;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import com.smule.android.c.aa;
import com.smule.android.c.ab;
import com.smule.android.c.f;
import com.smule.android.c.i;
import com.smule.android.network.core.NetworkResponseCallback;
import com.smule.android.network.core.r;
import com.smule.android.network.managers.PerformanceManager;
import com.smule.android.network.managers.ak;
import com.smule.android.network.managers.ap;
import com.smule.android.network.models.AccountIcon;
import com.smule.android.network.models.ListingV2;
import com.smule.android.network.models.PerformanceV2;
import com.smule.android.network.models.SongV2;
import com.smule.magicpiano.PianoCoreBridge;
import com.smule.pianoandroid.e.c;
import com.smule.pianoandroid.globe.PianoGlobeBridge;
import com.smule.pianoandroid.globe.a;
import com.smule.pianoandroid.globe.b;
import com.smule.pianoandroid.magicpiano.a.e;
import com.smule.pianoandroid.magicpiano.a.g;
import com.smule.pianoandroid.magicpiano.b.p;
import com.smule.pianoandroid.magicpiano.b.q;
import com.smule.pianoandroid.synths.SoundPoolSynth;
import com.smule.pianoandroid.utils.m;
import com.smule.pianoandroid.utils.n;
import com.smule.pianoandroid.utils.o;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Future;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ag, ao, at, j, 
//            an, PreSongActivity, i, as, 
//            PurchaseActivity_, GlobeGLSurfaceView, o, MagicApplication

public class GlobeActivity extends ag
    implements ab, a, b, ao, at, com.smule.pianoandroid.magicpiano.b.b, q, j
{

    static final String a = com/smule/pianoandroid/magicpiano/GlobeActivity.getName();
    static final boolean b;
    private p A;
    private com.smule.pianoandroid.magicpiano.b.a B;
    private boolean C;
    private SongV2 D;
    private boolean E;
    private boolean F;
    private boolean G;
    private boolean H;
    private boolean I;
    private SongV2 J;
    private ListingV2 K;
    private com.smule.pianoandroid.magicpiano.a.a L;
    private Future M;
    private int N;
    private android.view.ViewTreeObserver.OnGlobalLayoutListener O;
    private boolean P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private int T;
    private boolean U;
    private GlobeGLSurfaceView c;
    private int d;
    private ArrayList e;
    private TextView f;
    private TextView g;
    private TextView h;
    private View i;
    private ImageView j;
    private TextView k;
    private View l;
    private View m;
    private View n;
    private ImageView t;
    private File u;
    private File v;
    private SoundPoolSynth w;
    private com.smule.pianoandroid.magicpiano.o x;
    private an y;
    private com.smule.pianoandroid.magicpiano.i z;

    public GlobeActivity()
    {
        d = 0;
        e = new ArrayList();
        D = null;
        E = false;
        F = false;
        G = false;
        H = false;
        I = false;
        J = null;
        K = null;
        M = null;
        N = 0;
        O = new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

            final GlobeActivity a;

            public void onGlobalLayout()
            {
                com.smule.pianoandroid.utils.n.a(this, com.smule.pianoandroid.magicpiano.GlobeActivity.a(a).getViewTreeObserver());
                Rect rect = new Rect();
                com.smule.pianoandroid.magicpiano.GlobeActivity.a(a).getGlobalVisibleRect(rect);
                com.smule.pianoandroid.magicpiano.GlobeActivity.a(a).a(rect);
            }

            
            {
                a = GlobeActivity.this;
                super();
            }
        };
        P = false;
        Q = true;
    }

    static ListingV2 a(GlobeActivity globeactivity, ListingV2 listingv2)
    {
        globeactivity.K = listingv2;
        return listingv2;
    }

    static SongV2 a(GlobeActivity globeactivity, SongV2 songv2)
    {
        globeactivity.J = songv2;
        return songv2;
    }

    static GlobeGLSurfaceView a(GlobeActivity globeactivity)
    {
        return globeactivity.c;
    }

    static an a(GlobeActivity globeactivity, an an1)
    {
        globeactivity.y = an1;
        return an1;
    }

    static File a(GlobeActivity globeactivity, File file)
    {
        globeactivity.v = file;
        return file;
    }

    private void a(int i1)
    {
        n.setVisibility(i1);
        i.setVisibility(i1);
        m.setVisibility(i1);
        findViewById(0x7f0a00e6).setVisibility(i1);
        findViewById(0x7f0a00e0).setVisibility(i1);
        f.setVisibility(i1);
        g.setVisibility(i1);
        h.setVisibility(i1);
    }

    private void a(PerformanceV2 performancev2, boolean flag)
    {
        com.smule.android.network.core.b.a(new Runnable(performancev2, flag) {

            final PerformanceV2 a;
            final boolean b;
            final GlobeActivity c;

            public void run()
            {
                aa.c(com.smule.pianoandroid.magicpiano.GlobeActivity.a, (new StringBuilder()).append("Fetching performance midi for: ").append(a.songUid).toString());
                if (!b && GlobeActivity.k(c) != null && GlobeActivity.k(c).exists())
                {
                    GlobeActivity.k(c).delete();
                }
                aa.a(com.smule.pianoandroid.magicpiano.GlobeActivity.a, "file deteled");
                (new File((new StringBuilder()).append(com.smule.android.f.n.b(c)).append("globe_cache").toString())).mkdirs();
                if (b)
                {
                    com.smule.pianoandroid.magicpiano.GlobeActivity.a(c, com.smule.android.network.a.r.a(a.origTrackUrl, (new StringBuilder()).append("globe_cache").append(a.performanceKey).toString(), c));
                    aa.a(com.smule.pianoandroid.magicpiano.GlobeActivity.a, "prefetch file downloaded");
                } else
                if (GlobeActivity.l(c) != null && GlobeActivity.l(c).exists())
                {
                    com.smule.pianoandroid.magicpiano.GlobeActivity.b(c, GlobeActivity.l(c));
                } else
                {
                    com.smule.pianoandroid.magicpiano.GlobeActivity.b(c, com.smule.android.network.a.r.a(a.origTrackUrl, (new StringBuilder()).append("globe_cache").append(a.performanceKey).toString(), c));
                }
                if (!c.isFinishing())
                {
                    if (com.smule.pianoandroid.magicpiano.GlobeActivity.m(c))
                    {
                        c.a(false);
                        return;
                    }
                    if (!b)
                    {
                        if (com.smule.pianoandroid.magicpiano.GlobeActivity.n(c))
                        {
                            com.smule.pianoandroid.magicpiano.GlobeActivity.o(c);
                            return;
                        } else
                        {
                            com.smule.pianoandroid.magicpiano.GlobeActivity.a(c, true);
                            return;
                        }
                    }
                }
            }

            
            {
                c = GlobeActivity.this;
                a = performancev2;
                b = flag;
                super();
            }
        });
    }

    static void a(GlobeActivity globeactivity, int i1)
    {
        globeactivity.a(i1);
    }

    static void a(GlobeActivity globeactivity, Integer integer)
    {
        globeactivity.a(integer);
    }

    private void a(Integer integer)
    {
        d = integer.intValue();
        for (int j1 = 0; d < e.size(); j1++)
        {
            String s1 = p().songUid;
            if (ak.a().a(s1) != null)
            {
                PerformanceV2 performancev2 = p();
                String s2 = performancev2.performanceKey;
                i i1 = i.a;
                if (performancev2.ensembleType.equalsIgnoreCase("MIX"))
                {
                    integer = f.e;
                } else
                {
                    integer = f.a;
                }
                com.smule.android.c.a.a(s2, i1, s1, integer, null);
                a(performancev2, false);
                if (d + 1 < e.size())
                {
                    a((PerformanceV2)e.get(d + 1), true);
                }
                return;
            }
            aa.c(a, (new StringBuilder()).append("Product: ").append(s1).append(" not found").toString());
            if (ak.a().k() < 10 || j1 > 10)
            {
                runOnUiThread(new Runnable() {

                    final GlobeActivity a;

                    public void run()
                    {
                        GlobeActivity.v(a).a(2, a.getResources().getString(0x7f0c01ae), true);
                        com.smule.pianoandroid.magicpiano.GlobeActivity.a(a, 4);
                    }

            
            {
                a = GlobeActivity.this;
                super();
            }
                });
                return;
            }
            d = d + 1;
        }

        m();
    }

    private void a(boolean flag, boolean flag1, Integer integer)
    {
        if (flag)
        {
            if (flag1)
            {
                integer = new Runnable() {

                    final GlobeActivity a;

                    public void run()
                    {
                        com.smule.pianoandroid.magicpiano.GlobeActivity.a(a, GlobeActivity.h(a).song);
                        com.smule.pianoandroid.magicpiano.GlobeActivity.c(a);
                    }

            
            {
                a = GlobeActivity.this;
                super();
            }
                };
                if (com.smule.pianoandroid.magicpiano.b.a.a(this))
                {
                    com.smule.pianoandroid.utils.o.a(this, integer, integer, getResources().getString(0x7f0c021e), getResources().getString(0x7f0c021d));
                    return;
                } else
                {
                    integer.run();
                    return;
                }
            }
            if (integer.intValue() == 2)
            {
                com.smule.pianoandroid.utils.o.a(this, K);
            } else
            if (K.isFree)
            {
                y.a(2, getResources().getString(0x7f0c0059), true);
            } else
            {
                y.a(2, getResources().getString(0x7f0c01f8), true);
            }
            ak.a().h();
            return;
        } else
        {
            y.a(2, getResources().getString(0x7f0c0045), true);
            return;
        }
    }

    static boolean a(GlobeActivity globeactivity, boolean flag)
    {
        globeactivity.G = flag;
        return flag;
    }

    static PerformanceV2 b(GlobeActivity globeactivity)
    {
        return globeactivity.p();
    }

    static File b(GlobeActivity globeactivity, File file)
    {
        globeactivity.u = file;
        return file;
    }

    private void b(SongV2 songv2)
    {
        if (songv2 != null && songv2.resourceFilePaths != null && songv2.resourceFilePaths.size() > 0)
        {
            Intent intent = new Intent(this, com/smule/pianoandroid/magicpiano/PreSongActivity);
            intent.putExtra("SONG_MODE", 0);
            intent.putExtra("CREATE_ACTIVITY_ON_FINISH", true);
            intent.putExtra("SONG_MIDI_EXTRA", (String)songv2.resourceFilePaths.get("main"));
            intent.putExtra("SONG_NAME_EXTRA", songv2.title);
            intent.putExtra("SONG_UID_EXTRA", songv2.songId);
            intent.putExtra("SONG_GENRE_EXTRA", songv2.genre);
            intent.putExtra("SONG_COMPOSER_EXTRA", songv2.artist);
            intent.putExtra("SONG_OWNED", Boolean.valueOf(com.smule.android.network.managers.i.a().c(songv2.songId)));
            com.smule.pianoandroid.utils.i.d().a(null, false);
            startActivity(intent);
            finish();
        } else
        {
            songv2 = getResources().getString(0x7f0c00d7);
            y.a(2, songv2, true);
        }
        A = null;
    }

    static boolean b(GlobeActivity globeactivity, boolean flag)
    {
        globeactivity.H = flag;
        return flag;
    }

    static void c(GlobeActivity globeactivity)
    {
        globeactivity.n();
    }

    static View d(GlobeActivity globeactivity)
    {
        return globeactivity.i;
    }

    static TextView e(GlobeActivity globeactivity)
    {
        return globeactivity.k;
    }

    static ImageView f(GlobeActivity globeactivity)
    {
        return globeactivity.j;
    }

    static SongV2 g(GlobeActivity globeactivity)
    {
        return globeactivity.J;
    }

    private void g()
    {
        float f1;
        PerformanceV2 performancev2;
label0:
        {
            f1 = 0.0F;
            if (PianoGlobeBridge.getPlaybackPercentageComplete() >= 0.20000000000000001D)
            {
                performancev2 = p();
                if (performancev2 != null)
                {
                    break label0;
                }
                aa.b(a, "Performance is null, cannot report performance listen");
            }
            return;
        }
        Location location = com.smule.android.f.f.a(this);
        float f2;
        if (location != null)
        {
            f2 = (float)location.getLatitude();
            f1 = (float)location.getLongitude();
        } else
        {
            f2 = 0.0F;
        }
        PerformanceManager.a().a(performancev2.performanceKey, f2, f1, new com.smule.android.network.managers.PerformanceManager.PerformanceResponseCallback() {

            final GlobeActivity a;

            public void handleResponse(com.smule.android.network.managers.q q1)
            {
                if (!q1.a.a())
                {
                    aa.b(com.smule.pianoandroid.magicpiano.GlobeActivity.a, "Failed to report performance listen");
                }
            }

            public volatile void handleResponse(Object obj)
            {
                handleResponse((com.smule.android.network.managers.q)obj);
            }

            
            {
                a = GlobeActivity.this;
                super();
            }
        });
    }

    static ListingV2 h(GlobeActivity globeactivity)
    {
        return globeactivity.K;
    }

    private void h()
    {
        if (!b && !F)
        {
            throw new AssertionError();
        }
        if (isFinishing())
        {
            return;
        }
        if (u != null)
        {
            p();
            aa.c(a, (new StringBuilder()).append("Midi downloaded, starting playback for: ").append(p().songUid).append(u.getAbsolutePath()).toString());
            runOnUiThread(new Runnable() {

                final GlobeActivity a;

                public void run()
                {
                    if (!a.isFinishing()) goto _L2; else goto _L1
_L1:
                    return;
_L2:
                    com.smule.pianoandroid.magicpiano.GlobeActivity.a(a).a(com.smule.pianoandroid.magicpiano.GlobeActivity.b(a).accountIcon.latitude, com.smule.pianoandroid.magicpiano.GlobeActivity.b(a).accountIcon.longitude);
                    synchronized (com.smule.pianoandroid.magicpiano.GlobeActivity.p(a))
                    {
                        PianoGlobeBridge.playPerformanceFromFile(GlobeActivity.k(a).getAbsolutePath());
                    }
                    com.smule.pianoandroid.magicpiano.GlobeActivity.a(a, 0);
                    GlobeActivity.d(a).setClickable(true);
                    com.smule.android.f.c.a(com.smule.pianoandroid.magicpiano.GlobeActivity.f(a), a.getResources().getDrawable(0x7f0200f6));
                    obj1 = com.smule.pianoandroid.magicpiano.GlobeActivity.b(a);
                    boolean flag;
                    if (com.smule.android.network.managers.i.a().c(((PerformanceV2) (obj1)).songUid) || ap.a().b())
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (flag)
                    {
                        com.smule.pianoandroid.magicpiano.GlobeActivity.a(a, ak.a().a(((PerformanceV2) (obj1)).songUid));
                        TextView textview;
                        if (com.smule.pianoandroid.magicpiano.GlobeActivity.g(a) != null)
                        {
                            com.smule.pianoandroid.magicpiano.GlobeActivity.q(a).setVisibility(0);
                        } else
                        {
                            com.smule.pianoandroid.magicpiano.GlobeActivity.q(a).setVisibility(4);
                        }
                    } else
                    {
                        com.smule.pianoandroid.magicpiano.GlobeActivity.a(a, ak.a().f(((PerformanceV2) (obj1)).songUid));
                        if (GlobeActivity.h(a) != null)
                        {
                            com.smule.pianoandroid.magicpiano.GlobeActivity.q(a).setVisibility(0);
                        } else
                        {
                            com.smule.pianoandroid.magicpiano.GlobeActivity.q(a).setVisibility(4);
                        }
                    }
                    com.smule.pianoandroid.magicpiano.GlobeActivity.r(a).setText(((PerformanceV2) (obj1)).accountIcon.handle);
                    GlobeActivity.s(a).setText(((PerformanceV2) (obj1)).title);
                    obj = ak.a().a(((PerformanceV2) (obj1)).songUid);
                    textview = GlobeActivity.t(a);
                    if (obj == null)
                    {
                        obj = "";
                    } else
                    {
                        obj = ((SongV2) (obj)).artist;
                    }
                    textview.setText(((CharSequence) (obj)));
                    com.smule.pianoandroid.magicpiano.GlobeActivity.e(a).setText(String.valueOf(((PerformanceV2) (obj1)).totalLoves));
                    com.smule.android.f.c.a(((PerformanceV2) (obj1)).accountIcon.picUrl, GlobeActivity.u(a), 0x7f020152, true, 0xff444444, null);
                    if (GlobeActivity.v(a) != null)
                    {
                        GlobeActivity.v(a).dismiss();
                        com.smule.pianoandroid.magicpiano.GlobeActivity.a(a, null);
                    }
                    a.a(false);
                    if (GlobeActivity.w(a)) goto _L1; else goto _L3
_L3:
                    com.smule.pianoandroid.magicpiano.GlobeActivity.b(a, true);
                    return;
                    obj1;
                    obj;
                    JVM INSTR monitorexit ;
                    throw obj1;
                }

            
            {
                a = GlobeActivity.this;
                super();
            }
            });
            com.smule.pianoandroid.utils.m.a(this);
            return;
        } else
        {
            runOnUiThread(new Runnable() {

                final GlobeActivity a;

                public void run()
                {
                    if (a.isFinishing())
                    {
                        return;
                    }
                    a.a(false);
                    if (GlobeActivity.v(a) == null)
                    {
                        com.smule.pianoandroid.magicpiano.GlobeActivity.a(a, new an(a, a.getResources().getString(0x7f0c0045)));
                    }
                    GlobeActivity.v(a).a(true);
                    GlobeActivity.v(a).a(2, a.getResources().getString(0x7f0c0045), true);
                }

            
            {
                a = GlobeActivity.this;
                super();
            }
            });
            return;
        }
    }

    private void i()
    {
        aa.a(a, (new StringBuilder()).append("Next downloading ").append(e()).append(" isFinishing ").append(isFinishing()).toString());
        while (e().booleanValue() || isFinishing()) 
        {
            return;
        }
        I = false;
        a(Integer.valueOf(d + 1));
    }

    static void i(GlobeActivity globeactivity)
    {
        globeactivity.g();
    }

    static void j(GlobeActivity globeactivity)
    {
        globeactivity.i();
    }

    static File k(GlobeActivity globeactivity)
    {
        return globeactivity.u;
    }

    static File l(GlobeActivity globeactivity)
    {
        return globeactivity.v;
    }

    private void m()
    {
        aa.a(a, (new StringBuilder()).append("Fetching top performances. offset=").append(N).append(" Loaded Perf size=").append(e.size()).toString());
        a(true);
        int i1 = N;
        N = N + 15;
        M = PerformanceManager.a().a(i1, new TopPerformanceCallback());
        runOnUiThread(new Runnable() {

            final GlobeActivity a;

            public void run()
            {
                while (a.isFinishing() || GlobeActivity.v(a) != null) 
                {
                    return;
                }
                com.smule.pianoandroid.magicpiano.GlobeActivity.a(a, new an(a, a.getResources().getString(0x7f0c029f)));
                GlobeActivity.v(a).a(a);
                GlobeActivity.v(a).setCancelable(false);
                GlobeActivity.v(a).a(false);
            }

            
            {
                a = GlobeActivity.this;
                super();
            }
        });
    }

    static boolean m(GlobeActivity globeactivity)
    {
        return globeactivity.I;
    }

    private void n()
    {
        String s1 = String.format(getResources().getString(0x7f0c00da), new Object[] {
            J.title
        });
        if (z != null)
        {
            z.dismiss();
        }
        z = new com.smule.pianoandroid.magicpiano.i(this, s1);
        z.a(this);
        z.setCancelable(true);
        (new Bundle()).putBoolean("CREATE_ACTIVITY_ON_FINISH", true);
        A = new p(this, J, this, z);
        aa.c(a, (new StringBuilder()).append("Downloading ").append(J.songId).append(" for play").toString());
        A.execute(new Void[] {
            null, null, null
        });
    }

    static boolean n(GlobeActivity globeactivity)
    {
        return globeactivity.F;
    }

    private void o()
    {
        B = new com.smule.pianoandroid.magicpiano.b.a(K, this);
        B.execute(new Void[] {
            null, null, null
        });
    }

    static void o(GlobeActivity globeactivity)
    {
        globeactivity.h();
    }

    private PerformanceV2 p()
    {
        if (e != null && e.size() > 0)
        {
            return (PerformanceV2)e.get(d);
        } else
        {
            return null;
        }
    }

    static SoundPoolSynth p(GlobeActivity globeactivity)
    {
        return globeactivity.w;
    }

    static View q(GlobeActivity globeactivity)
    {
        return globeactivity.n;
    }

    private void q()
    {
        PianoCoreBridge.initSoundPoolBridge(w);
        PianoGlobeBridge.onResume();
        if (w != null)
        {
            w.onResume();
        }
        L.a();
    }

    static TextView r(GlobeActivity globeactivity)
    {
        return globeactivity.f;
    }

    static TextView s(GlobeActivity globeactivity)
    {
        return globeactivity.g;
    }

    static TextView t(GlobeActivity globeactivity)
    {
        return globeactivity.h;
    }

    static ImageView u(GlobeActivity globeactivity)
    {
        return globeactivity.t;
    }

    static an v(GlobeActivity globeactivity)
    {
        return globeactivity.y;
    }

    static boolean w(GlobeActivity globeactivity)
    {
        return globeactivity.H;
    }

    static ArrayList x(GlobeActivity globeactivity)
    {
        return globeactivity.e;
    }

    static int y(GlobeActivity globeactivity)
    {
        return globeactivity.d;
    }

    static void z(GlobeActivity globeactivity)
    {
        globeactivity.o();
    }

    public void a(ListingV2 listingv2, Runnable runnable)
    {
        listingv2 = new as(this, listingv2, com.smule.pianoandroid.e.c.a().b(listingv2.song.songId), runnable, true);
        listingv2.a(this);
        listingv2.show();
    }

    public void a(SongV2 songv2)
    {
        if (E)
        {
            b(songv2);
            return;
        } else
        {
            C = true;
            D = songv2;
            return;
        }
    }

    public void a(String s1)
    {
        List list = ap.a().f();
        if (com.smule.android.network.core.r.a(this) && list != null && !list.isEmpty())
        {
            Intent intent = new Intent(this, com/smule/pianoandroid/magicpiano/PurchaseActivity_);
            intent.putExtra("DESIRED_SUBSCRIPTION", s1);
            startActivity(intent);
            overridePendingTransition(0x7f040013, 0x7f040015);
            return;
        } else
        {
            com.smule.android.network.core.b.d().p();
            return;
        }
    }

    public void a(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        P = flag;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void a(boolean flag, boolean flag1, Integer integer, ListingV2 listingv2)
    {
        if (E)
        {
            a(flag, flag1, integer);
        } else
        {
            R = true;
            U = flag;
            S = flag1;
            T = integer.intValue();
        }
        B = null;
    }

    public boolean a()
    {
        return true;
    }

    public String b()
    {
        return "Globe";
    }

    public void c()
    {
        F = true;
        if (G)
        {
            G = false;
            h();
        }
    }

    public void c_()
    {
        if (A != null)
        {
            A.cancel(true);
            A = null;
        }
        if (B != null)
        {
            B.cancel(true);
            B = null;
        }
        if (y != null)
        {
            y.dismiss();
            y = null;
            aa.b(a, "cancel, dismissing");
        }
        if (z != null)
        {
            z.dismiss();
            z = null;
            aa.b(a, "cancel download progress, dismissing");
        }
        if (!H)
        {
            com.smule.pianoandroid.utils.o.e(this);
            return;
        } else
        {
            a(false);
            I = true;
            return;
        }
    }

    public void d()
    {
        I = false;
        g();
        i();
    }

    public Boolean e()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = P;
        this;
        JVM INSTR monitorexit ;
        return Boolean.valueOf(flag);
        Exception exception;
        exception;
        throw exception;
    }

    protected void f()
    {
        Integer integer = com.smule.pianoandroid.e.c.a().b(K.productId);
        if (K.isFree && integer == null)
        {
            aa.c(a, (new StringBuilder()).append("Claiming list item ").append(K.productId).append(" for play").toString());
            y = new an(this, String.format(getResources().getString(0x7f0c005a), new Object[] {
                K.song.title
            }));
            y.a(this);
            y.setCancelable(true);
            o();
            return;
        }
        if (com.smule.pianoandroid.magicpiano.a.g.a().b(K.song.songId))
        {
            a(K, new Runnable() {

                final GlobeActivity a;

                public void run()
                {
                    GlobeActivity.z(a);
                }

            
            {
                a = GlobeActivity.this;
                super();
            }
            });
            return;
        } else
        {
            com.smule.pianoandroid.utils.o.a(this, K, integer, new Runnable() {

                final GlobeActivity a;

                public void run()
                {
                    String s1 = String.format(a.getResources().getString(0x7f0c01fa), new Object[] {
                        GlobeActivity.h(a).song.title
                    });
                    com.smule.pianoandroid.magicpiano.GlobeActivity.a(a, new an(a, s1));
                    GlobeActivity.v(a).a(a);
                    GlobeActivity.v(a).setCancelable(true);
                    GlobeActivity.z(a);
                }

            
            {
                a = GlobeActivity.this;
                super();
            }
            });
            return;
        }
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        if (i1 != 214) goto _L2; else goto _L1
_L1:
        if (intent == null)
        {
            aa.c(a, "onActivityResult, no data returned");
            return;
        }
        intent = intent.getStringExtra(com.smule.pianoandroid.utils.i.a);
        if (intent == null)
        {
            aa.c(a, "onActivityResult, data does not contain desiredListing extra");
            return;
        }
        K = ak.a().i(intent);
        if (j1 == 216)
        {
            J = K.song;
            n();
        } else
        {
            o();
        }
_L4:
        com.smule.pianoandroid.utils.m.a(this);
        return;
_L2:
        if (L.a(i1) && L.a(i1, j1, intent))
        {
            J = ak.a().a(intent.getStringExtra("PRODUCT_UID"));
            n();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onBackPressed()
    {
        g();
        com.smule.pianoandroid.utils.o.e(this);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle != null)
        {
            bundle = bundle.getString("current_listing");
            if (bundle != null)
            {
                K = ak.a().i(bundle);
            }
        }
        setContentView(0x7f030034);
        bundle = getActionBar();
        View view = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f030035, null);
        bundle.setBackgroundDrawable(getResources().getDrawable(0x7f020051));
        bundle.setCustomView(view);
        bundle.setDisplayShowCustomEnabled(true);
        bundle.show();
        y = new an(this, getResources().getString(0x7f0c029f));
        y.a(this);
        y.a(true);
        y.setCancelable(true);
        c = (GlobeGLSurfaceView)findViewById(0x7f0a00de);
        c.getViewTreeObserver().addOnGlobalLayoutListener(O);
        f = (TextView)findViewById(0x7f0a00e0);
        f.setText("");
        g = (TextView)view.findViewById(0x7f0a0089);
        g.setText("");
        h = (TextView)view.findViewById(0x7f0a00e7);
        h.setText("");
        i = findViewById(0x7f0a00e3);
        j = (ImageView)findViewById(0x7f0a00e4);
        k = (TextView)findViewById(0x7f0a00e5);
        k.setText("");
        t = (ImageView)findViewById(0x7f0a00e6);
        n = view.findViewById(0x7f0a00e8);
        n.setOnClickListener(new android.view.View.OnClickListener() {

            final GlobeActivity a;

            public void onClick(View view1)
            {
                view1 = com.smule.pianoandroid.magicpiano.GlobeActivity.b(a);
                if (view1 != null)
                {
                    if (com.smule.android.network.managers.i.a().c(((PerformanceV2) (view1)).songUid) || ap.a().b())
                    {
                        com.smule.pianoandroid.magicpiano.GlobeActivity.c(a);
                        return;
                    }
                    if (com.smule.android.network.core.r.a(a))
                    {
                        a.f();
                        return;
                    }
                }
            }

            
            {
                a = GlobeActivity.this;
                super();
            }
        });
        i.setOnClickListener(new android.view.View.OnClickListener() {

            final GlobeActivity a;

            public void onClick(View view1)
            {
                class a
                    implements Runnable
                {

                    View a;
                    final GlobeActivity b;

                    public void run()
                    {
                        float f2 = 0.0F;
                        PerformanceV2 performancev2 = com.smule.pianoandroid.magicpiano.GlobeActivity.b(b);
                        if (!com.smule.pianoandroid.utils.o.a(b))
                        {
                            return;
                        }
                        String s1 = performancev2.performanceKey;
                        String s2 = performancev2.songUid;
                        float f1;
                        Object obj;
                        if (performancev2.ensembleType.equalsIgnoreCase("MIX"))
                        {
                            obj = f.e;
                        } else
                        {
                            obj = f.a;
                        }
                        com.smule.android.c.a.a(s1, s2, ((f) (obj)), null);
                        GlobeActivity.d(b).setClickable(false);
                        obj = com.smule.android.f.f.a(b);
                        if (obj != null)
                        {
                            f2 = (float)((Location) (obj)).getLatitude();
                            f1 = (float)((Location) (obj)).getLongitude();
                        } else
                        {
                            f1 = 0.0F;
                        }
                        PerformanceManager.a().a(performancev2.performanceKey, f2, f1, new NetworkResponseCallback(this, performancev2) {

                            final PerformanceV2 a;
                            final a b;

                            public void handleResponse(com.smule.android.network.core.o o1)
                            {
                                if (o1 != null && o1.a == com.smule.android.network.core.p.a && o1.b == 0)
                                {
                                    b.a.post(new Runnable(this) {

                                        final _cls1 a;

                                        public void run()
                                        {
                                            PerformanceV2 performancev2 = a.a;
                                            performancev2.totalLoves = performancev2.totalLoves + 1;
                                            com.smule.pianoandroid.magicpiano.GlobeActivity.e(a.b.b).setText(String.valueOf(a.a.totalLoves));
                                            com.smule.android.f.c.a(com.smule.pianoandroid.magicpiano.GlobeActivity.f(a.b.b), a.b.b.getResources().getDrawable(0x7f0200f7));
                                        }

            
            {
                a = _pcls1;
                super();
            }
                                    });
                                    return;
                                } else
                                {
                                    com.smule.android.network.core.b.a(o1);
                                    MagicApplication.getInstance().showToast(b.b.getResources().getString(0x7f0c0045), 0);
                                    return;
                                }
                            }

                            public volatile void handleResponse(Object obj)
                            {
                                handleResponse((com.smule.android.network.core.o)obj);
                            }

            
            {
                b = a1;
                a = performancev2;
                super();
            }
                        });
                        if (com.smule.pianoandroid.magicpiano.GlobeActivity.g(b) == null) goto _L2; else goto _L1
_L1:
                        com.smule.pianoandroid.magicpiano.a.e.a("loved_perf", com.smule.pianoandroid.magicpiano.GlobeActivity.g(b));
_L4:
                        com.smule.pianoandroid.utils.m.a(b);
                        return;
_L2:
                        if (GlobeActivity.h(b) != null && GlobeActivity.h(b).song != null)
                        {
                            com.smule.pianoandroid.magicpiano.a.e.a("loved_perf", GlobeActivity.h(b).song);
                        }
                        if (true) goto _L4; else goto _L3
_L3:
                    }

            a(View view)
            {
                b = GlobeActivity.this;
                super();
                a = view;
            }
                }

                com.smule.pianoandroid.utils.o.a(a, a. new a(view1), null, a.getResources().getString(0x7f0c0212), a.getResources().getString(0x7f0c0211));
            }

            
            {
                a = GlobeActivity.this;
                super();
            }
        });
        l = findViewById(0x7f0a00e1);
        l.setOnClickListener(new android.view.View.OnClickListener() {

            final GlobeActivity a;

            public void onClick(View view1)
            {
                com.smule.pianoandroid.magicpiano.GlobeActivity.i(a);
                GlobeActivity.j(a);
            }

            
            {
                a = GlobeActivity.this;
                super();
            }
        });
        m = findViewById(0x7f0a00e1);
        c.setKeepScreenOn(true);
        setVolumeControlStream(3);
        if (((AudioManager)getSystemService("audio")).isWiredHeadsetOn())
        {
            SoundPoolSynth.setVolumeScaleForHeadphones(1);
        } else
        {
            SoundPoolSynth.setVolumeScaleForHeadphones(0);
        }
        bundle = new IntentFilter("android.intent.action.HEADSET_PLUG");
        x = new com.smule.pianoandroid.magicpiano.o(this);
        registerReceiver(x, bundle);
        L = new com.smule.pianoandroid.magicpiano.a.a(this);
        w = new SoundPoolSynth();
        w.onCreate(getApplicationContext());
        PianoCoreBridge.initSoundPoolBridge(w);
        PianoGlobeBridge.playbackEndedCallback = this;
        PianoGlobeBridge.sGlobeInitializedCallback = this;
        i();
        com.smule.pianoandroid.utils.q.p();
        com.smule.pianoandroid.utils.m.a(this);
    }

    public void onDestroy()
    {
        L.c();
        super.onDestroy();
        unregisterReceiver(x);
        if (A != null)
        {
            A.a = null;
        }
        if (B != null)
        {
            B.a = null;
        }
        ViewTreeObserver viewtreeobserver = c.getViewTreeObserver();
        com.smule.pianoandroid.utils.n.a(O, viewtreeobserver);
        if (u != null && u.exists())
        {
            u.delete();
        }
        if (v != null && v.exists())
        {
            v.delete();
        }
        if (M != null)
        {
            M.cancel(true);
            M = null;
        }
    }

    protected void onPause()
    {
        super.onPause();
        E = false;
        PianoGlobeBridge.onPause();
        if (w != null)
        {
            w.onPause();
        }
        MagicApplication.getInstance().onPause();
        L.b();
        com.smule.pianoandroid.utils.m.a(this);
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
    }

    protected void onResume()
    {
        super.onResume();
        E = true;
        if (Q)
        {
            q();
        }
        if (C)
        {
            b(D);
            C = false;
        }
        if (R)
        {
            a(U, S, Integer.valueOf(T));
        }
        com.smule.android.c.a.a(com.smule.pianoandroid.utils.r.c);
        MagicApplication.getInstance().onResume();
        com.smule.pianoandroid.utils.m.a(this);
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (K != null)
        {
            bundle.putString("current_listing", K.listingId);
        }
    }

    protected void onStart()
    {
        super.onStart();
        MagicApplication.onActivityStart(this);
    }

    protected void onStop()
    {
        super.onStop();
        MagicApplication.onActivityStop(this);
        if (isFinishing())
        {
            g();
        }
    }

    public void onWindowFocusChanged(boolean flag)
    {
        super.onWindowFocusChanged(flag);
        if (flag && E && !Q)
        {
            q();
        }
        Q = flag;
    }

    static 
    {
        boolean flag;
        if (!com/smule/pianoandroid/magicpiano/GlobeActivity.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b = flag;
    }

    private class TopPerformanceCallback
        implements com.smule.android.network.managers.PerformanceManager.PerformancesResponseCallback
    {

        final GlobeActivity a;

        public void handleResponse(s s1)
        {
            if (a.isFinishing())
            {
                return;
            }
            if (s1 == null || !s1.a.a())
            {
                a.runOnUiThread(new Runnable(s1) {

                    final s a;
                    final TopPerformanceCallback b;

                    public void run()
                    {
                        b.a.a(false);
                        if (a != null)
                        {
                            com.smule.android.network.core.b.a(a.a);
                        }
                        GlobeActivity.v(b.a).a(2, b.a.getResources().getString(0x7f0c0045), true);
                        com.smule.pianoandroid.magicpiano.GlobeActivity.a(b.a, 4);
                    }

                
                {
                    b = TopPerformanceCallback.this;
                    a = s1;
                    super();
                }
                });
                return;
            }
            aa.c(com.smule.pianoandroid.magicpiano.GlobeActivity.a, (new StringBuilder()).append("Downloaded ").append(s1.mPerformances.size()).append(" performances.").toString());
            GlobeActivity.x(a).addAll(s1.mPerformances);
            if (!s1.mPerformances.isEmpty())
            {
                com.smule.pianoandroid.magicpiano.GlobeActivity.a(a, Integer.valueOf(GlobeActivity.y(a)));
                return;
            } else
            {
                a.runOnUiThread(new Runnable() {

                    final TopPerformanceCallback a;

                    public void run()
                    {
                        a.a.a(false);
                        com.smule.pianoandroid.magicpiano.GlobeActivity.a(a.a, 4);
                    }

                
                {
                    a = TopPerformanceCallback.this;
                    super();
                }
                });
                return;
            }
        }

        public volatile void handleResponse(Object obj)
        {
            handleResponse((s)obj);
        }

        public TopPerformanceCallback()
        {
            a = GlobeActivity.this;
            super();
        }
    }

}
