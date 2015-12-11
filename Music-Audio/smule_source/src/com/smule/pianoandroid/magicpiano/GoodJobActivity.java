// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.flurry.android.FlurryAdListener;
import com.flurry.android.FlurryAdType;
import com.smule.android.c.aa;
import com.smule.android.c.ab;
import com.smule.android.c.f;
import com.smule.android.c.o;
import com.smule.android.f.c;
import com.smule.android.facebook.a;
import com.smule.android.network.core.r;
import com.smule.android.network.managers.PerformanceManager;
import com.smule.android.network.managers.UserManager;
import com.smule.android.network.managers.ak;
import com.smule.android.network.managers.e;
import com.smule.android.network.models.PerformanceV2;
import com.smule.android.network.models.SongV2;
import com.smule.magicpiano.MagicPerformanceStats;
import com.smule.magicpiano.PianoCoreBridge;
import com.smule.pianoandroid.ads.j;
import com.smule.pianoandroid.data.model.Performance;
import com.smule.pianoandroid.data.model.ScoreInfo;
import com.smule.pianoandroid.f.b;
import com.smule.pianoandroid.magicpiano.a.g;
import com.smule.pianoandroid.magicpiano.a.h;
import com.smule.pianoandroid.magicpiano.a.k;
import com.smule.pianoandroid.utils.i;
import com.smule.pianoandroid.utils.n;
import com.smule.pianoandroid.utils.q;
import com.smule.pianoandroid.utils.s;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ag, ar, aw, ay, 
//            DailyChallengeActivity, MagicApplication, an, r, 
//            s, q, ae

public class GoodJobActivity extends ag
    implements FlurryAdListener, ab
{

    private static final String d = com/smule/pianoandroid/magicpiano/GoodJobActivity.getName();
    private static String e = "SONGBOOK_PRESSED";
    private static String f = "RESTART_PRESSED";
    private ProgressBar A;
    private String B;
    private ScoreInfo C;
    private SongV2 D;
    private com.smule.android.network.managers.q E;
    private boolean F;
    private boolean G;
    private int H;
    private j I;
    private boolean J;
    private Map K;
    private String L;
    private an M;
    private aw N;
    private int O;
    private String P;
    private String Q;
    private CallbackManager R;
    private boolean S;
    private Runnable T;
    private Observer U;
    private android.view.View.OnClickListener V;
    private Runnable W;
    com.smule.pianoandroid.magicpiano.r a;
    protected boolean b;
    boolean c;
    private TextView g;
    private TextView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private LinearLayout t;
    private TextView u;
    private TextView v;
    private TextView w;
    private ImageView x;
    private TextView y;
    private ProgressBar z;

    public GoodJobActivity()
    {
        F = false;
        G = false;
        H = 0;
        J = false;
        K = new HashMap();
        M = null;
        N = null;
        c = false;
        S = false;
        T = null;
        U = null;
        V = new android.view.View.OnClickListener() {

            final GoodJobActivity a;

            public void onClick(View view)
            {
                view = new Runnable(this) {

                    final _cls3 a;

                    public void run()
                    {
                        com.smule.pianoandroid.magicpiano.GoodJobActivity.a(a.a, true);
                        q.o(GoodJobActivity.d(a.a).songId);
                        if (!com.smule.pianoandroid.magicpiano.GoodJobActivity.g(a.a).a(a.a, 0x7f0a0063))
                        {
                            a.a.setResult(2);
                            a.a.finish();
                        }
                    }

            
            {
                a = _pcls3;
                super();
            }
                };
                if (com.smule.pianoandroid.magicpiano.GoodJobActivity.h(a))
                {
                    com.smule.pianoandroid.utils.o.a(a, view, view, a.getResources().getString(0x7f0c020e), a.getResources().getString(0x7f0c020d));
                    return;
                } else
                {
                    view.run();
                    return;
                }
            }

            
            {
                a = GoodJobActivity.this;
                super();
            }
        };
        W = new Runnable() {

            final GoodJobActivity a;

            public void run()
            {
                Runnable runnable = new Runnable(this, new Runnable(this) {

                    final _cls4 a;

                    public void run()
                    {
                        a.a.setResult(1);
                        a.a.finish();
                    }

            
            {
                a = _pcls4;
                super();
            }
                }) {

                    final Runnable a;
                    final _cls4 b;

                    public void run()
                    {
                        com.smule.pianoandroid.magicpiano.GoodJobActivity.b(b.a, true);
                        if (!com.smule.pianoandroid.magicpiano.GoodJobActivity.g(b.a).a(b.a, 0x7f0a00b5))
                        {
                            a.run();
                        }
                    }

            
            {
                b = _pcls4;
                a = runnable;
                super();
            }
                };
                if (com.smule.pianoandroid.magicpiano.GoodJobActivity.h(a))
                {
                    com.smule.pianoandroid.utils.o.a(a, runnable, runnable, a.getResources().getString(0x7f0c020e), a.getResources().getString(0x7f0c020d));
                    return;
                } else
                {
                    runnable.run();
                    return;
                }
            }

            
            {
                a = GoodJobActivity.this;
                super();
            }
        };
    }

    private double a(float f1)
    {
        g g1 = com.smule.pianoandroid.magicpiano.a.g.a();
        if ((double)f1 >= g1.g())
        {
            return 3D;
        }
        if ((double)f1 >= g1.f())
        {
            return ((double)f1 - g1.f()) / (g1.g() - g1.f()) + 2D;
        }
        if ((double)f1 >= g1.e())
        {
            return ((double)f1 - g1.e()) / (g1.f() - g1.e()) + 1.0D;
        } else
        {
            return (double)f1 / g1.e();
        }
    }

    public static int a(float f1, float f2)
    {
        if (f2 <= 0.0F)
        {
            return 0;
        }
        f1 /= f2;
        if (f1 < 0.3F)
        {
            return 1;
        }
        return f1 >= 0.85F ? 3 : 2;
    }

    static int a(GoodJobActivity goodjobactivity, int i1)
    {
        goodjobactivity.O = i1;
        return i1;
    }

    static int a(GoodJobActivity goodjobactivity, k k1)
    {
        return goodjobactivity.a(k1);
    }

    private int a(k k1)
    {
        class _cls13
        {

            static final int a[];

            static 
            {
                a = new int[com.smule.pianoandroid.magicpiano.a.k.values().length];
                try
                {
                    a[k.b.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[k.c.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[k.d.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (com.smule.pianoandroid.magicpiano._cls13.a[k1.ordinal()])
        {
        default:
            return 0x7f020196;

        case 1: // '\001'
            return 0x7f020195;

        case 2: // '\002'
            return 0x7f020199;

        case 3: // '\003'
            return 0x7f020197;
        }
    }

    static an a(GoodJobActivity goodjobactivity, an an1)
    {
        goodjobactivity.M = an1;
        return an1;
    }

    static String a(GoodJobActivity goodjobactivity, String s1)
    {
        goodjobactivity.P = s1;
        return s1;
    }

    private void a(int i1, int j1)
    {
        a(findViewById(i1), j1);
    }

    private void a(View view, int i1)
    {
        AlphaAnimation alphaanimation = new AlphaAnimation(0.0F, 1.0F);
        alphaanimation.setDuration(800L);
        alphaanimation.setStartOffset(i1 * 400);
        view.startAnimation(alphaanimation);
    }

    private void a(ProgressBar progressbar, MagicPerformanceStats magicperformancestats, String s1)
    {
        int i1 = Math.round((float)progressbar.getMax() * (float)a(magicperformancestats.partialProgress()));
        if (com.smule.pianoandroid.utils.n.b())
        {
            ObjectAnimator objectanimator;
            String s2;
            StringBuilder stringbuilder;
            int j1;
            int k1;
            if (i1 >= progressbar.getMax())
            {
                j1 = progressbar.getMax();
            } else
            {
                j1 = i1;
            }
            objectanimator = ObjectAnimator.ofInt(progressbar, "progress", new int[] {
                j1
            });
            objectanimator.setDuration(800L);
            k1 = i1 / progressbar.getMax();
            j1 = k1;
            if (k1 > 0)
            {
                j1 = k1;
                if (i1 % progressbar.getMax() == 0)
                {
                    j1 = k1 - 1;
                }
            }
            objectanimator.setRepeatCount(j1);
            s2 = d;
            stringbuilder = (new StringBuilder()).append("Ring Progress = ").append(i1).append(", repeatCount = ").append(j1).append(", next progress = ");
            if (i1 >= progressbar.getMax())
            {
                j1 = progressbar.getMax();
            } else
            {
                j1 = i1;
            }
            aa.a(s2, stringbuilder.append(j1).toString());
            objectanimator.addListener(new android.animation.Animator.AnimatorListener(i1, progressbar, s1, magicperformancestats) {

                int a;
                final int b;
                final ProgressBar c;
                final String d;
                final MagicPerformanceStats e;
                final GoodJobActivity f;
                private int g;

                private void a(String s3)
                {
                    a = a + 1;
                    ((ImageView)f.findViewById(f.getResources().getIdentifier((new StringBuilder()).append(s3).append(a).toString(), "id", f.getPackageName()))).setImageResource(com.smule.pianoandroid.magicpiano.GoodJobActivity.a(f, com.smule.pianoandroid.magicpiano.a.k.values()[e.difficulty]));
                }

                public void onAnimationCancel(Animator animator)
                {
                }

                public void onAnimationEnd(Animator animator)
                {
                    if (c.getProgress() == 1000)
                    {
                        a(d);
                    }
                }

                public void onAnimationRepeat(Animator animator)
                {
                    a(d);
                    c.setProgress(0);
                    g = g - c.getMax();
                    String s3 = GoodJobActivity.d();
                    StringBuilder stringbuilder1 = (new StringBuilder()).append("next progress = ");
                    int l1;
                    if (g >= c.getMax())
                    {
                        l1 = c.getMax();
                    } else
                    {
                        l1 = g;
                    }
                    aa.a(s3, stringbuilder1.append(l1).toString());
                    animator = (ObjectAnimator)animator;
                    if (g >= c.getMax())
                    {
                        l1 = c.getMax();
                    } else
                    {
                        l1 = g;
                    }
                    animator.setIntValues(new int[] {
                        l1
                    });
                }

                public void onAnimationStart(Animator animator)
                {
                }

            
            {
                f = GoodJobActivity.this;
                b = i1;
                c = progressbar;
                d = s1;
                e = magicperformancestats;
                super();
                a = 0;
                g = b;
            }
            });
            objectanimator.start();
            return;
        }
        if (i1 == 0)
        {
            i1 = 0;
        } else
        {
            i1 %= progressbar.getMax();
        }
        progressbar.setProgress(i1);
    }

    static void a(GoodJobActivity goodjobactivity)
    {
        goodjobactivity.e();
    }

    private void a(String s1, String s2, String s3)
    {
        if (!r.a(this))
        {
            return;
        } else
        {
            aa.c(d, "Share to Facebook ");
            T = new Runnable(s1, s3, s2) {

                final String a;
                final String b;
                final String c;
                final GoodJobActivity d;

                public void run()
                {
                    d.a = new com.smule.pianoandroid.magicpiano.r(d, a, b);
                    if (a.equals("perform_android"))
                    {
                        com.smule.pianoandroid.magicpiano.ae.a(c).a(d.getFragmentManager(), GoodJobActivity.d(), d.a);
                    } else
                    if (a.equals("play_android") && com.smule.pianoandroid.f.a.a(d).a())
                    {
                        d.a.execute(new String[] {
                            d.getString(0x7f0c01e1)
                        });
                        return;
                    }
                }

            
            {
                d = GoodJobActivity.this;
                a = s1;
                b = s2;
                c = s3;
                super();
            }
            };
            T.run();
            return;
        }
    }

    static boolean a(GoodJobActivity goodjobactivity, boolean flag)
    {
        goodjobactivity.G = flag;
        return flag;
    }

    static TextView b(GoodJobActivity goodjobactivity)
    {
        return goodjobactivity.u;
    }

    static String b(GoodJobActivity goodjobactivity, String s1)
    {
        goodjobactivity.Q = s1;
        return s1;
    }

    static boolean b(GoodJobActivity goodjobactivity, boolean flag)
    {
        goodjobactivity.F = flag;
        return flag;
    }

    static Runnable c(GoodJobActivity goodjobactivity)
    {
        return goodjobactivity.W;
    }

    static SongV2 d(GoodJobActivity goodjobactivity)
    {
        return goodjobactivity.D;
    }

    static String d()
    {
        return d;
    }

    private void e()
    {
        (new Handler(Looper.getMainLooper())).post(new Runnable() {

            final GoodJobActivity a;

            public void run()
            {
                com.smule.pianoandroid.magicpiano.GoodJobActivity.f(a);
            }

            
            {
                a = GoodJobActivity.this;
                super();
            }
        });
    }

    static void e(GoodJobActivity goodjobactivity)
    {
        goodjobactivity.m();
    }

    private void f()
    {
        aa.a(d, (new StringBuilder()).append("publishFacebook. isLoggedIn=").append(com.smule.android.facebook.a.a().h()).append(" hasPublishPermission=").append(com.smule.android.facebook.a.a().i()).toString());
        if (com.smule.android.facebook.a.a().h())
        {
            if (b)
            {
                com.smule.android.facebook.a.a().f();
                com.smule.android.facebook.a.a().b(this);
                b = false;
            } else
            if (com.smule.android.facebook.a.a().i())
            {
                c();
                return;
            }
        }
    }

    static void f(GoodJobActivity goodjobactivity)
    {
        goodjobactivity.f();
    }

    static j g(GoodJobActivity goodjobactivity)
    {
        return goodjobactivity.I;
    }

    private void g()
    {
        aa.c(d, "Share to Facebook ");
        if (!com.smule.android.facebook.a.a().h())
        {
            b = true;
            LoginManager.getInstance().logInWithReadPermissions(this, b.b);
            return;
        }
        if (!com.smule.android.facebook.a.a().i())
        {
            com.smule.android.facebook.a.a().b(this);
            return;
        } else
        {
            c();
            return;
        }
    }

    private boolean h()
    {
        while (!com.smule.pianoandroid.magicpiano.c.a.a().d() || !com.smule.pianoandroid.magicpiano.ar.a() || PianoCoreBridge.sChallenge || (com.smule.pianoandroid.magicpiano.c.a.a().f() - 1) % 5 != 0) 
        {
            return false;
        }
        return true;
    }

    static boolean h(GoodJobActivity goodjobactivity)
    {
        return goodjobactivity.h();
    }

    private com.smule.android.network.managers.q i()
    {
        if (E == null)
        {
            E = PerformanceManager.a().a(L, B, PianoCoreBridge.sSong.title, null, null, Boolean.valueOf(false), PianoCoreBridge.sLastPerformance.latitude, PianoCoreBridge.sLastPerformance.longitude, "SOLO", null);
        }
        return E;
    }

    static com.smule.android.network.managers.q i(GoodJobActivity goodjobactivity)
    {
        return goodjobactivity.i();
    }

    static boolean j(GoodJobActivity goodjobactivity)
    {
        return goodjobactivity.S;
    }

    static ScoreInfo k(GoodJobActivity goodjobactivity)
    {
        return goodjobactivity.C;
    }

    static String l(GoodJobActivity goodjobactivity)
    {
        return goodjobactivity.B;
    }

    private void m()
    {
        aa.c(d, (new StringBuilder()).append("Upload ").append(L).toString());
        android.view.View.OnClickListener onclicklistener = new android.view.View.OnClickListener() {

            final GoodJobActivity a;

            public void onClick(View view)
            {
                (new com.smule.pianoandroid.magicpiano.s(a)).execute(new com.smule.pianoandroid.magicpiano.q[] {
                    new com.smule.pianoandroid.magicpiano.q(this) {

                        final _cls7 a;

                        public void a(com.smule.android.network.managers.q q1)
                        {
                            com.smule.android.c.a.a(q1.mPerformance.performanceKey, o.j, com.smule.android.c.n.a, com.smule.android.c.i.a, PianoCoreBridge.getEnsembleAnalyticsType());
                            com.smule.pianoandroid.f.a.a(a.a).a(a.a, q1.mPerformance.performanceKey, GoodJobActivity.l(a.a), q1.mPerformance.webUrl, 4);
                        }

            
            {
                a = _pcls7;
                super();
            }
                    }, null, null
                });
            }

            
            {
                a = GoodJobActivity.this;
                super();
            }
        };
        android.view.View.OnClickListener onclicklistener1 = new android.view.View.OnClickListener() {

            final GoodJobActivity a;

            public void onClick(View view)
            {
                (new com.smule.pianoandroid.magicpiano.s(a)).execute(new com.smule.pianoandroid.magicpiano.q[] {
                    new com.smule.pianoandroid.magicpiano.q(this) {

                        final _cls8 a;

                        public void a(com.smule.android.network.managers.q q1)
                        {
                            com.smule.android.c.a.a(q1.mPerformance.performanceKey, o.b, com.smule.android.c.n.a, com.smule.android.c.i.a, PianoCoreBridge.getEnsembleAnalyticsType());
                            com.smule.pianoandroid.magicpiano.GoodJobActivity.a(a.a, q1.mPerformance.performanceKey);
                            com.smule.pianoandroid.magicpiano.GoodJobActivity.b(a.a, q1.mPerformance.songUid);
                            GoodJobActivity.m(a.a);
                        }

            
            {
                a = _pcls8;
                super();
            }
                    }, null, null
                });
            }

            
            {
                a = GoodJobActivity.this;
                super();
            }
        };
        android.view.View.OnClickListener onclicklistener2 = new android.view.View.OnClickListener() {

            final GoodJobActivity a;

            public void onClick(View view)
            {
                (new com.smule.pianoandroid.magicpiano.s(a)).execute(new com.smule.pianoandroid.magicpiano.q[] {
                    new com.smule.pianoandroid.magicpiano.q(this) {

                        final _cls9 a;

                        public void a(com.smule.android.network.managers.q q1)
                        {
                            com.smule.android.c.a.a(q1.mPerformance.performanceKey, o.c, com.smule.android.c.n.a, com.smule.android.c.i.a, PianoCoreBridge.getEnsembleAnalyticsType());
                            com.smule.pianoandroid.f.a.a(a.a).d(a.a, q1.mPerformance.performanceKey, GoodJobActivity.l(a.a), q1.mPerformance.webUrl, 4);
                        }

            
            {
                a = _pcls9;
                super();
            }
                    }, null, null
                });
            }

            
            {
                a = GoodJobActivity.this;
                super();
            }
        };
        android.view.View.OnClickListener onclicklistener3 = new android.view.View.OnClickListener() {

            final GoodJobActivity a;

            public void onClick(View view)
            {
                (new com.smule.pianoandroid.magicpiano.s(a)).execute(new com.smule.pianoandroid.magicpiano.q[] {
                    new com.smule.pianoandroid.magicpiano.q(this) {

                        final _cls10 a;

                        public void a(com.smule.android.network.managers.q q1)
                        {
                            com.smule.android.c.a.a(q1.mPerformance.performanceKey, o.f, com.smule.android.c.n.a, com.smule.android.c.i.a, PianoCoreBridge.getEnsembleAnalyticsType());
                            com.smule.pianoandroid.f.a.a(a.a).c(a.a, q1.mPerformance.performanceKey, GoodJobActivity.l(a.a), q1.mPerformance.webUrl, 4);
                        }

            
            {
                a = _pcls10;
                super();
            }
                    }, null, null
                });
            }

            
            {
                a = GoodJobActivity.this;
                super();
            }
        };
        android.view.View.OnClickListener onclicklistener4 = new android.view.View.OnClickListener() {

            final GoodJobActivity a;

            public void onClick(View view)
            {
                (new com.smule.pianoandroid.magicpiano.s(a)).execute(new com.smule.pianoandroid.magicpiano.q[] {
                    new com.smule.pianoandroid.magicpiano.q(this) {

                        final _cls11 a;

                        public void a(com.smule.android.network.managers.q q1)
                        {
                            com.smule.android.c.a.a(q1.mPerformance.performanceKey, o.g, com.smule.android.c.n.a, com.smule.android.c.i.a, PianoCoreBridge.getEnsembleAnalyticsType());
                            com.smule.pianoandroid.f.a.a(a.a).b(a.a, q1.mPerformance.performanceKey, GoodJobActivity.l(a.a), q1.mPerformance.webUrl, 4);
                        }

            
            {
                a = _pcls11;
                super();
            }
                    }, null, null
                });
            }

            
            {
                a = GoodJobActivity.this;
                super();
            }
        };
        N = new aw(this, com.smule.pianoandroid.magicpiano.ay.a, PianoCoreBridge.sSong.songId, PianoCoreBridge.getEnsembleAnalyticsType(), onclicklistener, onclicklistener1, onclicklistener2, onclicklistener3, onclicklistener4, null);
        N.show();
    }

    static void m(GoodJobActivity goodjobactivity)
    {
        goodjobactivity.g();
    }

    public boolean a()
    {
        return true;
    }

    public String b()
    {
        return "Score";
    }

    public void c()
    {
        a("perform_android", P, Q);
        P = null;
        Q = null;
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        if (i1 == 3)
        {
            if (j1 == 4)
            {
                (new Handler()).post(new Runnable() {

                    final GoodJobActivity a;

                    public void run()
                    {
                        com.smule.pianoandroid.magicpiano.GoodJobActivity.e(a);
                    }

            
            {
                a = GoodJobActivity.this;
                super();
            }
                });
            }
            return;
        }
        if (i1 == 4)
        {
            aa.c(d, "generic social share result");
            return;
        } else
        {
            R.onActivityResult(i1, j1, intent);
            return;
        }
    }

    public void onAdClicked(String s1)
    {
    }

    public void onAdClosed(String s1)
    {
    }

    public void onAdOpened(String s1)
    {
    }

    public void onApplicationExit(String s1)
    {
    }

    public void onBackPressed()
    {
        if (!com.smule.pianoandroid.magicpiano.c.a.a().d())
        {
            return;
        }
        if (J)
        {
            startActivity(new Intent(this, com/smule/pianoandroid/magicpiano/DailyChallengeActivity));
            finish();
            return;
        } else
        {
            setResult(2);
            finish();
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030036);
        R = com.facebook.CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(R, new FacebookCallback() {

            final GoodJobActivity a;

            public void a(LoginResult loginresult)
            {
                com.smule.pianoandroid.magicpiano.GoodJobActivity.a(a);
            }

            public void onCancel()
            {
            }

            public void onError(FacebookException facebookexception)
            {
                aa.c(GoodJobActivity.d(), "Facebook Error", facebookexception);
            }

            public void onSuccess(Object obj2)
            {
                a((LoginResult)obj2);
            }

            
            {
                a = GoodJobActivity.this;
                super();
            }
        });
        c = false;
        g = (TextView)findViewById(0x7f0a00ef);
        h = (TextView)findViewById(0x7f0a00f2);
        i = (TextView)findViewById(0x7f0a00f5);
        j = (TextView)findViewById(0x7f0a00f8);
        k = (TextView)findViewById(0x7f0a00ea);
        l = (TextView)findViewById(0x7f0a0101);
        m = (TextView)findViewById(0x7f0a0102);
        n = (TextView)findViewById(0x7f0a00ff);
        t = (LinearLayout)findViewById(0x7f0a0100);
        u = (TextView)findViewById(0x7f0a0106);
        v = (TextView)findViewById(0x7f0a0110);
        w = (TextView)findViewById(0x7f0a010f);
        x = (ImageView)findViewById(0x7f0a010e);
        z = (ProgressBar)findViewById(0x7f0a00fc);
        z.setProgressDrawable(new com.smule.pianoandroid.b.a(new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), 0x7f02015b)), 3));
        A = (ProgressBar)findViewById(0x7f0a010c);
        A.setProgressDrawable(new com.smule.pianoandroid.b.a(new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), 0x7f02015b)), 3));
        y = (TextView)findViewById(0x7f0a0111);
        I = new j();
        Runnable runnable = new Runnable() {

            final GoodJobActivity a;

            public void run()
            {
                a.setResult(2);
                a.finish();
            }

            
            {
                a = GoodJobActivity.this;
                super();
            }
        };
        Object obj = getIntent();
        J = ((Intent) (obj)).getBooleanExtra("daily_challenge", false);
        int i1 = ((Intent) (obj)).getIntExtra("score", 0);
        MagicPerformanceStats magicperformancestats = (MagicPerformanceStats)((Intent) (obj)).getParcelableExtra("stats");
        B = ((Intent) (obj)).getStringExtra("SONG_UID_EXTRA");
        E = null;
        H = com.smule.pianoandroid.magicpiano.a.g.a().a(magicperformancestats.scoringHitChords(), magicperformancestats.totalScoringChords());
        boolean flag;
        if (magicperformancestats.score() >= magicperformancestats.totalPointsPossible())
        {
            obj = getResources().getString(0x7f0c01d0);
        } else
        {
            obj = getResources().getString(0x7f0c0132);
        }
        flag = getBaseContext().getSharedPreferences("magic_piano_prefs", 0).getBoolean("GameMode", true);
        try
        {
            File file = File.createTempFile((new StringBuilder()).append(B).append("_performance_").toString(), ".midi", getCacheDir());
            PianoCoreBridge.writePerformanceMidi(file.getAbsolutePath());
            L = file.getAbsolutePath();
        }
        catch (IOException ioexception)
        {
            aa.b(d, (new StringBuilder()).append("There was a problem saving the performance file: ").append(B).toString());
            ioexception.printStackTrace();
        }
        if (flag)
        {
            if (!J)
            {
                findViewById(0x7f0a00b5).setVisibility(0);
                findViewById(0x7f0a0103).setVisibility(8);
                h h1 = new h(magicperformancestats, com.smule.pianoandroid.magicpiano.a.j.a());
                g.setVisibility(0);
                String s1 = String.format("%d", new Object[] {
                    Integer.valueOf(i1)
                });
                g.setText(s1);
                a(0x7f0a00ed, 1);
                s1 = String.format("%d", new Object[] {
                    Integer.valueOf(h1.e())
                });
                h.setText(s1);
                a(0x7f0a00f0, 2);
                s1 = String.format("%d %s", new Object[] {
                    Long.valueOf(h1.b()), getResources().getString(0x7f0c02e2)
                });
                i.setText(s1);
                a(0x7f0a00f3, 3);
                long l1 = h1.c();
                j.setText(String.format("%d %s", new Object[] {
                    Long.valueOf(l1), getResources().getString(0x7f0c02e2)
                }));
                a(0x7f0a00f6, 4);
                a(z, magicperformancestats, "star_");
            } else
            {
                findViewById(0x7f0a00b5).setVisibility(8);
                findViewById(0x7f0a0103).setVisibility(0);
                Object obj1 = com.smule.android.network.managers.e.a().f();
                obj1 = com.smule.android.network.managers.e.a().a(((com.smule.android.network.models.ContestData.ContestInfo) (obj1)));
                if (UserManager.n().h())
                {
                    findViewById(0x7f0a0105).setVisibility(0);
                    findViewById(0x7f0a0107).setVisibility(8);
                    if (((com.smule.android.network.models.ContestData.ContestUserState) (obj1)).rank != null)
                    {
                        u.setText((new Long(((com.smule.android.network.models.ContestData.ContestUserState) (obj1)).rank.longValue() + 1L)).toString());
                    } else
                    {
                        u.setText("");
                        if (((com.smule.android.network.models.ContestData.ContestUserState) (obj1)).submitState == com.smule.android.network.models.ContestData.SubmitState.SUBMIT_EXPIRED)
                        {
                            aa.b("$$$", "rank not ready yet, submit error expired");
                            Toast.makeText(getApplicationContext(), getString(0x7f0c027b), 1).show();
                        } else
                        if (((com.smule.android.network.models.ContestData.ContestUserState) (obj1)).submitState == com.smule.android.network.models.ContestData.SubmitState.SUBMIT_ERROR)
                        {
                            aa.b("$$$", "rank not ready yet, submit error");
                            Toast.makeText(getApplicationContext(), getString(0x7f0c027a), 1).show();
                        } else
                        {
                            aa.b("$$$", "rank not ready yet, listening for submit results");
                            U = new Observer() {

                                final GoodJobActivity a;

                                public void update(Observable observable, Object obj2)
                                {
                                    a.runOnUiThread(new Runnable(this, obj2) {

                                        final Object a;
                                        final _cls14 b;

                                        public void run()
                                        {
                                            Object obj = (com.smule.android.network.models.ContestData.SubmitState)a;
                                            if (obj == com.smule.android.network.models.ContestData.SubmitState.SUBMIT_SUCCESS)
                                            {
                                                aa.b("$$$", "good job: got submit result, setting rank on UI");
                                                obj = com.smule.android.network.managers.e.a().a(com.smule.android.network.managers.e.a().f());
                                                com.smule.pianoandroid.magicpiano.GoodJobActivity.b(b.a).setText((new Long(((com.smule.android.network.models.ContestData.ContestUserState) (obj)).rank.longValue() + 1L)).toString());
                                            } else
                                            {
                                                if (obj == com.smule.android.network.models.ContestData.SubmitState.SUBMIT_ERROR)
                                                {
                                                    aa.b("$$$", "good job: got submit result, error, showing toast");
                                                    Toast.makeText(b.a, b.a.getString(0x7f0c027a), 1).show();
                                                    return;
                                                }
                                                if (obj == com.smule.android.network.models.ContestData.SubmitState.SUBMIT_EXPIRED)
                                                {
                                                    aa.b("$$$", "good job: got submit result, expired, showing toast");
                                                    Toast.makeText(b.a, b.a.getString(0x7f0c027b), 1).show();
                                                    return;
                                                }
                                            }
                                        }

            
            {
                b = _pcls14;
                a = obj;
                super();
            }
                                    });
                                }

            
            {
                a = GoodJobActivity.this;
                super();
            }
                            };
                            com.smule.android.f.h.a().a("NOTIFICATION_SCORE_SUBMITTED", U);
                        }
                    }
                    w.setText(UserManager.n().e());
                    com.smule.android.f.c.a(x, s.a().b(), 0xff888888, true);
                } else
                {
                    findViewById(0x7f0a0105).setVisibility(8);
                    findViewById(0x7f0a0107).setVisibility(0);
                    w.setText(0x7f0c02e7);
                }
                a(A, magicperformancestats, "dc_star_");
                v.setText((new Integer(((com.smule.android.network.models.ContestData.ContestUserState) (obj1)).score.intValue())).toString());
                y.setText(0x7f0c00b3);
                y.setOnClickListener(new android.view.View.OnClickListener() {

                    final GoodJobActivity a;

                    public void onClick(View view)
                    {
                        view = new Intent(a, com/smule/pianoandroid/magicpiano/DailyChallengeActivity);
                        a.startActivity(view);
                        a.finish();
                    }

            
            {
                a = GoodJobActivity.this;
                super();
            }
                });
            }
        } else
        {
            findViewById(0x7f0a00eb).setVisibility(8);
            findViewById(0x7f0a00fd).setVisibility(0);
            g.setVisibility(4);
            obj = getResources().getString(0x7f0c0132);
            k.setGravity(1);
        }
        if (!com.smule.pianoandroid.magicpiano.c.a.a().d())
        {
            n.setVisibility(8);
            m.setVisibility(8);
            t.setVisibility(8);
            l.setOnClickListener(new android.view.View.OnClickListener() {

                final GoodJobActivity a;

                public void onClick(View view)
                {
                    com.smule.pianoandroid.magicpiano.GoodJobActivity.c(a).run();
                }

            
            {
                a = GoodJobActivity.this;
                super();
            }
            });
            l.setText(getResources().getString(0x7f0c00b3));
        } else
        if (PianoCoreBridge.isJoin() || J)
        {
            n.setVisibility(8);
            m.setVisibility(8);
            t.setVisibility(0);
            l.setOnClickListener(V);
        } else
        {
            n.setVisibility(0);
            m.setVisibility(0);
            t.setVisibility(8);
            l.setOnClickListener(V);
        }
        k.setText(((CharSequence) (obj)));
        n.setOnClickListener(new android.view.View.OnClickListener() {

            final GoodJobActivity a;

            public void onClick(View view)
            {
                com.smule.pianoandroid.magicpiano.GoodJobActivity.c(a).run();
            }

            
            {
                a = GoodJobActivity.this;
                super();
            }
        });
        m.setOnClickListener(new android.view.View.OnClickListener() {

            final GoodJobActivity a;

            public void onClick(View view)
            {
                String s2 = GoodJobActivity.d(a).songId;
                if (PianoCoreBridge.isJoin())
                {
                    view = f.e;
                } else
                {
                    view = f.a;
                }
                q.a(s2, false, view);
                com.smule.pianoandroid.magicpiano.GoodJobActivity.e(a);
            }

            
            {
                a = GoodJobActivity.this;
                super();
            }
        });
        t.setOnClickListener(new android.view.View.OnClickListener() {

            final GoodJobActivity a;

            public void onClick(View view)
            {
                view = new Intent("android.intent.action.VIEW");
                view.setData(Uri.parse(a.getString(0x7f0c0259)));
                a.startActivity(view);
            }

            
            {
                a = GoodJobActivity.this;
                super();
            }
        });
        D = ak.a().a(B);
        if (bundle != null)
        {
            G = bundle.getBoolean(e, false);
            F = bundle.getBoolean(f, false);
        }
        bundle = com.smule.pianoandroid.magicpiano.a.g.a().a(D.songId);
        if (bundle != null && !bundle.isEmpty())
        {
            C = (ScoreInfo)bundle.get(0);
        } else
        {
            aa.b(d, (new StringBuilder()).append("Song ").append(D.title).append(" doesn't have scoreInfo").toString());
        }
        obj = getActionBar();
        bundle = (TextView)((ActionBar) (obj)).getCustomView().findViewById(0x7f0a0037);
        ((ActionBar) (obj)).setDisplayHomeAsUpEnabled(false);
        ((ActionBar) (obj)).setDisplayShowHomeEnabled(false);
        ((ActionBar) (obj)).setHomeButtonEnabled(false);
        ((ActionBar) (obj)).getCustomView().setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
        obj = (android.widget.RelativeLayout.LayoutParams)bundle.getLayoutParams();
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(13, -1);
        if (J)
        {
            bundle.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            bundle.setTextSize(1, 17F);
        }
        bundle.setText(D.title);
        K.put("uid", D.songId);
        K.put("composer", D.artist);
        K.put("genre", D.genre);
        I.b(this, 0x7f0a00b5, runnable, K);
    }

    protected void onDestroy()
    {
        if (U != null)
        {
            com.smule.android.f.h.a().b("NOTIFICATION_SCORE_SUBMITTED", U);
        }
        I.c(this);
        I = null;
        if (L != null)
        {
            (new File(L)).delete();
        }
        super.onDestroy();
    }

    protected void onPause()
    {
        I.a(this);
        super.onPause();
        MagicApplication.getInstance().onPause();
        S = false;
    }

    protected void onPostResume()
    {
        super.onPostResume();
        MagicApplication.getInstance().onResume();
        if (M != null)
        {
            if (O != 1)
            {
                an an1 = M;
                int i1 = O;
                String s1 = getString(0x7f0c02cc);
                boolean flag;
                if (O == 2)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                an1.a(i1, s1, flag);
            }
            M = null;
        }
        S = true;
        if (!F) goto _L2; else goto _L1
_L1:
        setResult(1);
        finish();
_L4:
        F = false;
        G = false;
        return;
_L2:
        if (G)
        {
            setResult(2);
            finish();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onRenderFailed(String s1)
    {
    }

    public void onRendered(String s1)
    {
    }

    protected void onResume()
    {
        I.b(this);
        com.smule.android.c.a.a(com.smule.pianoandroid.utils.r.f);
        super.onResume();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(e, G);
        bundle.putBoolean(f, F);
    }

    protected void onStart()
    {
        super.onStart();
        MagicApplication.onActivityStart(this);
        I.c(this, 0x7f0a00b5, null, K);
        if (!getSharedPreferences("sharedialog", 0).getBoolean("doNotShow", false) && com.smule.pianoandroid.e.e.a().f() >= 3 && H == 3 && !com.smule.pianoandroid.utils.i.d().b() && !J)
        {
            String s1 = D.songId;
            f f1;
            if (PianoCoreBridge.isJoin())
            {
                f1 = f.e;
            } else
            {
                f1 = f.a;
            }
            q.a(s1, true, f1);
            m();
        }
    }

    protected void onStop()
    {
        super.onStop();
        if (N != null && N.isShowing())
        {
            N.cancel();
            N = null;
        }
        if (!c && com.smule.android.facebook.a.a().c() && com.smule.android.facebook.a.a().i())
        {
            a("play_android", ((String) (null)), B);
        }
        MagicApplication.onActivityStop(this);
        I.f();
    }

    public void onVideoCompleted(String s1)
    {
    }

    public boolean shouldDisplayAd(String s1, FlurryAdType flurryadtype)
    {
        return I.b();
    }

    public void spaceDidFailToReceiveAd(String s1)
    {
        aa.b(d, (new StringBuilder()).append("Flurry failed to received ad for space ").append(s1).toString());
    }

    public void spaceDidReceiveAd(String s1)
    {
        aa.a(d, (new StringBuilder()).append("Flurry received ad for space ").append(s1).toString());
    }

}
