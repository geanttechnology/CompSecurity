// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.apps.youtube.kids.activities;

import aaa;
import acd;
import aco;
import act;
import ada;
import adc;
import adg;
import adk;
import adn;
import afz;
import amd;
import amj;
import android.content.Intent;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.TextUtils;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import bcy;
import bgv;
import bje;
import bjv;
import blu;
import bmo;
import bmr;
import boq;
import bov;
import bpj;
import bsc;
import bss;
import bsz;
import bta;
import bum;
import bvy;
import bwa;
import bxb;
import bxe;
import bxx;
import bxy;
import byc;
import chv;
import cnq;
import com.google.android.apps.youtube.core.player.PlayerView;
import com.google.android.apps.youtube.kids.application.KidsApplication;
import com.google.android.apps.youtube.kids.ui.ParentalControlLaunchBar;
import com.google.android.apps.youtube.kids.ui.ScrollingSectionListGridView;
import com.google.android.apps.youtube.kids.ui.TimeLimitProgressBar;
import cse;
import csf;
import csg;
import csx;
import csy;
import ctd;
import cto;
import ctr;
import cts;
import ctt;
import cuv;
import cuz;
import dky;
import dre;
import duu;
import dxa;
import eby;
import eda;
import ede;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx;
import sj;
import sr;
import ta;
import uy;
import xn;
import zs;
import zt;
import zu;
import zv;
import zw;
import zx;
import zy;

public class WatchActivity extends xn
    implements bxe
{

    private ScrollingSectionListGridView A;
    private bov B;
    private bvy C;
    private Handler D;
    private boolean E;
    private boolean F;
    private boolean G;
    private boolean H;
    private boolean I;
    private boolean J;
    private Bundle K;
    private blu L;
    private TransitionSet M;
    private String N;
    private bum O;
    private zy P;
    private rx h;
    private bpj i;
    private PlayerView j;
    private act k;
    private View l;
    private adg m;
    private adk n;
    private adc o;
    private sj p;
    private ta q;
    private ViewGroup r;
    private View s;
    private View t;
    private View u;
    private View v;
    private View w;
    private View x;
    private ParentalControlLaunchBar y;
    private TimeLimitProgressBar z;

    public WatchActivity()
    {
        P = new zy(this);
    }

    public static act a(WatchActivity watchactivity)
    {
        return watchactivity.k;
    }

    private void a(bum bum1)
    {
        Object obj1;
        boolean flag;
        boolean flag1;
        flag = false;
        flag1 = false;
        O = bum1;
        obj1 = o;
        if (bum1 == null) goto _L2; else goto _L1
_L1:
        Object obj;
        int i1;
        boolean flag2;
        if (bum1.a.f != null)
        {
            obj = new bsc(bum1.a.f.a, null);
        } else
        {
            obj = null;
        }
        obj1.b = ((bsc) (obj));
        if (((adc) (obj1)).b == null) goto _L4; else goto _L3
_L3:
        obj = ((adc) (obj1)).b.c();
        if (obj == null || ((dxa) (obj)).d == null) goto _L4; else goto _L5
_L5:
        flag2 = true;
_L15:
        ((adc) (obj1)).a.c(flag2);
_L2:
        i1 = ((flag) ? 1 : 0);
        if (bum1 == null) goto _L7; else goto _L6
_L6:
        i1 = ((flag) ? 1 : 0);
        if (bum1.b == null) goto _L7; else goto _L8
_L8:
        obj = bum1.b.a;
        flag = flag1;
        if (A.d.a() <= 0) goto _L10; else goto _L9
_L9:
        obj1 = A;
        if (((ScrollingSectionListGridView) (obj1)).d.a() == ((List) (obj)).size()) goto _L12; else goto _L11
_L11:
        i1 = 0;
_L13:
        flag = flag1;
        if (i1 == 0)
        {
            A.a();
            flag = true;
        }
_L10:
        i1 = ((flag) ? 1 : 0);
        if (A.d.a() == 0)
        {
            obj1 = A.d;
            i1 = ((flag) ? 1 : 0);
            if (obj != null)
            {
                ((afz) (obj1)).a(((List) (obj)));
                ((afz) (obj1)).notifyDataSetChanged();
                i1 = ((flag) ? 1 : 0);
            }
        }
_L7:
        if (i1 != 0)
        {
            D.postDelayed(new zv(this, bum1), 125L);
            return;
        } else
        {
            A.a(bum1);
            return;
        }
_L12:
        i1 = 0;
        do
        {
            if (i1 >= ((ScrollingSectionListGridView) (obj1)).d.a())
            {
                break;
            }
            Object obj2 = ((ScrollingSectionListGridView) (obj1)).d.getItem(i1);
            if (!(obj2 instanceof bta))
            {
                i1 = 0;
                continue; /* Loop/switch isn't completed */
            }
            obj2 = (bta)obj2;
            if (obj2 != null && ((List) (obj)).get(i1) != null && !((bta) (obj2)).a.g.equals(((bta)((List) (obj)).get(i1)).a.g))
            {
                i1 = 0;
                continue; /* Loop/switch isn't completed */
            }
            i1++;
        } while (true);
        i1 = 1;
        if (true) goto _L13; else goto _L4
_L4:
        flag2 = false;
        if (true) goto _L15; else goto _L14
_L14:
    }

    private void a(bum bum1, bvy bvy1)
    {
        if (bvy1 != null)
        {
            B.a(bvy1, bum1, null);
        }
        if (!bum1.e.equals(N))
        {
            O = null;
            N = bum1.e;
        }
        if (!chv.a(bum1.d.e.b))
        {
            A.removeCallbacks(P);
            a(bum1);
        } else
        if (O == null)
        {
            P.a = bum1;
            A.postDelayed(P, 1000L);
            return;
        }
    }

    private void a(bvy bvy1)
    {
        if (bvy1 != null && !bvy1.equals(C))
        {
            C = bvy1;
            B.a(bvy1, bwa.a, null);
        }
    }

    public static void a(WatchActivity watchactivity, bum bum1)
    {
        watchactivity.a(bum1);
    }

    public static void a(WatchActivity watchactivity, cto cto1)
    {
        watchactivity.a(cto1);
    }

    private void a(cto cto1)
    {
        if (h.b(cto1))
        {
            return;
        } else
        {
            h.a(cto1);
            k.a(true);
            k.b(false);
            return;
        }
    }

    public static rx b(WatchActivity watchactivity)
    {
        return watchactivity.h;
    }

    public static ScrollingSectionListGridView c(WatchActivity watchactivity)
    {
        return watchactivity.A;
    }

    private void handlePlaybackServiceException(cse cse1)
    {
        zw.a[cse1.a.ordinal()];
        JVM INSTR tableswitch 1 7: default 52
    //                   1 53
    //                   2 53
    //                   3 53
    //                   4 53
    //                   5 53
    //                   6 53
    //                   7 126;
           goto _L1 _L2 _L2 _L2 _L2 _L2 _L2 _L3
_L1:
        return;
_L2:
        Object obj = cse1.c;
        cse1 = ((cse) (obj));
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            cse1 = getString(0x7f0b00b9);
        }
        G = true;
        obj = k;
        obj.f = true;
        ((act) (obj)).b();
        ((act) (obj)).a(false);
        ((act) (obj)).c.setText(cse1);
        ((act) (obj)).c.setVisibility(0);
        ((act) (obj)).g.a(false);
        return;
_L3:
        cse1 = cse1.c;
        if (cse1 != null && cse1.equals(getString(0x7f0b0122)))
        {
            I = true;
            k.a(cuv.d);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    private void handleSequencerHasPreviousNext(csx csx1)
    {
        boolean flag = false;
        E = csx1.a;
        F = csx1.b;
        if (!k.d)
        {
            csx1 = s;
            int i1;
            if (E)
            {
                i1 = 0;
            } else
            {
                i1 = 4;
            }
            csx1.setVisibility(i1);
            csx1 = t;
            if (F)
            {
                i1 = ((flag) ? 1 : 0);
            } else
            {
                i1 = 4;
            }
            csx1.setVisibility(i1);
        }
    }

    private void handleSequencerStageEvent(csy csy1)
    {
        zw.b[csy1.a.ordinal()];
        JVM INSTR tableswitch 1 2: default 32
    //                   1 33
    //                   2 238;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        a(csy1.d);
        bxb bxb1 = csy1.b;
        csy1 = csy1.d;
        if (bxb1.f().a())
        {
            if (csy1 != null)
            {
                B.a(csy1, bxb1, null);
            }
            G = false;
            csy1 = k;
            csy1.f = false;
            ((act) (csy1)).c.setVisibility(8);
            if (!((act) (csy1)).d)
            {
                csy1.c();
            }
            if (v != null)
            {
                ((TextView)findViewById(0x7f100072)).setText(bxb1.c());
            }
            if (n != null)
            {
                csy1 = i();
                if (csy1 != null && csy1.i().a())
                {
                    Object obj = n;
                    if (bxb1 != null)
                    {
                        csy1 = bxb1.d();
                        obj = ((adk) (obj)).b;
                        ((adn) (obj)).d.a(csy1, null);
                        ((adn) (obj)).a(4);
                    }
                }
            }
            if (O != null && !bxb.a(bxb1.a).equals(O.e))
            {
                k.c(false);
            }
            k.d();
            return;
        }
          goto _L1
_L3:
        a(csy1.d);
        a(csy1.c, csy1.d);
        return;
    }

    private void handleVideoStageEvent(ctd ctd1)
    {
        zw.c[ctd1.b.ordinal()];
        JVM INSTR tableswitch 1 3: default 36
    //                   1 37
    //                   2 52
    //                   3 52;
           goto _L1 _L2 _L3 _L3
_L1:
        return;
_L2:
        J = false;
        x.setVisibility(8);
        return;
_L3:
        J = true;
        if (!k.d)
        {
            x.setVisibility(0);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    private static boolean j()
    {
        return android.os.Build.VERSION.SDK_INT >= 19;
    }

    private aco k()
    {
        HashMap hashmap = new HashMap();
        hashmap.put(eda, new zx(this));
        bxy bxy1 = new bxy();
        bxy1.a(new bxx(this, k, (boq)c().M.b_()), new Class[] {
            dky
        });
        return new aco(hashmap, this, bxy1, c().F());
    }

    protected final void g()
    {
        g.a(false);
    }

    public final bvy h()
    {
        if (C == null)
        {
            bmo.e("InteractionLoggingData was null. Setting to new value before returning.");
            C = new bvy(e().f());
        }
        return C;
    }

    public void handleConnectivityChangeEvent(bjv bjv1)
    {
        if (bjv1.a && I)
        {
            I = false;
            h.j();
        }
    }

    public void handlePlayerGeometryEvent(csg csg1)
    {
        byte byte0;
        byte0 = 4;
        Object obj;
        boolean flag;
        if (csg1.b == ctr.c)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (k.d == flag) goto _L2; else goto _L1
_L1:
        csg1 = k;
        csg1.d = flag;
        csg1.d();
        int i1;
        if (((act) (csg1)).d)
        {
            csg1.b();
        } else
        {
            csg1.c();
        }
        csg1 = m;
        obj = ((adg) (csg1)).a;
        if (flag)
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        ((ViewGroup) (obj)).setVisibility(i1);
        obj = csg1.getResources();
        if (flag)
        {
            i1 = 0x7f0a00f8;
        } else
        {
            i1 = 0x7f0a00f9;
        }
        i1 = ((Resources) (obj)).getDimensionPixelSize(i1);
        ((android.view.ViewGroup.MarginLayoutParams)((adg) (csg1)).b.getLayoutParams()).setMargins(0, 0, 0, i1);
        ((adg) (csg1)).b.requestLayout();
        if (!flag) goto _L4; else goto _L3
_L3:
        if (G) goto _L6; else goto _L5
_L5:
        if (j())
        {
            TransitionManager.beginDelayedTransition(r, M);
        }
        if (v == null) goto _L8; else goto _L7
_L7:
        v.setVisibility(8);
_L11:
        s.setVisibility(8);
        t.setVisibility(8);
        z.setVisibility(8);
        A.setVisibility(8);
        l.setVisibility(8);
        y.setVisibility(8);
        x.setVisibility(8);
_L6:
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        j.setContentDescription(getResources().getString(0x7f0b01ee));
_L2:
        return;
_L8:
        if (w != null)
        {
            w.setVisibility(8);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        int j1;
        if (v != null)
        {
            v.setVisibility(0);
        } else
        if (w != null)
        {
            w.setVisibility(0);
        }
        csg1 = s;
        if (E)
        {
            j1 = 0;
        } else
        {
            j1 = 4;
        }
        csg1.setVisibility(j1);
        csg1 = t;
        j1 = byte0;
        if (F)
        {
            j1 = 0;
        }
        csg1.setVisibility(j1);
        z.setVisibility(0);
        A.setVisibility(0);
        l.setVisibility(0);
        y.setVisibility(0);
        if (J)
        {
            x.setVisibility(0);
        }
        if (true) goto _L6; else goto _L9
_L9:
        j.setContentDescription(getResources().getString(0x7f0b01ef));
        return;
        if (true) goto _L11; else goto _L10
_L10:
    }

    public void onBackPressed()
    {
        if (k.d)
        {
            o.a(false);
            return;
        } else
        {
            super.onBackPressed();
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        setContentView(0x7f04006a);
        super.onCreate(bundle);
        i = c().M();
        L = d().c();
        K = getIntent().getExtras();
        h = c().H();
        k = new act(this);
        o = new adc(this, k, h, k());
        bundle = new sr(this);
        q = new ta(bundle, c().Q(), e().i(), false, this, e().d());
        r = (ViewGroup)findViewById(0x7f10018f);
        j = (PlayerView)findViewById(0x7f100193);
        c().y().a(j);
        s = findViewById(0x7f100187);
        t = findViewById(0x7f100098);
        w = findViewById(0x7f1000c0);
        u = k.findViewById(0x7f1000ce);
        v = findViewById(0x7f100097);
        l = k.findViewById(0x7f1000cc);
        x = k.findViewById(0x7f1000cf);
        y = (ParentalControlLaunchBar)findViewById(0x7f1000b9);
        y.a();
        z = (TimeLimitProgressBar)findViewById(0x7f1000b2);
        z.a();
        A = (ScrollingSectionListGridView)findViewById(0x7f1001ca);
        m = new adg(getApplicationContext(), 0);
        p = new sj(m, e().d(), h, i, L, k());
        B = c().N();
        if (((KidsApplication)getApplicationContext()).i())
        {
            adn adn1 = new adn(this, L);
            n = new adk(i(), adn1);
            j.a(new cuz[] {
                adn1, bundle, k, m
            });
            o.c = i().i().a();
        } else
        {
            j.a(new cuz[] {
                bundle, k, m
            });
        }
        A.a(L, k(), null, getResources().getInteger(0x7f0e0009), B, this);
        A.a(new zs(this));
        s.setOnClickListener(new zt(this));
        t.setOnClickListener(new zu(this));
        if (j())
        {
            int i1 = getResources().getInteger(0x7f0e0025);
            M = (new TransitionSet()).setOrdering(1).addTransition(new ChangeBounds()).addTransition(new Fade(1)).setDuration(i1);
        }
        D = new Handler();
        H = true;
        I = false;
        J = false;
    }

    public void onDestroy()
    {
        super.onDestroy();
    }

    public void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        b();
    }

    public void onPause()
    {
        Object obj = k;
        ((act) (obj)).i.cancel();
        if (((act) (obj)).j)
        {
            ((act) (obj)).a();
        }
        k.a(cuv.c);
        k.d();
        obj = e().d();
        ((bje) (obj)).b(this);
        if (n != null)
        {
            ((bje) (obj)).b(n);
        }
        ((bje) (obj)).b(o);
        ((bje) (obj)).b(p);
        ((bje) (obj)).b(q);
        h.c(isFinishing());
        super.onPause();
    }

    public void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
        E = bundle.getBoolean("hasPrevious");
        F = bundle.getBoolean("hasNext");
        G = bundle.getBoolean("isError");
        H = bundle.getBoolean("isFirstTime");
        I = bundle.getBoolean("isReloadNeeded");
        O = (bum)bundle.getParcelable("watchNextResponse");
        uy uy1 = (uy)bundle.getParcelable("playbackServiceState");
        h.a(uy1);
        if (u != null)
        {
            u.setVisibility(bundle.getInt("replayVisibility"));
        }
        k.a(false);
    }

    public void onResume()
    {
        super.onResume();
        b();
        h.a(j.a);
        Object obj = e().d();
        ((bje) (obj)).a(this);
        if (n != null)
        {
            ((bje) (obj)).a(n);
        }
        ((bje) (obj)).a(o);
        ((bje) (obj)).a(p);
        ((bje) (obj)).a(q);
        obj = o;
        boolean flag1;
        if (H && getResources().getBoolean(0x7f12000d))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        ((adc) (obj)).a(flag1);
        if (H && K.containsKey("playbackStartDescriptor"))
        {
            H = false;
            cto cto1 = (cto)K.getParcelable("playbackStartDescriptor");
            if (cto1 != null)
            {
                a(cto1);
            }
        } else
        {
            NetworkInfo networkinfo;
            boolean flag;
            if (O == null || !O.e.equals(h.d()))
            {
                h.k();
            } else
            {
                a(O, ((bvy) (null)));
            }
            networkinfo = ((ConnectivityManager)getSystemService("connectivity")).getActiveNetworkInfo();
            if (networkinfo != null && networkinfo.isConnected())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag && I)
            {
                I = false;
                h.j();
                k.a(true);
                return;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("hasPrevious", E);
        bundle.putBoolean("hasNext", F);
        bundle.putBoolean("isError", G);
        bundle.putBoolean("isFirstTime", H);
        bundle.putBoolean("isReloadNeeded", I);
        bundle.putParcelable("watchNextResponse", O);
        bundle.putParcelable("playbackServiceState", h.e(false));
        if (u != null)
        {
            bundle.putInt("replayVisibility", u.getVisibility());
        }
    }
}
