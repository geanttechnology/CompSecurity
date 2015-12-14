// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity;

import afm;
import afn;
import afo;
import afp;
import afq;
import afr;
import afv;
import afw;
import afx;
import afy;
import afz;
import agb;
import agf;
import agg;
import agi;
import amo;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import apq;
import azn;
import bjd;
import bje;
import bkv;
import bpy;
import com.flurry.android.FlurryAgent;
import com.fotoable.fotobeauty.FullscreenActivity;
import com.fotoable.fotoproedit.view.ui.ProEidtActionBarView;
import com.instabeauty.application.InstaBeautyApplication;
import com.wantu.imagelib.filter.TImageFilterManager;
import com.wantu.imagerender.ImageGLSurfaceView;
import com.wantu.utility.ui.ProcessDialogFragment;
import com.wantu.view.TFilterListScrollView;
import java.util.ArrayList;
import xn;
import zp;

public class ProEditFilterActivity extends FullscreenActivity
    implements amo, android.view.SurfaceHolder.Callback, bpy, xn
{

    private String A;
    private TImageFilterManager B;
    private int C;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G;
    private int H;
    private Bitmap I;
    private ImageGLSurfaceView J;
    private ArrayList K;
    private ArrayList L;
    private ArrayList M;
    private ArrayList N;
    private int O;
    private boolean P;
    private boolean Q;
    private boolean R;
    public TFilterListScrollView a;
    public TFilterListScrollView b;
    public TFilterListScrollView c;
    ProEidtActionBarView d;
    boolean e;
    FrameLayout f;
    bjd g;
    bje h;
    public Bitmap i;
    private final String j = "ProEditFilterActivity";
    private boolean k;
    private FrameLayout l;
    private ImageGLSurfaceView m;
    private bkv n;
    private RelativeLayout o;
    private SeekBar p;
    private FrameLayout q;
    private FrameLayout r;
    private FrameLayout s;
    private ImageView t;
    private ImageView u;
    private ImageView v;
    private FrameLayout w;
    private ProcessDialogFragment x;
    private String y;
    private int z;

    public ProEditFilterActivity()
    {
        k = false;
        z = 0;
        e = false;
        C = 4;
        D = true;
        E = false;
        F = false;
        h = new afy(this);
        i = null;
        G = true;
        H = 1;
        K = new ArrayList();
        L = new ArrayList();
        M = new ArrayList();
        N = new ArrayList();
        O = 0;
        P = true;
        Q = true;
        R = true;
    }

    public static int a(ProEditFilterActivity proeditfilteractivity, int i1)
    {
        proeditfilteractivity.z = i1;
        return i1;
    }

    public static Bitmap a(ProEditFilterActivity proeditfilteractivity, Bitmap bitmap)
    {
        proeditfilteractivity.I = bitmap;
        return bitmap;
    }

    private TImageFilterManager a(Context context)
    {
        if (B == null)
        {
            B = new TImageFilterManager(context);
        }
        return B;
    }

    public static TImageFilterManager a(ProEditFilterActivity proeditfilteractivity, Context context)
    {
        return proeditfilteractivity.a(context);
    }

    public static ImageGLSurfaceView a(ProEditFilterActivity proeditfilteractivity)
    {
        return proeditfilteractivity.m;
    }

    private void a(Bitmap bitmap)
    {
        int i1 = H + 1;
        switch (O)
        {
        default:
            return;

        case 0: // '\0'
            a.placeFilterItem(bitmap, i1);
            H = H + 1;
            return;

        case 1: // '\001'
            b.placeFilterItem(bitmap, i1);
            H = H + 1;
            return;

        case 2: // '\002'
            c.placeFilterItem(bitmap, i1);
            break;
        }
        H = H + 1;
    }

    private void a(ImageView imageview, boolean flag)
    {
        v.setSelected(false);
        t.setSelected(false);
        u.setSelected(false);
        u.clearColorFilter();
        t.clearColorFilter();
        v.clearColorFilter();
        Animation animation = AnimationUtils.loadAnimation(this, 0x7f04002c);
        Animation animation1 = AnimationUtils.loadAnimation(this, 0x7f04002b);
        if (imageview != null && flag)
        {
            imageview.setColorFilter(Color.rgb(0, 122, 255), android.graphics.PorterDuff.Mode.MULTIPLY);
            imageview.setSelected(true);
            if (imageview == v)
            {
                w.startAnimation(animation1);
                (new Handler()).postDelayed(new agf(this, animation), 300L);
            }
            if (imageview == u)
            {
                w.startAnimation(animation1);
                (new Handler()).postDelayed(new afn(this, animation), 300L);
            }
            if (imageview == t)
            {
                w.startAnimation(animation1);
                (new Handler()).postDelayed(new afo(this, animation), 300L);
            }
        } else
        {
            imageview.setColorFilter(Color.rgb(0, 122, 255), android.graphics.PorterDuff.Mode.MULTIPLY);
            imageview.setSelected(true);
            if (imageview == v)
            {
                b.setVisibility(4);
                a.setVisibility(4);
                c.setVisibility(0);
            }
            if (imageview == u)
            {
                c.setVisibility(4);
                a.setVisibility(4);
                b.setVisibility(0);
            }
            if (imageview == t)
            {
                c.setVisibility(4);
                b.setVisibility(4);
                a.setVisibility(0);
                return;
            }
        }
    }

    public static void a(ProEditFilterActivity proeditfilteractivity, ImageView imageview, boolean flag)
    {
        proeditfilteractivity.a(imageview, flag);
    }

    public static void a(ProEditFilterActivity proeditfilteractivity, ArrayList arraylist, int i1)
    {
        proeditfilteractivity.a(arraylist, i1);
    }

    private void a(ArrayList arraylist)
    {
        try
        {
            g = new bjd();
            g.a(h);
            g.a(arraylist);
            g.b(azn.d());
            g.d(new ArrayList[] {
                arraylist
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ArrayList arraylist)
        {
            arraylist.printStackTrace();
        }
    }

    private void a(ArrayList arraylist, int i1)
    {
        b();
        Log.e("ProEditFilterActivity", "showProcessDialog updateScrollImage");
        O = i1;
        H = 1;
        N.clear();
        N.addAll(arraylist);
        j();
    }

    public static boolean a(ProEditFilterActivity proeditfilteractivity, boolean flag)
    {
        proeditfilteractivity.E = flag;
        return flag;
    }

    public static bkv b(ProEditFilterActivity proeditfilteractivity)
    {
        return proeditfilteractivity.n;
    }

    public static void b(ProEditFilterActivity proeditfilteractivity, Bitmap bitmap)
    {
        proeditfilteractivity.a(bitmap);
    }

    public static boolean b(ProEditFilterActivity proeditfilteractivity, boolean flag)
    {
        proeditfilteractivity.F = flag;
        return flag;
    }

    public static boolean c(ProEditFilterActivity proeditfilteractivity)
    {
        return proeditfilteractivity.k;
    }

    public static boolean c(ProEditFilterActivity proeditfilteractivity, boolean flag)
    {
        proeditfilteractivity.R = flag;
        return flag;
    }

    public static void d(ProEditFilterActivity proeditfilteractivity)
    {
        proeditfilteractivity.g();
    }

    public static boolean d(ProEditFilterActivity proeditfilteractivity, boolean flag)
    {
        proeditfilteractivity.Q = flag;
        return flag;
    }

    public static boolean e(ProEditFilterActivity proeditfilteractivity)
    {
        return proeditfilteractivity.F;
    }

    public static boolean e(ProEditFilterActivity proeditfilteractivity, boolean flag)
    {
        proeditfilteractivity.P = flag;
        return flag;
    }

    public static ImageView f(ProEditFilterActivity proeditfilteractivity)
    {
        return proeditfilteractivity.t;
    }

    private void g()
    {
        if (i == null || i.isRecycled() || l.getWidth() <= 0)
        {
            return;
        } else
        {
            Object obj = new Rect(0, 0, l.getWidth(), l.getHeight());
            ((Rect) (obj)).inset(C, C);
            obj = zp.a(((Rect) (obj)), new Rect(0, 0, i.getWidth(), i.getHeight()));
            obj = new android.widget.FrameLayout.LayoutParams(((Rect) (obj)).width(), ((Rect) (obj)).height(), 17);
            m.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            m.setSourceBitmap(i);
            m.getHolder().addCallback(this);
            n = m.getRender();
            l.bringChildToFront(o);
            l.requestLayout();
            l.invalidate();
            a();
            return;
        }
    }

    public static void g(ProEditFilterActivity proeditfilteractivity)
    {
        proeditfilteractivity.i();
    }

    public static ImageView h(ProEditFilterActivity proeditfilteractivity)
    {
        return proeditfilteractivity.u;
    }

    private void h()
    {
        if (z == 0)
        {
            c.cancelSelected();
            b.cancelSelected();
        }
        if (z == 1)
        {
            c.cancelSelected();
            a.cancelSelected();
        }
        if (z == 2)
        {
            a.cancelSelected();
            b.cancelSelected();
        }
    }

    private void i()
    {
        if (G)
        {
            return;
        }
        Animation animation;
        boolean flag;
        if (!G)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        G = flag;
        w.setVisibility(0);
        animation = AnimationUtils.loadAnimation(this, 0x7f040012);
        animation.setAnimationListener(new afp(this));
        w.startAnimation(animation);
    }

    public static boolean i(ProEditFilterActivity proeditfilteractivity)
    {
        return proeditfilteractivity.R;
    }

    public static ArrayList j(ProEditFilterActivity proeditfilteractivity)
    {
        return proeditfilteractivity.L;
    }

    private void j()
    {
        if (H >= N.size())
        {
            c();
            if (J != null)
            {
                J.clear();
                J.onPause();
                l.removeView(J);
                J = null;
            }
        } else
        {
            if (J == null)
            {
                J = new ImageGLSurfaceView(this);
                l.addView(J);
                android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)J.getLayoutParams();
                layoutparams.height = 1;
                layoutparams.width = 1;
                J.setLayoutParams(layoutparams);
                J.setVisibility(0);
                J.getHolder().addCallback(new afq(this));
                J.onResume();
            }
            agi agi1 = (agi)N.get(H);
            if (I != null)
            {
                J.processImage(I, agi1.a, 1.0F, new agg(this));
                return;
            }
        }
    }

    public static ImageView k(ProEditFilterActivity proeditfilteractivity)
    {
        return proeditfilteractivity.v;
    }

    public static boolean l(ProEditFilterActivity proeditfilteractivity)
    {
        return proeditfilteractivity.Q;
    }

    public static ArrayList m(ProEditFilterActivity proeditfilteractivity)
    {
        return proeditfilteractivity.M;
    }

    public static boolean n(ProEditFilterActivity proeditfilteractivity)
    {
        return proeditfilteractivity.E;
    }

    public static Bitmap o(ProEditFilterActivity proeditfilteractivity)
    {
        return proeditfilteractivity.I;
    }

    public static ArrayList p(ProEditFilterActivity proeditfilteractivity)
    {
        return proeditfilteractivity.K;
    }

    public static boolean q(ProEditFilterActivity proeditfilteractivity)
    {
        return proeditfilteractivity.P;
    }

    public static FrameLayout r(ProEditFilterActivity proeditfilteractivity)
    {
        return proeditfilteractivity.w;
    }

    public static void s(ProEditFilterActivity proeditfilteractivity)
    {
        proeditfilteractivity.j();
    }

    public static FrameLayout t(ProEditFilterActivity proeditfilteractivity)
    {
        return proeditfilteractivity.l;
    }

    public void a()
    {
        c.clear();
        b.clear();
        a.clear();
        java.util.Map map = a(((Context) (this))).getmFilterDict();
        (new Thread(new afz(this, a(((Context) (this))).filterNamesByCatalogeName("lomo"), map, a(((Context) (this))).filterNamesByCatalogeName("beauty")))).start();
    }

    public void a(String s1)
    {
        if (m != null)
        {
            Log.v("ProEditFilterActivity", s1);
            if (A == null || !A.equals(s1))
            {
                h();
                A = s1;
                m.setFilterName(A);
                m.setOpacity(0.8F);
                p.setProgress(80);
                if (s1.equals(getResources().getString(0x7f0601a0)))
                {
                    c.setItemSelected(0, Boolean.valueOf(true));
                    a.setItemSelected(0, Boolean.valueOf(true));
                    b.setItemSelected(0, Boolean.valueOf(true));
                    p.setEnabled(false);
                } else
                {
                    p.setEnabled(true);
                }
                Log.v("ProEditFilterActivity", (new StringBuilder()).append(s1).append("is selected").toString());
                return;
            }
        }
    }

    public void a(String s1, Object obj)
    {
        h();
        if (m != null)
        {
            m.setFilterName(s1);
        }
        if (s1.equals(getResources().getString(0x7f0601a0)))
        {
            c.setItemSelected(0, Boolean.valueOf(true));
            a.setItemSelected(0, Boolean.valueOf(true));
            b.setItemSelected(0, Boolean.valueOf(true));
            p.setEnabled(false);
            return;
        } else
        {
            p.setEnabled(true);
            return;
        }
    }

    public void b()
    {
        try
        {
            if (x != null)
            {
                return;
            }
        }
        catch (Exception exception)
        {
            return;
        }
        x = ProcessDialogFragment.a(f());
        x.setCancelable(false);
        x.show(getSupportFragmentManager(), "process");
        return;
    }

    public void b(String s1)
    {
        y = s1;
    }

    public void c()
    {
        try
        {
            if (x != null)
            {
                x.dismissAllowingStateLoss();
                b(getResources().getString(0x7f0601c6));
                x = null;
            }
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void d()
    {
        if (n == null || m == null)
        {
            return;
        } else
        {
            apq.a("Filter");
            b();
            Log.e("ProEditFilterActivity", "showProcessDialog acceptClicked");
            n.a(new agb(this));
            m.requestRender();
            return;
        }
    }

    public void e()
    {
        setResult(0);
        finish();
        overridePendingTransition(0, 0x7f04001e);
    }

    public String f()
    {
        return y;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(0x7f030036);
        d = (ProEidtActionBarView)findViewById(0x7f0d00ba);
        d.setActionBarTitle("");
        d.setOnAcceptListener(this);
        a = (TFilterListScrollView)findViewById(0x7f0d012e);
        b = (TFilterListScrollView)findViewById(0x7f0d012f);
        c = (TFilterListScrollView)findViewById(0x7f0d0130);
        o = (RelativeLayout)findViewById(0x7f0d011c);
        b(getResources().getString(0x7f0601c6));
        p = (SeekBar)findViewById(0x7f0d011d);
        p.setEnabled(false);
        p.setProgress(100);
        p.setOnSeekBarChangeListener(new afm(this));
        bundle = getIntent();
        if (bundle != null)
        {
            k = bundle.getBooleanExtra("KISDERECTEDTOSAVE_STRING", false);
            if (k)
            {
                bundle = bundle.getStringExtra("KIMAGEURI");
                if (bundle != null)
                {
                    ArrayList arraylist = new ArrayList();
                    arraylist.add(Uri.parse(bundle));
                    a(arraylist);
                }
            }
        }
        m = (ImageGLSurfaceView)findViewById(0x7f0d00ac);
        bundle = (android.widget.FrameLayout.LayoutParams)m.getLayoutParams();
        bundle.width = 1;
        bundle.height = 1;
        bundle.gravity = 17;
        m.setLayoutParams(bundle);
        b();
        l = (FrameLayout)findViewById(0x7f0d00bb);
        l.getViewTreeObserver().addOnGlobalLayoutListener(new afr(this));
        q = (FrameLayout)findViewById(0x7f0d0132);
        r = (FrameLayout)findViewById(0x7f0d0134);
        s = (FrameLayout)findViewById(0x7f0d0136);
        if (InstaBeautyApplication.d())
        {
            s.setVisibility(8);
        }
        f = (FrameLayout)findViewById(0x7f0d012c);
        f.setVisibility(0);
        t = (ImageView)findViewById(0x7f0d0133);
        u = (ImageView)findViewById(0x7f0d0135);
        v = (ImageView)findViewById(0x7f0d0137);
        w = (FrameLayout)findViewById(0x7f0d012d);
        a(t, false);
        q.setOnClickListener(new afv(this));
        r.setOnClickListener(new afw(this));
        s.setOnClickListener(new afx(this));
    }

    protected void onDestroy()
    {
        super.onDestroy();
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (i1 == 4 && keyevent.getRepeatCount() == 0)
        {
            e();
        }
        return super.onKeyDown(i1, keyevent);
    }

    public void onPause()
    {
        super.onPause();
        if (m != null)
        {
            m.onPause();
        }
        if (x != null && x.isVisible())
        {
            c();
        }
        if (J != null && J.getRender() != null)
        {
            J.onPause();
        }
    }

    public void onResume()
    {
        super.onResume();
        FlurryAgent.onPageView();
        if (D)
        {
            D = false;
        }
        if (m != null && m.getRender() != null)
        {
            m.onResume();
        }
    }

    protected void onStart()
    {
        super.onStart();
    }

    protected void onStop()
    {
        super.onStop();
    }

    public void surfaceChanged(SurfaceHolder surfaceholder, int i1, int j1, int k1)
    {
    }

    public void surfaceCreated(SurfaceHolder surfaceholder)
    {
    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder)
    {
    }
}
