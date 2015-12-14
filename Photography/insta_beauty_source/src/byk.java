// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.opengl.GLES20;
import java.io.IOException;

class byk
    implements Runnable
{

    final Camera a;
    final byi b;

    byk(byi byi1, Camera camera)
    {
        b = byi1;
        a = camera;
        super();
    }

    public void run()
    {
        int ai[] = new int[1];
        GLES20.glGenTextures(1, ai, 0);
        GLES20.glBindTexture(36197, ai[0]);
        GLES20.glTexParameterf(36197, 10241, 9729F);
        GLES20.glTexParameterf(36197, 10240, 9729F);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        byi.a(b, new SurfaceTexture(ai[0]));
        try
        {
            a.setPreviewTexture(byi.f(b));
            a.setPreviewCallback(b);
            a.startPreview();
            return;
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
        }
    }
}
