// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera.view;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.hardware.Camera;
import android.media.AudioManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.TextView;
import com.picsart.studio.PicsartContext;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.exception.ExceptionReportService;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.d;
import com.socialin.android.util.Utils;
import com.socialin.camera.opengl.a;
import com.socialin.picsin.camera.CameraMainActivity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import myobfuscated.de.b;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.picsin.camera.view:
//            c, a, b, CameraFocusRectView, 
//            CustomVerticalSeekBar

public class CameraViewCupcake extends SurfaceView
    implements android.hardware.Camera.OnZoomChangeListener, android.os.Handler.Callback, android.view.SurfaceHolder.Callback, c
{

    public static int m = 4096;
    public static int n = 4096;
    private long A;
    private String B;
    private String C;
    private boolean D;
    private String E;
    private boolean F;
    private b G;
    private a H;
    private Point I;
    private boolean J;
    private ArrayList K;
    private myobfuscated.df.a L;
    private myobfuscated.df.a M;
    private String N;
    private boolean O;
    private int P;
    private int Q;
    private int R;
    private ScaleGestureDetector S;
    private float T;
    private HandlerThread U;
    protected Camera a;
    protected SurfaceHolder b;
    protected android.hardware.Camera.Parameters c;
    protected android.view.SurfaceHolder.Callback d;
    protected boolean e;
    protected boolean f;
    protected int g;
    protected boolean h;
    protected boolean i;
    protected boolean j;
    public boolean k;
    protected boolean l;
    Point o;
    protected Activity p;
    protected Handler q;
    private boolean r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private boolean y;
    private boolean z;

    public CameraViewCupcake(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        r = true;
        s = 0x80000000;
        t = 0x80000000;
        u = 0x80000000;
        v = 0x80000000;
        w = 0x80000000;
        x = 0x80000000;
        y = false;
        e = false;
        f = false;
        z = true;
        A = -1L;
        g = 0;
        h = false;
        i = false;
        D = false;
        E = null;
        F = true;
        j = false;
        k = false;
        l = true;
        o = null;
        J = false;
        K = null;
        N = null;
        O = false;
        P = 0;
        Q = 0;
        R = 0;
        T = 0.0F;
        a();
        j = true;
    }

    public CameraViewCupcake(android.view.ViewGroup.LayoutParams layoutparams, Activity activity, b b1)
    {
        super(activity);
        r = true;
        s = 0x80000000;
        t = 0x80000000;
        u = 0x80000000;
        v = 0x80000000;
        w = 0x80000000;
        x = 0x80000000;
        y = false;
        e = false;
        f = false;
        z = true;
        A = -1L;
        g = 0;
        h = false;
        i = false;
        D = false;
        E = null;
        F = true;
        j = false;
        k = false;
        l = true;
        o = null;
        J = false;
        K = null;
        N = null;
        O = false;
        P = 0;
        Q = 0;
        R = 0;
        T = 0.0F;
        setLayoutParams(layoutparams);
        a();
        j = true;
        G = b1;
        p = activity;
    }

    private void Y()
    {
        Context context = getContext();
        getContext();
        context.getSharedPreferences("CameraView", 0).getBoolean("is.send", false);
    }

    private String[] Z()
    {
        List list = c.getSupportedFocusModes();
        if (list != null)
        {
            return (String[])list.toArray(new String[list.size()]);
        } else
        {
            return null;
        }
    }

    static float a(CameraViewCupcake cameraviewcupcake)
    {
        return cameraviewcupcake.T;
    }

    static float a(CameraViewCupcake cameraviewcupcake, float f1)
    {
        cameraviewcupcake.T = f1;
        return f1;
    }

    private void a(android.hardware.Camera.Parameters parameters)
    {
        List list = parameters.getSupportedPreviewSizes();
        List list1 = parameters.getSupportedPictureSizes();
        if (list != null && list1 != null)
        {
            K = new ArrayList();
            for (int i1 = 0; i1 < list.size(); i1++)
            {
                parameters = (android.hardware.Camera.Size)list.get(i1);
                float f1 = (float)((android.hardware.Camera.Size) (parameters)).width / (float)((android.hardware.Camera.Size) (parameters)).height;
                for (int j1 = 0; j1 < list1.size(); j1++)
                {
                    parameters = (android.hardware.Camera.Size)list1.get(j1);
                    if (f1 == (float)((android.hardware.Camera.Size) (parameters)).width / (float)((android.hardware.Camera.Size) (parameters)).height)
                    {
                        new com.socialin.picsin.camera.view.a(this);
                    }
                }

            }

            break MISSING_BLOCK_LABEL_193;
        }
        parameters = parameters.flatten();
        parameters = (new StringBuilder("can't init camera sizes \n")).append(parameters).toString();
        ExceptionReportService.reportString(p, parameters, (new StringBuilder()).append(SocialinV3.getInstance().getUser().id).toString());
        return;
        parameters;
        ExceptionReportService.report(parameters);
        return;
    }

    private String aa()
    {
        if (c != null)
        {
            return c.getFocusMode();
        } else
        {
            return null;
        }
    }

    static float b(CameraViewCupcake cameraviewcupcake, float f1)
    {
        f1 = cameraviewcupcake.T * f1;
        cameraviewcupcake.T = f1;
        return f1;
    }

    private void b(boolean flag)
    {
        D = flag;
        Object obj = getContext();
        if (obj != null)
        {
            obj = (CameraMainActivity)obj;
            if (flag && ((CameraMainActivity) (obj)).m)
            {
                if (Integer.parseInt(android.os.Build.VERSION.SDK) >= 8 && com.socialin.camera.opengl.a.a(((Activity) (obj))))
                {
                    ((CameraMainActivity) (obj)).b(0x7f100223);
                }
                obj.m = false;
            }
        }
    }

    public final void A()
    {
        if (a == null || i) goto _L2; else goto _L1
_L1:
        String as[] = Z();
        if (as == null) goto _L4; else goto _L3
_L3:
        int i1;
        int j1;
        j1 = as.length;
        i1 = 0;
_L9:
        if (i1 >= j1) goto _L4; else goto _L5
_L5:
        String s1 = as[i1];
        if (!s1.equals("continuous-picture")) goto _L7; else goto _L6
_L6:
        setFocusMode(s1);
_L4:
        d();
        a.startPreview();
        b(true);
        y = false;
_L2:
        return;
_L7:
        i1++;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public final boolean B()
    {
        return y;
    }

    public final boolean C()
    {
        return D;
    }

    public final boolean D()
    {
        if (!r || y || e || f || i)
        {
            Log.e("ex", "#######################################");
            if (!r)
            {
                Log.e("ex", "!canTakePic");
            }
            if (y)
            {
                Log.e("ex", "isPicTaking");
            }
            if (e)
            {
                Log.e("ex", "inAuthoFocus");
            }
            if (f)
            {
                Log.e("ex", "takePhotoAfterAuthoFocus");
            }
            if (i)
            {
                Log.e("ex", "isReleased");
            }
            if (k)
            {
                Log.e("ex", "isColorSplashActive");
            }
            Log.e("ex", "#######################################");
        }
        return r && !y && !e && !f && !i;
    }

    public final int E()
    {
        return g;
    }

    public final int F()
    {
        if (c == null)
        {
            return -1;
        }
        String s1 = c.getFlashMode();
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        if (s1.equals("on"))
        {
            return 1;
        }
        if (s1.equalsIgnoreCase("off"))
        {
            return 0;
        }
        boolean flag = s1.equalsIgnoreCase("auto");
        if (flag)
        {
            return 2;
        }
        break MISSING_BLOCK_LABEL_70;
        Exception exception;
        exception;
        Log.e("CameraView", "exception when getting flash mode", exception);
        return -1;
    }

    public final String[] G()
    {
        List list = c.getSupportedColorEffects();
        if (list != null)
        {
            return (String[])list.toArray(new String[list.size()]);
        } else
        {
            return null;
        }
    }

    public final String H()
    {
        return c.getColorEffect();
    }

    public final String[] I()
    {
        List list = c.getSupportedSceneModes();
        if (list != null)
        {
            return (String[])list.toArray(new String[list.size()]);
        } else
        {
            return null;
        }
    }

    public final String J()
    {
        return c.getSceneMode();
    }

    public final String[] K()
    {
        List list = c.getSupportedWhiteBalance();
        if (list != null)
        {
            return (String[])list.toArray(new String[list.size()]);
        } else
        {
            return null;
        }
    }

    public final String L()
    {
        return c.getWhiteBalance();
    }

    protected final void M()
    {
        if (a != null && S())
        {
            if (S == null)
            {
                S = new ScaleGestureDetector(p, new com.socialin.picsin.camera.view.b(this, (byte)0));
            }
            if (U == null || q == null)
            {
                U = new HandlerThread("SMOOTH_ZOOM_THREAD");
                U.start();
                if (q != null)
                {
                    Looper looper = q.getLooper();
                    if (looper != null)
                    {
                        looper.quit();
                    }
                    q = null;
                }
                q = new Handler(U.getLooper(), this);
                T = T();
            }
        }
    }

    public final boolean N()
    {
        return k;
    }

    public final int O()
    {
        return c.getExposureCompensation() - c.getMinExposureCompensation();
    }

    public final int P()
    {
        return c.getMinExposureCompensation();
    }

    public final int Q()
    {
        return c.getMaxExposureCompensation();
    }

    public final boolean R()
    {
        return c.getMinExposureCompensation() != c.getMaxExposureCompensation();
    }

    public final boolean S()
    {
        return c == null || c.getMaxZoom() > 0;
    }

    public final int T()
    {
        if (c != null)
        {
            return c.getZoom();
        } else
        {
            return 1;
        }
    }

    public final int U()
    {
        if (c != null)
        {
            return c.getMaxZoom();
        } else
        {
            return 1;
        }
    }

    public final List V()
    {
        if (c != null)
        {
            return c.getZoomRatios();
        } else
        {
            return null;
        }
    }

    public final boolean W()
    {
        return O;
    }

    public final ScaleGestureDetector X()
    {
        return S;
    }

    protected final void a()
    {
        b = getHolder();
        b.setType(3);
        b.addCallback(this);
    }

    public final void a(android.hardware.Camera.PictureCallback picturecallback, android.hardware.Camera.PictureCallback picturecallback1)
    {
label0:
        {
label1:
            {
                ((AudioManager)getContext().getSystemService("audio")).setStreamMute(1, true);
                if (!i)
                {
                    if (!k)
                    {
                        break label0;
                    }
                    if (H == null || H.c != 21)
                    {
                        break label1;
                    }
                    if (G != null)
                    {
                        G.b();
                    }
                    a.setPreviewCallback(null);
                    a.takePicture(null, picturecallback, picturecallback1);
                    y = true;
                }
                return;
            }
            a.setPreviewCallback(null);
        }
        y = true;
        try
        {
            a.takePicture(null, picturecallback, picturecallback1);
            b(false);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (android.hardware.Camera.PictureCallback picturecallback) { }
        if (p != null)
        {
            Utils.b(p, 0x7f0805ca);
        }
        A();
    }

    public final void a(android.hardware.Camera.ShutterCallback shuttercallback, android.hardware.Camera.PictureCallback picturecallback)
    {
        boolean flag = true;
        if (e)
        {
            f = true;
        } else
        if (a != null && D && !i)
        {
            if (r && !y)
            {
                y = true;
                if (aa() == null || !aa().equals("continuous-picture"))
                {
                    flag = false;
                }
                if (!flag && z && System.currentTimeMillis() - A > 3000L)
                {
                    A = System.currentTimeMillis();
                    try
                    {
                        a.autoFocus(new android.hardware.Camera.AutoFocusCallback(shuttercallback, null, picturecallback) {

                            private android.hardware.Camera.PictureCallback a;
                            private android.hardware.Camera.PictureCallback b;
                            private CameraViewCupcake c;

                            public final void onAutoFocus(boolean flag1, Camera camera)
                            {
                                c.a(a, b);
                            }

            
            {
                c = CameraViewCupcake.this;
                a = null;
                b = picturecallback1;
                super();
            }
                        });
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (android.hardware.Camera.ShutterCallback shuttercallback)
                    {
                        a(((android.hardware.Camera.PictureCallback) (null)), picturecallback);
                    }
                    return;
                }
                if (!i)
                {
                    a(((android.hardware.Camera.PictureCallback) (null)), picturecallback);
                    return;
                }
            } else
            {
                com.socialin.android.d.b((new StringBuilder("right now camera can't take picture, cantakepicture: ")).append(r).append(" ispictaking: ").append(y).toString());
                return;
            }
        }
    }

    public final void a(CameraFocusRectView camerafocusrectview, com.socialin.picsin.camera.b b1)
    {
        while (aa() == null || aa().equals("continuous-picture") || !z || a == null || e || i || !D || !r || y) 
        {
            return;
        }
        camerafocusrectview.setLineColor(0xffff0000);
        camerafocusrectview.setVisibility(0);
        e = true;
        A = System.currentTimeMillis();
        try
        {
            a.autoFocus(new android.hardware.Camera.AutoFocusCallback(camerafocusrectview, b1) {

                final CameraFocusRectView a;
                final com.socialin.picsin.camera.b b;
                final CameraViewCupcake c;

                public final void onAutoFocus(boolean flag, Camera camera)
                {
                    a.setLineColor(0xff00ff00);
                    a.invalidate();
                    (new Handler()).postDelayed(new Runnable(this) {

                        private _cls2 a;

                        public final void run()
                        {
                            a.a.setVisibility(8);
                            a.c.e = false;
                            if (a.c.f)
                            {
                                a.b.a();
                                a.c.f = false;
                            }
                        }

            
            {
                a = _pcls2;
                super();
            }
                    }, 200L);
                }

            
            {
                c = CameraViewCupcake.this;
                a = camerafocusrectview;
                b = b1;
                super();
            }
            });
            return;
        }
        catch (RuntimeException runtimeexception)
        {
            camerafocusrectview.setLineColor(0xff00ff00);
        }
        camerafocusrectview.invalidate();
        (new Handler()).postDelayed(new Runnable(camerafocusrectview, b1) {

            private CameraFocusRectView a;
            private com.socialin.picsin.camera.b b;
            private CameraViewCupcake c;

            public final void run()
            {
                a.setVisibility(8);
                c.e = false;
                if (c.f)
                {
                    b.a();
                    c.f = false;
                }
            }

            
            {
                c = CameraViewCupcake.this;
                a = camerafocusrectview;
                b = b1;
                super();
            }
        }, 200L);
    }

    public final void a(boolean flag)
    {
        z = flag;
    }

    public final String b()
    {
        return c.flatten();
    }

    public final Camera c()
    {
        return a;
    }

    public final boolean d()
    {
        try
        {
            if (!y)
            {
                a.setParameters(c);
            }
        }
        catch (Exception exception)
        {
            Y();
            return false;
        }
        return true;
    }

    public final int e()
    {
        return s;
    }

    public final int f()
    {
        return t;
    }

    public final boolean g()
    {
        boolean flag = false;
        if (c.get("contrast") == null) goto _L2; else goto _L1
_L1:
        s = 0;
        if (c.get("contrast-min") == null) goto _L4; else goto _L3
_L3:
        s = c.getInt("contrast-min");
_L13:
        if (c.get("contrast-max") == null) goto _L6; else goto _L5
_L5:
        t = c.getInt("contrast-max");
_L10:
        if (s == t)
        {
            return false;
        }
          goto _L7
_L4:
        int i1;
        try
        {
            if (c.get("min-contrast") != null)
            {
                s = c.getInt("min-contrast");
            }
        }
        catch (Exception exception)
        {
            return false;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (c.get("max-contrast") == null) goto _L9; else goto _L8
_L8:
        t = c.getInt("max-contrast");
          goto _L10
_L9:
        if (t != 0x80000000) goto _L10; else goto _L11
_L11:
        t = c.getInt("contrast") * 2;
          goto _L10
_L7:
        if (s > t)
        {
            i1 = s;
            s = t;
            t = i1;
        }
        flag = true;
_L2:
        return flag;
        if (true) goto _L13; else goto _L12
_L12:
    }

    public final int h()
    {
        return c.getInt("contrast");
    }

    public boolean handleMessage(Message message)
    {
        if (p != null)
        {
            p.runOnUiThread(new Runnable() {

                private CameraViewCupcake a;

                public final void run()
                {
                    if (!a.D() || a.c == null || a.a == null) goto _L2; else goto _L1
_L1:
                    int i1;
                    int j1;
                    i1 = (int)com.socialin.picsin.camera.view.CameraViewCupcake.a(a);
                    j1 = a.U();
                    if (i1 >= 0) goto _L4; else goto _L3
_L3:
                    i1 = 0;
_L6:
                    a.setZoom(i1);
                    a.d();
                    if (a.p != null)
                    {
                        CameraMainActivity cameramainactivity = (CameraMainActivity)a.p;
                        List list = cameramainactivity.a.V();
                        if (list != null && i1 >= 0 && i1 < list.size())
                        {
                            ((CustomVerticalSeekBar)cameramainactivity.findViewById(0x7f1001ff)).setProgressAndThumb(i1);
                            ((TextView)cameramainactivity.findViewById(0x7f1001fe)).setText((new StringBuilder()).append((float)(((Integer)list.get(i1)).intValue() / 10) / 10F).append("X").toString());
                        }
                    }
_L2:
                    return;
_L4:
                    if (i1 > j1)
                    {
                        i1 = j1;
                    }
                    if (true) goto _L6; else goto _L5
_L5:
                }

            
            {
                a = CameraViewCupcake.this;
                super();
            }
            });
        }
        return false;
    }

    public final int i()
    {
        return w;
    }

    public final int j()
    {
        return x;
    }

    public final boolean k()
    {
        boolean flag = false;
        if (c.get("sharpness") == null) goto _L2; else goto _L1
_L1:
        w = 0;
        if (c.get("sharpness-min") == null) goto _L4; else goto _L3
_L3:
        w = c.getInt("sharpness-min");
_L13:
        if (c.get("sharpness-max") == null) goto _L6; else goto _L5
_L5:
        x = c.getInt("sharpness-max");
_L10:
        if (w == x)
        {
            return false;
        }
          goto _L7
_L4:
        int i1;
        try
        {
            if (c.get("min-sharpness") != null)
            {
                w = c.getInt("min-sharpness");
            }
        }
        catch (Exception exception)
        {
            return false;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (c.get("max-sharpness") == null) goto _L9; else goto _L8
_L8:
        x = c.getInt("max-sharpness");
          goto _L10
_L9:
        if (x != 0x80000000) goto _L10; else goto _L11
_L11:
        x = c.getInt("sharpness") * 2;
          goto _L10
_L7:
        if (w > x)
        {
            i1 = w;
            w = x;
            x = i1;
        }
        flag = true;
_L2:
        return flag;
        if (true) goto _L13; else goto _L12
_L12:
    }

    public final int l()
    {
        return c.getInt("sharpness");
    }

    public final int m()
    {
        return u;
    }

    public final int n()
    {
        return v;
    }

    public final boolean o()
    {
        boolean flag = false;
        if (c.get("saturation") == null) goto _L2; else goto _L1
_L1:
        u = 0;
        if (c.get("saturation-min") == null) goto _L4; else goto _L3
_L3:
        u = c.getInt("saturation-min");
_L13:
        if (c.get("saturation-max") == null) goto _L6; else goto _L5
_L5:
        v = c.getInt("saturation-max");
_L10:
        if (u == v)
        {
            return false;
        }
          goto _L7
_L4:
        if (c.get("min-saturation") != null)
        {
            u = c.getInt("min-saturation");
            continue; /* Loop/switch isn't completed */
        }
        int i1;
        try
        {
            u = 0;
        }
        catch (Exception exception)
        {
            return false;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (c.get("max-saturation") == null) goto _L9; else goto _L8
_L8:
        v = c.getInt("max-saturation");
          goto _L10
_L9:
        if (v != 0x80000000) goto _L10; else goto _L11
_L11:
        v = c.getInt("saturation") * 2;
          goto _L10
_L7:
        if (u > v)
        {
            i1 = u;
            u = v;
            v = i1;
        }
        flag = true;
_L2:
        return flag;
        if (true) goto _L13; else goto _L12
_L12:
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (S != null)
        {
            S.onTouchEvent(motionevent);
        }
        return super.onTouchEvent(motionevent);
    }

    public void onZoomChange(int i1, boolean flag, Camera camera)
    {
    }

    public final int p()
    {
        return c.getInt("saturation");
    }

    public final String[] q()
    {
        int i1 = 0;
        String as[];
label0:
        do
        {
label1:
            {
                if (i1 < 4)
                {
                    String s1 = (new String[] {
                        "iso", "picture-iso", "mot-picture-iso", "nv-picture-iso"
                    })[i1];
                    if (c.get(s1) == null)
                    {
                        break label1;
                    }
                    E = s1;
                }
                i1 = 0;
                as = null;
                for (; i1 < 4; i1++)
                {
                    String s2 = (new String[] {
                        "iso-values", "picture-iso-values", "mot-picture-iso-values", "nv-picture-iso-values"
                    })[i1];
                    if (c.get(s2) != null)
                    {
                        as = c.get(s2).split(",");
                    }
                }

                break label0;
            }
            i1++;
        } while (true);
        if (E == null)
        {
            as = null;
        }
        String as1[] = as;
        if (as != null)
        {
            as1 = as;
            if (as.length == 1)
            {
                as1 = null;
            }
        }
        return as1;
    }

    public final String r()
    {
        return c.get(E);
    }

    public final boolean s()
    {
        if (c == null) goto _L2; else goto _L1
_L1:
        List list = c.getSupportedFlashModes();
        if (list == null || list.size() == 1) goto _L2; else goto _L3
_L3:
        int ai[];
        ai = new int[3];
        ai;
        ai[0] = -1;
        ai[1] = -1;
        ai[2] = -1;
        int i1 = 0;
        while (i1 < list.size()) 
        {
            if (((String)list.get(i1)).equalsIgnoreCase("on"))
            {
                ai[0] = 1;
            } else
            if (((String)list.get(i1)).equalsIgnoreCase("off"))
            {
                ai[1] = 0;
            } else
            if (((String)list.get(i1)).equalsIgnoreCase("auto"))
            {
                ai[2] = 2;
            }
            i1++;
        }
_L12:
        if (ai != null) goto _L5; else goto _L4
_L4:
        return false;
_L2:
        ai = null;
        continue; /* Loop/switch isn't completed */
_L5:
        int j1;
        boolean flag;
        boolean flag1;
        boolean flag2;
        int k1;
        k1 = ai.length;
        j1 = 0;
        flag1 = false;
        flag2 = false;
        flag = false;
_L7:
        boolean flag3;
        boolean flag4;
        int l1;
        if (j1 >= k1)
        {
            continue; /* Loop/switch isn't completed */
        }
        l1 = ai[j1];
        if (l1 != 2)
        {
            break; /* Loop/switch isn't completed */
        }
        flag3 = true;
        flag4 = flag;
_L8:
        j1++;
        flag1 = flag3;
        flag = flag4;
        if (true) goto _L7; else goto _L6
_L6:
        if (l1 == 1)
        {
            flag4 = true;
            flag3 = flag1;
        } else
        {
            flag3 = flag1;
            flag4 = flag;
            if (l1 == 0)
            {
                flag2 = true;
                flag3 = flag1;
                flag4 = flag;
            }
        }
          goto _L8
        if (true) goto _L7; else goto _L9
_L9:
        if (!flag || !flag2 || !flag1) goto _L4; else goto _L10
_L10:
        return true;
        if (true) goto _L12; else goto _L11
_L11:
    }

    public void setBrightness(int i1)
    {
        c.setExposureCompensation(c.getMinExposureCompensation() + i1);
    }

    public void setCameraIndex(int i1)
    {
    }

    public void setCanTakePicture(boolean flag)
    {
        r = flag;
    }

    public void setContrast(int i1)
    {
        c.set("contrast", i1);
    }

    public void setDefaultProperties()
    {
        if (N != null)
        {
            c.unflatten(N);
            if (j)
            {
                myobfuscated.de.a.a(c);
            }
            a.setParameters(c);
        }
    }

    public void setEffect(String s1)
    {
        c.setColorEffect(s1);
    }

    public void setEffectOnSurfaceChanged(boolean flag, int i1, int j1, int k1)
    {
        O = flag;
        P = i1;
        Q = j1;
        R = k1;
    }

    public void setEffectsController(a a1)
    {
        H = a1;
    }

    public void setFirstBestSize(Point point)
    {
        o = point;
    }

    public void setFlashMode(int i1)
    {
        if (c != null)
        {
            if (i1 == 1)
            {
                c.setFlashMode("on");
                return;
            }
            if (i1 == 0)
            {
                c.setFlashMode("off");
                return;
            }
            if (i1 == 2)
            {
                c.setFlashMode("auto");
                return;
            }
        }
    }

    public void setFocusMode(String s1)
    {
        c.setFocusMode(s1);
    }

    public void setImageSize(int i1, int j1)
    {
    }

    public void setIso(String s1)
    {
        c.set(E, s1);
    }

    public void setOrientation(int i1)
    {
    }

    public void setPictureSize(int i1, int j1)
    {
        c.setPictureSize(i1, j1);
    }

    public void setPictureTaking(boolean flag)
    {
        y = flag;
    }

    public void setPlayShutter(boolean flag)
    {
        F = flag;
    }

    public void setProperties(String s1)
    {
        c.unflatten(s1);
        if (j)
        {
            myobfuscated.de.a.a(c);
        }
        a.setParameters(c);
    }

    public void setRotation(int i1)
    {
        c.setRotation(i1);
    }

    public void setSaturation(int i1)
    {
        c.set("saturation", i1);
    }

    public void setSceneMode(String s1)
    {
        c.setSceneMode(s1);
    }

    public void setSharpness(int i1)
    {
        c.set("sharpness", i1);
    }

    public void setSurfaceChangeCallback(android.view.SurfaceHolder.Callback callback)
    {
        d = callback;
    }

    public void setWhiteBalance(String s1)
    {
        c.setWhiteBalance(s1);
    }

    public void setZoom(int i1)
    {
        if (c != null)
        {
            c.setZoom(i1);
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceholder, int i1, int j1, int k1)
    {
        android.hardware.Camera.Size size = null;
        if (!i) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int l1;
        long l2 = System.currentTimeMillis();
        float f1;
        float f2;
        String as[];
        Object obj;
        Point point;
        int i2;
        try
        {
            if (D)
            {
                a.stopPreview();
                b(false);
            }
        }
        catch (Exception exception) { }
        if (a == null)
        {
            d.surfaceChanged(null, -1, -1, -1);
            return;
        }
        if (c == null)
        {
            c = a.getParameters();
            c.setPictureFormat(256);
            if (j)
            {
                myobfuscated.de.a.a(c);
            }
        }
        as = Z();
        if (as == null) goto _L4; else goto _L3
_L3:
        l1 = 0;
_L16:
        if (l1 >= as.length) goto _L4; else goto _L5
_L5:
        if (!as[l1].equals("continuous-picture")) goto _L7; else goto _L6
_L6:
        setFocusMode(as[l1]);
_L4:
        C = c.flatten();
        if (B == null)
        {
            B = C.replace(" ", "");
            c.unflatten(B);
            if (j)
            {
                myobfuscated.de.a.a(c);
            }
        }
        try
        {
            a.setParameters(c);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Y();
            try
            {
                B = c.flatten();
                c.unflatten(B);
                if (j)
                {
                    myobfuscated.de.a.a(c);
                }
                a.setParameters(c);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                Y();
            }
        }
        try
        {
            if (l)
            {
                a.startPreview();
                b(true);
                i = false;
            }
        }
        // Misplaced declaration of an exception variable
        catch (SurfaceHolder surfaceholder)
        {
            b(false);
            d.surfaceChanged(null, -1, -1, -1);
            return;
        }
        R();
        g();
        o();
        k();
        d.surfaceChanged(surfaceholder, i1, j1, k1);
        (new StringBuilder("CameraViewCupcake surfaceChanged time = ")).append(System.currentTimeMillis() - l2);
        y = false;
        if (a != null && K == null)
        {
            a(a.getParameters());
        }
        if (I == null)
        {
            I = new Point(j1, k1);
            (new StringBuilder("firstSize width:")).append(j1).append(" height:").append(k1);
        }
        if (c == null) goto _L9; else goto _L8
_L8:
        if (I == null)
        {
            break MISSING_BLOCK_LABEL_1602;
        }
        l1 = I.x;
        i1 = I.y;
_L19:
        surfaceholder = PicsartContext.c();
        i2 = PicsartContext.a.getOptimalImageSize();
        obj = PicsartContext.d();
        point = PicsartContext.e();
        if (k) goto _L11; else goto _L10
_L10:
        if (L == null)
        {
            L = myobfuscated.f.m.a(c, ((Point) (surfaceholder)).x, ((Point) (surfaceholder)).y, I.x, I.y, i2, ((Point) (obj)), point);
        }
        if (L == null) goto _L13; else goto _L12
_L12:
        size = L.a;
        surfaceholder = L.b;
_L18:
        if (size == null)
        {
            break MISSING_BLOCK_LABEL_521;
        }
        c.setPreviewSize(size.width, size.height);
        if (surfaceholder == null)
        {
            break MISSING_BLOCK_LABEL_540;
        }
        c.setPictureSize(((android.hardware.Camera.Size) (surfaceholder)).width, ((android.hardware.Camera.Size) (surfaceholder)).height);
        Log.e("ex1", "***************************");
        if (size == null)
        {
            break MISSING_BLOCK_LABEL_597;
        }
        Log.e("ex1", (new StringBuilder("previewSize = ")).append(size.width).append(" ").append(size.height).toString());
        if (surfaceholder == null)
        {
            break MISSING_BLOCK_LABEL_641;
        }
        Log.e("ex1", (new StringBuilder("pictureSize = ")).append(((android.hardware.Camera.Size) (surfaceholder)).width).append(" ").append(((android.hardware.Camera.Size) (surfaceholder)).height).toString());
        Log.e("ex1", "***************************");
        d();
        if (N == null)
        {
            N = c.flatten().replace(" ", "");
        }
        if (!k) goto _L15; else goto _L14
_L14:
        J = true;
        e = false;
        f = false;
_L9:
        if (J)
        {
            if (k && a != null && p.findViewById(0x7f10022b).getVisibility() != 0)
            {
                try
                {
                    b(false);
                    a.stopPreview();
                }
                // Misplaced declaration of an exception variable
                catch (SurfaceHolder surfaceholder) { }
                if (!G.a(a) && a != null && a.getParameters() != null)
                {
                    AnalyticUtils.getInstance(p).trackLocalAction((new StringBuilder("start:camera surfaceChange preview format not supported")).append(a.getParameters().getPreviewFormat()).toString());
                }
                try
                {
                    a.startPreview();
                    b(true);
                    ((CameraMainActivity)p).c(true);
                }
                // Misplaced declaration of an exception variable
                catch (SurfaceHolder surfaceholder) { }
            }
            M();
            return;
        }
          goto _L1
_L7:
        l1++;
          goto _L16
_L11:
        if (M == null)
        {
            M = myobfuscated.f.m.a(c, ((Point) (surfaceholder)).x, ((Point) (surfaceholder)).y, I.x / 2, I.y / 2, i2, ((Point) (obj)), point);
        }
        if (M == null) goto _L13; else goto _L17
_L17:
        size = M.a;
        surfaceholder = M.b;
          goto _L18
_L15:
        if (size == null)
        {
            break MISSING_BLOCK_LABEL_1450;
        }
        if (o != null)
        {
            break MISSING_BLOCK_LABEL_1094;
        }
        f1 = (float)l1 / (float)size.width;
        f2 = (float)i1 / (float)size.height;
        if (f1 >= f2)
        {
            f1 = f2;
        }
        o = new Point((int)((float)size.width * f1), (int)(f1 * (float)size.height));
        Log.e("ex1", (new StringBuilder("beforeWidth: ")).append(j1).append(" beforeHeight: ").append(k1).toString());
        Log.e("ex1", (new StringBuilder("firstBestSize w : ")).append(o.x).append(" firstBestSize h : ").append(o.y).toString());
        Log.e("ex1", (new StringBuilder("delta = 2")).toString());
        surfaceholder = new android.widget.RelativeLayout.LayoutParams(o.x - 2, o.y - 2);
        surfaceholder.addRule(13);
        setLayoutParams(surfaceholder);
        (new StringBuilder("displayWidth: ")).append(l1).append(" displayHeight: ").append(i1);
        if (j1 == o.x - 2 && k1 == o.y - 2)
        {
            J = true;
            e = false;
            f = false;
            if (a != null && !D)
            {
                a.startPreview();
                b(true);
                i = false;
            }
            if (O)
            {
                O = false;
                surfaceholder = (CameraMainActivity)getContext();
                i1 = P;
                j1 = Q;
                k1 = R;
                if (((CameraMainActivity) (surfaceholder)).f != null && ((CameraMainActivity) (surfaceholder)).n != null && ((CameraMainActivity) (surfaceholder)).n.getView() != null)
                {
                    ((CameraMainActivity) (surfaceholder)).n.a(i1, ((CameraMainActivity) (surfaceholder)).n.getView());
                    (new Handler()).postDelayed(new com.socialin.picsin.camera.CameraMainActivity._cls28(surfaceholder, i1, j1, k1), 700L);
                }
            }
        }
          goto _L9
label0:
        {
            c.setPreviewSize(I.x, I.y);
            d();
            if (j1 != I.x || k1 != I.y)
            {
                break label0;
            }
            J = true;
            e = false;
            f = false;
            if (a != null && !D)
            {
                a.startPreview();
                b(true);
                i = false;
            }
        }
          goto _L9
        try
        {
            surfaceholder = new android.widget.RelativeLayout.LayoutParams(I.x, I.y);
            surfaceholder.addRule(13);
            setLayoutParams(surfaceholder);
        }
        // Misplaced declaration of an exception variable
        catch (SurfaceHolder surfaceholder)
        {
            Y();
        }
          goto _L9
_L13:
        surfaceholder = null;
          goto _L18
        i1 = k1;
        l1 = j1;
          goto _L19
    }

    public void surfaceCreated(SurfaceHolder surfaceholder)
    {
        if (a == null)
        {
            try
            {
                a = Camera.open();
                a.setPreviewDisplay(b);
                i = false;
            }
            // Misplaced declaration of an exception variable
            catch (SurfaceHolder surfaceholder)
            {
                surfaceholder.printStackTrace();
                d.surfaceCreated(null);
                return;
            }
        } else
        {
            try
            {
                a.setPreviewDisplay(null);
                a();
                a.setPreviewDisplay(b);
            }
            catch (IOException ioexception)
            {
                ioexception.printStackTrace();
            }
        }
        d.surfaceCreated(surfaceholder);
        J = false;
        l = false;
        T = 0.0F;
    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder)
    {
        if (G != null)
        {
            G.b();
            if (!i && a != null)
            {
                a.setPreviewCallback(null);
            }
        }
        if (a == null)
        {
            d.surfaceDestroyed(null);
        } else
        {
            try
            {
                a.stopPreview();
                b(false);
                a.release();
                a = null;
            }
            catch (Exception exception) { }
            i = true;
            d.surfaceDestroyed(surfaceholder);
            if (q != null)
            {
                surfaceholder = q.getLooper();
                if (surfaceholder != null)
                {
                    surfaceholder.quit();
                }
                q = null;
                U = null;
                return;
            }
        }
    }

    public final boolean t()
    {
        return y;
    }

    public int u()
    {
        return 1;
    }

    public int v()
    {
        return 0;
    }

    public final boolean w()
    {
        return F;
    }

    public final int x()
    {
        return m;
    }

    public final void y()
    {
        if (a != null && !i)
        {
            i = true;
            b(false);
            a.setPreviewCallback(null);
            a.release();
        }
    }

    public boolean z()
    {
        return false;
    }

}
