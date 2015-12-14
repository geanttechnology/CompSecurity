// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.eyereplacer;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SlidingDrawer;
import android.widget.TextView;
import com.picsart.studio.EditingData;
import com.picsart.studio.PicsartContext;
import com.socialin.android.activity.AdBaseActivity;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.dialog.g;
import com.socialin.android.photo.imgop.ImageOpCommon;
import com.socialin.android.util.ModernAsyncTask;
import com.socialin.android.util.Utils;
import com.socialin.android.util.c;
import com.socialin.android.util.w;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import myobfuscated.ay.e;
import org.json.JSONArray;

// Referenced classes of package com.picsart.effects.eyereplacer:
//            EyeReplaceImageView, a, c, d, 
//            b

public class EyeReplacerActivity extends AdBaseActivity
{

    private static final String b = (new StringBuilder()).append(com/picsart/effects/eyereplacer/EyeReplacerActivity.getSimpleName()).append("_").append(System.currentTimeMillis()).toString();
    boolean a;
    private EyeReplaceImageView c;
    private LinearLayout d;
    private int e;
    private String f;
    private String g;
    private String h;
    private int i;
    private HashMap j;
    private int k;
    private int l;
    private com.picsart.effects.eyereplacer.c m;
    private a n;
    private g o;
    private boolean p;
    private ThreadPoolExecutor q;

    public EyeReplacerActivity()
    {
        f = null;
        g = null;
        i = 0;
        j = null;
        a = false;
        o = null;
        p = true;
        q = null;
    }

    static a a(EyeReplacerActivity eyereplaceractivity)
    {
        return eyereplaceractivity.n;
    }

    private boolean a()
    {
        Object obj;
        Object obj1;
        c = (EyeReplaceImageView)findViewById(0x7f1000ef);
        c.setTouchCircleDrawer(m);
        Bitmap bitmap;
        if (j != null)
        {
            k = ((Integer)j.get("width")).intValue();
            l = ((Integer)j.get("height")).intValue();
        } else
        {
            obj = new android.graphics.BitmapFactory.Options();
            obj.inJustDecodeBounds = true;
            com.socialin.android.util.c.a(h, ((android.graphics.BitmapFactory.Options) (obj)), b);
            if (i == 90 || i == 270)
            {
                l = ((android.graphics.BitmapFactory.Options) (obj)).outWidth;
                k = ((android.graphics.BitmapFactory.Options) (obj)).outHeight;
            } else
            {
                k = ((android.graphics.BitmapFactory.Options) (obj)).outWidth;
                l = ((android.graphics.BitmapFactory.Options) (obj)).outHeight;
            }
        }
        obj1 = null;
        obj = obj1;
        Log.e("ex1", "BITMAP_PREVIEW_MAXSIZE = 640");
        obj = obj1;
        bitmap = myobfuscated.ay.e.a(h, i, j, 0x64000);
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_144;
        }
        obj = bitmap;
        Log.e("ex1", (new StringBuilder("eyeReplacer preview imageBitmap size w = ")).append(bitmap.getWidth()).append(" h = ").append(bitmap.getHeight()).toString());
        obj1 = bitmap;
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_315;
        }
        obj = bitmap;
        obj1 = bitmap;
        if (bitmap.isRecycled())
        {
            break MISSING_BLOCK_LABEL_315;
        }
        obj = bitmap;
        obj1 = bitmap;
        if (bitmap.isMutable())
        {
            break MISSING_BLOCK_LABEL_315;
        }
        obj = bitmap;
        obj1 = bitmap.copy(android.graphics.Bitmap.Config.ARGB_8888, true);
        obj = bitmap;
        com.socialin.android.util.c.a(bitmap);
        obj = obj1;
_L1:
        if (obj != null && !((Bitmap) (obj)).isRecycled())
        {
            c.setImageFitCenter(((Bitmap) (obj)));
            n = new a(this, ((Bitmap) (obj)));
            return true;
        } else
        {
            return false;
        }
        obj1;
        ((Exception) (obj1)).printStackTrace();
        obj1 = obj;
        obj = obj1;
          goto _L1
    }

    static com.picsart.effects.eyereplacer.c b(EyeReplacerActivity eyereplaceractivity)
    {
        return eyereplaceractivity.m;
    }

    static EyeReplaceImageView c(EyeReplacerActivity eyereplaceractivity)
    {
        return eyereplaceractivity.c;
    }

    static boolean d(EyeReplacerActivity eyereplaceractivity)
    {
        return eyereplaceractivity.p;
    }

    static boolean e(EyeReplacerActivity eyereplaceractivity)
    {
        eyereplaceractivity.p = false;
        return false;
    }

    static int f(EyeReplacerActivity eyereplaceractivity)
    {
        return eyereplaceractivity.k;
    }

    static int g(EyeReplacerActivity eyereplaceractivity)
    {
        return eyereplaceractivity.l;
    }

    static String h(EyeReplacerActivity eyereplaceractivity)
    {
        return eyereplaceractivity.f;
    }

    static String i(EyeReplacerActivity eyereplaceractivity)
    {
        return eyereplaceractivity.g;
    }

    static HashMap j(EyeReplacerActivity eyereplaceractivity)
    {
        return eyereplaceractivity.j;
    }

    static String k(EyeReplacerActivity eyereplaceractivity)
    {
        return eyereplaceractivity.h;
    }

    static int l(EyeReplacerActivity eyereplaceractivity)
    {
        return eyereplaceractivity.i;
    }

    static int m(EyeReplacerActivity eyereplaceractivity)
    {
        return eyereplaceractivity.e;
    }

    static g n(EyeReplacerActivity eyereplaceractivity)
    {
        return eyereplaceractivity.o;
    }

    static ThreadPoolExecutor o(EyeReplacerActivity eyereplaceractivity)
    {
        return eyereplaceractivity.q;
    }

    protected ViewGroup getAdLayout()
    {
        return (RelativeLayout)findViewById(0x7f100128);
    }

    public void onBackPressed()
    {
        SlidingDrawer slidingdrawer = (SlidingDrawer)findViewById(0x7f10057c);
        if (slidingdrawer.isOpened())
        {
            slidingdrawer.close();
            return;
        } else
        {
            super.onBackPressed();
            return;
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        Object obj;
        RelativeLayout relativelayout;
        boolean flag;
        obj = null;
        if (c != null)
        {
            EyeReplaceImageView eyereplaceimageview = c;
            if (eyereplaceimageview.c != null && eyereplaceimageview.b != null && !eyereplaceimageview.b.isRecycled())
            {
                float f1 = eyereplaceimageview.a.width() / (float)eyereplaceimageview.b.getWidth();
                PointF pointf = eyereplaceimageview.c.a();
                eyereplaceimageview.d.x = (int)((pointf.x - eyereplaceimageview.a.left) / f1);
                eyereplaceimageview.d.y = (int)((pointf.y - eyereplaceimageview.a.top) / f1);
                eyereplaceimageview.e = eyereplaceimageview.c.b.b / f1;
            }
        }
        flag = ((SlidingDrawer)findViewById(0x7f10057c)).isOpened();
        ((LinearLayout)findViewById(0x7f10057d)).removeAllViews();
        relativelayout = (RelativeLayout)findViewById(0x7f1001ab);
        relativelayout.removeAllViews();
        configuration.orientation;
        JVM INSTR tableswitch 1 2: default 212
    //                   1 261
    //                   2 297;
           goto _L1 _L2 _L3
_L1:
        Object obj1 = null;
_L5:
        ((SlidingDrawer) (obj1)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        relativelayout.addView(((View) (obj1)));
        ((LinearLayout)findViewById(0x7f10057d)).addView(d);
        if (flag)
        {
            ((SlidingDrawer) (obj1)).open();
        }
        super.onConfigurationChanged(configuration);
        return;
_L2:
        obj1 = (SlidingDrawer)getLayoutInflater().inflate(0x7f030189, null);
        obj = new android.widget.RelativeLayout.LayoutParams(-1, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(12);
        continue; /* Loop/switch isn't completed */
_L3:
        obj1 = (SlidingDrawer)getLayoutInflater().inflate(0x7f030148, null);
        obj = new android.widget.RelativeLayout.LayoutParams((int)TypedValue.applyDimension(1, 320F, getResources().getDisplayMetrics()), -1);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(11);
        if (true) goto _L5; else goto _L4
_L4:
    }

    protected void onCreate(Bundle bundle)
    {
        RelativeLayout relativelayout;
        super.onCreate(bundle);
        setContentView(0x7f0300ed);
        AnalyticUtils.getInstance(this).trackLocalAction("EyeReplacer:onCreate");
        initAd();
        q = (ThreadPoolExecutor)Executors.newFixedThreadPool(1);
        e = getIntent().getExtras().getInt("maxPixel", PicsartContext.a());
        Log.e("ex1", (new StringBuilder("EYEreplaycerAcivity pixelsMaxCount = ")).append(e).toString());
        f = getIntent().getExtras().getString("saveToPath", null);
        g = getIntent().getExtras().getString("buffer_to_save", null);
        h = getIntent().getExtras().getString("path");
        i = getIntent().getIntExtra("degree", i);
        if (getIntent().hasExtra("bufferData"))
        {
            j = (HashMap)getIntent().getSerializableExtra("bufferData");
        }
        m = new com.picsart.effects.eyereplacer.c(com.socialin.android.util.c.a(getResources(), 0x7f02024d, null, b));
        if (!a())
        {
            Utils.b(this, 0x7f080429);
            finish();
            return;
        }
        findViewById(0x7f1004d1).setOnClickListener(new android.view.View.OnClickListener() {

            private EyeReplacerActivity a;

            public final void onClick(View view)
            {
                if (EyeReplacerActivity.a(a).j)
                {
                    Utils.b(a, 0x7f080405);
                } else
                {
                    Object obj1 = EyeReplacerActivity.b(a).a();
                    RectF rectf = com.picsart.effects.eyereplacer.EyeReplacerActivity.c(a).a;
                    view = com.picsart.effects.eyereplacer.EyeReplacerActivity.c(a).b;
                    if (view != null && !view.isRecycled())
                    {
                        float f1 = rectf.width() / (float)view.getWidth();
                        view = EyeReplacerActivity.a(a);
                        float f2 = ((PointF) (obj1)).x;
                        float f3 = ((PointF) (obj1)).y;
                        float f4 = EyeReplacerActivity.b(a).b.b;
                        float f5 = rectf.left;
                        float f6 = rectf.top;
                        view.j = true;
                        int i1 = (int)((f2 - f5) / f1);
                        int j1 = (int)((f3 - f6) / f1);
                        int k1 = (int)(f4 / f1);
                        obj1 = new PorterDuffXfermode(android.graphics.PorterDuff.Mode.CLEAR);
                        ((a) (view)).e.setXfermode(((android.graphics.Xfermode) (obj1)));
                        ((a) (view)).f.drawCircle(i1, j1, k1, ((a) (view)).e);
                        obj1 = new PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_OVER);
                        ((a) (view)).e.setXfermode(((android.graphics.Xfermode) (obj1)));
                        ((a) (view)).f.drawBitmap(((a) (view)).c, 0.0F, 0.0F, ((a) (view)).e);
                        obj1 = new b();
                        obj1.a = i1;
                        obj1.b = j1;
                        obj1.c = k1;
                        ((a) (view)).g.add(obj1);
                        view.j = false;
                        com.picsart.effects.eyereplacer.EyeReplacerActivity.c(a).invalidate();
                        a.findViewById(0x7f1004d3).setEnabled(true);
                        a.findViewById(0x7f1004d4).setEnabled(true);
                        a.findViewById(0x7f1004d2).setEnabled(true);
                        if (EyeReplacerActivity.d(a))
                        {
                            view = (SlidingDrawer)a.findViewById(0x7f10057c);
                            if (!view.isOpened())
                            {
                                view.open();
                            }
                            com.picsart.effects.eyereplacer.EyeReplacerActivity.e(a);
                            return;
                        }
                    }
                }
            }

            
            {
                a = EyeReplacerActivity.this;
                super();
            }
        });
        findViewById(0x7f1004d3).setOnClickListener(new android.view.View.OnClickListener() {

            private EyeReplacerActivity a;

            public final void onClick(View view)
            {
                if (!EyeReplacerActivity.a(a).j) goto _L2; else goto _L1
_L1:
                Utils.b(a, 0x7f080405);
_L4:
                return;
_L2:
                Object obj1 = com.picsart.effects.eyereplacer.EyeReplacerActivity.c(a).b;
                if (obj1 == null || ((Bitmap) (obj1)).isRecycled()) goto _L4; else goto _L3
_L3:
                obj1 = EyeReplacerActivity.a(a);
                if (((a) (obj1)).g.size() <= 0) goto _L6; else goto _L5
_L5:
                ((a) (obj1)).g.remove(((a) (obj1)).g.size() - 1);
                ((a) (obj1)).b.position(0);
                ((a) (obj1)).d.copyPixelsFromBuffer(((a) (obj1)).b);
                if (((a) (obj1)).g.size() == 0) goto _L6; else goto _L7
_L7:
                boolean flag;
                PorterDuffXfermode porterduffxfermode = new PorterDuffXfermode(android.graphics.PorterDuff.Mode.CLEAR);
                ((a) (obj1)).e.setXfermode(porterduffxfermode);
                ((a) (obj1)).a(((a) (obj1)).f, ((a) (obj1)).e);
                porterduffxfermode = new PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_OVER);
                ((a) (obj1)).e.setXfermode(porterduffxfermode);
                ((a) (obj1)).f.drawBitmap(((a) (obj1)).c, 0.0F, 0.0F, ((a) (obj1)).e);
                flag = true;
_L9:
                if (!flag)
                {
                    view.setEnabled(false);
                    a.findViewById(0x7f1004d4).setEnabled(false);
                    a.findViewById(0x7f1004d2).setEnabled(false);
                }
                com.picsart.effects.eyereplacer.EyeReplacerActivity.c(a).invalidate();
                return;
_L6:
                flag = false;
                if (true) goto _L9; else goto _L8
_L8:
            }

            
            {
                a = EyeReplacerActivity.this;
                super();
            }
        });
        findViewById(0x7f1004d4).setOnClickListener(new android.view.View.OnClickListener() {

            final EyeReplacerActivity a;

            public final void onClick(View view)
            {
                if (EyeReplacerActivity.a(a).j)
                {
                    Utils.b(a, 0x7f080405);
                } else
                {
                    Bitmap bitmap = com.picsart.effects.eyereplacer.EyeReplacerActivity.c(a).b;
                    if (bitmap != null && !bitmap.isRecycled())
                    {
                        long l1 = System.nanoTime();
                        if (EyeReplacerActivity.f(a) == bitmap.getWidth() && bitmap.getHeight() == com.picsart.effects.eyereplacer.EyeReplacerActivity.g(a))
                        {
                            Intent intent = new Intent();
                            Object obj1;
                            Object obj2;
                            int i1;
                            int j1;
                            boolean flag;
                            if (EyeReplacerActivity.h(a) != null)
                            {
                                view = new File(EyeReplacerActivity.h(a));
                                w.a(view, bitmap, android.graphics.Bitmap.CompressFormat.PNG, a);
                                intent.putExtra("path", view.getAbsolutePath());
                            } else
                            if (EyeReplacerActivity.i(a) != null)
                            {
                                intent.putExtra("result_buffer_Data", w.a(EyeReplacerActivity.i(a), bitmap));
                            }
                            obj1 = "";
                            obj2 = a.getIntent();
                            view = ((View) (obj1));
                            if (((Intent) (obj2)).hasExtra("editing_data"))
                            {
                                obj2 = (EditingData)((Intent) (obj2)).getParcelableExtra("editing_data");
                                view = ((View) (obj1));
                                if (obj2 != null)
                                {
                                    view = ((EditingData) (obj2)).a;
                                }
                            }
                            Log.e("ex1", (new StringBuilder("EYE replacer remover uid = ")).append(view).toString());
                            obj1 = a;
                            i1 = bitmap.getWidth();
                            j1 = bitmap.getHeight();
                            if (!a.a)
                            {
                                flag = true;
                            } else
                            {
                                flag = false;
                            }
                            myobfuscated.ay.e.a(((android.content.Context) (obj1)), "effect_color_eye", i1, j1, flag, true, (System.nanoTime() - l1) / 0xf4240L, false, new JSONArray(), view);
                            a.setResult(-1, intent);
                            a.finish();
                            return;
                        } else
                        {
                            (new ModernAsyncTask(this, bitmap, l1) {

                                private Bitmap a;
                                private long b;
                                private _cls3 c;

                                protected final Object doInBackground(Object aobj[])
                                {
                                    return EyeReplacerActivity.a(c.a).a(EyeReplacerActivity.j(c.a), EyeReplacerActivity.k(c.a), EyeReplacerActivity.l(c.a), EyeReplacerActivity.h(c.a), EyeReplacerActivity.i(c.a), EyeReplacerActivity.m(c.a));
                                }

                                protected final void onPostExecute(Object obj)
                                {
                                    obj = (HashMap)obj;
                                    if (EyeReplacerActivity.n(c.a).isShowing())
                                    {
                                        EyeReplacerActivity.n(c.a).dismiss();
                                    }
                                    if (!c.a.isFinishing())
                                    {
                                        Intent intent = new Intent();
                                        Object obj1;
                                        Object obj2;
                                        int i1;
                                        int j1;
                                        boolean flag;
                                        if (obj != null)
                                        {
                                            intent.putExtra("result_buffer_Data", ((java.io.Serializable) (obj)));
                                        } else
                                        if (EyeReplacerActivity.h(c.a) != null)
                                        {
                                            intent.putExtra("path", EyeReplacerActivity.h(c.a));
                                        }
                                        obj1 = "";
                                        obj2 = c.a.getIntent();
                                        obj = obj1;
                                        if (((Intent) (obj2)).hasExtra("editing_data"))
                                        {
                                            obj2 = (EditingData)((Intent) (obj2)).getParcelableExtra("editing_data");
                                            obj = obj1;
                                            if (obj2 != null)
                                            {
                                                obj = ((EditingData) (obj2)).a;
                                            }
                                        }
                                        Log.e("ex1", (new StringBuilder("EYE replacer remover uid = ")).append(((String) (obj))).toString());
                                        obj1 = c.a;
                                        i1 = a.getWidth();
                                        j1 = a.getHeight();
                                        if (!c.a.a)
                                        {
                                            flag = true;
                                        } else
                                        {
                                            flag = false;
                                        }
                                        myobfuscated.ay.e.a(((android.content.Context) (obj1)), "effect_color_eye", i1, j1, flag, true, (System.nanoTime() - b) / 0xf4240L, false, new JSONArray(), ((String) (obj)));
                                        c.a.setResult(-1, intent);
                                        c.a.finish();
                                    }
                                }

            
            {
                c = _pcls3;
                a = bitmap;
                b = l1;
                super();
            }
                            }).executeOnExecutor(EyeReplacerActivity.o(a), new Void[] {
                                null
                            });
                            EyeReplacerActivity.n(a).show();
                            return;
                        }
                    }
                }
            }

            
            {
                a = EyeReplacerActivity.this;
                super();
            }
        });
        findViewById(0x7f1004d2).setOnClickListener(new android.view.View.OnClickListener() {

            private EyeReplacerActivity a;

            public final void onClick(View view)
            {
                if (a.isFinishing())
                {
                    return;
                }
                if (!EyeReplacerActivity.a(a).j)
                {
                    a a1 = EyeReplacerActivity.a(a);
                    a1.j = true;
                    a1.g.clear();
                    a1.b.position(0);
                    a1.d.copyPixelsFromBuffer(a1.b);
                    a1.j = false;
                    com.picsart.effects.eyereplacer.EyeReplacerActivity.c(a).invalidate();
                    view.setEnabled(false);
                    a.findViewById(0x7f1004d3).setEnabled(false);
                    a.findViewById(0x7f1004d4).setEnabled(false);
                    return;
                } else
                {
                    Utils.b(a, 0x7f080405);
                    return;
                }
            }

            
            {
                a = EyeReplacerActivity.this;
                super();
            }
        });
        o = new g(this);
        o.setMessage(getString(0x7f080679));
        relativelayout = (RelativeLayout)findViewById(0x7f1001ab);
        getResources().getConfiguration().orientation;
        JVM INSTR tableswitch 1 2: default 372
    //                   1 641
    //                   2 676;
           goto _L1 _L2 _L3
_L1:
        Object obj;
        bundle = null;
        obj = null;
_L5:
        ((SlidingDrawer) (obj)).setLayoutParams(bundle);
        relativelayout.addView(((View) (obj)));
        bundle = (LinearLayout)findViewById(0x7f10057d);
        d = (LinearLayout)getLayoutInflater().inflate(0x7f0300ee, null);
        obj = new android.widget.LinearLayout.LayoutParams(-1, -1);
        d.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        d.setOrientation(1);
        bundle.addView(d);
        bundle = (TextView)findViewById(0x7f1004d6);
        bundle.setText((new StringBuilder()).append(getString(0x7f0801e4)).append(" : ").append(n.h).toString());
        obj = (SeekBar)findViewById(0x7f1004d7);
        ((SeekBar) (obj)).setMax(360);
        ((SeekBar) (obj)).setProgress(n.h);
        ((SeekBar) (obj)).setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener(bundle) {

            final EyeReplacerActivity a;
            private TextView b;

            public final void onProgressChanged(SeekBar seekbar, int i1, boolean flag)
            {
                b.setText((new StringBuilder()).append(a.getString(0x7f0801e4)).append(" : ").append(i1).toString());
            }

            public final void onStartTrackingTouch(SeekBar seekbar)
            {
            }

            public final void onStopTrackingTouch(SeekBar seekbar)
            {
                a.a = true;
                if (EyeReplacerActivity.a(a).j)
                {
                    Utils.b(a, 0x7f080405);
                    return;
                } else
                {
                    b.setText((new StringBuilder()).append(a.getString(0x7f0801e4)).append(" : ").append(seekbar.getProgress()).toString());
                    (new ModernAsyncTask(this, seekbar) {

                        private SeekBar a;
                        private _cls5 b;

                        protected final Object doInBackground(Object aobj[])
                        {
                            aobj = EyeReplacerActivity.a(b.a);
                            int i1 = a.getProgress();
                            aobj.h = i1;
                            aobj.j = true;
                            if (!((a) (aobj)).a.isFinishing())
                            {
                                ((a) (aobj)).a(((a) (aobj)).b, i1, ((a) (aobj)).i);
                                if (((a) (aobj)).a.isFinishing())
                                {
                                    aobj.j = false;
                                } else
                                {
                                    ((a) (aobj)).a.runOnUiThread(new a._cls2(((a) (aobj))));
                                    aobj.j = false;
                                }
                            }
                            return null;
                        }

                        protected final void onPostExecute(Object obj)
                        {
                            if (EyeReplacerActivity.n(b.a).isShowing())
                            {
                                EyeReplacerActivity.n(b.a).dismiss();
                            }
                            if (!b.a.isFinishing())
                            {
                                com.picsart.effects.eyereplacer.EyeReplacerActivity.c(b.a).invalidate();
                            }
                        }

            
            {
                b = _pcls5;
                a = seekbar;
                super();
            }
                    }).executeOnExecutor(EyeReplacerActivity.o(a), new Void[] {
                        null
                    });
                    EyeReplacerActivity.n(a).show();
                    return;
                }
            }

            
            {
                a = EyeReplacerActivity.this;
                b = textview;
                super();
            }
        });
        bundle = (TextView)findViewById(0x7f1004d8);
        bundle.setText((new StringBuilder()).append(getString(0x7f0801e8)).append(" : ").append(n.i + 50).toString());
        obj = (SeekBar)findViewById(0x7f1004d9);
        ((SeekBar) (obj)).setMax(100);
        ((SeekBar) (obj)).setProgress(n.i + 50);
        ((SeekBar) (obj)).setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener(bundle) {

            final EyeReplacerActivity a;
            private TextView b;

            public final void onProgressChanged(SeekBar seekbar, int i1, boolean flag)
            {
                b.setText((new StringBuilder()).append(a.getString(0x7f0801e8)).append(" : ").append(i1).toString());
            }

            public final void onStartTrackingTouch(SeekBar seekbar)
            {
            }

            public final void onStopTrackingTouch(SeekBar seekbar)
            {
                a.a = true;
                if (EyeReplacerActivity.a(a).j)
                {
                    Utils.b(a, 0x7f080405);
                    return;
                } else
                {
                    b.setText((new StringBuilder()).append(a.getString(0x7f0801e8)).append(" : ").append(seekbar.getProgress()).toString());
                    (new ModernAsyncTask(this, seekbar) {

                        private SeekBar a;
                        private _cls6 b;

                        protected final Object doInBackground(Object aobj[])
                        {
                            aobj = EyeReplacerActivity.a(b.a);
                            int i1 = a.getProgress() - 50;
                            aobj.i = i1;
                            if (!((a) (aobj)).a.isFinishing())
                            {
                                aobj.j = true;
                                ((a) (aobj)).a(((a) (aobj)).b, ((a) (aobj)).h, i1);
                                if (((a) (aobj)).a.isFinishing())
                                {
                                    aobj.j = false;
                                } else
                                {
                                    ((a) (aobj)).a.runOnUiThread(new a._cls3(((a) (aobj))));
                                    aobj.j = false;
                                }
                            }
                            return null;
                        }

                        protected final void onPostExecute(Object obj)
                        {
                            if (EyeReplacerActivity.n(b.a).isShowing())
                            {
                                EyeReplacerActivity.n(b.a).dismiss();
                            }
                            if (!b.a.isFinishing())
                            {
                                com.picsart.effects.eyereplacer.EyeReplacerActivity.c(b.a).invalidate();
                            }
                        }

            
            {
                b = _pcls6;
                a = seekbar;
                super();
            }
                    }).executeOnExecutor(EyeReplacerActivity.o(a), new Void[] {
                        null
                    });
                    EyeReplacerActivity.n(a).show();
                    return;
                }
            }

            
            {
                a = EyeReplacerActivity.this;
                b = textview;
                super();
            }
        });
        return;
_L2:
        obj = (SlidingDrawer)getLayoutInflater().inflate(0x7f030189, null);
        bundle = new android.widget.RelativeLayout.LayoutParams(-1, -2);
        bundle.addRule(12);
        continue; /* Loop/switch isn't completed */
_L3:
        obj = (SlidingDrawer)getLayoutInflater().inflate(0x7f030148, null);
        bundle = new android.widget.RelativeLayout.LayoutParams((int)TypedValue.applyDimension(1, 320F, getResources().getDisplayMetrics()), -1);
        bundle.addRule(11);
        if (true) goto _L5; else goto _L4
_L4:
    }

    protected void onStop()
    {
        super.onStop();
        if (isFinishing())
        {
            Log.e("ex1", "onStop isFinishing()");
            if (m != null)
            {
                com.picsart.effects.eyereplacer.c c1 = m;
                if (c1.j != null && !c1.j.isRecycled())
                {
                    com.socialin.android.util.c.a(c1.j);
                    c1.j = null;
                }
            }
            if (c != null)
            {
                EyeReplaceImageView eyereplaceimageview = c;
                if (eyereplaceimageview.b != null && !eyereplaceimageview.b.isRecycled())
                {
                    com.socialin.android.util.c.a(eyereplaceimageview.b);
                    eyereplaceimageview.b = null;
                }
            }
            (new ModernAsyncTask() {

                private EyeReplacerActivity a;

                protected final volatile Object doInBackground(Object aobj[])
                {
                    return null;
                }

                protected final void onPostExecute(Object obj)
                {
                    Log.e("ex1", "onStop onPostExecute");
                    if (EyeReplacerActivity.a(a) == null) goto _L2; else goto _L1
_L1:
                    obj = EyeReplacerActivity.a(a);
                    if (((a) (obj)).b == null || ((a) (obj)).k) goto _L4; else goto _L3
_L3:
                    ImageOpCommon.freeNativeBuffer(((a) (obj)).b);
                    obj.b = null;
_L6:
                    if (((a) (obj)).c != null && !((a) (obj)).c.isRecycled())
                    {
                        com.socialin.android.util.c.a(((a) (obj)).c, "EyeReplacer");
                        obj.c = null;
                    }
_L2:
                    return;
_L4:
                    if (((a) (obj)).k)
                    {
                        obj.l = true;
                    }
                    if (true) goto _L6; else goto _L5
_L5:
                }

            
            {
                a = EyeReplacerActivity.this;
                super();
            }
            }).executeOnExecutor(q, new Void[] {
                null
            });
            AnalyticUtils.getInstance(this).trackLocalAction("EyeReplacer:onDestroy");
        }
    }

}
