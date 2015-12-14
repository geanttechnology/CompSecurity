// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import com.crashlytics.android.Crashlytics;
import com.fotoable.ad.FotoAdFactory;
import com.fotoable.fotoproedit.activity.crop.CropImageView;
import com.fotoable.fotoproedit.activity.crop.CropMaskView;
import com.fotoable.fotoproedit.activity.crop.TProEditCropScrollView;
import com.fotoable.fotoproedit.activity.crop.TProEditRotateBottomBar;
import com.fotoable.photocollage.view.ProEidtActionBarView;
import com.pipcamera.activity.FullscreenActivity;
import com.wantu.utility.ui.ProcessDialogFragment;
import ew;
import gm;
import go;
import kf;
import ma;
import ms;

public class ProEditCropActivity extends FullscreenActivity
    implements ma, ms
{

    private float A;
    private RelativeLayout B;
    private boolean C;
    CropImageView a;
    TProEditCropScrollView b;
    ProEidtActionBarView c;
    private String d;
    private ImageView e;
    private Bitmap f;
    private String g;
    private ProcessDialogFragment h;
    private FrameLayout i;
    private FrameLayout j;
    private FrameLayout k;
    private ImageView l;
    private ImageView m;
    private ImageView n;
    private TProEditRotateBottomBar o;
    private SeekBar p;
    private Matrix q;
    private Rect r;
    private FrameLayout s;
    private int t;
    private CropMaskView u;
    private boolean v;
    private float w;
    private float x;
    private float y;
    private float z;

    public ProEditCropActivity()
    {
        d = "ProEditCropActivity";
        t = 0;
        v = false;
        w = 1.0F;
        x = 0.0F;
        y = 1.0F;
        z = 0.0F;
        A = 0.0F;
        C = false;
    }

    static int a(ProEditCropActivity proeditcropactivity, int i1)
    {
        proeditcropactivity.t = i1;
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

    private Rect a(RectF rectf)
    {
        float f4 = getResources().getDisplayMetrics().widthPixels - ew.a(this, 6F);
        float f1;
        float f2;
        float f3;
        float f5;
        int i1;
        int j1;
        if (ew.n(this))
        {
            f1 = getResources().getDisplayMetrics().heightPixels - ew.a(this, 157F);
        } else
        {
            f1 = getResources().getDisplayMetrics().heightPixels - ew.a(this, 207F);
        }
        f5 = rectf.width() / rectf.height();
        rectf = getResources().getDrawable(0x7f02029d);
        if (f5 > f4 / f1)
        {
            f3 = f4 - (float)rectf.getIntrinsicWidth();
            f2 = (int)(f3 / f5);
        } else
        {
            f2 = f1 - (float)rectf.getIntrinsicHeight();
            f3 = (int)(f2 * f5);
        }
        i1 = (int)((f4 - f3) / 2.0F);
        j1 = (int)((f1 - f2) / 2.0F);
        return new Rect(i1, j1, (int)(f3 + (float)i1), (int)(f2 + (float)j1));
    }

    static CropMaskView a(ProEditCropActivity proeditcropactivity)
    {
        return proeditcropactivity.u;
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
            v = true;
        } else
        {
            v = false;
        }
        x = f1;
        f3 = getResources().getDisplayMetrics().widthPixels - ew.a(this, 6F);
        if (ew.n(this))
        {
            f2 = getResources().getDisplayMetrics().heightPixels - ew.a(this, 157F);
        } else
        {
            f2 = getResources().getDisplayMetrics().heightPixels - ew.a(this, 207F);
        }
        d1 = ((double)f1 * 3.1415926535897931D) / 180D;
        d4 = Math.abs((double)r.height() * Math.sin(d1));
        d5 = Math.abs((double)r.width() * Math.cos(d1));
        d2 = Math.abs((double)r.width() * Math.sin(d1));
        d3 = Math.abs((double)r.height() * Math.cos(d1));
        d4 += d5;
        d2 += d3;
        A = (int)(Math.abs(Math.cos(d1) * d2) + Math.abs(Math.sin(d1) * d4));
        d3 = Math.abs(Math.sin(d1) * d2);
        z = (int)(Math.abs(Math.cos(d1) * d4) + d3);
        w = (float)Math.max(d4 / (double)(float)f.getWidth(), d2 / (double)(float)f.getHeight());
        if (q == null)
        {
            q = new Matrix();
        } else
        {
            q.reset();
        }
        q.postScale(w, w);
        q.postRotate(f1, (w * (float)f.getWidth()) / 2.0F, (w * (float)f.getHeight()) / 2.0F);
        q.postTranslate(f3 / 2.0F - (w * (float)f.getWidth()) / 2.0F, (f2 - w * (float)f.getHeight()) / 2.0F);
        e.setImageMatrix(q);
    }

    private void a(ImageView imageview)
    {
        n.setSelected(false);
        l.setSelected(false);
        m.setSelected(false);
        m.clearColorFilter();
        l.clearColorFilter();
        n.clearColorFilter();
        b.setVisibility(4);
        o.setVisibility(4);
        s.setVisibility(4);
        if (imageview != null)
        {
            imageview.setColorFilter(Color.rgb(0, 122, 255), android.graphics.PorterDuff.Mode.MULTIPLY);
            imageview.setSelected(true);
            if (imageview == n)
            {
                s.setVisibility(0);
            }
            if (imageview == m)
            {
                o.setVisibility(0);
            }
            if (imageview == l)
            {
                b.setVisibility(0);
            }
        }
    }

    static void a(ProEditCropActivity proeditcropactivity, float f1)
    {
        proeditcropactivity.a(f1);
    }

    static void a(ProEditCropActivity proeditcropactivity, ImageView imageview)
    {
        proeditcropactivity.a(imageview);
    }

    static int b(ProEditCropActivity proeditcropactivity)
    {
        return proeditcropactivity.t;
    }

    static ImageView c(ProEditCropActivity proeditcropactivity)
    {
        return proeditcropactivity.l;
    }

    static ImageView d(ProEditCropActivity proeditcropactivity)
    {
        return proeditcropactivity.m;
    }

    static SeekBar e(ProEditCropActivity proeditcropactivity)
    {
        return proeditcropactivity.p;
    }

    static ImageView f(ProEditCropActivity proeditcropactivity)
    {
        return proeditcropactivity.n;
    }

    private void f()
    {
        RectF rectf = i();
        a.setCropContentRect(new RectF(rectf));
        a.setFloatRationWH(0.0F);
        b.initItem();
        r = a(rectf);
        u.setClearRect(r);
        y = (float)f.getWidth() / (float)r.width();
        a(0.0F);
    }

    private void g()
    {
        b = (TProEditCropScrollView)findViewById(0x7f0c0098);
        o = (TProEditRotateBottomBar)findViewById(0x7f0c0099);
        s = (FrameLayout)findViewById(0x7f0c009a);
        p = (SeekBar)findViewById(0x7f0c009b);
        o.setListner(this);
        b.setCallback(this);
        p.setMax(100);
        p.setProgress(50);
        p.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {

            final ProEditCropActivity a;

            public void onProgressChanged(SeekBar seekbar, int i1, boolean flag)
            {
                float f1 = (float)(i1 - 50) / 100F;
                ProEditCropActivity.a(a, (int)(f1 * 90F));
            }

            public void onStartTrackingTouch(SeekBar seekbar)
            {
                ProEditCropActivity.a(a).setVisibility(0);
            }

            public void onStopTrackingTouch(SeekBar seekbar)
            {
                ProEditCropActivity.a(a).setVisibility(4);
            }

            
            {
                a = ProEditCropActivity.this;
                super();
            }
        });
    }

    private void h()
    {
        i = (FrameLayout)findViewById(0x7f0c009c);
        j = (FrameLayout)findViewById(0x7f0c009e);
        k = (FrameLayout)findViewById(0x7f0c00a0);
        l = (ImageView)findViewById(0x7f0c009d);
        m = (ImageView)findViewById(0x7f0c009f);
        n = (ImageView)findViewById(0x7f0c00a1);
        a(l);
        i.setOnClickListener(new android.view.View.OnClickListener() {

            final ProEditCropActivity a;

            public void onClick(View view)
            {
                if (ProEditCropActivity.b(a) == 0)
                {
                    return;
                } else
                {
                    ProEditCropActivity.a(a, 0);
                    ProEditCropActivity.a(a, ProEditCropActivity.c(a));
                    a.a.setVisibility(0);
                    return;
                }
            }

            
            {
                a = ProEditCropActivity.this;
                super();
            }
        });
        j.setOnClickListener(new android.view.View.OnClickListener() {

            final ProEditCropActivity a;

            public void onClick(View view)
            {
                if (ProEditCropActivity.b(a) == 1)
                {
                    return;
                } else
                {
                    ProEditCropActivity.a(a, 1);
                    ProEditCropActivity.a(a, ProEditCropActivity.d(a));
                    a.a.setVisibility(4);
                    ProEditCropActivity.e(a).setProgress(50);
                    return;
                }
            }

            
            {
                a = ProEditCropActivity.this;
                super();
            }
        });
        k.setOnClickListener(new android.view.View.OnClickListener() {

            final ProEditCropActivity a;

            public void onClick(View view)
            {
                if (ProEditCropActivity.b(a) == 2)
                {
                    return;
                } else
                {
                    ProEditCropActivity.a(a, 2);
                    ProEditCropActivity.a(a, ProEditCropActivity.f(a));
                    a.a.setVisibility(4);
                    return;
                }
            }

            
            {
                a = ProEditCropActivity.this;
                super();
            }
        });
    }

    private RectF i()
    {
        float f3 = getResources().getDisplayMetrics().widthPixels - ew.a(this, 6F);
        float f1;
        float f2;
        float f4;
        float f5;
        if (ew.n(this))
        {
            f1 = getResources().getDisplayMetrics().heightPixels - ew.a(this, 157F);
        } else
        {
            f1 = getResources().getDisplayMetrics().heightPixels - ew.a(this, 207F);
        }
        f5 = f.getWidth();
        f4 = f.getHeight();
        f2 = f5 / f3;
        if (f5 / f4 < f3 / f1)
        {
            f2 = f4 / f1;
        }
        f5 /= f2;
        f2 = f4 / f2;
        f3 = (f3 - f5) / 2.0F;
        f1 = (f1 - f2) / 2.0F;
        return new RectF(f3, f1, f5 + f3, f2 + f1);
    }

    private Bitmap j()
    {
        int k1;
        int l1;
        int i2;
        int j2;
        k1 = 0;
        if (A <= 0.0F || z <= 0.0F)
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
            bitmap = Bitmap.createBitmap((int)(z * y), (int)(A * y), android.graphics.Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            Matrix matrix = new Matrix();
            float f1 = w * y;
            matrix.setScale(f1, f1);
            matrix.postRotate(x, ((float)f.getWidth() * f1) / 2.0F, ((float)f.getHeight() * f1) / 2.0F);
            matrix.postTranslate((float)(bitmap.getWidth() / 2) - ((float)f.getWidth() * f1) / 2.0F, (float)(bitmap.getHeight() / 2) - (f1 * (float)f.getHeight()) / 2.0F);
            canvas.drawBitmap(f, matrix, ((Paint) (obj)));
            obj = a.getCropRect();
            if (t == 2)
            {
                obj = r;
            }
            i1 = (int)(y * ((z - (float)r.width()) / 2.0F + (float)(((Rect) (obj)).left - r.left)));
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
        l1 = (int)(y * ((A - (float)r.height()) / 2.0F + (float)(((Rect) (obj)).top - r.top)));
        if (l1 >= 0)
        {
            k1 = l1;
        }
        l1 = (int)(y * (float)((Rect) (obj)).width());
        f2 = y;
        i2 = (int)((float)((Rect) (obj)).height() * f2);
        if (i1 + l1 <= bitmap.getWidth() && k1 + i2 <= bitmap.getHeight() && i2 > 0 && l1 > 0)
        {
            break MISSING_BLOCK_LABEL_378;
        }
        return f;
        obj = Bitmap.createBitmap(bitmap, i1, k1, l1, i2);
        Log.e(d, (new StringBuilder()).append("bitmap:").append(((Bitmap) (obj)).getWidth()).append(",").append(((Bitmap) (obj)).getHeight()).toString());
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

    public void a()
    {
        try
        {
            if (h == null)
            {
                h = ProcessDialogFragment.a(c());
                h.setCancelable(false);
                h.show(getSupportFragmentManager(), "process");
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
        g = s1;
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
        s1 = a(f, -90F);
        if (s1 != f)
        {
            e.setImageBitmap(s1);
            C = true;
            f = s1;
            f();
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (s1.compareTo("right") != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = a(f, 90F);
        if (s1 != f)
        {
            C = true;
            f = s1;
            e.setImageBitmap(s1);
            f();
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
        if (s1.compareTo("flip-h") != 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        s1 = a(f, 0);
        if (s1 != f)
        {
            C = true;
            f = s1;
            e.setImageBitmap(s1);
            return;
        }
        continue; /* Loop/switch isn't completed */
        if (s1.compareTo("flip-v") != 0) goto _L1; else goto _L5
_L5:
        s1 = a(f, 1);
        if (s1 != f)
        {
            C = true;
            f = s1;
            e.setImageBitmap(s1);
            return;
        }
        if (true) goto _L1; else goto _L6
_L6:
    }

    public void b()
    {
        try
        {
            if (h != null)
            {
                h.dismissAllowingStateLoss();
                a(getResources().getString(0x7f0601a4));
                h = null;
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
        return g;
    }

    public void d()
    {
        Bitmap bitmap;
        if (t == 1)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        bitmap = j();
_L1:
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_81;
        }
        try
        {
            kf.b("edit");
            a();
            gm.c().a(new go() {

                final ProEditCropActivity a;

                public void a()
                {
                    a.setResult(-1);
                    a.b();
                    a.finish();
                    a.overridePendingTransition(0, 0x7f040027);
                }

            
            {
                a = ProEditCropActivity.this;
                super();
            }
            }, bitmap, this);
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        break MISSING_BLOCK_LABEL_77;
label0:
        {
            if (!C)
            {
                break label0;
            }
            bitmap = f;
        }
          goto _L1
        finish();
        overridePendingTransition(0, 0x7f040027);
        return;
        b();
    }

    public void e()
    {
        setResult(0);
        finish();
        overridePendingTransition(0, 0x7f040027);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(0x7f030023);
        B = (RelativeLayout)findViewById(0x7f0c0055);
        c = (ProEidtActionBarView)findViewById(0x7f0c0088);
        bundle = (FrameLayout)findViewById(0x7f0c0096);
        int j1 = getResources().getDisplayMetrics().widthPixels;
        int k1 = ew.a(this, 6F);
        android.widget.FrameLayout.LayoutParams layoutparams;
        int i1;
        if (ew.n(this))
        {
            i1 = getResources().getDisplayMetrics().heightPixels - ew.a(this, 157F);
            Log.e("proeditcropActivity", "adbanner height 157");
        } else
        {
            i1 = getResources().getDisplayMetrics().heightPixels - ew.a(this, 207F);
            Log.e("proeditcropActivity", "adbanner height 207");
        }
        layoutparams = new android.widget.FrameLayout.LayoutParams(j1 - k1, i1, 17);
        e = new ImageView(this);
        bundle.addView(e, layoutparams);
        a = new CropImageView(this);
        bundle.addView(a, layoutparams);
        u = new CropMaskView(this, null);
        bundle.addView(u, layoutparams);
        bundle = getString(0x7f060296);
        c.setActionBarTitle(bundle);
        c.setOnAcceptListener(this);
        f = gm.c().k();
        if (f == null)
        {
            b();
            finish();
            return;
        } else
        {
            e.setImageBitmap(f);
            e.setScaleType(android.widget.ImageView.ScaleType.MATRIX);
            u.setVisibility(4);
            g();
            a(getResources().getString(0x7f0601a4));
            h();
            f();
            return;
        }
    }

    protected void onDestroy()
    {
        super.onDestroy();
        e.setImageBitmap(null);
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
        Log.v(d, (new StringBuilder()).append(d).append(" onResume").toString());
        if (!ew.n(this))
        {
            B.setVisibility(0);
            FotoAdFactory.createAdBanner(this, B);
            return;
        } else
        {
            B.setVisibility(8);
            return;
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
