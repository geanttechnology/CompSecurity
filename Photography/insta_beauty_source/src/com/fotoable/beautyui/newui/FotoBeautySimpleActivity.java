// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui.newui;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.crashlytics.android.Crashlytics;
import com.fotoable.beautyui.NewFilterContainer;
import com.fotoable.fotobeauty.FullscreenActivity;
import com.wantu.imagerender.ImageGLSurfaceView;
import ig;
import iv;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import pt;
import sx;
import sy;
import sz;
import ta;
import tc;
import td;
import te;
import tf;
import th;
import uv;
import xb;
import yo;

public class FotoBeautySimpleActivity extends FullscreenActivity
    implements android.view.SurfaceHolder.Callback
{

    private static com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState l;
    private final String a = "FotoBeautySimpleActivity";
    private xb b;
    private ImageView c;
    private ImageView d;
    private NewFilterContainer e;
    private ImageView f;
    private ImageView g;
    private ImageGLSurfaceView h;
    private FrameLayout i;
    private Bitmap j;
    private ig k;
    private FrameLayout m;
    private String n;
    private float o;
    private ExecutorService p;
    private boolean q;
    private float r;
    private th s;
    private boolean t;
    private iv u;
    private android.view.View.OnClickListener v;

    public FotoBeautySimpleActivity()
    {
        n = "";
        o = 0.7F;
        p = Executors.newSingleThreadExecutor();
        q = false;
        r = 0.5F;
        s = new th(this, this);
        t = true;
        u = new tc(this);
        v = new td(this);
    }

    public static float a(FotoBeautySimpleActivity fotobeautysimpleactivity, float f1)
    {
        fotobeautysimpleactivity.o = f1;
        return f1;
    }

    private Bitmap a(Bitmap bitmap)
    {
        Bitmap bitmap1 = j.copy(android.graphics.Bitmap.Config.ARGB_8888, true);
        Canvas canvas = new Canvas(bitmap1);
        Paint paint = new Paint();
        paint.setColor(-1);
        paint.setAlpha((int)(e.getFilterValue() * 255F));
        paint.setAntiAlias(true);
        paint.setStrokeWidth(2.0F);
        if (bitmap != null)
        {
            canvas.drawBitmap(bitmap, 0.0F, 0.0F, paint);
        }
        return bitmap1;
    }

    public static Bitmap a(FotoBeautySimpleActivity fotobeautysimpleactivity, Bitmap bitmap)
    {
        fotobeautysimpleactivity.j = bitmap;
        return bitmap;
    }

    public static ImageView a(FotoBeautySimpleActivity fotobeautysimpleactivity)
    {
        return fotobeautysimpleactivity.c;
    }

    public static String a(FotoBeautySimpleActivity fotobeautysimpleactivity, String s1)
    {
        fotobeautysimpleactivity.n = s1;
        return s1;
    }

    private void a(Bitmap bitmap, String s1)
    {
        if (s1 != null && !s1.equals(""))
        {
            g();
            if (h != null && bitmap != null && s1 != null)
            {
                h.processImage(bitmap, s1, 1.0F, s);
            }
            return;
        } else
        {
            h();
            return;
        }
    }

    private void a(View view, int i1, int j1, long l1, boolean flag)
    {
        if (view == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        if (view.getVisibility() != 0)
        {
            return;
        }
        try
        {
            TranslateAnimation translateanimation = new TranslateAnimation(0.0F, 0.0F, i1, j1);
            translateanimation.setDuration(l1);
            translateanimation.setInterpolator(new DecelerateInterpolator());
            translateanimation.setAnimationListener(new sz(this, flag, view));
            view.startAnimation(translateanimation);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view) { }
    }

    private void a(ImageView imageview, float f1)
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            imageview.setAlpha(f1);
            return;
        } else
        {
            imageview.setAlpha((int)(255F * f1));
            return;
        }
    }

    public static void a(FotoBeautySimpleActivity fotobeautysimpleactivity, Bitmap bitmap, String s1)
    {
        fotobeautysimpleactivity.a(bitmap, s1);
    }

    public static void a(FotoBeautySimpleActivity fotobeautysimpleactivity, View view, int i1, int j1, long l1, boolean flag)
    {
        fotobeautysimpleactivity.a(view, i1, j1, l1, flag);
    }

    public static void a(FotoBeautySimpleActivity fotobeautysimpleactivity, ImageView imageview, float f1)
    {
        fotobeautysimpleactivity.a(imageview, f1);
    }

    public static com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState b()
    {
        return l;
    }

    public static boolean b(FotoBeautySimpleActivity fotobeautysimpleactivity)
    {
        return fotobeautysimpleactivity.q;
    }

    public static FrameLayout c(FotoBeautySimpleActivity fotobeautysimpleactivity)
    {
        return fotobeautysimpleactivity.m;
    }

    private void c()
    {
        if (pt.b(pt.t, this, false))
        {
            k.a(true, 0.5F, 0.3F, 0.3F, 0.2F, 0.2F);
        } else
        {
            k.a(true, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        }
        d();
    }

    public static Bitmap d(FotoBeautySimpleActivity fotobeautysimpleactivity)
    {
        return fotobeautysimpleactivity.j;
    }

    private void d()
    {
        k.a(r);
    }

    public static NewFilterContainer e(FotoBeautySimpleActivity fotobeautysimpleactivity)
    {
        return fotobeautysimpleactivity.e;
    }

    private void e()
    {
        g();
        p.execute(new ta(this));
    }

    public static xb f(FotoBeautySimpleActivity fotobeautysimpleactivity)
    {
        return fotobeautysimpleactivity.b;
    }

    private void f()
    {
        if (t)
        {
            t = false;
            Bitmap bitmap = yo.b(j, 90, 120);
            e.setPresetScrollImg(bitmap);
            e.setScrollImage(bitmap);
            e.setItemViewSelected(n);
            return;
        } else
        {
            e.needScrollView();
            return;
        }
    }

    public static ig g(FotoBeautySimpleActivity fotobeautysimpleactivity)
    {
        return fotobeautysimpleactivity.k;
    }

    private void g()
    {
        i.setVisibility(0);
    }

    private void h()
    {
        i.setVisibility(4);
    }

    public static void h(FotoBeautySimpleActivity fotobeautysimpleactivity)
    {
        fotobeautysimpleactivity.c();
    }

    public static ImageView i(FotoBeautySimpleActivity fotobeautysimpleactivity)
    {
        return fotobeautysimpleactivity.d;
    }

    private boolean i()
    {
        return i.getVisibility() == 0;
    }

    private void j()
    {
        if (i())
        {
            return;
        } else
        {
            g();
            p.execute(new te(this));
            return;
        }
    }

    public static void j(FotoBeautySimpleActivity fotobeautysimpleactivity)
    {
        fotobeautysimpleactivity.h();
    }

    private void k()
    {
        g();
        if (this != null)
        {
            Object obj = new HashMap();
            ((Map) (obj)).put("filterSel", n);
            sx.a("OneKeyNext", ((Map) (obj)));
            obj = ((BitmapDrawable)c.getDrawable()).getBitmap();
            if (obj != null)
            {
                obj = a(((Bitmap) (obj)));
                uv.c().a(((Bitmap) (obj)), new tf(this, ((Bitmap) (obj))));
                return;
            }
        }
    }

    public static void k(FotoBeautySimpleActivity fotobeautysimpleactivity)
    {
        fotobeautysimpleactivity.f();
    }

    public static float l(FotoBeautySimpleActivity fotobeautysimpleactivity)
    {
        return fotobeautysimpleactivity.o;
    }

    public static String m(FotoBeautySimpleActivity fotobeautysimpleactivity)
    {
        return fotobeautysimpleactivity.n;
    }

    public static void n(FotoBeautySimpleActivity fotobeautysimpleactivity)
    {
        fotobeautysimpleactivity.j();
    }

    public static void o(FotoBeautySimpleActivity fotobeautysimpleactivity)
    {
        fotobeautysimpleactivity.k();
    }

    public boolean a()
    {
label0:
        {
            boolean flag1 = false;
            boolean flag = flag1;
            int i1;
            try
            {
                if (k == null)
                {
                    break label0;
                }
                i1 = k.a();
            }
            catch (Exception exception)
            {
                Crashlytics.logException(exception);
                exception.printStackTrace();
                return false;
            }
            flag = flag1;
            if (i1 > 0)
            {
                flag = true;
            }
        }
        return flag;
    }

    public void onCreate(Bundle bundle)
    {
label0:
        {
            super.onCreate(bundle);
            requestWindowFeature(1);
            getWindow().setFlags(1024, 1024);
            setContentView(0x7f030028);
            m = (FrameLayout)findViewById(0x7f0d00c9);
            e = (NewFilterContainer)findViewById(0x7f0d00ca);
            g = (ImageView)findViewById(0x7f0d0106);
            f = (ImageView)findViewById(0x7f0d00cb);
            c = (ImageView)findViewById(0x7f0d00c8);
            d = (ImageView)findViewById(0x7f0d00c7);
            i = (FrameLayout)findViewById(0x7f0d0060);
            i.setVisibility(8);
            i.setClickable(true);
            c.setVisibility(0);
            d.setVisibility(0);
            if (b != null)
            {
                j = b.a();
                k = b.b();
                if (j == null)
                {
                    break label0;
                }
                c.setImageBitmap(j);
                d.setImageBitmap(j);
            }
            f.setOnClickListener(v);
            g.setOnClickListener(v);
            f.getBackground().setColorFilter(getResources().getColor(0x7f0c00a6), android.graphics.PorterDuff.Mode.SRC_IN);
            g.getBackground().setColorFilter(getResources().getColor(0x7f0c009d), android.graphics.PorterDuff.Mode.SRC_IN);
            e.setListener(u);
            e.setBtnFindState(true);
            c.getViewTreeObserver().addOnGlobalLayoutListener(new sy(this));
            h = (ImageGLSurfaceView)findViewById(0x7f0d00ac);
            h.setVisibility(0);
            h.getHolder().addCallback(this);
            e();
            return;
        }
        b.a(l);
    }

    public void onDestroy()
    {
        if (s != null)
        {
            s.removeCallbacksAndMessages(null);
        }
        super.onDestroy();
    }

    public void onPause()
    {
        super.onPause();
        try
        {
            if (h != null)
            {
                h.onPause();
            }
            return;
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
            exception.printStackTrace();
            return;
        }
    }

    public void onResume()
    {
        super.onResume();
        try
        {
            if (h != null)
            {
                h.onResume();
            }
            return;
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
            exception.printStackTrace();
            return;
        }
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

    static 
    {
        new ig();
    }
}
