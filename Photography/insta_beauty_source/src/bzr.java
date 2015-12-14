// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.EGL14;
import jp.co.cyberagent.android.gpuimage.grafika.CameraCaptureActivity;

public class bzr
    implements Runnable
{

    final cee a;
    final cdx b;
    final CameraCaptureActivity c;

    public bzr(CameraCaptureActivity cameracaptureactivity, cee cee1, cdx cdx1)
    {
        c = cameracaptureactivity;
        a = cee1;
        b = cdx1;
        super();
    }

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
        cee1;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
