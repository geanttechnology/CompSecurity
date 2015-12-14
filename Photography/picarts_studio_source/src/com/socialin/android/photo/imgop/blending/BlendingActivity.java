// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.imgop.blending;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.picsart.studio.PicsartContext;
import com.socialin.android.activity.AdBaseActivity;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.d;
import com.socialin.android.dialog.g;
import com.socialin.android.photo.imgop.ImageOp;
import com.socialin.android.photo.imgop.ImageOpCommon;
import com.socialin.android.util.ScaleRotateGestureDetector;
import com.socialin.android.util.Utils;
import com.socialin.android.util.l;
import com.socialin.android.util.w;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.photo.imgop.blending:
//            a, b

public class BlendingActivity extends AdBaseActivity
    implements android.view.View.OnClickListener
{

    private static final String f = com/socialin/android/photo/imgop/blending/BlendingActivity.getSimpleName();
    private android.widget.SeekBar.OnSeekBarChangeListener A;
    int a;
    Bitmap b;
    Bitmap c;
    public b d;
    final ExecutorService e = Executors.newSingleThreadExecutor();
    private String g;
    private String h;
    private String i;
    private Bitmap j;
    private Bitmap k;
    private ByteBuffer l;
    private ByteBuffer m;
    private ByteBuffer n;
    private a o;
    private DisplayMetrics p;
    private g q;
    private HashMap r;
    private HashMap s;
    private HashMap t;
    private boolean u;
    private RectF v;
    private RectF w;
    private int x;
    private int y;
    private Runnable z;

    public BlendingActivity()
    {
        a = 10;
        k = null;
        c = null;
        s = null;
        u = false;
        v = null;
        x = 0;
        y = 0;
        z = new Runnable() {

            private BlendingActivity a;

            public final void run()
            {
                BlendingActivity.a(a).a(null);
                BlendingActivity.a(a).b(BlendingActivity.b(a));
            }

            
            {
                a = BlendingActivity.this;
                super();
            }
        };
        A = new android.widget.SeekBar.OnSeekBarChangeListener() {

            private BlendingActivity a;

            public final void onProgressChanged(SeekBar seekbar, int i1, boolean flag)
            {
                BlendingActivity.a(a, i1 + 1);
                ((TextView)a.findViewById(0x7f1001b9)).setText((new StringBuilder()).append(a.getString(0x7f080630)).append(": ").append(com.socialin.android.photo.imgop.blending.BlendingActivity.d(a)).toString());
            }

            public final void onStartTrackingTouch(SeekBar seekbar)
            {
            }

            public final void onStopTrackingTouch(SeekBar seekbar)
            {
                a.b();
                a.a();
                BlendingActivity.a(a).a(false);
            }

            
            {
                a = BlendingActivity.this;
                super();
            }
        };
    }

    static int a(BlendingActivity blendingactivity, int i1)
    {
        blendingactivity.a = i1;
        return i1;
    }

    static a a(BlendingActivity blendingactivity)
    {
        return blendingactivity.o;
    }

    private void a(Bundle bundle)
    {
        Log.i("ex", "initImageData Invoked");
        if (bundle.containsKey("extra.bg.image.bufferdata"))
        {
            r = (HashMap)bundle.get("extra.bg.image.bufferdata");
        }
        if (bundle.containsKey("extra.bg.image.path"))
        {
            g = bundle.getString("extra.bg.image.path");
        }
        y = bundle.getInt("originalImageDegree", 0);
        if (bundle.containsKey("extra.blending.image.bufferdata"))
        {
            s = (HashMap)bundle.get("extra.blending.image.bufferdata");
        }
        if (bundle.containsKey("extra.blending.image.path"))
        {
            h = bundle.getString("extra.blending.image.path");
        }
        if (bundle.containsKey("extra.blendingmask.image.bufferdata"))
        {
            t = (HashMap)bundle.getSerializable("extra.blendingmask.image.bufferdata");
            x = bundle.getInt("blendingDegree", 0);
        }
        if (bundle.containsKey("boundingRect"))
        {
            v = (RectF)bundle.getParcelable("boundingRect");
        } else
        {
            v = null;
        }
        if (bundle.containsKey("blendImageParamsChanged"))
        {
            u = bundle.getBoolean("blendImageParamsChanged");
        }
        if (bundle.containsKey("JSON"))
        {
            i = bundle.getString("JSON");
        }
    }

    private static void a(ByteBuffer bytebuffer)
    {
        if (bytebuffer != null)
        {
            ImageOpCommon.freeNativeBuffer(bytebuffer);
        }
    }

    private void a(boolean flag)
    {
        if (c == null)
        {
            if (flag)
            {
                b();
                a();
                o.a(true);
                return;
            } else
            {
                Utils.c(this, "Blend failed");
                return;
            }
        } else
        {
            setResult(-1);
            finish();
            return;
        }
    }

    private static Bitmap b(Bitmap bitmap)
    {
        Bitmap bitmap1 = bitmap;
        if (bitmap.getWidth() * bitmap.getHeight() * 4 != bitmap.getRowBytes() * bitmap.getHeight())
        {
            bitmap1 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
            Paint paint = new Paint();
            paint.setFilterBitmap(true);
            (new Canvas(bitmap1)).drawBitmap(bitmap, 0.0F, 0.0F, paint);
            bitmap.recycle();
        }
        return bitmap1;
    }

    static Bitmap b(BlendingActivity blendingactivity)
    {
        return blendingactivity.c;
    }

    static void c(BlendingActivity blendingactivity)
    {
        blendingactivity.a(false);
    }

    static int d(BlendingActivity blendingactivity)
    {
        return blendingactivity.a;
    }

    private void d()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = com.socialin.android.util.w.a(t, PicsartContext.a(), 0);
        if (k != null)
        {
            k.recycle();
            k = null;
        }
        if (l != null)
        {
            a(l);
        }
        k = com.socialin.android.util.w.c(((Bitmap) (obj)));
        ((Bitmap) (obj)).recycle();
        l = ImageOp.a(k.getWidth() * k.getHeight());
        k.copyPixelsToBuffer(l);
        obj = d;
        ByteBuffer bytebuffer = l;
        k.getWidth();
        k.getHeight();
        obj.b = bytebuffer;
        if (o.b == null)
        {
            o.a(b);
            o.b(j);
        }
        o.c(k);
        o.invalidate();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void e()
    {
        if (s != null)
        {
            b = com.socialin.android.util.w.a(s, PicsartContext.a(), x);
            b = b(b);
        } else
        {
            try
            {
                b = com.socialin.android.util.w.b(h, PicsartContext.a(), x);
                b = b(b);
            }
            catch (Exception exception)
            {
                com.socialin.android.d.b(f, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
                });
            }
        }
        if (v != null)
        {
            Bitmap bitmap = b;
            RectF rectf = v;
            Bitmap bitmap1 = Bitmap.createBitmap((int)rectf.width(), (int)rectf.height(), android.graphics.Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap1);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setFilterBitmap(true);
            canvas.drawBitmap(bitmap, -rectf.left, -rectf.top, paint);
            b = bitmap1;
        }
        Log.e("ex", (new StringBuilder("blending w = ")).append(b.getWidth()).toString());
        Log.e("ex", (new StringBuilder("blending h = ")).append(b.getHeight()).toString());
        n = com.socialin.android.util.w.b(b);
        d.a(n, b.getWidth(), b.getHeight());
        o.a(b);
        o.invalidate();
    }

    final void a()
    {
        o.b(j);
        o.a(b);
        if (c != null)
        {
            c.recycle();
            c = null;
        }
    }

    public final void a(Bitmap bitmap)
    {
        this;
        JVM INSTR monitorenter ;
        a(n);
        a(l);
        n = com.socialin.android.util.w.b(bitmap);
        d.a(n, bitmap.getWidth(), bitmap.getHeight());
        bitmap = o;
        bitmap = com.socialin.android.util.w.a(k, ((a) (bitmap)).e, (int)((a) (bitmap)).f.width(), (int)((a) (bitmap)).f.height(), android.graphics.Bitmap.Config.ALPHA_8);
        l = ImageOp.a(bitmap.getHeight() * bitmap.getWidth());
        l.position(0);
        bitmap.copyPixelsToBuffer(l);
        b b1 = d;
        ByteBuffer bytebuffer = l;
        bitmap.getWidth();
        bitmap.getHeight();
        b1.b = bytebuffer;
        bitmap.recycle();
        this;
        JVM INSTR monitorexit ;
        return;
        bitmap;
        throw bitmap;
    }

    public final void a(ByteBuffer bytebuffer, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        c = com.socialin.android.util.w.a(j.getWidth(), j.getHeight(), bytebuffer);
        a(bytebuffer);
        q.hide();
        o.post(z);
        myobfuscated.f.m.b(this, q);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        runOnUiThread(new Runnable() {

            private BlendingActivity a;

            public final void run()
            {
                BlendingActivity.c(a);
            }

            
            {
                a = BlendingActivity.this;
                super();
            }
        });
        this;
        JVM INSTR monitorexit ;
        return;
        bytebuffer;
        throw bytebuffer;
    }

    public final void b()
    {
        myobfuscated.f.m.a(this, q, true);
    }

    public final void c()
    {
        q.hide();
        myobfuscated.f.m.b(this, q);
    }

    protected ViewGroup getAdLayout()
    {
        return (RelativeLayout)findViewById(0x7f100128);
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        Log.i("ex", "onActivityResult Invoked");
        if (j1 != -1) goto _L2; else goto _L1
_L1:
        i1;
        JVM INSTR tableswitch 70 70: default 32
    //                   70 33;
           goto _L3 _L4
_L3:
        return;
_L4:
        boolean flag;
        w = v;
        v = null;
        flag = u;
        if (u)
        {
            x = 0;
            s = null;
            h = null;
            i = null;
            e();
            if (k != null)
            {
                k.recycle();
                k = null;
            }
            if (l != null)
            {
                a(l);
            }
            k = Bitmap.createBitmap(b.getWidth(), b.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
            k.eraseColor(-1);
            Object obj = com.socialin.android.util.w.c(k);
            k.recycle();
            k = null;
            k = ((Bitmap) (obj));
            l = ImageOp.a(k.getWidth() * k.getHeight());
            k.copyPixelsToBuffer(l);
            obj = d;
            ByteBuffer bytebuffer = l;
            k.getWidth();
            k.getHeight();
            obj.b = bytebuffer;
            if (o.b == null)
            {
                o.a(b);
                o.b(j);
            }
            o.c(k);
            o.invalidate();
            u = false;
        }
        x = intent.getIntExtra("degree", 0);
        if (!intent.hasExtra("bufferData")) goto _L6; else goto _L5
_L5:
        t = (HashMap)intent.getExtras().getSerializable("bufferData");
        if (intent.hasExtra("boundingRect"))
        {
            o.a(null);
            b.recycle();
            v = (RectF)intent.getExtras().getParcelable("boundingRect");
        }
        e();
        a();
        d();
        if (intent.hasExtra("JSON"))
        {
            i = intent.getExtras().getString("JSON");
        }
        if (flag) goto _L8; else goto _L7
_L7:
        float f1;
        float f2;
        float f3;
        RectF rectf;
        RectF rectf1;
        intent = o;
        rectf = w;
        rectf1 = v;
        intent.a(new Matrix());
        f1 = rectf1.left - rectf.left;
        f2 = rectf1.top - rectf.top;
        f3 = com.socialin.android.util.l.b(((a) (intent)).d);
        if (f3 <= ((a) (intent)).i && f3 >= ((a) (intent)).h) goto _L10; else goto _L9
_L9:
        flag = false;
_L14:
        o.g = flag;
        intent = o;
        i1 = o.getWidth();
        j1 = o.getHeight();
        o.getWidth();
        o.getHeight();
        intent.a(i1, j1);
_L15:
        o.a(false);
        return;
_L6:
        throw new Error("WT bufferData onActivityResult was null");
_L10:
        if (f1 != 0.0F || f2 != 0.0F || rectf1.width() - rectf.width() != 0.0F || rectf1.height() - rectf.height() != 0.0F)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        ((a) (intent)).d.preTranslate(f1, f2);
        if (i1 == 0) goto _L12; else goto _L11
_L11:
        rectf = new RectF(0.0F, 0.0F, ((a) (intent)).a.getWidth(), ((a) (intent)).a.getHeight());
        f1 = ((a) (intent)).b.getWidth();
        f2 = ((a) (intent)).b.getHeight();
        rectf1 = new RectF(f1 / 4F, f2 / 4F, (f1 * 3F) / 4F, (f2 * 3F) / 4F);
        ((a) (intent)).d.mapRect(rectf1);
        if (RectF.intersects(rectf1, rectf)) goto _L12; else goto _L13
_L13:
        flag = false;
          goto _L14
_L12:
        ((a) (intent)).j.a(((a) (intent)).d);
        flag = true;
          goto _L14
_L8:
        o.g = false;
        intent = o;
        i1 = o.getWidth();
        j1 = o.getHeight();
        o.getWidth();
        o.getHeight();
        intent.a(i1, j1);
          goto _L15
_L2:
        if (j1 == 0)
        {
            AnalyticUtils.getInstance(this).trackLocalAction("onActivityResult() was cancelled");
            u = false;
            return;
        }
        if (true) goto _L3; else goto _L16
_L16:
    }

    public void onClick(View view)
    {
        if (view.getId() == 0x7f1001b6)
        {
            a(true);
        } else
        if (view.getId() != 0x7f1001b7 && view.getId() == 0x7f1001b5)
        {
            setResult(0);
            finish();
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        d = new b(this);
        o = new a(this);
        if (bundle != null)
        {
            a(bundle);
        }
        a(getIntent().getExtras());
        ByteBuffer bytebuffer;
        int i1;
        int j1;
        if (r != null)
        {
            j = com.socialin.android.util.w.a(r, PicsartContext.a(), 0);
            j = b(j);
        } else
        {
            try
            {
                j = com.socialin.android.util.w.b(g, PicsartContext.a(), y);
                j = b(j);
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                com.socialin.android.d.b(f, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(bundle.getMessage()).toString()
                });
            }
        }
        m = com.socialin.android.util.w.b(j);
        bundle = d;
        bytebuffer = m;
        i1 = j.getWidth();
        j1 = j.getHeight();
        bundle.c = bytebuffer;
        bundle.d = i1;
        bundle.e = j1;
        o.b(j);
        e();
        d();
        setContentView(0x7f03003a);
        ((RelativeLayout)findViewById(0x7f1001b3)).addView(o);
        bundle = (SeekBar)findViewById(0x7f1001ba);
        bundle.setProgress(a - 1);
        ((TextView)findViewById(0x7f1001b9)).setText((new StringBuilder()).append(getString(0x7f080630)).append(": ").append(a).toString());
        bundle.setOnSeekBarChangeListener(A);
        p = getResources().getDisplayMetrics();
        i1 = p.heightPixels;
        i1 = p.widthPixels;
        ((ImageButton)findViewById(0x7f1001b6)).setOnClickListener(this);
        ((ImageButton)findViewById(0x7f1001b5)).setOnClickListener(this);
        ((ImageButton)findViewById(0x7f1001b7)).setOnClickListener(this);
        q = new g(this);
        q.setMessage(getString(0x7f0803d8));
        q.setCancelable(false);
        q.setCanceledOnTouchOutside(false);
        q.setIndeterminate(true);
        initAd();
    }

    protected void onDestroy()
    {
        super.onDestroy();
        a(n);
        a(m);
        a(l);
        b.recycle();
        j.recycle();
        k.recycle();
        o.c.recycle();
        if (c != null && !c.isRecycled())
        {
            c.recycle();
        }
        e.shutdownNow();
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        if (s != null)
        {
            bundle.putSerializable("extra.blending.image.bufferdata", s);
        }
        if (h != null)
        {
            bundle.putSerializable("extra.blending.image.path", h);
        }
        if (r != null)
        {
            bundle.putSerializable("extra.bg.image.bufferdata", r);
        }
        if (g != null)
        {
            bundle.putSerializable("extra.bg.image.path", g);
        }
        if (l != null)
        {
            bundle.putSerializable("extra.blendingmask.image.bufferdata", t);
        }
        if (v != null)
        {
            bundle.putParcelable("boundingRect", v);
        }
        if (i != null)
        {
            bundle.putString("JSON", i);
        }
        if (w != null)
        {
            bundle.putParcelable("oldBoundingRect", w);
        }
        bundle.putBoolean("blendImageParamsChanged", u);
        bundle.putInt("originalImageDegree", y);
    }

}
