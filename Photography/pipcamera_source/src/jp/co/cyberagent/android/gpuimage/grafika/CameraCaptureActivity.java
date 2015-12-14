// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jp.co.cyberagent.android.gpuimage.grafika;

import aew;
import agx;
import agy;
import agz;
import aha;
import ahh;
import android.app.Activity;
import android.opengl.EGL14;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import jp.co.cyberagent.android.gpuimage.camera.BeautyCameraGLSurfaceView;

public abstract class CameraCaptureActivity extends Activity
{

    private static final File n = Environment.getExternalStorageDirectory();
    public int a;
    public int b;
    public BeautyCameraGLSurfaceView c;
    protected aew d;
    protected boolean e;
    protected boolean f;
    protected boolean g;
    protected boolean h;
    protected boolean i;
    protected boolean j;
    protected boolean k;
    protected boolean l;
    private final String m = "PreviewRatio";
    private agz o;
    private final agy p = new agy() {

        final CameraCaptureActivity a;

        public void a(agx agx)
        {
            Log.i("CameraCaptureActivity", (new StringBuilder()).append("onStopped:encoder=").append(agx).toString());
            if (agx instanceof aha)
            {
                a.a(null);
            }
        }

            
            {
                a = CameraCaptureActivity.this;
                super();
            }
    };

    public CameraCaptureActivity()
    {
        a = 0;
        b = 0;
        o = null;
        e = true;
        f = false;
        g = false;
        h = false;
        i = false;
        j = false;
        k = false;
        l = false;
    }

    public static void a(CameraCaptureActivity cameracaptureactivity)
    {
        cameracaptureactivity.d();
    }

    public static void b(CameraCaptureActivity cameracaptureactivity)
    {
        cameracaptureactivity.c();
    }

    private void c()
    {
        a();
        if (o != null)
        {
            o.a();
            o = null;
        }
    }

    private void d()
    {
        c.setSurfaceContainerSize(a, b);
    }

    protected abstract void a();

    public void a(aha aha)
    {
        ahh ahh1 = (ahh)c.getRender();
        c.queueEvent(new Runnable(ahh1, aha) {

            final ahh a;
            final aha b;
            final CameraCaptureActivity c;

            public void run()
            {
                synchronized (a)
                {
                    if (b != null)
                    {
                        b.a(EGL14.eglGetCurrentContext(), a.b());
                    }
                    a.G = b;
                }
                return;
                exception;
                ahh2;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                c = CameraCaptureActivity.this;
                a = ahh1;
                b = aha1;
                super();
            }
        });
    }

    public abstract void a(boolean flag);

    protected boolean b()
    {
label0:
        {
            boolean flag = false;
            try
            {
                if (o == null)
                {
                    break label0;
                }
                o.a();
                o = null;
            }
            catch (Exception exception)
            {
                return false;
            }
            flag = true;
        }
        return flag;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    protected void onDestroy()
    {
        Log.i("CameraCaptureActivity", "onDestroy");
        d.a();
        super.onDestroy();
    }

    protected void onPause()
    {
        Log.i("CameraCaptureActivity", "onPause -- releasing camera");
        c.pauseAll();
        b();
        super.onPause();
        Log.e("CameraCaptureActivity", "onPause complete");
    }

    protected void onResume()
    {
        super.onResume();
        c.resumeAll();
    }

}
