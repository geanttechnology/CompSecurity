// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui.gpuimage.sample.activity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import bzl;
import bzu;
import com.crashlytics.android.Crashlytics;
import com.flurry.android.FlurryAgent;
import com.fotoable.ad.ApplicationState;
import com.fotoable.beautyui.newui.MNewFotoBeautyActivity;
import com.fotoable.beautyui.other.SeperateMovieBar;
import com.fotoable.fotobeauty.WantuActivity;
import com.instabeauty.application.InstaBeautyApplication;
import ik;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import jp.co.cyberagent.android.gpuimage.Rotation;
import jp.co.cyberagent.android.gpuimage.camera.BeautyCameraGLSurfaceView;
import jp.co.cyberagent.android.gpuimage.grafika.CameraCaptureActivity;
import lj;
import ll;
import lm;
import lo;
import lp;
import lq;
import lt;
import lu;
import lv;
import lw;
import lx;
import ly;
import lz;
import ma;
import mb;
import mc;
import md;
import mf;
import mh;
import mi;
import mj;
import ml;
import mm;
import mn;
import mo;
import mq;
import mr;
import ms;
import mt;
import mu;
import mv;
import mx;
import my;
import mz;
import na;
import nb;
import nc;
import nd;
import ne;
import ng;
import nh;
import ni;
import nj;
import nk;
import oj;
import pt;
import pu;
import pz;
import sm;
import uv;
import yo;
import yp;

// Referenced classes of package com.fotoable.beautyui.gpuimage.sample.activity:
//            ActivityMediaPlayerTest, contiCapEditItem, CameraFilterScrollView

public class ActivityCameraNew extends CameraCaptureActivity
    implements bzl
{

    private static final SimpleDateFormat aT;
    private static final int ay[] = {
        1, 0, 5, 7, 6
    };
    public static String b = "capture_state";
    public static String c = "StartCameraFromShortCut";
    private FrameLayout A;
    private ImageView B;
    private TextView C;
    private ImageView D;
    private ImageView E;
    private View F;
    private ImageView G;
    private int H;
    private FrameLayout I;
    private ImageView J;
    private ImageView K;
    private FrameLayout L;
    private FrameLayout M;
    private FrameLayout N;
    private TextView O;
    private Button P;
    private ImageButton Q;
    private ImageButton R;
    private ImageButton S;
    private SeperateMovieBar T;
    private ImageButton U;
    private ImageButton V;
    private ImageButton W;
    private ImageButton X;
    private TextView Y;
    private CameraFilterScrollView Z;
    public final int a = 1243;
    private pz aA;
    private android.view.View.OnClickListener aB;
    private android.view.View.OnClickListener aC;
    private android.view.View.OnClickListener aD;
    private android.view.View.OnClickListener aE;
    private android.view.View.OnTouchListener aF;
    private android.view.View.OnClickListener aG;
    private android.view.View.OnClickListener aH;
    private long aI;
    private long aJ;
    private String aK;
    private String aL;
    private ArrayList aM;
    private boolean aN;
    private android.view.View.OnClickListener aO;
    private android.view.View.OnClickListener aP;
    private android.view.View.OnClickListener aQ;
    private android.view.View.OnClickListener aR;
    private android.view.View.OnClickListener aS;
    private Handler aU;
    private int aV;
    private ArrayList aW;
    private oj aX;
    private android.view.GestureDetector.SimpleOnGestureListener aY;
    private android.view.View.OnClickListener aZ;
    private int aa;
    private String ab;
    private GestureDetector ac;
    private TextView ad;
    private LinearLayout ae;
    private SeekBar af;
    private float ag;
    private ImageView ah;
    private boolean ai;
    private boolean aj;
    private ImageView ak;
    private FrameLayout al;
    private Timer am;
    private Timer an;
    private ni ao;
    private nj ap;
    private nk aq;
    private int ar;
    private boolean as;
    private Uri at;
    private boolean au;
    private int av;
    private int aw;
    private boolean ax;
    private android.view.View.OnClickListener az;
    private boolean ba;
    private SensorManager bb;
    private Sensor bc;
    private float bd;
    boolean d;
    boolean e;
    ExecutorService f;
    public int g;
    SensorEventListener h;
    private String u;
    private View v;
    private ImageView w;
    private boolean x;
    private int y;
    private ArrayList z;

    public ActivityCameraNew()
    {
        u = "ActivityCameraNew";
        y = 0;
        z = new ArrayList();
        H = 0;
        ag = 0.5F;
        ai = true;
        aj = false;
        ar = 0;
        d = true;
        as = false;
        au = false;
        az = new nd(this);
        aA = new ng(this);
        aB = new nh(this);
        aC = new ll(this);
        aD = new lm(this);
        aE = new lo(this);
        aF = new lp(this);
        aG = new lq(this);
        aH = new lt(this);
        aI = 0L;
        aJ = 0L;
        aM = new ArrayList();
        e = false;
        aN = false;
        aO = new lv(this);
        aP = new lw(this);
        aQ = new lx(this);
        aR = new lz(this);
        aS = new ma(this);
        aU = new Handler();
        aV = 1;
        aW = new ArrayList();
        f = Executors.newCachedThreadPool();
        g = 0;
        aY = new mn(this);
        aZ = new mq(this);
        ba = false;
    }

    public static ArrayList A(ActivityCameraNew activitycameranew)
    {
        return activitycameranew.z;
    }

    private void A()
    {
        k.setIsTakingPhoto(false);
        N.setVisibility(4);
    }

    public static FrameLayout B(ActivityCameraNew activitycameranew)
    {
        return activitycameranew.A;
    }

    private void B()
    {
        runOnUiThread(new mh(this));
    }

    private void C()
    {
        if (pt.b(pt.b, this, true))
        {
            Toast.makeText(getBaseContext(), 0x7f0600a3, 0).show();
        }
        Intent intent = new Intent(this, com/fotoable/beautyui/newui/MNewFotoBeautyActivity);
        intent.putExtra(MNewFotoBeautyActivity.e, aa);
        intent.putExtra(MNewFotoBeautyActivity.f, ag);
        intent.putExtra(MNewFotoBeautyActivity.a, 1);
        intent.putExtra(MNewFotoBeautyActivity.g, 11);
        intent.putExtra(c, au);
        if (at != null)
        {
            intent.putExtra(MNewFotoBeautyActivity.i, at.toString());
            startActivityForResult(intent, 1244);
            return;
        } else
        {
            startActivity(intent);
            return;
        }
    }

    public static boolean C(ActivityCameraNew activitycameranew)
    {
        return activitycameranew.n;
    }

    private void D()
    {
        if (k.getCamera() == null)
        {
            finish();
            return;
        }
        try
        {
            k.getCamera().autoFocus(new mi(this));
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            Crashlytics.logException(exception);
            K.setVisibility(4);
            K.clearAnimation();
            return;
        }
    }

    public static void D(ActivityCameraNew activitycameranew)
    {
        activitycameranew.v();
    }

    private void E()
    {
        if (aX != null)
        {
            aX.b();
            aX = null;
        }
        boolean flag = k.isFrontFacing();
        aX = new oj(this, flag, new mj(this, flag));
        aX.a();
    }

    public static void E(ActivityCameraNew activitycameranew)
    {
        activitycameranew.x();
    }

    private void F()
    {
        O.setVisibility(8);
        P.setVisibility(8);
        Q.setVisibility(8);
        R.setVisibility(8);
        S.setVisibility(8);
        T.setVisibility(8);
        U.setVisibility(8);
        V.setVisibility(8);
        W.setVisibility(8);
        X.setVisibility(8);
        Y.setVisibility(8);
        E.setVisibility(8);
    }

    public static boolean F(ActivityCameraNew activitycameranew)
    {
        return activitycameranew.aN;
    }

    public static ImageButton G(ActivityCameraNew activitycameranew)
    {
        return activitycameranew.S;
    }

    private void G()
    {
        L.getViewTreeObserver().addOnGlobalLayoutListener(new mm(this));
    }

    public static ArrayList H(ActivityCameraNew activitycameranew)
    {
        return activitycameranew.aM;
    }

    private void H()
    {
        try
        {
            System.gc();
            Intent intent = new Intent();
            intent.setClass(this, com/fotoable/fotobeauty/WantuActivity);
            intent.setFlags(0x4000000);
            startActivity(intent);
            return;
        }
        catch (ActivityNotFoundException activitynotfoundexception)
        {
            Crashlytics.logException(activitynotfoundexception);
        }
    }

    private void I()
    {
        al.clearAnimation();
        TranslateAnimation translateanimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, yp.a(this, 70F));
        translateanimation.setDuration(300L);
        translateanimation.setFillEnabled(true);
        translateanimation.setFillAfter(true);
        translateanimation.setAnimationListener(new ms(this));
        al.startAnimation(translateanimation);
    }

    public static void I(ActivityCameraNew activitycameranew)
    {
        activitycameranew.r();
    }

    private void J()
    {
        al.clearAnimation();
        TranslateAnimation translateanimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -yp.a(this, 70F));
        translateanimation.setDuration(300L);
        translateanimation.setFillEnabled(true);
        translateanimation.setFillAfter(true);
        translateanimation.setAnimationListener(new mt(this));
        al.startAnimation(translateanimation);
    }

    public static void J(ActivityCameraNew activitycameranew)
    {
        activitycameranew.p();
    }

    public static ImageButton K(ActivityCameraNew activitycameranew)
    {
        return activitycameranew.W;
    }

    private void K()
    {
        bb = (SensorManager)getSystemService("sensor");
        bb.getSensorList(-1);
        bc = bb.getDefaultSensor(5);
        if (bc == null)
        {
            return;
        } else
        {
            float f1 = bc.getMaximumRange();
            Log.e(u, (new StringBuilder()).append("light sensor maximum = ").append(f1).toString());
            h = new na(this);
            bb.registerListener(h, bc, 2);
            return;
        }
    }

    public static void L(ActivityCameraNew activitycameranew)
    {
        activitycameranew.s();
    }

    public static int M(ActivityCameraNew activitycameranew)
    {
        return activitycameranew.aV;
    }

    public static ImageView N(ActivityCameraNew activitycameranew)
    {
        return activitycameranew.D;
    }

    public static int O(ActivityCameraNew activitycameranew)
    {
        int i1 = activitycameranew.aV;
        activitycameranew.aV = i1 + 1;
        return i1;
    }

    public static Handler P(ActivityCameraNew activitycameranew)
    {
        return activitycameranew.aU;
    }

    public static View Q(ActivityCameraNew activitycameranew)
    {
        return activitycameranew.F;
    }

    public static void R(ActivityCameraNew activitycameranew)
    {
        activitycameranew.C();
    }

    public static void S(ActivityCameraNew activitycameranew)
    {
        activitycameranew.z();
    }

    public static void T(ActivityCameraNew activitycameranew)
    {
        activitycameranew.B();
    }

    public static void U(ActivityCameraNew activitycameranew)
    {
        activitycameranew.A();
    }

    public static ImageView V(ActivityCameraNew activitycameranew)
    {
        return activitycameranew.K;
    }

    public static ImageView W(ActivityCameraNew activitycameranew)
    {
        return activitycameranew.J;
    }

    public static oj X(ActivityCameraNew activitycameranew)
    {
        return activitycameranew.aX;
    }

    public static FrameLayout Y(ActivityCameraNew activitycameranew)
    {
        return activitycameranew.I;
    }

    public static FrameLayout Z(ActivityCameraNew activitycameranew)
    {
        return activitycameranew.L;
    }

    public static float a(ActivityCameraNew activitycameranew, float f1)
    {
        activitycameranew.ag = f1;
        return f1;
    }

    private int a(int i1, int j1)
    {
        if (i1 == 1)
        {
            if (j1 < 300)
            {
                return 300;
            }
            return j1 >= 600 ? 640 : 640;
        }
        if (j1 < 900)
        {
            return 800;
        }
        return j1 >= 1200 ? 1280 : 960;
    }

    public static String a(ActivityCameraNew activitycameranew, int i1)
    {
        return activitycameranew.b(i1);
    }

    public static void a(Activity activity, int i1)
    {
        Intent intent = new Intent(activity, com/fotoable/beautyui/gpuimage/sample/activity/ActivityCameraNew);
        intent.putExtra(b, jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState.STATE_TAKE_PHOTO);
        intent.putExtra(c, true);
        activity.startActivityForResult(intent, i1);
    }

    private static void a(Context context)
    {
        context = new File((new StringBuilder()).append(ik.a(context)).append("/camera_photo_temp").toString());
        if (!context.exists() || !context.isDirectory()) goto _L2; else goto _L1
_L1:
        String as1[] = context.list();
        int i1 = 0;
_L3:
        if (i1 >= as1.length)
        {
            break; /* Loop/switch isn't completed */
        }
        (new File(context, as1[i1])).delete();
        i1++;
        if (true) goto _L3; else goto _L2
        context;
        context.printStackTrace();
        Crashlytics.logException(context);
_L2:
    }

    public static void a(ActivityCameraNew activitycameranew)
    {
        activitycameranew.l();
    }

    public static void a(ActivityCameraNew activitycameranew, String s1)
    {
        activitycameranew.b(s1);
    }

    public static void a(ActivityCameraNew activitycameranew, jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState enumcameracapturestate)
    {
        activitycameranew.a(enumcameracapturestate);
    }

    private void a(jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState enumcameracapturestate)
    {
        F();
        P.setVisibility(0);
        int i1;
        if (k.getPreviewRatio() == jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumPreviewRatio.Ratio_four2three)
        {
            W.setBackgroundResource(0x7f02018f);
        } else
        {
            W.setBackgroundResource(0x7f020190);
        }
        i1 = getResources().getDisplayMetrics().widthPixels;
        switch (nb.b[enumcameracapturestate.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            O.setVisibility(0);
            U.setVisibility(0);
            E.setVisibility(0);
            enumcameracapturestate = new android.widget.FrameLayout.LayoutParams(-1, -1);
            enumcameracapturestate.width = yp.a(this, 40F);
            enumcameracapturestate.height = yp.a(this, 40F);
            enumcameracapturestate.gravity = 19;
            enumcameracapturestate.leftMargin = i1 / 4 - yp.a(this, 35F);
            O.setLayoutParams(enumcameracapturestate);
            enumcameracapturestate = new android.widget.FrameLayout.LayoutParams(-1, -1);
            enumcameracapturestate.width = yp.a(this, 40F);
            enumcameracapturestate.height = yp.a(this, 40F);
            enumcameracapturestate.gravity = 19;
            enumcameracapturestate.leftMargin = (i1 * 3) / 4 - yp.a(this, 5F);
            P.setLayoutParams(enumcameracapturestate);
            return;

        case 2: // '\002'
            U.setVisibility(0);
            E.setVisibility(0);
            enumcameracapturestate = new android.widget.FrameLayout.LayoutParams(-1, -1);
            enumcameracapturestate.width = yp.a(this, 40F);
            enumcameracapturestate.height = yp.a(this, 40F);
            enumcameracapturestate.gravity = 19;
            enumcameracapturestate.leftMargin = i1 / 4 - yp.a(this, 35F);
            P.setLayoutParams(enumcameracapturestate);
            return;

        case 3: // '\003'
            V.setVisibility(8);
            G.setVisibility(4);
            enumcameracapturestate = new android.widget.FrameLayout.LayoutParams(-1, -1);
            enumcameracapturestate.width = yp.a(this, 40F);
            enumcameracapturestate.height = yp.a(this, 40F);
            enumcameracapturestate.gravity = 19;
            enumcameracapturestate.leftMargin = yp.a(this, 60F);
            W.setLayoutParams(enumcameracapturestate);
            R.setVisibility(0);
            R.setBackgroundResource(0x7f020152);
            W.setVisibility(0);
            return;

        case 4: // '\004'
            V.setVisibility(0);
            V.setBackgroundResource(0x7f020194);
            Q.setVisibility(0);
            Q.setBackgroundResource(0x7f020152);
            W.setVisibility(0);
            T.setVisibility(0);
            G.setVisibility(4);
            return;

        case 5: // '\005'
            Y.setVisibility(0);
            R.setVisibility(0);
            R.setBackgroundResource(0x7f020153);
            G.setVisibility(4);
            return;

        case 6: // '\006'
            S.setVisibility(0);
            break;
        }
        S.setBackgroundResource(0x7f020191);
        Q.setVisibility(0);
        Q.setBackgroundResource(0x7f020152);
        X.setVisibility(0);
        T.setVisibility(0);
        G.setVisibility(4);
    }

    public static boolean a(ActivityCameraNew activitycameranew, nk nk1)
    {
        return activitycameranew.a(nk1);
    }

    public static boolean a(ActivityCameraNew activitycameranew, boolean flag)
    {
        activitycameranew.as = flag;
        return flag;
    }

    private boolean a(nk nk1)
    {
        (new Thread(new nc(this, nk1))).start();
        return true;
    }

    public static FrameLayout aa(ActivityCameraNew activitycameranew)
    {
        return activitycameranew.M;
    }

    public static bzu ab(ActivityCameraNew activitycameranew)
    {
        return activitycameranew.l;
    }

    public static bzu ac(ActivityCameraNew activitycameranew)
    {
        return activitycameranew.l;
    }

    public static FrameLayout ad(ActivityCameraNew activitycameranew)
    {
        return activitycameranew.al;
    }

    public static boolean ae(ActivityCameraNew activitycameranew)
    {
        return activitycameranew.o;
    }

    public static boolean af(ActivityCameraNew activitycameranew)
    {
        return activitycameranew.n;
    }

    public static void ag(ActivityCameraNew activitycameranew)
    {
        activitycameranew.D();
    }

    public static boolean ah(ActivityCameraNew activitycameranew)
    {
        return activitycameranew.o;
    }

    public static CameraFilterScrollView ai(ActivityCameraNew activitycameranew)
    {
        return activitycameranew.Z;
    }

    public static TextView aj(ActivityCameraNew activitycameranew)
    {
        return activitycameranew.ad;
    }

    public static float ak(ActivityCameraNew activitycameranew)
    {
        return activitycameranew.bd;
    }

    public static float b(ActivityCameraNew activitycameranew, float f1)
    {
        activitycameranew.bd = f1;
        return f1;
    }

    public static int b(ActivityCameraNew activitycameranew, int i1)
    {
        activitycameranew.aa = i1;
        return i1;
    }

    public static SeperateMovieBar b(ActivityCameraNew activitycameranew)
    {
        return activitycameranew.T;
    }

    private String b(int i1)
    {
        int j1 = i1;
        if (i1 > 3599)
        {
            j1 = 3599;
        }
        i1 = j1 / 60;
        j1 %= 60;
        String s1;
        String s2;
        if (i1 < 10)
        {
            s1 = String.format("0%d", new Object[] {
                Integer.valueOf(i1)
            });
        } else
        {
            s1 = String.format("%d", new Object[] {
                Integer.valueOf(i1)
            });
        }
        if (j1 < 10)
        {
            s2 = String.format("0%d", new Object[] {
                Integer.valueOf(j1)
            });
        } else
        {
            s2 = String.format("%d", new Object[] {
                Integer.valueOf(j1)
            });
        }
        return (new StringBuilder()).append(s1).append(":").append(s2).toString();
    }

    public static String b(ActivityCameraNew activitycameranew, String s1)
    {
        activitycameranew.ab = s1;
        return s1;
    }

    public static void b(Activity activity, int i1)
    {
        Intent intent = new Intent(activity, com/fotoable/beautyui/gpuimage/sample/activity/ActivityCameraNew);
        intent.putExtra(b, jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState.STATE_TAKE_PHOTO);
        activity.startActivityForResult(intent, i1);
    }

    private void b(String s1)
    {
        ad.setText(s1);
        s1 = new AlphaAnimation(0.0F, 1.0F);
        s1.setDuration(1000L);
        s1.setAnimationListener(new mo(this));
        ad.startAnimation(s1);
    }

    public static boolean b(ActivityCameraNew activitycameranew, boolean flag)
    {
        activitycameranew.ax = flag;
        return flag;
    }

    public static int c(ActivityCameraNew activitycameranew)
    {
        return activitycameranew.ar;
    }

    public static int c(ActivityCameraNew activitycameranew, int i1)
    {
        activitycameranew.H = i1;
        return i1;
    }

    private void c(int i1)
    {
        ArrayList arraylist = k.getFlashLightList();
        if (!k.isFrontFacing()) goto _L2; else goto _L1
_L1:
        G.setVisibility(0);
        i1;
        JVM INSTR tableswitch 0 2: default 52
    //                   0 53
    //                   1 64
    //                   2 75;
           goto _L3 _L4 _L5 _L6
_L3:
        return;
_L4:
        G.setImageResource(0x7f0200f2);
        return;
_L5:
        G.setImageResource(0x7f0200f3);
        return;
_L6:
        G.setImageResource(0x7f0200f4);
        return;
_L2:
        if (i1 < arraylist.size())
        {
            G.setVisibility(0);
            if (((String)arraylist.get(i1)).equals("auto"))
            {
                G.setImageResource(0x7f0200f2);
                k.setCameraFlashlight("auto");
            }
            if (((String)arraylist.get(i1)).equals("off"))
            {
                G.setImageResource(0x7f0200f3);
                k.setCameraFlashlight("off");
            }
            if (((String)arraylist.get(i1)).equals("on"))
            {
                G.setImageResource(0x7f0200f4);
                k.setCameraFlashlight("on");
            }
            if (((String)arraylist.get(i1)).equals("torch"))
            {
                G.setImageResource(0x7f0200f4);
                k.setCameraFlashlight("torch");
                return;
            }
        }
        if (true) goto _L3; else goto _L7
_L7:
    }

    public static void c(Activity activity, int i1)
    {
        Intent intent = new Intent(activity, com/fotoable/beautyui/gpuimage/sample/activity/ActivityCameraNew);
        intent.putExtra(b, jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState.STATE_CONTINUOUS_PHOTO);
        activity.startActivityForResult(intent, i1);
    }

    public static boolean c(ActivityCameraNew activitycameranew, boolean flag)
    {
        activitycameranew.aj = flag;
        return flag;
    }

    public static TextView d(ActivityCameraNew activitycameranew)
    {
        return activitycameranew.Y;
    }

    public static void d(Activity activity, int i1)
    {
        Intent intent = new Intent(activity, com/fotoable/beautyui/gpuimage/sample/activity/ActivityCameraNew);
        intent.putExtra(b, jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState.STATE_PREPARE_CONTINOUS_RECORD);
        activity.startActivityForResult(intent, i1);
    }

    public static void d(ActivityCameraNew activitycameranew, int i1)
    {
        activitycameranew.c(i1);
    }

    public static boolean d(ActivityCameraNew activitycameranew, boolean flag)
    {
        activitycameranew.n = flag;
        return flag;
    }

    public static int e(ActivityCameraNew activitycameranew, int i1)
    {
        activitycameranew.y = i1;
        return i1;
    }

    public static boolean e(ActivityCameraNew activitycameranew)
    {
        return activitycameranew.m();
    }

    public static boolean e(ActivityCameraNew activitycameranew, boolean flag)
    {
        activitycameranew.o = flag;
        return flag;
    }

    public static int[] e()
    {
        return ay;
    }

    public static nk f(ActivityCameraNew activitycameranew)
    {
        return activitycameranew.aq;
    }

    public static boolean f(ActivityCameraNew activitycameranew, boolean flag)
    {
        activitycameranew.p = flag;
        return flag;
    }

    public static int g(ActivityCameraNew activitycameranew)
    {
        int i1 = activitycameranew.ar;
        activitycameranew.ar = i1 + 1;
        return i1;
    }

    public static boolean g(ActivityCameraNew activitycameranew, boolean flag)
    {
        activitycameranew.aN = flag;
        return flag;
    }

    public static ImageView h(ActivityCameraNew activitycameranew)
    {
        return activitycameranew.ah;
    }

    public static String i(ActivityCameraNew activitycameranew)
    {
        return activitycameranew.u;
    }

    private void j()
    {
        if (h != null && bc != null)
        {
            bb.unregisterListener(h, bc);
        }
    }

    public static boolean j(ActivityCameraNew activitycameranew)
    {
        return activitycameranew.aj;
    }

    private void k()
    {
        Display display = getWindowManager().getDefaultDisplay();
        av = display.getWidth();
        aw = display.getHeight();
    }

    public static void k(ActivityCameraNew activitycameranew)
    {
        activitycameranew.I();
    }

    public static Button l(ActivityCameraNew activitycameranew)
    {
        return activitycameranew.P;
    }

    private void l()
    {
        if (!pt.b(pt.q, this, false))
        {
            ah.setVisibility(0);
            Animation animation = AnimationUtils.loadAnimation(this, 0x7f040013);
            animation.setAnimationListener(new ne(this));
            ah.setAnimation(animation);
        }
    }

    public static void m(ActivityCameraNew activitycameranew)
    {
        activitycameranew.J();
    }

    private boolean m()
    {
        Q.setBackgroundResource(0x7f020152);
        i();
        if (am != null)
        {
            am.cancel();
        }
        T.stopCapture();
        return true;
    }

    public static int n(ActivityCameraNew activitycameranew)
    {
        int i1 = activitycameranew.H;
        activitycameranew.H = i1 + 1;
        return i1;
    }

    private void n()
    {
        a(new File(aK));
        aM.remove(aK);
        if (aM.size() < 1)
        {
            k.setCaptureState(jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState.STATE_PREPARE_SEPERATE_RECORD);
            a(jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState.STATE_PREPARE_SEPERATE_RECORD);
        } else
        {
            k.setCaptureState(jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState.STATE_SEPERATE_RECORD);
            a(jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState.STATE_SEPERATE_RECORD);
        }
        try
        {
            i();
        }
        catch (Exception exception) { }
        if (am != null)
        {
            am.cancel();
        }
        T.stopCapture();
        T.deleteMovie();
    }

    public static int o(ActivityCameraNew activitycameranew)
    {
        return activitycameranew.H;
    }

    private boolean o()
    {
        aI = System.nanoTime();
        String s1 = (new StringBuilder()).append(pu.b(this).toString()).append("/").append(u()).toString();
        if (s1 == aK)
        {
            deleteFile(aK);
        }
        new File(s1);
        aK = s1;
        a(s1);
        if (k.getCaptureState() != jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState.STATE_SEPERATE_RECORD)
        {
            a(jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState.STATE_SEPERATE_RECORD);
        }
        S.setBackgroundResource(0x7f020191);
        Q.setBackgroundResource(0x7f0203cb);
        T.setBarState(com.fotoable.beautyui.other.SeperateMovieBar.MovieBarState.STATE_CAPTURING);
        T.startCapture();
        am = new Timer();
        ao = new ni(this);
        am.schedule(ao, 0L, 30L);
        return true;
    }

    public static ImageView p(ActivityCameraNew activitycameranew)
    {
        return activitycameranew.E;
    }

    private void p()
    {
        if (ax) goto _L2; else goto _L1
_L1:
        oj.a(this, new lu(this));
_L4:
        return;
_L2:
        aL = (new File(pu.b(this).toString(), u())).toString();
        aJ = System.nanoTime();
        ba = false;
        jp.co.cyberagent.android.gpuimage.grafika.CameraCaptureActivity.EnumRecordResult enumrecordresult = a(aL);
        switch (nb.a[enumrecordresult.ordinal()])
        {
        default:
            return;

        case 2: // '\002'
            break;

        case 1: // '\001'
            k.setCaptureState(jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState.STATE_CONTINOUS_RECORD);
            a(jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState.STATE_CONTINOUS_RECORD);
            an = new Timer();
            ap = new nj(this);
            an.schedule(ap, 0L, 1000L);
            return;

        case 3: // '\003'
            Toast.makeText(this, 0x7f0601d8, 0).show();
            break; /* Loop/switch isn't completed */
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void q()
    {
        if (an != null)
        {
            an.cancel();
            an = null;
        }
        if (ap != null)
        {
            ap.cancel();
            ap = null;
        }
        ar = 0;
        Y.setText("00:00");
    }

    public static void q(ActivityCameraNew activitycameranew)
    {
        activitycameranew.E();
    }

    private void r()
    {
        if (System.nanoTime() - aJ < 0x1dcd6500L)
        {
            ba = true;
            i();
            Toast.makeText(this, 0x7f0602f2, 0).show();
            return;
        } else
        {
            i();
            k.setCaptureState(jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState.STATE_PREPARE_CONTINOUS_RECORD);
            a(jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState.STATE_PREPARE_CONTINOUS_RECORD);
            sm.a(aL, this);
            return;
        }
    }

    public static boolean r(ActivityCameraNew activitycameranew)
    {
        return activitycameranew.x;
    }

    public static View s(ActivityCameraNew activitycameranew)
    {
        return activitycameranew.v;
    }

    private void s()
    {
        aL = (new File(pu.b(this).toString(), u())).toString();
        try
        {
            Log.e("yyy", (new StringBuilder()).append("mMovieNameList.size() = ").append(aM.size()).toString());
            String s1;
            for (Iterator iterator = aM.iterator(); iterator.hasNext(); Log.e("yyy", (new StringBuilder()).append("strName = ").append(s1).toString()))
            {
                s1 = (String)iterator.next();
            }

        }
        catch (Exception exception)
        {
            Log.e(u, (new StringBuilder()).append("mergeMovie exception = ").append(exception.toString()).toString());
        }
        for (Iterator iterator1 = aM.iterator(); iterator1.hasNext(); a(new File((String)iterator1.next()))) { }
        aM.clear();
        T.clear();
        sm.a(aL, this);
        k.setCaptureState(jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState.STATE_PREPARE_SEPERATE_RECORD);
        a(jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState.STATE_PREPARE_SEPERATE_RECORD);
        Intent intent = new Intent(this, com/fotoable/beautyui/gpuimage/sample/activity/ActivityMediaPlayerTest);
        Bundle bundle = new Bundle();
        bundle.putString("movie_name", aL);
        bundle.putInt("video_width", k.getPreviewHeight());
        bundle.putInt("video_height", k.getPreviewWidth());
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private static final String t()
    {
        GregorianCalendar gregoriancalendar = new GregorianCalendar();
        return aT.format(gregoriancalendar.getTime());
    }

    public static void t(ActivityCameraNew activitycameranew)
    {
        activitycameranew.h();
    }

    private static final String u()
    {
        return (new StringBuilder()).append("FOTORUS-").append(t()).append(".mp4").toString();
    }

    public static void u(ActivityCameraNew activitycameranew)
    {
        activitycameranew.G();
    }

    public static GestureDetector v(ActivityCameraNew activitycameranew)
    {
        return activitycameranew.ac;
    }

    private void v()
    {
        N.setVisibility(0);
        D.setVisibility(0);
        aV = 1;
        mb mb1 = new mb(this);
        aU.post(mb1);
    }

    public static long w(ActivityCameraNew activitycameranew)
    {
        return activitycameranew.aI;
    }

    private void w()
    {
        e = false;
        as = false;
    }

    private void x()
    {
        if (k.getIsTakingPhoto())
        {
            return;
        }
        if (q)
        {
            F.setVisibility(0);
        }
        k.takePhoto();
    }

    public static void x(ActivityCameraNew activitycameranew)
    {
        activitycameranew.n();
    }

    private void y()
    {
        findViewById(0x7f0d0060).setVisibility(0);
    }

    public static boolean y(ActivityCameraNew activitycameranew)
    {
        return activitycameranew.o();
    }

    public static ImageView z(ActivityCameraNew activitycameranew)
    {
        return activitycameranew.B;
    }

    private void z()
    {
        findViewById(0x7f0d0060).setVisibility(8);
    }

    public int a()
    {
        int i1;
        boolean flag;
        flag = false;
        i1 = ((flag) ? 1 : 0);
        getWindowManager().getDefaultDisplay().getRotation();
        JVM INSTR tableswitch 0 3: default 48
    //                   0 50
    //                   1 77
    //                   2 83
    //                   3 90;
           goto _L1 _L2 _L3 _L4 _L5
_L5:
        break MISSING_BLOCK_LABEL_90;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        i1 = ((flag) ? 1 : 0);
_L6:
        android.hardware.Camera.CameraInfo camerainfo = k.getCameraInfo();
        if (camerainfo.facing == 1)
        {
            return (i1 + camerainfo.orientation) % 360;
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

    public void a(int i1)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("FPS Count", (new StringBuilder()).append("").append(i1).toString());
        FlurryAgent.logEvent("camera_fps_count", hashmap);
    }

    public void a(File file)
    {
        if (!file.exists()) goto _L2; else goto _L1
_L1:
        if (!file.isFile()) goto _L4; else goto _L3
_L3:
        file.delete();
_L6:
        file.delete();
_L2:
        return;
_L4:
        if (file.isDirectory())
        {
            File afile[] = file.listFiles();
            int i1 = 0;
            while (i1 < afile.length) 
            {
                a(afile[i1]);
                i1++;
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void a(String s1, Exception exception)
    {
        runOnUiThread(new mv(this, s1));
    }

    protected void a(boolean flag)
    {
        super.m = true;
        if (!t) goto _L2; else goto _L1
_L1:
        t = false;
_L4:
        return;
_L2:
        jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState enumcameracapturestate;
        enumcameracapturestate = k.getCaptureState();
        if (enumcameracapturestate != jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState.STATE_SEPERATE_RECORD)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!flag && !aM.contains(aK))
        {
            aM.add(aK);
            e = true;
            if (as)
            {
                s();
                as = false;
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
        if (enumcameracapturestate != jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState.STATE_CONTINOUS_RECORD && enumcameracapturestate != jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState.STATE_PREPARE_CONTINOUS_RECORD) goto _L4; else goto _L3
_L3:
        q();
        if (!flag)
        {
            if (ba || !d)
            {
                a(new File(aL));
                sm.a(aL, this);
                k.setCaptureState(jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState.STATE_PREPARE_CONTINOUS_RECORD);
                a(jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState.STATE_PREPARE_CONTINOUS_RECORD);
                return;
            } else
            {
                Intent intent = new Intent(this, com/fotoable/beautyui/gpuimage/sample/activity/ActivityMediaPlayerTest);
                Bundle bundle = new Bundle();
                bundle.putString("movie_name", aL);
                bundle.putInt("video_width", k.getPreviewHeight());
                bundle.putInt("video_height", k.getPreviewWidth());
                intent.putExtras(bundle);
                startActivity(intent);
                return;
            }
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public void a(byte abyte0[])
    {
        Object obj;
        Object obj1;
        int i1;
        boolean flag;
        runOnUiThread(new mc(this));
        i1 = a(ik.a(), ik.b());
        try
        {
            obj = pu.a(x, getApplicationContext());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((IOException) (obj)).printStackTrace();
            obj = null;
        }
        if (obj == null)
        {
            Toast.makeText(getApplicationContext(), "no sdcard!", 0).show();
            B();
            return;
        }
        obj1 = Uri.fromFile(((File) (obj))).toString();
        flag = k.isFrontFacing();
        if (x)
        {
            abyte0 = yo.a(abyte0, abyte0, i1, i1);
            obj1 = new Matrix();
            ((Matrix) (obj1)).postRotate(oj.a(flag, this));
            if (flag)
            {
                ((Matrix) (obj1)).postScale(-1F, 1.0F);
            }
            abyte0 = Bitmap.createBitmap(abyte0, 0, 0, abyte0.getWidth(), abyte0.getHeight(), ((Matrix) (obj1)), true);
            abyte0 = Bitmap.createScaledBitmap(abyte0, (int)((float)i1 * ((float)abyte0.getWidth() / (float)abyte0.getHeight())), i1, true);
            k.stopPreview();
            if (flag)
            {
                flag = pt.b(pt.b, InstaBeautyApplication.a, true);
            } else
            {
                flag = pt.b(pt.c, InstaBeautyApplication.a, false);
            }
            y();
            uv.c().a(abyte0, ((File) (obj)).getAbsolutePath(), flag, new md(this));
            return;
        }
        A();
        A.setVisibility(0);
        y = y + 1;
        if (aW.size() != 0) goto _L2; else goto _L1
_L1:
        aW.add(k.getTakePicSize());
_L4:
        C.setText(String.valueOf(y));
        contiCapEditItem conticapedititem = new contiCapEditItem();
        conticapedititem.urlStr = ((String) (obj1));
        conticapedititem.filterFlag = aa;
        conticapedititem.softLevel = ag;
        z.add(conticapedititem);
        B();
        obj = ((File) (obj)).getAbsolutePath();
        f.execute(new mf(this, abyte0, i1, flag, ((String) (obj))));
        return;
_L2:
        if (!k.getTakePicSize().equals(aW.get(0)))
        {
            r = true;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void b()
    {
        super.t = true;
        q();
        Toast.makeText(getApplicationContext(), 0x7f0601d8, 0).show();
        a(new File(aL));
        sm.a(aL, this);
        super.m = true;
        H();
    }

    public void b(boolean flag)
    {
        if (!flag)
        {
            return;
        } else
        {
            runOnUiThread(new mz(this));
            return;
        }
    }

    public void c()
    {
        runOnUiThread(new mu(this));
    }

    public void d()
    {
        runOnUiThread(new mx(this));
        k.setIsSwitchCamera(false);
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        i1;
        JVM INSTR tableswitch 1243 1244: default 32
    //                   1243 33
    //                   1244 119;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        if (intent != null && (intent = intent.getData()) != null && (intent = intent.toString()) != null)
        {
            Intent intent1 = new Intent(this, com/fotoable/beautyui/newui/MNewFotoBeautyActivity);
            intent1.putExtra(MNewFotoBeautyActivity.b, intent);
            intent1.putExtra(MNewFotoBeautyActivity.a, 2);
            intent1.putExtra(MNewFotoBeautyActivity.g, 10);
            intent1.putExtra(c, au);
            startActivity(intent1);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (at != null && intent != null)
        {
            if (intent.getBooleanExtra(MNewFotoBeautyActivity.h, true))
            {
                setResult(-1);
            } else
            {
                setResult(0);
            }
            runOnUiThread(new mr(this));
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().addFlags(1024);
        setContentView(0x7f03001c);
        BeautyCameraGLSurfaceView beautycameraglsurfaceview = (BeautyCameraGLSurfaceView)findViewById(0x7f0d0065);
        beautycameraglsurfaceview.setCameraCallBack(this);
        k();
        T = (SeperateMovieBar)findViewById(0x7f0d006b);
        S = (ImageButton)findViewById(0x7f0d006e);
        Q = (ImageButton)findViewById(0x7f0d006a);
        R = (ImageButton)findViewById(0x7f0d0071);
        V = (ImageButton)findViewById(0x7f0d006c);
        W = (ImageButton)findViewById(0x7f0d006d);
        Y = (TextView)findViewById(0x7f0d0070);
        X = (ImageButton)findViewById(0x7f0d006f);
        aq = new nk(this);
        T.setMovieHandler(aq);
        U = (ImageButton)findViewById(0x7f0d005c);
        O = (TextView)findViewById(0x7f0d0072);
        P = (Button)findViewById(0x7f0d0069);
        if (P.getBackground() != null)
        {
            P.getBackground().clearColorFilter();
        }
        Bundle bundle1;
        try
        {
            super.a(beautycameraglsurfaceview, this, true);
            System.out.println((new StringBuilder()).append("isopensoft:").append(true).toString());
            pt.a(pt.o, this, 0.7F);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        bundle = jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState.STATE_TAKE_PHOTO;
        bundle1 = getIntent().getExtras();
        if (bundle1 != null)
        {
            if (bundle1.get(b) != null)
            {
                bundle = (jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState)bundle1.get(b);
            }
            au = bundle1.getBoolean(c, false);
            if (au)
            {
                FlurryAgent.logEvent("camera_start_from_shortcut");
            }
            at = (Uri)bundle1.getParcelable("output");
            bundle1 = bundle;
            if (at != null)
            {
                FlurryAgent.logEvent("camera_start_from_three");
                bundle1 = bundle;
            }
        } else
        {
            bundle1 = bundle;
        }
        a(av, aw, bundle1);
        if (bundle1 == jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState.STATE_CONTINUOUS_PHOTO)
        {
            x = false;
        } else
        {
            x = true;
        }
        w = (ImageView)findViewById(0x7f0d0056);
        v = findViewById(0x7f0d0066);
        v.setVisibility(8);
        A = (FrameLayout)findViewById(0x7f0d005d);
        B = (ImageView)findViewById(0x7f0d0073);
        C = (TextView)findViewById(0x7f0d0074);
        D = (ImageView)findViewById(0x7f0d0077);
        E = (ImageView)findViewById(0x7f0d0058);
        F = findViewById(0x7f0d0050);
        G = (ImageView)findViewById(0x7f0d0057);
        I = (FrameLayout)findViewById(0x7f0d0064);
        J = (ImageView)(ImageView)findViewById(0x7f0d004f);
        K = (ImageView)findViewById(0x7f0d0051);
        L = (FrameLayout)findViewById(0x7f0d005a);
        M = (FrameLayout)findViewById(0x7f0d0053);
        N = (FrameLayout)findViewById(0x7f0d0076);
        Z = (CameraFilterScrollView)findViewById(0x7f0d0068);
        ad = (TextView)findViewById(0x7f0d0075);
        ah = (ImageView)findViewById(0x7f0d0078);
        al = (FrameLayout)findViewById(0x7f0d0067);
        O.setOnClickListener(aZ);
        Z.setListener(aA);
        P.setOnClickListener(aB);
        F.setVisibility(4);
        E.setOnClickListener(aD);
        w.setOnClickListener(aE);
        A.setVisibility(4);
        C.setText("0");
        U.setOnClickListener(aH);
        B.setOnClickListener(aG);
        B.getBackground().setColorFilter(getResources().getColor(0x7f0c0010), android.graphics.PorterDuff.Mode.SRC_IN);
        G.setOnClickListener(aC);
        beautycameraglsurfaceview.setOnTouchListener(aF);
        ac = new GestureDetector(this, aY);
        Q.setOnTouchListener(aF);
        S.setOnClickListener(aO);
        X.setOnClickListener(aS);
        V.setOnClickListener(aR);
        W.setOnClickListener(aQ);
        R.setOnClickListener(aP);
        N.setOnClickListener(az);
        pt.b(pt.d, this, true);
        n = pt.b(pt.i, this, false);
        o = pt.b(pt.j, this, false);
        aa = 0x7f0601a0;
        ab = getResources().getString(0x7f0601a0);
        ae = (LinearLayout)findViewById(0x7f0d0059);
        af = (SeekBar)findViewById(0x7f0d005b);
        af.setProgress(50);
        af.setOnSeekBarChangeListener(new ly(this));
        ah.setVisibility(8);
        ak = (ImageView)findViewById(0x7f0d0054);
        ak.setOnClickListener(new ml(this));
        G();
        if (bundle1 == jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState.STATE_PREPARE_CONTINOUS_RECORD)
        {
            (new Handler()).postDelayed(new my(this), 1000L);
        }
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (k != null)
        {
            jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState enumcameracapturestate = k.getCaptureState();
            if ((enumcameracapturestate == jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState.STATE_CONTINUOUS_PHOTO || enumcameracapturestate == jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState.STATE_TAKE_PHOTO) && (keyevent.getKeyCode() == 25 || keyevent.getKeyCode() == 24))
            {
                v();
                return true;
            }
        }
        return super.onKeyDown(i1, keyevent);
    }

    protected void onPause()
    {
        Log.e(u, "onPause -- releasing camera");
        d = false;
        if (k.getCaptureState() == jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState.STATE_CONTINOUS_RECORD)
        {
            q();
            jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState enumcameracapturestate = jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState.STATE_PREPARE_CONTINOUS_RECORD;
            k.setCaptureState(enumcameracapturestate);
            a(enumcameracapturestate);
        }
        super.onPause();
        j();
        Log.e(u, "onPause complete");
    }

    protected void onResume()
    {
        Object obj;
        super.onResume();
        obj = getWindow().getAttributes();
        obj.screenBrightness = 0.7F;
        getWindow().setAttributes(((android.view.WindowManager.LayoutParams) (obj)));
        FlurryAgent.onPageView();
        a(this);
        K();
        F.setVisibility(4);
        if (k.isFrontFacing())
        {
            g = pt.b(pt.k, this, 0);
        } else
        {
            g = pt.b(pt.l, this, 0);
        }
        g = g + a();
        obj = Rotation.NORMAL;
        g % 360;
        JVM INSTR lookupswitch 3: default 128
    //                   90: 201
    //                   180: 208
    //                   270: 215;
           goto _L1 _L2 _L3 _L4
_L1:
        d = true;
        k.setRotation(((Rotation) (obj)), k.isFrontFacing(), false);
        c(H);
        k.setIsTakingPhoto(false);
        N.setVisibility(4);
        b(ab);
        w();
        return;
_L2:
        obj = Rotation.ROTATION_90;
        continue; /* Loop/switch isn't completed */
_L3:
        obj = Rotation.ROTATION_180;
        continue; /* Loop/switch isn't completed */
_L4:
        obj = Rotation.ROTATION_270;
        if (true) goto _L1; else goto _L5
_L5:
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

    public void onWindowFocusChanged(boolean flag)
    {
        super.onWindowFocusChanged(flag);
        if (ai)
        {
            ai = false;
            lj lj1 = new lj(this);
            (new Timer()).schedule(lj1, 300L);
        }
    }

    static 
    {
        try
        {
            System.loadLibrary("fotobeautyengine");
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        aT = new SimpleDateFormat("yyyyMMdd-HHmmss", Locale.US);
    }
}
