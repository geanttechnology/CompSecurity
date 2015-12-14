// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.app.Activity;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.AsyncTask;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.cyberlink.clgpuimage.CLMakeupLiveFilter;
import com.cyberlink.clgpuimage.GPUImage;
import com.cyberlink.clgpuimage.Rotation;
import com.cyberlink.clgpuimage.o;
import com.cyberlink.youcammakeup.activity.CameraActivity;
import com.cyberlink.youcammakeup.clflurry.YMKApplyEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.clflurry.p;
import com.cyberlink.youcammakeup.jniproxy.ai;
import com.cyberlink.youcammakeup.jniproxy.bn;
import com.cyberlink.youcammakeup.kernelctrl.BeautifierManager;
import com.cyberlink.youcammakeup.kernelctrl.LiveDemoConfigHelper;
import com.cyberlink.youcammakeup.kernelctrl.ar;
import com.cyberlink.youcammakeup.kernelctrl.b.d;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.r;
import com.cyberlink.youcammakeup.kernelctrl.gpuimage.camera.GPUImageCameraView;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ImageBufferWrapper;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.aa;
import com.cyberlink.youcammakeup.utility.at;
import com.cyberlink.youcammakeup.utility.ax;
import com.cyberlink.youcammakeup.venus.CommonShare;
import com.cyberlink.youcammakeup.venus.FaceAlignData;
import com.cyberlink.youcammakeup.venus.FaceAlignDataUtils;
import com.cyberlink.youcammakeup.venus.MutableInteger;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import com.pf.common.utility.m;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            u, v, o, z, 
//            aa, ad, ac

public class y
    implements SensorEventListener
{

    public static Bitmap a = null;
    private Object A;
    private Object B;
    private int C;
    private android.hardware.Camera.Size D;
    private List E;
    private boolean F;
    private AtomicBoolean G;
    private float H;
    private int I;
    private final AtomicBoolean J = new AtomicBoolean(true);
    private boolean K;
    private boolean L;
    private Rect M;
    private ac N;
    protected final String b = (new StringBuilder()).append(CommonShare.openTempFolder()).append("/FaceBeautify").toString();
    protected final String c;
    com.cyberlink.clgpuimage.CLMakeupLiveFilter.CaptureFrameType d;
    private final View e;
    private Camera f;
    private int g;
    private Activity h;
    private GPUImageCameraView i;
    private BeautifierManager j;
    private GPUImage k;
    private Object l;
    private CLMakeupLiveFilter m;
    private com.cyberlink.clgpuimage.CLMakeupLiveEyeFilter.LiveEyeMakeupMetadata n[];
    private com.cyberlink.clgpuimage.CLMakeupLiveLipStickFilter.LipstickData o;
    private com.cyberlink.clgpuimage.CLMakeupLiveBlushFilter.LiveBlushMakeupdata p;
    private com.cyberlink.clgpuimage.CLMakeupLiveSmoothFilter.LiveSmoothMetadata q;
    private com.cyberlink.clgpuimage.CLMakeupLiveFilter.LiveFrameInformation r;
    private boolean s;
    private boolean t;
    private Rect u;
    private SurfaceTexture v;
    private com.cyberlink.youcammakeup.camera.aa w;
    private SensorManager x;
    private Sensor y;
    private float z[];

    public y(Activity activity, GPUImageCameraView gpuimagecameraview, View view)
    {
        f = null;
        g = 0;
        h = null;
        i = null;
        j = null;
        k = null;
        l = null;
        m = null;
        n = null;
        o = null;
        p = null;
        q = null;
        r = null;
        s = true;
        t = true;
        u = null;
        v = null;
        w = null;
        x = null;
        y = null;
        z = null;
        A = null;
        B = null;
        C = 0;
        D = null;
        E = null;
        c = (new StringBuilder()).append(b).append("/composite").toString();
        F = false;
        G = new AtomicBoolean(false);
        H = 0.0F;
        d = com.cyberlink.clgpuimage.CLMakeupLiveFilter.CaptureFrameType.a;
        I = 1;
        K = false;
        L = false;
        M = new Rect();
        N = null;
        h = activity;
        i = gpuimagecameraview;
        e = view;
        l = new Object();
    }

    private int a(float af[])
    {
        while (y == null || (double)Math.abs(af[0]) < 0.01D && (double)Math.abs(af[1]) < 0.01D && (double)Math.abs(af[2]) < 0.01D || Math.abs(af[2]) > 9.2F) 
        {
            return 90;
        }
        if (Math.abs(af[0]) > Math.abs(af[1]) + 3F)
        {
            if (af[0] > 0.0F)
            {
                return (C + 270) % 360;
            } else
            {
                return (C + 90) % 360;
            }
        }
        if (af[1] > 0.0F)
        {
            return C;
        } else
        {
            return (C + 180) % 360;
        }
    }

    private android.hardware.Camera.Size a(List list, int i1, int j1)
    {
        return com.cyberlink.youcammakeup.camera.u.a(list, i1, j1, H).a;
    }

    static AtomicBoolean a(y y1)
    {
        return y1.J;
    }

    private void a(boolean flag, boolean flag1)
    {
        s = flag;
        if (s && (t || flag1))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        synchronized (j)
        {
            j.a(flag, 70);
        }
        m.a(com.cyberlink.clgpuimage.CLMakeupLiveFilter.MakeupLiveFeatures.d, flag);
        return;
        exception;
        beautifiermanager;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static boolean a(y y1, boolean flag)
    {
        y1.K = flag;
        return flag;
    }

    static android.hardware.Camera.Size b(y y1)
    {
        return y1.D;
    }

    static boolean b(y y1, boolean flag)
    {
        y1.F = flag;
        return flag;
    }

    static com.cyberlink.youcammakeup.camera.aa c(y y1)
    {
        return y1.w;
    }

    static AtomicBoolean d(y y1)
    {
        return y1.G;
    }

    static CLMakeupLiveFilter e(y y1)
    {
        return y1.m;
    }

    static BeautifierManager f(y y1)
    {
        return y1.j;
    }

    static ac g(y y1)
    {
        return y1.N;
    }

    static void h(y y1)
    {
        y1.m();
    }

    private void m()
    {
        String s1 = com.cyberlink.youcammakeup.clflurry.p.f();
        if (s1 != null && !s1.isEmpty())
        {
            p p1 = new p(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.a);
            p1.f(s1);
            com.cyberlink.youcammakeup.clflurry.b.a(p1.e());
            com.cyberlink.youcammakeup.clflurry.p.l("");
        }
        BeautyMode abeautymode[] = BeautyMode.values();
        int l1 = abeautymode.length;
        int i1 = 0;
        while (i1 < l1) 
        {
            Object obj = abeautymode[i1];
            if (com.cyberlink.youcammakeup.widgetpool.panel.c.p.a().a(((BeautyMode) (obj))) != null)
            {
                if (obj == BeautyMode.n)
                {
                    r r1 = com.cyberlink.youcammakeup.widgetpool.panel.c.p.f();
                    int j1 = 0;
                    String s2 = "";
                    for (; j1 < r1.f().size(); j1++)
                    {
                        s2 = YMKApplyEvent.a(new String[] {
                            s2, YMKApplyEvent.a(((at)r1.f().get(j1)).j())
                        });
                    }

                    Object obj2;
                    if (MotionControlHelper.e().a(r1))
                    {
                        int k1 = 0;
                        obj = null;
                        do
                        {
                            obj2 = obj;
                            if (k1 >= r1.f().size())
                            {
                                break;
                            }
                            if (r1.f().get(k1) == null)
                            {
                                obj2 = null;
                            } else
                            {
                                obj2 = ((at)r1.f().get(k1)).i();
                            }
                            obj = YMKApplyEvent.a(new String[] {
                                obj, YMKApplyEvent.b(new String[] {
                                    obj2
                                })
                            });
                            k1++;
                        } while (true);
                    } else
                    {
                        obj2 = null;
                    }
                    obj = new p(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.l);
                    ((p) (obj)).e(r1.c());
                    ((p) (obj)).f(r1.b());
                    ((p) (obj)).h(s2);
                    ((p) (obj)).i(((String) (obj2)));
                    com.cyberlink.youcammakeup.clflurry.b.a(((p) (obj)).e());
                } else
                if (obj == BeautyMode.l)
                {
                    Object obj3 = com.cyberlink.youcammakeup.widgetpool.panel.c.p.g();
                    obj = ((r) (obj3)).e().i();
                    String s3 = ((r) (obj3)).b();
                    float f1 = ((r) (obj3)).g();
                    obj3 = new p(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.j);
                    ((p) (obj3)).d(YMKApplyEvent.b(new String[] {
                        obj
                    }));
                    ((p) (obj3)).f(s3);
                    ((p) (obj3)).g(String.valueOf(f1));
                    com.cyberlink.youcammakeup.clflurry.b.a(((p) (obj3)).e());
                } else
                if (obj == BeautyMode.m)
                {
                    Object obj4 = com.cyberlink.youcammakeup.widgetpool.panel.c.p.h();
                    obj = ((r) (obj4)).e().i();
                    String s4 = ((r) (obj4)).b();
                    float f2 = ((r) (obj4)).g();
                    obj4 = new p(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.k);
                    ((p) (obj4)).d(YMKApplyEvent.b(new String[] {
                        obj
                    }));
                    ((p) (obj4)).f(s4);
                    ((p) (obj4)).g(String.valueOf(f2));
                    com.cyberlink.youcammakeup.clflurry.b.a(((p) (obj4)).e());
                } else
                if (obj == BeautyMode.a)
                {
                    Object obj5 = com.cyberlink.youcammakeup.widgetpool.panel.c.p.i();
                    obj = ((r) (obj5)).e().i();
                    String s5 = ((r) (obj5)).b();
                    float f3 = ((r) (obj5)).g();
                    obj5 = new p(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.d);
                    ((p) (obj5)).d(YMKApplyEvent.b(new String[] {
                        obj
                    }));
                    ((p) (obj5)).f(s5);
                    ((p) (obj5)).g(String.valueOf(f3));
                    com.cyberlink.youcammakeup.clflurry.b.a(((p) (obj5)).e());
                } else
                if (obj == BeautyMode.v)
                {
                    Object obj1 = com.cyberlink.youcammakeup.widgetpool.panel.c.p.j();
                    String s6 = ((r) (obj1)).e().i();
                    String s7 = ((r) (obj1)).b();
                    float f4 = ((r) (obj1)).g();
                    obj1 = PanelDataCenter.a().p(s7);
                    p p2;
                    if (obj1 != null && ((ax) (obj1)).h() != null)
                    {
                        obj1 = YMKApplyEvent.a(((ax) (obj1)).h().b());
                    } else
                    {
                        obj1 = null;
                    }
                    p2 = new p(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.t);
                    p2.d(YMKApplyEvent.b(new String[] {
                        s6
                    }));
                    p2.f(s7);
                    p2.h(((String) (obj1)));
                    p2.g(String.valueOf(f4));
                    com.cyberlink.youcammakeup.clflurry.b.a(p2.e());
                }
            }
            i1++;
        }
    }

    public Bitmap a(String s1)
    {
        AssetManager assetmanager = h.getAssets();
        Object obj = null;
        try
        {
            s1 = assetmanager.open(s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            s1.printStackTrace();
            s1 = obj;
        }
        return BitmapFactory.decodeStream(s1);
    }

    public void a(float f1)
    {
        H = f1;
    }

    public void a(Rect rect)
    {
        if (C == 90 || C == 270)
        {
            rect.left = (rect.left * 2000) / D.height - 1000;
            rect.right = (rect.right * 2000) / D.height - 1000;
            rect.top = (rect.top * 2000) / D.width - 1000;
            rect.bottom = (rect.bottom * 2000) / D.width - 1000;
        } else
        {
            rect.left = (rect.left * 2000) / D.width - 1000;
            rect.right = (rect.right * 2000) / D.width - 1000;
            rect.top = (rect.top * 2000) / D.height - 1000;
            rect.bottom = (rect.bottom * 2000) / D.height - 1000;
        }
        if (rect.left < -1000)
        {
            rect.left = -1000;
        }
        if (rect.left > 1000)
        {
            rect.left = 1000;
        }
        if (rect.right < -1000)
        {
            rect.right = -1000;
        }
        if (rect.right > 1000)
        {
            rect.right = 1000;
        }
        if (rect.top < -1000)
        {
            rect.top = -1000;
        }
        if (rect.top > 1000)
        {
            rect.top = 1000;
        }
        if (rect.bottom < -1000)
        {
            rect.bottom = -1000;
        }
        if (rect.bottom > 1000)
        {
            rect.bottom = 1000;
        }
        if (rect.left < rect.right && rect.top < rect.bottom)
        {
            int i1 = (rect.right + rect.left) / 2;
            int j1 = (rect.bottom + rect.top) / 2;
            M.left = i1 - 175;
            M.right = i1 + 175;
            M.top = j1 - 175;
            M.bottom = j1 + 175;
            rect = new ArrayList();
            rect.add(new android.hardware.Camera.Area(M, 1000));
            android.hardware.Camera.Parameters parameters = f.getParameters();
            if (parameters.getMaxNumMeteringAreas() > 0)
            {
                parameters.setMeteringAreas(null);
            }
            if (parameters.getMaxNumFocusAreas() > 0)
            {
                parameters.setFocusAreas(rect);
            }
            f.setParameters(parameters);
        }
    }

    public void a(Camera camera, int i1)
    {
        f = camera;
        g = i1;
        if (camera != null)
        {
            L = com.cyberlink.youcammakeup.camera.o.a(camera);
        }
        d = com.cyberlink.clgpuimage.CLMakeupLiveFilter.CaptureFrameType.a;
        v = new SurfaceTexture(10);
        camera.setPreviewTexture(v);
        camera.setPreviewCallback(new android.hardware.Camera.PreviewCallback() {

            final y a;

            public void onPreviewFrame(byte abyte0[], Camera camera1)
            {
                y.a(a).set(false);
                y.c(a).a(abyte0, com.cyberlink.youcammakeup.camera.y.b(a).width, com.cyberlink.youcammakeup.camera.y.b(a).height);
            }

            
            {
                a = y.this;
                super();
            }
        });
    }

    public void a(z z1, boolean flag, boolean flag1)
    {
        boolean flag2;
        com.pf.common.utility.m.b("PICTURE_TAKEN", (new StringBuilder()).append("inside capture image with isCameraFacingBack: ").append(flag).append(", isPhotoFlipOn: ").append(flag1).toString());
        if (m == null)
        {
            if (z1 != null)
            {
                z1.a();
            }
            return;
        }
        flag2 = t;
        o ao[] = ((o []) (l));
        ao;
        JVM INSTR monitorenter ;
        d = com.cyberlink.clgpuimage.CLMakeupLiveFilter.CaptureFrameType.d;
        if (flag2)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        b(true);
        I = 1;
        ao;
        JVM INSTR monitorexit ;
        ao = m.b(com.cyberlink.clgpuimage.CLMakeupLiveFilter.CaptureFrameType.d);
        if (z1 != null)
        {
            z1.b();
        }
        if (!flag2)
        {
            b(flag2);
        }
        com.pf.common.utility.m.b("CaptureImage", "AsyncTask");
        (new AsyncTask(flag, flag1, ao, z1) {

            final boolean a;
            final boolean b;
            final o c[];
            final z d;
            final y e;

            protected transient Boolean a(Void avoid[])
            {
                com.pf.common.utility.m.b("PICTURE_TAKEN", "start createBitmap on background");
                com.pf.common.utility.m.b("CaptureImage", "createBitmap");
                Object obj = new MutableInteger();
                avoid = new ArrayList();
                boolean flag3;
                if (!a && !b)
                {
                    flag3 = true;
                } else
                {
                    flag3 = false;
                }
                if (flag3)
                {
                    aa.a(c[0].c, c[0].a, c[0].b, android.graphics.Bitmap.Config.ARGB_8888, 0, c[0].a, 0, 0);
                    aa.a(c[1].c, c[1].a, c[1].b, android.graphics.Bitmap.Config.ARGB_8888, 0, c[1].a, 0, 0);
                }
                if (c[0].d != null && c[0].d.size() > 0)
                {
                    com.pf.common.utility.m.b("CaptureImage", "AnalyzeLiveImage");
                    y.f(e).a(((MutableInteger) (obj)), c[0].d, c[0].a, c[0].b, c[0].a * 4, c[0].c, c[0].e, c[0].f, flag3);
                    com.pf.common.utility.m.b("CaptureImage", "FaceData");
                    Object obj2 = new ArrayList();
                    if (((MutableInteger) (obj)).value > 0)
                    {
                        y.f(e).a(((ArrayList) (obj2)), ((MutableInteger) (obj)).value);
                        Object obj1 = (Rect)((ArrayList) (obj2)).get(0);
                        com.pf.common.utility.m.b("FaceRect", ((Rect) (obj1)).toShortString());
                        obj = new ai();
                        ((ai) (obj)).a(((Rect) (obj1)).left);
                        ((ai) (obj)).b(((Rect) (obj1)).top);
                        ((ai) (obj)).c(((Rect) (obj1)).right);
                        ((ai) (obj)).d(((Rect) (obj1)).bottom);
                        Object obj3 = new FaceAlignData();
                        y.f(e).a((Rect)((ArrayList) (obj2)).get(0), ((FaceAlignData) (obj3)));
                        obj1 = new com.cyberlink.youcammakeup.jniproxy.y();
                        FaceAlignDataUtils.convertFaceAlignData(((FaceAlignData) (obj3)).point_list, ((com.cyberlink.youcammakeup.jniproxy.y) (obj1)));
                        obj3 = new MutableInteger();
                        y.f(e).a((Rect)((ArrayList) (obj2)).get(0), ((MutableInteger) (obj3)));
                        obj2 = new com.cyberlink.youcammakeup.jniproxy.ax();
                        ((com.cyberlink.youcammakeup.jniproxy.ax) (obj2)).a(((MutableInteger) (obj3)).value);
                        obj3 = new bn();
                        y.f(e).a(((ai) (obj)), ((bn) (obj3)));
                        flag3 = y.f(e).a(((ai) (obj)));
                        ar ar1 = new ar(0);
                        ar1.b = ((ai) (obj));
                        ar1.c = ((com.cyberlink.youcammakeup.jniproxy.y) (obj1));
                        ar1.d = ((com.cyberlink.youcammakeup.jniproxy.ax) (obj2));
                        ar1.e = ((bn) (obj3));
                        ar1.f = flag3;
                        ar1.g = new com.cyberlink.youcammakeup.kernelctrl.at();
                        avoid.add(ar1);
                        obj = Bitmap.createBitmap(c[0].a, c[0].b, android.graphics.Bitmap.Config.ARGB_8888);
                        ((Bitmap) (obj)).setPixels(c[0].c, 0, c[0].a, 0, 0, c[0].a, c[0].b);
                        aa.a(y.a);
                        y.a = Bitmap.createBitmap(c[1].a, c[1].b, android.graphics.Bitmap.Config.ARGB_8888);
                        y.a.setPixels(c[1].c, 0, c[1].a, 0, 0, c[1].a, c[1].b);
                        obj1 = new ImageBufferWrapper();
                        ((ImageBufferWrapper) (obj1)).a(((Bitmap) (obj)));
                        ((Bitmap) (obj)).recycle();
                        y.h(e);
                        if (d != null)
                        {
                            com.pf.common.utility.m.b("CaptureImage", "onImageSaved");
                            d.a(((ImageBufferWrapper) (obj1)), avoid);
                            com.pf.common.utility.m.b("CaptureImage", "onImageSaved End");
                        }
                        ((ImageBufferWrapper) (obj1)).m();
                        return Boolean.TRUE;
                    } else
                    {
                        return Boolean.FALSE;
                    }
                } else
                {
                    return Boolean.FALSE;
                }
            }

            protected void a(Boolean boolean1)
            {
                if (!boolean1.booleanValue())
                {
                    com.pf.common.utility.m.b("CaptureImage", "No face.");
                    if (d != null)
                    {
                        d.c();
                    }
                }
            }

            protected Object doInBackground(Object aobj[])
            {
                return a((Void[])aobj);
            }

            protected void onPostExecute(Object obj)
            {
                a((Boolean)obj);
            }

            
            {
                e = y.this;
                a = flag;
                b = flag1;
                c = ao;
                d = z1;
                super();
            }
        }).execute(new Void[0]);
        return;
        z1;
        ao;
        JVM INSTR monitorexit ;
        throw z1;
    }

    public void a(d d1)
    {
        k = i.getGPUImage();
        k.a(com.cyberlink.clgpuimage.GPUImage.ScaleType.e);
        k.a(l);
        i.setKeepScreenOn(true);
        m = d1.a();
        j = BeautifierManager.a();
        boolean flag = j.j();
        while (!flag) 
        {
            try
            {
                Thread.sleep(10L);
            }
            // Misplaced declaration of an exception variable
            catch (d d1)
            {
                d1.printStackTrace();
            }
            flag = j.j();
        }
        F = false;
        n = new com.cyberlink.clgpuimage.CLMakeupLiveEyeFilter.LiveEyeMakeupMetadata[2];
        n[0] = new com.cyberlink.clgpuimage.CLMakeupLiveEyeFilter.LiveEyeMakeupMetadata();
        n[1] = new com.cyberlink.clgpuimage.CLMakeupLiveEyeFilter.LiveEyeMakeupMetadata();
        o = new com.cyberlink.clgpuimage.CLMakeupLiveLipStickFilter.LipstickData();
        p = new com.cyberlink.clgpuimage.CLMakeupLiveBlushFilter.LiveBlushMakeupdata();
        q = new com.cyberlink.clgpuimage.CLMakeupLiveSmoothFilter.LiveSmoothMetadata();
        r = new com.cyberlink.clgpuimage.CLMakeupLiveFilter.LiveFrameInformation();
        u = new Rect();
        B = new Object();
        w = new com.cyberlink.youcammakeup.camera.aa(this);
        x = (SensorManager)h.getSystemService("sensor");
        y = x.getDefaultSensor(9);
        if (y == null)
        {
            y = x.getDefaultSensor(1);
        }
        z = (new float[] {
            0.0F, 0.0F, 0.0F
        });
        A = new Object();
        (new ad(this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public void a(boolean flag)
    {
        a(flag, false);
    }

    public void a(byte abyte0[], int i1, int j1)
    {
        boolean flag;
        flag = false;
        if (!a())
        {
            synchronized (l)
            {
                k.a(abyte0, i1, j1);
            }
            return;
        }
        break MISSING_BLOCK_LABEL_39;
        abyte0;
        obj;
        JVM INSTR monitorexit ;
        throw abyte0;
        if (d == com.cyberlink.clgpuimage.CLMakeupLiveFilter.CaptureFrameType.a) goto _L2; else goto _L1
_L1:
        if (I == 0) goto _L4; else goto _L3
_L3:
        I = I - 1;
_L2:
        int k1;
        boolean flag1;
        boolean flag2;
        if (com.cyberlink.youcammakeup.camera.o.a(g) != 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        synchronized (A)
        {
            k1 = a(z);
        }
        if (j != null)
        {
            synchronized (j)
            {
                j.a(abyte0, i1, j1, k1, flag1);
                flag2 = j.a(u);
                flag1 = j.a(n, o, p, q, r);
            }
        } else
        {
            flag1 = false;
            flag2 = false;
        }
        if (!flag1 || J.get()) goto _L6; else goto _L5
_L5:
        synchronized (l)
        {
            k.a(abyte0, i1, j1);
            if (m != null)
            {
                m.a(n, o, p, q, r);
                m.a(true);
                m.a(d);
            }
        }
        obj1 = B;
        obj1;
        JVM INSTR monitorenter ;
        abyte0 = f;
        if (abyte0 == null || !flag2) goto _L8; else goto _L7
_L7:
        a(u);
        if (!L) goto _L8; else goto _L9
_L9:
        if (!LiveDemoConfigHelper.h().d()) goto _L11; else goto _L10
_L10:
        if (LiveDemoConfigHelper.h().k())
        {
            i1 = 0;
        } else
        {
            i1 = 1;
        }
        if (!LiveDemoConfigHelper.h().l())
        {
            i1 = 0;
        }
_L16:
        if (i1 == 0) goto _L8; else goto _L12
_L12:
        if (K) goto _L8; else goto _L13
_L13:
        flag1 = CameraActivity.a(false, true);
        if (!flag1) goto _L8; else goto _L14
_L14:
        f.autoFocus(new android.hardware.Camera.AutoFocusCallback() {

            final y a;

            public void onAutoFocus(boolean flag3, Camera camera)
            {
                com.pf.common.utility.m.b("LiveMakeupCtrl", (new StringBuilder()).append("ProcessingFrame(), onAutoFocus result=").append(String.valueOf(flag3)).toString());
                CameraActivity.b(false);
                y.a(a, true);
            }

            
            {
                a = y.this;
                super();
            }
        });
_L8:
        obj1;
        JVM INSTR monitorexit ;
        return;
        abyte0;
        obj1;
        JVM INSTR monitorexit ;
        throw abyte0;
        abyte0;
        obj1;
        JVM INSTR monitorexit ;
        throw abyte0;
        abyte0;
        obj1;
        JVM INSTR monitorexit ;
        throw abyte0;
        abyte0;
        obj1;
        JVM INSTR monitorexit ;
        throw abyte0;
        abyte0;
        i1 = ((flag) ? 1 : 0);
_L15:
        if (i1 == 0)
        {
            break MISSING_BLOCK_LABEL_422;
        }
        CameraActivity.b(false);
        abyte0.printStackTrace();
          goto _L8
_L6:
        K = false;
        synchronized (l)
        {
            k.a(abyte0, i1, j1);
            if (m != null)
            {
                m.a(false);
                m.a(d);
            }
        }
        return;
        abyte0;
        obj2;
        JVM INSTR monitorexit ;
        throw abyte0;
        abyte0;
        i1 = 1;
          goto _L15
_L11:
        i1 = 1;
        if (true) goto _L16; else goto _L4
_L4:
    }

    public boolean a()
    {
        return F;
    }

    public byte[] a(Bitmap bitmap)
    {
        int i1 = 0;
        int j1 = bitmap.getWidth();
        int k1 = bitmap.getHeight();
        int ai[] = new int[j1 * k1];
        byte abyte0[] = new byte[j1 * k1];
        bitmap.getPixels(ai, 0, j1, 0, 0, j1, k1);
        for (; i1 < j1 * k1; i1++)
        {
            abyte0[i1] = (byte)(ai[i1] >>> 24);
        }

        return abyte0;
    }

    public void b()
    {
        x.registerListener(this, y, 2);
    }

    public void b(boolean flag)
    {
        t = flag;
        a(s);
    }

    public void c()
    {
        try
        {
            x.unregisterListener(this);
            return;
        }
        catch (Exception exception)
        {
            com.pf.common.utility.m.b("LiveMakeupCtrl", "onPause", exception);
        }
    }

    public void d()
    {
        w.quit();
        synchronized (j)
        {
            j.k();
        }
        j = null;
        m = null;
        return;
        exception;
        beautifiermanager;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void e()
    {
        if (D != null)
        {
            int i1 = D.width;
            int k1 = D.height * i1;
            if (k1 > 0)
            {
                byte abyte0[] = new byte[(int)((double)k1 * 1.5D)];
                int j1 = 0;
                while (j1 < abyte0.length) 
                {
                    if (j1 < k1)
                    {
                        abyte0[j1] = 0;
                    } else
                    {
                        abyte0[j1] = -128;
                    }
                    j1++;
                }
                J.set(true);
                w.a(abyte0, D.width, D.height);
            }
        }
    }

    public void f()
    {
        synchronized (B)
        {
            if (f != null)
            {
                v = null;
                f.setPreviewTexture(null);
                f.setPreviewCallback(null);
                f = null;
                g = 0;
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void g()
    {
        android.hardware.Camera.Parameters parameters;
        Object obj;
        int i1 = i.getWidth();
        int j1 = i.getHeight();
        parameters = f.getParameters();
        E = parameters.getSupportedPreviewSizes();
        D = (android.hardware.Camera.Size)E.get(0);
        if (i1 < j1)
        {
            D = a(E, j1, i1);
        } else
        {
            D = a(E, i1, j1);
        }
        parameters.setPreviewSize(D.width, D.height);
        parameters.setPreviewFormat(17);
        obj = parameters.getSupportedPictureSizes().iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            android.hardware.Camera.Size size = (android.hardware.Camera.Size)((Iterator) (obj)).next();
            if (size.width == D.width && size.height == D.height)
            {
                parameters.setPictureSize(D.width, D.height);
            }
        } while (true);
        obj = parameters.getSupportedFocusModes();
        if (!((List) (obj)).contains("continuous-picture")) goto _L2; else goto _L1
_L1:
        parameters.setFocusMode("continuous-picture");
_L4:
        f.setParameters(parameters);
        return;
_L2:
        if (((List) (obj)).contains("auto"))
        {
            parameters.setFocusMode("auto");
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void h()
    {
        Object obj;
        android.hardware.Camera.CameraInfo camerainfo;
        int i1;
        try
        {
            camerainfo = com.cyberlink.youcammakeup.camera.o.b(g);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            com.pf.common.utility.m.b("LiveMakeupCtrl", "onApplyOnPreview", ((Throwable) (obj)));
            return;
        }
        h.getWindowManager().getDefaultDisplay().getRotation();
        JVM INSTR tableswitch 0 3: default 52
    //                   0 190
    //                   1 195
    //                   2 201
    //                   3 208;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        i1 = 0;
_L10:
        if (camerainfo.facing == 1)
        {
            i1 = (360 - (i1 + camerainfo.orientation) % 360) % 360;
        } else
        {
            i1 = ((camerainfo.orientation - i1) + 360) % 360;
        }
        C = i1;
        obj = Rotation.a;
        i1;
        JVM INSTR lookupswitch 3: default 124
    //                   90: 233
    //                   180: 240
    //                   270: 247;
           goto _L6 _L7 _L8 _L9
_L6:
        break; /* Loop/switch isn't completed */
_L9:
        break MISSING_BLOCK_LABEL_247;
_L11:
        if (camerainfo.facing == 0)
        {
            if (h.getResources().getConfiguration().orientation == 2)
            {
                k.a(((Rotation) (obj)), false, false);
            } else
            {
                k.a(((Rotation) (obj)), true, true);
            }
        } else
        if (h.getResources().getConfiguration().orientation == 2)
        {
            k.a(((Rotation) (obj)), false, true);
        } else
        {
            k.a(((Rotation) (obj)), true, false);
        }
        if (m != null)
        {
            m.c(C);
        }
        return;
_L2:
        i1 = 0;
          goto _L10
_L3:
        i1 = 90;
          goto _L10
_L4:
        i1 = 180;
          goto _L10
_L5:
        i1 = 270;
          goto _L10
_L7:
        obj = Rotation.b;
          goto _L11
_L8:
        obj = Rotation.c;
          goto _L11
        obj = Rotation.d;
          goto _L11
    }

    public CLMakeupLiveFilter i()
    {
        return m;
    }

    public BeautifierManager j()
    {
        return j;
    }

    public android.hardware.Camera.Size k()
    {
        return D;
    }

    public boolean l()
    {
        return G.get();
    }

    public void onAccuracyChanged(Sensor sensor, int i1)
    {
    }

    public void onSensorChanged(SensorEvent sensorevent)
    {
        Object obj = A;
        obj;
        JVM INSTR monitorenter ;
        h.getWindowManager().getDefaultDisplay().getRotation();
        JVM INSTR tableswitch 0 3: default 220
    //                   0 55
    //                   1 99
    //                   2 139
    //                   3 180;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        break; /* Loop/switch isn't completed */
_L5:
        break MISSING_BLOCK_LABEL_180;
_L6:
        return;
_L2:
        z[0] = sensorevent.values[0];
        z[1] = sensorevent.values[1];
        z[2] = sensorevent.values[2];
          goto _L6
        sensorevent;
        obj;
        JVM INSTR monitorexit ;
        throw sensorevent;
_L3:
        z[0] = -sensorevent.values[1];
        z[1] = sensorevent.values[0];
        z[2] = sensorevent.values[2];
          goto _L6
_L4:
        z[0] = -sensorevent.values[0];
        z[1] = -sensorevent.values[1];
        z[2] = sensorevent.values[2];
          goto _L6
        z[0] = sensorevent.values[1];
        z[1] = -sensorevent.values[0];
        z[2] = sensorevent.values[2];
          goto _L6
    }

}
