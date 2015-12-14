// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.hardware.Camera;
import android.util.DisplayMetrics;
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
//            GpuBenchmarkActivity, LauncherActivity, OpeningTutorialActivity

class a
    implements Runnable
{

    final float a;
    final sh b;

    public void run()
    {
        Object obj3 = null;
        Object obj2 = null;
        z.a("GPU_BENCHMARK_FPS", a, Globals.d());
        z.a("HAD_RUN_GPU_BENCHMARK", Boolean.valueOf(true), Globals.d());
        Object obj4 = new StringBuilder();
        Object obj = b.b.getResources().getDisplayMetrics();
        int i = ((DisplayMetrics) (obj)).widthPixels;
        int j = ((DisplayMetrics) (obj)).heightPixels;
        obj = esources(b, 1);
        Object obj1;
        Exception exception;
        if (obj != null)
        {
            obj = u.a(((List) (obj)), i, j, a);
        } else
        {
            obj = null;
        }
        obj1 = a(b, 0);
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
                Integer.valueOf(((v) (obj)).a.a), Integer.valueOf(((v) (obj)).a.a)
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
                Integer.valueOf(((v) (obj1)).a.a), Integer.valueOf(((v) (obj1)).a.a)
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
        if (z.a("HAD_SHOWN_OPENING_TUTORIAL_V4.13.0", false, b.b.getApplicationContext()))
        {
            obj = new Intent(b.b.getApplicationContext(), com/cyberlink/youcammakeup/activity/LauncherActivity);
        } else
        {
            obj = new Intent(b.b.getApplicationContext(), com/cyberlink/youcammakeup/activity/OpeningTutorialActivity);
        }
        b.b.startActivity(((Intent) (obj)));
        b.b.finish();
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

    anager(anager anager, float f)
    {
        b = anager;
        a = f;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/activity/GpuBenchmarkActivity$1

/* anonymous class */
    class GpuBenchmarkActivity._cls1
        implements w
    {

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

        static List a(GpuBenchmarkActivity._cls1 _pcls1, int i)
        {
            return _pcls1.a(i);
        }

        public void a(float f)
        {
            if (GpuBenchmarkActivity.b(a).get() || !GpuBenchmarkActivity.a(a).a())
            {
                a.finish();
                return;
            } else
            {
                a.runOnUiThread(new GpuBenchmarkActivity._cls1._cls1(this, f));
                return;
            }
        }

            
            {
                a = gpubenchmarkactivity;
                super();
            }
    }

}
