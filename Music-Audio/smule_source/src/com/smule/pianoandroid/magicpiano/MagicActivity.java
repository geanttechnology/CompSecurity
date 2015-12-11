// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.smule.android.c.aa;
import com.smule.android.c.ab;
import com.smule.android.c.f;
import com.smule.android.c.w;
import com.smule.android.c.z;
import com.smule.android.f.h;
import com.smule.android.network.managers.PerformanceManager;
import com.smule.android.network.managers.ak;
import com.smule.android.network.managers.ap;
import com.smule.android.network.models.SongV2;
import com.smule.magicpiano.PianoCoreBridge;
import com.smule.magicpiano.b;
import com.smule.magicpiano.c;
import com.smule.pianoandroid.magicpiano.a.k;
import com.smule.pianoandroid.magicpiano.c.a;
import com.smule.pianoandroid.synths.SoundPoolSynth;
import com.smule.pianoandroid.utils.i;
import com.smule.pianoandroid.utils.m;
import com.smule.pianoandroid.utils.n;
import com.smule.pianoandroid.utils.o;
import com.smule.pianoandroid.utils.q;
import java.io.File;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ag, ProductListActivity, av, a, 
//            MagicGLSurfaceView, u, w, DailyChallengeActivity, 
//            PauseDialogActivity_, PreSongActivity, MagicApplication, v, 
//            ProductListFragment

public class MagicActivity extends ag
    implements ab, b, c
{

    static final String a = com/smule/pianoandroid/magicpiano/MagicActivity.getName();
    private View A;
    private TextView B;
    private View C;
    private View D;
    private View E;
    private TextView F;
    private boolean G;
    private boolean H;
    private View I;
    private ProgressBar J;
    private TextView K;
    private TextView L;
    private TextView M;
    private TextView N;
    private Button O;
    private Button P;
    private long Q;
    private int R;
    private TimerTask S;
    private Button T;
    private Button U;
    private Button V;
    private Button W;
    private int X;
    private boolean Y;
    private boolean Z;
    private int aa;
    private u ab;
    public MagicGLSurfaceView b;
    public String c;
    public SongV2 d;
    Observer e;
    TimerTask f;
    private SoundPoolSynth g;
    private boolean h;
    private boolean i;
    private boolean j;
    private int k;
    private boolean l;
    private int m;
    private String n;
    private String t;
    private String u;
    private String v;
    private v w;
    private Timer x;
    private TextView y;
    private TextView z;

    public MagicActivity()
    {
        h = false;
        i = false;
        j = false;
        G = false;
        H = false;
        Y = false;
        Z = true;
        ab = null;
    }

    private void A()
    {
        PianoCoreBridge.uninitNative();
        Intent intent = new Intent(this, com/smule/pianoandroid/magicpiano/ProductListActivity);
        intent.addFlags(0x4000000);
        startActivity(intent);
        finish();
    }

    static int a(MagicActivity magicactivity)
    {
        return magicactivity.k;
    }

    static int a(MagicActivity magicactivity, int i1)
    {
        i1 = magicactivity.X - i1;
        magicactivity.X = i1;
        return i1;
    }

    static View a(MagicActivity magicactivity, View view)
    {
        magicactivity.C = view;
        return view;
    }

    static TextView a(MagicActivity magicactivity, TextView textview)
    {
        magicactivity.F = textview;
        return textview;
    }

    static u a(MagicActivity magicactivity, u u1)
    {
        magicactivity.ab = u1;
        return u1;
    }

    static TimerTask a(MagicActivity magicactivity, TimerTask timertask)
    {
        magicactivity.S = timertask;
        return timertask;
    }

    private void a(View view)
    {
        view.setVisibility(0);
        view.clearAnimation();
        view.startAnimation(AnimationUtils.loadAnimation(this, 0x7f040014));
    }

    private void a(View view, int i1)
    {
        Animation animation = AnimationUtils.loadAnimation(this, i1);
        animation.setAnimationListener(new android.view.animation.Animation.AnimationListener(view) {

            final View a;
            final MagicActivity b;

            public void onAnimationEnd(Animation animation1)
            {
                a.setVisibility(8);
            }

            public void onAnimationRepeat(Animation animation1)
            {
            }

            public void onAnimationStart(Animation animation1)
            {
            }

            
            {
                b = MagicActivity.this;
                a = view;
                super();
            }
        });
        view.startAnimation(animation);
    }

    private void a(View view, Runnable runnable)
    {
        view.clearAnimation();
        Animation animation = AnimationUtils.loadAnimation(this, 0x7f040016);
        view.startAnimation(animation);
        animation.setAnimationListener(new android.view.animation.Animation.AnimationListener(view, runnable) {

            final View a;
            final Runnable b;
            final MagicActivity c;

            public void onAnimationEnd(Animation animation1)
            {
                a.setVisibility(4);
                if (b != null)
                {
                    b.run();
                }
            }

            public void onAnimationRepeat(Animation animation1)
            {
            }

            public void onAnimationStart(Animation animation1)
            {
            }

            
            {
                c = MagicActivity.this;
                a = view;
                b = runnable;
                super();
            }
        });
    }

    private void a(TextView textview, int i1)
    {
        runOnUiThread(new Runnable(i1, textview) {

            final int a;
            final TextView b;
            final MagicActivity c;

            public void run()
            {
                if (a != 0)
                {
                    if (b.getVisibility() == 4)
                    {
                        b.setVisibility(0);
                    } else
                    {
                        com.smule.pianoandroid.magicpiano.MagicActivity.a(c, b, null);
                    }
                    b.setText(c.getString(a));
                    com.smule.pianoandroid.magicpiano.MagicActivity.b(c, b);
                    return;
                } else
                {
                    com.smule.pianoandroid.magicpiano.MagicActivity.a(c, b, new Runnable(this) {

                        final _cls12 a;

                        public void run()
                        {
                            a.b.setText("");
                        }

            
            {
                a = _pcls12;
                super();
            }
                    });
                    return;
                }
            }

            
            {
                c = MagicActivity.this;
                a = i1;
                b = textview;
                super();
            }
        });
    }

    static void a(MagicActivity magicactivity, View view, int i1)
    {
        magicactivity.a(view, i1);
    }

    static void a(MagicActivity magicactivity, View view, Runnable runnable)
    {
        magicactivity.a(view, runnable);
    }

    static void a(MagicActivity magicactivity, boolean flag)
    {
        magicactivity.a(flag);
    }

    private void a(boolean flag)
    {
        if (flag)
        {
            com.smule.android.c.w.a("sync_audio_success", (new z()).a("target", PianoCoreBridge.getSong().songId).a("value", String.valueOf(X)));
            com.smule.pianoandroid.magicpiano.av.b(this, X);
            com.smule.pianoandroid.magicpiano.av.b(this, true);
            PianoCoreBridge.setLatencyCompensation((float)X / 1000F);
        } else
        {
            X = com.smule.pianoandroid.magicpiano.a.a().a(this).intValue();
            PianoCoreBridge.setLatencyCompensation((float)X / 1000F);
        }
        k = 0;
        T.setVisibility(8);
        U.setVisibility(8);
        V.setVisibility(8);
        W.setVisibility(8);
        E.setVisibility(8);
        PianoCoreBridge.syncComplete();
        m();
        PianoCoreBridge.restartPerformance(this);
    }

    static int b(MagicActivity magicactivity, int i1)
    {
        magicactivity.X = i1;
        return i1;
    }

    static void b(MagicActivity magicactivity, View view)
    {
        magicactivity.a(view);
    }

    static boolean b(MagicActivity magicactivity)
    {
        return magicactivity.l;
    }

    static int c(MagicActivity magicactivity, int i1)
    {
        i1 = magicactivity.X + i1;
        magicactivity.X = i1;
        return i1;
    }

    static boolean c(MagicActivity magicactivity)
    {
        return magicactivity.G;
    }

    static int d(MagicActivity magicactivity, int i1)
    {
        magicactivity.aa = i1;
        return i1;
    }

    static void d(MagicActivity magicactivity)
    {
        magicactivity.o();
    }

    static void e(MagicActivity magicactivity)
    {
        magicactivity.n();
    }

    static ProgressBar f(MagicActivity magicactivity)
    {
        return magicactivity.J;
    }

    static void g(MagicActivity magicactivity)
    {
        magicactivity.s();
    }

    static int h(MagicActivity magicactivity)
    {
        return magicactivity.X;
    }

    static void i(MagicActivity magicactivity)
    {
        magicactivity.r();
    }

    static String j(MagicActivity magicactivity)
    {
        return magicactivity.u;
    }

    static String k(MagicActivity magicactivity)
    {
        return magicactivity.v;
    }

    static void l(MagicActivity magicactivity)
    {
        magicactivity.v();
    }

    static View m(MagicActivity magicactivity)
    {
        return magicactivity.D;
    }

    private void m()
    {
        boolean flag;
        if (!com.smule.pianoandroid.magicpiano.c.a.a().h() && k == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        PianoCoreBridge.setJoin(Boolean.valueOf(true), Boolean.valueOf(flag));
        PianoCoreBridge.setJoinAudioFile(t, false);
        if (k == 1 || k == 2)
        {
            PianoCoreBridge.setVoxVolume(0.7F);
        } else
        {
            PianoCoreBridge.setVoxVolume(av.g(this));
        }
        PianoCoreBridge.setLatencyCompensation((float)com.smule.pianoandroid.magicpiano.a.a().a(this).intValue() / 1000F);
        PianoCoreBridge.sEnterFreeplayCallback = this;
    }

    static View n(MagicActivity magicactivity)
    {
        return magicactivity.C;
    }

    private void n()
    {
        com.smule.android.c.aa.c(a, "resumeCore");
        PianoCoreBridge.reloadTextures();
        PianoCoreBridge.resize(b.getRendererWidth(), b.getRendererHeight());
        H = true;
    }

    static int o(MagicActivity magicactivity)
    {
        return magicactivity.aa;
    }

    private void o()
    {
        com.smule.android.c.aa.c(a, "renderer initialized, calling initCore");
        PianoCoreBridge.initGfx(getApplicationContext(), b.getRendererWidth(), b.getRendererHeight());
        k;
        JVM INSTR tableswitch 0 2: default 60
    //                   0 71
    //                   1 210
    //                   2 202;
           goto _L1 _L2 _L3 _L4
_L1:
        G = true;
        H = true;
        return;
_L2:
        if (com.smule.pianoandroid.magicpiano.c.a.a().c())
        {
            com.smule.pianoandroid.magicpiano.suggestions.c.a().a(d.songId);
        }
        PianoCoreBridge.togglePianoVisuals(false);
        PianoCoreBridge.leaveFreeplay();
        PianoCoreBridge.startPerformanceFromFile(n, false);
        PianoCoreBridge.setPaused(true);
        Timer timer = new Timer();
        if (!com.smule.pianoandroid.magicpiano.c.a.a().c())
        {
            S = new TimerTask() {

                final MagicActivity a;

                public void run()
                {
                    a.e();
                    MagicActivity.g(a);
                }

            
            {
                a = MagicActivity.this;
                super();
            }
            };
            timer.schedule(S, 3500L);
        } else
        {
            s();
            S = new TimerTask() {

                final MagicActivity a;

                public void run()
                {
                    a.e();
                }

            
            {
                a = MagicActivity.this;
                super();
            }
            };
            TimerTask timertask = S;
            long l1;
            if (PianoCoreBridge.isJoin())
            {
                l1 = 3300L;
            } else
            {
                l1 = 1000L;
            }
            timer.schedule(timertask, l1);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        c(R);
_L3:
        com.smule.android.c.w.b("perf_time");
        PianoCoreBridge.setPaused(false);
        PianoCoreBridge.togglePianoVisuals(false);
        PianoCoreBridge.leaveFreeplay();
        PianoCoreBridge.startPerformanceFromFile(n, true);
        s();
        if (true) goto _L1; else goto _L5
_L5:
    }

    static TextView p(MagicActivity magicactivity)
    {
        return magicactivity.F;
    }

    private void p()
    {
        E = findViewById(0x7f0a0150);
        B = (TextView)findViewById(0x7f0a0151);
        K = (TextView)findViewById(0x7f0a0158);
        L = (TextView)findViewById(0x7f0a015a);
        M = (TextView)findViewById(0x7f0a015c);
        N = (TextView)findViewById(0x7f0a015e);
        I = findViewById(0x7f0a0152);
        z = (TextView)findViewById(0x7f0a0156);
        A = findViewById(0x7f0a0154);
        D = findViewById(0x7f0a0142);
        if (!com.smule.pianoandroid.magicpiano.c.a.a().c())
        {
            com.smule.pianoandroid.utils.q.w();
        } else
        if (PianoCoreBridge.isJoin() && !com.smule.pianoandroid.magicpiano.c.a.a().h() && k == 0)
        {
            com.smule.pianoandroid.utils.q.n(c);
            return;
        }
    }

    static u q(MagicActivity magicactivity)
    {
        return magicactivity.ab;
    }

    private void q()
    {
        B.setText(getResources().getString(0x7f0c0034));
        E.setVisibility(0);
        X = com.smule.pianoandroid.magicpiano.a.a().a(this).intValue();
        T = (Button)findViewById(0x7f0a013c);
        T.setVisibility(0);
        T.setOnClickListener(new android.view.View.OnClickListener() {

            final MagicActivity a;

            public void onClick(View view)
            {
                com.smule.pianoandroid.magicpiano.MagicActivity.a(a, false);
            }

            
            {
                a = MagicActivity.this;
                super();
            }
        });
        U = (Button)findViewById(0x7f0a013d);
        U.setVisibility(0);
        U.setOnClickListener(new android.view.View.OnClickListener() {

            final MagicActivity a;

            public void onClick(View view)
            {
                com.smule.pianoandroid.magicpiano.MagicActivity.a(a, true);
            }

            
            {
                a = MagicActivity.this;
                super();
            }
        });
        V = (Button)findViewById(0x7f0a013f);
        V.setVisibility(0);
        V.setOnClickListener(new android.view.View.OnClickListener() {

            final MagicActivity a;

            public void onClick(View view)
            {
                com.smule.pianoandroid.magicpiano.MagicActivity.a(a, 20);
                if (com.smule.pianoandroid.magicpiano.MagicActivity.h(a) < 0)
                {
                    com.smule.pianoandroid.magicpiano.MagicActivity.b(a, 0);
                }
                PianoCoreBridge.setLatencyCompensation((float)com.smule.pianoandroid.magicpiano.MagicActivity.h(a) / 1000F);
                com.smule.pianoandroid.magicpiano.MagicActivity.i(a);
            }

            
            {
                a = MagicActivity.this;
                super();
            }
        });
        W = (Button)findViewById(0x7f0a013e);
        W.setVisibility(0);
        W.setOnClickListener(new android.view.View.OnClickListener() {

            final MagicActivity a;

            public void onClick(View view)
            {
                com.smule.pianoandroid.magicpiano.MagicActivity.c(a, 20);
                if (com.smule.pianoandroid.magicpiano.MagicActivity.h(a) > 500)
                {
                    com.smule.pianoandroid.magicpiano.MagicActivity.b(a, 500);
                }
                PianoCoreBridge.setLatencyCompensation((float)com.smule.pianoandroid.magicpiano.MagicActivity.h(a) / 1000F);
                com.smule.pianoandroid.magicpiano.MagicActivity.i(a);
            }

            
            {
                a = MagicActivity.this;
                super();
            }
        });
        r();
    }

    private void r()
    {
        boolean flag1 = true;
        Button button = V;
        boolean flag;
        if (X > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        button.setEnabled(flag);
        button = W;
        if (X < 500)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        button.setEnabled(flag);
    }

    static void r(MagicActivity magicactivity)
    {
        magicactivity.u();
    }

    static int s(MagicActivity magicactivity)
    {
        return magicactivity.m;
    }

    private void s()
    {
        if (com.smule.pianoandroid.magicpiano.c.a.a().c() && (!PianoCoreBridge.isJoin() || com.smule.pianoandroid.magicpiano.c.a.a().h() || k != 0))
        {
            if (k == 2 || k == 1)
            {
                t();
                return;
            }
            if (k == 0)
            {
                u();
                return;
            }
        }
    }

    private void t()
    {
        runOnUiThread(new Runnable() {

            final MagicActivity a;

            public void run()
            {
                ((TextView)a.findViewById(0x7f0a0161)).setText(MagicActivity.j(a));
                ((TextView)a.findViewById(0x7f0a0162)).setText(com.smule.pianoandroid.magicpiano.MagicActivity.k(a));
                if (PianoCoreBridge.isJoin())
                {
                    a.findViewById(0x7f0a0163).setVisibility(0);
                    MagicActivity.l(a);
                }
            }

            
            {
                a = MagicActivity.this;
                super();
            }
        });
    }

    static void t(MagicActivity magicactivity)
    {
        magicactivity.m();
    }

    static String u(MagicActivity magicactivity)
    {
        return magicactivity.n;
    }

    private void u()
    {
        runOnUiThread(new Runnable() {

            final MagicActivity a;

            public void run()
            {
                a.findViewById(0x7f0a0141).setVisibility(0);
                ((TextView)a.findViewById(0x7f0a0143)).setText(MagicActivity.j(a));
                ((TextView)a.findViewById(0x7f0a0144)).setText(com.smule.pianoandroid.magicpiano.MagicActivity.k(a));
                Animation animation = AnimationUtils.loadAnimation(a, 0x7f040017);
                animation.setAnimationListener(new android.view.animation.Animation.AnimationListener(this) {

                    final _cls5 a;

                    public void onAnimationEnd(Animation animation)
                    {
                        a.a.findViewById(0x7f0a0141).setVisibility(8);
                    }

                    public void onAnimationRepeat(Animation animation)
                    {
                    }

                    public void onAnimationStart(Animation animation)
                    {
                    }

            
            {
                a = _pcls5;
                super();
            }
                });
                com.smule.pianoandroid.magicpiano.MagicActivity.m(a).startAnimation(animation);
                if (PianoCoreBridge.isJoin())
                {
                    com.smule.pianoandroid.magicpiano.MagicActivity.a(a, a.findViewById(0x7f0a0145));
                    com.smule.pianoandroid.magicpiano.MagicActivity.n(a).setVisibility(0);
                    com.smule.pianoandroid.magicpiano.MagicActivity.a(a, (TextView)a.findViewById(0x7f0a0146));
                    MagicActivity.d(a, 3);
                    MagicActivity.p(a).setText(Integer.toString(com.smule.pianoandroid.magicpiano.MagicActivity.o(a)));
                    com.smule.pianoandroid.magicpiano.MagicActivity.a(a, new u(a, 4500L, 1000L));
                    com.smule.pianoandroid.magicpiano.MagicActivity.q(a).start();
                    MagicActivity.l(a);
                    com.smule.pianoandroid.magicpiano.MagicActivity.n(a).findViewById(0x7f0a0148).startAnimation(AnimationUtils.loadAnimation(a, 0x7f04000d));
                    Animation animation1 = AnimationUtils.loadAnimation(a, 0x7f04000f);
                    animation1.setAnimationListener(new android.view.animation.Animation.AnimationListener(this) {

                        final _cls5 a;

                        public void onAnimationEnd(Animation animation)
                        {
                            com.smule.pianoandroid.magicpiano.MagicActivity.n(a.a).setVisibility(8);
                        }

                        public void onAnimationRepeat(Animation animation)
                        {
                        }

                        public void onAnimationStart(Animation animation)
                        {
                        }

            
            {
                a = _pcls5;
                super();
            }
                    });
                    com.smule.pianoandroid.magicpiano.MagicActivity.n(a).startAnimation(animation1);
                }
            }

            
            {
                a = MagicActivity.this;
                super();
            }
        });
    }

    static TimerTask v(MagicActivity magicactivity)
    {
        return magicactivity.S;
    }

    private void v()
    {
        LinkedList linkedlist = com.smule.pianoandroid.utils.n.a(d);
        TextView textview = (TextView)findViewById(0x7f0a014a);
        ImageView imageview = (ImageView)findViewById(0x7f0a0149);
        ImageView imageview1 = (ImageView)findViewById(0x7f0a014c);
        TextView textview1 = (TextView)findViewById(0x7f0a014d);
        if (linkedlist.isEmpty())
        {
            com.smule.android.c.aa.b(a, "No singer info!");
            findViewById(0x7f0a0031).setVisibility(8);
            return;
        }
        textview.setText((CharSequence)((Pair)linkedlist.get(0)).first);
        com.smule.android.f.c.a((String)((Pair)linkedlist.get(0)).second, imageview, 0, true, 0);
        if (linkedlist.size() > 1)
        {
            ((TextView)findViewById(0x7f0a0147)).setText(getString(0x7f0c02bc));
            textview1.setText((CharSequence)((Pair)linkedlist.get(1)).first);
            com.smule.android.f.c.a((String)((Pair)linkedlist.get(1)).second, imageview1, 0, true, 0);
            imageview1.setVisibility(0);
            textview1.setVisibility(0);
            return;
        } else
        {
            findViewById(0x7f0a014b).setVisibility(8);
            findViewById(0x7f0a0031).setVisibility(8);
            return;
        }
    }

    static View w(MagicActivity magicactivity)
    {
        return magicactivity.I;
    }

    private void w()
    {
        if (f != null)
        {
            f.cancel();
            f = null;
        }
        if (S != null)
        {
            S.cancel();
            S = null;
        }
        if (ab != null)
        {
            ab.cancel();
            ab = null;
        }
    }

    static int x(MagicActivity magicactivity)
    {
        int i1 = magicactivity.aa;
        magicactivity.aa = i1 - 1;
        return i1;
    }

    private void x()
    {
        com.smule.android.c.aa.c(a, "resumeSong");
        Timer timer = new Timer();
        f = new com.smule.pianoandroid.magicpiano.w(this);
        timer.schedule(f, 1000L);
    }

    private long y()
    {
        return Math.round(com.smule.android.c.w.e("perf_time"));
    }

    static TextView y(MagicActivity magicactivity)
    {
        return magicactivity.N;
    }

    private void z()
    {
        Intent intent = new Intent(this, com/smule/pianoandroid/magicpiano/DailyChallengeActivity);
        intent.addFlags(0x4000000);
        startActivity(intent);
        finish();
    }

    static void z(MagicActivity magicactivity)
    {
        magicactivity.q();
    }

    public void a(int i1)
    {
        if (k == 1 || k == 2)
        {
            return;
        } else
        {
            runOnUiThread(new Runnable(i1) {

                final int a;
                final MagicActivity b;

                public void run()
                {
                    if (a == 1)
                    {
                        com.smule.pianoandroid.magicpiano.MagicActivity.w(b).setVisibility(0);
                        Animation animation = AnimationUtils.loadAnimation(b, 0x7f04000c);
                        animation.setAnimationListener(new android.view.animation.Animation.AnimationListener(this) {

                            final _cls8 a;

                            public void onAnimationEnd(Animation animation)
                            {
                                com.smule.pianoandroid.magicpiano.MagicActivity.w(a.b).setVisibility(8);
                                com.smule.pianoandroid.magicpiano.MagicActivity.w(a.b).clearAnimation();
                            }

                            public void onAnimationRepeat(Animation animation)
                            {
                            }

                            public void onAnimationStart(Animation animation)
                            {
                            }

            
            {
                a = _pcls8;
                super();
            }
                        });
                        com.smule.pianoandroid.magicpiano.MagicActivity.w(b).startAnimation(animation);
                    }
                }

            
            {
                b = MagicActivity.this;
                a = i1;
                super();
            }
            });
            return;
        }
    }

    public void a(String s1)
    {
        if (y != null && com.smule.pianoandroid.magicpiano.c.a.a().c() && (!j || j && com.smule.pianoandroid.magicpiano.c.a.a().h()))
        {
            y.setVisibility(0);
            y.setText(s1);
            a(((View) (y)), 0x7f04000b);
        }
    }

    public boolean a()
    {
        return true;
    }

    public String b()
    {
        switch (k)
        {
        default:
            return a;

        case 0: // '\0'
            return "Play";

        case 1: // '\001'
            return "Hear";

        case 2: // '\002'
            return "Preview";
        }
    }

    public void b(int i1)
    {
        if (J != null)
        {
            runOnUiThread(new Runnable(i1) {

                final int a;
                final MagicActivity b;

                public void run()
                {
                    com.smule.pianoandroid.magicpiano.MagicActivity.f(b).setProgress(a);
                }

            
            {
                b = MagicActivity.this;
                a = i1;
                super();
            }
            });
        }
    }

    public void b(String s1)
    {
        runOnUiThread(new Runnable(s1) {

            final String a;
            final MagicActivity b;

            public void run()
            {
                MagicActivity.y(b).setVisibility(0);
                MagicActivity.y(b).setText(a);
                com.smule.pianoandroid.magicpiano.MagicActivity.a(b, MagicActivity.y(b), 0x7f040018);
            }

            
            {
                b = MagicActivity.this;
                a = s1;
                super();
            }
        });
    }

    public void c()
    {
        if (!Y)
        {
            g();
        }
        Y = true;
    }

    protected void c(int i1)
    {
        if (x != null)
        {
            x.cancel();
        }
        x = new Timer();
        TimerTask timertask = new TimerTask() {

            final MagicActivity a;

            public void run()
            {
                PianoCoreBridge.leavePerformance();
            }

            
            {
                a = MagicActivity.this;
                super();
            }
        };
        x.schedule(timertask, i1);
        runOnUiThread(new Runnable() {

            final MagicActivity a;

            public void run()
            {
                a.b.setKeepScreenOn(true);
            }

            
            {
                a = MagicActivity.this;
                super();
            }
        });
        Q = System.nanoTime();
        R = i1;
    }

    public void d(int i1)
    {
        com.smule.android.c.aa.a(a, (new StringBuilder()).append("title id ").append(i1).toString());
        a(K, i1);
    }

    public boolean d()
    {
        return H;
    }

    public void e()
    {
        w();
        if (!h) goto _L2; else goto _L1
_L1:
        if (!d())
        {
            break MISSING_BLOCK_LABEL_73;
        }
        PianoCoreBridge.setPaused(false);
        g.onResume();
        if (k != 5) goto _L4; else goto _L3
_L3:
        h();
_L2:
        return;
_L4:
        if (k == 2)
        {
            c(R);
            return;
        }
        if (k != 0) goto _L2; else goto _L5
_L5:
        com.smule.android.c.w.b("perf_time");
        return;
        Timer timer = new Timer();
        f = new com.smule.pianoandroid.magicpiano.w(this);
        timer.schedule(f, 1000L);
        com.smule.android.c.aa.c(a, "startSong: renderer not ready, waiting to start song");
        return;
    }

    public void e(int i1)
    {
        a(L, i1);
    }

    public void f()
    {
        S = new TimerTask() {

            final MagicActivity a;

            public void run()
            {
                a.runOnUiThread(new Runnable(this) {

                    final _cls7 a;

                    public void run()
                    {
                        com.smule.pianoandroid.magicpiano.MagicActivity.f(a.a).setProgress(0);
                        com.smule.pianoandroid.magicpiano.MagicActivity.f(a.a).setVisibility(0);
                    }

            
            {
                a = _pcls7;
                super();
            }
                });
                MagicActivity.r(a);
                com.smule.pianoandroid.magicpiano.MagicActivity.a(a, new TimerTask(this) {

                    final _cls7 a;

                    public void run()
                    {
                        PianoCoreBridge.setDifficulty(MagicActivity.s(a.a));
                        MagicActivity.t(a.a);
                        PianoCoreBridge.startPerformanceFromFile(MagicActivity.u(a.a), false);
                        a.a.e();
                    }

            
            {
                a = _pcls7;
                super();
            }
                });
                (new Timer()).schedule(MagicActivity.v(a), 3300L);
            }

            
            {
                a = MagicActivity.this;
                super();
            }
        };
        (new Timer()).schedule(S, 2500L);
        if (PianoCoreBridge.isJoin() && !com.smule.pianoandroid.magicpiano.c.a.a().h())
        {
            com.smule.pianoandroid.utils.q.a(c, com.smule.pianoandroid.magicpiano.av.h(this));
        }
        com.smule.pianoandroid.magicpiano.c.a.a().i();
        com.smule.pianoandroid.utils.q.a(null, com.smule.pianoandroid.magicpiano.a.k.values()[m], d.songId, f.e);
    }

    public void f(int i1)
    {
        a(M, i1);
    }

    protected void g()
    {
        boolean flag1 = false;
        Intent intent = new Intent(this, com/smule/pianoandroid/magicpiano/PauseDialogActivity_);
        boolean flag;
        if (k == 1 || k == 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        intent.putExtra("pause_mode", flag);
        flag = flag1;
        if (!l)
        {
            flag = flag1;
            if (!ap.a().b())
            {
                flag = true;
            }
        }
        intent.putExtra("pause_not_owned", flag);
        startActivityForResult(intent, 1);
    }

    public void h()
    {
        runOnUiThread(new Runnable() {

            final MagicActivity a;

            public void run()
            {
                com.smule.pianoandroid.magicpiano.MagicActivity.z(a);
                PianoCoreBridge.startAudioSync(a);
            }

            
            {
                a = MagicActivity.this;
                super();
            }
        });
    }

    public void i()
    {
        PianoCoreBridge.uninitNative();
        Intent intent = getIntent();
        overridePendingTransition(0, 0);
        intent.addFlags(0x10000);
        intent.putExtra("SONG_MODE", 0);
        intent.setClass(this, com/smule/pianoandroid/magicpiano/PreSongActivity);
        finish();
        overridePendingTransition(0, 0);
        startActivity(intent);
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        if (i1 != 1) goto _L2; else goto _L1
_L1:
        Y = false;
        b.setVisibility(0);
        if (j1 != 2) goto _L4; else goto _L3
_L3:
        if (k == 0)
        {
            k k1 = com.smule.pianoandroid.magicpiano.a.k.values()[PianoCoreBridge.getDifficulty()];
            String s1 = d.songId;
            long l1 = y();
            if (PianoCoreBridge.isJoin())
            {
                intent = f.e;
            } else
            {
                intent = f.a;
            }
            com.smule.pianoandroid.utils.q.a(null, k1, s1, l1, intent);
        }
        A();
_L6:
        return;
_L4:
        if (j1 == 1)
        {
            if (k == 0)
            {
                p();
            }
            PianoCoreBridge.restartPerformance(this);
            return;
        }
        if (j1 != 0)
        {
            if (j1 == 3)
            {
                i();
                return;
            }
            if (j1 == 4)
            {
                setResult(1);
                finish();
                return;
            }
            if (j1 == 6)
            {
                k = 5;
                return;
            }
            if (j1 == 7)
            {
                com.smule.pianoandroid.utils.q.f(d.songId);
                z();
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (i1 == 2)
        {
            com.smule.pianoandroid.utils.i.d().a(true);
            if (i)
            {
                z();
                return;
            }
            if (j1 == 1)
            {
                com.smule.pianoandroid.utils.o.a(this, false, k, n, u, c, v);
                finish();
                return;
            }
            if (j1 == 2)
            {
                A();
                return;
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void onBackPressed()
    {
        if (k == 2 || k == 1)
        {
            PianoCoreBridge.leavePerformance();
        } else
        if (k == 5)
        {
            a(false);
        } else
        {
            g();
        }
        w();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getIntent();
        k = bundle.getIntExtra("SONG_MODE", 0);
        i = bundle.getBooleanExtra("CHALLENGE_EXTRA", false);
        PianoCoreBridge.setDailyChallenge(i);
        l = bundle.getBooleanExtra("SONG_OWNED", true);
        c = bundle.getStringExtra("SONG_UID_EXTRA");
        if (!com.smule.pianoandroid.magicpiano.c.a.a().c())
        {
            n = com.smule.android.f.n.a(this, "_twinkle_tutorial_1.mid").getAbsolutePath();
        } else
        {
            n = bundle.getStringExtra("SONG_MIDI_EXTRA");
        }
        u = bundle.getStringExtra("SONG_NAME_EXTRA");
        v = bundle.getStringExtra("SONG_COMPOSER_EXTRA");
        m = bundle.getIntExtra("SONG_DIFFICULTY", 1);
        d = ak.a().a(c);
        int j1;
        if (c != null)
        {
            if (com.smule.pianoandroid.utils.i.d().b())
            {
                j = true;
                t = d.a("vocal_only");
                n = d.a("accomp");
            }
            if (MagicApplication.isDebug().booleanValue())
            {
                bundle = null;
                File file2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                File afile[] = file2.listFiles();
                int i2 = afile.length;
                int i1 = 0;
                File file = null;
                while (i1 < i2) 
                {
                    File file3 = afile[i1];
                    File file1 = file;
                    Bundle bundle1 = bundle;
                    if (file3.getName().compareToIgnoreCase("content") == 0)
                    {
                        File afile1[] = file3.listFiles();
                        int j2 = afile1.length;
                        int l1 = 0;
                        do
                        {
                            file1 = file;
                            bundle1 = bundle;
                            if (l1 >= j2)
                            {
                                break;
                            }
                            file1 = afile1[l1];
                            if (file1.getName().endsWith(".m4a"))
                            {
                                bundle = file1;
                            } else
                            if (file1.getAbsolutePath().endsWith(".mid"))
                            {
                                file = file1;
                            }
                            l1++;
                        } while (true);
                    }
                    i1++;
                    file = file1;
                    bundle = bundle1;
                }
                if (bundle != null && file != null)
                {
                    j = true;
                    t = new String((new StringBuilder()).append(file2).append(File.separator).append("content").append(File.separator).append(bundle.getName()).toString());
                    n = new String((new StringBuilder()).append(file2).append(File.separator).append("content").append(File.separator).append(file.getName()).toString());
                    com.smule.android.c.aa.c(a, (new StringBuilder()).append("Local content override, using ").append(t).append(" and ").append(n).toString());
                    com.smule.pianoandroid.magicpiano.c.a.a().k();
                    com.smule.pianoandroid.magicpiano.c.a.a().i();
                }
            }
            if (j)
            {
                m();
            } else
            {
                PianoCoreBridge.setJoin(Boolean.valueOf(false), Boolean.valueOf(false));
            }
        }
        if (j && !com.smule.pianoandroid.magicpiano.c.a.a().h())
        {
            j1 = 3;
        } else
        {
            j1 = m;
        }
        PianoCoreBridge.setDifficulty(j1);
        if (k == 1 || k == 2)
        {
            setContentView(0x7f03003e);
        } else
        {
            setContentView(0x7f03003d);
            J = (ProgressBar)findViewById(0x7f0a013a);
            if (!com.smule.pianoandroid.magicpiano.c.a.a().c() || j && !com.smule.pianoandroid.magicpiano.c.a.a().h())
            {
                J.setVisibility(4);
            }
            y = (TextView)findViewById(0x7f0a014f);
        }
        b = (MagicGLSurfaceView)findViewById(0x7f0a0139);
        b.a(getApplicationContext());
        O = (Button)findViewById(0x7f0a013b);
        if (k == 0 || !com.smule.pianoandroid.magicpiano.c.a.a().c() || j && !com.smule.pianoandroid.magicpiano.c.a.a().h())
        {
            O.setVisibility(4);
            PianoCoreBridge.sPerformancePausedCallback = this;
        } else
        {
            O.setOnClickListener(new android.view.View.OnClickListener() {

                final MagicActivity a;

                public void onClick(View view)
                {
                    if (com.smule.pianoandroid.magicpiano.MagicActivity.a(a) == 1 || com.smule.pianoandroid.magicpiano.MagicActivity.a(a) == 2)
                    {
                        PianoCoreBridge.setPaused(true);
                        a.g();
                    }
                }

            
            {
                a = MagicActivity.this;
                super();
            }
            });
        }
        if (k == 1 || k == 2)
        {
            P = (Button)findViewById(0x7f0a0140);
            P.setOnClickListener(new android.view.View.OnClickListener() {

                final MagicActivity a;

                public void onClick(View view)
                {
                    PianoCoreBridge.sPerforming = false;
                    (new Timer()).schedule(new TimerTask(this) {

                        final _cls11 a;

                        public void run()
                        {
                            if (com.smule.pianoandroid.magicpiano.MagicActivity.b(a.a) || ap.a().b())
                            {
                                a.a.i();
                                return;
                            } else
                            {
                                a.a.setResult(1);
                                a.a.finish();
                                return;
                            }
                        }

            
            {
                a = _pcls11;
                super();
            }
                    }, 1000L);
                }

            
            {
                a = MagicActivity.this;
                super();
            }
            });
        }
        setVolumeControlStream(3);
        if (((AudioManager)getSystemService("audio")).isWiredHeadsetOn())
        {
            SoundPoolSynth.setVolumeScaleForHeadphones(1);
        } else
        {
            SoundPoolSynth.setVolumeScaleForHeadphones(0);
        }
        g = new SoundPoolSynth();
        g.onCreate(getApplicationContext());
        bundle = new IntentFilter("android.intent.action.HEADSET_PLUG");
        w = new v(this);
        registerReceiver(w, bundle);
        PianoCoreBridge.setContext(this);
        PianoCoreBridge.initSoundPoolBridge(g);
        PianoCoreBridge.setSong(d);
        if (!com.smule.pianoandroid.magicpiano.c.a.a().c())
        {
            PianoCoreBridge.setScoreMode(false, true);
        } else
        {
            PianoCoreBridge.setScoreMode(com.smule.pianoandroid.magicpiano.av.b(this).booleanValue(), false);
        }
        k;
        JVM INSTR tableswitch 0 2: default 856
    //                   0 1064
    //                   1 1043
    //                   2 1023;
           goto _L1 _L2 _L3 _L4
_L1:
        e = new Observer() {

            final MagicActivity a;

            public void update(Observable observable, Object obj)
            {
                if (!com.smule.pianoandroid.magicpiano.MagicActivity.c(a))
                {
                    MagicActivity.d(a);
                    return;
                } else
                {
                    MagicActivity.e(a);
                    return;
                }
            }

            
            {
                a = MagicActivity.this;
                super();
            }
        };
        com.smule.android.f.h.a().a("RENDERER_INITIALIZED", e);
        p();
        com.smule.pianoandroid.utils.m.a(this);
        return;
_L4:
        R = 30000;
        com.smule.pianoandroid.utils.q.a(d, com.smule.pianoandroid.magicpiano.ProductListFragment.a);
        continue; /* Loop/switch isn't completed */
_L3:
        b.setKeepScreenOn(true);
        com.smule.pianoandroid.utils.q.a(d, com.smule.pianoandroid.magicpiano.ProductListFragment.a);
        continue; /* Loop/switch isn't completed */
_L2:
        if (!i)
        {
            break; /* Loop/switch isn't completed */
        }
        com.smule.pianoandroid.utils.q.e(d.songId);
_L6:
        com.smule.android.c.w.d("perf_time");
        com.smule.android.c.w.b("perf_time");
        if (true) goto _L1; else goto _L5
_L5:
        if (com.smule.pianoandroid.magicpiano.c.a.a().c() && (!j || j && com.smule.pianoandroid.magicpiano.c.a.a().h()))
        {
            k k1 = com.smule.pianoandroid.magicpiano.a.k.values()[m];
            String s1 = d.songId;
            if (PianoCoreBridge.isJoin())
            {
                bundle = f.e;
            } else
            {
                bundle = f.a;
            }
            com.smule.pianoandroid.utils.q.a(null, k1, s1, bundle);
        }
        if (com.smule.pianoandroid.magicpiano.c.a.a().a)
        {
            com.smule.pianoandroid.utils.q.l(d.songId);
        }
        if (j)
        {
            PerformanceManager.a().a(d.performanceKey, null);
        }
          goto _L6
        if (true) goto _L1; else goto _L7
_L7:
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (x != null)
        {
            x.cancel();
        }
        unregisterReceiver(w);
        com.smule.android.f.h.a().b("RENDERER_INITIALIZED", e);
        PianoCoreBridge.sPerformancePausedCallback = null;
        PianoCoreBridge.sEnterFreeplayCallback = null;
        PianoCoreBridge.setContext(null);
    }

    protected void onPause()
    {
        super.onPause();
        MagicApplication.getInstance().onPause();
        if (k != 2) goto _L2; else goto _L1
_L1:
        long l1 = System.nanoTime();
        long l2 = Q;
        R = (int)((long)R - (l1 - l2) / 0xf4240L);
        R = Math.max(0, R);
        if (x != null)
        {
            x.cancel();
        }
_L4:
        if (d())
        {
            PianoCoreBridge.setPaused(true);
        }
        b.onPause();
        w();
        h = false;
        H = false;
        return;
_L2:
        if (k == 0)
        {
            com.smule.android.c.w.c("perf_time");
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onResume()
    {
        com.smule.android.c.aa.c(a, "onResume");
        super.onResume();
        MagicApplication.getInstance().onResume();
        b.onResume();
        h = true;
        if (Z && h && G)
        {
            x();
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
        g.onStop();
    }

    public void onWindowFocusChanged(boolean flag)
    {
        com.smule.android.c.aa.c(a, "onWindowFocusChanged");
        super.onWindowFocusChanged(flag);
        Z = flag;
        if (Z && h && G)
        {
            x();
        }
    }

}
