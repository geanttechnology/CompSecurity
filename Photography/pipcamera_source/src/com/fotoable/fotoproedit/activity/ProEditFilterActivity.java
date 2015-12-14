// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import com.fotoable.fotoproedit.activity.filter.TFilterListScrollView;
import com.fotoable.photocollage.view.ProEidtActionBarView;
import com.pipcamera.activity.FullscreenActivity;
import com.pipcamera.activity.NewPhotoShareActivity;
import com.pipcamera.application.PIPCameraApplication;
import com.wantu.imagelib.filter.TImageFilterInfo;
import com.wantu.imagelib.filter.TImageFilterManager;
import com.wantu.imagerender.ImageGLSurfaceView;
import com.wantu.utility.ui.ProcessDialogFragment;
import ev;
import ew;
import fn;
import gk;
import gl;
import gm;
import go;
import gx;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kf;
import ma;
import ms;
import rd;
import vb;

public class ProEditFilterActivity extends FullscreenActivity
    implements android.view.SurfaceHolder.Callback, gx, ma, ms
{

    public static String e = "imageFromeWebView";
    private int A;
    private Bitmap B;
    private ImageGLSurfaceView C;
    private ArrayList D;
    private ArrayList E;
    private ArrayList F;
    private ArrayList G;
    private int H;
    private boolean I;
    private boolean J;
    private boolean K;
    TFilterListScrollView a;
    TFilterListScrollView b;
    TFilterListScrollView c;
    ProEidtActionBarView d;
    boolean f;
    private final String g = "ProEditFilterActivity";
    private FrameLayout h;
    private ImageGLSurfaceView i;
    private vb j;
    private RelativeLayout k;
    private SeekBar l;
    private FrameLayout m;
    private FrameLayout n;
    private FrameLayout o;
    private ImageView p;
    private ImageView q;
    private ImageView r;
    private LinearLayout s;
    private ProcessDialogFragment t;
    private String u;
    private int v;
    private String w;
    private TImageFilterManager x;
    private int y;
    private boolean z;

    public ProEditFilterActivity()
    {
        v = 0;
        f = false;
        y = 4;
        z = true;
        A = 1;
        D = new ArrayList();
        E = new ArrayList();
        F = new ArrayList();
        G = new ArrayList();
        H = 0;
        I = true;
        J = true;
        K = true;
    }

    static int a(ProEditFilterActivity proeditfilteractivity, int i1)
    {
        proeditfilteractivity.v = i1;
        return i1;
    }

    private TImageFilterManager a(Context context)
    {
        if (x == null)
        {
            x = new TImageFilterManager();
        }
        return x;
    }

    static ImageGLSurfaceView a(ProEditFilterActivity proeditfilteractivity)
    {
        return proeditfilteractivity.i;
    }

    static ImageGLSurfaceView a(ProEditFilterActivity proeditfilteractivity, ImageGLSurfaceView imageglsurfaceview)
    {
        proeditfilteractivity.i = imageglsurfaceview;
        return imageglsurfaceview;
    }

    static vb a(ProEditFilterActivity proeditfilteractivity, vb vb1)
    {
        proeditfilteractivity.j = vb1;
        return vb1;
    }

    private void a(Bitmap bitmap)
    {
        int i1 = A + 1;
        switch (H)
        {
        default:
            return;

        case 0: // '\0'
            a.placeFilterItem(bitmap, i1);
            A = A + 1;
            return;

        case 1: // '\001'
            b.placeFilterItem(bitmap, i1);
            A = A + 1;
            return;

        case 2: // '\002'
            c.placeFilterItem(bitmap, i1);
            break;
        }
        A = A + 1;
    }

    private void a(ImageView imageview)
    {
        r.setSelected(false);
        p.setSelected(false);
        q.setSelected(false);
        q.clearColorFilter();
        p.clearColorFilter();
        r.clearColorFilter();
        c.setVisibility(4);
        b.setVisibility(4);
        a.setVisibility(4);
        if (imageview != null)
        {
            imageview.setColorFilter(Color.rgb(0, 122, 255), android.graphics.PorterDuff.Mode.MULTIPLY);
            imageview.setSelected(true);
            if (imageview == r)
            {
                c.setVisibility(0);
            }
            if (imageview == q)
            {
                b.setVisibility(0);
            }
            if (imageview == p)
            {
                a.setVisibility(0);
            }
        }
    }

    public static void a(ProEditFilterActivity proeditfilteractivity, Bitmap bitmap)
    {
        proeditfilteractivity.a(bitmap);
    }

    static void a(ProEditFilterActivity proeditfilteractivity, ImageView imageview)
    {
        proeditfilteractivity.a(imageview);
    }

    static void a(ProEditFilterActivity proeditfilteractivity, ArrayList arraylist, int i1)
    {
        proeditfilteractivity.a(arraylist, i1);
    }

    private void a(ArrayList arraylist, int i1)
    {
        b();
        Log.e("ProEditFilterActivity", "showProcessDialog updateScrollImage");
        H = i1;
        A = 0;
        G.clear();
        G.addAll(arraylist);
        i();
    }

    static boolean a(ProEditFilterActivity proeditfilteractivity, boolean flag)
    {
        proeditfilteractivity.K = flag;
        return flag;
    }

    public static FrameLayout b(ProEditFilterActivity proeditfilteractivity)
    {
        return proeditfilteractivity.h;
    }

    static boolean b(ProEditFilterActivity proeditfilteractivity, boolean flag)
    {
        proeditfilteractivity.J = flag;
        return flag;
    }

    static int c(ProEditFilterActivity proeditfilteractivity)
    {
        return proeditfilteractivity.y;
    }

    static RelativeLayout d(ProEditFilterActivity proeditfilteractivity)
    {
        return proeditfilteractivity.k;
    }

    static ImageView e(ProEditFilterActivity proeditfilteractivity)
    {
        return proeditfilteractivity.p;
    }

    static void f(ProEditFilterActivity proeditfilteractivity)
    {
        proeditfilteractivity.h();
    }

    static ImageView g(ProEditFilterActivity proeditfilteractivity)
    {
        return proeditfilteractivity.q;
    }

    private void g()
    {
        if (v == 0)
        {
            c.cancelSelected();
            b.cancelSelected();
        }
        if (v == 1)
        {
            c.cancelSelected();
            a.cancelSelected();
        }
        if (v == 2)
        {
            a.cancelSelected();
            b.cancelSelected();
        }
    }

    private void h()
    {
        if (z)
        {
            return;
        }
        Animation animation;
        boolean flag;
        if (!z)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        z = flag;
        s.setVisibility(0);
        animation = AnimationUtils.loadAnimation(this, 0x7f04000d);
        animation.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

            final ProEditFilterActivity a;

            public void onAnimationEnd(Animation animation1)
            {
                animation1 = (android.widget.FrameLayout.LayoutParams)ProEditFilterActivity.m(a).getLayoutParams();
                animation1.bottomMargin = ew.a(a, 40F);
                ProEditFilterActivity.m(a).setLayoutParams(animation1);
                ProEditFilterActivity.m(a).clearAnimation();
            }

            public void onAnimationRepeat(Animation animation1)
            {
            }

            public void onAnimationStart(Animation animation1)
            {
            }

            
            {
                a = ProEditFilterActivity.this;
                super();
            }
        });
        s.startAnimation(animation);
    }

    static boolean h(ProEditFilterActivity proeditfilteractivity)
    {
        return proeditfilteractivity.K;
    }

    static ArrayList i(ProEditFilterActivity proeditfilteractivity)
    {
        return proeditfilteractivity.E;
    }

    private void i()
    {
        if (A >= G.size())
        {
            c();
            if (C != null)
            {
                C.clear();
                C.onPause();
                h.removeView(C);
                C = null;
            }
        } else
        {
            if (C == null)
            {
                C = new ImageGLSurfaceView(this);
                h.addView(C);
                android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)C.getLayoutParams();
                layoutparams.height = 1;
                layoutparams.width = 1;
                C.setLayoutParams(layoutparams);
                C.setVisibility(0);
                C.getHolder().addCallback(new android.view.SurfaceHolder.Callback() {

                    final ProEditFilterActivity a;

                    public void surfaceChanged(SurfaceHolder surfaceholder, int i1, int j1, int k1)
                    {
                    }

                    public void surfaceCreated(SurfaceHolder surfaceholder)
                    {
                    }

                    public void surfaceDestroyed(SurfaceHolder surfaceholder)
                    {
                    }

            
            {
                a = ProEditFilterActivity.this;
                super();
            }
                });
                C.onResume();
            }
            gl gl1 = (gl)G.get(A);
            if (B != null)
            {
                C.processImage(B, gl1.a, 1.0F, new gk(this));
                return;
            }
        }
    }

    static ImageView j(ProEditFilterActivity proeditfilteractivity)
    {
        return proeditfilteractivity.r;
    }

    static boolean k(ProEditFilterActivity proeditfilteractivity)
    {
        return proeditfilteractivity.J;
    }

    static ArrayList l(ProEditFilterActivity proeditfilteractivity)
    {
        return proeditfilteractivity.F;
    }

    static LinearLayout m(ProEditFilterActivity proeditfilteractivity)
    {
        return proeditfilteractivity.s;
    }

    public static void n(ProEditFilterActivity proeditfilteractivity)
    {
        proeditfilteractivity.i();
    }

    public void a()
    {
        c.clear();
        b.clear();
        a.clear();
        Map map = a(((Context) (this))).getmFilterDict();
        Object obj1 = a(((Context) (this))).filterNamesByCatalogeName("lomo");
        Object obj = a(((Context) (this))).filterNamesByCatalogeName("beauty");
        Bitmap bitmap = gm.c().k();
        if (bitmap != null)
        {
            bitmap = ev.a(bitmap, 120, 120);
            a.addFilterItem(bitmap, getResources().getString(0x7f060181));
            gl gl3;
            for (obj1 = ((List) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); D.add(gl3))
            {
                TImageFilterInfo timagefilterinfo2 = (TImageFilterInfo)map.get((String)((Iterator) (obj1)).next());
                a.addFilterItem(bitmap, timagefilterinfo2.filterName);
                gl3 = new gl(this);
                gl3.a = timagefilterinfo2.filterName;
                gl3.b = 0;
            }

            a.setCallback(this);
            b.addFilterItem(bitmap, getResources().getString(0x7f060181));
            gl gl1;
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); E.add(gl1))
            {
                TImageFilterInfo timagefilterinfo = (TImageFilterInfo)map.get((String)((Iterator) (obj)).next());
                b.addFilterItem(bitmap, timagefilterinfo.filterName);
                gl1 = new gl(this);
                gl1.a = timagefilterinfo.filterName;
                gl1.b = 1;
            }

            b.setCallback(this);
            c.addFilterItem(bitmap, getResources().getString(0x7f060181));
            if (!PIPCameraApplication.d())
            {
                gl gl2;
                for (Iterator iterator = a(((Context) (this))).filterNamesByCatalogeName("arts").iterator(); iterator.hasNext(); F.add(gl2))
                {
                    TImageFilterInfo timagefilterinfo1 = (TImageFilterInfo)map.get((String)iterator.next());
                    c.addFilterItem(bitmap, timagefilterinfo1.filterName);
                    gl2 = new gl(this);
                    gl2.a = timagefilterinfo1.filterName;
                    gl2.b = 2;
                }

                c.setCallback(this);
            }
            B = bitmap;
            if (I)
            {
                I = false;
                a(D, 0);
                return;
            }
        }
    }

    public void a(String s1)
    {
        if (i != null)
        {
            Log.v("ProEditFilterActivity", s1);
            if (w == null || !w.equals(s1))
            {
                g();
                w = s1;
                i.setFilterName(w);
                i.setOpacity(0.8F);
                l.setProgress(80);
                if (s1.equals(getResources().getString(0x7f060181)))
                {
                    c.setItemSelected(0, Boolean.valueOf(true));
                    a.setItemSelected(0, Boolean.valueOf(true));
                    b.setItemSelected(0, Boolean.valueOf(true));
                    l.setEnabled(false);
                } else
                {
                    l.setEnabled(true);
                }
                Log.v("ProEditFilterActivity", (new StringBuilder()).append(s1).append("is selected").toString());
                return;
            }
        }
    }

    public void a(String s1, Object obj)
    {
        g();
        if (i != null)
        {
            i.setFilterName(s1);
        }
        if (s1.equals(getResources().getString(0x7f060181)))
        {
            c.setItemSelected(0, Boolean.valueOf(true));
            a.setItemSelected(0, Boolean.valueOf(true));
            b.setItemSelected(0, Boolean.valueOf(true));
            l.setEnabled(false);
            return;
        } else
        {
            l.setEnabled(true);
            return;
        }
    }

    public void b()
    {
        try
        {
            if (t != null)
            {
                return;
            }
        }
        catch (Exception exception)
        {
            return;
        }
        t = ProcessDialogFragment.a(f());
        t.setCancelable(false);
        t.show(getSupportFragmentManager(), "process");
        return;
    }

    public void b(String s1)
    {
        u = s1;
    }

    public void c()
    {
        try
        {
            if (t != null)
            {
                t.dismissAllowingStateLoss();
                b(getResources().getString(0x7f0601a4));
                t = null;
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
        if (j == null || i == null)
        {
            return;
        } else
        {
            b();
            Log.e("ProEditFilterActivity", "showProcessDialog acceptClicked");
            j.a(new Handler() {

                final ProEditFilterActivity a;

                public void handleMessage(Message message)
                {
                    message = (Bitmap)message.obj;
                    if (message != null)
                    {
                        try
                        {
                            kf.b("filter");
                            gm.c().a(new go(this) {

                                final _cls6 a;

                                public void a()
                                {
                                    Object obj;
                                    if (!a.a.f)
                                    {
                                        break MISSING_BLOCK_LABEL_139;
                                    }
                                    obj = gm.c().k();
                                    if (obj == null)
                                    {
                                        break MISSING_BLOCK_LABEL_104;
                                    }
                                    obj = rd.a(((Bitmap) (obj)));
                                    rd.a(((File) (obj)).getAbsolutePath(), a.a);
                                    obj = Uri.fromFile(((File) (obj)));
                                    if (obj == null)
                                    {
                                        break MISSING_BLOCK_LABEL_104;
                                    }
                                    Intent intent = new Intent(a.a, com/pipcamera/activity/NewPhotoShareActivity);
                                    intent.putExtra("PhotoShareActivity_ToShareImageUri", ((Uri) (obj)).toString());
                                    a.a.startActivity(intent);
                                    a.a.overridePendingTransition(0x7f040007, 0);
_L1:
                                    Exception exception;
                                    try
                                    {
                                        a.a.c();
                                        return;
                                    }
                                    catch (Exception exception1)
                                    {
                                        a.a.c();
                                        exception1.printStackTrace();
                                        return;
                                    }
                                    exception;
                                    exception.printStackTrace();
                                      goto _L1
                                    a.a.c();
                                    a.a.setResult(-1);
                                    a.a.finish();
                                    a.a.overridePendingTransition(0, 0x7f040027);
                                    return;
                                }

            
            {
                a = _pcls6;
                super();
            }
                            }, message, a);
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (Message message)
                        {
                            Log.e("ProEditFilterActivity", message.getMessage());
                        }
                        break MISSING_BLOCK_LABEL_64;
                    }
                    a.runOnUiThread(new Runnable(this) {

                        final _cls6 a;

                        public void run()
                        {
                            a.a.c();
                        }

            
            {
                a = _pcls6;
                super();
            }
                    });
                    return;
                    a.c();
                    return;
                }

            
            {
                a = ProEditFilterActivity.this;
                super();
            }
            });
            i.requestRender();
            return;
        }
    }

    public void e()
    {
        setResult(0);
        finish();
        overridePendingTransition(0, 0x7f040027);
    }

    public String f()
    {
        return u;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(0x7f030024);
        if (getIntent() != null && getIntent().hasExtra(e))
        {
            f = getIntent().getBooleanExtra(e, false);
        }
        d = (ProEidtActionBarView)findViewById(0x7f0c0088);
        bundle = getString(0x7f06029a);
        d.setActionBarTitle(bundle);
        d.setOnAcceptListener(this);
        a = (TFilterListScrollView)findViewById(0x7f0c00a3);
        b = (TFilterListScrollView)findViewById(0x7f0c00a4);
        c = (TFilterListScrollView)findViewById(0x7f0c00a5);
        k = (RelativeLayout)findViewById(0x7f0c0092);
        b(getResources().getString(0x7f0601a4));
        l = (SeekBar)findViewById(0x7f0c0093);
        l.setEnabled(false);
        l.setProgress(100);
        l.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {

            final ProEditFilterActivity a;

            public void onProgressChanged(SeekBar seekbar, int i1, boolean flag)
            {
                if (ProEditFilterActivity.a(a) != null)
                {
                    ProEditFilterActivity.a(a).setOpacity((float)i1 / 100F);
                }
            }

            public void onStartTrackingTouch(SeekBar seekbar)
            {
            }

            public void onStopTrackingTouch(SeekBar seekbar)
            {
            }

            
            {
                a = ProEditFilterActivity.this;
                super();
            }
        });
        h = (FrameLayout)findViewById(0x7f0c0096);
        h.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

            final ProEditFilterActivity a;

            public void onGlobalLayout()
            {
                Bitmap bitmap;
                Object obj;
label0:
                {
                    if (ProEditFilterActivity.a(a) == null)
                    {
                        obj = new Rect(0, 0, ProEditFilterActivity.b(a).getWidth(), ProEditFilterActivity.b(a).getHeight());
                        ((Rect) (obj)).inset(ProEditFilterActivity.c(a), ProEditFilterActivity.c(a));
                        bitmap = gm.c().k();
                        if (bitmap != null)
                        {
                            break label0;
                        }
                        Log.e("ProEditFilterActivity", "process bitmap is null");
                        a.c();
                        a.finish();
                    }
                    return;
                }
                obj = fn.a(((Rect) (obj)), new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()));
                ProEditFilterActivity.a(a, new ImageGLSurfaceView(a));
                obj = new android.widget.FrameLayout.LayoutParams(((Rect) (obj)).width(), ((Rect) (obj)).height(), 17);
                ProEditFilterActivity.a(a).setSourceBitmap(bitmap);
                ProEditFilterActivity.a(a).getHolder().addCallback(a);
                ProEditFilterActivity.a(a, ProEditFilterActivity.a(a).getRender());
                ProEditFilterActivity.b(a).bringChildToFront(ProEditFilterActivity.d(a));
                ProEditFilterActivity.b(a).requestLayout();
                ProEditFilterActivity.b(a).invalidate();
                ProEditFilterActivity.b(a).addView(ProEditFilterActivity.a(a), 0, ((android.view.ViewGroup.LayoutParams) (obj)));
            }

            
            {
                a = ProEditFilterActivity.this;
                super();
            }
        });
        a();
        m = (FrameLayout)findViewById(0x7f0c00a7);
        n = (FrameLayout)findViewById(0x7f0c00a9);
        o = (FrameLayout)findViewById(0x7f0c00ab);
        if (PIPCameraApplication.d())
        {
            o.setVisibility(8);
        }
        p = (ImageView)findViewById(0x7f0c00a8);
        q = (ImageView)findViewById(0x7f0c00aa);
        r = (ImageView)findViewById(0x7f0c00ac);
        s = (LinearLayout)findViewById(0x7f0c00a2);
        a(p);
        m.setOnClickListener(new android.view.View.OnClickListener() {

            final ProEditFilterActivity a;

            public void onClick(View view)
            {
                if (ProEditFilterActivity.e(a).isSelected())
                {
                    return;
                } else
                {
                    ProEditFilterActivity.f(a);
                    ProEditFilterActivity.a(a, 0);
                    ProEditFilterActivity.a(a, ProEditFilterActivity.e(a));
                    return;
                }
            }

            
            {
                a = ProEditFilterActivity.this;
                super();
            }
        });
        n.setOnClickListener(new android.view.View.OnClickListener() {

            final ProEditFilterActivity a;

            public void onClick(View view)
            {
                if (ProEditFilterActivity.g(a).isSelected())
                {
                    return;
                }
                ProEditFilterActivity.f(a);
                if (ProEditFilterActivity.h(a))
                {
                    ProEditFilterActivity.a(a, false);
                    ProEditFilterActivity.a(a, ProEditFilterActivity.i(a), 1);
                }
                ProEditFilterActivity.a(a, 1);
                ProEditFilterActivity.a(a, ProEditFilterActivity.g(a));
            }

            
            {
                a = ProEditFilterActivity.this;
                super();
            }
        });
        o.setOnClickListener(new android.view.View.OnClickListener() {

            final ProEditFilterActivity a;

            public void onClick(View view)
            {
                if (ProEditFilterActivity.j(a).isSelected())
                {
                    return;
                }
                ProEditFilterActivity.f(a);
                if (ProEditFilterActivity.k(a))
                {
                    ProEditFilterActivity.b(a, false);
                    ProEditFilterActivity.a(a, ProEditFilterActivity.l(a), 2);
                }
                ProEditFilterActivity.a(a, 2);
                ProEditFilterActivity.a(a, ProEditFilterActivity.j(a));
            }

            
            {
                a = ProEditFilterActivity.this;
                super();
            }
        });
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
        if (i != null)
        {
            i.onPause();
        }
        if (t != null && t.isVisible())
        {
            c();
        }
        if (C != null && C.getRender() != null)
        {
            C.onPause();
        }
    }

    public void onResume()
    {
        super.onResume();
        if (i != null && i.getRender() != null)
        {
            i.onResume();
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
