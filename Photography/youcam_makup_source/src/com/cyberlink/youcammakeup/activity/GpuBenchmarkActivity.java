// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.hardware.Camera;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.camera.o;
import com.cyberlink.youcammakeup.camera.u;
import com.cyberlink.youcammakeup.camera.v;
import com.cyberlink.youcammakeup.camera.w;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.pf.common.utility.m;
import java.io.File;
import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            l, LauncherActivity, OpeningTutorialActivity

public class GpuBenchmarkActivity extends Activity
{

    private static final String e;
    private Thread a;
    private GLSurfaceView b;
    private AtomicBoolean c;
    private u d;
    private w f;

    public GpuBenchmarkActivity()
    {
        c = new AtomicBoolean(false);
        d = null;
        f = new w() {

            final GpuBenchmarkActivity a;

            private List a(int i)
            {
                Object obj;
                Object obj1;
                obj1 = null;
                obj = obj1;
                if (!o.e(i))
                {
                    break MISSING_BLOCK_LABEL_46;
                }
                Camera camera = Camera.open(o.d(i));
                obj = camera;
                List list = camera.getParameters().getSupportedPreviewSizes();
                obj = list;
                if (camera != null)
                {
                    camera.release();
                    obj = list;
                }
_L2:
                return ((List) (obj));
                Exception exception1;
                exception1;
                camera = null;
_L5:
                obj = camera;
                m.b("GpuBenchmarkActivity", (new StringBuilder()).append("Cannot open camera. Facing: ").append(i).toString(), exception1);
                obj = obj1;
                if (camera == null) goto _L2; else goto _L1
_L1:
                camera.release();
                return null;
                Exception exception;
                exception;
                obj = null;
_L4:
                if (obj != null)
                {
                    ((Camera) (obj)).release();
                }
                throw exception;
                exception;
                if (true) goto _L4; else goto _L3
_L3:
                exception1;
                  goto _L5
            }

            static List a(_cls1 _pcls1, int i)
            {
                return _pcls1.a(i);
            }

            public void a(float f1)
            {
                if (GpuBenchmarkActivity.b(a).get() || !GpuBenchmarkActivity.a(a).a())
                {
                    a.finish();
                    return;
                } else
                {
                    a.runOnUiThread(new Runnable(this, f1) {

                        final float a;
                        final _cls1 b;

                        public void run()
                        {
                            Object obj3 = null;
                            Object obj2 = null;
                            z.a("GPU_BENCHMARK_FPS", a, Globals.d());
                            z.a("HAD_RUN_GPU_BENCHMARK", Boolean.valueOf(true), Globals.d());
                            Object obj4 = new StringBuilder();
                            Object obj = b.a.getResources().getDisplayMetrics();
                            int i = ((DisplayMetrics) (obj)).widthPixels;
                            int j = ((DisplayMetrics) (obj)).heightPixels;
                            obj = _cls1.a(b, 1);
                            Object obj1;
                            Exception exception;
                            if (obj != null)
                            {
                                obj = u.a(((List) (obj)), i, j, a);
                            } else
                            {
                                obj = null;
                            }
                            obj1 = _cls1.a(b, 0);
                            if (obj1 != null)
                            {
                                obj1 = u.a(((List) (obj1)), i, j, a);
                            } else
                            {
                                obj1 = null;
                            }
                            ((StringBuilder) (obj4)).append(String.format(Locale.US, "benchmark fps: %.3f\n", new Object[] {
                                Float.valueOf(a)
                            }));
                            if (obj != null)
                            {
                                ((StringBuilder) (obj4)).append("\n==== Front ====\n");
                                ((StringBuilder) (obj4)).append(String.format(Locale.US, "preview size: %d, %d\n", new Object[] {
                                    Integer.valueOf(((v) (obj)).a.width), Integer.valueOf(((v) (obj)).a.height)
                                }));
                                ((StringBuilder) (obj4)).append(String.format(Locale.US, "estimate fps: %.3f\n", new Object[] {
                                    Float.valueOf(((v) (obj)).b)
                                }));
                                z.a("GPU_BENCHMARK_ESTIMATE_FPS_FRONT", ((v) (obj)).b, Globals.d());
                            }
                            if (obj1 != null)
                            {
                                ((StringBuilder) (obj4)).append("\n==== Back ====\n");
                                ((StringBuilder) (obj4)).append(String.format(Locale.US, "preview size: %d, %d\n", new Object[] {
                                    Integer.valueOf(((v) (obj1)).a.width), Integer.valueOf(((v) (obj1)).a.height)
                                }));
                                ((StringBuilder) (obj4)).append(String.format(Locale.US, "estimate fps: %.3f\n", new Object[] {
                                    Float.valueOf(((v) (obj1)).b)
                                }));
                                z.a("GPU_BENCHMARK_ESTIMATE_FPS_BACK", ((v) (obj1)).b, Globals.d());
                            }
                            obj4 = ((StringBuilder) (obj4)).toString();
                            m.e("GPU_BENCHMARK", ((String) (obj4)));
                            if (!NetworkManager.e())
                            {
                                break MISSING_BLOCK_LABEL_396;
                            }
                            obj = obj3;
                            obj1 = new PrintWriter(new File(GpuBenchmarkActivity.b()));
                            ((PrintWriter) (obj1)).write(((String) (obj4)));
                            ((PrintWriter) (obj1)).flush();
                            if (obj1 != null)
                            {
                                ((PrintWriter) (obj1)).close();
                            }
_L1:
                            if (z.a("HAD_SHOWN_OPENING_TUTORIAL_V4.13.0", false, b.a.getApplicationContext()))
                            {
                                obj = new Intent(b.a.getApplicationContext(), com/cyberlink/youcammakeup/activity/LauncherActivity);
                            } else
                            {
                                obj = new Intent(b.a.getApplicationContext(), com/cyberlink/youcammakeup/activity/OpeningTutorialActivity);
                            }
                            b.a.startActivity(((Intent) (obj)));
                            b.a.finish();
                            return;
                            obj;
                            obj1 = obj2;
                            obj2 = obj;
_L4:
                            obj = obj1;
                            ((Exception) (obj2)).printStackTrace();
                            if (obj1 != null)
                            {
                                ((PrintWriter) (obj1)).close();
                            }
                              goto _L1
                            exception;
                            obj1 = obj;
                            obj = exception;
_L3:
                            if (obj1 != null)
                            {
                                ((PrintWriter) (obj1)).close();
                            }
                            throw obj;
                            obj;
                            if (true) goto _L3; else goto _L2
_L2:
                            exception;
                              goto _L4
                        }

            
            {
                b = _pcls1;
                a = f1;
                super();
            }
                    });
                    return;
                }
            }

            
            {
                a = GpuBenchmarkActivity.this;
                super();
            }
        };
    }

    static u a(GpuBenchmarkActivity gpubenchmarkactivity)
    {
        return gpubenchmarkactivity.d;
    }

    static String b()
    {
        return e;
    }

    static AtomicBoolean b(GpuBenchmarkActivity gpubenchmarkactivity)
    {
        return gpubenchmarkactivity.c;
    }

    public void a()
    {
        a = new l(this);
        a.start();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030010);
        if (Globals.d().c() == com.cyberlink.youcammakeup.Globals.STORE_NAME.c)
        {
            findViewById(0x7f0c012c).setVisibility(0);
        }
        bundle = (FrameLayout)findViewById(0x7f0c0129);
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int i = displaymetrics.widthPixels;
        int j = displaymetrics.heightPixels;
        b = new GLSurfaceView(this);
        bundle.addView(b, new android.view.ViewGroup.LayoutParams(i, j));
        d = new u(b, f);
    }

    protected void onPause()
    {
        c.set(true);
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        a();
    }

    static 
    {
        e = (new StringBuilder()).append(NetworkManager.b).append("GPU_benchmark.txt").toString();
    }
}
