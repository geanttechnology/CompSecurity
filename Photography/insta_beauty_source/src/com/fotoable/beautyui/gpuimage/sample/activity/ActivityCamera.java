// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui.gpuimage.sample.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.hardware.Camera;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import byb;
import com.crashlytics.android.Crashlytics;
import com.flurry.android.FlurryAgent;
import com.fotoable.beautyui.newui.MNewFotoBeautyActivity;
import com.fotoable.fotobeauty.FullscreenActivity;
import ik;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import jp.co.cyberagent.android.gpuimage.GPUImage;
import kn;
import ko;
import kp;
import kq;
import kr;
import ks;
import kt;
import kw;
import kx;
import ky;
import kz;
import la;
import lc;
import oj;
import pt;
import pu;
import qd;
import rb;
import ss;
import yp;

public class ActivityCamera extends FullscreenActivity
    implements android.view.View.OnClickListener, byb
{

    public static String a = "IsOneCaptureInfo";
    public static boolean c = true;
    private static String d = "ActivityCamera";
    private boolean A;
    private LinearLayout B;
    private SeekBar C;
    private FrameLayout D;
    private ImageView E;
    private ArrayList F;
    private ImageView G;
    private oj H;
    private android.view.View.OnClickListener I;
    private android.view.View.OnTouchListener J;
    private boolean K;
    private boolean L;
    private boolean M;
    private volatile boolean N;
    private Handler O;
    private int P;
    private Runnable Q;
    MediaPlayer b;
    private Uri e;
    private GPUImage f;
    private ss g;
    private qd h;
    private boolean i;
    private String j[] = {
        "off", "on", "auto"
    };
    private int k[] = {
        0x7f0200f3, 0x7f0200f4, 0x7f0200f2
    };
    private int l;
    private ImageView m;
    private ImageView n;
    private View o;
    private ImageView p;
    private FrameLayout q;
    private RelativeLayout r;
    private ImageView s;
    private ImageView t;
    private ImageButton u;
    private View v;
    private ImageView w;
    private FrameLayout x;
    private TextView y;
    private int z;

    public ActivityCamera()
    {
        l = 0;
        z = 0;
        F = new ArrayList();
        I = new kx(this);
        J = new ky(this);
        K = false;
        L = false;
        M = false;
        N = false;
        O = new Handler();
        P = 1;
        Q = new kp(this);
        b = null;
    }

    public static SeekBar A(ActivityCamera activitycamera)
    {
        return activitycamera.C;
    }

    public static Uri B(ActivityCamera activitycamera)
    {
        return activitycamera.e;
    }

    public static int a(ActivityCamera activitycamera, int i1)
    {
        activitycamera.z = i1;
        return i1;
    }

    public static ImageView a(ActivityCamera activitycamera)
    {
        return activitycamera.m;
    }

    public static GPUImage a(ActivityCamera activitycamera, GPUImage gpuimage)
    {
        activitycamera.f = gpuimage;
        return gpuimage;
    }

    private void a(int i1, int j1)
    {
        if (h == null)
        {
            return;
        }
        if (h.b.getParameters().getSupportedFocusModes() != null && h.b.getParameters().getSupportedFocusModes().contains("auto"))
        {
            s.setVisibility(0);
            h.b.autoFocus(new ko(this));
            return;
        } else
        {
            s.setVisibility(4);
            return;
        }
    }

    private void a(Intent intent)
    {
        if (intent != null)
        {
            if ((intent = intent.getData()) != null && intent.toString().length() > 0)
            {
                Intent intent1 = new Intent(this, com/fotoable/beautyui/newui/MNewFotoBeautyActivity);
                intent1.putExtra(MNewFotoBeautyActivity.b, intent.toString());
                startActivity(intent1);
                return;
            }
        }
    }

    private void a(android.hardware.Camera.Size size)
    {
        Object obj = getResources().getDisplayMetrics();
        int i1 = ((DisplayMetrics) (obj)).heightPixels - yp.a(this, 44F);
        int j1 = ((DisplayMetrics) (obj)).widthPixels;
        System.out.println((new StringBuilder()).append("optimalSize:").append(size).toString());
        j1 = (int)(((double)j1 / (double)size.height) * (double)size.width);
        int k1 = yp.a(this, 60F);
        size = (android.widget.FrameLayout.LayoutParams)q.getLayoutParams();
        obj = (android.widget.RelativeLayout.LayoutParams)r.getLayoutParams();
        if (j1 < i1 - k1)
        {
            Log.e("", (new StringBuilder()).append("opt:").append(i1 - j1).toString());
            size.bottomMargin = i1 - j1;
            obj.height = i1 - j1;
        } else
        {
            size.height = j1;
            obj.height = k1;
        }
        r.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        q.setLayoutParams(size);
    }

    public static void a(ActivityCamera activitycamera, int i1, int j1)
    {
        activitycamera.a(i1, j1);
    }

    public static void a(ActivityCamera activitycamera, android.hardware.Camera.Size size)
    {
        activitycamera.a(size);
    }

    private static void a(File file)
    {
        if (file.isFile())
        {
            file.delete();
        } else
        if (file.isDirectory())
        {
            File afile[] = file.listFiles();
            if (afile == null || afile.length == 0)
            {
                file.delete();
                return;
            }
            for (int i1 = 0; i1 < afile.length; i1++)
            {
                a(afile[i1]);
            }

            file.delete();
            return;
        }
    }

    public static boolean a()
    {
        boolean flag = true;
        if (ik.a() < 2)
        {
            flag = false;
        }
        return flag;
    }

    public static boolean a(ActivityCamera activitycamera, boolean flag)
    {
        activitycamera.K = flag;
        return flag;
    }

    public static String b()
    {
        return d;
    }

    public static void b(ActivityCamera activitycamera)
    {
        activitycamera.c();
    }

    public static boolean b(ActivityCamera activitycamera, boolean flag)
    {
        activitycamera.L = flag;
        return flag;
    }

    public static qd c(ActivityCamera activitycamera)
    {
        return activitycamera.h;
    }

    private void c()
    {
        if (H != null)
        {
            H.b();
            H = null;
        }
        if (f == null)
        {
            return;
        } else
        {
            H = new oj(this, h.c, new la(this));
            H.a();
            return;
        }
    }

    public static boolean c(ActivityCamera activitycamera, boolean flag)
    {
        activitycamera.M = flag;
        return flag;
    }

    public static ImageView d(ActivityCamera activitycamera)
    {
        return activitycamera.w;
    }

    private void d()
    {
        if (h != null || h.b != null)
        {
            if (f == null && !K)
            {
                q.setEnabled(true);
                u.setEnabled(true);
                w.setEnabled(true);
                return;
            }
            if (!L)
            {
                L = true;
                f();
                return;
            }
        }
    }

    public static ArrayList e(ActivityCamera activitycamera)
    {
        return activitycamera.F;
    }

    private void e()
    {
        q.setEnabled(false);
        u.setEnabled(false);
        w.setEnabled(false);
        if (pt.b(pt.i, this, false))
        {
            if (M)
            {
                return;
            } else
            {
                M = true;
                t.setBackgroundResource(0x7f02029a);
                t.setVisibility(0);
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

    private void f()
    {
        if (i)
        {
            v.setVisibility(0);
        }
        if (!N)
        {
            if (h == null || h.b == null)
            {
                u.setEnabled(true);
                w.setEnabled(true);
                q.setEnabled(true);
                return;
            }
            h.b.setPreviewCallback(null);
            if (!N)
            {
                try
                {
                    h.b.startPreview();
                    h.b.takePicture(g(), null, null, new kq(this));
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
        }
    }

    public static boolean f(ActivityCamera activitycamera)
    {
        return activitycamera.A;
    }

    private android.hardware.Camera.ShutterCallback g()
    {
        if (pt.b(pt.d, this, false))
        {
            return new kr(this);
        } else
        {
            return null;
        }
    }

    public static FrameLayout g(ActivityCamera activitycamera)
    {
        return activitycamera.x;
    }

    private void h()
    {
        android.hardware.Camera.Parameters parameters;
        char c1;
        char c2;
        c1 = '\u03C0';
        c2 = '\u021C';
        if (h == null || h.b == null)
        {
            return;
        }
        parameters = h.b.getParameters();
        if (parameters == null) goto _L2; else goto _L1
_L1:
        float f1;
        List list;
        list = parameters.getSupportedPreviewSizes();
        h.d = h.a(list, 960, 540);
        if (h.d != null)
        {
            parameters.setPreviewSize(h.d.width, h.d.height);
        }
        list = parameters.getSupportedPictureSizes();
        f1 = pu.d();
        if (f1 >= 0.7F) goto _L4; else goto _L3
_L3:
        char c4 = c1;
        char c3 = c2;
        if (c2 * c1 > 0x2dc6c0)
        {
            c3 = '\u05DC';
            c4 = '\u07D0';
        }
        h.e = h.a(list, c4, c3);
        if (h.e != null)
        {
            Log.e(d, (new StringBuilder()).append("takePictureSize:").append(h.e.width).append(",").append(h.e.height).toString());
            parameters.setPictureSize(h.e.width, h.e.height);
        }
        h.b.setParameters(parameters);
_L2:
        f.a(h.b);
        h.b.startPreview();
        return;
_L4:
        if (f1 > 0.7F && f1 < 1.7F)
        {
            c1 = '\u0780';
            c2 = '\u0438';
        } else
        if (f1 > 1.7F)
        {
            c1 = '\u0F00';
            c2 = '\u0870';
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public static void h(ActivityCamera activitycamera)
    {
        activitycamera.e();
    }

    public static FrameLayout i(ActivityCamera activitycamera)
    {
        return activitycamera.q;
    }

    public static boolean j(ActivityCamera activitycamera)
    {
        return activitycamera.K;
    }

    public static ImageView k(ActivityCamera activitycamera)
    {
        return activitycamera.s;
    }

    public static ImageView l(ActivityCamera activitycamera)
    {
        return activitycamera.E;
    }

    public static GPUImage m(ActivityCamera activitycamera)
    {
        return activitycamera.f;
    }

    public static void n(ActivityCamera activitycamera)
    {
        activitycamera.h();
    }

    public static oj o(ActivityCamera activitycamera)
    {
        return activitycamera.H;
    }

    public static int p(ActivityCamera activitycamera)
    {
        return activitycamera.P;
    }

    public static ImageView q(ActivityCamera activitycamera)
    {
        return activitycamera.t;
    }

    public static boolean r(ActivityCamera activitycamera)
    {
        return activitycamera.N;
    }

    public static void s(ActivityCamera activitycamera)
    {
        activitycamera.d();
    }

    public static int t(ActivityCamera activitycamera)
    {
        int i1 = activitycamera.P;
        activitycamera.P = i1 + 1;
        return i1;
    }

    public static Handler u(ActivityCamera activitycamera)
    {
        return activitycamera.O;
    }

    public static View v(ActivityCamera activitycamera)
    {
        return activitycamera.v;
    }

    public static ImageButton w(ActivityCamera activitycamera)
    {
        return activitycamera.u;
    }

    public static int x(ActivityCamera activitycamera)
    {
        return activitycamera.z;
    }

    public static int y(ActivityCamera activitycamera)
    {
        int i1 = activitycamera.z;
        activitycamera.z = i1 + 1;
        return i1;
    }

    public static TextView z(ActivityCamera activitycamera)
    {
        return activitycamera.y;
    }

    public void a(boolean flag)
    {
        if (!pt.b(pt.m, this, false))
        {
            pt.a(pt.m, this, true);
        }
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        if (j1 == -1) goto _L2; else goto _L1
_L1:
        return;
_L2:
        switch (i1)
        {
        default:
            return;

        case 1244: 
            if (e != null && intent != null)
            {
                if (intent.getBooleanExtra(MNewFotoBeautyActivity.h, true))
                {
                    setResult(-1);
                } else
                {
                    setResult(0);
                }
                runOnUiThread(new lc(this));
                return;
            }
            break;

        case 3021: 
            a(intent);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void onBackPressed()
    {
        android.view.WindowManager.LayoutParams layoutparams = getWindow().getAttributes();
        layoutparams.screenBrightness = -1F;
        getWindow().setAttributes(layoutparams);
        super.onBackPressed();
    }

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR tableswitch 2131558485 2131558492: default 52
    //                   2131558485 53
    //                   2131558486 210
    //                   2131558487 99
    //                   2131558488 246
    //                   2131558489 52
    //                   2131558490 52
    //                   2131558491 52
    //                   2131558492 198;
           goto _L1 _L2 _L3 _L4 _L5 _L1 _L1 _L1 _L6
_L1:
        return;
_L2:
        FlurryAgent.logEvent("camera_brightness_click");
        if (i)
        {
            p.setImageResource(0x7f020108);
            i = false;
            return;
        } else
        {
            p.setImageResource(0x7f020109);
            i = true;
            return;
        }
_L4:
        FlurryAgent.logEvent("camera_flash_click");
        if (h.b != null && h != null)
        {
            view = h.b.getParameters();
            l = (l + 1) % 3;
            m.setImageResource(k[l]);
            view.setFlashMode(j[l]);
            h.b.setParameters(view);
            h.a(l);
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
            h.c();
            qd.c(h.a);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            Crashlytics.logException(view);
        }
        view.printStackTrace();
        return;
_L5:
        FlurryAgent.logEvent("camera_setting_click");
        n.getTop();
        int i1 = n.getBottom();
        view = new rb(this, new kz(this));
        boolean flag = pt.b(pt.i, this, false);
        boolean flag1 = pt.b(pt.j, this, false);
        boolean flag2 = pt.b(pt.e, this, true);
        boolean flag3 = pt.b(pt.g, this, true);
        boolean flag4 = pt.b(pt.f, this, true);
        view.a(pt.b(pt.t, this, false), flag, flag1, flag2, flag3, flag4, A);
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
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(0x7f030018);
        i = false;
        c = pt.b(pt.n, this, true);
        r = (RelativeLayout)findViewById(0x7f0d005a);
        s = (ImageView)findViewById(0x7f0d0051);
        t = (ImageView)findViewById(0x7f0d0052);
        n = (ImageView)findViewById(0x7f0d0058);
        n.setOnClickListener(this);
        v = findViewById(0x7f0d0050);
        v.setVisibility(4);
        p = (ImageView)findViewById(0x7f0d0055);
        p.setOnClickListener(this);
        m = (ImageView)findViewById(0x7f0d0057);
        m.setOnClickListener(this);
        o = findViewById(0x7f0d0056);
        o.setOnClickListener(this);
        u = (ImageButton)findViewById(0x7f0d005c);
        u.setOnClickListener(this);
        q = (FrameLayout)findViewById(0x7f0d004e);
        q.setOnTouchListener(J);
        q.setOnClickListener(I);
        g = new ss(this);
        h = new qd(g, this, q, new kn(this));
        if (!g.d() || !g.e())
        {
            o.setVisibility(8);
            bundle = new android.widget.FrameLayout.LayoutParams(-2, -2);
            bundle.rightMargin = yp.a(this, 10F);
            bundle.gravity = 5;
            m.setLayoutParams(bundle);
        }
        B = (LinearLayout)findViewById(0x7f0d0059);
        C = (SeekBar)findViewById(0x7f0d005b);
        C.setProgress(70);
        C.setOnSeekBarChangeListener(new ks(this));
        bundle = getIntent().getExtras();
        if (bundle != null)
        {
            e = (Uri)bundle.getParcelable("output");
            if (e != null)
            {
                FlurryAgent.logEvent("camera_start_from_three");
            }
        }
        A = getIntent().getBooleanExtra(a, true);
        h.a(A);
        y = (TextView)findViewById(0x7f0d005f);
        x = (FrameLayout)findViewById(0x7f0d005d);
        x.setVisibility(4);
        w = (ImageView)findViewById(0x7f0d005e);
        w.getBackground().setColorFilter(getResources().getColor(0x7f0c0010), android.graphics.PorterDuff.Mode.SRC_IN);
        w.setOnClickListener(new kt(this));
        D = (FrameLayout)findViewById(0x7f0d0053);
        E = (ImageView)(ImageView)findViewById(0x7f0d004f);
        G = (ImageView)findViewById(0x7f0d0054);
        G.setOnClickListener(new kw(this));
    }

    protected void onDestroy()
    {
        N = true;
        if (H != null)
        {
            H.b();
        }
        super.onDestroy();
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (keyevent.getKeyCode() == 25 || keyevent.getKeyCode() == 24)
        {
            if (!u.isClickable())
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
        h.b();
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        FlurryAgent.onPageView();
        E.setVisibility(4);
        Object obj = new File((new StringBuilder()).append(ik.a(this)).append("/camera_photo_temp").toString());
        if (((File) (obj)).exists())
        {
            a(((File) (obj)));
        }
        M = false;
        N = false;
        u.setEnabled(true);
        w.setEnabled(true);
        q.setEnabled(true);
        obj = getWindow().getAttributes();
        obj.screenBrightness = 1.0F;
        getWindow().setAttributes(((android.view.WindowManager.LayoutParams) (obj)));
        h.a();
        Log.e("camera", "onResume");
    }

    public void onStart()
    {
        super.onStart();
    }

    public void onStop()
    {
        super.onStop();
        s.setVisibility(4);
    }

    static 
    {
        System.loadLibrary("fotobeautyengine");
    }
}
