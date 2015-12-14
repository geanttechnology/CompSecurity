// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.colorsplash;

import android.app.ActivityManager;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ConfigurationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SlidingDrawer;
import android.widget.TextView;
import com.picsart.effects.redeyeremover.RedEyeRemoverActivity;
import com.picsart.effects.view.BrushStyleView;
import com.picsart.studio.PicsartContext;
import com.socialin.android.activity.AdBaseActivity;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.dialog.a;
import com.socialin.android.dialog.b;
import com.socialin.android.dialog.g;
import com.socialin.android.photo.imgop.ImageOp;
import com.socialin.android.photo.imgop.ImageOpCommon;
import com.socialin.android.util.Utils;
import com.socialin.android.util.c;
import com.socialin.android.util.w;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import myobfuscated.ay.e;
import myobfuscated.f.m;
import org.json.JSONArray;

// Referenced classes of package com.picsart.effects.colorsplash:
//            ColorSplashForegroundView, a, b, c, 
//            MyGLSurfaceView

public class ColorSplashActivity extends AdBaseActivity
    implements android.os.Handler.Callback
{

    private a A;
    private int B[] = {
        0x7f1001d7, 0x7f1001d9, 0x7f1001db, 0x7f1001dd, 0x7f1001df
    };
    private int C[] = {
        0x7f1001d8, 0x7f1001da, 0x7f1001dc, 0x7f1001de, 0x7f1001e0
    };
    private HandlerThread D;
    private Handler E;
    private boolean F;
    private boolean G;
    private Handler H;
    private android.view.View.OnClickListener I;
    private android.view.View.OnClickListener J;
    LinearLayout a;
    MyGLSurfaceView b;
    com.picsart.effects.colorsplash.a c;
    com.picsart.effects.colorsplash.b d;
    long e;
    ColorSplashForegroundView f;
    private String g;
    private int h;
    private LinearLayout i;
    private int j;
    private int k;
    private Point l;
    private int m;
    private String n;
    private HashMap o;
    private String p;
    private String q;
    private int r;
    private RelativeLayout s;
    private ByteBuffer t;
    private ByteBuffer u;
    private int v;
    private Bitmap w;
    private ByteBuffer x;
    private ByteBuffer y;
    private ProgressDialog z;

    public ColorSplashActivity()
    {
        g = (new StringBuilder()).append(com/picsart/effects/redeyeremover/RedEyeRemoverActivity.getSimpleName()).append("_").append(System.currentTimeMillis()).toString();
        h = -1;
        i = null;
        a = null;
        j = 0;
        k = 0;
        l = new Point();
        m = PicsartContext.a();
        n = null;
        p = null;
        q = null;
        r = 0;
        s = null;
        b = null;
        c = null;
        d = null;
        v = 0;
        w = null;
        x = null;
        y = null;
        z = null;
        A = null;
        F = false;
        G = false;
        H = new Handler() {

            final ColorSplashActivity a;

            public final void handleMessage(Message message)
            {
                switch (message.arg1)
                {
                default:
                    return;

                case 0: // '\0'
                    message.arg1 = -1;
                    a.runOnUiThread(new Runnable(this) {

                        private _cls1 a;

                        public final void run()
                        {
                            if (!a.a.isFinishing() && com.picsart.effects.colorsplash.ColorSplashActivity.a(a.a) != null)
                            {
                                Message message = com.picsart.effects.colorsplash.ColorSplashActivity.a(a.a).obtainMessage();
                                message.what = 1;
                                message.arg1 = 1;
                                com.picsart.effects.colorsplash.ColorSplashActivity.a(a.a).sendMessage(message);
                            }
                        }

            
            {
                a = _pcls1;
                super();
            }
                    });
                    return;

                case 1: // '\001'
                    (new Handler()).postDelayed(new Runnable(this) {

                        private _cls1 a;

                        public final void run()
                        {
                            com.picsart.effects.colorsplash.ColorSplashActivity.b(a.a).setVisibility(4);
                            com.picsart.effects.colorsplash.ColorSplashActivity.c(a.a).dismiss();
                        }

            
            {
                a = _pcls1;
                super();
            }
                    }, 100L);
                    break;
                }
                message.arg1 = -1;
            }

            
            {
                a = ColorSplashActivity.this;
                super();
            }
        };
        I = new android.view.View.OnClickListener() {

            private ColorSplashActivity a;

            public final void onClick(View view)
            {
                if (!ColorSplashActivity.d(a))
                {
                    ((ColorSplashForegroundView)a.findViewById(0x7f1002bc)).setBrushSizeIndex(((Integer)view.getTag()).intValue());
                    ((FrameLayout)view).setBackgroundResource(0x7f020556);
                    if (ColorSplashActivity.j(a) != null)
                    {
                        ColorSplashActivity.j(a).dismiss();
                        return;
                    }
                }
            }

            
            {
                a = ColorSplashActivity.this;
                super();
            }
        };
        J = new android.view.View.OnClickListener() {

            final ColorSplashActivity a;

            public final void onClick(View view)
            {
                if (!ColorSplashActivity.d(a))
                {
                    ColorSplashActivity.k(a);
                    if (com.picsart.effects.colorsplash.ColorSplashActivity.e(a) != null)
                    {
                        com.picsart.effects.colorsplash.ColorSplashActivity.e(a).setOrigBitmapAndCanvas(null, null);
                    }
                    a.findViewById(0x7f1001a8).setVisibility(8);
                    if (ColorSplashActivity.l(a).s != 0)
                    {
                        if (ColorSplashActivity.l(a).i == com.picsart.effects.colorsplash.ColorSplashActivity.m(a) && ColorSplashActivity.l(a).j == ColorSplashActivity.n(a))
                        {
                            if (!a.isFinishing() && com.picsart.effects.colorsplash.ColorSplashActivity.a(a) != null)
                            {
                                view = com.picsart.effects.colorsplash.ColorSplashActivity.a(a).obtainMessage();
                                view.what = 1;
                                view.arg1 = 0;
                                com.picsart.effects.colorsplash.ColorSplashActivity.a(a).sendMessage(view);
                                return;
                            }
                        } else
                        {
                            a.findViewById(0x7f100127).setVisibility(8);
                            com.picsart.effects.colorsplash.ColorSplashActivity.b(a).setVisibility(0);
                            (new Handler()).postDelayed(new Runnable(this) {

                                final _cls6 a;

                                public final void run()
                                {
                                    ColorSplashActivity.h(a.a).queueEvent(new Runnable(this) {

                                        final _cls1 a;

                                        public final void run()
                                        {
                                            a.a.a.runOnUiThread(new Runnable(this) {

                                                private _cls1 a;

                                                public final void run()
                                                {
                                                    Object obj = ColorSplashActivity.l(a.a.a.a);
                                                    obj.l = true;
                                                    obj.m = 0;
                                                    obj.k = 0;
                                                    obj = new android.widget.LinearLayout.LayoutParams(com.picsart.effects.colorsplash.ColorSplashActivity.m(a.a.a.a), ColorSplashActivity.n(a.a.a.a));
                                                    ColorSplashActivity.h(a.a.a.a).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
                                                }

            
            {
                a = _pcls1;
                super();
            }
                                            });
                                        }

            
            {
                a = _pcls1;
                super();
            }
                                    });
                                }

            
            {
                a = _pcls6;
                super();
            }
                            }, 200L);
                            if (com.picsart.effects.colorsplash.ColorSplashActivity.c(a) == null)
                            {
                                com.picsart.effects.colorsplash.ColorSplashActivity.a(a, new g(a));
                                com.picsart.effects.colorsplash.ColorSplashActivity.c(a).setMessage(a.getString(0x7f080679));
                                com.picsart.effects.colorsplash.ColorSplashActivity.c(a).setProgressStyle(0);
                            }
                            com.picsart.effects.colorsplash.ColorSplashActivity.c(a).show();
                            return;
                        }
                    } else
                    {
                        a.setResult(0);
                        a.finish();
                        return;
                    }
                }
            }

            
            {
                a = ColorSplashActivity.this;
                super();
            }
        };
    }

    static ProgressDialog a(ColorSplashActivity colorsplashactivity, ProgressDialog progressdialog)
    {
        colorsplashactivity.z = progressdialog;
        return progressdialog;
    }

    static Handler a(ColorSplashActivity colorsplashactivity)
    {
        return colorsplashactivity.E;
    }

    private void a(View view, int i1, int j1)
    {
        for (int k1 = 0; k1 < 5; k1++)
        {
            BrushStyleView brushstyleview = (BrushStyleView)view.findViewById(C[k1]);
            brushstyleview.setParams(i1, j1);
            brushstyleview.setBmpTag(g);
        }

    }

    static void a(ColorSplashActivity colorsplashactivity, View view)
    {
        ColorSplashForegroundView colorsplashforegroundview = (ColorSplashForegroundView)colorsplashactivity.findViewById(0x7f1002bc);
        ((FrameLayout)view.findViewById(colorsplashactivity.B[colorsplashforegroundview.h])).setBackgroundResource(0x7f020556);
        colorsplashactivity.a(view, 255, 100 - (int)(100F - colorsplashforegroundview.j));
        for (int i1 = 0; i1 < 5; i1++)
        {
            FrameLayout framelayout = (FrameLayout)view.findViewById(colorsplashactivity.B[i1]);
            framelayout.setTag(Integer.valueOf(i1));
            framelayout.setOnClickListener(colorsplashactivity.I);
        }

        view.findViewById(0x7f1001e2).setVisibility(8);
        view.findViewById(0x7f1001e1).setVisibility(8);
        SeekBar seekbar = (SeekBar)view.findViewById(0x7f1001e4);
        seekbar.setMax(100);
        seekbar.setProgress((int)(100F - colorsplashforegroundview.j));
        ((TextView)view.findViewById(0x7f1001e3)).setText((new StringBuilder()).append(colorsplashactivity.getString(0x7f080068)).append(" ").append((int)(100F - colorsplashforegroundview.j)).toString());
        seekbar.setOnSeekBarChangeListener(colorsplashactivity. new android.widget.SeekBar.OnSeekBarChangeListener(view) {

            private View a;
            private ColorSplashActivity b;

            public final void onProgressChanged(SeekBar seekbar1, int j1, boolean flag)
            {
                j1 = seekbar1.getProgress();
                ((TextView)a.findViewById(0x7f1001e3)).setText((new StringBuilder()).append(b.getString(0x7f080068)).append(" ").append(j1).toString());
                com.picsart.effects.colorsplash.ColorSplashActivity.a(b, a, com.picsart.effects.colorsplash.ColorSplashActivity.e(b).k, 100 - j1);
            }

            public final void onStartTrackingTouch(SeekBar seekbar1)
            {
            }

            public final void onStopTrackingTouch(SeekBar seekbar1)
            {
                com.picsart.effects.colorsplash.ColorSplashActivity.e(b).setHardness(seekbar1.getProgress());
            }

            
            {
                b = ColorSplashActivity.this;
                a = view;
                super();
            }
        });
    }

    static void a(ColorSplashActivity colorsplashactivity, View view, int i1, int j1)
    {
        colorsplashactivity.a(view, i1, j1);
    }

    static RelativeLayout b(ColorSplashActivity colorsplashactivity)
    {
        return colorsplashactivity.s;
    }

    private void b()
    {
        findViewById(0x7f1002b5).setBackgroundResource(0x7f0203b6);
        findViewById(0x7f1002b7).setBackgroundResource(0x7f0203b6);
        findViewById(0x7f1002b9).setBackgroundResource(0x7f0203b6);
        a(0x7f1002b4);
    }

    static ProgressDialog c(ColorSplashActivity colorsplashactivity)
    {
        return colorsplashactivity.z;
    }

    private void c()
    {
        Object obj;
        Object obj2;
        Log.e("ex1", "saveImageAndReturn");
        obj2 = c.p;
        ((ByteBuffer) (obj2)).position(0);
        ImageOpCommon.reverseBitmap(((java.nio.Buffer) (obj2)), j, k);
        int i1 = w.getWidth();
        w.getHeight();
        if (w != null && !w.isRecycled())
        {
            w.recycle();
        }
        w = null;
        f.b();
        ColorSplashForegroundView colorsplashforegroundview = f;
        int k1 = j;
        int l1 = k;
        Bitmap bitmap = com.socialin.android.util.c.a(k1, l1, android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawRect(new Rect(0, 0, k1, l1), colorsplashforegroundview.i);
        Matrix matrix = new Matrix();
        float f1 = (float)k1 / (float)i1;
        matrix.setScale(f1, f1);
        for (int j1 = 0; j1 < colorsplashforegroundview.e.size(); j1++)
        {
            Path path = (Path)colorsplashforegroundview.e.get(j1);
            path.transform(matrix);
            Paint paint = (Paint)colorsplashforegroundview.f.get(j1);
            paint.setStrokeWidth(paint.getStrokeWidth() * f1);
            float f2 = ((Float)colorsplashforegroundview.g.get(j1)).floatValue();
            BlurMaskFilter blurmaskfilter = null;
            if (f2 > 0.0F)
            {
                blurmaskfilter = new BlurMaskFilter((f2 * paint.getStrokeWidth()) / 100F, android.graphics.BlurMaskFilter.Blur.NORMAL);
            }
            paint.setMaskFilter(blurmaskfilter);
            canvas.drawPath(path, paint);
        }

        obj = ImageOpCommon.allocNativeBuffer(k1 * l1 * 4);
        ((ByteBuffer) (obj)).position(0);
        bitmap.copyPixelsToBuffer(((java.nio.Buffer) (obj)));
        if (bitmap != null && !bitmap.isRecycled())
        {
            bitmap.recycle();
        }
        ((ByteBuffer) (obj)).position(0);
        if (isFinishing()) goto _L2; else goto _L1
_L1:
        h;
        JVM INSTR tableswitch 0 1: default 400
    //                   0 661
    //                   1 691;
           goto _L3 _L4 _L5
_L3:
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        boolean flag1;
        ImageOpCommon.freeNativeBuffer(((ByteBuffer) (obj)));
        obj5 = null;
        obj3 = null;
        obj6 = null;
        obj4 = null;
        flag1 = false;
        if (isFinishing()) goto _L7; else goto _L6
_L6:
        Object obj1;
        Bitmap bitmap1;
        boolean flag;
        bitmap1 = com.socialin.android.util.c.a(j, k, android.graphics.Bitmap.Config.ARGB_8888);
        flag = flag1;
        obj = obj5;
        obj1 = obj6;
        if (bitmap1 == null) goto _L9; else goto _L8
_L8:
        ((ByteBuffer) (obj2)).position(0);
        bitmap1.copyPixelsFromBuffer(((java.nio.Buffer) (obj2)));
        Log.e("ex1", "resultBitmap != null");
        if (bitmap1.getWidth() != l.x) goto _L11; else goto _L10
_L10:
        obj2 = bitmap1;
        if (bitmap1.getHeight() == l.y) goto _L12; else goto _L11
_L11:
        Log.e("ex1", "resultBitmap.getWidth() != origBitmapSize.x || resultBitmap.getHeight() != origBitmapSize.y");
        obj2 = com.socialin.android.util.c.a(bitmap1, l.x, l.y, false);
        com.socialin.android.util.c.a(bitmap1);
_L12:
        flag = flag1;
        obj = obj5;
        obj1 = obj6;
        if (obj2 != null)
        {
            Log.e("ex1", "scaledBitmap != null");
            if (p != null)
            {
                obj = new File(p);
                com.socialin.android.util.w.a(((File) (obj)), ((Bitmap) (obj2)), android.graphics.Bitmap.CompressFormat.PNG, this);
                obj1 = obj4;
            } else
            {
                obj = obj3;
                obj1 = obj4;
                if (q != null)
                {
                    obj1 = com.socialin.android.util.w.a(q, ((Bitmap) (obj2)));
                    obj = obj3;
                }
            }
            if (obj2 != null && !((Bitmap) (obj2)).isRecycled())
            {
                com.socialin.android.util.c.a(((Bitmap) (obj2)));
            }
            flag = true;
        }
_L9:
        if (!isFinishing())
        {
            runOnUiThread(new Runnable(flag, ((File) (obj)), ((HashMap) (obj1))) {

                private boolean a;
                private File b;
                private HashMap c;
                private ColorSplashActivity d;

                public final void run()
                {
                    if (com.picsart.effects.colorsplash.ColorSplashActivity.c(d) != null && com.picsart.effects.colorsplash.ColorSplashActivity.c(d).isShowing())
                    {
                        com.picsart.effects.colorsplash.ColorSplashActivity.c(d).dismiss();
                    }
                    if (!a)
                    {
                        Utils.a(d, 0x7f08024e);
                    }
                    Intent intent = new Intent();
                    boolean flag2;
                    if (b != null)
                    {
                        intent.putExtra("path", b.getAbsolutePath());
                    } else
                    if (c != null)
                    {
                        intent.putExtra("result_buffer_Data", c);
                    }
                    intent.putExtra("effects_dynamic_processing_time", System.currentTimeMillis() - d.e);
                    if (!com.picsart.effects.colorsplash.ColorSplashActivity.g(d).b.m.f)
                    {
                        flag2 = true;
                    } else
                    {
                        flag2 = false;
                    }
                    intent.putExtra("effects_default_settings_changed", flag2);
                    com.picsart.effects.colorsplash.ColorSplashActivity.g(d).b.c();
                    intent.putExtra("effects_color_splash_options", com.picsart.effects.colorsplash.ColorSplashActivity.g(d).b.c().toString());
                    d.setResult(-1, intent);
                    d.finish();
                }

            
            {
                d = ColorSplashActivity.this;
                a = flag;
                b = file;
                c = hashmap;
                super();
            }
            });
        }
_L7:
        return;
_L4:
        t.position(0);
        ImageOpCommon.changeBufferWithMask(t, ((java.nio.Buffer) (obj)), ((java.nio.Buffer) (obj2)), j, k);
        continue; /* Loop/switch isn't completed */
_L5:
        obj1 = ImageOpCommon.allocNativeBuffer(t.capacity());
        ((ByteBuffer) (obj1)).position(0);
        t.position(0);
        d.b.f;
        JVM INSTR tableswitch 0 1: default 752
    //                   0 783
    //                   1 803;
           goto _L13 _L14 _L15
_L13:
        break; /* Loop/switch isn't completed */
_L14:
        break; /* Loop/switch isn't completed */
_L17:
        ((ByteBuffer) (obj1)).position(0);
        ImageOpCommon.changeBufferWithMask(((java.nio.Buffer) (obj1)), ((java.nio.Buffer) (obj)), ((java.nio.Buffer) (obj2)), j, k);
        ImageOpCommon.freeNativeBuffer(((ByteBuffer) (obj1)));
        if (true) goto _L3; else goto _L16
_L16:
        ImageOpCommon.grayscale(t, ((java.nio.Buffer) (obj1)), j, k);
          goto _L17
_L15:
        ImageOpCommon.sepia(t, ((java.nio.Buffer) (obj1)), j, k);
          goto _L17
_L2:
        ImageOpCommon.freeNativeBuffer(((ByteBuffer) (obj)));
        return;
    }

    static boolean d(ColorSplashActivity colorsplashactivity)
    {
        return colorsplashactivity.G;
    }

    static ColorSplashForegroundView e(ColorSplashActivity colorsplashactivity)
    {
        return colorsplashactivity.f;
    }

    static boolean f(ColorSplashActivity colorsplashactivity)
    {
        return colorsplashactivity.F;
    }

    static com.picsart.effects.colorsplash.b g(ColorSplashActivity colorsplashactivity)
    {
        return colorsplashactivity.d;
    }

    static MyGLSurfaceView h(ColorSplashActivity colorsplashactivity)
    {
        return colorsplashactivity.b;
    }

    static void i(ColorSplashActivity colorsplashactivity)
    {
        b b1 = new b();
        b1.a = colorsplashactivity.getString(0x7f0805fb);
        b1.f = 0x7f030046;
        b1.h = false;
        b1.p = colorsplashactivity. new com.socialin.android.dialog.c() {

            private ColorSplashActivity a;

            public final void onViewCreated(View view, DialogFragment dialogfragment)
            {
                com.picsart.effects.colorsplash.ColorSplashActivity.a(a, view);
            }

            
            {
                a = ColorSplashActivity.this;
                super();
            }
        };
        colorsplashactivity.A = b1.a();
        colorsplashactivity.A.show(colorsplashactivity.getFragmentManager(), null);
    }

    static a j(ColorSplashActivity colorsplashactivity)
    {
        return colorsplashactivity.A;
    }

    static boolean k(ColorSplashActivity colorsplashactivity)
    {
        colorsplashactivity.G = true;
        return true;
    }

    static com.picsart.effects.colorsplash.a l(ColorSplashActivity colorsplashactivity)
    {
        return colorsplashactivity.c;
    }

    static int m(ColorSplashActivity colorsplashactivity)
    {
        return colorsplashactivity.j;
    }

    static int n(ColorSplashActivity colorsplashactivity)
    {
        return colorsplashactivity.k;
    }

    static void o(ColorSplashActivity colorsplashactivity)
    {
        Object obj;
        Object obj1;
        obj = null;
        if (colorsplashactivity.z != null && colorsplashactivity.z.isShowing())
        {
            colorsplashactivity.z.dismiss();
        }
        RelativeLayout relativelayout;
        int i1;
        int j1;
        int k1;
        if (((ActivityManager)colorsplashactivity.getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion >= 0x20000)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        j1 = android.os.Build.VERSION.SDK_INT;
        if (i1 == 0 || j1 < 8) goto _L2; else goto _L1
_L1:
        relativelayout = (RelativeLayout)colorsplashactivity.findViewById(0x7f1001ab);
        colorsplashactivity.getResources().getConfiguration().orientation;
        JVM INSTR tableswitch 1 2: default 112
    //                   1 647
    //                   2 682;
           goto _L3 _L4 _L5
_L3:
        obj1 = null;
_L6:
        ((SlidingDrawer) (obj1)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        relativelayout.addView(((View) (obj1)));
        colorsplashactivity.d = new com.picsart.effects.colorsplash.b(colorsplashactivity, colorsplashactivity.h);
        obj = new android.widget.LinearLayout.LayoutParams(-1, -1);
        colorsplashactivity.c = new com.picsart.effects.colorsplash.a(colorsplashactivity, colorsplashactivity.H, colorsplashactivity.d);
        colorsplashactivity.b = new MyGLSurfaceView(colorsplashactivity, colorsplashactivity.c);
        colorsplashactivity.b.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        colorsplashactivity.i = (LinearLayout)colorsplashactivity.findViewById(0x7f1000ef);
        colorsplashactivity.a = (LinearLayout)colorsplashactivity.findViewById(0x7f10057d);
        colorsplashactivity.i.addView(colorsplashactivity.b);
        colorsplashactivity.findViewById(0x7f1002bb).setEnabled(false);
        colorsplashactivity.findViewById(0x7f1002bb).setOnClickListener(colorsplashactivity.J);
        colorsplashactivity.findViewById(0x7f1001a8).setOnClickListener(colorsplashactivity. new android.view.View.OnClickListener() {

            private ColorSplashActivity a;

            public final void onClick(View view)
            {
                if (ColorSplashActivity.d(a))
                {
                    return;
                } else
                {
                    a.c(true);
                    return;
                }
            }

            
            {
                a = ColorSplashActivity.this;
                super();
            }
        });
        colorsplashactivity.f = (ColorSplashForegroundView)colorsplashactivity.findViewById(0x7f1002bc);
        colorsplashactivity.f.setGlSurfaceView(colorsplashactivity.b);
        obj = new DisplayMetrics();
        colorsplashactivity.getWindowManager().getDefaultDisplay().getMetrics(((DisplayMetrics) (obj)));
        colorsplashactivity.s = (RelativeLayout)colorsplashactivity.findViewById(0x7f1002bd);
        colorsplashactivity.f.setOrigBitmap(colorsplashactivity.w, colorsplashactivity.x, colorsplashactivity.y);
        obj = colorsplashactivity.c;
        obj1 = colorsplashactivity.u;
        i1 = colorsplashactivity.j;
        j1 = colorsplashactivity.k;
        k1 = colorsplashactivity.v;
        obj.d = 0.0F;
        obj.e = 0.0F;
        obj.c = k1;
        obj.f = ((com.picsart.effects.colorsplash.a) (obj)).c;
        obj.a = i1;
        obj.b = j1;
        obj.o = ((ByteBuffer) (obj1));
        ((com.picsart.effects.colorsplash.a) (obj)).o.position(0);
        colorsplashactivity.c.s = 0;
        colorsplashactivity.c.t = colorsplashactivity. new Runnable() {

            private ColorSplashActivity a;

            public final void run()
            {
                com.picsart.effects.colorsplash.ColorSplashActivity.e(a).a(false);
            }

            
            {
                a = ColorSplashActivity.this;
                super();
            }
        };
        colorsplashactivity.b.requestRender();
        colorsplashactivity.f.setRenderer(colorsplashactivity.c);
        colorsplashactivity.f.invalidate();
        colorsplashactivity.findViewById(0x7f1002ba).setOnClickListener(colorsplashactivity. new android.view.View.OnClickListener() {

            private ColorSplashActivity a;

            public final void onClick(View view)
            {
                if (!ColorSplashActivity.d(a))
                {
                    view = a.findViewById(0x7f100133);
                    if (view.getVisibility() != 0)
                    {
                        view.startAnimation(AnimationUtils.loadAnimation(a, 0x7f040017));
                        view.setVisibility(0);
                        return;
                    }
                    if (view.getVisibility() != 8)
                    {
                        view.startAnimation(AnimationUtils.loadAnimation(a, 0x7f040016));
                        view.setVisibility(8);
                        return;
                    }
                }
            }

            
            {
                a = ColorSplashActivity.this;
                super();
            }
        });
        obj = colorsplashactivity. new android.view.View.OnClickListener() {

            private ColorSplashActivity a;

            public final void onClick(View view)
            {
                if (ColorSplashActivity.d(a))
                {
                    return;
                }
                ColorSplashForegroundView colorsplashforegroundview = (ColorSplashForegroundView)a.findViewById(0x7f1002bc);
                if (view.getId() == 0x7f10018e)
                {
                    ((CompoundButton)a.findViewById(0x7f10018d)).setChecked(false);
                    ((CompoundButton)a.findViewById(0x7f10018e)).setChecked(true);
                    colorsplashforegroundview.setDrawMode(true);
                    return;
                } else
                {
                    ((CompoundButton)a.findViewById(0x7f10018d)).setChecked(true);
                    ((CompoundButton)a.findViewById(0x7f10018e)).setChecked(false);
                    colorsplashforegroundview.setDrawMode(false);
                    return;
                }
            }

            
            {
                a = ColorSplashActivity.this;
                super();
            }
        };
        colorsplashactivity.findViewById(0x7f10018d).setOnClickListener(((android.view.View.OnClickListener) (obj)));
        colorsplashactivity.findViewById(0x7f10018e).setOnClickListener(((android.view.View.OnClickListener) (obj)));
        colorsplashactivity.findViewById(0x7f10018b).setOnClickListener(colorsplashactivity. new android.view.View.OnClickListener() {

            private ColorSplashActivity a;

            public final void onClick(View view)
            {
                if (!ColorSplashActivity.d(a)) goto _L2; else goto _L1
_L1:
                return;
_L2:
                boolean flag;
                view = (ColorSplashForegroundView)a.findViewById(0x7f1002bc);
                if (((ColorSplashForegroundView) (view)).e.size() <= 0)
                {
                    break; /* Loop/switch isn't completed */
                }
                ((ColorSplashForegroundView) (view)).e.remove(((ColorSplashForegroundView) (view)).e.size() - 1);
                ((ColorSplashForegroundView) (view)).f.remove(((ColorSplashForegroundView) (view)).f.size() - 1);
                ((ColorSplashForegroundView) (view)).g.remove(((ColorSplashForegroundView) (view)).g.size() - 1);
                if (((ColorSplashForegroundView) (view)).d != null && ((ColorSplashForegroundView) (view)).c != null && !((ColorSplashForegroundView) (view)).c.isRecycled())
                {
                    ((ColorSplashForegroundView) (view)).d.drawRect(new Rect(0, 0, ((ColorSplashForegroundView) (view)).c.getWidth(), ((ColorSplashForegroundView) (view)).c.getHeight()), ((ColorSplashForegroundView) (view)).i);
                    for (int l1 = 0; l1 < ((ColorSplashForegroundView) (view)).e.size(); l1++)
                    {
                        Path path = (Path)((ColorSplashForegroundView) (view)).e.get(l1);
                        Paint paint = (Paint)((ColorSplashForegroundView) (view)).f.get(l1);
                        ((ColorSplashForegroundView) (view)).d.drawPath(path, paint);
                    }

                }
                view.invalidate();
                if (((ColorSplashForegroundView) (view)).e.size() <= 0)
                {
                    break; /* Loop/switch isn't completed */
                }
                flag = true;
_L4:
                if (!flag)
                {
                    a.b(false);
                    return;
                }
                if (true) goto _L1; else goto _L3
_L3:
                flag = false;
                  goto _L4
                if (true) goto _L1; else goto _L5
_L5:
            }

            
            {
                a = ColorSplashActivity.this;
                super();
            }
        });
        colorsplashactivity.findViewById(0x7f10018c).setOnClickListener(colorsplashactivity. new android.view.View.OnClickListener() {

            private ColorSplashActivity a;

            public final void onClick(View view)
            {
                if (ColorSplashActivity.d(a))
                {
                    return;
                } else
                {
                    ((ColorSplashForegroundView)a.findViewById(0x7f1002bc)).a();
                    a.b(false);
                    return;
                }
            }

            
            {
                a = ColorSplashActivity.this;
                super();
            }
        });
        colorsplashactivity.findViewById(0x7f100136).setOnClickListener(colorsplashactivity. new android.view.View.OnClickListener() {

            private ColorSplashActivity a;

            public final void onClick(View view)
            {
                if (ColorSplashActivity.d(a))
                {
                    return;
                } else
                {
                    ColorSplashActivity.i(a);
                    return;
                }
            }

            
            {
                a = ColorSplashActivity.this;
                super();
            }
        });
        colorsplashactivity.b(false);
        obj = colorsplashactivity. new android.view.View.OnClickListener() {

            private ColorSplashActivity a;

            public final void onClick(View view)
            {
                boolean flag = true;
                if (ColorSplashActivity.f(a) && !ColorSplashActivity.d(a))
                {
                    int l1;
                    int i2;
                    if (view.getId() == 0x7f1002b5)
                    {
                        l1 = 0x7f1002b4;
                        i2 = 0;
                    } else
                    if (view.getId() == 0x7f1002b7)
                    {
                        l1 = 0x7f1002b6;
                        i2 = 1;
                    } else
                    if (view.getId() == 0x7f1002b9)
                    {
                        i2 = 2;
                        l1 = 0x7f1002b8;
                    } else
                    {
                        l1 = 0;
                        i2 = 0;
                    }
                    if (com.picsart.effects.colorsplash.ColorSplashActivity.g(a) != null && com.picsart.effects.colorsplash.ColorSplashActivity.g(a).b != null)
                    {
                        a.a(l1);
                        com.picsart.effects.colorsplash.ColorSplashActivity.g(a).b.b(i2);
                        view = com.picsart.effects.colorsplash.ColorSplashActivity.g(a).b;
                        if (((com.picsart.effects.colorsplash.c) (view)).h[((com.picsart.effects.colorsplash.c) (view)).l] > 0.0F)
                        {
                            l1 = ((flag) ? 1 : 0);
                        } else
                        {
                            l1 = 0;
                        }
                        if (l1 == 0)
                        {
                            a.c(false);
                            return;
                        }
                    }
                }
            }

            
            {
                a = ColorSplashActivity.this;
                super();
            }
        };
        colorsplashactivity.b();
        colorsplashactivity.findViewById(0x7f1002b5).setOnClickListener(((android.view.View.OnClickListener) (obj)));
        colorsplashactivity.findViewById(0x7f1002b7).setOnClickListener(((android.view.View.OnClickListener) (obj)));
        colorsplashactivity.findViewById(0x7f1002b9).setOnClickListener(((android.view.View.OnClickListener) (obj)));
        colorsplashactivity.F = true;
        return;
_L4:
        obj1 = (SlidingDrawer)colorsplashactivity.getLayoutInflater().inflate(0x7f030189, null);
        obj = new android.widget.RelativeLayout.LayoutParams(-1, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(12);
        continue; /* Loop/switch isn't completed */
_L5:
        obj1 = (SlidingDrawer)colorsplashactivity.getLayoutInflater().inflate(0x7f030148, null);
        obj = new android.widget.RelativeLayout.LayoutParams((int)TypedValue.applyDimension(1, 320F, colorsplashactivity.getResources().getDisplayMetrics()), -1);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(11);
        if (true) goto _L6; else goto _L2
_L2:
        colorsplashactivity.finish();
        return;
    }

    static ByteBuffer p(ColorSplashActivity colorsplashactivity)
    {
        return colorsplashactivity.u;
    }

    static ByteBuffer q(ColorSplashActivity colorsplashactivity)
    {
        colorsplashactivity.u = null;
        return null;
    }

    public final void a()
    {
        runOnUiThread(new Runnable() {

            private ColorSplashActivity a;

            public final void run()
            {
                ColorSplashActivity.h(a).requestRender();
            }

            
            {
                a = ColorSplashActivity.this;
                super();
            }
        });
    }

    public final void a(int i1)
    {
        findViewById(0x7f1002b4).setBackgroundResource(0x7f020582);
        findViewById(0x7f1002b6).setBackgroundResource(0x7f020582);
        findViewById(0x7f1002b8).setBackgroundResource(0x7f020582);
        findViewById(i1).setBackgroundResource(0x7f020583);
    }

    final void a(boolean flag)
    {
        if (flag)
        {
            findViewById(0x7f1002ba).setEnabled(true);
            return;
        } else
        {
            findViewById(0x7f1002ba).setEnabled(false);
            findViewById(0x7f100133).setVisibility(8);
            return;
        }
    }

    public final void b(int i1)
    {
        if (f != null)
        {
            f.setSplashMode(i1);
        }
        b.requestRender();
    }

    public final void b(boolean flag)
    {
        findViewById(0x7f10018c).setEnabled(flag);
        findViewById(0x7f10018b).setEnabled(flag);
    }

    public final void c(boolean flag)
    {
        c.s = 0;
        a.removeAllViews();
        findViewById(0x7f1001ab).setVisibility(8);
        findViewById(0x7f1001a8).setEnabled(false);
        findViewById(0x7f1002bb).setEnabled(false);
        a(false);
        b.requestRender();
        Object obj = findViewById(0x7f1002bc);
        if (obj != null)
        {
            obj = (ColorSplashForegroundView)obj;
            obj.m = false;
            obj.l = false;
            ((ColorSplashForegroundView) (obj)).a(true);
        }
        if (flag)
        {
            if (d != null && d.b != null)
            {
                d.b.a();
            }
            b();
            ((ColorSplashForegroundView)findViewById(0x7f1002bc)).a();
            b(false);
            findViewById(0x7f10018e).performClick();
        }
    }

    protected ViewGroup getAdLayout()
    {
        return (RelativeLayout)findViewById(0x7f100128);
    }

    public boolean handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 0 2: default 32
    //                   0 34
    //                   1 1376
    //                   2 1212;
           goto _L1 _L2 _L3 _L4
_L1:
        return false;
_L2:
        message = getIntent().getExtras();
        m = message.getInt("maxPixel", PicsartContext.a());
        Log.e("ex1", (new StringBuilder("ColorSplashActivity pixelsMaxCount = ")).append(m).toString());
        p = getIntent().getExtras().getString("saveToPath", null);
        q = getIntent().getExtras().getString("buffer_to_save", null);
        n = getIntent().getExtras().getString("path");
        if (message.containsKey("degree"))
        {
            r = message.getInt("degree");
        }
        if (getIntent().hasExtra("bufferData"))
        {
            o = (HashMap)getIntent().getSerializableExtra("bufferData");
        }
        h = message.getInt("effectMode");
        u = null;
        message = myobfuscated.ay.e.a(n, r, o, m);
        Object obj;
        obj = message;
        if (message == null)
        {
            break MISSING_BLOCK_LABEL_648;
        }
        Object obj1;
        int l1;
        Log.e("ex1", (new StringBuilder("ColorSplash imageBitmap size w = ")).append(message.getWidth()).append(" h = ").append(message.getHeight()).toString());
        l = new Point(message.getWidth(), message.getHeight());
        Log.e("ex1", (new StringBuilder("origBitmapSize w = ")).append(l.x).toString());
        Log.e("ex1", (new StringBuilder("origBitmapSize h = ")).append(l.y).toString());
        obj = com.socialin.android.util.w.a(l);
        obj1 = new com.socialin.android.util.a(this);
        l1 = ((com.socialin.android.util.a) (obj1)).a();
        int i1 = l1;
        if (l1 != 0) goto _L6; else goto _L5
_L5:
        Log.e("ex1", "textureMaxSize == 0");
        i1 = myobfuscated.f.m.a();
        if (i1 <= 0) goto _L8; else goto _L7
_L7:
        ((com.socialin.android.util.a) (obj1)).a(i1);
_L8:
        Log.e("ex1", (new StringBuilder("textureMaxSize = ")).append(i1).toString());
_L6:
        obj1 = obj;
        if (i1 <= 0)
        {
            break MISSING_BLOCK_LABEL_475;
        }
        if (((Point) (obj)).x > i1) goto _L10; else goto _L9
_L9:
        obj1 = obj;
        if (((Point) (obj)).y <= i1)
        {
            break MISSING_BLOCK_LABEL_475;
        }
_L10:
        obj1 = myobfuscated.ay.e.a(((Point) (obj)).x, ((Point) (obj)).y, i1);
        if (obj1 == null) goto _L12; else goto _L11
_L11:
        Log.e("ex1", (new StringBuilder("previewSize w = ")).append(((Point) (obj1)).x).toString());
        Log.e("ex1", (new StringBuilder("previewSize h = ")).append(((Point) (obj1)).y).toString());
_L12:
        obj = message;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_648;
        }
        if (((Point) (obj1)).x != l.x) goto _L14; else goto _L13
_L13:
        obj = message;
        if (((Point) (obj1)).y == l.y)
        {
            break MISSING_BLOCK_LABEL_648;
        }
_L14:
        obj1 = com.socialin.android.util.c.a(message, ((Point) (obj1)).x, ((Point) (obj1)).y, false);
        com.socialin.android.util.c.a(message);
        if (obj1 == null) goto _L16; else goto _L15
_L15:
        Log.e("ex1", (new StringBuilder("scaledBitmap w = ")).append(((Bitmap) (obj1)).getWidth()).toString());
        Log.e("ex1", (new StringBuilder("scaledBitmap h = ")).append(((Bitmap) (obj1)).getHeight()).toString());
_L16:
        obj = obj1;
        message = ((Message) (obj));
_L18:
        if (message == null)
        {
            runOnUiThread(new Runnable() {

                private ColorSplashActivity a;

                public final void run()
                {
                    Utils.a(a, 0x7f08024e);
                }

            
            {
                a = ColorSplashActivity.this;
                super();
            }
            });
            finish();
            return false;
        }
        break; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        message = null;
_L19:
        exception.printStackTrace();
        if (true) goto _L18; else goto _L17
_L17:
        j = message.getWidth();
        k = message.getHeight();
        v = Math.max(j, k);
        int j1 = v;
        if (j1 != 0 && (j1 & j1 - 1) == 0)
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        if (j1 == 0)
        {
            j1 = v;
            if (j1 == 0)
            {
                j1 = 1;
            } else
            {
                j1--;
                j1 |= j1 >> 1;
                j1 |= j1 >> 2;
                j1 |= j1 >> 4;
                j1 |= j1 >> 8;
                j1 = (j1 | j1 >> 16) + 1;
            }
            v = j1;
        }
        u = ImageOpCommon.allocNativeBuffer(v * v * 4);
        t = ImageOpCommon.allocNativeBuffer(j * k * 4);
        t.position(0);
        message.copyPixelsToBuffer(t);
        if (message.getWidth() > 640 || message.getWidth() > 640)
        {
            w = com.socialin.android.util.w.a(message, 640, 640);
        } else
        {
            w = message.copy(android.graphics.Bitmap.Config.ARGB_8888, true);
        }
        if (w == null || w.isRecycled())
        {
            if (u != null)
            {
                ImageOpCommon.freeNativeBuffer(u);
                u = null;
            }
            runOnUiThread(new Runnable() {

                private ColorSplashActivity a;

                public final void run()
                {
                    Utils.b(a, 0x7f080429);
                    a.finish();
                }

            
            {
                a = ColorSplashActivity.this;
                super();
            }
            });
            return false;
        }
        if (h == 1)
        {
            ByteBuffer bytebuffer = ImageOpCommon.allocNativeBuffer(w.getWidth() * w.getHeight() * 4);
            x = ImageOpCommon.allocNativeBuffer(bytebuffer.capacity());
            w.copyPixelsToBuffer(bytebuffer);
            bytebuffer.position(0);
            ImageOpCommon.grayscale(bytebuffer, x, w.getWidth(), w.getHeight());
            x.position(0);
            w.copyPixelsFromBuffer(x);
            y = ImageOpCommon.allocNativeBuffer(bytebuffer.capacity());
            bytebuffer.position(0);
            y.position(0);
            ImageOpCommon.sepia(bytebuffer, y, w.getWidth(), w.getHeight());
            y.position(0);
            ImageOpCommon.freeNativeBuffer(bytebuffer);
        }
        com.socialin.android.util.c.a(message);
        u.position(0);
        t.position(0);
        ImageOpCommon.getPowerOfTwoSizeBuffer(t, u, j, k, v, 0xff000000);
        u.position(0);
        runOnUiThread(new Runnable() {

            private ColorSplashActivity a;

            public final void run()
            {
                if (!a.isFinishing())
                {
                    ColorSplashActivity.o(a);
                } else
                if (ColorSplashActivity.p(a) != null)
                {
                    ImageOpCommon.freeNativeBuffer(ColorSplashActivity.p(a));
                    ColorSplashActivity.q(a);
                    return;
                }
            }

            
            {
                a = ColorSplashActivity.this;
                super();
            }
        });
        return false;
_L4:
        if (t != null)
        {
            ImageOpCommon.freeNativeBuffer(t);
            t = null;
        }
        if (x != null)
        {
            ImageOpCommon.freeNativeBuffer(x);
            x = null;
        }
        if (y != null)
        {
            ImageOpCommon.freeNativeBuffer(y);
            y = null;
        }
        if (f != null)
        {
            f.b();
        }
        if (w != null && !w.isRecycled())
        {
            w.recycle();
        }
        w = null;
        if (c != null)
        {
            message = c;
            if (((com.picsart.effects.colorsplash.a) (message)).p != null)
            {
                ImageOp.a(((com.picsart.effects.colorsplash.a) (message)).p);
                message.p = null;
            }
            if (((com.picsart.effects.colorsplash.a) (message)).o != null)
            {
                ImageOp.a(((com.picsart.effects.colorsplash.a) (message)).o);
                message.o = null;
            }
        }
        runOnUiThread(new Runnable() {

            private ColorSplashActivity a;

            public final void run()
            {
                if (com.picsart.effects.colorsplash.ColorSplashActivity.a(a) != null)
                {
                    Looper looper = com.picsart.effects.colorsplash.ColorSplashActivity.a(a).getLooper();
                    if (looper != null)
                    {
                        looper.quit();
                    }
                }
            }

            
            {
                a = ColorSplashActivity.this;
                super();
            }
        });
        return false;
_L3:
        int k1 = message.arg1;
        c();
        return false;
        bytebuffer;
          goto _L19
        bytebuffer;
        message = ((Message) (obj1));
          goto _L19
    }

    public void onClose(View view)
    {
        setResult(0);
        finish();
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        Object obj = null;
        if (!F) goto _L2; else goto _L1
_L1:
        RelativeLayout relativelayout;
        boolean flag;
        flag = ((SlidingDrawer)findViewById(0x7f10057c)).isOpened();
        a.removeAllViews();
        relativelayout = (RelativeLayout)findViewById(0x7f1001ab);
        relativelayout.removeAllViews();
        configuration.orientation;
        JVM INSTR tableswitch 1 2: default 76
    //                   1 143
    //                   2 178;
           goto _L3 _L4 _L5
_L3:
        Object obj1 = null;
_L7:
        ((SlidingDrawer) (obj1)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        relativelayout.addView(((View) (obj1)));
        a = (LinearLayout)findViewById(0x7f10057d);
        if (relativelayout.getVisibility() == 0)
        {
            a.addView(d.b.e);
            if (flag)
            {
                ((SlidingDrawer) (obj1)).open();
            }
        }
_L2:
        super.onConfigurationChanged(configuration);
        return;
_L4:
        obj1 = (SlidingDrawer)getLayoutInflater().inflate(0x7f030189, null);
        obj = new android.widget.RelativeLayout.LayoutParams(-1, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(12);
        continue; /* Loop/switch isn't completed */
_L5:
        obj1 = (SlidingDrawer)getLayoutInflater().inflate(0x7f030148, null);
        obj = new android.widget.RelativeLayout.LayoutParams((int)TypedValue.applyDimension(1, 320F, getResources().getDisplayMetrics()), -1);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(11);
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        e = System.currentTimeMillis();
        AnalyticUtils.getInstance(this).trackLocalAction("ColorSplash:onCreate");
        setContentView(0x7f030072);
        ((ColorSplashForegroundView)findViewById(0x7f1002bc)).setLayerType(1, null);
        bundle = getSupportActionBar();
        if (bundle != null)
        {
            bundle.hide();
        }
        if (D == null)
        {
            D = new HandlerThread("color_splash_thread");
            D.start();
            E = new Handler(D.getLooper(), this);
            bundle = E.obtainMessage();
            bundle.what = 0;
            E.sendMessage(bundle);
        }
        if (z == null)
        {
            z = new g(this);
            z.setMessage(getString(0x7f080679));
            z.setProgressStyle(0);
        }
        z.show();
        initAd();
    }

    protected void onStop()
    {
        super.onStop();
        if (isFinishing())
        {
            Log.e("ex1", "Colorplash onStop isFinishing");
            AnalyticUtils.getInstance(this).trackLocalAction("ColorSplash:onDestroy");
            if (f != null)
            {
                f.b = ColorSplashForegroundView.PickerState.CLOSED;
                f.setBuffers(null, null);
                f.setOrigBitmapAndCanvas(null, null);
            }
            if (E != null)
            {
                Message message = E.obtainMessage();
                message.what = 2;
                E.sendMessage(message);
            }
        }
    }

    // Unreferenced inner class com/picsart/effects/colorsplash/ColorSplashActivity$8

/* anonymous class */
    final class _cls8
        implements Runnable
    {

        private ColorSplashActivity a;

        public final void run()
        {
            com.picsart.effects.colorsplash.ColorSplashActivity.e(a).invalidate();
        }

            
            {
                a = ColorSplashActivity.this;
                super();
            }
    }

}
