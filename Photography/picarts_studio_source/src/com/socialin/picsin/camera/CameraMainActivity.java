// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.hardware.Camera;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.net.Uri;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.RotateAnimation;
import android.webkit.MimeTypeMap;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ViewFlipper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.apiv3.exception.ExceptionReportService;
import com.socialin.android.apiv3.model.ImageItem;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.d;
import com.socialin.android.dialog.g;
import com.socialin.android.photo.imgop.ImageOpCommon;
import com.socialin.android.photo.imgop.ImageResize;
import com.socialin.android.util.FileUtils;
import com.socialin.android.util.Utils;
import com.socialin.android.util.o;
import com.socialin.android.util.w;
import com.socialin.android.util.x;
import com.socialin.camera.opengl.CameraOpenGlSurfaceView;
import com.socialin.camera.opengl.a;
import com.socialin.camera.opengl.ac;
import com.socialin.camera.opengl.h;
import com.socialin.camera.opengl.n;
import com.socialin.picsin.camera.view.CameraFocusRectView;
import com.socialin.picsin.camera.view.CameraViewCupcake;
import com.socialin.picsin.camera.view.CameraViewGingerbread;
import com.socialin.picsin.camera.view.ColorSplashForegroundView;
import com.socialin.picsin.camera.view.CustomVerticalSeekBar;
import com.socialin.picsin.camera.view.RotateImageView;
import com.socialin.picsin.camera.view.c;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import myobfuscated.db.b;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.picsin.camera:
//            j, n, CameraShutter, b, 
//            e, f, a, m, 
//            i, h, o, d, 
//            c

public class CameraMainActivity extends BaseActivity
    implements android.hardware.Camera.PictureCallback, android.hardware.Camera.ShutterCallback, android.os.Handler.Callback, android.view.SurfaceHolder.Callback, android.view.View.OnClickListener, android.view.View.OnLongClickListener, android.widget.AdapterView.OnItemClickListener, android.widget.RadioGroup.OnCheckedChangeListener, android.widget.SeekBar.OnSeekBarChangeListener, j, com.socialin.picsin.camera.n, b
{

    private static int t = 111;
    private boolean A;
    private boolean B;
    private Handler C;
    private Bitmap D;
    private String E;
    private int F;
    private long G;
    private String H;
    private boolean I;
    private boolean J;
    private int K;
    private int L;
    private HandlerThread M;
    private Handler N;
    private Point O;
    private AlertDialog P;
    private int Q;
    private CameraFocusRectView R;
    private float S;
    private int T[] = {
        0x7f10020a, 0x7f10020b, 0x7f10020c, 0x7f10020d, 0x7f10020e, 0x7f1001fe, 0x7f100231, 0x7f100230, 0x7f10022f, 0x7f10022e
    };
    private ArrayList U;
    private GoogleApiClient V;
    private RelativeLayout W;
    public c a;
    public g b;
    CameraShutter c;
    public com.socialin.picsin.camera.d d;
    public myobfuscated.de.b e;
    public a f;
    public h g;
    public CameraOpenGlSurfaceView h;
    public Bitmap i;
    public volatile long j;
    public boolean k;
    public boolean l;
    public boolean m;
    public myobfuscated.db.a n;
    com.socialin.picsin.camera.m o;
    private String p[];
    private SettingsListAdapter q;
    private boolean r;
    private String s;
    private String u;
    private Object v;
    private int w;
    private int x;
    private OrientationEventListener y;
    private boolean z;

    public CameraMainActivity()
    {
        r = false;
        s = "";
        u = null;
        v = null;
        w = 0;
        x = 0;
        b = null;
        y = null;
        z = false;
        A = false;
        B = true;
        C = new Handler();
        e = null;
        f = null;
        g = null;
        h = null;
        E = null;
        F = 0;
        j = 0L;
        G = -1L;
        H = null;
        k = false;
        I = false;
        J = false;
        K = -1;
        L = -1;
        l = false;
        m = true;
        O = new Point();
        Q = 0;
        S = 0.0F;
        U = new ArrayList();
        o = null;
        W = null;
    }

    static boolean A(CameraMainActivity cameramainactivity)
    {
        return cameramainactivity.l;
    }

    static String B(CameraMainActivity cameramainactivity)
    {
        return cameramainactivity.E;
    }

    static int C(CameraMainActivity cameramainactivity)
    {
        return cameramainactivity.F;
    }

    static myobfuscated.de.b D(CameraMainActivity cameramainactivity)
    {
        return cameramainactivity.e;
    }

    static Point E(CameraMainActivity cameramainactivity)
    {
        return cameramainactivity.O;
    }

    static void F(CameraMainActivity cameramainactivity)
    {
        cameramainactivity.o();
    }

    static boolean G(CameraMainActivity cameramainactivity)
    {
        cameramainactivity.B = true;
        return true;
    }

    static long H(CameraMainActivity cameramainactivity)
    {
        return cameramainactivity.G;
    }

    static long I(CameraMainActivity cameramainactivity)
    {
        return cameramainactivity.j;
    }

    static String J(CameraMainActivity cameramainactivity)
    {
        return cameramainactivity.H;
    }

    static int K(CameraMainActivity cameramainactivity)
    {
        return cameramainactivity.K;
    }

    static int L(CameraMainActivity cameramainactivity)
    {
        return cameramainactivity.L;
    }

    static int a(CameraMainActivity cameramainactivity)
    {
        return cameramainactivity.w;
    }

    static int a(CameraMainActivity cameramainactivity, int i1)
    {
        cameramainactivity.w = i1;
        return i1;
    }

    static Bitmap a(CameraMainActivity cameramainactivity, Bitmap bitmap)
    {
        cameramainactivity.i = bitmap;
        return bitmap;
    }

    static g a(CameraMainActivity cameramainactivity, g g1)
    {
        cameramainactivity.b = g1;
        return g1;
    }

    static CameraFocusRectView a(CameraMainActivity cameramainactivity, CameraFocusRectView camerafocusrectview)
    {
        cameramainactivity.R = camerafocusrectview;
        return camerafocusrectview;
    }

    static String a(CameraMainActivity cameramainactivity, String s1)
    {
        cameramainactivity.E = s1;
        return s1;
    }

    private void a(float f1)
    {
        int i1;
        if (a != null && a.t())
        {
            return;
        }
        i1 = (int)f1;
        float f2 = ((360F - f1) + 360F) % 360F;
        f1 = f2;
        if (f2 == 360F)
        {
            f1 = 0.0F;
        }
        if (f1 != 0.0F || S != 270F) goto _L2; else goto _L1
_L1:
        float f3;
        S = -90F;
        f3 = f1;
_L4:
        RotateAnimation rotateanimation = new RotateAnimation(S, f3, 1, 0.5F, 1, 0.5F);
        rotateanimation.setFillAfter(true);
        rotateanimation.setDuration(500L);
        (new Handler()).postDelayed(new Runnable(i1) {

            private int a;
            private CameraMainActivity b;

            public final void run()
            {
                com.socialin.picsin.camera.CameraMainActivity.a(b, CameraMainActivity.i(b));
                if (a == com.socialin.picsin.camera.CameraMainActivity.a(b))
                {
                    if (com.socialin.picsin.camera.CameraMainActivity.g(b) != null)
                    {
                        com.socialin.picsin.camera.CameraMainActivity.g(b).a((int)(360F - (float)a));
                    }
                    ViewFlipper viewflipper = (ViewFlipper)b.findViewById(0x7f10020f);
                    if (viewflipper.getVisibility() == 0)
                    {
                        int k1 = viewflipper.getDisplayedChild();
                        com.socialin.picsin.camera.CameraMainActivity.a(b, k1, a);
                    }
                    if (b.o != null)
                    {
                        b.o.a((int)(360F - (float)a));
                    }
                    if (CameraMainActivity.j(b) != null)
                    {
                        CameraMainActivity.j(b).setRotation((int)(360F - (float)a));
                    }
                    int l1 = 0;
                    while (l1 < CameraMainActivity.k(b).length) 
                    {
                        int i2 = CameraMainActivity.k(b)[l1];
                        View view1 = b.findViewById(i2);
                        view1.clearAnimation();
                        view1.setRotation(360F - (float)a);
                        l1++;
                    }
                }
            }

            
            {
                b = CameraMainActivity.this;
                a = i1;
                super();
            }
        }, rotateanimation.getDuration());
        for (int j1 = 0; j1 < T.length; j1++)
        {
            View view = findViewById(T[j1]);
            view.setRotation(0.0F);
            view.startAnimation(rotateanimation);
        }

        break; /* Loop/switch isn't completed */
_L2:
        f3 = f1;
        if (f1 == 270F)
        {
            f3 = f1;
            if (S == 0.0F)
            {
                f3 = -90F;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        f1 = f3;
        if (f3 < 0.0F)
        {
            f1 = f3 + 360F;
        }
        S = f1;
        return;
    }

    private void a(int i1, int j1)
    {
        ((ViewFlipper)findViewById(0x7f10020f)).setDisplayedChild(i1);
        b(i1, j1);
    }

    private void a(SeekBar seekbar, int i1, int j1, int k1)
    {
        seekbar.setMax(j1 - i1);
        seekbar.setProgress(k1 - i1);
        seekbar.setOnSeekBarChangeListener(this);
    }

    static void a(CameraMainActivity cameramainactivity, float f1)
    {
        cameramainactivity.a(f1);
    }

    static void a(CameraMainActivity cameramainactivity, int i1, int j1)
    {
        cameramainactivity.b(i1, j1);
    }

    static void a(CameraMainActivity cameramainactivity, View view)
    {
        if (cameramainactivity.a == null || !cameramainactivity.a.t())
        {
            ((RotateImageView)view).setDegree(cameramainactivity.w);
        }
    }

    static void a(CameraMainActivity cameramainactivity, boolean flag)
    {
        cameramainactivity.d(flag);
    }

    private void a(String s1, int i1)
    {
        if (v instanceof Uri)
        {
            String s2 = ((Uri)v).getPath();
            if (!(new File(s1)).equals(new File(s2)))
            {
                try
                {
                    FileUtils.b(s1, s2);
                }
                catch (IOException ioexception)
                {
                    ioexception.printStackTrace();
                }
            }
        }
        if (!u.equals("from.launcher"))
        {
            break MISSING_BLOCK_LABEL_234;
        }
        com.socialin.android.util.x.a();
        new ArrayList();
        s1 = com.socialin.android.util.x.b(s1, true);
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_201;
        }
        Class.forName("com.picsart.studio.util.StudioManager").getDeclaredMethod("openImageInEditor", new Class[] {
            android/app/Activity, java/lang/String, Class.forName("com.picsart.studio.util.a"), com/socialin/android/apiv3/model/ImageItem, java/lang/String, java/lang/String, java/lang/Runnable, java/lang/Runnable
        }).invoke(this, new Object[] {
            this, s1, null, null, null, null, null, new Runnable() {

                private CameraMainActivity a;

                public final void run()
                {
                    a.finish();
                }

            
            {
                a = CameraMainActivity.this;
                super();
            }
            }
        });
        return;
        s1;
        ExceptionReportService.report(s1);
        return;
        s1;
        ExceptionReportService.report(s1);
        return;
        s1;
        ExceptionReportService.report(s1);
        return;
        s1;
        ExceptionReportService.report(s1);
        return;
        Intent intent = new Intent();
        if (s1 != null)
        {
            intent.putExtra("path", s1);
            intent.setData(Uri.fromFile(new File(s1)));
        }
        intent.putExtra("degree", i1);
        setResult(-1, intent);
        finish();
        return;
    }

    private void a(String s1, boolean flag)
    {
        if (!isFinishing())
        {
            if (P == null)
            {
                P = (new android.app.AlertDialog.Builder(this)).setMessage(s1).setNeutralButton(getString(0x7f080311), new android.content.DialogInterface.OnClickListener(true) {

                    private boolean a;
                    private CameraMainActivity b;

                    public final void onClick(DialogInterface dialoginterface, int i1)
                    {
                        if (a)
                        {
                            b.finish();
                        }
                    }

            
            {
                b = CameraMainActivity.this;
                a = flag;
                super();
            }
                }).create();
            }
            if (!P.isShowing())
            {
                P.setMessage(s1);
                P.show();
                return;
            }
        }
    }

    static int b(CameraMainActivity cameramainactivity)
    {
        return cameramainactivity.Q;
    }

    static Bitmap b(CameraMainActivity cameramainactivity, Bitmap bitmap)
    {
        cameramainactivity.D = bitmap;
        return bitmap;
    }

    private void b(int i1, int j1)
    {
        float f2 = 0.0F;
        Object obj = (Point)U.get(i1);
        int k1 = ((Point) (obj)).x;
        int l1 = ((Point) (obj)).y;
        obj = ((ViewFlipper)findViewById(0x7f10020f)).getChildAt(i1);
        i1 = ((View) (obj)).getId();
        if (i1 == 0x7f100211 || i1 == 0x7f100214 || i1 == 0x7f100217 || i1 == 0x7f10021a)
        {
            obj = ((ViewGroup)obj).getChildAt(0);
        }
        i1 = (int)(360F - (float)j1);
        if (k1 > 0 && l1 > 0 && obj != null)
        {
            float f1;
            if (i1 == 270 || i1 == 90)
            {
                f2 = -k1 / 2 + l1 / 2;
                f1 = l1 / 2 - k1 / 2;
            } else
            {
                f1 = 0.0F;
            }
            ((View) (obj)).setTranslationX(f2);
            ((View) (obj)).setTranslationY(f1);
            ((View) (obj)).setRotation(i1);
        }
    }

    static void b(CameraMainActivity cameramainactivity, int i1)
    {
        cameramainactivity.a(4, i1);
    }

    static void b(CameraMainActivity cameramainactivity, String s1)
    {
        cameramainactivity.a(s1, true);
    }

    static void b(CameraMainActivity cameramainactivity, boolean flag)
    {
        cameramainactivity.f(flag);
    }

    static int c(CameraMainActivity cameramainactivity, int i1)
    {
        cameramainactivity.F = i1;
        return i1;
    }

    static c c(CameraMainActivity cameramainactivity)
    {
        return cameramainactivity.a;
    }

    private void c(int i1)
    {
        ((ViewFlipper)findViewById(0x7f1001fb)).setDisplayedChild(i1);
        ViewFlipper viewflipper = (ViewFlipper)findViewById(0x7f10020f);
        if (i1 == 1)
        {
            viewflipper.setVisibility(0);
            b(viewflipper.getDisplayedChild(), w);
            return;
        } else
        {
            viewflipper.setVisibility(8);
            return;
        }
    }

    private void d(int i1)
    {
        View view = findViewById(0x7f10022d);
        if (view != null)
        {
            view.setVisibility(i1);
        }
    }

    static void d(CameraMainActivity cameramainactivity)
    {
        cameramainactivity.j();
    }

    static void d(CameraMainActivity cameramainactivity, int i1)
    {
        cameramainactivity.b(i1);
    }

    private void d(boolean flag)
    {
label0:
        {
label1:
            {
                ImageView imageview = (ImageView)findViewById(0x7f10022c);
                if (imageview == null || O.x <= 0 || O.y <= 0 || i == null || i.isRecycled())
                {
                    break label0;
                }
                int j1 = x - w;
                int i1 = j1;
                if (j1 < 360)
                {
                    i1 = j1 + 360;
                }
                i1 %= 360;
                float f8 = i.getWidth();
                float f7 = i.getHeight();
                float f1 = O.x;
                float f2 = O.y;
                float f3;
                float f4;
                float f5;
                float f6;
                if (flag)
                {
                    Display display = getWindowManager().getDefaultDisplay();
                    Point point = new Point();
                    display.getSize(point);
                    int k1 = point.x;
                    int l1 = point.y;
                    f1 = (int)((float)k1 - Utils.a(58F, this));
                    f2 = l1;
                    f3 = f2;
                    f4 = f1;
                } else
                {
                    f3 = f2;
                    f4 = f1;
                }
                if (i1 != 90)
                {
                    f6 = f2;
                    f5 = f1;
                    if (i1 != 270)
                    {
                        break label1;
                    }
                }
                f5 = f2;
                f6 = f1;
            }
            if (f5 / f8 < f6 / f7)
            {
                f1 = f5 / f8;
            } else
            {
                f1 = f6 / f7;
            }
            f2 = (f8 * f1) / f4;
            f1 = (f1 * f7) / f3;
            imageview.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
            imageview.setScaleX(f2);
            imageview.setScaleY(f1);
            imageview.setRotation(i1);
            imageview.invalidate();
        }
    }

    static ArrayList e(CameraMainActivity cameramainactivity)
    {
        return cameramainactivity.U;
    }

    private void e(boolean flag)
    {
        if (c != null && c.f && !flag)
        {
            c.c();
            c.b();
            g(false);
            c.f = false;
            c.g = true;
            return;
        } else
        {
            c.e();
            c.a();
            AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.CameraActionEvent(s, "capture"));
            return;
        }
    }

    static CameraFocusRectView f(CameraMainActivity cameramainactivity)
    {
        return cameramainactivity.R;
    }

    private void f(boolean flag)
    {
        if (F == 0 || F == 360)
        {
            if (l)
            {
                runOnUiThread(new Runnable() {

                    private CameraMainActivity a;

                    public final void run()
                    {
                        if (a.d != null && com.socialin.picsin.camera.CameraMainActivity.c(a) != null && com.socialin.picsin.camera.CameraMainActivity.c(a).c() != null && com.socialin.picsin.camera.CameraMainActivity.c(a).c().getParameters() != null)
                        {
                            android.hardware.Camera.Size size = com.socialin.picsin.camera.CameraMainActivity.c(a).c().getParameters().getPictureSize();
                            if (size != null)
                            {
                                myobfuscated.cv.c.a(a, a.d.d, size.width, size.height, "camera", "share_to_pa");
                                CameraMainActivity.l(a);
                            }
                        }
                    }

            
            {
                a = CameraMainActivity.this;
                super();
            }
                });
            }
        } else
        {
            if (H == null || G != j)
            {
                continue;
            }
            if (k)
            {
                if (l && H != null)
                {
                    myobfuscated.cv.c.a(this, H, K, L, "camera", "share_to_pa");
                    d(8);
                    return;
                }
            } else
            {
                runOnUiThread(new Runnable() {

                    private CameraMainActivity a;

                    public final void run()
                    {
                        com.socialin.picsin.camera.CameraMainActivity.a(a, com.socialin.android.dialog.g.a(a, a.getString(0x7f080679), false));
                    }

            
            {
                a = CameraMainActivity.this;
                super();
            }
                });
                return;
            }
        }
        do
        {
            do
            {
                return;
            } while (i == null || i.isRecycled());
            if (M == null)
            {
                M = new HandlerThread("shareing_thread");
                M.start();
                N = new Handler(M.getLooper(), this);
            }
            Message message = N.obtainMessage(0);
            message.what = 0;
            message.obj = Long.valueOf(j);
            N.removeMessages(0);
            N.sendMessage(message);
        } while (!flag);
        runOnUiThread(new Runnable() {

            private CameraMainActivity a;

            public final void run()
            {
                com.socialin.picsin.camera.CameraMainActivity.a(a, com.socialin.android.dialog.g.a(a, a.getString(0x7f080679), false));
            }

            
            {
                a = CameraMainActivity.this;
                super();
            }
        });
    }

    static myobfuscated.db.a g(CameraMainActivity cameramainactivity)
    {
        return cameramainactivity.n;
    }

    private void g(boolean flag)
    {
        if (W == null)
        {
            return;
        }
        if (flag)
        {
            W.setVisibility(0);
            W.setRotation((int)(360F - (float)w));
            return;
        } else
        {
            W.setVisibility(4);
            return;
        }
    }

    static void h(CameraMainActivity cameramainactivity)
    {
        cameramainactivity.c(0);
    }

    private void i()
    {
        ViewFlipper viewflipper = (ViewFlipper)findViewById(0x7f10020f);
        for (int i1 = 0; i1 < viewflipper.getChildCount(); i1++)
        {
            U.add(new Point());
        }

        for (int j1 = 0; j1 < viewflipper.getChildCount(); j1++)
        {
            View view;
label0:
            {
                View view1 = viewflipper.getChildAt(j1);
                int k1 = view1.getId();
                if (k1 != 0x7f100211 && k1 != 0x7f100214 && k1 != 0x7f100217)
                {
                    view = view1;
                    if (k1 != 0x7f10021a)
                    {
                        break label0;
                    }
                }
                view = ((ViewGroup)view1).getChildAt(0);
            }
            view.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener(view, j1, viewflipper) {

                private View a;
                private int b;
                private ViewFlipper c;
                private CameraMainActivity d;

                public final void onGlobalLayout()
                {
                    int l1 = a.getWidth();
                    int i2 = a.getHeight();
                    if (l1 > 0 && i2 > 0)
                    {
                        myobfuscated.f.m.a(a, this);
                        ((Point)CameraMainActivity.e(d).get(b)).set(l1, i2);
                        if (c.getVisibility() == 0 && c.getDisplayedChild() == b)
                        {
                            com.socialin.picsin.camera.CameraMainActivity.a(d, b, com.socialin.picsin.camera.CameraMainActivity.a(d));
                        }
                    }
                }

            
            {
                d = CameraMainActivity.this;
                a = view;
                b = i1;
                c = viewflipper;
                super();
            }
            });
        }

    }

    static boolean i(CameraMainActivity cameramainactivity)
    {
        return cameramainactivity.A;
    }

    static RelativeLayout j(CameraMainActivity cameramainactivity)
    {
        return cameramainactivity.W;
    }

    private void j()
    {
        if (!a.N() || g != null && (g == null || g.h))
        {
            if (R == null)
            {
                R = (CameraFocusRectView)findViewById(0x7f1001fa);
            }
            if (findViewById(0x7f10022b).getVisibility() != 0)
            {
                com.socialin.picsin.camera.b b1 = new com.socialin.picsin.camera.b(this);
                a.a(R, b1);
                return;
            }
        }
    }

    private c k()
    {
        int i1 = Integer.parseInt(android.os.Build.VERSION.SDK);
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        if (e != null)
        {
            e.b();
            e.c();
        }
        if (i1 <= 8)
        {
            e = new myobfuscated.de.b();
            a = new CameraViewCupcake(layoutparams, this, e);
        } else
        {
            e = new myobfuscated.de.b();
            a = new CameraViewGingerbread(layoutparams, this, e);
        }
        if (i1 > 10)
        {
            ((View)a).setTag("CAMERA_VIEW_HONEYCOMB_TAG");
        }
        a.setSurfaceChangeCallback(this);
        ((View)a).setLongClickable(true);
        ((View)a).setOnLongClickListener(this);
        ((View)a).setOnClickListener(new android.view.View.OnClickListener() {

            private CameraMainActivity a;

            public final void onClick(View view)
            {
                if (a.o != null && a.o.b())
                {
                    a.o.a();
                }
                if (com.socialin.picsin.camera.CameraMainActivity.g(a) != null && com.socialin.picsin.camera.CameraMainActivity.g(a).c())
                {
                    com.socialin.picsin.camera.CameraMainActivity.g(a).b(true);
                }
                if (((ViewFlipper)a.findViewById(0x7f1001fb)).getDisplayedChild() != 0)
                {
                    com.socialin.picsin.camera.CameraMainActivity.h(a);
                }
                if (com.socialin.picsin.camera.CameraMainActivity.c(a) != null && (com.socialin.picsin.camera.CameraMainActivity.c(a).N() || com.socialin.picsin.camera.CameraMainActivity.c(a).W() || a.findViewById(0x7f100684).getVisibility() == 0))
                {
                    return;
                } else
                {
                    com.socialin.picsin.camera.CameraMainActivity.d(a);
                    return;
                }
            }

            
            {
                a = CameraMainActivity.this;
                super();
            }
        });
        return a;
    }

    static int[] k(CameraMainActivity cameramainactivity)
    {
        return cameramainactivity.T;
    }

    private void l()
    {
        ((ImageView)findViewById(0x7f10022c)).setImageBitmap(null);
        findViewById(0x7f10022b).setVisibility(8);
        findViewById(0x7f100210).setVisibility(0);
        findViewById(0x7f10022a).setVisibility(0);
        a(0);
        if (!I)
        {
            if (i != null && !i.isRecycled())
            {
                com.socialin.android.util.c.a(i, "CameraMainActivity");
            }
            i = null;
            return;
        } else
        {
            J = true;
            return;
        }
    }

    static void l(CameraMainActivity cameramainactivity)
    {
        cameramainactivity.d(8);
    }

    private void m()
    {
        Object obj;
        String as[];
        if (a.R())
        {
            findViewById(0x7f10020a).setVisibility(0);
            findViewById(0x7f100211).setVisibility(0);
            a((SeekBar)findViewById(0x7f100213), a.P(), a.Q(), a.O());
        } else
        {
            findViewById(0x7f10020a).setVisibility(8);
            findViewById(0x7f100211).setVisibility(8);
        }
        if (!a.g())
        {
            findViewById(0x7f100214).setVisibility(8);
            findViewById(0x7f10020b).setVisibility(8);
        } else
        {
            findViewById(0x7f100214).setVisibility(0);
            findViewById(0x7f10020b).setVisibility(0);
            findViewById(0x7f100216).setVisibility(0);
            findViewById(0x7f100215).setVisibility(0);
            a((SeekBar)findViewById(0x7f100216), a.e(), a.f(), a.h());
        }
        if (!a.k())
        {
            findViewById(0x7f100217).setVisibility(8);
            findViewById(0x7f10020c).setVisibility(8);
        } else
        {
            findViewById(0x7f100217).setVisibility(0);
            findViewById(0x7f10020c).setVisibility(0);
            findViewById(0x7f100219).setVisibility(0);
            findViewById(0x7f100218).setVisibility(0);
            a((SeekBar)findViewById(0x7f100219), a.i(), a.j(), a.l());
        }
        if (!a.o())
        {
            findViewById(0x7f10021a).setVisibility(8);
            findViewById(0x7f10020d).setVisibility(8);
        } else
        {
            findViewById(0x7f10021a).setVisibility(0);
            findViewById(0x7f10020d).setVisibility(0);
            findViewById(0x7f10021c).setVisibility(0);
            findViewById(0x7f10021b).setVisibility(0);
            a((SeekBar)findViewById(0x7f10021c), a.m(), a.n(), a.p());
        }
        obj = (ViewFlipper)findViewById(0x7f1001fb);
        if (!r)
        {
            ((ViewFlipper) (obj)).setDisplayedChild(0);
        }
        findViewById(0x7f100208).setOnClickListener(this);
        p = a.G();
        if (p != null) goto _L2; else goto _L1
_L1:
        findViewById(0x7f10021f).setVisibility(8);
_L5:
        obj = (RadioGroup)findViewById(0x7f100209);
        ((RadioGroup) (obj)).setOnCheckedChangeListener(null);
        ((RadioGroup) (obj)).check(((RadioGroup) (obj)).getChildAt(0).getId());
        ((RadioGroup) (obj)).setOnCheckedChangeListener(this);
        ((RadioGroup) (obj)).findViewById(0x7f10020e).setOnClickListener(new android.view.View.OnClickListener() {

            private CameraMainActivity a;

            public final void onClick(View view)
            {
                if (((ViewFlipper)a.findViewById(0x7f10020f)).getDisplayedChild() == 4)
                {
                    com.socialin.picsin.camera.CameraMainActivity.b(a, com.socialin.picsin.camera.CameraMainActivity.a(a));
                } else
                {
                    com.socialin.picsin.camera.CameraMainActivity.b(a, com.socialin.picsin.camera.CameraMainActivity.a(a));
                    if (CameraMainActivity.y(a))
                    {
                        a.b();
                        return;
                    }
                }
            }

            
            {
                a = CameraMainActivity.this;
                super();
            }
        });
        q = new SettingsListAdapter();
        as = a.K();
        if (as != null)
        {
            as = new e("White Balance", a.L(), false, new f(this, 0x7f03009b, as, 1));
            q.add(as);
        }
        as = a.q();
        if (as != null)
        {
            as = new e("ISO", a.r(), false, new f(this, 0x7f03009b, as, 2));
            q.add(as);
        }
        as = a.I();
        if (as != null)
        {
            as = new e("Scene Modes", a.J(), false, new f(this, 0x7f03009b, as, 4));
            q.add(as);
        }
        as = new e("Sound", "on", true, null);
        as.d = a.w();
        com.socialin.picsin.camera.a a1;
        int i1;
        if (((e) (as)).d)
        {
            as.b = "on";
        } else
        {
            as.b = "off";
        }
        q.add(as);
        if (p != null)
        {
            as = new e("Effects", null, false, null);
            q.add(as);
        }
        as = new e("Reset defaults", null, false, null);
        q.add(as);
        as = (ListView)findViewById(0x7f10021d);
        as.setAdapter(q);
        as.setOnItemClickListener(this);
        ((ListView)findViewById(0x7f10021e)).setItemsCanFocus(false);
        ((ListView)findViewById(0x7f10021e)).setChoiceMode(1);
        ((ListView)findViewById(0x7f10021e)).setOnItemClickListener(this);
        i1 = a.F();
        as = (ViewFlipper)findViewById(0x7f100202);
        if (!a.s())
        {
            findViewById(0x7f100200).setVisibility(8);
        } else
        {
            C.postDelayed(new Runnable() {

                private CameraMainActivity a;

                public final void run()
                {
                    a.findViewById(0x7f100200).setVisibility(0);
                }

            
            {
                a = CameraMainActivity.this;
                super();
            }
            }, 100L);
            if (i1 == 2)
            {
                as.setDisplayedChild(0);
            } else
            if (i1 == 1)
            {
                as.setDisplayedChild(1);
            } else
            {
label0:
                {
                    if (i1 != 0)
                    {
                        break label0;
                    }
                    as.setDisplayedChild(2);
                }
            }
            findViewById(0x7f100203).setOnClickListener(this);
            findViewById(0x7f100205).setOnClickListener(this);
            findViewById(0x7f100204).setOnClickListener(this);
        }
_L7:
        if (findViewById(0x7f100209).getVisibility() == 0)
        {
            as = (RadioButton)findViewById(0x7f10020b);
            Object obj1 = (RadioButton)findViewById(0x7f10020a);
            if (((RadioButton)findViewById(0x7f10020e)).getVisibility() == 0)
            {
                findViewById(0x7f10020e).performClick();
            } else
            if (((RadioButton) (obj1)).getVisibility() == 0)
            {
                ((RadioGroup)findViewById(0x7f100209)).check(0x7f10020a);
            } else
            if (as.getVisibility() == 0)
            {
                ((RadioGroup)findViewById(0x7f100209)).check(0x7f10020b);
            }
        }
        findViewById(0x7f10022a).setOnClickListener(this);
        findViewById(0x7f100226).setOnClickListener(this);
        findViewById(0x7f100231).setOnClickListener(this);
        findViewById(0x7f100230).setOnClickListener(this);
        findViewById(0x7f10022f).setOnClickListener(this);
        findViewById(0x7f10022e).setOnClickListener(this);
        findViewById(0x7f100229).setOnClickListener(this);
        as = (CustomVerticalSeekBar)findViewById(0x7f1001ff);
        if (!a.S())
        {
            findViewById(0x7f1001fd).setVisibility(8);
        } else
        {
            List list = a.V();
            if (list == null)
            {
                findViewById(0x7f1001fd).setVisibility(8);
            } else
            {
                findViewById(0x7f1001fd).setVisibility(0);
                int j1 = a.U();
                int k1 = a.T();
                as.setMax(j1);
                as.setProgressAndThumb(k1);
                TextView textview = (TextView)findViewById(0x7f1001fe);
                textview.setText((new StringBuilder()).append((float)(((Integer)list.get(k1)).intValue() / 10) / 10F).append("X").toString());
                as.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener(textview, list) {

                    private TextView a;
                    private List b;
                    private CameraMainActivity c;

                    public final void onProgressChanged(SeekBar seekbar, int l1, boolean flag)
                    {
                        if (flag)
                        {
                            com.socialin.picsin.camera.CameraMainActivity.c(c).setZoom(l1);
                            a.setText((new StringBuilder()).append((float)(((Integer)b.get(l1)).intValue() / 10) / 10F).append("X").toString());
                            com.socialin.picsin.camera.CameraMainActivity.c(c).d();
                        }
                    }

                    public final void onStartTrackingTouch(SeekBar seekbar)
                    {
                    }

                    public final void onStopTrackingTouch(SeekBar seekbar)
                    {
                    }

            
            {
                c = CameraMainActivity.this;
                a = textview;
                b = list;
                super();
            }
                });
            }
        }
        (new StringBuilder("cameraView.getNumberOfCameras() : ")).append(a.u());
        if (a.u() > 1)
        {
            findViewById(0x7f100201).setVisibility(0);
            findViewById(0x7f100207).setOnClickListener(this);
            return;
        } else
        {
            findViewById(0x7f100201).setVisibility(8);
            return;
        }
_L2:
        findViewById(0x7f10021f).setVisibility(0);
        as = a.H();
        obj1 = (ListView)findViewById(0x7f10021f);
        ((ListView) (obj1)).setItemsCanFocus(false);
        ((ListView) (obj1)).setChoiceMode(1);
        a1 = new com.socialin.picsin.camera.a(this, 0x7f03009b, p);
        ((ListView) (obj1)).setAdapter(a1);
        i1 = 0;
_L6:
        if (i1 >= a1.getCount())
        {
            break MISSING_BLOCK_LABEL_1339;
        }
        if (!((String)a1.getItem(i1)).equals(as)) goto _L4; else goto _L3
_L3:
        ((ListView) (obj1)).setItemChecked(i1, true);
        ((ListView) (obj1)).setOnItemClickListener(this);
          goto _L5
_L4:
        i1++;
          goto _L6
        i1 = -1;
          goto _L3
        findViewById(0x7f100200).setVisibility(8);
          goto _L7
    }

    static void m(CameraMainActivity cameramainactivity)
    {
        cameramainactivity.g(false);
    }

    private int n()
    {
        int j1 = w;
        int i1 = j1;
        if (a != null)
        {
            i1 = j1;
            if (a.v() != 0)
            {
                j1 = (360 - w) % 360;
                i1 = j1;
                if (d.b)
                {
                    (new StringBuilder("++++++++++++++++++++++++++++++++++++++++++++++++++ saveRotation ")).append(j1).append(" rotation : ").append(w);
                    i1 = j1;
                }
            }
        }
        int k1 = a.E();
        j1 = i1;
        if (k1 == 180)
        {
            j1 = (i1 + k1) % 360;
        }
        return j1;
    }

    static String n(CameraMainActivity cameramainactivity)
    {
        return cameramainactivity.s;
    }

    static a o(CameraMainActivity cameramainactivity)
    {
        return cameramainactivity.f;
    }

    private void o()
    {
        findViewById(0x7f1001f8).setVisibility(0);
        h = new CameraOpenGlSurfaceView(this);
        h.setOnClickListener(new android.view.View.OnClickListener() {

            private CameraMainActivity a;

            public final void onClick(View view1)
            {
                if (com.socialin.picsin.camera.CameraMainActivity.g(a) != null && com.socialin.picsin.camera.CameraMainActivity.g(a).c())
                {
                    com.socialin.picsin.camera.CameraMainActivity.g(a).b(true);
                }
            }

            
            {
                a = CameraMainActivity.this;
                super();
            }
        });
        if (f == null)
        {
            f = new a(this);
            a.setEffectsController(f);
        }
        g = new h(this, f);
        f.y = g;
        g.u = a.z();
        g.v = a.E();
        h.setRenderer(g);
        h.setRenderMode(0);
        e.b = g;
        e.a = h;
        ((LinearLayout)findViewById(0x7f1001f9)).addView(h);
        View view = findViewById(0x7f100208);
        if (view != null)
        {
            view.setVisibility(8);
        }
    }

    static h p(CameraMainActivity cameramainactivity)
    {
        return cameramainactivity.g;
    }

    private void p()
    {
        CameraViewCupcake cameraviewcupcake = (CameraViewCupcake)a;
        a.c().setPreviewCallback(null);
        f.a(0, false, false, false);
        e.b();
        cameraviewcupcake.k = false;
        b(true);
    }

    static void q(CameraMainActivity cameramainactivity)
    {
        cameramainactivity.b(false);
    }

    private boolean q()
    {
        boolean flag1 = true;
        boolean flag;
        if (g != null && h != null && h.getVisibility() == 0 && (g.g || !g.h))
        {
            if (g.g)
            {
                Log.e("ex", "renderer.isSavingPicture()");
            }
            if (!g.h)
            {
                Log.e("ex", "!renderer.canTakePicture()");
            }
            flag = false;
        } else
        {
            b(false);
            o();
            ((ImageView)findViewById(0x7f10022c)).setImageBitmap(null);
            findViewById(0x7f10022b).setVisibility(8);
            findViewById(0x7f100210).setVisibility(0);
            a(0);
            android.widget.RelativeLayout.LayoutParams layoutparams;
            byte byte0;
            if (!I)
            {
                if (i != null && !i.isRecycled())
                {
                    com.socialin.android.util.c.a(i, "CameraMainActivity");
                }
            } else
            {
                J = true;
            }
            if (((CameraViewCupcake)a).getWidth() == 1)
            {
                byte0 = 2;
            } else
            {
                byte0 = 1;
            }
            ((CameraViewCupcake)a).k = true;
            layoutparams = new android.widget.RelativeLayout.LayoutParams(byte0, byte0);
            ((CameraViewCupcake)a).setLayoutParams(layoutparams);
            if (n != null)
            {
                n.a();
                n.a(true);
            }
            flag = flag1;
            if (f != null)
            {
                flag = flag1;
                if (f.c == 0)
                {
                    e();
                    return true;
                }
            }
        }
        return flag;
    }

    static Bitmap r(CameraMainActivity cameramainactivity)
    {
        return cameramainactivity.i;
    }

    private void r()
    {
        if (!l && H != null && N != null)
        {
            Message message = N.obtainMessage(1);
            message.what = 1;
            message.obj = H;
            N.sendMessage(message);
        }
    }

    static int s(CameraMainActivity cameramainactivity)
    {
        return cameramainactivity.n();
    }

    static CameraOpenGlSurfaceView t(CameraMainActivity cameramainactivity)
    {
        return cameramainactivity.h;
    }

    static g u(CameraMainActivity cameramainactivity)
    {
        return cameramainactivity.b;
    }

    static void v(CameraMainActivity cameramainactivity)
    {
        cameramainactivity.h();
    }

    static Bitmap w(CameraMainActivity cameramainactivity)
    {
        return cameramainactivity.D;
    }

    static boolean x(CameraMainActivity cameramainactivity)
    {
        return cameramainactivity.B;
    }

    static boolean y(CameraMainActivity cameramainactivity)
    {
        return cameramainactivity.r;
    }

    static Object z(CameraMainActivity cameramainactivity)
    {
        return cameramainactivity.v;
    }

    public final void a(int i1)
    {
        ViewFlipper viewflipper = (ViewFlipper)findViewById(0x7f1001fb);
        viewflipper.setVisibility(i1);
        ViewFlipper viewflipper1 = (ViewFlipper)findViewById(0x7f10020f);
        if (i1 == 0)
        {
            if (viewflipper.getDisplayedChild() == 1)
            {
                viewflipper1.setVisibility(i1);
                b(viewflipper1.getDisplayedChild(), w);
            }
            return;
        } else
        {
            viewflipper1.setVisibility(i1);
            return;
        }
    }

    public final void a(int i1, boolean flag, boolean flag1)
    {
        if (!z)
        {
            z = true;
            if (((ViewFlipper)findViewById(0x7f1001fb)).getDisplayedChild() != 0)
            {
                c(0);
            }
            findViewById(0x7f100226).setVisibility(8);
            if (o != null)
            {
                o.a.setVisibility(8);
                o.a(CameraShutter.ShutterMode.NORMAL);
            }
            if (!((CameraViewCupcake)a).k)
            {
                findViewById(0x7f100684).setVisibility(0);
                findViewById(0x7f100685).setVisibility(0);
                C.postDelayed(new Runnable(i1, flag, flag1) {

                    private int a;
                    private boolean b;
                    private boolean c;
                    private CameraMainActivity d;

                    public final void run()
                    {
                        CameraMainActivity.F(d);
                        ((CameraViewCupcake)com.socialin.picsin.camera.CameraMainActivity.c(d)).k = true;
                        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(1, 1);
                        ((CameraViewCupcake)com.socialin.picsin.camera.CameraMainActivity.c(d)).setLayoutParams(layoutparams);
                        com.socialin.picsin.camera.CameraMainActivity.o(d).a(a, true, true, b, c);
                    }

            
            {
                d = CameraMainActivity.this;
                a = i1;
                b = flag;
                c = flag1;
                super();
            }
                }, 100L);
                return;
            }
        }
    }

    public final void a(i i1)
    {
        if (d.b)
        {
            (new StringBuilder("camera shutter onUpdate ")).append(i1.toString());
        }
        if (W == null)
        {
            int j1 = (int)TypedValue.applyDimension(1, 120F, getResources().getDisplayMetrics());
            android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(j1, j1);
            layoutparams.addRule(13);
            W = (RelativeLayout)getLayoutInflater().inflate(0x7f030091, null);
            ((ViewGroup)findViewById(0x7f1001f5)).addView(W, layoutparams);
            W.setOnClickListener(this);
            W.setRotation((int)(360F - (float)w));
        }
        if (c.a != CameraShutter.ShutterMode.TIME_LAPSE && c.a != CameraShutter.ShutterMode.TIMER) goto _L2; else goto _L1
_L1:
        ((TextView)W.findViewById(0x7f100338)).setText((new StringBuilder()).append(i1.b()).toString());
        ((TextView)W.findViewById(0x7f100339)).setText(getResources().getString(0x7f080095));
_L4:
        g(true);
        return;
_L2:
        if (c.a == CameraShutter.ShutterMode.BURST)
        {
            if (i1.b() == 0)
            {
                if (o != null)
                {
                    o.a(CameraShutter.ShutterMode.NORMAL);
                }
                g(false);
                a(0);
                findViewById(0x7f100220).setVisibility(0);
                return;
            }
            ((TextView)W.findViewById(0x7f100338)).setText((new StringBuilder()).append(i1.b()).toString());
            ((TextView)W.findViewById(0x7f100339)).setText(getResources().getString(0x7f080096));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void a(boolean flag)
    {
        if (g != null && flag)
        {
            g.i = true;
        }
        if (h != null)
        {
            p();
            ((CameraViewCupcake)a).setVisibility(4);
            ((CameraViewCupcake)a).setVisibility(0);
        }
        findViewById(0x7f100226).setVisibility(0);
        if (n != null)
        {
            myobfuscated.db.a a1 = n;
            if (a1.d != null && a1.d.getCount() > 0)
            {
                a1.d.a(0);
            }
        }
        z = false;
    }

    public final boolean a()
    {
        return h != null;
    }

    public final void b()
    {
        String s1;
        ListView listview;
        listview = (ListView)findViewById(0x7f10021e);
        int i1 = listview.getCheckedItemPosition();
        Object obj = null;
        s1 = obj;
        if (i1 != -1)
        {
            s1 = obj;
            if (listview != null)
            {
                s1 = obj;
                if (listview.getAdapter() != null)
                {
                    s1 = obj;
                    if (listview.getAdapter().getItem(i1) != null)
                    {
                        s1 = (String)listview.getAdapter().getItem(i1);
                    }
                }
            }
        }
        if (s1 == null) goto _L2; else goto _L1
_L1:
        Object obj1 = (f)listview.getAdapter();
        if (((f) (obj1)).a != 2) goto _L4; else goto _L3
_L3:
        obj1 = q.getItemByName("ISO");
        if (obj1 != null)
        {
            obj1.b = s1;
        }
_L6:
        q.notifyDataSetChanged();
_L2:
        return;
_L4:
        if (((f) (obj1)).a == 3)
        {
            obj1 = q.getItemByName("Resolution");
            if (obj1 != null)
            {
                obj1.b = s1;
            }
        } else
        if (((f) (obj1)).a == 4)
        {
            obj1 = q.getItemByName("Scene Modes");
            if (obj1 != null)
            {
                obj1.b = s1;
            }
        } else
        if (((f) (obj1)).a == 1)
        {
            obj1 = q.getItemByName("White Balance");
            if (obj1 != null)
            {
                obj1.b = s1;
            }
        } else
        if (((f) (obj1)).a == 5)
        {
            e e1 = q.getItemByName("Image Size");
            if (e1 != null)
            {
                e1.b = s1;
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final void b(int i1)
    {
        if (i1 == 0x7f100224)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (((ViewFlipper)findViewById(0x7f1001fb)).getDisplayedChild() != 0)
        {
            c(0);
        }
        if (!isFinishing())
        {
            if (o != null && o.b())
            {
                o.a();
            }
            if (c.a != CameraShutter.ShutterMode.NORMAL)
            {
                Utils.c(this, getString(0x7f0800c2));
                return;
            }
            if (!a.B() && a.C())
            {
                if (f == null)
                {
                    f = new a(this);
                    f.d = s;
                    a.setEffectsController(f);
                }
                if (n == null)
                {
                    Object obj = getFragmentManager().findFragmentByTag(myobfuscated.db.a.a);
                    if (obj == null)
                    {
                        obj = getFragmentManager().beginTransaction();
                        n = new myobfuscated.db.a(f, i1);
                        ((FragmentTransaction) (obj)).add(0x7f100232, n, myobfuscated.db.a.a);
                        n.a((int)(360F - (float)w));
                        ((FragmentTransaction) (obj)).commit();
                        return;
                    }
                    n = (myobfuscated.db.a)obj;
                    obj = n;
                    a a1 = f;
                    obj.c = a1;
                    obj.g = i1;
                    if (((myobfuscated.db.a) (obj)).e == null)
                    {
                        obj.e = new com.socialin.camera.masks.d(((myobfuscated.db.a) (obj)).getActivity(), "mask.json");
                    }
                    if (a1 != null)
                    {
                        View view = ((myobfuscated.db.a) (obj)).getView();
                        a1.x = ((myobfuscated.db.a) (obj));
                        if (view != null)
                        {
                            ((myobfuscated.db.a) (obj)).a(i1, view);
                            return;
                        }
                    }
                } else
                if (n.g == i1)
                {
                    n.b(true);
                    return;
                } else
                {
                    n.a(i1, n.getView());
                    return;
                }
            }
        }
    }

    public final void b(boolean flag)
    {
        findViewById(0x7f1001f8).setVisibility(8);
        e.b();
        if (g != null)
        {
            g.y = true;
        }
        if (h != null)
        {
            h.a = true;
            h.onPause();
        }
        ((LinearLayout)findViewById(0x7f1001f9)).removeAllViews();
        h = null;
        g = null;
        if (n != null)
        {
            if (flag)
            {
                n.g = -1;
                n.c(false);
                View view = findViewById(0x7f100208);
                if (view != null)
                {
                    view.setVisibility(0);
                }
            }
            n.a(false);
        }
    }

    public final GLSurfaceView c()
    {
        return h;
    }

    public final void c(boolean flag)
    {
        runOnUiThread(new Runnable(flag) {

            private boolean a;
            private CameraMainActivity b;

            public final void run()
            {
                View view = b.findViewById(0x7f100684);
                View view1 = b.findViewById(0x7f100685);
                if (view != null && view1 != null)
                {
                    if (a)
                    {
                        view.setVisibility(0);
                        view1.setVisibility(0);
                    } else
                    if (com.socialin.picsin.camera.CameraMainActivity.x(b))
                    {
                        view.setVisibility(8);
                        view1.setVisibility(8);
                        return;
                    }
                }
            }

            
            {
                b = CameraMainActivity.this;
                a = flag;
                super();
            }
        });
    }

    public final void d()
    {
        if (h != null)
        {
            h.requestRender();
        }
    }

    public final ColorSplashForegroundView e()
    {
        RelativeLayout relativelayout = (RelativeLayout)findViewById(0x7f1001f6);
        Object obj = relativelayout.findViewWithTag("COLOR_SPLASH_FOREGROUND_VIEW_TAG");
        if (obj == null)
        {
            obj = new ColorSplashForegroundView(this);
            ((ColorSplashForegroundView) (obj)).setTag("COLOR_SPLASH_FOREGROUND_VIEW_TAG");
            ((ColorSplashForegroundView) (obj)).setRenderer(g);
            ((ColorSplashForegroundView) (obj)).setGlSurfaceView(h);
            relativelayout.addView(((View) (obj)));
        } else
        {
            obj = (ColorSplashForegroundView)obj;
            ((ColorSplashForegroundView) (obj)).a(true);
            ((ColorSplashForegroundView) (obj)).setRenderer(g);
            ((ColorSplashForegroundView) (obj)).setGlSurfaceView(h);
        }
        if (h != null && g != null)
        {
            h.queueEvent(new Runnable() {

                private CameraMainActivity a;

                public final void run()
                {
                    View view = ((RelativeLayout)a.findViewById(0x7f1001f6)).findViewWithTag("COLOR_SPLASH_FOREGROUND_VIEW_TAG");
                    if (view != null)
                    {
                        CameraMainActivity.p(a).x = (ColorSplashForegroundView)view;
                    }
                    CameraMainActivity.p(a).c = true;
                }

            
            {
                a = CameraMainActivity.this;
                super();
            }
            });
        }
        return ((ColorSplashForegroundView) (obj));
    }

    public final void f()
    {
        if (!a.N() || g != null && (g == null || g.h))
        {
            if (a.N() && n != null && n.g == 1)
            {
                n.a(false);
            }
            a.a(this, this);
            if (c.a != CameraShutter.ShutterMode.BURST)
            {
                c.b();
                g(false);
                return;
            }
        }
    }

    public final void g()
    {
        if (c != null)
        {
            CameraShutter camerashutter = c;
            if (camerashutter.j)
            {
                camerashutter.j = false;
                if ((camerashutter.a != CameraShutter.ShutterMode.BURST || camerashutter.f) && !camerashutter.g)
                {
                    camerashutter.a();
                }
                camerashutter.g = false;
            }
        }
        if (c.a != CameraShutter.ShutterMode.NORMAL && W != null)
        {
            CameraShutter camerashutter1 = c;
            int i1;
            if (camerashutter1.a == CameraShutter.ShutterMode.BURST)
            {
                i1 = camerashutter1.d.b();
            } else
            if (camerashutter1.a == CameraShutter.ShutterMode.TIME_LAPSE)
            {
                i1 = camerashutter1.c.b();
            } else
            if (camerashutter1.a == CameraShutter.ShutterMode.TIMER)
            {
                i1 = camerashutter1.b.b();
            } else
            {
                i1 = 0;
            }
            if (i1 != 0)
            {
                g(true);
                ((TextView)W.findViewById(0x7f100338)).setText(String.valueOf(i1));
                if (c.a == CameraShutter.ShutterMode.BURST)
                {
                    ((TextView)W.findViewById(0x7f100339)).setText(getResources().getString(0x7f080096));
                    return;
                } else
                {
                    ((TextView)W.findViewById(0x7f100339)).setText(getResources().getString(0x7f080095));
                    return;
                }
            }
        }
    }

    public final void h()
    {
        if (O.x == 0 || O.y == 0)
        {
            ImageView imageview = (ImageView)findViewById(0x7f10022c);
            imageview.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener(imageview) {

                private ImageView a;
                private CameraMainActivity b;

                public final void onGlobalLayout()
                {
                    int i1 = a.getWidth();
                    int j1 = a.getHeight();
                    if (i1 > 0 && j1 > 0)
                    {
                        myobfuscated.f.m.a(a, this);
                        CameraMainActivity.E(b).x = i1;
                        CameraMainActivity.E(b).y = j1;
                        if (CameraMainActivity.r(b) != null && !CameraMainActivity.r(b).isRecycled())
                        {
                            com.socialin.picsin.camera.CameraMainActivity.a(b, CameraMainActivity.i(b));
                        }
                    }
                }

            
            {
                b = CameraMainActivity.this;
                a = imageview;
                super();
            }
            });
        }
        View view = findViewById(0x7f10022d);
        if (view != null)
        {
            view.requestLayout();
            view.invalidate();
        }
        a(w);
        if (i != null && !i.isRecycled())
        {
            d(A);
        }
    }

    public boolean handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 0 1: default 28
    //                   0 30
    //                   1 445;
           goto _L1 _L2 _L3
_L1:
        return false;
_L2:
        G = ((Long)message.obj).longValue();
        if (E != null && i != null && !i.isRecycled() && findViewById(0x7f10022b).getVisibility() == 0)
        {
            I = true;
            message = new android.graphics.BitmapFactory.Options();
            message.inPreferredConfig = android.graphics.Bitmap.Config.ARGB_8888;
            message = com.socialin.android.util.c.a(E, message);
            I = false;
            if (J)
            {
                if (G == j)
                {
                    if (i != null && !i.isRecycled())
                    {
                        com.socialin.android.util.c.a(i);
                    }
                    i = null;
                }
                J = false;
                return false;
            }
            if (message == null)
            {
                runOnUiThread(new Runnable() {

                    private CameraMainActivity a;

                    public final void run()
                    {
                        if (CameraMainActivity.u(a) != null && CameraMainActivity.u(a).isShowing())
                        {
                            CameraMainActivity.u(a).dismiss();
                        }
                    }

            
            {
                a = CameraMainActivity.this;
                super();
            }
                });
                return false;
            }
            message = com.socialin.android.util.w.c(message, F);
            if (message == null)
            {
                runOnUiThread(new Runnable() {

                    private CameraMainActivity a;

                    public final void run()
                    {
                        if (CameraMainActivity.u(a) != null && CameraMainActivity.u(a).isShowing())
                        {
                            CameraMainActivity.u(a).dismiss();
                        }
                    }

            
            {
                a = CameraMainActivity.this;
                super();
            }
                });
                return false;
            }
            String s1 = (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/").append(getString(0x7f0808fb)).append("/").toString();
            s1 = (new StringBuilder()).append(s1).append(getString(0x7f08096b)).append("/").toString();
            Object obj = new Date();
            obj = (new StringBuilder()).append(getString(0x7f0808fb)).append("_").append(((Date) (obj)).toLocaleString().replace(":", ".")).append(".jpg").toString();
            H = (new StringBuilder()).append(s1).append(((String) (obj))).toString();
            try
            {
                K = message.getWidth();
                L = message.getHeight();
                com.socialin.android.util.w.a(android.graphics.Bitmap.CompressFormat.JPEG, message, 100, new File(H), this);
                k = true;
                runOnUiThread(new Runnable() {

                    private CameraMainActivity a;

                    public final void run()
                    {
                        if (CameraMainActivity.H(a) == CameraMainActivity.I(a) && a.findViewById(0x7f10022b).getVisibility() == 0 && !CameraMainActivity.i(a))
                        {
                            if (CameraMainActivity.u(a) != null && CameraMainActivity.u(a).isShowing())
                            {
                                CameraMainActivity.u(a).dismiss();
                            }
                            if (CameraMainActivity.A(a) && CameraMainActivity.J(a) != null)
                            {
                                myobfuscated.cv.c.a(a, CameraMainActivity.J(a), CameraMainActivity.K(a), CameraMainActivity.L(a), "camera", "share_to_pa");
                                CameraMainActivity.l(a);
                            }
                        }
                    }

            
            {
                a = CameraMainActivity.this;
                super();
            }
                });
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
            if (message != null && !message.isRecycled())
            {
                message.recycle();
                return false;
            }
        }
        continue; /* Loop/switch isn't completed */
_L3:
        message = (String)message.obj;
        if (message != null)
        {
            message = new File(message);
            if (message.delete())
            {
                new o(this, message.getAbsolutePath(), "image/*");
                return false;
            }
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        if (i1 != t) goto _L2; else goto _L1
_L1:
        j1;
        JVM INSTR lookupswitch 2: default 36
    //                   -1: 212
    //                   11: 212;
           goto _L3 _L4 _L4
_L3:
        if (a != null && a.N() && n != null)
        {
            Log.e("ex", "ONactivity result");
            n.a();
            n.a(true);
        }
        if (a != null && a.N())
        {
            q();
        }
_L2:
        if (findViewById(0x7f10022b).getVisibility() == 0)
        {
            findViewById(0x7f10022b).setVisibility(8);
            a(0);
            findViewById(0x7f100210).setVisibility(0);
            ((ImageView)findViewById(0x7f10022c)).setImageBitmap(null);
            if (i != null && !i.isRecycled())
            {
                com.socialin.android.util.c.a(i, "CameraMainActivity");
            }
            i = null;
        }
        l = false;
        super.onActivityResult(i1, j1, intent);
        return;
_L4:
        String s1;
        if (intent != null && intent.getStringExtra("path") != null)
        {
            s1 = intent.getStringExtra("path");
        } else
        {
            s1 = null;
        }
        a(s1, 0);
        if (true) goto _L2; else goto _L5
_L5:
    }

    public void onBackPressed()
    {
        AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.CameraActionEvent(s, "close"));
        super.onBackPressed();
    }

    public void onCheckedChanged(RadioGroup radiogroup, int i1)
    {
        if (o != null && o.b())
        {
            o.a();
        }
        if (n != null && n.c())
        {
            n.b(false);
        }
        if (radiogroup == findViewById(0x7f10021f))
        {
            a.setEffect(p[i1 - 1]);
            a.d();
        } else
        if (radiogroup == findViewById(0x7f100209))
        {
            radiogroup = (ViewFlipper)findViewById(0x7f1001fb);
            ViewFlipper viewflipper = (ViewFlipper)findViewById(0x7f10020f);
            if (radiogroup.getDisplayedChild() == 1 && viewflipper.getVisibility() != 0)
            {
                viewflipper.setVisibility(0);
            }
            if (i1 == 0x7f10020a)
            {
                a(0, w);
                return;
            }
            if (i1 == 0x7f10020b)
            {
                a(1, w);
                return;
            }
            if (i1 == 0x7f10020c)
            {
                a(2, w);
                return;
            }
            if (i1 == 0x7f10020d)
            {
                a(3, w);
                return;
            }
        }
    }

    public void onClick(View view)
    {
        File file;
        Intent intent;
        Uri uri;
        MimeTypeMap mimetypemap;
        int i1;
        int j1;
        int k1;
        int l1;
        boolean flag;
        if (o != null && o.b() && view.getId() != 0x7f100226)
        {
            o.a();
            flag = true;
        } else
        {
            flag = false;
        }
        if (n != null && n.c())
        {
            n.b(false);
        }
        if (view.getId() != 0x7f100203) goto _L2; else goto _L1
_L1:
        ((ViewFlipper)findViewById(0x7f100202)).setDisplayedChild(1);
        a.setFlashMode(1);
        a.d();
        AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.CameraActionEvent(s, "flash"));
_L4:
        return;
_L2:
        if (view.getId() == 0x7f100204)
        {
            ((ViewFlipper)findViewById(0x7f100202)).setDisplayedChild(2);
            a.setFlashMode(0);
            a.d();
            AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.CameraActionEvent(s, "flash"));
            return;
        }
        if (view.getId() == 0x7f100205)
        {
            ((ViewFlipper)findViewById(0x7f100202)).setDisplayedChild(0);
            a.setFlashMode(2);
            a.d();
            AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.CameraActionEvent(s, "flash"));
            return;
        }
        if (view.getId() == 0x7f10022a)
        {
            e(flag);
            return;
        }
        if (view.getId() != 0x7f100207)
        {
            break MISSING_BLOCK_LABEL_792;
        }
        if (!a.D() || g != null && (g.g || !g.h))
        {
            Log.e("ex", "cant changeCamera");
            return;
        }
        if (o != null)
        {
            if (c != null)
            {
                c.c();
            }
            o.a(CameraShutter.ShutterMode.NORMAL);
        }
        flag = a.N();
        if (flag && n != null)
        {
            findViewById(0x7f100684).setVisibility(0);
            findViewById(0x7f100685).setVisibility(0);
            l1 = n.g;
            if (l1 == 0)
            {
                view = n;
                if (((myobfuscated.db.a) (view)).d != null)
                {
                    i1 = ((myobfuscated.db.a) (view)).d.a;
                } else
                {
                    i1 = -1;
                }
                k1 = 0;
                j1 = i1;
                i1 = k1;
            } else
            {
                view = n;
                if (((myobfuscated.db.a) (view)).f != null)
                {
                    i1 = ((myobfuscated.db.a) (view)).f.c;
                } else
                {
                    i1 = -1;
                }
                j1 = 0;
            }
            B = false;
            if (f != null)
            {
                k1 = f.c;
            } else
            {
                k1 = 0;
            }
        } else
        {
            k1 = 0;
            i1 = 0;
            j1 = 0;
            l1 = 0;
        }
        if (h != null)
        {
            a(false);
        }
        if (flag && f != null && k1 != 0)
        {
            view = f;
            switch (k1)
            {
            case 21: // '\025'
                break MISSING_BLOCK_LABEL_744;
            }
        }
        if (a.v() == 1)
        {
            k1 = 0;
        } else
        {
            k1 = 1;
        }
        a.y();
        ((ViewGroup)findViewById(0x7f1001f7)).removeView((View)a);
        r = false;
        a = k();
        a.setEffectsController(f);
        a.setEffectOnSurfaceChanged(flag, l1, j1, i1);
        a.setCameraIndex(k1);
        view = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        view.addRule(13);
        ((View)a).setLayoutParams(view);
        ((ViewGroup)findViewById(0x7f1001f7)).addView((View)a, 0);
        AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.CameraActionEvent(s, "camera_rotate"));
        return;
        if (((a) (view)).p != null)
        {
            view = ((a) (view)).p;
            if (((n) (view)).i != null)
            {
                if (((n) (view)).c == 0)
                {
                    view.a(1);
                } else
                {
                    view.a(0);
                }
            }
        }
        break MISSING_BLOCK_LABEL_536;
        if (view.getId() != 0x7f100208)
        {
            break; /* Loop/switch isn't completed */
        }
        if (!a.N())
        {
            c(1);
            a(w);
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (view != W)
        {
            break; /* Loop/switch isn't completed */
        }
        view = c;
        if (((CameraShutter) (view)).a == CameraShutter.ShutterMode.TIMER)
        {
            ((CameraShutter) (view)).b.c();
            ((CameraShutter) (view)).e.a(((CameraShutter) (view)).b);
            return;
        }
        if (((CameraShutter) (view)).a == CameraShutter.ShutterMode.TIME_LAPSE)
        {
            ((CameraShutter) (view)).c.c();
            ((CameraShutter) (view)).e.a(((CameraShutter) (view)).c);
            return;
        }
        if (((CameraShutter) (view)).a == CameraShutter.ShutterMode.BURST)
        {
            ((CameraShutter) (view)).d.c();
            ((CameraShutter) (view)).e.a(((CameraShutter) (view)).d);
            return;
        }
        if (true) goto _L4; else goto _L5
_L5:
        if (view.getId() != 0x7f100226)
        {
            break; /* Loop/switch isn't completed */
        }
        if (o == null || o != null && !o.b())
        {
            if (c.a != CameraShutter.ShutterMode.NORMAL && c.a != CameraShutter.ShutterMode.TIMER || !a.B())
            {
                if (o == null)
                {
                    o = new com.socialin.picsin.camera.m(this, (RelativeLayout)findViewById(0x7f1001f5), new com.socialin.picsin.camera.o(this));
                }
                g(false);
                c.c();
                view = o;
                i1 = (int)(360F - (float)w);
                ((com.socialin.picsin.camera.m) (view)).a.setVisibility(0);
                view.a(i1);
                return;
            }
        } else
        {
            o.a();
            return;
        }
        if (true) goto _L4; else goto _L6
_L6:
        if (view.getId() == 0x7f100208)
        {
            c(1);
            return;
        }
        if (view.getId() != 0x7f100230) goto _L8; else goto _L7
_L7:
        if (a.N()) goto _L10; else goto _L9
_L9:
        l();
_L11:
        ((ImageView)findViewById(0x7f100228)).setImageBitmap(null);
        if (D != null && !D.isRecycled())
        {
            com.socialin.android.util.c.a(D, "CameraMainActivity");
        }
        E = null;
        if (d != null)
        {
            if (d.b)
            {
                view = new File(d.d);
                if (view.exists() && view.delete())
                {
                    new o(this, view.getAbsolutePath(), "image/*");
                }
            } else
            {
                d.c = 1;
            }
        }
        findViewById(0x7f100227).setVisibility(8);
        r();
_L12:
        AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.CameraCapturedActionEvent(s, "delete"));
        return;
_L10:
        if (!q()) goto _L12; else goto _L11
_L8:
        if (view.getId() == 0x7f10022e)
        {
            if (d != null)
            {
                if (d.b)
                {
                    a(d.d, d.a);
                } else
                {
                    Utils.c(this, getString(0x7f080471));
                }
            }
            AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.CameraCapturedActionEvent(s, "apply"));
            return;
        }
        if (view.getId() == 0x7f10022f)
        {
            if (a != null && a.N() && g != null && h != null && h.getVisibility() == 0 && (g.g || !g.h))
            {
                Log.e("ex", "cant export still saving in opengl");
                return;
            }
            AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.CameraCapturedActionEvent(s, "share"));
            l = true;
            if (d != null)
            {
                if (d.b)
                {
                    f(true);
                    return;
                } else
                {
                    d.c = 2;
                    b = com.socialin.android.dialog.g.a(this, getString(0x7f080679), false);
                    return;
                }
            } else
            {
                b = com.socialin.android.dialog.g.a(this, getString(0x7f080679), false);
                return;
            }
        }
        if (view.getId() != 0x7f100229)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (c != null && c.f || E == null) goto _L4; else goto _L13
_L13:
        file = new File(E);
        if (file.exists())
        {
            intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            uri = Uri.fromFile(file);
            view = "*/*";
            mimetypemap = MimeTypeMap.getSingleton();
            if (mimetypemap.hasExtension(MimeTypeMap.getFileExtensionFromUrl(uri.toString())))
            {
                view = mimetypemap.getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(uri.toString()));
            }
            intent.setDataAndType(Uri.fromFile(file), view);
            startActivity(Intent.createChooser(intent, "Select viewer"));
            return;
        }
        E = null;
        ((ImageView)findViewById(0x7f100228)).setImageBitmap(null);
        if (D != null && !D.isRecycled())
        {
            com.socialin.android.util.c.a(D, "CameraMainActivity");
        }
        D = null;
        findViewById(0x7f100227).setVisibility(8);
        Utils.c(this, getString(0x7f080242));
        return;
        if (view.getId() != 0x7f100231) goto _L4; else goto _L14
_L14:
        if (!a.N())
        {
            l();
        } else
        {
            q();
        }
        AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.CameraCapturedActionEvent(s, "close"));
        return;
    }

    public void onCreate(Bundle bundle)
    {
        Object obj;
        super.onCreate(bundle);
        obj = getFragmentManager().findFragmentByTag(myobfuscated.db.a.a);
        if (obj != null)
        {
            ((myobfuscated.db.a)obj).b = true;
        }
        setContentView(0x7f03004b);
        setRequestedOrientation(0);
        android.view.View.OnClickListener onclicklistener;
        int i1;
        try
        {
            i1 = getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((android.content.pm.PackageManager.NameNotFoundException) (obj)).printStackTrace();
            i1 = 0;
        }
        if (i1 <= 56)
        {
            Object obj1 = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/").append(getResources().getString(0x7f0808fc)).toString();
            obj = new File((new StringBuilder()).append(((String) (obj1))).append("/Camera/").toString());
            obj1 = new File((new StringBuilder()).append(((String) (obj1))).append("/").append(getResources().getString(0x7f0808c3)).append("/").toString());
            ((File) (obj)).renameTo(((File) (obj1)));
            new o(this, ((File) (obj1)).getAbsolutePath(), "image/*");
        }
        y = new OrientationEventListener(this) {

            private CameraMainActivity a;

            public final void onOrientationChanged(int j1)
            {
                int k1 = com.socialin.picsin.camera.CameraMainActivity.a(a);
                j1 = ((com.socialin.picsin.camera.CameraMainActivity.b(a) + j1 + 45) / 90) * 90;
                com.socialin.picsin.camera.CameraMainActivity.a(a, (j1 + 90) % 360);
                if (com.socialin.picsin.camera.CameraMainActivity.a(a) != k1)
                {
                    (new StringBuilder("rotation: ")).append(com.socialin.picsin.camera.CameraMainActivity.a(a)).append(" orientation:").append(j1);
                    com.socialin.picsin.camera.CameraMainActivity.a(a);
                    com.socialin.picsin.camera.CameraMainActivity.a(a, a.findViewById(0x7f100203));
                    com.socialin.picsin.camera.CameraMainActivity.a(a, a.findViewById(0x7f100205));
                    com.socialin.picsin.camera.CameraMainActivity.a(a, a.findViewById(0x7f100204));
                    com.socialin.picsin.camera.CameraMainActivity.a(a, a.findViewById(0x7f100207));
                    com.socialin.picsin.camera.CameraMainActivity.a(a, a.findViewById(0x7f100208));
                    com.socialin.picsin.camera.CameraMainActivity.a(a, a.findViewById(0x7f100223));
                    com.socialin.picsin.camera.CameraMainActivity.a(a, a.findViewById(0x7f100224));
                    com.socialin.picsin.camera.CameraMainActivity.a(a, a.findViewById(0x7f100226));
                    com.socialin.picsin.camera.CameraMainActivity.a(a, a.findViewById(0x7f10022a));
                    com.socialin.picsin.camera.CameraMainActivity.a(a, com.socialin.picsin.camera.CameraMainActivity.a(a));
                }
            }

            
            {
                a = CameraMainActivity.this;
                super(context, 1);
            }
        };
        obj = getIntent().getExtras();
        if (getIntent().getStringExtra("from.where.opened") == null) goto _L2; else goto _L1
_L1:
        u = getIntent().getStringExtra("from.where.opened");
        if (obj != null)
        {
            v = ((Bundle) (obj)).get("output");
        }
_L5:
        Object obj2;
        String s1;
        if (bundle == null)
        {
            if (obj != null)
            {
                s = ((Bundle) (obj)).getString("session_id");
            }
            AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.CameraOpenEvent(s));
        } else
        {
            s = bundle.getString("session_id");
        }
        c = new CameraShutter(this, this);
        a = k();
        i1 = Integer.parseInt(android.os.Build.VERSION.SDK);
        bundle = (ViewGroup)findViewById(0x7f1001f7);
        obj = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(13);
        ((View)a).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        bundle.addView((View)a, 0);
        if (i1 >= 8 && com.socialin.camera.opengl.a.a(this))
        {
            bundle = findViewById(0x7f100223);
            bundle.setVisibility(0);
            obj = findViewById(0x7f100224);
            onclicklistener = new android.view.View.OnClickListener() {

                private CameraMainActivity a;

                public final void onClick(View view)
                {
                    com.socialin.picsin.camera.CameraMainActivity.d(a, view.getId());
                    if (view.getId() == 0x7f100224)
                    {
                        AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.EventsFactory.CameraActionEvent(com.socialin.picsin.camera.CameraMainActivity.n(a), "mask"));
                        return;
                    } else
                    {
                        AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.EventsFactory.CameraActionEvent(com.socialin.picsin.camera.CameraMainActivity.n(a), "fx"));
                        return;
                    }
                }

            
            {
                a = CameraMainActivity.this;
                super();
            }
            };
            bundle.setOnClickListener(onclicklistener);
            ((View) (obj)).setOnClickListener(onclicklistener);
        }
        bundle = (ViewGroup)LayoutInflater.from(this).inflate(0x7f030137, null);
        bundle.setClickable(true);
        bundle.setOnClickListener(new android.view.View.OnClickListener() {

            public final void onClick(View view)
            {
            }

        });
        addContentView(bundle, new android.view.ViewGroup.LayoutParams(-1, -1));
        findViewById(0x7f10022a).setOnTouchListener(new android.view.View.OnTouchListener() {

            private CameraMainActivity a;

            public final boolean onTouch(View view, MotionEvent motionevent)
            {
                if (motionevent.getAction() == 0 && com.socialin.picsin.camera.CameraMainActivity.c(a) != null)
                {
                    com.socialin.picsin.camera.CameraMainActivity.d(a);
                }
                return false;
            }

            
            {
                a = CameraMainActivity.this;
                super();
            }
        });
        i();
        bundle = myobfuscated.az.b.b(this);
        if (bundle != null)
        {
            bundle.a(this);
        }
        V = myobfuscated.f.m.a(this);
        return;
_L2:
        obj2 = getIntent().getCategories();
        if (obj2 != null) goto _L4; else goto _L3
_L3:
        u = "from.other.app";
        if (obj != null)
        {
            v = ((Bundle) (obj)).get("output");
        }
_L6:
        findViewById(0x7f10022f).setVisibility(8);
          goto _L5
_L4:
        obj2 = ((Set) (obj2)).iterator();
_L8:
        if (((Iterator) (obj2)).hasNext())
        {
            s1 = (String)((Iterator) (obj2)).next();
            if (!s1.equals("android.intent.category.LAUNCHER"))
            {
                continue; /* Loop/switch isn't completed */
            }
            u = "from.launcher";
        }
          goto _L6
        if (!s1.equals("android.intent.category.DEFAULT")) goto _L8; else goto _L7
_L7:
        u = "from.other.app";
        if (obj != null)
        {
            v = ((Bundle) (obj)).get("output");
        }
          goto _L6
    }

    protected void onDestroy()
    {
        Object obj;
        y.disable();
        obj = getPreferences(0).edit();
        try
        {
            ((android.content.SharedPreferences.Editor) (obj)).putString("camera.saved.properties", a.b());
        }
        catch (Exception exception1)
        {
            ((android.content.SharedPreferences.Editor) (obj)).remove("camera.saved.properties");
        }
        ((android.content.SharedPreferences.Editor) (obj)).putBoolean("camera.sound", a.w());
        if (a.x() != 640) goto _L2; else goto _L1
_L1:
        ((android.content.SharedPreferences.Editor) (obj)).putInt("image.size", 0);
_L4:
        ((android.content.SharedPreferences.Editor) (obj)).commit();
        Exception exception2;
        try
        {
            if (e != null)
            {
                e.b();
            }
            a.y();
        }
        catch (Exception exception) { }
        if (h != null)
        {
            b(true);
        }
        if (e != null)
        {
            e.c();
        }
        if (c != null)
        {
            c.h.release();
        }
        if (N != null)
        {
            obj = N.getLooper();
            if (obj != null)
            {
                ((Looper) (obj)).quit();
            }
        }
        ((ImageView)findViewById(0x7f10022c)).setImageBitmap(null);
        if (i != null && !i.isRecycled())
        {
            com.socialin.android.util.c.a(i, "CameraMainActivity");
        }
        i = null;
        super.onDestroy();
        return;
_L2:
        if (a.x() != 1024) goto _L4; else goto _L3
_L3:
        ((android.content.SharedPreferences.Editor) (obj)).putInt("image.size", 1);
          goto _L4
        exception2;
        exception2.printStackTrace();
          goto _L4
    }

    public void onItemClick(AdapterView adapterview, View view, int i1, long l1)
    {
        boolean flag;
        flag = false;
        if (o != null && o.b())
        {
            o.a();
        }
        if (n != null && n.c())
        {
            n.b(false);
        }
        adapterview = adapterview.getAdapter();
        if (!(adapterview instanceof SettingsListAdapter)) goto _L2; else goto _L1
_L1:
        adapterview = (e)((SettingsListAdapter)adapterview).get(i1);
        if (!((e) (adapterview)).a.equals("White Balance") && !((e) (adapterview)).a.equals("ISO") && !((e) (adapterview)).a.equals("Resolution") && !((e) (adapterview)).a.equals("Scene Modes") && !((e) (adapterview)).a.equals("Image Size") && !((e) (adapterview)).a.equals("Effects")) goto _L4; else goto _L3
_L3:
        view = (ViewFlipper)findViewById(0x7f10020f);
        if (((e) (adapterview)).a.equals("Effects")) goto _L6; else goto _L5
_L5:
        f f1;
        int j1;
        a(5, w);
        ((ListView)view.findViewById(0x7f10021e)).setAdapter(((e) (adapterview)).e);
        view = (ListView)view.findViewById(0x7f10021e);
        f1 = (f)((e) (adapterview)).e;
        adapterview = ((e) (adapterview)).b;
        j1 = f1.getCount();
        i1 = ((flag) ? 1 : 0);
_L18:
        if (i1 >= j1) goto _L8; else goto _L7
_L7:
        if (!((String)f1.getItem(i1)).equals(adapterview)) goto _L10; else goto _L9
_L9:
        view.setItemChecked(i1, true);
_L12:
        return;
_L10:
        i1++;
        continue; /* Loop/switch isn't completed */
_L8:
        i1 = -1;
          goto _L9
_L6:
        a(6, w);
        return;
_L4:
        if (((e) (adapterview)).a.equals("Geo tag")) goto _L12; else goto _L11
_L11:
        if (((e) (adapterview)).a.equals("Sound"))
        {
            boolean flag1;
            if (!((e) (adapterview)).d)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            adapterview.d = flag1;
            a.setPlayShutter(((e) (adapterview)).d);
            if (((e) (adapterview)).d)
            {
                adapterview.b = "on";
            } else
            {
                adapterview.b = "off";
            }
            if (c != null)
            {
                c.i = ((e) (adapterview)).d;
            }
            ((CheckBox)view.findViewWithTag("Sound")).setChecked(((e) (adapterview)).d);
            ((TextView)view.findViewWithTag("Sound_value")).setText(((e) (adapterview)).b);
            return;
        }
        if (!((e) (adapterview)).a.equals("Reset defaults")) goto _L12; else goto _L13
_L13:
        if (h != null)
        {
            p();
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        a.setDefaultProperties();
        a.setPlayShutter(true);
        if (c != null)
        {
            c.i = true;
        }
        m();
        if (i1 == 0) goto _L12; else goto _L14
_L14:
        ((CameraViewCupcake)a).setVisibility(4);
        ((CameraViewCupcake)a).setVisibility(0);
        return;
_L2:
        if (!(adapterview instanceof f))
        {
            continue; /* Loop/switch isn't completed */
        }
        adapterview = (f)adapterview;
        view = (String)adapterview.getItem(i1);
        if (((f) (adapterview)).a == 2)
        {
            a.setIso(view);
        } else
        if (((f) (adapterview)).a == 3)
        {
            a.setPictureSize(Integer.valueOf(view.substring(0, view.indexOf("x"))).intValue(), Integer.valueOf(view.substring(view.indexOf("x") + 1, view.length())).intValue());
        } else
        if (((f) (adapterview)).a == 4)
        {
            a.setSceneMode(view);
        } else
        if (((f) (adapterview)).a == 1)
        {
            a.setWhiteBalance(view);
        }
        if (!a.d())
        {
            Utils.c(this, getString(0x7f0804ac));
            return;
        }
          goto _L12
        if (!(adapterview instanceof com.socialin.picsin.camera.a)) goto _L12; else goto _L15
_L15:
        adapterview = (String)((com.socialin.picsin.camera.a)adapterview).getItem(i1);
        a.setEffect(adapterview);
        if (a.d()) goto _L12; else goto _L16
_L16:
        Utils.c(this, getString(0x7f0804ac));
        return;
        if (true) goto _L18; else goto _L17
_L17:
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        boolean flag;
        boolean flag1;
        flag1 = true;
        flag = flag1;
        i1;
        JVM INSTR lookupswitch 5: default 60
    //                   4: 222
    //                   24: 80
    //                   25: 80
    //                   27: 71
    //                   82: 68;
           goto _L1 _L2 _L3 _L3 _L4 _L5
_L1:
        flag = super.onKeyDown(i1, keyevent);
_L5:
        return flag;
_L4:
        c.a();
        return true;
_L3:
        flag = flag1;
        if (!r)
        {
            continue; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (findViewById(0x7f10022b).getVisibility() == 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (a == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (!a.C())
        {
            continue; /* Loop/switch isn't completed */
        }
        keyevent = findViewById(0x7f100684);
        if (keyevent == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (keyevent.getVisibility() == 0) goto _L5; else goto _L6
_L6:
        j();
        View view;
        View view1;
        if (o != null && o.b())
        {
            o.a();
            flag = true;
        } else
        {
            flag = false;
        }
        if (n != null && n.c())
        {
            n.b(false);
        }
        e(flag);
        return true;
_L2:
        if (!r)
        {
            break; /* Loop/switch isn't completed */
        }
        view = findViewById(0x7f100684);
        view1 = findViewById(0x7f100685);
        if (view == null || view1 == null || a == null || view.getVisibility() != 0 && view1.getVisibility() != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        if (a.N())
        {
            flag = flag1;
            if (g != null)
            {
                flag = flag1;
                if (g.h)
                {
                    flag = flag1;
                    if (!g.g)
                    {
                        flag = flag1;
                        if (a.D())
                        {
                            view.setVisibility(8);
                            view1.setVisibility(8);
                            a(true);
                            return true;
                        }
                    }
                }
            }
        } else
        {
            flag = flag1;
            if (B)
            {
                view.setVisibility(8);
                view1.setVisibility(8);
                return true;
            }
        }
        if (true) goto _L5; else goto _L7
_L7:
        if (o != null && o.b())
        {
            o.a();
            return true;
        }
        if (c != null && c.a != CameraShutter.ShutterMode.NORMAL && c.f)
        {
            c.c();
            c.b();
            g(false);
            c.f = false;
            c.g = true;
            return true;
        }
        if (findViewById(0x7f10022b).getVisibility() == 0)
        {
            AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.CameraCapturedActionEvent(s, "close"));
            if (!a.N())
            {
                l();
                r();
                return true;
            } else
            {
                q();
                return true;
            }
        }
        if (((ViewFlipper)findViewById(0x7f1001fb)).getDisplayedChild() != 0)
        {
            switch (((ViewFlipper)findViewById(0x7f10020f)).getDisplayedChild())
            {
            default:
                c(0);
                return true;

            case 5: // '\005'
            case 6: // '\006'
                a(4, w);
                break;
            }
            b();
            return true;
        }
        if (a.D())
        {
            return super.onKeyDown(i1, keyevent);
        } else
        {
            Log.e("ex", "cant back");
            return true;
        }
    }

    public boolean onKeyUp(int i1, KeyEvent keyevent)
    {
        switch (i1)
        {
        default:
            return super.onKeyUp(i1, keyevent);

        case 23: // '\027'
            c.a();
            break;
        }
        return true;
    }

    public boolean onLongClick(View view)
    {
        return false;
    }

    protected void onPause()
    {
        A = true;
        super.onPause();
        if (c != null)
        {
            c.c();
        }
        if (g != null)
        {
            g.f = false;
        }
        if (h != null)
        {
            h.onResume();
        }
    }

    public void onPictureTaken(byte abyte0[], Camera camera)
    {
        if (!isFinishing() && abyte0 != null && a.c() != null)
        {
            x = w;
            ((AudioManager)getSystemService("audio")).setStreamMute(1, false);
            if (a.w())
            {
                MediaPlayer mediaplayer = MediaPlayer.create(this, 0x7f070002);
                if (mediaplayer != null)
                {
                    mediaplayer.start();
                }
            }
            j = System.currentTimeMillis();
            l = false;
            if (Integer.parseInt(android.os.Build.VERSION.SDK) >= 8 && ((CameraViewCupcake)a).k && f.c != 0)
            {
                if (f.c == 21 && h != null)
                {
                    android.hardware.Camera.Size size = camera.getParameters().getPictureSize();
                    int i1 = n();
                    h.queueEvent(new Runnable(abyte0, size, i1) {

                        private byte a[];
                        private android.hardware.Camera.Size b;
                        private int c;
                        private CameraMainActivity d;

                        public final void run()
                        {
                            a a1;
                            byte abyte1[];
                            int i2;
                            int k3;
                            boolean flag1;
                            a1 = com.socialin.picsin.camera.CameraMainActivity.o(d);
                            abyte1 = a;
                            k3 = b.width;
                            i2 = b.height;
                            i2 = c;
                            flag1 = com.socialin.picsin.camera.CameraMainActivity.c(d).z();
                            a1.c;
                            JVM INSTR tableswitch 21 21: default 76
                        //                                       21 77;
                               goto _L1 _L2
_L1:
                            return;
_L2:
                            if (a1.p == null) goto _L1; else goto _L3
_L3:
                            if (a1.t == -1)
                            {
                                int ai[] = new int[1];
                                GLES20.glGenTextures(1, ai, 0);
                                a1.t = ai[0];
                            }
                            if (a1.p == null) goto _L1; else goto _L4
_L4:
                            n n1;
                            Activity activity;
                            int j2;
                            int k2;
                            int l2;
                            a1.v = true;
                            a1.p.j = i2;
                            n1 = a1.p;
                            activity = a1.a;
                            k2 = ((ac)a1.b.get(Integer.valueOf(a1.c))).a;
                            l2 = a1.t;
                            j2 = a1.u;
                            i2 = j2;
                            if (!a1.v) goto _L6; else goto _L5
_L5:
                            int i3;
                            int j3;
                            i3 = n1.g;
                            j3 = n1.h;
                            if (abyte1 == null) goto _L8; else goto _L7
_L7:
                            Object obj2;
                            obj2 = new android.graphics.BitmapFactory.Options();
                            obj2.inSampleSize = (int)((float)k3 / (float)CameraViewCupcake.m);
                            if (((android.graphics.BitmapFactory.Options) (obj2)).inSampleSize <= 0)
                            {
                                obj2.inSampleSize = 1;
                            }
                            obj2.inPreferredConfig = android.graphics.Bitmap.Config.ARGB_8888;
                            obj2 = com.socialin.android.util.c.a(abyte1, 0, abyte1.length, ((android.graphics.BitmapFactory.Options) (obj2)));
                            if (obj2 != null && !((Bitmap) (obj2)).isRecycled()) goto _L10; else goto _L9
_L9:
                            j2 = 10;
_L11:
                            a1.u = j2;
                            a1.p.k = flag1;
                            a1.v = false;
                            return;
_L10:
                            n1.g = ((Bitmap) (obj2)).getWidth();
                            n1.h = ((Bitmap) (obj2)).getHeight();
                            i2 = ((Bitmap) (obj2)).getRowBytes();
                            int l3 = ((Bitmap) (obj2)).getHeight();
                            i2 *= l3;
_L12:
                            if (obj2 != null && (!((Bitmap) (obj2)).isMutable() || i2 != n1.g * n1.h * 4))
                            {
                                Bitmap bitmap = com.socialin.android.util.c.a(n1.g, n1.h, android.graphics.Bitmap.Config.ARGB_8888);
                                Canvas canvas = new Canvas(bitmap);
                                Paint paint = new Paint();
                                paint.setFilterBitmap(true);
                                paint.setDither(true);
                                canvas.drawBitmap(((Bitmap) (obj2)), 0.0F, 0.0F, paint);
                                ((Bitmap) (obj2)).recycle();
                                obj2 = bitmap;
                            }
                            if (l2 >= 0 && abyte1 != null)
                            {
                                GLES20.glActiveTexture(33985);
                                GLES20.glBindTexture(3553, l2);
                            }
                            if (abyte1 != null || obj2 != null && (((Bitmap) (obj2)).getWidth() > j2 || ((Bitmap) (obj2)).getHeight() > j2))
                            {
                                i2 = 1024;
                                if (obj2 != null)
                                {
                                    i2 = myobfuscated.f.m.a(Math.max(((Bitmap) (obj2)).getWidth(), ((Bitmap) (obj2)).getHeight()));
                                }
                                ByteBuffer bytebuffer = ImageOpCommon.allocNativeBuffer(i2 * i2 * 4);
                                bytebuffer.position(0);
                                GLES20.glTexImage2D(3553, 0, 6408, i2, i2, 0, 6408, 5121, bytebuffer);
                                GLES20.glTexParameterf(3553, 10241, 9729F);
                                GLES20.glTexParameterf(3553, 10240, 9729F);
                                GLES20.glTexParameteri(3553, 10242, 10497);
                                GLES20.glTexParameteri(3553, 10243, 10497);
                                myobfuscated.f.m.i("glTexImage2D");
                                ImageOpCommon.freeNativeBuffer(bytebuffer);
                            } else
                            {
                                i2 = j2;
                            }
                            if (obj2 != null)
                            {
                                float f3;
                                float f4;
                                float f5;
                                if (n1.i == null)
                                {
                                    n1.i = ImageOpCommon.allocNativeBuffer(n1.g * n1.h * 4);
                                    n1.i.position(0);
                                    ((Bitmap) (obj2)).copyPixelsToBuffer(n1.i);
                                    if (obj2 != null && !((Bitmap) (obj2)).isRecycled())
                                    {
                                        ((Bitmap) (obj2)).recycle();
                                    }
                                    n1.i.position(0);
                                } else
                                {
                                    ByteBuffer bytebuffer1 = ImageOpCommon.allocNativeBuffer(n1.g * n1.h * 4);
                                    bytebuffer1.position(0);
                                    ((Bitmap) (obj2)).copyPixelsToBuffer(bytebuffer1);
                                    if (obj2 != null && !((Bitmap) (obj2)).isRecycled())
                                    {
                                        ((Bitmap) (obj2)).recycle();
                                    }
                                    bytebuffer1.position(0);
                                    n1.i.position(0);
                                    j2 = n1.g;
                                    int i4 = n1.h;
                                    obj2 = n1.i;
                                    int j4 = com.socialin.camera.opengl.n.a(n1.b);
                                    int k4 = (int)n1.a;
                                    boolean flag;
                                    if (n1.c == 1)
                                    {
                                        flag = true;
                                    } else
                                    {
                                        flag = false;
                                    }
                                    ImageOpCommon.centerCropBlend(bytebuffer1, j2, i4, ((java.nio.Buffer) (obj2)), i3, j3, j4, k4, flag);
                                    bytebuffer1.position(0);
                                    ImageOpCommon.freeNativeBuffer(n1.i);
                                    n1.i = bytebuffer1;
                                }
                                n1.a(0);
                                f4 = n1.g;
                                f5 = n1.h;
                                if (f4 > 128F || f5 > 128F)
                                {
                                    Bitmap bitmap1;
                                    ByteBuffer bytebuffer2;
                                    if (128F / f4 < 128F / f5)
                                    {
                                        f3 = 128F / f4;
                                    } else
                                    {
                                        f3 = 128F / f5;
                                    }
                                    f5 = f3 * f5;
                                    f4 *= f3;
                                    f3 = f5;
                                } else
                                {
                                    f3 = f5;
                                }
                                obj2 = new Point((int)f4, (int)f3);
                                j2 = ((Point) (obj2)).x;
                                i3 = ((Point) (obj2)).y;
                                bytebuffer2 = ImageOpCommon.allocNativeBuffer(j2 * i3 * 4);
                                ImageResize.resize(n1.i, n1.g, n1.h, bytebuffer2, j2, i3, 1);
                                bitmap1 = com.socialin.android.util.c.a(j2, i3, android.graphics.Bitmap.Config.ARGB_8888);
                                obj2 = bitmap1;
                                if (bitmap1 != null)
                                {
                                    bytebuffer2.position(0);
                                    bitmap1.copyPixelsFromBuffer(bytebuffer2);
                                    obj2 = com.socialin.android.util.w.c(bitmap1, n1.j);
                                }
                                ImageOpCommon.freeNativeBuffer(bytebuffer2);
                                activity.runOnUiThread(new com.socialin.camera.opengl.n._cls5(n1, ((Bitmap) (obj2))));
                                if (n1.e != null)
                                {
                                    n1.e.d();
                                }
                                GLES20.glTexSubImage2D(3553, 0, 0, 0, n1.g, n1.h, 6408, 5121, n1.i);
                                myobfuscated.f.m.i("glTexSubImage2D");
                            }
_L6:
                            j2 = i2;
                            if (l2 >= 0)
                            {
                                j2 = i2;
                                if (abyte1 != null)
                                {
                                    GLES20.glActiveTexture(33985);
                                    GLES20.glBindTexture(3553, l2);
                                    GLES20.glUniform1i(GLES20.glGetUniformLocation(k2, "sTexture2"), 1);
                                    GLES20.glUniform1f(GLES20.glGetUniformLocation(k2, "texture2Size"), i2);
                                    GLES20.glUniform1f(GLES20.glGetUniformLocation(k2, "texture2Width"), n1.g);
                                    GLES20.glUniform1f(GLES20.glGetUniformLocation(k2, "texture2Height"), n1.h);
                                    j2 = i2;
                                }
                            }
                              goto _L11
_L8:
                            obj2 = null;
                            i2 = 0;
                              goto _L12
                        }

            
            {
                d = CameraMainActivity.this;
                a = abyte0;
                b = size;
                c = i1;
                super();
            }
                    });
                    e.a(camera);
                    camera.startPreview();
                    e.a();
                    b = com.socialin.android.dialog.g.a(this, getString(0x7f080679), false);
                    return;
                }
                d = null;
                if (g != null)
                {
                    g.b = n();
                    g.g = true;
                }
                k = false;
                long l1 = g.w;
                e.b();
                Object obj = new android.graphics.BitmapFactory.Options();
                obj.inSampleSize = (int)((float)camera.getParameters().getPictureSize().width / (float)CameraViewCupcake.m);
                if (((android.graphics.BitmapFactory.Options) (obj)).inSampleSize <= 0)
                {
                    obj.inSampleSize = 1;
                }
                obj.inPreferredConfig = android.graphics.Bitmap.Config.ARGB_8888;
                abyte0 = com.socialin.android.util.c.a(abyte0, 0, abyte0.length, ((android.graphics.BitmapFactory.Options) (obj)));
                if (abyte0 == null)
                {
                    e.a(camera);
                    a.A();
                    e.a();
                    Utils.c(this, getString(0x7f0805ca));
                    (new Handler()).post(new Runnable() {

                        private CameraMainActivity a;

                        public final void run()
                        {
                            if (CameraMainActivity.p(a) != null)
                            {
                                CameraMainActivity.p(a).g = false;
                            }
                        }

            
            {
                a = CameraMainActivity.this;
                super();
            }
                    });
                    return;
                }
                int j1 = abyte0.getWidth();
                int k1 = abyte0.getHeight();
                if (j1 > CameraViewCupcake.m || k1 > CameraViewCupcake.n)
                {
                    float f1 = (float)CameraViewCupcake.m / (float)j1;
                    float f2 = (float)CameraViewCupcake.n / (float)k1;
                    if (f1 >= f2)
                    {
                        f1 = f2;
                    }
                    j1 = (int)((float)j1 * f1);
                    k1 = (int)(f1 * (float)k1);
                    abyte0 = com.socialin.android.util.w.a(abyte0, j1, k1);
                }
                if (!f.b())
                {
                    obj = ImageOpCommon.allocNativeBuffer(abyte0.getWidth() * abyte0.getHeight() * 4);
                    ((ByteBuffer) (obj)).position(0);
                    abyte0.copyPixelsToBuffer(((java.nio.Buffer) (obj)));
                    ((ByteBuffer) (obj)).position(0);
                    abyte0.recycle();
                    camera = null;
                    abyte0 = ((byte []) (obj));
                } else
                {
                    Object obj1 = null;
                    camera = abyte0;
                    abyte0 = obj1;
                }
                if (g == null || g != null && l1 != g.w)
                {
                    if (abyte0 != null)
                    {
                        ImageOpCommon.freeNativeBuffer(abyte0);
                    }
                    if (camera != null && !camera.isRecycled())
                    {
                        camera.recycle();
                        return;
                    }
                } else
                {
                    ((ImageView)findViewById(0x7f10022c)).setImageBitmap(null);
                    if (i != null && !i.isRecycled())
                    {
                        com.socialin.android.util.c.a(i);
                        i = null;
                    }
                    if (isFinishing())
                    {
                        if (abyte0 != null)
                        {
                            ImageOpCommon.freeNativeBuffer(abyte0);
                        }
                        if (camera != null && !camera.isRecycled())
                        {
                            camera.recycle();
                            return;
                        }
                    } else
                    {
                        i = g.b();
                        findViewById(0x7f10022b).setVisibility(0);
                        a(8);
                        findViewById(0x7f100210).setVisibility(8);
                        if (i != null && !i.isRecycled())
                        {
                            ((ImageView)findViewById(0x7f10022c)).setImageBitmap(i);
                        }
                        h();
                        if (C == null)
                        {
                            C = new Handler();
                        }
                        C.postDelayed(new Runnable(abyte0, camera, l1, j1, k1) {

                            private ByteBuffer a;
                            private Bitmap b;
                            private long c;
                            private int d;
                            private int e;
                            private CameraMainActivity f;

                            public final void run()
                            {
                                if (!f.isFinishing()) goto _L2; else goto _L1
_L1:
                                if (a != null)
                                {
                                    ImageOpCommon.freeNativeBuffer(a);
                                }
                                if (b != null && !b.isRecycled())
                                {
                                    b.recycle();
                                }
_L4:
                                return;
_L2:
                                if (CameraMainActivity.p(f) == null || CameraMainActivity.p(f).w == c)
                                {
                                    break; /* Loop/switch isn't completed */
                                }
                                if (a != null)
                                {
                                    ImageOpCommon.freeNativeBuffer(a);
                                    return;
                                }
                                if (true) goto _L4; else goto _L3
_L3:
                                Object obj2;
                                obj2 = CameraMainActivity.p(f);
                                obj2 = new Point(((h) (obj2)).k, ((h) (obj2)).l);
                                if ((((Point) (obj2)).x != d || ((Point) (obj2)).y != e) && !com.socialin.picsin.camera.CameraMainActivity.o(f).b()) goto _L6; else goto _L5
_L5:
                                CameraMainActivity.q(f);
                                int i2 = -1;
                                Bitmap bitmap;
                                if (com.socialin.picsin.camera.CameraMainActivity.o(f).b())
                                {
                                    bitmap = b;
                                    i2 = com.socialin.picsin.camera.CameraMainActivity.o(f).c;
                                } else
                                {
                                    bitmap = com.socialin.android.util.c.b(CameraMainActivity.r(f), android.graphics.Bitmap.Config.ARGB_8888);
                                }
                                if (a != null)
                                {
                                    ImageOpCommon.freeNativeBuffer(a);
                                }
                                f.d = new com.socialin.picsin.camera.d(f, bitmap, CameraMainActivity.s(f), i2, com.socialin.picsin.camera.CameraMainActivity.c(f).z());
                                f.d.start();
                                if (CameraMainActivity.p(f) != null)
                                {
                                    CameraMainActivity.p(f).g = false;
                                }
_L8:
                                com.socialin.picsin.camera.CameraMainActivity.c(f).setPictureTaking(false);
                                com.socialin.picsin.camera.CameraMainActivity.a(f, com.socialin.android.dialog.g.a(f, null, f.getString(0x7f080679)));
                                CameraMainActivity.u(f).setCancelable(false);
                                return;
_L6:
                                if (CameraMainActivity.p(f) != null && CameraMainActivity.t(f) != null)
                                {
                                    h h1 = CameraMainActivity.p(f);
                                    ByteBuffer bytebuffer = a;
                                    int j2 = d;
                                    int k2 = e;
                                    h1.s = 0;
                                    h1.n = true;
                                    h1.o = bytebuffer;
                                    h1.p = myobfuscated.f.m.a(Math.max(j2, k2));
                                    h1.q = j2;
                                    h1.r = k2;
                                    h1.m = (new float[] {
                                        0.0F, (float)k2 / (float)h1.p, (float)j2 / (float)h1.p, (float)k2 / (float)h1.p, 0.0F, 0.0F, (float)j2 / (float)h1.p, 0.0F
                                    });
                                    h1.j = com.socialin.camera.opengl.h.a(h1.m);
                                    CameraMainActivity.t(f).setLayoutParams(new android.widget.LinearLayout.LayoutParams(d, e));
                                }
                                if (true) goto _L8; else goto _L7
_L7:
                            }

            
            {
                f = CameraMainActivity.this;
                a = bytebuffer;
                b = bitmap;
                c = l1;
                d = i1;
                e = j1;
                super();
            }
                        }, 300L);
                        return;
                    }
                }
            }
            while (false) 
            {
                findViewById(0x7f100227).setVisibility(0);
                E = null;
                camera = a.c().getParameters().getPictureSize();
                obj = (ImageView)findViewById(0x7f100228);
                ((ImageView) (obj)).setImageBitmap(null);
                if (D != null && !D.isRecycled())
                {
                    com.socialin.android.util.c.a(D, "CameraMainActivity");
                    D = null;
                }
                (new Thread(new Runnable(camera, abyte0, ((ImageView) (obj))) {

                    final ImageView a;
                    final CameraMainActivity b;
                    private android.hardware.Camera.Size c;
                    private byte d[];

                    public final void run()
                    {
                        float f3 = Math.min(128F / (float)c.width, 128F / (float)c.height);
                        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
                        options.inSampleSize = (int)(1.0F / f3);
                        com.socialin.picsin.camera.CameraMainActivity.b(b, com.socialin.android.util.c.a(d, 0, d.length, options));
                        com.socialin.picsin.camera.CameraMainActivity.b(b, com.socialin.android.util.w.d(com.socialin.picsin.camera.CameraMainActivity.w(b), CameraMainActivity.s(b)));
                        b.runOnUiThread(new Runnable(this) {

                            private _cls9 a;

                            public final void run()
                            {
                                if (com.socialin.picsin.camera.CameraMainActivity.w(a.b) != null && !com.socialin.picsin.camera.CameraMainActivity.w(a.b).isRecycled())
                                {
                                    a.a.setImageBitmap(com.socialin.picsin.camera.CameraMainActivity.w(a.b));
                                    return;
                                } else
                                {
                                    com.socialin.picsin.camera.CameraMainActivity.b(a.b, null);
                                    return;
                                }
                            }

            
            {
                a = _pcls9;
                super();
            }
                        });
                    }

            
            {
                b = CameraMainActivity.this;
                c = size;
                d = abyte0;
                a = imageview;
                super();
            }
                })).start();
                if (c.a == CameraShutter.ShutterMode.NORMAL || c.a == CameraShutter.ShutterMode.TIMER)
                {
                    k = false;
                    if (o != null)
                    {
                        o.a(CameraShutter.ShutterMode.NORMAL);
                    }
                    g(false);
                    ((ImageView)findViewById(0x7f10022c)).setImageBitmap(null);
                    if (!I)
                    {
                        if (i != null && !i.isRecycled())
                        {
                            com.socialin.android.util.c.a(i);
                            i = null;
                        }
                    } else
                    {
                        J = true;
                    }
                    (new Thread(new Runnable(camera, abyte0) {

                        final CameraMainActivity a;
                        private android.hardware.Camera.Size b;
                        private byte c[];

                        public final void run()
                        {
                            float f3;
                            android.graphics.BitmapFactory.Options options;
                            int i2;
                            if (b.width > 1024 || b.height > 1024)
                            {
                                f3 = Math.min(1024F / (float)b.width, 1024F / (float)b.height);
                            } else
                            {
                                f3 = 1.0F;
                            }
                            options = new android.graphics.BitmapFactory.Options();
                            options.inSampleSize = (int)(1.0F / f3);
                            if ((double)f3 < 0.75D && (double)f3 > 0.5D)
                            {
                                options.inSampleSize = 2;
                            }
                            options.inPreferredConfig = android.graphics.Bitmap.Config.ARGB_8888;
                            com.socialin.picsin.camera.CameraMainActivity.a(a, com.socialin.android.util.c.a(c, 0, c.length, options));
                            i2 = com.socialin.picsin.camera.CameraMainActivity.c(a).E();
                            if (i2 == 180)
                            {
                                com.socialin.picsin.camera.CameraMainActivity.a(a, com.socialin.android.util.w.d(CameraMainActivity.r(a), i2));
                            }
                            if (com.socialin.picsin.camera.CameraMainActivity.c(a).z() && CameraMainActivity.r(a) != null)
                            {
                                com.socialin.picsin.camera.CameraMainActivity.a(a, com.socialin.android.util.w.a(CameraMainActivity.r(a), -1F));
                            }
                            com.socialin.picsin.camera.CameraMainActivity.b(a, false);
                            a.runOnUiThread(new Runnable(this) {

                                private _cls8 a;

                                public final void run()
                                {
                                    if (CameraMainActivity.r(a.a) != null && !CameraMainActivity.r(a.a).isRecycled())
                                    {
                                        ((ImageView)a.a.findViewById(0x7f10022c)).setImageBitmap(CameraMainActivity.r(a.a));
                                        CameraMainActivity.v(a.a);
                                    }
                                }

            
            {
                a = _pcls8;
                super();
            }
                            });
                        }

            
            {
                a = CameraMainActivity.this;
                b = size;
                c = abyte0;
                super();
            }
                    })).start();
                    findViewById(0x7f10022b).setVisibility(0);
                    h();
                    a(8);
                    findViewById(0x7f100210).setVisibility(8);
                    findViewById(0x7f10022a).setVisibility(8);
                    if (o != null && o.b())
                    {
                        o.a.setVisibility(8);
                    }
                    d = new com.socialin.picsin.camera.d(this, abyte0, n());
                    d.start();
                    a.A();
                    return;
                }
                if (c.a == CameraShutter.ShutterMode.TIME_LAPSE)
                {
                    (new com.socialin.picsin.camera.d(this, abyte0, n())).start();
                    a.A();
                    c.a();
                    return;
                }
                if (c.a != CameraShutter.ShutterMode.BURST)
                {
                    continue;
                }
                abyte0 = new com.socialin.picsin.camera.d(this, abyte0, n());
                abyte0.setPriority(1);
                abyte0.start();
                a.A();
                if (c.a == CameraShutter.ShutterMode.BURST)
                {
                    c.a();
                    return;
                }
            }
        }
    }

    public void onProgressChanged(SeekBar seekbar, int i1, boolean flag)
    {
        if (seekbar.getId() != 0x7f100213) goto _L2; else goto _L1
_L1:
        a.setBrightness(i1);
_L4:
        if (!a.d())
        {
            Utils.c(this, getString(0x7f0804ac));
        }
        return;
_L2:
        if (seekbar.getId() == 0x7f100216)
        {
            a.setContrast(a.e() + i1);
        } else
        if (seekbar.getId() == 0x7f100219)
        {
            a.setSharpness(a.i() + i1);
        } else
        if (seekbar.getId() == 0x7f10021c)
        {
            a.setSaturation(a.m() + i1);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onResume()
    {
        super.onResume();
        if (getResources().getConfiguration().orientation != 2)
        {
            setRequestedOrientation(0);
        }
        if (r)
        {
            c(false);
        }
        if (c != null)
        {
            c.e();
            c.f = false;
        }
        A = false;
        if (h != null)
        {
            h.onResume();
        }
        View view = findViewById(0x7f10022b);
        if (view != null && view.getVisibility() == 0)
        {
            d(false);
        }
        d(0);
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putString("session_id", s);
    }

    public void onShutter()
    {
    }

    protected void onStart()
    {
        super.onStart();
        V.connect();
        myobfuscated.f.m.a(V, "http://schema.org/PhotographAction", getString(0x7f080090), "android-app://com.picsart.studio/picsart/camera");
    }

    public void onStartTrackingTouch(SeekBar seekbar)
    {
    }

    protected void onStop()
    {
        super.onStop();
        myobfuscated.f.m.b(V, "http://schema.org/PhotographAction", getString(0x7f080090), "android-app://com.picsart.studio/picsart/camera");
        V.disconnect();
    }

    public void onStopTrackingTouch(SeekBar seekbar)
    {
    }

    public boolean onTrackballEvent(MotionEvent motionevent)
    {
        switch (motionevent.getAction())
        {
        default:
            return super.onTrackballEvent(motionevent);

        case 1: // '\001'
            c.a();
            break;
        }
        return true;
    }

    public void surfaceChanged(SurfaceHolder surfaceholder, int i1, int j1, int k1)
    {
        if (surfaceholder == null)
        {
            a(getString(0x7f08025f), true);
            return;
        }
        if (!r)
        {
            a.setPlayShutter(true);
            if (c != null)
            {
                c.i = true;
            }
            m();
            r = true;
        }
        y.enable();
        i1 = getWindowManager().getDefaultDisplay().getOrientation();
        if (i1 != 0) goto _L2; else goto _L1
_L1:
        Q = 270;
_L4:
        C.postDelayed(new Runnable() {

            private CameraMainActivity a;

            public final void run()
            {
                if (com.socialin.picsin.camera.CameraMainActivity.c(a) != null && !com.socialin.picsin.camera.CameraMainActivity.c(a).N() && !com.socialin.picsin.camera.CameraMainActivity.c(a).W() && com.socialin.picsin.camera.CameraMainActivity.x(a))
                {
                    a.findViewById(0x7f100684).setVisibility(8);
                    a.findViewById(0x7f100685).setVisibility(8);
                }
            }

            
            {
                a = CameraMainActivity.this;
                super();
            }
        }, 100L);
        return;
_L2:
        if (i1 == 1)
        {
            Q = 0;
        } else
        if (i1 == 3)
        {
            Q = 180;
        } else
        if (i1 == 2)
        {
            Q = 90;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void surfaceCreated(SurfaceHolder surfaceholder)
    {
        if (surfaceholder == null)
        {
            a(getString(0x7f08025d), true);
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder)
    {
    }

    static 
    {
        (new StringBuilder()).append(Environment.getExternalStorageDirectory().toString()).append("/DCIM/Camera").toString().toLowerCase().hashCode();
        new ArrayList() {

            
            {
                add(new com.socialin.picsin.camera.c());
                add(new com.socialin.picsin.camera.c());
            }
        };
    }

    // Unreferenced inner class com/socialin/picsin/camera/CameraMainActivity$19

/* anonymous class */
    public final class _cls19
        implements Runnable
    {

        private CameraMainActivity a;

        public final void run()
        {
            if (CameraMainActivity.p(a) != null)
            {
                CameraMainActivity.p(a).c = false;
                CameraMainActivity.p(a).x = null;
            }
        }

            public 
            {
                a = CameraMainActivity.this;
                super();
            }
    }


    // Unreferenced inner class com/socialin/picsin/camera/CameraMainActivity$22

/* anonymous class */
    public final class _cls22
        implements Runnable
    {

        private android.widget.LinearLayout.LayoutParams a;
        private CameraMainActivity b;

        public final void run()
        {
            if (!b.isFinishing() && CameraMainActivity.t(b) != null)
            {
                CameraMainActivity.t(b).setLayoutParams(a);
            }
        }

            public 
            {
                b = CameraMainActivity.this;
                a = layoutparams;
                super();
            }
    }


    // Unreferenced inner class com/socialin/picsin/camera/CameraMainActivity$24

/* anonymous class */
    public final class _cls24
        implements Runnable
    {

        private CameraMainActivity a;

        public final void run()
        {
            if (CameraMainActivity.u(a) != null && CameraMainActivity.u(a).isShowing())
            {
                CameraMainActivity.u(a).dismiss();
            }
            CameraMainActivity.D(a).b();
            CameraMainActivity.D(a).a();
        }

            public 
            {
                a = CameraMainActivity.this;
                super();
            }
    }


    // Unreferenced inner class com/socialin/picsin/camera/CameraMainActivity$25

/* anonymous class */
    public final class _cls25
        implements Runnable
    {

        private Bitmap a;
        private int b;
        private CameraMainActivity c;

        public final void run()
        {
            CameraMainActivity.q(c);
            c.d = new com.socialin.picsin.camera.d(c, a, b, com.socialin.picsin.camera.CameraMainActivity.c(c).z());
            c.d.start();
            if (CameraMainActivity.p(c) != null)
            {
                CameraMainActivity.p(c).g = false;
            }
            if (CameraMainActivity.t(c) != null)
            {
                CameraMainActivity.t(c).setVisibility(8);
            }
        }

            public 
            {
                c = CameraMainActivity.this;
                a = bitmap;
                b = i1;
                super();
            }
    }


    // Unreferenced inner class com/socialin/picsin/camera/CameraMainActivity$28

/* anonymous class */
    public final class _cls28
        implements Runnable
    {

        private int a;
        private int b;
        private int c;
        private CameraMainActivity d;

        public final void run()
        {
            if (a != 0) goto _L2; else goto _L1
_L1:
            com.socialin.picsin.camera.CameraMainActivity.g(d).a(b, false);
_L4:
            CameraMainActivity.G(d);
            if (com.socialin.picsin.camera.CameraMainActivity.c(d) != null)
            {
                com.socialin.picsin.camera.CameraMainActivity.c(d);
            }
            return;
_L2:
            myobfuscated.db.a a1 = com.socialin.picsin.camera.CameraMainActivity.g(d);
            int i1 = c;
            if (a1.f != null && i1 >= 0 && i1 < a1.f.getCount())
            {
                a1.f.b(i1, false);
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

            public 
            {
                d = CameraMainActivity.this;
                a = i1;
                b = j1;
                c = k1;
                super();
            }
    }


    // Unreferenced inner class com/socialin/picsin/camera/CameraMainActivity$34

/* anonymous class */
    public final class _cls34
        implements Runnable
    {

        private CameraMainActivity a;

        public final void run()
        {
            if (CameraMainActivity.f(a) == null)
            {
                com.socialin.picsin.camera.CameraMainActivity.a(a, (CameraFocusRectView)a.findViewById(0x7f1001fa));
            }
            if (CameraMainActivity.f(a) != null)
            {
                CameraMainActivity.f(a).setVisibility(8);
            }
        }

            public 
            {
                a = CameraMainActivity.this;
                super();
            }
    }


    private class SettingsListAdapter extends ArrayList
        implements ListAdapter
    {

        private static final long serialVersionUID = 0x959d9315733bdd64L;
        private final HashMap SETTINGS_NAMES_MAP = new HashMap() {

            final SettingsListAdapter this$1;

                
                {
                    this$1 = SettingsListAdapter.this;
                    super();
                    put("White Balance", Integer.valueOf(0x7f080098));
                    put("Scene Modes", Integer.valueOf(0x7f080094));
                    put("Sound", Integer.valueOf(0x7f080097));
                    put("Effects", Integer.valueOf(0x7f080091));
                    put("Reset defaults", Integer.valueOf(0x7f080093));
                }
        };
        private final DataSetObservable mDataSetObservable = new DataSetObservable();
        final CameraMainActivity this$0;

        public boolean areAllItemsEnabled()
        {
            return true;
        }

        public int getCount()
        {
            return size();
        }

        public e getItem(int i1)
        {
            return (e)get(i1);
        }

        public volatile Object getItem(int i1)
        {
            return getItem(i1);
        }

        public e getItemByName(String s1)
        {
            int j1 = size();
            for (int i1 = 0; i1 < j1; i1++)
            {
                e e1 = (e)get(i1);
                if (e1.a.equals(s1))
                {
                    return e1;
                }
            }

            return null;
        }

        public long getItemId(int i1)
        {
            return 0L;
        }

        public int getItemViewType(int i1)
        {
            return 0;
        }

        public View getView(int i1, View view, ViewGroup viewgroup)
        {
            e e1 = getItem(i1);
            viewgroup = view;
            if (view == null)
            {
                viewgroup = getLayoutInflater().inflate(0x7f030054, null);
            }
            TextView textview = (TextView)viewgroup.findViewById(0x7f100252);
            view = e1.a;
            if (SETTINGS_NAMES_MAP.containsKey(e1.a))
            {
                i1 = ((Integer)SETTINGS_NAMES_MAP.get(e1.a)).intValue();
                view = getString(i1);
            }
            textview.setText(view);
            view = (TextView)viewgroup.findViewById(0x7f100253);
            view.setText(e1.b);
            view.setTag((new StringBuilder()).append(e1.a).append("_value").toString());
            view = (CheckBox)viewgroup.findViewById(0x7f100254);
            view.setTag(e1.a);
            if (e1.c)
            {
                view.setChecked(e1.d);
                view.setVisibility(0);
                return viewgroup;
            } else
            {
                view.setVisibility(8);
                return viewgroup;
            }
        }

        public int getViewTypeCount()
        {
            return 1;
        }

        public boolean hasStableIds()
        {
            return false;
        }

        public boolean isEmpty()
        {
            return size() == 0;
        }

        public boolean isEnabled(int i1)
        {
            return true;
        }

        public void notifyDataSetChanged()
        {
            mDataSetObservable.notifyChanged();
        }

        public void registerDataSetObserver(DataSetObserver datasetobserver)
        {
            mDataSetObservable.registerObserver(datasetobserver);
        }

        public void unregisterDataSetObserver(DataSetObserver datasetobserver)
        {
            mDataSetObservable.unregisterObserver(datasetobserver);
        }

        public SettingsListAdapter()
        {
            this$0 = CameraMainActivity.this;
            super();
        }
    }

}
