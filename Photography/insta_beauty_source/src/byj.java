// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.hardware.Camera;
import java.nio.IntBuffer;
import jp.co.cyberagent.android.gpuimage.GPUImageNativeLibrary;
import jp.co.cyberagent.android.gpuimage.OpenGlUtils;

class byj
    implements Runnable
{

    final byte a[];
    final android.hardware.Camera.Size b;
    final Camera c;
    final byi d;

    byj(byi byi1, byte abyte0[], android.hardware.Camera.Size size, Camera camera)
    {
        d = byi1;
        a = abyte0;
        b = size;
        c = camera;
        super();
    }

    public void run()
    {
        System.currentTimeMillis();
        if (OpenGlUtils.a() == jp.co.cyberagent.android.gpuimage.OpenGlUtils.GPURenderType.GPUImageRender_RGB)
        {
            GPUImageNativeLibrary.YUVtoRBGA(a, b.width, b.height, byi.a(d).array());
        } else
        {
            GPUImageNativeLibrary.YUVtoARBG(a, b.width, b.height, byi.a(d).array());
        }
        byi.a(d, OpenGlUtils.a(byi.a(d), b, byi.b(d)));
        c.addCallbackBuffer(a);
        if (byi.c(d) != b.width)
        {
            byi.d(d).a(b.width, b.height);
            byi.b(d, b.width);
            byi.c(d, b.height);
            byi.e(d);
        }
    }
}
