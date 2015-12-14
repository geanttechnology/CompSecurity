// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jp.co.cyberagent.android.gpuimage.grafika;

import aha;
import ahh;
import android.opengl.EGL14;

// Referenced classes of package jp.co.cyberagent.android.gpuimage.grafika:
//            CameraCaptureActivity

class b
    implements Runnable
{

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
        ahh1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    (CameraCaptureActivity cameracaptureactivity, ahh ahh1, aha aha1)
    {
        c = cameracaptureactivity;
        a = ahh1;
        b = aha1;
        super();
    }
}
