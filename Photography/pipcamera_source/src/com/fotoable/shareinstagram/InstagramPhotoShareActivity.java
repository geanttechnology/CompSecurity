// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.shareinstagram;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import com.crashlytics.android.Crashlytics;
import ew;
import java.lang.reflect.Array;
import oh;

// Referenced classes of package com.fotoable.shareinstagram:
//            HandleBmpView, ImageView_Color, ColorScrollView

public abstract class InstagramPhotoShareActivity extends Activity
{

    public boolean a;
    FrameLayout b;
    FrameLayout c;
    Bitmap d;
    LinearLayout e;
    ImageView_Color f;
    ImageView_Color g;
    ImageView_Color h;
    ImageView_Color i;
    SeekBar j;
    FrameLayout k;
    FrameLayout l;
    ColorScrollView m;
    HandleBmpView n;
    ImageView o;
    int p;
    int q;
    int r;
    boolean s;
    ProgressDialog t;

    public InstagramPhotoShareActivity()
    {
        a = false;
        p = -1;
        q = 0;
        r = 0;
        s = false;
        t = null;
    }

    public static Bitmap a(Bitmap bitmap, int i1)
    {
        bitmap = bitmap.copy(bitmap.getConfig(), true);
        if (i1 < 1)
        {
            return null;
        }
        int k11 = bitmap.getWidth();
        int l11 = bitmap.getHeight();
        int ai[] = new int[k11 * l11];
        Log.e("pix", (new StringBuilder()).append(k11).append(" ").append(l11).append(" ").append(ai.length).toString());
        bitmap.getPixels(ai, 0, k11, 0, 0, k11, l11);
        int l10 = k11 - 1;
        int i12 = l11 - 1;
        int j1 = k11 * l11;
        int j12 = i1 + i1 + 1;
        int ai1[] = new int[j1];
        int ai2[] = new int[j1];
        int ai3[] = new int[j1];
        int ai4[] = new int[Math.max(k11, l11)];
        j1 = j12 + 1 >> 1;
        int k12 = j1 * j1;
        int ai5[] = new int[256];
        for (j1 = 0; j1 < 256; j1++)
        {
            ai5[j1] = j1;
        }

        int ai6[][] = (int[][])Array.newInstance(Integer.TYPE, new int[] {
            j12, 3
        });
        int l12 = i1 + 1;
        int j7 = 0;
        j1 = 0;
        for (int l6 = 0; l6 < l11; l6++)
        {
            int l1 = 0;
            int l7 = -i1;
            int i3 = 0;
            int k3 = 0;
            int i4 = 0;
            int k4 = 0;
            int i5 = 0;
            int l5 = 0;
            int j6 = 0;
            int k2 = 0;
            while (l7 <= i1) 
            {
                int k8 = ai[Math.min(l10, Math.max(l7, 0)) + j1];
                int ai7[] = ai6[l7 + i1];
                ai7[0] = (0xff0000 & k8) >> 16;
                ai7[1] = (0xff00 & k8) >> 8;
                ai7[2] = k8 & 0xff;
                k8 = l12 - Math.abs(l7);
                j6 += ai7[0] * k8;
                l5 += ai7[1] * k8;
                i5 += k8 * ai7[2];
                if (l7 > 0)
                {
                    i3 += ai7[0];
                    k2 += ai7[1];
                    l1 += ai7[2];
                } else
                {
                    k4 += ai7[0];
                    i4 += ai7[1];
                    k3 += ai7[2];
                }
                l7++;
            }
            l7 = l5;
            boolean flag = false;
            l5 = i1;
            int l8 = j6;
            j6 = i5;
            for (int j5 = ((flag) ? 1 : 0); j5 < k11; j5++)
            {
                ai1[j1] = ai5[l8 / k12];
                ai2[j1] = ai5[l7 / k12];
                ai3[j1] = ai5[j6 / k12];
                int ai8[] = ai6[((l5 - i1) + j12) % j12];
                int l13 = ai8[0];
                int i13 = ai8[1];
                int l9 = ai8[2];
                if (l6 == 0)
                {
                    ai4[j5] = Math.min(j5 + i1 + 1, l10);
                }
                int i14 = ai[ai4[j5] + j7];
                ai8[0] = (0xff0000 & i14) >> 16;
                ai8[1] = (0xff00 & i14) >> 8;
                ai8[2] = i14 & 0xff;
                i3 += ai8[0];
                k2 += ai8[1];
                l1 += ai8[2];
                l8 = (l8 - k4) + i3;
                l7 = (l7 - i4) + k2;
                j6 = (j6 - k3) + l1;
                l5 = (l5 + 1) % j12;
                ai8 = ai6[l5 % j12];
                k4 = (k4 - l13) + ai8[0];
                i4 = (i4 - i13) + ai8[1];
                k3 = (k3 - l9) + ai8[2];
                i3 -= ai8[0];
                k2 -= ai8[1];
                l1 -= ai8[2];
                j1++;
            }

            j7 += k11;
        }

        for (int k1 = 0; k1 < k11; k1++)
        {
            int k6 = 0;
            int k7 = -i1 * k11;
            int i7 = -i1;
            int k5 = 0;
            int l3 = 0;
            int j4 = 0;
            int l4 = 0;
            int i2 = 0;
            int j3 = 0;
            int l2 = 0;
            int i6 = 0;
            while (i7 <= i1) 
            {
                int i8 = Math.max(0, k7) + k1;
                int ai9[] = ai6[i7 + i1];
                ai9[0] = ai1[i8];
                ai9[1] = ai2[i8];
                ai9[2] = ai3[i8];
                int i9 = l12 - Math.abs(i7);
                int i10 = ai1[i8];
                int i11 = ai2[i8];
                int j13 = ai3[i8];
                if (i7 > 0)
                {
                    k5 += ai9[0];
                    i6 += ai9[1];
                    k6 += ai9[2];
                } else
                {
                    l4 += ai9[0];
                    j4 += ai9[1];
                    l3 += ai9[2];
                }
                i8 = k7;
                if (i7 < i12)
                {
                    i8 = k7 + k11;
                }
                i7++;
                i2 = j13 * i9 + i2;
                j3 = i11 * i9 + j3;
                l2 = i10 * i9 + l2;
                k7 = i8;
            }
            int j9 = j3;
            int j10 = l2;
            boolean flag1 = false;
            l2 = k1;
            i7 = k6;
            k7 = i6;
            int j8 = k5;
            j3 = l3;
            l3 = j4;
            j4 = l4;
            l4 = i1;
            k6 = j10;
            i6 = j9;
            k5 = i2;
            for (int j2 = ((flag1) ? 1 : 0); j2 < l11; j2++)
            {
                ai[l2] = 0xff000000 & ai[l2] | ai5[k6 / k12] << 16 | ai5[i6 / k12] << 8 | ai5[k5 / k12];
                int ai10[] = ai6[((l4 - i1) + j12) % j12];
                int j11 = ai10[0];
                int k10 = ai10[1];
                int k9 = ai10[2];
                if (k1 == 0)
                {
                    ai4[j2] = Math.min(j2 + l12, i12) * k11;
                }
                int k13 = ai4[j2] + k1;
                ai10[0] = ai1[k13];
                ai10[1] = ai2[k13];
                ai10[2] = ai3[k13];
                j8 += ai10[0];
                k7 += ai10[1];
                i7 += ai10[2];
                k6 = (k6 - j4) + j8;
                i6 = (i6 - l3) + k7;
                k5 = (k5 - j3) + i7;
                l4 = (l4 + 1) % j12;
                ai10 = ai6[l4];
                j4 = (j4 - j11) + ai10[0];
                l3 = (l3 - k10) + ai10[1];
                j3 = (j3 - k9) + ai10[2];
                j8 -= ai10[0];
                k7 -= ai10[1];
                i7 -= ai10[2];
                l2 += k11;
            }

        }

        Log.e("pix", (new StringBuilder()).append(k11).append(" ").append(l11).append(" ").append(ai.length).toString());
        bitmap.setPixels(ai, 0, k11, 0, 0, k11, l11);
        return bitmap;
    }

    private void a(int i1)
    {
        d();
        (new Thread(new Runnable(i1) {

            final int a;
            final InstagramPhotoShareActivity b;

            public void run()
            {
                Bitmap bitmap = InstagramPhotoShareActivity.a(b.d, a);
                b.runOnUiThread(new Runnable(this, bitmap) {

                    final Bitmap a;
                    final _cls6 b;

                    public void run()
                    {
                        InstagramPhotoShareActivity.a(b.b);
                        if (a == null || a.isRecycled())
                        {
                            b.b.o.setImageBitmap(b.b.d);
                            return;
                        } else
                        {
                            b.b.o.setImageBitmap(a);
                            return;
                        }
                    }

            
            {
                b = _pcls6;
                a = bitmap;
                super();
            }
                });
            }

            
            {
                b = InstagramPhotoShareActivity.this;
                a = i1;
                super();
            }
        })).start();
    }

    static void a(InstagramPhotoShareActivity instagramphotoshareactivity)
    {
        instagramphotoshareactivity.e();
    }

    static void a(InstagramPhotoShareActivity instagramphotoshareactivity, int i1)
    {
        instagramphotoshareactivity.a(i1);
    }

    private void d()
    {
        String s1 = "Processing...";
        if (!ew.b()) goto _L2; else goto _L1
_L1:
        s1 = "\u5904\u7406\u4E2D...";
_L4:
        if (t == null)
        {
            t = new ProgressDialog(this);
            t.setMessage(s1);
            t.show();
        }
        return;
_L2:
        if (ew.c())
        {
            s1 = "\u8655\u7406\u4E2D...";
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void e()
    {
        try
        {
            if (t != null && t.isShowing())
            {
                t.dismiss();
                t = null;
            }
            return;
        }
        catch (Exception exception)
        {
            t = null;
        }
    }

    public abstract void a();

    public void a(Bitmap bitmap)
    {
        d = bitmap;
        int i1 = ew.a(this, 44F);
        int j1 = ew.a(this, 45F);
        int k1 = ew.a(this, 70F);
        bitmap = (android.widget.FrameLayout.LayoutParams)c.getLayoutParams();
        Object obj = getResources().getDisplayMetrics();
        bitmap.width = ((DisplayMetrics) (obj)).widthPixels;
        bitmap.height = ((DisplayMetrics) (obj)).widthPixels;
        bitmap.topMargin = (((DisplayMetrics) (obj)).heightPixels - i1 - j1 - k1 - ((android.widget.FrameLayout.LayoutParams) (bitmap)).width) / 2;
        c.setLayoutParams(bitmap);
        c.setBackgroundColor(p);
        o = new ImageView(this);
        o.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
        obj = new android.widget.FrameLayout.LayoutParams(((android.widget.FrameLayout.LayoutParams) (bitmap)).width, ((android.widget.FrameLayout.LayoutParams) (bitmap)).height, 51);
        obj.topMargin = 0;
        obj.leftMargin = 0;
        o.setVisibility(0);
        c.addView(o, ((android.view.ViewGroup.LayoutParams) (obj)));
        n = new HandleBmpView(this);
        n.setSrcBitmap(d);
        n.setBackgroundColor(0);
        bitmap = new android.widget.FrameLayout.LayoutParams(((android.widget.FrameLayout.LayoutParams) (bitmap)).width, ((android.widget.FrameLayout.LayoutParams) (bitmap)).height, 51);
        bitmap.topMargin = 0;
        bitmap.leftMargin = 0;
        c.addView(n, bitmap);
        n.setReDraw();
        a(60);
    }

    public abstract void b();

    public Bitmap c()
    {
        int j1 = d.getWidth();
        int k1 = d.getHeight();
        Bitmap bitmap;
        Object obj;
        Canvas canvas;
        Matrix matrix;
        Paint paint;
        android.graphics.drawable.Drawable drawable;
        int i1;
        if (j1 > k1)
        {
            i1 = j1;
        } else
        {
            i1 = k1;
        }
        bitmap = Bitmap.createBitmap(i1, i1, android.graphics.Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        if (o.getVisibility() != 0)
        {
            break MISSING_BLOCK_LABEL_207;
        }
        matrix = new Matrix();
        matrix.setScale((float)i1 / (float)j1, (float)i1 / (float)k1);
        paint = new Paint();
        paint.setFilterBitmap(true);
        drawable = o.getDrawable();
        if (drawable == null) goto _L2; else goto _L1
_L1:
        if (!(drawable instanceof BitmapDrawable)) goto _L2; else goto _L3
_L3:
        if (((BitmapDrawable)o.getDrawable()).getBitmap() == null) goto _L5; else goto _L4
_L4:
        canvas.drawBitmap(((BitmapDrawable)o.getDrawable()).getBitmap(), matrix, paint);
_L6:
        n.drawInSaveCanvas(canvas, i1);
        return bitmap;
_L5:
        canvas.drawColor(p);
          goto _L6
        obj;
        Crashlytics.logException(((Throwable) (obj)));
_L7:
        return null;
_L2:
        canvas.drawColor(p);
          goto _L6
        obj;
        Crashlytics.logException(((Throwable) (obj)));
          goto _L7
        canvas.drawColor(p);
          goto _L6
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(com.fotoable.fotoadpackage.R.layout.activity_instagram_share);
        b = (FrameLayout)findViewById(com.fotoable.fotoadpackage.R.id.topbar);
        c = (FrameLayout)findViewById(com.fotoable.fotoadpackage.R.id.container);
        ((FrameLayout)findViewById(com.fotoable.fotoadpackage.R.id.back_frame)).setOnClickListener(new android.view.View.OnClickListener() {

            final InstagramPhotoShareActivity a;

            public void onClick(View view)
            {
                a.a();
            }

            
            {
                a = InstagramPhotoShareActivity.this;
                super();
            }
        });
        ((FrameLayout)findViewById(com.fotoable.fotoadpackage.R.id.next_frame)).setOnClickListener(new android.view.View.OnClickListener() {

            final InstagramPhotoShareActivity a;

            public void onClick(View view)
            {
                if (a.s)
                {
                    return;
                } else
                {
                    a.s = true;
                    a.b();
                    return;
                }
            }

            
            {
                a = InstagramPhotoShareActivity.this;
                super();
            }
        });
        e = (LinearLayout)findViewById(com.fotoable.fotoadpackage.R.id.bottom_view);
        f = (ImageView_Color)findViewById(com.fotoable.fotoadpackage.R.id.blur_image);
        f.setSelected(true);
        ((FrameLayout)findViewById(com.fotoable.fotoadpackage.R.id.blur_frame)).setOnClickListener(new android.view.View.OnClickListener() {

            final InstagramPhotoShareActivity a;

            public void onClick(View view)
            {
                a.j.setVisibility(0);
                a.f.setSelected(true);
                a.k.setVisibility(4);
                a.g.setSelected(false);
                a.l.setVisibility(4);
                a.h.setSelected(false);
                a.o.setVisibility(0);
            }

            
            {
                a = InstagramPhotoShareActivity.this;
                super();
            }
        });
        g = (ImageView_Color)findViewById(com.fotoable.fotoadpackage.R.id.color_image);
        ((FrameLayout)findViewById(com.fotoable.fotoadpackage.R.id.color_frame)).setOnClickListener(new android.view.View.OnClickListener() {

            final InstagramPhotoShareActivity a;

            public void onClick(View view)
            {
                a.j.setVisibility(4);
                a.f.setSelected(false);
                a.k.setVisibility(0);
                a.g.setSelected(true);
                a.l.setVisibility(4);
                a.h.setSelected(false);
                a.o.setVisibility(4);
            }

            
            {
                a = InstagramPhotoShareActivity.this;
                super();
            }
        });
        h = (ImageView_Color)findViewById(com.fotoable.fotoadpackage.R.id.corner_image);
        ((FrameLayout)findViewById(com.fotoable.fotoadpackage.R.id.corner_frame)).setOnClickListener(new android.view.View.OnClickListener() {

            final InstagramPhotoShareActivity a;

            public void onClick(View view)
            {
                a.j.setVisibility(4);
                a.f.setSelected(false);
                a.k.setVisibility(4);
                a.g.setSelected(false);
                a.l.setVisibility(0);
                a.h.setSelected(true);
            }

            
            {
                a = InstagramPhotoShareActivity.this;
                super();
            }
        });
        i = (ImageView_Color)findViewById(com.fotoable.fotoadpackage.R.id.shadow_image);
        ((FrameLayout)findViewById(com.fotoable.fotoadpackage.R.id.shadow_frame)).setOnClickListener(new android.view.View.OnClickListener() {

            final InstagramPhotoShareActivity a;

            public void onClick(View view)
            {
                a.n.changeShadowMode();
                view = a.i;
                boolean flag;
                if (!a.i.isSelected())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                view.setSelected(flag);
            }

            
            {
                a = InstagramPhotoShareActivity.this;
                super();
            }
        });
        j = (SeekBar)findViewById(com.fotoable.fotoadpackage.R.id.blur_alpha);
        j.setMax(100);
        j.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {

            final InstagramPhotoShareActivity a;

            public void onProgressChanged(SeekBar seekbar, int i1, boolean flag)
            {
            }

            public void onStartTrackingTouch(SeekBar seekbar)
            {
            }

            public void onStopTrackingTouch(SeekBar seekbar)
            {
                int j1 = seekbar.getProgress();
                int i1 = j1;
                if (j1 <= 0)
                {
                    i1 = 1;
                }
                InstagramPhotoShareActivity.a(a, i1);
            }

            
            {
                a = InstagramPhotoShareActivity.this;
                super();
            }
        });
        l = (FrameLayout)findViewById(com.fotoable.fotoadpackage.R.id.corner_container);
        bundle = (SeekBar)findViewById(com.fotoable.fotoadpackage.R.id.corner_alpha);
        bundle.setMax(100);
        bundle.setProgress(10);
        bundle.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {

            final InstagramPhotoShareActivity a;

            public void onProgressChanged(SeekBar seekbar, int i1, boolean flag)
            {
                a.q = i1;
                if (a.n != null)
                {
                    a.n.setCornerRadius(a.q);
                }
            }

            public void onStartTrackingTouch(SeekBar seekbar)
            {
            }

            public void onStopTrackingTouch(SeekBar seekbar)
            {
            }

            
            {
                a = InstagramPhotoShareActivity.this;
                super();
            }
        });
        bundle = (SeekBar)findViewById(com.fotoable.fotoadpackage.R.id.side_alpha);
        bundle.setMax(100);
        bundle.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {

            final InstagramPhotoShareActivity a;

            public void onProgressChanged(SeekBar seekbar, int i1, boolean flag)
            {
                a.r = i1;
                if (a.n != null)
                {
                    a.n.setBorderRadius(a.r);
                }
            }

            public void onStartTrackingTouch(SeekBar seekbar)
            {
            }

            public void onStopTrackingTouch(SeekBar seekbar)
            {
            }

            
            {
                a = InstagramPhotoShareActivity.this;
                super();
            }
        });
        k = (FrameLayout)findViewById(com.fotoable.fotoadpackage.R.id.color_container);
        m = (ColorScrollView)findViewById(com.fotoable.fotoadpackage.R.id.color_scroll);
        bundle = getResources().getDisplayMetrics();
        m.setMaxSizeWithMultyLine(2, ((DisplayMetrics) (bundle)).widthPixels, (int)(((DisplayMetrics) (bundle)).density * 40F));
        m.setOnMultyColorSelectorLisener(new oh() {

            final InstagramPhotoShareActivity a;

            public void a()
            {
            }

            public void a(int i1)
            {
                a.p = i1;
                a.c.setBackgroundColor(a.p);
            }

            public void b()
            {
            }

            
            {
                a = InstagramPhotoShareActivity.this;
                super();
            }
        });
        ((FrameLayout)findViewById(com.fotoable.fotoadpackage.R.id.brown_view)).setOnClickListener(new android.view.View.OnClickListener() {

            final InstagramPhotoShareActivity a;

            public void onClick(View view)
            {
                a.p = 0xff7a7a7a;
                a.c.setBackgroundColor(0xff7a7a7a);
            }

            
            {
                a = InstagramPhotoShareActivity.this;
                super();
            }
        });
        ((FrameLayout)findViewById(com.fotoable.fotoadpackage.R.id.white_view)).setOnClickListener(new android.view.View.OnClickListener() {

            final InstagramPhotoShareActivity a;

            public void onClick(View view)
            {
                a.p = -1;
                a.c.setBackgroundColor(-1);
            }

            
            {
                a = InstagramPhotoShareActivity.this;
                super();
            }
        });
        ((FrameLayout)findViewById(com.fotoable.fotoadpackage.R.id.black_view)).setOnClickListener(new android.view.View.OnClickListener() {

            final InstagramPhotoShareActivity a;

            public void onClick(View view)
            {
                a.p = 0xff000000;
                a.c.setBackgroundColor(0xff000000);
            }

            
            {
                a = InstagramPhotoShareActivity.this;
                super();
            }
        });
        i.setSelected(true);
    }

    protected void onDestroy()
    {
        super.onDestroy();
        if (n != null)
        {
            n.clearDrawBitmap();
        }
    }

    protected void onResume()
    {
        super.onResume();
        s = false;
    }
}
