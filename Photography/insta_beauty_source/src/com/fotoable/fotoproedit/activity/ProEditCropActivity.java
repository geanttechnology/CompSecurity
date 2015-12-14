// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity;

import aeu;
import aex;
import aez;
import afe;
import aff;
import afg;
import afh;
import afi;
import afj;
import afk;
import afl;
import amo;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import apq;
import azn;
import bjd;
import bje;
import com.crashlytics.android.Crashlytics;
import com.flurry.android.FlurryAgent;
import com.fotoable.ad.FotoAdFactory;
import com.fotoable.beautyui.other.TProEditCropScrollView;
import com.fotoable.fotobeauty.FullscreenActivity;
import com.fotoable.fotoproedit.activity.crop.CropImageView;
import com.fotoable.fotoproedit.activity.crop.CropMaskView;
import com.fotoable.fotoproedit.view.ui.ProEidtActionBarView;
import com.fotoable.fotoproedit.view.ui.scroll.TProEditRotateBottomBar;
import com.wantu.utility.ui.ProcessDialogFragment;
import java.util.ArrayList;
import xn;
import yp;

public class ProEditCropActivity extends FullscreenActivity
    implements amo, xn
{

    private int A;
    private CropMaskView B;
    private boolean C;
    private float D;
    private float E;
    private float F;
    private float G;
    private float H;
    private boolean I;
    public CropImageView a;
    public TProEditCropScrollView b;
    ProEidtActionBarView c;
    RelativeLayout d;
    public FrameLayout e;
    RelativeLayout f;
    bjd g;
    bje h;
    boolean i;
    private String j;
    private boolean k;
    private ImageView l;
    private Bitmap m;
    private String n;
    private ProcessDialogFragment o;
    private FrameLayout p;
    private FrameLayout q;
    private FrameLayout r;
    private ImageView s;
    private ImageView t;
    private ImageView u;
    private TProEditRotateBottomBar v;
    private SeekBar w;
    private Matrix x;
    private Rect y;
    private FrameLayout z;

    public ProEditCropActivity()
    {
        j = "ProEditCropActivity";
        k = false;
        A = 0;
        C = false;
        D = 1.0F;
        E = 0.0F;
        F = 1.0F;
        G = 0.0F;
        H = 0.0F;
        h = new afe(this);
        i = true;
        I = false;
    }

    public static int a(ProEditCropActivity proeditcropactivity, int i1)
    {
        proeditcropactivity.A = i1;
        return i1;
    }

    private Bitmap a(Bitmap bitmap, float f1)
    {
        Matrix matrix = new Matrix();
        int i1 = bitmap.getHeight();
        int j1 = bitmap.getWidth();
        matrix.postRotate(f1);
        return Bitmap.createBitmap(bitmap, 0, 0, j1, i1, matrix, true);
    }

    private Bitmap a(Bitmap bitmap, int i1)
    {
        Object obj = null;
        i1;
        JVM INSTR tableswitch 0 1: default 28
    //                   0 71
    //                   1 121;
           goto _L1 _L2 _L3
_L1:
        float af[] = null;
_L5:
        if (af != null)
        {
            obj = new Matrix();
            ((Matrix) (obj)).setValues(af);
            obj = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), ((Matrix) (obj)), true);
        }
        return ((Bitmap) (obj));
_L2:
        af = new float[9];
        af;
        af[0] = -1F;
        af[1] = 0.0F;
        af[2] = 0.0F;
        af[3] = 0.0F;
        af[4] = 1.0F;
        af[5] = 0.0F;
        af[6] = 0.0F;
        af[7] = 0.0F;
        af[8] = 1.0F;
        continue; /* Loop/switch isn't completed */
_L3:
        af = new float[9];
        af;
        af[0] = 1.0F;
        af[1] = 0.0F;
        af[2] = 0.0F;
        af[3] = 0.0F;
        af[4] = -1F;
        af[5] = 0.0F;
        af[6] = 0.0F;
        af[7] = 0.0F;
        af[8] = 1.0F;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static Bitmap a(ProEditCropActivity proeditcropactivity)
    {
        return proeditcropactivity.m;
    }

    public static Bitmap a(ProEditCropActivity proeditcropactivity, Bitmap bitmap)
    {
        proeditcropactivity.m = bitmap;
        return bitmap;
    }

    private Rect a(RectF rectf)
    {
        float f3 = getResources().getDisplayMetrics().widthPixels - yp.a(this, 6F);
        float f4 = getResources().getDisplayMetrics().heightPixels - yp.a(this, 157F);
        float f5 = rectf.width() / rectf.height();
        rectf = getResources().getDrawable(0x7f0201d9);
        float f1;
        float f2;
        int i1;
        int j1;
        if (f5 > f3 / f4)
        {
            f2 = f3 - (float)rectf.getIntrinsicWidth();
            f1 = (int)(f2 / f5);
        } else
        {
            f1 = f4 - (float)rectf.getIntrinsicHeight();
            f2 = (int)(f1 * f5);
        }
        i1 = (int)((f3 - f2) / 2.0F);
        j1 = (int)((f4 - f1) / 2.0F);
        return new Rect(i1, j1, (int)(f2 + (float)i1), (int)(f1 + (float)j1));
    }

    private void a(float f1)
    {
        double d1;
        double d2;
        double d3;
        double d4;
        double d5;
        float f2;
        float f3;
        if (f1 != 0.0F)
        {
            C = true;
        } else
        {
            C = false;
        }
        E = f1;
        f2 = getResources().getDisplayMetrics().widthPixels - yp.a(this, 6F);
        f3 = getResources().getDisplayMetrics().heightPixels - yp.a(this, 157F);
        d1 = ((double)f1 * 3.1415926535897931D) / 180D;
        d4 = Math.abs((double)y.height() * Math.sin(d1));
        d5 = Math.abs((double)y.width() * Math.cos(d1));
        d2 = Math.abs((double)y.width() * Math.sin(d1));
        d3 = Math.abs((double)y.height() * Math.cos(d1));
        d4 += d5;
        d2 += d3;
        H = (int)(Math.abs(Math.cos(d1) * d2) + Math.abs(Math.sin(d1) * d4));
        d3 = Math.abs(Math.sin(d1) * d2);
        G = (int)(Math.abs(Math.cos(d1) * d4) + d3);
        D = (float)Math.max(d4 / (double)(float)m.getWidth(), d2 / (double)(float)m.getHeight());
        if (x == null)
        {
            x = new Matrix();
        } else
        {
            x.reset();
        }
        x.postScale(D, D);
        x.postRotate(f1, (D * (float)m.getWidth()) / 2.0F, (D * (float)m.getHeight()) / 2.0F);
        x.postTranslate(f2 / 2.0F - (D * (float)m.getWidth()) / 2.0F, (f3 - D * (float)m.getHeight()) / 2.0F);
        l.setImageMatrix(x);
    }

    private void a(Bitmap bitmap)
    {
        if (bitmap == null || bitmap.isRecycled())
        {
            return;
        } else
        {
            a();
            (new Thread(new aez(this, bitmap))).start();
            return;
        }
    }

    private void a(ImageView imageview, boolean flag)
    {
        u.setSelected(false);
        s.setSelected(false);
        t.setSelected(false);
        t.clearColorFilter();
        s.clearColorFilter();
        u.clearColorFilter();
        android.view.animation.Animation animation = AnimationUtils.loadAnimation(this, 0x7f04002c);
        android.view.animation.Animation animation1 = AnimationUtils.loadAnimation(this, 0x7f04002b);
        if (imageview != null && flag)
        {
            imageview.setColorFilter(Color.rgb(234, 107, 136), android.graphics.PorterDuff.Mode.MULTIPLY);
            imageview.setSelected(true);
            if (imageview == u)
            {
                e.startAnimation(animation1);
                (new Handler()).postDelayed(new afj(this, animation), 300L);
            }
            if (imageview == t)
            {
                e.startAnimation(animation1);
                (new Handler()).postDelayed(new afk(this, animation), 300L);
            }
            if (imageview == s)
            {
                e.startAnimation(animation1);
                (new Handler()).postDelayed(new afl(this, animation), 300L);
            }
        } else
        {
            imageview.setColorFilter(Color.rgb(234, 107, 136), android.graphics.PorterDuff.Mode.MULTIPLY);
            imageview.setSelected(true);
            if (imageview == u)
            {
                b.setVisibility(4);
                v.setVisibility(4);
                z.setVisibility(0);
            }
            if (imageview == t)
            {
                b.setVisibility(4);
                z.setVisibility(4);
                v.setVisibility(0);
            }
            if (imageview == s)
            {
                z.setVisibility(4);
                v.setVisibility(4);
                b.setVisibility(0);
                return;
            }
        }
    }

    public static void a(ProEditCropActivity proeditcropactivity, float f1)
    {
        proeditcropactivity.a(f1);
    }

    public static void a(ProEditCropActivity proeditcropactivity, ImageView imageview, boolean flag)
    {
        proeditcropactivity.a(imageview, flag);
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

    public static void b(ProEditCropActivity proeditcropactivity)
    {
        proeditcropactivity.f();
    }

    public static void b(ProEditCropActivity proeditcropactivity, Bitmap bitmap)
    {
        proeditcropactivity.a(bitmap);
    }

    public static CropMaskView c(ProEditCropActivity proeditcropactivity)
    {
        return proeditcropactivity.B;
    }

    public static int d(ProEditCropActivity proeditcropactivity)
    {
        return proeditcropactivity.A;
    }

    public static ImageView e(ProEditCropActivity proeditcropactivity)
    {
        return proeditcropactivity.s;
    }

    public static ImageView f(ProEditCropActivity proeditcropactivity)
    {
        return proeditcropactivity.t;
    }

    private void f()
    {
        l.setImageBitmap(m);
        l.setScaleType(android.widget.ImageView.ScaleType.MATRIX);
        g();
    }

    public static SeekBar g(ProEditCropActivity proeditcropactivity)
    {
        return proeditcropactivity.w;
    }

    private void g()
    {
        RectF rectf = j();
        a.setCropContentRect(new RectF(rectf));
        a.setFloatRationWH(0.0F);
        b.initItem();
        y = a(rectf);
        B.setClearRect(y);
        F = (float)m.getWidth() / (float)y.width();
        a(0.0F);
        if (i)
        {
            i = false;
            android.view.animation.Animation animation = AnimationUtils.loadAnimation(this, 0x7f040030);
            d.startAnimation(animation);
        }
    }

    public static ImageView h(ProEditCropActivity proeditcropactivity)
    {
        return proeditcropactivity.u;
    }

    private void h()
    {
        b = (TProEditCropScrollView)findViewById(0x7f0d0120);
        v = (TProEditRotateBottomBar)findViewById(0x7f0d0121);
        z = (FrameLayout)findViewById(0x7f0d0122);
        w = (SeekBar)findViewById(0x7f0d0123);
        v.setListner(this);
        b.setCallback(this);
        w.setMax(100);
        w.setProgress(50);
        w.setOnSeekBarChangeListener(new aff(this));
    }

    public static TProEditRotateBottomBar i(ProEditCropActivity proeditcropactivity)
    {
        return proeditcropactivity.v;
    }

    private void i()
    {
        p = (FrameLayout)findViewById(0x7f0d0125);
        q = (FrameLayout)findViewById(0x7f0d0127);
        r = (FrameLayout)findViewById(0x7f0d0129);
        s = (ImageView)findViewById(0x7f0d0126);
        t = (ImageView)findViewById(0x7f0d0128);
        u = (ImageView)findViewById(0x7f0d012a);
        a(s, false);
        p.setOnClickListener(new afg(this));
        q.setOnClickListener(new afh(this));
        r.setOnClickListener(new afi(this));
    }

    private RectF j()
    {
        float f3 = getResources().getDisplayMetrics().widthPixels - yp.a(this, 6F);
        float f2 = getResources().getDisplayMetrics().heightPixels - yp.a(this, 157F);
        float f5 = m.getWidth();
        float f4 = m.getHeight();
        float f1 = f5 / f3;
        if (f5 / f4 < f3 / f2)
        {
            f1 = f4 / f2;
        }
        f5 /= f1;
        f1 = f4 / f1;
        f3 = (f3 - f5) / 2.0F;
        f2 = (f2 - f1) / 2.0F;
        return new RectF(f3, f2, f5 + f3, f1 + f2);
    }

    public static FrameLayout j(ProEditCropActivity proeditcropactivity)
    {
        return proeditcropactivity.z;
    }

    private Bitmap k()
    {
        int k1;
        int l1;
        int i2;
        int j2;
        k1 = 0;
        if (H <= 0.0F || G <= 0.0F)
        {
            return null;
        }
        float f2;
        Object obj;
        Bitmap bitmap;
        int i1;
        try
        {
            obj = new Paint();
            ((Paint) (obj)).setAntiAlias(true);
            ((Paint) (obj)).setColor(-1);
            ((Paint) (obj)).setStrokeWidth(4F);
            bitmap = Bitmap.createBitmap((int)(G * F), (int)(H * F), android.graphics.Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            Matrix matrix = new Matrix();
            float f1 = D * F;
            matrix.setScale(f1, f1);
            matrix.postRotate(E, ((float)m.getWidth() * f1) / 2.0F, ((float)m.getHeight() * f1) / 2.0F);
            matrix.postTranslate((float)(bitmap.getWidth() / 2) - ((float)m.getWidth() * f1) / 2.0F, (float)(bitmap.getHeight() / 2) - (f1 * (float)m.getHeight()) / 2.0F);
            canvas.drawBitmap(m, matrix, ((Paint) (obj)));
            obj = a.getCropRect();
            if (A == 2)
            {
                obj = y;
            }
            i1 = (int)(F * ((G - (float)y.width()) / 2.0F + (float)(((Rect) (obj)).left - y.left)));
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            Crashlytics.logException(exception);
            return null;
        }
        if (i1 < 0)
        {
            i1 = 0;
        }
        l1 = (int)(F * ((H - (float)y.height()) / 2.0F + (float)(((Rect) (obj)).top - y.top)));
        if (l1 >= 0)
        {
            k1 = l1;
        }
        l1 = (int)(F * (float)((Rect) (obj)).width());
        f2 = F;
        i2 = (int)((float)((Rect) (obj)).height() * f2);
        if (i1 + l1 <= bitmap.getWidth() && k1 + i2 <= bitmap.getHeight() && i2 > 0 && l1 > 0)
        {
            break MISSING_BLOCK_LABEL_378;
        }
        return m;
        obj = Bitmap.createBitmap(bitmap, i1, k1, l1, i2);
        Log.e(j, (new StringBuilder()).append("bitmap:").append(((Bitmap) (obj)).getWidth()).append(",").append(((Bitmap) (obj)).getHeight()).toString());
        k1 = ((Bitmap) (obj)).getWidth();
        j2 = ((Bitmap) (obj)).getHeight();
        if (k1 % 2 != 0) goto _L2; else goto _L1
_L1:
        l1 = j2;
        i2 = k1;
        if (j2 % 2 == 0) goto _L3; else goto _L2
_L3:
        obj = Bitmap.createScaledBitmap(((Bitmap) (obj)), i2, l1, true);
        return ((Bitmap) (obj));
_L2:
        int j1 = k1;
        if (k1 % 2 != 0)
        {
            j1 = k1 - 1;
        }
        l1 = j2;
        i2 = j1;
        if (j2 % 2 != 0)
        {
            l1 = j2 - 1;
            i2 = j1;
        }
        if (true) goto _L3; else goto _L4
_L4:
    }

    public static Bitmap k(ProEditCropActivity proeditcropactivity)
    {
        return proeditcropactivity.k();
    }

    public void a()
    {
        try
        {
            if (o == null)
            {
                o = ProcessDialogFragment.a(c());
                o.setCancelable(false);
                o.show(getSupportFragmentManager(), "process");
            }
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void a(String s1)
    {
        n = s1;
    }

    public void a(String s1, Object obj)
    {
        if (s1.compareTo("original") != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (s1.compareTo("free") == 0)
        {
            a.setFloatRationWH(0.0F);
            return;
        }
        if (s1.compareTo("1-1") == 0)
        {
            a.setFloatRationWH(1.0F);
            return;
        }
        if (s1.compareTo("goldenH") == 0)
        {
            a.setFloatRationWH(1.618F);
            return;
        }
        if (s1.compareTo("goldenV") == 0)
        {
            a.setFloatRationWH(0.618F);
            return;
        }
        if (s1.compareTo("2-3") == 0)
        {
            a.setFloatRationWH(0.6666667F);
            return;
        }
        if (s1.compareTo("3-4") == 0)
        {
            a.setFloatRationWH(0.75F);
            return;
        }
        if (s1.compareTo("9-16") == 0)
        {
            a.setFloatRationWH(0.5625F);
            return;
        }
        if (s1.compareTo("3-2") == 0)
        {
            a.setFloatRationWH(1.5F);
            return;
        }
        if (s1.compareTo("4-3") == 0)
        {
            a.setFloatRationWH(1.333333F);
            return;
        }
        if (s1.compareTo("16-9") == 0)
        {
            a.setFloatRationWH(1.777778F);
            return;
        }
        if (s1.compareTo("left") != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = a(m, -90F);
        if (s1 != m)
        {
            l.setImageBitmap(s1);
            I = true;
            m = s1;
            g();
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (s1.compareTo("right") != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = a(m, 90F);
        if (s1 != m)
        {
            I = true;
            m = s1;
            l.setImageBitmap(s1);
            g();
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
        if (s1.compareTo("flip-h") != 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        s1 = a(m, 0);
        if (s1 != m)
        {
            I = true;
            m = s1;
            l.setImageBitmap(s1);
            return;
        }
        continue; /* Loop/switch isn't completed */
        if (s1.compareTo("flip-v") != 0) goto _L1; else goto _L5
_L5:
        s1 = a(m, 1);
        if (s1 != m)
        {
            I = true;
            m = s1;
            l.setImageBitmap(s1);
            return;
        }
        if (true) goto _L1; else goto _L6
_L6:
    }

    public void b()
    {
        try
        {
            if (o != null)
            {
                o.dismissAllowingStateLoss();
                a(getResources().getString(0x7f0601c6));
                o = null;
            }
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public String c()
    {
        return n;
    }

    public void d()
    {
        apq.a("Crop");
        if (A != 1 || m == null || m.isRecycled())
        {
            break MISSING_BLOCK_LABEL_70;
        }
        if (I)
        {
            a(m);
            return;
        }
        try
        {
            finish();
            overridePendingTransition(0, 0x7f04001e);
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        b();
        return;
        a();
        (new Thread(new aex(this))).start();
        return;
    }

    public void e()
    {
        setResult(0);
        finish();
        overridePendingTransition(0, 0x7f04001e);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(0x7f030034);
        f = (RelativeLayout)findViewById(0x7f0d00b0);
        if (!azn.a(this))
        {
            f.setVisibility(8);
        }
        d = (RelativeLayout)findViewById(0x7f0d011e);
        d.setVisibility(0);
        e = (FrameLayout)findViewById(0x7f0d011f);
        c = (ProEidtActionBarView)findViewById(0x7f0d00ba);
        bundle = (FrameLayout)findViewById(0x7f0d00bb);
        android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(getResources().getDisplayMetrics().widthPixels - yp.a(this, 6F), getResources().getDisplayMetrics().heightPixels - yp.a(this, 157F), 17);
        l = new ImageView(this);
        bundle.addView(l, layoutparams);
        a = new CropImageView(this);
        bundle.addView(a, layoutparams);
        B = new CropMaskView(this, null);
        bundle.addView(B, layoutparams);
        getString(0x7f0602d0);
        c.setActionBarTitle("");
        c.setOnAcceptListener(this);
        B.setVisibility(4);
        h();
        a(getResources().getString(0x7f0601c6));
        i();
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
        a();
        if (!k)
        {
            (new Thread(new aeu(this))).start();
        }
    }

    protected void onDestroy()
    {
        super.onDestroy();
        l.setImageBitmap(null);
        if (g != null)
        {
            g.a(null);
        }
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (i1 == 4 && keyevent.getRepeatCount() == 0)
        {
            e();
        }
        return super.onKeyDown(i1, keyevent);
    }

    protected void onResume()
    {
        super.onResume();
        FlurryAgent.onPageView();
        if (azn.a(this))
        {
            FotoAdFactory.createAdBanner(this, f);
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
}
