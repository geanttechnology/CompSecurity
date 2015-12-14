// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.shareinstagram;

import aar;
import aas;
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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import auf;
import aug;
import auh;
import aui;
import auj;
import auk;
import aum;
import aun;
import auo;
import aup;
import auq;
import aur;
import aus;
import aut;
import com.crashlytics.android.Crashlytics;
import java.lang.reflect.Array;
import yp;

// Referenced classes of package com.fotoable.shareinstagram:
//            HandleBmpView, ImageView_Color, ColorScrollView

public abstract class InstagramPhotoShareActivity extends Activity
{

    public boolean c;
    FrameLayout d;
    public FrameLayout e;
    public Bitmap f;
    LinearLayout g;
    public ImageView_Color h;
    public ImageView_Color i;
    public ImageView_Color j;
    public ImageView_Color k;
    public SeekBar l;
    public FrameLayout m;
    public FrameLayout n;
    ColorScrollView o;
    public HandleBmpView p;
    public ImageView q;
    public int r;
    public int s;
    public int t;
    public boolean u;
    ProgressDialog v;

    public InstagramPhotoShareActivity()
    {
        c = false;
        r = -1;
        s = 0;
        t = 0;
        u = false;
        v = null;
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
        (new Thread(new auk(this, i1))).start();
    }

    public static void a(InstagramPhotoShareActivity instagramphotoshareactivity)
    {
        instagramphotoshareactivity.e();
    }

    public static void a(InstagramPhotoShareActivity instagramphotoshareactivity, int i1)
    {
        instagramphotoshareactivity.a(i1);
    }

    private void d()
    {
        String s1 = "Processing...";
        if (!yp.b()) goto _L2; else goto _L1
_L1:
        s1 = "\u5904\u7406\u4E2D...";
_L4:
        if (v == null)
        {
            v = new ProgressDialog(this);
            v.setMessage(s1);
            v.show();
        }
        return;
_L2:
        if (yp.c())
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
            if (v != null && v.isShowing())
            {
                v.dismiss();
                v = null;
            }
            return;
        }
        catch (Exception exception)
        {
            v = null;
        }
    }

    public abstract void a();

    public void a(Bitmap bitmap)
    {
        f = bitmap;
        int i1 = yp.a(this, 44F);
        int j1 = yp.a(this, 45F);
        int k1 = yp.a(this, 70F);
        bitmap = (android.widget.FrameLayout.LayoutParams)e.getLayoutParams();
        Object obj = getResources().getDisplayMetrics();
        bitmap.width = ((DisplayMetrics) (obj)).widthPixels;
        bitmap.height = ((DisplayMetrics) (obj)).widthPixels;
        bitmap.topMargin = (((DisplayMetrics) (obj)).heightPixels - i1 - j1 - k1 - ((android.widget.FrameLayout.LayoutParams) (bitmap)).width) / 2;
        e.setLayoutParams(bitmap);
        e.setBackgroundColor(r);
        q = new ImageView(this);
        q.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
        obj = new android.widget.FrameLayout.LayoutParams(((android.widget.FrameLayout.LayoutParams) (bitmap)).width, ((android.widget.FrameLayout.LayoutParams) (bitmap)).height, 51);
        obj.topMargin = 0;
        obj.leftMargin = 0;
        q.setVisibility(0);
        e.addView(q, ((android.view.ViewGroup.LayoutParams) (obj)));
        p = new HandleBmpView(this);
        p.setSrcBitmap(f);
        p.setBackgroundColor(0);
        bitmap = new android.widget.FrameLayout.LayoutParams(((android.widget.FrameLayout.LayoutParams) (bitmap)).width, ((android.widget.FrameLayout.LayoutParams) (bitmap)).height, 51);
        bitmap.topMargin = 0;
        bitmap.leftMargin = 0;
        e.addView(p, bitmap);
        p.setReDraw();
        a(60);
    }

    public abstract void b();

    public Bitmap c()
    {
        int j1 = f.getWidth();
        int k1 = f.getHeight();
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
        if (q.getVisibility() != 0)
        {
            break MISSING_BLOCK_LABEL_207;
        }
        matrix = new Matrix();
        matrix.setScale((float)i1 / (float)j1, (float)i1 / (float)k1);
        paint = new Paint();
        paint.setFilterBitmap(true);
        drawable = q.getDrawable();
        if (drawable == null) goto _L2; else goto _L1
_L1:
        if (!(drawable instanceof BitmapDrawable)) goto _L2; else goto _L3
_L3:
        if (((BitmapDrawable)q.getDrawable()).getBitmap() == null) goto _L5; else goto _L4
_L4:
        canvas.drawBitmap(((BitmapDrawable)q.getDrawable()).getBitmap(), matrix, paint);
_L6:
        p.drawInSaveCanvas(canvas, i1);
        return bitmap;
_L5:
        canvas.drawColor(r);
          goto _L6
        obj;
        Crashlytics.logException(((Throwable) (obj)));
_L7:
        return null;
_L2:
        canvas.drawColor(r);
          goto _L6
        obj;
        Crashlytics.logException(((Throwable) (obj)));
          goto _L7
        canvas.drawColor(r);
          goto _L6
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(aas.activity_instagram_share);
        d = (FrameLayout)findViewById(aar.topbar);
        e = (FrameLayout)findViewById(aar.container);
        ((FrameLayout)findViewById(aar.back_frame)).setOnClickListener(new auf(this));
        ((FrameLayout)findViewById(aar.next_frame)).setOnClickListener(new aum(this));
        g = (LinearLayout)findViewById(aar.bottom_view);
        h = (ImageView_Color)findViewById(aar.blur_image);
        h.setSelected(true);
        ((FrameLayout)findViewById(aar.blur_frame)).setOnClickListener(new aun(this));
        i = (ImageView_Color)findViewById(aar.color_image);
        ((FrameLayout)findViewById(aar.color_frame)).setOnClickListener(new auo(this));
        j = (ImageView_Color)findViewById(aar.corner_image);
        ((FrameLayout)findViewById(aar.corner_frame)).setOnClickListener(new aup(this));
        k = (ImageView_Color)findViewById(aar.shadow_image);
        ((FrameLayout)findViewById(aar.shadow_frame)).setOnClickListener(new auq(this));
        l = (SeekBar)findViewById(aar.blur_alpha);
        l.setMax(100);
        l.setOnSeekBarChangeListener(new aur(this));
        n = (FrameLayout)findViewById(aar.corner_container);
        bundle = (SeekBar)findViewById(aar.corner_alpha);
        bundle.setMax(100);
        bundle.setProgress(10);
        bundle.setOnSeekBarChangeListener(new aus(this));
        bundle = (SeekBar)findViewById(aar.side_alpha);
        bundle.setMax(100);
        bundle.setOnSeekBarChangeListener(new aut(this));
        m = (FrameLayout)findViewById(aar.color_container);
        o = (ColorScrollView)findViewById(aar.color_scroll);
        bundle = getResources().getDisplayMetrics();
        o.setMaxSizeWithMultyLine(2, ((DisplayMetrics) (bundle)).widthPixels, (int)(((DisplayMetrics) (bundle)).density * 40F));
        o.setOnMultyColorSelectorLisener(new aug(this));
        ((FrameLayout)findViewById(aar.brown_view)).setOnClickListener(new auh(this));
        ((FrameLayout)findViewById(aar.white_view)).setOnClickListener(new aui(this));
        ((FrameLayout)findViewById(aar.black_view)).setOnClickListener(new auj(this));
        k.setSelected(true);
    }

    protected void onDestroy()
    {
        super.onDestroy();
        if (p != null)
        {
            p.clearDrawBitmap();
        }
    }

    protected void onResume()
    {
        super.onResume();
        u = false;
    }
}
