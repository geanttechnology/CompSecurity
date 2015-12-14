// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui.gpuimage.sample.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.hardware.Camera;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.crashlytics.android.Crashlytics;
import com.flurry.android.FlurryAgent;
import com.fotoable.ad.ApplicationState;
import com.fotoable.beautyui.newui.MNewFotoBeautyActivity;
import com.instabeauty.application.InstaBeautyApplication;
import ik;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import nl;
import nm;
import nn;
import no;
import np;
import nq;
import ns;
import nv;
import nw;
import ny;
import ob;
import oc;
import od;
import oe;
import of;
import og;
import oh;
import oi;
import oj;
import pt;
import pu;
import qa;
import rb;
import uv;
import yo;
import yp;

public class ActivityCameraNoRealtime extends Activity
    implements android.view.View.OnClickListener
{

    public static String e = "IsOneCaptureInfoB";
    private static String k = "ActivityCameraNoRealtime";
    private TextView A;
    private int B;
    private ArrayList C;
    private boolean D;
    private ImageView E;
    private ImageView F;
    private FrameLayout G;
    private android.view.View.OnClickListener H;
    private android.view.View.OnClickListener I;
    private android.view.View.OnTouchListener J;
    private boolean K;
    private boolean L;
    private boolean M;
    private volatile boolean N;
    private Handler O;
    private int P;
    private Runnable Q;
    public Camera a;
    int b;
    public int c;
    int d;
    public oj f;
    MediaPlayer g;
    public int h;
    private oi i;
    private boolean j;
    private boolean l;
    private String m[] = {
        "off", "on", "auto"
    };
    private int n[] = {
        0x7f0200f3, 0x7f0200f4, 0x7f0200f2
    };
    private ImageView o;
    private ImageView p;
    private View q;
    private ImageView r;
    private FrameLayout s;
    private RelativeLayout t;
    private ImageView u;
    private ImageView v;
    private ImageButton w;
    private View x;
    private ImageView y;
    private FrameLayout z;

    public ActivityCameraNoRealtime()
    {
        c = 0;
        j = true;
        d = 0;
        B = 0;
        C = new ArrayList();
        H = new oc(this);
        I = new od(this);
        J = new oe(this);
        K = false;
        L = false;
        M = false;
        N = false;
        O = new Handler();
        P = 1;
        Q = new nn(this);
        g = null;
        h = 0;
    }

    public static int a(ActivityCameraNoRealtime activitycameranorealtime, int i1)
    {
        activitycameranorealtime.B = i1;
        return i1;
    }

    public static ImageView a(ActivityCameraNoRealtime activitycameranorealtime)
    {
        return activitycameranorealtime.y;
    }

    private void a(int i1, int j1)
    {
        if (a == null)
        {
            return;
        }
        if (a.getParameters().getSupportedFocusModes() != null && a.getParameters().getSupportedFocusModes().contains("auto"))
        {
            u.setVisibility(0);
            a.autoFocus(new nm(this));
            return;
        } else
        {
            u.setVisibility(4);
            return;
        }
    }

    public static void a(Activity activity, int i1)
    {
        Intent intent = new Intent(activity, com/fotoable/beautyui/gpuimage/sample/activity/ActivityCameraNoRealtime);
        intent.putExtra(e, true);
        activity.startActivityForResult(intent, i1);
    }

    private static void a(Context context)
    {
        context = new File((new StringBuilder()).append(ik.a(context)).append("/camera_photo_temp").toString());
        if (!context.exists() || !context.isDirectory()) goto _L2; else goto _L1
_L1:
        String as[] = context.list();
        int i1 = 0;
_L3:
        if (i1 >= as.length)
        {
            break; /* Loop/switch isn't completed */
        }
        (new File(context, as[i1])).delete();
        i1++;
        if (true) goto _L3; else goto _L2
        context;
        context.printStackTrace();
        Crashlytics.logException(context);
_L2:
    }

    private void a(android.hardware.Camera.Size size)
    {
        Object obj = getResources().getDisplayMetrics();
        int i1 = ((DisplayMetrics) (obj)).heightPixels - yp.a(this, 44F);
        int j1 = (int)(((double)((DisplayMetrics) (obj)).widthPixels / (double)size.height) * (double)size.width);
        int k1 = yp.a(this, 60F);
        size = (android.widget.FrameLayout.LayoutParams)s.getLayoutParams();
        obj = (android.widget.FrameLayout.LayoutParams)t.getLayoutParams();
        if (j1 < i1 - k1)
        {
            size.bottomMargin = i1 - j1;
            obj.height = i1 - j1;
        } else
        {
            size.height = j1;
            obj.height = k1;
        }
        t.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        s.setLayoutParams(size);
    }

    public static void a(ActivityCameraNoRealtime activitycameranorealtime, int i1, int j1)
    {
        activitycameranorealtime.a(i1, j1);
    }

    public static void a(ActivityCameraNoRealtime activitycameranorealtime, android.hardware.Camera.Size size)
    {
        activitycameranorealtime.a(size);
    }

    public static boolean a(int i1)
    {
        android.hardware.Camera.CameraInfo camerainfo = new android.hardware.Camera.CameraInfo();
        Camera.getCameraInfo(i1, camerainfo);
        return camerainfo.facing == 1;
    }

    public static String b()
    {
        return k;
    }

    public static ArrayList b(ActivityCameraNoRealtime activitycameranorealtime)
    {
        return activitycameranorealtime.C;
    }

    private void c()
    {
        if (a != null)
        {
            a.stopPreview();
            i.a(null);
            a.release();
            a = null;
        }
        a = Camera.open((c + 1) % b);
        boolean flag;
        if (!j)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        j = flag;
        c = (c + 1) % b;
        l();
        if (a(c))
        {
            h = pt.b(pt.k, this, 0) + b(c);
        } else
        {
            h = pt.b(pt.l, this, 0) + b(c);
        }
        i.b(a);
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            try
            {
                a.setDisplayOrientation(h);
                return;
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
            return;
        }
        a.stopPreview();
        try
        {
            a.setDisplayOrientation(h);
        }
        catch (Exception exception1)
        {
            exception1.printStackTrace();
        }
        a.startPreview();
    }

    public static boolean c(ActivityCameraNoRealtime activitycameranorealtime)
    {
        return activitycameranorealtime.D;
    }

    public static FrameLayout d(ActivityCameraNoRealtime activitycameranorealtime)
    {
        return activitycameranorealtime.z;
    }

    private void d()
    {
        while (a == null || L) 
        {
            return;
        }
        L = true;
        f();
    }

    private void e()
    {
        G.setVisibility(0);
        if (pt.b(pt.i, this, false))
        {
            if (M)
            {
                return;
            } else
            {
                M = true;
                v.setBackgroundResource(0x7f02029a);
                v.setVisibility(0);
                P = 1;
                System.out.println("mHandler");
                O.post(Q);
                return;
            }
        } else
        {
            d();
            return;
        }
    }

    public static void e(ActivityCameraNoRealtime activitycameranorealtime)
    {
        activitycameranorealtime.e();
    }

    public static FrameLayout f(ActivityCameraNoRealtime activitycameranorealtime)
    {
        return activitycameranorealtime.s;
    }

    private void f()
    {
        if (l)
        {
            x.setVisibility(0);
        }
        try
        {
            System.gc();
            a.setPreviewCallback(null);
            a.startPreview();
            a.takePicture(g(), null, null, new no(this));
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            Crashlytics.logException(exception);
            Toast.makeText(this, getResources().getString(0x7f06029a), 0);
            finish();
            return;
        }
    }

    private android.hardware.Camera.ShutterCallback g()
    {
        if (pt.b(pt.d, this, true))
        {
            return new np(this);
        } else
        {
            return null;
        }
    }

    public static ImageView g(ActivityCameraNoRealtime activitycameranorealtime)
    {
        return activitycameranorealtime.u;
    }

    public static int h(ActivityCameraNoRealtime activitycameranorealtime)
    {
        return activitycameranorealtime.P;
    }

    private void h()
    {
        findViewById(0x7f0d0060).setVisibility(0);
    }

    public static ImageView i(ActivityCameraNoRealtime activitycameranorealtime)
    {
        return activitycameranorealtime.v;
    }

    private void i()
    {
        findViewById(0x7f0d0060).setVisibility(8);
    }

    private void j()
    {
        L = false;
        G.setVisibility(8);
    }

    public static boolean j(ActivityCameraNoRealtime activitycameranorealtime)
    {
        return activitycameranorealtime.N;
    }

    private void k()
    {
        if (pt.b(pt.b, this, true))
        {
            Toast.makeText(getBaseContext(), 0x7f0600a3, 0).show();
        }
        Intent intent = new Intent(this, com/fotoable/beautyui/newui/MNewFotoBeautyActivity);
        intent.putExtra(MNewFotoBeautyActivity.a, 1);
        startActivity(intent);
    }

    public static void k(ActivityCameraNoRealtime activitycameranorealtime)
    {
        activitycameranorealtime.d();
    }

    public static int l(ActivityCameraNoRealtime activitycameranorealtime)
    {
        int i1 = activitycameranorealtime.P;
        activitycameranorealtime.P = i1 + 1;
        return i1;
    }

    private void l()
    {
        pu pu1 = new pu(c, this, new nv(this));
        if (pu1.a(2))
        {
            pu1.c();
            pu1.b(2);
        }
    }

    public static Handler m(ActivityCameraNoRealtime activitycameranorealtime)
    {
        return activitycameranorealtime.O;
    }

    public static void n(ActivityCameraNoRealtime activitycameranorealtime)
    {
        activitycameranorealtime.j();
    }

    public static void o(ActivityCameraNoRealtime activitycameranorealtime)
    {
        activitycameranorealtime.k();
    }

    public static void p(ActivityCameraNoRealtime activitycameranorealtime)
    {
        activitycameranorealtime.i();
    }

    public static int q(ActivityCameraNoRealtime activitycameranorealtime)
    {
        return activitycameranorealtime.B;
    }

    public static int r(ActivityCameraNoRealtime activitycameranorealtime)
    {
        int i1 = activitycameranorealtime.B;
        activitycameranorealtime.B = i1 + 1;
        return i1;
    }

    public static TextView s(ActivityCameraNoRealtime activitycameranorealtime)
    {
        return activitycameranorealtime.A;
    }

    public static ImageView t(ActivityCameraNoRealtime activitycameranorealtime)
    {
        return activitycameranorealtime.E;
    }

    public static oi u(ActivityCameraNoRealtime activitycameranorealtime)
    {
        return activitycameranorealtime.i;
    }

    public static boolean v(ActivityCameraNoRealtime activitycameranorealtime)
    {
        return activitycameranorealtime.j;
    }

    public static ImageView w(ActivityCameraNoRealtime activitycameranorealtime)
    {
        return activitycameranorealtime.o;
    }

    public void a()
    {
        if (f != null)
        {
            f.b();
            f = null;
        }
        f = new oj(this, j, new nw(this));
        f.a();
    }

    public void a(byte abyte0[])
    {
        int i1 = ik.a();
        int j1 = ik.b();
        Object obj;
        String s1;
        boolean flag;
        if (i1 == 1)
        {
            if (j1 < 300)
            {
                i1 = 300;
            } else
            if (j1 < 600)
            {
                i1 = 640;
            } else
            {
                i1 = 640;
            }
        } else
        if (j1 < 900)
        {
            i1 = 800;
        } else
        if (j1 < 1200)
        {
            i1 = 960;
        } else
        {
            i1 = 1280;
        }
        abyte0 = yo.a(abyte0, abyte0, i1, i1);
        obj = new Matrix();
        ((Matrix) (obj)).postRotate(oj.a(j, this));
        if (j)
        {
            ((Matrix) (obj)).postScale(-1F, 1.0F);
        }
        abyte0 = Bitmap.createBitmap(abyte0, 0, 0, abyte0.getWidth(), abyte0.getHeight(), ((Matrix) (obj)), true);
        abyte0 = Bitmap.createScaledBitmap(abyte0, (int)((float)i1 * ((float)abyte0.getWidth() / (float)abyte0.getHeight())), i1, true);
        obj = pu.a(D, getApplicationContext());
        if (obj == null)
        {
            try
            {
                Toast.makeText(getApplicationContext(), "no sdcard!", 0).show();
                a.startPreview();
                j();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                abyte0.printStackTrace();
            }
            Crashlytics.logException(abyte0);
            return;
        }
        s1 = Uri.fromFile(((File) (obj))).toString();
        if (!D)
        {
            break MISSING_BLOCK_LABEL_245;
        }
        if (!j)
        {
            break MISSING_BLOCK_LABEL_230;
        }
        flag = pt.b(pt.b, InstaBeautyApplication.a, true);
_L1:
        h();
        uv.c().a(abyte0, ((File) (obj)).getAbsolutePath(), flag, new nq(this));
        return;
        flag = pt.b(pt.c, InstaBeautyApplication.a, false);
          goto _L1
        qa.a().a(abyte0, ((File) (obj)).getAbsolutePath(), new ns(this, s1));
        return;
    }

    public int b(int i1)
    {
        android.hardware.Camera.CameraInfo camerainfo;
        boolean flag;
        flag = false;
        camerainfo = new android.hardware.Camera.CameraInfo();
        Camera.getCameraInfo(i1, camerainfo);
        i1 = ((flag) ? 1 : 0);
        getWindowManager().getDefaultDisplay().getRotation();
        JVM INSTR tableswitch 0 3: default 60
    //                   0 62
    //                   1 89
    //                   2 95
    //                   3 102;
           goto _L1 _L2 _L3 _L4 _L5
_L5:
        break MISSING_BLOCK_LABEL_102;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        i1 = ((flag) ? 1 : 0);
_L6:
        if (camerainfo.facing == 1)
        {
            return (360 - (i1 + camerainfo.orientation) % 360) % 360;
        } else
        {
            return ((camerainfo.orientation - i1) + 360) % 360;
        }
_L3:
        i1 = 90;
          goto _L6
_L4:
        i1 = 180;
          goto _L6
        i1 = 270;
          goto _L6
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        android.view.WindowManager.LayoutParams layoutparams = getWindow().getAttributes();
        layoutparams.screenBrightness = -1F;
        getWindow().setAttributes(layoutparams);
    }

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR tableswitch 2131558485 2131558492: default 52
    //                   2131558485 53
    //                   2131558486 204
    //                   2131558487 99
    //                   2131558488 238
    //                   2131558489 52
    //                   2131558490 52
    //                   2131558491 52
    //                   2131558492 192;
           goto _L1 _L2 _L3 _L4 _L5 _L1 _L1 _L1 _L6
_L1:
        return;
_L2:
        FlurryAgent.logEvent("camera_brightness_click");
        if (l)
        {
            r.setImageResource(0x7f020108);
            l = false;
            return;
        } else
        {
            r.setImageResource(0x7f020109);
            l = true;
            return;
        }
_L4:
        FlurryAgent.logEvent("camera_flash_click");
        if (a != null)
        {
            try
            {
                view = a.getParameters();
                d = (d + 1) % 3;
                o.setImageResource(n[d]);
                view.setFlashMode(m[d]);
                a.setParameters(view);
                i.a(d);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                view.printStackTrace();
            }
            Crashlytics.logException(view);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        FlurryAgent.logEvent("camera_capture_click");
        e();
        return;
_L3:
        FlurryAgent.logEvent("camera_switch_click");
        try
        {
            c();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            Crashlytics.logException(view);
        }
        view.printStackTrace();
        oj.a(this, new og(this));
        return;
_L5:
        FlurryAgent.logEvent("camera_setting_click");
        p.getTop();
        int i1 = p.getBottom();
        view = new rb(this, new oh(this));
        boolean flag = pt.b(pt.i, this, false);
        boolean flag1 = pt.b(pt.j, this, false);
        boolean flag2 = pt.b(pt.e, this, true);
        boolean flag3 = pt.b(pt.g, this, true);
        boolean flag4 = pt.b(pt.f, this, true);
        view.a(pt.b(pt.t, this, false), flag, flag1, flag2, flag3, flag4, D);
        if (!N)
        {
            view.a(0, i1);
            return;
        }
        if (true) goto _L1; else goto _L7
_L7:
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Log.d("TEST", "Activtycamera norealtime DEBUG");
        Log.e("TEST", "Activtycamera norealtime error");
        requestWindowFeature(1);
        getWindow().addFlags(1024);
        setContentView(0x7f030019);
        b = Camera.getNumberOfCameras();
        bundle = new android.hardware.Camera.CameraInfo();
        int i1 = 0;
        do
        {
label0:
            {
                if (i1 < b)
                {
                    try
                    {
                        Camera.getCameraInfo(i1, bundle);
                    }
                    catch (Exception exception)
                    {
                        exception.printStackTrace();
                        Crashlytics.logException(exception);
                        oj.a(this, new nl(this));
                    }
                    if (((android.hardware.Camera.CameraInfo) (bundle)).facing != 1)
                    {
                        break label0;
                    }
                    c = i1;
                    j = true;
                }
                l = false;
                t = (RelativeLayout)findViewById(0x7f0d005a);
                u = (ImageView)findViewById(0x7f0d0051);
                v = (ImageView)findViewById(0x7f0d0052);
                p = (ImageView)findViewById(0x7f0d0058);
                p.setOnClickListener(this);
                x = findViewById(0x7f0d0050);
                x.setVisibility(4);
                r = (ImageView)findViewById(0x7f0d0055);
                r.setOnClickListener(this);
                o = (ImageView)findViewById(0x7f0d0057);
                o.setOnClickListener(this);
                q = findViewById(0x7f0d0056);
                q.setOnClickListener(this);
                w = (ImageButton)findViewById(0x7f0d005c);
                w.setOnClickListener(this);
                s = (FrameLayout)findViewById(0x7f0d004e);
                s.setOnTouchListener(J);
                s.setOnClickListener(H);
                if (b < 2)
                {
                    q.setVisibility(8);
                    bundle = new android.widget.FrameLayout.LayoutParams(-2, -2);
                    bundle.rightMargin = yp.a(this, 10F);
                    bundle.gravity = 5;
                    o.setLayoutParams(bundle);
                }
                D = getIntent().getBooleanExtra(e, true);
                A = (TextView)findViewById(0x7f0d005f);
                z = (FrameLayout)findViewById(0x7f0d005d);
                z.setVisibility(4);
                y = (ImageView)findViewById(0x7f0d005e);
                y.getBackground().setColorFilter(getResources().getColor(0x7f0c0010), android.graphics.PorterDuff.Mode.SRC_IN);
                y.setOnClickListener(new ny(this));
                E = (ImageView)(ImageView)findViewById(0x7f0d004f);
                F = (ImageView)findViewById(0x7f0d0054);
                F.setOnClickListener(new ob(this));
                G = (FrameLayout)findViewById(0x7f0d0062);
                G.setVisibility(8);
                G.setOnClickListener(I);
                return;
            }
            j = false;
            i1++;
        } while (true);
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (keyevent.getKeyCode() == 25 || keyevent.getKeyCode() == 24)
        {
            if (!w.isClickable())
            {
                return true;
            } else
            {
                e();
                return true;
            }
        } else
        {
            return super.onKeyDown(i1, keyevent);
        }
    }

    protected void onPause()
    {
        super.onPause();
        if (a == null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        i.a(null);
        a.setPreviewCallback(null);
        a.release();
        a = null;
        s.removeView(i);
        i = null;
        a = null;
        s.removeView(i);
        i = null;
_L2:
        if (f != null)
        {
            f.b();
            f = null;
        }
        return;
        Object obj;
        obj;
        Crashlytics.logException(((Throwable) (obj)));
        a = null;
        s.removeView(i);
        i = null;
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        a = null;
        s.removeView(i);
        i = null;
        throw obj;
    }

    protected void onResume()
    {
        super.onResume();
        j();
        E.setVisibility(4);
        a(this);
        i = new oi(this, this);
        s.addView(i);
        int i1;
        boolean flag;
        try
        {
            a = Camera.open(c);
            flag = a(c);
            l();
            i.a(a);
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
            oj.a(this, new of(this));
            a = null;
            return;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_125;
        }
        h = pt.b(pt.k, this, 0) + b(c);
_L1:
        i1 = android.os.Build.VERSION.SDK_INT;
        if (i1 < 14)
        {
            break MISSING_BLOCK_LABEL_178;
        }
        a.setDisplayOrientation(h);
        return;
        h = pt.b(pt.l, this, 0) + b(c);
          goto _L1
        Exception exception1;
        exception1;
        exception1.printStackTrace();
        return;
        a.stopPreview();
        a.setDisplayOrientation(h);
_L2:
        a.startPreview();
        return;
        exception1;
        exception1.printStackTrace();
          goto _L2
    }

    protected void onStart()
    {
        super.onStart();
        FlurryAgent.onStartSession(this, "J3DP5Q6Y48C3GPJXV4X3");
        ApplicationState.checkAppStateAfterOnStart();
    }

    protected void onStop()
    {
        super.onStop();
        FlurryAgent.onEndSession(this);
        ApplicationState.checkAppStateAfterOnStop();
    }

}
